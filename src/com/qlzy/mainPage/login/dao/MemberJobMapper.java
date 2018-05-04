package com.qlzy.mainPage.login.dao;

import java.util.List;

import com.qlzy.model.MemberJob;


public interface MemberJobMapper {
    int insert(MemberJob record);

    int insertSelective(MemberJob record);
    List<MemberJob> gainMemberJobList();
}