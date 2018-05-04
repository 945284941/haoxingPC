<%@page import="javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<meta http-equiv="keywords" content="" />
<meta http-equiv="description" content="" />
<link rel="stylesheet" href="css/page.css" type="text/css"></link>
<link rel="stylesheet" href="web/css/main.css" type="text/css"></link>
<link href="css/news.css" rel="stylesheet" type="text/css">
<title>商城公告</title>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/slides.jquery.js"></script>

<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
</head>
<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="/admin/common/navigation.jsp" />
<div class="breadThumb">当前位置：首页 &gt; 商城公告 </div>
<div class="gzgz">
	<div class="listleft" >
		<div class="listbk">
			<p class="zplist_new">
				<span class="xwzxz">${newsCatName }</span>
			</p>
				<ul class="listnew">
					<c:forEach items="${list }" var="v" varStatus="vs">
						<li><span class="listnr" ><a href="news/detail/${v.id }.html" title="${v.firstTitle }">
								${fn:substring(v.firstTitle, 0, 22)}
						</a>
						</span><span class="listdate"><fmt:formatDate value="${v.createtime}" pattern="yyyy-MM-dd" ></fmt:formatDate></span>
						</li>
					</c:forEach>
				</ul>
			<div id="showpages">
				<page:pagination path="news/more/${ncn}.html" />
			</div>
		</div>
	</div>
</div>
<div class="clear"></div>
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>