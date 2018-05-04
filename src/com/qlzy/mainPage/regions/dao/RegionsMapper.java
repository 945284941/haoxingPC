package com.qlzy.mainPage.regions.dao;

import java.util.List;

import com.qlzy.model.Regions;


public interface RegionsMapper {
    
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
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return Regions    返回类型
	* @throws
	*/
	public Regions gainNameByPid(String id);
	/**
	 * 获取下一级省市区列表
	 * @param list
	 * @return
	 */
	public List<Regions> gainNextCityOrAreaListByPid(List<String> list);
}