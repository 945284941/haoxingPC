/**  
 * @Title: IndexFloorAction.java 
 * @Package com.qlzy.mainPage.action 
 * @Description: TODO(首页1F-7F)
 * @author wangmei  
 * @date 2013-5-7 下午3:02:35
 * @version V1.0  
 */
package com.qlzy.mainPage.floor.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qlzy.common.util.PcOrWap;
import com.qlzy.mainPage.country.service.NCountryService;
import com.qlzy.mainPage.head.service.CatalogueService;
import com.qlzy.mainPage.indexGoods.service.DictionaryService;
import com.qlzy.mainPage.indexGoods.service.HomeSysService;
import com.qlzy.mainPage.want.service.WantBuyService;
import com.qlzy.memberCenter.goods.service.GoodsService;
import com.qlzy.model.*;
import com.qlzy.util.Pagination;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.floor.service.IndexFloorService;
import com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService;
import com.qlzy.memberCenter.shop.service.CompanyShopManageService;
import com.qlzy.memberCenter.shop.service.MemberManageService;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;


@Namespace("/indexFloor")
@Action(value = "indexFloorAction", results = {
		@Result(name = "showIndexShoppingFloor", location = "/admin/floor/shoppingIndex.jsp"),
        @Result(name = "showIndexShoppingFloorWap", location = "/wap/index/indexGong.jsp"),
		@Result(name = "showIndexMarketOrBuildFloor", location = "/admin/floor/marketIndex.jsp"),
		@Result(name = "toComShopManagerForVip", location = "/memberCenter/company/shop/front/index.jsp"),
		@Result(name = "tofoot", location = "/admin/common/indexFooter.jsp"),
		@Result(name = "toSimplifyFoot", location = "/admin/floor/floor.jsp"),
		@Result(name = "toMarket", location = "/market.jsp"),
		@Result(name = "toBuild", location = "/building.jsp"),
		@Result(name = "toGroup", location = "/group.jsp"),
		@Result(name = "toflashSale", location = "/flashSale.jsp"),
		@Result(name = "toWantBuy", location = "/wantBuy.jsp"),
		@Result(name = "toSecondHand", location = "/secondHand.jsp"),
		@Result(name = "showIndexFlashSaleFloor", location = "/admin/floor/flashSaleIndex.jsp"),
		@Result(name = "showIndexGroupFloor", location = "/admin/floor/groupIndex.jsp"),
		@Result(name = "showIndexBkFloor", location = "/admin/floor/bkByIndex.jsp"),
		@Result(name = "showIndexWantBuyFloor", location = "/admin/floor/wantByIndex.jsp"),
		@Result(name = "showIndexSecondHandFloor", location = "/admin/floor/handByIndex.jsp")
})
public class IndexFloorAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(IndexFloorAction.class);

	@Resource
	private IndexFloorService indexFloorService;
	@Resource
	private MemberManageService memberManageService;
	@Resource
	private MemberCollectService memberCollectService;
	@Resource
	private CompanyShopManageService companyShopManageService;
	@Resource
	private CatalogueService catalogueService;
	@Resource
	private DictionaryService dictionaryService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private HomeSysService homeSysService;
	@Resource
	private WantBuyService wantBuyService;
	@Resource
	private NCountryService nCountryService;

	public List<CompanysHeadImg> getCompanysHeadImgs() {
		return companysHeadImgs;
	}
	public void setCompanysHeadImgs(List<CompanysHeadImg> companysHeadImgs) {
		this.companysHeadImgs = companysHeadImgs;
	}
	Map<String,HomeSys> mapList = new HashMap<String, HomeSys>();
	private List<CompanysHeadImg> companysHeadImgs = new ArrayList<CompanysHeadImg>();// 商家店铺头部广告列表
	private List<HomeSys> homeList;
	private String searchType;//搜索类型
	private String topSearchLike;//搜索条件
	private String companyId;// 商家ID
	private List<CompanySys> companySys;
	
	private GoodsHot goodsHot;
	//商城公告列表
	private List<News> gonggaoList;
	Map<String,CompanySys> cmp = new HashMap<String, CompanySys>();
	//汇率信息
	Map<String,Double> huilvMap = new HashMap<>();
	private List<Goods> flashSaleGoodsList;//首页限时抢购
	private Map<String,HomeSys> adMap;//首页广告位图片
	private List<Goods> shoppingGoodsList;//首页推荐商品
	private List<Goods> marketGoodsList;//超市首页推荐商品
	private String showType;
	private List<WantBuy> wantBuyList;//求购列表信息
	private List<GoodsCat> shopOneCatList;//商城一级分类
	private List<NCountry> countryList;//查询国家
	private WantBuy wantBuy;//求购信息
	private String buyType;




	/***
	 * 跳转商城首页底部
	 * @return
	 */
	public String showFoot(){
		return PcOrWap.isPc(request,"tofoot");
	}

	/***
	 * 跳转普通底部
	 * @return
	 */
	public String toSimplifyFoot(){
		return PcOrWap.isPc(request,"toSimplifyFoot");
	}

	/***
	 * 跳转超市首页
	 * @return
	 */
	public String toMarket(){
		return PcOrWap.isPc(request,"toMarket");
	}

	/***
	 * 跳转 建材设备
	 * @return
	 */
	public String toBuild(){
		return PcOrWap.isPc(request,"toBuild");
	}

	/***
	 * 跳转限时抢购首页
	 * @return
	 */
	public String toFlashSale(){
		return PcOrWap.isPc(request,"toflashSale");
	}

	/***
	 * 跳转团多多
	 * @return
	 */
	public String toGroup(){
		return PcOrWap.isPc(request,"toGroup");
	}

	/***
	 * 跳转求购
	 * @return
	 */
	public String toWantBuy(){
		return PcOrWap.isPc(request,"toWantBuy");
	}

	/**
	 * @Title: 商城首页展示
	 * @Description: TODO(首页显示)
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public String showIndexShoppingFloor() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());// 获取登录人信息
		huilvMap = dictionaryService.selectByHvType("hv_type");
		session.put("huilv",huilvMap);//添加汇率
		//session.put("huilv",huilvMap);//添加当前国家
		try {
			Map<String,Object> flashParmMap  = new HashMap<>();
			flashParmMap.put("isFlashSale","1");
			flashParmMap.put("limitNum",ResourceUtil.getFlashSaleIndexNum());
			flashParmMap.put("isSort","0");
			nCountryService.checkAddressId(request,flashParmMap,session,sessionInfo,"1");
			//查询首页限时抢购商品 按照更新时间排序
			flashSaleGoodsList = goodsService.selectGoodsByType(flashParmMap);
			//查询首页推荐商品 按照平台管理员操作时间排序
			Map<String,Object> indexParmMap = new HashMap<>();
			indexParmMap.put("isIndexShop","1");
			indexParmMap.put("limitNum",ResourceUtil.getShoppingIndexNum());
			indexParmMap.put("isSort","1");
			nCountryService.checkAddressId(request,indexParmMap,session,sessionInfo,"1");
			shoppingGoodsList = goodsService.selectGoodsByType(indexParmMap);
			indexParmMap = new HashMap<>();
			indexParmMap.put("type",showType);
			nCountryService.checkAddressId(request,indexParmMap,session,sessionInfo,"1");
			//查询首页广告位
			List<HomeSys> adList = homeSysService.selectByType(indexParmMap);
			adMap = new HashMap<>();
			for(HomeSys homeSys:adList){
				adMap.put(homeSys.getPosition(),homeSys);
			}
			//查询首页公告
			gonggaoList = catalogueService.gainNewGongGaoList();
		} catch (Exception e) {
			logger.error("showIndexShoppingFloor", e);
			e.printStackTrace();
		}

		return PcOrWap.isPc(request,"showIndexShoppingFloor");
	}

	/***
	 * 超市、装饰建材  超市装饰建材的首页推荐商品
	 * @return
     */
	public String showIndexMarketOrBuildFloor() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());// 获取登录人信息
		Pagination pagination = definationPagination(request);
		pagination.setRows(8L);//设置每页显示几条数据
		huilvMap = dictionaryService.selectByHvType("hv_type");
		session.put("huilv",huilvMap);
		try {
			Map<String,Object> parmMap  = new HashMap<>();
			parmMap.put(showType,"1");
			parmMap.put("isSort","1");
			nCountryService.checkAddressId(request,parmMap,session,sessionInfo,"1");
			Long count = goodsService.selectGoodsByTypeAndPageCount(parmMap);
			pagination.setTotalCount(count);
			parmMap.put("rows", pagination.getRows());
			parmMap.put("page", (pagination.getPage()-1)*pagination.getRows());
			marketGoodsList = goodsService.selectGoodsByTypeAndPage(parmMap);
			request.setAttribute("pagination", pagination);
		} catch (Exception e) {
			logger.error("showIndexMarketOrBuildFloor", e);
			e.printStackTrace();
		}
		return PcOrWap.isPc(request,"showIndexMarketOrBuildFloor");
	}


	/***
	 * 限时抢购首页 按照销量排序
	 * @return
     */
	public String showIndexFlashSaleFloor(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());// 获取登录人信息
		Pagination pagination = definationPagination(request);
		pagination.setRows(6L);//设置每页显示几条数据
		try {
			Map<String,Object> parmMap  = new HashMap<>();
			parmMap.put("isFlashSale","1");
			nCountryService.checkAddressId(request,parmMap,session,sessionInfo,"1");
			Long count = goodsService.selectGoodsByTypeAndPageCount(parmMap);
			pagination.setTotalCount(count);
			parmMap.put("rows", pagination.getRows());
			parmMap.put("page", (pagination.getPage()-1)*pagination.getRows());
			parmMap.put("isSort","2");
			marketGoodsList = goodsService.selectGoodsByTypeAndPage(parmMap);
 			request.setAttribute("pagination", pagination);
		} catch (Exception e) {
			logger.error("showIndexFlashSaleFloor", e);
			e.printStackTrace();
		}
		return PcOrWap.isPc(request,"showIndexFlashSaleFloor");
	}

	/***
	 * 团多多首页 按照销量排序
	 * @return
	 */
	public String showIndexGroupFloor(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());// 获取登录人信息
		Pagination pagination = definationPagination(request);
		pagination.setRows(1L);//设置每页显示几条数据
		try {
			Map<String,Object> parmMap  = new HashMap<>();
			parmMap.put("isGroup","1");
			nCountryService.checkAddressId(request,parmMap,session,sessionInfo,"1");
			Long count = goodsService.selectGoodsByTypeAndPageCount(parmMap);
			pagination.setTotalCount(count);
			parmMap.put("rows", pagination.getRows());
			parmMap.put("page", (pagination.getPage()-1)*pagination.getRows());
			parmMap.put("isSort","2");
			marketGoodsList = goodsService.selectGoodsByTypeAndPage(parmMap);
			request.setAttribute("pagination", pagination);
		} catch (Exception e) {
			logger.error("showIndexGroupFloor", e);
			e.printStackTrace();
		}
		return PcOrWap.isPc(request,"showIndexGroupFloor");
	}

	/***
	 * 求购首页
	 * @return
	 */
	public String showIndexWantBuyFloor(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());// 获取登录人信息
		//查询商城的一级分类
		Map<String,String> shopMap = new HashMap<>();
		shopMap.put("pid",ResourceUtil.getShoppingId());
		shopOneCatList = catalogueService.gainCatalogueByPidAndSort(shopMap);
		if(null != wantBuy && !"".equals(wantBuy.getBuyType()) && ("3".equals(wantBuy.getBuyType()) || "4".equals(wantBuy.getBuyType()))){
			//查询国家
			countryList = nCountryService.gainNCountry();
		}
		Pagination pagination = definationPagination(request);
		pagination.setRows(6L);//设置每页显示几条数据
		try {
			Map<String,Object> parmMap  = new HashMap<>();
			nCountryService.checkAddressId(request,parmMap,session,sessionInfo,"2");
//			parmMap.put("fromCountryId",sessionInfo.getAddressMap().get("addressId"));
			if(null != wantBuy){
				if(!"".equals(wantBuy.getCatId())){
					parmMap.put("catId",wantBuy.getCatId());
				}

				if(!"".equals(wantBuy.getBuyType())){
					parmMap.put("buyType",wantBuy.getBuyType());
					if("3".equals(wantBuy.getBuyType())){
						if(!"".equals(wantBuy.getToCountryId())){
							parmMap.put("toCountryId",wantBuy.getToCountryId());
						}
					}
				}else{
					wantBuy.setBuyType("1");
					parmMap.put("buyType","1");
				}

			}else{
				wantBuy = new WantBuy();
				wantBuy.setBuyType("1");
				parmMap.put("buyType","1");
			}
			Long count = wantBuyService.gainWantBuyPageCount(parmMap);
			pagination.setTotalCount(count);
			parmMap.put("rows", pagination.getRows());
			parmMap.put("page", (pagination.getPage()-1)*pagination.getRows());
			wantBuyList = wantBuyService.gainWantBuyPage(parmMap);
			request.setAttribute("pagination", pagination);
		} catch (Exception e) {
			logger.error("showIndexWantBuyFloor", e);
			e.printStackTrace();
		}
		return PcOrWap.isPc(request,"showIndexWantBuyFloor");
	}
