/**   
 * @Title: QuestionService.java 
 * @Package com.qlzy.memberCenter.common.service 
 * @Description: TODO(安全保护问题接口类) 
 * @author wangmei   
 * @date 2013-9-26 上午10:58:27 
 * @version V1.0   
 */
package com.qlzy.memberCenter.common.service;

import java.util.List;

import com.qlzy.model.Question;

public interface QuestionService {
	
	/**
	 * @Title: gainAll
	 * @Description: TODO(查询所有安全保护问题)
	 * @param @return    设定文件
	 * @return List<Question>    返回类型
	 * @throws
	 * @author wangmei
	 */
	List<Question> gainAll();
}
