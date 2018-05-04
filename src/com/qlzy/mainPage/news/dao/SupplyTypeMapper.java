package com.qlzy.mainPage.news.dao;

import java.util.List;

import com.qlzy.model.SupplyType;

public interface SupplyTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(SupplyType record);

    int insertSelective(SupplyType record);

    SupplyType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SupplyType record);

    int updateByPrimaryKey(SupplyType record);

	List<SupplyType> gainAllSupplyType();

	String gainSupplyTypeNameById(String parameter);
}