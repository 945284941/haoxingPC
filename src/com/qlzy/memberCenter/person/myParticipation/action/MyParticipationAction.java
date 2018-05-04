/**   
 * @Title: MyParticipationAction.java 
 * @Package com.qlzy.memberCenter.person.myParticipation 
 * @Description: TODO(我的参与管理) 
 * @author wangmei   
 * @date 2013-10-6 下午2:25:04 
 * @version V1.0   
 */
package com.qlzy.memberCenter.person.myParticipation.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.email.util.GenerateLinkUtils;
import com.qlzy.memberCenter.person.myParticipation.service.MyParticipationService;
import com.qlzy.model.Company;
import com.qlzy.model.InstationMessage;
import com.qlzy.model.Member;
import com.qlzy.model.PptDeptUsers;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

@Namespace("/person")
@Action(value = "myParticipation", results = {
		@Result(name = "toShareFriends", location = "/memberCenter/person/myParticipation/shareFriends.jsp"),
		@Result(name = "gainInstationMessageList", location = "/memberCenter/person/myParticipation/instationMessage.jsp"),
		@Result(name = "addInstationMessageOk", type = "redirect", location = "/person/myParticipation/instationMessageList.html") })
public class MyParticipationAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private MyParticipationService myParticipationService;

	private List<InstationMessage> instationMessageList;// 站内短信列表
	private InstationMessage instationMessage;// 站内短信实体类

	/**
	 * @Title: toShareFriends
	 * @Description: TODO(生成新链接并跳转分享好友页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String toShareFriends() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		String friendUrl = GenerateLinkUtils.generateResetNewUrlForWebsite(sessionInfo);
		Long inviteCount = myParticipationService.gainInviteFriendsByUserId(sessionInfo);
		request.setAttribute("friendUrl", friendUrl);
		request.setAttribute("inviteCount", inviteCount);
		return "toShareFriends";
	}

	/**
	 * @Title: gainInstationMessageList
	 * @Description: TODO(站内短信列表)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String gainInstationMessageList() {
		String isReceive = request.getParameter("isReceive");
		String name = request.getParameter("m_name");
		String userId = "";
		Member member = myParticipationService
				.gainMemberByUsername(name);
		Company company = myParticipationService
				.gainCompanyByUserName(name);
		if (null == member && null == company) {// 好友不存在
			userId = "";
		} else {// 好友存在
			if (null != member) {// 其为个人会员
				userId = member.getId();
			}
			if (null != company) {// 其为企业会员
				userId = company.getId();
			}
		}		
		if (null == isReceive || "".equals(isReceive)) {
			isReceive = "0";
		}
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());

		Pagination pagination = definationPagination(request);
		pagination.setRows(10L);

		pagination.setTotalCount(myParticipationService
				.gainInstationMessageCountByUserId(sessionInfo.getUserId(),
						isReceive, userId));
		instationMessageList = myParticipationService
				.gainInstationMessagesByUserId(pagination,
						sessionInfo.getUserId(), isReceive, userId);
		request.setAttribute("pagination", pagination);
		request.setAttribute("isReceive", isReceive);
		request.setAttribute("name", name);
		request.setAttribute("mesCount", myParticipationService.gainInstationMessageCountByUserId(sessionInfo.getUserId()));
		return "gainInstationMessageList";
	}

	/**
	 * @Title: toShowDetailInstationMessage
	 * @Description: TODO(跳转查看站内短信详细信息页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public void toShowDetailInstationMessage() {
		String id = String.valueOf(request.getParameter("id"));
		instationMessage = myParticipationService.gainInstationMessageById(id);
		if (null != instationMessage) {
			if (0 == instationMessage.getStatus()) {// 0-未读，1-已读
				InstationMessage im = new InstationMessage();
				im.setId(id);
				im.setStatus(1);// 将站内短信状态设置为已读
				myParticipationService.updateInstationMessage(im);
			}
		}
		writeJson(instationMessage);
	}

	/**
	 * @Title: addInstationMessage
	 * @Description: TODO(站内短信发送)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public String addInstationMessage() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (null != instationMessage.getToId1()
					&& !"".equals(instationMessage.getToId1())) {
				instationMessage.setToId(instationMessage.getToId1());
			}
			if (null != instationMessage.getToId2()
					&& !"".equals(instationMessage.getToId2())) {
				instationMessage.setToId(instationMessage.getToId2());
			}
			myParticipationService.addInstationMessage(instationMessage);// 添加站内短信
			map.put("success", true);
			map.put("msg", "站内短信发送成功！");
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "站内短信发送失败！");
			logger.error("addInstationMessage", e);
			e.printStackTrace();
		}
		return "addInstationMessageOk";
	}

	/**
	 * @Title: gainIsExistMember
	 * @Description: TODO(查询验证用户是否存在)
	 * @param 设定文件
	 * @return void 返回类型
	 * @author wangmei
	 */
	public void gainIsExistMember() {
		Map<String, Object> map = new HashMap<String, Object>();
		String username = String.valueOf(request.getParameter("username"));// 用户名
		String userId = String.valueOf(request.getParameter("userId"));// 用户ID
		try {
			Member member = myParticipationService
					.gainMemberByUsername(username);
			Company company = myParticipationService
					.gainCompanyByUserName(username);
			if (null == member && null == company) {// 好友不存在
				map.put("success", false);
				map.put("msg", "您填写的好友不存在！");
			} else {// 好友存在时，判断好友是个人会员还是企业会员
				if (null != member) {// 其为个人会员时，判断发短信之人是否为本人
					if (member.getId().equals(userId)) {
						map.put("success", false);
						map.put("msg", "您不能给自己发送站内短信！");
					} else {
						map.put("success", true);
						map.put("users", member);
						map.put("userType", "member");
					}
				}
				if (null != company) {// 其为企业会员时，判断发短信之人是否为本人
					if (company.getId().equals(userId)) {
						map.put("success", false);
						map.put("msg", "您不能给自己发送站内短信！");
					} else {
						map.put("success", true);
						map.put("users", company);
						map.put("userType", "company");
					}
				}
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "查询验证用户异常！");
			logger.error("gainIsExistMember", e);
			e.printStackTrace();
		}
		writeJson(map);
	}

	/**
	 * @Title: deleteInstationMessage
	 * @Description: TODO(单条或批量删除站内短信(逻辑删除))
	 * @param 设定文件
	 * @return void 返回类型
	 * @author wangmei
	 */
	public void deleteInstationMessage() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String ids = request.getParameter("ids");
			myParticipationService.deleteInstationMessage(ToolsUtil
					.StringConvertList(ids));
			map.put("success", true);
			map.put("msg", "站内短信删除成功！");
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "站内短信删除失败！");
			logger.error("deleteInstationMessage() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(map);
	}

	/**
	 * @Title: updateStatusForInstationMessage
	 * @Description: TODO(修改站内短信查看状态)
	 * @param 设定文件
	 * @return void 返回类型
	 * @author wangmei
	 */
	public void updateStatusForInstationMessage() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			myParticipationService.gainPptDeptUsersByUserId(sessionInfo
					.getUserId());
		} catch (Exception e) {
			logger.error("updateStatusForInstationMessage() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(map);
	}

	/**
	 * @Title: gainPptUsers
	 * @Description: TODO(获取我的好友列表)
	 * @param 设定文件
	 * @return void 返回类型
	 * @author wangmei
	 */
	public void gainPptUsers() {
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil
				.getSessionInfoName());
		List<PptDeptUsers> list = myParticipationService
				.gainPptDeptUsersByUserId(sessionInfo.getUserId());
		writeJson(list);
	}

	public List<InstationMessage> getInstationMessageList() {
		return instationMessageList;
	}

	public void setInstationMessageList(
			List<InstationMessage> instationMessageList) {
		this.instationMessageList = instationMessageList;
	}

	public InstationMessage getInstationMessage() {
		return instationMessage;
	}

	public void setInstationMessage(InstationMessage instationMessage) {
		this.instationMessage = instationMessage;
	}
}
