package com.qlzy.model;

import java.io.Serializable;

public class GoodsHotPic implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String goodsHotId;
	private String picSrc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsHotId() {
		return goodsHotId;
	}

	public void setGoodsHotId(String goodsHotId) {
		this.goodsHotId = goodsHotId;
	}

	public String getPicSrc() {
		return picSrc;
	}

	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}

}
