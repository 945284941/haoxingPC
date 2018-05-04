package com.qlzy.model;

import javax.persistence.Transient;

import java.io.Serializable;

public class GoodsItem implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String productId;

    private String attrJson;

    private String skuJsonHz;

    private String skuJson;

    private Integer store;

    private Double price;

    private Integer status;

    private String bn;

    private String code;

    private String skuJsonHf;
    
    @Transient
    private Goods goods;

    public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getAttrJson() {
        return attrJson;
    }

    public void setAttrJson(String attrJson) {
        this.attrJson = attrJson == null ? null : attrJson.trim();
    }

    public String getSkuJsonHz() {
        return skuJsonHz;
    }

    public void setSkuJsonHz(String skuJsonHz) {
        this.skuJsonHz = skuJsonHz == null ? null : skuJsonHz.trim();
    }

    public String getSkuJson() {
        return skuJson;
    }

    public void setSkuJson(String skuJson) {
        this.skuJson = skuJson == null ? null : skuJson.trim();
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBn() {
        return bn;
    }

    public void setBn(String bn) {
        this.bn = bn == null ? null : bn.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSkuJsonHf() {
        return skuJsonHf;
    }

    public void setSkuJsonHf(String skuJsonHf) {
        this.skuJsonHf = skuJsonHf == null ? null : skuJsonHf.trim();
    }
}