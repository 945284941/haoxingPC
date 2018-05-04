package com.qlzy.memberCenter.shop.dao;

import java.util.List;

import com.qlzy.model.CompanySys;



public interface CompanySysMapper {
    int deleteByPrimaryKey(String id);

    int insert(CompanySys record);

    int insertSelective(CompanySys record);

    CompanySys selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CompanySys record);

    int updateByPrimaryKey(CompanySys record);

	List<CompanySys> gainCompanySysByMember(String userId);

	void deleteCompanySys(CompanySys companySy);
}