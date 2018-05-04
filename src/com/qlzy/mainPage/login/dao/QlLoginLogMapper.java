package com.qlzy.mainPage.login.dao;
import com.qlzy.model.QlLoginLog;

public interface QlLoginLogMapper {
/****
 * 向登录日志表中插入数据
 * @param qlLoginLog
 * @return
 */
    int insertSelective(QlLoginLog qlLoginLog);

}