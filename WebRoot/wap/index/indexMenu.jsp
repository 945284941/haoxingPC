<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="../../js/changeLanguage.js"></script>
<div class="mainlist clearfix">
	<ul>
		<c:if test="${'zh' eq sessionInfo.language}">
			<li>
				<a id="65537" href="${dict.value}" target="_blank" original_url=""><p class="iconfont">&#xe67f;</p>${dict.label}</a>
			</li>
		</c:if>
		<c:if test="${'zh' ne sessionInfo.language}">
			<li>
				<a id="65539" href="${dict.value}" target="_blank" original_url=""><p class="iconfont">&#xe67f;</p>${dict.labelEng}</a>
			</li>
		</c:if>
	</ul>
</div>