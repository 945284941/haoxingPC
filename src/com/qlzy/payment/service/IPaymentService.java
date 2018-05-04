package com.qlzy.payment.service;

import java.math.BigDecimal;
import java.util.List;

import com.qlzy.model.OrderPayment;

public interface IPaymentService {
	/**
	 * 汇筹支付结果处理
	 * @param type			1汇豆，2汇宝，3汇积分，4汇豆+汇宝
	 * @param orderId
	 * @param memberId
	 * @param beansAmount
	 * @param huibaoAmount
	 * @param pointAmount
	 * @param payuser
	 * @param paypass
	 * @return
	 */
	public String dealHcResult(String type, String orderId, String memberId, BigDecimal beansAmount, BigDecimal huibaoAmount, BigDecimal pointAmount, String payuser, String paypass);
	
	/**
	 * 
	 * 系统内部支付：经验值、金米、惠米
	 * @param type	1金米， 2经验值，3惠米
	 * @param orderId
	 * @param memberId
	 * @param payPassword
	 * @return
	 */
	public String dealOwnResult(String type, String orderId, String memberId, String payPassword);
	
	/**
	 * 使用积分支付（无订单校验）
	 * @param orderId
	 * @param memberId
	 * @return
	 * 	积分抵扣的金额
	 */
	public double payByPoint(String orderId, String memberId);
	
	/**
	 * 订单取消，退回经验值
	 * @param orderId
	 * @param memberId
	 * @return
	 */
	public double returnPoint(String orderId, String memberId);
	
	/**
	 * 查询经验值支付记录（唯一）
	 * @param orderId
	 * @return
	 */
	public OrderPayment queryPointPayment(String orderId);
	
	/**
	 * 查询支付记录
	 * @param orderId
	 * @param paymentType	支付方式：null则查询所有方式
	 * @param status		支付状态：null则查询所有状态
	 * @return
	 */
	public List<OrderPayment> queryPaymentRecord(String orderId, String paymentType, String status);
	
	/**
	 * 查询已支付金额（不包括经验值）
	 * @param orderId
	 * @return
	 */
	public BigDecimal queryPaidAmount(String orderId);
}
