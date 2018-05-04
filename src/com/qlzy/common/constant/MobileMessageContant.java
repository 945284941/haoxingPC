/**??
* @Title: MobileMessageContant.java
* @Package com.qlzy.common.constant
* @Description: TODO(用一句话描述该文件做什么)
* @author zhao yang bin
* @date 2013-10-23 下午4:00:13
* @version V1.0??
*/
package com.qlzy.common.constant;

/**
 * @ClassName: MobileMessageContant
 * @Description: TODO(常用信息)
 * @author zhao yang bin
 * @date 2013-10-23 下午4:00:13
 *
 */
public class MobileMessageContant {
	
	public static String tixianYanzheng="您在【颐佳商城】提现所获得的动态密码是：";
	public static Long timeRange=300l;//时间设置180秒
	
	public static String VERIFICATIONCODE_EMAILBIND = "";
	public static String VERIFICATIONCODE_MOBILEBIND = "";
	public static String VERIFICATIONCODE_UPDATEPW = "";
	public static String VERIFICATIONCODE_UPDATEMOBILE = "";
	
	public static String sendForBindEmail(String randNum){
		VERIFICATIONCODE_EMAILBIND = "【颐佳商城】您的验证码是："+randNum+"，在5分钟内有效，如非本人操作请忽略此短信。";
		return VERIFICATIONCODE_EMAILBIND;
	}
	
	public static String sendForUpdatePw(String randNum){
		VERIFICATIONCODE_UPDATEPW = "【颐佳商城】您的验证码是："+randNum+"，在5分钟内有效，如非本人操作请忽略此短信。";
		return VERIFICATIONCODE_UPDATEPW;
	}
	
	public static String sendForBindMobile(String randNum){
		VERIFICATIONCODE_MOBILEBIND = "【颐佳商城】您的验证码是："+randNum+"，在5分钟内有效，如非本人操作请忽略此短信。";
		return VERIFICATIONCODE_MOBILEBIND;
	}
	
	public static String sendForRegisterMobile(String randNum){
		VERIFICATIONCODE_UPDATEMOBILE = "【颐佳商城】您的验证码是："+randNum+"，在5分钟内有效，如非本人操作请忽略此短信。";
		return VERIFICATIONCODE_UPDATEMOBILE;
	}
	
}
