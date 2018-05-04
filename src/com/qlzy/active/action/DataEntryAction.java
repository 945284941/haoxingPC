/**  
* @Title: DataEntryAction.java
* @Package com.qlzy.active.action
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-6-29 下午2:14:33
* @version V1.0  
*/
package com.qlzy.active.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.active.service.DataEntryService;
import com.qlzy.model.ActiveCollectGoodsQB;
import com.qlzy.model.CarBrand;
import com.qlzy.model.GoodsCat;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

/**
 * 数据入口转向控制<br>开放类、定向类，补充类数据的上传
 * @ClassName: DataEntryAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-6-29 下午2:14:33
 */
@Action(value = "dataEntryAction", results = {
		@Result(name = "goReplenishData", location = "/active/replenishData.jsp")})
public class DataEntryAction extends BaseAction {
	
	@Resource
	private DataEntryService dataEntryService;
	
	private List<ActiveCollectGoodsQB> list;
	private List<GoodsCat> cats;
	private List<CarBrand> carBrands;
	private GoodsCat goodsCat;
	private CarBrand carBrand;
	private ActiveCollectGoodsQB activeCollectGoodsQB;
	private String type;
	
	/**
	* @ClassName: com.qlzy.active.actionDataEntryAction.java
	* @Description: TODO(这里用一句话描述这个类的作用)
	* @author 周张豹
	* @date 2013-6-29 下午2:15:18
	*/
	private static final long serialVersionUID = 1L;
	
	/**
	 * 转向补充类<br> 获取全部的题库资料
	* @Title: goReplenishData
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public String goReplenishData(){
		Map<String,Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(5L);
		if (carBrand != null && carBrand.getName() != null) {
			map.put("carBrandName", carBrand.getName());
		}else {
			carBrand=new CarBrand();
			carBrand.setName("中国重汽");
			map.put("carBrandName", carBrand.getName());
		}
		if (goodsCat != null && goodsCat.getName() != null && !"".equals(goodsCat.getName())) {
			map.put("goodsCatName", goodsCat.getName());
		}
		if (type != null && !"".equals(type)) {
			map.put("type", type);
		}
		if(activeCollectGoodsQB!=null&&activeCollectGoodsQB.getName()!=null&&!"".equals(activeCollectGoodsQB.getName())){
			map.put("name", activeCollectGoodsQB.getName());
			request.setAttribute("name", activeCollectGoodsQB.getName());
		}
		if(activeCollectGoodsQB!=null&&activeCollectGoodsQB.getBn()!=null&&!"".equals(activeCollectGoodsQB.getBn())){
			map.put("bn", activeCollectGoodsQB.getBn());
			request.setAttribute("bn", activeCollectGoodsQB.getBn());
		}
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		pagination.setTotalCount(dataEntryService.gainActiveGoodsQBNum(map));//获取总条数
		list = dataEntryService.gainActiveGoodsQB(map);
		cats = dataEntryService.gainGoodsCat();//商品分类
		carBrands = dataEntryService.gainCarBrandFirst();//获取一级品牌分类
		request.setAttribute("pagination", pagination);
		request.setAttribute("carBrand", carBrand);
		request.setAttribute("goodsCat", goodsCat);
		request.setAttribute("type", type);
		return "goReplenishData";
	}

	
	
	
	/**
	 * @return the list
	 */
	public List<ActiveCollectGoodsQB> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<ActiveCollectGoodsQB> list) {
		this.list = list;
	}




	/**
	 * @return the cats
	 */
	public List<GoodsCat> getCats() {
		return cats;
	}




	/**
	 * @param cats the cats to set
	 */
	public void setCats(List<GoodsCat> cats) {
		this.cats = cats;
	}




	/**
	 * @return the carBrands
	 */
	public List<CarBrand> getCarBrands() {
		return carBrands;
	}




	/**
	 * @param carBrands the carBrands to set
	 */
	public void setCarBrands(List<CarBrand> carBrands) {
		this.carBrands = carBrands;
	}




	/**
	 * @return the goodsCat
	 */
	public GoodsCat getGoodsCat() {
		return goodsCat;
	}




	/**
	 * @param goodsCat the goodsCat to set
	 */
	public void setGoodsCat(GoodsCat goodsCat) {
		this.goodsCat = goodsCat;
	}




	/**
	 * @return the carBrand
	 */
	public CarBrand getCarBrand() {
		return carBrand;
	}




	/**
	 * @param carBrand the carBrand to set
	 */
	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}




	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}




	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}




	/**
	 * @return the activeCollectGoodsQB
	 */
	public ActiveCollectGoodsQB getActiveCollectGoodsQB() {
		return activeCollectGoodsQB;
	}




	/**
	 * @param activeCollectGoodsQB the activeCollectGoodsQB to set
	 */
	public void setActiveCollectGoodsQB(ActiveCollectGoodsQB activeCollectGoodsQB) {
		this.activeCollectGoodsQB = activeCollectGoodsQB;
	}
	
	
}
