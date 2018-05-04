package com.qlzy.memberCenter.common.dao;

import java.util.List;

import com.qlzy.model.Question;

public interface QuestionMapper {

	/**
	 * @Title: gainAll
	 * @Description: TODO(查询所有安全保护问题)
	 * @param @return    设定文件
	 * @return List<Question>    返回类型
	 * @throws
	 * @author wangmei
	 */
    List<Question> gainAll();

    int updateByPrimaryKeySelective(Question record);

	int  insertSelective(Question record);
}