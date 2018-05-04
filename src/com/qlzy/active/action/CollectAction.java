package com.qlzy.active.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.qlzy.active.service.CollectService;
import com.qlzy.common.tools.FtpUtil;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.model.ActiveCollectGoods;
import com.qlzy.model.ActiveCollectGoodsCheck;
import com.qlzy.model.ActiveCollectGoodsPic;
import com.qlzy.model.ActiveCollectGoodsQB;
import com.qlzy.model.CarBrand;
import com.qlzy.model.GoodsCat;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Constant;
import com.qlzy.util.Pagination;

/**
* @ClassName: ActiveAction
* @Description: 
* @author Huifeng Wang
* @date 2013-6-14 下午1:28:08
*/
@Action(value = "collect", results = {
		@Result(name = "toAdd", location = "/active/upload.jsp"),
		@Result(name = "toCheckList", location = "/active/checkList.jsp"),
		@Result(name = "toPublicCheck", location = "/active/publicCheck.jsp"),
		@Result(name = "toReplenishUpload", location = "/active/replenishUpload.jsp"),
		@Result(name = "toDirectionalUpload", location = "/active/directionalUpload.jsp"),
		@Result(name = "activeLogin", location = "/activeIndex.jsp"),
		@Result(name = "resultR",type="redirect", location="/active/goReplenish.html")})
public class CollectAction extends BaseAction implements ModelDriven<ActiveCollectGoods>{
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 2 * 1024;
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private CollectService collectService;
	//入围的商品列表
	private List<ActiveCollectGoods> acgList=new ArrayList<ActiveCollectGoods>();
	//上传商品时用到的实体类
	private ActiveCollectGoods acg=new ActiveCollectGoods();
	private ActiveCollectGoodsQB acgqb;
	private File filedata;
	private String filedataFileName;
	private String filedataContentType;

