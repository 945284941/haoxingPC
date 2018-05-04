package com.qlzy.model;

import java.util.Date;

import java.io.Serializable;

public class PayDeal implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String dealOrder;

    private Double dealFee;

    private String dealState;

    private String dealSignure;

    private String dealId;

    private String type;
    
    private Date updatetime;
    
    private Double dealDiscount;
    
    private String merId;
    
    private String updatePriceResult;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDealOrder() {
        return dealOrder;
    }

    public void setDealOrder(String dealOrder) {
        this.dealOrder = dealOrder == null ? null : dealOrder.trim();
    }

    

    /**
	 * @return the dealFee
	 */
	public Double getDealFee() {
		return dealFee;
	}

	/**
	 * @param dealFee the dealFee to set
	 */
	public void setDealFee(Double dealFee) {
		this.dealFee = dealFee;
	}

	public String getDealState() {
        return dealState;
    }

    public void setDealState(String dealState) {
        this.dealState = dealState == null ? null : dealState.trim();
    }

    public String getDealSignure() {
        return dealSignure;
    }

    public void setDealSignure(String dealSignure) {
        this.dealSignure = dealSignure == null ? null : dealSignure.trim();
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId == null ? null : dealId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

	/**
	 * @return the updatetime
	 */
	public Date getUpdatetime() {
		return updatetime;
	}

	/**
	 * @param updatetime the updatetime to set
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Double getDealDiscount() {
		return dealDiscount;
	}

	public void setDealDiscount(Double dealDiscount) {
		this.dealDiscount = dealDiscount;
	}

	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public String getUpdatePriceResult() {
		return updatePriceResult;
	}

	public void setUpdatePriceResult(String updatePriceResult) {
		this.updatePriceResult = updatePriceResult;
	}
    
    
}