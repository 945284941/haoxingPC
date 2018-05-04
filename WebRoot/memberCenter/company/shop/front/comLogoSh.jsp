<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 代码 开始 -->
	<div class="gzgz qylogo">
		<div class="pos">
			<div class="boxA">
				<a class="box"> <span class="qylogo-img"> <img
						src="imges/huiyuan1.png" width="174" height="92" /> <s:if
							test='null!=company.companyLogo&&""!=company.companyLogo'>
							<img height="80px" src="${company.companyLogo}" />
						</s:if> <s:else>
							<img height="80px" src="/images/vip/pptlogo.gif" />
						</s:else> </span> <span class="comtitle">${company.companyName}</span> </a>
			</div>
		</div>

	</div>