	private List<CarBrand> brandList;
	private List<CarBrand> seriesList;
	private List<CarBrand> typeList;
	private List<GoodsCat> catList;
	private List<GoodsCat> secondCatList;
	private List<GoodsCat> componentList;
	public FtpUtil ftp ;
	@Override
	public ActiveCollectGoods getModel() {
		return acg;
	}

	
	/**
	* @Title: toCheckList
	* @Description: 跳转数据校对页面
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public String toCheckList(){
		Map<String,Object> map =new HashMap<String,Object>();
		String ncn = request.getParameter("ncn");
		log.info(ncn);
		String cat=null;
		if(ncn.equals("1")){
			cat="发动机";
		}else if(ncn.equals("2")){
			cat="发动机附件";
		}else if(ncn.equals("3")){
			cat="驾驶室";
		}else if(ncn.equals("4")){
			cat="变速器总成";
		}else if(ncn.equals("5")){
			cat="离合器";
		}else if(ncn.equals("6")){
			cat="转向系统";
		}else if(ncn.equals("7")){
			cat="挂车";
		}else if(ncn.equals("8")){
			cat="电气系统";
		}else if(ncn.equals("9")){
			cat="传动系统";
		}else if(ncn.equals("10")){
			cat="悬挂";
		}else if(ncn.equals("11")){
			cat="车架";
		}else if(ncn.equals("12")){
			cat="自卸上装";
		}else if(ncn.equals("13")){
			cat="前中后桥";
		}else if(ncn.equals("14")){
			cat="制动系统";
		}else if(ncn.equals("15")){
			cat="油品";
		}else if(ncn.equals("16")){
			cat="螺母及螺栓";
		}else if(ncn.equals("17")){
			cat="轴承";
		}else{
			cat=null;
		}
		Pagination pagination = definationPagination(request);
		pagination.setRows(Constant.paginationRows);// 设置每页显示几条数据
		map.put("cat", cat);
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		acgList=collectService.gainHasCheckedActiveCollectGoods(map);
		pagination.setTotalCount(collectService.gainHasCheckedActiveCollectGoodsCount(map));
		request.setAttribute("pagination", pagination);
		request.setAttribute("acgList", acgList);
		request.setAttribute("ncn", ncn);
		return "toCheckList";
	}
	
	/**
	* @Title: toPublicCheck 开放类
	* @Description: 跳转校对某个配件的页面
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public String toPublicCheck(){
		acg=collectService.gainActiveCollectGoodsById(request.getParameter("id"));
		brandList=collectService.gainBrandList(1);
		if(acg.getBrand()!=null){
			seriesList=collectService.gainNextCarBrandListByPName(acg.getBrand());
			List<String> type=new ArrayList<String>();
			for (CarBrand e : seriesList) {
				type.add(e.getName());
			}
			String temps=type.toString();
			temps=temps.substring(1,temps.length()-1);
			if(temps.length()>0){
				typeList=collectService.gainNextCarBrandListByPName(temps);
			}
		}else{
			seriesList=new ArrayList<CarBrand>();
			typeList=new ArrayList<CarBrand>();
		}
		catList=collectService.gainCatList(1);
		if(acg.getCat()!=null){
			componentList=collectService.gainNextGoodsCatListByPName(acg.getCat());
		}else{
			componentList=new ArrayList<GoodsCat>();
		}
		List<String> picList=collectService.gainActiveCollectGoodsPicByGoodsId(request.getParameter("id"));
		if(picList.size()>0){
			request.setAttribute("picList", picList);
		}
		if(acg.getBrand()!=null){
			List<CarBrand> temp=collectService.gainBrandListByBrandName(acg.getBrand());
			List<String> brandSelect=new ArrayList<String>();
			for (CarBrand e : temp) {
				brandSelect.add(e.getId());
			}
			
			request.setAttribute("brandSelect", brandSelect);
		}
		return "toPublicCheck";
	}
	
	/**
	* @Title: toReplenishCheck 补充类
	* @Description: 跳转校对某个配件的页面
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public String toReplenishUpload(){
 		acgqb=collectService.gainActiveCollectGoodsQBById(request.getParameter("id"));
 		if("0".equals(acgqb.getEditField())){
 			brandList=collectService.gainBrandList(1);
 			if(acgqb.getBrand()!=null){
 				seriesList=collectService.gainNextCarBrandListByPName(acgqb.getBrand());
 			}else{
 				seriesList=new ArrayList<CarBrand>();
 			}
 			typeList=new ArrayList<CarBrand>();
 			catList=collectService.gainCatList(1);
 			if(acgqb.getCat()!=null&&!"".equals(acgqb.getCat())){
 				secondCatList=collectService.gainNextGoodsCatListByPName(acgqb.getCat());
 			}else{
 				secondCatList=new ArrayList<GoodsCat>();
 			}
 			if(acgqb.getBrand()!=null){
 				List<CarBrand> temp=collectService.gainBrandListByBrandName(acgqb.getBrand());
 				List<String> brandSelect=new ArrayList<String>();
 				for (CarBrand e : temp) {
 					brandSelect.add(e.getId());
 				}
 				
 				request.setAttribute("brandSelect", brandSelect);
 			}
 		}else if("1".equals(acgqb.getEditField())){
 			if(acgqb.getBrand()!=null){
 				seriesList=collectService.gainNextCarBrandListByPName(acgqb.getBrand());
 			}else{
 				brandList=collectService.gainBrandList(1);
 				seriesList=new ArrayList<CarBrand>();
 			}
 			typeList=new ArrayList<CarBrand>();
 			catList=collectService.gainCatList(1);
 			if(acgqb.getCat()!=null&&!"".equals(acgqb.getCat())){
 				secondCatList=collectService.gainNextGoodsCatListByPName(acgqb.getCat());
 			}else{
 				secondCatList=new ArrayList<GoodsCat>();
 			}
 			if(acgqb.getBrand()!=null){
 				List<CarBrand> temp=collectService.gainBrandListByBrandName(acgqb.getBrand());
 				List<String> brandSelect=new ArrayList<String>();
 				for (CarBrand e : temp) {
 					brandSelect.add(e.getId());
 				}
 				
 				request.setAttribute("brandSelect", brandSelect);
 			}
 		}else{
 			brandList=collectService.gainBrandList(1);
 			if(acgqb.getBrand()!=null){
 				seriesList=collectService.gainNextCarBrandListByPName(acgqb.getBrand());
 			}else{
 				seriesList=new ArrayList<CarBrand>();
 			}
 			typeList=new ArrayList<CarBrand>();
 			catList=collectService.gainCatList(1);
 			if(acgqb.getCat()!=null&&!"".equals(acgqb.getCat())){
 				secondCatList=collectService.gainNextGoodsCatListByPName(acgqb.getCat());
 			}else{
 				secondCatList=new ArrayList<GoodsCat>();
 			}
 			if(acgqb.getBrand()!=null){
 				List<CarBrand> temp=collectService.gainBrandListByBrandName(acgqb.getBrand());
 				List<String> brandSelect=new ArrayList<String>();
 				for (CarBrand e : temp) {
 					brandSelect.add(e.getId());
 				}
 				
 				request.setAttribute("brandSelect", brandSelect);
 			}
 		}
 		componentList=new ArrayList<GoodsCat>();
		return "toReplenishUpload";
	}
	
	public List<GoodsCat> getSecondCatList() {
		return secondCatList;
	}


	public void setSecondCatList(List<GoodsCat> secondCatList) {
		this.secondCatList = secondCatList;
	}


	/**
	* @Title: toDirectionalUpload
	* @Description: 丁香类上传
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public String toDirectionalUpload(){
		List<String> brandSelect=new ArrayList<String>();
		brandSelect.add("中国重汽");
		String temp=brandSelect.toString();
		temp=temp.substring(1, temp.length()-1);
		acgqb=new ActiveCollectGoodsQB();
		acgqb.setBrand(temp);
		seriesList=collectService.gainNextCarBrandListByPName(temp);
		typeList=new ArrayList<CarBrand>();
		catList=collectService.gainCatList(1);
		componentList=new ArrayList<GoodsCat>();
		request.setAttribute("brandSelect", brandSelect);
		return "toDirectionalUpload";
	}
	
	/**
	* @Title: check
	* @Description: 文本框校对
	* @param     设定文件
	* @return void    返回类型
	*/
	public void check(){
		SessionInfo si=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String,Object> map=new HashMap<String,Object>();
		ActiveCollectGoodsCheck acgc=new ActiveCollectGoodsCheck();
		acgc.setCreatetime(new Date());
		acgc.setGfields(request.getParameter("key"));
		acgc.setGvalues(request.getParameter("value"));
		acgc.setGoodsId(request.getParameter("goodsId"));
		acgc.setSourceType(1);
		acgc.setId(ToolsUtil.getUUID());
		acgc.setStatus(0D);
		acgc.setMemberId(si.getUserId());
			try {
				collectService.saveCheck(acgc);
			} catch (Exception e) {
				map.put("error", "该数据您已经提交过!");
			}
			map.put("success", true);
			map.put("msg", "成功");
			super.writeJson(map);
	}
	
