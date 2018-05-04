package com.qlzy.memberCenter.person.active.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.DataDownload;



public interface DataDownloadMapper {
    int deleteByPrimaryKey(String id);

    int insert(DataDownload record);

    int insertSelective(DataDownload record);

    DataDownload selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DataDownload record);

    int updateByPrimaryKey(DataDownload record);

	/**
	* @Title: gainDataloadList
	* @Description: TODO(下载列表)
	* @param @param map
	* @param @return????设定文件
	* @return List<DataDownload>????返回类型
	* @throws
	*/
	List<DataDownload> gainDataloadList(Map<String, Object> map);

	/**
	* @Title: gainDataloadListCount
	* @Description: TODO(下载列表数目)
	* @param @param map
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainDataloadListCount(Map<String, Object> map);

	/**
	* @Title: deleteDataDownloadByIds
	* @Description: TODO(批量删除下载列表)
	* @param @param list????设定文件
	* @return void????返回类型
	* @throws
	*/
	void deleteDataDownloadByIds(List<String> list);
	
	/**
	 * @Title: DataDownloadMapper.java 
	 * @Description: TODO(活动统计-下载资料统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainDownloadStatisticsByTime(Map<String, Object> map);
}