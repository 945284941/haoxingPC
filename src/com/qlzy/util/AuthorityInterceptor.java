package com.qlzy.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class AuthorityInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String url=request.getRequestURI();
		System.out.println("当前访问的路径是:"+url);
		// 取得请求相关的ActionContext实例        
        ActionContext ctx=invocation.getInvocationContext();
        Map<String, Object> session=ctx.getSession();    
        session.put("url", url);
        //取出名为user的session属性        
        String user= (String) session.get("id");      
        //如果没有登陆返回重新登陆        
        if(user!=null){        
        	return invocation.invoke();        
        }        
        //没有登陆，将服务器提示设置成一个HttpServletRequest属性      
        ctx.put("tip","您还没有登录，请登陆系统");   
        //return "tologin";
        return invocation.invoke();//开发阶段不验证
	}

}
