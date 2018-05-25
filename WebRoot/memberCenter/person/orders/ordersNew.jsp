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
<%--<html lang="en">--%>
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
<%--<link rel="stylesheet" href="css/page.css" type="text/css" />--%>

<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/layer/layer.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript src="js/tanchu.js"></script>
<script type=text/javascript src="js/register.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>

<!-- 日历控件 -->
<script type="text/javascript" src="web/js/jquery.date_input.pack.js"></script>

<script type="text/javascript">
	function changeStatus(orderId,status,disabled) {
        $.ajax({
            url : 'orderAction!changeOrderStatus.action',
            type : 'POST',
            data : {orderId:orderId,status:status,disabled:disabled},
            success : function(data) {
                var r = $.parseJSON(data);
                if (r == 'ok') {
                    window.location.href = "person/order/myOrders.html";
                } else {
                    alert('<s:text name="index_0316"/>！');
                    return false;
                }
            }
        });
	}

    function queren(orderId,orderNum) {
        $('#yuyuenr1').show();
        $("#spanShouhuo").html(orderNum);
        $("#orderId").val(orderId);
	}

    function tuikuan(orderId) {
        $('#yuyuenr2').show();
        $("#orderId").val(orderId);
    }

    function quxiao(){
        $("#orderId").val("");
        $("#textarea").val("");
        $('#yuyuenr1').hide();
        $('#yuyuenr2').hide();
    }

    function action(){
        var orderId = $("#orderId").val();
        var textarea = $("#textarea").val();
        if(textarea == null || textarea == ''){
            alert("请输入原因！");
            return false;
		}
        $.ajax({
            url : 'orderAction!returnGoods.action',
            type : 'POST',
            data : $("#tuiForm").serialize(),
            success : function() {
                $("#textarea").val("");
                window.location.href = "person/order/myOrders.html";
        	}
        });
        $('#yuyuenr2').hide();
    }

    /* 确认收货 */
    function qurenOrder(){
        var orderId = $("#orderId").val();
        //alert(orderId);
        $.ajax({
            url : 'orderAction!receiveGoods.action',
            type : 'POST',
            data : {
                orderId:orderId
			},
            success : function() {
                window.location.href = "person/order/myOrders.html";
            }
        });
        $('#yuyuenr1').hide();
	}

