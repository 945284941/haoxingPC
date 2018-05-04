package com.qlzy.memberCenter.common.dao;

import java.util.List;

import com.qlzy.model.PptDept;

public interface PptDeptMapper {
    int insert(PptDept record);

    int insertSelective(PptDept record);
    
    /**
     * @Title: gainPptDeptsByUserId
     * @Description: TODO(根据用户ID查询其好友分组) 
     * @param @param userId
     * @param @return    设定文件 
     * @return List<PptDept> 返回类型 
     * @author wangmei
     */
    List<PptDept> gainPptDeptsByUserId(String userId);
}