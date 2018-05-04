package com.qlzy.model;

import java.io.Serializable;

public class GoodsPic implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String goodsId;

    private String companyId;

    private String picSrc;

    private String thumbPicSrc;

    private String standardPicSrc;

    private Double picSize;

    private Double width;

    private Double height;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc == null ? null : picSrc.trim();
    }

    public String getThumbPicSrc() {
        return thumbPicSrc;
    }

    public void setThumbPicSrc(String thumbPicSrc) {
        this.thumbPicSrc = thumbPicSrc == null ? null : thumbPicSrc.trim();
    }

    public String getStandardPicSrc() {
        return standardPicSrc;
    }

    public void setStandardPicSrc(String standardPicSrc) {
        this.standardPicSrc = standardPicSrc == null ? null : standardPicSrc.trim();
    }

    public Double getPicSize() {
        return picSize;
    }

    public void setPicSize(Double picSize) {
        this.picSize = picSize;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}