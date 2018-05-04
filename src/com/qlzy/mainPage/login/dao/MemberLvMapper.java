package com.qlzy.mainPage.login.dao;

import com.qlzy.model.MemberLv;

public interface MemberLvMapper {
    int deleteByPrimaryKey(String id);


    int insertSelective(MemberLv record);

    MemberLv selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberLv record);

}