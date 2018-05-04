package com.qlzy.mainPage.indexGoods.dao;

import java.util.List;

import com.qlzy.model.GoodsSpecificationValue;
;


public interface GoodsSpecificationValueMapper {

	/**
	 * 根据商品ID查询商品属性
	* @Title: gainGoodsAttributeById
	* @Description: TODO(根据商品ID查询商品属性)
	* @param @param id
	* @param @return    设定文件
	* @return Map<String,Object>    返回类型
	* @author 周张豹
	 */
	public List<GoodsSpecificationValue> gainGoodsAttributeById(String goodsId);
}