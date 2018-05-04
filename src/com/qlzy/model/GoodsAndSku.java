package com.qlzy.model;
import java.io.Serializable;

public class GoodsAndSku implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String goodsId;

    private String skuId;

    private String skuCode;

    private String skuName;

    private String skuOptionId;

    private String skuOptionCode;

    private String skuOptionValue;

    private Integer status;

    private String remark;

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

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public String getSkuOptionId() {
        return skuOptionId;
    }

    public void setSkuOptionId(String skuOptionId) {
        this.skuOptionId = skuOptionId == null ? null : skuOptionId.trim();
    }

    public String getSkuOptionCode() {
        return skuOptionCode;
    }

    public void setSkuOptionCode(String skuOptionCode) {
        this.skuOptionCode = skuOptionCode == null ? null : skuOptionCode.trim();
    }

    public String getSkuOptionValue() {
        return skuOptionValue;
    }

    public void setSkuOptionValue(String skuOptionValue) {
        this.skuOptionValue = skuOptionValue == null ? null : skuOptionValue.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}