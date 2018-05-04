package com.qlzy.mainPage.indexGoods.dao;

import java.util.List;

import com.qlzy.model.GoodsHotPic;


public interface GoodsHotPicMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(GoodsHotPic record);

    GoodsHotPic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsHotPic record);

	/**
	* @Title: insertByList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param goodsPicList    设定文件
	* @return void    返回类型
	*/
	void insertByList(List<GoodsHotPic> goodsPicList);
	
	List<String> gainGoodsPicListByGoodsId(List<String> list);
	/**
	* @Title: dropGoodsPicBySrc
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param de    设定文件
	* @return void    返回类型
	*/
	void dropGoodsPicBySrc(String de);

	/**
	* @Title: dropGoodsPicByGoodsId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void dropGoodsPicByGoodsId(List<String> list);
}