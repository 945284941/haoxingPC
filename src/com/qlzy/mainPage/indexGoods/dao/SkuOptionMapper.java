package com.qlzy.mainPage.indexGoods.dao;
import com.qlzy.model.SkuOption;

public interface SkuOptionMapper {
    int deleteByPrimaryKey(String id);

    int insert(SkuOption record);

    int insertSelective(SkuOption record);

    SkuOption selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SkuOption record);

    int updateByPrimaryKey(SkuOption record);
}