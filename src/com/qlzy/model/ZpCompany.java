package com.qlzy.model;

import java.io.Serializable;

import com.qlzy.pojo.Base;

public class ZpCompany extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String imageSrc;

    private String companyMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc == null ? null : imageSrc.trim();
    }

    public String getCompanyMessage() {
        return companyMessage;
    }

    public void setCompanyMessage(String companyMessage) {
        this.companyMessage = companyMessage == null ? null : companyMessage.trim();
    }
}