package com.qlzy.mainPage.common.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import com.qlzy.common.util.AddressUtils;
import com.qlzy.common.util.PcOrWap;
import com.qlzy.mainPage.country.service.NCountryService;
import com.qlzy.mainPage.indexGoods.service.DictionaryService;
import com.qlzy.model.NCountry;
import com.qlzy.model.QlDict;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.mainPage.common.service.CommonService;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.model.Regions;
import com.qlzy.pojo.Json;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;

/**
 * @ClassName: CommonAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huifeng Wang
 * @date 2013-5-15 上午11:27:36
 *
 */
@Action(value = "common", results = {
		@Result(name = "toHead", location = "/admin/common/head.jsp"),
		@Result(name = "toFriendLink", location = "/admin/common/friendLink.jsp"),
		@Result(name = "toLogo", location = "/admin/common/logo.jsp"),
		@Result(name = "toPersionLogo", location = "/admin/common/persionLogo.jsp")//跳转个人中心头部
})
public class CommonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	private RegionsService regionsService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private NCountryService nCountryService;
	private List<QlDict> indexKeywordsList;
	private List<QlDict> indexCompanyKeywordsList;
	private List<NCountry> changeCountryList;
	private int count = 0;

	
	public String toHead(){
		nCountryService.changeAddressByIp(addressId,request,session);
		//获取所有国家
		changeCountryList = nCountryService.gainNCountry();
		return PcOrWap.isPc(request,"toHead");
	}
	public String toLogo(){
		indexKeywordsList = dictionaryService.selectByType("index_keywords");
		indexCompanyKeywordsList = dictionaryService.selectByType("popushop");

		return PcOrWap.isPc(request,"toLogo");
	}
	public String toPersionLogo(){
		indexKeywordsList = dictionaryService.selectByType("index_keywords");
		return PcOrWap.isPc(request,"toPersionLogo");
	}

	public void changeAddress(){
		String result = "001";
		try {
			nCountryService.changeAddressByIp(addressId,request,session);
			result = "000";
		} catch (Exception e) {
			e.printStackTrace();

		}
		super.writeJson(result);
	}


	public String toFriendLink(){
		return "toFriendLink";
	}
	//动态检查上传文件扩展名
	public void checkImageFileExt(){
		Map<String,Object> map =new HashMap<String,Object>();
		String fileName=request.getParameter("fileName");
		// 检查文件扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
				.toLowerCase();
		if (!Arrays.<String> asList(
				ResourceUtil.get("images_Ext").split(",")).contains(
				fileExt)) {
			map.put("result", false);
			map.put("msg","上传文件扩展名是不允许的扩展名。\n只允许"
					+ ResourceUtil.get("images_Ext") + "格式！");
		}else{
			map.put("result", true);
		}
		super.writeJson(map);
	}
	/**
	 * 获取session对象
	 * @author HuifengWang
	 */
	public void gainSessionInfo(){
		Map<String, Object> map = new HashMap<String, Object>();
		SessionInfo info =(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(info==null){
			map.put(ResourceUtil.getSessionInfoName(), info);
			map.put("result", true);
			super.writeJson(map);
		}else {
			map.put("result", false);
			super.writeJson(true);
		}
	}
	
	/**
	 * @author HuifengWang
	 * 验证验证码是否正确
	 */
	public void checkCode(){
		Boolean flag=false;
		String code=request.getParameter("code");
		if(code!=null &&!"".equalsIgnoreCase(code)){
			String sessionCode=(String) session.get("validateCode");
			if(code.equalsIgnoreCase(sessionCode)){
				flag=true;
			}else{
				flag=false;
			}
		}else{
			flag=false;
		}
		super.writeJson(flag);
	}
	/**
	 * 获取下一级省市区
	 */
	public void gainNextCityOrAreaByPid(){
		String pid =request.getParameter("pid");
		List<Regions> regions = new ArrayList<Regions>();
		if(!"".equals(pid.trim())){
			regions=regionsService.gainNextCityOrAreaListByPid(pid);
		}
		super.writeJson(regions);
	}
	
	public String jspToHtml(){
		try {
			commonService.toHtml(request,response,"baozirangnongde", "index");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Title: checkValidateCode
	 * @Description: TODO(检验验证码是否正确) 
	 * @param
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void checkValidateCode() {
		Json j = new Json();

		// 获取页面输入的验证码
		String verifyCode = request.getParameter("verifyCode");
		if (verifyCode != null && !"".equals(verifyCode)) {// 当页面输入的验证码不为空时

			// 获取页面加载的验证码
			String yzm = (String) session.get("validateCode");
			if (yzm != null && !"".equals(yzm)) {
				if (verifyCode.equalsIgnoreCase(yzm)) {
					j.setMsg("succ");
				} else {
					j.setMsg("fail");
				}
			}
		} else {// 为空时
			j.setMsg("isNull");
		}
		writeJson(j);
	}
	
	/**
	 * @Title: checkSession
	 * @Description: TODO(验证session是否过期)
	 * @param
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void checkSession() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if (null == sessionInfo) {
			writeJson(false);
		} else {
			writeJson(true);
		}
	}

	public List<QlDict> getIndexKeywordsList() {
		return indexKeywordsList;
	}

	public void setIndexKeywordsList(List<QlDict> indexKeywordsList) {
		this.indexKeywordsList = indexKeywordsList;
	}

	public List<NCountry> getChangeCountryList() {
		return changeCountryList;
	}

	public void setChangeCountryList(List<NCountry> changeCountryList) {
		this.changeCountryList = changeCountryList;
	}

	public List<QlDict> getIndexCompanyKeywordsList() {
		return indexCompanyKeywordsList;
	}

	public void setIndexCompanyKeywordsList(List<QlDict> indexCompanyKeywordsList) {
		this.indexCompanyKeywordsList = indexCompanyKeywordsList;
	}
}
