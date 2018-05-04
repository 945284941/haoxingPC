package com.qlzy.memberCenter.person.moneyManage.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.common.tools.MD5;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.login.dao.MemberMapper;
import com.qlzy.memberCenter.common.dao.MobileMessageMapper;
import com.qlzy.memberCenter.person.moneyManage.dao.AdvanceLogsMapper;
import com.qlzy.memberCenter.person.moneyManage.service.MoneyManageService;
import com.qlzy.model.AdvanceLogs;
import com.qlzy.model.Member;
import com.qlzy.model.MobileMessage;
import com.qlzy.pojo.SessionInfo;
@Service
public class MoneyManageServiceImpl implements MoneyManageService{
	@Autowired
	private AdvanceLogsMapper advanceLogsMapper;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private MobileMessageMapper mobileMessageMapper;
	 /**
		 * 
		 * 得到所有资金列表
		 * */
	@Override
	public List<AdvanceLogs> gainMoneyAllList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		 return advanceLogsMapper.gainMoneyAllList(map);
	}

	@Override
	public Long gainMoneyAllListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return advanceLogsMapper.gainMoneyAllListCount(map);
	}

	@Override
	public Boolean payIsTrue(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String passowrd="";
		SessionInfo sessionInfo = (SessionInfo) map.get("sessionInfo");
		if(sessionInfo.getUserType().equals("company")){
//			passowrd = companyMapper.gainCompanyMessageById(sessionInfo.getUserId()).getPayPassword();
		}else{
			passowrd = memberMapper.selectByPrimaryKey(sessionInfo.getUserId()).getPayPassword();
		}
		String p = (String) map.get("payPassword");
		String paw = MD5.encrypt(p);
		if(passowrd.equals(paw)){
			return  true;
		}else{
			return false;
		}
	}
	/**
	 * 
	 * 添加充值日志
	 * */
	@Override
	public void addMoney(AdvanceLogs advanceLogs,SessionInfo sessionInfo) {
		Double advance=0D;
		if(sessionInfo.getUserType().equals("company")){
//			advance = companyMapper.gainCompanyMessageById((String) advanceLogs.getUserId()).getAdvance();
		}else{
			advance = memberMapper.selectByPrimaryKey((String) advanceLogs.getUserId()).getAdvance();
		}
		
		// TODO Auto-generated method stub
		advance = advanceLogs.getDoMoney()+advance;
		advanceLogs.setId(ToolsUtil.getUUID());
		advanceLogs.setDoTime(new Date());
		advanceLogs.setDoType("0");
		advanceLogs.setTrading("0");
		advanceLogs.setBalance(advance);
		//修改member
//		Member member = new Member();
//		member.setId(advanceLogs.getUserId());
//		member.setAdvance(advance);
//		memberMapper.updateByPrimaryKeySelective(member);
		//修改根据sessionInfo 修改company表
		advanceLogsMapper.insertSelective(advanceLogs);
	}

	@Override
	public void enchashment(AdvanceLogs advanceLogs,SessionInfo sessionInfo) {
		// TODO Auto-generated method stub
		Double advance = 0d;
		if(sessionInfo.getUserType().equals("company")){
//			advance = companyMapper.gainCompanyMessageById(sessionInfo.getUserId()).getAdvance();
		}else{
			advance = memberMapper.selectByPrimaryKey((String) advanceLogs.getUserId()).getAdvance();
		}
		advance = advance-advanceLogs.getDoMoney();
		advanceLogs.setId(ToolsUtil.getUUID());
		advanceLogs.setDoTime(new Date());
		advanceLogs.setDoType("1");
		advanceLogs.setTrading("0");
		advanceLogs.setDoMoney(-advanceLogs.getDoMoney());
		advanceLogs.setBalance(advance);
		//修改member 添加审核功能，并且和银行接口实现对接后，实现修改member值
		//Member member = new Member();
		//member.setId(advanceLogs.getUserId());
		//member.setAdvance(advance);
		//memberMapper.updateByPrimaryKeySelective(member);
		//根据sessioninfo 修改company表
		advanceLogsMapper.insertSelective(advanceLogs);
	}

	@Override
	public Double moneyEnchs(SessionInfo sessionInfo) {
		// TODO Auto-generated method stub
		Double advance = 0d;
		if(sessionInfo.getUserType().equals("company")){
//			advance = companyMapper.gainCompanyMessageById(sessionInfo.getUserId()).getAdvance();
		}else{
			 advance=	memberMapper.selectByPrimaryKey(sessionInfo.getUserId()).getAdvance();
		}
	return advance;
	}

	@Override
	public void addMobileMessage(MobileMessage mobileMess) {
			mobileMessageMapper.addMobileMessage(mobileMess);
	}

	@Override
	public List<MobileMessage> gainMobileByUserId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mobileMessageMapper.gainMobileByUserId(map);
	}

}
