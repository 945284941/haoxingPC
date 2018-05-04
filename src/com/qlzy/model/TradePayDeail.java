package com.qlzy.model;

import java.util.Date;

import java.io.Serializable;

public class TradePayDeail implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 价格
     */
    private Double totalPrice;

    /**
     * 订单号
     */
    private String orderNum;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 订单买家留言
     */
    private String orderMsg;

    /**
     * 订单名称
     */
    private String orderName;

    /**
     * 产品地址
     */
    private String productUrl;

    /**
     * 支付时间
     */
    private Date paydate;

    /**
     * 支付宝交易号
     */
    private String tradeNo;

    /**
     * 交易状态
     */
    private String tradeStatus;

    /**
     * 签名
     */
    private String mysign;

    /**
     * 签名方式
     */
    private String signType;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取价格
     *
     * @return total_price - 价格
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置价格
     *
     * @param totalPrice 价格
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取订单号
     *
     * @return order_num - 订单号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单号
     *
     * @param orderNum 订单号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    /**
     * 获取订单ID
     *
     * @return order_id - 订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID
     *
     * @param orderId 订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取订单买家留言
     *
     * @return order_msg - 订单买家留言
     */
    public String getOrderMsg() {
        return orderMsg;
    }

    /**
     * 设置订单买家留言
     *
     * @param orderMsg 订单买家留言
     */
    public void setOrderMsg(String orderMsg) {
        this.orderMsg = orderMsg == null ? null : orderMsg.trim();
    }

    /**
     * 获取订单名称
     *
     * @return order_name - 订单名称
     */
    public String getOrderName() {
        return orderName;
    }

    /**
     * 设置订单名称
     *
     * @param orderName 订单名称
     */
    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    /**
     * 获取产品地址
     *
     * @return product_url - 产品地址
     */
    public String getProductUrl() {
        return productUrl;
    }

    /**
     * 设置产品地址
     *
     * @param productUrl 产品地址
     */
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl == null ? null : productUrl.trim();
    }

    /**
     * 获取支付时间
     *
     * @return paydate - 支付时间
     */
    public Date getPaydate() {
        return paydate;
    }

    /**
     * 设置支付时间
     *
     * @param paydate 支付时间
     */
    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    /**
     * 获取支付宝交易号
     *
     * @return trade_no - 支付宝交易号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置支付宝交易号
     *
     * @param tradeNo 支付宝交易号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取交易状态
     *
     * @return trade_status - 交易状态
     */
    public String getTradeStatus() {
        return tradeStatus;
    }

    /**
     * 设置交易状态
     *
     * @param tradeStatus 交易状态
     */
    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    /**
     * 获取签名
     *
     * @return mysign - 签名
     */
    public String getMysign() {
        return mysign;
    }

    /**
     * 设置签名
     *
     * @param mysign 签名
     */
    public void setMysign(String mysign) {
        this.mysign = mysign == null ? null : mysign.trim();
    }

    /**
     * 获取签名方式
     *
     * @return sign_type - 签名方式
     */
    public String getSignType() {
        return signType;
    }

    /**
     * 设置签名方式
     *
     * @param signType 签名方式
     */
    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }
}