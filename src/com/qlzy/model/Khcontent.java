package com.qlzy.model;


import java.io.Serializable;

public class Khcontent implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String khContent;

    private Integer khPonit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getKhContent() {
        return khContent;
    }

    public void setKhContent(String khContent) {
        this.khContent = khContent == null ? null : khContent.trim();
    }

	public Integer getKhPonit() {
		return khPonit;
	}

	public void setKhPonit(Integer khPonit) {
		this.khPonit = khPonit;
	}

   
}