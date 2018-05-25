/**
 * @Title: PersonalInfoAction.java
 * @Package com.qlzy.memberCenter.shop.action
 * @Description: (个人信息管理)
 * @author wangmei
 * @date 2013-9-17 下午1:53:48 
 * @version V1.0
 */
package com.qlzy.memberCenter.person.perinfo.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.aliyuncs.exceptions.ClientException;
import com.qlzy.common.tools.*;
import com.qlzy.common.util.PcOrWap;
import com.qlzy.mainPage.indexGoods.service.DictionaryService;
import com.qlzy.model.*;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.memberCenter.common.service.QuestionService;
import com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService;
import com.qlzy.memberCenter.order.service.OrderService;
import com.qlzy.memberCenter.person.perinfo.service.PersonalInfoService;
import com.qlzy.pojo.Json;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Constant;
import com.qlzy.util.Pagination;

@Namespace("/person")
@Action(value = "personalInfo", results = {
		@Result(name = "toShowBasicInfo", location = "/memberCenter/person/personalInfo/basicInfo.jsp"),
		@Result(name = "toShowBasicInfoWap", location = "/wap/person/basicInfo.jsp"),
		@Result(name = "toBianjiWap", location = "/wap/person/bianjiziliao.jsp"),
		@Result(name = "toZhanghuguanliWap", location = "/wap/person/zhanghuguanli.jsp"),
		@Result(name = "toShowFirstnameWap", location = "/wap/person/firstname.jsp"),
		@Result(name = "toShowFirstname", location = "/memberCenter/person/personalInfo/firstname.jsp"),
		@Result(name = "toShowMobile", location = "/memberCenter/person/personalInfo/mobile.jsp"),
		@Result(name = "toShowMobileWap", location = "/wap/person/mobile.jsp"),
		@Result(name = "toShowImg", location = "/memberCenter/person/personalInfo/image.jsp"),
		@Result(name = "toShowImgWap", location = "/wap/person/image.jsp"),
		@Result(name = "toShowPassword", location = "/memberCenter/person/personalInfo/password.jsp"),
		@Result(name = "toShowPasswordWap", location = "/wap/person/changePassword.jsp"),
		@Result(name = "myYiji", location = "/memberCenter/person/personalInfo/myYiji.jsp"),
		@Result(name = "myErji", location = "/memberCenter/person/personalInfo/myErji.jsp"),
		@Result(name = "mySanji", location = "/memberCenter/person/personalInfo/mySanji.jsp"),
		@Result(name = "xianjinbi", location = "/memberCenter/person/personalInfo/xianjinbi.jsp"),
		@Result(name = "xianjinbiCash", location = "/memberCenter/person/personalInfo/xianjinbiCash.jsp"),
		@Result(name = "liucunbi", location = "/memberCenter/person/personalInfo/liucunbi.jsp"),
		@Result(name = "toShowAccountSecurity", location = "/memberCenter/person/personalInfo/accountSecurity.jsp"),
		@Result(name = "purchaseHistory", location = "/memberCenter/person/personalInfo/purchaseHistory.jsp"),
		@Result(name = "toFenxiaoCenter", location = "/memberCenter/person/personalInfo/fenxiaoCenter.jsp"),
		@Result(name = "toFenxiaoCenterWap", location = "/wap/person/fenxiaoCenter.jsp"),
		@Result(name = "toFenxiaoshang", location = "/memberCenter/person/personalInfo/fenxiaoshang.jsp"),
		@Result(name = "toFenxiaoshangWap", location = "/wap/person/fenxiaoshang.jsp"),
		@Result(name = "toFensituan", location = "/memberCenter/person/personalInfo/fensituan.jsp"),
		@Result(name = "toFensituanWap", location = "/wap/person/fensituan.jsp"),
		@Result(name = "toTixianjilu", location = "/memberCenter/person/personalInfo/tixianjilu.jsp"),
		@Result(name = "toTixianjiluWap", location = "/wap/person/tixianjilu.jsp"),
		@Result(name = "toYujiticheng", location = "/memberCenter/person/personalInfo/yujiticheng.jsp"),
		@Result(name = "toYujitichengWap", location = "/wap/person/yujiticheng.jsp"),
		@Result(name = "toXiaxianticheng", location = "/memberCenter/person/personalInfo/xiaxianticheng.jsp"),
		@Result(name = "toXiaxiantichengWap", location = "/wap/person/xiaxianticheng.jsp"),
		@Result(name = "toXiaoshouticheng", location = "/memberCenter/person/personalInfo/xiaoshouticheng.jsp"),
		@Result(name = "toXiaxiantichengTongji", location = "/memberCenter/person/personalInfo/xiaxiantichengTongji.jsp"),
		@Result(name = "toXiaxiantichengTongjiWap", location = "/wap/person/xiaxiantichengTongji.jsp"),
		@Result(name = "toXiaoshoutichengTongji", location = "/memberCenter/person/personalInfo/xiaoshoutichengTongji.jsp")
})
public class PersonalInfoAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private PersonalInfoService personalInfoService;
	//	@Resource
//	private RegionsService regionsService;// 地区接口类
	@Resource
	private QuestionService questionService;// 安全保护问题接口类
	@Resource
	private CompanyInfoService companyInfoService;
	@Resource
	private DictionaryService dictionaryService;
	@Resource
	private OrderService orderService;

	private Member member;// 个人会员实体类
	private List<Member> memberList;// 个人会员实体类
	private Company company;// 企业会员实体类

	private List<XianjinbiDetail> xianjinbiList;
	private List<XianjinbiCashApply> xianjinbiCashList;

	private List<LiucunbiDetail> liucunbiList;
	private List<MemberJob> memberJobs;// 从事领域列表
	private List<Regions> provinceList;// 省份列表
	private List<Regions> cityList;// 市列表
	private List<Regions> areaList;// 区列表
	private List<Question> questions;// 安全保护问题列表

	private List<Order> orderList = new ArrayList<Order>();
	private List<AdvanceLogs> advanceLogsList = new ArrayList<AdvanceLogs>();
	private String telCode;// 手机验证码
	private String telNum;//手机号码

	private Double maxPoint;

	private String username;
	private String shenfenzheng;
	private Double guliangbi;
	private Double jifen;

	private String areaSize;

	private String dhtype;
	private Double dhcount;

	private String zhuanpanId;
	private String personId;

	private Integer level;

	private String mobile;
	private String randNum;
	private String codeType;
	Logger log = Logger.getLogger(this.getClass());
	/**
	 * @Title: toShowBasicInfo
	 * @Description: (显示修改基本信息页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 * @author wangmei
	 */
	public String toShowBasicInfo(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}
		// 会员信息
		member = personalInfoService.gainMemberById(sessionInfo.getUserId());
