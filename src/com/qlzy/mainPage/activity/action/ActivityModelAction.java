package com.qlzy.mainPage.activity.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.qlzy.mainPage.activity.service.ActivityService;
import com.qlzy.model.ActivityModel;
import com.qlzy.util.BaseAction;


@Namespace("/")
@Action(value = "activityModelAction", results = {
		@Result(name = "gainShowIndexFloor", location = "/admin/floor/floor.jsp")
		 })
public class ActivityModelAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(ActivityModelAction.class);
	
	@Resource
	private ActivityService activityService;
	
	
	private List<ActivityModel> activityModelList;
	/**
	 * @Title: gainCitys
	 * @Description: TODO(根据省份id查询其市列表)
	 * @param 设定文件
	 * @return void 返回类型
	 */
	public void gainActivityList() {
		try {
			activityModelList = activityService.gainActivityList();
		} catch (Exception e) {
			logger.error("gainActivityList", e);
			e.printStackTrace();
		}
	}
	public List<ActivityModel> getActivityModelList() {
		return activityModelList;
	}
	public void setActivityModelList(List<ActivityModel> activityModelList) {
		this.activityModelList = activityModelList;
	}
	
	
}
