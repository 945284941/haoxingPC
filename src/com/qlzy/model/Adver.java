package com.qlzy.model;

import java.math.BigDecimal;
import java.util.Date;

import java.io.Serializable;

public class Adver implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private BigDecimal position;

    private String adverSize;

    private BigDecimal type;

    private String imgSrc;

    private String url;

    private Date starttime;

    private Date endtime;

    private BigDecimal lowestBidAmount;

    private BigDecimal successBidAmount;

    private BigDecimal bidStatus;
    
    private Integer floor;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPosition() {
        return position;
    }

    public void setPosition(BigDecimal position) {
        this.position = position;
    }

    public String getAdverSize() {
        return adverSize;
    }

    public void setAdverSize(String adverSize) {
        this.adverSize = adverSize == null ? null : adverSize.trim();
    }

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc == null ? null : imgSrc.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public BigDecimal getLowestBidAmount() {
        return lowestBidAmount;
    }

    public void setLowestBidAmount(BigDecimal lowestBidAmount) {
        this.lowestBidAmount = lowestBidAmount;
    }

    public BigDecimal getSuccessBidAmount() {
        return successBidAmount;
    }

    public void setSuccessBidAmount(BigDecimal successBidAmount) {
        this.successBidAmount = successBidAmount;
    }

    public BigDecimal getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(BigDecimal bidStatus) {
        this.bidStatus = bidStatus;
    }

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}
    
}