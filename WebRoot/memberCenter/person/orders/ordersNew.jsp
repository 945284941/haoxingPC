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

//	/* function chankanwuliu(wuliu) {
//		$
//				.ajax({
//					url : 'person/order/chakanwuliu.html',
//					type : 'post',
//					data : 'wuliu=' + wuliu,
//					dataType : "json",
//					success : function(messagew) {
//						var message = eval('(' + messagew + ')');
//						var msg = '<div style="max-height:400px;overflow:auto;"><ul class="wuliuxinxi" style="max-height:70%;overflow-y:auto">';
//						if (message.status == 0) {
//							$.each(message.result.list, function(index, item) {
//								msg += '<li><p>' + item.status + '</p><p>'
//										+ item.time + '</p></li>';
//							});
//						} else {
//							msg += '<li><p>' + message.msg + '</p></li>';
//						}
//						msg += '</ul></div>';
//						layer.open({
//							content : msg
//						})
//					}
//				});
//	}*/

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

	//会员进行等级平均
	function memberEvaluate(type, evaluate) {
		if (evaluate == 1) {//好评
			$("#" + type + "1").attr("src", "images/memberimg/pjdj.gif");
			$("#" + type + "2").attr("src", "images/memberimg/pjdj.gif");
			$("#" + type + "3").attr("src", "images/memberimg/pjdj.gif");
			$("#" + type + "Type").html("好评");
		} else if (evaluate == 0) {//中评
			$("#" + type + "1").attr("src", "images/memberimg/pjdj.gif");
			$("#" + type + "2").attr("src", "images/memberimg/pjdj.gif");
			$("#" + type + "3").attr("src", "images/memberimg/pjdj2.gif");
			$("#" + type + "Type").html("中评");
		} else {//差评
			$("#" + type + "1").attr("src", "images/memberimg/pjdj.gif");
			$("#" + type + "2").attr("src", "images/memberimg/pjdj2.gif");
			$("#" + type + "3").attr("src", "images/memberimg/pjdj2.gif");
			$("#" + type + "Type").html("差评");
		}
		$("#member_evaluate_" + type).val(evaluate);
	}

	function memberEvaluateSubmit() {
		var evaluate = $("#member_evaluate_appraise").val();
		var serve = $("#member_evaluate_serve").val();
		var quality = $("#member_evaluate_quality").val();
		var credit = $("#member_evaluate_credit").val();
		var logistics = $("#member_evaluate_logistics").val();
		if (evaluate == null || evaluate == '' || evaluate == '请在此处填写你对商品的评价……') {
			alert('请对商品填写评价内容！');
		} else if (serve == null || serve == '') {
			alert('请对服务评级进行评价！');
		} else if (quality == null || quality == '') {
			alert('请对质量评级进行评价！');
		} else if (credit == null || credit == '') {
			alert('请对信誉评级进行评价！');
		} else if (logistics == null || logistics == '') {
			alert('请对物流评级进行评价！');
		} else {
			$("#memberEvaluateFrom").submit();
		}
	}

	//点击申请退货
	function returnGoodsOnclick(orderId, orderNum, shipStatus, orderTotal) {
		$("#returnGoods_orderId").val(orderId);
		$("#returnGoods_isdelivery").val(shipStatus);
		$("#returnGoods_orderTotal").val(orderTotal);
		$("#returnGoods_orderIdSpan").html(orderNum);
		showsplbtitle('tanchu', 'thtk');
	}

	// 提交退款退货
	function returnGoodsSubmit() {
		var returnMoney = $("#orderReturn_returnMoney").val();
		var logisticsNum = $("#orderReturn_logisticsNum").val();
		var logisticsName = $("#orderReturn_logisticsName").val();
		var logisticsTel = $("#orderReturn_logisticsTel").val();
		var cause = $("#orderReturn_cause").val();
		var orderTotal = $("#returnGoods_orderTotal").val();
		var shipType = $("#returnGoods_isdelivery").val();
		if (returnMoney == null || returnMoney == '') {
			alert("请填写需要退款金额！");
		} else if (returnMoney > orderTotal) {
			alert("退款金额不得超过订单总金额");
		} else if (shipType == "1"
				&& (logisticsNum == null || logisticsNum == '')) {
			alert("退回货物的物流单号不能为空！");
		} else if (shipType == "1"
				&& (logisticsName == null || logisticsName == '')) {
			alert("退回货物的物流公司不能为空！");
		} else if (shipType == "1"
				&& (logisticsTel == null || logisticsTel == '')) {
			alert("退回货物的物流公司电话不能为空！");
		} else if (cause == null || cause == '') {
			alert("请填写退款、退货的原因！");
		} else {
			$("#memberReturnGoodsForm").submit();
		}

	}

	function searchSubmit(type) {
		if (0 == type) {
			$("#payStatus").val("-1");
			$("#shipStatus").val("-1");
		}
		if (1 == type) { //代付款
			//未付款，未发货
			$("#payStatus").val("0");
			$("#shipStatus").val("0");
		}
		if (2 == type) { //代发货
			//已付款，未发货
			$("#payStatus").val("1");
			$("#shipStatus").val("0");
		}
		if (3 == type) { //待收货
			//已付款，已发货
			$("#payStatus").val("1");
			$("#shipStatus").val("1");
		}
		if (4 == type) { //已完成
			//  已收货
			$("#payStatus").val("-1");
			$("#shipStatus").val("2");
		}
		$("#person_orders_orderForm").submit();
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
			<div class="l-fr">
				<div class="w-title">
					<h3>我的订单</h3>
				</div>
				<div class="vip_b3">
					<div class="vip_a15">订单号 <input type="text" class="q1"></div>
					<div class="vip_a15">商品名 <input type="text" class="q1"></div>
					<div class="vip_a15">收货人 <input type="text" class="q1"></div>
				</div>
				<div class="vip_b3">
					<div class="vip_a15">订单状态
						<select name="" class="lbcd2">
							<option value="平台商城">所有订单</option>
							<option value="平台商城">所有订单</option>
							<option value="平台商城">所有订单</option>
						</select>
					</div>
					<div class="vip_a15">订单期限
						<select name="" class="lbcd2">
							<option value="平台商城">最近三个月</option>
							<option value="平台商城">最近三个月</option>
							<option value="平台商城">最近三个月</option>
						</select>
					</div>
					<a href="">
						<div class="vip_a14">查询</div>
					</a>
				</div>
				<div class="slideTxtBox">
					<div class="bd" style="margin-bottom: 15px;">
						<ul>
							<div class="w-bond" style="padding: 20px 0 0;">
								<div class="w-bond-title">
									<p class="w-title-name">订单信息</p>
									<p class="w-title-time">收货人</p>
									<p class="w-title-time">订单金额</p>
									<p class="w-title-mony">订单状态</p>
									<p class="w-title-mony">操作</p>
								</div>
							</div>
						</ul>
						<s:iterator var="o" value="orderList" status="status">
						<table class="sghsc-order-rig-dd-tit">
							<div class="w-bond-tit3">
								<div class="w-bond-num fl">订单编号：${o.orderNum}    下单时间：<span class="sghsc-order-rig-dd-tit-1"><s:date name="#o.createtime" format="yyyy-MM-dd HH:mm:ss" /></span> </div>
								<div class="clear"></div>
							</div>
							<tbody>

							<tr>
								<td width="310"><a href="goods/${i.goodsId}.html" target="_blank"> <img
										src="${i.goodsPic}" border="0" width="80" height="80" />
								</a></td>
								<td width="492"><a href="goods/${i.goodsId}.html" target="_blank"> <span
										style="line-height:16px;">${i.goodsName}</span> </a></td>
								<td width="36">￥${o.totalCost}</td>
								<td width="492">
									<s:if test="#o.payStatus == 0">待付款</s:if>
									<s:if test="#o.payStatus == 1 && #o.shipStatus == 0">待发货</s:if>
									<s:if test="#o.payStatus == 1 && #o.shipStatus == 1">已发货</s:if>
									<s:if test="#o.payStatus == 1 && #o.shipStatus == 2">已完成</s:if>
									<s:if test="#o.payStatus ==3">已退款</s:if>
								</td>
								<td width="36"></td>
							</tr>
							</tbody>
						</table>
						</s:iterator>

						<!--分页-->
						<link rel="stylesheet" href="web/css/sghsc-goods.css">

						<!-- 分页开始 -->
						<div id="showpages">
							<page:pagination path="person/order/myOrders.html"
											 formName="person_orders_orderForm" />
						</div>
						<!-- 分页结束 -->


						<%--<div class="w-bond-list3">
							<div class="w-bond-tit3">
								<div class="w-bond-num fl">订单编号：${o.orderNum}    下单时间：<span class="sghsc-order-rig-dd-tit-1"><s:date name="#o.createtime" format="yyyy-MM-dd HH:mm:ss" /></span> </div>
								<div class="clear"></div>
							</div>
							<div class="w-bond-info3">
								<div class="w-bond-013 borb2">
									<div class="w-bond-img3 fl">
										<c:choose>
											<c:when test="${i.goods != null && i.goods != '' && i.goods.marketable != 'false' && i.goods.disabled != 'true' }">
												<a href="goods/${i.goodsId}.html" target="_blank"> <img
														src="${i.goodsPic}" border="0" width="80" height="80" />
												</a>
											</c:when>
											<c:otherwise>
												<img src="${i.goodsPic}" border="0" width="80" height="80" />
											</c:otherwise>
										</c:choose>

									</div>
									<div class="w-bond-name3 fl">
										<c:choose>
											<c:when
													test="${i.goods != null && i.goods != '' && i.goods.marketable != 'false' && i.goods.disabled != 'true' }">
												<a href="goods/${i.goodsId}.html" target="_blank"> <span
														style="line-height:16px;">${i.goodsName}</span> </a>
											</c:when>
											<c:otherwise>
															<span class="sghsc-order-rig-dd-1-bt-p-2"
																  style="line-height:16px;">${i.goodsName}</span>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="clear"></div>
								</div>
								<div class="w-bond-023">
									<p>￥${o.totalCost}</p>
									<p>$12.00</p>
									<p>AED10</p>
								</div>
								<div class="w-bond-033">
									<a href="">2017-05-02<br>12:00:20</a>
								</div>
								<div class="w-bond-043">
									<s:if test="#o.payStatus == 0">待付款</s:if>
									<s:if test="#o.payStatus == 1 && #o.shipStatus == 0">待发货</s:if>
									<s:if test="#o.payStatus == 1 && #o.shipStatus == 1">已发货</s:if>
									<s:if test="#o.payStatus == 1 && #o.shipStatus == 2">已完成</s:if>
									<s:if test="#o.payStatus ==3">已退款</s:if>
								</div>
								<div class="w-bond-053">
									<s:if test=" #o.payStatus == 1 && #o.shipStatus == 1">
										<div class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
											<a href="javascript:void(0)" class="sghsc-order-rig-dd-1-paya" onclick="memberPayOrder('${o.id}','${o.orderNum }','${o.payMent }')">
												<span class="sghsc-order-rig-dd-1-pay">确认收货</span>
											</a>
										</div>
									</s:if>
									<s:if test="#i.isLogistice == 1">
									<div class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
										<a href="logisticsDetail/${i.logisticsNum}.html" class="sghsc-order-rig-dd-1-paya" target="_blank">
											<span class="sghsc-order-rig-dd-1-pay">查看物流</span>
										</a>
									</div>
									</s:if>
									<s:if test="#o.payStatus == 0">
										<div
												class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
											<a href="payment!toPaymentType.action?orderId=${o.id}"
											   class="sghsc-order-rig-dd-1-paya" target="_blank">
												<span class="sghsc-order-rig-dd-1-pay">支付订单</span> </a>
										</div>

										<div
												class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
											<a class="sghsc-order-rig-dd-1-paya"
											   onclick="dropOrder('${o.id}')" href="javascript:void(0)">
												<span class="sghsc-order-rig-dd-1-pay">删除订单</span> </a>
										</div>
									</s:if>
									<a href="toOrderDetail/${o.id}.html" class="sghsc-order-rig-dd-1-bta" target="_blank">查看订单</a>

									<a href="">取消订单</a>

								</div>
								<div class="clear"></div>
							</div>
						</div>--%>






			</div>
		</div>
		</div>
		</div>
		<!-- 右侧功能结束 -->
























		<div class="sghsc-order-main-right">
			<div class="sghsc-order-rig-tit">我的订单</div>
			<form id="person_orders_orderForm" name="person_orders_orderForm"
				action="person/order/myOrders.html" method="post">
				<input type="hidden" id="payStatus" name="payStatus"
					value="${payStatus}" /> <input type="hidden" id="shipStatus"
					name="shipStatus" value="${shipStatus}" />

				<div class="sghsc-order-rig-qh">
					<div class="sghsc-order-rig-qh-1">
						<a onclick="searchSubmit(0);" target="_self">全部订单</a> <a
							onclick="searchSubmit(1);" target="_self">待付款</a> <a
							onclick="searchSubmit(2);" target="_self">待发货</a> <a
							onclick="searchSubmit(3);" target="_self">待收货</a> <a
							onclick="searchSubmit(4);" target="_self">已完成</a>
					</div>
				</div>
				<div class="sghsc-order-rig-cj" id="ssbox3">
					<span>成交时间：</span> <span> <input type="text"
						id="orders_startTime" name="startTime" value="${startTimeStr}"
						class="sghsc-order-rig-cjsj" placeholder="请选择起始时间" />&nbsp;--- <input
						type="text" id="orders_endTime" name="endTime"
						value="${endTimeStr}" class="sghsc-order-rig-cjsj"
						placeholder="请选择结束时间" /> </span> <span>订单编号：</span> <span> <input
						type="text" name="orderNum" value="${orderNum}"
						class="sghsc-order-rig-cjsj" placeholder="请输入订单编号">
					</span> <span> <a class="sghsc-order-rig-qh-62"
						onclick="searchSubmit(-1);">搜索</a> </span>
				</div>
			</form>

			<div class="sghsc-order-rig-zt">
				<div class="sghsc-order-rig-zt-1"></div>
				<div class="sghsc-order-rig-zt-2">订单</div>
				<div class="sghsc-order-rig-zt-3">单价</div>
				<div class="sghsc-order-rig-zt-4">数量</div>
				<div class="sghsc-order-rig-zt-5">实付款</div>
				<div class="sghsc-order-rig-zt-6">交易状态</div>
				<div class="sghsc-order-rig-zt-7">操作</div>
			</div>
			<s:iterator var="o" value="orderList" status="status">
				<div class="sghsc-order-rig-dd">

					<table class="sghsc-order-rig-dd-tit">
						<tbody>
							<tr>
								<td width="160"><span class="sghsc-order-rig-dd-tit-1"><s:date
											name="#o.createtime" format="yyyy-MM-dd HH:mm:ss" />
								</span>
								</td>
								<td width="310">订单编号：${o.orderNum}</td>
								<td width="492"></td>
								<td width="36"></td>
							</tr>
						</tbody>
					</table>

					<s:iterator var="i" value="#o.items" status="st">
						<table>
							<tbody>
								<tr>
									<td class="sghsc-order-rig-dd-1-td">
										<div class="sghsc-order-rig-dd-1-div">
											<div class="sghsc-order-rig-dd-1-img">
												<c:choose>
													<c:when
														test="${i.goods != null && i.goods != '' && i.goods.marketable != 'false' && i.goods.disabled != 'true' }">
														<a href="goods/${i.goodsId}.html" target="_blank"> <img
															src="${i.goodsPic}" border="0" width="80" height="80" />
														</a>
													</c:when>
													<c:otherwise>
														<img src="${i.goodsPic}" border="0" width="80" height="80" />
													</c:otherwise>
												</c:choose>

											</div>
											<div class="sghsc-order-rig-dd-1-bt">
												<p>
													<c:choose>
														<c:when
															test="${i.goods != null && i.goods != '' && i.goods.marketable != 'false' && i.goods.disabled != 'true' }">
															<a href="goods/${i.goodsId}.html" target="_blank"> <span
																style="line-height:16px;">${i.goodsName}</span> </a>
														</c:when>
														<c:otherwise>
															<span class="sghsc-order-rig-dd-1-bt-p-2"
																style="line-height:16px;">${i.goodsName}</span>
														</c:otherwise>
													</c:choose>


												</p>
												<p class="sghsc-order-rig-dd-1-bt-p-2">
													&lt;%&ndash; <span title="七天退换" ><img src="web/images/sghscorder/sghsc-order-zheng.png" ></span>
					    <span title="如实描述" ><img src="web/images/sghscorder/sghsc-order-7.png" ></span>
					    <span title="正品保证" ><img src="web/images/sghscorder/sghsc-order-bao.png" ></span> &ndash;%&gt;
													(${i.itemSku })
												</p>
											</div>
										</div></td>
									<td class="sghsc-order-rig-dd-1-td"><div
											class="sghsc-order-rig-dd-1-lb">￥${i.dealPrice}</div>
									</td>
									<td class="sghsc-order-rig-dd-1-td"><div
											class="sghsc-order-rig-dd-1-lb2">${i.nums}</div>
									</td>
									<!-- <td class="sghsc-order-rig-dd-1-td2"> -->
									<td class="sghsc-order-rig-dd-1-td">
										<div class="sghsc-order-rig-dd-1-lb">￥${o.totalCost}</div>
										<div>(含运费)</div></td>
									<!-- <td class="sghsc-order-rig-dd-1-td2"> -->
									<c:choose>
										<c:when
											test="${i.goods != null && i.goods != '' && i.goods.marketable != 'false' && i.goods.disabled != 'true' }">
											<td class="sghsc-order-rig-dd-1-td">
												<div class="sghsc-order-rig-dd-1-lb">
													<s:if test="#o.payStatus == 0">待付款</s:if>
													<s:if test="#o.payStatus == 1 && #o.shipStatus == 0">待发货</s:if>
													<s:if test="#o.payStatus == 1 && #o.shipStatus == 1">已发货</s:if>
													<s:if test="#o.payStatus == 1 && #o.shipStatus == 2">已完成</s:if>
													<s:if test="#o.payStatus ==3">已退款</s:if>
												</div>
												<div class="sghsc-order-rig-dd-1-lb">
													<s:if test="#st.index ==0">
														<!--已付款  -->
														<s:if test="#o.payStatus == 1">
															<!-- 已收货 -->
															<s:if test="#o.shipStatus ==2">
																<s:else>
																	<span>已评价</span>
																</s:else>
															</s:if>
															<!-- 未收货 -->
															<s:else>
																<s:if test="#i.appraise ==0">
																	<span>未评价</span>
																</s:if>
																<s:else>
																	<span>已评价</span>
																</s:else>
															</s:else>

														</s:if>
														<!-- 未付款 -->
														<s:else>
															<s:if test="#i.appraise ==0">
																<span>未评价</span>
															</s:if>
															<s:else>
																<span>已评价</span>
															</s:else>
														</s:else>
													</s:if>
													<s:else>
														<!--已付款  -->
														<s:if test="#o.payStatus ==1">
															<!-- 已收货 -->
															<s:if test="#o.shipStatus ==2">
																<s:else>
																	<span>已评价</span>
																</s:else>
															</s:if>
															<!-- 未收货 -->
															<s:else>
																<s:if test="#i.appraise ==0">
																	<span>未评价</span>
																</s:if>
																<s:else>
																	<span>已评价</span>
																</s:else>
															</s:else>
														</s:if>
														<!-- 未付款 -->
														<s:else>
															<s:if test="#i.appraise ==0">
																<span>未评价</span>
															</s:if>
															<s:else>
																<span>已评价</span>
															</s:else>
														</s:else>
													</s:else>
												</div>
												<div>
													<a href="toOrderDetail/${o.id}.html"
														class="sghsc-order-rig-dd-1-bta" target="_blank">订单详情</a>
												</div></td>
											<!-- <td class="sghsc-order-rig-dd-1-td3"> -->

											<td class="sghsc-order-rig-dd-1-td"><s:if
													test=" #o.payStatus == 1 && #o.shipStatus == 1">
													<div
														class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
														<a href="javascript:void(0)"
															class="sghsc-order-rig-dd-1-paya"
															onclick="memberPayOrder('${o.id}','${o.orderNum }','${o.payMent }')">
															<span class="sghsc-order-rig-dd-1-pay">确认收货</span> </a>
													</div>
												</s:if> <s:if test="#i.isLogistice == 1">
													<div
														class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
														<a href="logisticsDetail/${i.logisticsNum}.html"
															class="sghsc-order-rig-dd-1-paya" target="_blank"> <span
															class="sghsc-order-rig-dd-1-pay">查看物流</span> </a>
													</div>
												</s:if>

												<div class="sghsc-order-rig-dd-1-lb">
													<s:if test="#st.index ==0">
														<!--已付款  -->
														<s:if test="#o.payStatus == 1">
															<!-- 已收货 -->
															<s:if test="#i.isLogistice == 1">
																<s:if test="#i.appraise == 0">
																	<div
																		class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
																		<div
																			onclick="memberEvaluateOnclick('${i.orderId}','${i.goodsId}','${i.companyId}');"
																			class="sghsc-order-rig-dd-1-paya">
																			<span class="sghsc-order-rig-dd-1-pay">评价晒单</span>
																		</div>
																	</div>
																</s:if>
															</s:if>
															<!-- 未收货 -->
															<s:else>
															</s:else>

														</s:if>
														<!-- 未付款 -->
														<s:else>
															<s:if test="#i.appraise ==0">
															</s:if>
															<s:else>
															</s:else>
														</s:else>
													</s:if>
													<s:else>
														<!--已付款  -->
														<s:if test="#o.payStatus ==1">
															<!-- 已收货 -->
															<s:if test="#i.isLogistice == 2">
																<div
																	class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
																	<a href="logisticsDetail/${i.logisticsNum}.html"
																		class="sghsc-order-rig-dd-1-paya" target="_blank">
																		<span class="sghsc-order-rig-dd-1-pay">查看物流</span> </a>
																</div>
																<s:if test="#i.appraise ==0">
																	<div
																		class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
																		<a
																			onclick="memberEvaluateOnclick('${i.orderId}','${i.goodsId}','${i.companyId}');"
																			class="sghsc-order-rig-dd-1-paya" target="_blank">
																			<span class="sghsc-order-rig-dd-1-pay">评价晒单</span> </a>
																	</div>
																</s:if>
															</s:if>
															<!-- 未收货 -->
															<s:else>
																<s:if test="#i.appraise == 0">
																</s:if>
																<s:else>
																</s:else>
															</s:else>

														</s:if>
														<!-- 未付款 -->
														<s:else>
															<s:if test="#i.appraise == 0">
															</s:if>
															<s:else>
															</s:else>
														</s:else>
													</s:else>
													&lt;%&ndash; <s:if test="#st.index ==0">
				<li class="ddeight" style="height:32px; line-height:32px;">
					<span class="wtk ddsh">退货/退款</span>
				</li>
			</s:if> &ndash;%&gt;
													<s:if test="#o.payStatus == 0">
														<div
															class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
															<a href="payment!toPaymentType.action?orderId=${o.id}"
																class="sghsc-order-rig-dd-1-paya" target="_blank">
																<span class="sghsc-order-rig-dd-1-pay">支付订单</span> </a>
														</div>

														<div
															class="sghsc-order-rig-dd-1-lb sghsc-order-rig-dd-1-lb22">
															<a class="sghsc-order-rig-dd-1-paya"
																onclick="dropOrder('${o.id}')" href="javascript:void(0)">
																<span class="sghsc-order-rig-dd-1-pay">删除订单</span> </a>
														</div>
													</s:if>

												</div></td>
										</c:when>
										<c:otherwise>
											<td class="sghsc-order-rig-dd-1-td">
												<div class="sghsc-order-rig-dd-1-lb">商品下架</div>
											</td>
											<td class="sghsc-order-rig-dd-1-td">
												<div class="sghsc-order-rig-dd-1-lb">商品下架</div>
											</td>
										</c:otherwise>
									</c:choose>
								</tr>
							</tbody>
						</table>

					</s:iterator>

				</div>
			</s:iterator>

		</div>
	</div>

	<!--签收弹出框begin-->
	<div id="shxx" class="aqmmtc" style=" visibility:hidden">
		<form action="person/order/receiveGoods.html" id="receiveGoodsFrom"
			method="post">
			<div class="tcgb">
				<a onclick="stopsplbtitle('tanchu', 'shxx');"><img
					src="images/memberimg/gb.gif" /> </a>
			</div>
			<p style="margin-left:70px; margin-top:30px; margin-bottom:20px;">
				<img src="images/memberimg/tc01.gif" />
			</p>
			<ul>
				<li><label>安全密码：</label>
				</li>
				<li>
					<!-- 					<input type="password" name="payPassword" id="payPassword" value="" />  -->
					<input type="hidden" name="order.id" id="payOrderId" value="" /> <input
					type="hidden" name="order.orderNum" id="payOrderOrderNum" value="" />
					<input type="hidden" name="order.payMent" id="payMent" value="" />
				</li>
				<li><button type="button" class="tcqr" style="border: none;"
						id="receiptGoods">收货</button>
				</li>
			</ul>
		</form>
	</div>
	<!--签收弹出框END-->
	<!--退货/退款弹出框begin-->
	<div id="thtk" class="aqmmtc aqmmtc_2" style=" visibility:hidden">
		<form action="person/order/returnOrder.html"
			id="memberReturnGoodsForm" method="post">
			<div class="tcgb" style="top:9px; right:15px;">
				<a onclick="stopsplbtitle('tanchu', 'thtk');"><img
					src="images/memberimg/gb.gif" /> </a>
			</div>
			<p class="thxqd">退货详情单</p>
			<p
				style="margin-left:50px; margin-top:15px; margin-right:50px;  background:#FFFFdd">
				<label class="laleft">单号： <input type="hidden"
					name="orderReturn.isdelivery" id="returnGoods_isdelivery" /> <input
					type="hidden" name="orderReturn.orderId" id="returnGoods_orderId" />
					<input type="hidden" id="returnGoods_orderTotal" /> </label><span
					id="returnGoods_orderIdSpan"></span>
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">退款金额：</label><input type="text"
					id="orderReturn_returnMoney" name="orderReturn.returnMoney"
					value="" onkeyup="clearNoNum(this)" />
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">物流单号：</label><input type="text"
					id="orderReturn_logisticsNum" name="orderReturn.logisticsNum"
					value="" />
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">物流公司：</label><input type="text"
					id="orderReturn_logisticsName" name="orderReturn.logisticsName"
					value="" />
			</p>
			<p style="margin-left:50px; margin-top:10px; margin-bottom:15px;">
				<label class="laleft">物流电话：</label><input type="text"
					id="orderReturn_logisticsTel" name="orderReturn.logisticsTel"
					value="" />
			</p>
			<p style="margin-left:50px; height:100px; margin-bottom:20px;">
				<label class="laleft" style=" float:left;">退货/退款原因：</label>
				<textarea id="orderReturn_cause" name="orderReturn.cause"
					class="textyy"></textarea>
			</p>
			<p style="margin-left:200px; margin-top:20px; clear: both">
				<a class="tcqr" onclick="returnGoodsSubmit();">确认提交</a>
			</p>
		</form>
	</div>
	<!--退货/退款弹出框end-->
	<div id="tctk" class="aqmmtc" style=" visibility:hidden">
		<div class="tcgb">
			<a onclick="stopsplbtitle('tanchu', 'tctk');"><img
				src="images/memberimg/gb.gif" /> </a>
		</div>
		<p
			style="margin-left:40px; padding-left:40px; line-height:30px; font-size:20px;color:#666666; font-weight:bold; width:470px; margin-top:30px; margin-bottom:10px; background:url(images/memberimg/aqxq02.gif) no-repeat left top;">
			您的退货/退款申请已提交至商家，待商家收到要退的货物后，您的货款预计在<span style="color:#f77e00">三个工作日内</span>返还！
		</p>
		<p style="margin-left:230px">
			<a class="tcqr">已阅关闭</a>
		</p>
	</div>
	<!--评价弹出框begin-->
	<div id="pjnr" class="tcpj" style="visibility: hidden;">
		<form action="person/order/evaluateGoods.html" id="memberEvaluateFrom"
			method="post">
			<h2>
				<span>评价内容</span><a onclick="stopsplbtitle('tanchu', 'pjnr');">【关闭】</a>
			</h2>
			<p class="pjcontent">
				<input type="hidden" name="appraise.orderId"
					id="member_evaluate_orderId" /> <input type="hidden"
					name="appraise.goodsId" id="member_evaluate_goodsId" /> <input
					type="hidden" name="appraise.companyId"
					id="member_evaluate_companyId" />
				<textarea id="member_evaluate_appraise" name="appraise.content"
					cols="" rows=""
					onBlur="if(this.innerHTML==''){this.innerHTML='请在此处填写你对商品的评价……';this.style.color='#D1D1D1'}"
					style="COLOR: #d1d1d1"
					onFocus="if(this.innerHTML=='请在此处填写你对商品的评价……'){this.innerHTML='';this.style.color='#000'}">请在此处填写你对商品的评价……</textarea>
			</p>
			<div class="tcmjpj">
				<h2>卖家评级</h2>
				<p style="color:#b0080e">
					<span>服务评级<input type="hidden" id="member_evaluate_serve"
						name="appraise.serve" /> </span> <span><a
						onclick="memberEvaluate('serve','-1');"><img id="serve1"
							src="images/memberimg/pjdj2.gif" /> </a> </span> <span><a
						onclick="memberEvaluate('serve','0');"><img id="serve2"
							src="images/memberimg/pjdj2.gif" /> </a> </span> <span><a
						onclick="memberEvaluate('serve','1');"><img id="serve3"
							src="images/memberimg/pjdj2.gif" /> </a> </span> <span id="serveType"></span>
				</p>
				<p style="color:#00589d">
					<span>质量评级<input type="hidden" id="member_evaluate_quality"
						name="appraise.quality" /> </span> <span><a
						onclick="memberEvaluate('quality','-1');"><img id="quality1"
							src="images/memberimg/pjdj2.gif" /> </a> </span> <span><a
						onclick="memberEvaluate('quality','0');"><img id="quality2"
							src="images/memberimg/pjdj2.gif" /> </a> </span> <span><a
						onclick="memberEvaluate('quality','1');"><img id="quality3"
							src="images/memberimg/pjdj2.gif" /> </a> </span> <span id="qualityType"></span>
				</p>
				<p style="color:#e45e00">
					<span>信誉评级<input type="hidden" id="member_evaluate_credit"
						name="appraise.credit" /> </span> <span><a
						onclick="memberEvaluate('credit','-1');"><img id="credit1"
							src="images/memberimg/pjdj2.gif" /> </a> </span> <span><a
						onclick="memberEvaluate('credit','0');"><img id="credit2"
							src="images/memberimg/pjdj2.gif" /> </a> </span> <span><a
						onclick="memberEvaluate('credit','1');"><img id="credit3"
							src="images/memberimg/pjdj2.gif" /> </a> </span> <span id="creditType"></span>

				</p>
				<p style="color:#72a023">
					<span>物流评级<input type="hidden"
						id="member_evaluate_logistics" name="appraise.logistics" /> </span> <span><a
						onclick="memberEvaluate('logistics','-1');"><img
							id="logistics1" src="images/memberimg/pjdj2.gif" /> </a> </span> <span><a
						onclick="memberEvaluate('logistics','0');"><img
							id="logistics2" src="images/memberimg/pjdj2.gif" /> </a> </span> <span><a
						onclick="memberEvaluate('logistics','1');"><img
							id="logistics3" src="images/memberimg/pjdj2.gif" /> </a> </span> <span
						id="logisticsType"></span>
				</p>
			</div>
			<div
				style="margin-left:15px; margin-bottom:20px; margin-top:10px; position:relative">
				<a onclick="memberEvaluateSubmit();" class="tcqr"
					style="color: #333333">保存评价</a>
			</div>
		</form>
	</div>
	<!--评价弹出框结束-->

	<div class="clear"></div>
	<jsp:include page="/admin/common/indexFooter.jsp" />
	<!--更多搜索条件-->
	<script type="text/javascript">
		window.onload = function() {
			var pStatus = $
			{
				payStatus
			}
			;
			var sStatus = $
			{
				shipStatus
			}
			;

			if (-1 == pStatus && -1 == sStatus) {
				$(".sghsc-order-rig-qh-1 a:eq(0)").css("color", "red");
				$(".sghsc-order-rig-qh-1 a:eq(1)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(2)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(3)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(4)").css("color", "");
			}
			if (0 == pStatus && 0 == sStatus) {
				$(".sghsc-order-rig-qh-1 a:eq(1)").css("color", "red");
				$(".sghsc-order-rig-qh-1 a:eq(0)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(2)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(3)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(4)").css("color", "");
			}
			if (1 == pStatus && 0 == sStatus) {
				$(".sghsc-order-rig-qh-1 a:eq(2)").css("color", "red");
				$(".sghsc-order-rig-qh-1 a:eq(0)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(1)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(3)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(4)").css("color", "");
			}
			if (1 == pStatus && 1 == sStatus) {
				$(".sghsc-order-rig-qh-1 a:eq(3)").css("color", "red");
				$(".sghsc-order-rig-qh-1 a:eq(0)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(1)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(2)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(4)").css("color", "");
			}
			if (-1 == pStatus && 2 == sStatus) {
				$(".sghsc-order-rig-qh-1 a:eq(4)").css("color", "red");
				$(".sghsc-order-rig-qh-1 a:eq(0)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(1)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(2)").css("color", "");
				$(".sghsc-order-rig-qh-1 a:eq(3)").css("color", "");
			}

			var ssbox_3 = document.getElementById("ssbox3");
			/*var ssbox_4 = document.getElementById("ssbox4")
					.getElementsByTagName("span")[0];
			ssbox_4.onclick = function() {
				ssbox_3.className = (ssbox_3.className == "sghsc-order-rig-cj") ? "sghsc-order-rig-cj-bok"
						: "sghsc-order-rig-cj";
				ssbox_4.className = (ssbox_4.className == "sghsc-order-rig-qh-7") ? "sghsc-order-rig-qh-7-bok"
						: "sghsc-order-rig-qh-7";
			};*/
		}
	</script>

</body>
</html>