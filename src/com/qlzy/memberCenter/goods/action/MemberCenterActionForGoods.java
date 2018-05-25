package com.qlzy.memberCenter.goods.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService;
import com.qlzy.memberCenter.goods.service.GoodsService;
import com.qlzy.memberCenter.order.service.OrderService;
import com.qlzy.model.CarBrand;
import com.qlzy.model.Company;
import com.qlzy.model.Goods;
import com.qlzy.model.GoodsAndLabel;
import com.qlzy.model.GoodsLabel;
import com.qlzy.model.GoodsSpecification;
import com.qlzy.model.GoodsSpecificationValue;
import com.qlzy.model.Member;
import com.qlzy.pojo.Json;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Constant;
import com.qlzy.util.Pagination;

/**
 * @ClassName: MemberCenterActionForGoods
 * @Description: 
 * @author Huifeng Wang
 * @date 2013-5-27 下午1:33:41
 *
 */
@Namespace("/memberCenter")
@Action(value = "goods", results = {
		@Result(name = "toAdd", location = "/memberCenter/company/goods/hyzxdpgl_sptj.jsp"),
		@Result(name = "toEdit", location = "/memberCenter/company/goods/hyzxdpgl_spxg.jsp"),
		@Result(name = "add",type="redirect", location = "/memberCenterGL.html"),
		@Result(name = "edit",type="redirect", location = "/memberCenterGL.html"),
		@Result(name = "recycle", location = "/memberCenter/company/goods/hyzxdpgl_sphsz.jsp"),
		@Result(name = "list", location = "/memberCenter/company/goods/hyzxdpgl_splb.jsp"),
		@Result(name = "error", location = "/error/404.jsp")})
public class MemberCenterActionForGoods extends BaseAction{
	private static final long serialVersionUID = 1L;
	private Goods goods;
	@Autowired
	private GoodsService goodsService;
	@Resource
	private CompanyInfoService companyInfoService;
	
	private List<CarBrand> firstCarBrands;
	
	private Date startTime;
	private Date endTime;
	private SessionInfo sessionInfo;
	
	/**
	 * 跳转商品添加页面
	 * @author HuifengWang
	 * @return
	 */
	public String toAdd(){
		sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo == null){
			return "login_hf";
		}
		// 判断是否是企业登录人
		Company company = companyInfoService.gainCompanyById(sessionInfo.getUserId());
		if(null == company){
			return "error";
		}
		
