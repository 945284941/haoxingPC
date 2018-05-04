package com.qlzy.memberCenter.goods.dao;

import java.util.List;

import com.qlzy.model.GoodsPic;

public interface GoodsPicMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(GoodsPic record);

    GoodsPic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsPic record);

	/**
	* @Title: insertByList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param goodsPicList    设定文件
	* @return void    返回类型
	*/
	void insertByList(List<GoodsPic> goodsPicList);
	
	List<String> gainGoodsPicListByGoodsId(String goodsId);
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