/**  
* @Title: LhPayPojo.java
* @Package com.qlzy.pojo
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-11-11 上午10:33:24
* @version V1.0  
*/
package com.qlzy.pojo;

/**
 * 关于使用联行支付平台 支付信息实体类
 * @ClassName: LhPayPojo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-11-11 上午10:33:24
 */
import java.io.Serializable;

public class LhPayPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	//------必选项-------
	private String merId;//商户编号
	private String dealName;//商户名称
	private String dealOrder;//订单编号
	private String dealFee;//订单金额
	private String dealReturn;//支付完成后支付结果返回到该url，主要用于结果展示
	private String dealNotify;//支付完成后支付结果通知到该url，主要用于通知接受
	private String dealSignure;//订单数据数字签名
	
	//------可选项------
	private String dealLogLinker;//联系人
	private String dealLogTel;//联系电话
	private String dealLogPhone;//联系手机
	private String dealLogAddr;//收货地址
	
	
	
	/**
	 * @return the 商户编号
	 */
	public String getMerId() {
		return merId;
	}
	/**
	 * @param merId the 商户编号 to set
	 */
	public void setMerId(String merId) {
		this.merId = merId;
	}
	/**
	 * @return the 商户名称
	 */
	public String getDealName() {
		return dealName;
	}
	/**
	 * @param dealName the 商户名称 to set
	 */
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}
	/**
	 * @return the 订单编号
	 */
	public String getDealOrder() {
		return dealOrder;
	}
	/**
	 * @param dealOrder the 订单编号 to set
	 */
	public void setDealOrder(String dealOrder) {
		this.dealOrder = dealOrder;
	}
	/**
	 * @return the 订单金额
	 */
	public String getDealFee() {
		return dealFee;
	}
	/**
	 * @param dealFee the 订单金额 to set
	 */
	public void setDealFee(String dealFee) {
		this.dealFee = dealFee;
	}
	/**
	 * @return the 支付完成后支付结果返回到该url，主要用于结果展示
	 */
	public String getDealReturn() {
		return dealReturn;
	}
	/**
	 * @param dealReturn the 支付完成后支付结果返回到该url，主要用于结果展示 to set
	 */
	public void setDealReturn(String dealReturn) {
		this.dealReturn = dealReturn;
	}
	/**
	 * @return the 支付完成后支付结果通知到该url，主要用于通知接受
	 */
	public String getDealNotify() {
		return dealNotify;
	}
	/**
	 * @param dealNotify the 支付完成后支付结果通知到该url，主要用于通知接受 to set
	 */
	public void setDealNotify(String dealNotify) {
		this.dealNotify = dealNotify;
	}
	/**
	 * @return the 订单数据数字签名
	 */
	public String getDealSignure() {
		return dealSignure;
	}
	/**
	 * @param dealSignure the 订单数据数字签名 to set
	 */
	public void setDealSignure(String dealSignure) {
		this.dealSignure = dealSignure;
	}
	/**
	 * @return the 联系人
	 */
	public String getDealLogLinker() {
		return dealLogLinker;
	}
	/**
	 * @param dealLogLinker the 联系人 to set
	 */
	public void setDealLogLinker(String dealLogLinker) {
		this.dealLogLinker = dealLogLinker;
	}
	/**
	 * @return the 联系人电话
	 */
	public String getDealLogTel() {
		return dealLogTel;
	}
	/**
	 * @param dealLogTel the 联系人电话 to set
	 */
	public void setDealLogTel(String dealLogTel) {
		this.dealLogTel = dealLogTel;
	}
	/**
	 * @return the 联系人手机
	 */
	public String getDealLogPhone() {
		return dealLogPhone;
	}
	/**
	 * @param dealLogPhone the 联系人手机 to set
	 */
	public void setDealLogPhone(String dealLogPhone) {
		this.dealLogPhone = dealLogPhone;
	}
	/**
	 * @return the 收到地址
	 */
	public String getDealLogAddr() {
		return dealLogAddr;
	}
	/**
	 * @param dealLogAddr the 收到地址 to set
	 */
	public void setDealLogAddr(String dealLogAddr) {
		this.dealLogAddr = dealLogAddr;
	}
	

	
	
	
	
	
	

}
