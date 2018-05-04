package com.qlzy.memberCenter.goods.dao;

import java.util.List;

import com.qlzy.model.CarPartsProducer;

public interface CarPartsProducerMapper {
    int insert(CarPartsProducer record);

    int insertSelective(CarPartsProducer record);
    
    /**
     * 根据分页查询
    * @Title: gainAll
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param carPartsProducer
    * @param @return    设定文件
    * @return List<CarPartsProducer>    返回类型
     */
    public List<CarPartsProducer> gainAll(CarPartsProducer carPartsProducer);
    
    /**
     * 查询所有的
    * @Title: gainCarPartsProducer
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @return    设定文件
    * @return List<CarPartsProducer>    返回类型
     */
    public List<CarPartsProducer> gainCarPartsProducer();
    
    /**
     * 配合分页查询总数
    * @Title: gainLong
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param carPartsProducer
    * @param @return    设定文件
    * @return Long    返回类型
     */
    public Long gainLong(CarPartsProducer carPartsProducer);
    
    /**
     * 更新
    * @Title: updateByPrimaryKeySelective
    * @Description: TODO(只更新有值的属性)
    * @param @param carPartsProducer    设定文件
    * @return void    返回类型
     */
    public void updateByPrimaryKeySelective(CarPartsProducer carPartsProducer);

	/**
	* @Title: gainById
	* @Description: TODO(根据ID查询)
	* @param @param id
	* @param @return    设定文件
	* @return CarPartsProducer    返回类型
	*/
	CarPartsProducer gainById(String id);
    
}