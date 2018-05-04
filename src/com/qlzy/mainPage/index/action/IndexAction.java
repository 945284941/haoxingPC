package com.qlzy.mainPage.index.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qlzy.common.util.PcOrWap;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.common.service.ExhibitionApplyService;
import com.qlzy.mainPage.company.service.CompanyService;
import com.qlzy.mainPage.floor.service.IndexFloorService;
import com.qlzy.mainPage.indexGoods.service.IndexGoodsService;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.model.Company;
import com.qlzy.model.ExhibitionApply;
import com.qlzy.model.Goods;
import com.qlzy.model.Qixiuchang;
import com.qlzy.model.Regions;
import com.qlzy.util.BaseAction;
import com.qlzy.util.HttpRequestDeviceUtils;

/**
 * @ClassName: IndexAction
 * @Description: 
 * @author Huifeng Wang
 * @date 2013-8-16 下午4:05:37
 */
@Action(value = "index", results = {
		@Result(name = "index", location = "/index.jsp"),//电商首页
		@Result(name = "indexWap", location = "/wap/index.jsp"),//电商首页
		})
public class IndexAction extends BaseAction{
	/**
	* @ClassName: com.qlzy.mainPage.index.actionIndexAction.java
	* @Description: TODO(这里用一句话描述这个类的作用)
	* @author 周张豹
	* @date 2013-8-17 上午10:16:12
	*/

	private static final long serialVersionUID = 1L;
	@Resource
	private CompanyService companyService;
	@Resource
	private IndexGoodsService indexGoodsService;
	@Resource
	private IndexFloorService indexFloorService;
	@Resource
	private RegionsService regionsService;// 区域接口类
	@Resource
	private ExhibitionApplyService exhibitionApplyService;
	
	private Company company;
	private Qixiuchang qixiuchang;
	private ExhibitionApply exhibitionApply;
	private String benString;
	private String key;
	private List<Goods> goodsList;
	private List<Qixiuchang> qixiuchangList;// 汽修厂列表
	private List<Regions> provinceList;// 省份列表
	private List<Regions> cityList;// 市列表
	private List<Regions> areaList;// 区列表
	
	/**
	 * 获取访问的域名<br>
	 * 如果是一级域名跳转到商城首页<br>
	 * 如果是二级域名，先要分析二级域名是否官方二级域名，如果是官方二级域名则跳转指定页面<br>
	 * 如果不是官方二级域名，再查看是否卖家二级域名，如果是卖家二级域名跳转到卖家店铺页面<br>
	 * 如果不是官方二级域名，也不是卖家二级域名，则跳转到商城首页
	* @Title: in
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public String in(){
		return PcOrWap.isPc(request,"index");
	}
	/**
	 * 插入祝福语
	* @Title: toBenison
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @throws IOException    设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public void toBenison() throws IOException{
		if (benString != null && !"".equals(benString)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ID", ToolsUtil.getUUID());
			map.put("CONTENT", benString);
			map.put("CREATETIME", new Date());
			indexGoodsService.insertBenison(map);
		}
		response.sendRedirect("http://qpzx.qlqpw.com");
		
	}
	/**
	 * 查询祝福语
	* @Title: gainBenison
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public void gainBenison(){
		try {
			List<Goods> list = indexGoodsService.gainBenisons();
			super.writeJson(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String gainBenisonList(){
		try {
			goodsList = indexGoodsService.gainBenisons();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "benisonList";
	}
	
	public static void main(String[] args) {
		Map<String, Object> doaminMap = ToolsUtil.splitDomain("image.qlqpw.com");
		Integer domainGroup = (Integer)doaminMap.get("group");
		System.out.println("访问的域名等级为："+domainGroup);
		for (int i = 1; i <= domainGroup; i++) {
			System.out.println(i+">>>"+doaminMap.get(i+""));
		}
//		
	}

	
	
	/**
	 * @Title: toOnlineApply
	 * @Description: TODO(跳转我要报名页面) 
	 * @param @return    设定文件 
	 * @return String 返回类型 
	 * @author wangmei
	 */
	public String toOnlineApply(){
		// 获取省份列表
		provinceList = regionsService.gainProvinceList();
		return "toOnlineApply";
	}

	
//	/**
//	 * 获取字典的内容
//	 */
//	public void gainDictionaryValue(){
//		String dVulue = indexGoodsService.gianDictionaryValue(key);
//		writeJson(dVulue);
//	}
	
	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}




	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the benString
	 */
	public String getBenString() {
		return benString;
	}

	/**
	 * @param benString the benString to set
	 */
	public void setBenString(String benString) {
		this.benString = benString;
	}
	/**
	 * @return the goodsList
	 */
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	/**
	 * @param goodsList the goodsList to set
	 */
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public List<Qixiuchang> getQixiuchangList() {
		return qixiuchangList;
	}
	public void setQixiuchangList(List<Qixiuchang> qixiuchangList) {
		this.qixiuchangList = qixiuchangList;
	}
	public List<Regions> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<Regions> provinceList) {
		this.provinceList = provinceList;
	}
	public Qixiuchang getQixiuchang() {
		return qixiuchang;
	}
	public void setQixiuchang(Qixiuchang qixiuchang) {
		this.qixiuchang = qixiuchang;
	}
	public List<Regions> getCityList() {
		return cityList;
	}
	public void setCityList(List<Regions> cityList) {
		this.cityList = cityList;
	}
	public List<Regions> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<Regions> areaList) {
		this.areaList = areaList;
	}
	public ExhibitionApply getExhibitionApply() {
		return exhibitionApply;
	}
	public void setExhibitionApply(ExhibitionApply exhibitionApply) {
		this.exhibitionApply = exhibitionApply;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
}
