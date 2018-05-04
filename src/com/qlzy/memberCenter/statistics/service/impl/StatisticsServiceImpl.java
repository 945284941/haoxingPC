/**   
 * @Title: StatisticsServiceImpl.java 
 * @Package com.qlzy.memberCenter.common.service.impl 
 * @Description: TODO(个人或企业统计信息接口实现类) 
 * @author wangmei   
 * @date 2013-9-27 下午3:24:50 
 * @version V1.0   
 */
package com.qlzy.memberCenter.statistics.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.active.dao.ActiveCollectGoodsCheckMapper;
import com.qlzy.active.dao.ActiveCollectGoodsMapper;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.mainPage.news.dao.NewsMapper;
import com.qlzy.mainPage.news.dao.SupplyMapper;
import com.qlzy.mainPage.school.dao.TechnologyAnswerMapper;
import com.qlzy.mainPage.school.dao.TechnologyQuestionMapper;
import com.qlzy.memberCenter.call.dao.MemberCollectMapper;
import com.qlzy.memberCenter.common.dao.AppraiseMapper;
import com.qlzy.memberCenter.common.dao.PointDetailMapper;
import com.qlzy.memberCenter.common.dao.ViewsMapper;
import com.qlzy.memberCenter.order.dao.OrderMapper;
import com.qlzy.memberCenter.person.active.dao.DataDownloadMapper;
import com.qlzy.memberCenter.person.moneyManage.dao.AdvanceLogsMapper;
import com.qlzy.memberCenter.shop.dao.CompanysGoodsCatMapper;
import com.qlzy.memberCenter.statistics.service.StatisticsService;
import com.qlzy.model.Company;
import com.qlzy.model.Member;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.Constant;

@Service("statisticsService")
@Transactional(rollbackFor=Exception.class)
public class StatisticsServiceImpl implements StatisticsService {
	
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private AdvanceLogsMapper advanceLogsMapper;
	@Resource
	private PointDetailMapper pointDetailMapper;
	@Resource
	private MemberCollectMapper memberCollectMapper;
	@Resource
	private ViewsMapper viewsMapper;
	@Resource
	private DataDownloadMapper dataDownloadMapper;
	@Resource
	private TechnologyQuestionMapper technologyQuestionMapper;
	@Resource
	private TechnologyAnswerMapper technologyAnswerMapper;
	@Resource
	private ActiveCollectGoodsMapper activeCollectGoodsMapper;
	@Resource
	private ActiveCollectGoodsCheckMapper activeCollectGoodsCheckMapper;
	@Resource
	private AppraiseMapper appraiseMapper;
	@Resource
	private MemberMapper memberMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private NewsMapper newsMapper;
	@Resource
	private CompanysGoodsCatMapper companysGoodsCatMapper;
	@Resource
	private SupplyMapper supplyMapper;

