package com.qlzy.active.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.ActiveCollectGoods;
import com.qlzy.model.ActiveCollectGoodsCheck;
import com.qlzy.model.ActiveCollectGoodsQB;
import com.qlzy.model.CarBrand;
import com.qlzy.model.GoodsCat;

/**
 * @ClassName: CheckService
 * @Description: 
 * @author Huifeng Wang
 * @date 2013-6-21 上午10:42:05
 */
public interface CollectService {
	/**
	* @Title: saveCheck
	* @Description: 保存校对数据
	* @param @param acgc    设定文件
	* @return void    返回类型
	*/
	public void saveCheck(ActiveCollectGoodsCheck acgc);

	/**
	* @Title: gainHasCheckedActiveCollectGoods
	* @Description: 
	* @param @param map    设定文件
	* @return void    返回类型
	*/
	public List<ActiveCollectGoods> gainHasCheckedActiveCollectGoods(Map<String, Object> map);
	
	public void saveActiveCollectGoods(Map<String, Object> map);

	/**
	* @Title: gainHasCheckedActiveCollectGoodsCount
	* @Description: 
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainHasCheckedActiveCollectGoodsCount(Map<String, Object> map);

	/**
	* @Title: gainBrandList
	* @Description: 
	* @param @param i
	* @param @return    设定文件
	* @return List<String>    返回类型
	*/
	public List<CarBrand> gainBrandList(Integer i);

	/**
	* @Title: gainCatList
	* @Description: 
	* @param @param i
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	*/
	public List<GoodsCat> gainCatList(Integer i);

	/**
	* @Title: gainSeriesList
	* @Description: 
	* @param @param pid
	* @param @return    设定文件
	* @return List<CarBrand>    返回类型
	*/
	public List<CarBrand> gainNextCarBrandListByPid(String pid);

	/**
	* @Title: gainNextGoodsListByPid
	* @Description: 
	* @param @param pid
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	*/
	public List<GoodsCat> gainNextGoodsCatListByPid(String pid);

	/**
	* @Title: gainCarBrandNameById
	* @Description: 
	* @param @param pid
	* @param @return    设定文件
	* @return List<String>    返回类型
	*/
	public List<String> gainCarBrandNameById(String pid);

	/**
	* @Title: gainActiveCollectGoodsById
	* @Description: 
	* @param @param parameter
	* @param @return    设定文件
	* @return ActiveCollectGoods    返回类型
	*/
	public ActiveCollectGoods gainActiveCollectGoodsById(String parameter);
	
	/**
	* @Title: gainActiveCollectGoodsQBById
	* @Description: 
	* @param @param parameter
	* @param @return    设定文件
	* @return ActiveCollectGoodsQB    返回类型
	*/
	public ActiveCollectGoodsQB gainActiveCollectGoodsQBById(String parameter);

	/**
	* @Title: gainBrandListByBrandName
	* @Description: 根据名称查询品牌系列
	* @param @param brand
	* @param @return    设定文件
	* @return List<CarBrand>    返回类型
	*/
	public List<CarBrand> gainBrandListByBrandName(String brand);

	/**
	* @Title: gainActiveCollectGoodsPicByGoodsId
	* @Description: 
	* @param @param parameter
	* @param @return    设定文件
	* @return List<String>    返回类型
	*/
	public List<String> gainActiveCollectGoodsPicByGoodsId(String parameter);

	/**
	* @Title: gainNextCarBrandListByPName
	* @Description: 
	* @param @param series
	* @param @return    设定文件
	* @return List<CarBrand>    返回类型
	*/
	public List<CarBrand> gainNextCarBrandListByPName(String parameter);

	/**
	* @Title: gainNextGoodsCatListByPName
	* @Description: 
	* @param @param cat
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	*/
	public List<GoodsCat> gainNextGoodsCatListByPName(String cat);

	/**
	* @Title: gainCheckCountByParam
	* @Description: 
	* @param @param acgc    设定文件
	* @return void    返回类型
	*/
	public Long gainCheckCountByParam(ActiveCollectGoodsCheck acgc);
	
	
	public void test();

	/**
	 * @author HuifengWang
	 * @param string
	 * @return
	 */
	public List<ActiveCollectGoods> gainActiveCollectGoodsByCompanyId(
			String string);

}
