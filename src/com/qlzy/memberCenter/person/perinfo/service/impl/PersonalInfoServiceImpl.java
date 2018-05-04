/**   
 * @Title: PersonalInfoServiceImpl.java 
 * @Package com.qlzy.memberCenter.shop.service.impl 
 * @Description: 
 * @author wangmei   
 * @date 2013-9-17 下午2:17:31 
 * @version V1.0   
 */
package com.qlzy.memberCenter.person.perinfo.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.common.constant.MobileMessageContant;
import com.qlzy.common.mail.SendEmailUtil;
import com.qlzy.common.tools.Arith;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.login.dao.MemberJobMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.memberCenter.common.dao.EmailSendLogMapper;
import com.qlzy.memberCenter.common.dao.MobileMessageMapper;
import com.qlzy.memberCenter.common.dao.PointDetailMapper;
import com.qlzy.memberCenter.person.moneyManage.dao.AdvanceLogsMapper;
import com.qlzy.memberCenter.person.perinfo.dao.JiesuanItemMapper;
import com.qlzy.memberCenter.person.perinfo.dao.LiucunbiDetailMapper;
import com.qlzy.memberCenter.person.perinfo.dao.MemeberDeailMapper;
import com.qlzy.memberCenter.person.perinfo.dao.XianjinbiCashApplyMapper;
import com.qlzy.memberCenter.person.perinfo.dao.XianjinbiDetailMapper;
import com.qlzy.memberCenter.person.perinfo.dao.ZhuanpanLogMapper;
import com.qlzy.memberCenter.person.perinfo.dao.ZhuanpanMapper;
import com.qlzy.memberCenter.person.perinfo.service.PersonalInfoService;
import com.qlzy.model.AdvanceLogs;
import com.qlzy.model.Company;
import com.qlzy.model.EmailSendLog;
import com.qlzy.model.LiucunbiDetail;
import com.qlzy.model.Member;
import com.qlzy.model.MemberJob;
import com.qlzy.model.MemeberDeail;
import com.qlzy.model.MobileMessage;
import com.qlzy.model.PointDetail;
import com.qlzy.model.XianjinbiCashApply;
import com.qlzy.model.XianjinbiDetail;
import com.qlzy.model.Zhuanpan;
import com.qlzy.model.ZhuanpanLog;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.task.model.CashBackTask;
import com.qlzy.task.service.ITaskService;
import com.qlzy.util.Constant;

@Service("personalInfoService")
@Transactional(rollbackFor = Exception.class)
public class PersonalInfoServiceImpl implements PersonalInfoService {

	@Resource
	private MemberMapper memberMapper;
	@Resource
	private MemberJobMapper memberJobMapper;
	@Resource
	private MobileMessageMapper mobileMessageMapper;
	@Resource
	private EmailSendLogMapper emailSendLogMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private AdvanceLogsMapper advanceLogsMapper;
	@Resource
	private PointDetailMapper pointDetailMapper;
	@Resource
	private MemeberDeailMapper memeberDeailMapper;
	@Resource
	private XianjinbiDetailMapper  XianjinbiMapper;
	@Resource
	private XianjinbiCashApplyMapper xianjinbiCashApplyMapper;
	@Resource
	private LiucunbiDetailMapper  liucunbiDetailMapper;
//	@Resource
//	private CourtesyMemberMapper courtesyMemberMapper;
	@Resource
	private JiesuanItemMapper jiesuanItemMapper;
	@Resource
	private ZhuanpanMapper zhuanpanMapper;
	@Resource
	private ZhuanpanLogMapper zhuanpanLogMapper;
	@Resource
	private ITaskService taskService;
	/**
	 * (非 Javadoc)
	 * 
	 * @Title: PersonalInfoServiceImpl.java
	 * @Description: 
	 * @param @param id
	 * @param @return
	 * @see com.qlzy.memberCenter.shop.service.PersonalInfoService#gainMemberById(java.lang.String)
	 */
	@Override
	public Member gainMemberById(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Member member =  memberMapper.gainMemberById(id);
		map.put("onlyId",member.getOnlyId());
		Long yiji = memberMapper.myYijiCount(map);
		Long erji =  memberMapper.myErjiCount(map);
		Long sanji =  memberMapper.mySanjiCount(map);
		Long yijivip = memberMapper.myYijiCountvip(map);
		Long erjivip =  memberMapper.myErjiCountvip(map);
		Long sanjivip =  memberMapper.mySanjiCountvip(map);
		
		member.setYiji(yiji);
		member.setErji(erji);
		member.setSanji(sanji);
		member.setYijivip(yijivip);
		member.setErjivip(erjivip);
		member.setSanjivip(sanjivip);
		
		return member;
	}

