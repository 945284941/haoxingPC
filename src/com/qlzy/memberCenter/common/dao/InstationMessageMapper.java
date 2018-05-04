package com.qlzy.memberCenter.common.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.InstationMessage;

public interface InstationMessageMapper {

    /**
     * @Title: gainById
     * @Description: TODO(根据主键查询站内详细信息) 
     * @param @param id
     * @param @return    设定文件 
     * @return InstationMessage 返回类型 
     * @author wangmei
     */
    InstationMessage gainById(String id);
    
    /**
     * @Title: gainInstationMessagesByUserId
     * @Description: TODO(根据会员ID查询站内短信列表) 
     * @param @param map
     * @param @return    设定文件 
     * @return List<InstationMessage> 返回类型 
     * @author wangmei
     */
    List<InstationMessage> gainInstationMessagesByUserId(Map<String, Object> map);
    
    /**
     * @Title: gainInstationMessageCountByUserId
     * @Description: TODO(根据会员ID查询站内短信总记录数)
     * @param @param map
     * @param @return    设定文件 
     * @return Long 返回类型 
     * @author wangmei
     */
    Long gainInstationMessageCountByUserId(Map<String, Object> map);
    
    /**
     * @Title: addInstationMessage
     * @Description: TODO(发送站内短信)
     * @param @param instationMessage    设定文件 
     * @return void 返回类型 
     * @author wangmei
     */
    void addInstationMessage(InstationMessage instationMessage);
    
    /**
     * @Title: deleteInstationMessage
     * @Description: TODO(单条或批量删除站内短信(逻辑删除))
     * @param @param ids    设定文件 
     * @return void 返回类型 
     * @author wangmei
     */
    void deleteInstationMessage(List<String> ids);
    
    /**
     * @Title: dropInstationMessage
     * @Description: TODO(单条或批量删除站内短信(物理删除))
     * @param @param ids    设定文件 
     * @return void 返回类型 
     * @author wangmei
     */
    void dropInstationMessage(List<String> ids);
    
    /**
     * @Title: updateInstationMessage
     * @Description: TODO(修改)
     * @param @param instationMessage    设定文件 
     * @return void 返回类型 
     * @author wangmei
     */
    void updateInstationMessage(InstationMessage instationMessage);
}