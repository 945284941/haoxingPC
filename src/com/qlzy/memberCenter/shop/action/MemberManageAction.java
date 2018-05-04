package com.qlzy.memberCenter.shop.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.common.tools.FtpUtil;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.mainPage.floor.service.IndexFloorService;
import com.qlzy.memberCenter.shop.service.MemberManageService;
import com.qlzy.model.Company;
import com.qlzy.model.CompanySys;
import com.qlzy.model.CompanysGoodsCat;
import com.qlzy.model.CompanysHeadImg;
import com.qlzy.model.CompanysInfo;
import com.qlzy.model.CompanysMessage;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

/**
 * @ClassName: MemberManage
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhaoyangbin
 * @date 2013-8-14 下午4:08:29
 *
 */
@Namespace("/")
@Action(value = "memberManageAction", results = {
		@Result(name = "toGoodsCatList",location = "/memberCenter/company/shop/storeManage/goodsCatList.jsp"  ),
		@Result(name = "toGoodsCat", type="redirect" ,location = "memberManageGoodsCat.html"  ),
		@Result(name = "toMemberInoformation", location = "/memberCenter/company/shop/storeManage/companyInformation.jsp"),
		@Result(name = "toMemberInoformationAct",type="redirect" ,location = "memberManageInoformation.html"  ),
		@Result(name = "toHeadImg", location = "/memberCenter/company/shop/storeManage/companyHeadImg.jsp"),
		@Result(name = "toCompanySys", location = "/memberCenter/company/shop/storeManage/companySysList.jsp"),
		@Result(name = "headAct", type="redirect" ,location = "memberManageHeadImg.html"),
		@Result(name = "companySysAct", type="redirect" ,location = "toCompanySys.html"),
		@Result(name = "toCompanyInfo", location = "/memberCenter/company/shop/storeManage/companyInfo.jsp"),
		@Result(name = "toCompanyInfoList",type="redirect" , location = "memberManageCompanyInfo.html"),
		@Result(name = "toAddCompanyInfo", location = "/memberCenter/company/shop/storeManage/addCompanyInfo.jsp"),
		@Result(name = "toCust", location = "/memberCenter/company/shop/storeManage/customerMessageList.jsp"),
		@Result(name = "toUpdateCompanyInfo", location = "/memberCenter/company/shop/storeManage/editCompanyInfo.jsp")
})
public class MemberManageAction extends BaseAction  {
	private static final long serialVersionUID = 1L;