//		if(null != member){
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("member",member);
//		}
		request.setAttribute("member",member);
		return  PcOrWap.isPc(request,"toShowBasicInfo");
	}

	/**
	 * wap编辑个人资料页面
	 */
	public String toBianji(){
		toShowBasicInfo();
		return PcOrWap.isPc(request,"toBianji");
	}
	/**
	 * wap账户管理
	 * @return
	 */
	public String toZhanghuguanli(){
		toShowBasicInfo();
		return  PcOrWap.isPc(request,"toZhanghuguanli");
	}

	/**
	 * 显示修改昵称页面
	 * @return
	 */
	public String toShowFirstname(){
		toShowBasicInfo();
		return  PcOrWap.isPc(request,"toShowFirstname");
	}
	/**
	 * 显示修改用户名页面
	 * @return
	 */
	public String toShowUsername() {
		toShowBasicInfo();
		return "toShowUsername";
	}

	/* 跳转分销中心页面 */
	public String toFenxiaoCenter(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}
		// 会员信息
		member = personalInfoService.gainMemberById(sessionInfo.getUserId());
		member.setYijiticheng(personalInfoService.gainFirstByUserId(member.getOnlyId()));
		member.setErjiticheng(personalInfoService.gainSecondByUserId(member.getOnlyId()));

		request.setAttribute("member",member);
		return  PcOrWap.isPc(request,"toFenxiaoCenter");
	}

	/* 跳转分销中心--分销商页面 */
	public String toFenxiaoshang(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}
		// 会员信息
		String dengji = request.getParameter("dengji");
		member = personalInfoService.gainMemberById(sessionInfo.getUserId());
		request.setAttribute("member",member);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("onlyId",member.getOnlyId());
		map.put("dengji",dengji);
		String value = request.getParameter("value");
		map.put("value",value);
		memberList = personalInfoService.gainMembersByMap(map);
		List<Member> memberListNew = new ArrayList<Member>();
		for(Member m : memberList){
			if(!("0").equals(m.getType())){
				MemberLv memberLv = personalInfoService.gainMemberLvById(m.getType());
				m.setMemberLvName(memberLv.getName());
				memberListNew.add(m);
			}
		}
		map.put("time",1);
		long today = personalInfoService.gainMemberCountByMap(map);
		map.put("time",2);
		long yesToday = personalInfoService.gainMemberCountByMap(map);
		map.put("time",3);
		long week = personalInfoService.gainMemberCountByMap(map);
		map.put("time",4);
		long month = personalInfoService.gainMemberCountByMap(map);
		map.put("time",5);
		long total = personalInfoService.gainMemberCountByMap(map);
		request.setAttribute("dengji",dengji);
		request.setAttribute("today",today);
		request.setAttribute("yesToday",yesToday);
		request.setAttribute("week",week);
		request.setAttribute("month",month);
		request.setAttribute("total",total);
		request.setAttribute("memberListNew",memberListNew);
		return  PcOrWap.isPc(request,"toFenxiaoshang");
	}




	/* 跳转分销中心--粉丝团页面 */
	public String toFensituan(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}
		// 会员信息
		String dengji = "";
		member = personalInfoService.gainMemberById(sessionInfo.getUserId());
		request.setAttribute("member",member);
		member = personalInfoService.gainMemberById(sessionInfo.getUserId());
		request.setAttribute("member",member);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("onlyId",member.getOnlyId());
		map.put("dengji",dengji);
		memberList = personalInfoService.gainMembersByMap(map);
		List<Member> memberListNew = new ArrayList<Member>();
		for(Member m : memberList){
			if(("0").equals(m.getType())){
				memberListNew.add(m);
			}
		}
		request.setAttribute("memberListNew",memberListNew);
		return  PcOrWap.isPc(request,"toFensituan");
	}

	/* 跳转分销中心--提现记录页面 */
	public String toTixianjilu(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}

		// 会员信息
		member = personalInfoService.gainMemberById(sessionInfo.getUserId());
		request.setAttribute("member",member);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId",member.getId());
		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(8L);
		map.put("page", (pagination.getPage()-1)* pagination.getRows());
		map.put("rows", pagination.getRows());
		List<XianjinbiCashApply> xianjinList = personalInfoService.xianjinbiCashList(map);
		QlDict qlDict = dictionaryService.gainByType("tixian_fee");
		String fee = qlDict.getValue();
		request.setAttribute("fee",fee);
		request.setAttribute("xianjinList",xianjinList);
		return  PcOrWap.isPc(request,"toTixianjilu");
	}

	/* 跳转分销中心--预计提成页面 */
	public String toYujiticheng(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		//sessionInfo.setToUrl("personalInfo/yujiticheng/(.*).html");
		if(null == sessionInfo){
			return "login_hf";
		}
		// 会员信息
		member = personalInfoService.gainMemberById(sessionInfo.getUserId());

		String dengji = request.getParameter("dengji");
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("onlyId",member.getOnlyId());
		paraMap.put("onlyType",dengji);

		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(6L);
		paraMap.put("page", (pagination.getPage()-1)* pagination.getRows());
		paraMap.put("rows", pagination.getRows());

		List<Order> orderList = orderService.gainYujitichengList(paraMap);
		pagination.setTotalCount(100L);
		request.setAttribute("dengji",dengji);
		request.setAttribute("orderList",orderList);
		request.setAttribute("member",member);
		request.setAttribute("pagination",pagination);
		return  PcOrWap.isPc(request,"toYujiticheng");
	}

	/* 跳转分销中心--下线提成页面 */
	public String toXiaxianticheng(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}
		request.setAttribute("sessionInfo",sessionInfo);
		// 会员信息
		String dengji = request.getParameter("dengji");
		member = personalInfoService.gainMemberById(sessionInfo.getUserId());
		request.setAttribute("member",member);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("onlyId",member.getOnlyId());
		map.put("dengji",dengji);
		Pagination pagination = definationPagination(request);
		pagination.setTotalCount(personalInfoService.gainCountByMap(map));
		// 设置每页显示几条数据
		pagination.setRows(8L);
		map.put("page", (pagination.getPage()-1)* pagination.getRows());
		map.put("rows", pagination.getRows());
		List<Member> memberList = personalInfoService.gainListByMap(map);
		for(Member m : memberList){
			map.put("id",m.getId());
			AdvanceLogs advanceLogs = personalInfoService.gainByUserId(map);
			m.setTotal(advanceLogs.getTotalMoney());
			m.setCount(advanceLogs.getNum());
			m.setTicheng(advanceLogs.getTicheng());
		}
		request.setAttribute("pagination",pagination);
		request.setAttribute("memberList",memberList);
		request.setAttribute("dengji",dengji);
		return  PcOrWap.isPc(request,"toXiaxianticheng");
	}



	/* 跳转分销中心--下线提成--本月统计页面 */
	public String toXiaxiantichengTongji(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}
		request.setAttribute("sessionInfo",sessionInfo);
		String memberId = request.getParameter("memberId");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId",memberId);
		String time = request.getParameter("time");
		member = personalInfoService.gainMemberById(memberId);
		map.put("id",member.getId());
		map.put("time",time);
		AdvanceLogs advanceLogs = personalInfoService.gainByUserId(map);
		member.setTotal(advanceLogs.getTotalMoney());
		member.setCount(advanceLogs.getNum());
		member.setTicheng(advanceLogs.getTicheng());
		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(8L);
		map.put("page", (pagination.getPage()-1)* pagination.getRows());
		map.put("rows", pagination.getRows());
		pagination.setTotalCount(advanceLogs.getNum());
		request.setAttribute("pagination",pagination);
		advanceLogsList = personalInfoService.gainByUserIdGetList(map);
		request.setAttribute("time",time);
		request.setAttribute("member",member);
		request.setAttribute("advanceLogsList",advanceLogsList);
		return  PcOrWap.isPc(request,"toXiaxiantichengTongji");
	}




	public String myYiji(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}
		// 会员信息
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows

		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		memberList = personalInfoService.myYiji(map);
		pagination.setTotalCount(personalInfoService.myYijiCount(map));
		request.setAttribute("pagination", pagination);
		return "myYiji";
	}
	public String myErji(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}
		// 会员信息
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows

		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		memberList = personalInfoService.myErji(map);
		pagination.setTotalCount(personalInfoService.myErjiCount(map));
		request.setAttribute("pagination", pagination);
		return "myErji";
	}
	public String mySanji(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}

		// 会员信息
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows

		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		memberList = personalInfoService.mySanji(map);
		pagination.setTotalCount(personalInfoService.mySanjiCount(map));
		request.setAttribute("pagination", pagination);
		return "mySanji";

	}

	/**
	 * 显示修改头像页面
	 * @return
	 */
	public String toShowImg() {
		toShowBasicInfo();
		return  PcOrWap.isPc(request,"toShowImg");
	}

