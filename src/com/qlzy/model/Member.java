package com.qlzy.model;

import java.math.BigDecimal;
import java.util.Date;

import com.qlzy.pojo.Base;

import java.io.Serializable;

public class Member extends Base implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String password;

    private String truename;

    private String firstname;

    private String cardFront;

    private String cardReverse;

    private String lastname;

    private String area;

    private String city;

    private String mobile;

    private String telphone;

    private String email;

    private String zip;

    private String address;

    private String gender;
    
    private String education;

    private String vocation;

    private String qrCode;//二维码图片



    private String interest;

    private Double advance;

    private Double point;

    private String regIp;

    private Date regTime;

    private Double state;

    private String pwdAnswer;

    private String pwdQuestion;

    private String disabled;

    private String remark;

    private String remarkType;

    private String card;

    private String type;

    private String province;

    private String payPassword;
    
    private String age;
    
    private String scopes;
    
    private Integer jobRole;
    
    private String engageindustry;

    private Date lastLoginTime;
    
    private BigDecimal rewardMoney;
    
    private String recommendUserId;
    
    private Integer emailStatus;

    private Integer mobileStatus;

    private String questionId;

    private String questionAnswer;

    private String lastLoginIp;
    
    private String birthday;

    private String img;

    private Integer isonline;

    private String mysignature;

    private String zitiname;

    private BigDecimal fontsize;

    private BigDecimal fontstyle;

    private String namecolor;

    private String contentcolor;

    private String lookandfeel;

    private String tishi;

    private String istop;

    private String savepath;

    private String isshow;    
    private String shangjiId;   
    private String onlyId;   
    private String isQuxian;  
    private String isXiaofei;  
    // 以下为扩展字段
    private String engageindustryname;// 升级vip粮票是否充足
    private String pname;// 省名称
    private String cname;// 市名称
    private String aname;// 区或县名称
    private Integer accountSecurityScore;// 账号安全评分
    private String question;// 安全保护问题
    private String randNum;// 验证码

    private Long yiji;
    private Long yijivip;
    private Long erji;
    private Long erjivip;
    private Long sanji;
    private Long sanjivip;
    private Long yijifensi;

    private Double shouyi;
    private Double yujiticheng;
    private Double yijiticheng;
    private Double erjiticheng;
    
    private Double liucunbi;
    private Double xianjinbi;



    private Double zhekou;
    private Double maxPoint;
    private Double minPoint;

    private String qq;
    private String weiXin;
    private String memberLvName;
    private Long count;
    private BigDecimal total;
    private BigDecimal ticheng;
    private String memberName;

    private String dengji;

    public String getDengji() {
        return dengji;
    }

    public void setDengji(String dengji) {
        this.dengji = dengji;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTicheng() {
        return ticheng;
    }

    public void setTicheng(BigDecimal ticheng) {
        this.ticheng = ticheng;
    }

    public String getMemberLvName() {
        return memberLvName;
    }

    public void setMemberLvName(String memberLvName) {
        this.memberLvName = memberLvName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeiXin() {
        return weiXin;
    }

    public void setWeiXin(String weiXin) {
        this.weiXin = weiXin;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname == null ? null : firstname.trim();
    }

    public String getCardFront() {
        return cardFront;
    }

    public void setCardFront(String cardFront) {
        this.cardFront = cardFront;
    }

    public String getCardReverse() {
        return cardReverse;
    }

    public void setCardReverse(String cardReverse) {
        this.cardReverse = cardReverse;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getVocation() {
        return vocation;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation == null ? null : vocation.trim();
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
        this.advance = advance;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp == null ? null : regIp.trim();
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Double getState() {
        return state;
    }

    public void setState(Double state) {
        this.state = state;
    }

    public String getPwdAnswer() {
        return pwdAnswer;
    }

    public void setPwdAnswer(String pwdAnswer) {
        this.pwdAnswer = pwdAnswer == null ? null : pwdAnswer.trim();
    }

    public String getPwdQuestion() {
        return pwdQuestion;
    }

    public void setPwdQuestion(String pwdQuestion) {
        this.pwdQuestion = pwdQuestion == null ? null : pwdQuestion.trim();
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

    public String getRemarkType() {
        return remarkType;
    }

    public void setRemarkType(String remarkType) {
        this.remarkType = remarkType == null ? null : remarkType.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }



	public Integer getJobRole() {
		return jobRole;
	}

	public void setJobRole(Integer jobRole) {
		this.jobRole = jobRole;
	}

	public String getScopes() {
		return scopes;
	}

	public void setScopes(String scopes) {
		this.scopes = scopes;
	}
	
    public String getEngageindustry() {
        return engageindustry;
    }

    public void setEngageindustry(String engageindustry) {
        this.engageindustry = engageindustry == null ? null : engageindustry.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    public BigDecimal getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(BigDecimal rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

	public String getEngageindustryname() {
		return engageindustryname;
	}

	public void setEngageindustryname(String engageindustryname) {
		this.engageindustryname = engageindustryname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	/**
	 * @return the recommendUserId
	 */
	public String getRecommendUserId() {
		return recommendUserId;
	}

	/**
	 * @param recommendUserId the recommendUserId to set
	 */
	public void setRecommendUserId(String recommendUserId) {
		this.recommendUserId = recommendUserId;
	}    
	
    public Integer getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(Integer emailStatus) {
        this.emailStatus = emailStatus;
    }

    public Integer getMobileStatus() {
        return mobileStatus;
    }

    public void setMobileStatus(Integer mobileStatus) {
        this.mobileStatus = mobileStatus;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer == null ? null : questionAnswer.trim();
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

	public Integer getAccountSecurityScore() {
		return accountSecurityScore;
	}

	public void setAccountSecurityScore(Integer accountSecurityScore) {
		this.accountSecurityScore = accountSecurityScore;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

   

    public Integer getIsonline() {
		return isonline;
	}

	public void setIsonline(Integer isonline) {
		this.isonline = isonline;
	}

	public String getMysignature() {
        return mysignature;
    }

    public void setMysignature(String mysignature) {
        this.mysignature = mysignature == null ? null : mysignature.trim();
    }

    public String getZitiname() {
        return zitiname;
    }

    public void setZitiname(String zitiname) {
        this.zitiname = zitiname == null ? null : zitiname.trim();
    }

    public BigDecimal getFontsize() {
        return fontsize;
    }

    public void setFontsize(BigDecimal fontsize) {
        this.fontsize = fontsize;
    }

    public BigDecimal getFontstyle() {
        return fontstyle;
    }

    public void setFontstyle(BigDecimal fontstyle) {
        this.fontstyle = fontstyle;
    }

    public String getNamecolor() {
        return namecolor;
    }

    public void setNamecolor(String namecolor) {
        this.namecolor = namecolor == null ? null : namecolor.trim();
    }

    public String getContentcolor() {
        return contentcolor;
    }

    public void setContentcolor(String contentcolor) {
        this.contentcolor = contentcolor == null ? null : contentcolor.trim();
    }

    public String getLookandfeel() {
        return lookandfeel;
    }

    public void setLookandfeel(String lookandfeel) {
        this.lookandfeel = lookandfeel == null ? null : lookandfeel.trim();
    }

    public String getTishi() {
        return tishi;
    }

    public void setTishi(String tishi) {
        this.tishi = tishi == null ? null : tishi.trim();
    }

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop == null ? null : istop.trim();
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath == null ? null : savepath.trim();
    }

    public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow == null ? null : isshow.trim();
    }

	public String getRandNum() {
		return randNum;
	}

	public void setRandNum(String randNum) {
		this.randNum = randNum;
	}

	public String getShangjiId() {
		return shangjiId;
	}

	public void setShangjiId(String shangjiId) {
		this.shangjiId = shangjiId;
	}

	public String getOnlyId() {
		return onlyId;
	}

	public void setOnlyId(String onlyId) {
		this.onlyId = onlyId;
	}



	public Double getZhekou() {
		return zhekou;
	}

	public void setZhekou(Double zhekou) {
		this.zhekou = zhekou;
	}

	

	

	public Long getYiji() {
		return yiji;
	}

	public void setYiji(Long yiji) {
		this.yiji = yiji;
	}

	public Long getYijivip() {
		return yijivip;
	}

	public void setYijivip(Long yijivip) {
		this.yijivip = yijivip;
	}

	public Long getErji() {
		return erji;
	}

	public void setErji(Long erji) {
		this.erji = erji;
	}

	public Long getErjivip() {
		return erjivip;
	}

	public void setErjivip(Long erjivip) {
		this.erjivip = erjivip;
	}

	public Long getSanji() {
		return sanji;
	}

	public void setSanji(Long sanji) {
		this.sanji = sanji;
	}

	public Long getSanjivip() {
		return sanjivip;
	}

	public void setSanjivip(Long sanjivip) {
		this.sanjivip = sanjivip;
	}

	public Double getLiucunbi() {
		return liucunbi;
	}

	public void setLiucunbi(Double liucunbi) {
		this.liucunbi = liucunbi;
	}

	public Double getXianjinbi() {
		return xianjinbi;
	}

	public void setXianjinbi(Double xianjinbi) {
		this.xianjinbi = xianjinbi;
	}

	public Double getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(Double maxPoint) {
		this.maxPoint = maxPoint;
	}

	public Double getMinPoint() {
		return minPoint;
	}

	public void setMinPoint(Double minPoint) {
		this.minPoint = minPoint;
	}

	public String getIsQuxian() {
		return isQuxian;
	}

	public void setIsQuxian(String isQuxian) {
		this.isQuxian = isQuxian;
	}

	public String getIsXiaofei() {
		return isXiaofei;
	}

	public void setIsXiaofei(String isXiaofei) {
		this.isXiaofei = isXiaofei;
	}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private  String bankcar;

    public String getBankcar() {
        return bankcar;
    }

    public void setBankcar(String bankcar) {
        this.bankcar = bankcar;
    }


    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Long getYijifensi() {
        return yijifensi;
    }

    public void setYijifensi(Long yijifensi) {
        this.yijifensi = yijifensi;
    }

    public Double getShouyi() {
        return shouyi;
    }

    public void setShouyi(Double shouyi) {
        this.shouyi = shouyi;
    }

    public Double getYujiticheng() {
        return yujiticheng;
    }

    public void setYujiticheng(Double yujiticheng) {
        this.yujiticheng = yujiticheng;
    }

    public Double getYijiticheng() {
        return yijiticheng;
    }

    public void setYijiticheng(Double yijiticheng) {
        this.yijiticheng = yijiticheng;
    }

    public Double getErjiticheng() {
        return erjiticheng;
    }

    public void setErjiticheng(Double erjiticheng) {
        this.erjiticheng = erjiticheng;
    }
}