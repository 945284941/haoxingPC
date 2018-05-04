/**  
* @Title: DeliverPojos.java
* @Package com.qlzy.pojo
* @Description: TODO(用一句话描述该文件做什么)
* @author 周张豹  
* @date 2013-11-26 下午4:42:38
* @version V1.0  
*/
package com.qlzy.pojo;

/**
 * @ClassName: DeliverPojos
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 周张豹
 * @date 2013-11-26 下午4:42:38
 */
import java.io.Serializable;

public class DeliverPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String dealId;
	private String dealLog;
	private String dealLogOrder;
	private String dealSignure;
	
	private String merId;

	/**
	 * @return the dealId
	 */
	public String getDealId() {
		return dealId;
	}

	/**
	 * @param dealId the dealId to set
	 */
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	/**
	 * @return the dealLog
	 */
	public String getDealLog() {
		return dealLog;
	}

	/**
	 * @param dealLog the dealLog to set
	 */
	public void setDealLog(String dealLog) {
		this.dealLog = dealLog;
	}

	/**
	 * @return the dealLogOrder
	 */
	public String getDealLogOrder() {
		return dealLogOrder;
	}

	/**
	 * @param dealLogOrder the dealLogOrder to set
	 */
	public void setDealLogOrder(String dealLogOrder) {
		this.dealLogOrder = dealLogOrder;
	}

	/**
	 * @return the dealSignure
	 */
	public String getDealSignure() {
		return dealSignure;
	}

	/**
	 * @param dealSignure the dealSignure to set
	 */
	public void setDealSignure(String dealSignure) {
		this.dealSignure = dealSignure;
	}

	/**
	 * @return the merId
	 */
	public String getMerId() {
		return merId;
	}

	/**
	 * @param merId the merId to set
	 */
	public void setMerId(String merId) {
		this.merId = merId;
	}
	
	}
