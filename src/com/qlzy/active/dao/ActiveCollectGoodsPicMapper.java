package com.qlzy.active.dao;

import java.util.List;

import com.qlzy.model.ActiveCollectGoodsPic;


public interface ActiveCollectGoodsPicMapper {

	/**
	* @Title: insertSelectiveBeach
	* @Description: 
	* @param @param object    设定文件
	* @return void    返回类型
	*/
	void insertSelectiveBeach(List<ActiveCollectGoodsPic> list);

	/**
	* @Title: gainActiveCollectGoodsPicByGoodsId
	* @Description: 
	* @param @param parameter
	* @param @return    设定文件
	* @return List<String>    返回类型
	*/
	List<String> gainActiveCollectGoodsPicByGoodsId(String parameter);
	
}