	public List<Member> selectMemberByName(String username){
		return memberMapper.selectByMemberName(username);
	}

	public List<Member> selectMemberByMobile(String mobile){
		return memberMapper.selectMemberByMobile(mobile);
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: PersonalInfoServiceImpl.java
	 * @Description: 
	 * @param @return
	 * @see com.qlzy.memberCenter.shop.service.PersonalInfoService#gainMemberJobList()
	 */
	@Override
	public List<MemberJob> gainMemberJobList() {
		return memberJobMapper.gainMemberJobList();
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: PersonalInfoServiceImpl.java
	 * @Description: 
	 * @param @param member
	 * @see com.qlzy.memberCenter.shop.service.PersonalInfoService#updatePersonInfo(com.qlzy.model.Member)
	 */
	@Override
	public int updatePersonInfo(Member member) {
		return memberMapper.updateByPrimaryKeySelective(member);

	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title:isCorrectCheckPassword
	 * @Description: 
	 * @param sessionInfo
	 * @param password
	 * @param type
	 * @return
	 * @see com.qlzy.memberCenter.person.perinfo.service.PersonalInfoService#isCorrectCheckPassword(com.qlzy.pojo.SessionInfo,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isCorrectCheckPassword(SessionInfo sessionInfo,
			String password, String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", sessionInfo.getUserId());
		map.put("pwd", password);
		map.put("type", type);
		if (Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())) {
			List<Member> list = memberMapper.gainMemberByIdAndPassword(map);
			if (list != null && list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} else {
//			List<Company> list = companyMapper.gainCompanyByIdAndPassword(map);
			List<Company> list = null;
			if (list != null && list.size() > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title:gainQuestionByMemberId
	 * @Description: 
	 * @param userId
	 * @return
	 * @see com.qlzy.memberCenter.person.perinfo.service.PersonalInfoService#gainQuestionByMemberId(java.lang.String)
	 */
	@Override
	public String gainQuestionByMemberId(String userId) {
		return memberMapper.gainQuestionByMemberId(userId);
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title:sendMobileCode
	 * @Description: 
	 * @param mobileNum
	 * @param randNum
	 * @return
	 * @see
	 */
	@Override
	public void sendMobileCode(String mobileNum, String randNum,
			String type) {
		String content = MobileMessageContant.sendForRegisterMobile(randNum);
		// 记录发送短信验证码日志
		MobileMessage mobileMessage = new MobileMessage();
		mobileMessage.setId(ToolsUtil.getUUID());
		mobileMessage.setMsgId(null);
		mobileMessage.setContent(content);
		mobileMessage.setToMobile(String.valueOf(mobileNum));
		mobileMessage.setCreatetime(new Date());
		mobileMessage.setType("1");
		mobileMessage.setStatus("true");
		mobileMessage.setStatusDescription(null);
		mobileMessage.setVerificationCode(randNum);
//		mobileMessage.setUserId(sessionInfo.getUserId());
		mobileMessageMapper.addMobileMessage(mobileMessage);
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title:gainMobileMessagesByMap
	 * @Description: 
	 * @param mobileNum
	 * @param sessionInfo
	 * @return
	 * @see
	 */
	@Override
	public List<MobileMessage> gainMobileMessagesByMap(String mobileNum,
			String randNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("verificationCode", randNum);
		map.put("toMobile", mobileNum);
		return mobileMessageMapper.gainMobileByUserId(map);
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title:sendEmailCode
	 * @Description: 
	 * @param email
	 * @param randStr
	 * @param sessionInfo
	 * @see com.qlzy.memberCenter.person.perinfo.service.PersonalInfoService#sendEmailCode(java.lang.String,
	 *      java.lang.String, com.qlzy.pojo.SessionInfo)
	 */
	@Override
	public void sendEmailCode(String email, String randStr,
			SessionInfo sessionInfo) {
		// 发送邮箱验证码
		SendEmailUtil.sendEmailCode(sessionInfo.getLoginName(), email, randStr);

		// 记录发送邮箱验证码日志
		EmailSendLog esl = new EmailSendLog();
		esl.setId(ToolsUtil.getUUID());
		esl.setContent(MobileMessageContant.sendForBindEmail(randStr));
		esl.setToEmail(email);
		esl.setCreatetime(new Date());
		esl.setVerificationCode(randStr);
		esl.setUserId(sessionInfo.getUserId());
		emailSendLogMapper.addEmailSendLog(esl);
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title:gainEmailSendLogByMap
	 * @Description: 
	 * @param email
	 * @param randStr
	 * @param sessionInfo
	 * @return
	 * @see com.qlzy.memberCenter.person.perinfo.service.PersonalInfoService#gainEmailSendLogByMap(java.lang.String,
	 *      java.lang.String, com.qlzy.pojo.SessionInfo)
	 */
	@Override
	public List<EmailSendLog> gainEmailSendLogByMap(String email,
			String randStr, SessionInfo sessionInfo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", sessionInfo.getUserId());
		map.put("verificationCode", randStr);
		map.put("email", email);
		return emailSendLogMapper.gainEmailSendLogByMap(map);
	}

	@Override
	public void zhuanzhang(Map<String, Object> map) {
		Member member = new Member();
		member=(Member) map.get("member");//拿到钱的人
		Member  member2 = new Member();//出钱的人
		member2 =memberMapper.selectByPrimaryKey((String)map.get("userId2"));
		
		if((Double)map.get("guliangbi") !=null &&(Double)map.get("guliangbi") !=0 ){
		
		AdvanceLogs advanceLogs2 = new AdvanceLogs();
		advanceLogs2.setId(ToolsUtil.getUUID());
		advanceLogs2.setUserId((String)map.get("userId2"));
		advanceLogs2.setMessage("您向用户"+member.getUsername()+"转账");
		advanceLogs2.setDoTime(new Date());
		advanceLogs2.setDoType("2");
		advanceLogs2.setDoMoney((Double)map.get("guliangbi"));
		advanceLogs2.setBalance(member2.getAdvance());
		advanceLogs2.setTrading("1");
		advanceLogsMapper.insertSelective(advanceLogs2);
		
		AdvanceLogs advanceLogs = new AdvanceLogs();
		advanceLogs.setId(ToolsUtil.getUUID());
		advanceLogs.setUserId(member.getId());
		advanceLogs.setMessage("用户"+member2.getUsername()+"向您"+member.getUsername()+"转账");
		advanceLogs.setDoTime(new Date());
		advanceLogs.setDoType("0");
		advanceLogs.setDoMoney((Double)map.get("guliangbi"));
		advanceLogs.setBalance(member.getAdvance());
		advanceLogs.setTrading("1");
		advanceLogsMapper.insertSelective(advanceLogs);
		
		member.setAdvance(member.getAdvance()+(Double)map.get("guliangbi"));
		member2.setAdvance(member2.getAdvance()-(Double)map.get("guliangbi"));
		memberMapper.updateByPrimaryKeySelective(member2);
		memberMapper.updateByPrimaryKeySelective(member);
		}
		if((Double)map.get("jifen") !=null &&(Double)map.get("jifen") !=0 ){
		PointDetail pointDetail2 =new PointDetail();
		pointDetail2.setId(ToolsUtil.getUUID());
		pointDetail2.setPoint((Double)map.get("jifen"));
		pointDetail2.setMemberId((String)map.get("userId2"));
		pointDetail2.setRemark("您向用户"+member.getUsername()+"转经验值");
		pointDetail2.setCreatetime(new Date());
		pointDetail2.setBalance(member2.getPoint());
		pointDetail2.setType(1);
		pointDetailMapper.insertSelective(pointDetail2);
		
		PointDetail pointDetail =new PointDetail();
		pointDetail.setId(ToolsUtil.getUUID());
		pointDetail.setPoint((Double)map.get("jifen"));
		pointDetail.setMemberId(member.getId());
		pointDetail.setRemark("用户"+member2.getUsername()+"向您"+member.getUsername()+"转经验值");
		pointDetail.setCreatetime(new Date());
		pointDetail.setBalance(member.getPoint());
		pointDetail.setType(0);
		pointDetailMapper.insertSelective(pointDetail);
		
		member.setPoint(member.getPoint()+(Double)map.get("jifen"));
		member2.setPoint(member2.getPoint()-(Double)map.get("jifen"));
		memberMapper.updateByPrimaryKeySelective(member2);
		memberMapper.updateByPrimaryKeySelective(member);
		}
	}

	@Override
	public Member gainMemberByUsername(String userName) {
		return memberMapper.gainMemberByUsername(userName);
	}

	@Override
	public synchronized Member shengjivip(String userId, Double i) {

		Member member = memberMapper.selectByPrimaryKey(userId);
		if (member.getAdvance() < i) {
			member.setEngageindustryname("粮票余额不足");
		} else {
			if (member.getType().equals("0")) {

				member.setType("82ee892375df4c1e98a3d8c9fd6e7612");
				member.setAdvance(member.getAdvance() - i);
				memberMapper.updateByPrimaryKeySelective(member);

				AdvanceLogs advanceLogs2 = new AdvanceLogs();
				advanceLogs2.setId(ToolsUtil.getUUID());
				advanceLogs2.setUserId(userId);
				advanceLogs2.setMessage("升级vip，花费998粮票");
				advanceLogs2.setDoTime(new Date());
				advanceLogs2.setDoType("2");
				advanceLogs2.setDoMoney(i);
				advanceLogs2.setBalance(member.getAdvance() + i);
				advanceLogs2.setTrading("1");
				advanceLogsMapper.insertSelective(advanceLogs2);

				MemeberDeail mem = new MemeberDeail();
				mem.setId(ToolsUtil.getUUID());
				mem.setMembername(member.getUsername());
				mem.setMemberid(member.getId());
				mem.setMessage("升级会员");
				mem.setCreatetime(new Date());
				mem.setStutas("1");
				mem.setNum(1L);
				mem.setZengsongtype(member.getIstop());
				memeberDeailMapper.insertSelective(mem);

				// 金米返现开始
//				JiesuanItem jit = new JiesuanItem();
//				jit.setId(ToolsUtil.getUUID());
//				jit.setMemberId(member.getId());
//				jit.setCount(25D);
//				jit.setRemark(member.getUsername() + "升级会员，提供金米返现奖励");
//				jit.setCreatetime(new Date());
//				jit.setNum(40L);
//				jiesuanItemMapper.insertSelective(jit);
				
				CashBackTask task=new CashBackTask();
				task.setMemberId(member.getId());
				task.setMemberName(member.getUsername());
				task.setBackKey("2");   //返现类型：1商品返现，2升级返现
				task.setBackValue(advanceLogs2.getId()); //logid
				task.setRemark(member.getUsername() + "升级会员，提供金米返现奖励");
				task.setAmount(new BigDecimal(25D));
				task.setTotalBalance(new BigDecimal(40*25));
				task.setTotalNumber(40);
				taskService.insertCashBackTask(task);
				
				if (member.getShangjiId() != null && member.getShangjiId() != "") {

					List<Member> list1 = memberMapper.gainMemberByShangjiId(member.getShangjiId());
					if (list1.size() == 1) {
						Member smMember = list1.get(0);
						MemeberDeail memz = new MemeberDeail();
						memz.setId(ToolsUtil.getUUID());
						memz.setMemberid(smMember.getId());
						memz.setMembername(smMember.getUsername());
						memz.setMessage("一级下游【" + member.getUsername()+ "】升级998会员获得金米");
						memz.setCreatetime(new Date());
						memz.setZengsongtype(smMember.getIstop());
						memz.setStutas("1");

						XianjinbiDetail xianjinbiDetail = new XianjinbiDetail();
						xianjinbiDetail.setId(ToolsUtil.getUUID());
						xianjinbiDetail.setMemberId(smMember.getId());
						xianjinbiDetail.setRemark("一级下游【" + member.getUsername() + "】升级998会员获得金米");
						xianjinbiDetail.setCreatetime(new Date());
						xianjinbiDetail.setType((short) 0);
						xianjinbiDetail.setStatus("1");
						xianjinbiDetail.setPoint(99.8D);
						xianjinbiDetail.setBalance(smMember.getXianjinbi());
						XianjinbiMapper.insertSelective(xianjinbiDetail);
						smMember.setXianjinbi(smMember.getXianjinbi() + 99.8D);
						memberMapper.updateByPrimaryKeySelective(smMember);
						memz.setGuliangbinum(99.8);
						memeberDeailMapper.insertSelective(memz);

						List<Member> list2 = memberMapper.gainMemberByShangjiId(smMember.getShangjiId());
						if (list2.size() == 1) {
							Member ssMember = list2.get(0);
							if (smMember.getShangjiId() != null && smMember.getShangjiId() != "") {
								MemeberDeail mems = new MemeberDeail();
								mems.setId(ToolsUtil.getUUID());
								mems.setMemberid(ssMember.getId());
								mems.setMembername(ssMember.getUsername());
								mems.setMessage("二级下游 【" + member.getUsername() + "】 升级998会员获得金米");
								mems.setCreatetime(new Date());
								mems.setZengsongtype(ssMember.getIstop());
								mems.setStutas("1");

								XianjinbiDetail xianjinbiDetail2 = new XianjinbiDetail();
								xianjinbiDetail2.setId(ToolsUtil.getUUID());
								xianjinbiDetail2.setMemberId(ssMember.getId());
								xianjinbiDetail2.setRemark("二级下游【" + member.getUsername() + "】升级998会员获得金米");
								xianjinbiDetail2.setCreatetime(new Date());
								xianjinbiDetail2.setType((short) 0);
								xianjinbiDetail2.setStatus("1");
								xianjinbiDetail2.setPoint(99.8D);
								xianjinbiDetail2.setBalance(ssMember.getXianjinbi());
								XianjinbiMapper.insertSelective(xianjinbiDetail2);
								ssMember.setXianjinbi(ssMember.getXianjinbi() + 99.8D);
								memberMapper.updateByPrimaryKeySelective(ssMember);
								mems.setGuliangbinum(99.8);
								memeberDeailMapper.insertSelective(mems);

								List<Member> list3 = memberMapper.gainMemberByShangjiId(ssMember.getShangjiId());
								if (list3.size() == 1) {
									Member sssMember = list3.get(0);
									if (ssMember.getShangjiId() != null && ssMember.getShangjiId() != "") {
										MemeberDeail mem3 = new MemeberDeail();
										mem3.setId(ToolsUtil.getUUID());
										mem3.setMemberid(sssMember.getId());
										mem3.setMembername(sssMember.getUsername());
										mem3.setMessage("三级下游 【" + member.getUsername() + "】 升级998会员获得金米");
										mem3.setCreatetime(new Date());
										mem3.setZengsongtype(sssMember.getIstop());
										mem3.setStutas("1");

										XianjinbiDetail xianjinbiDetail3 = new XianjinbiDetail();
										xianjinbiDetail3.setId(ToolsUtil.getUUID());
										xianjinbiDetail3.setMemberId(sssMember.getId());
										xianjinbiDetail3.setRemark("三级下游【" + member.getUsername() + "】升级998会员获得金米");
										xianjinbiDetail3.setCreatetime(new Date());
										xianjinbiDetail3.setType((short) 0);
										xianjinbiDetail3.setStatus("1");
										xianjinbiDetail3.setPoint(99.8D);
										xianjinbiDetail3.setBalance(sssMember.getXianjinbi());
										XianjinbiMapper.insertSelective(xianjinbiDetail3);
										sssMember.setXianjinbi(sssMember.getXianjinbi() + 99.8D);
										memberMapper.updateByPrimaryKeySelective(sssMember);
										mem3.setGuliangbinum(99.8);
										memeberDeailMapper.insertSelective(mem3);
									}
								}
							}
						}
					}
				}
			}
			member.setEngageindustryname("升级成功");
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public void duihuan(String userId, Double dhcount, String dhtype) {
		Member member = memberMapper.selectByPrimaryKey(userId);
		if(dhtype.equals("1")){//金米转经验值、
			member.setXianjinbi(member.getXianjinbi()-dhcount);
			if(member.getXianjinbi()>0){
				member.setPoint(member.getPoint()+dhcount*1000);
				memberMapper.updateByPrimaryKeySelective(member);
				
				XianjinbiDetail xianjinbi = new XianjinbiDetail();
				xianjinbi.setId(ToolsUtil.getUUID());
				xianjinbi.setPoint(dhcount);
				xianjinbi.setMemberId(userId);
				xianjinbi.setRemark("兑换经验值消耗");
				xianjinbi.setCreatetime(new Date());
				xianjinbi.setBalance(member.getXianjinbi());
				xianjinbi.setType((short) 2);
				xianjinbi.setStatus("1");
				XianjinbiMapper.insertSelective(xianjinbi);
				PointDetail pointDetail2 =new PointDetail();
				pointDetail2.setId(ToolsUtil.getUUID());
				pointDetail2.setPoint(dhcount*1000);
				pointDetail2.setMemberId(userId);
				pointDetail2.setRemark("兑换金米所得");
				pointDetail2.setCreatetime(new Date());
				pointDetail2.setBalance(member.getPoint());
				pointDetail2.setType(0);
				pointDetailMapper.insertSelective(pointDetail2);
			}
		}else{ //金米转惠米
			member.setXianjinbi(member.getXianjinbi()-dhcount);
			//member.setAdvance(member.getAdvance()-dhcount);
			if(member.getXianjinbi()>0){
				member.setLiucunbi(member.getLiucunbi()+dhcount);
				memberMapper.updateByPrimaryKeySelective(member);
				
				XianjinbiDetail xianjinbi = new XianjinbiDetail();
				xianjinbi.setId(ToolsUtil.getUUID());
				xianjinbi.setPoint(dhcount);
				xianjinbi.setMemberId(userId);
				xianjinbi.setRemark("兑换惠米消耗");
				xianjinbi.setCreatetime(new Date());
				xianjinbi.setBalance(member.getXianjinbi());
				xianjinbi.setType((short) 2);
				xianjinbi.setStatus("1");
				XianjinbiMapper.insertSelective(xianjinbi);

				LiucunbiDetail liucunbiDetail  =  new LiucunbiDetail();
				liucunbiDetail.setId(ToolsUtil.getUUID());
				liucunbiDetail.setPoint(dhcount);
				liucunbiDetail.setMemberId(userId);
				liucunbiDetail.setRemark("兑换惠米所得");
				liucunbiDetail.setCreatetime(new Date());
				liucunbiDetail.setBalance(member.getLiucunbi());
				liucunbiDetail.setType((short) 0);
				liucunbiDetail.setStatus("1");
				liucunbiDetailMapper.insertSelective(liucunbiDetail);
			}
		}
	}

	@Override
	public List<Member> myYiji(Map<String,Object> map) {
		Member mem = memberMapper.gainMemberById(map.get("userId").toString());
		map.put("onlyId",mem.getOnlyId());
		List<Member> list  = memberMapper.gainMemberByO(map);
		return list;
	}

	@Override
	public List<Member> myErji(Map<String,Object> map) {
		Member mem = memberMapper.gainMemberById(map.get("userId").toString());
		map.put("onlyId",mem.getOnlyId());
		List<Member> memberList = memberMapper.xiaxiayou(map);
		return memberList;
	}

	@Override
	public List<Member> mySanji(Map<String, Object> map) {
		Member mem = memberMapper.gainMemberById(map.get("userId").toString());
		map.put("onlyId", mem.getOnlyId());
		List<Member> memberList = memberMapper.xiaxiaxiayou(map);
		return memberList;
	}

	@Override
	public Member tixian(String userId, Double maxPoint) {
		Member mem = memberMapper.gainMemberById(userId);
		if (maxPoint*100 > mem.getXianjinbi()) {
			throw new RuntimeException("金额不足，请确保有足够的金额可兑米!");
		}
		if(mem.getIsonline()==1){
			mem.setIsonline(0);
			String xianjinbiDetailId = ToolsUtil.getUUID();// 明细表主键id
			// 金米明细表数据操作
			XianjinbiDetail xianjin = new XianjinbiDetail();
			xianjin.setId(xianjinbiDetailId);
			xianjin.setMemberId(userId);
			xianjin.setBalance(Arith.sub(mem.getXianjinbi(), maxPoint*100));// 操作后余额
			xianjin.setPoint(maxPoint*100);
			xianjin.setCreatetime(new Date());
			Calendar calendar = Calendar.getInstance();
			Date date = new Date(System.currentTimeMillis());
			calendar.setTime(date);
			date = calendar.getTime();
			SimpleDateFormat time=new SimpleDateFormat("yyyy年 MM月 dd日 "); 
			if(mem.getType().equals("0")){
				xianjin.setRemark("用户在"+time.format(date)+"时，提取金米："+maxPoint*100+",实际转账金额："+maxPoint*100*0.9);
			}else{
				xianjin.setRemark("用户在"+time.format(date)+"时，提取金米："+maxPoint*100+",实际转账金额："+maxPoint*100*0.95);
			}
			xianjin.setType((short) 1); //0:获取，1：使用
			XianjinbiMapper.insertSelective(xianjin);
			
			// 金米兑米申请表是否重复提交验证  
			int count = 0;
			XianjinbiCashApply xianjinbiCashCheck = new XianjinbiCashApply();
			xianjinbiCashCheck.setMemberId(userId);
			xianjinbiCashCheck.setAmount(maxPoint*100); // 兑米金额
			if(mem.getType().equals("0")){
				// 普通会员
				xianjinbiCashCheck.setRealAmount(maxPoint*100*0.9); // 实际到账
				xianjinbiCashCheck.setLiucunAmount(maxPoint*100*0.1);// 惠米
			}else{
				// vip会员
				xianjinbiCashCheck.setRealAmount(maxPoint*100*0.95); // 实际到账(扣完惠米)
				xianjinbiCashCheck.setLiucunAmount(maxPoint*100*0.05); // 惠米
			}
			xianjinbiCashCheck.setBankUser(mem.getTruename());
			xianjinbiCashCheck.setBankAccount(mem.getInterest());
			xianjinbiCashCheck.setBankAddress(mem.getVocation());
			xianjinbiCashCheck.setStatus("0");
			Date operDate = new Date();
			operDate.setTime(operDate.getTime() - 60000);
			xianjinbiCashCheck.setCreateTime(operDate);
			
			count = xianjinbiCashApplyMapper.repeatabilityCheck(xianjinbiCashCheck);
			if (count > 0) {
				throw new RuntimeException("请勿重复提交");
			}

			// 金米兑米申请表数据操作
			XianjinbiCashApply xianjinbiCash = new XianjinbiCashApply();
			xianjinbiCash.setId(ToolsUtil.getUUID());
			xianjinbiCash.setMemberId(userId);
			xianjinbiCash.setXianjinbiDetailId(xianjinbiDetailId);
			xianjinbiCash.setAmount(maxPoint*100); // 兑米金额
			if(mem.getType().equals("0")){
				// 普通会员
				xianjinbiCash.setRealAmount(maxPoint*100*0.9); // 实际到账
				xianjinbiCash.setLiucunAmount(maxPoint*100*0.1);// 惠米
			}else{
				// vip会员
				xianjinbiCash.setRealAmount(maxPoint*100*0.95); // 实际到账(扣完惠米)
				xianjinbiCash.setLiucunAmount(maxPoint*100*0.05); // 惠米
			}
			xianjinbiCash.setBankUser(mem.getTruename());
			xianjinbiCash.setBankAccount(mem.getInterest());
			xianjinbiCash.setBankAddress(mem.getVocation());
			xianjinbiCash.setStatus("0");
			xianjinbiCash.setRemark("金米兑米申请");
			xianjinbiCash.setCreateTime(new Date());
			xianjinbiCashApplyMapper.insertSelective(xianjinbiCash);
			
			// 用户表操作 （把兑米的金额从总的金额中减去）
			mem.setXianjinbi(Arith.sub(mem.getXianjinbi(), maxPoint*100)); 
			memberMapper.updateByPrimaryKeySelective(mem);
			
			mem.setEngageindustryname("兑米操作成功！！");
		}else{
			mem.setEngageindustryname("操作无效");
		}
		return mem;
	}

	@Override
	public Integer dejiang() {
		List<Zhuanpan> zList = zhuanpanMapper.gainAll();
		String product="0,1,2,3,4,5,6";
		 String num = "";
		 double baseNum = 0.99;
		 for (int i = 0; i < zList.size(); i++) {
			if(i!=(zList.size()-1)){
				num = num+zList.get(i).getGailv()+",";
			}else{
				num = num+zList.get(i).getGailv();
			}
		}
	        String[] p = product.split(",");
	        String[] n = num.split(",");
	 
	        java.util.Random ran = new java.util.Random();
	        double base = ran.nextDouble();
	 
	        if (base > baseNum) {
	            return 0;
	        }
	 
	        List<String> list = new ArrayList<String>();
	        for (int i = 0; i < p.length; i++) {
	            for (int j = 0; j < Integer.parseInt(n[i]); j++) {
	                list.add(p[i]);
	            }
	        }
	                // 打乱奖池数据
	        int l = ran.nextInt(list.size());
	        l =Integer.parseInt(list.get(l));
		return l;
	}

	@Override
	public void zhuanpanrizhi(String id,String zhuanpanId) {
		//采用硬性绑定id来处理中奖的情况
		if ("6".equals(zhuanpanId)) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dayStr = df.format(new Date());
			Member m = memberMapper.gainMemberById(id);
			if (!this.hasLuckDraw(id, dayStr)) {
				ZhuanpanLog log =new ZhuanpanLog();
				log.setId(ToolsUtil.getUUID());
				log.setCreatetime(new Date());
				log.setMemberId(id);
				log.setRamark(dayStr + "经验值抽奖,获得经验值奖励");
				log.setPoint(20D);
				log.setZhuanpanId(zhuanpanId);
				zhuanpanLogMapper.insertSelective(log);
				
				PointDetail p2 = new PointDetail();
				p2.setId(ToolsUtil.getUUID());
				p2.setBalance(m.getPoint());
				p2.setCreatetime(new Date());
				p2.setMemberId(m.getId());
				p2.setRemark("抽奖获得经验值");
				p2.setType(0);
				p2.setPoint(20D);
				pointDetailMapper.insertSelective(p2);
				m.setPoint(m.getPoint()+ 20);
				
				memberMapper.updateByPrimaryKeySelective(m);
			}else {
				
			}
			
		}
	}

	/**
	 * 今天是否已抽奖
	 * 根据用户的id和日期戳来验证
	 * @param id
	 * @param dayStr
	 * @return true 标识已抽奖，false：未抽奖
	 */
	public boolean hasLuckDraw(String userId, String dayStr){
		
		List<ZhuanpanLog> list = zhuanpanLogMapper.getByMultiCondition(userId, dayStr + "%");
		
		return list!= null && list.size() > 0;
	}
	
	@Override
	public Long myYijiCount(Map<String, Object> map) {
		return memberMapper.myYijiCount(map);
	}
	@Override
	public Long myErjiCount(Map<String, Object> map) {
		return memberMapper.myErjiCount(map);
	}

	@Override
	public Long mySanjiCount(Map<String, Object> map) {
		return memberMapper.mySanjiCount(map);
	}

	@Override
	public List<XianjinbiDetail> xianjinbi(Map<String, Object> map) {
		List<XianjinbiDetail> meml = XianjinbiMapper.gainListByMemberId(map);
		for(XianjinbiDetail detail : meml) {
			String remark = detail.getRemark();
			if(detail.getType() == 1 && remark != null) {
				// 0获取，1使用，2兑换；10消费，11兑米
				if(remark.indexOf("购买") != -1) {
					detail.setType((short) 10);
				}
				else if(remark.indexOf("提取") != -1) {
					detail.setType((short) 11);
				}
			}
		}
		return meml;
	}

	@Override
	public Long xianjinbiCount(Map<String, Object> map) {
		return XianjinbiMapper.gainListByMemberIdCount(map);
	} 
	
	@Override
	public List<XianjinbiCashApply> xianjinbiCashList(Map<String, Object> map) {
		List<XianjinbiCashApply> xianjinbiCash = xianjinbiCashApplyMapper.gainXianjinbiCashList(map);
		return xianjinbiCash;
	}
	
	@Override
	public Long xianjinbiCashCount(Map<String, Object> map) {
		return xianjinbiCashApplyMapper.gainXianjinbiCashCount(map);
	}

	@Override
	public List<LiucunbiDetail> liucunbi(Map<String, Object> map) {
		List<LiucunbiDetail> meml = liucunbiDetailMapper.gainListByMemberId(map);
		return meml;
	}

	@Override
	public Long liucunbiCount(Map<String, Object> map) {
		return liucunbiDetailMapper.gainListByMemberIdCount(map);
	}
}