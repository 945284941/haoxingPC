package com.qlzy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class GoodsDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

    private String name;

    private String defaultPicSrc;

    private String bn;
    
    private String productArea;
    
    private Double price;
    private Double yuanjia;

    private String unit;

    private Date modifytime;
    
    private Long store;
    
    private Long clickNum;
    
    private String isCarProducter;

    private Long inCity;

    private Long inProvince;

    private Long outProvince;
    
    private String companyName;
    
    private String disabled;
    
    private String city;
    
    private String province;

    private Long ordernum;

    private Long point;
   
    private String carPartsId;//goodsCat id
    
    private String shCatId; //shCat id

    private String carPartsProducerId;
    
    private String firstGoodsCatName;//一级分类名称
    
    private String goodsCatName;//分类名称
    
    private String ptree;//分类树形参数
    
    private String carBrandId;//品牌id,在标准数据页面存入名称
    
    private String carLineId;//车系
    
    private String carVersionId;//车型
    
    private String topSearchLike;//表头模糊查询关键字
    
    private String weight;//重量
    
    private String length;//长度
    
    private String width;//宽度
    
    private String height;//高度
    
    private String color;//颜色
    
    private String wheel;//齿数
    
    private String inside;//内径
    
    private String outside;//外径
    
    private String hole;//孔数
    
    private Date createtime;
    
    private Long collectnum;//收藏
    
    private String companyId;
    private String companyAdress;
    
    private Long queryNum;
    
    private String lessinformation;
    
    private List<SpecificationInformation> specificationInformationList;//商品规格列表
    
    private String leixing;
    
    private String baozhuang;
    
    private String zhongliang;
    
    private String shengfen;
    
    private String goodstype;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefaultPicSrc() {
		return defaultPicSrc;
	}

	public void setDefaultPicSrc(String defaultPicSrc) {
		this.defaultPicSrc = defaultPicSrc;
	}

	public String getBn() {
		return bn;
	}

	public void setBn(String bn) {
		this.bn = bn;
	}

	public String getProductArea() {
		return productArea;
	}

	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Long getStore() {
		return store;
	}

	public void setStore(Long store) {
		this.store = store;
	}

	public String getIsCarProducter() {
		return isCarProducter;
	}

	public void setIsCarProducter(String isCarProducter) {
		this.isCarProducter = isCarProducter;
	}

	public Long getInCity() {
		return inCity;
	}

	public void setInCity(Long inCity) {
		this.inCity = inCity;
	}

	public Long getInProvince() {
		return inProvince;
	}

	public void setInProvince(Long inProvince) {
		this.inProvince = inProvince;
	}

	public Long getOutProvince() {
		return outProvince;
	}

	public void setOutProvince(Long outProvince) {
		this.outProvince = outProvince;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Long getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Long ordernum) {
		this.ordernum = ordernum;
	}

	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public String getCarPartsId() {
		return carPartsId;
	}

	public void setCarPartsId(String carPartsId) {
		this.carPartsId = carPartsId;
	}

	public String getCarPartsProducerId() {
		return carPartsProducerId;
	}

	public void setCarPartsProducerId(String carPartsProducerId) {
		this.carPartsProducerId = carPartsProducerId;
	}

	public String getFirstGoodsCatName() {
		return firstGoodsCatName;
	}

	public void setFirstGoodsCatName(String firstGoodsCatName) {
		this.firstGoodsCatName = firstGoodsCatName;
	}

	public String getGoodsCatName() {
		return goodsCatName;
	}

	public void setGoodsCatName(String goodsCatName) {
		this.goodsCatName = goodsCatName;
	}

	public String getPtree() {
		return ptree;
	}

	public void setPtree(String ptree) {
		this.ptree = ptree;
	}

	public String getCarBrandId() {
		return carBrandId;
	}

	public void setCarBrandId(String carBrandId) {
		this.carBrandId = carBrandId;
	}

	public Long getClickNum() {
		return clickNum;
	}

	public void setClickNum(Long clickNum) {
		this.clickNum = clickNum;
	}

	public String getCarLineId() {
		return carLineId;
	}

	public void setCarLineId(String carLineId) {
		this.carLineId = carLineId;
	}

	public String getCarVersionId() {
		return carVersionId;
	}

	public void setCarVersionId(String carVersionId) {
		this.carVersionId = carVersionId;
	}

	public List<SpecificationInformation> getSpecificationInformationList() {
		return specificationInformationList;
	}

	public void setSpecificationInformationList(
			List<SpecificationInformation> specificationInformationList) {
		this.specificationInformationList = specificationInformationList;
	}

	public String getTopSearchLike() {
		return topSearchLike;
	}

	public void setTopSearchLike(String topSearchLike) {
		this.topSearchLike = topSearchLike;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWheel() {
		return wheel;
	}

	public void setWheel(String wheel) {
		this.wheel = wheel;
	}

	public String getInside() {
		return inside;
	}

	public void setInside(String inside) {
		this.inside = inside;
	}

	public String getOutside() {
		return outside;
	}

	public void setOutside(String outside) {
		this.outside = outside;
	}

	public String getHole() {
		return hole;
	}

	public void setHole(String hole) {
		this.hole = hole;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyAdress() {
		return companyAdress;
	}

	public void setCompanyAdress(String companyAdress) {
		this.companyAdress = companyAdress;
	}

	public String getShCatId() {
		return shCatId;
	}

	public void setShCatId(String shCatId) {
		this.shCatId = shCatId;
	}

	public Long getQueryNum() {
		return queryNum;
	}

	public void setQueryNum(Long queryNum) {
		this.queryNum = queryNum;
	}

	public String getLessinformation() {
		return lessinformation;
	}

	public void setLessinformation(String lessinformation) {
		this.lessinformation = lessinformation;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Long getCollectnum() {
		return collectnum;
	}

	public void setCollectnum(Long collectnum) {
		this.collectnum = collectnum;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public String getBaozhuang() {
		return baozhuang;
	}

	public void setBaozhuang(String baozhuang) {
		this.baozhuang = baozhuang;
	}

	public String getZhongliang() {
		return zhongliang;
	}

	public void setZhongliang(String zhongliang) {
		this.zhongliang = zhongliang;
	}

	public String getShengfen() {
		return shengfen;
	}

	public void setShengfen(String shengfen) {
		this.shengfen = shengfen;
	}

	public Double getYuanjia() {
		return yuanjia;
	}

	public void setYuanjia(Double yuanjia) {
		this.yuanjia = yuanjia;
	}

	public String getGoodstype() {
		return goodstype;
	}

	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}
    
	
}