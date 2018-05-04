package com.qlzy.model;

import java.util.Date;

import java.io.Serializable;

public class Supply implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String name;

    private String province;

    private String city;

    private String area;

    private String address;

    private Double price;

    private String picpath;

    private Date createtime;

    private Date effectivetime;

    private String linkman;

    private String linkmobile;

    private String qqEmail;

    private String status;

    private String disabled;

    private String typeId;

    private Long viewnum;

    private String userId;

    private String typeName;

    private String provinceId;

    private String cityId;

    private String areaId;

    private String producerId;

    private String producerName;

    private String carbrandId;

    private String carbrandName;

    private String carseriesId;

    private String carseriesName;

    private String cartypeId;

    private String cartypeName;

    private String carcatId;

    private String carcatName;

    private String carBn;

    private String quality;

    private String equipmentType;

    private String deliveryScope;

    private String transportMode;

    private String isRound;

    private String isTransit;

    private String isFixedshift;

    private String organizegoodsMode;

    private String goodsType;

    private String serviceMode;

    private String operateSort;

    private String jobNature;

    private String monthlypay;

    private String jobName;

    private String jobRequest;

    private String companyName;

    private String calling;

    private String companyAddress;

    private String companyScale;

    private String companyNature;

    private String education;

    private String workExperience;

    private String jobRank;

    private String color;

    private Date carFirstcardtime;

    private String hasAccident;

    private String hasCertificate;

    private String interiorCondition;

    private Long mileage;

    private String leaseType;

    private Double acreage;

    private String description;

    private String gender;

    private Date birthday;

    private String homeAddress;

    private String originPlace;

    private String certificate;

    private String jobPlace;

    private String jobCat;

    private String job;

    private String p1;

    private String p2;

    private String p3;

    private String p4;

    private String p5;

    private String p6;

    private String p7;

    private String p8;

    private String p9;

    private String p0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath == null ? null : picpath.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEffectivetime() {
        return effectivetime;
    }

    public void setEffectivetime(Date effectivetime) {
        this.effectivetime = effectivetime;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkmobile() {
        return linkmobile;
    }

    public void setLinkmobile(String linkmobile) {
        this.linkmobile = linkmobile == null ? null : linkmobile.trim();
    }

    public String getQqEmail() {
        return qqEmail;
    }

    public void setQqEmail(String qqEmail) {
        this.qqEmail = qqEmail == null ? null : qqEmail.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled == null ? null : disabled.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public Long getViewnum() {
        return viewnum;
    }

    public void setViewnum(Long viewnum) {
        this.viewnum = viewnum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId == null ? null : producerId.trim();
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName == null ? null : producerName.trim();
    }

    public String getCarbrandId() {
        return carbrandId;
    }

    public void setCarbrandId(String carbrandId) {
        this.carbrandId = carbrandId == null ? null : carbrandId.trim();
    }

    public String getCarbrandName() {
        return carbrandName;
    }

    public void setCarbrandName(String carbrandName) {
        this.carbrandName = carbrandName == null ? null : carbrandName.trim();
    }

    public String getCarseriesId() {
        return carseriesId;
    }

    public void setCarseriesId(String carseriesId) {
        this.carseriesId = carseriesId == null ? null : carseriesId.trim();
    }

    public String getCarseriesName() {
        return carseriesName;
    }

    public void setCarseriesName(String carseriesName) {
        this.carseriesName = carseriesName == null ? null : carseriesName.trim();
    }

    public String getCartypeId() {
        return cartypeId;
    }

    public void setCartypeId(String cartypeId) {
        this.cartypeId = cartypeId == null ? null : cartypeId.trim();
    }

    public String getCartypeName() {
        return cartypeName;
    }

    public void setCartypeName(String cartypeName) {
        this.cartypeName = cartypeName == null ? null : cartypeName.trim();
    }

    public String getCarcatId() {
        return carcatId;
    }

    public void setCarcatId(String carcatId) {
        this.carcatId = carcatId == null ? null : carcatId.trim();
    }

    public String getCarcatName() {
        return carcatName;
    }

    public void setCarcatName(String carcatName) {
        this.carcatName = carcatName == null ? null : carcatName.trim();
    }

    public String getCarBn() {
        return carBn;
    }

    public void setCarBn(String carBn) {
        this.carBn = carBn == null ? null : carBn.trim();
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public String getDeliveryScope() {
        return deliveryScope;
    }

    public void setDeliveryScope(String deliveryScope) {
        this.deliveryScope = deliveryScope == null ? null : deliveryScope.trim();
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode == null ? null : transportMode.trim();
    }

    public String getIsRound() {
        return isRound;
    }

    public void setIsRound(String isRound) {
        this.isRound = isRound == null ? null : isRound.trim();
    }

    public String getIsTransit() {
        return isTransit;
    }

    public void setIsTransit(String isTransit) {
        this.isTransit = isTransit == null ? null : isTransit.trim();
    }

    public String getIsFixedshift() {
        return isFixedshift;
    }

    public void setIsFixedshift(String isFixedshift) {
        this.isFixedshift = isFixedshift == null ? null : isFixedshift.trim();
    }

    public String getOrganizegoodsMode() {
        return organizegoodsMode;
    }

    public void setOrganizegoodsMode(String organizegoodsMode) {
        this.organizegoodsMode = organizegoodsMode == null ? null : organizegoodsMode.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getServiceMode() {
        return serviceMode;
    }

    public void setServiceMode(String serviceMode) {
        this.serviceMode = serviceMode == null ? null : serviceMode.trim();
    }

    public String getOperateSort() {
        return operateSort;
    }

    public void setOperateSort(String operateSort) {
        this.operateSort = operateSort == null ? null : operateSort.trim();
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature == null ? null : jobNature.trim();
    }

    public String getMonthlypay() {
        return monthlypay;
    }

    public void setMonthlypay(String monthlypay) {
        this.monthlypay = monthlypay == null ? null : monthlypay.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobRequest() {
        return jobRequest;
    }

    public void setJobRequest(String jobRequest) {
        this.jobRequest = jobRequest == null ? null : jobRequest.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCalling() {
        return calling;
    }

    public void setCalling(String calling) {
        this.calling = calling == null ? null : calling.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale == null ? null : companyScale.trim();
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature == null ? null : companyNature.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience == null ? null : workExperience.trim();
    }

    public String getJobRank() {
        return jobRank;
    }

    public void setJobRank(String jobRank) {
        this.jobRank = jobRank == null ? null : jobRank.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Date getCarFirstcardtime() {
        return carFirstcardtime;
    }

    public void setCarFirstcardtime(Date carFirstcardtime) {
        this.carFirstcardtime = carFirstcardtime;
    }

    public String getHasAccident() {
        return hasAccident;
    }

    public void setHasAccident(String hasAccident) {
        this.hasAccident = hasAccident == null ? null : hasAccident.trim();
    }

    public String getHasCertificate() {
        return hasCertificate;
    }

    public void setHasCertificate(String hasCertificate) {
        this.hasCertificate = hasCertificate == null ? null : hasCertificate.trim();
    }

    public String getInteriorCondition() {
        return interiorCondition;
    }

    public void setInteriorCondition(String interiorCondition) {
        this.interiorCondition = interiorCondition == null ? null : interiorCondition.trim();
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType == null ? null : leaseType.trim();
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace == null ? null : originPlace.trim();
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace == null ? null : jobPlace.trim();
    }

    public String getJobCat() {
        return jobCat;
    }

    public void setJobCat(String jobCat) {
        this.jobCat = jobCat == null ? null : jobCat.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1 == null ? null : p1.trim();
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2 == null ? null : p2.trim();
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3 == null ? null : p3.trim();
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4 == null ? null : p4.trim();
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5 == null ? null : p5.trim();
    }

    public String getP6() {
        return p6;
    }

    public void setP6(String p6) {
        this.p6 = p6 == null ? null : p6.trim();
    }

    public String getP7() {
        return p7;
    }

    public void setP7(String p7) {
        this.p7 = p7 == null ? null : p7.trim();
    }

    public String getP8() {
        return p8;
    }

    public void setP8(String p8) {
        this.p8 = p8 == null ? null : p8.trim();
    }

    public String getP9() {
        return p9;
    }

    public void setP9(String p9) {
        this.p9 = p9 == null ? null : p9.trim();
    }

    public String getP0() {
        return p0;
    }

    public void setP0(String p0) {
        this.p0 = p0 == null ? null : p0.trim();
    }
}