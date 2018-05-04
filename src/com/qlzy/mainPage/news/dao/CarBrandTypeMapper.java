package com.qlzy.mainPage.news.dao;

import java.util.List;

import com.qlzy.model.CarBrandType;
public interface CarBrandTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarBrandType record);

    int insertSelective(CarBrandType record);

    CarBrandType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarBrandType record);

    int updateByPrimaryKey(CarBrandType record);
    
    List<CarBrandType> gainAllList(CarBrandType record);
}