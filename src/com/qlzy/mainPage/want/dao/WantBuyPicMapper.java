package com.qlzy.mainPage.want.dao;

import com.qlzy.model.WantBuyPic;

import java.util.List;

public interface WantBuyPicMapper {
    int deleteByPrimaryKey(WantBuyPic key);

    int insert(WantBuyPic record);

    int insertSelective(WantBuyPic record);

    WantBuyPic selectByPrimaryKey(WantBuyPic key);

    int updateByPrimaryKeySelective(WantBuyPic record);

    int updateByPrimaryKey(WantBuyPic record);

    void batchInsert(List<WantBuyPic> wantBuyPicList);

    List<String> selectByBuyId(String id);
}