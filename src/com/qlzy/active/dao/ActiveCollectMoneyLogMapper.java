package com.qlzy.active.dao;

import java.util.Map;


public interface ActiveCollectMoneyLogMapper {
	
	/**
	 * @Title: gainTotalMoney
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总奖金)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	Double gainTotalMoney(Map<String, Object> map);
	
	/**
	 * @Title: gainTotalMoneyRank
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总奖金的总排名)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainTotalMoneyRank(Map<String, Object> map);
}