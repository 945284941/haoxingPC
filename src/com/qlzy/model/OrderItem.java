package com.qlzy.model;



import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String orderId;

    private String goodsId;
    
    //订单中的单品ID
    private String goodsItemId;
    
    //订单中单品的规格
    private String itemSku;
    



	private String goodsName;
    private BigDecimal marketbalePrice;//市场价(item的价格)
    private BigDecimal dealPrice;//成交价格(经过计算后的实际支付价格人民币 单个商品价格)
    private String companyId;
    private BigDecimal amount;//商品小计(实际支付的人民币价格) 乘以数量之后
    private Integer nums;
    private String saleActiveId;//是否团购或限时抢购 1是团购 0不是团购
    private BigDecimal saleActiveReduceMoney;//团购优惠的比例即goods表中的activity_price
    private BigDecimal memberlvRedceMoney;
    private BigDecimal memberlvDiscount;
    private String appraise;
    private BigDecimal point;//购买此商品所获得的心动值
	private BigDecimal pointBili;//购买此商品所获得的心动值比例
	private String countryId;//购买国家id
	private String goodsEnName;//商品英文名称
	private BigDecimal dlmBili;//汇率比例
	private BigDecimal docBili;//汇率比例
	private BigDecimal dlmPrice;//商品小计(实际支付的dlm价格) 乘以数量之后
	private BigDecimal docPrice;//商品小计(实际支付的doc价格) 乘以数量之后
	private BigDecimal countryBili;//国家售卖比例
    
    /**
     * 是否已发货
     */
    private Integer isLogistice = 0;
    /**
     * 物流单号
     */
    private String logisticsNum;
    /**
     * 物流公司名称
     */
    private String logisticsName;
    /**
     * 物流公司电话
     */
    private String logisticsTel;
    //一下为扩展字段
    private String defaultPicSrc;
    private String bn;
    private String companyName;
    private String memberName;
    private String shipStatus;
    private String payStatus;
    private String createtime;
    private String goodsPic;
    private String appraiseContent;
	private Integer appraiseSincerity;

	/**
     * 商品的详细信息
     */
    private Goods goods;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsItemId() {
		return goodsItemId;
	}

	public void setGoodsItemId(String goodsItemId) {
		this.goodsItemId = goodsItemId;
	}

	public String getItemSku() {
		return itemSku;
	}

	public void setItemSku(String itemSku) {
		this.itemSku = itemSku;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getMarketbalePrice() {
		return marketbalePrice;
	}

	public void setMarketbalePrice(BigDecimal marketbalePrice) {
		this.marketbalePrice = marketbalePrice;
	}

	public BigDecimal getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(BigDecimal dealPrice) {
		this.dealPrice = dealPrice;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public String getSaleActiveId() {
		return saleActiveId;
	}

	public void setSaleActiveId(String saleActiveId) {
		this.saleActiveId = saleActiveId;
	}

	public BigDecimal getSaleActiveReduceMoney() {
		return saleActiveReduceMoney;
	}

	public void setSaleActiveReduceMoney(BigDecimal saleActiveReduceMoney) {
		this.saleActiveReduceMoney = saleActiveReduceMoney;
	}

	public BigDecimal getMemberlvRedceMoney() {
		return memberlvRedceMoney;
	}

	public void setMemberlvRedceMoney(BigDecimal memberlvRedceMoney) {
		this.memberlvRedceMoney = memberlvRedceMoney;
	}

	public BigDecimal getMemberlvDiscount() {
		return memberlvDiscount;
	}

	public void setMemberlvDiscount(BigDecimal memberlvDiscount) {
		this.memberlvDiscount = memberlvDiscount;
	}

	public String getAppraise() {
		return appraise;
	}

	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}

	public BigDecimal getPoint() {
		return point;
	}

	public void setPoint(BigDecimal point) {
		this.point = point;
	}

	public BigDecimal getPointBili() {
		return pointBili;
	}

	public void setPointBili(BigDecimal pointBili) {
		this.pointBili = pointBili;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getGoodsEnName() {
		return goodsEnName;
	}

	public void setGoodsEnName(String goodsEnName) {
		this.goodsEnName = goodsEnName;
	}

	public BigDecimal getDlmBili() {
		return dlmBili;
	}

	public void setDlmBili(BigDecimal dlmBili) {
		this.dlmBili = dlmBili;
	}

	public BigDecimal getDocBili() {
		return docBili;
	}

	public void setDocBili(BigDecimal docBili) {
		this.docBili = docBili;
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

	public BigDecimal getCountryBili() {
		return countryBili;
	}

	public void setCountryBili(BigDecimal countryBili) {
		this.countryBili = countryBili;
	}

	public Integer getIsLogistice() {
		return isLogistice;
	}

	public void setIsLogistice(Integer isLogistice) {
		this.isLogistice = isLogistice;
	}

	public String getLogisticsNum() {
		return logisticsNum;
	}

	public void setLogisticsNum(String logisticsNum) {
		this.logisticsNum = logisticsNum;
	}

	public String getLogisticsName() {
		return logisticsName;
	}

	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}

	public String getLogisticsTel() {
		return logisticsTel;
	}

	public void setLogisticsTel(String logisticsTel) {
		this.logisticsTel = logisticsTel;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getGoodsPic() {
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	public String getAppraiseContent() {
		return appraiseContent;
	}

	public void setAppraiseContent(String appraiseContent) {
		this.appraiseContent = appraiseContent;
	}

	public Integer getAppraiseSincerity() {
		return appraiseSincerity;
	}

	public void setAppraiseSincerity(Integer appraiseSincerity) {
		this.appraiseSincerity = appraiseSincerity;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}