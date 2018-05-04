package com.qlzy.active.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.ActiveCollectGoods;

public interface ActiveCollectGoodsMapper {
	
	/**
	* @Title: updateByPrimaryKeySelective
	* @Description: 更新上传数据
	* @param @param activeCollectGoods    设定文件
	* @return void    返回类型
	*/
	void updateByPrimaryKeySelective(ActiveCollectGoods activeCollectGoods);
	
	/**
	* @Title: insertSelective
	* @Description: 插入上传数据
	* @param @param activeCollectGoods    设定文件
	* @return void    返回类型
	*/
	void insertSelective(ActiveCollectGoods activeCollectGoods);
	
	/**
	* @Title: deleteByPrimaryKey
	* @Description: 根据ID删除数据
	* @param @param id    设定文件
	* @return void    返回类型
	*/
	void deleteByPrimaryKey(String id);
	
	/**
	* @Title: selectByPrimaryKey
	* @Description: 根据ID选择数据
	* @param @param id
	* @param @return    设定文件
	* @return ActiveCollectGoods    返回类型
	*/
	ActiveCollectGoods selectByPrimaryKey(String id);
	
	/**
	 * @Title: gainUploadCount
	 * @Description: TODO(根据会员id,上传通过标示查询上传的数据条数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainUploadCount(Map<String, Object> map);
	/**
	 * @Title: gainUploadCountByMemberId
	 * @Description: TODO(根据会员id上传数据且通过的数据条数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author 
	 */
	Long gainUploadCountByMemberId(Map<String, Object> map);
	
	/**
	 * @Title: gainActiveCollectGoodsList
	 * @Description: TODO(根据会员id查询上传数据信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ActiveCollectGoods>    返回类型
	 * @author wangmei
	 */
	List<ActiveCollectGoods> gainActiveCollectGoodsList(Map<String, Object> map);

	/**
	* @Title: gainHasCheckedActiveCollectGoods
	* @Description: 获取已经入围的商品
	* @param @param map    设定文件
	* @return void    返回类型
	*/
	List<ActiveCollectGoods> gainHasCheckedActiveCollectGoods(Map<String, Object> map);

	/**
	* @Title: gainHasCheckedActiveCollectGoodsCount
	* @Description: 
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainHasCheckedActiveCollectGoodsCount(Map<String, Object> map);
	
	/**
	 * @Title: gainUploadAddUpPoint
	 * @Description: TODO(查询会员上传累计经验值)
	 * @param @param memberId
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainUploadAddUpPoint(String memberId);
	
	/**
	 * @Title: gainUploadAddUpMoney
	 * @Description: TODO(查询会员上传累计奖金)
	 * @param @param memberId
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	Double gainUploadAddUpMoney(String memberId);
	
	/**
	 * @Title: gainUploadCountByTime
	 * @Description: TODO(查询今日、昨日、本月的上传数据统计)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainUploadCountByTime(Map<String, Object> map);
	
	/**
	 * @Title: gainUploadRankByTime
	 * @Description: TODO(查询今日、昨日、本月的上传数据总排名)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainUploadRankByTime(Map<String, Object> map);
	
	/**
	 * @Title: gainUploadGetPoint
	 * @Description: TODO(查询今日、昨日、本月的上传数据采用获得的经验值)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainUploadGetPoint(Map<String, Object> map);
	/**
	 * @Title: gainUploadGetMoney
	 * @Description: TODO(查询今日、昨日、本月的上传数据采用获得的奖金)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Double    返回类型
	 * @author wangmei
	 */
	Double gainUploadGetMoney(Map<String, Object> map);
	
	/**
	 * @Title: gainListForUploadRankByTime
	 * @Description: TODO(查询今日、本月数据上传排行榜)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ActiveCollectGoods>    返回类型
	 * @author wangmei
	 */
	List<ActiveCollectGoods> gainListForUploadRankByTime(Map<String, Object> map);
	
	/**
	 * @Title: ActiveCollectGoodsMapper.java 
	 * @Description: TODO(活动统计-上传或上传采用统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainUploadStatisticsByTime(Map<String, Object> map);

	/**
	 * @author HuifengWang
	 * @param string
	 * @return
	 */
	List<ActiveCollectGoods> gainActiveCollectGoodsByCompanyId(String string);
}