package com.qlzy.memberCenter.person.perinfo.dao;

import java.util.List;

import com.qlzy.model.Zhuanpan;



public interface ZhuanpanMapper {
    int deleteByPrimaryKey(String id);

    int insert(Zhuanpan record);

    int insertSelective(Zhuanpan record);

    Zhuanpan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Zhuanpan record);

    int updateByPrimaryKey(Zhuanpan record);

	List<Zhuanpan> gainAll();
}