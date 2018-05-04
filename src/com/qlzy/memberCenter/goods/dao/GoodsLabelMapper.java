package com.qlzy.memberCenter.goods.dao;

import java.util.List;

import com.qlzy.model.GoodsLabel;

/**
* @ClassName: GoodsLabelMapper
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 赵阳彬
* @date 2013-4-17 下午1:39:03
*/
public interface GoodsLabelMapper {
  /**
   * 
  * @Title: gainGoodsLabelList
  * @Description: TODO(商品标签列表)
  * @param @param goodsLabel
  * @param @return    设定文件
  * @return List<GoodsLabel>    返回类型
   */
    List<GoodsLabel> gainGoodsLabelList(GoodsLabel goodsLabel);
    /**
     * 
    * @Title: gainGoodsLabelList
    * @Description: TODO(商品标签列表页数)
    * @param @param goodsLabel
    * @param @return    设定文件
    * @return List<GoodsLabel>    返回类型
     */
	Long gainGoodsLabelListCount(GoodsLabel goodsLabel);
	/**
	   * 
	  * @Title: gainGoodsLabelList
	  * @Description: TODO(根据id删除商品标签)
	  * @param @param goodsLabel
	  * @param @return    设定文件
	  * @return List<GoodsLabel>    返回类型
	   */
	void deleteByPrimaryKey(List list);
	/**
	   * 
	  * @Title: gainGoodsLabelList
	  * @Description: TODO(添加商品标签)
	  * @param @param goodsLabel
	  * @param @return    设定文件
	  * @return List<GoodsLabel>    返回类型
	   */
	void addGoodsLabel(GoodsLabel goodsLabel);
	/**
	   * 
	  * @Title: gainGoodsLabelList
	  * @Description: TODO(编辑商品标签)
	  * @param @param goodsLabel
	  * @param @return    设定文件
	  * @return List<GoodsLabel>    返回类型
	   */
	void updateGoodsLabel(GoodsLabel goodsLabel);
	/**
	* @Title: gainGoodsByName
	* @Description: TODO(标签名称唯一性验证)
	* @param @param name
	* @param @return    设定文件
	* @return List<GoodsLabel>    返回类型
	*/
	List<GoodsLabel> gainGoodsByName(String name);

}