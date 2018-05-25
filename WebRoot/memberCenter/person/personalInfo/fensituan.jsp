<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="x-ua-compatible" content="ie=7" />
	<jsp:include page="/admin/common/keyWords.jsp" />
	<title>颐佳商城</title>
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<meta http-equiv="keywords" content="颐佳,商城" />
	<meta http-equiv="description" content="颐佳,商城" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<!-- <link rel="stylesheet" href="web/bootstrap/bootstrap.min.css" type="text/css" /> -->
	<link rel="stylesheet" href="web/css/sghsc-main.css" type="text/css" />
	<link rel="stylesheet" href="web/css/sghsc-order.css" type="text/css" />
	<link rel="stylesheet" href="web/css/datePicker.css" />

	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<link rel="stylesheet" href="css/hyzxgr.css" type="text/css" />
	<link rel="stylesheet" href="css/page.css" type="text/css" />

	<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
	<script type=text/javascript src="js/layer/layer.min.js"></script>
	<script type=text/javascript src="js/slides.jquery.js"></script>
	<script type=text/javascript src="js/tanchu.js"></script>
	<script type=text/javascript src="js/register.js"></script>
	<script type="text/javascript" src="js/layer/layer.js"></script>

	<!-- 日历控件 -->
	<script type="text/javascript" src="web/js/jquery.date_input.pack.js"></script>

	<script type="text/javascript">
        //var aa = '${sessionInfo.userType}';
        $(function() {


        });



	</script>

</head>
<body>
<div id="tanchu"></div>
<!-- 头部开始 -->
<!--======================top开始============================-->
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toPersionLogo" executeResult="true" namespace="/"></s:action>
<!--======================导航开始============================-->
<%--<jsp:include page="/admin/common/navigation.jsp" />--%>
<!-- 头部结束 -->
<%--<div class="breadThumb">首页 > 会员中心 > 电子商城 > 订单管理 > 我的订单</div>--%>

<div class="sghsc-order-main">
	<!-- 左侧功能菜单开始 -->
	<div class="main">
		<div class="h_content">
			<c:choose>
				<c:when test="${sessionInfo.userType=='company' }">
					<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" />
				</c:otherwise>
			</c:choose>
			<!-- 左侧功能菜单结束 -->
			<!-- 右侧功能开始 -->
			<div class="w-buyers">
				<div class="l-fr">
					<div class="w-title">
						<h3><s:text name="index_0205"/></h3>
					</div>
					<table class="table0902" width="100%" border="1" cellspacing="0" cellpadding="0">
						<thead>
						<tr>
							<td><s:text name="index_0211"/></td>
							<td><s:text name="index_0297"/></td>
							<td><s:text name="index_0211"/></td>
							<td><s:text name="index_0297"/></td>
							<td><s:text name="index_0211"/></td>
							<td><s:text name="index_0297"/></td>
						</tr>
						</thead>
						<tbody>
						<tr>
						<c:forEach items="${memberListNew}" var="member" varStatus="s">
							<td>${member.username}</td>
							<td><fmt:formatDate value="${member.regTime}" pattern="yyyy-MM-dd"/></td>
							<c:if test="${s.count%3==0}">
								</tr>
							</c:if>
						</c:forEach>
						</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 右侧功能结束 -->
		</div>
	</div>
</div>
<div class="clear"></div>
<jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>