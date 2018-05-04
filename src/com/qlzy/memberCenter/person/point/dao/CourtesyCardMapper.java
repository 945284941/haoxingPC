package com.qlzy.memberCenter.person.point.dao;

import com.qlzy.model.CourtesyCard;


public interface CourtesyCardMapper {
    int deleteByPrimaryKey(String id);

    int insert(CourtesyCard record);

    int insertSelective(CourtesyCard record);

    CourtesyCard selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CourtesyCard record);

    int updateByPrimaryKey(CourtesyCard record);
}