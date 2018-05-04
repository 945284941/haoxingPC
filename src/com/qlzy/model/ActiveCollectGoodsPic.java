package com.qlzy.model;

import java.io.Serializable;

public class ActiveCollectGoodsPic implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String goodsId;

    private String src;

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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }
}