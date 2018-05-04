/**  
 * @Title: ComShopManagerAction.java 
 * @Package com.qlzy.mainPage.floor.action 
 * @Description: TODO(商家店铺管理)
 * @author wangmei  
 * @date 2013-7-19 下午1:05:50
 * @version V1.0  
 */
package com.qlzy.memberCenter.shop.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.mainPage.floor.service.IndexFloorService;
import com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService;
import com.qlzy.memberCenter.shop.service.CompanyShopManageService;
import com.qlzy.model.Company;
import com.qlzy.model.CompanysGoodsCat;
import com.qlzy.model.CompanysHeadImg;
import com.qlzy.model.CompanysInfo;
import com.qlzy.model.CompanysMessage;
import com.qlzy.model.Goods;
import com.qlzy.model.Member;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Constant;
import com.qlzy.util.Pagination;

@Namespace("/comShopManage")
@Action(value = "companyShopManageAction", results = {
		@Result(name = "gainCompanyGoodsCats", location = "/memberCenter/company/shop/front/companyGoodsCats.jsp"),
		@Result(name = "toShowComProfilePage", location = "/memberCenter/company/shop/front/comProfile.jsp"),
		@Result(name = "toShowComProfilePageSh", location = "/memberCenter/company/shop/front/comProfileSh.jsp"),
		@Result(name = "toShowComHeadImgPage", location = "/memberCenter/company/shop/front/comHeadImg.jsp"),
		@Result(name = "toShowComInformationListPageSh", location = "/memberCenter/company/shop/front/comInformationListSh.jsp"),
		@Result(name = "toShowComInformationListPage", location = "/memberCenter/company/shop/front/comInformationList.jsp"),
		@Result(name = "toShowComInformationDetailPageSh", location = "/memberCenter/company/shop/front/comInformationDetailSh.jsp"),
		@Result(name = "toShowComInformationDetailPage", location = "/memberCenter/company/shop/front/comInformationDetail.jsp"),
		@Result(name = "toShowComGoodsListPageSh", location = "/memberCenter/company/shop/front/comGoodsListSh.jsp"),
		@Result(name = "toShowComGoodsListPage", location = "/memberCenter/company/shop/front/comGoodsList.jsp"),
		@Result(name = "toMoreComGoodsPageSh", location = "/memberCenter/company/shop/front/moreComGoodsSh.jsp"),
		@Result(name = "toMoreComGoodsPage", location = "/memberCenter/company/shop/front/moreComGoods.jsp"),
		@Result(name = "toComContactPage", location = "/memberCenter/company/shop/front/comContact.jsp"),
		@Result(name = "toComContactPageSh", location = "/memberCenter/company/shop/front/comContactSh.jsp"),
		@Result(name = "toComMessageListPageSh", location = "/memberCenter/company/shop/front/comMessageListSh.jsp"),
		@Result(name = "toComMessageListPage", location = "/memberCenter/company/shop/front/comMessageList.jsp"),
		@Result(name = "toLeaveMessagePageSh", location = "/memberCenter/company/shop/front/leaveMessageSh.jsp"),
		@Result(name = "toLeaveMessagePage", location = "/memberCenter/company/shop/front/leaveMessage.jsp"),
		@Result(name = "addCompanysMessageOk", type = "redirect", location = "/Shop/comMessage/list/${companyId}.html"),
		@Result(name = "gainCompanysHeadImgs", location = "/memberCenter/company/shop/front/comHeadImg.jsp"),
		@Result(name = "gainCompanysHeadImgsSh", location = "/memberCenter/company/shop/front/comHeadImgSh.jsp")})
