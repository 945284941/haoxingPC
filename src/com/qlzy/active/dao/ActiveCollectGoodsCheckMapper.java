package com.qlzy.active.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.ActiveCollectGoodsCheck;

public interface ActiveCollectGoodsCheckMapper {

	/**
	* @Title: updateByPrimaryKeySelective
	* @Description: 更新校对数据
	* @param @param activeCollectGoodsCheck    设定文件
	* @return void    返回类型
	*/
	void updateByPrimaryKeySelective(ActiveCollectGoodsCheck activeCollectGoodsCheck);
	
	/**
	* @Title: deleteByPrimaryKey
	* @Description: 删除校对数据,根据ID
	* @param @param id    设定文件
	* @return void    返回类型
	*/
	void deleteByPrimaryKey(String id);
	
	/**
	* @Title: insertSelective
	* @Description: 插入校对数据
	* @param @param activeCollectGoodsCheck    设定文件
	* @return void    返回类型
	*/
	void insertSelective(ActiveCollectGoodsCheck activeCollectGoodsCheck);
	
	/**
	* @Title: selectByPrimaryKey
	* @Description: 根据ID获取校对数据
	* @param @param id
	* @param @return    设定文件
	* @return ActiveCollectGoodsCheck    返回类型
	*/
	ActiveCollectGoodsCheck selectByPrimaryKey(String id);
	
	/**
	 * @Title: gainCheckCount
	 * @Description: TODO(根据会员id,校对通过标示查询校对的数据条数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainCheckCount(Map<String, Object> map);
	
	/**
	 * @Title: gainCheckActiveCollectGoodsList
	 * @Description: TODO(根据会员id查询校对的数据信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ActiveCollectGoodsCheck>    返回类型
	 * @author wangmei
	 */
	List<ActiveCollectGoodsCheck> gainCheckActiveCollectGoodsList(Map<String, Object> map);
	
	/**
	 * @Title: gainCheckAddUpPoint
	 * @Description: TODO(查询会员校对累计经验值)
	 * @param @param memberId
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainCheckAddUpPoint(String memberId);
	
	/**
	 * @Title: gainCheckAddUpMoney
	 * @Description: TODO(查询会员校对累计奖金)
	 * @param @param memberId
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	Double gainCheckAddUpMoney(String memberId);
	
	/**
	 * @Title: gainCheckCountByTime
	 * @Description: TODO(查询今日、昨日、本月的校对数据统计)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainCheckCountByTime(Map<String, Object> map);
	
	/**
	 * @Title: gainCheckRankByTime
	 * @Description: TODO(查询今日、昨日、本月的校对数据总排名)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainCheckRankByTime(Map<String, Object> map);
	
	/**
	 * @Title: gainCheckGetPoint
	 * @Description: TODO(查询今日、昨日、本月的校对数据采用获得的经验值)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainCheckGetPoint(Map<String, Object> map);
	
	/**
	 * @Title: gainCheckGetMoney
	 * @Description: TODO(查询今日、昨日、本月的校对数据采用获得的奖金)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	Double gainCheckGetMoney(Map<String, Object> map);
	
	Long gainCheckCountByParam(ActiveCollectGoodsCheck acgc);
	
	/**
	 * @Title: ActiveCollectGoodsCheckMapper.java 
	 * @Description: TODO(活动统计-校对或校对采用统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainCheckStatisticsByTime(Map<String, Object> map);
}