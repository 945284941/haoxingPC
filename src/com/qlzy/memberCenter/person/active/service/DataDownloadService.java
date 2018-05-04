package com.qlzy.memberCenter.person.active.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.DataDownload;

public interface DataDownloadService {

	/**
	* @Title: gainDataloadList
	* @Description: TODO(得到下载列表)
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
	* @Description: TODO(批量删除)
	* @param @param dataDownloadIds????设定文件
	* @return void????返回类型
	* @throws
	*/
	void deleteDataDownloadByIds(String dataDownloadIds);


	

}
