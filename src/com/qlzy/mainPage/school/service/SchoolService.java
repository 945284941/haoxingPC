package com.qlzy.mainPage.school.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.TechnologyAnswer;
import com.qlzy.model.TechnologyQuestion;
import com.qlzy.model.ZpxyHuodongAttend;

public interface SchoolService {

	/**
	 * @author HuifengWang
	 * 插入技术答疑
	 * @param technologyQuestion
	 */
	void insertJsdy(TechnologyQuestion technologyQuestion);

	/**
	 * @author HuifengWang
	 * 根据ID获取技术答疑实体类
	 * @param id
	 * @return
	 */
	TechnologyQuestion gainTechnologyQuestionById(String id);

	/**
	 * @author HuifengWang
	 * 更新技术答疑
	 * @param tec
	 */
	void updateTechnologyQuestion(TechnologyQuestion tec);

	/**
	 * @author HuifengWang
	 * 根据Map参数查询技术答疑列表,带分页
	 * @param map
	 * @return
	 */
	List<TechnologyAnswer> gainTechnologyAnswerListWithPage(
			Map<String, Object> map);
	/**
	 * @author HuifengWang
	 * 根据Map参数查询技术答疑列表数量,带分页
	 * @param map
	 * @return
	 */
	Long gainTechnologyAnswerListCountWithPage(Map<String, Object> map);

	/**
	 * @author HuifengWang
	 * 添加技术答疑
	 * @param ta
	 */
	void addTechnologyAnswer(TechnologyAnswer ta);

	/**
	 * @author HuifengWang
	 * 添加重配学院活动
	 * @param za
	 */
	void addZpxyHuodongAttend(ZpxyHuodongAttend za);

	/**
	 * @author HuifengWang
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> gainJsdyAnswerPaihangbangList(Map<String, Object> map);

	/**
	 * @author HuifengWang
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> gainXiazaiBangList(Map<String, Object> map);

}
