package com.qlzy.model;



import java.io.Serializable;

public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String orderId;

    private String goodsId;
    
    //订单中的单品ID
    private String goodsItemId;
    
    //订单中单品的规格
    private String itemSku;
    

    public String getItemSku() {
		return itemSku;
	}

	public void setItemSku(String itemSku) {
		this.itemSku = itemSku;
	}

	public String getGoodsItemId() {
		return goodsItemId;
	}

	public void setGoodsItemId(String goodsItemId) {
		this.goodsItemId = goodsItemId;
	}

	private String goodsName;

    private Double marketbalePrice;

    private Double dealPrice;

    private String companyId;

    private Double amount;

    private Integer nums;

    private String saleActiveId;

    private Double saleActiveReduceMoney;

    private Double memberlvRedceMoney;

    private Double memberlvDiscount;
    
    private String appraise;
    
    private Double point;
    
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
    /**
     * 商品的详细信息
     */
    private Goods goods;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Double getMarketbalePrice() {
        return marketbalePrice;
    }

    public void setMarketbalePrice(Double marketbalePrice) {
        this.marketbalePrice = marketbalePrice;
    }

    public Double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(Double dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
        this.saleActiveId = saleActiveId == null ? null : saleActiveId.trim();
    }

    public Double getSaleActiveReduceMoney() {
        return saleActiveReduceMoney;
    }

    public void setSaleActiveReduceMoney(Double saleActiveReduceMoney) {
        this.saleActiveReduceMoney = saleActiveReduceMoney;
    }

    public Double getMemberlvRedceMoney() {
        return memberlvRedceMoney;
    }

    public void setMemberlvRedceMoney(Double memberlvRedceMoney) {
        this.memberlvRedceMoney = memberlvRedceMoney;
    }

    public Double getMemberlvDiscount() {
        return memberlvDiscount;
    }

    public void setMemberlvDiscount(Double memberlvDiscount) {
        this.memberlvDiscount = memberlvDiscount;
    }

	/**
	 * @return the appraise
	 */
	public String getAppraise() {
		return appraise;
	}

	/**
	 * @param appraise the appraise to set
	 */
	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}

	/**
	 * @return the defaultPicSrc
	 */
	public String getDefaultPicSrc() {
		return defaultPicSrc;
	}

	/**
	 * @param defaultPicSrc the defaultPicSrc to set
	 */
	public void setDefaultPicSrc(String defaultPicSrc) {
		this.defaultPicSrc = defaultPicSrc;
	}

	/**
	 * @return the bn
	 */
	public String getBn() {
		return bn;
	}

	/**
	 * @param bn the bn to set
	 */
	public void setBn(String bn) {
		this.bn = bn;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the shipStatus
	 */
	public String getShipStatus() {
		return shipStatus;
	}

	/**
	 * @param shipStatus the shipStatus to set
	 */
	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	/**
	 * @return the payStatus
	 */
	public String getPayStatus() {
		return payStatus;
	}

	/**
	 * @param payStatus the payStatus to set
	 */
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getGoodsPic() {
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
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

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}
	
}