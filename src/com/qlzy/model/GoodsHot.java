package com.qlzy.model;

import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class GoodsHot extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String companyName; // 公司名称

	private String activeContent;// 促销商品活动内容

	private String companyLinkPhone;// 联系电话

	private Integer isShow; // 1促销显示，2促销结束

	private String defaultPicSrc;// 默认图片路径

	private String bn;// 原厂编号
	
	private String optimalCar;// 适用车系
	
	private Date activeStartTime;// 活动开始时间
	
	private Date activeEndTime;// 活动结束时间
	public Double getyPrice() {
		return yPrice;
	}

	public void setyPrice(Double yPrice) {
		this.yPrice = yPrice;
	}

	private Date goodsHotTime;//商品时间（添加或修改）
	private String activeGoodsAddr;// 促销商品地址
	
	private Integer activeType;// 活动类型 1特卖 2 普通 3过期
	
	private String userId;
	private String userName;
	
	private Integer shActiveType;
	private Double  cxPrice;
	private Double  yPrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getActiveContent() {
		return activeContent;
	}

	public void setActiveContent(String activeContent) {
		this.activeContent = activeContent;
	}

	public String getCompanyLinkPhone() {
		return companyLinkPhone;
	}

	public void setCompanyLinkPhone(String companyLinkPhone) {
		this.companyLinkPhone = companyLinkPhone;
	}

	public String getDefaultPicSrc() {
		return defaultPicSrc;
	}

	public void setDefaultPicSrc(String defaultPicSrc) {
		this.defaultPicSrc = defaultPicSrc;
	}

	public String getBn() {
		return bn;
	}

	public void setBn(String bn) {
		this.bn = bn;
	}

	public String getOptimalCar() {
		return optimalCar;
	}

	public void setOptimalCar(String optimalCar) {
		this.optimalCar = optimalCar;
	}

	public Date getActiveStartTime() {
		return activeStartTime;
	}

	public void setActiveStartTime(Date activeStartTime) {
		this.activeStartTime = activeStartTime;
	}

	public Date getActiveEndTime() {
		return activeEndTime;
	}

	public void setActiveEndTime(Date activeEndTime) {
		this.activeEndTime = activeEndTime;
	}

	public String getActiveGoodsAddr() {
		return activeGoodsAddr;
	}

	public void setActiveGoodsAddr(String activeGoodsAddr) {
		this.activeGoodsAddr = activeGoodsAddr;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getActiveType() {
		return activeType;
	}

	public void setActiveType(Integer activeType) {
		this.activeType = activeType;
	}

	public Date getGoodsHotTime() {
		return goodsHotTime;
	}

	public void setGoodsHotTime(Date goodsHotTime) {
		this.goodsHotTime = goodsHotTime;
	}

	public Integer getShActiveType() {
		return shActiveType;
	}

	public void setShActiveType(Integer shActiveType) {
		this.shActiveType = shActiveType;
	}

	public Double getCxPrice() {
		return cxPrice;
	}

	public void setCxPrice(Double cxPrice) {
		this.cxPrice = cxPrice;
	}


	

}