/**  
* @Title: searchGoodsAction.java
* @Package com.qlzy.searchGoods.action
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com  
* @date 2013-5-21 下午3:47:14
* @version V1.0  
*/
package com.qlzy.searchGoods.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.mainPage.floor.service.IndexFloorService;
import com.qlzy.mainPage.head.service.CatalogueService;
import com.qlzy.mainPage.indexGoods.service.IndexGoodsService;
import com.qlzy.mainPage.regions.service.RegionsService;
import com.qlzy.memberCenter.goods.service.GoodsService;
import com.qlzy.model.CarBrand;
import com.qlzy.model.Goods;
import com.qlzy.model.GoodsCat;
import com.qlzy.model.GoodsDetail;
import com.qlzy.model.GoodsSpecification;
import com.qlzy.model.HomeSys;
import com.qlzy.model.News;
import com.qlzy.model.Regions;
import com.qlzy.searchGoods.service.SearchGoodsService;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;


@Namespace("/")
//命名空间
@Action(value = "searchGoodsAction", results = {
		@Result(name="toMarket",location="/market.jsp"),
		@Result(name="toList",location="/admin/goods/goodsList.jsp"),
		@Result(name="toHcList",location="/admin/goods/goodsHcList.jsp"),
		@Result(name="toTemaiList",location="/admin/cuxiao/cuxiao.jsp"),
		@Result(name="toShList",location="/shanghui/goods/searchGoods.jsp"),
		@Result(name="firstList",location="/admin/head/catalogue.jsp"),
		@Result(name = "dianpu", type = "redirect",location = "gainCompanyListHead.html?searchType=${searchType}&topSearchLike=${topSearchLike}"),
		@Result(name = "zixun", type = "redirect",location = "/news/searchAllNews.html?searchType=${searchType}&topSearchLike=${topSearchLike}")
		})
/**
 * @ClassName: searchGoodsAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author A18ccms a18ccms_gmail_com
 * @date 2013-5-21 下午3:47:14
 *
 */
