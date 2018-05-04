/**??
* @Title: MagazineService.java
* @Package magazine.service
* @Description: TODO(用一句话描述该文件做什么)
* @author zhao yang bin
* @date 2013-11-2 下午2:23:16
* @version V1.0??
*/
package com.qlzy.mainPage.magazine.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.MagazineMessage;
import com.qlzy.model.News;

/**
 * @ClassName: MagazineService
 * @Description: TODO(杂志相关操作)
 * @author zhao yang bin
 * @date 2013-11-2 下午2:23:16
 *
 */
public interface MagazineService {

	/**
	* @Title: gainLeftMagazineList
	* @Description: TODO(杂志左边菜单栏)
	* @param @return设定文件
	* @return Map<String,List<News>>返回类型
	* @throws
	*/
	Map<String, List<News>> gainLeftMagazineList();

	/**
	* @Title: gainMagazineList
	* @Description: TODO(得到每期杂志列表)
	* @param @return设定文件
	* @return List<MagazineMessage>返回类型
	* @throws
	*/
	List<MagazineMessage> gainMagazineList();

}
