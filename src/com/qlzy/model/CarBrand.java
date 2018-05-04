package com.qlzy.model;

import com.qlzy.pojo.Base;

import java.io.Serializable;

public class CarBrand extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String pid;

    private String name;

    private String pic;

    private String remark;

    private String carTypeId;

    private String disabled;

    private String pOrder;

    private String ptree;
    
    private Integer grade;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(String carTypeId) {
        this.carTypeId = carTypeId == null ? null : carTypeId.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    public String getpOrder() {
        return pOrder;
    }

    public void setpOrder(String pOrder) {
        this.pOrder = pOrder == null ? null : pOrder.trim();
    }

    public String getPtree() {
        return ptree;
    }

    public void setPtree(String ptree) {
        this.ptree = ptree == null ? null : ptree.trim();
    }

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
    
}