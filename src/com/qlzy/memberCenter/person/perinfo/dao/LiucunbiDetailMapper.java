package com.qlzy.memberCenter.person.perinfo.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.LiucunbiDetail;




public interface LiucunbiDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(LiucunbiDetail record);

    int insertSelective(LiucunbiDetail record);

    LiucunbiDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LiucunbiDetail record);

    int updateByPrimaryKey(LiucunbiDetail record);

	List<LiucunbiDetail> gainListByMemberId(Map<String, Object> map);

	Long gainListByMemberIdCount(Map<String, Object> map);
}