package com.qlzy.model;


import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class JiesuanItem extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String memberId;

    private Double count;

    private String status;

    private String pici;
    
    private String goodsId;

    private String remark;

    private Date createtime;

    private Long num;
    
    private String username;
    
    private Long yinum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

   

    public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici == null ? null : pici.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setYinum(Long yinum) {
		this.yinum = yinum;
	}

	public Long getYinum() {
		return yinum;
	}

    
}