		List<GoodsLabel> goodsLabels=goodsService.gainGoodsLabels();
		List<GoodsSpecification> goodsSpecifications=goodsService.gainGoodsSepcifications();
		request.setAttribute("goodsLabels", goodsLabels);
		request.setAttribute("goodsSpecifications", goodsSpecifications);
		return "toAdd";
	}
	/**
	 * 根据原厂编号查询标准数据库
	 * @author HuifengWang
	 */
	public void gainGoodsListByBnAndStanderIsZero(){
		List<Goods> list=goodsService.gainGoodsListByBnAndStanderIsZero(request.getParameter("bn"));
		Goods goods =new Goods();
		Map<String, Object> map=new HashMap<String,Object>();
		if(list!=null && list.size()>0){
			goods=list.get(0);
			List<String> carBrand=goodsService.gainGoodsMidCarBrand(goods.getId());//获取车型
			List<String> secCarBrand=goodsService.gainSecondCarBrand(carBrand);//根据车型获取车系
			List<String> firCarBrand=goodsService.gainSecondCarBrand(secCarBrand);//根据车系获取品牌
			List<Map<String,Object>> gsv=new ArrayList<Map<String,Object>>();
			List<GoodsSpecification> goodsSpecifications=goodsService.gainGoodsSepcifications();
			List<GoodsSpecificationValue> specValue=goodsService.gainGoodsSpecificationValueByGoodsId(goods.getId());//根据商品ID获取商品关联规格的中间表的值
			for (GoodsSpecification e : goodsSpecifications) {
				Map<String,Object> sv =new HashMap<String,Object>();
				sv.put("specificationId", e.getId());
				sv.put("specificationName", e.getName());
				for (GoodsSpecificationValue f : specValue) {
					if(e.getId().equals(f.getSpecificationId())){
						sv.put("specificationValue", f.getSpecificationValue());
					}
				}
				gsv.add(sv);
			}
			boolean flag=true;
			Map<String,Object> cpmap= new  HashMap<String,Object>();
			String cpid=goods.getCarPartsId();
			Integer i=1;
			while(flag){
				String temp=goodsService.gainGoodsCatPidById(cpid);
				if(temp!=null &&!temp.equals("") && !temp.equals("B040E78C948846C2AD1595047FA6D9CB")){
					cpmap.put("pid"+i, temp);
					cpid=temp;
					i++;
				}else{
					flag=false;
				}
				
			}
			map.put("cpLevel", i);
			map.put("cpmap", cpmap);
			map.put("first", firCarBrand);
			map.put("sec", secCarBrand);
			map.put("third", carBrand);
			map.put("goods", goods);
			map.put("gsv", gsv);
		}else{
			map.put("first", new ArrayList<String>());
			map.put("sec", new ArrayList<String>());
			map.put("third", new ArrayList<String>());
			map.put("goods", goods);
			map.put("gsv", new ArrayList<Map<String,Object>>());
		}
		super.writeJson(map);
	}
	/**
	 * 跳转编辑商品页面
	 * @author HuifengWang
	 * @return
	 */
	public String toEdit(){
		sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo == null){
			return "login_hf";
		}
		String goodsId=request.getParameter("id");
		Goods goods=goodsService.gainGoodsById(goodsId);
		List<String> goodsIdList=new ArrayList<String>();
		goodsIdList.add(goodsId);
//		List<String> thumb=goodsService.gainGoodsPicListByGoodsIds(goodsIdList);
		List<GoodsSpecification> goodsSpecifications=goodsService.gainGoodsSepcifications();
		List<GoodsSpecificationValue> specValue=goodsService.gainGoodsSpecificationValueByGoodsId(goodsId);//根据商品ID获取商品关联规格的中间表的值
		List<GoodsLabel> goodsLabels=goodsService.gainGoodsLabels();
		List<GoodsAndLabel> glValue=goodsService.gainGoodsAndLabelsByGoodsId(goodsId);
		List<Map<String,Object>> goodsLabelList=new ArrayList<Map<String,Object>>();
		for (GoodsLabel e : goodsLabels) {
			Map<String,Object> map =new HashMap<String,Object>();
			map.put("id", e.getId());
			map.put("name", e.getName());
			for (GoodsAndLabel f : glValue) {
				if(e.getId().equals(f.getGoodsLabelId())){
					map.put("selected", true);
				}
			}
			goodsLabelList.add(map);
		}
		List<Map<String,Object>> gsv=new ArrayList<Map<String,Object>>();
		for (GoodsSpecification e : goodsSpecifications) {
			Map<String,Object> sv =new HashMap<String,Object>();
			sv.put("specificationId", e.getId());
			sv.put("specificationName", e.getName());
			for (GoodsSpecificationValue f : specValue) {
				if(e.getId().equals(f.getSpecificationId())){
					sv.put("specificationValue", f.getSpecificationValue());
				}
			}
			gsv.add(sv);
		}
		request.setAttribute("goods", goods);
