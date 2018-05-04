package com.qlzy.mainPage.head.dao;

import java.util.List;

import com.qlzy.model.CarBrand;


public interface CarBrandMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarBrand record);

    int insertSelective(CarBrand record);

    CarBrand selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarBrand record);

    int updateByPrimaryKeyWithBLOBs(CarBrand record);

    int updateByPrimaryKey(CarBrand record);

	/**
	 * @param grade 
	* @Title: gainCarBrandList
	* @Description: TODO(主页显示品牌列表)
	* @param @return    设定文件
	* @return List<CarBrand>    返回类型
	*/
	List<CarBrand> gainCarBrandList(Integer grade);
	/****
	 * 查询id是pid的所有数据 （存在二级分类的数据）
	 * @param grade
	 * @return
	 */
	List<CarBrand> gainCarBrandListPidNotNull(Integer grade);
	/**
	* @Title: gainCarBrandListByPid
	* @Description: TODO(根据pid得到carBrand)
	* @param @param pid
	* @param @return    设定文件
	* @return List<CarBrand>    返回类型
	*/
	List<CarBrand> gainCarBrandListByPid(String pid);
	
	List<CarBrand> gainCarBrandListByPidBeach(List<String> pids);

	/**
	* @Title: gainCarBrandNameById
	* @Description: 根据Id获取name
	* @param @param stringConvertList
	* @param @return    设定文件
	* @return List<String>    返回类型
	*/
	List<String> gainCarBrandNameById(List<String> stringConvertList);

	/**
	* @Title: gainBrandListByBrandName
	* @Description: 
	* @param @param list
	* @param @return    设定文件
	* @return List<CarBrand>    返回类型
	*/
	List<CarBrand> gainBrandListByBrandName(List<String> list);

	/**
	* @Title: gainNextCarBrandListByPName
	* @Description: 
	* @param @param stringConvertList
	* @param @return    设定文件
	* @return List<CarBrand>    返回类型
	*/
	List<CarBrand> gainNextCarBrandListByPName(List<String> stringConvertList);

	/**
	* @Title: gainCarBrandIdListByGoodsId
	* @Description: TODO(根据商品id，查找适用车型)
	* @param @param id
	* @param @return    设定文件
	* @return List    返回类型
	*/
	List gainCarBrandIdListByGoodsId(String id);

	/**
	* @Title: gainCarBrandById
	* @Description: TODO(根据id查找商品品牌)
	* @param @param carBrandId
	* @param @return    设定文件
	* @return CarBrand    返回类型
	*/
	CarBrand gainCarBrandById(String carBrandId);

	/**
	* @Title: gainCarBrandListAll
	* @Description: 
	* @param @return    设定文件
	* @return List<CarBrand>    返回类型
	*/
	List<CarBrand> gainCarBrandListAll();

	List<String> gainCarBrandsByChildIds(List<String> carBrand);

	String gainCarBrandIdByName(String type);

	List<CarBrand> gainCarBrandListForOneSelect();

	Long gainCarBrandListCountByPid(String id);

	String gainCarBrandPidById(String cpid);

	
}