//	*
//	 * 修改昵称
//
//	public void updateFirstname(){
//		String result = "";
//		member = new Member();
//		member.setFirstname(request.getParameter("firstname"));
//		int num = personalInfoService.updatePersonInfo(member);
//		if (num > 0) {
//			result = "success";
//		}
//		super.writeJson(result);
//	}

	/**
	 * 修改头像
	 */
	public void updateImg(){
		String result = "";
		member = new Member();
		member.setId(request.getParameter("id"));
		member.setImg(request.getParameter("img"));
		int num = personalInfoService.updatePersonInfo(member);
		if (num > 0) {
			result = "success";
		}
		super.writeJson(result);
	}

	/**
	 * 显示修改登录手机号页面
	 * @return
	 */
	public String toShowMobile() {
		toShowBasicInfo();
		return  PcOrWap.isPc(request,"toShowMobile");
	}

	/**
	 * 显示修改登录密码页面
	 * @return
	 */
	public String toShowPassword() {
		toShowBasicInfo();
		return  PcOrWap.isPc(request,"toShowPassword");
	}



//	public String myYiji(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		if(null == sessionInfo){
//			return "login_hf";
//		}
//		// 会员信息
//		Map<String, Object> map = new HashMap<String, Object>();
//		Pagination pagination = definationPagination(request);
//		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
//
//		map.put("page", (pagination.getPage()-1)*pagination.getRows());
//		map.put("rows", pagination.getRows());
//		map.put("userId", sessionInfo.getUserId());
//		memberList = personalInfoService.myYiji(map);
//		pagination.setTotalCount(personalInfoService.myYijiCount(map));
//		request.setAttribute("pagination", pagination);
//		return "myYiji";
//	}
//	public String myErji(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		if(null == sessionInfo){
//			return "login_hf";
//		}
//		// 会员信息
//		Map<String, Object> map = new HashMap<String, Object>();
//		Pagination pagination = definationPagination(request);
//		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
//
//		map.put("page", (pagination.getPage()-1)*pagination.getRows());
//		map.put("rows", pagination.getRows());
//		map.put("userId", sessionInfo.getUserId());
//		memberList = personalInfoService.myErji(map);
//		pagination.setTotalCount(personalInfoService.myErjiCount(map));
//		request.setAttribute("pagination", pagination);
//		return "myErji";
//	}
//	public String mySanji(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		if(null == sessionInfo){
//			return "login_hf";
//		}
//
//		// 会员信息
//		Map<String, Object> map = new HashMap<String, Object>();
//		Pagination pagination = definationPagination(request);
//		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
//
//		map.put("page", (pagination.getPage()-1)*pagination.getRows());
//		map.put("rows", pagination.getRows());
//		map.put("userId", sessionInfo.getUserId());
//		memberList = personalInfoService.mySanji(map);
//		pagination.setTotalCount(personalInfoService.mySanjiCount(map));
//		request.setAttribute("pagination", pagination);
//		return "mySanji";
//	}
//
//
//	public String xianjinbi(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		if(null == sessionInfo){
//			return "login_hf";
//		}
//
//		// 会员信息
//		Map<String, Object> map = new HashMap<String, Object>();
//		Pagination pagination = definationPagination(request);
//		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
//
//		map.put("page", (pagination.getPage()-1)*pagination.getRows());
//		map.put("rows", pagination.getRows());
//		map.put("userId", sessionInfo.getUserId());
//		xianjinbiList = personalInfoService.xianjinbi(map);
//		pagination.setTotalCount(personalInfoService.xianjinbiCount(map));
//		request.setAttribute("pagination", pagination);
//		return "xianjinbi";
//	}
//
//	public String xianjinbiCash(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
//		if(null == sessionInfo){
//			return "login_hf";
//		}
//
//		// 会员信息
//		Map<String, Object> map = new HashMap<String, Object>();
//		Pagination pagination = definationPagination(request);
//		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
//
//		map.put("page", (pagination.getPage()-1)*pagination.getRows());
//		map.put("rows", pagination.getRows());
//		map.put("userId", sessionInfo.getUserId());
//		xianjinbiCashList = personalInfoService.xianjinbiCashList(map);
//		pagination.setTotalCount(personalInfoService.xianjinbiCashCount(map));
//		request.setAttribute("pagination", pagination);
//		return "xianjinbiCash";
//	}
//
//	public String liucunbi(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		if(null == sessionInfo){
//			return "login_hf";
//		}
//
//		// 会员信息
//		Map<String, Object> map = new HashMap<String, Object>();
//		Pagination pagination = definationPagination(request);
//		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
//
//		map.put("page", (pagination.getPage()-1)*pagination.getRows());
//		map.put("rows", pagination.getRows());
//		map.put("userId", sessionInfo.getUserId());
//		liucunbiList = personalInfoService.liucunbi(map);
//		pagination.setTotalCount(personalInfoService.liucunbiCount(map));
//		request.setAttribute("pagination", pagination);
//		return "liucunbi";
//	}
//

	/***
	 * 发送验证码 随后再加记录日志 有短信后再放开
	 */
	public void sendNewCode(){
		String result = "000";
		username = request.getParameter("username");
		if(null != username && !"".equals(username)){
			randNum = CodeUtils.createRandom(true, 6);
			System.out.println(randNum);
			try {
				boolean ss = Sms.Send(username, randNum, codeType);
				if (ss) {
					result = "000";
					// 发送校验码记录日志
					personalInfoService.sendMobileCode(username,
							randNum,  request.getParameter("type"));
				}
			} catch (ClientException e) {
				log.info(e.getMessage());
				e.printStackTrace();
				result = "001";
			}
		}else{
			result = "001";
		}
		super.writeJson(result);
	}

	/**
	 * 登录电话修改
	 */
	public void updateMobile() {
		String result = "";
		String id = request.getParameter("member.id");
		member = personalInfoService.gainMemberById(id);
		String pwd = member.getPassword();
		String password = MD5.encrypt(request.getParameter("password"));
		int a = 0;
		if (pwd.equals(password)) {
			String username = request.getParameter("username");
			String code = request.getParameter("randNum");
			List<Member> listMember = personalInfoService.selectByMemberUsername(username);
			List<MobileMessage> mobileMessages = personalInfoService
					.gainMobileMessagesByMap(username, code);
			if (listMember.size() == 0) {
				if (mobileMessages != null && mobileMessages.size() > 0) {
					for (MobileMessage ms : mobileMessages) {
						boolean flag = ToolsUtil.isCheckExpires(ms.getCreatetime(),
								Long.parseLong(ResourceUtil.getValidTime("1")));
						if (!flag) {
							a++;
						}
					}
					if (a != mobileMessages.size()) {
						member.setUsername(username);
						personalInfoService.updatePersonInfo(member);
						result = "success";
					}
				}
			}
		}
		super.writeJson(result);
	}


	/**
	 * 登录密码修改
	 */
	public void updatePassword() {
		String result = "";
		int a = 0;
		String username = request.getParameter("username");
		String code = request.getParameter("randNum");
		List<MobileMessage> mobileMessages = personalInfoService
				.gainMobileMessagesByMap(username, code);
		if (mobileMessages != null && mobileMessages.size() > 0) {
			for (MobileMessage ms : mobileMessages) {
				boolean flag = ToolsUtil.isCheckExpires(ms.getCreatetime(),
						Long.parseLong(ResourceUtil.getValidTime("1")));
				if (!flag) {
					a++;
				}
			}
			if (a != mobileMessages.size()) {
				String password = request.getParameter("newPassword");
				String pwd = MD5.encrypt(password);
				member.setPassword(pwd);
				personalInfoService.updatePersonInfo(member);
				result = "success";
			}
		}
		super.writeJson(result);
	}

	/**
	 * @Title: updateBasicInfo
	 * @Description: (个人基本信息修改)
	 * @return void    返回类型
	 * @throws
	 * @author wangmei
	 */
	public void updateBasicInfo(){
		String result = "";
		member.setId(request.getParameter("member.id"));
		member.setTruename(request.getParameter("member.truename"));
		member.setFirstname(request.getParameter("member.firstname"));
		member.setCard(request.getParameter("member.card"));
		member.setCardFront(request.getParameter("member.cardFront"));
		member.setCardReverse(request.getParameter("member.cardReverse"));
		member.setGender(request.getParameter("member.gender"));
		member.setAge(String.valueOf(request.getParameter("member.age")));
		member.setBirthday(request.getParameter("member.birthday"));
		member.setQq(request.getParameter("member.qq"));
		member.setEmail(request.getParameter("member.email"));
		member.setWeiXin(request.getParameter("member.weiXin"));
		member.setArea(request.getParameter("member.area"));
		int num = personalInfoService.updatePersonInfo(member);
		if (num > 0) {
			result = "success";
		}
		super.writeJson(result);
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		Map<String, Object> map = new HashMap<String, Object>();
//		try{
//			Member meInfo = new Member();
//			meInfo.setId(member.getId());
//			meInfo.setLastname(member.getLastname());
//			meInfo.setFirstname(member.getFirstname());
//			meInfo.setGender(member.getGender());
//			meInfo.setAge(member.getAge());
//			meInfo.setCard(member.getCard());
//			meInfo.setAddress(member.getAddress());
//			meInfo.setEmail(member.getEmail());
//
//			meInfo.setTruename(member.getTruename());
//			meInfo.setProvince(member.getProvince());
//			meInfo.setCity(member.getCity());
//			meInfo.setArea(member.getArea());
//			meInfo.setVocation(member.getVocation());
//			meInfo.setInterest(member.getInterest());
//
//			personalInfoService.updatePersonInfo(meInfo);
//			map.put("res", "succ");
//			map.put("msg", "基本信息修改成功！");
//
//		} catch (Exception e) {
//			map.put("res", "fail");
//			map.put("msg", "基本信息修改失败！");
//			logger.error("updateBasicInfo", e);
//			e.printStackTrace();
//		}
//		writeJson(map);
 	}

	public void getPoint(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		// 会员信息
		member = personalInfoService.gainMemberById(sessionInfo.getUserId());
		super.writeJson(member);
	}
