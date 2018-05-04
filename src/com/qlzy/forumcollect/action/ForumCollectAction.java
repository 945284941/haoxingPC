package com.qlzy.forumcollect.action;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.forum.service.ForumService;
import com.qlzy.forumcollect.service.ForumCollectService;
import com.qlzy.model.Forum;
import com.qlzy.model.ForumCollect;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
@Namespace("/")
@Action(value = "forumCollect", results = {
		@Result(name = "hysq", location = "/admin/hysq/hysqIndex.jsp"),
		@Result(name = "toMoreHuiTie", location = "/admin/hysq/gengduo.jsp")
})
public class ForumCollectAction extends BaseAction{

	/**
	 * 
	 */
	private static final Logger logger = Logger
			.getLogger(ForumCollectAction.class);
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private ForumCollectService forumCollectService;
	@Autowired
	private ForumService forumService;
	
	private ForumCollect forumCollect;
	
	private SessionInfo sessionInfo = new SessionInfo();

	/**
	 * 收藏帖子操作
	 * 
	 * @Title: forumCollect
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 王乔良
	 */
	public void forumCollect() {
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil
					.getSessionInfoName());
			if (sessionInfo != null) {	
				// 用户登录情况下加入收藏
				
				String Id = request.getParameter("id");
				ForumCollect forumCollect = new ForumCollect();
				String id = ToolsUtil.getUUID();
				forumCollect.setId(id);
				forumCollect.setForumId(Id);
				forumCollect.setUserId(sessionInfo.getUserId());
				forumCollect.setUserType(sessionInfo.getUserType());
				forumCollect.setCollectIp(sessionInfo.getIp());
				forumCollect.setCollectTime(new Date());
				Forum forum = new Forum();
				forum.setId(Id);
				forum = forumService.selectByShouCang(forum);
				forum.setVisits(forum.getVisits()+1);
				forumService.updateByVisits(forum);
				forumCollectService.addCollect(forumCollect);
				
			} else {
				// 用户不登陆情况下的
				logger.error("用户未登录(Session中未获取到用户的信息)，收藏帖子失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ForumCollect getForumCollect() {
		return forumCollect;
	}

	public void setForumCollect(ForumCollect forumCollect) {
		this.forumCollect = forumCollect;
	}

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

}
