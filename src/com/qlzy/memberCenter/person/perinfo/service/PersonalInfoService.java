/**   
 * @Title: PersonalInfoService.java 
 * @Package com.qlzy.memberCenter.shop.service 
 * @Description: TODO(个人信息管理接口) 
 * @author wangmei   
 * @date 2013-9-17 下午2:13:49 
 * @version V1.0   
 */
package com.qlzy.memberCenter.person.perinfo.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.EmailSendLog;
import com.qlzy.model.LiucunbiDetail;
import com.qlzy.model.Member;
import com.qlzy.model.MemberJob;
import com.qlzy.model.MobileMessage;
import com.qlzy.model.XianjinbiCashApply;
import com.qlzy.model.XianjinbiDetail;
import com.qlzy.pojo.SessionInfo;

public interface PersonalInfoService {

	/**
	 * @Title: gainMemberById
	 * @Description: TODO(获取个人信息)
	 * @param @param id
	 * @param @return 设定文件
	 * @return Member 返回类型
	 * @throws
	 * @author wangmei
	 */
	public Member gainMemberById(String id);
	
	/**
	 * 根据手机号查询用户列表
	 * @param mobile
	 * @return
	 */
	public List<Member> selectMemberByMobile(String mobile);

	/**
	 * 根据登录手机号查询用户列表
	 * @param username
	 * @return
	 */
	public List<Member> selectMemberByName(String username);
	/**
	 * @Title: gainMemberJobList
	 * @Description: TODO(查询从事领域列表)
	 * @param @return 设定文件
	 * @return List<MemberJob> 返回类型
	 * @throws
	 * @author wangmei
	 */
	public List<MemberJob> gainMemberJobList();

	/**
	 * @Title: updatePersonInfo
	 * @Description: TODO(修改个人会员信息)
	 * @param @param member 设定文件
	 * @return void 返回类型
	 * @throws
	 * @author wangmei
	 */
	public int updatePersonInfo(Member member);

	/**
	 * @Title: isCorrectCheckPassword
	 * @Description: TODO(验证登录密码或支付密码是否正确)
	 * @param @param sessionInfo
	 * @param @param password
	 * @param @param type
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @author wangmei
	 */
	public boolean isCorrectCheckPassword(SessionInfo sessionInfo,
			String password, String type);

	/**
	 * @Title: gainQuestionByUserId
	 * @Description: TODO(根据用户ID查询安全保护问题)
	 * @param @param userId
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String gainQuestionByMemberId(String userId);

	/**
	 * @Title: sendMobileCode
	 * @Description: TODO(发送手机验证码并记录日志) 
	 * @param @param mobileNum
	 * @param @param randNum
	 * @param @param type
	 * @param @return    设定文件
	 * @author wangmei
	 */
	public void sendMobileCode(String mobileNum, String randNum,String type);

	/**
	 * @Title: gainMobileMessagesByMap
	 * @Description: TODO(根据手机号码、验证码查询日志信息)
	 * @param @param mobileNum
	 * @param @param randNum
	 * @param @param sessionInfo
	 * @param @return 设定文件
	 * @return List<MobileMessage> 返回类型
	 * @author wangmei
	 */
	public List<MobileMessage> gainMobileMessagesByMap(String mobileNum,
			String randNum);

	/**
	 * @Title: sendEmailCode
	 * @Description: TODO(发送邮箱验证码并记录日志)
	 * @param @param email
	 * @param @param randStr
	 * @param @param sessionInfo 设定文件
	 * @return void 返回类型
	 * @author wangmei
	 */
	public void sendEmailCode(String email, String randStr,
			SessionInfo sessionInfo);

	/**
	 * @Title: gainEmailSendLogByMap
	 * @Description: TODO(根据用户ID、邮箱和验证码查询发送日志信息)
	 * @param @param email
	 * @param @param randStr
	 * @param @param sessionInfo
	 * @param @return 设定文件
	 * @return List<EmailSendLog> 返回类型
	 * @author wangmei
	 */
	public List<EmailSendLog> gainEmailSendLogByMap(String email,
			String randStr, SessionInfo sessionInfo);

	public void zhuanzhang(Map<String, Object> map);

	public Member gainMemberByUsername(String string);

	public Member shengjivip(String userId, Double i);

	public void duihuan(String userId, Double dhcount, String dhtype);

	public List<Member> myYiji(Map<String, Object> map);

	public List<Member> myErji(Map<String, Object> map);

	public List<Member> mySanji(Map<String, Object> map);

	public Member tixian(String userId, Double maxPoint);

	public Integer dejiang();

	public void zhuanpanrizhi(String string, String zhuanpanId);

	public Long myYijiCount(Map<String, Object> map);

	public Long myErjiCount(Map<String, Object> map);

	public Long mySanjiCount(Map<String, Object> map);

	public List<XianjinbiDetail> xianjinbi(Map<String, Object> map);

	public Long xianjinbiCount(Map<String, Object> map);
	
	/**
	 *  金米兑米申请列表
	 * @param map
	 * @return
	 */
	public List<XianjinbiCashApply> xianjinbiCashList(Map<String, Object> map);

	/**
	 * 金米兑米申请数量
	 * @param map
	 * @return
	 */
	public Long xianjinbiCashCount(Map<String, Object> map);

	public List<LiucunbiDetail> liucunbi(Map<String, Object> map);

	public Long liucunbiCount(Map<String, Object> map);

	/**
	 * 判断是否中奖
	 * @param userId
	 * @param dayStr
	 * @return
	 */
	public boolean hasLuckDraw(String userId, String dayStr);
}
