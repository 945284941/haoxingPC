package com.qlzy.model;

import com.qlzy.pojo.Base;
import com.qlzy.util.Pagination;

import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Company extends Pagination implements Serializable {
    private String id;

    private String username;

    private String password;

    private String area;

    private String city;

    private String mobile;

    private String telphone;

    private String email;

    private String zip;

    private String address;

    private BigDecimal advance;

    private BigDecimal point;

    private String regIp;

    private Date regTime;

    private BigDecimal state;

    private Integer clickNum;

    private String pwdAnswer;

    private String pwdQuestion;

    private String disabled;

    private String remark;

    private String remarkType;

    private String card;

    private String companyName;

    private String licenceSrc;

    private String corporationName;

    private String licenceNum;

    private String linkmanName;

    private String linkmanPhone;

    private String linkmanMobile;

    private String linkmanAddress;

    private String licenceEndDate;

    private String licenceAddress;

    private String organizationNum;

    private String companyLogo;

    private String companyBankName;

    private String companyBankNum;

    private String accountName;

    private String bankArea;

    private String bankAddress;

    private String province;

    private String storefrontSrc;

    private BigDecimal jobRole;

    private BigDecimal linkmanSex;

    private BigDecimal linkmanAge;

    private String scopes;

    private String combrief;

    private String vipGrade;

    private Date modifytime;

    private String companyPurpose;

    private String domain;

    private String payPassword;

    private String birthday;

    private String img;

    private BigDecimal isonline;

    private String mysignature;

    private String zitiname;

    private BigDecimal fontsize;

    private BigDecimal fontstyle;

    private String namecolor;

    private String contentcolor;

    private String tishi;

    private String istop;

    private String savepath;

    private String lookandfeel;

    private String isshow;

    private Date lastLoginTime;

    private String recommendUserid;

    private BigDecimal emailStatus;

    private BigDecimal mobileStatus;

    private String questionId;

    private String questionAnswer;

    private String lastLoginIp;

    private String mainCarbrand;

    private String isCheck;

    private String shCheck;

    private String qqNumber;

    private BigDecimal guaranteeprice;

    private String shoperName;

    private String shoperContent;

    private Integer attentionCount;

    private String countryId;

    private String cardUrl;

    private Date openTime;

    private String productIntroduction;

    private String operatorId;

    private String isBuilding;

    private String isMarket;

    private String isShop;

    private String isGroup;

    private String isFlashSale;

    private String sellRange;

    private List<String> imgList;

    @Transient
    private List<Cart> cartList;
    @Transient
    private List<Goods> goodsList;
    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
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

    public BigDecimal getAdvance() {
        return advance;
    }

    public void setAdvance(BigDecimal advance) {
        this.advance = advance;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
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

    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getLicenceSrc() {
        return licenceSrc;
    }

    public void setLicenceSrc(String licenceSrc) {
        this.licenceSrc = licenceSrc == null ? null : licenceSrc.trim();
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName == null ? null : corporationName.trim();
    }

    public String getLicenceNum() {
        return licenceNum;
    }

    public void setLicenceNum(String licenceNum) {
        this.licenceNum = licenceNum == null ? null : licenceNum.trim();
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName == null ? null : linkmanName.trim();
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone == null ? null : linkmanPhone.trim();
    }

    public String getLinkmanMobile() {
        return linkmanMobile;
    }

    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile == null ? null : linkmanMobile.trim();
    }

    public String getLinkmanAddress() {
        return linkmanAddress;
    }

    public void setLinkmanAddress(String linkmanAddress) {
        this.linkmanAddress = linkmanAddress == null ? null : linkmanAddress.trim();
    }

    public String getLicenceEndDate() {
        return licenceEndDate;
    }

    public void setLicenceEndDate(String licenceEndDate) {
        this.licenceEndDate = licenceEndDate == null ? null : licenceEndDate.trim();
    }

    public String getLicenceAddress() {
        return licenceAddress;
    }

    public void setLicenceAddress(String licenceAddress) {
        this.licenceAddress = licenceAddress == null ? null : licenceAddress.trim();
    }

    public String getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(String organizationNum) {
        this.organizationNum = organizationNum == null ? null : organizationNum.trim();
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo == null ? null : companyLogo.trim();
    }

    public String getCompanyBankName() {
        return companyBankName;
    }

    public void setCompanyBankName(String companyBankName) {
        this.companyBankName = companyBankName == null ? null : companyBankName.trim();
    }

    public String getCompanyBankNum() {
        return companyBankNum;
    }

    public void setCompanyBankNum(String companyBankNum) {
        this.companyBankNum = companyBankNum == null ? null : companyBankNum.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getBankArea() {
        return bankArea;
    }

    public void setBankArea(String bankArea) {
        this.bankArea = bankArea == null ? null : bankArea.trim();
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress == null ? null : bankAddress.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getStorefrontSrc() {
        return storefrontSrc;
    }

    public void setStorefrontSrc(String storefrontSrc) {
        this.storefrontSrc = storefrontSrc == null ? null : storefrontSrc.trim();
    }

    public BigDecimal getJobRole() {
        return jobRole;
    }

    public void setJobRole(BigDecimal jobRole) {
        this.jobRole = jobRole;
    }

    public BigDecimal getLinkmanSex() {
        return linkmanSex;
    }

    public void setLinkmanSex(BigDecimal linkmanSex) {
        this.linkmanSex = linkmanSex;
    }

    public BigDecimal getLinkmanAge() {
        return linkmanAge;
    }

    public void setLinkmanAge(BigDecimal linkmanAge) {
        this.linkmanAge = linkmanAge;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes == null ? null : scopes.trim();
    }

    public String getCombrief() {
        return combrief;
    }

    public void setCombrief(String combrief) {
        this.combrief = combrief == null ? null : combrief.trim();
    }

    public String getVipGrade() {
        return vipGrade;
    }

    public void setVipGrade(String vipGrade) {
        this.vipGrade = vipGrade == null ? null : vipGrade.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getCompanyPurpose() {
        return companyPurpose;
    }

    public void setCompanyPurpose(String companyPurpose) {
        this.companyPurpose = companyPurpose == null ? null : companyPurpose.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
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

    public BigDecimal getIsonline() {
        return isonline;
    }

    public void setIsonline(BigDecimal isonline) {
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

    public String getLookandfeel() {
        return lookandfeel;
    }

    public void setLookandfeel(String lookandfeel) {
        this.lookandfeel = lookandfeel == null ? null : lookandfeel.trim();
    }

    public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow == null ? null : isshow.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRecommendUserid() {
        return recommendUserid;
    }

    public void setRecommendUserid(String recommendUserid) {
        this.recommendUserid = recommendUserid == null ? null : recommendUserid.trim();
    }

    public BigDecimal getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(BigDecimal emailStatus) {
        this.emailStatus = emailStatus;
    }

    public BigDecimal getMobileStatus() {
        return mobileStatus;
    }

    public void setMobileStatus(BigDecimal mobileStatus) {
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

    public String getMainCarbrand() {
        return mainCarbrand;
    }

    public void setMainCarbrand(String mainCarbrand) {
        this.mainCarbrand = mainCarbrand == null ? null : mainCarbrand.trim();
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck == null ? null : isCheck.trim();
    }

    public String getShCheck() {
        return shCheck;
    }

    public void setShCheck(String shCheck) {
        this.shCheck = shCheck == null ? null : shCheck.trim();
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber == null ? null : qqNumber.trim();
    }

    public BigDecimal getGuaranteeprice() {
        return guaranteeprice;
    }

    public void setGuaranteeprice(BigDecimal guaranteeprice) {
        this.guaranteeprice = guaranteeprice;
    }

    public String getShoperName() {
        return shoperName;
    }

    public void setShoperName(String shoperName) {
        this.shoperName = shoperName == null ? null : shoperName.trim();
    }

    public String getShoperContent() {
        return shoperContent;
    }

    public void setShoperContent(String shoperContent) {
        this.shoperContent = shoperContent == null ? null : shoperContent.trim();
    }

    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId == null ? null : countryId.trim();
    }

    public String getCardUrl() {
        return cardUrl;
    }

    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl == null ? null : cardUrl.trim();
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getProductIntroduction() {
        return productIntroduction;
    }

    public void setProductIntroduction(String productIntroduction) {
        this.productIntroduction = productIntroduction == null ? null : productIntroduction.trim();
    }
    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getIsBuilding() {
        return isBuilding;
    }

    public void setIsBuilding(String isBuilding) {
        this.isBuilding = isBuilding == null ? null : isBuilding.trim();
    }

    public String getIsMarket() {
        return isMarket;
    }

    public void setIsMarket(String isMarket) {
        this.isMarket = isMarket == null ? null : isMarket.trim();
    }

    public String getIsShop() {
        return isShop;
    }

    public void setIsShop(String isShop) {
        this.isShop = isShop == null ? null : isShop.trim();
    }

    public String getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(String isGroup) {
        this.isGroup = isGroup == null ? null : isGroup.trim();
    }

    public String getIsFlashSale() {
        return isFlashSale;
    }

    public void setIsFlashSale(String isFlashSale) {
        this.isFlashSale = isFlashSale == null ? null : isFlashSale.trim();
    }

    public String getSellRange() {
        return sellRange;
    }

    public void setSellRange(String sellRange) {
        this.sellRange = sellRange == null ? null : sellRange.trim();
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}