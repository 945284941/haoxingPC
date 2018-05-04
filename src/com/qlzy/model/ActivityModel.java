package com.qlzy.model;

import java.io.Serializable;

import com.qlzy.pojo.Base;

public class ActivityModel extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String name;

    private String urladdress;

    private Integer ordernum;

    private String disable;

    public String getId	() {
        return id	;
    }

    public void setId	(String id	) {
        this.id	 = id	 == null ? null : id	.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrladdress() {
        return urladdress;
    }

    public void setUrladdress(String urladdress) {
        this.urladdress = urladdress == null ? null : urladdress.trim();
    }
    public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable == null ? null : disable.trim();
    }
}