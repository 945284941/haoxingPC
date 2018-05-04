/**??
* @Title: SupplyStander.java
* @Package com.qlzy.model
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-6 下午1:54:37
* @version V1.0??
*/
package com.qlzy.model;

import java.util.Date;


/**
 * @ClassName: SupplyStander
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author A18ccms a18ccms_gmail_com
 * @date 2013-10-6 下午1:54:37
 *
 */
import java.io.Serializable;

public class SupplyStander implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String id;
	
	private String supplyType;
	
	private String supplyTitle;
	
	private Date createTime;
	
	private Integer viewNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSupplyType() {
		return supplyType;
	}

	public void setSupplyType(String supplyType) {
		this.supplyType = supplyType;
	}

	public String getSupplyTitle() {
		return supplyTitle;
	}

	public void setSupplyTitle(String supplyTitle) {
		this.supplyTitle = supplyTitle;
	}

	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getViewNum() {
		return viewNum;
	}

	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}
	
	
	
}
