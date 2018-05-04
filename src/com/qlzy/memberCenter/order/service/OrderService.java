/**  
* @Title: OrderService.java
* @Package com.qlzy.memberCenter.order.service
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-9-23 上午11:15:25
* @version V1.0  
*/
package com.qlzy.memberCenter.order.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Order;
import com.qlzy.model.OrderItem;
import com.qlzy.model.OrderReturn;
import com.qlzy.model.TradePayDeail;

/**
 * @ClassName: OrderService
 * @Description: TODO(订单处理)
 * @author 周张豹
 * @date 2013-9-23 上午11:15:25
 */
public interface OrderService {

	/**
	 *  跟用户ID查询订单总数
	* @Title: gainOrdersByUserId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	* @author 周张豹
	*/
	public Long gainOrdersByUserIdGetLong(Map<String, Object> map);
	
	/**
	 * 根据用户ID查询订单信息
	* @Title: gainOrdersByUserIdGetList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<Order>    返回类型
	* @author 周张豹
	 */
	public List<Order> gainOrdersByUserIdGetList(Map<String, Object> map);
	
	/**
	 * 根据订单ID将订单物流状态改为签收
	* @Title: receiveGoodsById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id    设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public void receiveGoodsById(String id);

	/**
	 * 根据商家ID查询该商家出售的订单总数
	* @Title: gainOrdersByCompanyIdGetLong
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	* @author 周张豹
	*/
	public Long gainOrdersByCompanyIdGetLong(Map<String, Object> map);

	/**
	 * 根据商家ID查询商家出售的订单信息
	* @Title: gainOrdersByCompanyIdGetList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<Order>    返回类型
	* @author 周张豹
	*/
	public List<Order> gainOrdersByCompanyIdGetList(Map<String, Object> map);
	
	/**
	 * 根据订单ID查询订单里面的详细清单
	* @Title: gainOrderItemsByOrderId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param orderId
	* @param @return    设定文件
	* @return List<OrderItem>    返回类型
	* @author 周张豹
	 */
	public List<OrderItem> gainOrderItemsByOrderId(String orderId);
	
	/**
	 *  根据订单ID查询订单信息
	* @Title: gianOrderById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return Order    返回类型
	* @author 周张豹
	 */
	public Order gainOrderById(String id);

	/**
	 * 退货、退款申请
	* @Title: returnGoods
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param orderReturn    设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void returnGoods(OrderReturn orderReturn);

	/**
	 * 商家对买家申请的退款出来
	* @Title: returnPay
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void returnPay(String orderId,String type);

	/**
	 * 卖家确认收到退货
	* @Title: returnShip
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id    设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void returnShip(String id);

	/**
	 * 卖家发货<br>注意：参数order实体中只能存在orderId和发货信息相关的内容，因为此时是选择性更新
	* @Title: deliverShip
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void compayDeliverShip(Order order, String orderItemId);

	/**
	 * 根据订单编号ID查询订单信息
	* @Title: gainOrderByOrderNum
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param dealOrder
	* @param @return    设定文件
	* @return Order    返回类型
	* @author 周张豹
	*/
	public Order gainOrderByOrderNum(String orderNum);

	public void deleteByPrimaryKey(String id);
	
    public OrderItem selectByOrderItemId(String id);
    public int updateItemByOrderItemId(OrderItem record);
    public int updateOrderByOrderId(Order record);

	public List<Order> gainOrderByCreateTime(Integer i);

	public Long gainOrdersByCompanyIdGetLongxs(Map<String, Object> map);

	public List<Order> gainOrdersByCompanyIdGetListxs(Map<String, Object> map);

	public List<Order> gainOrdersByCompanyIdGetListgm(Map<String, Object> map);

	public Double gaintotalCostgm(Map<String, Object> paramMap);

	public Double gaintotalCostxs(Map<String, Object> paramMap);

	public Long gainOrdersByCompanyIdGetLonggm(Map<String, Object> map);

	public Long gainOrdersByCompanyIdGetLongCh(Map<String, Object> map);

	public List<Order> gainOrdersByCompanyIdGetListCh(Map<String, Object> map);

	public List<Order> gainChuanhuoList();

	public void updatePayDeail(TradePayDeail tradePayDeail);

	public void updateOrderAndPayDeail(String out_trade_no, String trade_no,
			String trade_status, String payType);


	public String gainOrdersByOrderNum(String out_trade_no);

	public OrderReturn gainOrderReturnById(String id);

	void orderFanxian(String out_trade_no);

//	void orderSanjifenxiao(Order order,String userId);

	public void receiveQuartzUpdate(List<Order> orderList);

	public void receiveAndFenxiao(Order order, String orderItemId);

	/**
	 * 支付完成时，更新商品销量（在修改支付状态之前调用，保证销量被修改且仅修改一次）
	 */
//	public void updateSaleQuantity(String out_trade_no);
	
	public void receiveTimeout();
	
	public void notpayTimeout();
}
