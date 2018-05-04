package com.qlzy.model;

import java.io.Serializable;

public class MemberLv implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Double minPoint;

    private String type;

    private Double discount;

    private String disabled;

    private Double maxPoint;

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

    public Double getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(Double minPoint) {
        this.minPoint = minPoint;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    public Double getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Double maxPoint) {
        this.maxPoint = maxPoint;
    }
}