package com.qlzy.model;

import java.io.Serializable;

public class Khzj implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String khContent;

    private String tpUsername;

    private String tpTelphone;

    private String khContentid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getKhContent() {
        return khContent;
    }

    public void setKhContent(String khContent) {
        this.khContent = khContent == null ? null : khContent.trim();
    }

    public String getTpUsername() {
        return tpUsername;
    }

    public void setTpUsername(String tpUsername) {
        this.tpUsername = tpUsername == null ? null : tpUsername.trim();
    }

    public String getTpTelphone() {
        return tpTelphone;
    }

    public void setTpTelphone(String tpTelphone) {
        this.tpTelphone = tpTelphone == null ? null : tpTelphone.trim();
    }

	public String getKhContentid() {
		return khContentid;
	}

	public void setKhContentid(String khContentid) {
		this.khContentid = khContentid;
	}

	

	

   
}