	/**
	* @Title: checkSelect
	* @Description: 车型车系select 框校对
	* @param     设定文件
	* @return void    返回类型
	*/
	public void checkSelect(){
		SessionInfo si=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String,Object> map=new HashMap<String,Object>();
		ActiveCollectGoodsCheck acgc=new ActiveCollectGoodsCheck();
		acgc.setCreatetime(new Date());
		acgc.setGfields(request.getParameter("key"));
		String value=request.getParameter("value");
//		List<String> brandSelect=collectService.gainCarBrandNameById(request.getParameter("value"));
		
		if(request.getParameter("selectVal")!=null){
			seriesList=collectService.gainNextCarBrandListByPid(request.getParameter("selectVal"));
		}else{
			seriesList=collectService.gainNextCarBrandListByPName(request.getParameter("value"));
		}
		List<String> type=new ArrayList<String>();
		for (CarBrand e : seriesList) {
			type.add(e.getName());
		}
		if(type.size()>0){
			String temps=type.toString();
			temps=temps.substring(1,temps.length()-1);
			typeList=collectService.gainNextCarBrandListByPName(temps);
		}
//		String value=brandSelect.toString();
//		value=value.substring(1, value.length()-1);
		acgc.setGvalues(value);
		acgc.setGoodsId(request.getParameter("goodsId"));
		acgc.setSourceType(1);
		acgc.setId(ToolsUtil.getUUID());
		acgc.setStatus(0D);
		acgc.setMemberId(si.getUserId());
		try {
			collectService.saveCheck(acgc);
		} catch (Exception e1) {
			map.put("error", "该数据您已经提交过!");
		}
		map.put("success", true);
		map.put("msg", "成功");
		map.put("obj", acgc);
		map.put("seriesList",seriesList );
		map.put("typeList", typeList);
		super.writeJson(map);
	}
	
