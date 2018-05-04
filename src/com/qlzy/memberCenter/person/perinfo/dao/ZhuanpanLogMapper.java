package com.qlzy.memberCenter.person.perinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qlzy.model.ZhuanpanLog;





public interface ZhuanpanLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZhuanpanLog record);

    int insertSelective(ZhuanpanLog record);

    ZhuanpanLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZhuanpanLog record);

    int updateByPrimaryKey(ZhuanpanLog record);
    /**
     * 多条件查询抽奖记录
     * @param memeberId
     * @param remark
     * @return
     */
    List<ZhuanpanLog> getByMultiCondition(@Param(value="memberId")String memeberId, @Param(value="remark")String remark);
    
}