package com.qlzy.memberCenter.shop.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.CompanysGoodsCat;
import com.qlzy.model.GoodsCat;

public interface CompanysGoodsCatMapper {
   

    int insert(CompanysGoodsCat record);

    int insertSelective(CompanysGoodsCat record);

    CompanysGoodsCat selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CompanysGoodsCat record);

    int updateByPrimaryKey(CompanysGoodsCat record);

	/**
	* @Title: gainGoodsCatList
	* @Description: TODO(根据会员id，查找分类列表)
	* @param @param memberIdString
	* @param @return    设定文件
	* @return List<CompanysGoodsCat>    返回类型
	*/
	List<CompanysGoodsCat> gainCompanyGoodsCatList(String memberIdString);

	/**
	* @Title: deleteById
	* @Description: TODO(根据id，删除商品分类)
	* @param @param object    设定文件
	* @return void    返回类型
	*/
	void deleteById(String string);

	/**
	* @Title: updateById
	* @Description: TODO(更新分类排序)
	* @param @param map    设定文件
	* @return void    返回类型
	*/
	void updateById(Map<String, Object> map);

	/**
	* @Title: gainGoodsCatListShop
	* @Description: TODO(得到shop商品分类，除去该店铺本身存在的分类
	* )
	* @param @param memberIdString
	* @param @return    设定文件
	* @return List<GoodsCat>    返回类型
	*/
	List<CompanysGoodsCat> gainGoodsCatListShop(String memberIdString);

	/**
	* @Title: addCompanyGoods
	* @Description: TODO(添加商品分类)
	* @param @param string
	* @param @param object    设定文件
	* @return void    返回类型
	*/
	void addCompanyGoods(CompanysGoodsCat cat);

	/**
	 * @Title: gainCompanysGoodsCats
	 * @Description: TODO(根据用户ID查询热销品类数量) 
	 * @param @param map
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainCompanysGoodsCats(Map<String, Object> map);

	List<CompanysGoodsCat> gainCompanyCatByGrade(Map<String, Object> parmMap);

	List<CompanysGoodsCat> gainCompanyCatByParm(Map<String, Object> parmMap);

	/**
	 * @Title findCompanyGoodsCatByCompanyId
	 * @Description TODO(查询最父级)
	 * @param companyId
	 * @return
	 */
	List<CompanysGoodsCat> findCompanyGoodsCatByCompanyId(String companyId);

	/**
	 * @TITLE findChildrenByPid
	 * @Description TODO（查询子集）
	 * @param pid
	 * @return
	 */
	List<CompanysGoodsCat> findChildrenByPid(String pid);
}