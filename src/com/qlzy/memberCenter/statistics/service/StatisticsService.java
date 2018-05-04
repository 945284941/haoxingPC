/**   
 * @Title: StatisticsService.java 
 * @Package com.qlzy.memberCenter.common.service 
 * @Description: TODO(个人或企业统计信息接口类) 
 * @author wangmei   
 * @date 2013-9-27 下午3:23:52 
 * @version V1.0   
 */
package com.qlzy.memberCenter.statistics.service;

import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;

public interface StatisticsService {

	/**
	 * @Title: gainOrderStatisticsByTime
	 * @Description: TODO(统计信息-订单统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainOrderStatisticsByTime(String time, String orderType,SessionInfo sessionInfo);
	
	/**
	 * @Title: gainShoppingCartStatisticsByTime
	 * @Description: TODO(统计信息-购物车统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainShoppingCartStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainFundStatisticsByTime
	 * @Description: TODO(统计信息-资金统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainFundStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainPointStatisticsByTime
	 * @Description: TODO(统计信息-经验值统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainPointStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainCollectStatisticsByTime
	 * @Description: TODO(统计信息-收藏统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainCollectStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainBrowseStatisticsByTime
	 * @Description: TODO(统计信息-浏览统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainBrowseStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainActiveStatisticsByTime
	 * @Description: TODO(统计信息-活动统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainActiveStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainMsgStatisticsByTime
	 * @Description: TODO(统计信息-信息统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainMsgStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainSettleStatisticsByTime
	 * @Description: TODO(统计信息-结算统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainSettleStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainPublishStatisticsByTime
	 * @Description: TODO(统计信息-发布统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainPublishStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainLogisticsStatisticsByTime
	 * @Description: TODO(统计信息-物流统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainLogisticsStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainCreditLevelStatisticsByTime
	 * @Description: TODO(信息统计-信誉等级统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainCreditLevelStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainServeLevelStatisticsByTime
	 * @Description: TODO(信息统计-服务等级统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainServeLevelStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainQualityLevelStatisticsByTime
	 * @Description: TODO(信息统计-质量等级统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainQualityLevelStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainLogisticsLevelStatisticsByTime
	 * @Description: TODO(信息统计-物流等级统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainLogisticsLevelStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainGoodsStatisticsByTime
	 * @Description: TODO(信息统计-商品统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainGoodsStatisticsByTime(String time, SessionInfo sessionInfo);
	
	/**
	 * @Title: gainVisitStatisticsByTime
	 * @Description: TODO(信息统计-访问统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param time
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainVisitStatisticsByTime(String time, SessionInfo sessionInfo);

	StatisticsInfo gainOrderStatisticsByTimexs(String time, String orderType,
			SessionInfo sessionInfo);
}
