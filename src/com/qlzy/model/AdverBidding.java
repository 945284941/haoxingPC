package com.qlzy.model;

import java.math.BigDecimal;
import java.util.Date;

import com.qlzy.pojo.Base;

import java.io.Serializable;

public class AdverBidding extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String adverId;

    private Date starttime;

    private Date endtime;

    private String name;

    private Date adverStarttime;

    private Date adverEndtime;

    private BigDecimal successBidAmount;

    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAdverId() {
        return adverId;
    }

    public void setAdverId(String adverId) {
        this.adverId = adverId == null ? null : adverId.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getAdverStarttime() {
        return adverStarttime;
    }

    public void setAdverStarttime(Date adverStarttime) {
        this.adverStarttime = adverStarttime;
    }

    public Date getAdverEndtime() {
        return adverEndtime;
    }

    public void setAdverEndtime(Date adverEndtime) {
        this.adverEndtime = adverEndtime;
    }

    public BigDecimal getSuccessBidAmount() {
        return successBidAmount;
    }

    public void setSuccessBidAmount(BigDecimal successBidAmount) {
        this.successBidAmount = successBidAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}