//	/**
//	 * @Title: updateBasicInfo
//	 * @Description: (个人基本信息修改)
//	 * @param     设定文件
//	 * @return void    返回类型
//	 * @throws
//	 * @author wangmei
//	 */
//	public void zhuanzhang(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("username", username);
//		map.put("shenfenzheng", shenfenzheng);
//		map.put("guliangbi", guliangbi);
//		map.put("jifen", jifen);
//		map.put("username2", sessionInfo.getUserName());
//		map.put("userId2", sessionInfo.getUserId());
//		if( guliangbi==null){
//			guliangbi=0D;
//		}
//		if( jifen==null){
//			jifen=0D;
//		}
//		try{
//		member = personalInfoService.gainMemberByUsername(username);
//		Member member2 = personalInfoService.gainMemberById(sessionInfo.getUserId());
//		if(!member.getOnlyId().equals(shenfenzheng)){
//			map.put("res", "expiry");
//			map.put("msg", "请核实用户名和会员编号！");
//		}else if(member.getId().equals(member2.getId())){
//			map.put("res", "fail");
//			map.put("msg", "您不能给自己转账！");
//		}else{
//			map.put("member", member);
//			if(member2.getAdvance()<guliangbi){
//				map.put("res", "fail");
//				map.put("msg", "您输入粮票金额大于自身持有的粮票！");
//			}else if(member2.getPoint()<jifen){
//				map.put("res", "fail");
//				map.put("msg", "您输入的经验值金额大于自身持有的经验值！");
//			}else{
//			personalInfoService.zhuanzhang(map);
//			map.put("res", "succ");
//			map.put("msg", "转账成功！");
//			}
//		}
//		} catch (Exception e) {
//			map.put("res", "fail");
//			map.put("msg", "转账失败！");
//			logger.error("zhuanzhang", e);
//			e.printStackTrace();
//		}
//		writeJson(map);
//	}
//	public void shengjivip(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		Map<String, Object> map = new HashMap<String, Object>();
//		try{
//		member = personalInfoService.shengjivip(sessionInfo.getUserId(),998D);
//			map.put("msg", member.getEngageindustryname());
//			map.put("success", true);
//		} catch (Exception e) {
//			map.put("success", false);
//			e.printStackTrace();
//		}
//		writeJson(map);
//	}

