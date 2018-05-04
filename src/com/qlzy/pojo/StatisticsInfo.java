/**   
 * @Title: StatisticsInfo.java 
 * @Package com.qlzy.pojo 
 * @Description: TODO(统计信息封装类) 
 * @author wangmei   
 * @date 2013-9-27 下午3:48:27 
 * @version V1.0   
 */
package com.qlzy.pojo;

import java.io.Serializable;

public class StatisticsInfo implements Serializable {
	private static final long serialVersionUID = 1L;


	private String statisticsType;
	/******************** 订单统计定义开始 ********************/
	private Long noPayAndShipOrderCount;// 未付款未发货订单数
	private Long alreadyPayAndNoShipOrderCount;// 已付款未发货订单数
	private Long alreadyPayAndShipOrderCount;// 已付款已发货订单数
	private Long completeOfTheTransactionHistoryOrderCount;// 历史交易完成订单数
	private Long closeOfTheTransactionHistoryOrderCount;// 历史交易关闭订单数
	private Long alreadyReturnAndNoFullrefundOrderCount;// 已退货待退款订单数
	private Long alreadyReturnAndFullrefundOrderCount;// 已退货已退款订单数
	/******************** 订单统计定义结束 ********************/

	/******************** 购物车统计定义开始 ********************/
	private Long shoppingCartQuantity;// 购物车商品数量
	private Double shoppingCartTotal;// 购物车商品总价
	/******************** 购物车统计定义结束 ********************/

	/******************** 资金统计定义开始 ********************/
	private Double depositTotal;// 存入总额
	private Double expendTotal;// 支出总额
	private Double withdrawTotal;// 兑米总额
	private Double moneyBalance;// 当前余额
	/******************** 资金统计定义结束 ********************/

	/******************** 经验值统计定义开始 ********************/
	private Long pointAddUp;// 经验值累计
	private Long pointExpend;// 经验值消费
	private Long pointBalance;// 经验值余额
	/******************** 经验值统计定义结束 ********************/

	/******************** 收藏统计定义开始 ********************/
	private Long collectGoodsCount;// 收藏商品总数
	private Long collectShopCount;// 收藏商铺总数
	private Long collectNewsCount;// 收藏资讯总数
	/******************** 收藏统计定义结束 ********************/

	/******************** 浏览统计定义开始 ********************/
	private Long browseGoodsCount;// 浏览商品总数
	private Long browseShopCount;// 浏览商铺总数
	private Long browseNewsCount;// 浏览资讯总数
	/******************** 活动统计定义结束 ********************/

	/******************** 活动统计定义开始 ********************/
	private Long partakeActives;// 参与的活动
	private Long downloadData;// 下载资料
	private Long askQuestions;// 提问
	private Long replyQuestions;//回答
	private Long uploadCount;// 上传数据
	private Long uploadPassCount;// 上传采用
	private Long checkCount;// 校对数据
	private Long checkPassCount;// 校对采用
	private Double addUpReward;// 累计奖金
	/******************** 活动统计定义结束 ********************/

	/******************** 信息统计定义开始 ********************/
	private Long commentCount;// 评论信息总数
	/******************** 信息统计定义结束 ********************/
	
	/******************** 结算统计定义开始 ********************/
	private Double totalTradeAmount;// 总交易额
	private Double refunds;// 退款额
	private Double depositAmount;// 保证金金额
	/******************** 结算统计定义结束 ********************/
	
	/******************** 发布统计定义开始 ********************/
	private Long totalSupplyInfo ;// 发布供求信息总数
	private Long totalAdver;// 发布广告总数
	private Long totalNews;// 发布新闻资讯
	/******************** 发布统计定义结束 ********************/
	
	/******************** 物流统计定义开始 ********************/
	private Long totalSinceTheMention;// 客户自提数
	private Long totalDelivery;// 物流配送数
	private Long totalReturns;// 退货数
	/******************** 物流统计定义结束 ********************/
	
	/******************** 信誉等级统计定义开始 ********************/
	private Long credit_greatReviews;// 信誉好评数
	private Long credit_inReviews;// 信誉中评数
	private Long credit_badReviews;// 信誉差评数
	private Long credit_totalPoint;// 信誉经验值
	/******************** 信誉等级统计定义结束 ********************/
	
	/******************** 服务等级统计定义开始 ********************/
	private Long serve_greatReviews;// 服务好评数
	private Long serve_inReviews;// 服务中评数
	private Long serve_badReviews;// 服务差评数
	private Long serve_totalPoint;// 服务经验值
	/******************** 服务等级统计定义结束 ********************/
	