	/**
	 * (非 Javadoc) 
	 * @Title:gainOrderStatisticsByTime 
	 * @Description: TODO(统计信息-订单统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainOrderStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo)
	 */
	@Override
	public StatisticsInfo gainOrderStatisticsByTime(String time, String orderType,SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("orderType", orderType);//0普通订单  1串货订单
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("payStatus", Constant.PAY_STATUS_NOPAY);
		paramMap.put("shipStatus", Constant.SHIP_STATUS_NOSHIP);
		statisticsInfo.setNoPayAndShipOrderCount(orderMapper.gainOrderStatisticsByTime(paramMap));// 未付款未发货订单数
		paramMap.put("payStatus", Constant.PAY_STATUS_ALREADY);
		statisticsInfo.setAlreadyPayAndNoShipOrderCount(orderMapper.gainOrderStatisticsByTime(paramMap));// 已付款未发货订单数
		paramMap.put("shipStatus", Constant.SHIP_STATUS_ALREADY);
		statisticsInfo.setAlreadyPayAndShipOrderCount(orderMapper.gainOrderStatisticsByTime(paramMap));// 已付款已发货订单数
		paramMap.put("payStatus", "");
		paramMap.put("shipStatus", Constant.SHIP_STATUS_ALREADYRECEIVE);
		statisticsInfo.setCompleteOfTheTransactionHistoryOrderCount(orderMapper.gainOrderStatisticsByTime(paramMap));// 历史交易完成订单数
		paramMap.put("payStatus", "");
		paramMap.put("shipStatus", "");
		paramMap.put("status",Constant.STATUS_NOAVAIL);
		statisticsInfo.setCloseOfTheTransactionHistoryOrderCount(orderMapper.gainOrderStatisticsByTime(paramMap));// 历史交易关闭订单数
		paramMap.put("payStatus", Constant.PAY_STATUS_PROCESSING);
		paramMap.put("shipStatus", Constant.SHIP_STATUS_ALREADYRETURN);
		paramMap.put("status","");
		statisticsInfo.setAlreadyReturnAndNoFullrefundOrderCount(orderMapper.gainOrderStatisticsByTime(paramMap));// 已退货待退款订单数
		paramMap.put("payStatus", Constant.PAY_STATUS_FULLREFUND);
		statisticsInfo.setAlreadyReturnAndFullrefundOrderCount(orderMapper.gainOrderStatisticsByTime(paramMap));// 已退货已退款订单数
		return statisticsInfo;
	}
	@Override
	public StatisticsInfo gainOrderStatisticsByTimexs(String time, String orderType,SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("orderType", orderType);//0普通订单  1串货订单
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("payStatus", Constant.PAY_STATUS_NOPAY);
		paramMap.put("shipStatus", Constant.SHIP_STATUS_NOSHIP);
		statisticsInfo.setNoPayAndShipOrderCount(orderMapper.gainOrderStatisticsByTimexs(paramMap));// 未付款未发货订单数
		paramMap.put("payStatus", Constant.PAY_STATUS_ALREADY);
		statisticsInfo.setAlreadyPayAndNoShipOrderCount(orderMapper.gainOrderStatisticsByTimexs(paramMap));// 已付款未发货订单数
		paramMap.put("shipStatus", Constant.SHIP_STATUS_ALREADY);
		statisticsInfo.setAlreadyPayAndShipOrderCount(orderMapper.gainOrderStatisticsByTimexs(paramMap));// 已付款已发货订单数
		paramMap.put("payStatus", "");
		paramMap.put("shipStatus", Constant.SHIP_STATUS_ALREADYRECEIVE);
		statisticsInfo.setCompleteOfTheTransactionHistoryOrderCount(orderMapper.gainOrderStatisticsByTimexs(paramMap));// 历史交易完成订单数
		paramMap.put("payStatus", "");
		paramMap.put("shipStatus", "");
		paramMap.put("status",Constant.STATUS_NOAVAIL);
		statisticsInfo.setCloseOfTheTransactionHistoryOrderCount(orderMapper.gainOrderStatisticsByTimexs(paramMap));// 历史交易关闭订单数
		paramMap.put("payStatus", Constant.PAY_STATUS_PROCESSING);
		paramMap.put("shipStatus", Constant.SHIP_STATUS_ALREADYRETURN);
		paramMap.put("status","");
		statisticsInfo.setAlreadyReturnAndNoFullrefundOrderCount(orderMapper.gainOrderStatisticsByTimexs(paramMap));// 已退货待退款订单数
		paramMap.put("payStatus", Constant.PAY_STATUS_FULLREFUND);
		statisticsInfo.setAlreadyReturnAndFullrefundOrderCount(orderMapper.gainOrderStatisticsByTimexs(paramMap));// 已退货已退款订单数
		return statisticsInfo;
	}
	/**
	 * (非 Javadoc) 
	 * @Title:gainShoppingCartStatisticsByTime 
	 * @Description: TODO(统计信息-购物车统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainShoppingCartStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo)
	 */
	@Override
	public StatisticsInfo gainShoppingCartStatisticsByTime(String time,SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		statisticsInfo.setShoppingCartQuantity(goodsMapper.gainShoppingCartQuantityByTime(paramMap));// 购物车商品数量
		statisticsInfo.setShoppingCartTotal(goodsMapper.gainShoppingCartTotalByTime(paramMap));// 购物车商品总价
		statisticsInfo.setShoppingCartQuantity(statisticsInfo.getShoppingCartQuantity() == null?0:statisticsInfo.getShoppingCartQuantity());
		statisticsInfo.setShoppingCartTotal(statisticsInfo.getShoppingCartTotal() == null ?0:statisticsInfo.getShoppingCartTotal());
		return statisticsInfo;
	}
	
	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(统计信息-资金统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.common.service.StatisticsService#gainFundStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainFundStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("operateType", Constant.FUND_RECHARGE);
		statisticsInfo.setDepositTotal(advanceLogsMapper.gainFundStatisticsByTime(paramMap));// 存入总额
		paramMap.put("operateType", Constant.FUND_CONSUME);
		statisticsInfo.setExpendTotal(advanceLogsMapper.gainFundStatisticsByTime(paramMap));// 支出总额
		paramMap.put("operateType", Constant.FUND_WITHDRAW);
		statisticsInfo.setWithdrawTotal(advanceLogsMapper.gainFundStatisticsByTime(paramMap));// 兑米总额
		//获取资金余额
		if("member".equals(sessionInfo.getUserType())){// 个人
			Member member = memberMapper.gainMemberById(sessionInfo.getUserId());
			if(member != null && member.getAdvance() != null){
				statisticsInfo.setMoneyBalance(member.getAdvance());
			}
		}else {// 企业
			Company company = companyMapper.selectByPrimaryKey(sessionInfo.getUserId());
			if(company != null && company.getAdvance() != null){
//				statisticsInfo.setMoneyBalance(company.getAdvance());
			}
		}
		statisticsInfo.setDepositTotal(statisticsInfo.getDepositTotal() == null ? 0:statisticsInfo.getDepositTotal());
		statisticsInfo.setExpendTotal(statisticsInfo.getExpendTotal() == null ? 0:statisticsInfo.getExpendTotal());
		statisticsInfo.setWithdrawTotal(statisticsInfo.getWithdrawTotal() == null ? 0:statisticsInfo.getWithdrawTotal());
		statisticsInfo.setMoneyBalance(statisticsInfo.getMoneyBalance() == null ? 0:statisticsInfo.getMoneyBalance());
		return statisticsInfo;
	}
	
	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(统计信息-经验值统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.common.service.StatisticsService#gainPointStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainPointStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Double point = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("operateType", Constant.POINT_GET);
		statisticsInfo.setPointAddUp(pointDetailMapper.gainPointStatisticsByTime(paramMap));// 累计经验值
		paramMap.put("operateType", Constant.POINT_CONSUME);
		statisticsInfo.setPointExpend(pointDetailMapper.gainPointStatisticsByTime(paramMap));// 消费经验值
		//获取经验值余额
		if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){// 个人
			point = memberMapper.gainMemberById(sessionInfo.getUserId()).getPoint();
			if(null != point && !"".equals(point)){
				statisticsInfo.setPointBalance(point.longValue());
			}
		}
		statisticsInfo.setPointAddUp(statisticsInfo.getPointAddUp() == null ? 0:statisticsInfo.getPointAddUp());
		statisticsInfo.setPointExpend(statisticsInfo.getPointExpend() == null ? 0:statisticsInfo.getPointExpend());
		return statisticsInfo;
	}

	/**
	 * (非 Javadoc) 
	 * @Title:gainCollectStatisticsByTime 
	 * @Description: TODO(统计信息-收藏统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainCollectStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo)
	 */
	@Override
	public StatisticsInfo gainCollectStatisticsByTime(String time, SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("collectType", Constant._GOODS);
		statisticsInfo.setCollectGoodsCount(memberCollectMapper.gainCollectStatisticsByTime(paramMap));// 收藏商品总数
		paramMap.put("collectType", Constant._NEWS);
		statisticsInfo.setCollectNewsCount(memberCollectMapper.gainCollectStatisticsByTime(paramMap));// 收藏商铺总数
		paramMap.put("collectType", Constant._SHOP);
		statisticsInfo.setCollectShopCount(memberCollectMapper.gainCollectStatisticsByTime(paramMap));// 收藏资讯总数
		return statisticsInfo;
	}

	/**
	 * (非 Javadoc) 
	 * @Title:gainBrowseStatisticsByTime 
	 * @Description: TODO(统计信息-浏览统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainBrowseStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo)
	 */
	@Override
	public StatisticsInfo gainBrowseStatisticsByTime(String time, SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("browseType", Constant._GOODS);
		statisticsInfo.setBrowseGoodsCount(viewsMapper.gainBrowseStatisticsByTime(paramMap));// 浏览商品总数
		paramMap.put("browseType", Constant._NEWS);
		statisticsInfo.setBrowseNewsCount(viewsMapper.gainBrowseStatisticsByTime(paramMap));// 浏览商铺总数
		paramMap.put("browseType", Constant._SHOP);
		statisticsInfo.setBrowseShopCount(viewsMapper.gainBrowseStatisticsByTime(paramMap));// 浏览资讯总数
		return statisticsInfo;
	}
	
	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(统计信息-活动统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.common.service.StatisticsService#gainActiveStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainActiveStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		statisticsInfo.setDownloadData(dataDownloadMapper.gainDownloadStatisticsByTime(paramMap));// 下载资料
		paramMap.put("questionType", Constant.QUESTION_ASK);
		statisticsInfo.setAskQuestions(technologyQuestionMapper.gainQuestionStatisticsByTime(paramMap));// 提问
		paramMap.put("questionType", Constant.QUESTION_REPLY);
		statisticsInfo.setReplyQuestions(technologyAnswerMapper.gainAnswerStatisticsByTime(paramMap));// 问答
		if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){// 个人
			paramMap.put("status", "");
			statisticsInfo.setUploadCount(activeCollectGoodsMapper.gainUploadStatisticsByTime(paramMap));// 上传数据
			paramMap.put("status", 1);
			statisticsInfo.setUploadPassCount(activeCollectGoodsMapper.gainUploadStatisticsByTime(paramMap));// 上传采用
			paramMap.put("status", "");
			statisticsInfo.setCheckCount(activeCollectGoodsCheckMapper.gainCheckStatisticsByTime(paramMap));// 校对数据
			paramMap.put("status", 1);
			statisticsInfo.setCheckPassCount(activeCollectGoodsCheckMapper.gainCheckStatisticsByTime(paramMap));// 校对采用			
			statisticsInfo.setAddUpReward(memberMapper.gainMemberById(sessionInfo.getUserId()).getAdvance());// 累计奖金
		}
		return statisticsInfo;
	}

	/**
	 * (非 Javadoc) 
	 * @Title:gainMsgStatisticsByTime 
	 * @Description: TODO(统计信息-信息统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainMsgStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo)
	 */
	@Override
	public StatisticsInfo gainMsgStatisticsByTime(String time, SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("userType", Constant.USERTYPE_MEMBER);
		statisticsInfo.setCommentCount(appraiseMapper.gainGoodsReviewsStatisticsByTime(paramMap));
		return statisticsInfo;
	}

	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(统计信息-结算统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainSettleStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainSettleStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("shipStatus", Constant.SHIP_STATUS_ALREADYRECEIVE);
		statisticsInfo.setTotalTradeAmount(orderMapper.gainSettleStatisticsByTime(paramMap));// 总交易额
		statisticsInfo.setTotalTradeAmount(statisticsInfo.getTotalTradeAmount() == null?0:statisticsInfo.getTotalTradeAmount());
		return statisticsInfo;
	}

	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(统计信息-发布统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainPublishStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainPublishStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		statisticsInfo.setTotalSupplyInfo(supplyMapper.gainSupplyStatisticsByTime(paramMap));// 发布的供求信息数
		statisticsInfo.setTotalNews(newsMapper.gainNewsStatisticsByTime(paramMap));// 发布的新闻资讯数
		return statisticsInfo;
	}

	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(统计信息-物流统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainLogisticsStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainLogisticsStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("shipStatus", Constant.SHIP_STATUS_ALREADYRECEIVE);
		paramMap.put("isDelivery", Constant.DELIVERY_ZT);
		statisticsInfo.setTotalSinceTheMention(orderMapper.gainLogisticsStatisticsByTime(paramMap));// 客户自提数
		paramMap.put("isDelivery", Constant.DELIVERY_WLPS);
		statisticsInfo.setTotalDelivery(orderMapper.gainLogisticsStatisticsByTime(paramMap));// 物流配送数
		paramMap.put("isDelivery", "");
		paramMap.put("shipStatus", Constant.SHIP_STATUS_ALREADYRETURN);
		statisticsInfo.setTotalReturns(orderMapper.gainLogisticsStatisticsByTime(paramMap));// 退货数
		return statisticsInfo;
	}

	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(信息统计-信誉等级统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainCreditLevelStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainCreditLevelStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("selType", 1);
		paramMap.put("appraiseType", Constant._CREDIT);
		paramMap.put("appraiseLevel", Constant.APPRAISE_GOOD);
		statisticsInfo.setCredit_greatReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 信誉好评数
		paramMap.put("appraiseLevel", Constant.APPRAISE_IN);
		statisticsInfo.setCredit_inReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 信誉中评数
		paramMap.put("appraiseLevel", Constant.APPRAISE_BAD);
		statisticsInfo.setCredit_badReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 信誉差评数
		paramMap.put("selType", 2);
		paramMap.put("sumType", Constant._CREDIT);
		paramMap.put("appraiseType", "");
		statisticsInfo.setCredit_totalPoint(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 信誉经验值
		statisticsInfo.setCredit_totalPoint(statisticsInfo.getCredit_totalPoint() == null?0:statisticsInfo.getCredit_totalPoint());
		return statisticsInfo;
	}

	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(信息统计-服务等级统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainServeLevelStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainServeLevelStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("selType", 1);
		paramMap.put("appraiseType", Constant._SERVE);
		paramMap.put("appraiseLevel", Constant.APPRAISE_GOOD);
		statisticsInfo.setServe_greatReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 服务好评数
		paramMap.put("appraiseLevel", Constant.APPRAISE_IN);
		statisticsInfo.setServe_inReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 服务中评数
		paramMap.put("appraiseLevel", Constant.APPRAISE_BAD);
		statisticsInfo.setServe_badReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 服务差评数
		paramMap.put("selType", 2);
		paramMap.put("sumType", Constant._SERVE);
		paramMap.put("appraiseType", "");
		statisticsInfo.setServe_totalPoint(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 服务经验值
		statisticsInfo.setServe_totalPoint(statisticsInfo.getServe_totalPoint() == null?0:statisticsInfo.getServe_totalPoint());
		return statisticsInfo;
	}

	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(信息统计-质量等级统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainQualityLevelStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainQualityLevelStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("selType", 1);
		paramMap.put("appraiseType", Constant._QUALITY);
		paramMap.put("appraiseLevel", Constant.APPRAISE_GOOD);
		statisticsInfo.setQuality_greatReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 质量好评数
		paramMap.put("appraiseLevel", Constant.APPRAISE_IN);
		statisticsInfo.setQuality_inReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 质量中评数
		paramMap.put("appraiseLevel", Constant.APPRAISE_BAD);
		statisticsInfo.setQuality_badReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 质量差评数
		paramMap.put("selType", 2);
		paramMap.put("sumType", Constant._QUALITY);
		paramMap.put("appraiseType", "");
		statisticsInfo.setQuality_totalPoint(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 质量经验值
		statisticsInfo.setQuality_totalPoint(statisticsInfo.getQuality_totalPoint() == null?0:statisticsInfo.getQuality_totalPoint());
		return statisticsInfo;
	}

	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(信息统计-物流等级统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainLogisticsLevelStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainLogisticsLevelStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("selType", 1);
		paramMap.put("appraiseType", Constant._LOGISTICS);
		paramMap.put("appraiseLevel", Constant.APPRAISE_GOOD);
		statisticsInfo.setLogistics_greatReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 物流好评数
		paramMap.put("appraiseLevel", Constant.APPRAISE_IN);
		statisticsInfo.setLogistics_inReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 物流中评数
		paramMap.put("appraiseLevel", Constant.APPRAISE_BAD);
		statisticsInfo.setLogistics_badReviews(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 物流差评数
		paramMap.put("selType", 2);
		paramMap.put("sumType", Constant._LOGISTICS);
		paramMap.put("appraiseType", "");
		statisticsInfo.setLogistics_totalPoint(appraiseMapper.gainIntegrityLevelStatisticsByTime(paramMap));// 物流经验值
		statisticsInfo.setLogistics_totalPoint(statisticsInfo.getLogistics_totalPoint() == null?0:statisticsInfo.getLogistics_totalPoint());
		return statisticsInfo;
	}

	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(信息统计-商品统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainGoodsStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainGoodsStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", sessionInfo.getUserId());
		statisticsInfo.setGoodsCats(companysGoodsCatMapper.gainCompanysGoodsCats(paramMap));// 商品分类数
		paramMap.put("time", time);
		statisticsInfo.setGoodsCount(goodsMapper.gainGoodsStatisticsByTime(paramMap));// 商品总数
		paramMap.put("marketable", Constant.MARKETABLE_ADDED);
		statisticsInfo.setGoodsAddedCount(goodsMapper.gainGoodsStatisticsByTime(paramMap));// 商品上架总数
		paramMap.put("marketable", Constant.MARKETABLE_OFFTHESHELF);
		statisticsInfo.setGoodsOffTheShelfCount(goodsMapper.gainGoodsStatisticsByTime(paramMap));// 商品下架总数
		return statisticsInfo;
	}

	/** (非 Javadoc) 
	 * @Title: StatisticsServiceImpl.java 
	 * @Description: TODO(信息统计-访问统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))  
	 * @param time
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainVisitStatisticsByTime(java.lang.String, com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public StatisticsInfo gainVisitStatisticsByTime(String time,
			SessionInfo sessionInfo) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("time", time);
		paramMap.put("userId", sessionInfo.getUserId());
		paramMap.put("browseType", Constant._GOODS);
		statisticsInfo.setCustomerViews(viewsMapper.gainCustomerViewsStatisticsByTime(paramMap));// 客户浏览商品数
		paramMap.put("collectType", Constant._GOODS);
		statisticsInfo.setCustomerCollects(memberCollectMapper.gainCustomerCollectsStatisticsByTime(paramMap));// 客户收藏商品数
		paramMap.put("userType", Constant.USERTYPE_COMPANY);
		statisticsInfo.setCustomerComments(appraiseMapper.gainGoodsReviewsStatisticsByTime(paramMap));// 客户评论商品数
		return statisticsInfo;
	}
}
