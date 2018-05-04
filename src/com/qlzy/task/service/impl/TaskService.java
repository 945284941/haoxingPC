package com.qlzy.task.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.memberCenter.person.perinfo.dao.LiucunbiDetailMapper;
import com.qlzy.memberCenter.person.perinfo.dao.XianjinbiDetailMapper;
import com.qlzy.model.LiucunbiDetail;
import com.qlzy.model.Member;
import com.qlzy.model.XianjinbiDetail;
import com.qlzy.task.dao.CashBackTaskLogMapper;
import com.qlzy.task.dao.CashBackTaskMapper;
import com.qlzy.task.model.CashBackTask;
import com.qlzy.task.model.CashBackTaskLog;
import com.qlzy.task.service.ITaskService;

@Service("taskService")
public class TaskService implements ITaskService {
	private static final Logger log = Logger.getLogger(TaskService.class);
	
	@Autowired
	private CashBackTaskMapper cashBackTaskMapper;
	@Autowired
	private CashBackTaskLogMapper cashBackTaskLogMapper;
	@Autowired
	private XianjinbiDetailMapper xianjinbiDetailMapper;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private LiucunbiDetailMapper liucunbiDetailMapper;
	
	@Override
	public void insertCashBackTask(CashBackTask task) {
		task.setTaskId(ToolsUtil.getUUID());
		task.setStatus("1");
		task.setCreateTime(new Date());
		task.setAlreadyBalance(new BigDecimal(0));
		task.setAlreadyNumber(0);
		Calendar next = Calendar.getInstance();
		next.set(next.get(Calendar.YEAR), next.get(Calendar.MONTH), next.get(Calendar.DATE), 0, 0, 0);
		next.add(Calendar.MONTH, 2);
		next.add(Calendar.DAY_OF_MONTH, 1);
		task.setNextBackTime(next.getTime());
		
		cashBackTaskMapper.insertSelective(task);
	}

	@Override
	public void execCashBackTask() {
		log.info("==== 返现任务开始 ==================================================");
		List<CashBackTask> taskList = cashBackTaskMapper.queryShouldCalculateTask(new Date());
		int success = 0;
		int failure = 0;
		for(CashBackTask task : taskList) {
			try {
				executeCashback(task);
				success++;
			} catch (Exception e) {
				failure++;
				log.error("【返现任务】任务ID-" + task.getTaskId() + "，会员ID-" + task.getMemberId() + "，执行失败！！");
			}
		}
		log.info("==== 返现任务结束：共" + taskList.size() + "条，成功" + success + "条，失败" + failure + "条================================");
	}
	
	@Transactional
	private void executeCashback(CashBackTask task) {
		CashBackTask newTask = new CashBackTask();
		newTask.setTaskId(task.getTaskId());
		
		int alreadyNumber = task.getAlreadyNumber() + 1;
		int totalNumber = task.getTotalNumber();
		if(alreadyNumber <= totalNumber) {
			BigDecimal amount = task.getAmount();
			BigDecimal alreadyBalance = task.getAlreadyBalance();
			BigDecimal totalBalance = task.getTotalBalance();
			if(alreadyNumber == totalNumber) {
				newTask.setStatus("2");
				amount = totalBalance.subtract(alreadyBalance);
			}
			newTask.setAlreadyNumber(alreadyNumber);
			newTask.setAlreadyBalance(alreadyBalance.add(amount));
			Calendar next = Calendar.getInstance();
			next.setTime(task.getNextBackTime());
			next.set(next.get(Calendar.YEAR), next.get(Calendar.MONTH) + 1, next.get(Calendar.DATE), 0, 0, 0);
			newTask.setNextBackTime(next.getTime());
			
			Member oldMember = memberMapper.selectByPrimaryKey(task.getMemberId());
			double currentAmount = 0;
			String remark = null;

			String recordId = ToolsUtil.getUUID();
			Calendar splitTime = Calendar.getInstance();
			splitTime.set(2016, 11, 1, 0, 0, 0);
			// 结算得惠米	点击确认收货在splitTime之后的订单返惠米
			if("1".equals(task.getBackKey()) && (task.getCreateTime()==null || task.getCreateTime()!=null && task.getCreateTime().compareTo(splitTime.getTime())>=0)) {
				currentAmount = (oldMember.getLiucunbi()==null ? 0 : oldMember.getLiucunbi()) + amount.doubleValue();
				remark = "结算获得惠米，第" + alreadyNumber + "期";
				
				// 更新用户惠米
				Member member = new Member();
				member.setId(task.getMemberId());
				member.setLiucunbi(currentAmount);
				memberMapper.updateByPrimaryKeySelective(member);
				
				// 记录惠米日志
				LiucunbiDetail record = new LiucunbiDetail();
				record.setId(recordId);
				record.setPoint(amount.doubleValue());
				record.setMemberId(task.getMemberId());
				record.setRemark(remark);
				record.setCreatetime(new Date());
				record.setBalance(currentAmount);
				record.setType((short) 0);
				record.setDisabled("false");
				record.setStatus("1");
				liucunbiDetailMapper.insert(record);
			}
			// 结算得金米	会员升级 或 点击确认收货在splitTime之前的订单返金米
			else {
				currentAmount = (oldMember.getXianjinbi()==null ? 0 : oldMember.getXianjinbi()) + amount.doubleValue();
				remark = "结算获得金米，第" + alreadyNumber + "期";
				
				// 更新用户金米
				Member member = new Member();
				member.setId(task.getMemberId());
				member.setXianjinbi(currentAmount);
				memberMapper.updateByPrimaryKeySelective(member);
				
				// 记录金米日志
				XianjinbiDetail record = new XianjinbiDetail();
				record.setId(recordId);
				record.setPoint(amount.doubleValue());
				record.setMemberId(task.getMemberId());
				record.setRemark(remark);
				record.setCreatetime(new Date());
				record.setBalance(currentAmount);
				record.setType((short) 0);
				record.setDisabled("false");
				record.setStatus("1");
				xianjinbiDetailMapper.insert(record);
			}
			
			// 记录返现日志
			CashBackTaskLog log = new CashBackTaskLog();
			log.setId(ToolsUtil.getUUID());
			log.setTaskId(task.getTaskId());
			log.setNumber(alreadyNumber);
			log.setAmount(amount);
			log.setLinkId(recordId);
			log.setCreateTime(new Date());
			log.setRemark(remark);
			cashBackTaskLogMapper.insert(log);
		} else {
			newTask.setStatus("2");
		}
		
		cashBackTaskMapper.updateByPrimaryKeySelective(newTask);
	}
}
