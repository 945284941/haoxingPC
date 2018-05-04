package com.qlzy.task.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CashBackTask implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String taskId;
	private String memberId;
	private String memberName;
	private String backKey;
	private String backValue;
	private String goodsId;
	private String goodsName;
	private String skuId;
	private String skuValue;
	private BigDecimal amount;
	private BigDecimal totalBalance;
	private BigDecimal alreadyBalance;
	private Integer totalNumber;
	private Integer alreadyNumber;
	private String status;
	private Date nextBackTime;
	private Date createTime;
	private String remark;
	
	public String getTaskId() {
		return this.taskId;
	}
	
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	public String getMemberId() {
		return this.memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberName() {
		return this.memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getBackKey() {
		return this.backKey;
	}
	
	public void setBackKey(String backKey) {
		this.backKey = backKey;
	}
	
	public String getBackValue() {
		return this.backValue;
	}
	
	public void setBackValue(String backValue) {
		this.backValue = backValue;
	}
	
	public String getGoodsId() {
		return this.goodsId;
	}
	
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	
	public String getGoodsName() {
		return this.goodsName;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public String getSkuId() {
		return this.skuId;
	}
	
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	
	public String getSkuValue() {
		return this.skuValue;
	}
	
	public void setSkuValue(String skuValue) {
		this.skuValue = skuValue;
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public BigDecimal getTotalBalance() {
		return this.totalBalance;
	}
	
	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	public BigDecimal getAlreadyBalance() {
		return this.alreadyBalance;
	}
	
	public void setAlreadyBalance(BigDecimal alreadyBalance) {
		this.alreadyBalance = alreadyBalance;
	}
	
	public Integer getTotalNumber() {
		return this.totalNumber;
	}
	
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	public Integer getAlreadyNumber() {
		return this.alreadyNumber;
	}
	
	public void setAlreadyNumber(Integer alreadyNumber) {
		this.alreadyNumber = alreadyNumber;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getNextBackTime() {
		return this.nextBackTime;
	}
	
	public void setNextBackTime(Date nextBackTime) {
		this.nextBackTime = nextBackTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