//	/**
//	 * 金米兑米操作
//	 *
//	 */
//	public void tixian(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
//		Map<String, Object> map = new HashMap<String, Object>();
//		try{
//		    member = personalInfoService.tixian(sessionInfo.getUserId(), maxPoint);
//			map.put("msg", member.getEngageindustryname());
//			map.put("success", true);
//		} catch (Exception e) {
//			map.put("success", false);
//			e.printStackTrace();
//		}
//		writeJson(map);
//	}
//
//	public void duihuan(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		Map<String, Object> map = new HashMap<String, Object>();
//		try{
//		 personalInfoService.duihuan(sessionInfo.getUserId(),dhcount,dhtype);
//
//			map.put("success", true);
//
//		} catch (Exception e) {
//			map.put("success", false);
//			e.printStackTrace();
//		}
//		writeJson(map);
//	}
//
//	/**
//	 * @Title: updateMobile
//	 * @Description: (手机号码修改)
//	 * @param     设定文件
//	 * @return void 返回类型
//	 * @author wangmei
//	 */
//	public void updateMobile1(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());// 获取登录人信息
//		String mobileNum = request.getParameter("mobileNum");// 获取手机号码
//		String mobileCode = request.getParameter("mobileCode");// 获取校验码
//		Map<String, Object> map = new HashMap<String, Object>();
//		member = new Member();
//		company =new Company();
//		int a = 0;
//		try {
//			List<MobileMessage> mobileMessages = personalInfoService
//					.gainMobileMessagesByMap(mobileNum, mobileCode);
//			if (mobileMessages != null && mobileMessages.size() > 0) {
//				for (MobileMessage ms : mobileMessages) {
//					boolean flag = ToolsUtil.isCheckExpires(ms.getCreatetime(),
//							Long.parseLong(ResourceUtil.getValidTime("1")));
//					if (!flag) {
//						a++;
//					}
//				}
//				if (a == mobileMessages.size()) {
//					map.put("res", "expiry");
//					map.put("msg", "您输入的校验码已过期！");
//				} else {
//					if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){
//						member.setId(sessionInfo.getUserId());
//						member.setMobile(mobileNum);
//						member.setMobileStatus(1);
//						personalInfoService.updatePersonInfo(member);
//					}else{
//						company.setId(sessionInfo.getUserId());
//						company.setLinkmanPhone(mobileNum);
//						company.setMobileStatus(new BigDecimal(1));
//						companyInfoService.updateComInfo(company);
//					}
//					map.put("res", "succ");
//					map.put("msg", "手机号码修改成功!");
//					map.put("userType",sessionInfo.getUserType());
//				}
//			} else {
//				// 企业用户更换手机号码，在没有点击获取验证码的情况下，输入永久验证码也即正确
//				if(Constant.USERTYPE_COMPANY.equals(sessionInfo.getUserType())){// 企业
//					if(mobileCode.equals(ResourceUtil.getForeverValidatecode())){
//						company.setId(sessionInfo.getUserId());
//						company.setLinkmanPhone(mobileNum);
//						company.setMobileStatus(new BigDecimal(1));
//						companyInfoService.updateComInfo(company);
//						map.put("res", "succ");
//						map.put("msg", "手机号码修改成功!");
//						map.put("userType",sessionInfo.getUserType());
//					}else{
//						map.put("res", "error");
//						map.put("msg", "您输入的校验码不正确！");
//					}
//				}else{// 个人
//					map.put("res", "error");
//					map.put("msg", "您输入的校验码不正确！");
//				}
//			}
//		} catch (Exception e) {
//			map.put("res", "fail");
//			logger.error("手机号码修改失败！", e);
//			e.printStackTrace();
//		}
//		writeJson(map);
//	}

	/**
	 * @Title: isBindMobile
	 * @Description: (检验手机号码是否已绑定)
	 * @param
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void isBindMobile(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());// 获取登录人信息
		Map<String, Object> map = new HashMap<String, Object>();
		if(null == sessionInfo){
			map.put("res", "sessionexpiry");
			map.put("msg", "页面已过期，请重新登录！");
		}else{
			String mobileNum = request.getParameter("mobileNum");// 获取手机号码
			if(null == mobileNum){
				map.put("res", "isBind");
				map.put("msg", "手机号不能为空");
			}else{
				List<Member> membersList = personalInfoService.selectMemberByMobile(mobileNum);
				if (membersList != null && membersList.size() > 0) {
					map.put("res", "isBind");
					map.put("msg", "此手机号码已在系统中被使用，请更换其他手机号码！");
				}else{
					map.put("res", "succ");
				}
			}
		}
		writeJson(map);
	}

	/**
	 * @Title: updateDetailInfo
	 * @Description: (个人详细信息修改)
	 * @param
	 * @return void    返回类型
	 * @throws
	 * @author wangmei
	 */
	public void updateDetailInfo(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			personalInfoService.updatePersonInfo(member);
			map.put("success", true);
			map.put("msg", "详细信息修改成功！");
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "详细信息修改失败！");
			logger.error("updateBasicInfo", e);
			e.printStackTrace();
		}
		writeJson(map);
	}

	/**
	 * 调用
	 */
