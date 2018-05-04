package com.qlzy.memberCenter.person.perinfo.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.XianjinbiCashApply;

/**
 * 金米兑米申请记录
 *
 */
public interface XianjinbiCashApplyMapper {
	int deleteByPrimaryKey(String id);

	int insert(XianjinbiCashApply record);

	int insertSelective(XianjinbiCashApply record);

	XianjinbiCashApply selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(XianjinbiCashApply record);

	int updateByPrimaryKey(XianjinbiCashApply record);
	
	List<XianjinbiCashApply> gainXianjinbiCashList(Map<String, Object> map);

	Long gainXianjinbiCashCount(Map<String, Object> map);
	
	int repeatabilityCheck(XianjinbiCashApply record);
	
}