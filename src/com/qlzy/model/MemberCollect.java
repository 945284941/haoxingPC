package com.qlzy.model;

import java.util.Date;

import java.io.Serializable;

public class MemberCollect implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String userId;

	private String collectId;

	private Date collectTime;

	private String collectIp;

	private String userType;

	private String type;

	private String cid;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	//辅助字段
	private String goodsName;
	private String companyName;
	private String companyId;
	private String shoperName;
	private String shoperContent;
	private String img;

	private Double price;//现价
	private String yuanjia;//原价
	private String store;//库存
	private String queryNum;//总销量
	private String name;//商品名称
	private String enName;//商品英文名称
	private String praiseRate;//好评率
	private String defaultPicSrc;//默认图片路径
	private String goodsId;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getPraiseRate() {
		return praiseRate;
	}

	public void setPraiseRate(String praiseRate) {
		this.praiseRate = praiseRate;
	}

	public String getYuanjia() {
		return yuanjia;

	}

	public void setYuanjia(String yuanjia) {
		this.yuanjia = yuanjia;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getQueryNum() {
		return queryNum;
	}

	public void setQueryNum(String queryNum) {
		this.queryNum = queryNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getShoperName() {
		return shoperName;
	}

	public void setShoperName(String shoperName) {
		this.shoperName = shoperName;
	}

	public String getShoperContent() {
		return shoperContent;
	}

	public void setShoperContent(String shoperContent) {
		this.shoperContent = shoperContent;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the collectId
	 */
	public String getCollectId() {
		return collectId;
	}

	/**
	 * @param collectId the collectId to set
	 */
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}

	/**
	 * @return the collectTime
	 */
	public Date getCollectTime() {
		return collectTime;
	}

	/**
	 * @param collectTime the collectTime to set
	 */
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	/**
	 * @return the collectIp
	 */
	public String getCollectIp() {
		return collectIp;
	}

	/**
	 * @param collectIp the collectIp to set
	 */
	public void setCollectIp(String collectIp) {
		this.collectIp = collectIp;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * @return the defaultPicSrc
	 */
	public String getDefaultPicSrc() {
		return defaultPicSrc;
	}

	/**
	 * @param defaultPicSrc the defaultPicSrc to set
	 */
	public void setDefaultPicSrc(String defaultPicSrc) {
		this.defaultPicSrc = defaultPicSrc;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


}