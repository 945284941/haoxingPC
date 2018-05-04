package com.qlzy.shanghui.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.common.constant.SysSetting;
import com.qlzy.mainPage.company.service.CompanyService;
import com.qlzy.mainPage.indexGoods.service.IndexGoodsService;
import com.qlzy.mainPage.news.service.NewsService;
import com.qlzy.memberCenter.order.service.OrderService;
import com.qlzy.model.CarPartsProducer;
import com.qlzy.model.Company;
import com.qlzy.model.Goods;
import com.qlzy.model.News;
import com.qlzy.model.Order;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Constant;
import com.qlzy.util.Pagination;

@Namespace("/")
@Action(value = "shMainPageAction", results = {
		@Result(name = "toShIndexGoodsHot", location = "/shanghui/shouye/indexHot.jsp"),
		@Result(name = "toFloorGoods", location = "/shanghui/shouye/shFloor.jsp"),
		@Result(name = "toscgg", location = "/shanghui/shouye/scgg.jsp"),
		@Result(name = "toNewsList", location = "/shanghui/shouye/newsList.jsp"),
		@Result(name = "toRmList", location = "/shanghui/shouye/rmtj.jsp"),
		@Result(name = "chsc", location = "/shanghui/shouye/chuanhuo.jsp")
})
public class MainPageAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	/**
	 * 转向首页的热销商品
	 * 
	 * @Title: toHotGoods
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 赵
	 */
	
	private List<Goods> shHotGoods = new ArrayList<Goods>();
	private List<Goods> list1= new ArrayList<Goods>();
	private List<Goods> list2= new ArrayList<Goods>();
	private List<Goods> listOne = new ArrayList<Goods>();
	private List<Goods> listTwo = new ArrayList<Goods>();
	private List<Goods> listThree = new ArrayList<Goods>();
	private List<Goods> listFour = new ArrayList<Goods>();
	private List<News> gonggaoList = new ArrayList<News>();
	private Integer companyNum;
	private Integer goodsNum;
	private List<Order> listOrder = new ArrayList<Order>();
	private Map<String, Object> map = new HashMap<String, Object>();
	private List<Company> companyList = new ArrayList<Company>();
	@Resource
	private IndexGoodsService indexGoodsService;
	@Resource
	private NewsService newService;
	@Resource
	private CompanyService companyService;
	@Resource
	private OrderService orderService;
	
	//首页热销
	public String toHotGoods() {
		shHotGoods = indexGoodsService.gainGoodsByShType("热卖", 8);
		for (int i = 0; i < shHotGoods.size(); i++) {  
			if(i<3){
				list1.add(shHotGoods.get(i));
			}else{
				list2.add(shHotGoods.get(i));
			}
			  }  
		return "toShIndexGoodsHot";
	}
	//首页楼层
	public String toFloorGoods() {
		listOne = indexGoodsService.gainShIndexGoodsList("653f492467b4492a9d769300106a439f",8);//发动机id
		listTwo = indexGoodsService.gainShIndexGoodsList("1bb62b6e330149bab5ee0c934a0be6cb",8);//发动机附件id
		listThree = indexGoodsService.gainShIndexGoodsList("6fa0db59646e498eba6aca3cd9e405d6",8);//电器系统id
		listFour = indexGoodsService.gainShIndexGoodsList("529ee4bc1a77431f9f04ba7d5f1008d0",8);//润滑油id
		return "toFloorGoods";
	}
	//生成公告
		public String toscgg() {
			//商城公告列表
			gonggaoList = newService.gainNewShGongGaoList();
			goodsNum = indexGoodsService.gainShGoodsNum();
			companyNum = companyService.gainCompanyNum();
			listOrder = orderService.gainOrderByCreateTime(SysSetting.twenty);//获取最靠前的100条数据
			return "toscgg";
		}
	//首页底部新闻列表
		public String toNewsList() {
			News temp=new News();
			temp.setId("");
			Map<String, Object> newsCatMap = new HashMap<String, Object>();
			Map<String, Object> param;
			newsCatMap.put("0", "方针政策");
			newsCatMap.put("1", "技术前沿");
			newsCatMap.put("2", "产业资讯");
			for (int i = 0; i <= 5; i++) {
				List<News> list = new ArrayList<News>();
				param = new HashMap<String, Object>();
				param.put("newsCatName", String.valueOf(newsCatMap.get(i + "")));
				List<News> temp1 = newService.gainNewsForQPZX(param);
				map.put("top_"+i, temp1.size()>0?temp1.get(0):temp1);
				if(temp1.size()>=2){
					list = temp1.subList(1, temp1.size() >= 5 ? 5 : temp1.size());
				}
				map.put("news_" + i, list);
			}
			return "toNewsList";
		}
		//热销列表
		public String toRmList() {
			Pagination pagination = definationPagination(request);
			pagination.setRows(Constant.paginationRowsLong);// 设置每页显示几条数据
			map.put("page", pagination.getPage());
			map.put("rows", pagination.getRows());
			map.put("disabled", "true");
			shHotGoods = indexGoodsService.gainGoodsByTypeListAll(map);
			Long goodsLength = indexGoodsService.gainGoodsByTypeListAllcount(map);
			pagination.setTotalCount(goodsLength);
			
			request.setAttribute("shHotGoods", shHotGoods);
			request.setAttribute("pagination", pagination);
			return "toRmList";
		}
		
		//串货市场
		public String chsc(){
			listOrder = orderService.gainChuanhuoList();
			Pagination pagination = definationPagination(request);
			pagination.setRows(Constant.paginationRowsLong);// 设置每页显示几条数据
			map.put("page", pagination.getPage());
			map.put("rows", pagination.getRows());
			map.put("disabled", "true");
			companyList = companyService.gainCHCompanyList(map);
			Long companyListD = companyService.gainCHCompanyListCount(map);
			pagination.setTotalCount(companyListD);
			request.setAttribute("companyList", companyList);
			request.setAttribute("pagination", pagination);
			return "chsc";
		}
	public IndexGoodsService getIndexGoodsService() {
		return indexGoodsService;
	}
	public void setIndexGoodsService(IndexGoodsService indexGoodsService) {
		this.indexGoodsService = indexGoodsService;
	}
	public List<Goods> getShHotGoods() {
		return shHotGoods;
	}
	public void setShHotGoods(List<Goods> shHotGoods) {
		this.shHotGoods = shHotGoods;
	}


	public List<Goods> getList1() {
		return list1;
	}


	public void setList1(List<Goods> list1) {
		this.list1 = list1;
	}


	public List<Goods> getList2() {
		return list2;
	}


	public List<News> getGonggaoList() {
		return gonggaoList;
	}
	public void setGonggaoList(List<News> gonggaoList) {
		this.gonggaoList = gonggaoList;
	}
	public void setList2(List<Goods> list2) {
		this.list2 = list2;
	}
	public List<Goods> getListOne() {
		return listOne;
	}
	public void setListOne(List<Goods> listOne) {
		this.listOne = listOne;
	}
	public List<Goods> getListTwo() {
		return listTwo;
	}
	public void setListTwo(List<Goods> listTwo) {
		this.listTwo = listTwo;
	}
	public List<Goods> getListThree() {
		return listThree;
	}
	public void setListThree(List<Goods> listThree) {
		this.listThree = listThree;
	}
	public List<Goods> getListFour() {
		return listFour;
	}
	public void setListFour(List<Goods> listFour) {
		this.listFour = listFour;
	}
	public NewsService getNewService() {
		return newService;
	}
	public void setNewService(NewsService newService) {
		this.newService = newService;
	}
	public Integer getCompanyNum() {
		return companyNum;
	}
	public void setCompanyNum(Integer companyNum) {
		this.companyNum = companyNum;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public CompanyService getCompanyService() {
		return companyService;
	}
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
	public List<Order> getListOrder() {
		return listOrder;
	}
	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public List<Company> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}
	
}
