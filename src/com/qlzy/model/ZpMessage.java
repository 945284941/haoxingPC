package com.qlzy.model;

import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class ZpMessage extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String zpPosition;

    private String workPlace;

    private Integer peopleNum;

    private Date deliverTime;

    private String detailMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getZpPosition() {
        return zpPosition;
    }

    public void setZpPosition(String zpPosition) {
        this.zpPosition = zpPosition == null ? null : zpPosition.trim();
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage == null ? null : detailMessage.trim();
    }
}