package com.qlzy.mainPage.indexGoods.dao;

import java.util.List;

import com.qlzy.model.GoodsAndSku;

public interface GoodsAndSkuMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsAndSku record);

    int insertSelective(GoodsAndSku record);

    GoodsAndSku selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsAndSku record);

    int updateByPrimaryKey(GoodsAndSku record);
    
    
    public List<GoodsAndSku> selectGoodsAndSkuListByGoodsId(GoodsAndSku gas);
}