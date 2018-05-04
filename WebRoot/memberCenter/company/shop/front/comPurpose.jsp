<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="gzgzvip ln">
	<p>
		<strong style="font-size:16px; color:#333333">企业理念和宗旨：</strong>
		<s:if test="null!=company.companyPurpose&&''!=company.companyPurpose">${company.companyPurpose}</s:if>
		<s:else>---</s:else>
	</p>
</div>