package com.qlzy.memberCenter.person.moneyManage.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.AdvanceLogs;
import com.qlzy.model.MobileMessage;
import com.qlzy.pojo.SessionInfo;

public interface MoneyManageService {
	 /**
		* 得到所有资金列表
	  */
	List<AdvanceLogs> gainMoneyAllList(Map<String, Object> map);
	/**
	 * 得到所有资金数目
    */
	Long gainMoneyAllListCount(Map<String, Object> map);
	/**
	 * 验证支付密码
     */
	Boolean payIsTrue(Map<String, Object> map);
	/**
	 *添加充值日志
     */
	void addMoney(AdvanceLogs advanceLogs, SessionInfo sessionInfo);
	/**
	 *添加取现日志
     */
	void enchashment(AdvanceLogs advanceLogs,SessionInfo sessionInfo);
	/**
	 *取现时判断金额
     */
	Double moneyEnchs(SessionInfo sessionInfo);
	/**
	* @Title: addMobileMessage
	* @Description: TODO(短息信息记录表)
	* @param @param mobileMess设定文件
	* @return void返回类型
	* @throws
	*/
	void addMobileMessage(MobileMessage mobileMess);
	/**
	* @Title: gainMobileByUserId
	* @Description: TODO(根据验证码及用户民查找短信)
	* @param @param map
	* @param @return设定文件
	* @return MobileMessage返回类型
	* @throws
	*/
	List<MobileMessage> gainMobileByUserId(Map<String, Object> map);
}
