package com.qlzy.task.service;

import com.qlzy.task.model.CashBackTask;

public interface ITaskService {
	/**
	 * 插入返现任务
	 * @param task
	 */
	public void insertCashBackTask(CashBackTask task);
	
	/**
	 * 执行定时返现任务
	 */
	public void execCashBackTask();
}
