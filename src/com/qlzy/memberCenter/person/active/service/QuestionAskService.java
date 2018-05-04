/**??
* @Title: QuestionAskService.java
* @Package com.qlzy.memberCenter.person.active.service
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-9-28 上午10:35:08
* @version V1.0??
*/
package com.qlzy.memberCenter.person.active.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Question;
import com.qlzy.model.QuestionLog;

/**
 * @ClassName: QuestionAskService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhao yang bin
 * @date 2013-9-28 上午10:35:08
 *
 */
public interface QuestionAskService {

	/**
	* @Title: gainQuestionAskList
	* @Description: TODO(答问列表)
	* @param @param map
	* @param @return????设定文件
	* @return List<QuestionAsk>????返回类型
	* @throws
	*/
	List<QuestionLog> gainQuestionAskList(Map<String, Object> map);

	/**
	* @Title: gainQuestionAskListCount
	* @Description: TODO(答问列表数目)
	* @param @param map
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainQuestionAskListCount(Map<String, Object> map);

	/**
	 * @param questionType 
	* @Title: deleteQuestionAskByIds
	* @Description: TODO(批量删除)
	* @param @param questionAskIds????设定文件
	* @return void????返回类型
	* @throws
	*/
	void deleteQuestionAskByIds(String questionAskIds, String questionType);

	/**
	 * @param questionType
	 * @Title: deleteQuestionAskByIds
	 * @Description: TODO(新增)
	 * @param @param questionAskIds????设定文件
	 * @return void????返回类型
	 * @throws
	 */
	int  addquestion(Question record);
}
