package com.qlzy.task.dao;

import com.qlzy.task.model.CashBackTaskLog;

public interface CashBackTaskLogMapper {
	int insert(CashBackTaskLog cashBackTaskLog);

	int insertSelective(CashBackTaskLog cashBackTaskLog);

	int deleteByPrimaryKey(String id);

	CashBackTaskLog selectByPrimaryKey(String id);

	int updateByPrimaryKey(CashBackTaskLog cashBackTaskLog);

	int updateByPrimaryKeySelective(CashBackTaskLog cashBackTaskLog);
}
