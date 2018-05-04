package com.qlzy.task.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CashBackTaskLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String taskId;
	private Integer number;
	private BigDecimal amount;
	private String linkId;
	private Date createTime;
	private String remark;
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTaskId() {
		return this.taskId;
	}
	
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	public Integer getNumber() {
		return this.number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getLinkId() {
		return this.linkId;
	}
	
	public void setLinkId(String linkId) {
		this.linkId = linkId;
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
