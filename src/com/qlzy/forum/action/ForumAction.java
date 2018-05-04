package com.qlzy.forum.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.common.tools.URLDecoderTwice;
import com.qlzy.forum.service.ForumService;
import com.qlzy.model.Forum;
import com.qlzy.model.News;
import com.qlzy.pojo.Json;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

@Namespace("/forum")
@Action(value = "forumAction", results = {
		@Result(name = "hysq", location = "/admin/hysq/hysqIndex.jsp"),
		@Result(name = "toMoreHuiTie", location = "/admin/hysq/gengduo.jsp"),
		@Result(name = "zxrt", location = "/admin/huitie/HuiTieIndex.jsp"),
		@Result(name = "MyForum", location = "/memberCenter/person/forum/myforum.jsp"),
		@Result(name = "uploadPage", location = "/uploader.jsp"),
		@Result(name = "fatie", location = "/memberCenter/person/forum/forumSend.jsp")
})
public class ForumAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1231118973089103507L;
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private ForumService forumService;
	private Forum forum;
	private Map<String, Object> map = new HashMap<String, Object>();
	private List<?> list;
	private String type;
	private SessionInfo sessionInfo ;
	
	
	public String toHysqIndex(){
		Forum temp=new Forum();
		temp.setId("");
		Map<String, Object> newsCatMap = new HashMap<String, Object>();
		Map<String, Object> param;
		newsCatMap.put("0", "0");
		newsCatMap.put("1", "1");
		newsCatMap.put("2", "2");
		newsCatMap.put("3", "3");
		newsCatMap.put("4", "4");
		newsCatMap.put("5", "5");
		
		for (int i = 0; i <= 5; i++) {
			param = new HashMap<String, Object>();
			param.put("type", String.valueOf(newsCatMap.get(i + "")));
			List<Forum> temp1 = forumService.gainHysqIndex(param);
					list = temp1.subList(0, temp1.size() > 6 ? 6 : temp1.size());
			map.put("forum_" + i, list);
		}
			return "hysq";
		}
	
	/**
	 * @Title: toMore
	 * @Description: 点击查看其他页面更多
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String toMoreHuiTie() {
		String Temp=request.getParameter("id");
		int index = Temp.indexOf("/");
		String temp = Temp.substring(index+1);
		type=URLDecoderTwice.decoder(temp);
		Map<String, Object> map1 = new HashMap<String, Object>();
		//Map<Integer, Object> Forum = new HashMap<Integer, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(12L);// 设置每页显示几条数据
		map1.put("type", type);
		map1.put("page", (pagination.getPage()-1)*pagination.getRows() );
		map1.put("rows", pagination.getRows());
		list = forumService.gainMoreForum(map1);
		pagination.setTotalCount(forumService
				.gainMoreForumCount(map1));
		request.setAttribute("pagination", pagination);
		request.setAttribute("id", temp);
		List<Forum> zuixinList = forumService.gainZuixin(6);
		map.put("zuixin",zuixinList);
		return "toMoreHuiTie";
	}
	
	public String MyForum(){
		Forum temp=new Forum();
		temp.setId("");
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> MyForum = new HashMap<String, Object>();
		Map<String, Object> param;
		MyForum.put("0", sessionInfo.getUserId());
		for (int i = 0; i <= 0; i++) {
			param = new HashMap<String, Object>();
			param.put("userId", String.valueOf(MyForum.get(i + "")));
			
			List<Forum> temp1 = forumService.MyForum(param);
					list = temp1.subList(0, temp1.size() > 12 ? 12 : temp1.size());
			map.put("myforum_" + i, list);
		}
		
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		//Map<Integer, Object> Forum = new HashMap<Integer, Object>();
		Map<Integer, Object> forum = new HashMap<Integer, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(6L);// 设置每页显示几条数据
		map1.put("userId", sessionInfo.getUserId());
		map1.put("page", (pagination.getPage()-1)*pagination.getRows() );
		map1.put("rows", pagination.getRows());
		list = forumService.MyForumList(map1);
		pagination.setTotalCount(forumService
				.MyForumListCount(map1));
		request.setAttribute("pagination", pagination);
		request.setAttribute("ncn", temp);
		request.setAttribute("forum",forum);
		//request.setAttribute("ForumList_",list);
		
		
		
		return "MyForum";
		
	}
	
	public String MyForumSend(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Json j = new Json();
		try {
			forum.setId(ToolsUtil.getUUID());
			forum.setCreateTime(new Date());
			forum.setUserId(sessionInfo.getUserId());
			forum.setUserName(sessionInfo.getLoginName());
			forumService.InsertForum(forum);
				j.setMsg("发帖成功");
				j.setSuccess(true);		
		} catch (Exception e) {
			// TODO: handle exception
			j.setMsg("发帖失败");
			j.setSuccess(false);
			e.printStackTrace();
		}		
		return "fatie";
	}
	
	public void praiseAdd(){		
		Json j = new Json();
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			Forum forum = new Forum();
			/*if(sessionInfo==null){
				j.setMsg("请先登录再点赞");
				j.setSuccess(false);
			}else{*/
				forum.setId(request.getParameter("id"));
				forum = forumService.selectById(forum);
				forum.setPraise(forum.getPraise()+1);
				forumService.updateById(forum);
				j.setMsg("点赞成功");
				j.setSuccess(true);
			/*}*/						
		} catch (Exception e) {
			// TODO: handle exception
			j.setMsg("点赞失败");
			j.setSuccess(false);
			e.printStackTrace();
		}
	}
	public String toUploadPage(){
		return "uploadPage";
	}
	
	public Map<String, Object> getMap() {
		return map;
	}


	public void setMap(Map<String, Object> map) {
		this.map = map;
	}


	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}


	public List<?> getList() {
		return list;
	}


	public void setList(List<?> list) {
		this.list = list;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}
	
}