//	private List<Regions> gainCityList(String proId) {
//		return regionsService.gainCityListByPid(proId);
//	}
//
//	private List<Regions> gainAreaList(String cityId) {
//		return regionsService.gainAreaListByCityId(cityId);
//	}

	/**
	 * @Title: toShowAccountSecurity
	 * @Description: (跳转账号安全页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 * @author wangmei
	 */
	public String toShowAccountSecurity(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		if(null == sessionInfo){
			return "login_hf";
		}

		// 会员信息
		member = personalInfoService.gainMemberById(sessionInfo.getUserId());

		// 获取安全保护问题
		String question = personalInfoService.gainQuestionByMemberId(member.getId());
		member.setQuestion(question);

		Integer accountSecurityScore = 20;// 密码初始化25分
		if(null!=member){
			if(null != member.getQuestionId() && !"".equals(member.getQuestionId())){
				accountSecurityScore += 20;
			}
			if(null != member.getEmailStatus() && 0!=member.getEmailStatus()){
				accountSecurityScore += 20;
			}
			if(null != member.getMobileStatus() && 0!=member.getMobileStatus()){
				accountSecurityScore += 20;
			}
			if(null != member.getPayPassword() && !"".equals(member.getPayPassword())){
				accountSecurityScore += 20;
			}
		}
		member.setAccountSecurityScore(accountSecurityScore);
		// 安全保护问题列表
		questions = questionService.gainAll();
		return "toShowAccountSecurity";
	}

	/**
	 * @Title: isCorrectByCheckQuestion
	 * @Description: (验证安全保护问题)
	 * @param
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void isCorrectByCheckQuestion(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		String questionAnswer = "";
		String questionAnswer_ = request.getParameter("questionAnswer");// 获取安全问题答案
		if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){
			// 个人会员信息
			questionAnswer = personalInfoService.gainMemberById(sessionInfo.getUserId()).getQuestionAnswer();
		}else{
			// 企业会员信息
			questionAnswer = companyInfoService.gainCompanyById(sessionInfo.getUserId()).getQuestionAnswer();
		}
		try {
			if(!questionAnswer_.equals(questionAnswer)){
				map.put("success", false);
				map.put("msg", "安全保护问题答案不正确！");
			}else{
				map.put("success", true);
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "验证安全保护问题失败！");
			logger.error("验证安全保护问题异常!", e);
		}
		writeJson(map);
	}

	/**
	 * @Title: setUpSecurityProtection
	 * @Description: (设置安全保护问题)
	 * @param
	 * @return void    返回类型
	 * @throws
	 * @author wangmei
	 */
	public void setUpSecurityProtection(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		member = new Member();
		company = new Company();
		try {
			String questionId = request.getParameter("questionId");
			String questionAnswer = request.getParameter("questionAnswer");
			if (Constant.USERTYPE_MEMBER.equals(sessionInfo
					.getUserType())) {// 个人
				member.setId(sessionInfo.getUserId());
				member.setQuestionId(questionId);
				member.setQuestionAnswer(questionAnswer);
				personalInfoService.updatePersonInfo(member);
			} else {// 企业
				company.setId(sessionInfo.getUserId());
				company.setQuestionId(questionId);
				company.setQuestionAnswer(questionAnswer);
				companyInfoService.updateComInfo(company);
			}
			map.put("success", true);
			map.put("msg", "安全保护问题设置成功！");
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "安全保护问题设置失败！");
			logger.error("setUpSecurityProtection", e);
			e.printStackTrace();
		}
		writeJson(map);
	}

	/**
	 * @Title: gainMobile
	 * @Description: (根据登录人ID查询其手机信息)
	 * @param
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void gainMobile(){
		Map<String, Object> map = new HashMap<String, Object>();
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());// 获取登录人信息
		String mobile = "";// 手机号码
		if(null == sessionInfo){
			map.put("res", "sessionexpiry");
			map.put("msg", "页面已过期，请重新登录！");
		}else {
			if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){
				// 会员信息
				member = personalInfoService.gainMemberById(sessionInfo.getUserId());
				if(null != member){
					if(null != member.getMobile() && !"".equals(member.getMobile())){
						mobile = member.getMobile().substring(0,3)+"****"+member.getMobile().substring(7);
					}
				}
			}else{
				// 企业信息
				company = companyInfoService.gainCompanyById(sessionInfo
						.getUserId());
				if(null != company){
					if(null != company.getLinkmanPhone() && !"".equals(company.getLinkmanPhone())){
						mobile = company.getLinkmanPhone().substring(0, 3)+"****"+company.getLinkmanPhone().substring(7);
					}
				}
			}
			map.put("res", "succ");
			map.put("mobile", mobile);
		}
		writeJson(map);
	}

//	/**
//	 * @Title: isCheckMobile
//	 * @Description: (修改密码前验证手机)
//	 * @param     设定文件
//	 * @return void 返回类型
//	 * @author wangmei
//	 */
//	public void isCheckMobile(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		// 获取登录人信息
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
//		String mobile = "";
//		if(null == sessionInfo){
//			map.put("res", "sessionexpiry");
//			map.put("msg", "页面已过期，请重新登录！");
//		}else {
//			if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){
//				// 会员信息
//				member = personalInfoService.gainMemberById(sessionInfo.getUserId());
//				if(null != member){
//					if(null != member.getMobile() && !"".equals(member.getMobile())){
//						mobile = member.getMobile();
//					}else{
//						// 若手机号为空，则通过用户名，并判断用户名是否是手机号
//						String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";
//						Pattern p = Pattern.compile(regExp);
//						Matcher m = p.matcher(member.getUsername());
//						boolean isMobile = m.find();
//						if (isMobile) {
//							mobile = member.getUsername();
//						}
//					}
//				}
//			}else{
//				// 企业信息
//				company = companyInfoService.gainCompanyById(sessionInfo.getUserId());
//				if(null != company){
//					mobile = company.getLinkmanPhone();
//				}
//			}
//		}
//		String mobileCode = request.getParameter("mobileCode");// 获取校验码
//
//		int a = 0;
//		try {
//			List<MobileMessage> mobileMessages = personalInfoService.gainMobileMessagesByMap(mobile, mobileCode, sessionInfo);
//			if (mobileMessages != null && mobileMessages.size() > 0) {
//				for (MobileMessage ms : mobileMessages) {
//					boolean flag = ToolsUtil.isCheckExpires(ms.getCreatetime(),
//							Long.parseLong(ResourceUtil.getValidTime("1")));
//					if (!flag) {
//						a++;
//					}
//				}
//				if (a == mobileMessages.size()) {
//					map.put("res", "expiry");
//					map.put("msg", "您输入的校验码已过期！");
//				} else {
//					map.put("res", "succ");
//					map.put("msg", "您输入的校验码正确!");
//				}
//			} else {
//				// 用户在没有点击获取验证码的情况下，输入永久验证码也即正确
//				if(mobileCode.equals(ResourceUtil.getForeverValidatecode())){
//					map.put("res", "succ");
//					map.put("msg", "您输入的校验码正确!");
//				}else{
//					map.put("res", "error");
//					map.put("msg", "您输入的校验码不正确！");
//				}
//			}
//		} catch (Exception e) {
//			map.put("res", "fail");
//			logger.error("验证手机失败！", e);
//			e.printStackTrace();
//		}
//		writeJson(map);
//	}

//	/**
//	 * @Title: updateLoginPassword
//	 * @Description: (个人登录密码修改)
//	 * @param @return    设定文件
//	 * @return String    返回类型
//	 * @throws
//	 * @author wangmei
//	 */
//	public void updateLoginPassword(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		Map<String, Object> map = new HashMap<String, Object>();
//		//String oldPassword_ = request.getParameter("oldPassword");// 获取原密码
//		String newPassword_ = request.getParameter("newPassword");// 获取新密码
//		String pwd = "";
//		member = new Member();
//		company = new Company();
//		try {
//			/*if(null != oldPassword_ && !"".equals(oldPassword_)){
//				pwd = MD5.encrypt(oldPassword_);
//			}
//			// 验证原密码是否正确
//			boolean flag = personalInfoService.isCorrectCheckPassword(sessionInfo, pwd,"1");
//			if(!flag){
//				map.put("res", "pwdErr");
//				map.put("msg", "原密码输入不正确！");
//				writeJson(map);
//				return;
//			}else{*/
//				if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){// 个人
//					if(null != newPassword_ && !"".equals(newPassword_)){
//						pwd = MD5.encrypt(newPassword_);
//						member.setId(sessionInfo.getUserId());
//						member.setPassword(pwd);
//					}
//					personalInfoService.updatePersonInfo(member);
//				}else{
//					if(null != newPassword_ && !"".equals(newPassword_)){// 企业
//						pwd = MD5.encrypt(newPassword_);
//						company.setId(sessionInfo.getUserId());
//						company.setPassword(pwd);
//					}
//					companyInfoService.updateComInfo(company);
//				}
//				map.put("res", "succ");
//				map.put("msg", "登录密码修改成功！");
//			//}
//		} catch (Exception e) {
//			map.put("res", "fail");
//			map.put("msg", "登录密码修改失败！");
//			logger.error("person-updateLoginPassword", e);
//			e.printStackTrace();
//		}
//		writeJson(map);
//	}

	/**
	 * @Title: updatePayPassword
	 * @Description: (设置支付密码)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 * @author wangmei
	 */
