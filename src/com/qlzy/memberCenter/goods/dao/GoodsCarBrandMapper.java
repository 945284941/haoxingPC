package com.qlzy.memberCenter.goods.dao;

import java.util.List;

import com.qlzy.model.GoodsCarBrand;

public interface GoodsCarBrandMapper {

	/**
	* @Title: addGoodsMidCarBrand
	* @Description: TODO添加商品跟carbrand 中间数据
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void addGoodsMidCarBrand(List<GoodsCarBrand> list);
	
	/**
	* @Title: dropGoodsMidCarBrand
	* @Description: TODO删除商品跟carbrand中间表数据
	* @param @param goodsId    设定文件
	* @return void    返回类型
	*/
	void dropGoodsMidCarBrand(String goodsId);

	/**
	* @Title: gainGoodsMidCarBrand
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return List<String>    返回类型
	*/
	List<String> gainGoodsMidCarBrand(String id);

	/**
	* @Title: deleteGoodsMidCarBrandByGoodsId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void deleteGoodsMidCarBrandByGoodsId(List<String> list);

	/**
	* @Title: dropGoodsMidCarBrandByGoodsId
	* @Description: TODO批量删除商品跟carBrand之间的关系数据
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void dropGoodsMidCarBrandByGoodsId(List<String> list);

	/**
	* @Title: recoverGoodsMidCarBrand
	* @Description: TODO批量恢复商品跟品牌的中间数据
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void recoverGoodsMidCarBrand(List<String> list);

	/**
	* @Title: addGoodsCarBrandExcel
	* @Description: TODO(excel上传添加中间表信息)
	* @param @param listCarBrands    设定文件
	* @return void    返回类型
	*/
	void addGoodsCarBrandExcel(List<GoodsCarBrand> listCarBrands);
}