package com.qlzy.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderPayment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String paymentId;
	private String orderId;
	private String paymentType;
	private BigDecimal amount;
	private String status;
	private Date createTime;
	
	public String getPaymentId() {
		return this.paymentId;
	}
	
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
	public String getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getPaymentType() {
		return this.paymentType;
	}
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
