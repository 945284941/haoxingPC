/**
 * 
 */
package com.qlzy.mainPage.head.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.util.PcOrWap;
import com.qlzy.mainPage.indexGoods.service.DictionaryService;
import com.qlzy.mainPage.indexGoods.service.HomeSysService;
import com.qlzy.model.*;
import com.qlzy.pojo.SessionInfo;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.common.tools.URLDecoderTwice;
import com.qlzy.mainPage.company.service.CompanyService;
import com.qlzy.mainPage.floor.action.IndexFloorAction;
import com.qlzy.mainPage.head.service.CatalogueService;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

@Namespace("/")
//命名空间
@Action(value = "catalogueAction", results = {
		@Result(name="toCome",location="/admin/head/warp.jsp"),
		@Result(name="toLunboCome",location="/admin/head/warpMarket.jsp"),
		@Result(name="companyList",location="/admin/head/companyListHead.jsp"),
		@Result(name="fullCategoryList",location="/admin/head/fullCategoryListHead.jsp"),
		@Result(name="marketfullCategoryList",location="/admin/head/marketHead.jsp"),
		@Result(name="toMenu",location="/admin/head/indexMenu.jsp"),
		@Result(name="toMenuWap",location="/wap/index/indexMenu.jsp")
})
/**
* @ClassName: CatalogueAction
* @Description: TODO(主页目录部分)
* @author 赵阳彬
* @date 2013-5-6 上午9:02:36
*/
public class CatalogueAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(IndexFloorAction.class);
	//前台展示所需字段
	private List<GoodsCat> firstGoodsCatList;
	private List<GoodsCat> secondGoodsCatList;
	private List<GoodsCat> fullCategoryList;
	
	private String pid;
	//省份列表
	private List<Regions> provinceList;
	//商城公告列表
	private List<News> gonggaoList;
	
	@Resource
	private CatalogueService catalogueService;
	@Resource
	private HomeSysService homeSysService;
	@Resource
	private RegionsService regionsService;//区域接口类
	@Resource
	private CompanyService companyService;
	@Resource
	private DictionaryService dictionaryService;
	
	private String topSearchLike;//表头查询关键字
	
	private String searchType;//搜索  商品  店铺  咨询
	private String order;// 排序
	private List<Company> companyList;


	//新加
	private List<HomeSys> homeList;//首页轮播图
	private String catType;
	private String lunboType;
	private List<QlDict> dictList;//横批菜单值

	/***
	* @Title: toCome 商城轮播+广告
	* @Description: TODO(进入主页所触发action)
	* @return void    返回类型
	 */
	public String toCome() {
		//商城公告列表
		homeList =catalogueService.gainLunbotuByShop("index_lunbo_pc");
		gonggaoList = catalogueService.gainNewGongGaoList();
		return PcOrWap.isPc(request,"toCome");
	}

	/***
	 * 超市轮播
	 * @return
     */
	public String toLunbo(){
		homeList = catalogueService.gainLunbotuByMarket(lunboType);
		return PcOrWap.isPc(request,"toLunboCome");
	}

	/***
	 * 横批菜单分类
	 * @return
     */
	public String queryFullMenu(){
		dictList  = dictionaryService.selectByType("index_menu");
		Map<String,QlDict> m = new HashMap<>();
		for(QlDict dict:dictList){
			m.put(dict.getId(),dict);
		}
		session.put("hp",m);
		return PcOrWap.isPc(request,"toMenu");
	}
	/**
	 * 查询所有商品分类
	 * @return
	 */
	public String queryFullCategory() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());// 获取登录人信息
		fullCategoryList = catalogueService.queryFullCategory(catType);
		if("gwsc".equals(catType)){//跳转购物商城分类
			return PcOrWap.isPc(request,"fullCategoryList");
		}else if("cs".equals(catType)){//跳转超市分类
			return PcOrWap.isPc(request,"marketfullCategoryList");
		}else if("xsqg".equals(catType) || "tdd".equals(catType) || "qg".equals(catType)){//跳转限时抢购分类 //跳转团多多分类
			checkCurentMenu(sessionInfo,catType);
			return PcOrWap.isPc(request,"marketfullCategoryList");
		}else{
			checkCurentMenu(sessionInfo,catType);
			return PcOrWap.isPc(request,"marketfullCategoryList");
		}

	}

	/***
	 * 检查目前到了哪个目录
	 * @param sessionInfo
	 * @param catType
     */
	public void checkCurentMenu(SessionInfo sessionInfo,String catType){
		Map<String,QlDict> rt = (Map<String, QlDict>) session.get("hp");
		if(null == sessionInfo){
			sessionInfo = new SessionInfo();
		}
		if("zh".equals(sessionInfo.getLanguage())){
			sessionInfo.setCurentMenu(rt.get(catType).getLabel());
		}else{
			sessionInfo.setCurentMenu(rt.get(catType).getLabelEng());
		}
		sessionInfo.setToUrl(rt.get(catType).getValue());


	}
	/***
	* @Title: gainFirstCatalogue
	* @Description: TODO(得到一级目录)
	* @return void    返回类型
	 */
    public void gainFirstCatalogue(){
    	//一级目录参数
    	firstGoodsCatList=catalogueService.gainCatalogueByGrade(Integer.parseInt(pid));
    	writeJson(firstGoodsCatList);
    }
    
    /***
	* @Title: gainSecondCatalogue
	* @Description: TODO(得到二级目录)
	* @param
	* @return void    返回类型
	 */
    public void gainSecondCatalogue(){
    	secondGoodsCatList=catalogueService.gainCatalogueByPid(pid);
    	writeJson(secondGoodsCatList);
    	
    }
    
    
    /***
	* @Title: gainSecondCatalogue
	* @Description: TODO(商家列表)
	* @param
	* @return void    返回类型
	 */
    public String gainCompanyListHead(){
    	Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);

		// 设置每页显示几条数据
		pagination.setRows(6L);
		if(null!=topSearchLike){
		request.setAttribute("topSearchLike",URLDecoderTwice.decoder(topSearchLike));
		map.put("topSearchLike", URLDecoderTwice.decoder(topSearchLike));
		}
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		try {
			if (null == order || "".equals(order)) {
				order = "desc";
			}
			map.put("order", order);
			pagination.setTotalCount(companyService
					.gainCompanyListHeadCount(map));

			// 获取区域商家列表
			companyList = companyService.gainCompanyListHead(map);
			request.setAttribute("pagination", pagination);
		} catch (Exception e) {
			logger.error("gainCompanyListHead", e);
			e.printStackTrace();
		}
		return "companyList";
    	
    }
    
    public List<GoodsCat> getFirstGoodsCatList() {
		return firstGoodsCatList;
	}
	public void setFirstGoodsCatList(List<GoodsCat> firstGoodsCatList) {
		this.firstGoodsCatList = firstGoodsCatList;
	}
	public List<GoodsCat> getSecondGoodsCatList() {
		return secondGoodsCatList;
	}
	public void setSecondGoodsCatList(List<GoodsCat> secondGoodsCatList) {
		this.secondGoodsCatList = secondGoodsCatList;
	}
	
	public List<GoodsCat> getFullCategoryList() {
		return fullCategoryList;
	}
	public void setFullCategoryList(List<GoodsCat> fullCategoryList) {
		this.fullCategoryList = fullCategoryList;
	}

	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public CatalogueService getCatalogueService() {
		return catalogueService;
	}
	public void setCatalogueService(CatalogueService catalogueService) {
		this.catalogueService = catalogueService;
	}
	public List<Regions> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<Regions> provinceList) {
		this.provinceList = provinceList;
	}
	public RegionsService getRegionsService() {
		return regionsService;
	}
	public void setRegionsService(RegionsService regionsService) {
		this.regionsService = regionsService;
	}
	public List<News> getGonggaoList() {
		return gonggaoList;
	}
	public void setGonggaoList(List<News> gonggaoList) {
		this.gonggaoList = gonggaoList;
	}
	public String getTopSearchLike() {
		return topSearchLike;
	}
	public void setTopSearchLike(String topSearchLike) {
		this.topSearchLike = topSearchLike;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public List<Company> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public List<HomeSys> getHomeList() {
		return homeList;
	}
	public void setHomeList(List<HomeSys> homeList) {
		this.homeList = homeList;
	}

	public String getCatType() {
		return catType;
	}

	public void setCatType(String catType) {
		this.catType = catType;
	}

	public List<QlDict> getDictList() {
		return dictList;
	}

	public void setDictList(List<QlDict> dictList) {
		this.dictList = dictList;
	}

	public String getLunboType() {
		return lunboType;
	}

	public void setLunboType(String lunboType) {
		this.lunboType = lunboType;
	}
}
