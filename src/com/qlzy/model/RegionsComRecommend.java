package com.qlzy.model;

import java.util.Date;

import com.qlzy.util.Pagination;

import java.io.Serializable;

public class RegionsComRecommend extends Pagination implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String goodsCatId;

    private String companyId;

    private String province;

    private String city;

    private Date createtime;

    private Date modifytime;

    private String userId;
    
   
    
    /**
     * 以下为扩展字段
     */
    private String companyName;
    private String comSrc;
    private Integer floor;
    private String carBrandStr;
    private String vipGrade;
    private String pname;
    private String cname;
    private String aname;
    private String address;
    private String mobile;
    private String telePhone;
    private Date regTime;
    private String pcaa;
    private String vipGradeImgSrc;// 会员等级图标
    private String vipLevelName;// 会员等级名称
    private String qualityImgSrc;// 质量等级图标
    private String creditImgSrc;// 信誉等级图标
    private String serveImgSrc;// 服务等级图标
    private String logisticsImgSrc;// 物流等级图标
    private String mainCarBrand;//主销车型
    private String topSearchLike;//首页搜寻
    private String qqNumber;//QQ客服
    
    public String getId() {
        return id;
    }

    public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsCatId() {
        return goodsCatId;
    }

    public void setGoodsCatId(String goodsCatId) {
        this.goodsCatId = goodsCatId == null ? null : goodsCatId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getComSrc() {
		return comSrc;
	}

	public void setComSrc(String comSrc) {
		this.comSrc = comSrc;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getCarBrandStr() {
		return carBrandStr;
	}

	public void setCarBrandStr(String carBrandStr) {
		this.carBrandStr = carBrandStr;
	}

	public String getVipGrade() {
		return vipGrade;
	}

	public void setVipGrade(String vipGrade) {
		this.vipGrade = vipGrade;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getPcaa() {
		return pcaa;
	}

	public void setPcaa(String pcaa) {
		this.pcaa = pcaa;
	}

	public String getVipGradeImgSrc() {
		return vipGradeImgSrc;
	}

	public void setVipGradeImgSrc(String vipGradeImgSrc) {
		this.vipGradeImgSrc = vipGradeImgSrc;
	}

	public String getQualityImgSrc() {
		return qualityImgSrc;
	}

	public void setQualityImgSrc(String qualityImgSrc) {
		this.qualityImgSrc = qualityImgSrc;
	}

	public String getCreditImgSrc() {
		return creditImgSrc;
	}

	public void setCreditImgSrc(String creditImgSrc) {
		this.creditImgSrc = creditImgSrc;
	}

	public String getServeImgSrc() {
		return serveImgSrc;
	}

	public void setServeImgSrc(String serveImgSrc) {
		this.serveImgSrc = serveImgSrc;
	}

	public String getLogisticsImgSrc() {
		return logisticsImgSrc;
	}

	public void setLogisticsImgSrc(String logisticsImgSrc) {
		this.logisticsImgSrc = logisticsImgSrc;
	}

	public String getVipLevelName() {
		return vipLevelName;
	}

	public void setVipLevelName(String vipLevelName) {
		this.vipLevelName = vipLevelName;
	}

	public String getMainCarBrand() {
		return mainCarBrand;
	}

	public void setMainCarBrand(String mainCarBrand) {
		this.mainCarBrand = mainCarBrand;
	}

	public String getTopSearchLike() {
		return topSearchLike;
	}

	public void setTopSearchLike(String topSearchLike) {
		this.topSearchLike = topSearchLike;
	}
	
}