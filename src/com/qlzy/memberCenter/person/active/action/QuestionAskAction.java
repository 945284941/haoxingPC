/**??
 * @Title: QuestionAskAction.java
 * @Package com.qlzy.memberCenter.person.active.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com??
 * @date 2013-9-28 上午10:34:48
 * @version V1.0??
 */
package com.qlzy.memberCenter.person.active.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.common.util.PcOrWap;
import com.qlzy.model.Question;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.memberCenter.person.active.service.QuestionAskService;
import com.qlzy.memberCenter.statistics.service.StatisticsService;
import com.qlzy.model.QuestionLog;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;
import sun.plugin.util.UIUtil;

/**
 * @ClassName: QuestionAskAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author  zhao yang bin
 * @date 2013-9-28 上午10:34:48
 *
 */
@Namespace("/")
@Action(value = "questionAskAction", results = {
		@Result(name = "questionAskList", location = "/memberCenter/person/active/askQuestionList.jsp"),
		@Result(name = "questionAskListCompany", location = "/memberCenter/company/active/askQuestionList.jsp"),
		@Result(name = "toList",type="redirect", location = "questionAskAction!toQuestionAskList.action"),
		@Result(name = "toadd", location = "/memberCenter/person/personalInfo/yijianfankui.jsp"),
		@Result(name = "toaddWap", location = "/wap/person/yijianfankui.jsp")
})
public class QuestionAskAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(this.getClass());

	private String timeRange;

	private String questionAskIds;
	@Autowired
	private QuestionAskService questionAskService;

	private SessionInfo sessionInfo;

	private List<QuestionLog> questionOrAskList;

	@Resource
	private StatisticsService statisticsService;// 统计信息接口类

	private StatisticsInfo questionAskStatisticsInfo;//统计

	private String questionType;//0 为提问 1 回答
	private Question question =new Question();
	/**
	 *
	 * 得到问答列表列表
	 * */
	public String toQuestionAskList(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		map.put("questionType",questionType);
		if(timeRange!=null && !timeRange.equals("")){
			map.put("timeRange", timeRange);
		}
		questionOrAskList = questionAskService.gainQuestionAskList(map);
		pagination.setTotalCount(questionAskService.gainQuestionAskListCount(map));
		request.setAttribute("pagination", pagination);

		if(sessionInfo.getUserType().equals("company")){
			return "questionAskListCompany";
		}else{
			return "questionAskList";
		}
	}
	/**
	 *
	 *批量删除
	 * */
	public void deleteQuestionAskByIds(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			questionAskService.deleteQuestionAskByIds(questionAskIds,questionType);
			map.put("success", true);
			map.put("msg", "删除成功！");
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "删除失败！");
			logger.error("deleteQuestionAskByIds() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(map);
	}

	public void statisticsQuestionAsk(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		questionAskStatisticsInfo = statisticsService.gainActiveStatisticsByTime("0", sessionInfo);
		writeJson(questionAskStatisticsInfo);
	}
	public String toadd(){
		return PcOrWap.isPc(request,"toadd");
	}
	public void addyi(){
		String result = "";
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		String ques=request.getParameter("question");
		question.setId(ToolsUtil.getUUID());
		question.setQuestion(ques);
		question.setCreateBy(sessionInfo.getUserId());
		int n = questionAskService.addquestion(question);
		if(n>0){
			result = "ok";
		}
		writeJson(result);
	}

	public String getTimeRange() {
		return timeRange;
	}


	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}
	public String getQuestionAskIds() {
		return questionAskIds;
	}

	public void setQuestionAskIds(String questionAskIds) {
		this.questionAskIds = questionAskIds;
	}
	public StatisticsInfo getQuestionAskStatisticsInfo() {
		return questionAskStatisticsInfo;
	}
	public void setQuestionAskStatisticsInfo(
			StatisticsInfo questionAskStatisticsInfo) {
		this.questionAskStatisticsInfo = questionAskStatisticsInfo;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public List<QuestionLog> getQuestionOrAskList() {
		return questionOrAskList;
	}
	public void setQuestionOrAskList(List<QuestionLog> questionOrAskList) {
		this.questionOrAskList = questionOrAskList;
	}


}