@InterceptorRefs( {@InterceptorRef("defaultStack"),@InterceptorRef(value="token",params={"includeMethods","addCompanysMessage"})}) 
public class CompanyShopManageAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private IndexFloorService indexFloorService;
	@Resource
	private CompanyShopManageService companyShopManageService;
	@Resource
	private CompanyInfoService companyInfoService;

	private Goods goods = new Goods();// 商品实体类
	private Company company = new Company();// 商家实体类
	private CompanysInfo companysInfo = new CompanysInfo();// 企业资讯实体类
	private Member member = new Member();// 个人会员实体类
	private CompanysMessage companysMessage;// 留言实体类

	private List<Goods> goodsListByCom = new ArrayList<Goods>();// 供应商品列表
	private List<CompanysGoodsCat> companysGoodsCats = new ArrayList<CompanysGoodsCat>();// 热销品类列表
	private List<CompanysInfo> companysInfoList = new ArrayList<CompanysInfo>();// 企业资讯列表
	private List<Map<String, Object>> comGoodsList = new ArrayList<Map<String, Object>>();// 商品列表
	private List<CompanysHeadImg> companysHeadImgs = new ArrayList<CompanysHeadImg>();// 商家店铺头部广告列表
	private List<CompanysMessage> companysMessageList = new ArrayList<CompanysMessage>();// 留言列表

	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String, Object> comGoodsMap = new HashMap<String, Object>();

	private String companyId;
	private String goodsCatId;
	private String goodsCatName;
	private String userType;// 用户类型
	private String verifyCode;// 验证码
	private String result;

	/**
	 * @Title: gainComGoodsListByCat
	 * @Description: TODO(查询某商品分类下的商品信息)
	 * @param 设定文件
	 * @return void 返回类型
	 * @author wangmei
	 */
	public void gainComGoodsListByCat() {
		try {
			writeJson(indexFloorService.gainComGoodsListByCat(
					goods.getCompanyId(), goods.getCarPartsId()));
		} catch (Exception e) {
			logger.error("gainComGoodsListByCat", e);
			e.printStackTrace();
		}
	}

	/**
	 * @Title: gainCompanysHeadImgs
	 * @Description: TODO(获取商家店铺头部广告图片)
	 * @param 设定文件
	 * @return void 返回类型
	 * @author wangmei
	 */
	public String gainCompanysHeadImgs() {
		try {
			companysHeadImgs = companyShopManageService
					.gainHeadImgsByCompanyId(companyId);
		} catch (Exception e) {
			logger.error("companyShopManageAction-gainCompanysHeadImgs", e);
		}
		return "gainCompanysHeadImgs";
	}
	
	/**
	 * @Title: gainCompanysHeadImgs
	 * @Description: TODO(获取商家店铺头部广告图片)
	 * @param 设定文件
	 * @return void 返回类型
	 * @author wangmei
	 */
	public String gainCompanysHeadImgsSh() {
		try {
			companysHeadImgs = companyShopManageService
					.gainHeadImgsByCompanyId(companyId);
		} catch (Exception e) {
			logger.error("companyShopManageAction-gainCompanysHeadImgs", e);
		}
		return "gainCompanysHeadImgsSh";
	}
	/**
	 * @Title: gainCompanyGoodsCats
	 * @Description: TODO(获取商家店铺热销品类)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String gainCompanyGoodsCats() {
		// 获取热销品类
		companysGoodsCats = indexFloorService
				.gainCompanyGoodsCatListByCompanyId(companyId);
		return "gainCompanyGoodsCats";
	}

	/**
	 * @Title: toShowComHeadImgPage
	 * @Description: TODO(跳转显示商家店铺头部图片页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String toShowComHeadImgPage() {
		return "toShowComHeadImgPage";
	}
	
	/**
	 * @Title: gainCompanyById
	 * @Description: TODO(根据商家ID查询其详细信息)
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Company 返回类型 
	 * @author wangmei
	 */
	private Company gainCompanyById(String id){
		company = companyInfoService.gainCompanyById(id);
		return company;
	}

	/**
	 * @Title: toShowComProfilePage
	 * @Description: TODO(跳转企业简介页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String toShowComProfilePage() {
		// 获取商家详细信息
		company = gainCompanyById(companyId);
		request.setAttribute("menuId", 1);
		if("1".equals(company.getShCheck())){
			return "toShowComProfilePageSh";
		}else{
			return "toShowComProfilePage";
		}
		
	}

	/**
	 * @Title: toShowComInformationPage
	 * @Description: TODO(跳转企业资讯页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String toShowComInformationListPage() {

		// 获取商家详细信息
		company = gainCompanyById(companyId);
		Pagination pagination = definationPagination(request);

		// 设置每页显示几条数据
		pagination.setRows(10L);

		// 设置总记录数
		pagination.setTotalCount(companyShopManageService
				.gainCompanysInfoListCount(companyId));
		companysInfoList = companyShopManageService.gainCompanysInfoListByPage(
				pagination, companyId);
		request.setAttribute("pagination", pagination);
		request.setAttribute("menuId", 2);
		if("1".equals(company.getShCheck())){
			return "toShowComInformationListPageSh";
		}else{
			return "toShowComInformationListPage";
		}
	}

	/**
	 * @Title: toShowComInformationDetailPage
	 * @Description: TODO(跳转企业资讯详情页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String toShowComInformationDetailPage() {

		// 获取资讯ID
		String id = request.getParameter("id");

		// 根据资讯ID获取当前浏览量
		Integer views = companyShopManageService.gainCompanysInfoById(id)
				.getViews();
		if(null == views || "".equals(views)){
			views = 0;
		}

		// 更新浏览量
		companysInfo = new CompanysInfo();
		companysInfo.setId(id);
		companysInfo.setViews(views + 1);
		companyShopManageService.updateViewsForCompanyInfo(companysInfo);

		// 获取商家详细信息
		company = gainCompanyById(companyId);

		// 根据资讯ID获取资讯详细信息
		companysInfo = companyShopManageService.gainCompanysInfoById(id);
		
		// 获取上一篇
		CompanysInfo c1 = companyShopManageService.gainForAdjacent(id, company.getId(), 1);
		
		// 获取下一篇
		CompanysInfo c2 = companyShopManageService.gainForAdjacent(id, company.getId(), 2);
		if(null!=c1){
			request.setAttribute("c1", c1);
		}else{
			request.setAttribute("c1", companysInfo);
		}
		if(null!=c2){
			request.setAttribute("c2", c2);
		}else{
			request.setAttribute("c2", companysInfo);
		}
		request.setAttribute("menuId", 2);
		
		if("1".equals(company.getShCheck())){
			return "toShowComInformationDetailPageSh";
		}else{
			return "toShowComInformationDetailPage";
		}
	}

	/**
	 * @Title: toShowComGoodsListPage
	 * @Description: TODO(跳转商家主营产品页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String toShowComGoodsListPage() {

		// 获取商家详细信息
		company = gainCompanyById(companyId);
		companysGoodsCats = indexFloorService
				.gainCompanyGoodsCatListByCompanyId(companyId);
		if (null != companysGoodsCats && companysGoodsCats.size() > 0) {
			for (int i = 0; i < companysGoodsCats.size(); i++) {
				CompanysGoodsCat cgc = companysGoodsCats.get(i);
//				List<Goods> list = indexFloorService.gainComGoodsListByCat(
//						companyId, cgc.getGoodsCatId());
//				list = list.subList(0, list.size() > 5 ? 5 : list.size());
//				map.put(cgc.getGoodsCatId(), list);
			}
			for (Entry<String, Object> e : map.entrySet()) {
				comGoodsMap = new HashMap<String, Object>();
				comGoodsMap.put("gid", e.getKey());
				comGoodsMap.put("glist", e.getValue());
				comGoodsMap.put("gname", companyShopManageService
						.gainGoodsCatNameById(e.getKey()));
				comGoodsList.add(comGoodsMap);
			}
		}
		request.setAttribute("menuId", 3);
		if("1".equals(company.getShCheck())){
			return "toShowComGoodsListPageSh";
		}else{
			return "toShowComGoodsListPage";
		}
	}

	/**
	 * @Title: toMoreComGoodsPage
	 * @Description: TODO(商家店铺-主营产品，点击更多)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String toMoreComGoodsPage() {

		// 获取商家详细信息
		company = gainCompanyById(companyId);

		// 获取热销品类
		companysGoodsCats = indexFloorService
				.gainCompanyGoodsCatListByCompanyId(company.getId());

		// 获取商品店铺主营产品某分类下的商品列表
		Pagination pagination = definationPagination(request);

		// 设置每页显示几条数据
		pagination.setRows(20L);

		// 设置总记录数
		pagination.setTotalCount(indexFloorService
				.gainGoodsListCountByCompanyId(company.getId(), goodsCatId));
		goodsListByCom = indexFloorService.gainGoodsListByCompanyIdForPage(
				pagination, company.getId(), goodsCatId);
		goodsCatName = companyShopManageService
				.gainGoodsCatNameById(goodsCatId);
		request.setAttribute("pagination", pagination);
		request.setAttribute("menuId", 3);
		
		if("1".equals(company.getShCheck())){
			return "toMoreComGoodsPageSh";
		}else{
			return "toMoreComGoodsPage";
		}
		
	}

	/**
	 * @Title: toComContactPage
	 * @Description: TODO(商家店铺-跳转联系我们页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String toComContactPage() {
		// 获取商家详细信息
		company = gainCompanyById(companyId);
		request.setAttribute("menuId", 4);
		if("1".equals(company.getShCheck())){
			return "toComContactPageSh";
		}else{
			return "toComContactPage";
		}
		
	}

	/**
	 * @Title: toComMessageListPage
	 * @Description: TODO(商家店铺-跳转客户留言列表页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String toComMessageListPage() {

		// 获取商家详细信息
		company = gainCompanyById(companyId);
		Pagination pagination = definationPagination(request);

		// 设置每页显示几条数据
		pagination.setRows(5L);

		// 设置总记录数
		pagination.setTotalCount(companyShopManageService
				.gainCompanysMessageCount(companyId));
		companysMessageList = companyShopManageService
				.gainCompanysMessageListForPage(pagination, companyId);
		request.setAttribute("pagination", pagination);
		request.setAttribute("menuId", 5);
		if("1".equals(company.getShCheck())){
			return "toComMessageListPageSh";
		}else{
			return "toComMessageListPage";
		}
		
	}

	/**
	 * @Title: toLeaveMessagePage
	 * @Description: TODO(商家店铺-跳转我要留言页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String toLeaveMessagePage() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());// 获取登录人信息
		if (null == sessionInfo) {
			return "login_hf";
		}

		// 获取商家详细信息
		company = gainCompanyById(companyId);
		userType = sessionInfo.getUserType();
		if (Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())) {// 个人
			member = companyShopManageService.gainMemberById(sessionInfo
					.getUserId());
		} else {// 企业
			company = gainCompanyById(sessionInfo.getUserId());
		}
		request.setAttribute("menuId", 5);
		if("1".equals(company.getShCheck())){
			return "toLeaveMessagePageSh";
		}else{
			return "toLeaveMessagePage";
		}
		
	}

	/**
	 * @Title: addCompanysMessage
	 * @Description: TODO(添加留言)
	 * @param
	 * @return void 返回类型
	 * @author wangmei
	 */
	public String addCompanysMessage() {
		companyId = companysMessage.getCompanyId();
		companyShopManageService.addCompanysMessage(companysMessage);
		return "addCompanysMessageOk";
	}
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Goods> getGoodsListByCom() {
		return goodsListByCom;
	}

	public void setGoodsListByCom(List<Goods> goodsListByCom) {
		this.goodsListByCom = goodsListByCom;
	}

	public List<CompanysGoodsCat> getCompanysGoodsCats() {
		return companysGoodsCats;
	}

	public void setCompanysGoodsCats(List<CompanysGoodsCat> companysGoodsCats) {
		this.companysGoodsCats = companysGoodsCats;
	}

	public List<CompanysInfo> getCompanysInfoList() {
		return companysInfoList;
	}

	public void setCompanysInfoList(List<CompanysInfo> companysInfoList) {
		this.companysInfoList = companysInfoList;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public CompanysInfo getCompanysInfo() {
		return companysInfo;
	}

	public void setCompanysInfo(CompanysInfo companysInfo) {
		this.companysInfo = companysInfo;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getComGoodsMap() {
		return comGoodsMap;
	}

	public void setComGoodsMap(Map<String, Object> comGoodsMap) {
		this.comGoodsMap = comGoodsMap;
	}

	public List<Map<String, Object>> getComGoodsList() {
		return comGoodsList;
	}

	public void setComGoodsList(List<Map<String, Object>> comGoodsList) {
		this.comGoodsList = comGoodsList;
	}

	public List<CompanysHeadImg> getCompanysHeadImgs() {
		return companysHeadImgs;
	}

	public void setCompanysHeadImgs(List<CompanysHeadImg> companysHeadImgs) {
		this.companysHeadImgs = companysHeadImgs;
	}

	public String getGoodsCatName() {
		return goodsCatName;
	}

	public void setGoodsCatName(String goodsCatName) {
		this.goodsCatName = goodsCatName;
	}

	public List<CompanysMessage> getCompanysMessageList() {
		return companysMessageList;
	}

	public void setCompanysMessageList(List<CompanysMessage> companysMessageList) {
		this.companysMessageList = companysMessageList;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public CompanysMessage getCompanysMessage() {
		return companysMessage;
	}

	public void setCompanysMessage(CompanysMessage companysMessage) {
		this.companysMessage = companysMessage;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getGoodsCatId() {
		return goodsCatId;
	}

	public void setGoodsCatId(String goodsCatId) {
		this.goodsCatId = goodsCatId;
	}
}