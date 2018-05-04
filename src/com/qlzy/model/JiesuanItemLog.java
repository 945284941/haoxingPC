package com.qlzy.model;


import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class JiesuanItemLog extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String jiesuanItemId;

    private Double count;

    private String jiesuanId;

    private String remark;

    private Date createtime;

    private Long pici;
    
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJiesuanItemId() {
        return jiesuanItemId;
    }

    public void setJiesuanItemId(String jiesuanItemId) {
        this.jiesuanItemId = jiesuanItemId == null ? null : jiesuanItemId.trim();
    }

   

    public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public String getJiesuanId() {
        return jiesuanId;
    }

    public void setJiesuanId(String jiesuanId) {
        this.jiesuanId = jiesuanId == null ? null : jiesuanId.trim();
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

	public Long getPici() {
		return pici;
	}

	public void setPici(Long pici) {
		this.pici = pici;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}