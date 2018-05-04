package com.qlzy.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ActiveAspectJ {
	@Pointcut("execution(public * com.qlzy.active.action.*.*(..))")
	public void addMethod(){}
//	
//		@Before("addMethod()")
//		public void sessionCheck() throws Exception{
//	        SessionInfo info =(SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(ResourceUtil.getSessionInfoName());
//	        if(info==null){
//				ServletActionContext.getRequest().getSession().setAttribute(ResourceUtil.getSessionInfoName(), info);
//	        	ServletActionContext.getResponse().sendRedirect("/activeIndex.jsp");
//	        	return ;
//	        }
//		}
}


	