	public void gainCarBrandNext(){
		typeList=collectService.gainNextCarBrandListByPid(request.getParameter("pid"));
		super.writeJson(typeList);
	}
	
	/**
	* @Title: checkSelectForCat
	* @Description: 配件组件select框校对
	* @param     设定文件
	* @return void    返回类型
	*/
	public void checkSelectForCat(){
		SessionInfo si=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String,Object> map=new HashMap<String,Object>();
		ActiveCollectGoodsCheck acgc=new ActiveCollectGoodsCheck();
		acgc.setCreatetime(new Date());
		acgc.setGfields(request.getParameter("key"));
		if(request.getParameter("pid")!=null){
			catList=collectService.gainNextGoodsCatListByPid(request.getParameter("pid"));
			map.put("catList",catList );
		}
		acgc.setGvalues(request.getParameter("value"));
		acgc.setGoodsId(request.getParameter("goodsId"));
		acgc.setSourceType(1);
		acgc.setId(ToolsUtil.getUUID());
		acgc.setStatus(0D);
		acgc.setMemberId(si.getUserId());
		try {
			collectService.saveCheck(acgc);
		} catch (Exception e1) {
			map.put("error", "该数据您已经提交过!");
		}
		map.put("msg", "成功");
		super.writeJson(map);
	}
	
	/**
	* @Title: checkSelectForSpec
	* @Description: 规格校对
	* @param     设定文件
	* @return void    返回类型
	*/
	public void checkSelectForSpec(){
		SessionInfo si=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String,Object> map=new HashMap<String,Object>();
		ActiveCollectGoodsCheck acgc=new ActiveCollectGoodsCheck();
		acgc.setCreatetime(new Date());
		String key=request.getParameter("key");
		List<String> keys=ToolsUtil.StringConvertList(key);
		String value=request.getParameter("value");
		List<String> values=ToolsUtil.StringConvertList(value);
		for (int i = 0; i < keys.size(); i++) {
			acgc.setGfields(keys.get(i));
			acgc.setGvalues(values.get(i));
			acgc.setGoodsId(request.getParameter("goodsId"));
			acgc.setSourceType(1);
			acgc.setId(ToolsUtil.getUUID());
			acgc.setStatus(0D);
			acgc.setMemberId(si.getUserId());
			try {
				collectService.saveCheck(acgc);
			} catch (Exception e1) {
				map.put("error", "规格值有您已经提交过的数据,我们会自动给你剔除,请谅解!");
			}
		}
		map.put("msg", "成功");
		super.writeJson(map);
	}
	
	
	public void checkRight(){
		SessionInfo si=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String,Object> map=new HashMap<String,Object>();
		ActiveCollectGoodsCheck acgc=new ActiveCollectGoodsCheck();
		acgc.setCreatetime(new Date());
		String key=request.getParameter("key");
		String value=request.getParameter("value");
		acgc.setGfields(key);
		acgc.setGvalues(value);
		acgc.setGoodsId(request.getParameter("goodsId"));
		acgc.setSourceType(1);
		acgc.setId(ToolsUtil.getUUID());
		acgc.setStatus(0D);
		acgc.setMemberId(si.getUserId());
		try {
			collectService.saveCheck(acgc);
		} catch (Exception e) {
			map.put("error", "");
		}
		map.put("msg", "成功");
		super.writeJson(map);
	}
	
