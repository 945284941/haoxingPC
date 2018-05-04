package com.qlzy.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.pojo.SessionInfo;

/**
 * session拦截器
 * 
 * @author Huifeng Wang
 * 
 */
public class SessionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SessionInterceptor.class);

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String actionName=actionInvocation.getInvocationContext().getName();
		List<String> ans=new ArrayList<String>();
		ans.add("collect");
		ans.add("dataEntryAction");
		ans.add("memberCenterManager");
		ans.add("payment");
		if(ans.contains(actionName)){
			SessionInfo sessionInfo = (SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(ResourceUtil.getSessionInfoName());
			if (sessionInfo == null || "".equals(sessionInfo.getLoginName()) ||  null == sessionInfo.getLoginName()) {
				logger.debug("用户未登录，跳转");
				return "login_hf";
			}
		}
		return actionInvocation.invoke();
		
	}

}
