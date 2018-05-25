package com.qlzy.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("basePackage")// 这里是package的name
@Namespace("/")//命名空间
public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6230751116897773145L;
	protected Map<String, Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String addressId;
	//将对象写成json扔到前台
	public  void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取分页信息
	 */
    public static Pagination definationPagination(HttpServletRequest request)
    {
        String page = request.getParameter("page");
        Pagination pagination = new Pagination();
        if(null == page || "".equals(page))
        	pagination.setPage(1L);
        else
        	pagination.setPage(Long.parseLong(page));
        return pagination;
    }
    
    
    /**
	* @Title: uploadError
	* @Description: TODO上传失败
	* @param @param err
	* @param @param msg    设定文件
	* @return void    返回类型
	 */
    public void uploadError(String err, String msg) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("err", err);
		m.put("msg", msg);
		writeJson(m);
	}
	/**
	* @Title: uploadError
	* @Description: TODO上传失败
	* @param @param err
	* @param @param msg    设定文件
	* @return void    返回类型
	 */
	public void uploadError(String err) {
		this.uploadError(err, "");
	}
	/**
	* @Title: uploadError
	* @Description: TODO上传成功
	* @param @param err
	* @param @param msg    设定文件
	* @return void    返回类型
	 */
	public void uploadSuccess(String newFileName, String fileName, int id) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("err", "");
		Map<String, Object> nm = new HashMap<String, Object>();
		nm.put("url", newFileName);
		nm.put("localfile", fileName);
		nm.put("id", id);
		m.put("msg", nm);
		writeJson(m);
	}
    
    
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletResponse getResopnse() {
		return response;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
}