	/**
	* @Title: checkName
	* @Description: 根据id查名字
	* @param     设定文件
	* @return void    返回类型
	*/
	public void checkName(){
		String brandSelect=collectService.gainCarBrandNameById(request.getParameter("id")).toString();
		brandSelect = brandSelect.substring(1,brandSelect.length()-1);
		super.writeJson(brandSelect);
	}
	
	/**
	* @Title: toAdd
	* @Description: 跳转上传商品页面
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public String toAdd(){
		brandList=collectService.gainBrandList(1);
		catList=collectService.gainCatList(1);
		return "toAdd";
	}
	
	public void gainNextCarBrandList(){
		String pid=request.getParameter("pid");
		Map<String,Object> map=new HashMap<String,Object>();
		brandList=new ArrayList<CarBrand>();
		List<String> temp=new ArrayList<String>();
		if(!"".equals(pid.trim())){
			brandList=collectService.gainNextCarBrandListByPid(pid);
			temp=collectService.gainCarBrandNameById(pid);
		}
		String carBrand=temp.toString();
		map.put("carBrandName", carBrand.substring(1, carBrand.length()-1));
		map.put("brandList", brandList);
		super.writeJson(map);
	}
	
	public void gainNextGoodsCatList(){
		String pid=request.getParameter("pid");
		catList=new ArrayList<GoodsCat>();
		if(!"".equals(pid.trim())){
			catList=collectService.gainNextGoodsCatListByPid(pid);
		}
		super.writeJson(catList);
	}
	
	/**
	* @Title: upload
	* @Description: 上传功能组件
	* @param @throws Exception    设定文件
	* @return void    返回类型
	*/
	public void uploadpic() throws Exception {
		
		ftp=new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
		ftp.connectServer();
		String savePath=ResourceUtil.getActive_collect_goods_Directory();
		if(!ftp.isDirExist(savePath)){
			ftp.createDir(savePath);
		}
		ftp.cd(savePath);
		ftp.upload(this.filedata.getPath(), request.getParameter("name"));
		ActiveCollectGoodsCheck acgc=new ActiveCollectGoodsCheck();
		acgc.setCreatetime(new Date());
		acgc.setGfields("pic");
		acgc.setGvalues(ResourceUtil.getWebPath()+ResourceUtil.getActive_collect_goods_Directory() + "/"+request.getParameter("name"));
		acgc.setGoodsId(request.getParameter("goodsId"));
		acgc.setSourceType(1);
		acgc.setId(ToolsUtil.getUUID());
		acgc.setStatus(0D);
		//acgc.setMemberId(si.getUserId());
		collectService.saveCheck(acgc);
		ftp.closeServer();
		super.writeJson(true);
	}
	
	
	
