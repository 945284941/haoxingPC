/**  
* @Title: SpecificationInformation.java
* @Package com.qlzy.model
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com  
* @date 2013-8-5 上午10:53:57
* @version V1.0  
*/
package com.qlzy.model;

import com.qlzy.util.Pagination;

/**
 * @ClassName: SpecificationInformation
 * @Description: TODO(商品规格实体类)
 * @author A18ccms a18ccms_gmail_com
 * @date 2013-8-5 上午10:53:57
 *
 */
import java.io.Serializable;

public class SpecificationInformation extends Pagination implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String specificationValue;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecificationValue() {
		return specificationValue;
	}
	public void setSpecificationValue(String specificationValue) {
		this.specificationValue = specificationValue;
	}
	
	
}
