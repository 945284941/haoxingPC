package com.qlzy.mainPage.indexGoods.dao;



import com.qlzy.model.QlDict;

import java.util.List;

public interface QlDictMapper {
    int deleteByPrimaryKey(String id);

    int insert(QlDict record);

    int insertSelective(QlDict record);

    QlDict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(QlDict record);

    int updateByPrimaryKey(QlDict record);

    List<QlDict> selectByType(String hv_type);

    QlDict getByType(String hv_type);
}