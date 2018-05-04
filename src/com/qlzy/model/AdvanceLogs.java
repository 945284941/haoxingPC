package com.qlzy.model;

import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class AdvanceLogs extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String userId;

    private String message;

    private Date doTime;

    private String paymentId;

    private String doType;

    private String orderId;

    private String doWhat;

    private Double doMoney;

    private String disabled;

    private String userType;

    private Double balance;
    
    private String bank;
    
    private String bankAccount;
    
    private String trading;
    
    private String yanzhengMobile;//扩展字段 手机验证码

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getDoTime() {
        return doTime;
    }

    public void setDoTime(Date doTime) {
        this.doTime = doTime;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId == null ? null : paymentId.trim();
    }

    public String getDoType() {
        return doType;
    }

    public void setDoType(String doType) {
        this.doType = doType == null ? null : doType.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getDoWhat() {
        return doWhat;
    }

    public void setDoWhat(String doWhat) {
        this.doWhat = doWhat == null ? null : doWhat.trim();
    }


    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

	public Double getDoMoney() {
		return doMoney;
	}

	public void setDoMoney(Double doMoney) {
		this.doMoney = doMoney;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getYanzhengMobile() {
		return yanzhengMobile;
	}

	public void setYanzhengMobile(String yanzhengMobile) {
		this.yanzhengMobile = yanzhengMobile;
	}

}