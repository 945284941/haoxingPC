package com.qlzy.payment.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.qlzy.model.OrderPayment;

public interface OrderPaymentMapper {
	int insert(OrderPayment orderPayment);

	int insertSelective(OrderPayment orderPayment);

	int deleteByPrimaryKey(String paymentId);

	OrderPayment selectByPrimaryKey(String paymentId);

	int updateByPrimaryKey(OrderPayment orderPayment);

	int updateByPrimaryKeySelective(OrderPayment orderPayment);
	
	/**
	 * 查询支付记录
	 * @param orderId
	 * @param paymentType	支付方式：null则查询所有方式
	 * @param status		支付状态：null则查询所有状态
	 * @return
	 */
	List<OrderPayment> queryPaymentRecord(Map<String, String> param);
	
	/**
	 * 查询已支付金额（不包括经验值）
	 * @param orderId
	 * @return
	 */
	public BigDecimal queryPaidAmount(String orderId);
}
