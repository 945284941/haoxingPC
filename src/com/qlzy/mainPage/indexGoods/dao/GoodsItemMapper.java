package com.qlzy.mainPage.indexGoods.dao;
import java.util.List;

import com.qlzy.model.GoodsItem;

public interface GoodsItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsItem record);

    int insertSelective(GoodsItem record);

    GoodsItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsItem record);

    int updateByPrimaryKey(GoodsItem record);
    
	public List<GoodsItem> selectGoodsItemListByGoodsId(GoodsItem ppItem);

	List<GoodsItem> gainCartsByUserId(String userId);
}