	public void upload() throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
		ftp.connectServer();
		String savePath=ResourceUtil.getActive_collect_goods_Directory()+"/";
		if(!ftp.isDirExist(savePath)){
			ftp.createDir(savePath);
		}
		ftp.cd(savePath);
		String fileExt = filedataFileName.substring(filedataFileName.lastIndexOf(".") + 1)
				.toLowerCase();
		String newFileName = UUID.randomUUID().toString()
				.replaceAll("-", "")
				+ "." + fileExt;// 新的文件名称
		try {
			ftp.upload(this.filedata.getPath(), newFileName);
		} catch (Exception e) {
			map.put("status", 0);
			e.printStackTrace();
		}
		ftp.closeServer();
		map.put("status", 1);
		map.put("url", savePath + newFileName);
		super.writeJson(map);
	}
	
	
	public String toSubmit() {
		String filePath =  ResourceUtil.getWebPath() + ResourceUtil.getActive_collect_goods_Directory() ;
		log.info("上传图片保存文件路径： " + filePath);
		String temp=request.getParameter("refundImageUrls");
		String pic[] = {};
		if(temp!=null&!"".equals(temp)){
			pic=temp.split(",");
		}
//		int count = Integer.parseInt(request.getParameter("uploader_count"));
//		if(count==0){
//			count=picCount;
//		}
		ActiveCollectGoodsPic acgp;
		SessionInfo si=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(si==null){
			return "activeLogin";
		}
		acg.setId(ToolsUtil.getUUID());
		acg.setCreatetime(new Date());
		acg.setModifytime(new Date());
		acg.setMemberid(si.getUserId());
		acg.setIp(si.getIp());
		List<ActiveCollectGoodsPic> acgpList=new ArrayList<ActiveCollectGoodsPic>();
		for (int i = 0; i < pic.length; i++) {
			acgp=new ActiveCollectGoodsPic();
			acgp.setId(ToolsUtil.getUUID());
			acgp.setGoodsId(acg.getId());
			acgp.setSrc(ResourceUtil.getWebPath()+pic[i]);
			acgpList.add(acgp);
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("acg", acg);
		map.put("acgpList", acgpList);
		collectService.saveActiveCollectGoods(map);
		ActiveCollectGoodsCheck acgc=new ActiveCollectGoodsCheck();
		if(acg.getUploadType()==0){
			String editField=request.getParameter("editField");
			if("0".equals(editField)){
				acgc.setCreatetime(new Date());
				acgc.setModifytime(new Date());
				acgc.setMemberId(si.getUserId());
				acgc.setSourceType(0);
				acgc.setGoodsId(acg.getId());
				if(acg.getSeries()!=null&&!"".equals(acg.getSeries())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("series");
					acgc.setGvalues(acg.getSeries());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getType()!=null&&!"".equals(acg.getType())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("type");
					acgc.setGvalues(acg.getType());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getComponent()!=null&&!"".equals(acg.getComponent())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("component");
					acgc.setGvalues(acg.getComponent());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				try {
					if(acgpList.size()>0){
						acgc.setGfields("pic");
						for (ActiveCollectGoodsPic e : acgpList) {
							acgc.setId(ToolsUtil.getUUID());
							acgc.setGvalues(e.getSrc());
							try {
								collectService.saveCheck(acgc);
							} catch (Exception e1) {
								log.error(e1);
								e1.printStackTrace();
							}
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(acg.getGheight()!=null&&!"".equals(acg.getGheight().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gheight");
					acgc.setGvalues(acg.getGheight().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGhole()!=null&&!"".equals(acg.getGhole().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("ghole");
					acgc.setGvalues(acg.getGhole().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGinside()!=null&&!"".equals(acg.getGinside().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("ginside");
					acgc.setGvalues(acg.getGinside().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGlength()!=null&&!"".equals(acg.getGlength().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("glength");
					acgc.setGvalues(acg.getGlength().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGoutside()!=null&&!"".equals(acg.getGoutside().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("goutside");
					acgc.setGvalues(acg.getGoutside().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGweight()!=null&&!"".equals(acg.getGweight().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gweight");
					acgc.setGvalues(acg.getGweight().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGwheel()!=null&&!"".equals(acg.getGwheel().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gwheel");
					acgc.setGvalues(acg.getGwheel().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGwidth()!=null&&!"".equals(acg.getGwidth().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gwidth");
					acgc.setGvalues(acg.getGwidth().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
			}else if ("1".equals(editField)) {
				acgc.setCreatetime(new Date());
				acgc.setModifytime(new Date());
				acgc.setMemberId(si.getUserId());
				acgc.setSourceType(0);
				acgc.setGoodsId(acgc.getId());
				if(acg.getSeries()!=null&&!"".equals(acg.getSeries().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("series");
					acgc.setGvalues(acg.getSeries());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getType()!=null&&!"".equals(acg.getType().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("type");
					acgc.setGvalues(acg.getType());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getCat()!=null&&!"".equals(acg.getCat().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("cat");
					acgc.setGvalues(acg.getCat());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getComponent()!=null&&!"".equals(acg.getComponent().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("component");
					acgc.setGvalues(acg.getComponent());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acgpList.size()>0){
					acgc.setGfields("pic");
					for (ActiveCollectGoodsPic e : acgpList) {
						acgc.setId(ToolsUtil.getUUID());
						acgc.setGvalues(e.getSrc());
						try {
							collectService.saveCheck(acgc);
						} catch (Exception e1) {
							log.error(e1);
							e1.printStackTrace();
						}
					}
				}
				if(acg.getGheight()!=null&&!"".equals(acg.getGheight().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gheight");
					acgc.setGvalues(acg.getGheight().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGhole()!=null&&!"".equals(acg.getGhole().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("ghole");
					acgc.setGvalues(acg.getGhole().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGinside()!=null&&!"".equals(acg.getGinside().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("ginside");
					acgc.setGvalues(acg.getGinside().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGlength()!=null&&!"".equals(acg.getGlength().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("glength");
					acgc.setGvalues(acg.getGlength().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGoutside()!=null&&!"".equals(acg.getGoutside().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("goutside");
					acgc.setGvalues(acg.getGoutside().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGweight()!=null&&!"".equals(acg.getGweight().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gweight");
					acgc.setGvalues(acg.getGweight().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGwheel()!=null&&!"".equals(acg.getGwheel().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gwheel");
					acgc.setGvalues(acg.getGwheel().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGwidth()!=null&&!"".equals(acg.getGwidth().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gwidth");
					acgc.setGvalues(acg.getGwidth().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
			}else{
				acgc.setCreatetime(new Date());
				acgc.setModifytime(new Date());
				acgc.setMemberId(si.getUserId());
				acgc.setSourceType(0);
				acgc.setGoodsId(acgc.getId());
				if(acg.getBrand()!=null&&!"".equals(acg.getBrand().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("series");
					acgc.setGvalues(acg.getSeries());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getSeries()!=null&&!"".equals(acg.getSeries().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("series");
					acgc.setGvalues(acg.getSeries());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getType()!=null&&!"".equals(acg.getType().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("type");
					acgc.setGvalues(acg.getType());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getCat()!=null&&!"".equals(acg.getCat().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("cat");
					acgc.setGvalues(acg.getCat());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getComponent()!=null&&!"".equals(acg.getComponent().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("component");
					acgc.setGvalues(acg.getComponent());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acgpList.size()>0){
					acgc.setGfields("pic");
					for (ActiveCollectGoodsPic e : acgpList) {
						acgc.setId(ToolsUtil.getUUID());
						acgc.setGvalues(e.getSrc());
						try {
							collectService.saveCheck(acgc);
						} catch (Exception e1) {
							log.error(e1);
							e1.printStackTrace();
						}
					}
				}
				if(acg.getGheight()!=null&&!"".equals(acg.getGheight().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gheight");
					acgc.setGvalues(acg.getGheight().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGhole()!=null&&!"".equals(acg.getGhole().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("ghole");
					acgc.setGvalues(acg.getGhole().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGinside()!=null&&!"".equals(acg.getGinside().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("ginside");
					acgc.setGvalues(acg.getGinside().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGlength()!=null&&!"".equals(acg.getGlength().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("glength");
					acgc.setGvalues(acg.getGlength().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGoutside()!=null&&!"".equals(acg.getGoutside().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("goutside");
					acgc.setGvalues(acg.getGoutside().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGweight()!=null&&!"".equals(acg.getGweight().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gweight");
					acgc.setGvalues(acg.getGweight().trim());
					collectService.saveCheck(acgc);
				}
				if(acg.getGwheel()!=null&&!"".equals(acg.getGwheel().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gwheel");
					acgc.setGvalues(acg.getGwheel().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
				if(acg.getGwidth()!=null&&!"".equals(acg.getGwidth().trim())){
					acgc.setId(ToolsUtil.getUUID());
					acgc.setGfields("gwidth");
					acgc.setGvalues(acg.getGwidth().trim());
					try {
						collectService.saveCheck(acgc);
					} catch (Exception e) {
						log.error(e);
						e.printStackTrace();
					}
				}
			}
		}
		return "resultR";
	}
	
	private void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			if (dst.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(dst, true),BUFFER_SIZE);
			} else {
				out = new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
			}
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * @return the acg
	 */
	public ActiveCollectGoods getAcg() {
		return acg;
	}

	/**
	 * @param acg the acg to set
	 */
	public void setAcg(ActiveCollectGoods acg) {
		this.acg = acg;
	}



	/**
	 * @return the acgList
	 */
	public List<ActiveCollectGoods> getAcgList() {
		return acgList;
	}


	/**
	 * @param acgList the acgList to set
	 */
	public void setAcgList(List<ActiveCollectGoods> acgList) {
		this.acgList = acgList;
	}


	/**
	 * @return the collectService
	 */
	public CollectService getCollectService() {
		return collectService;
	}


	/**
	 * @param collectService the collectService to set
	 */
	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}


	/**
	 * @return the brandList
	 */
	public List<CarBrand> getBrandList() {
		return brandList;
	}


	/**
	 * @param brandList the brandList to set
	 */
	public void setBrandList(List<CarBrand> brandList) {
		this.brandList = brandList;
	}


	/**
	 * @return the seriesList
	 */
	public List<CarBrand> getSeriesList() {
		return seriesList;
	}


	/**
	 * @param seriesList the seriesList to set
	 */
	public void setSeriesList(List<CarBrand> seriesList) {
		this.seriesList = seriesList;
	}


	/**
	 * @return the typeList
	 */
	public List<CarBrand> getTypeList() {
		return typeList;
	}


	/**
	 * @param typeList the typeList to set
	 */
	public void setTypeList(List<CarBrand> typeList) {
		this.typeList = typeList;
	}


	/**
	 * @return the catList
	 */
	public List<GoodsCat> getCatList() {
		return catList;
	}


	/**
	 * @param catList the catList to set
	 */
	public void setCatList(List<GoodsCat> catList) {
		this.catList = catList;
	}


	/**
	 * @return the componentList
	 */
	public List<GoodsCat> getComponentList() {
		return componentList;
	}


	/**
	 * @param componentList the componentList to set
	 */
	public void setComponentList(List<GoodsCat> componentList) {
		this.componentList = componentList;
	}


	/**
	 * @return the acgqb
	 */
	public ActiveCollectGoodsQB getAcgqb() {
		return acgqb;
	}


	/**
	 * @param acgqb the acgqb to set
	 */
	public void setAcgqb(ActiveCollectGoodsQB acgqb) {
		this.acgqb = acgqb;
	}

	public void test(){
		collectService.test();
	}


	/**
	 * @return the filedata
	 */
	public File getFiledata() {
		return filedata;
	}


	/**
	 * @param filedata the filedata to set
	 */
	public void setFiledata(File filedata) {
		this.filedata = filedata;
	}


	/**
	 * @return the filedataFileName
	 */
	public String getFiledataFileName() {
		return filedataFileName;
	}


	/**
	 * @param filedataFileName the filedataFileName to set
	 */
	public void setFiledataFileName(String filedataFileName) {
		this.filedataFileName = filedataFileName;
	}


	/**
	 * @return the filedataContentType
	 */
	public String getFiledataContentType() {
		return filedataContentType;
	}


	/**
	 * @param filedataContentType the filedataContentType to set
	 */
	public void setFiledataContentType(String filedataContentType) {
		this.filedataContentType = filedataContentType;
	}
}
