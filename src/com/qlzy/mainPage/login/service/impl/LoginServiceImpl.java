package com.qlzy.mainPage.login.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.common.tools.MD5;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.email.util.GenerateLinkUtils;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.floor.dao.CompanysCarbrandMapper;
import com.qlzy.mainPage.head.dao.CarBrandMapper;
import com.qlzy.mainPage.login.dao.MemberJobMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.mainPage.login.dao.QlLoginLogMapper;
import com.qlzy.mainPage.login.service.LoginService;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.common.dao.PointDetailMapper;
import com.qlzy.model.CarBrand;
import com.qlzy.model.Company;
import com.qlzy.model.CompanysCarbrand;
import com.qlzy.model.Member;
import com.qlzy.model.MemberJob;
import com.qlzy.model.PointDetail;
import com.qlzy.model.QlLoginLog;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.LoadpropertiesUtil;

/**
 * @ClassName: LoginServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huifeng Wang
 * @date 2013-5-23 上午11:23:04
 *
 */
@Service("loginService")
@Transactional(rollbackFor=Exception.class)
public class LoginServiceImpl implements LoginService{

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private CarBrandMapper carBrandMapper;
	@Autowired
	private MemberJobMapper memberJobMapper;
	@Autowired
	private CompanysCarbrandMapper companysCarbrandMapper;
	@Autowired
	private QlLoginLogMapper qlLoginLogMapper;
	@Autowired
	private MemberCallService memberCallService;
	@Autowired
	private PointDetailMapper pointDetailMapper;
	
	
	@Override
	public void addCompany(Company company) {
		// TODO Auto-generated method stub
		companyMapper.insertSelective(company);
		
	}
	@Override
	public void addMember(Member member) {
		// TODO Auto-generated method stub
		memberMapper.insertSelective(member);
	}
	@Override
	public void updateCompany(Company company) {
		// TODO Auto-generated method stub
		companyMapper.updateByPrimaryKeySelective(company);
	}
	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		memberMapper.updateByPrimaryKeySelective(member);
	}
	/***
	 * 主销车型查询
	 */
	@Override
	public List<CarBrand> gainCarBrandList() {
		// TODO Auto-generated method stub
		Integer grade = 1;
		List<CarBrand> carList =  carBrandMapper.gainCarBrandList(grade);
		return carList;
	}
	/***
	 * 有上级目录的主销车型
	 */
	@Override
	public List<CarBrand> gainCarBrandListPidNotNull() {
		// TODO Auto-generated method stub
		Integer grade = 1;
		List<CarBrand> carList =  carBrandMapper.gainCarBrandListPidNotNull(grade);
		return carList;
	}
	
	/**
	 * 通过上级id查询主销车型
	 */
	@Override
	public List<CarBrand> gainCarBrandListByPid(String pid) {
		// TODO Auto-generated method stub
		return carBrandMapper.gainCarBrandListByPid(pid);
	}
	/***
	 * 通过name查询company
	 */
	@Override
	public List<Company> getCompanyListByName(String username) {
		// TODO Auto-generated method stub
//		return companyMapper.selectByCompanyName(username);
		return null;
	}

	/***
	 * 通过name查询member
	 */
	@Override
	public List<Member> getMemberListByName(String username) {
		// TODO Auto-generated method stub
		return memberMapper.selectByMemberName(username);
	}
	@Override
	public List<Member> gainMemberByLoginName(String username) {
		// TODO Auto-generated method stub
		return memberMapper.gainMemberByLoginName(username);
	}
	
	/***
	 * 通过name查询member
	 */
	@Override
	public List<Member> getMemberListByFirstName(String firstname) {
		// TODO Auto-generated method stub
		return memberMapper.selectByMemberFirstName(firstname);
	}
	/***
	 * 增加companysCarbrand
	 */
	public void companysCarbrandInsert(CompanysCarbrand companysCarbrand){
		companysCarbrandMapper.insert(companysCarbrand);
	}
	/***
	 * 增加company及Carbrand
	 */
	@Override
	public void CompanyAndcompanysCarbrandInsert(Company company,String[] carBrand,HttpServletRequest request,Map<String, Object> session) {
		// TODO Auto-generated method stub
			Double comPoint;
			company.setId(ToolsUtil.getUUID());
			company.setMobileStatus(BigDecimal.ONE);
			String uIp = getIpAddr(request);
			company.setRegIp(uIp);
			if(null != company.getRecommendUserid() && !"".equals(company.getRecommendUserid())){
				GenerateLinkUtils pwdCrypt = new GenerateLinkUtils();
				String uId = pwdCrypt.decrypt(company.getRecommendUserid());
				company.setRecommendUserid(uId);
				Company com = companyMapper.selectByPrimaryKey(company.getRecommendUserid());
				LoadpropertiesUtil pr = new LoadpropertiesUtil();
				Properties propertie = pr.loadproperties("shopSet.properties");
				String pointStr = propertie.getProperty("point");
				int numCheck = Integer.parseInt(propertie.getProperty("memberCountIp"));
				List<Company> hyCount = gainCompanyByUpd(uId, uIp);
				if(hyCount.size() > numCheck){

				}else{
					comPoint = Double.parseDouble(pointStr);
//					com.setPoint(com.getPoint().add(comPoint));
					companyMapper.updateByPrimaryKeySelective(com);

					// 获得经验值记录日志
					PointDetail pointDetail = new PointDetail();
					pointDetail.setId(ToolsUtil.getUUID());
					pointDetail.setPoint(comPoint);
					pointDetail.setMemberId(company.getId());
					pointDetail.setRemark("分享好友获得的经验值");
					pointDetail.setCreatetime(new Date());
					pointDetail.setType(0);
					pointDetailMapper.addPointLog(pointDetail);
				}

			}
			company.setPassword(MD5.encrypt(company.getPassword()));
			company.setRegTime(new Date());
			companyMapper.insertSelective(company);
		for (int i = 0; i < carBrand.length; i++) {
			CompanysCarbrand companysCarbrand = new CompanysCarbrand();
			companysCarbrand.setId(ToolsUtil.getUUID());
			companysCarbrand.setCarBrandId(carBrand[i]);
			companysCarbrand.setCompanyId(company.getId());
			companysCarbrandMapper.insert(companysCarbrand);
		}
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setUserId(company.getId());
		sessionInfo.setLoginName(company.getUsername());
		sessionInfo.setIp(getIpAddr(request));
		sessionInfo.setUserType("company");
		sessionInfo.setShCheck(company.getShCheck());
		session.put(ResourceUtil.getSessionInfoName(), sessionInfo);
	}
	/***
	 * 增加member
	 */
	@Override
	public void memberInsert(Member member, HttpServletRequest request,
			Map<String, Object> session) {
		// TODO Auto-generated method stub
		Member mb = null; 
		Double Memberpoint;	
		member.setId(ToolsUtil.getUUID());
		member.setMobileStatus(1);
		String uIp = getIpAddr(request);
		member.setRegIp(uIp);
		if(!"".equals(member.getRecommendUserId())){
			GenerateLinkUtils pwdCrypt = new GenerateLinkUtils();
			String uId = pwdCrypt.decrypt(member.getRecommendUserId());
			member.setRecommendUserId(uId);
			mb =  memberMapper.selectByPrimaryKey(member.getRecommendUserId());
			LoadpropertiesUtil pr = new LoadpropertiesUtil();
			Properties propertie = pr.loadproperties("shopSet.properties");
			String pointStr = propertie.getProperty("point");
			int numCheck = Integer.parseInt(propertie.getProperty("memberCountIp"));
			List<Member> memberCount = this.gainMemberByUpd(uId,uIp);
			if(memberCount.size() > numCheck){
				
			}else{
				Memberpoint = Double.parseDouble(pointStr);
				mb.setPoint(mb.getPoint()+ Memberpoint);
				memberMapper.updateByPrimaryKeySelective(mb);
				
				// 获得经验值记录日志
				PointDetail pointDetail = new PointDetail();
				pointDetail.setId(ToolsUtil.getUUID());
				pointDetail.setPoint(Memberpoint);
				pointDetail.setMemberId(member.getId());
				pointDetail.setRemark("分享好友获得的经验值");
				pointDetail.setCreatetime(new Date());
				pointDetail.setType(0);
				pointDetailMapper.addPointLog(pointDetail);
			}
			
		}
		
		member.setPassword(MD5.encrypt(member.getPassword()));
		member.setRegTime(new Date());
		member.setPoint(2000D);
		
		String onlyId = memberMapper.nextOnlyId();
		int i = 0;
		while(true){
			List<Member> exist = memberMapper.gainMemberByShangjiId(onlyId);
			if(!exist.isEmpty()){
				i++;
				onlyId = String.valueOf(Integer.parseInt(memberMapper.nextOnlyId()) + i);
			}else {
				break;
			}
		}
		member.setOnlyId(onlyId);
		
		memberMapper.insertSelective(member);		
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setUserId(member.getId());
		sessionInfo.setLoginName(member.getUsername());
		sessionInfo.setIp(getIpAddr(request));
		sessionInfo.setUserType("member");
		sessionInfo.setLoginNickName(member.getFirstname());
		session.put(ResourceUtil.getSessionInfoName(), sessionInfo);
		// 注册经验值记录日志
		PointDetail pointDetail = new PointDetail();
		pointDetail.setId(ToolsUtil.getUUID());
		pointDetail.setPoint(2000D);
		pointDetail.setMemberId(member.getId());
		pointDetail.setRemark("注册会员获得的经验值");
		pointDetail.setCreatetime(new Date());
		pointDetail.setType(0);
		pointDetailMapper.addPointLog(pointDetail);
		
		
		if(member.getShangjiId()!=null && member.getShangjiId() != ""){
			
			List <Member>list1 = memberMapper.gainMemberByShangjiId(member.getShangjiId());
			if(list1.size() ==1 ){
				Member smMember =list1 .get(0);
				PointDetail pointDetail1 = new PointDetail();
				pointDetail1.setId(ToolsUtil.getUUID());
				pointDetail1.setPoint(200D);
				pointDetail1.setMemberId(smMember.getId());
				pointDetail1.setRemark("一级下游注册会员获得经验值");
				pointDetail1.setBalance(smMember.getPoint());
				pointDetail1.setCreatetime(new Date());
				pointDetail1.setType(0);
				pointDetailMapper.addPointLog(pointDetail1);
			
				smMember.setPoint(smMember.getPoint()+200D);
				memberMapper.updateByPrimaryKeySelective(smMember);
				
				List <Member>list2 = memberMapper.gainMemberByShangjiId(smMember.getShangjiId());
				if( list2.size() ==1 ){
					Member ssMember =list2.get(0);
				
					PointDetail pointDetail2 = new PointDetail();
					pointDetail2.setId(ToolsUtil.getUUID());
					pointDetail2.setPoint(200D);
					pointDetail2.setMemberId(ssMember.getId());
					pointDetail2.setRemark("二级下游注册会员获得经验值");
					pointDetail2.setBalance(ssMember.getPoint());
					pointDetail2.setCreatetime(new Date());
					pointDetail2.setType(0);
					pointDetailMapper.addPointLog(pointDetail2);
							
					ssMember.setPoint(ssMember.getPoint()+200D);
					memberMapper.updateByPrimaryKeySelective(ssMember);
							
						List <Member>list3 = memberMapper.gainMemberByShangjiId(ssMember.getShangjiId());
						if( list3.size() ==1 ){
							Member sssMember =list3 .get(0);
								
							PointDetail pointDetail3 = new PointDetail();
							pointDetail3.setId(ToolsUtil.getUUID());
							pointDetail3.setPoint(200D);
							pointDetail3.setMemberId(sssMember.getId());
							pointDetail3.setRemark("三级下游注册会员获得经验值");
							pointDetail3.setBalance(sssMember.getPoint());
							pointDetail3.setCreatetime(new Date());
							pointDetail3.setType(0);
							pointDetailMapper.addPointLog(pointDetail3);
							
							sssMember.setPoint(sssMember.getPoint()+200D);
							memberMapper.updateByPrimaryKeySelective(sssMember);
								
						}
				}
			}
				}
	}
	/***
	 * 获取请求ip
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	/***
	 * 从事领域信息
	 */
	@Override
	public List<MemberJob> gainMemberJobList() {
		// TODO Auto-generated method stub
		return memberJobMapper.gainMemberJobList();
	}
	/***
	 * 会员登录添加日志信息
	 */
	@Override
	public void addLoginLog(QlLoginLog qlLoginLog) {
		// TODO Auto-generated method stub
		qlLoginLogMapper.insertSelective(qlLoginLog);
	}
	/***
	 * 会员登录添加日志信息
	 */
	@Override
	public void updateSeCartLog(Map<String, Object> session,
			HttpServletResponse  response,HttpServletRequest request, 
			SessionInfo sessionInfo,
			Member memberdto) {
		// TODO Auto-generated method stub
		session.put(ResourceUtil.getSessionInfoName(), sessionInfo);
		memberCallService.updateCartByCookie(response,request, sessionInfo);
		memberdto.setLastLoginTime(new Date());
		memberMapper.updateByPrimaryKeySelective(memberdto);
		QlLoginLog qlLoginLog = new QlLoginLog();
		qlLoginLog.setId(ToolsUtil.getUUID());
		qlLoginLog.setLoginIp(getIpAddr(request));
		qlLoginLog.setLoginTime(new Date());
		qlLoginLog.setUserId(memberdto.getId());
		qlLoginLog.setType(0);
		qlLoginLogMapper.insertSelective(qlLoginLog);
	}
	/***
	 * 企业会员登录添加日志信息
	 */
	@Override
	public void updateSeCartLog(Map<String, Object> session,
			HttpServletResponse  response,HttpServletRequest request, 
			SessionInfo sessionInfo,
			Company companydto) {
		// TODO Auto-generated method stub
		session.put(ResourceUtil.getSessionInfoName(), sessionInfo);
		memberCallService.updateCartByCookie(response,request, sessionInfo);
		QlLoginLog qlLoginLog = new QlLoginLog();
		qlLoginLog.setId(ToolsUtil.getUUID());
		qlLoginLog.setLoginIp(getIpAddr(request));
		qlLoginLog.setLoginTime(new Date());
		qlLoginLog.setUserId(companydto.getId());
		qlLoginLog.setType(1);
		qlLoginLogMapper.insertSelective(qlLoginLog);
	}
	/***
	 * 查询近15分钟内登录信息
	 */
	public List<Member> memberLoginListByTime(){
		List<Member> memberLoginList = memberMapper.gainActiveAllLoginNameByTime();
		return memberLoginList;
	}
	/***
	 * 查询近15分钟内注册信息
	 */
	public List<Member> memberRegListByTime(){
		List<Member> regMemberList = memberMapper.gainActiveselectAllRegNameByTime();
		return regMemberList;
	}
	/***
	 * 查询近15分钟内校对信息
	 */
	public List<Member> memberCollectGoodsCheckListByTime(){
		List<Member> goodsCheckList = memberMapper.gainActiveGoodsCheckListByTime();
		return goodsCheckList;
	}
	@Override
	public List<Member> membergainCollectGoodsListByTime() {
		// TODO Auto-generated method stub
		List<Member> goodsList = memberMapper.gainActiveGoodsListByTime();
		return goodsList;
	}
	/***
	 * 查询全部登录信息
	 */
	public List<Member> memberLoginListAll(){
		List<Member> memberLoginList = memberMapper.gainActiveAllLoginNameAll();
		return memberLoginList;
	}
	/***
	 * 查询近全部注册信息
	 */
	public List<Member> memberRegListAll(){
		List<Member> regMemberList = memberMapper.gainActiveselectAllRegNameAll();
		return regMemberList;
	}
	/***
	 * 查询近全部校对信息
	 */
	public List<Member> memberCollectGoodsCheckListAll(){
		List<Member> goodsCheckList = memberMapper.gainActiveGoodsCheckListAll();
		return goodsCheckList;
	}
	/***
	 * 查询近全部上传信息
	 */
	@Override
	public List<Member> membergainCollectGoodsListAll() {
		// TODO Auto-generated method stub
		List<Member> goodsList = memberMapper.gainActiveGoodsListAll();
		return goodsList;
	}
	@Override
	public List<Member> gainMemberByUpd(String recommendUserId, String regIp) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("recommendUserId", recommendUserId);
		map.put("regIp", regIp);
		List<Member> goodsList = memberMapper.gainMemberByUpd(map);
		return goodsList;
	}
	/* (non-Javadoc)
	 * @see com.qlzy.mainPage.login.service.LoginService#gainUserById(java.lang.String, java.lang.String)
	 */
	@Override
	public String gainUserPayPasswordById(String userId, String userType) {
		if (userType != null && "member".equals(userType)) {//个人会员
			Member member = memberMapper.selectMemberById(userId);
			return member.getPayPassword();
		} else if(userType != null && "company".equals(userType)) {//企业会员
			Company company = companyMapper.selectByPrimaryKey(userId);
			return company.getPayPassword();
		}else {
			return null;
		}
		
	}
	
	/** (非 Javadoc) 
	 * @Title:gainCompanyByUpd 
	 * @Description: TODO(根据推荐用户ID跟注册IP查看注册权限)  
	 * @param recommendUserId
	 * @param regIp
	 * @return 
	 * @see com.qlzy.mainPage.login.service.LoginService#gainCompanyByUpd(java.lang.String, java.lang.String) 
	 */
	@Override
	public List<Company> gainCompanyByUpd(String recommendUserId, String regIp) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("recommendUserId", recommendUserId);
		map.put("regIp", regIp);
