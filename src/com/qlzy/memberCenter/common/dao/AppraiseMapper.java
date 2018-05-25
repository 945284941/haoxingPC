package com.qlzy.memberCenter.common.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.qlzy.model.Appraise;
import com.qlzy.model.Goods;
import com.qlzy.pojo.StatisticsInfo;

public interface AppraiseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

	Appraise selectByOrderIdAndGoodsId(Appraise appraise);

    Appraise selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);
    
    /**
     * @Title: gainGoodsReviewsStatisticsByTime
     * @Description: TODO(信息统计-商品评论统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
     * @param @param map
     * @param @return    设定文件 
     * @return Long 返回类型 
     * @author wangmei
     */
    Long gainGoodsReviewsStatisticsByTime(Map<String, Object> map);

	/**
	* @Title: gainAppraiseList
	* @Description: TODO(我的评论列表)
	* @param @param map
	* @param @return????设定文件
	* @return List<Appraise>????返回类型
	* @throws
	*/
	List<Appraise> gainAppraiseList(Map<String, Object> map);

	/**
	* @Title: gainAppraiseListCount
	* @Description: TODO(我的评论列表数目)
	* @param @param map
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainAppraiseListCount(Map<String, Object> map);

	/**
	* @Title: gainAllCountRight
	* @Description: TODO(统计评论)
	* @param @param userId
	* @param @return????设定文件
	* @return StatisticsInfo????返回类型
	* @throws
	*/
	StatisticsInfo gainAllCountRight(String userId);

	/**
	* @Title: gainAppraiseListByType
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return????设定文件
	* @return List<Appraise>????返回类型
	* @throws
	*/
	List<Appraise> gainAppraiseListByType(Map<String, Object> map);

	/**
	* @Title: gainAppraiseListCountByType
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainAppraiseListCountByType(Map<String, Object> map);

	/**
	* @Title: gainAllCountRightByCompany
	* @Description: TODO(企业会员右侧显示)
	* @param @param userId
	* @param @return????设定文件
	* @return StatisticsInfo????返回类型
	* @throws
	*/
	StatisticsInfo gainAllCountRightByCompany(String userId);
	
	/**
	 * @Title: gainIntegrityLevelStatisticsByTime
	 * @Description: TODO(信息统计-诚信(信誉+质量+服务+物流)等级统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年))
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainIntegrityLevelStatisticsByTime(Map<String, Object> map);
	
	/**
	 * 根据GOODSID 查询对商品的评价
	* @Title: gainAllByGoodsId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<Appraise>    返回类型
	* @author 周张豹
	 */
	public List<Appraise> gainAllByGoodsId(String goodsId);

	public void deleteByOrderId(String id);

	Goods selectAppraiseCount(String id);

	List<Appraise> selectAppariseByTypeAndPage(Map<String, Object> parmMap);

	Long selectAppariseByTypeAndPageCount(Map<String, Object> parmMap);

	/**
	 * @Title goodEvaluate
	 * @Description TODO(好评的数量)
	 * @param companyId
	 * @return
	 * @author Jason
	 */
	Long goodEvaluate(String companyId);
	/**
	 * @Title goodEvaluate
	 * @Description TODO(总评价数)
	 * @param companyId
	 * @return
	 * @author Jason
	 */
	Long Evaluate(String companyId);
}