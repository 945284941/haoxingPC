package com.qlzy.model;

import java.io.Serializable;

public class GoodsCatSh implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String pid;

    private String pTree;

    private String name;

    private String disabled;

    private Integer pOrder;

    private String keyWord;

    private Integer floor;

    private Integer grade;

    private String remark;
   // private String pNum;
    private String picSrc;
    private String pnum;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getpTree() {
        return pTree;
    }

    public void setpTree(String pTree) {
        this.pTree = pTree == null ? null : pTree.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }


    public Integer getpOrder() {
		return pOrder;
	}

	public void setpOrder(Integer pOrder) {
		this.pOrder = pOrder;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

   

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }


	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getPicSrc() {
		return picSrc;
	}

	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}
    
}