package com.qlzy.model;


import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class CourtesyCard extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String name;

    private Date startTime;

    private Date timerange;

    private Double price;

    private String title;

    private String message;

    private String type;

    private Double priceMin;

    private String huodongId;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getTimerange() {
        return timerange;
    }

    public void setTimerange(Date timerange) {
        this.timerange = timerange;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Double priceMin) {
        this.priceMin = priceMin;
    }

    public String getHuodongId() {
        return huodongId;
    }

    public void setHuodongId(String huodongId) {
        this.huodongId = huodongId == null ? null : huodongId.trim();
    }
}