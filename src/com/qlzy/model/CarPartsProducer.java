package com.qlzy.model;

import java.io.Serializable;

import com.qlzy.pojo.Base;

public class CarPartsProducer extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String name;

    private String remark;

    private String disabled;
    
    private String p_order;

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

	/**
	 * @return the p_order
	 */
	public String getP_order() {
		return p_order;
	}

	/**
	 * @param p_order the p_order to set
	 */
	public void setP_order(String p_order) {
		this.p_order = p_order;
	}
}