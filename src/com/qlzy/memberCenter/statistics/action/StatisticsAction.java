/**   
 * @Title: StatisticsAction.java 
 * @Package com.qlzy.memberCenter.statistics.action 
 * @Description: TODO(个人会员或企业会员统计信息管理) 
 * @author wangmei   
 * @date 2013-10-19 下午2:05:33 
 * @version V1.0   
 */
package com.qlzy.memberCenter.statistics.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService;
import com.qlzy.memberCenter.person.perinfo.service.PersonalInfoService;
import com.qlzy.memberCenter.statistics.service.StatisticsService;
import com.qlzy.model.Company;
import com.qlzy.model.Member;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Constant;

@Namespace("/statisticsManage")
@Action(value = "statisticsAction", results = {
		@Result(name = "toPerStatistics", location = "/memberCenter/person/personalInfo/statistics.jsp"),
		@Result(name = "toComStatistics", location = "/memberCenter/company/commpanyInfo/statistics.jsp"),
		@Result(name = "showRightStatisticsForC", location = "/memberCenter/common/rightVipStatistics.jsp"),
		@Result(name = "showRightStatisticsForM", location = "/memberCenter/person/personalInfo/rightjxw.jsp"),
		@Result(name = "error", location = "/error/404.jsp")
})
public class StatisticsAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	private StatisticsService statisticsService;// 统计信息接口类
	@Resource
	private CompanyInfoService companyInfoService;
	@Resource
	private PersonalInfoService personalInfoService;
	
	private StatisticsInfo orderStatisticsInfo;// 订单统计
	private StatisticsInfo shoppingCartStatisticsInfo;// 购物车统计
	private StatisticsInfo fundStatisticsInfo;// 资金统计
	private StatisticsInfo pointStatisticsInfo;// 经验值统计
	private StatisticsInfo collectStatisticsInfo;// 收藏统计
	private StatisticsInfo browseStatisticsInfo;// 浏览统计
	private StatisticsInfo activeStatisticsInfo;// 活动统计
	private StatisticsInfo msgStatisticsInfo;// 信息统计
	private StatisticsInfo settleStatisticsInfo;// 结算统计
	private StatisticsInfo publishStatisticsInfo;// 发布统计
	private StatisticsInfo logisticsStatisticsInfo;// 物流统计
	private StatisticsInfo creditLevelStatisticsInfo;// 信誉等级统计
	private StatisticsInfo serveLevelStatisticsInfo;// 服务等级统计
	private StatisticsInfo qualityLevelStatisticsInfo;// 质量等级统计
	private StatisticsInfo logisticsLevelStatisticsInfo;// 物流等级统计
	private StatisticsInfo goodsStatisticsInfo;// 商品统计
	private StatisticsInfo visitStatisticsInfo;// 访问统计
	
	private Member member;// 个人会员实体类
	private Company company;// 企业会员实体类
	
	private String type;// 统计类型
	private String time;// 时段
	
	/**
	 * @Title: toStatistics
	 * @Description: TODO(跳转统计信息页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 * @author wangmei
	 */
	public String toStatistics(){
		try {
			SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
					.getSessionInfoName());// 获取登录人的信息
			if(null == sessionInfo){
				return "login_hf";
			}
			
			/**
			 * 从订单统计到信息统计为个人与企业共有统计
			 */
			// 订单统计
			orderStatisticsInfo = statisticsService.gainOrderStatisticsByTime("0","0", sessionInfo);
			
			// 购物车统计
			shoppingCartStatisticsInfo = statisticsService.gainShoppingCartStatisticsByTime("0", sessionInfo);
			
			// 资金统计
			fundStatisticsInfo = statisticsService.gainFundStatisticsByTime("0", sessionInfo);
			
			// 经验值统计
			pointStatisticsInfo = statisticsService.gainPointStatisticsByTime("0", sessionInfo);
			
			// 收藏统计
			collectStatisticsInfo = statisticsService.gainCollectStatisticsByTime("0", sessionInfo);
			
			// 浏览统计
			browseStatisticsInfo = statisticsService.gainBrowseStatisticsByTime("0", sessionInfo);
			
			// 活动统计
			activeStatisticsInfo = statisticsService.gainActiveStatisticsByTime("0", sessionInfo);
			
			// 信息统计
			msgStatisticsInfo = statisticsService.gainMsgStatisticsByTime("0", sessionInfo);
			
			if("company".equals(sessionInfo.getUserType())){// 企业统计信息
				
				// 结算统计
				settleStatisticsInfo = statisticsService.gainSettleStatisticsByTime("0", sessionInfo);
				
				// 发布统计
				publishStatisticsInfo = statisticsService.gainPublishStatisticsByTime("0", sessionInfo);
				
				// 物流统计
				logisticsStatisticsInfo = statisticsService.gainLogisticsStatisticsByTime("0", sessionInfo);
				
				// 信誉等级统计
				creditLevelStatisticsInfo = statisticsService.gainCreditLevelStatisticsByTime("0", sessionInfo);
				
				// 服务等级统计
				serveLevelStatisticsInfo = statisticsService.gainServeLevelStatisticsByTime("0", sessionInfo);
				
				// 质量等级统计
				qualityLevelStatisticsInfo = statisticsService.gainQualityLevelStatisticsByTime("0", sessionInfo);
				
				// 物流等级统计
				logisticsLevelStatisticsInfo = statisticsService.gainLogisticsLevelStatisticsByTime("0", sessionInfo);
				
				// 商品统计
				goodsStatisticsInfo = statisticsService.gainGoodsStatisticsByTime("0", sessionInfo);
				
				// 访问统计
				visitStatisticsInfo = statisticsService.gainVisitStatisticsByTime("0", sessionInfo);
				return "toComStatistics";
			}else{// 个人统计信息
				return "toPerStatistics";
			}
		} catch (Exception e) {
			logger.error("统计信息异常！", e);
			return ERROR;
		}
	}
	
	/**
	 * @Title: PersonalInfoAction.java 
	 * @Description: TODO(根据时段查询各类型的统计信息) 
	 * @param     设定文件 
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void gainStatisticsByTime(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if("ddtj".equals(type)){// 订单统计
				orderStatisticsInfo = statisticsService.gainOrderStatisticsByTime(time, "0",sessionInfo);
				orderStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", orderStatisticsInfo);
			}else if("gwctj".equals(type)){// 购物车统计
				shoppingCartStatisticsInfo = statisticsService.gainShoppingCartStatisticsByTime(time, sessionInfo);
				shoppingCartStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", shoppingCartStatisticsInfo);
			}else if("zjtj".equals(type)){// 资金统计
				fundStatisticsInfo = statisticsService.gainFundStatisticsByTime(time, sessionInfo);
				fundStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", fundStatisticsInfo);
			}else if("jftj".equals(type)){//  经验值统计
				pointStatisticsInfo = statisticsService.gainPointStatisticsByTime(time, sessionInfo);
				pointStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", pointStatisticsInfo);
			}else if("sctj".equals(type)){//  收藏统计
				collectStatisticsInfo = statisticsService.gainCollectStatisticsByTime(time, sessionInfo);
				collectStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", collectStatisticsInfo);
			}else if("lltj".equals(type)){//  浏览统计
				browseStatisticsInfo = statisticsService.gainBrowseStatisticsByTime(time, sessionInfo);
				browseStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", browseStatisticsInfo);
			}else if("hdtj".equals(type)){//  活动统计
				activeStatisticsInfo = statisticsService.gainActiveStatisticsByTime(time, sessionInfo);
				activeStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", activeStatisticsInfo);
			}else if("xxtj".equals(type)){// 信息统计
				msgStatisticsInfo = statisticsService.gainMsgStatisticsByTime(time, sessionInfo);
				msgStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", msgStatisticsInfo);
			}else if("jstj".equals(type)){// 结算统计
				settleStatisticsInfo = statisticsService.gainSettleStatisticsByTime(time, sessionInfo);
				settleStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", settleStatisticsInfo);
			}else if("fbtj".equals(type)){// 发布统计
				publishStatisticsInfo = statisticsService.gainPublishStatisticsByTime(time, sessionInfo);
				publishStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", publishStatisticsInfo);
			}else if("wltj".equals(type)){// 物流统计
				logisticsStatisticsInfo = statisticsService.gainLogisticsStatisticsByTime(time, sessionInfo);
				logisticsStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", logisticsStatisticsInfo);
			}else if("xydjtj".equals(type)){// 信誉等级统计
				creditLevelStatisticsInfo = statisticsService.gainCreditLevelStatisticsByTime(time, sessionInfo);
				creditLevelStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", creditLevelStatisticsInfo);
			}else if("fwdjtj".equals(type)){// 服务等级统计
				serveLevelStatisticsInfo = statisticsService.gainServeLevelStatisticsByTime(time, sessionInfo);
				serveLevelStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", serveLevelStatisticsInfo);
			}else if("zldjtj".equals(type)){// 质量等级统计
				qualityLevelStatisticsInfo = statisticsService.gainQualityLevelStatisticsByTime(time, sessionInfo);
				qualityLevelStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", qualityLevelStatisticsInfo);
			}else if("wldjtj".equals(type)){// 物流等级统计
				logisticsLevelStatisticsInfo = statisticsService.gainLogisticsLevelStatisticsByTime(time, sessionInfo);
				logisticsLevelStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", logisticsLevelStatisticsInfo);
			}else if("sptj".equals(type)){//商品统计
				goodsStatisticsInfo = statisticsService.gainGoodsStatisticsByTime(time, sessionInfo);
				goodsStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", goodsStatisticsInfo);
			}else if("fwtj".equals(type)){//访问统计
				visitStatisticsInfo = statisticsService.gainVisitStatisticsByTime(time, sessionInfo);
				visitStatisticsInfo.setStatisticsType(type);
				map.put("perStatisticsInfo", visitStatisticsInfo);
			}else{
				map.put("perStatisticsInfo", "没有查到此类统计！");
			}
		} catch (Exception e) {
			logger.error("根据时段查询统计信息", e);
			e.printStackTrace();
		}
		writeJson(map);
	}
	
	/**
	 * @Title: showRightStatistics
	 * @Description: TODO(公共右侧统计) 
	 * @param @return    设定文件 
	 * @return String 返回类型 
	 * @author wangmei
	 */
	public String showRightStatistics(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){
			// 会员信息
			member = personalInfoService.gainMemberById(sessionInfo.getUserId());
			return "showRightStatisticsForM";
		}else{
			// 企业信息
			company = companyInfoService.gainCompanyById(sessionInfo
					.getUserId());
//			company.setAdvance(company.getAdvance() == null?0:company.getAdvance());
			return "showRightStatisticsForC";
		}
	}

	public StatisticsInfo getOrderStatisticsInfo() {
		return orderStatisticsInfo;
	}

	public void setOrderStatisticsInfo(StatisticsInfo orderStatisticsInfo) {
		this.orderStatisticsInfo = orderStatisticsInfo;
	}

	public StatisticsInfo getShoppingCartStatisticsInfo() {
		return shoppingCartStatisticsInfo;
	}

	public void setShoppingCartStatisticsInfo(
			StatisticsInfo shoppingCartStatisticsInfo) {
		this.shoppingCartStatisticsInfo = shoppingCartStatisticsInfo;
	}

	public StatisticsInfo getFundStatisticsInfo() {
		return fundStatisticsInfo;
	}

	public void setFundStatisticsInfo(StatisticsInfo fundStatisticsInfo) {
		this.fundStatisticsInfo = fundStatisticsInfo;
	}

	public StatisticsInfo getPointStatisticsInfo() {
		return pointStatisticsInfo;
	}

	public void setPointStatisticsInfo(StatisticsInfo pointStatisticsInfo) {
		this.pointStatisticsInfo = pointStatisticsInfo;
	}

	public StatisticsInfo getCollectStatisticsInfo() {
		return collectStatisticsInfo;
	}

	public void setCollectStatisticsInfo(StatisticsInfo collectStatisticsInfo) {
		this.collectStatisticsInfo = collectStatisticsInfo;
	}

	public StatisticsInfo getBrowseStatisticsInfo() {
		return browseStatisticsInfo;
	}

	public void setBrowseStatisticsInfo(StatisticsInfo browseStatisticsInfo) {
		this.browseStatisticsInfo = browseStatisticsInfo;
	}

	public StatisticsInfo getActiveStatisticsInfo() {
		return activeStatisticsInfo;
	}

	public void setActiveStatisticsInfo(StatisticsInfo activeStatisticsInfo) {
		this.activeStatisticsInfo = activeStatisticsInfo;
	}

	public StatisticsInfo getMsgStatisticsInfo() {
		return msgStatisticsInfo;
	}

	public void setMsgStatisticsInfo(StatisticsInfo msgStatisticsInfo) {
		this.msgStatisticsInfo = msgStatisticsInfo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public StatisticsInfo getPublishStatisticsInfo() {
		return publishStatisticsInfo;
	}

	public void setPublishStatisticsInfo(StatisticsInfo publishStatisticsInfo) {
		this.publishStatisticsInfo = publishStatisticsInfo;
	}

	public StatisticsInfo getLogisticsStatisticsInfo() {
		return logisticsStatisticsInfo;
	}

	public void setLogisticsStatisticsInfo(StatisticsInfo logisticsStatisticsInfo) {
		this.logisticsStatisticsInfo = logisticsStatisticsInfo;
	}
	
	public StatisticsInfo getSettleStatisticsInfo() {
		return settleStatisticsInfo;
	}

	public void setSettleStatisticsInfo(StatisticsInfo settleStatisticsInfo) {
		this.settleStatisticsInfo = settleStatisticsInfo;
	}

	public StatisticsInfo getCreditLevelStatisticsInfo() {
		return creditLevelStatisticsInfo;
	}

	public void setCreditLevelStatisticsInfo(
			StatisticsInfo creditLevelStatisticsInfo) {
		this.creditLevelStatisticsInfo = creditLevelStatisticsInfo;
	}

	public StatisticsInfo getServeLevelStatisticsInfo() {
		return serveLevelStatisticsInfo;
	}

	public void setServeLevelStatisticsInfo(StatisticsInfo serveLevelStatisticsInfo) {
		this.serveLevelStatisticsInfo = serveLevelStatisticsInfo;
	}

	public StatisticsInfo getQualityLevelStatisticsInfo() {
		return qualityLevelStatisticsInfo;
	}

	public void setQualityLevelStatisticsInfo(
			StatisticsInfo qualityLevelStatisticsInfo) {
		this.qualityLevelStatisticsInfo = qualityLevelStatisticsInfo;
	}

	public StatisticsInfo getLogisticsLevelStatisticsInfo() {
		return logisticsLevelStatisticsInfo;
	}

	public void setLogisticsLevelStatisticsInfo(
			StatisticsInfo logisticsLevelStatisticsInfo) {
		this.logisticsLevelStatisticsInfo = logisticsLevelStatisticsInfo;
	}

	public StatisticsInfo getGoodsStatisticsInfo() {
		return goodsStatisticsInfo;
	}

	public void setGoodsStatisticsInfo(StatisticsInfo goodsStatisticsInfo) {
		this.goodsStatisticsInfo = goodsStatisticsInfo;
	}

	public StatisticsInfo getVisitStatisticsInfo() {
		return visitStatisticsInfo;
	}

	public void setVisitStatisticsInfo(StatisticsInfo visitStatisticsInfo) {
		this.visitStatisticsInfo = visitStatisticsInfo;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
