package com.qlzy.mainPage.indexGoods.dao;
import java.util.List;
import com.qlzy.model.GoodsHot;
@SuppressWarnings("all")
public interface GoodsHotMapper {
    GoodsHot selectByPrimaryKey(String id);
    /**
    * @Title: updateByPrimaryKeySelective
    * @Description: TODO更新促销活动商品
    * @param @param record
    * @param @return    设定文件
    * @return int    返回类型
    */
    int updateByPrimaryKeySelective(GoodsHot record);

	/**
	 *  添加促销活动商品
	 * @param goodsHot
	 */
	void addGoodsHot(GoodsHot goodsHot);
	
	/**
	* @Title: gainAllWithByPage
	* @Description: TODO(查询所有促销商品)
	* @param @param goodsHot
	* @param @return设定文件
	* @return List<GoodsHot>返回类型
	* @throws
	*/
	List<GoodsHot> gainAllWithByPage(GoodsHot goodsHot);
	/**
	* @Title: gainAllWithByStart
	* @Description: TODO(查询这个时间段活动开始的商品)
	* @param @param goodsHot
	* @param @return设定文件
	* @return List<GoodsHot>返回类型
	* @throws
	*/
	
	List<GoodsHot> gainAllWithByStart(GoodsHot goodsHot);
	
	
	/**
	* @Title: gainAllWithByEnd
	* @Description: TODO(查询这个时间段活动结束的商品)
	* @param @param goodsHot
	* @param @return设定文件
	* @return List<GoodsHot>返回类型
	* @throws
	*/
	List<GoodsHot> gainAllWithByEnd(GoodsHot goodsHot);
	Long gainGoodsHotListCount(GoodsHot goodsHot);
	List<GoodsHot> gainGoodsHotList(GoodsHot goodsHot);
	void dropGoodsHot(List<String> list);
	void autoStart();
	void autoEnd();
	List<GoodsHot> gainGoodsHotT();
	List<GoodsHot> gainGoodsHotP();
	List<GoodsHot> gainGoodsHotG();
	List<GoodsHot> gainGoodsHot();
	List<GoodsHot> gainGoodsHotS();
}