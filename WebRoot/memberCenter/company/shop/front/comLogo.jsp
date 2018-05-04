<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<div class="pos">

	<div class="boxA">
		<a class="box">
		
		 <span class="comtitle">${company.companyName}</span>
		 <span class="qylogo-img">
			<s:if test='null!=company.companyLogo&&""!=company.companyLogo'>
				<img height="83" src="${company.companyLogo}" />			
			</s:if>
			<s:else>
				<img height="83" src="/images/vip/pptlogo.gif" />
			</s:else>
		 </span>
		</a>
	</div>
</div>

