package com.qlzy.model;

import java.io.Serializable;

import com.qlzy.pojo.Base;

public class Zhuanpan extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String name;

    private Long gailv;

    private String message;

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

    public Long getGailv() {
        return gailv;
    }

    public void setGailv(Long gailv) {
        this.gailv = gailv;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}