package com.qlzy.memberCenter.call.dao;

import com.qlzy.model.Bankcard;

import java.util.List;

public interface BankcardMapper {
    List<Bankcard> selectByMemberId(String memberId);

    int deleteByPrimaryKey(String id);

    int insert(Bankcard record);

    int insertSelective(Bankcard record);

    Bankcard selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Bankcard record);

    int updateByPrimaryKey(Bankcard record);

    List<Bankcard> findBankCardByCid(Bankcard bankcard);
}