//		return companyMapper.gainCompanyByUpd(map);
		return null;
	}

	@Override
	public void CompanyAndcompanysInsert(Company company,
			HttpServletRequest request, Map<String, Object> session) {
		// TODO Auto-generated method stub
					BigDecimal comPoint;
					company.setId(ToolsUtil.getUUID());
					company.setMobileStatus(new BigDecimal(1));
					String uIp = getIpAddr(request);
					company.setRegIp(uIp);
					if(null != company.getRecommendUserid() && !"".equals(company.getRecommendUserid())){
						GenerateLinkUtils pwdCrypt = new GenerateLinkUtils();
						String uId = pwdCrypt.decrypt(company.getRecommendUserid());
						company.setRecommendUserid(uId);
						Company com = companyMapper.selectByPrimaryKey(company.getRecommendUserid());
						LoadpropertiesUtil pr = new LoadpropertiesUtil();
						Properties propertie = pr.loadproperties("shopSet.properties");
						String pointStr = propertie.getProperty("point");
						int numCheck = Integer.parseInt(propertie.getProperty("memberCountIp"));
						List<Company> hyCount = gainCompanyByUpd(uId, uIp);
						if(hyCount.size() > numCheck){
							
						}else{
							comPoint = new BigDecimal(pointStr);
							com.setPoint(com.getPoint().add(comPoint));
							companyMapper.updateByPrimaryKeySelective(com);
							
							// 获得经验值记录日志
							PointDetail pointDetail = new PointDetail();
							pointDetail.setId(ToolsUtil.getUUID());
							pointDetail.setPoint(Double.parseDouble(comPoint.toString()));
							pointDetail.setMemberId(company.getId());
							pointDetail.setRemark("分享好友获得的经验值");
							pointDetail.setCreatetime(new Date());
							pointDetail.setType(0);
							pointDetailMapper.addPointLog(pointDetail);
						}
						
					}			
					company.setPassword(MD5.encrypt(company.getPassword()));
					company.setRegTime(new Date());
					companyMapper.insertSelective(company);
				SessionInfo sessionInfo = new SessionInfo();
				sessionInfo.setUserId(company.getId());
				sessionInfo.setLoginName(company.getUsername());
				sessionInfo.setIp(getIpAddr(request));
				sessionInfo.setUserType("company");
				sessionInfo.setShCheck(company.getShCheck());
				session.put(ResourceUtil.getSessionInfoName(), sessionInfo);
		
	}
	@Override
	public List<Member> getMemberListByShangjiId(String shangjiId) {
		// TODO Auto-generated method stub
		return memberMapper.getMemberListByShangjiId(shangjiId);
	}
	@Override
	public Member queryMemberById(String id) {
		return memberMapper.selectByPrimaryKey(id);
	}
	@Override
	public Company queryCompanyById(String id) {
		return companyMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 验证用户手机号是否已使用
	 */
	@Override
	public List<Member> gainByMobile(String mobile) {
		
		return memberMapper.gainByMobile(mobile);
	}
	
	/**
	 * 根据用户名手机号验证登录
	 */
	@Override
	public List<Member> validateLogin(Map<String, Object> map) {
		
		return memberMapper.validateLogin(map);
	}

}
