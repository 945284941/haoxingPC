package com.qlzy.model;

import java.io.Serializable;
import java.util.Date;

import com.qlzy.util.Pagination;

public class ActiveCollectGoods extends Pagination implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;

    private String name;

    private String bn;

    private Date createtime;

    private Date modifytime;

    private String memberid;

    private String disabled;

    private String brand;

    private String series;

    private String type;

    private String component;

    private String cat;

    private String glength;

    private String gwidth;

    private String gheight;

    private String gweight;

    private String gwheel;
    
    private String ginside;

    private String goutside;

    private String ghole;

    private Integer status;
    
    private Integer uploadType;
    
    private String defaultPic;//添加的字段,用于前台显示图片
    
    private Long uploadCount;//扩展字段
    
    private String memName;//扩展字段
    
    private Long uploadRank;//扩展字段
    
    private String dataName;//扩展字段
   
    private String ip;

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

    public String getBn() {
        return bn;
    }

    public void setBn(String bn) {
        this.bn = bn == null ? null : bn.trim();
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

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series == null ? null : series.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
    
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }
    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat == null ? null : cat.trim();
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	
	public String getGlength() {
		return glength;
	}

	public void setGlength(String glength) {
		this.glength = glength== null ? null : glength.trim();
	}

	public String getGwidth() {
		return gwidth;
	}

	public void setGwidth(String gwidth) {
		this.gwidth = gwidth == null ? null : gwidth.trim();
	}

	public String getGheight() {
		return gheight;
	}

	public void setGheight(String gheight) {
		this.gheight = gheight  == null ? null : gheight.trim();
	}

	public String getGweight() {
		return gweight;
	}

	public void setGweight(String gweight) {
		this.gweight = gweight  == null ? null : gweight.trim();
	}

	public String getGwheel() {
		return gwheel;
	}

	public void setGwheel(String gwheel) {
		this.gwheel = gwheel == null ? null : gwheel.trim();
	}

	public String getGinside() {
		return ginside;
	}

	public void setGinside(String ginside) {
		this.ginside = ginside ==null?null: ginside.trim();
	}

	public String getGoutside() {
		return goutside;
	}

	public void setGoutside(String goutside) {
		this.goutside = goutside==null? null:goutside.trim();
	}

	public String getGhole() {
		return ghole;
	}

	public void setGhole(String ghole) {
		this.ghole = ghole ==null? null:ghole.trim();
	}

	/**
	 * @return the defaultPic
	 */
	public String getDefaultPic() {
		return defaultPic;
	}

	/**
	 * @param defaultPic the defaultPic to set
	 */
	public void setDefaultPic(String defaultPic) {
		this.defaultPic = defaultPic ==null? null:defaultPic.trim();
	}

	/**
	 * @return the uploadType
	 */
	public Integer getUploadType() {
		return uploadType;
	}

	/**
	 * @param uploadType the uploadType to set
	 */
	public void setUploadType(Integer uploadType) {
		this.uploadType = uploadType;
	}

	public Long getUploadCount() {
		return uploadCount;
	}

	public void setUploadCount(Long uploadCount) {
		this.uploadCount = uploadCount;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public Long getUploadRank() {
		return uploadRank;
	}

	public void setUploadRank(Long uploadRank) {
		this.uploadRank = uploadRank;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
}