package com.qlzy.memberCenter.person.active.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.memberCenter.person.active.service.DataDownloadService;
import com.qlzy.memberCenter.statistics.service.StatisticsService;
import com.qlzy.model.DataDownload;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.pojo.StatisticsInfo;
import com.qlzy.util.BaseAction;
import com.qlzy.util.Pagination;

/**
 * @ClassName: MoneyManageAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhao yang bin
 * @date 2013-9-24 下午1:33:41
 *
 */
@Namespace("/")
@Action(value = "dataDownload", results = {
		@Result(name = "dataDownloadList", location = "/memberCenter/person/active/downloadList.jsp"),
		@Result(name = "dataDownloadListCompany", location = "/memberCenter/company/active/downloadList.jsp")
		
})
public class DataDownloadAction extends BaseAction{
	
	private Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 1L;
	@Autowired
	private DataDownloadService dataDownloadService;
	
	private String timeRange;
	
	private List<DataDownload> dataDownloadList;
	
	private String dataDownloadIds;
	
	private SessionInfo sessionInfo;
	
	@Resource
	private StatisticsService statisticsService;// 统计信息接口类
	
	private StatisticsInfo downLoadStatisticsInfo;//统计
	 /**
	 * 
	 * 得到下载列表列表
	 * */
	public String toDataloadList(){
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination pagination = definationPagination(request);
		pagination.setRows((long) 20);// 设置每页显示几条数据Constant.paginationRows
		map.put("page", pagination.getPage());
		map.put("rows", pagination.getRows());
		map.put("userId", sessionInfo.getUserId());
		if(timeRange!=null && !timeRange.equals("")){
			map.put("timeRange", timeRange);
		}
		dataDownloadList = dataDownloadService.gainDataloadList(map);
		pagination.setTotalCount(dataDownloadService.gainDataloadListCount(map));
		request.setAttribute("pagination", pagination);
		if(sessionInfo.getUserType().equals("company")){
			return "dataDownloadListCompany";
		}else{
			return "dataDownloadList";
		}
		
	}
	public void deleteDataDownloadByIds(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			dataDownloadService.deleteDataDownloadByIds(dataDownloadIds);
			map.put("success", true);
			map.put("msg", "删除成功！");
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", "删除失败！");
			logger.error("deleteDataDownloadByIds() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(map);
	}
	
	public void statisticsDownLoad(){
		// 下载统计
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		downLoadStatisticsInfo = statisticsService.gainCollectStatisticsByTime("0", sessionInfo);
		downLoadStatisticsInfo = statisticsService.gainBrowseStatisticsByTime("0", sessionInfo);
		downLoadStatisticsInfo = statisticsService.gainActiveStatisticsByTime("0", sessionInfo);
		 writeJson(downLoadStatisticsInfo);
		
	}
	
	public String getTimeRange() {
		return timeRange;
	}
	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}
	public List<DataDownload> getDataDownloadList() {
		return dataDownloadList;
	}
	public void setDataDownloadList(List<DataDownload> dataDownloadList) {
		this.dataDownloadList = dataDownloadList;
	}
	public String getDataDownloadIds() {
		return dataDownloadIds;
	}
	public void setDataDownloadIds(String dataDownloadIds) {
		this.dataDownloadIds = dataDownloadIds;
	}
	public StatisticsInfo getDownLoadStatisticsInfo() {
		return downLoadStatisticsInfo;
	}
	public void setDownLoadStatisticsInfo(StatisticsInfo downLoadStatisticsInfo) {
		this.downLoadStatisticsInfo = downLoadStatisticsInfo;
	}
	

}
