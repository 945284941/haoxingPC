package com.qlzy.memberCenter.common.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.PointDetail;

public interface PointDetailMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(PointDetail record);

    PointDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PointDetail record);

    int updateByPrimaryKey(PointDetail record);
    
    /**
     * @Title: PointDetailMapper.java 
     * @Description: TODO(统计信息-经验值统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
     * @param @param map
     * @param @return    设定文件 
     * @return Long 返回类型 
     * @author wangmei
     */
    Long gainPointStatisticsByTime(Map<String, Object> map);

	/**
	* @Title: gainPointList
	* @Description: TODO(我的经验值列表)
	* @param @param map
	* @param @return????设定文件
	* @return List<PointDetail>????返回类型
	* @throws
	*/
	List<PointDetail> gainPointList(Map<String, Object> map);

	/**
	* @Title: gainPointListCount
	* @Description: TODO(经验值列表数目)
	* @param @param map
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainPointListCount(Map<String, Object> map);

	/**
	* @Title: deletePointList
	* @Description: TODO(删除)
	* @param @param pointId????设定文件
	* @return void????返回类型
	* @throws
	*/
	void deletePointList(String pointId);
	
	/**
	 * @Title: PointDetailMapper.java 
	 * @Description: TODO(添加经验值日志) 
	 * @param @param pointDetail    设定文件 
	 * @return void 返回类型 
	 * @author wangmei
	 */
	void addPointLog(PointDetail pointDetail);
}