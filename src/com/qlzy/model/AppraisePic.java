package com.qlzy.model;

import java.io.Serializable;

public class AppraisePic implements Serializable {
    private String id;

    private String picUrl;

    private String appraiseId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getAppraiseId() {
        return appraiseId;
    }

    public void setAppraiseId(String appraiseId) {
        this.appraiseId = appraiseId == null ? null : appraiseId.trim();
    }
}