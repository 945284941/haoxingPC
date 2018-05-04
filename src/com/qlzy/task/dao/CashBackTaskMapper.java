package com.qlzy.task.dao;

import java.util.Date;
import java.util.List;

import com.qlzy.task.model.CashBackTask;

public interface CashBackTaskMapper {
	int insert(CashBackTask cashBackTask);

	int insertSelective(CashBackTask cashBackTask);

	int deleteByPrimaryKey(String taskId);

	CashBackTask selectByPrimaryKey(String taskId);

	int updateByPrimaryKey(CashBackTask cashBackTask);

	int updateByPrimaryKeySelective(CashBackTask cashBackTask);
	
	List<CashBackTask> queryShouldCalculateTask(Date nowTime);
}
