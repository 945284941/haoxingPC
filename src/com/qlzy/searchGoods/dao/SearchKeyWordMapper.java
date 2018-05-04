package com.qlzy.searchGoods.dao;

import java.util.List;

import com.qlzy.model.SearchKeyWord;


public interface SearchKeyWordMapper {
    int deleteByPrimaryKey(String id);

    int insert(SearchKeyWord record);

   

    SearchKeyWord selectByPrimaryKey(String id);

    

    int updateByPrimaryKey(SearchKeyWord record);

	/**
	* @Title: gainByName
	* @Description: TODO(根据关键查找该关键字是否存在过)
	* @param @param topSearchLike
	* @param @return    设定文件
	* @return SearchKeyWord    返回类型
	*/
	List<SearchKeyWord> gainByName(String topSearchLike);
	 void addSearchKeyWord(SearchKeyWord record);
	 void updateByPrimaryKeySelective(SearchKeyWord record);
    
}