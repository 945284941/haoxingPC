package com.qlzy.memberCenter.goods.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.qlzy.model.CarBrand;
import com.qlzy.model.CarPartsProducer;
import com.qlzy.model.Goods;
import com.qlzy.model.GoodsAndLabel;
import com.qlzy.model.GoodsCat;
import com.qlzy.model.GoodsLabel;
import com.qlzy.model.GoodsSpecification;
import com.qlzy.model.GoodsSpecificationValue;

/**
 * @ClassName: GoodsService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huifeng Wang
 * @date 2013-5-28 下午4:51:12
 *
 */
public interface GoodsService {
	/**
	* @Title: addGoods
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param goods
	* @param @param specValues    设定文件
	* @return void    返回类型
	*/
	public void addGoods (Goods goods,Map<String,Object> map) throws UnsupportedEncodingException;
	
	/**
	 * 根据商品ids查询商品
	* @Title: gainGoodsByIds
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param goodsIds
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	* @author 周张豹
	 */
	public List<Goods> gainGoodsByIds(List<String> goodsIds);
	
	public List<CarBrand> gainBrandList(Integer i);
	public List<GoodsCat> gainCatList(Integer i);
	public List<CarBrand> gainNextCarBrandListByPid(String pid) ;
	public List<GoodsCat> gainNextGoodsCatListByPid(String pid);

	public List<String> gainCarBrandNameById(String id) ;
	public List<CarBrand> gainBrandListByBrandName(String brand) ;
	public List<CarBrand> gainNextCarBrandListByPName(String parameter);

	public List<GoodsCat> gainNextGoodsCatListByPName(String cat) ;

	/**
	* @Title: gainGoodsListByBn
	* @Description: 
	* @param @param string
	* @param @return    设定文件
	* @return Goods    返回类型
	*/
	public List<Goods> gainGoodsListByBn(String string);

	/**
	* @Title: gainGoodsCatList
	* @Description: 
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	*/
	public List<GoodsCat> gainGoodsCatList();

	/**
	* @Title: gainCarPartsProducer
	* @Description: 
	* @param @return    设定文件
	* @return List<CarPartsProducer>    返回类型
	*/
	public List<CarPartsProducer> gainCarPartsProducer();

	/**
	* @Title: gainGoodsLabels
	* @Description: 
	* @param @return    设定文件
	* @return List<GoodsLabel>    返回类型
	*/
	public List<GoodsLabel> gainGoodsLabels();

	/**
	* @Title: gainGoodsSepcifications
	* @Description: 
	* @param @return    设定文件
	* @return List<GoodsSpecification>    返回类型
	*/
	public List<GoodsSpecification> gainGoodsSepcifications();

	/**
	* @Title: gainGoodsListByCompanyIdWithPage
	* @Description: 
	* @param @param goods
	* @param @return    设定文件
	* @return List<Goods>    返回类型
	*/
	public List<Goods> gainGoodsListByCompanyIdWithPage(Map<String, Object> map);

	/**
	* @Title: gainGoodsListCountByCompanyIdWithPage
	* @Description: 
	* @param @param goods
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainGoodsListCountByCompanyIdWithPage(Map<String, Object> map);

	/**
	* @Title: gainCarBrandList
	* @Description: 
	* @param @return    设定文件
	* @return List<CarBrand>    返回类型
	*/
	public List<CarBrand> gainCarBrandList();

	/**
	* @Title: delete
	* @Description: 
	* @param @param parameter    设定文件
	* @return void    返回类型
	*/
	public void delete(List<String> list);

	/**
	* @Title: drop
	* @Description: 
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	public void drop(List<String> stringConvertList);

	/**
	* @Title: recover
	* @Description: 
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	public void recover(List<String> stringConvertList);

	/**
	 * @author HuifengWang
	 * @param parameter
	 * @return
	 */
	public Goods gainGoodsById(String parameter);

	/**
	 * @author HuifengWang
	 * @return
	 */
	public List<String> gainGoodsPicListByGoodsId(String goodsId);

	/**
	 * @author HuifengWang
	 * @param goodsId
	 * @return
	 */
	public List<GoodsSpecificationValue> gainGoodsSpecificationValueByGoodsId(
			String goodsId);

	/**
	 * @author HuifengWang
	 * @param goodsId
	 * @return
	 */
	public List<GoodsAndLabel> gainGoodsAndLabelsByGoodsId(String goodsId);

	/**
	 * @author HuifengWang
	 * @param goodsId
	 * @return
	 */
	public List<String> gainGoodsMidCarBrand(String goodsId);

	/**
	 * @author HuifengWang
	 * @param carBrand
	 * @return
	 */
	public List<String> gainSecondCarBrand(List<String> carBrand);

	/**
	 * @author HuifengWang
	 * @param goods
	 * @param map
	 * @throws UnsupportedEncodingException
	 */
	public void updateGoods(Goods goods, Map<String, Object> map) throws UnsupportedEncodingException ;

	/**
	 * @author HuifengWang
	 * @param stringConvertList
	 */
	public void marketable(Map<String, Object> map);

	public List<Goods> gainGoodsListByBnAndStanderIsZero(String parameter);

	public List<Map<String, Object>> gainNextGoodsCatListByPid2(String pid);

	/**
	 * 根据商品分类Id查询他爹!
	 * @author HuifengWang
	 * @param carPartsId
	 * @return
	 */
	public String gainGoodsCatPidById(String carPartsId);

	/**
	 * 根据pid查询下一级车型
	 * @author HuifengWang
	 * @param pid
	 * @return
	 */
	public List<Map<String,Object>> gainCarBrandListByPid(String pid);

	public String gainCarBrandPidById(String cpid);

	public String gainGoodsPicById(String goodsId);

	List<Map<String, Object>> gainNextGoodsCatShListByPid2(String pid);

	String gainGoodsCatPidShById(String shcarId);

	public List<Goods> gainGoodsListSearchShGoods(Map<String, Object> map);

	public Long gainGoodsListSearchGoodsShCount(Map<String, Object> map);

	public List<GoodsSpecification> gainSpecification(String string);







	List<Goods> selectByFlashSaleCat(Map<String, Object> parmMap);

	List<Goods> selectGoodsByType(Map<String, Object> parmMap);

	List<Goods> selectGoodsByTypeAndPage(Map<String, Object> parmMap);

	Long selectGoodsByTypeAndPageCount(Map<String, Object> parmMap);


	Goods gainGoodsByPrm(Map<String, Object> parmMap);

	/**
	 * @Title findGoodsListByCompanyId
	 * @Description TODO(店铺详情的左下角的商品列表)
	 * @param id
	 * @return
	 */
	public List<Goods> findGoodsListByCompanyId(String id);

	/**
	 * @Title gainFindGoodsBySelect
	 * @Description TODO(分页条件查询店铺的商品)
	 * @param goods
	 * @Author Jason
	 * @return
	 */
	public List<Goods> gainFindGoodsBySelect(Goods goods);

	/**
	 * @Title gainFindGoodsBySelect
	 * @Description TODO(查询所有的条数)
	 * @param goods
	 * @Author Jason
	 * @return
	 */
	public Long gainFindGoodsBySelectCount(Goods goods);
}
