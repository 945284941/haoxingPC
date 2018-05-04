package com.qlzy.util;

/**
 * @ClassName: Constant
 * @Description: 定义静态变量
 * @author Huifeng Wang
 * @date 2013-6-9 上午11:00:29
 * 
 */
public class Constant {
	public static final Long paginationRows = 10L;// 分页每页多少条
	public static final Long paginationRowsLong = 20L;// 分页每页多少条
	// 用户类型
	public static final String USERTYPE_MEMBER = "member";// 个人
	public static final String USERTYPE_COMPANY = "company";// 企业

	// 订单状态定义开始
	public static final String STATUS_UNAUDITE = "0";// 未审核
	public static final String STATUS_AUDITED = "1";// 已审核
	public static final String STATUS_CANCEL = "2";// 取消
	public static final String STATUS_NOAVAIL = "3";// 无效(或关闭)	
	// 订单状态定义结束
	
	// 订单支付状态定义开始
	public static final String PAY_STATUS_NOPAY = "0";// 未付款
	public static final String PAY_STATUS_ALREADY = "1";// 已付款
	public static final String PAY_STATUS_PROCESSING = "2";// 待退款
	public static final String PAY_STATUS_FULLREFUND = "3";// 已退款
	// 订单支付状态定义结束

	// 订单发货状态定义开始
	public static final String SHIP_STATUS_NOSHIP = "0";// 未发货
	public static final String SHIP_STATUS_ALREADY = "1";// 已发货
	public static final String SHIP_STATUS_ALREADYRECEIVE = "2";// 已收货
	public static final String SHIP_STATUS_UPONRETURN = "3";// 待退货
	public static final String SHIP_STATUS_ALREADYRETURN = "4";// 已退货
	// 订单发货状态定义结束

	// 时段定义开始
	public static final String ALLDAY = "0";// 全部
	public static final String NOW_DAY = "1";// 今日
	public static final String YESTERDAY = "2";// 昨日
	public static final String LAST_THREEDAYS = "3";// 近三天
	public static final String LAST_WEEK = "4";// 近一周
	public static final String NOW_MONTH = "5";// 本月
	public static final String NOW_YEAR = "6";// 本年
	// 时段定义结束

	// 统计信息定义开始
	public static final String ORDERSTATISTICS = "0";// 订单统计
	public static final String SHOPPINGCARTSTATISTICS = "0";// 购物车统计
	public static final String FUNDSTATISTICS = "0";// 订单统计
	// 统计信息定义结束
	
	// 资金操作类型定义开始
	public static final String FUND_RECHARGE = "0";// 充值
	public static final String FUND_WITHDRAW = "1";// 兑米
	public static final String FUND_CONSUME = "2";// 消费
	// 资金操作类型定义结束
	
	// 经验值操作类型定义开始
	public static final String POINT_GET = "0";// 获得经验值
	public static final String POINT_CONSUME = "1";// 消费经验值
	// 经验值操作类型定义结束

	// 收藏或浏览类型定义开始
	public static final String _GOODS = "goods";// 商品
	public static final String _SHOP = "shop";// 店铺
	public static final String _NEWS = "news";// 新闻
	// 收藏或浏览类型定义结束
	
	// 提问/问答类型定义开始
	public static final Integer QUESTION_ASK = 0;// 提问
	public static final Integer QUESTION_REPLY = 1;// 问答
	// 提问/问答类型定义结束
	
	// 发货类型定义开始
	public static final String DELIVERY_ZT = "Y";// 自提
	public static final String DELIVERY_WLPS = "N";// 物流配送
	// 发货类型定义结束
	
	// 诚信等级类型定义开始
	public static final String _CREDIT = "credit";// 信誉
	public static final String _SERVE = "serve";// 服务
	public static final String _QUALITY = "quality";// 质量
	public static final String _LOGISTICS = "logistics";// 物流
	// 诚信等级类型定义结束
	
	// 评价等级类型定义开始
	public static final Integer APPRAISE_GOOD = 1;// 好评
	public static final Integer APPRAISE_IN = 0;// 中评
	public static final Integer APPRAISE_BAD = -1;// 差评
	// 评价等级类型定义结束
	
	// 上下架类型定义开始
	public static final String MARKETABLE_ADDED = "true";// 上架
	public static final String MARKETABLE_OFFTHESHELF = "false";// 下架
	// 上下架类型定义结束
	
}
