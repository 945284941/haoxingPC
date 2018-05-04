package com.qlzy.model;

import java.io.Serializable;

import com.qlzy.pojo.Base;

public class GoodsLabel extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String id;
    private String name;
    private String disabled;
    private String remark;
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
		this.name = name;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}