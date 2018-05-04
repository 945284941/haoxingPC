package com.qlzy.model;



import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class ZhuanpanLog extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String memberId;

    private Double point;

    private String ramark;

    private String zhuanpanId;

    private String status;

    private Date createtime;

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

   

    public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public String getRamark() {
        return ramark;
    }

    public void setRamark(String ramark) {
        this.ramark = ramark == null ? null : ramark.trim();
    }

    public String getZhuanpanId() {
        return zhuanpanId;
    }

    public void setZhuanpanId(String zhuanpanId) {
        this.zhuanpanId = zhuanpanId == null ? null : zhuanpanId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}