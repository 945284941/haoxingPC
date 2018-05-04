package com.qlzy.common.util;


import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.util.BaseAction;
import com.qlzy.util.HttpRequestDeviceUtils;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

public class PcOrWap extends BaseAction {

	protected static HttpServletRequest request;
	
	/**

	 */
	public static String isPc(HttpServletRequest request,String reqUrl ) {
		boolean mobile = HttpRequestDeviceUtils.isMobileDevice(request);
		String domain =request.getServerName(); //获取访问的域名
		Map<String, Object> domainMap = ToolsUtil.splitDomain(domain);

		if (mobile) {//手机终端登录
			return reqUrl+"Wap";
		} else {//电脑终端
			return reqUrl;
		}

	}


}