	/******************** 质量等级统计定义开始 ********************/
	private Long quality_greatReviews;// 质量好评数
	private Long quality_inReviews;// 质量中评数
	private Long quality_badReviews;// 质量差评数
	private Long quality_totalPoint;// 质量经验值
	/******************** 质量等级统计定义结束 ********************/
	
	/******************** 物流等级统计定义开始 ********************/
	private Long logistics_greatReviews;// 物流好评数
	private Long logistics_inReviews;// 物流中评数
	private Long logistics_badReviews;// 物流差评数
	private Long logistics_totalPoint;// 物流经验值
	/******************** 物流等级统计定义结束 ********************/
	
	/******************** 商品统计定义开始 ********************/
	private Long goodsBrands;// 商品品牌数
	private Long goodsCats;// 商品分类数
	private Long goodsCount;// 商品总数
	private Long goodsAddedCount;// 商品上架总数
	private Long goodsOffTheShelfCount;// 商品下架总数
	/******************** 商品统计定义结束 ********************/
	
	/******************** 访问统计定义开始 ********************/
	private Long customerViews;// 客户浏览数
	private Long customerCollects;// 客户收藏数
	private Long customerComments;// 客户评论数
	/******************** 访问统计定义结束 ********************/
	
	/******************** 站内短信统计定义开始 ********************/
	private Long receiveCount;// 接收数
	private Long noReadCount;// 未读数
	private Long alreadyReadCount;// 已读数
	private Long sendCount;// 发送数
	/******************** 站内短信统计定义结束 ********************/	

	/******************** 供求统计开始 ********************/
	private Long zhengcheCount;// 整车供应总数
	private Long peijianCount;
	private Long shebeiCount;
	private Long qixiuCount;
	private Long wuliuCount;
	private Long zulinCount;
	private Long qiuzhiCount;
	private Long qitaCount;
	/******************** 供求统计结束 ********************/

	/******************** 评论统计开始 ********************/
	private Long sumAllCount;// 商品评价总数
	private Long bellCount;// 好评
	private Long badCount;// 差评
	private Long middleCount;// 中评
	/******************** 评论统计结束 ********************/
	
