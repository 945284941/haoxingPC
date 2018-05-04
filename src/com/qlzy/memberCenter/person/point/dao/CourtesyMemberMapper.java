package com.qlzy.memberCenter.person.point.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.CourtesyMember;


public interface CourtesyMemberMapper {
    int deleteByPrimaryKey(String id);

    int insert(CourtesyMember record);

    int insertSelective(CourtesyMember record);

    CourtesyMember selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CourtesyMember record);

    int updateByPrimaryKey(CourtesyMember record);

	List<CourtesyMember> gainYouhuiquanList(Map<String, Object> map);

	Long gainCourtesyMemberMapperByMemberId(String id);
}