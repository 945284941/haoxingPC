<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--======================miaddle部分开始============================-->
<!-- banenr内容 -->
<div class="top_mid_slide">
	<ul class="top_mid_slider_ul">
		<c:forEach items="${homeList}" var="li" varStatus="status">
		<li class="top_mid_slider_ul_li" style="width: 100%; height: 375px;  background: url(${li.imageUrl}) 50% 0% no-repeat #f7ecda;">
			<a style="display:block;height:380px; width:100%;" href="${li.href}"></a>
		</li>
		</c:forEach>
	</ul>
	<div class="banner_top">
		<ul>
			<li class="" style="cursor:pointer;"></li>
			<li style="cursor:pointer;" class=""></li>
			<li style="cursor:pointer;" class="this"></li>
			<li style="cursor:pointer;" class=""></li>
			<li style="cursor:pointer;" class=""></li>
		</ul>
	</div>
</div>