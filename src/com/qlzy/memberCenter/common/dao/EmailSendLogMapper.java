package com.qlzy.memberCenter.common.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.EmailSendLog;

public interface EmailSendLogMapper {
    
	/**
	 * @Title: addEmailSendLog
	 * @Description: TODO(记录邮箱发送日志) 
	 * @param @param emailSendLog    设定文件 
	 * @return void 返回类型 
	 * @author wangmei
	 */
    void addEmailSendLog(EmailSendLog emailSendLog);
    
    /**
     * @Title: gainEmailSendLogByMap
     * @Description: TODO(根据用户ID、邮箱和验证码查询发送日志信息) 
     * @param @param map
     * @param @return    设定文件 
     * @return List<EmailSendLog> 返回类型 
     * @author wangmei
     */
    List<EmailSendLog> gainEmailSendLogByMap(Map<String, Object> map);
}