//	public void updatePayPassword(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
//		Map<String, Object> map = new HashMap<String, Object>();
//		member = new Member();
//		company = new Company();
//		//String oldPayPassword_ = request.getParameter("oldPayPassword");// 获取原支付密码
//		String newPayPassword_ = String.valueOf(request.getParameter("newPayPassword"));// 获取新支付密码
//		String payPassword_ = request.getParameter("payPassword");// 获取支付密码
//		payPassword_ = MD5.encrypt(payPassword_);
//		String type = String.valueOf(request.getParameter("type"));
//		String pwd = "";
//		try {
//				if("setUp".equals(type)){
//					if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){
//						member.setId(sessionInfo.getUserId());
//						member.setPayPassword(payPassword_);
//						personalInfoService.updatePersonInfo(member);
//					}else{
//						company.setId(sessionInfo.getUserId());
//						company.setPayPassword(payPassword_);
//						companyInfoService.updateComInfo(company);
//					}
//					map.put("res", "succ");
//					map.put("msg", "支付密码设置成功！");
//				}else{
//					/*if(null != oldPayPassword_ && !"".equals(oldPayPassword_)){
//						pwd = MD5.encrypt(oldPayPassword_);
//					}
//					// 验证支付密码是否正确
//					boolean flag = personalInfoService.isCorrectCheckPassword(sessionInfo, pwd,"2");
//					if(!flag){
//						map.put("res", "pwdErr");
//						map.put("msg", "旧安全密码输入不正确！");
//						writeJson(map);
//						return;
//					}else{*/
//						if(null != newPayPassword_ && !"".equals(newPayPassword_)){
//							pwd = MD5.encrypt(newPayPassword_);
//						}
//						if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){
//							member.setId(sessionInfo.getUserId());
//							member.setPayPassword(pwd);
//							personalInfoService.updatePersonInfo(member);
//						}else {
//							company.setId(sessionInfo.getUserId());
//							company.setPayPassword(pwd);
//							companyInfoService.updateComInfo(company);
//						}
//						map.put("res", "succ");
//						map.put("msg", "支付密码修改成功！");
//					//}
//				}
//		} catch (Exception e) {
//			map.put("res", "fail");
//			map.put("msg", "支付密码设置失败！");
//			logger.error("person-updatePayPassword", e);
//			e.printStackTrace();
//		}
//		writeJson(map);
//	}

	/**
	 * @Title: PersonalInfoAction.java
	 * @Description: (发送邮箱校验码)
	 * @param
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void sendEmailCode(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		String email = request.getParameter("email");// 获取邮箱
		String randStr = ToolsUtil.generateString(6);// 获取6位随机字符串
		try {
			personalInfoService.sendEmailCode(email, randStr, sessionInfo);
			map.put("success", true);
			map.put("msg", "邮箱校验码发送成功，请去您的邮箱查看获取!");
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "邮箱校验码发送失败!");
			logger.error("发送邮箱校验码失败！", e);
			e.printStackTrace();
		}
		writeJson(map);
	}

	/**
	 * @Title: PersonalInfoAction.java
	 * @Description: (邮箱绑定)
	 * @param
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void bindEmail() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		int a = 0;
		try {
			String email = request.getParameter("email");// 获取邮箱
			String randStr = request.getParameter("emailCode");// 获取校验码
			List<EmailSendLog> emailSendLogs = personalInfoService
					.gainEmailSendLogByMap(email, randStr, sessionInfo);
			if (emailSendLogs != null && emailSendLogs.size() > 0) {
				for (EmailSendLog esl : emailSendLogs) {
					boolean flag = ToolsUtil.isCheckExpires(
							esl.getCreatetime(),
							Long.parseLong(ResourceUtil.getValidTime("2")));
					if (!flag) {
						a++;
					}
				}
				if (a == emailSendLogs.size()) {
					map.put("res", "expiry");
					map.put("msg", "您输入的校验码已过期！");
				} else {
					if (Constant.USERTYPE_MEMBER.equals(sessionInfo
							.getUserType())) {// 个人
						member = new Member();
						member.setId(sessionInfo.getUserId());
						member.setEmail(email);
						member.setEmailStatus(1);
						personalInfoService.updatePersonInfo(member);
					} else {// 企业
						company = new Company();
						company.setId(sessionInfo.getUserId());
						company.setEmail(email);
						company.setEmailStatus(BigDecimal.ONE);
						companyInfoService.updateComInfo(company);
					}
					map.put("res", "succ");
					map.put("msg", "邮箱绑定成功!");
				}
			} else {
				map.put("res", "error");
				map.put("msg", "您输入的校验码不正确！");
			}
		} catch (Exception e) {
			map.put("res", "fail");
			logger.error("邮箱绑定失败！", e);
			e.printStackTrace();
		}
		writeJson(map);
	}

//	/**
//	 * @Title: sendMobileCode
//	 * @Description: (发送手机校验码)
//	 * @param     设定文件
//	 * @return void 返回类型
//	 * @author wangmei
//	 */
//	public void sendMobileCode(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
//		if (null == sessionInfo) {
//			sessionInfo = new SessionInfo();
//			String id = ToolsUtil.getUUID();
//			sessionInfo.setUserId(id);
//			session.put(ResourceUtil.getRegisterMobileCode(), id);
//		}
//		String mobileNum = "";
//		if("mobileCheck".equals(request.getParameter("mobileCheck"))){
//			if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){
//				// 会员信息
//				member = personalInfoService.gainMemberById(sessionInfo.getUserId());
//				if(null != member){
//					if(null != member.getMobile() && !"".equals(member.getMobile())){
//						mobileNum = member.getMobile();
//					}else{
//						// 若手机号为空，则通过用户名，并判断用户名是否是手机号
//						String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";
//						Pattern p = Pattern.compile(regExp);
//						Matcher m = p.matcher(member.getUsername());
//						boolean isMobile = m.find();
//						if (isMobile) {
//							mobileNum = member.getUsername();
//						}
//					}
//
//				}
//			}else{
//				// 企业信息
//				company = companyInfoService.gainCompanyById(sessionInfo
//						.getUserId());
//				if(null != company){
//					mobileNum = company.getLinkmanPhone();
//				}
//			}
//		}else{
//			mobileNum = request.getParameter("mobileNum");// 获取手机号码
//		}
//		String randNum = ToolsUtil.getRandomNumber(6);// 获取6位随机数
//
//		// 发送校验码
//		Map<String, Object> map = personalInfoService.sendMobileCode(mobileNum, randNum, sessionInfo, request.getParameter("type"));
//		super.writeJson(map);
//	}

	/**
	 * @Title: bindMobile
	 * @Description: (手机绑定)
	 * @param
	 * @return void 返回类型 
	 * @author wangmei
	 */
//	public void bindMobile(){
//		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
//				.getSessionInfoName());
//		String mobileNum = request.getParameter("mobileNum");// 获取手机号码
//		String mobileCode = request.getParameter("mobileCode");// 获取校验码
//		Map<String, Object> map = new HashMap<String, Object>();
//		member = new Member();
//		company = new Company();
//		int a = 0;
//		try {
//			List<MobileMessage> mobileMessages = personalInfoService
//					.gainMobileMessagesByMap(mobileNum, mobileCode, sessionInfo);
//			if (mobileMessages != null && mobileMessages.size() > 0) {
//				for (MobileMessage ms : mobileMessages) {
//					boolean flag = ToolsUtil.isCheckExpires(ms.getCreatetime(),
//							Long.parseLong(ResourceUtil.getValidTime("1")));
//					if (!flag) {
//						a++;
//					}
//				}
//				if (a == mobileMessages.size()) {
//					map.put("res", "expiry");
//					map.put("msg", "您输入的校验码已过期！");
//				} else {
//					if (Constant.USERTYPE_MEMBER.equals(sessionInfo
//							.getUserType())) {// 个人
//						member.setId(sessionInfo.getUserId());
//						member.setMobile(mobileNum);
//						member.setMobileStatus(1);
//						personalInfoService.updatePersonInfo(member);
//					} else {// 企业
//						company.setId(sessionInfo.getUserId());
//						company.setMobile(mobileNum);
//						company.setMobileStatus(1);
//						companyInfoService.updateComInfo(company);
//					}
//					map.put("res", "succ");
//					map.put("msg", "手机绑定成功!");
//				}
//			} else {
//				map.put("res", "error");
//				map.put("msg", "您输入的校验码不正确！");
//			}
//		} catch (Exception e) {
//			map.put("res", "fail");
//			logger.error("手机绑定失败！", e);
//			e.printStackTrace();
//		}
//		writeJson(map);
//	}