//		request.setAttribute("pic", thumb);
		request.setAttribute("gsv", gsv);
		request.setAttribute("goodsLabelList", goodsLabelList);
		return "toEdit";
	}
	/**
	 * 商品编辑页面车型车系反选
	 * @author HuifengWang
	 */
	public void gainOtherForEdit(){
//		String goodsId=request.getParameter("id");
		String cpid=request.getParameter("cpid");
		Map<String, Object> map=new HashMap<String,Object>();
		boolean flag=true;
		Map<String,Object> cpmap= new  HashMap<String,Object>();
		Integer i=1;
		while(flag){
			String temp=goodsService.gainGoodsCatPidById(cpid);
			if(temp!=null &&!temp.equals("") && !temp.equals("B040E78C948846C2AD1595047FA6D9CB")){
				cpmap.put("pid"+i, temp);
				cpid=temp;
				i++;
			}else{
				flag=false;
			}
			
		}
		map.put("cpLevel", i);
		map.put("cpmap", cpmap);
		super.writeJson(map);
	}
	
	/**
	 * 编辑商品
	 * @author HuifengWang
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String edit() throws UnsupportedEncodingException{
		sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo == null){
			return "login_hf";
		}
		Map<String, Object> map=new HashMap<String,Object>();
		String goodsLabel= request.getParameter("goodsLabel");
		String pic=request.getParameter("picSrc");
		String specValues=request.getParameter("specValues");
		map.put("goodsLabel", goodsLabel);
		map.put("pic", pic);
		map.put("specValues", specValues);
		goods.setModifytime(new Date());
		goods.setCompanyId(sessionInfo.getUserId());
		goodsService.updateGoods(goods, map);
		return "edit";
	}
	/**
	* 获取车辆品牌
	* @Title: main
	* @Description: TODO获取车辆品牌
	* @param @param args    设定文件
	* @return void    返回类型
	 */
	public void gainFirstCarBrands(){
		super.writeJson(goodsService.gainBrandList(1));
	}
	/**
	 * 根据父类车型或者车系获取下一级子菜单
	 * @author HuifengWang
	 */
	public void gainCarBrandNext(){
		List<CarBrand> carBrands=goodsService.gainNextCarBrandListByPid(request.getParameter("pid"));
		super.writeJson(carBrands);
	}
	/**
	 * 获取商品分类
	 * @author HuifengWang
	 */
	public void gainGoodsCatList(){
		super.writeJson(goodsService.gainGoodsCatList());
	}
	
	/**
	 * 根据上一级商品分类查询下一级商品分类
	 * @author HuifengWang
	 * @param
	 */
	public void gainGoodsCatListByPid(){
		String pid =request.getParameter("id");
		super.writeJson(goodsService.gainNextGoodsCatListByPid2(pid));
	}
	
	public void gainGoodsCatShListByPid(){
		String pid = request.getParameter("id");
		super.writeJson(goodsService.gainNextGoodsCatShListByPid2(pid));
	}
	
	
	public void gainCarBrandListByPid(){
		String pid =request.getParameter("id");
		super.writeJson(goodsService.gainCarBrandListByPid(pid));
	}
	
	/**
	 * 获取车型所有列表
	 * @author HuifengWang
	 */
	public void gainCarBrandList(){
		List<CarBrand> carBrands=goodsService.gainCarBrandList();
		super.writeJson(carBrands);
	}
