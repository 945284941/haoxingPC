/**   
 * @Title: MyParticipationServiceImpl.java 
 * @Package com.qlzy.memberCenter.person.myParticipation.service.impl 
 * @Description: TODO(我的参与管理接口实现类) 
 * @author wangmei   
 * @date 2013-10-6 下午2:28:31 
 * @version V1.0   
 */
package com.qlzy.memberCenter.person.myParticipation.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.memberCenter.common.dao.InstationMessageMapper;
import com.qlzy.memberCenter.common.dao.PptDeptMapper;
import com.qlzy.memberCenter.common.dao.PptDeptUsersMapper;
import com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService;
import com.qlzy.model.Company;
import com.qlzy.model.InstationMessage;
import com.qlzy.model.Member;
import com.qlzy.model.PptDept;
import com.qlzy.model.PptDeptUsers;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.Constant;
import com.qlzy.util.Pagination;

@Service("myParticipationService")
@Transactional(rollbackFor = Exception.class)
public class MyParticipationServiceImpl implements MyParticipationService {

	@Resource
	private InstationMessageMapper instationMessageMapper;
	@Resource
	private MemberMapper memberMapper;
	@Resource
	private PptDeptMapper pptDeptMapper;
	@Resource
	private PptDeptUsersMapper pptDeptUsersMapper;
	@Resource
	private CompanyMapper companyMapper;

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: MyParticipationServiceImpl.java
	 * @Description: TODO(根据ID查询站内短信详细信息)
	 * @param id
	 * @return
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#gainInstationMessageById(java.lang.String)
	 */
	@Override
	public InstationMessage gainInstationMessageById(String id) {
		return instationMessageMapper.gainById(id);
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: MyParticipationServiceImpl.java
	 * @Description: TODO(发送站内短信，同时双方互加好友)
	 * @param instationMessage
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#addInstationMessage(com.qlzy.model.InstationMessage)
	 */
	@Override
	public void addInstationMessage(InstationMessage instationMessage) {
		instationMessage.setId(ToolsUtil.getUUID());
		instationMessage.setType(1);
		instationMessage.setCreatetime(new Date());
		instationMessageMapper.addInstationMessage(instationMessage);// 添加站内短信

		int a = 0;
		List<PptDeptUsers> pptDeptUsers = pptDeptUsersMapper
				.gainPptDeptUsersByUserId(instationMessage.getFromId());// 获取发送人的好友列表
		if (pptDeptUsers != null && pptDeptUsers.size() > 0) {
			for (int i = 0; i < pptDeptUsers.size(); i++) {
				if (pptDeptUsers.get(i).getUserId()
						.equals(instationMessage.getToId())) {// 循环判断被发送人是否已是自己的好友，如是自己好友，将a的值加1
					a++;
				}
			}
		}
		if (a == 0) {// 当a等于0时，说明被发送人还不是自己好友，将被发送人添加为自己的好友，同时被发送人也将自己添加为他的好友
			List<PptDept> from_pptDepts = pptDeptMapper
					.gainPptDeptsByUserId(instationMessage.getFromId());// 获取发送人的好友分组
			List<PptDept> to_pptDepts = pptDeptMapper
					.gainPptDeptsByUserId(instationMessage.getToId());// 获取被发送人的好友分组
			if ((from_pptDepts != null && from_pptDepts.size() > 0)
					&& (to_pptDepts != null && to_pptDepts.size() > 0)) {
				PptDeptUsers from_pdu = new PptDeptUsers();
				from_pdu.setId(ToolsUtil.getUUID());
				from_pdu.setDeptId(from_pptDepts.get(0).getId());
				from_pdu.setUserId(instationMessage.getToId());
				from_pdu.setUserType(instationMessage.getUserType());
				pptDeptUsersMapper.addPptDeptUsers(from_pdu);// 添加被发送人为好友

				PptDeptUsers to_pdu = new PptDeptUsers();
				to_pdu.setId(ToolsUtil.getUUID());
				to_pdu.setDeptId(to_pptDepts.get(0).getId());
				to_pdu.setUserId(instationMessage.getFromId());
				to_pdu.setUserType(instationMessage.getToUserType());
				pptDeptUsersMapper.addPptDeptUsers(to_pdu);// 添加发送人为好友
			}
		}
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: MyParticipationServiceImpl.java
	 * @Description: TODO(根据用户名查询信息)
	 * @param userName
	 * @return
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#gainMemberByUsername(java.lang.String)
	 */
	@Override
	public Member gainMemberByUsername(String userName) {
		return memberMapper.gainMemberByUsername(userName);
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: MyParticipationServiceImpl.java
	 * @Description: TODO(单条或批量删除站内短信(逻辑删除))
	 * @param ids
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#deleteInstationMessage(java.util.List)
	 */
	@Override
	public void deleteInstationMessage(List<String> ids) {
		instationMessageMapper.deleteInstationMessage(ids);
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: MyParticipationServiceImpl.java
	 * @Description: TODO(单条或批量删除站内短信(物理删除))
	 * @param ids
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#dropInstationMessage(java.util.List)
	 */
	@Override
	public void dropInstationMessage(List<String> ids) {
		instationMessageMapper.dropInstationMessage(ids);
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: MyParticipationServiceImpl.java
	 * @Description: TODO(根据用户ID查询其好友)
	 * @param userId
	 * @return
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#gainPptDeptUsersByUserId(java.lang.String)
	 */
	@Override
	public List<PptDeptUsers> gainPptDeptUsersByUserId(String userId) {
		List<PptDeptUsers> list = pptDeptUsersMapper
				.gainPptDeptUsersByUserId(userId);
		List<PptDeptUsers> removeUsers = new ArrayList<PptDeptUsers>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				PptDeptUsers pptDeptUsers = list.get(i);
				if ("member".equals(pptDeptUsers.getUserType())) {
					Member member = memberMapper.gainMemberById(pptDeptUsers
							.getUserId());
					if (null != member) {
						pptDeptUsers.setUserName(member.getUsername());
					} else {
						removeUsers.add(pptDeptUsers);
					}
				} else {
//					Company company = companyMapper.selectById(pptDeptUsers
//							.getUserId());
//					if (null != company) {
//						pptDeptUsers.setUserName(company.getUsername());
//					} else {
//						removeUsers.add(pptDeptUsers);
//					}
				}
			}
			list.removeAll(removeUsers);
		}
		return list;
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: MyParticipationServiceImpl.java
	 * @Description: TODO(根据用户名查询企业信息)
	 * @param userName
	 * @return
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#gainCompanyByUserName(java.lang.String)
	 */
	@Override
	public Company gainCompanyByUserName(String userName) {
//		return companyMapper.gainCompanyByUserName(userName);
		return null;
	}

	/** (非 Javadoc) 
	 * @Title: MyParticipationServiceImpl.java 
	 * @Description: TODO(站内短信状态修改)  
	 * @param instationMessage 
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#updateInstationMessage(com.qlzy.model.InstationMessage) 
	 */
	@Override
	public void updateInstationMessage(InstationMessage instationMessage) {
		instationMessageMapper.updateInstationMessage(instationMessage);
	}

	/** (非 Javadoc) 
	 * @Title: MyParticipationServiceImpl.java 
	 * @Description: TODO(根据会员ID查询站内短信列表)  
	 * @param pagination
	 * @param userId
	 * @param isReceive
	 * @param name
	 * @return 
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#gainInstationMessagesByUserId(com.qlzy.util.Pagination, java.lang.String, java.lang.String, java.lang.String) 
	 */
	@Override
	public List<InstationMessage> gainInstationMessagesByUserId(
			Pagination pagination, String userId, String isReceive, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		map.put("userId", userId);
		map.put("isReceive", isReceive);
		map.put("name", name);
		return instationMessageMapper.gainInstationMessagesByUserId(map);
	}

	/** (非 Javadoc) 
	 * @Title: MyParticipationServiceImpl.java 
	 * @Description: TODO(根据会员ID查询站内短信总记录数)  
	 * @param userId
	 * @param isReceive
	 * @param name
	 * @return 
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#gainInstationMessageCountByUserId(java.lang.String, java.lang.String, java.lang.String) 
	 */
	@Override
	public Long gainInstationMessageCountByUserId(String userId,
			String isReceive, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("isReceive", isReceive);
		map.put("name", name);
		return instationMessageMapper.gainInstationMessageCountByUserId(map);
	}
	
	/** (非 Javadoc) 
	 * @Title:gainInviteFriendsByUserId 
	 * @Description: TODO(根据用户ID查询邀请好友数)  
	 * @param sessionInfo
	 * @return 
	 * @see com.qlzy.memberCenter.statistics.service.StatisticsService#gainInviteFriendsByUserId(com.qlzy.pojo.SessionInfo) 
	 */
	@Override
	public Long gainInviteFriendsByUserId(SessionInfo sessionInfo) {
		if(Constant.USERTYPE_MEMBER.equals(sessionInfo.getUserType())){
			return memberMapper.gainInviteFriendsByMemberId(sessionInfo.getUserId());
		}else{
//			return companyMapper.gainInviteFriendsByCompanyId(sessionInfo.getUserId());
			return null;
		}
	}

	/**
	 * (非 Javadoc) 
	 * @Title:gainInstationMessageCountByUserId 
	 * @Description: TODO(根据用户ID查询收到已未读/发送的站内短信数)  
	 * @param userId
	 * @return 
	 * @see com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService#gainInstationMessageCountByUserId(java.lang.String)
	 */
	@Override
	public StatisticsInfo gainInstationMessageCountByUserId(String userId) {
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("isReceive", 0);
		statisticsInfo.setReceiveCount(instationMessageMapper.gainInstationMessageCountByUserId(paramMap));
		paramMap.put("status", 1);
		statisticsInfo.setAlreadyReadCount(instationMessageMapper.gainInstationMessageCountByUserId(paramMap));
		paramMap.put("status", 0);
		statisticsInfo.setNoReadCount(instationMessageMapper.gainInstationMessageCountByUserId(paramMap));
		paramMap.put("status", null);
		paramMap.put("isReceive", 1);
		statisticsInfo.setSendCount(instationMessageMapper.gainInstationMessageCountByUserId(paramMap));
		return statisticsInfo;
	}

}