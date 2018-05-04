/**  
* @Title: SearchGoodsService.java
* @Package com.qlzy.searchGoods.service
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com  
* @date 2013-5-21 下午3:47:49
* @version V1.0  
*/
package com.qlzy.searchGoods.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Goods;
import com.qlzy.model.GoodsDetail;

/**
 * @ClassName: SearchGoodsService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author A18ccms a18ccms_gmail_com
 * @date 2013-5-21 下午3:47:49
 *
 */
public interface SearchGoodsService {

	/**
	* @Title: gainGoodsListSearchGoods
	* @Description: TODO(根据条件查询商品列表)
	* @param @param searchGoodsMap
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	*/
	List<GoodsDetail> gainGoodsListSearchGoods(Map<String, Object> map);

	/**
	* @Title: gainGoodsListSearchGoodsCount
	* @Description: TODO(根据条件查询商品列表数据条数)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainGoodsListSearchGoodsCount(Map<String, Object> map);

	/**
	* @Title: gainStanderGoods
	* @Description: TODO(根据商品编号查找标准数据)
	* @param @param bn
	* @param @return    设定文件
	* @return Goods    返回类型
	*/
	GoodsDetail gainStanderGoods(String bn);

	Long gainGoodsListSearchGoodsShCount(Map<String, Object> map);

	List<GoodsDetail> gainGoodsListSearchShGoods(Map<String, Object> map);

	List<Goods> gainGoodsByCompany(Map<String, Object> map);
	
}
