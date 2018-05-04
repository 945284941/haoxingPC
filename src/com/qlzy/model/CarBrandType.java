package com.qlzy.model;

import java.io.Serializable;

public class CarBrandType implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String remark;

    private String disabled;

    private Long porder;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

	public Long getPorder() {
		return porder;
	}

	public void setPorder(Long porder) {
		this.porder = porder;
	}

}