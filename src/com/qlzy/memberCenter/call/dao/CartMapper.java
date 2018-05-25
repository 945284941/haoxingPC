package com.qlzy.memberCenter.call.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Cart;

public interface CartMapper {
	
	/**
	 * 根据ID删除购物车信息
	* @Title: deleteByPrimaryKey
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id    设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public void deleteByPrimaryKey(String id);
	
	/**
	 * 加入购物车
	* @Title: insert
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param record    设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
    public void insert(Cart record);

	/**
	* @Title: gianCarByUserId
	* @Description: TODO(根据用户的ID获取购物车信息)
	* @param @param userId
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	*/
	public List<String> gianCarByUserId(String userId);

	/**
	 * 根据商品的ID获取该商品在购物车中的数量
	* @Title: selectGoodsNumInCartByGoodsId
	* @Description: TODO(根据商品的ID获取该商品在购物车中的数量)
	* @param @param goodsId
	* @param @return    设定文件
	* @return Integer    返回类型
	* @author 周张豹
	*/
	public Cart selectGoodsNumInCartByGoodsId(Cart cart);
	/**
	 * 根据单品的ID获取该单品在购物车中的数量
	* @Title: selectGoodsNumInCartByGoodsId
	* @Description: TODO(根据商品的ID获取该商品在购物车中的数量)
	* @param @param goodsId
	* @param @return    设定文件
	* @return Integer    返回类型
	* @author 王汇丰
	*/
	public Cart selectGoodsNumInCartByItemId(Cart cart);
	
	/**
	 * 更新购物车信息
	* @Title: updateCart
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param cart    设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public void updateByPrimaryKey(Cart cart);

	/**
	 * 根据商品id删除购物车信息
	* @Title: deleteByGoodeIds
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param asList    设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void deleteByGoodeIds(Map<String,Object> map);

	/**
	* @Title: updateCartNumByGoodsId
	* @Description: TODO(根据用户的ID和商品ID更新购物车商品的数量)
	* @param @param cart    设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void updateCartNumByGoodsId(Cart cart);

	/**
	 * 根据用户的ID查询该用户下购物车商品的数量
	* @Title: selectCartNumByUserId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param userId
	* @param @return    设定文件
	* @return Integer    返回类型
	* @author 周张豹
	 */
	public Integer selectCartNumByUserId(String userId);

	public List<Cart> selectCartsByUserId(String userId);

	public List<Cart> gainCartsByIds(List<String> asList);

	public Cart gainCartById(String id);


	/**
	 * @Title: deleteByUserId
	 * @Description:
	 * @date 2017-1-12 上午11:42:54 
	 * @param @param userId 设定文件
	 * @return void 返回类型
	 * @throws
	 * @version V1.0
	 */
	public void deleteByUserId(String userId);

	List<Cart> selectCartsByUserIdAndAd(Map<String, Object> parm);

	Integer gainCartNumByParm(Map<String, Object> parmMap);

	List<Cart> gainCartsByItemIds(Map<String, Object> parmMap);
}