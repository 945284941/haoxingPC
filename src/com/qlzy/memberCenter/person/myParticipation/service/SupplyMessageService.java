/**??
* @Title: SupplyMessageService.java
* @Package com.qlzy.memberCenter.person.myParticipation.service
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-6 下午1:31:48
* @version V1.0??
*/
package com.qlzy.memberCenter.person.myParticipation.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Supply;
import com.qlzy.pojo.StatisticsInfo;

/**
 * @ClassName: SupplyMessageService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhao yang bin
 * @date 2013-10-6 下午1:31:48
 *
 */
public interface SupplyMessageService {

	/**
	* @Title: gainSupplyList
	* @Description: TODO(得到供求列表)
	* @param @param map
	* @param @return????设定文件
	* @return List<SupplyStander>????返回类型
	* @throws
	*/
	List<Supply> gainSupplyList(Map<String, Object> map);

	/**
	* @Title: gainSupplyListCount
	* @Description: TODO(供求列表数目)
	* @param @param map
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainSupplyListCount(Map<String, Object> map);

	/**
	* @Title: gainSupplyMessage
	* @Description: TODO(供求信息左端显示栏)
	* @param @param userId
	* @param @return????设定文件
	* @return StatisticsInfo????返回类型
	* @throws
	*/
	Long gainSupplyMessage(Map map);

}
