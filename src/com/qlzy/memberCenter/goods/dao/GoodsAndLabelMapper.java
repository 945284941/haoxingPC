package com.qlzy.memberCenter.goods.dao;

import java.util.List;

import com.qlzy.model.Goods;
import com.qlzy.model.GoodsAndLabel;
import com.qlzy.model.GoodsLabel;

/**
* @ClassName: GoodsAndLabelMapper
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 赵阳彬
* @date 2013-4-17 下午1:48:00
*/
public interface GoodsAndLabelMapper {

	/**
	* @Title: gainGoodsAndLabelByGoodsId
	* @Description: 查找不在该标签下的商品列表
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<GoodsAndLabel>    返回类型
	*/
	List<Goods> gainGoodsListByLabelIdEdit(GoodsLabel goodsLabel);

	/**
	* @Title: gainGoodsAndLabelByGoodsId
	* @Description: 查找不在该标签下的商品列表的数目
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<GoodsAndLabel>    返回类型
	*/
	Long gainGoodsListByLabelCountEdit(GoodsLabel goodsLabel);

	/**
	* @Title: gainGoodsAndLabelByGoodsId
	* @Description: 查找在该标签下的商品列表
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<GoodsAndLabel>    返回类型
	*/
	List<Goods> gainGoodsListByLabelId(GoodsLabel goodsLabel);
	/**
	* @Title: gainGoodsAndLabelByGoodsId
	* @Description: 查找在该标签下的商品列数目
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<GoodsAndLabel>    返回类型
	*/
	Long gainGoodsListByLabelIdCount(String labelId);

	/**
	* @Title: gainGoodsAndLabelByGoodsId
	* @Description: 编辑页面删除商品
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<GoodsAndLabel>    返回类型
	*/
	void deleteGoodsByGoodsLabel(List<String> l);

	/**
	* @Title: gainGoodsAndLabelByGoodsId
	* @Description: 添加商品标签
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<GoodsAndLabel>    返回类型
	*/
	int addGoodsLabel(GoodsAndLabel record);

	/**
	* @Title: gainGoodsAndLabelByGoodsId
	* @Description: 删除商品标签
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<GoodsAndLabel>    返回类型
	*/
	void deleteByGoodsLabel(String string);
	
	/**
	* @Title: gainGoodsAndLabelByGoodsId
	* @Description: 批量删除标签下的商品
	* @param @param goodsId
	* @param @return    设定文件
	* @return List<GoodsAndLabel>    返回类型
	*/
	public List<GoodsAndLabel> gainGoodsAndLabelByGoodsId(String goodsId);

	/**
	* @Title: addGoodsAndLabel
	* @Description: 中间表添加数据
	* @param @param li    设定文件
	* @return void    返回类型
	*/
	void addGoodsAndLabel(List<GoodsAndLabel> li);

	/**
	* @Title: dropGoodsAndLabelByGoodsId
	* @Description: TODO删除商品跟标签的关联数据
	* @param @param id    设定文件
	* @return void    返回类型
	*/
	void dropGoodsAndLabelByGoodsId(String id);

	/**
	* @Title: deleteGoodsMidGoodsLabelByGoodsId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void deleteGoodsMidGoodsLabelByGoodsId(List<String> list);

	/**
	* @Title: dropGoodsMidGoodsLabelByGoodsId
	* @Description: TODO批量删除商品跟标签之间的关系数据
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void dropGoodsMidGoodsLabelByGoodsId(List<String> list);

	/**
	* @Title: recoverGoodsMidGoodsLabel
	* @Description: TODO批量恢复商品跟GoodsLabel的数据
	* @param @param list    设定文件
	* @return void    返回类型
	*/
	void recoverGoodsMidGoodsLabel(List<String> list);
}