package com.qlzy.memberCenter.goods.dao;

import java.util.List;

import com.qlzy.model.GoodsSpecificationValue;

public interface SpecificationValueMapper {

	/**
	* @Title: addSpecificationValue
	* @Description: TODO添加商品同时添加商品规格值
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void addSpecificationValue(List<GoodsSpecificationValue> list);
	/**
	* @Title: dropSepcificationValue
	* @Description: TODO根据商品Id,删除相关联的规格
	* @param @param id    设定文件
	* @return void    返回类型
	*/
	void dropSepcificationValueByGoodsId(String id);

	/**
	* @Title: gainGoodsSpecificationsByGoodsI
	* @Description: TODO根据商品Id获取关联的规格项目
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<GoodsSpecification>    返回类型
	*/
	List<GoodsSpecificationValue> gainGoodsSpecificationValueByGoodsId(String goodsId);
	/**
	* @Title: deleteGoodsMidSpecValueByGoodsId
	* @Description: TODO逻辑删除关联表内容
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void deleteGoodsMidSpecValueByGoodsId(List<String> list);
	/**
	* @Title: dropGoodsMidSpecValueByGoodsId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void dropGoodsMidSpecValueByGoodsId(List<String> list);
	/**
	* @Title: recoverGoodsMidSpecValue
	* @Description: TODO恢复商品跟规格的中间数据
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void recoverGoodsMidSpecValue(List<String> list);
	
}