package com.qlzy.model;

import java.util.Date;

import java.io.Serializable;

public class InstationMessage implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String content;

    private String fromId;

    private String toId;

    private Date createtime;

    private Integer status;

    private String messageTitle;

    private Integer type;

    private String disabled;
    
    private String userType;
    
    //以下为扩展字段
    private String toId1;
    private String toId2;
    private String toUserType;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle == null ? null : messageTitle.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

	public String getToId1() {
		return toId1;
	}

	public void setToId1(String toId1) {
		this.toId1 = toId1;
	}

	public String getToId2() {
		return toId2;
	}

	public void setToId2(String toId2) {
		this.toId2 = toId2;
	}

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

	public String getToUserType() {
		return toUserType;
	}

	public void setToUserType(String toUserType) {
		this.toUserType = toUserType;
	}
}