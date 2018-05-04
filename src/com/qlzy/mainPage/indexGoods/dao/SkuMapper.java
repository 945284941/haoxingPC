package com.qlzy.mainPage.indexGoods.dao;
import com.qlzy.model.Sku;

public interface SkuMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);
}