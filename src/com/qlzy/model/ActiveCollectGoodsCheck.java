package com.qlzy.model;

import java.util.Date;

import java.io.Serializable;

public class ActiveCollectGoodsCheck implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String goodsId;

    private String memberId;

    private Date createtime;

    private Date modifytime;

    private String disabled;

    private String gfields;

    private String gvalues;

    private String remark;

    private Double status;
    
    private Integer sourceType;
    
    private String acgName;//扩展字段
    
    private String dataName;//扩展字段
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

	/**
	 * @return the gfields
	 */
	public String getGfields() {
		return gfields;
	}

	/**
	 * @param gfields the gfields to set
	 */
	public void setGfields(String gfields) {
		this.gfields = gfields;
	}

	/**
	 * @return the gvalues
	 */
	public String getGvalues() {
		return gvalues;
	}

	/**
	 * @param gvalues the gvalues to set
	 */
	public void setGvalues(String gvalues) {
		this.gvalues = gvalues;
	}

	public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public String getAcgName() {
		return acgName;
	}

	public void setAcgName(String acgName) {
		this.acgName = acgName;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	
}