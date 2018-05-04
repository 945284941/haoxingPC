/**
 * 创建人:WangHuifeng
 * 创建时间:2012-10-31 下午2:43:12
 */
package com.qlzy.pojo;

import java.io.Serializable;

/**
 * 创建人:WangHuifeng
 * 创建时间:2012-10-31 下午2:43:12
 */

public class Json implements Serializable{
	private static final long serialVersionUID = 1L;
	private Boolean success=false;//是否成功
	private String msg;
	private Object obj;
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