	private List<CompanysGoodsCat> companysGoodsCats ;
	private List<CompanysHeadImg>  companysHeadImgs ;
	private List<CompanySys>  companySys ;
	private List<CompanysMessage> companysMessages;
	private List<CompanysInfo> companysInfos;
	private String id;//传递id参数
	private Long goodsNum;//商品数目
	private String goodsCatId;//商品分类id
	private String porderNum;//分类排序
	private CompanysHeadImg companysHeadImg;
	private CompanySys companySy;
	private Company company;
	private CompanysMessage companyMessage = new CompanysMessage();// 留言实体类;
	private CompanysInfo companysInfo;
	private String selGoodsCatId;//跳转前端页面所需参数
	private String companyInfoIds;//批量删除
	private SessionInfo sessionInfo;
	@Resource
	private MemberManageService memberManageService;
	@Resource
	private IndexFloorService indexFloorService;
	
	
	/**
	 * @Title: gainGoodsCatList
	 * @Description: TODO(店铺分类列表)
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public String gainGoodsCatList() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		companysGoodsCats=memberManageService.gainGoodsCatList(sessionInfo.getUserId());
		return "toGoodsCatList";
	}
	/**
	 * @Title: dropById
	 * @Description: TODO(删除店铺分类)
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public void dropById() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("id",id);
		map.put("goodsCatId",goodsCatId);
		map.put("memberId", sessionInfo.getUserId());
		goodsNum = memberManageService.dropById(map);
		writeJson(goodsNum);
	}
	/**
	 * @Title: updatePorderById
	 * @Description: TODO(更新排序)
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public void updatePorderById (){
		Map<String , Object> map = new HashMap<String,Object>();
		map.put("id",id);
		map.put("porderNum",porderNum);
		memberManageService.updateGoodsCat(map);
	}
	/**
	 * @Title: addCompanyCat
	 * @Description: TODO(添加店铺分类)
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public String  addCompanyCat (){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		memberManageService.addCompanyCat(goodsCatId,sessionInfo.getUserId());
		return "toGoodsCat";
	}
	/**
	 * @Title: gainGoodsCatList
	 * @Description: TODO(得到店铺分类不存在的商品分类)
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public void  gainGoodsCatListShop (){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		companysGoodsCats = memberManageService.gainGoodsCatListShop(sessionInfo.getUserId());
	    writeJson(companysGoodsCats);
	}
	
	/**
	 * @Title: toMemberInoformation
	 * @Description: TODO(进入店铺简介界面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public String  toMemberInoformation (){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		company = memberManageService.gainCompanyById(sessionInfo.getUserId());
		return "toMemberInoformation";
	}
	/**
	 * @Title: updateMemberInoformation
	 * @Description: TODO(更新企业简介)
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public String  updateMemberInoformation (){
		memberManageService.updateMemberInoformation(company);
		return "toMemberInoformationAct";
	}
	/**
	 * @Title: toAdver
	 * @Description: TODO(进入广告管理界面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public String  toHeadImg (){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		companysHeadImgs=memberManageService.gainCompanysHeadImg(sessionInfo.getUserId());
		return "toHeadImg";
	}
	/**
	 * @Title: toAdver
	 * @Description: TODO(进入首页管理界面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public String  toCompanySys (){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		companySys=memberManageService.gainCompanySys(sessionInfo.getUserId());
		return "toCompanySys";
	}
	/**
	 * @Title: uploadAdverImg
	 * @Description: TODO(广告管理上传图片)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String  uploadAdverImg (){
		if (companysHeadImg.getMyFile() != null ) {
			FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
			ftp.connectServer();
			String extName = companysHeadImg.getMyFileFileName().substring(companysHeadImg.getMyFileFileName().lastIndexOf(".")+ 1).toLowerCase();//扩展名
			String savePath=ResourceUtil.getCompany_Head_Img_Directory ();
			String saveUrl=ResourceUtil.getWebPath()+savePath;
			if(!ftp.isDirExist(savePath)){
				ftp.createDir(savePath);
			}
			ftp.cd(savePath);
			String newFileName = UUID.randomUUID().toString().replaceAll("-", "")+ "." + extName;
			if (!Arrays.<String> asList(
					ResourceUtil.getImage_Ext().split(",")).contains(
							extName)) {
				
			}
			ftp.upload(companysHeadImg.getMyFile().getPath(),newFileName);
			ftp.closeServer();
			companysHeadImg.setImgSrc(saveUrl+newFileName);
			memberManageService.updateHeadImg(companysHeadImg);
		}
		return "headAct";
	}
	/**
	 * @Title: uploadAdverImg
	 * @Description: TODO(广告管理上传图片)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String  uploadCompanySys (){
		if (companySy.getMyFile() != null ) {
			FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
			ftp.connectServer();
			String extName = companySy.getMyFileFileName().substring(companySy.getMyFileFileName().lastIndexOf(".")+ 1).toLowerCase();//扩展名
			String savePath=ResourceUtil.getCompany_Head_Img_Directory ();
			String saveUrl=ResourceUtil.getWebPath()+savePath;
			if(!ftp.isDirExist(savePath)){
				ftp.createDir(savePath);
			}
			ftp.cd(savePath);
			String newFileName = UUID.randomUUID().toString().replaceAll("-", "")+ "." + extName;
			if (!Arrays.<String> asList(
					ResourceUtil.getImage_Ext().split(",")).contains(
							extName)) {
				
			}
			ftp.upload(companySy.getMyFile().getPath(),newFileName);
			ftp.closeServer();
			companySy.setImageUrl(saveUrl+newFileName);
		}
		memberManageService.updateCompanySy(companySy);
		return "companySysAct";
	}
	
	/**
	 * @Title: deleteHeadImg
	 * @Description: TODO(商铺顶端图片删除)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String  deleteHeadImg (){
		memberManageService.deleteHeadImg(companysHeadImg);
		return "headAct";
	}
	
	/**
	 * @Title: deleteHeadImg
	 * @Description: TODO(商铺顶端图片删除)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String  deleteCompanySys (){
		memberManageService.deleteCompanySys(companySy);
		return "companySysAct";
	}
	
/**
 * @Title: toCustomerMessage
 * @Description: TODO(进入客户留言列表)
 * @param @return 设定文件
 * @return  返回类型
 */

