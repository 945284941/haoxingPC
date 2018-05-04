package com.qlzy.memberCenter.person.moneyManage.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.constant.MobileMessageContant;
import com.qlzy.common.tools.MessageUtil;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.memberCenter.company.companyMember.service.CompanyMemberService;
import com.qlzy.memberCenter.person.moneyManage.service.MoneyManageService;
import com.qlzy.memberCenter.person.perinfo.service.PersonalInfoService;
import com.qlzy.memberCenter.statistics.service.StatisticsService;
import com.qlzy.model.AdvanceLogs;
import com.qlzy.model.MobileMessage;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;
/**
 * @ClassName: MoneyManageAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhao yang bin
 * @date 2013-9-24 下午1:33:41
 *
 */
@Namespace("/")
@Action(value = "moneyManage", results = {
		@Result(name = "moneyList", location = "/memberCenter/person/moneyCenter/myMoney.jsp"),
		@Result(name = "moneyListCompany", location = "/memberCenter/company/moneyCenter/myMoney.jsp"),
		@Result(name = "toRecharge", location = "/memberCenter/person/moneyCenter/addMoney.jsp"),
		@Result(name = "toRechargeCompany", location = "/memberCenter/company/moneyCenter/addMoney.jsp"),
		@Result(name = "toWithdrawCompany", location = "/memberCenter/company/moneyCenter/enchashment.jsp"),
		@Result(name = "toWithdraw", location = "/memberCenter/person/moneyCenter/enchashment.jsp"),
		@Result(name = "addMoney", type="redirect" ,location = "person/moneyManage/myMoneyList.html"),
		@Result(name = "toBalanceCompany",location = "/memberCenter/company/moneyCenter/moneyBalance.jsp"),
		@Result(name = "toBalance",location = "/memberCenter/person/moneyCenter/moneyBalance.jsp")
})
public class MoneyManageAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	private MoneyManageService moneyManageService;
	
	private List<AdvanceLogs> advanceList;
	
	private String moneyType;
	
	private AdvanceLogs advanceLogs;
	
	private String payPassword;
	
	private Double money;
	
	private SessionInfo sessionInfo;
	
	private String yanzhengMobile;
	
	@Resource
	private StatisticsService statisticsService;// 统计信息接口类
	
	@Autowired
	private CompanyMemberService companyMemberService;
	
	@Resource
	private PersonalInfoService personalInfoService;
	
	private StatisticsInfo fundStatisticsInfo;// 资金统计
	
	private String mobileNum;//手机号码
	
	private Integer statusMobile;//手机验证状态
	
	
	 /**
		 * 
		 * 得到所有资金列表
		 * */
	public String gainMoneyList(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Boolean isB=true;
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows((long) 10);// 设置每页显示几条数据Constant.paginationRows
		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		if(moneyType!=null && !moneyType.equals("")){
			if(moneyType.equals("10")){
				isB=false;
			}else{
				map.put("moneyType", moneyType);
			}
		}
		advanceList = moneyManageService.gainMoneyAllList(map);
		pagination.setTotalCount(moneyManageService.gainMoneyAllListCount(map));
		request.setAttribute("pagination", pagination);
		if(isB){
			if(sessionInfo.getUserType().equals("company")){
				return "moneyListCompany";
			}else{
				return "moneyList";
			}
		}else{
			if(sessionInfo.getUserType().equals("company")){
				return "toBalanceCompany";
			}else{
				return "toBalance";
			}
			
		}
	}
	/**
	 * 
	 * 进入充值
	 * */
	public String toRecharge(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo.getUserType().equals("company")){
			return "toRechargeCompany";
		}else{
			return "toRecharge";
		}
	}
	/**
	 * 
	 * 进入取现
	 * */
	public String toWithdraw(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo.getUserType().equals("company")){
			mobileNum = companyMemberService.gainCompanyMessageById(sessionInfo.getUserId()).getLinkmanPhone();
			payPassword = companyMemberService.gainCompanyMessageById(sessionInfo.getUserId()).getPayPassword();
//			statusMobile = companyMemberService.gainCompanyMessageById(sessionInfo.getUserId()).getMobileStatus();
			return "toWithdrawCompany";
		}else{
			mobileNum = personalInfoService.gainMemberById(sessionInfo.getUserId()).getMobile();
			payPassword = personalInfoService.gainMemberById(sessionInfo.getUserId()).getPayPassword();
			statusMobile = personalInfoService.gainMemberById(sessionInfo.getUserId()).getMobileStatus();
			return "toWithdraw";
		}
	}
	/**
	 * 
	 * 添加预付款
	 * */
	public String addMoney(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		advanceLogs.setUserId(sessionInfo.getUserId());
		moneyManageService.addMoney(advanceLogs,sessionInfo);
		return "addMoney";
	}
	/**
	 * 
	 * 验证支付密码
	 * */
	public void payIsTrue(){
	  sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("payPassword", payPassword);
	  map.put("sessionInfo", sessionInfo);
	  Boolean isTrue = moneyManageService.payIsTrue(map);
	  writeJson(isTrue);
	}
	/**
	 * 
	 * 取现时判断金额
	 * */
	public void moneyEnchs(){
		Calendar nowDate=Calendar.getInstance(),
				 oldDate=Calendar.getInstance();
		nowDate.setTime(new Date());
		List<Long> timeOld = new ArrayList<Long>();//初始值
		timeOld.add(0l);
		Boolean timeB=false;
		long timeNow=nowDate.getTimeInMillis();
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("userId", sessionInfo.getUserId());
		 map.put("verificationCode", yanzhengMobile);
		 map.put("toMobile", mobileNum);
		List<MobileMessage> mm = moneyManageService.gainMobileByUserId(map);
		if(null!=mm){
			for(int i=0;i<mm.size();i++){
				oldDate.setTime(mm.get(i).getCreatetime());
				timeOld.add(oldDate.getTimeInMillis());
			}
		}
			for(int i=0;i<timeOld.size();i++){
				long  num = (timeNow-timeOld.get(i))/(1000);//化为秒
				if(num<MobileMessageContant.timeRange){
					timeB=true;
				}
			}
		 
//		String pas=(String) session.get("quxianPass");
//		oldDate.setTime((Date)session.get("quxianPass_time"));
		Double advance = moneyManageService.moneyEnchs(sessionInfo);
		if(advance<money){
			map.put("moneyEn", false);
		}else{
			map.put("moneyEn", true);
		}
		if(mm!=null){
			map.put("yanzheng", true);
		}else{
			map.put("yanzheng", false);
		}
		map.put("guoqi", timeB);
		writeJson(map);
	}
	/**
	 * 
	 * 取现
	 * */
	public String enchashment(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		advanceLogs.setUserId(sessionInfo.getUserId());
		moneyManageService.enchashment(advanceLogs,sessionInfo);
		return "addMoney";
	}
	/**
	 * 资金列表右端显示栏
	 * 
	 * */
	public void statisticsMoney(){
		// 资金统计
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
	   fundStatisticsInfo = statisticsService.gainFundStatisticsByTime("0", sessionInfo);
		writeJson(fundStatisticsInfo);
	}
	/**
	 * 短信验证
	 * 
	 * */
	public void  mobileMessage(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Random random = new Random();
		String ran = Integer.toString(random.nextInt(899999)+100000);
//		session.put("quxianPass",ran );
//		session.put("quxianPass_time", new Date());
		Map<String, Object> map = MessageUtil.sendMsg(MobileMessageContant.tixianYanzheng+ran,mobileNum);
		Boolean isTrue = (Boolean) map.get("success");
		if(isTrue){
			MobileMessage mobileMess = new MobileMessage();
			mobileMess.setContent(MobileMessageContant.tixianYanzheng+ran);
			mobileMess.setCreatetime(new Date());
			mobileMess.setId(ToolsUtil.getUUID());
			mobileMess.setMsgId((String)map.get("msgId"));
			mobileMess.setStatus(map.get("success").toString());
			mobileMess.setStatusDescription((String)map.get("result"));
			mobileMess.setToMobile(mobileNum);
			mobileMess.setVerificationCode(ran);
			mobileMess.setUserId(sessionInfo.getUserId());
			mobileMess.setType("1");
			moneyManageService.addMobileMessage(mobileMess);
		}
		writeJson(isTrue);
	}
	
	public List<AdvanceLogs> getAdvanceList() {
		return advanceList;
	}
	public void setAdvanceList(List<AdvanceLogs> advanceList) {
		this.advanceList = advanceList;
	}
	public String getMoneyType() {
		return moneyType;
	}
	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}
	public AdvanceLogs getAdvanceLogs() {
		return advanceLogs;
	}
	public void setAdvanceLogs(AdvanceLogs advanceLogs) {
		this.advanceLogs = advanceLogs;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public StatisticsInfo getFundStatisticsInfo() {
		return fundStatisticsInfo;
	}
	public void setFundStatisticsInfo(StatisticsInfo fundStatisticsInfo) {
		this.fundStatisticsInfo = fundStatisticsInfo;
	}
	public String getYanzhengMobile() {
		return yanzhengMobile;
	}
	public void setYanzhengMobile(String yanzhengMobile) {
		this.yanzhengMobile = yanzhengMobile;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public Integer getStatusMobile() {
		return statusMobile;
	}
	public void setStatusMobile(Integer statusMobile) {
		this.statusMobile = statusMobile;
	}
	
}
