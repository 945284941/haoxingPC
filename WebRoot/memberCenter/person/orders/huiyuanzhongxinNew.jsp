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
						<div class="img"><img src="images/lh_13.jpg" /></div>
						<div class="txt">
							<h3>静水流深</h3>
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
									<a href="#">待付款</a>
								</li>
								<li class="txt-03">
									<a href="#">待发货</a>
								</li>
								<li class="txt-03">
									<a href="#">待收货</a>
								</li>
								<li class="txt-03">
									<a href="#">待评价</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="right01">
						<div class="wsfxs01">
							<a href="#">我是分销商</a>
						</div>
						<div class="wsfxs02">
							<a href="#">分销规则</a>
						</div>
					</div>
				</div>
				<div class="l-fr tgar" style="padding-bottom: 20px;">
					<div class="w-title">
						<h3 class="fl">我的订单</h3>
						<a href="" style="text-align: right; padding: 0 15px; float: right;">查看全部订单</a>
					</div>
					<div class="w-bond-list3">
						<div class="w-bond-tit3">
							<div class="w-bond-num fl">[订单编号：0120123456789]</div>
							<div class="clear"></div>
						</div>
						<div class="w-bond-info3">
							<div class="w-bond-013 borb2" >
								<div class="w-bond-img3 fl">
									<a href="">
										<img src="images/lh_02.jpg">
										<img src="images/lh_02.jpg">
										<img src="images/lh_02.jpg">
										<span>...</span>
									</a>
								</div>
								<div class="w-bond-name3 fl">
									<a href="">小小</a></div>
								<div class="clear"></div>
							</div>
							<div class="w-bond-023">
								<p>￥80000.00</p>
								<p>$12.00</p>
								<p>AED10</p>
							</div>
							<div class="w-bond-033">
								<a href="">2017-05-02<br>12:00:20</a>
							</div>
							<div class="w-bond-043">等待付款</div>
							<div class="w-bond-053">
								<button type="button" class="btn-danger03">查看订单</button>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="w-bond-list3">
						<div class="w-bond-tit3">
							<div class="w-bond-num fl">[订单编号：0120123456789]</div>
							<div class="clear"></div>
						</div>
						<div class="w-bond-info3">
							<div class="w-bond-013 borb2" >
								<div class="w-bond-img3 fl">
									<a href="">
										<img src="images/lh_02.jpg">
										<img src="images/lh_02.jpg">
										<img src="images/lh_02.jpg">
										<span>...</span>
									</a>
								</div>
								<div class="w-bond-name3 fl">
									<a href="">小小</a></div>
								<div class="clear"></div>
							</div>
							<div class="w-bond-023">
								<p>￥80000.00</p>
								<p>$12.00</p>
								<p>AED10</p>
							</div>
							<div class="w-bond-033">
								<a href="">2017-05-02<br>12:00:20</a>
							</div>
							<div class="w-bond-043">等待付款</div>
							<div class="w-bond-053">
								<button type="button" class="btn-danger03">查看订单</button>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="w-bond-list3">
						<div class="w-bond-tit3">
							<div class="w-bond-num fl">[订单编号：0120123456789]</div>
							<div class="clear"></div>
						</div>
						<div class="w-bond-info3">
							<div class="w-bond-013 borb2" >
								<div class="w-bond-img3 fl">
									<a href="">
										<img src="images/lh_02.jpg">
										<img src="images/lh_02.jpg">
										<img src="images/lh_02.jpg">
										<span>...</span>
									</a>
								</div>
								<div class="w-bond-name3 fl">
									<a href="">小小</a></div>
								<div class="clear"></div>
							</div>
							<div class="w-bond-023">
								<p>￥80000.00</p>
								<p>$12.00</p>
								<p>AED10</p>
							</div>
							<div class="w-bond-033">
								<a href="">2017-05-02<br>12:00:20</a>
							</div>
							<div class="w-bond-043">等待付款</div>
							<div class="w-bond-053">
								<button type="button" class="btn-danger03">查看订单</button>
							</div>
							<div class="clear"></div>
						</div>
					</div>


				</div>
				<div class="l-fr">
					<div class="w-title">
						<h3 class="fl">我收藏的商品</h3>
						<a href="" style="text-align: right; padding: 0 15px; float: right; ">查看全部订单</a>
					</div>
					<div class="lh_dpyytg01">
						<ul>
							<li><a href="#"><img src="images/lh_12.png"/></a></li>
							<li><a href="#"><img src="images/lh_12.png"/></a></li>
							<li><a href="#"><img src="images/lh_12.png"/></a></li>
							<li><a href="#"><img src="images/lh_12.png"/></a></li>
						</ul>
					</div>
				</div>
			</div>
		<!-- 右侧功能结束 -->





</body>
</html>