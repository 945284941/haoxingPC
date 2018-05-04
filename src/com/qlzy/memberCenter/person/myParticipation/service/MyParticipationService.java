/**   
 * @Title: MyParticipationService.java 
 * @Package com.qlzy.memberCenter.person.myParticipation.service 
 * @Description: TODO(我的参与管理接口类) 
 * @author wangmei   
 * @date 2013-10-6 下午2:27:27 
 * @version V1.0   
 */
package com.qlzy.memberCenter.person.myParticipation.service;

import java.util.List;

import com.qlzy.model.Company;
import com.qlzy.model.InstationMessage;
import com.qlzy.model.Member;
import com.qlzy.model.PptDeptUsers;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.Pagination;


public interface MyParticipationService {

	/**
	 * @Title: gainInstationMessagesByUserId
	 * @Description: TODO(根据会员ID查询站内短信列表) 
	 * @param @param pagination
	 * @param @param userId
	 * @param @param isReceive
	 * @param @param name
	 * @param @return    设定文件 
	 * @return List<InstationMessage> 返回类型 
	 * @author wangmei
	 */
	public List<InstationMessage> gainInstationMessagesByUserId(Pagination pagination, 
			String userId, String isReceive, String name);
	
	/**
	 * @Title: gainInstationMessageCountByUserId
	 * @Description: TODO(根据会员ID查询站内短信总记录数) 
	 * @param @param userId
	 * @param @param isReceive
	 * @param @param name
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	public Long gainInstationMessageCountByUserId(String userId, String isReceive, String name);
	
	/**
	 * @Title: gainInstationMessageById
	 * @Description: TODO(根据ID查询站内短信详细信息) 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return InstationMessage 返回类型 
	 * @author wangmei
	 */
	public InstationMessage gainInstationMessageById(String id);
	
	/**
	 * @Title: addInstationMessage
	 * @Description: TODO(发送站内短信，同时双方互加好友) 
	 * @param @param instationMessage    设定文件 
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void addInstationMessage(InstationMessage instationMessage);
	
	/**
	 * @Title: updateInstationMessage
	 * @Description: TODO(站内短信状态修改) 
	 * @param @param instationMessage    设定文件 
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void updateInstationMessage(InstationMessage instationMessage);
	
	/**
	 * @Title: gainMemberByUsername
	 * @Description: TODO(根据用户名查询信息) 
	 * @param @param userName
	 * @param @return    设定文件 
	 * @return Member 返回类型 
	 * @author wangmei
	 */
	public Member gainMemberByUsername(String userName);
	
	/**
	 * @Title: deleteInstationMessage
	 * @Description: TODO(单条或批量删除站内短信(逻辑删除)) 
	 * @param @param ids    设定文件 
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void deleteInstationMessage(List<String> ids);
	
	/**
	 * @Title: dropInstationMessage
	 * @Description: TODO(单条或批量删除站内短信(物理删除)) 
	 * @param @param ids    设定文件 
	 * @return void 返回类型 
	 * @author wangmei
	 */
	public void dropInstationMessage(List<String> ids);
	
	/**
	 * @Title: gainPptDeptUsersByUserId
	 * @Description: TODO(根据用户ID查询其好友) 
	 * @param @param userId
	 * @param @return    设定文件 
	 * @return List<PptDeptUsers> 返回类型 
	 * @author wangmei
	 */
	public List<PptDeptUsers> gainPptDeptUsersByUserId(String userId);
	
	/**
	 * @Title: gainCompanyByUserName
	 * @Description: TODO(根据用户名查询企业信息) 
	 * @param @param userName
	 * @param @return    设定文件 
	 * @return Company 返回类型 
	 * @author wangmei
	 */
	public Company gainCompanyByUserName(String userName);
	
	/**
	 * @Title: gainInviteFriendsByUserId
	 * @Description: TODO(根据用户ID查询邀请好友数) 
	 * @param @param sessionInfo
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	public Long gainInviteFriendsByUserId(SessionInfo sessionInfo);
	
	/**
	 * @Title: gainInstationMessageCountByUserId
	 * @Description: TODO(根据用户ID查询收到已未读/发送的站内短信数) 
	 * @param @param userId
	 * @param @return    设定文件 
	 * @return StatisticsInfo 返回类型 
	 * @author wangmei
	 */
	public StatisticsInfo gainInstationMessageCountByUserId(String userId);
}
