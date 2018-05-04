package com.qlzy.model;

import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class MemeberDeail  extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;

    private String memberid;

    private String message;

    private Long num;

    private String zengsongtype;

    private Double guliangbinum;

    private String stutas;

    private Date createtime;
    
    private Date updatetime;
    
    private String userId;
    
    private Double point;
    
    private String youhuiquanid;
    
    private String youhuiquanname;
    
    private String membername;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getZengsongtype() {
        return zengsongtype;
    }

    public void setZengsongtype(String zengsongtype) {
        this.zengsongtype = zengsongtype == null ? null : zengsongtype.trim();
    }

  

    public Double getGuliangbinum() {
		return guliangbinum;
	}

	public void setGuliangbinum(Double guliangbinum) {
		this.guliangbinum = guliangbinum;
	}

	public String getStutas() {
        return stutas;
    }

    public void setStutas(String stutas) {
        this.stutas = stutas == null ? null : stutas.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public String getYouhuiquanid() {
		return youhuiquanid;
	}

	public void setYouhuiquanid(String youhuiquanid) {
		this.youhuiquanid = youhuiquanid;
	}

	public String getYouhuiquanname() {
		return youhuiquanname;
	}

	public void setYouhuiquanname(String youhuiquanname) {
		this.youhuiquanname = youhuiquanname;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	
    
}