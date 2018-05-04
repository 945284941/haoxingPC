/**??
* @Title: PointDetailService.java
* @Package com.qlzy.memberCenter.person.point.action.service
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-5 上午10:04:06
* @version V1.0??
*/
package com.qlzy.memberCenter.person.point.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.CourtesyMember;
import com.qlzy.model.PointDetail;

/**
 * @ClassName: PointDetailService
 * @Description: TODO(经验值管理)
 * @author zhao  yang bin 
 * @date 2013-10-5 上午10:04:06
 *
 */
public interface PointDetailService {

	/**
	* @Title: gainPointList
	* @Description: TODO(得到经验值列表)
	* @param @param map
	* @param @return设定文件
	* @return List<PointDetail>返回类型
	* @throws
	*/
	List<PointDetail> gainPointList(Map<String, Object> map);

	/**
	* @Title: gainPointListCount
	* @Description: TODO(经验值列表数目)
	* @param @param map
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainPointListCount(Map<String, Object> map);

	/**
	* @Title: deletePointList
	* @Description: TODO(删除)
	* @param @param pointId????设定文件
	* @return void????返回类型
	* @throws
	*/
	void deletePointList(String pointId);

	List<CourtesyMember> gainYouhuiquanList(Map<String, Object> map);

}
