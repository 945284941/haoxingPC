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
			<form id="pagerForm" name="pagerForm" action="person/personalInfo!toYujiticheng.action?dengji=1" method="post">
				<input type="hidden" name="order.orderNum" id="orderNum" value="${order.orderNum}"/>
			</form>
			<div class="w-buyers">
				<div class="l-fr">
					<div class="w-title">
						<h3>预计提成</h3>
					</div>
				</div>

				<div class="l-fr1 tgar">

					<div class="slideTxtBox">
						<div class="hd">
							<ul>
								<li id="first" class="on">
									<a href="personalInfo/yujiticheng/1.html">一级分销商</a>
								</li>
								<li id="second" >
									<a href="personalInfo/yujiticheng/2.html">二级分销商</a>
								</li>
							</ul>
						</div>
						<div class="bd">
							<ul>
								<div class="lh_sales">
									<c:forEach items="${orderList}" var="order">
									<div class="order tgar">
										<div class="order_bh borb">
											<div class="order_bh_left">订单编号：${order.orderNum}</div>
											<div class="order_bh_right"><fmt:formatDate type="time" value="${order.createtime}" ></fmt:formatDate></div>
										</div>
										<div class="order_jg">
											<div class="order_jg_left">总价：<span>￥<fmt:formatNumber type="number" value="${1 * order.totalCost}" pattern="0.00" maxFractionDigits="2"  /> $<fmt:formatNumber type="number" value="${huilv.now_rate_doc * order.totalCost}" pattern="0.00" maxFractionDigits="2"/>  AED<fmt:formatNumber type="number" value="${huilv.now_rate_dlm * order.totalCost}" pattern="0.00" maxFractionDigits="2"/>   </span> </div>
											<div class="order_jg_right">提成：
												<span>
													<c:if test="${dengji eq '1'}">
														￥<fmt:formatNumber type="number" value="${yijibili * order.orderPoints}" pattern="0.00" maxFractionDigits="2"/>
													</c:if>
													<c:if test="${dengji eq '2'}">
														￥<fmt:formatNumber type="number" value="${erjibili * order.orderPoints}" pattern="0.00" maxFractionDigits="2"/>
													</c:if>
												</span>
											</div>
										</div>
									</div>
									</c:forEach>
								</div>

							</ul>
							<!-- 分页开始 -->

							<div class="clear"></div>
							<!--分页-->
							<div id="pageReload">
								<page:pagination path="person/personalInfo!toYujiticheng.action?dengji=1" formName="pagerForm"/>
							</div>
							<!-- 分页结束 -->
						</div>
					</div>
				</div>
			</div>
			<!-- 右侧功能结束 -->

		</div>


	</div>

</div>


		<div class="clear"></div>
		<jsp:include page="/admin/common/indexFooter.jsp" />


</body>
<script type="text/javascript">
    function subFo() {
        var url="indexFloor/indexFloorAction!showIndexWantBuyFloor.action";
        $.ajax({
            type:"POST",
            url:url,
            cache:true,
            async:true,
            data : $('#pagerForm').serialize(),
            success:function (html) {
                $("#pageReload").html(html);
            }
        });
    }
</script>
</html>