public String toComShopManagerPage() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());// 获取登录人信息
		if (sessionInfo != null && sessionInfo.getUserId() != null && !"".equals(sessionInfo.getUserId())) {
			//插入浏览记录
			Views views = new Views();
			views.setId(ToolsUtil.getUUID());
			views.setUserId(sessionInfo.getUserId());
			views.setViewId(companyId);
			views.setCreatetime(new Date());
			views.setType("shop");
			memberCollectService.insetMemberViews(views);
		}
		companySys = memberManageService.gainCompanySys(companyId);
		companysHeadImgs = companyShopManageService
				.gainHeadImgsByCompanyId(companyId);
		for (int i = 0; i < companySys.size(); i++) {
			cmp.put("cmp_"+i, companySys.get(i));
		}
				return "toComShopManagerForVip";
	}
	
	public List<HomeSys> getHomeList() {
		return homeList;
	}

	public void setHomeList(List<HomeSys> homeList) {
		this.homeList = homeList;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getTopSearchLike() {
		return topSearchLike;
	}

	public void setTopSearchLike(String topSearchLike) {
		this.topSearchLike = topSearchLike;
	}

	public Map<String, HomeSys> getMapList() {
		return mapList;
	}

	public void setMapList(Map<String, HomeSys> mapList) {
		this.mapList = mapList;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public List<CompanySys> getCompanySys() {
		return companySys;
	}
	public void setCompanySys(List<CompanySys> companySys) {
		this.companySys = companySys;
	}
	public Map<String, CompanySys> getCmp() {
		return cmp;
	}
	public void setCmp(Map<String, CompanySys> cmp) {
		this.cmp = cmp;
	}
	public GoodsHot getGoodsHot() {
		return goodsHot;
	}
	public void setGoodsHot(GoodsHot goodsHot) {
		this.goodsHot = goodsHot;
	}

	public List<News> getGonggaoList() {
		return gonggaoList;
	}

	public void setGonggaoList(List<News> gonggaoList) {
		this.gonggaoList = gonggaoList;
	}

	public List<Goods> getFlashSaleGoodsList() {
		return flashSaleGoodsList;
	}

	public void setFlashSaleGoodsList(List<Goods> flashSaleGoodsList) {
		this.flashSaleGoodsList = flashSaleGoodsList;
	}

	public List<Goods> getShoppingGoodsList() {
		return shoppingGoodsList;
	}

	public void setShoppingGoodsList(List<Goods> shoppingGoodsList) {
		this.shoppingGoodsList = shoppingGoodsList;
	}

	public List<Goods> getMarketGoodsList() {
		return marketGoodsList;
	}

	public void setMarketGoodsList(List<Goods> marketGoodsList) {
		this.marketGoodsList = marketGoodsList;
	}

	public Map<String, HomeSys> getAdMap() {
		return adMap;
	}

	public void setAdMap(Map<String, HomeSys> adMap) {
		this.adMap = adMap;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public List<WantBuy> getWantBuyList() {
		return wantBuyList;
	}

	public void setWantBuyList(List<WantBuy> wantBuyList) {
		this.wantBuyList = wantBuyList;
	}

	public List<GoodsCat> getShopOneCatList() {
		return shopOneCatList;
	}

	public void setShopOneCatList(List<GoodsCat> shopOneCatList) {
		this.shopOneCatList = shopOneCatList;
	}

	public List<NCountry> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<NCountry> countryList) {
		this.countryList = countryList;
	}

	public WantBuy getWantBuy() {
		return wantBuy;
	}

	public void setWantBuy(WantBuy wantBuy) {
		this.wantBuy = wantBuy;
	}

	public String getBuyType() {
		return buyType;
	}

	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}
}
