package com.qlzy.mainPage.school.dao;

import com.qlzy.model.ZpxyHuodongAttend;

public interface ZpxyHuodongAttendMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZpxyHuodongAttend record);

    int insertSelective(ZpxyHuodongAttend record);

    ZpxyHuodongAttend selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZpxyHuodongAttend record);

    int updateByPrimaryKey(ZpxyHuodongAttend record);
}