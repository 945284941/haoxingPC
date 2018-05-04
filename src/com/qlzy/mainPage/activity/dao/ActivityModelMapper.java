package com.qlzy.mainPage.activity.dao;

import java.util.List;

import com.qlzy.model.ActivityModel;

public interface ActivityModelMapper {
    int deleteByPrimaryKey(String id	);

    int insert(ActivityModel record);

    int insertSelective(ActivityModel record);

    ActivityModel selectByPrimaryKey(String id	);

    int updateByPrimaryKeySelective(ActivityModel record);

    int updateByPrimaryKey(ActivityModel record);

    
    //得到活动列表 
	List<ActivityModel> gainActivityList();
}