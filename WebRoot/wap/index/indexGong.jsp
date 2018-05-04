<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="../../js/changeLanguage.js"></script>
<div class="swiper-container index_notice">

	<div class="swiper-wrapper">
		<c:forEach items="${gonggaoList}" var="gongao" varStatus="status">

			<c:if test="${'zh' eq sessionInfo.language}">
				<div class="swiper-slide">
					<a href="#" target="_blank" title="${gongao.firstTitle}">${fn:substring(gongao.firstTitle,0, 11)}</a>
				</div>
			</c:if>
			<c:if test="${'zh' ne sessionInfo.language}">
				<div class="swiper-slide">
					<a href="#" target="_blank" title="${gongao.secondTitle}">${fn:substring(gongao.secondTitle,0, 11)}</a>
				</div>
			</c:if>


		</c:forEach>


	</div>
	<!-- Add Arrows -->
	<div class="swiper-button-next"></div>
	<div class="swiper-button-prev"></div>
</div>