package com.qlzy.searchGoods.dao;

import java.util.List;
import java.util.Map;


import com.qlzy.model.Goods;
import com.qlzy.model.GoodsDetail;
import com.qlzy.model.SpecificationInformation;

/**
* @ClassName: GoodsMapper
* @Description: TODO前台商品管理
* @author Huifeng Wang
* @date 2013-5-7 上午11:36:53
*
*/
public interface GoodsDetailMapper {
	
	/**
	 * @param searchGoodsMap 
	* @Title: gainGoodsListSearchGoods
	* @Description: TODO(根据条件查找商品列表)
	* @param @param searchGoodsMap
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	*/
	public List<GoodsDetail> gainGoodsListSearchGoods(Map map);

	/**
	* @Title: gainGoodsListSearchGoodsCount
	* @Description: TODO(根据条件查找商品列表条数)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainGoodsListSearchGoodsCount(Map<String, Object> map);

	/**
	* @Title: gainStanderGoods
	* @Description: TODO(根据商品编号查找标准数据)
	* @param @param bn
	* @param @return    设定文件
	* @return Goods    返回类型
	*/
	public List<GoodsDetail> gainStanderGoods(String bn);

	/**
	* @Title: gainSpecificationListByGoodsId
	* @Description: TODO(根据商品id，得到商品规格)
	* @param @param id
	* @param @return    设定文件
	* @return List<SpecificationInformation>    返回类型
	*/
	public List<SpecificationInformation> gainSpecificationListByGoodsId(
			String id);

	public List<GoodsDetail> gainGoodsListSearchShGoods(Map<String, Object> map);

	public Long gainGoodsListSearchGoodsShCount(Map<String, Object> map);

	public List<Goods> gainGoodsByCompany(Map<String, Object> map);

}