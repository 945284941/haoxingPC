package com.qlzy.memberCenter.order.dao;

import java.util.List;

import com.qlzy.model.OrderItem;



public interface OrderItemMapper {
	/**
	 * 根据ID删除
	* @Title: deleteByPrimaryKey
	* @Description: TODO(根据ID删除)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author 周张豹
	 */
    public int deleteByPrimaryKey(String id);
    
    /**
     * 插入数据
    * @Title: insertSelective
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param record
    * @param @return    设定文件
    * @return int    返回类型
    * @author 周张豹
     */
    public int insertSelective(OrderItem record);
    /**
     * 根据ID查询
    * @Title: selectByPrimaryKey
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param id
    * @param @return    设定文件
    * @return OrderItem    返回类型
    * @author 周张豹
     */
    public OrderItem selectByPrimaryKey(String id);
    /**
     * 更新数据信息
    * @Title: updateByPrimaryKeySelective
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param record
    * @param @return    设定文件
    * @return int    返回类型
    * @author 周张豹
     */
    public int updateByPrimaryKeySelective(OrderItem record);

	/**
	* @Title: insertBeach
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param orderItems    设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void insertBeach(List<OrderItem> list);

	/**
	 *  根据订单ID查询订单的内容
	* @Title: selectByOrderId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return List<OrderItem>    返回类型
	* @author 周张豹
	*/
	public List<OrderItem> selectByOrderId(String id);

	/**
	 * 根据订单ID和商品ID将其评价状态改为已评价
	* @Title: updateAppraiseByOrderIdAndGoodsId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param orderItem    设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void updateAppraiseByOrderIdAndGoodsId(OrderItem orderItem);
	
	/**
	 * 根据商品ID查询该商品的购买记录
	* @Title: selectBuyRecordByGoodsId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<OrderItem>    返回类型
	* @author 周张豹
	 */
	public List<OrderItem> selectBuyRecordByGoodsId(String goodsId);

	public void droporderItems(List<String> orderItemsId);

}