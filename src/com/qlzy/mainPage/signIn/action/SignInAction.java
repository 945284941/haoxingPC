package com.qlzy.mainPage.signIn.action;


import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.mainPage.signIn.service.SignInService;
import com.qlzy.model.SignInModel;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;

/**
 * @ClassName: SignInAction
 * @Description: 
 * @author zhaoyangbin
 * @date 2014-10-15 上午11:03:37
 */
@Namespace("/")
@Action(value = "signIn", results = {
		@Result(name="toCome",location="/admin/head/warp.jsp")
})
public class SignInAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SignInService signInService;
	
	public void isLogin(){
		String msg = "false";
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		if(sessionInfo != null && !sessionInfo.equals("")){
				String companyId = sessionInfo.getUserId();
				String signInMsg = signInService.IsAlreadySigned(companyId);
				msg = signInMsg;
		}else{
			msg = "请先登录再签到，谢谢您的参与";
		}
		super.writeJson(msg);
	}

}
