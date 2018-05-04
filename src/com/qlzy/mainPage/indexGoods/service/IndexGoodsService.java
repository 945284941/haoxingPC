/**  
* @Title: IndexGoodsService.java
* @Package com.qlzy.mainPage.service
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-5-11 下午2:23:44
* @version V1.0  
*/
package com.qlzy.mainPage.indexGoods.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Goods;
import com.qlzy.model.GoodsCat;
import com.qlzy.model.GoodsHot;

/**
 * @ClassName: IndexGoodsService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-5-11 下午2:23:44
 */
public interface IndexGoodsService {


	/***
	 * 查询商家的推荐商品
     * @return
     */
	List<Goods> selectGoodsByType(Map<String,Object> parmMap);

	/**
	* @Title: 根据类型获取热销商品
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param type
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	 */
	public List<Goods> gainHotGoods(String type, String cat,Integer goodsLang);
	
	/**
	* @Title: gainGoodsCat
	* @Description: TODO(根据显示个数获取一级分类)
	* @param @param catLang
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	* @author 周张豹
	 */
	public List<GoodsCat> gainGoodsCat(Integer catLang);
	
	/**
	* @Title: gainGoodsByType
	* @Description: TODO(根据类型和查询的数量获取商品，类型比如：热销、新品，当数量为空表示获取全部的商品)
	* @param @param type
	* @param @param goodsLang
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	 */
	public List<Goods> gainGoodsByType(String type , Integer goodsLang);
	public List<Goods> gainGoodsByTypeIndex(String type , Integer goodsLang);

	
	/**
	 * 查询全部
	* @Title: selectAll
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return Goods    返回类型
	* @author 周张豹
	 */
	public List<Goods> selectAll();
	
	public void insertGoodsPic(String id,String goodsId,String companyId,String pic );

	/**
	 * 根据商品的分类ID查询商城页面中左边相关热卖商品<br>所查询的商品是根据销量和点击量排序<br>	基数为1，其中销量占0.7，点击量占0.3
	* @Title: gianHotGoodsByGoodId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param goodsCatId
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	*/
	public List<Goods> gianHotGoodsByGoodCatId(String goodsCatId,Integer goodsLang);
	public List<Goods> gianHotGoodsByShGoodCatId(String shCatId, Integer goodsLang);
	
	/**
	 * 临时使用，新增一条祝福语
	* @Title: insertBenison
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map    设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public void insertBenison(Map<String, Object> map);

	/**
	 * 临时使用，查询所有的祝福语
	* @Title: gainBenisons
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public List<Goods> gainBenisons();
	
	public List<GoodsHot> gainGoodsHotT();

	public List<GoodsHot> gainGoodsHotP();
	
	public List<GoodsHot> gainGoodsHotG();

	public List<GoodsHot> gainGoodsHot();
	
	public List<GoodsHot> gainGoodsHotS();

	public List<Goods> gainShIndexGoodsList(String string, int i);

	public List<Goods> gainGoodsByShType(String type , Integer goodsLang);

	public Integer gainShGoodsNum();

	public List<Goods> gainGoodsByTypeListAll(Map<String, Object> map);

	public Long gainGoodsByTypeListAllcount(Map<String, Object> map);

	public void updateGoods(Goods goods);

	/**
	 * 根据类目查找商品列表
	 * @param carPartsId
	 * @return
	 */
	public List<Goods> queryGoodsByCarPartsId(String carPartsId, int goodsLang, int goodsLang2);


	Goods gainGoodsByParm(Map<String, Object> parmMap);
}
