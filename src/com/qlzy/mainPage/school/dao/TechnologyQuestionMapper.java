package com.qlzy.mainPage.school.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.QuestionLog;
import com.qlzy.model.TechnologyQuestion;

public interface TechnologyQuestionMapper {
    int deleteByPrimaryKey(String id);

    int insert(TechnologyQuestion record);

    int insertSelective(TechnologyQuestion record);

    TechnologyQuestion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TechnologyQuestion record);

    int updateByPrimaryKey(TechnologyQuestion record);

	/**
	 * @author HuifengWang
	 * 根据分类名称查询技术答疑列表带分页
	 * @param map1
	 * @return
	 */
	List<TechnologyQuestion> gainJsdyListByCatNameWithPage(
			Map<String, Object> map1);

	/**
	 * @author HuifengWang
	 * 根据分类名称查询技术答疑列表数量 带分页
	 * @param map1
	 * @return
	 */
	Long gainJsdyListCountByCatNameWithPage(Map<String, Object> map1);

	/**
	 * @author HuifengWang
	 * 根据questionId 更新技术答疑某字段,变成已经回答
	 * @param questionId
	 */
	void updateTQHasAnswered(String questionId);

	/**
	* @Title: gainQuestionList
	* @Description: TODO(会员提问列表)
	* @param @param map
	* @param @return设定文件
	* @return List<QuestionLog>返回类型
	* @throws
	*/
	List<QuestionLog> gainQuestionList(Map<String, Object> map);

	/**
	* @Title: gainQuestionListCount
	* @Description: TODO(会员提问列表数目)
	* @param @param map
	* @param @return设定文件
	* @return Long返回类型
	* @throws
	*/
	Long gainQuestionListCount(Map<String, Object> map);

	/**
	* @Title: deleteByIds
	* @Description: TODO(批量删除)
	* @param @param questionAskIds设定文件
	* @return void返回类型
	* @throws
	*/
	void deleteByIds(List<String> list);
	
	/**
	 * @Title: gainQuestionStatisticsByTime
	 * @Description: TODO(活动统计-提问问题统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainQuestionStatisticsByTime(Map<String, Object> map);
}