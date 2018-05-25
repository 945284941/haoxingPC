package com.qlzy.memberCenter.order.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Order;

public interface OrderMapper {




	List<Order> gainYujitichengList(Map<String,Object> map);

	/**
	 * 查询下线会员销售额
	 * @param map
	 * @return
	 */
	Order getPercentageById(Map map);
	/**
	 * 
	* @Title: deleteByPrimaryKey
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author 周张豹
	 */
    public int deleteByPrimaryKey(String id);
    
    /**
     * 插入数据
    * @Title: insertSelective
    * @Description: TODO(选择性插入)
    * @param @param record
    * @param @return    设定文件
    * @return int    返回类型
    * @author 周张豹
     */
    public int insertSelective(Order record);
    
    /**
     * 根据ID查询
    * @Title: selectByPrimaryKey
    * @Description: TODO(根据ID查询)
    * @param @param id
    * @param @return    设定文件
    * @return Order    返回类型
    * @author 周张豹
     */
    public Order selectByPrimaryKey(String id);

    /**
     * 根据ID更新数据
    * @Title: updateByPrimaryKeySelective
    * @Description: TODO(选择性更新)
    * @param @param record
    * @param @return    设定文件
    * @return int    返回类型
    * @author 周张豹
     */
    public int updateByPrimaryKeySelective(Order record);

	/**
	 *  根据用户的id统计订单总数
	* @Title: gainOrdersByUserIdGetLong
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	* @author 周张豹
	*/
	public Long gainOrdersByUserIdGetLong(Map<String, Object> map);

	/**
	 * 根据用户ID获取订单信息
	* @Title: gainOrdersByUserIdGetList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<Order>    返回类型
	* @author 周张豹
	*/
	public List<Order> gainOrdersByUserIdGetList(Map<String, Object> map);
	
	/**
	 * @Title: gainOrderStatisticsByTime
	 * @Description: TODO(统计信息-订单统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @throws
	 * @author wangmei
	 */
	Long gainOrderStatisticsByTime(Map<String, Object> map);
	
	/**
	 * @Title: gainSettleStatisticsByTime
	 * @Description: TODO(统计信息-结算统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Double 返回类型 
	 * @author wangmei
	 */
	Double gainSettleStatisticsByTime(Map<String, Object> map);
	
	/**
	 * @Title: gainLogisticsStatisticsByTime
	 * @Description: TODO(统计信息-物流统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainLogisticsStatisticsByTime(Map<String, Object> map);

	/**
	 *  根据商家ID查询商家的出售订单总数
	* @Title: gainOrdersByCompanyIdGetLong
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	* @author 周张豹
	*/
	public Long gainOrdersByCompanyIdGetLong(Map<String, Object> map);
	public Long gainOrdersByCompanyIdGetLongxs(Map<String, Object> map);
	public Long gainOrdersByCompanyIdGetLonggm(Map<String, Object> map);
	/**
	 * 根据商家ID查询该商家出售订单的信息
	* @Title: gainOrdersByCompanyIdGetList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<Order>    返回类型
	* @author 周张豹
	*/
	public List<Order> gainOrdersByCompanyIdGetList(Map<String, Object> map);
	public List<Order> gainOrdersByCompanyIdGetListxs(Map<String, Object> map);
	public List<Order> gainOrdersByCompanyIdGetListgm(Map<String, Object> map);
	/**
	 * 根据商品的ID查询商品的成交量<br>成交量：确认收货的为成交
	* @Title: selectTransactionNumByGoodsId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param goodsId
	* @param @return    设定文件
	* @return Integer    返回类型
	* @author 周张豹
	*/
	public Integer selectTransactionNumByGoodsId(String goodsId);
	
	/**
	 * 根据商家ID查询订单的成交量<br>成交量：确认收货的为成交
	* @Title: selectTransactionNumByCompanyId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param companyId
	* @param @return    设定文件
	* @return Long    返回类型
	* @author 周张豹
	 */
	public Long selectTransactionNumByCompanyId(String companyId);

	/**
	 * 根据订单编号ID查询订单信息
	* @Title: gainOrderByOrderNum
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param orderNum
	* @param @return    设定文件
	* @return Order    返回类型
	* @author 周张豹
	*/
	public Order gainOrderByOrderNum(String orderNum);

	public List<Order> gainOrderByCreateTime(int i);
	
	Double gaintotalCostxs(Map<String, Object> map);
	Double gaintotalCostgm(Map<String, Object> map);

	public List<Order> gainOrdersByCompanyIdGetListCh(Map<String, Object> map);

	public Long gainOrdersByCompanyIdGetLongCh(Map<String, Object> map);

	public void insertSelectiveCh(Order order);

	public Long gainOrderStatisticsByTimexs(Map<String, Object> paramMap);

	public List<Order> gainChuanhuoList();

	public void upadteOrderPayType(Order order);

	public void upadteOrderPayTypeByOrderId(Order order);

	public Order gainOrdersByOrderNum(String out_trade_no);

	public List<Order> receiveQuartz(int i);

	public void updateBatchReceive(Map<String, Object> map);

	public void noPayQuartz(Map<String, Object> map);

	public List<Order> queryNopayOrders(Map<String, Object> map);
}