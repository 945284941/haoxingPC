package com.qlzy.mainPage.head.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.GoodsCat;


public interface GoodsCatMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsCat record);

    int insertSelective(GoodsCat record);

    GoodsCat selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsCat record);

    int updateByPrimaryKeyWithBLOBs(GoodsCat record);

    int updateByPrimaryKey(GoodsCat record);

	/**
	* @Title: gainAllGoodsCat
	* @Description: TODO(得到所有商品分类)
	* @param @return    设定文件
	* @return List<com.qlzy.model.GoodsCat>    返回类型
	*/
	List<GoodsCat> gainCatalogueByGrade(Integer grade);

	/**
	* @Title: gainCatalogueByPid
	* @Description: TODO(根据pid，查找上级目录)
	* @param @param pid
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	*/
	List<GoodsCat> gainCatalogueByPid(String pid);
	
	List<GoodsCat> gainCatalogueByPidBeach(List<String> pids);
	
	/**
	 * @Title: gainSonGoodsCatByFloor
	 * @Description: TODO(根据设置的floor的值查询其分类id,再根据其分类id查询其子分类)
	 * @param @param floor
	 * @param @return    设定文件
	 * @return List<GoodsCat>    返回类型
	 */
	public List<GoodsCat> gainSonGoodsCatByFloor(Integer floor);
	
	/**
	 * @Title: gainGoodsCatByFloor
	 * @Description: TODO(根据设置的floor的值查询其分类)
	 * @param @param floor
	 * @param @return    设定文件
	 * @return List<GoodsCat>    返回类型
	 */
	public List<GoodsCat> gainGoodsCatByFloor(Integer floor);

	/**
	* @Title: gainGoodsCat
	* @Description: TODO(获取商品一级分类)
	* @param @param catLang
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	* @author 周张豹
	*/
	List<GoodsCat> gainGoodsCat(Integer catLang);

	/**
	* @Title: gainNextGoodsCatListByPName
	* @Description: 
	* @param @param stringConvertList
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	*/
	List<GoodsCat> gainNextGoodsCatListByPName(List<String> stringConvertList);
	
	/**
	 * @Title: gainGoodsCatNameById
	 * @Description: TODO(根据商品分类ID查询商品分类名称)
	 * @param @param id
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author wangmei
	 */
	String gainGoodsCatNameById(String id);

	/**
	* @Title: gainGoodsCatList
	* @Description: 
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	*/
	List<GoodsCat> gainGoodsCatList();

	String gainCatIdByName(String component);
	
	/**
	 * @Title: gainSonGoodsCatsByPid
	 * @Description: TODO(根据父分类ID查询其子分类信息) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return List<GoodsCat> 返回类型 
	 * @author wangmei
	 */
	List<GoodsCat> gainSonGoodsCatsByPid(Map<String, Object> map);
	
	Long gainCatalogueCountByPid(String pid);

	String gainGoodsCatPidById(String carPartsId);

	List<GoodsCat> gainCatalogueByPidAndSort(Map<String, String> parmMap);
}