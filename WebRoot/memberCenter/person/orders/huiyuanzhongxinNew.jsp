<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	var aa = '${sessionInfo.userType}';
	$(function() {
		/*if (aa == 'company') {
			window.location.href = 'person/order/sellOrders.html';
		}*/

		//日历控件
		//$('#orders_startTime').date_input();
		//$('#orders_endTime').date_input();
	});

	function dropOrder(orderId) {
		if (confirm("确定要删除?删除后该订单不能恢复!")) {
			$.ajax({
				url : 'person/order/DropmyOrders.html',
				type : 'POST',
				data : 'id=' + orderId,
				success : function(data) {
					var r = $.parseJSON(data);
					if (r == 'ok') {
						alert('删除成功！');
						window.location.href = "person/order/myOrders.html";
					} else {
						alert('删除失败！');
						return false;
					}

				}
			});
		}

	}

	//会员点击收货操作
	function memberPayOrder(orderId, orderNum, payMent) {
		// 			$("#payPassword").val("");
		$("#payOrderId").val(orderId);
		$("#payOrderOrderNum").val(orderNum);
		$("#payMent").val(payMent);
		confirm("确认收货") ? $("#receiveGoodsFrom").submit() : "";
		// 			showsplbtitle('tanchu', 'shxx');
	}

	//会员点击评价操作
	function memberEvaluateOnclick(orderId, goodsId, companyId) {
		$("#member_evaluate_orderId").val(orderId);
		$("#member_evaluate_goodsId").val(goodsId);
		$("#member_evaluate_companyId").val(companyId);
		showsplbtitle('tanchu', 'pjnr');
	}

	function changeStatus(orderId,status,disabled) {
		$.ajax({
            url : 'orderAction!changeOrderStatus.action',
            type : 'POST',
            data : {orderId:orderId,status:status,disabled:disabled},
            success : function(data) {
                var r = $.parseJSON(data);
                if (r == 'ok') {
                    alert('<s:text name="index_0315"/>！');
                    window.location.href = "person/order/huiyuanzhongxin.html";
                } else {
                    alert('<s:text name="index_0316"/>！');
                    return false;
                }
            }
		});
    }
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
				<div class="w-buyers2">
					<div class="w-buy-name">
						<div class="img"><img src="${member.img}" /></div>
						<div class="txt">
							<h3>${member.firstname}</h3>
							<span>
						    			<i class="icon iconfont on"></i>
						    			<i class="icon iconfont on"></i>
						    			<i class="icon iconfont on"></i>
						    			<i class="icon iconfont on"></i>
						    			<i class="icon iconfont on"></i>
						    		</span>
						</div>
						<div class="txt">
							<ul>
								<li class="txt-03">
									<a href="person/order/myOrders/1.html" ><s:text name="index_0122"/></a>
								</li>
								<li class="txt-03">
									<a href="person/order/myOrders/2.html"><s:text name="index_0123"/></a>
								</li>
								<li class="txt-03">
									<a href="person/order/myOrders/3.html"><s:text name="index_0124"/></a>
								</li>
								<li class="txt-03">
									<a href="person/order/myOrders/5.html"><s:text name="index_0173"/></a>
								</li>
							</ul>
						</div>
					</div>
					<div class="right01">
						<div class="wsfxs01">
							<a href="personalInfo/fenxiaoCenter.html"><s:text name="index_0120"/></a>
						</div>
						<div class="wsfxs02">
							<a href="#"><s:text name="index_0339"/></a>
						</div>
					</div>
				</div>
				<div class="l-fr tgar" style="padding-bottom: 20px;">
					<div class="w-title">
						<h3 class="fl"><s:text name="index_0088"/></h3>
						<a href="person/order/myOrders.html" style="text-align: right; padding: 0 15px; float: right;"><s:text name="index_0340"/></a>
					</div>
				<c:if test="${empty orderList}">
					<div style="text-align: center;"><img style="height: 260px" src="images/wujilu.jpg"/></div>
				</c:if>
				<c:if test="${not empty orderList}">
					<ul>
						<div class="w-bond" style="padding: 20px 0 0;">
							<div class="w-bond-title">
								<p class="w-title-name" style="width: 200px"><s:text name="index_0341"/></p>
								<p class="w-title-time" style="width: 100px"><s:text name="index_0151"/></p>
								<p class="w-title-time" style="width: 140px"><s:text name="index_0342"/></p>
								<p class="w-title-time"><s:text name="index_0343"/></p>
								<p class="w-title-mony"><s:text name="index_0344"/></p>
								<p class="w-title-mony"><s:text name="index_0300"/></p>
							</div>
						</div>
					</ul>
					<c:forEach items="${orderList}" var="order" varStatus="n">
					<c:if test="${n.index<3}">
					<div class="w-bond-list3">
						<div class="w-bond-tit3">
							<div class="w-bond-num fl">[<s:text name="index_0176"/>：${order.orderNum}]</div>
							<div class="clear"></div>
						</div>
						<div class="w-bond-info3">
							<div class="w-bond-013 borb2" >
								<div class="w-bond-img3 fl">
									<a href="">
										<c:forEach items="${order.items}" var="item">
										<img src="${item.defaultPicSrc}">
										</c:forEach>
										<span>...</span>
									</a>
								</div>
								<div class="w-bond-name3 fl">
									<a href="">${order.shipName}</a></div>
								<div class="clear"></div>
							</div>
							<div class="w-bond-023">
								<p>￥${order.totalCost}</p>
								<p>$<fmt:formatNumber type="number" value="${huilv.now_rate_doc * order.totalCost}" pattern="0.00" maxFractionDigits="2"/></p>
								<p>AED<fmt:formatNumber type="number" value="${huilv.now_rate_dlm * order.totalCost}" pattern="0.00" maxFractionDigits="2"/></p>
							</div>
							<div class="w-bond-033">
								<a href=""><fmt:formatDate value="${order.createtime}" pattern="yyyy-MM-dd"/>
									<br><fmt:formatDate value="${order.createtime}" pattern="HH:mm:ss" /></a>
							</div>
							<c:if test="${order.status=='1'&&order.payStatus=='0'&&order.shipStatus=='0'}">
							<div class="w-bond-043"><s:text name="index_0357"/></div>
							<div class="w-bond-053">
								<a href="person/order/toOrderDetail/${order.id}.html"><s:text name="index_0345"/></a>
								<a href="javascript:void(0)" onclick="changeStatus('${order.id}','6','${order.disabled}')"><s:text name="index_0181"/></a>
							</div>
							</c:if>
							<c:if test="${order.status=='6'&&order.payStatus=='0'&&order.shipStatus=='0'}">
								<div class="w-bond-043"><s:text name="index_0171"/></div>
								<div class="w-bond-053">
									<a href="person/order/toOrderDetail/${order.id}.html"><s:text name="index_0345"/></a>
									<a href="javascript:void(0)" onclick="changeStatus('${order.id}','${order.status}','true')"><s:text name="index_0147"/></a>
								</div>
							</c:if>
							<c:if test="${order.status=='2'&&order.payStatus=='1'&&order.shipStatus=='0'}">
								<div class="w-bond-043"><s:text name="index_0336"/></div>
								<div class="w-bond-053">
									<a href="person/order/toOrderDetail/${order.id}.html"><s:text name="index_0345"/></a>
									<a href="javascript:void(0)" onclick="changeStatus('${order.id}','7','${order.disabled}')"><s:text name="index_0187"/></a>
								</div>
							</c:if>
							<c:if test="${order.status=='7'}">
								<div class="w-bond-043"><s:text name="index_0346"/></div>
								<div class="w-bond-053">
									<a href="person/order/toOrderDetai/l${order.id}.html"><s:text name="index_0345"/></a>
								</div>
							</c:if>
							<c:if test="${order.status=='3'&&order.payStatus=='1'&&order.shipStatus=='1'}">
								<div class="w-bond-043"><s:text name="index_0124"/><br/>
									<a><s:text name="index_0347"/></a>
								</div>
								<div class="w-bond-053">
									<a href="person/order/toOrderDetail/${order.id}.html"><s:text name="index_0345"/></a>
									<a href="javascript:void(0)" onclick="changeStatus('${order.id}','4','${order.disabled}')"><s:text name="index_0070"/></a>
									<a href="javascript:void(0)" onclick="changeStatus('${order.id}','7','${order.disabled}')"><s:text name="index_0348"/></a>
								</div>
							</c:if>
							<c:if test="${order.status=='5'&&order.payStatus=='1'&&order.shipStatus=='2'}">
								<div class="w-bond-043"><s:text name="index_0173"/></div>
								<div class="w-bond-053">
									<a href="person/order/toOrderDetail/${order.id}.html"><s:text name="index_0345"/></a>
									<a href="javascript:void(0)" onclick="changeStatus('${order.id}','4','${order.disabled}')"><s:text name="index_0070"/></a>
									<%--<button type="button" class="btn-danger03">评价</button>--%>
								</div>
							</c:if>
							<c:if test="${order.status=='4'&&order.payStatus=='1'&&order.shipStatus=='2'}">
								<div class="w-bond-043"><s:text name="index_0174"/></div>
								<div class="w-bond-053">
									<a href="person/order/toOrderDetail/${order.id}.html"><s:text name="index_0345"/></a>
									<a href="javascript:void(0)" onclick="changeStatus('${order.id}','4','${order.disabled}')"><s:text name="index_0070"/></a>
								</div>
							</c:if>
							<div class="clear"></div>
						</div>
					</div>
					</c:if>
					</c:forEach>
				</c:if>
				</div>
				<div class="l-fr">
					<div class="w-title">
						<h3 class="fl"><s:text name="index_0349"/></h3>
						<a href="showGoodsCollect.html" style="text-align: right; padding: 0 15px; float: right; "><s:text name="index_0350"/></a>
					</div>
					<div class="lh_dpyytg01">
						<c:if test="${empty memberCollectList}">
							<div style="text-align: center;"><img style="height: 240px" src="images/wujilu.jpg"/></div>
						</c:if>
						<c:if test="${not empty memberCollectList}">
						<ul>
						<c:forEach items="${memberCollectList}" var="memberCollect" varStatus="n">
						<c:if test="${n.index<4}">
							<li><a href="goods/${memberCollect.goodsId}.html"><img src="${memberCollect.defaultPicSrc}"/></a></li>
						</c:if>
						</c:forEach>
						</ul>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<!-- 右侧功能结束 -->
	</div>
</div>
	<jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>