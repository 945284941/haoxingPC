package com.qlzy.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.qlzy.util.Pagination;

import java.io.Serializable;

public class Order extends Pagination implements Serializable {
	private static final long serialVersionUID = 1L;

    private String id;

    private String memberId;

    private String memberType;

    private Date createtime;

    private String sourceType;

    private String saleType;

    private String status;

    private String payStatus;

    private String shipStatus;

    private String keshStatus;

    private String isDelivery;

    private String logisticsId;

    private String logisticsNum;

    private String logisticsName;

    private String logisticsTel;

    private String payMent;

    private Date payTime;

    private String shipName;

    private String area;

    private String shipZip;

    private String shipTel;

    private String shipEmail;

    private Date shipTime;

    private BigDecimal carriage;

    private BigDecimal advance;

    private BigDecimal ebankMon;

    private String remark;

    private Date modifytime;

    private BigDecimal orderPoints;

    private String province;

    private String city;

    private String address;

    private String billType;

    private String billHead;

    private String billContent;

    private String disabled;

    private String companyId;

    private String orderNum;

    private String dealId;

    private String dealType;
    private String orderMsg;

    private String zoneType;//0 非返惠米订单 1 返惠米订单 2  经验值订单 3 汇筹订单

    private Date completeTime;	//收货时间
    private String courtesyCardId;


    private BigDecimal yijiabi;
    private BigDecimal totalDocPrice;//（实际总金额）doc 价格
    private BigDecimal totalDlmPrice;//（实际总金额）dlm 价格
    private BigDecimal totalCost; //（实际总金额）人民币
    private BigDecimal costDocPrice; //doc价格 不加心动值
    private BigDecimal costDlmPrice;// dlm价格 不加心动值
    private BigDecimal costProtect;// 人民币价格 不加心动值
    private BigDecimal dlmBili; // dlm比例
    private BigDecimal docBili; // doc比例
    private BigDecimal xindongDlmPrice; //心动值所抵用的dlm价格
    private BigDecimal xindongDocPrice; //心动值所抵用的doc价格
    private String countryId; //购买的国家

	//以下为扩展字段
    private String companyName;
    private String memberName;
    private String pname;
    private String cname;
    private String aname;
    private String linkmanPhone;


    private Date hkTime;
    private String hkType;
    private Date sjhkTime;
    private List<OrderItem> items;


    private String orderType;

    private Long num;
    private BigDecimal totalMoney;
    private String time;
    private String qixian;

    private Integer count;//订单商品数量
    private String shopName;//商铺名称

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCourtesyCardId() {
        return courtesyCardId;
    }

    public void setCourtesyCardId(String courtesyCardId) {
        this.courtesyCardId = courtesyCardId;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }
    public String getQixian() {
        return qixian;
    }

