package com.qlzy.mainPage.indexGoods.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Goods;
import com.qlzy.model.GoodsAndSku;
import com.qlzy.model.GoodsItem;

/**
* @ClassName: GoodsMapper
* @Description: TODO前台商品管理
* @author Huifeng Wang
* @date 2013-5-7 上午11:36:53
*
*/
public interface GoodsMapper {
	
	/**
	* @Title: gainHotGoods
	* @Description: TODO:  根据商品类型获取
	* @param @param type
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	 */
	public List<Goods> gainHotGoods(Map<String, Object> map);

	/**
	* @Title: gainGoodsByType
	* @Description: TODO(根据类型和查询的数量获取商品，类型比如：热销、新品，当数量为空表示获取全部的商品)
	* @param @param type
	* @param @param goodsLang
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	*/
	
	public List<Goods> gainGoodsByTypeIndex(Map<String, Object> map);
	public List<Goods> gainGoodsByType(Map<String, Object> map);
	
	/**
	 * 根据商品ID查询商品信息
	* @Title: gainGoodsById
	* @Description: TODO(根据商品ID查询商品信息)
	* @param @param id
	* @param @return    设定文件
	* @return Goods    返回类型
	* @author 周张豹
	 */
	public Goods gainGoodsById(String id);
	public Goods gainGoodsByPrm(Map<String,Object> parmMap);
	
	/**
	 * 根据商品ID查询商品图片
	* @Title: gainGoodsPicById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return String    返回类型
	* @author 周张豹
	 */
	public String gainGoodsPicById(String id);
	/**
	* @Title: insertGoodsPic
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map    设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void insertGoodsPic(Map<String, Object> map);

	/**
	* @Title: selectAll
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	*/
	public List<Goods> selectAll();
	
	/**
	 * 根据商品的ID集合查询商品
	* @Title: selectGoodsByIds
	* @Description: TODO(根据商品的ID集合查询商品)
	* @param @param ids
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	 */
	public List<Goods> selectGoodsByIds(List<String> id);
	
	/**
	 * 根据用户的ID查询购物车的信息。展示的字段主要有商品ID、商品名称、商品价格、购物车数量、商品的默认图片
	* @Title: selectGoodsByCart
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param userId
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	 */
	public List<Goods> selectGoodsByCart(String userId);
	
	/**
	 * @Title: gainComGoodsListByCat
	 * @Description: TODO(查询某商品分类下的商品信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<Goods>    返回类型
	 * @author wangmei
	 */
	List<Goods> gainComGoodsListByCat(Map<String, Object> map);

	/**
	 * 根据商品的分类ID查询商城页面中左边相关热卖商品<br>所查询的商品是根据销量和点击量排序<br>	基数为1，其中销量占0.7，点击量占0.3
	* @Title: gianHotGoodsByGoodId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param goodsCatId
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	*/
	public List<Goods> gianHotGoodsByGoodCatId(Map<String, Object> map);
	public List<Goods> gianHotGoodsByShGoodCatId(Map<String, Object> map);

	/**
	 * @Title: gainGoodsListByCompanyIdForPage
	 * @Description: TODO(根据商家ID查询商品列表信息(带分页))
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<Goods>    返回类型
	 * @author wangmei
	 */
	List<Goods> gainGoodsListByCompanyIdForPage(Map<String, Object> map);

	/**
	 * @Title: gainGoodsListCountByCompanyId
	 * @Description: TODO(根据商家ID查询商品)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	Long gainGoodsListCountByCompanyId(Map<String, Object> map);

	/**
	* @Title: gainComGoodsListByMemberCatCount
	* @Description: TODO()
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainComGoodsListByMemberCatCount(Map<String,Object> map);

	/**
	* @Title: gainGoodsListByBn
	* @Description: 
	* @param @param string
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	*/
	public List<Goods> gainGoodsListByBn(String string);
	/**
	 * @author HuifengWang
	 * @param string
	 * @return
	 */
	public List<Goods> gainGoodsListByBnAndStanderIsZero(String string);


	/**
	* @Title: addGoods
	* @Description: 
	* @param @param goods    设定文件
	* @return void    返回类型
	*/
	public void addGoods(Goods goods);
	
