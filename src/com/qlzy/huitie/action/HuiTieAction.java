package com.qlzy.huitie.action;

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
import com.qlzy.huitie.service.HuiTieService;
import com.qlzy.model.Forum;
import com.qlzy.model.HuiTie;
import com.qlzy.pojo.Json;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;
@Namespace("/")
@Action(value = "huitieAction", results = {
		@Result(name = "huitie", location = "/admin/huitie/HuiTieIndex.jsp"),
		@Result(name = "Myht", location = "/memberCenter/person/forum/myhuitie.jsp")
})
public class HuiTieAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private HuiTieService huiTieService;
	@Autowired
	private ForumService forumService;
	private Map<String, Object> map = new HashMap<String, Object>();
	private List<?> list;
	private HuiTie huiTie;
	private Forum forum;
	private String newsCatName;
	private SessionInfo sInfo = null;
	private SessionInfo sessionInfo ;

	/**
	 * @Title: toHuiTie
	 * @Description: 点击新闻详情
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String toHuiTie() {
		String Id = request.getParameter("id");
		int index = Id.indexOf("/");
		String id = Id.substring(index+1);
			
		forum = forumService.gainForumById(id);
		
		forum.setViewnums(forum.getViewnums()+1);
		 forumService.updateByViewnums(forum);
		//huiTie = huiTieService.gainHuiTieById(id);
		 List<Forum> zuixinList = forumService.gainZuixin(6);
			map.put("zuixin",zuixinList);
			
			Map<String, Object> newsCatMap1 = new HashMap<String, Object>();
			Map<String, Object> param1;
			newsCatMap1.put("0", "0");
			newsCatMap1.put("1", "1");
			newsCatMap1.put("2", "2");
			newsCatMap1.put("3", "3");
			newsCatMap1.put("4", "4");
			newsCatMap1.put("5", "5");
			
			for (int i = 0; i <= 5; i++) {
				param1 = new HashMap<String, Object>();
				param1.put("type", String.valueOf(newsCatMap1.get(i + "")));
				List<Forum> temp1 = forumService.gainHysqIndex(param1);
						list = temp1.subList(0, temp1.size() > 5 ? 5 : temp1.size());
				map.put("zxrt_" + i, list);
			}

		
			//request.setAttribute("fh",forum);
		
		
		
		/*if(huiTie!=null){
		Integer temp=(int)(Math.random()*10)+1;
		huiTie.setViewnum(huiTie.getViewnum()+temp);
		huiTieService.updateViewNumById(huiTie);*/		
		Map<String, Object> newsCatMap = new HashMap<String, Object>();
		Map<String, Object> param;
		newsCatMap.put("0", id);

		for (int i = 0; i <= 0; i++) {
			param = new HashMap<String, Object>();
			param.put("forumId", String.valueOf(newsCatMap.get(i + "")));
			
			List<HuiTie> temp1 = huiTieService.gainHuiTieIndex(param);
			
				/*if(i>=1){
					list = temp1.subList(0, temp1.size() > 2 ? 2 : temp1.size());
				}else{
					list = temp1.subList(0, temp1.size() > 2 ? 2 : temp1.size());
				}*/
			map.put("HuiTie_" + i, temp1);
		}
		//newsCatName="会员社区列表";
		/*Map<String, Object> map1 = new HashMap<String, Object>();
		//Map<Integer, Object> huitie = new HashMap<Integer, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(2L);// 设置每页显示几条数据
		//map1.put("newsCatName", newsCatName);
		map1.put("forumId",huiTie.getForumId());
		map1.put("page", (pagination.getPage()-1)*pagination.getRows());
		map1.put("rows", pagination.getRows());
		
		list = huiTieService.gainHuiTieListById(map1);
		pagination.setTotalCount(huiTieService.gainHuiTieListByIdCount(map1));
		request.setAttribute("pagination", pagination);
		request.setAttribute("ncn", temp);
		request.setAttribute("huities",list);*/
		request.setAttribute("fh",forum);
		/*}else {
		request.setAttribute("fh",forum);
		}*/
		return "huitie";
	}
	
	
	public void gainHuiTie(){
		Json j = new Json();
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil
					.getSessionInfoName());
			
			HuiTie huiTie = new HuiTie();
			//String id = request.getParameter("id");
			huiTie.setForumId(request.getParameter("id"));
			String pid = request.getParameter("pid");
			huiTie.setId(ToolsUtil.getUUID());
			huiTie.setCreateTime(new Date());
			String message=URLDecoderTwice.decoder(request.getParameter("message"));
			String title=URLDecoderTwice.decoder(request.getParameter("title"));
			if(message==""){
				j.setMsg("回复失败");
				j.setSuccess(false);
			}else{
			huiTie.setMessage(message);
			huiTie.setTitle(title);
			huiTie.setUserId(sessionInfo.getUserId());
			huiTie.setUserName(sessionInfo.getLoginName());
			Forum forum = new Forum();
			if(pid.equals("undefined")){
				pid=null;
			}
			if(pid==""||pid==null){
				huiTie.setPid("1");
				forum.setId(huiTie.getForumId());
			}else{
				huiTie.setPid(request.getParameter("pid"));	
				forum.setId(huiTie.getForumId());
			}	
			forum = forumService.selectByForumId(forum);
				if(forumService.selectByForumId(forum).equals("")){
					forum.setHuitieSum(1);
				}else{
					forum.setHuitieSum(forum.getHuitieSum()+1);
				}							
				forumService.updateByHuiTieSum(forum);
				huiTieService.InsertHuiTie(huiTie);
				j.setMsg("回复成功");
				j.setSuccess(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			j.setMsg("回复失败");
			j.setSuccess(false);
			e.printStackTrace();
		}
		
	}
	/**
	 * 针对回帖人的回复
	 */
	public void gainHuiTieEnd(){
		Json j = new Json();
		try {
			HuiTie huiTie = new HuiTie();
			
			huiTie.setForumId(request.getParameter("id"));
			huiTie.setId(ToolsUtil.getUUID());
			huiTie.setCreateTime(new Date());
			huiTie.setMessage(request.getParameter("message"));
			huiTie.setTitle(request.getParameter("title"));
			huiTie.setPid(request.getParameter("pid"));
			sessionInfo = (SessionInfo) session.get(ResourceUtil
					.getSessionInfoName());
			//if(sessionInfo!=null){
				//huiTie.setUserId(sessionInfo.getUserId());
				//huiTie.setUserName(sessionInfo.getUserName());
				Forum forum = new Forum();
				forum.setId(huiTie.getForumId());
				forum = forumService.selectByForumId(forum);
				forum.setHuitieSum(forum.getHuitieSum()+1);
				forumService.updateByHuiTieSum(forum);
				huiTieService.InsertHuiTie(huiTie);
				j.setMsg("回复成功");
				j.setSuccess(true);
				
			/*}else{
				j.setMsg("请先登录在进行回复！");
				j.setSuccess(false);
			}*/
		} catch (Exception e) {
			// TODO: handle exception
			j.setMsg("回复失败");
			j.setSuccess(false);
			e.printStackTrace();
		}
		
	}
	public String MyHuiTie(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> newsCatMap = new HashMap<String, Object>();
		Map<String, Object> param;
		newsCatMap.put("0", sessionInfo.getUserId());

		for (int i = 0; i <= 0; i++) {
			param = new HashMap<String, Object>();
			param.put("userId", String.valueOf(newsCatMap.get(i + "")));
			
			List<HuiTie> temp1 = huiTieService.MyHuiTie(param);
				if(i>=1){
					list = temp1.subList(0, temp1.size() > 4 ? 4 : temp1.size());
				}else{
					list = temp1.subList(0, temp1.size() > 6 ? 6 : temp1.size());
				}
			map.put("MyHuiTie_" + i, list);
		}
		//newsCatName="会员社区列表";
		Map<String, Object> map1 = new HashMap<String, Object>();
		//Map<Integer, Object> huitie = new HashMap<Integer, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(12L);// 设置每页显示几条数据
		//map1.put("newsCatName", newsCatName);
		map1.put("userId",sessionInfo.getUserId());
		map1.put("page", (pagination.getPage()-1)*pagination.getRows());
		map1.put("rows", pagination.getRows());
		
		list = huiTieService.MyHuiTieList(map1);
		pagination.setTotalCount(huiTieService.MyHuiTieListCount(map1));
		request.setAttribute("pagination", pagination);
		request.setAttribute("myhuitie",list);
		//request.setAttribute("fh",forum);
		return "Myht";
		
	}
	public void visitAdd(){		
		Json j = new Json();
		try {
			sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			HuiTie huitie = new HuiTie();
			/*if(sessionInfo==null){
				j.setMsg("请先登录再点赞");
				j.setSuccess(false);
			}else{*/
				huitie.setId(request.getParameter("id"));
				huitie = huiTieService.selectById(huitie);
				huitie.setVisit(huitie.getVisit()+1);
				huiTieService.updateById(huitie);
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
	
	public HuiTie getHuiTie() {
		return huiTie;
	}

	public void setHuiTie(HuiTie huiTie) {
		this.huiTie = huiTie;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}


	public String getNewsCatName() {
		return newsCatName;
	}


	public void setNewsCatName(String newsCatName) {
		this.newsCatName = newsCatName;
	}


	public SessionInfo getsInfo() {
		return sInfo;
	}


	public void setsInfo(SessionInfo sInfo) {
		this.sInfo = sInfo;
	}


	public Forum getForum() {
		return forum;
	}


	public void setForum(Forum forum) {
		this.forum = forum;
	}


	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}


	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}
	

}
