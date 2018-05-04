package com.qlzy.memberCenter.common.dao;

import java.util.List;

import com.qlzy.model.PptDeptUsers;

public interface PptDeptUsersMapper {
    int insert(PptDeptUsers record);

    int insertSelective(PptDeptUsers record);
    
    /**
     * @Title: gainPptDeptUsersByUserId
     * @Description: TODO(根据用户ID查询其好友) 
     * @param @param userId
     * @param @return    设定文件 
     * @return List<PptDeptUsers> 返回类型 
     * @author wangmei
     */
    List<PptDeptUsers> gainPptDeptUsersByUserId(String userId);
    
    /**
     * @Title: addPptDeptUsers
     * @Description: TODO(添加好友) 
     * @param @param pptDeptUsers    设定文件 
     * @return void 返回类型 
     * @author wangmei
     */
    void addPptDeptUsers(PptDeptUsers pptDeptUsers);
}