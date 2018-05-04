package com.qlzy.memberCenter.news.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.memberCenter.news.service.CenterNewsService;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

/**
 * @ClassName: CenterNewsAction
 * @Description:
 * @author Huifeng Wang
 * @date 2013-9-23 上午11:21:53
 */
@Namespace("/newsCenter")
@Action(value = "news", results = {
		@Result(name = "wzsc", location = "/memberCenter/person/xxzx/hyzxgrsy_wzsc.jsp"),
		@Result(name = "lljl", location = "/memberCenter/person/xxzx/hyzxgrsy_lljl.jsp")
	 })
public class CenterNewsAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Date startTime;
	private Date endTime;
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Autowired
	private CenterNewsService centerNewsService;
	//------------------------------------------------------------------------------------
	/**
	 * 个人会员新闻资讯板块
	 */
	public String toWzsc(){
		SessionInfo info =(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(info==null){
			return "login_hf";
		}
		Map<String,Object> map =new HashMap<String,Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(10L);// 设置每页显示几条数据
		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", info.getUserId());
		if(startTime!=null){
			map.put("startTime", startTime);
		}
		if(endTime!=null){
			map.put("endTime",endTime);
		}
		List<Map<String,Object>> mcNews=centerNewsService.gainMemberCollectOfNews(map);
		pagination.setTotalCount(centerNewsService.gainMemberCollectCountOfNews(map));
		request.setAttribute("pagination", pagination);
		request.setAttribute("mcNews", mcNews);
		Map<String,Object> r=new HashMap<String,Object>();
		r.put("userId", info.getUserId());
		return "wzsc";
	}
	
	public String toLljl(){
		SessionInfo info =(SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(info==null){
			return "login_hf";
		}
		Map<String,Object> map =new HashMap<String,Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows(10L);// 设置每页显示几条数据
		map.put("page", (pagination.getPage()-1)*pagination.getRows());
		map.put("rows", pagination.getRows());
		map.put("userId", info.getUserId());
		if(startTime!=null){
			map.put("startTime", startTime);
		}
		if(endTime!=null){
			map.put("endTime",endTime);
		}
		List<Map<String,Object>> vNews=centerNewsService.gainViewOfNews(map);
		pagination.setTotalCount(centerNewsService.gainViewCountOfNews(map));
		request.setAttribute("pagination", pagination);
		request.setAttribute("vNews", vNews);
		Map<String,Object> r=new HashMap<String,Object>();
		r.put("userId", info.getUserId());
		return "lljl";
	}
	
	public void deleteWzsc(){
		try {
			centerNewsService.deleteWzsc(ToolsUtil.StringConvertList(request.getParameter("ids")));
			super.writeJson(true);
		} catch (Exception e) {
			super.writeJson(false);
			e.printStackTrace();
		}
	}
	public void deleteLljl(){
		try {
			centerNewsService.deleteLljl(ToolsUtil.StringConvertList(request.getParameter("ids")));
			super.writeJson(true);
		} catch (Exception e) {
			super.writeJson(false);
			e.printStackTrace();
		}
	}
}
