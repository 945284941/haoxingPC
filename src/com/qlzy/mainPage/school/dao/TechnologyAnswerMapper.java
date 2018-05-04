package com.qlzy.mainPage.school.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.QuestionLog;
import com.qlzy.model.TechnologyAnswer;

public interface TechnologyAnswerMapper {
    /**
     * @author HuifengWang
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * @author HuifengWang
     * 插入数据,所有列
     * @param record
     * @return
     */
    int insert(TechnologyAnswer record);

    /**
     * @author HuifengWang
     * 根据条件插入数据列
     * @param record
     * @return
     */
    int insertSelective(TechnologyAnswer record);

    /**
     * @author HuifengWang
     * 根据主键查询
     * @param id
     * @return
     */
    TechnologyAnswer selectByPrimaryKey(String id);

    /**
     * @author HuifengWang
     * 根据条件更新列
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TechnologyAnswer record);

    /**
     * @author HuifengWang
     * 更新所有列
     * @param record
     * @return
     */
    int updateByPrimaryKey(TechnologyAnswer record);

	/**
	 * @author HuifengWang
	 * 根据Map参数查询技术答疑列表,带分页
	 * @param map
	 * @return
	 */
	List<TechnologyAnswer> gainTechnologyAnswerListWithPage(Map<String, Object> map);
	/**
	 * @author HuifengWang
	 * 根据Map参数查询技术答疑列表数量,带分页
	 * @param map
	 * @return
	 */
	Long gainTechnologyAnswerListCountWithPage(Map<String, Object> map);

	/**
	 * @author HuifengWang
	 * 根据map参数获取回答列表
	 * @param map
	 * @return
	 */
	List<QuestionLog> gainAskList(Map<String, Object> map);

	/**
	* @Title: gainAnswerList
	* @Description: TODO(会员中心回答列表)
	* @param @param map
	* @param @return设定文件
	* @return List<QuestionLog>返回类型
	* @throws
	*/
	List<QuestionLog> gainAnswerList(Map<String, Object> map);

	/**
	* @Title: gainAnswerListCount
	* @Description: TODO(会员中心回答列表)
	* @param @param map
	* @param @return设定文件
	* @return Long返回类型
	* @throws
	*/
	Long gainAnswerListCount(Map<String, Object> map);

	/**
	* @Title: deleteByIds
	* @Description: TODO(批量删除)
	* @param @param questionAskIds设定文件
	* @return void返回类型
	* @throws
	*/
	void deleteByIds(List<String> list);

	/**
	* @Title: deleteByQuestionById
	* @Description: TODO(根据questionId 删除)
	* @param @param list设定文件
	* @return void返回类型
	* @throws
	*/
	void deleteByQuestionById(String string);
	
	/**
	 * @Title: gainAnswerStatisticsByTime
	 * @Description: TODO(活动统计-回答问题统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainAnswerStatisticsByTime(Map<String, Object> map);

	/**
	 * @author HuifengWang
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> gainJsdyAnswerPaihangbangList(
			Map<String, Object> map);

	/**
	 * @author HuifengWang
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> gainXiazaiBangList(Map<String, Object> map);
}