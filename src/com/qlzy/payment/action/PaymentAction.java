package com.qlzy.payment.action;

import java.math.BigDecimal;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.order.service.OrderService;
import com.qlzy.model.Member;
import com.qlzy.model.Order;
import com.qlzy.model.OrderPayment;
import com.qlzy.payment.service.IPaymentService;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;

@Namespace("/")
@Action(value = "payment", results = {
		@Result(name = "selectPaymentType", location = "/admin/payment/selectPaymentType.jsp"),
		@Result(name = "paySuccess", location = "/admin/payment/paySuccess.jsp"),
		@Result(name = "payFailure", location = "/admin/payment/payFailure.jsp")
})
public class PaymentAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private MemberCallService memberCallService;
	
	private SessionInfo sessionInfo = new SessionInfo();
	
	private String type;
	
	private String payPassword;
	
	private Member member;
	
	private String orderId;
	
	private String payment;
	
	private String hcPaystatus;	// 汇筹支付标志：0失败，1成功
	
	private String message;	// 支付结果信息
	
	private Order order;
	
	private String payuser;
	private String beanAmount;
	private String huibaoAmount;
	private String pointAmount;
	private String huichouType;
	private OrderPayment pointPayment;
	
	
	public String getPayuser() {
		return payuser;
	}

	public void setPayuser(String payuser) {
		this.payuser = payuser;
	}

	public String getBeanAmount() {
		return beanAmount;
	}

	public void setBeanAmount(String beanAmount) {
		this.beanAmount = beanAmount;
	}

	public String getHuibaoAmount() {
		return huibaoAmount;
	}

	public void setHuibaoAmount(String huibaoAmount) {
		this.huibaoAmount = huibaoAmount;
	}

	public String getPointAmount() {
		return pointAmount;
	}

	public void setPointAmount(String pointAmount) {
		this.pointAmount = pointAmount;
	}

	public String getHuichouType() {
		return huichouType;
	}

	public void setHuichouType(String huichouType) {
		this.huichouType = huichouType;
	}

	private String hcpayGateway;
	
	public String getHcpayGateway() {
		return hcpayGateway;
	}

	public void setHcpayGateway(String hcpayGateway) {
		this.hcpayGateway = hcpayGateway;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getHcPaystatus() {
		return hcPaystatus;
	}

	public void setHcPaystatus(String hcPaystatus) {
		this.hcPaystatus = hcPaystatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	/**
	 * 跳转到支付方式选择页面
	 * @return
	 */
	public String toPaymentType() {
		// 选择支付宝在jsp页面跳转：memberCallAction!toZfbPay.action?orderId=${orderId}
		// 选择汇筹：页面Ajax跨域调用
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		System.out.println(orderId);
//		order = orderService.gainOrderById(orderId);
//		pointPayment = paymentService.queryPointPayment(orderId);
//		member =  memberCallService.gainMember(order.getMemberId());
//		hcpayGateway = ResourceUtil.getHcpayGateway();
		
		return "selectPaymentType";
	}

	/**
	 * 汇筹Ajax支付完成后，携带支付结果的跳转
	 * @return
	 */
	public String dealHcResult() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		boolean flag = true;
		try {
			paymentService.dealHcResult(huichouType, orderId, sessionInfo.getUserId(),new BigDecimal(beanAmount),new BigDecimal(huibaoAmount),
					new BigDecimal(pointAmount),payuser,payPassword);
		} catch (Exception e) {
			flag = false;
			message = e.getMessage();
		}

		fillExtraInfo();
		return flag ? "paySuccess" : "payFailure";
	}
	
	/**
	 * 选择系统内部支付方式：经验值、金米、惠米
	 * @return
	 */
	public String dealOwnResult() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		boolean flag = false;
		try {
			paymentService.dealOwnResult(type, orderId, sessionInfo.getUserId(),payPassword);
			flag = true;
		} catch (Exception e) {
			message = e.getMessage();
		}

		fillExtraInfo();
		return flag ? "paySuccess" : "payFailure";
	}
	
	private void fillExtraInfo() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		order = orderService.gainOrderById(orderId);
		member =  memberCallService.gainMember(order.getMemberId());
		pointPayment = paymentService.queryPointPayment(orderId);
	}

	public OrderPayment getPointPayment() {
		return pointPayment;
	}

	public void setPointPayment(OrderPayment pointPayment) {
		this.pointPayment = pointPayment;
	}
}