</script>
	<style type="text/css">
		/*退货css*/
		.dialog1 {width: 100%;height: 100%;top: 0;left: 0;position: absolute;display: none;-webkit-align-items: center;align-items: center;-webkit-justify-content: center;justify-content: center;}
		.dialog-overlay1 {width: 100%;height: 100%;top: 0;left: 0;position: fixed;z-index: 9;background: rgba(55, 58, 71, 0.9);display: block;-webkit-transition: opacity 0.3s;transition: opacity 0.3s;
			-webkit-backface-visibility: hidden;}
		.dialog-content1 {width: 600px; padding: 20px;border-radius: 5px;background: #fff;text-align: center;position: fixed;top: 36%;left: 50%;
			margin-left: -300px;z-index: 13;display: block;}
		.dialog-content2 {width: 600px; padding: 20px;border-radius: 5px;background: #fff;text-align: center;position: fixed;top: 26%;left: 50%;
			margin-left: -300px;z-index: 13;display: block;}

		.dialog-content1 h2 { height:45px; border-bottom:#acacac 1px dashed;line-height: 45px;}
		.dialog-content1 h2 p{ display: block; float: left; font-size: 20px;}
		.dialog-content1 h2 span{display: block; float: right; color: #999; cursor: pointer; font-size: 14px; font-weight: normal;}

		.dialog-content2 h2 { height:45px; border-bottom:#acacac 1px dashed;line-height: 45px;}
		.dialog-content2 h2 p{ display: block; float: left; font-size: 20px;}

		#dialog-content1-nr{ padding: 20px; line-height: 30px; }
		#dialog-content1-nr p{font-size: 14px;}
		#dialog-content1-nr p strong{ display: block; font-size: 20px; margin: 5px 0;}
		#dialog-content1-nr p span{ color: #e7250f;}
		#dialog-content1-nr .bt {width: 84%;margin: 30px auto 0 auto;  font-size: 14px; height: 40px;line-height: 40px;border-radius: 5px;background:#222222;color: #fff;}
		.inputnr {padding: 3% 2%;}
		.inputnr form{width: 100%;}
		.inputnr .k1 {width: 96%; color: #999;margin: 0 auto 2% auto;border: #E1E1E1 1px solid;height: 150px;line-height: 28px;border-radius: 5px;padding:2%; font-size: 14px;}
		.inputnr .bt {width: 84%;margin: 0 auto 2% auto;border: #f44c01 1px solid;height: 2rem;line-height: 2rem;border-radius: 5px;background: #f44c01;color: #fff;}
		.inputnr span{width: 90px;height: 90px;font-size: 12px;color: #999;position: relative;display: block;text-align: center;vertical-align: top;
			margin-bottom: 10px;cursor: pointer;
			border: 1px dotted #999;}
		.inputnr .k2 {    left: 0;top: 0;width: 100%;z-index: 2;opacity: 0;cursor: pointer;}

		#tijiao{ margin-top: 20px; text-align: center;}
		#tijiao a{ display: inline-block; padding:10px 40px; background: #000000; color: #fff; margin: 0 15px; border-radius: 5px;}
		#tijiao a.hui{ background: #E0E0E0; color: #333;}
	</style>
</head>
<body>
<div id="pageReload">
	<div id="tanchu"></div>
	<!-- 头部开始 -->
	<!--======================top开始============================-->
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	<s:action name="common!toPersionLogo" executeResult="true" namespace="/"></s:action>
	<!--======================导航开始============================-->
	<%--<jsp:include page="/admin/common/navigation.jsp" />--%>
	<!-- 头部结束 -->
	<%--<div class="breadThumb">首页 > 会员中心 > 电子商城 > 订单管理 > 我的订单</div>--%>
	<!--退货弹框1-->
	<div id="yuyuenr1" class="dialog1">
		<div class="dialog-overlay1"></div>

		<div class="dialog-content1">
			<h2><p><s:text name="index_0384"/></p><span class="close1 action" onclick="quxiao()"><s:text name="index_0385"/></span></h2>
			<div id="dialog-content1-nr">
				<p><s:text name="index_0386"/>？</p>
				<p><strong>订单号：<span id="spanShouhuo"></span></strong></p>
				<p>注意：如果您尚未收到货品请不要点击“确认”。大部分被骗案件都是由于提前确认付款被骗的，请谨慎操作。</p>
				<input type="button" id="action" name="" onclick="qurenOrder()" class="bt" value="确认" />
			</div>

		</div>
	</div>
	<!--退货弹框2-->
	<div id="yuyuenr2" class="dialog1">
		<div class="dialog-overlay1"></div>

		<div class="dialog-content2">
			<h2><p>退货退款申请</p></h2>
			<div class="inputnr">
				<form id="tuiForm">
					<input type="hidden" id="orderId" name="orderId" />
					<textarea cols="200" rows="5" id="textarea" name="textarea" onfocus="if(value=='请填写退货退款原因'){value=''}"  onblur="if (value ==''){value='请填写退货退款原因'}" class="k1">请填写退货退款原因</textarea>

				<!--<input type="file" name="" value="上团图片" size="40" class="filenr" aria-invalid="false" ></span>-->
				<span style="">
                    <input name="photoUploader" accept="image/*" type="file" data-maxsize="5120" data-reactid="" data-spm-anchor-id="" class="k2">
					<div data-reactid="">上传图片</div>
					<div data-reactid="">(最多3张)</div>
				</span>
				<div id="tijiao">
					<a href="javascript:void(0);" onclick="action()">提交</a><a href="javascript:void(0);" class="hui" onclick="quxiao()">取消</a>
				</div>
				</form>
			</div>
		</div>
	</div>
	<div class="sghsc-order-main">
		<!-- 左侧功能菜单开始 -->
		<div class="main">
		<div class="h_content">
		<c:choose>
			<c:when test="${sessionInfo.userType=='company'}">
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
					<form id="pagerForm" name="pagerForm" action="${sessionInfo.toUrl}" method="post">
						<input type="hidden" name="order.memberId" id="memberId" value="${order.memberId}"/>
						<input type="hidden" name="order.status" id="statu" value="${order.status}"/>
						<input type="hidden" name="order.qixian" id="qx" value="${order.qixian}"/>
					</form>
					<form id="addForm" action="person/order/myOrders.html" method="post" target="_parent">
					<div class="vip_b3">
						<div class="vip_a15">订单号 <input id="orderNum" name="orderNum" type="text" class="q1"></div>
						<div class="vip_a15">商品名 <input id="goodsName" name="goodsName" type="text" class="q1"></div>
						<div class="vip_a15">收货人 <input id="shipName" name="shipName" type="text" class="q1"></div>
					</div>
					<div class="vip_b3">
						<div class="vip_a15">订单状态
							<select name="status" id="status" class="lbcd2">
								<option value="">所有订单</option>
								<option value="1">待付款</option>
								<option value="2">待发货</option>
								<option value="3">待收货</option>
								<option value="4">已完成</option>
								<option value="5">待评价</option>
								<option value="6">取消订单</option>
								<option value="7">退款退货中</option>
							</select>
						</div>
						<div class="vip_a15">订单期限
							<select name="qixian" id="qixian" class="lbcd2">
								<option value="-1">全部</option>
								<option value="0">最近一周</option>
								<option value="1">最近一个月</option>
								<option value="2">最近三个月</option>
							</select>
						</div>
						<div class="vip_a15">
							<input name="input" class="vip_a14"  style="cursor: pointer;" onclick="submit()" type="button" value="查询">
						</div>
					</div>
					</form>
					<div class="slideTxtBox">
						<div class="bd" style="margin-bottom: 15px;">
							<ul>
								<div class="w-bond" style="padding: 20px 0 0;">
									<div class="w-bond-title">
										<p class="w-title-name" style="width: 200px">订单信息</p>
										<p class="w-title-time" style="width: 100px">收货人</p>
										<p class="w-title-time" style="width: 140px">订单金额</p>
										<p class="w-title-time">订单时间</p>
										<p class="w-title-mony">订单状态</p>
										<p class="w-title-mony">操作</p>
									</div>
								</div>
							</ul>
							<c:if test="${empty orderList}">
								<div style="text-align: center;"><img src="images/wujilu.jpg"/></div>
							</c:if>
							<c:if test="${not empty orderList}">

							<c:forEach items="${orderList}" var="order">
								<div class="w-bond-list3">
									<div class="w-bond-tit3">
										<div class="w-bond-num fl">[订单编号：${order.orderNum}]</div>
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
											<div class="w-bond-043">待付款</div>
											<div class="w-bond-053">
												<a href="person/order/toOrderDetail/${order.id}.html">查看订单</a>
												<a href="javascript:void(0)" onclick="changeStatus('${order.id}','6','${order.disabled}')">取消订单</a>
											</div>
										</c:if>
										<c:if test="${order.status=='6'}">
											<div class="w-bond-043">已取消</div>
											<div class="w-bond-053">
												<a href="person/order/toOrderDetail/${order.id}.html">查看订单</a>
												<a href="javascript:void(0)" onclick="changeStatus('${order.id}','${order.status}','true')">删除</a>
											</div>
										</c:if>
										<c:if test="${order.status=='2'&&order.payStatus=='1'&&order.shipStatus=='0'}">
											<div class="w-bond-043">待发货</div>
											<div class="w-bond-053">
												<a href="person/order/toOrderDetail/${order.id}.html">查看订单</a>
												<a href="javascript:void(0)" onclick="tuikuan('${order.id}')">申请退款</a>
											</div>
										</c:if>
										<c:if test="${order.status=='7'}">
											<div class="w-bond-043">退款退货中</div>
											<div class="w-bond-053">
												<a href="person/order/toOrderDetail/${order.id}.html">查看订单</a>
											</div>
										</c:if>
										<c:if test="${order.status=='3'&&order.payStatus=='1'&&order.shipStatus=='1'}">
											<div class="w-bond-043">待收货 <br/>
												<a>物流跟踪</a>
											</div>
											<div class="w-bond-053">
												<a href="person/order/toOrderDetail/${order.id}.html">查看订单</a>
												<a href="javascript:void(0)" onclick="queren('${order.id}','${order.orderNum}')">确认订单</a>
												<a href="javascript:void(0)" onclick="tuikuan('${order.id}')">申请退货</a>
											</div>
										</c:if>
										<c:if test="${order.status=='5'&&order.payStatus=='1'&&order.shipStatus=='2'}">
											<div class="w-bond-043">待评价</div>
											<div class="w-bond-053">
												<a href="person/order/toOrderDetail/${order.id}.html">查看订单</a>
												<a href="javascript:void(0)" onclick="queren('${order.id}')">确认订单</a>
												<%--<button type="button" class="btn-danger03">评价</button>--%>
											</div>
										</c:if>
										<c:if test="${order.status=='4'&&order.payStatus=='1'&&order.shipStatus=='2'}">
											<div class="w-bond-043">已完成</div>
											<div class="w-bond-053">
												<a href="person/order/toOrderDetail/${order.id}.html">查看订单</a>
											</div>
										</c:if>
										<div class="clear"></div>
									</div>
								</div>
							</c:forEach>
							</c:if>
				</div>
			</div>
	</div>
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
</div>
</div>
	<div class="clear"></div>
	<div id="pageReload">
		<page:pagination path="person/order/myOrders.html" formName="pagerForm"/>
	</div>
</div>
<!--footer开始-->
<s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
<!--footer结束-->
</body>
</html>