//	/**
//	 * 商品添加
//	 * @author HuifengWang
//	 * @return
//	 */
//	public String add(){
//		sessionInfo=(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
//		if(sessionInfo == null){
//			return "login_hf";
//		}
//		try {
//			Company company = companyInfoService.gainCompanyById(sessionInfo.getUserId());
//			if(null != company){
//				Map<String, Object> map=new HashMap<String,Object>();
//				String goodsLabel= request.getParameter("goodsLabel");
//				String pic=request.getParameter("picSrc");
//				String specValues=request.getParameter("specValues");
//				map.put("goodsLabel", goodsLabel);
//				map.put("pic", pic);
//				map.put("specValues", specValues);
//				goods.setIsStander("1");
//				goods.setId(ToolsUtil.getUUID());
//				goods.setCreatetime(new Date());
//				goods.setCompanyId(sessionInfo.getUserId());
//				goods.setSendIp(getIpAddr());
//
//				goodsService.addGoods(goods, map);
//			}
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return "add";
//	}
	/***
	 * 获得访问ip
	 * 
	 * @return
	 */
	public String getIpAddr() {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	/**
	 * 验证session是否过期
	 * @author HuifengWang
	 */
	public void checkSession(){
		SessionInfo info =(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(info==null){
			super.writeJson(false);
		}else {
			super.writeJson(true);
		}
	}
	
	/**
	 * 将登录用户的session信息发送到前台，实现SSO登陆
	 */
	public void sendSession(){
		SessionInfo info =(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Json json = new Json();
		if (info != null) {
			json.setSuccess(true);
			json.setObj(info);
		} else {
			json.setSuccess(false);
		}
		
		super.writeJson(json);
	}
	/**
	 * 跳转商品列表页
	 * @author HuifengWang
	 * @return
	 */
	public String list(){
		SessionInfo info =(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(info==null){
			return "login_hf";
		}
		// 判断是否是企业登录人
		Company company = companyInfoService.gainCompanyById(sessionInfo.getUserId());
		if(null == company){
			return "error";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(Constant.paginationRows);// 设置每页显示几条数据
		if(startTime!=null) map.put("startTime", startTime);
		if(endTime!=null) map.put("endTime", endTime);
		if(request.getParameter("name")!=null&& !request.getParameter("name").trim().equals("")){
			map.put("name", request.getParameter("name").trim());
			request.setAttribute("name",  request.getParameter("name").trim());
		}
		if(request.getParameter("bn")!=null && !request.getParameter("bn").trim().equals("")) {
			map.put("bn", request.getParameter("bn").trim());
			request.setAttribute("bn", request.getParameter("bn").trim());
		}
		if(request.getParameter("productBn")!=null && !request.getParameter("productBn").trim().equals("")) {
			map.put("productBn", request.getParameter("productBn").trim());
			request.setAttribute("productBn", request.getParameter("productBn").trim());
		}
		if(request.getParameter("shCatId")!=null && !request.getParameter("shCatId").trim().equals("")) {
			String cpid =request.getParameter("shCatId").trim();
			Map<String,Object> tem = new HashMap<String,Object>();
			map.put("shCatId", cpid );
			boolean flag=true;
			Map<String,Object> cpmap= new  HashMap<String,Object>();
			Integer i=1;
			while(flag){
				String temp=goodsService.gainGoodsCatPidShById(cpid);
				if(temp!=null &&!temp.equals("") && !temp.equals("72c65e31ec3e4044ba4938b1dbf7bd14")){
					cpmap.put("pid"+i, temp);
					cpid=temp;
					i++;
				}else{
					flag=false;
				}
				
			}
			tem.put("cpLevel", i);
			tem.put("cpmap", cpmap);
			request.setAttribute("goodsCatShTemp", tem);
			request.setAttribute("shCatId", request.getParameter("shCatId").trim());
		}
		if(request.getParameter("carPartsId")!=null && !request.getParameter("carPartsId").trim().equals("")) {
			String cpid =request.getParameter("carPartsId").trim();
			Map<String,Object> tem = new HashMap<String,Object>();
			map.put("carPartsId", cpid );
			boolean flag=true;
			Map<String,Object> cpmap= new  HashMap<String,Object>();
			Integer i=1;
			while(flag){
				String temp=goodsService.gainGoodsCatPidById(cpid);
				if(temp!=null &&!temp.equals("") && !temp.equals("B040E78C948846C2AD1595047FA6D9CB")){
					cpmap.put("pid"+i, temp);
					cpid=temp;
					i++;
				}else{
					flag=false;
				}
				
			}
			tem.put("cpLevel", i);
			tem.put("cpmap", cpmap);
			request.setAttribute("goodsCatTemp", tem);
			request.setAttribute("carPartsId", request.getParameter("carPartsId").trim());
		}
		if(request.getParameter("carBrand")!=null && !request.getParameter("carBrand").trim().equals("")) {
			String cpid=request.getParameter("carBrand").trim();
			map.put("carBrand", cpid);
			boolean flag=true;
			Map<String,Object> tem = new HashMap<String,Object>();
			Map<String,Object> cpmap= new  HashMap<String,Object>();
			Integer i=1;
			while(flag){
				String temp=goodsService.gainCarBrandPidById(cpid);
				if(temp!=null &&!temp.equals("") && !temp.equals("6F618C89E6AA473E979707B1B29D5B31")){
					cpmap.put("pid"+i, temp);
					cpid=temp;
					i++;
				}else{
					flag=false;
				}
				
			}
			tem.put("cpLevel", i);
			tem.put("cpmap", cpmap);
			request.setAttribute("carBrandTemp", tem);
			request.setAttribute("carBrand", request.getParameter("carBrand").trim());
		}
		if(request.getParameter("marketable")!=null &&! request.getParameter("marketable").trim().equals("")) {
			map.put("marketable", request.getParameter("marketable").trim());
			request.setAttribute("marketable",request.getParameter("marketable").trim());
		}
		if(request.getParameter("carPartsProducerId")!=null &&! request.getParameter("carPartsProducerId").trim().equals("")) {
			map.put("carPartsProducerId", request.getParameter("carPartsProducerId").trim());
			request.setAttribute("carPartsProducerId", request.getParameter("carPartsProducerId").trim());
		}
		if(request.getParameter("isCarProducter")!=null &&! request.getParameter("isCarProducter").trim().equals("")) {
			map.put("isCarProducter", request.getParameter("isCarProducter").trim());
			request.setAttribute("isCarProducter", request.getParameter("isCarProducter").trim());
		}
		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("companyId", info.getUserId());
		map.put("disabled", "false");
		List<Goods> goodsList=goodsService.gainGoodsListByCompanyIdWithPage(map);
		pagination.setTotalCount(goodsService.gainGoodsListCountByCompanyIdWithPage(map));
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("pagination", pagination);
		return "list";
	}
	
	/**
	 * 跳转商品回收站
	 * @author HuifengWang
	 * @return
	 */
	public String recycle(){
		SessionInfo info =(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(info==null){
			return "login_hf";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(Constant.paginationRows);// 设置每页显示几条数据
		if(startTime!=null) map.put("startTime", startTime);
		if(endTime!=null) map.put("endTime", endTime);
		if(request.getParameter("name")!=null&& !request.getParameter("name").trim().equals("")){
			map.put("name", request.getParameter("name").trim());
			request.setAttribute("name",  request.getParameter("name").trim());
		}
		if(request.getParameter("bn")!=null && !request.getParameter("bn").trim().equals("")) {
			map.put("bn", request.getParameter("bn").trim());
			request.setAttribute("bn", request.getParameter("bn").trim());
		}
		if(request.getParameter("productBn")!=null && !request.getParameter("productBn").trim().equals("")) {
			map.put("productBn", request.getParameter("productBn").trim());
			request.setAttribute("productBn", request.getParameter("productBn").trim());
		}
		if(request.getParameter("carPartsId")!=null && !request.getParameter("carPartsId").trim().equals("")) {
			String cpid =request.getParameter("carPartsId").trim();
			Map<String,Object> tem = new HashMap<String,Object>();
			map.put("carPartsId", cpid );
			boolean flag=true;
			Map<String,Object> cpmap= new  HashMap<String,Object>();
			Integer i=1;
			while(flag){
				String temp=goodsService.gainGoodsCatPidById(cpid);
				if(temp!=null &&!temp.equals("") && !temp.equals("B040E78C948846C2AD1595047FA6D9CB")){
					cpmap.put("pid"+i, temp);
					cpid=temp;
					i++;
				}else{
					flag=false;
				}
				
			}
			tem.put("cpLevel", i);
			tem.put("cpmap", cpmap);
			request.setAttribute("goodsCatTemp", tem);
			request.setAttribute("carPartsId", request.getParameter("carPartsId").trim());
		}
		if(request.getParameter("carBrand")!=null && !request.getParameter("carBrand").trim().equals("")) {
			String cpid=request.getParameter("carBrand").trim();
			map.put("carBrand", cpid);
			boolean flag=true;
			Map<String,Object> tem = new HashMap<String,Object>();
			Map<String,Object> cpmap= new  HashMap<String,Object>();
			Integer i=1;
			while(flag){
				String temp=goodsService.gainCarBrandPidById(cpid);
				if(temp!=null &&!temp.equals("") && !temp.equals("6F618C89E6AA473E979707B1B29D5B31")){
					cpmap.put("pid"+i, temp);
					cpid=temp;
					i++;
				}else{
					flag=false;
				}
				
			}
			tem.put("cpLevel", i);
			tem.put("cpmap", cpmap);
			request.setAttribute("carBrandTemp", tem);
			request.setAttribute("carBrand", request.getParameter("carBrand").trim());
		}
		if(request.getParameter("marketable")!=null &&! request.getParameter("marketable").trim().equals("")) {
			map.put("marketable", request.getParameter("marketable").trim());
			request.setAttribute("marketable",request.getParameter("marketable").trim());
		}
		if(request.getParameter("carPartsProducerId")!=null &&! request.getParameter("carPartsProducerId").trim().equals("")) {
			map.put("carPartsProducerId", request.getParameter("carPartsProducerId").trim());
			request.setAttribute("carPartsProducerId", request.getParameter("carPartsProducerId").trim());
		}
		if(request.getParameter("isCarProducter")!=null &&! request.getParameter("isCarProducter").trim().equals("")) {
			map.put("isCarProducter", request.getParameter("isCarProducter").trim());
			request.setAttribute("isCarProducter", request.getParameter("isCarProducter").trim());
		}
		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("companyId", info.getUserId());
		map.put("disabled", "true");
		List<Goods> goodsList=goodsService.gainGoodsListByCompanyIdWithPage(map);
		pagination.setTotalCount(goodsService.gainGoodsListCountByCompanyIdWithPage(map));
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("pagination", pagination);
		return "recycle";
	}
	
	
	/**
	 * @author HuifengWang
	 * 逻辑删除商品
	 */
	public void delete(){
		try {
			goodsService.delete(ToolsUtil.StringConvertList(request.getParameter("ids")));
			super.writeJson(true);
		} catch (Exception e) {
			super.writeJson(false);
			e.printStackTrace();
		}
	}
	
	/**
	 * @author HuifengWang
	 * 物理删除
	 */
	public void drop(){
		try {
			goodsService.drop(ToolsUtil.StringConvertList(request.getParameter("ids")));
			super.writeJson(true);
		} catch (Exception e) {
			super.writeJson(false);
			e.printStackTrace();
		}
	}
	
	/**
	 * @author HuifengWang
	 * 恢复商品
	 */
	public void recover(){
		try {
			goodsService.recover(ToolsUtil.StringConvertList(request.getParameter("ids")));
			super.writeJson(true);
		} catch (Exception e) {
			super.writeJson(false);
			e.printStackTrace();
		}
	}
	
	public void updateMarketable(){
		Map<String,Object> r = new HashMap<String,Object>();
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("list", ToolsUtil.StringConvertList(request.getParameter("ids")));
			map.put("marketable",request.getParameter("marketable"));
			goodsService.marketable(map);
			r.put("ok", true);
		} catch (Exception e) {
			super.writeJson(false);
			r.put("ok", false);
			e.printStackTrace();
		}
		super.writeJson(r);
	}
	public void gainGoodsSpecificationsByPid (){
		String pid=request.getParameter("pid");
		super.writeJson(goodsService.gainSpecification(pid));
	}



	/**
	 * @return the firstCarBrands
	 */
	public List<CarBrand> getFirstCarBrands() {
		return firstCarBrands;
	}

	/**
	 * @param firstCarBrands the firstCarBrands to set
	 */
	public void setFirstCarBrands(List<CarBrand> firstCarBrands) {
		this.firstCarBrands = firstCarBrands;
	}
	/**
	 * @return the goods
	 */
	public Goods getGoods() {
		return goods;
	}
	/**
	 * @param goods the goods to set
	 */
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
