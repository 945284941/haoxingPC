package com.qlzy.mainPage.login.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qlzy.model.CarBrand;
import com.qlzy.model.Company;
import com.qlzy.model.CompanysCarbrand;
import com.qlzy.model.Member;
import com.qlzy.model.MemberJob;
import com.qlzy.model.QlLoginLog;
import com.qlzy.pojo.SessionInfo;

/**
 * @ClassName: LoginService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yhl
 * @date 2013-5-23 上午11:23:18
 *
 */
public interface LoginService {
	/***
	 * company增加
	 * @param company
	 */
	public void addCompany(Company company);
	/***
	 * 添加Company和CarbrandInsert
	 * @param company
	 * @param carBrand
	 * @param request
	 * @param session
	 */
	public void CompanyAndcompanysCarbrandInsert(Company company,String[] carBrand,HttpServletRequest request,Map<String, Object> session);
	/***
	 * member增加
	 * @param member
	 * @param request
	 * @param session
	 */
	public void memberInsert(Member member,HttpServletRequest request,Map<String, Object> session);
	/***
	 * 增加
	 * @param member
	 */
	public void addMember(Member member);
	/***
	 * 更新
	 * @param company
	 */
	public void updateCompany(Company company);
	/***
	 * 更新
	 * @param member
	 */
	public void updateMember(Member member);
	/***
	 * 查询主销车型
	 * @return
	 */
	public List<CarBrand> gainCarBrandList();
	/****
	 * 通过上级id查主销车型
	 * @param pid
	 * @return
	 */
	public List<CarBrand> gainCarBrandListByPid(String pid);
	/***
	 * 通过name查company
	 * @param username
	 * @return
	 */
	public List<Company> getCompanyListByName(String username);
	/***
	 * 通过name查member
	 * @param username
	 * @return
	 */
	public List<Member> getMemberListByName(String username);
	public List<Member> getMemberListByFirstName(String firstname);
	/***
	 * 增加company及carbrand
	 * @param companysCarbrand
	 */
	public void companysCarbrandInsert(CompanysCarbrand companysCarbrand);
	/***
	 * 有上级目录的主销车型
	 * @return
	 */
	public List<CarBrand> gainCarBrandListPidNotNull();
	/***
	 * 查询从事领域信息
	 * @return
	 */
	List<MemberJob> gainMemberJobList();
	/***
	 * 会员登录添加日志信息
	 * @param qlLoginLog
	 */
	public void addLoginLog(QlLoginLog qlLoginLog);
	/***
	 * 会员登录添加日志信息
	 * @param session
	 * @param request
	 * @param sessionInfo
	 * @param memberdto
	 */
	public void updateSeCartLog(Map<String, Object> session,HttpServletResponse  response,HttpServletRequest request, SessionInfo sessionInfo,Member memberdto);
	/***
	 * 企业会员登录添加日志信息
	 * @param session
	 * @param request
	 * @param sessionInfo
	 * @param companydto
	 */
	public void updateSeCartLog(Map<String, Object> session,HttpServletResponse  response,HttpServletRequest request, SessionInfo sessionInfo,Company companydto);
	/***
	 * 查询近15分钟内登录信息
	 * @return
	 */
	public List<Member> memberLoginListByTime();
	
	/***
	 * 查询近15分钟内注册信息
	 * @return
	 */
	public List<Member> memberRegListByTime();
	/***
	 * 查询近15分钟内校对信息
	 * @return
	 */
	public List<Member> memberCollectGoodsCheckListByTime();
	public List<Member> membergainCollectGoodsListByTime();
	/***
	 * 查询全部登录信息
	 * @return
	 */
	public List<Member> memberLoginListAll();
	/***
	 * 查询近全部注册信息
	 * @return
	 */
	public List<Member> memberRegListAll();
	/***
	 * 查询全部校对信息
	 * @return
	 */
	public List<Member> memberCollectGoodsCheckListAll();
	/***
	 * 查询全部上传信息
	 * @return
	 */
	public List<Member> membergainCollectGoodsListAll();
	/***
     * 根据推荐会员ID跟注册IP查看注册权限
     * @param recommendUserId
     * @param regIp
     * @return
     */
   public List<Member> gainMemberByUpd(String recommendUserId,String regIp);
   
   /**
    * 根据用户ID和用户的类型查询用户支付密码
   * @Title: gainUserById
   * @Description: TODO(根据用户ID和用户的类型查询用户信息)
   * @param @param userId
   * @param @param userType
   * @param @return    设定文件
   * @return Object    返回类型
   * @author 周张豹
    */
   public String gainUserPayPasswordById(String userId,String userType);
   
	/***
    * 根据推荐用户ID跟注册IP查看注册权限
    * @param recommendUserId
    * @param regIp
    * @return
    */
  public List<Company> gainCompanyByUpd(String recommendUserId,String regIp);
	public void CompanyAndcompanysInsert(Company company,
			HttpServletRequest request, Map<String, Object> session);
	public List<Member> getMemberListByShangjiId(String shangjiId);
	
	public Member queryMemberById(String id);
	
	public Company queryCompanyById(String id);
	
	/**
	 * 验证用户手机号是否已使用
	 * @param mobile
	 * @return
	 */
	public List<Member> gainByMobile(String mobile);
	
	public List<Member> validateLogin(Map<String, Object> map);
	/**
	 * @Title: gainMemberByLoginName
	 * @Description:
	 * @date 2017-1-11 上午11:08:01 
	 * @param @param loginName
	 * @param @return 设定文件
	 * @return List<Member> 返回类型
	 * @throws
	 * @version V1.0
	 */
	public List<Member> gainMemberByLoginName(String loginName);


}
