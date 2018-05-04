package com.qlzy.model;


import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class Jiesuan extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private Double zonge;

    private String pici;

    private Date createtime;

    private String adminId;

    private Date starttime;

    private Date endtime;
    
    private String nianfen;
    
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Double getZonge() {
		return zonge;
	}

	public void setZonge(Double zonge) {
		this.zonge = zonge;
	}

	public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici == null ? null : pici.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

	public String getNianfen() {
		return nianfen;
	}

	public void setNianfen(String nianfen) {
		this.nianfen = nianfen;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}