//	/**
//	 * 判断手机验证码是否正确<br>
//	 * 如果是登录用户则根据登录用户的ID查询，如果不是登录则根据session中的ID查询 <br>
//	 * 以上两中情况都存在，返回false
//	* @Title: ajaxMobileCodeBoolean
//	* @Description: (这里用一句话描述这个方法的作用)
//	* @param     设定文件
//	* @return void    返回类型
//	* @author 周张豹
//	 */
//	public void ajaxMobileCodeBoolean(){
//		Json json = new Json();
//		 SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
//		 String id = (String) session.get(ResourceUtil.getRegisterMobileCode());
//		 List<MobileMessage> mobileMessages ;
//		 if (null == sessionInfo && id != null ) {
//			sessionInfo = new SessionInfo();
//			sessionInfo.setUserId(id);
//		 }
//		 //再次判断如果此时还为空，证明没有登录也没有发送验证码或者说已经过期
//		 if (sessionInfo != null ) {
//			 mobileMessages = personalInfoService.gainMobileMessagesByMap(telNum, telCode, sessionInfo);
//			 if (mobileMessages != null && mobileMessages.size() > 0) {
//				 int a = 0;
//				for (MobileMessage m :mobileMessages) {
//					boolean flag = ToolsUtil.isCheckExpires(m.getCreatetime(), Long.parseLong(ResourceUtil.getValidTime("1")));
//					if (!flag) {
//						a++;
//					}
//				}
//				if (a==mobileMessages.size()) {
//					// 过期的
//					json.setSuccess(false);
//					json.setMsg("验证码过期,请重新发送！");
//				}else {
//					//不过期的
//					json.setSuccess(true);
//					json.setMsg("验证码正确！");
//				}
//			}else {
//				//用户在没有点击获取验证码的情况下，输入永久验证码也即正确
//				if(telCode.equals(ResourceUtil.getForeverValidatecode())){
//					json.setSuccess(true);
//					json.setMsg("验证码正确！");
//				}else{
//					//验证码不正确
//					json.setSuccess(false);
//					json.setMsg("验证码不正确,请重新输入！");
//				}
//			}
//		}else {
//			// 用户没有登录情况下，输入永久验证码也即正确
//			if(telCode.equals(ResourceUtil.getForeverValidatecode())){
//				json.setSuccess(true);
//				json.setMsg("验证码正确！");
//			}else{
//				//没有验证码
//				json.setSuccess(false);
//				json.setMsg("不存在验证码,请先发送验证码！");
//			}
//		}
//		 super.writeJson(json);
//	}

	public void zhuanpan(){
		Integer i;
		// 若是今天已经中奖，则今天以后每一次抽都是未中奖
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dayStr = df.format(new Date());
		if (personalInfoService.hasLuckDraw(sessionInfo.getUserId(), dayStr)){
			i= 0;
		}else {
			i = personalInfoService.dejiang();
		}
		super.writeJson(i);
	}

	public void zhuanpanrizhi(){
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());

		personalInfoService.zhuanpanrizhi(sessionInfo.getUserId(),zhuanpanId);
	}

	/**
	 * 判断是否已经中奖
	 * true 中奖
	 * false 未中奖
	 */
	public void hasLuckDraw () {
		Json json = new Json();
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dayStr = df.format(new Date());
		if (personalInfoService.hasLuckDraw(sessionInfo.getUserId(), dayStr)){
			json.setSuccess(true);
		}
		super.writeJson(json);
	}

	public  String seePurchaseHistory() {
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		// 设置每页显示几条数据
		pagination.setRows(8L);
		map.put("page", (pagination.getPage()-1)* pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", personId);
		map.put("orderType", "0");
		map.put("userType", "member");

		pagination.setTotalCount(orderService.gainOrdersByUserIdGetLong(map));//rComRecommendService.gainRegionsComRecommendCountByArea(map));
		orderList = orderService.gainOrdersByUserIdGetList(map);

//		返现金额处理
		for(Order order : orderList) {
			for (OrderItem item : order.getItems()) {
				if (item != null) {
					Goods goods = item.getGoods();
					if (goods != null) {
						if(level != null && level.intValue() != 0) {
							switch (level) {
								case 1:
									goods.setFanxian(goods.getYiji());
									break;
								case 2:
									goods.setFanxian(goods.getErji());
									break;
								case 3:
									goods.setFanxian(goods.getSanji());
									break;
								default:
									break;
							}
						}
					}
				}
			}
		}
		request.setAttribute("pagination", pagination);

		return "purchaseHistory";
	}


	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<MemberJob> getMemberJobs() {
		return memberJobs;
	}

	public void setMemberJobs(List<MemberJob> memberJobs) {
		this.memberJobs = memberJobs;
	}

	public List<Regions> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Regions> provinceList) {
		this.provinceList = provinceList;
	}

	public List<Regions> getCityList() {
		return cityList;
	}

	public void setCityList(List<Regions> cityList) {
		this.cityList = cityList;
	}

	public List<Regions> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Regions> areaList) {
		this.areaList = areaList;
	}

	public String getAreaSize() {
		return areaSize;
	}

	public void setAreaSize(String areaSize) {
		this.areaSize = areaSize;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the telCode
	 */
	public String getTelCode() {
		return telCode;
	}

	/**
	 * @param telCode the telCode to set
	 */
	public void setTelCode(String telCode) {
		this.telCode = telCode;
	}

	/**
	 * @return the telNum
	 */
	public String getTelNum() {
		return telNum;
	}

	/**
	 * @param telNum the telNum to set
	 */
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShenfenzheng() {
		return shenfenzheng;
	}

	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}

	public Double getGuliangbi() {
		return guliangbi;
	}

	public void setGuliangbi(Double guliangbi) {
		this.guliangbi = guliangbi;
	}

	public Double getJifen() {
		return jifen;
	}

	public void setJifen(Double jifen) {
		this.jifen = jifen;
	}

	public String getDhtype() {
		return dhtype;
	}

	public void setDhtype(String dhtype) {
		this.dhtype = dhtype;
	}

	public Double getDhcount() {
		return dhcount;
	}

	public void setDhcount(Double dhcount) {
		this.dhcount = dhcount;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public Double getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(Double maxPoint) {
		this.maxPoint = maxPoint;
	}

	public String getZhuanpanId() {
		return zhuanpanId;
	}

	public void setZhuanpanId(String zhuanpanId) {
		this.zhuanpanId = zhuanpanId;
	}

	public List<XianjinbiDetail> getXianjinbiList() {
		return xianjinbiList;
	}

	public void setXianjinbiList(List<XianjinbiDetail> xianjinbiList) {
		this.xianjinbiList = xianjinbiList;
	}

	public List<XianjinbiCashApply> getXianjinbiCashList() {
		return xianjinbiCashList;
	}

	public void setXianjinbiCashList(List<XianjinbiCashApply> xianjinbiCashList) {
		this.xianjinbiCashList = xianjinbiCashList;
	}

	public List<LiucunbiDetail> getLiucunbiList() {
		return liucunbiList;
	}

	public void setLiucunbiList(List<LiucunbiDetail> liucunbiList) {
		this.liucunbiList = liucunbiList;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
}