public class SearchGoodsAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private GoodsService goodsService;
	/***
	* @Title: searchGoods
	* @Description: TODO(根据查询条件得到列表)
	* @param     设定文件
	* @return void    返回类型
	 */
	//检索需要条件
	private String firstGoodsCatId;//一级分类id
	private String secondGoodsCatId;//二级分类id
	private String thirdGoodsCatId;//三级分类id
	private String firstGoodsCatName;//一级分类名称
	private String goodsCatName;//分类名称
	
	private String carBrandId;//品牌id
	private String shCatId;
	private String  carLineId;//车系id
	private String carVersionId;//车型id
	private String bn;//原厂编号
	private Long logisticsTime;//物流时间
	private String cityId;//市区id
	private String cityName;//市区名称
	private String provinceId;//省份id
	private Long store;
	private String sort;//排序条件
	private String order;//正序倒序
	private String topName;//页面表头路径
	private List<GoodsDetail> goodsDetailList;
	private GoodsDetail goodsDetail  = new GoodsDetail();
	private List<Goods> hotGoodsList;
	private List<Goods> hotJpGoodsList;
	private GoodsDetail standerGoods;
	
	private String topSearchLike;//表头查询关键字
	
	private String searchType;//搜索  商品  店铺  咨询
	
	//商城公告列表
		private List<News> gonggaoList;
	
	//规格值传递
	
	private String weight;//重量
    
    private String length;//长度
    
    private String width;//宽度
    
    private String height;//高度
    
    private String color;//颜色
    
    private String wheel;//齿数
    
    private String inside;//内径
    
    private String outside;//外径
    
    private String hole;//孔数
    
    private String zhankai;//更多时需传递
	
	//目录列表
    private List<GoodsCat> fullCategoryList; 
	private List<GoodsCat> firstGoodsCatList;
	private List<GoodsCat> secondGoodsCatList;
	private List<GoodsCat> thirdGoodsCats;
	private String pid;
   //品牌列表
	private List<CarBrand> carBrandList;
	//车系列表
	private List<CarBrand> carLineList;
	//车型列表
	private List<CarBrand> carVersionList;
	//省份列表
	private List<Regions> provinceList;
	
	@Resource
	private CatalogueService catalogueService;
	@Resource
	private RegionsService regionsService;//区域接口类
	@Resource
	private IndexFloorService indexFloorService;
	
	@Resource
	private SearchGoodsService searchGoodsService;
	@Resource
	private IndexGoodsService indexGoodsService;
	
	
	private String shCatIdName;
	private String carBrandIdName;
	private String goodstype;
	
	 	private String leixing;
	    
	    private String baozhuang;
	    private List<GoodsSpecification> baozhuangList;
	    private String zhongliang;
	    private List<GoodsSpecification> zhongliangList;
	    private String shengfen;
	    private List<GoodsSpecification> shengfenList;
		Map<String,HomeSys> mapList = new HashMap<String, HomeSys>();
		private List<HomeSys> temaiList;

	private String catType;


	public String searchGoods(){
		fullCategoryList = catalogueService.queryFullCategory(catType);
		return "toMarket";
	}


	/**
	 * 根据条件检索商品
	 * 
	 **/
	public String searchGoods1() {
		baozhuangList = goodsService.gainSpecification("88f370294cc64d85b7afe236ec5b8bfa");
		zhongliangList= goodsService.gainSpecification("9815ddfa41bc4655b80aa74a0972c2ef");
		shengfenList= goodsService.gainSpecification("5446afc1914d4e6fb3d5ad45fda8c430");
		Pagination pagination = definationPagination(request);
		pagination.setRows(30L);//设置每页显示几条数据
		Map<String,Object> map = new HashMap<String, Object>();
		if(null!=topSearchLike  && !"".equals(topSearchLike)){
			goodsDetail.setTopSearchLike(topSearchLike.trim());
		}
		if(null!=goodstype  && !"".equals(goodstype)){
			goodsDetail.setGoodstype(goodstype);
		}
		if(null!=firstGoodsCatId  && !"".equals(firstGoodsCatId) && null==goodstype){
			goodsDetail.setCarPartsId(firstGoodsCatId);
		}
		if(null!=secondGoodsCatId  && !"".equals(secondGoodsCatId)){
			goodsDetail.setCarPartsId(secondGoodsCatId);
		}
		if(null!=thirdGoodsCatId  && !"".equals(thirdGoodsCatId)){
			goodsDetail.setCarPartsId(thirdGoodsCatId);
		}
		if(null != firstGoodsCatName && !"".equals(firstGoodsCatName)){
			goodsDetail.setFirstGoodsCatName(firstGoodsCatName);
		}
		if(null!=goodsCatName  && !"".equals(goodsCatName)){
			goodsDetail.setGoodsCatName(goodsCatName);
		}
		if(null!=baozhuang  && !"".equals(baozhuang)){
			goodsDetail.setBaozhuang(baozhuang);
		}
		if(null!=zhongliang  && !"".equals(zhongliang)){
			goodsDetail.setZhongliang(zhongliang);
		}
		if(null!=shengfen  && !"".equals(shengfen)){
			goodsDetail.setShengfen(shengfen);
		}
		map.put("goodsDetail", goodsDetail);
		if(null==sort  || "".equals(sort) ){
			sort="(CLICK_NUMBER*0.3+query_num*0.7)";
		}
		if(null==order  || "".equals(order) ){
			order="DESC";
		}
		if(null!=secondGoodsCatId  && !"".equals(secondGoodsCatId)){
			thirdGoodsCats=catalogueService.gainCatalogueByPid(secondGoodsCatId);
		}
		map.put("order",order);
		map.put("sort",sort);
		pagination.setTotalCount(searchGoodsService.gainGoodsListSearchGoodsCount(map));
		map.put("rows", pagination.getRows());
		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		goodsDetailList = searchGoodsService.gainGoodsListSearchGoods(map);
		request.setAttribute("pagination", pagination);
		// 从首页分类查询商品时
		if(null != topName  && !"".equals(topName) && null == firstGoodsCatName){
			request.setAttribute("firstGoodsCatName",  topName);
		}
		//左边热销排行榜
	//	hotGoodsList=indexGoodsService.gainGoodsByType("宝贝推荐", 3);
		if(null != goodstype && !"".equals(goodstype) && "3".equals(goodstype)){
			 return "toHcList"; // 汇筹
		}else{
			return "toList";
		}
		
	}
	public String toTemaiList() {
		//左边热销排行榜
		 hotGoodsList=indexGoodsService.gainGoodsByType("宝贝推荐", 6);
		 temaiList	= indexFloorService.gainTemaiSysList();
			for(int i=0;i<temaiList.size();i++){
				mapList.put("temai_"+i,temaiList.get(i));
			}
		return "toTemaiList";
		
	}
	
	public String gainFirstList() {
		//左侧菜单 目录列表
		firstGoodsCatList=catalogueService.gainCatalogueByGrade(1) ;//一级目录
		gonggaoList = catalogueService.gainNewGongGaoList();
		
		
		
		return "firstList";
		
	}
	
	public void searchHotGoods(){
		//左边热销排行榜
		List<Goods> list=hotGoodsList=indexGoodsService.gainGoodsByType("热卖", 8);
		super.writeJson(list);
	}
	
	
	public String getFirstGoodsCatId() {
		return firstGoodsCatId;
	}
	public void setFirstGoodsCatId(String firstGoodsCatId) {
		this.firstGoodsCatId = firstGoodsCatId;
	}
	public List<GoodsDetail> getGoodsDetailList() {
		return goodsDetailList;
	}
	public void setGoodsDetailList(List<GoodsDetail> goodsDetailList) {
		this.goodsDetailList = goodsDetailList;
	}


	public String getSecondGoodsCatId() {
		return secondGoodsCatId;
	}


	public void setSecondGoodsCatId(String secondGoodsCatId) {
		this.secondGoodsCatId = secondGoodsCatId;
	}
	
	public String getFirstGoodsCatName() {
		return firstGoodsCatName;
	}
	
	public void setFirstGoodsCatName(String firstGoodsCatName) {
		this.firstGoodsCatName = firstGoodsCatName;
	}
	
	public String getGoodsCatName() {
		return goodsCatName;
	}
	
	public void setGoodsCatName(String goodsCatName) {
		this.goodsCatName = goodsCatName;
	}
	
	public String getCarBrandId() {
		return carBrandId;
	}


	public void setCarBrandId(String carBrandId) {
		this.carBrandId = carBrandId;
	}


	public String getCarLineId() {
		return carLineId;
	}


	public void setCarLineId(String carLineId) {
		this.carLineId = carLineId;
	}


	public String getCarVersionId() {
		return carVersionId;
	}


	public void setCarVersionId(String carVersionId) {
		this.carVersionId = carVersionId;
	}


	public String getBn() {
		return bn;
	}


	public void setBn(String bn) {
		this.bn = bn;
	}

	public Long getLogisticsTime() {
		return logisticsTime;
	}


	public void setLogisticsTime(Long logisticsTime) {
		this.logisticsTime = logisticsTime;
	}


	public String getCityId() {
		return cityId;
	}


	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getProvinceId() {
		return provinceId;
	}


	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public Long getStore() {
		return store;
	}


	public void setStore(Long store) {
		this.store = store;
	}


	public GoodsDetail getGoodsDetail() {
		return goodsDetail;
	}


	public void setGoodsDetail(GoodsDetail goodsDetail) {
		this.goodsDetail = goodsDetail;
	}


	public SearchGoodsService getSearchGoodsService() {
		return searchGoodsService;
	}


	public void setSearchGoodsService(SearchGoodsService searchGoodsService) {
		this.searchGoodsService = searchGoodsService;
	}



	public List<Goods> getHotGoodsList() {
		return hotGoodsList;
	}


	public void setHotGoodsList(List<Goods> hotGoodsList) {
		this.hotGoodsList = hotGoodsList;
	}


	public IndexGoodsService getIndexGoodsService() {
		return indexGoodsService;
	}


	public void setIndexGoodsService(IndexGoodsService indexGoodsService) {
		this.indexGoodsService = indexGoodsService;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	public List<GoodsCat> getFullCategoryList() {
		return fullCategoryList;
	}
	public void setFullCategoryList(List<GoodsCat> fullCategoryList) {
		this.fullCategoryList = fullCategoryList;
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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}


	public List<CarBrand> getCarBrandList() {
		return carBrandList;
	}

	public void setCarBrandList(List<CarBrand> carBrandList) {
		this.carBrandList = carBrandList;
	}

	public List<CarBrand> getCarLineList() {
		return carLineList;
	}

	public void setCarLineList(List<CarBrand> carLineList) {
		this.carLineList = carLineList;
	}

	public List<CarBrand> getCarVersionList() {
		return carVersionList;
	}

	public void setCarVersionList(List<CarBrand> carVersionList) {
		this.carVersionList = carVersionList;
	}

	public List<Regions> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Regions> provinceList) {
		this.provinceList = provinceList;
	}

	public CatalogueService getCatalogueService() {
		return catalogueService;
	}

	public void setCatalogueService(CatalogueService catalogueService) {
		this.catalogueService = catalogueService;
	}

	public RegionsService getRegionsService() {
		return regionsService;
	}

	public void setRegionsService(RegionsService regionsService) {
		this.regionsService = regionsService;
	}

	public String getTopName() {
		return topName;
	}

	public void setTopName(String topName) {
		this.topName = topName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public GoodsDetail getStanderGoods() {
		return standerGoods;
	}

	public void setStanderGoods(GoodsDetail standerGoods) {
		this.standerGoods = standerGoods;
	}

	public String getTopSearchLike() {
		return topSearchLike;
	}

	public void setTopSearchLike(String topSearchLike) {
		this.topSearchLike = topSearchLike;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWheel() {
		return wheel;
	}

	public void setWheel(String wheel) {
		this.wheel = wheel;
	}

	public String getInside() {
		return inside;
	}

	public void setInside(String inside) {
		this.inside = inside;
	}

	public String getOutside() {
		return outside;
	}

	public void setOutside(String outside) {
		this.outside = outside;
	}

	public String getHole() {
		return hole;
	}

	public void setHole(String hole) {
		this.hole = hole;
	}

	public String getZhankai() {
		return zhankai;
	}

	public List<Goods> getHotJpGoodsList() {
		return hotJpGoodsList;
	}
	public void setHotJpGoodsList(List<Goods> hotJpGoodsList) {
		this.hotJpGoodsList = hotJpGoodsList;
	}
	public void setZhankai(String zhankai) {
		this.zhankai = zhankai;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getShCatId() {
		return shCatId;
	}
	public void setShCatId(String shCatId) {
		this.shCatId = shCatId;
	}
	public String getShCatIdName() {
		return shCatIdName;
	}
	public void setShCatIdName(String shCatIdName) {
		this.shCatIdName = shCatIdName;
	}
	public String getCarBrandIdName() {
		return carBrandIdName;
	}
	public void setCarBrandIdName(String carBrandIdName) {
		this.carBrandIdName = carBrandIdName;
	}


	public String getLeixing() {
		return leixing;
	}


	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}


	public String getBaozhuang() {
		return baozhuang;
	}


	public void setBaozhuang(String baozhuang) {
		this.baozhuang = baozhuang;
	}


	public String getZhongliang() {
		return zhongliang;
	}


	public void setZhongliang(String zhongliang) {
		this.zhongliang = zhongliang;
	}


	public String getShengfen() {
		return shengfen;
	}


	public void setShengfen(String shengfen) {
		this.shengfen = shengfen;
	}


	public List<GoodsCat> getThirdGoodsCats() {
		return thirdGoodsCats;
	}


	public void setThirdGoodsCats(List<GoodsCat> thirdGoodsCats) {
		this.thirdGoodsCats = thirdGoodsCats;
	}


	public String getThirdGoodsCatId() {
		return thirdGoodsCatId;
	}


	public void setThirdGoodsCatId(String thirdGoodsCatId) {
		this.thirdGoodsCatId = thirdGoodsCatId;
	}


	public List<GoodsSpecification> getBaozhuangList() {
		return baozhuangList;
	}


	public void setBaozhuangList(List<GoodsSpecification> baozhuangList) {
		this.baozhuangList = baozhuangList;
	}


	public List<GoodsSpecification> getZhongliangList() {
		return zhongliangList;
	}


	public void setZhongliangList(List<GoodsSpecification> zhongliangList) {
		this.zhongliangList = zhongliangList;
	}


	public List<GoodsSpecification> getShengfenList() {
		return shengfenList;
	}


	public void setShengfenList(List<GoodsSpecification> shengfenList) {
		this.shengfenList = shengfenList;
	}
	public Map<String, HomeSys> getMapList() {
		return mapList;
	}
	public void setMapList(Map<String, HomeSys> mapList) {
		this.mapList = mapList;
	}
	public List<HomeSys> getTemaiList() {
		return temaiList;
	}
	public void setTemaiList(List<HomeSys> temaiList) {
		this.temaiList = temaiList;
	}
	public String getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}
	public List<News> getGonggaoList() {
		return gonggaoList;
	}
	public void setGonggaoList(List<News> gonggaoList) {
		this.gonggaoList = gonggaoList;
	}

	public String getCatType() {
		return catType;
	}

	public void setCatType(String catType) {
		this.catType = catType;
	}
}
