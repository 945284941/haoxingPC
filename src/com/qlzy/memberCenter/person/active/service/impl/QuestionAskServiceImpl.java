/**??
* @Title: QuestionAskServiceImpl.java
* @Package com.qlzy.memberCenter.person.active.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-9-28 上午10:35:32
* @version V1.0??
*/
package com.qlzy.memberCenter.person.active.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qlzy.memberCenter.common.dao.QuestionMapper;
import com.qlzy.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.mainPage.school.dao.TechnologyAnswerMapper;
import com.qlzy.mainPage.school.dao.TechnologyQuestionMapper;
import com.qlzy.memberCenter.person.active.service.QuestionAskService;
import com.qlzy.model.QuestionLog;

/**
 * @ClassName: QuestionAskServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhao yang bin
 * @date 2013-9-28 上午10:35:32
 *
 */
@Service
public class QuestionAskServiceImpl implements QuestionAskService{
	@Autowired
	private TechnologyQuestionMapper technologyQuestionMapper;
	@Autowired
	private TechnologyAnswerMapper technologyAnswerMapper;
	@Autowired
	private QuestionMapper questionMapper;

	@Override
	public List<QuestionLog> gainQuestionAskList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<QuestionLog> list =new ArrayList<QuestionLog>();
		if(map.get("questionType").equals("0")){
			list = technologyQuestionMapper.gainQuestionList(map);
		}else{
			list = technologyAnswerMapper.gainAnswerList(map);
		}
		return list;
	}

	@Override
	public Long gainQuestionAskListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Long count=0l;
		if(map.get("questionType").equals("0")){
			count = technologyQuestionMapper.gainQuestionListCount(map);
		}else{
			count = technologyAnswerMapper.gainAnswerListCount(map);
			
		}
		return count;
	}

	@Override
	public void deleteQuestionAskByIds(String questionAskIds,String questionType) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		String[] ids=questionAskIds.split(",");
		for (int i = 0; i < ids.length; i++) {
			list.add(ids[i]);
		}
		if(questionType.equals("0")){
			technologyQuestionMapper.deleteByIds(list);
			for(int i=0;i<list.size();i++){
				technologyAnswerMapper.deleteByQuestionById(list.get(i));
			}
		}else{
			technologyAnswerMapper.deleteByIds(list);
		}
	}

	public  int   addquestion(Question record){

		return questionMapper.insertSelective(record);
	}

}
