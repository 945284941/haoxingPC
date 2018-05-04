package com.qlzy.model;

import java.io.Serializable;

import com.qlzy.pojo.Base;

public class GoodsCarBrand extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
    private String id;
    private String goodsId;
    private String carBrandId;
    private String disabled;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getCarBrandId() {
		return carBrandId;
	}
	public void setCarBrandId(String carBrandId) {
		this.carBrandId = carBrandId;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
    
   
}