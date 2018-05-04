/**  
 * @Title: RegionsService.java 
 * @Package com.qlzy.mainPage.service 
 * @Description: TODO(地区接口类)
 * @author wangmei  
 * @date 2013-5-8 上午11:34:07
 * @version V1.0  
 */
package com.qlzy.mainPage.regions.service;

import java.util.List;

import com.qlzy.model.ReceiveAddress;
import com.qlzy.model.Regions;

public interface RegionsService {
	
	/**
	 * @Title: gainProvinceList
	 * @Description: TODO(查询省份列表)
	 * @param @return    设定文件
	 * @return List<Regions>    返回类型
	 */
	public List<Regions> gainProvinceList();
	/**
	 * @Title: gainCityListByPid
	 * @Description: TODO(根据省份id查询其市列表)
	 * @param @param pid
	 * @param @return    设定文件
	 * @return List<Regions>    返回类型
	 */
	public List<Regions> gainCityListByPid(String pid);
	
	public List<Regions> gainAreaListByCityId(String cityId);
	/**
	* @Title: gainNameByPid
	* @Description: TODO(根据id找名字)
	* @param @param id
	* @param @return    设定文件
	* @return Object    返回类型
	* @throws
	*/
	public Regions gainNameByPid(String id);
	
	public List<Regions> gainNextCityOrAreaListByPid(String pid);
	
}
