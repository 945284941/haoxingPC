package com.qlzy.model;

import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class XianjinbiCashApply extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String memberId;
	private String xianjinbiDetailId;
	private Double amount; // 兑米金额
	private Double realAmount; // 实际到账
	private Double liucunAmount; // 留存金额
	private String bankUser;
	private String bankAccount;
	private String bankAddress;
	private String remark;
	private String status;
	private Date createTime;
	private Date auditTime;
	private String tixian_type;
	private String bizhong_type;

	public String getBizhong_type() {
		return bizhong_type;
	}

	public void setBizhong_type(String bizhong_type) {
		this.bizhong_type = bizhong_type;
	}

	public String getTixian_type() {
		return tixian_type;
	}

	public void setTixian_type(String tixian_type) {
		this.tixian_type = tixian_type;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId == null ? null : memberId.trim();
	}

	public String getXianjinbiDetailId() {
		return xianjinbiDetailId;
	}

	public void setXianjinbiDetailId(String xianjinbiDetailId) {
		this.xianjinbiDetailId = xianjinbiDetailId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}

	public Double getLiucunAmount() {
		return liucunAmount;
	}

	public void setLiucunAmount(Double liucunAmount) {
		this.liucunAmount = liucunAmount;
	}

	public String getBankUser() {
		return bankUser;
	}

	public void setBankUser(String bankUser) {
		this.bankUser = bankUser == null ? null : bankUser.trim();
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount == null ? null : bankAccount.trim();
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress == null ? null : bankAddress.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

}