package com.qlzy.model;

import com.qlzy.util.Pagination;

import java.io.Serializable;

public class SearchKeyWord extends Pagination implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Long clickNum;

    private String pinName;

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

    
    public Long getClickNum() {
		return clickNum;
	}

	public void setClickNum(Long clickNum) {
		this.clickNum = clickNum;
	}

	public String getPinName() {
        return pinName;
    }

    public void setPinName(String pinName) {
        this.pinName = pinName == null ? null : pinName.trim();
    }
}