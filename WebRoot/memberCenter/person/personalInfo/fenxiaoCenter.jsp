<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
						<h3>分销商</h3>
					</div>
				</div>
				<div class="lh-buyers">
					<div class="w-buyers2">
						<ul>
							<li>
								<div class="biaoti">我的收益</div>
								<div class="neirong01">￥${member.onlyId}<br /> $10.0
									<br /> ADE8.00
								</div>
							</li>
							<li>
								<div class="biaoti">推荐码</div>
								<div class="neirong01">${member.onlyId}</div>
							</li>
							<%--<li>
								<div class="wdd">
									<a href="#">我的店</a>
								</div>
							</li>--%>
							<li style="border: 0px;">
								<div class="wx01"><img src="${member.qrCode}" style="width:180px"></div>
							</li>
						</ul>
					</div>
					<div><a href="tixian.html">申请提现</a></div>
					<div class="w-buyers2 tgar">
						<ul>
							<li>
								<div class="biaoti">一级提成</div>
								<div class="neirong01">￥800.00<br /> $10.0
									<br /> ADE8.00</div>
							</li>
							<li>
								<div class="biaoti">二级提成</div>
								<div class="neirong01">￥800.00<br /> $10.0
									<br /> ADE8.00</div>
							</li>
							<li>
								<div class="biaoti">预计提成</div>
								<div class="neirong01">￥800.00<br /> $10.0
									<br /> ADE8.00</div>
							</li>
							<li style="border: 0px;">
								<div class="biaoti">已发提成</div>
								<div class="neirong01">￥800.00<br /> $10.0
									<br /> ADE8.00</div>
							</li>
						</ul>
					</div>
					<div class="w-buyers3 tgar">
						<ul>
							<li>
								<div class="neirong01"><span>分销商</span>50</div>
							</li>
							<li style="border: 0px;">
								<div class="neirong01"><span>粉丝团</span>50</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!-- 右侧功能结束 -->



		</div>





		<div class="clear"></div>
		<jsp:include page="/admin/common/indexFooter.jsp" />


</body>
</html>