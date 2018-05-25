package com.qlzy.memberCenter.person.moneyManage.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.AdvanceLogs;

public interface AdvanceLogsMapper {



    int deleteByPrimaryKey(String id);

    int insert(AdvanceLogs record);

    int insertSelective(AdvanceLogs record);

    AdvanceLogs selectByPrimaryKey(String id);

	AdvanceLogs selectByUserId(Map<String,Object> map);

	Double selectFirstByUserId(String UserId);

	Double selectSecondByUserId(String UserId);

	List<AdvanceLogs> selectByUserIdGetList(Map<String,Object> map);

    int updateByPrimaryKeySelective(AdvanceLogs record);

    int updateByPrimaryKey(AdvanceLogs record);
	
    
    /**
	 * 
	 * 得到所有资金列表
	 * */
    List<AdvanceLogs> gainMoneyAllList(Map<String, Object> map);
    /**
   	 * 
   	 * 得到所有资金数目
   	 * */
	Long gainMoneyAllListCount(Map<String, Object> map);
	
	/**
	 * @Title: AdvanceLogsMapper.java 
	 * @Description: TODO(统计信息-资金统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年 ) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Double 返回类型 
	 * @author wangmei
	 */
	Double gainFundStatisticsByTime(Map<String, Object> map);
}