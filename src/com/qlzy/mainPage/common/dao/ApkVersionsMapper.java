package com.qlzy.mainPage.common.dao;

import com.qlzy.model.ApkVersions;



public interface ApkVersionsMapper {
    int deleteByPrimaryKey(String id);

    int insert(ApkVersions record);

    int insertSelective(ApkVersions record);

    ApkVersions selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ApkVersions record);

    int updateByPrimaryKey(ApkVersions record);
}