/**   
 * @Title: QuestionServiceImpl.java 
 * @Package com.qlzy.memberCenter.common.service.impl 
 * @Description: TODO(安全保护问题接口实现类) 
 * @author wangmei   
 * @date 2013-9-26 上午10:59:40 
 * @version V1.0   
 */
package com.qlzy.memberCenter.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.memberCenter.common.dao.QuestionMapper;
import com.qlzy.memberCenter.common.service.QuestionService;
import com.qlzy.model.Question;

@Service("questionService")
@Transactional(rollbackFor=Exception.class)
public class QuestionServiceImpl implements QuestionService {
	@Resource
	private QuestionMapper questionMapper;

	/** (非 Javadoc)
	 * @Title: QuestionServiceImpl.java
	 * @Description: TODO(查询所有安全保护问题)
	 * @param @return
	 * @see com.qlzy.memberCenter.common.service.QuestionService#gainAll()
	 */
	@Override
	public List<Question> gainAll() {
		return questionMapper.gainAll();
	}

}