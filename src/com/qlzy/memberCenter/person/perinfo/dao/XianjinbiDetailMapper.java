package com.qlzy.memberCenter.person.perinfo.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.XianjinbiDetail;


public interface XianjinbiDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(XianjinbiDetail record);

    int insertSelective(XianjinbiDetail record);

    XianjinbiDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(XianjinbiDetail record);

    int updateByPrimaryKey(XianjinbiDetail record);

	List<XianjinbiDetail> gainListByMemberId(Map<String, Object> map);

	Long gainListByMemberIdCount(Map<String, Object> map);

	List<XianjinbiDetail> gainListByRemark(String remark);
}