	public String getStatisticsType() {
		return statisticsType;
	}
	public void setStatisticsType(String statisticsType) {
		this.statisticsType = statisticsType;
	}
	public Long getNoPayAndShipOrderCount() {
		return noPayAndShipOrderCount;
	}
	public void setNoPayAndShipOrderCount(Long noPayAndShipOrderCount) {
		this.noPayAndShipOrderCount = noPayAndShipOrderCount;
	}
	public Long getAlreadyPayAndNoShipOrderCount() {
		return alreadyPayAndNoShipOrderCount;
	}
	public void setAlreadyPayAndNoShipOrderCount(Long alreadyPayAndNoShipOrderCount) {
		this.alreadyPayAndNoShipOrderCount = alreadyPayAndNoShipOrderCount;
	}
	public Long getAlreadyPayAndShipOrderCount() {
		return alreadyPayAndShipOrderCount;
	}
	public void setAlreadyPayAndShipOrderCount(Long alreadyPayAndShipOrderCount) {
		this.alreadyPayAndShipOrderCount = alreadyPayAndShipOrderCount;
	}
	public Long getCompleteOfTheTransactionHistoryOrderCount() {
		return completeOfTheTransactionHistoryOrderCount;
	}
	public void setCompleteOfTheTransactionHistoryOrderCount(
			Long completeOfTheTransactionHistoryOrderCount) {
		this.completeOfTheTransactionHistoryOrderCount = completeOfTheTransactionHistoryOrderCount;
	}
	public Long getCloseOfTheTransactionHistoryOrderCount() {
		return closeOfTheTransactionHistoryOrderCount;
	}
	public void setCloseOfTheTransactionHistoryOrderCount(
			Long closeOfTheTransactionHistoryOrderCount) {
		this.closeOfTheTransactionHistoryOrderCount = closeOfTheTransactionHistoryOrderCount;
	}
	public Long getAlreadyReturnAndNoFullrefundOrderCount() {
		return alreadyReturnAndNoFullrefundOrderCount;
	}
	public void setAlreadyReturnAndNoFullrefundOrderCount(
			Long alreadyReturnAndNoFullrefundOrderCount) {
		this.alreadyReturnAndNoFullrefundOrderCount = alreadyReturnAndNoFullrefundOrderCount;
	}
	public Long getAlreadyReturnAndFullrefundOrderCount() {
		return alreadyReturnAndFullrefundOrderCount;
	}
	public void setAlreadyReturnAndFullrefundOrderCount(
			Long alreadyReturnAndFullrefundOrderCount) {
		this.alreadyReturnAndFullrefundOrderCount = alreadyReturnAndFullrefundOrderCount;
	}
	public Long getShoppingCartQuantity() {
		return shoppingCartQuantity;
	}
	public void setShoppingCartQuantity(Long shoppingCartQuantity) {
		this.shoppingCartQuantity = shoppingCartQuantity;
	}
	public Double getShoppingCartTotal() {
		return shoppingCartTotal;
	}
	public void setShoppingCartTotal(Double shoppingCartTotal) {
		this.shoppingCartTotal = shoppingCartTotal;
	}
	public Double getDepositTotal() {
		return depositTotal;
	}
	public void setDepositTotal(Double depositTotal) {
		this.depositTotal = depositTotal;
	}
	public Double getExpendTotal() {
		return expendTotal;
	}
	public void setExpendTotal(Double expendTotal) {
		this.expendTotal = expendTotal;
	}
	public Double getWithdrawTotal() {
		return withdrawTotal;
	}
	public void setWithdrawTotal(Double withdrawTotal) {
		this.withdrawTotal = withdrawTotal;
	}
	public Double getMoneyBalance() {
		return moneyBalance;
	}
	public void setMoneyBalance(Double moneyBalance) {
		this.moneyBalance = moneyBalance;
	}
	public Long getPointAddUp() {
		return pointAddUp;
	}
	public void setPointAddUp(Long pointAddUp) {
		this.pointAddUp = pointAddUp;
	}
	public Long getPointExpend() {
		return pointExpend;
	}
	public void setPointExpend(Long pointExpend) {
		this.pointExpend = pointExpend;
	}
	public Long getPointBalance() {
		return pointBalance;
	}
	public void setPointBalance(Long pointBalance) {
		this.pointBalance = pointBalance;
	}
	public Long getCollectGoodsCount() {
		return collectGoodsCount;
	}
	public void setCollectGoodsCount(Long collectGoodsCount) {
		this.collectGoodsCount = collectGoodsCount;
	}
	public Long getCollectShopCount() {
		return collectShopCount;
	}
	public void setCollectShopCount(Long collectShopCount) {
		this.collectShopCount = collectShopCount;
	}
	public Long getCollectNewsCount() {
		return collectNewsCount;
	}
	public void setCollectNewsCount(Long collectNewsCount) {
		this.collectNewsCount = collectNewsCount;
	}
	public Long getBrowseGoodsCount() {
		return browseGoodsCount;
	}
	public void setBrowseGoodsCount(Long browseGoodsCount) {
		this.browseGoodsCount = browseGoodsCount;
	}
	public Long getBrowseShopCount() {
		return browseShopCount;
	}
	public void setBrowseShopCount(Long browseShopCount) {
		this.browseShopCount = browseShopCount;
	}
	public Long getBrowseNewsCount() {
		return browseNewsCount;
	}
	public void setBrowseNewsCount(Long browseNewsCount) {
		this.browseNewsCount = browseNewsCount;
	}
	public Long getPartakeActives() {
		return partakeActives;
	}
	public void setPartakeActives(Long partakeActives) {
		this.partakeActives = partakeActives;
	}
	public Long getDownloadData() {
		return downloadData;
	}
	public void setDownloadData(Long downloadData) {
		this.downloadData = downloadData;
	}
	public Long getAskQuestions() {
		return askQuestions;
	}
	public void setAskQuestions(Long askQuestions) {
		this.askQuestions = askQuestions;
	}
	public Long getReplyQuestions() {
		return replyQuestions;
	}
	public void setReplyQuestions(Long replyQuestions) {
		this.replyQuestions = replyQuestions;
	}
	public Long getUploadCount() {
		return uploadCount;
	}
	public void setUploadCount(Long uploadCount) {
		this.uploadCount = uploadCount;
	}
	public Long getUploadPassCount() {
		return uploadPassCount;
	}
	public void setUploadPassCount(Long uploadPassCount) {
		this.uploadPassCount = uploadPassCount;
	}
	public Long getCheckCount() {
		return checkCount;
	}
	public void setCheckCount(Long checkCount) {
		this.checkCount = checkCount;
	}
	public Long getCheckPassCount() {
		return checkPassCount;
	}
	public void setCheckPassCount(Long checkPassCount) {
		this.checkPassCount = checkPassCount;
	}
	public Double getAddUpReward() {
		return addUpReward;
	}
	public void setAddUpReward(Double addUpReward) {
		this.addUpReward = addUpReward;
	}
	public Long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}
	public Double getTotalTradeAmount() {
		return totalTradeAmount;
	}
	public void setTotalTradeAmount(Double totalTradeAmount) {
		this.totalTradeAmount = totalTradeAmount;
	}
	public Double getRefunds() {
		return refunds;
	}
	public void setRefunds(Double refunds) {
		this.refunds = refunds;
	}
	public Double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public Long getTotalSupplyInfo() {
		return totalSupplyInfo;
	}
	public void setTotalSupplyInfo(Long totalSupplyInfo) {
		this.totalSupplyInfo = totalSupplyInfo;
	}
	public Long getTotalAdver() {
		return totalAdver;
	}
	public void setTotalAdver(Long totalAdver) {
		this.totalAdver = totalAdver;
	}
	public Long getTotalNews() {
		return totalNews;
	}
	public void setTotalNews(Long totalNews) {
		this.totalNews = totalNews;
	}
	public Long getTotalSinceTheMention() {
		return totalSinceTheMention;
	}
	public void setTotalSinceTheMention(Long totalSinceTheMention) {
		this.totalSinceTheMention = totalSinceTheMention;
	}
	public Long getTotalDelivery() {
		return totalDelivery;
	}
	public void setTotalDelivery(Long totalDelivery) {
		this.totalDelivery = totalDelivery;
	}
	public Long getTotalReturns() {
		return totalReturns;
	}
	public void setTotalReturns(Long totalReturns) {
		this.totalReturns = totalReturns;
	}
	public Long getCredit_greatReviews() {
		return credit_greatReviews;
	}
	public void setCredit_greatReviews(Long credit_greatReviews) {
		this.credit_greatReviews = credit_greatReviews;
	}
	public Long getCredit_inReviews() {
		return credit_inReviews;
	}
	public void setCredit_inReviews(Long credit_inReviews) {
		this.credit_inReviews = credit_inReviews;
	}
	public Long getCredit_badReviews() {
		return credit_badReviews;
	}
	public void setCredit_badReviews(Long credit_badReviews) {
		this.credit_badReviews = credit_badReviews;
	}
	public Long getCredit_totalPoint() {
		return credit_totalPoint;
	}
	public void setCredit_totalPoint(Long credit_totalPoint) {
		this.credit_totalPoint = credit_totalPoint;
	}
	public Long getServe_greatReviews() {
		return serve_greatReviews;
	}
	public void setServe_greatReviews(Long serve_greatReviews) {
		this.serve_greatReviews = serve_greatReviews;
	}
	public Long getServe_inReviews() {
		return serve_inReviews;
	}
	public void setServe_inReviews(Long serve_inReviews) {
		this.serve_inReviews = serve_inReviews;
	}
	public Long getServe_badReviews() {
		return serve_badReviews;
	}
	public void setServe_badReviews(Long serve_badReviews) {
		this.serve_badReviews = serve_badReviews;
	}
	public Long getServe_totalPoint() {
		return serve_totalPoint;
	}
	public void setServe_totalPoint(Long serve_totalPoint) {
		this.serve_totalPoint = serve_totalPoint;
	}
	public Long getQuality_greatReviews() {
		return quality_greatReviews;
	}
	public void setQuality_greatReviews(Long quality_greatReviews) {
		this.quality_greatReviews = quality_greatReviews;
	}
	public Long getQuality_inReviews() {
		return quality_inReviews;
	}
	public void setQuality_inReviews(Long quality_inReviews) {
		this.quality_inReviews = quality_inReviews;
	}
	public Long getQuality_badReviews() {
		return quality_badReviews;
	}
	public void setQuality_badReviews(Long quality_badReviews) {
		this.quality_badReviews = quality_badReviews;
	}
	public Long getQuality_totalPoint() {
		return quality_totalPoint;
	}
	public void setQuality_totalPoint(Long quality_totalPoint) {
		this.quality_totalPoint = quality_totalPoint;
	}
	public Long getLogistics_greatReviews() {
		return logistics_greatReviews;
	}
	public void setLogistics_greatReviews(Long logistics_greatReviews) {
		this.logistics_greatReviews = logistics_greatReviews;
	}
	public Long getLogistics_inReviews() {
		return logistics_inReviews;
	}
	public void setLogistics_inReviews(Long logistics_inReviews) {
		this.logistics_inReviews = logistics_inReviews;
	}
	public Long getLogistics_badReviews() {
		return logistics_badReviews;
	}
	public void setLogistics_badReviews(Long logistics_badReviews) {
		this.logistics_badReviews = logistics_badReviews;
	}
	public Long getLogistics_totalPoint() {
		return logistics_totalPoint;
	}
	public void setLogistics_totalPoint(Long logistics_totalPoint) {
		this.logistics_totalPoint = logistics_totalPoint;
	}
	public Long getGoodsBrands() {
		return goodsBrands;
	}
	public void setGoodsBrands(Long goodsBrands) {
		this.goodsBrands = goodsBrands;
	}
	public Long getGoodsCats() {
		return goodsCats;
	}
	public void setGoodsCats(Long goodsCats) {
		this.goodsCats = goodsCats;
	}
	public Long getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Long goodsCount) {
		this.goodsCount = goodsCount;
	}
	public Long getGoodsAddedCount() {
		return goodsAddedCount;
	}
	public void setGoodsAddedCount(Long goodsAddedCount) {
		this.goodsAddedCount = goodsAddedCount;
	}
	public Long getGoodsOffTheShelfCount() {
		return goodsOffTheShelfCount;
	}
	public void setGoodsOffTheShelfCount(Long goodsOffTheShelfCount) {
		this.goodsOffTheShelfCount = goodsOffTheShelfCount;
	}
	public Long getCustomerViews() {
		return customerViews;
	}
	public void setCustomerViews(Long customerViews) {
		this.customerViews = customerViews;
	}
	public Long getCustomerCollects() {
		return customerCollects;
	}
	public void setCustomerCollects(Long customerCollects) {
		this.customerCollects = customerCollects;
	}
	public Long getCustomerComments() {
		return customerComments;
	}
	public void setCustomerComments(Long customerComments) {
		this.customerComments = customerComments;
	}
	public Long getZhengcheCount() {
		return zhengcheCount;
	}
	public void setZhengcheCount(Long zhengcheCount) {
		this.zhengcheCount = zhengcheCount;
	}
	public Long getPeijianCount() {
		return peijianCount;
	}
	public void setPeijianCount(Long peijianCount) {
		this.peijianCount = peijianCount;
	}
	public Long getShebeiCount() {
		return shebeiCount;
	}
	public void setShebeiCount(Long shebeiCount) {
		this.shebeiCount = shebeiCount;
	}
	public Long getQixiuCount() {
		return qixiuCount;
	}
	public void setQixiuCount(Long qixiuCount) {
		this.qixiuCount = qixiuCount;
	}
	public Long getWuliuCount() {
		return wuliuCount;
	}
	public void setWuliuCount(Long wuliuCount) {
		this.wuliuCount = wuliuCount;
	}
	public Long getZulinCount() {
		return zulinCount;
	}
	public void setZulinCount(Long zulinCount) {
		this.zulinCount = zulinCount;
	}
	public Long getQiuzhiCount() {
		return qiuzhiCount;
	}
	public void setQiuzhiCount(Long qiuzhiCount) {
		this.qiuzhiCount = qiuzhiCount;
	}
	public Long getQitaCount() {
		return qitaCount;
	}
	public void setQitaCount(Long qitaCount) {
		this.qitaCount = qitaCount;
	}
	public Long getSumAllCount() {
		return sumAllCount;
	}
	public void setSumAllCount(Long sumAllCount) {
		this.sumAllCount = sumAllCount;
	}
	public Long getBellCount() {
		return bellCount;
	}
	public void setBellCount(Long bellCount) {
		this.bellCount = bellCount;
	}
	public Long getBadCount() {
		return badCount;
	}
	public void setBadCount(Long badCount) {
		this.badCount = badCount;
	}
	public Long getMiddleCount() {
		return middleCount;
	}
	public void setMiddleCount(Long middleCount) {
		this.middleCount = middleCount;
	}
	public Long getReceiveCount() {
		return receiveCount;
	}
	public void setReceiveCount(Long receiveCount) {
		this.receiveCount = receiveCount;
	}
	public Long getNoReadCount() {
		return noReadCount;
	}
	public void setNoReadCount(Long noReadCount) {
		this.noReadCount = noReadCount;
	}
	public Long getAlreadyReadCount() {
		return alreadyReadCount;
	}
	public void setAlreadyReadCount(Long alreadyReadCount) {
		this.alreadyReadCount = alreadyReadCount;
	}
	public Long getSendCount() {
		return sendCount;
	}
	public void setSendCount(Long sendCount) {
		this.sendCount = sendCount;
	}
	
}
