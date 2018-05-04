package com.qlzy.model;

import java.math.BigDecimal;
import java.util.Date;

import com.qlzy.pojo.Base;

import java.io.Serializable;

public class MemberBiddingLogs extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String adverId;

    private String adverBiddingId;

    private BigDecimal currentBidding;

    private Date createtime;

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

    public String getAdverBiddingId() {
        return adverBiddingId;
    }

    public void setAdverBiddingId(String adverBiddingId) {
        this.adverBiddingId = adverBiddingId == null ? null : adverBiddingId.trim();
    }

    public BigDecimal getCurrentBidding() {
        return currentBidding;
    }

    public void setCurrentBidding(BigDecimal currentBidding) {
        this.currentBidding = currentBidding;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}