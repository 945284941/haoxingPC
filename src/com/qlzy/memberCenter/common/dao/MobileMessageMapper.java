package com.qlzy.memberCenter.common.dao;

import java.util.List;
import java.util.Map;

import com.qlzy.model.MobileMessage;



public interface MobileMessageMapper {
    int deleteByPrimaryKey(String id);

    int insert(MobileMessage record);

    MobileMessage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MobileMessage record);

    int updateByPrimaryKey(MobileMessage record);

	/**
	* @Title: gainMobileByUserId
	* @Description: TODO(根据用户id，及验证码查找短信记录)
	* @param @param map
	* @param @return设定文件
	* @return MobileMessage返回类型
	* @throws
	*/
	List<MobileMessage> gainMobileByUserId(Map<String, Object> map);
	
	/**
	 * @Title: addMobileMessage
	 * @Description: TODO(记录发送短信验证码日志) 
	 * @param @param mobileMessage    设定文件 
	 * @return void 返回类型 
	 * @author wangmei
	 */
	void addMobileMessage(MobileMessage mobileMessage);
}