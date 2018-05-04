package com.qlzy.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.util.AddressUtils;
import com.qlzy.mainPage.country.service.NCountryService;
import com.qlzy.pojo.SessionInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author koko
 * @date:Dec 31, 2011 10:26:46 AM
 * @version:中英文切换的拦截器
 *
 */
public class I18nChangeInterceptor extends AbstractInterceptor {
	/**
	* @Fields serialVersionUID : 
	*/
	private static final long serialVersionUID = 1L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
        String result="";
		//从页面上获取local,来设置语言
		String local = ServletActionContext.getRequest().getParameter("request_locale");
		Locale locale1 = (Locale) ActionContext.getContext().getSession().get("WW_TRANS_I18N_LOCALE");
		SessionInfo si = (SessionInfo) ActionContext.getContext().getSession().get(ResourceUtil.getSessionInfoName());
		if(local != null){
			//把local拆分成语方编号和区域编号
			String loc[] = local.split("_");
			Locale locale = new Locale(loc[0], loc[1]);
			//把Locale存入session中，系统后面就会使用这个Locale
			ActionContext.getContext().getSession().put("WW_TRANS_I18N_LOCALE", locale);
			if(null == si){
				si = new SessionInfo();
			}
			si.setLanguage(locale.getLanguage());
		}else if(null != locale1 &&  null != locale1.getLanguage() && !"".equals(locale1.getLanguage())){
			ActionContext.getContext().getSession().put("WW_TRANS_I18N_LOCALE", locale1);
			if(null == si){
				si = new SessionInfo();
			}
			si.setLanguage(locale1.getLanguage());
		}else{
			//获取request对象
			HttpServletRequest request= (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
			String url = "ip="+AddressUtils.getIpAdrress(request);
			String address = AddressUtils.getAddress(url,"utf-8");
			Locale locale = null;
			if("中国".equals(address)){
				locale = new Locale("zh", "CN");
			}else{
				locale = new Locale("en", "US");
			}
			//把Locale存入session中，系统后面就会使用这个Locale
			ActionContext.getContext().getSession().put("WW_TRANS_I18N_LOCALE", locale);
			if(null == si){
				si = new SessionInfo();
			}
			si.setLanguage(locale.getLanguage());
		}

		ActionContext.getContext().getSession().put(ResourceUtil.getSessionInfoName(), si);
		result = invocation.invoke();
		return result;
	}
}
