package com.qlzy.mainPage.news.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Supply;

public interface SupplyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Supply record);

    int insertSelective(Supply record);

    Supply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Supply record);

    int updateByPrimaryKey(Supply record);
    
	/**
	 * @author HuifengWang
	 * @return
	 */
	List<Supply> gainSupplyAll();

	/**
	 * @author HuifengWang
	 * 获取最新的供求信息
	 * @param map
	 * @return
	 */
	List<Supply> gainSupplyNew(Map<String, Object> map);

	/**
	* @Title: gainSupplyListByType
	* @Description: TODO(根据type查找信息)
	* @param @param map
	* @param @return????设定文件
	* @return List<Supply>????返回类型
	* @throws
	*/
	List<Supply> gainSupplyListByType(Map<String, Object> map);

	/**
	* @Title: gainSupplyListByTypeCount
	* @Description: TODO(根据type查找信息数目)
	* @param @param map
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainSupplyListByTypeCount(Map<String, Object> map);
	
	/**
	 * @author HuifengWang
	 * @param map
	 * @return
	 */
	List<Supply> gainAllByType(Map<String, Object> map);
	
	/**
	 * @author HuifengWang
	 * @param map
	 * @return
	 */
	Long gainAllCountByType(Map<String, Object> map);

	void updateSupplyViewNum(Supply s);

	/**
	* @Title: gainSupplyMessageByType
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param userId
	* @param @param zhengche
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainSupplyMessageByType(Map<?, ?> map);
	
	/**
	 * @Title: gainSupplyStatisticsByTime
	 * @Description: TODO(发布统计-发布供/求信息统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainSupplyStatisticsByTime(Map<String, Object> map);
}