package com.qlzy.model;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import com.qlzy.util.Pagination;

import java.io.Serializable;

public class Goods extends Pagination implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String companyId;

	private String name;

	private String enName;

	private String carPartsId;

	private String carPartsProducerId;

	private String defaultPicSrc;

	private BigDecimal price;

	private BigDecimal yuanjia;

	private String bn;

	private String productArea;

	private String unit;

	private BigDecimal store;

	private Date createtime;

	private Date modifytime;

	private String marketable;

	private String userId;

	private Double USAMoney;

	private Double ADMMoney;

	private Integer minPage;

	private Integer maxPage;

	public Double getUSAMoney() {
		return USAMoney;
	}

	public void setUSAMoney(double USAMoney) {
		this.USAMoney = USAMoney;
	}

	public Double getADMMoney() {
		return ADMMoney;
	}

	public void setADMMoney(Double ADMMoney) {
		this.ADMMoney = ADMMoney;
	}

	private String isCarProducter;

	private BigDecimal isMemberDiscount;

	private String pOrder;

	private String disabled;

	private String productBn;

	private BigDecimal inCity;

	private BigDecimal inProvince;

	private BigDecimal outProvince;

	private BigDecimal queryNum;

	private BigDecimal clickNumber;

	private String isMail;

	private BigDecimal isStander;

	private String sendIp;

	private String shCatId;

	private String lessinformation;

	private String goodstype;

	private String isMailing;

	private String skuId;

	private BigDecimal yiji;

	private BigDecimal erji;

	private BigDecimal sanji;

	private BigDecimal yijinum;

	private BigDecimal erjinum;

	private BigDecimal sanjinum;

	private Double minMoney;

	private Double maxMoney;


	private BigDecimal wuliu;

	private BigDecimal fanxian;

	private BigDecimal fanxiannum;

	private Integer freepostagenum;

	private String isconsultingpostage;

	private Boolean isPoint;

	private BigDecimal pointPercentage;

	private String sellCountryId;

	private String isBuilding;


	//好评率
	private BigDecimal praiseRate;
	//好评数
	private BigDecimal praiseNum;

	private BigDecimal orderEndNum;

	private BigDecimal clickNum;

	private BigDecimal zonghe;
	private String infomation;
	private String uninGoods;

	private String isMarket;

	private String isShop;

	private String isGroup;

	private String isFlashSale;

	private BigDecimal activityPrice;
	private BigDecimal dlmPrice;
	private BigDecimal docPrice;

	//评论数量
	private BigDecimal allCount;
	private BigDecimal haopingCount;
	private BigDecimal zhongpingCount;
	private BigDecimal chapingCount;
	private BigDecimal tupianCount;

	private String isPraise;

	private Integer cartNum;//商品在购物车中的数量
	private Integer collectNum;//商品在被收藏的数量

	//规格
    @Transient
    private List<GoodsAndSku> gasList;
    //商品规格
    @Transient
    private String skuKeys;
  //单品集合
    @Transient
    private String data;
    //sku选项按钮封装
    @Transient
    private Map<String,Collection<Object>> skuCode;
    
    private String showSku;


	private String isIndexShop;
	private String isIndexMarket;
	private String isIndexBuild;
	private Date sysUpdateDate;

	private String companyName;
	private String companyEnName;

	//图片信息
	private List<String> goodsPics;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
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

	public String getDefaultPicSrc() {
		return defaultPicSrc;
	}

	public void setDefaultPicSrc(String defaultPicSrc) {
		this.defaultPicSrc = defaultPicSrc;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getYuanjia() {
		return yuanjia;
	}

	public void setYuanjia(BigDecimal yuanjia) {
		this.yuanjia = yuanjia;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getStore() {
		return store;
	}

	public void setStore(BigDecimal store) {
		this.store = store;
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

	public String getMarketable() {
		return marketable;
	}

	public void setMarketable(String marketable) {
		this.marketable = marketable;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIsCarProducter() {
		return isCarProducter;
	}

	public void setIsCarProducter(String isCarProducter) {
		this.isCarProducter = isCarProducter;
	}

	public BigDecimal getIsMemberDiscount() {
		return isMemberDiscount;
	}

	public void setIsMemberDiscount(BigDecimal isMemberDiscount) {
		this.isMemberDiscount = isMemberDiscount;
	}

	public String getpOrder() {
		return pOrder;
	}

	public void setpOrder(String pOrder) {
		this.pOrder = pOrder;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getProductBn() {
		return productBn;
	}

	public void setProductBn(String productBn) {
		this.productBn = productBn;
	}

	public BigDecimal getInCity() {
		return inCity;
	}

	public void setInCity(BigDecimal inCity) {
		this.inCity = inCity;
	}

	public BigDecimal getInProvince() {
		return inProvince;
	}

	public void setInProvince(BigDecimal inProvince) {
		this.inProvince = inProvince;
	}

	public BigDecimal getOutProvince() {
		return outProvince;
	}

	public void setOutProvince(BigDecimal outProvince) {
		this.outProvince = outProvince;
	}

	public BigDecimal getQueryNum() {
		return queryNum;
	}

	public void setQueryNum(BigDecimal queryNum) {
		this.queryNum = queryNum;
	}

	public BigDecimal getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(BigDecimal clickNumber) {
		this.clickNumber = clickNumber;
	}

	public String getIsMail() {
		return isMail;
	}

	public void setIsMail(String isMail) {
		this.isMail = isMail;
	}

	public BigDecimal getIsStander() {
		return isStander;
	}

	public void setIsStander(BigDecimal isStander) {
		this.isStander = isStander;
	}

	public String getSendIp() {
		return sendIp;
	}

	public void setSendIp(String sendIp) {
		this.sendIp = sendIp;
	}

	public String getShCatId() {
		return shCatId;
	}

	public void setShCatId(String shCatId) {
		this.shCatId = shCatId;
	}

	public String getLessinformation() {
		return lessinformation;
	}

	public void setLessinformation(String lessinformation) {
		this.lessinformation = lessinformation;
	}

	public String getGoodstype() {
		return goodstype;
	}

	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}

	public String getIsMailing() {
		return isMailing;
	}

	public void setIsMailing(String isMailing) {
		this.isMailing = isMailing;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public BigDecimal getYiji() {
		return yiji;
	}

	public void setYiji(BigDecimal yiji) {
		this.yiji = yiji;
	}

	public BigDecimal getErji() {
		return erji;
	}

	public void setErji(BigDecimal erji) {
		this.erji = erji;
	}

	public BigDecimal getSanji() {
		return sanji;
	}

	public void setSanji(BigDecimal sanji) {
		this.sanji = sanji;
	}

	public BigDecimal getYijinum() {
		return yijinum;
	}

	public void setYijinum(BigDecimal yijinum) {
		this.yijinum = yijinum;
	}

	public BigDecimal getErjinum() {
		return erjinum;
	}

	public void setErjinum(BigDecimal erjinum) {
		this.erjinum = erjinum;
	}

	public BigDecimal getSanjinum() {
		return sanjinum;
	}

	public void setSanjinum(BigDecimal sanjinum) {
		this.sanjinum = sanjinum;
	}

	public BigDecimal getWuliu() {
		return wuliu;
	}

	public void setWuliu(BigDecimal wuliu) {
		this.wuliu = wuliu;
	}

	public BigDecimal getFanxian() {
		return fanxian;
	}

	public void setFanxian(BigDecimal fanxian) {
		this.fanxian = fanxian;
	}

	public BigDecimal getFanxiannum() {
		return fanxiannum;
	}

	public void setFanxiannum(BigDecimal fanxiannum) {
		this.fanxiannum = fanxiannum;
	}

	public Integer getFreepostagenum() {
		return freepostagenum;
	}

	public void setFreepostagenum(Integer freepostagenum) {
		this.freepostagenum = freepostagenum;
	}

	public String getIsconsultingpostage() {
		return isconsultingpostage;
	}

	public void setIsconsultingpostage(String isconsultingpostage) {
		this.isconsultingpostage = isconsultingpostage;
	}

	public Boolean getPoint() {
		return isPoint;
	}

	public void setPoint(Boolean point) {
		isPoint = point;
	}

	public BigDecimal getPointPercentage() {
		return pointPercentage;
	}

	public void setPointPercentage(BigDecimal pointPercentage) {
		this.pointPercentage = pointPercentage;
	}

	public String getSellCountryId() {
		return sellCountryId;
	}

	public void setSellCountryId(String sellCountryId) {
		this.sellCountryId = sellCountryId;
	}

	public String getIsBuilding() {
		return isBuilding;
	}

	public void setIsBuilding(String isBuilding) {
		this.isBuilding = isBuilding;
	}

	public String getIsMarket() {
		return isMarket;
	}

	public void setIsMarket(String isMarket) {
		this.isMarket = isMarket;
	}

	public String getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup;
	}

	public String getIsFlashSale() {
		return isFlashSale;
	}

	public void setIsFlashSale(String isFlashSale) {
		this.isFlashSale = isFlashSale;
	}

	public BigDecimal getActivityPrice() {
		return activityPrice;
	}

	public void setActivityPrice(BigDecimal activityPrice) {
		this.activityPrice = activityPrice;
	}

	public BigDecimal getPraiseRate() {
		return praiseRate;
	}

	public void setPraiseRate(BigDecimal praiseRate) {
		this.praiseRate = praiseRate;
	}

	public BigDecimal getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(BigDecimal praiseNum) {
		this.praiseNum = praiseNum;
	}

	public BigDecimal getOrderEndNum() {
		return orderEndNum;
	}

	public void setOrderEndNum(BigDecimal orderEndNum) {
		this.orderEndNum = orderEndNum;
	}

	public BigDecimal getClickNum() {
		return clickNum;
	}

	public void setClickNum(BigDecimal clickNum) {
		this.clickNum = clickNum;
	}

	public BigDecimal getZonghe() {
		return zonghe;
	}

	public void setZonghe(BigDecimal zonghe) {
		this.zonghe = zonghe;
	}

	public List<GoodsAndSku> getGasList() {
		return gasList;
	}

	public void setGasList(List<GoodsAndSku> gasList) {
		this.gasList = gasList;
	}

	public String getSkuKeys() {
		return skuKeys;
	}

	public void setSkuKeys(String skuKeys) {
		this.skuKeys = skuKeys;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Map<String, Collection<Object>> getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(Map<String, Collection<Object>> skuCode) {
		this.skuCode = skuCode;
	}

	public String getShowSku() {
		return showSku;
	}

	public void setShowSku(String showSku) {
		this.showSku = showSku;
	}
	public String getInfomation() {
		return infomation;
	}

	public void setInfomation(String infomation) {
		this.infomation = infomation == null ? null : infomation.trim();
	}

	public String getUninGoods() {
		return uninGoods;
	}

	public void setUninGoods(String uninGoods) {
		this.uninGoods = uninGoods == null ? null : uninGoods.trim();
	}

	public String getIsIndexShop() {
		return isIndexShop;
	}

	public void setIsIndexShop(String isIndexShop) {
		this.isIndexShop = isIndexShop;
	}

	public String getIsIndexMarket() {
		return isIndexMarket;
	}

	public void setIsIndexMarket(String isIndexMarket) {
		this.isIndexMarket = isIndexMarket;
	}

	public String getIsIndexBuild() {
		return isIndexBuild;
	}

	public void setIsIndexBuild(String isIndexBuild) {
		this.isIndexBuild = isIndexBuild;
	}

	public Date getSysUpdateDate() {
		return sysUpdateDate;
	}

	public void setSysUpdateDate(Date sysUpdateDate) {
		this.sysUpdateDate = sysUpdateDate;
	}

	public String getIsShop() {
		return isShop;
	}

	public void setIsShop(String isShop) {
		this.isShop = isShop;
	}

	public BigDecimal getDlmPrice() {
		return dlmPrice;
	}

	public void setDlmPrice(BigDecimal dlmPrice) {
		this.dlmPrice = dlmPrice;
	}

	public BigDecimal getDocPrice() {
		return docPrice;
	}

	public void setDocPrice(BigDecimal docPrice) {
		this.docPrice = docPrice;
	}

	public List<String> getGoodsPics() {
		return goodsPics;
	}

	public void setGoodsPics(List<String> goodsPics) {
		this.goodsPics = goodsPics;
	}

	public BigDecimal getAllCount() {
		return allCount;
	}

	public void setAllCount(BigDecimal allCount) {
		this.allCount = allCount;
	}

	public BigDecimal getHaopingCount() {
		return haopingCount;
	}

	public void setHaopingCount(BigDecimal haopingCount) {
		this.haopingCount = haopingCount;
	}

	public BigDecimal getZhongpingCount() {
		return zhongpingCount;
	}

	public void setZhongpingCount(BigDecimal zhongpingCount) {
		this.zhongpingCount = zhongpingCount;
	}

	public BigDecimal getChapingCount() {
		return chapingCount;
	}

	public void setChapingCount(BigDecimal chapingCount) {
		this.chapingCount = chapingCount;
	}

	public BigDecimal getTupianCount() {
		return tupianCount;
	}

	public void setTupianCount(BigDecimal tupianCount) {
		this.tupianCount = tupianCount;
	}

	public String getIsPraise() {
		return isPraise;
	}

	public void setIsPraise(String isPraise) {
		this.isPraise = isPraise;
	}

	public String getCompanyEnName() {
		return companyEnName;
	}

	public void setCompanyEnName(String companyEnName) {
		this.companyEnName = companyEnName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCartNum() {

		return cartNum;
	}
	public void setUSAMoney(Double USAMoney) {
		this.USAMoney = USAMoney;
	}

	public Double getMinMoney() {
		return minMoney;
	}

	public void setMinMoney(Double minMoney) {
		this.minMoney = minMoney;
	}

	public Double getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(Double maxMoney) {
		this.maxMoney = maxMoney;
	}
	public void setCartNum(Integer cartNum) {
		this.cartNum = cartNum;
	}

	public Integer getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}

	public Integer getMinPage() {
		return minPage;
	}

	public void setMinPage(Integer minPage) {
		this.minPage = minPage;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
}