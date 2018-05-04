package com.qlzy.memberCenter.person.perinfo.dao;

import java.util.List;

import com.qlzy.model.MemeberDeail;





public interface MemeberDeailMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemeberDeail record);

    int insertSelective(MemeberDeail record);

    MemeberDeail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemeberDeail record);

    int updateByPrimaryKey(MemeberDeail record);

	List<MemeberDeail> gainMemberDeailList(MemeberDeail memeberDeail);

	Long gainMemberDeailListcount(MemeberDeail memeberDeail);
}