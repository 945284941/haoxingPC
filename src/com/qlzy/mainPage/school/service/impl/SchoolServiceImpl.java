package com.qlzy.mainPage.school.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.mainPage.school.dao.TechnologyAnswerMapper;
import com.qlzy.mainPage.school.dao.TechnologyQuestionMapper;
import com.qlzy.mainPage.school.dao.ZpxyHuodongAttendMapper;
import com.qlzy.mainPage.school.service.SchoolService;
import com.qlzy.model.TechnologyAnswer;
import com.qlzy.model.TechnologyQuestion;
import com.qlzy.model.ZpxyHuodongAttend;
@Service
public class SchoolServiceImpl implements SchoolService{
	@Autowired
	private TechnologyQuestionMapper technologyQuestionMapper;
	@Autowired
	private TechnologyAnswerMapper technologyAnswerMapper;
	@Autowired
	private ZpxyHuodongAttendMapper zpxyHuodongAttendMapper;
	@Override
	public void insertJsdy(TechnologyQuestion technologyQuestion) {
		technologyQuestionMapper.insertSelective(technologyQuestion);
	}
	@Override
	public TechnologyQuestion gainTechnologyQuestionById(String id) {
		// TODO Auto-generated method stub
		return technologyQuestionMapper.selectByPrimaryKey(id);
	}
	@Override
	public void updateTechnologyQuestion(TechnologyQuestion tec) {
		technologyQuestionMapper.updateByPrimaryKeySelective(tec);
	}
	@Override
	public List<TechnologyAnswer> gainTechnologyAnswerListWithPage(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return technologyAnswerMapper.gainTechnologyAnswerListWithPage(map);
	}
	@Override
	public Long gainTechnologyAnswerListCountWithPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return technologyAnswerMapper.gainTechnologyAnswerListCountWithPage(map);
	}
	@Override
	public void addTechnologyAnswer(TechnologyAnswer ta) {
		technologyAnswerMapper.insertSelective(ta);
		technologyQuestionMapper.updateTQHasAnswered(ta.getQuestionId());
	}
	@Override
	public void addZpxyHuodongAttend(ZpxyHuodongAttend za) {
		zpxyHuodongAttendMapper.insertSelective(za);
	}
	/* (non-Javadoc)
	 * @see com.qlzy.mainPage.school.service.SchoolService#gainJsdyAnswerPaihangbangList(java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> gainJsdyAnswerPaihangbangList(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return technologyAnswerMapper.gainJsdyAnswerPaihangbangList(map);
	}
	@Override
	public List<Map<String, Object>> gainXiazaiBangList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return technologyAnswerMapper.gainXiazaiBangList(map);
	}

}