	public  List<Goods> gainGoodsListByCompanyIdWithPage(Map<String, Object> map);

	/**
	* @Title: gainGoodsListCountByCompanyIdWithPage
	* @Description: 
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainGoodsListCountByCompanyIdWithPage(Map<String, Object> map);

	/**
	* @Title: delete
	* @Description: 
	* @param @param id    设定文件
	* @return void    返回类型
	*/
	public void delete(List<String> ids);
	
	/**
	 * @Title: gainGoodsListCountByCompanyId
	 * @Description: TODO(根据商家ID查询某类型的商品信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Long    返回类型
	 * @author wangmei
	 */
	public List<Goods> gainSomeTypeGoodsByCompanyId(Map<String, Object> map);

	/**
	* @Title: drop
	* @Description: 
	* @param @param ids    设定文件
	* @return void    返回类型
	*/
	public void drop(List<String> ids);

	/**
	* @Title: recover
	* @Description: 
	* @param @param ids    设定文件
	* @return void    返回类型
	*/
	public void recover(List<String> ids);
	
	/**
	 * 临时使用的，新增一条祝福语
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
	* @param @return    设定文件
	* @return List<String>    返回类型
	* @author 周张豹
	*/
	public List<Goods> gainBenisons();
	
	/**
	 * @Title: GoodsMapper.java 
	 * @Description: TODO(购物车统计-购物车商品数量(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long  gainShoppingCartQuantityByTime(Map<String, Object> map);
	
	/**
	 * @Title: GoodsMapper.java 
	 * @Description: TODO(购物车统计-购物车商品总价(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Double 返回类型 
	 * @author wangmei
	 */
	Double gainShoppingCartTotalByTime(Map<String, Object> map);
	
	/**
	 * @Title: gainGoodsStatisticsByTime
	 * @Description: TODO(信息统计-商品统计(根据时段查询,例如昨日、今日、近三天、近一周、本月、本年)) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainGoodsStatisticsByTime(Map<String, Object> map);

	public void updateByPrimaryKeySelective(Goods goods);

	public void marketable(Map<String,Object> map);

	public void insertBatch(List<Goods> temp);

	public List<Goods> gainGoodsListSearchShGoods(Map<String, Object> map);

	public Long gainGoodsListSearchGoodsShCount(Map<String, Object> map);

	public List<Goods> gainGoodsByShType(Map<String, Object> map);

	public List<Goods> gainShIndexGoodsList(Map<String, Object> map);

	public Integer gainShGoodsNum();

	public List<Goods> gainGoodsByTypeListAll(Map<String, Object> map);

	public Long gainGoodsByTypeListAllcount(Map<String, Object> map);
	public List<Goods> gainGoodsByTypeList(Map<String, Object> map);

	public Long gainGoodsByTypeListcount(Map<String, Object> map);
	
	/**
	 * 根据类目查找商品列表
	 * @return
	 */
	public List<Goods> queryGoodsByCarPartsId(Map<String, Object> map/*String carPartsId*/);

	List<Goods> selectByFlashSaleCat(Map<String, Object> parmMap);

	List<Goods> selectGoodsByType(Map<String, Object> parmMap);

	List<Goods> selectGoodsByTypeAndPage(Map<String, Object> parmMap);

	Long selectGoodsByTypeAndPageCount(Map<String, Object> parmMap);


	/***
	 *
	 * @param parmMap
	 * @return
     */
	List<Goods> gainCompanyHotGoodsByTypeIndex(Map<String, Object> parmMap);
	/**
	 * @Title findGoodsListByCompanyId
	 * @Description TODO(店铺详情的左下角的商品列表)
	 * @param id
	 * @return
	 */
	List<Goods> findGoodsListByCompanyId(String companyId);
	/**
	 * @Title gainFindGoodsBySelect
	 * @Description TODO(分页条件查询店铺的商品)
	 * @param goods
	 * @Author Jason
	 * @return
	 */
	List<Goods> gainFindGoodsBySelect(Goods goods);
	/**
	 * @Title gainFindGoodsBySelect
	 * @Description TODO(总数)
	 * @param goods
	 * @Author Jason
	 * @return
	 */
	Long gainFindGoodsBySelectCount(Goods goods);
}