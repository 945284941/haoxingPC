package com.qlzy.mainPage.activity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qlzy.mainPage.activity.dao.ActivityModelMapper;
import com.qlzy.mainPage.activity.service.ActivityService;
import com.qlzy.model.ActivityModel;
@Service("activityService")
public class ActivityServiceImpl implements ActivityService{
	@Resource
	private ActivityModelMapper activityModelMapper;
	
	@Override
	public List<ActivityModel> gainActivityList() {
		// TODO Auto-generated method stub
		
		return activityModelMapper.gainActivityList();
	}

}
