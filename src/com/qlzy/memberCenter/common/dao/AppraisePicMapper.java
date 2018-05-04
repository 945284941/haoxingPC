package com.qlzy.memberCenter.common.dao;

import com.qlzy.model.AppraisePic;

import java.util.List;

public interface AppraisePicMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppraisePic record);

    int insertSelective(AppraisePic record);

    AppraisePic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppraisePic record);

    int updateByPrimaryKey(AppraisePic record);

    List<AppraisePic> selectByAppraiseId(String id);
}