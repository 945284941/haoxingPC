package com.qlzy.model;


import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class DataDownload extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String newId;

    private Date createdate;

    private String userId;

    private String disabled;

    private String newUrl;

    private Long loadType;
    
    private String nameCat;//资讯所属分类名称
    
    private String firstTitle;//标题

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId == null ? null : newId.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl == null ? null : newUrl.trim();
    }

    public Long getLoadType() {
        return loadType;
    }

    public void setLoadType(Long loadType) {
        this.loadType = loadType;
    }

	public String getNameCat() {
		return nameCat;
	}

	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}

	public String getFirstTitle() {
		return firstTitle;
	}

	public void setFirstTitle(String firstTitle) {
		this.firstTitle = firstTitle;
	}
}