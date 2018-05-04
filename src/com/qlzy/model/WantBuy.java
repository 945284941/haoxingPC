package com.qlzy.model;

import com.qlzy.util.Pagination;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class WantBuy extends Pagination implements Serializable {
    private String id;

    private String title;

    private String catId;

    private String fromCountryId;

    private String fromAddress;

    private String mobile;

    private String toCountryId;

    private String toAddress;

    private Date sendDate;

    private String goodsWeight;

    private String goodsSize;

    private String email;

    private String content;

    private Date createDate;

    private Date updateDate;

    private String delFlag;

    private String picUrl;

    private String memberId;

    private String buyType;
    private String picArry;
    private List<String> picList;

    private String countryName;
    private String catName;

    private String countryNameEng;
    private String catEnName;
    private String toCountryName;
    private String toCountryNameEng;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId == null ? null : catId.trim();
    }

    public String getFromCountryId() {
        return fromCountryId;
    }

    public void setFromCountryId(String fromCountryId) {
        this.fromCountryId = fromCountryId == null ? null : fromCountryId.trim();
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress == null ? null : fromAddress.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getToCountryId() {
        return toCountryId;
    }

    public void setToCountryId(String toCountryId) {
        this.toCountryId = toCountryId == null ? null : toCountryId.trim();
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress == null ? null : toAddress.trim();
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(String goodsWeight) {
        this.goodsWeight = goodsWeight == null ? null : goodsWeight.trim();
    }

    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize == null ? null : goodsSize.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType == null ? null : buyType.trim();
    }

    public String getPicArry() {
        return picArry;
    }

    public void setPicArry(String picArry) {
        this.picArry = picArry;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCountryNameEng() {
        return countryNameEng;
    }

    public void setCountryNameEng(String countryNameEng) {
        this.countryNameEng = countryNameEng;
    }

    public String getCatEnName() {
        return catEnName;
    }

    public void setCatEnName(String catEnName) {
        this.catEnName = catEnName;
    }

    public String getToCountryName() {
        return toCountryName;
    }

    public void setToCountryName(String toCountryName) {
        this.toCountryName = toCountryName;
    }

    public String getToCountryNameEng() {
        return toCountryNameEng;
    }

    public void setToCountryNameEng(String toCountryNameEng) {
        this.toCountryNameEng = toCountryNameEng;
    }
}