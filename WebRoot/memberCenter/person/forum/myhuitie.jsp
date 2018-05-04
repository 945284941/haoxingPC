<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv=”X-UA-Compatible” content=”IE=edge,chrome=1″ />
<jsp:include page="/admin/common/keyWords.jsp" />
<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/page.css" type="text/css" />
<title>三古汇官方商城</title>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
</head>
<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="/admin/common/navigation.jsp" />
<div class="breadThumb">首页 > 会员中心 > 电子商城 > 我的参与 > 我的回帖</div>
<div class="gzgz">
	<div class="hyleft">
		<c:choose>
			<c:when test="${sessionInfo.userType=='company' }"><jsp:include page="/memberCenter/common/leftNavigate.jsp" /></c:when>
			<c:otherwise><jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" /></c:otherwise>
		</c:choose>	
	</div>
	<div class="hyright">
		<p class="hymainbt">
			<span class="grmenubt">我的参与</span>
		</p>        
		<div class="sq_bot_nr_rit">
			<table class="table table-striped table-bordered myforumTable">
				<thead>
					<tr>
						<th>我的回帖</th>
						<th width="120">发帖信息</th>
						<th width="120">回帖信息</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="v" varStatus="vs">
					<tr>
						<td class="towline"><a href="HuiTieIndex/${v.forumId }.html "  title="${v.title }">${v.title }</a></td>
						<td>
							${v.userName }<br/>
							<fmt:formatDate value="${v.createTime}" pattern="yyyy-MM-dd" ></fmt:formatDate>
						</td>
						<td>
							${v.userNames }<br>
							<fmt:formatDate value="${v.createTimes}" pattern="yyyy-MM-dd" ></fmt:formatDate>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		<!--======================翻页开始============================-->
	     <form id="pagerForm" name="pagerForm" action="myhuitie/${userId }.html" method="post">
			 <input type="hidden" id="pageNum" name="pageNum" value="1" /> 
			 <input type="hidden" id="sort" name="sort" value="<s:property value='#request.sort'/>" />
			 <input type="hidden" id="order" name="order" value="<s:property value='#request.order'/>" />
		  </form>
		 <div class="fenye"  id="showpages">
		   <page:pagination path="myhuitie/${userId }.html" formName="pagerForm"/>
		</div>
        </div>
	</div>
</div>
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>