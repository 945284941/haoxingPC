package com.qlzy.active.dao;

import java.util.Map;


public interface ActiveCollectPointLogMapper {
	
	/**
	 * @Title: gainTotalPoint
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总经验值)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainTotalPoint(Map<String, Object> map);
	
	/**
	 * @Title: gainTotalPointRank
	 * @Description: TODO(查询今日、昨日、本月的上传和校对采用获得的总经验值的总排名)
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	Long gainTotalPointRank(Map<String, Object> map);
}