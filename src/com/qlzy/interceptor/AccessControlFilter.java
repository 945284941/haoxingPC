/**
 *功能说明：对
 * @author jacobliang
 * @time @Sep 14, 2010 @11:45:55 AM
 */
package com.qlzy.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.pojo.SessionInfo;

public class AccessControlFilter implements Filter {
	Logger log = Logger.getLogger(this.getClass());
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
							FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        /* 参数为true时，返回的是null;     
         * 没有参数或是false则返回新的session
         */   
        HttpSession session = httpRequest.getSession();
        String serveletPath = httpRequest.getServletPath();
        SessionInfo sessionInfo = session==null?null: (SessionInfo) session.getAttribute(ResourceUtil.getSessionInfoName());
        System.out.println("serveletPath:"+serveletPath+"; sessionInfo:"+ sessionInfo);
        if(serveletPath.contains("login") || sessionInfo != null){
        	chain.doFilter(httpRequest, httpResponse);
        }else{
        	chain.doFilter(httpRequest, httpResponse);
        	//request.getRequestDispatcher("login.jsp").forward(request,response);
        }
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