	public String  gainCustomerMessage (){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(2L);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		if(null!=companyMessage.getBaseKey()  && !"".equals(companyMessage.getBaseKey())){
			map.put("baseKey", companyMessage.getBaseKey().trim());
		}
		if(null!=companyMessage.getTimeRange()  && !"".equals(companyMessage.getTimeRange())){
			map.put("timeRange", companyMessage.getTimeRange());
		}
		map.put("companyId", sessionInfo.getUserId());
		// 设置总记录数
		pagination.setTotalCount(memberManageService.gainCompanyMessageListByIdCount(map));
		companysMessages=memberManageService.gainCompanyMessageListById(map);
		request.setAttribute("pagination", pagination);
		return "toCust";
	}
	/**
	 * @Title: gainCustomerMessageById
	 * @Description: TODO(得到客户留言详细信息)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String  gainCustomerMessageById (){
		companyMessage=memberManageService.gainCustomerMessageById(companyMessage.getId());
		return "toGoodsCatList";
	}
	/**
	 * @Title: gainCompanyInfoList
	 * @Description: TODO(店铺咨询)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String  gainCompanyInfoList (){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(2L);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		map.put("companyId", sessionInfo.getUserId());
		if(null!=companysInfo.getBaseKey()  && !"".equals(companysInfo.getBaseKey())){
			map.put("baseKey", companysInfo.getBaseKey().trim());
		}
		if(null!=companysInfo.getTimeRange()  && !"".equals(companysInfo.getTimeRange())){
			map.put("timeRange", companysInfo.getTimeRange());
		}
		pagination.setTotalCount(memberManageService.gainCompanyInfoListCount(map));
		companysInfos=memberManageService.gainCompanyInfoList(map);
		request.setAttribute("pagination", pagination);
		//预览跳转页面需带参数
				company = indexFloorService.gainCompanyById((String) map.get("companyId"));
		return "toCompanyInfo";
	}
	
	/**
	 * @Title: gainCompanyInfoList
	 * @Description: TODO(店铺咨询)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String  toCompanyInfoList (){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		// 获取商家详细信息
		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(2L);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		map.put("companyId", sessionInfo.getUserId());
		// 设置总记录数
		pagination.setTotalCount(memberManageService.gainCompanyInfoListCount(map));
		companysInfos=memberManageService.gainCompanyInfoList(map);
		request.setAttribute("pagination", pagination);
		//预览跳转页面需带参数
		company = indexFloorService.gainCompanyById((String) map.get("companyId"));
		// 获取热销品类
					companysGoodsCats = indexFloorService
							.gainCompanyGoodsCatListByCompanyId(company.getId());
					if (null == selGoodsCatId) {
						if (companysGoodsCats != null && companysGoodsCats.size() > 0) {
							for (int i = 0; i < companysGoodsCats.size(); i++) {
								CompanysGoodsCat cgc = companysGoodsCats.get(0);
//								selGoodsCatId = cgc.getGoodsCatId();
							}
						} else {
							selGoodsCatId = "null";
						}
					}
		return "toCompanyInfo";
	}
	
	/**
	 * @Title: toAddCompanyInfo
	 * @Description: TODO(店铺咨询)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String  toAddCompanyInfo (){
	
		return "toAddCompanyInfo";
	}
	/**
	 * @Title: addCompanyInfo
	 * @Description: TODO(店铺咨询)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String addCompanyInfo (){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		companysInfo.setCompanyId(sessionInfo.getUserId());//用户id
		memberManageService.addCompanyInfo(companysInfo);
		return "toCompanyInfoList";
	}
	/**
	 * @Title: addCompanyInfo
	 * @Description: TODO(进入店铺更细)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String  toUpdateCompanyInfo(){
		companysInfo=memberManageService.gainCompanyInfoById(company.getId());
		return "toUpdateCompanyInfo";
	}
	/**
	 * @Title: addCompanyInfo
	 * @Description: TODO(进入店铺更细)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String updateCompanyInfo (){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		memberManageService.updateCompanyInfo(companysInfo);
		return "toCompanyInfoList";
	}
	/**
	 * @Title: deleteCompanyInfoList
	 * @Description: TODO(进入店铺更细)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public String deleteCompanyInfoList(){
		memberManageService.deleteCompanyInfoList(companyInfoIds);
		return "toCompanyInfoList";
	}
	/**
	 * @Title: deleteCompanyInfoList
	 * @Description: TODO(根据id查找企业信息)
	 * @param @return 设定文件
	 * @return  返回类型
	 */
	public void gainCompanyById(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		company = memberManageService.gainCompanyById(sessionInfo.getUserId());
		writeJson(company);
	}
	public List<CompanysGoodsCat> getCompanysGoodsCats() {
		return companysGoodsCats;
	}
	public void setCompanysGoodsCats(List<CompanysGoodsCat> companysGoodsCats) {
		this.companysGoodsCats = companysGoodsCats;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Long goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsCatId() {
		return goodsCatId;
	}

	public void setGoodsCatId(String goodsCatId) {
		this.goodsCatId = goodsCatId;
	}
	public String getPorderNum() {
		return porderNum;
	}
	public void setPorderNum(String porderNum) {
		this.porderNum = porderNum;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<CompanysHeadImg> getCompanysHeadImgs() {
		return companysHeadImgs;
	}
	public void setCompanysHeadImgs(List<CompanysHeadImg> companysHeadImgs) {
		this.companysHeadImgs = companysHeadImgs;
	}
	public CompanysHeadImg getCompanysHeadImg() {
		return companysHeadImg;
	}
	public void setCompanysHeadImg(CompanysHeadImg companysHeadImg) {
		this.companysHeadImg = companysHeadImg;
	}
	public List<CompanysMessage> getCompanysMessages() {
		return companysMessages;
	}
	public void setCompanysMessages(List<CompanysMessage> companysMessages) {
		this.companysMessages = companysMessages;
	}
	public CompanysMessage getCompanyMessage() {
		return companyMessage;
	}
	public void setCompanyMessage(CompanysMessage companyMessage) {
		this.companyMessage = companyMessage;
	}
	public CompanysInfo getCompanysInfo() {
		return companysInfo;
	}
	public void setCompanysInfo(CompanysInfo companysInfo) {
		this.companysInfo = companysInfo;
	}
	public List<CompanysInfo> getCompanysInfos() {
		return companysInfos;
	}
	public void setCompanysInfos(List<CompanysInfo> companysInfos) {
		this.companysInfos = companysInfos;
	}
	public String getSelGoodsCatId() {
		return selGoodsCatId;
	}
	public void setSelGoodsCatId(String selGoodsCatId) {
		this.selGoodsCatId = selGoodsCatId;
	}
	public String getCompanyInfoIds() {
		return companyInfoIds;
	}
	public void setCompanyInfoIds(String companyInfoIds) {
		this.companyInfoIds = companyInfoIds;
	}
	public List<CompanySys> getCompanySys() {
		return companySys;
	}
	public void setCompanySys(List<CompanySys> companySys) {
		this.companySys = companySys;
	}
	public CompanySys getCompanySy() {
		return companySy;
	}
	public void setCompanySy(CompanySys companySy) {
		this.companySy = companySy;
	}
	

}