    public void setQixian(String qixian) {
        this.qixian = qixian;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderMsg() {
        return orderMsg;
    }

    public void setOrderMsg(String orderMsg) {
        this.orderMsg = orderMsg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType == null ? null : saleType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus == null ? null : shipStatus.trim();
    }

    public String getKeshStatus() {
        return keshStatus;
    }

    public void setKeshStatus(String keshStatus) {
        this.keshStatus = keshStatus == null ? null : keshStatus.trim();
    }

    public String getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(String isDelivery) {
        this.isDelivery = isDelivery == null ? null : isDelivery.trim();
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId == null ? null : logisticsId.trim();
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum == null ? null : logisticsNum.trim();
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName == null ? null : logisticsName.trim();
    }

    public String getPayMent() {
        return payMent;
    }

    public void setPayMent(String payMent) {
        this.payMent = payMent == null ? null : payMent.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName == null ? null : shipName.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip == null ? null : shipZip.trim();
    }

    public String getShipTel() {
        return shipTel;
    }

    public void setShipTel(String shipTel) {
        this.shipTel = shipTel == null ? null : shipTel.trim();
    }

    public String getShipEmail() {
        return shipEmail;
    }

    public void setShipEmail(String shipEmail) {
        this.shipEmail = shipEmail == null ? null : shipEmail.trim();
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalDocPrice() {
        return totalDocPrice;
    }

    public void setTotalDocPrice(BigDecimal totalDocPrice) {
        this.totalDocPrice = totalDocPrice;
    }

    public BigDecimal getTotalDlmPrice() {
        return totalDlmPrice;
    }

    public void setTotalDlmPrice(BigDecimal totalDlmPrice) {
        this.totalDlmPrice = totalDlmPrice;
    }

    public BigDecimal getCarriage() {
        return carriage;
    }

    public void setCarriage(BigDecimal carriage) {
        this.carriage = carriage;
    }

    public BigDecimal getAdvance() {
        return advance;
    }

    public void setAdvance(BigDecimal advance) {
        this.advance = advance;
    }

    public BigDecimal getEbankMon() {
        return ebankMon;
    }

    public void setEbankMon(BigDecimal ebankMon) {
        this.ebankMon = ebankMon;
    }

    public BigDecimal getOrderPoints() {
        return orderPoints;
    }

    public void setOrderPoints(BigDecimal orderPoints) {
        this.orderPoints = orderPoints;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

	/**
	 * @return the memberType
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * @param memberType the memberType to set
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * @return the billType
	 */
	public String getBillType() {
		return billType;
	}

	/**
	 * @param billType the billType to set
	 */
	public void setBillType(String billType) {
		this.billType = billType;
	}

	/**
	 * @return the billHead
	 */
	public String getBillHead() {
		return billHead;
	}

	/**
	 * @param billHead the billHead to set
	 */
	public void setBillHead(String billHead) {
		this.billHead = billHead;
	}

	/**
	 * @return the billContent
	 */
	public String getBillContent() {
		return billContent;
	}

	/**
	 * @param billContent the billContent to set
	 */
	public void setBillContent(String billContent) {
		this.billContent = billContent;
	}

	/**
	 * @return the disabled
	 */
	public String getDisabled() {
		return disabled;
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	/**
	 * @return the items
	 */
	public List<OrderItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the orderNum
	 */
	public String getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
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
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * @return the aname
	 */
	public String getAname() {
		return aname;
	}

	/**
	 * @param aname the aname to set
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}

	/**
	 * @return the logisticsTel
	 */
	public String getLogisticsTel() {
		return logisticsTel;
	}

	/**
	 * @param logisticsTel the logisticsTel to set
	 */
	public void setLogisticsTel(String logisticsTel) {
		this.logisticsTel = logisticsTel;
	}

	/**
	 * @return the dealId
	 */
	public String getDealId() {
		return dealId;
	}

	/**
	 * @param dealId the dealId to set
	 */
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	/**
	 * @return the dealType
	 */
	public String getDealType() {
		return dealType;
	}

	/**
	 * @param dealType the dealType to set
	 */
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getLinkmanPhone() {
		return linkmanPhone;
	}

	public void setLinkmanPhone(String linkmanPhone) {
		this.linkmanPhone = linkmanPhone;
	}



	public Date getHkTime() {
		return hkTime;
	}

	public void setHkTime(Date hkTime) {
		this.hkTime = hkTime;
	}

	public String getHkType() {
		return hkType;
	}

	public void setHkType(String hkType) {
		this.hkType = hkType;
	}

	public Date getSjhkTime() {
		return sjhkTime;
	}

	public void setSjhkTime(Date sjhkTime) {
		this.sjhkTime = sjhkTime;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

    public BigDecimal getCostDocPrice() {
        return costDocPrice;
    }

    public void setCostDocPrice(BigDecimal costDocPrice) {
        this.costDocPrice = costDocPrice;
    }

    public BigDecimal getCostDlmPrice() {
        return costDlmPrice;
    }

    public void setCostDlmPrice(BigDecimal costDlmPrice) {
        this.costDlmPrice = costDlmPrice;
    }

    public BigDecimal getCostProtect() {
        return costProtect;
    }

    public void setCostProtect(BigDecimal costProtect) {
        this.costProtect = costProtect;
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

    public BigDecimal getXindongDlmPrice() {
        return xindongDlmPrice;
    }

    public void setXindongDlmPrice(BigDecimal xindongDlmPrice) {
        this.xindongDlmPrice = xindongDlmPrice;
    }

    public BigDecimal getXindongDocPrice() {
        return xindongDocPrice;
    }

    public void setXindongDocPrice(BigDecimal xindongDocPrice) {
        this.xindongDocPrice = xindongDocPrice;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public BigDecimal getYijiabi() {
        return yijiabi;
    }

    public void setYijiabi(BigDecimal yijiabi) {
        this.yijiabi = yijiabi;
    }
}