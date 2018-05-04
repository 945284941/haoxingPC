package com.qlzy.model;

import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class CourtesyMember extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String memberId;

    private String memberType;

    private String courtesyCardId;

    private Long num;

    private Long status;

    private String disabled;

    private String orderId;
    
    private String name;
    private Date startTime;
    private Date timeRange;
    private Double price;
    
    private String remark;

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

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    public String getCourtesyCardId() {
        return courtesyCardId;
    }

    public void setCourtesyCardId(String courtesyCardId) {
        this.courtesyCardId = courtesyCardId == null ? null : courtesyCardId.trim();
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(Date timeRange) {
		this.timeRange = timeRange;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}