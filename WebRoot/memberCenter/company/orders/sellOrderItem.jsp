<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<link href="css/hyzxdp.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/tanchu.js"></script>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript>
	function bjPrice(bjvalue, itemid, orderid) {
		$("#" + bjvalue).attr("disabled", false);
		var html = '';
		html = '<a href="javascript:void(0)"  style="color:#c00f17;" onclick="bcPrice(\''
				+ bjvalue
				+ '\',\''
				+ itemid
				+ '\',\''
				+ orderid
				+ '\');">确认</a>';
		$("#bjbc" + bjvalue).html(html);
	}
	function bjCarriage(orderId) {
		$("#orderCarriage").attr("disabled", false);
		var html = '';
		html = '<a href="javascript:void(0)"  style="color:#c00f17;" onclick="bcCarPrice(\''
				+ orderId
				+ '\');">确认</a>';
		$("#bcCarriage").html(html);
	}
	function bcCarPrice(orderId) {
		var bcvalue = $("#orderCarriage").val();
		var reg = /^-?\d+\.?\d{0,2}$/;
		if (!reg.test(bcvalue)) {
			$("#orderCarriage").focus();
			alert("修改的物流费用只可输入两位小数的数字！");
			return false;
		} else {
			$("#orderCarriage").attr("disabled", true);
			$.ajax({
				url : 'person/order/sellOrderItemModifyCarr.html',
				type : 'post',
				data : 'bcvalue=' + bcvalue + '&id=' + orderId,
				success : function(data) {
					var r = $.parseJSON(data);
					if (r == 'no') {
						alert('修改失败！');
					} else if (r == 'ok') {
						alert('修改成功！');
					} else if (r == 'error') {
						alert('折扣金额不能大于交易总金额！');
					}
					window.location.href = "person/order/sellOrderItem/"
							+ orderId + ".html";

				}
			});
		}

	}
	
	function bcPrice(bjvalue, itemid, orderid) {
		var bcvalue = $("#" + bjvalue).val();
		var reg = /^-?\d+\.?\d{0,2}$/;
		if (!reg.test(bcvalue)) {
			$("#" + bjvalue).focus();
			alert("修改的单价只可输入两位小数的数字！");
			return false;
		} else {
			$("#" + bjvalue).attr("disabled", true);
			$.ajax({
				url : 'person/order/sellOrderItemModifyPrice.html',
				type : 'post',
				data : 'bcvalue=' + bcvalue + '&orderItemId=' + itemid,
				success : function(data) {
					var r = $.parseJSON(data);
					if (r == 'no') {
						alert('修改失败！');
					} else if (r == 'ok') {
						alert('修改成功！');
					} else if (r == 'error') {
						alert('折扣金额不能大于交易总金额！');
					}
					window.location.href = "person/order/sellOrderItem/"
							+ orderid + ".html";

				}
			});
		}

	}
	
	// 修改物流单号
	function bjLogisticsNum(orderId) {
		$("#orderLogisticsNum").attr("disabled", false);
		var html = '';
		html = '<a href="javascript:void(0)"  style="color:#c00f17;" onclick="bcLogisticsNum(\''
				+ orderId
				+ '\');">确认</a>';
		$("#bcLogisticsNum").html(html);
	}
	
	function bcLogisticsNum(orderId) {
	   var logisticsNum = $("#orderLogisticsNum").val();
		$("#orderLogisticsNum").attr("disabled", true);
			$.ajax({
				url : 'person/order/updateLogisticsNum.html',
				type : 'post',
				data : 'logisticsNum=' + logisticsNum + '&id=' + orderId,
				success : function(data) {
					var r = $.parseJSON(data);
					if (r == 'no') {
						alert('修改失败！');
					} else if (r == 'ok') {
						alert('修改成功！');
					}
					window.location.href = "person/order/sellOrderItem/" + orderId + ".html";

				}
			});
	}
	
	// 修改物流公司
	function bjLogisticsName(orderId) {
		$("#orderLogisticsName").attr("disabled", false);
		var html = '';
		html = '<a href="javascript:void(0)"  style="color:#c00f17;" onclick="bcLogisticsName(\''
				+ orderId
				+ '\');">确认</a>';
		$("#bcLogisticsName").html(html);
	}
	
	function bcLogisticsName(orderId) {
	   var logisticsName = $("#orderLogisticsName").val();
		$("#orderLogisticsName").attr("disabled", true);
			$.ajax({
				url : 'person/order/updateLogisticsName.html',
				type : 'post',
				data : 'logisticsName=' + logisticsName + '&id=' + orderId,
				success : function(data) {
					var r = $.parseJSON(data);
					if (r == 'no') {
						alert('修改失败！');
					} else if (r == 'ok') {
						alert('修改成功！');
					}
					window.location.href = "person/order/sellOrderItem/" + orderId + ".html";
				}
			});
	}
	
	
	
	
</script>
<div id="tanchu"></div>
</head>
<body>
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	<jsp:include page="/admin/common/navigation.jsp" />
	<!-- 头部结束 -->
	<!-- 页脚开始 -->
	<div class="breadThumb">首页 > 企业会员中心 > 电子商城 > 订单管理 > 订单详情</div>
	<div class="gzgz">
		<div class="hyleft">
			<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
		</div>
		<div class="shop">
			<div class="splb">
				<h2>商品列表222</h2>
				<ul>
					<li class="mc">商品名称</li>
					<li>商品货号</li>
					<li>成交单价</li>
					<li style="width:150px; ">规格</li>
					<li>购买数量</li>
					<li>金额小计</li>
					<li>是否发货</li>
				</ul>
				<div style="clear:both"></div>
				<s:iterator var="item" value="orderItems" status="status">
					<div class="cplb">
						<div class="cc cplbname">
							<div class="p-img">
								<a target="_blank" href="goods/${item.goodsId}.html"><img
									alt="${item.goodsName}" src="${item.goodsPic}" width="40"
									height="40" /> </a>
							</div>
							<div class="p-name">
								<a target="_blank" href="goods/${item.goodsId}.html">
									${fn:substring(item.goodsName , 0, 15)} </a>
							</div>
						</div>
						<div class="cc cplbname" style="width: 116px">
							<span class="price">${item.bn}</span>
						</div>
						<div class="cc cplbprice">
							<span class="price">￥${item.dealPrice}</span>
						</div>
						<div class="cc cplbprice" style="width:150px; ">
							<span class="price">${item.itemSku}'</span>
						</div>
						<div class="cc cplbprice">
							<span class="price" id='itemNums${status.index+1}'>${item.nums}</span>
						</div>

						<div class="cc cplbprice">
							<span class="price" style="color:#c00f17" id='itemAcount${status.index+1}'>￥${item.amount}</span>
						</div>
						<div class="cc cplbprice">
							<s:if test="%{#item.isLogistice == 1}">
								<a onclick="deliverShip('${order.id}','${order.shipName}','${order.shipTel}','${order.pname}${order.cname}${order.aname}${order.address}','${item.id}','${item.logisticsNum}','${item.logisticsName}','${item.logisticsTel}');"> 已发货</a>
								<a target="_blank" href="logisticsDetail/${item.logisticsNum}.html">查看物流</a>
							</s:if>
								
							<s:else>
								<s:if test="order.payStatus ==3">未发货</s:if>
								<s:elseif test="%{#item.isLogistice == null || #item.isLogistice != 1}">
									<a  style="color: red;" onclick="deliverShip('${order.id}','${order.shipName}','${order.shipTel}','${order.pname}${order.cname}${order.aname}${order.address}','${item.id}','','','');">未发货</a>
								</s:elseif>
							</s:else>
						</div>
						<div style="clear:both"></div>
					</div>
				</s:iterator>
				<div class="zj" style="height:30px;line-height:30px;">
					<span class="zjje">商品总金额：<strong style="color:#c00f17" id="orderCostProtect">￥${order.costProtect}</strong> </span>
				</div>
				<div class="zj" style="height:30px;line-height:30px;">
					<span class="zjje">物流总金额： <input id='orderCarriage' style='text-align:center; width:60px;margin-top:0px;height:25px;padding:0px;line-height:25px;'
						disabled='disabled' value='${order.carriage}'></input> 						
					</span>
						<!-- 未付款的才可以，商家才可以修改运费 -->
						<s:if test="order.payStatus == 0">
						 <span class="price" id="bcCarriage"><a href="javascript:void(0)"
						onclick="bjCarriage('${order.id}')">修改物流费用</a> 
						</span>
						</s:if>
				</div>
				<div class="zj" style="height:30px;line-height:30px;">
					<span class="zjje">订单总金额：<strong style="color:#c00f17"
						id="orderTotal">￥${order.totalCost}</strong> </span>
				</div>
			</div>
			<div class="splb splbtwo">
				<h2>买方留言</h2>
				${order.remark}

			</div>
			<div class="splb splbtwo">
				<h2>基本信息</h2>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">订单号</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price">${order.orderNum}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">订单状态</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price"> <s:if test="order.payStatus ==0">未付款</s:if>
							<s:elseif test="order.payStatus ==1">已付款</s:elseif> <s:elseif
								test="order.payStatus ==2">
								<s:if test="order.shipStatus==0 || order.shipStatus ==4">
									<a onclick="OpenReturnPay('${order.id}');" style="color: red;">待退款</a>
								</s:if>
								<s:else>待退款</s:else>
							</s:elseif> 
							<s:elseif test="order.payStatus ==3">已退款</s:elseif> 
							<s:elseif test="order.payStatus ==4">已拒绝退款</s:elseif> 
						</span> 
						<span class="price">
							<s:if test="order.payStatus ==2 || order.payStatus ==3 || order.payStatus ==4|| order.payStatus ==5">
								<a onclick="OpenReturnYuanyin('${order.id}');" style="color: red;">退货原因</a>
							</s:if> 
							</span> 
							<span class="price"> 
							<s:if test="order.shipStatus ==0">未发货</s:if> 
							<s:elseif test="order.shipStatus ==1">已发货</s:elseif> 
							<s:elseif test="order.shipStatus ==2">已收货</s:elseif> 
							<s:elseif test="order.shipStatus ==3">
								<a onclick="OpenReturnShip('${order.id}');" style="color: red;">待退货</a>
							</s:elseif> 
							<s:elseif test="order.shipStatus ==4">已退货</s:elseif> 
						</span>
					</div>
					<div style="clear:both"></div>
				</div>
				
				<div class="cplb" style="display: none;">
					<div class="cc name" style="float:left;">
						<span class="price">买方账号</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span>0531-86541222</span><span>15865418888</span>
					</div>
					<div style="clear:both"></div>
				</div>
				
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">下单时间</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price"><s:date name="order.createtime" format="yyyy-MM-dd HH:mm:ss" /> </span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">支付方式</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price"><s:if test="order.payMent == 0">现金支付</s:if>
							<s:elseif test="order.payMent == 1">金米支付</s:elseif> <s:elseif
								test="order.payMent == 2">经验值支付</s:elseif> <s:elseif
								test="order.payMent == 3">惠米支付</s:elseif><s:elseif
								test="order.payMent == 4">汇豆支付</s:elseif><s:elseif
								test="order.payMent == 5">汇宝支付</s:elseif><s:elseif
								test="order.payMent == 6">汇积分支付</s:elseif><s:elseif
								test="order.payMent == 7">汇豆+汇宝支付</s:elseif><s:else>
								未支付	
								</s:else> </span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">付款时间</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price">
							<s:if test="order.payTime != null">
								<s:date name="order.payTime" format="yyyy-MM-dd HH:mm:ss" />
							</s:if> 
							<s:else>未付款</s:else> </span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">配送方式</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price"> <c:choose>
								<c:when test="${order.isDelivery=='N' }">物流</c:when>
								<c:when test="${order.isDelivery=='Y' }">上门自提</c:when>
								<c:otherwise>
								--
							</c:otherwise>
							</c:choose> </span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">发货时间</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price"><s:if test="order.shipTime != null">
								<s:date name="order.shipTime" format="yyyy-MM-dd HH:mm:ss" />
							</s:if> <s:else>未发货</s:else> </span>
					</div>
					<div style="clear:both"></div>
				</div>
				<!-- 
				<div class="cplb">
				   	<div class="cc name" style="float:left;"><span class="price"  style="float:left;">物流单号  </span></div>				   	
						<div class="cc lb" style="float:left;width:785px;">
						<input id='orderLogisticsNum' style='text-align:center; width:150px;height:25px;margin-left:30px;margin-top:-5px;' disabled='disabled' value='${order.logisticsNum }'></input>
						 <!-- 商家修改物流单号
						<s:if test="order.logisticsNum != null ">
						 <span class="price" id="bcLogisticsNum"><a href="javascript:void(0)" onclick="bjLogisticsNum('${order.id}')">修改物流单号</a></span>
						</s:if>
						</div>
				</div>
				
				<div class="cplb">
					<div class="cc larst name" style="float:left;"><span class="price">物流公司名称</span></div>			
					<div class="cc larst lb"  style="float:left;width:785px;">
					  <input id='orderLogisticsName' style='text-align:center; width:150px;height:25px;margin-left:30px;margin-top:-5px;' disabled='disabled' value='${order.logisticsName }'></input>
				     <!-- 商家修改物流公司
						<s:if test="order.logisticsName != null ">
						 <span class="price" id="bcLogisticsName"><a href="javascript:void(0)" onclick="bjLogisticsName('${order.id}')">修改物流公司名称</a> </span>
						</s:if>
					</div>					
					<div style="clear:both"></div>
				</div>
				
				 -->
				
			</div>
			<!--买方信息开始-->
			<div class="splb splbtwo">
				<h2>买方信息</h2>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">收货人姓名</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price">${order.shipName}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">详细地址</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price">${order.pname}${order.cname}${order.aname}${order.address}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">联系电话</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<s:if test="order.order.shipTel != null"></s:if>
						<span>${order.shipTel}</span>
					</div>
					<div style="clear:both"></div>
				</div>
			</div>
			<div class="splb splbtwo">
				<h2>其他信息</h2>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">发票类型</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price">${order.billType}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">发票抬头</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span class="price">${order.billHead}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name" style="float:left;">
						<span class="price">发票内容</span>
					</div>
					<div class="cc lb" style="float:left;width:785px;">
						<span>${order.billContent}</span>
					</div>
					<div style="clear:both"></div>
				</div>

			</div>
		</div>
		<div style="clear:both"></div>
	</div>
	<!-- <div class="bottom_box_06">
		<div class="bottom_box_06img">
			<img src="web/images/zixun/tonglan.png" width="1190" height="118" />
		</div>
	</div> -->
	<!--======================bottom开始============================-->
	<jsp:include page="/admin/common/indexFooter.jsp" />
	<!-- footer end -->
	<!-- 页脚结束 -->
	<!--待退款弹出框begin-->
	<div id="sellOrderItem_returnPay_alert" class="aqmmtc aqmmjjty"
		style=" visibility:hidden;height:170px;">
		<form action="company/order/rejectReturnPay.html"
			id="sellOrderItemReturnPayFrom" method="post">
			<div class="tcgb">
				<a
					onclick="stopsplbtitle('tanchu', 'sellOrderItem_returnPay_alert');"><img
					src="images/memberimg/gb.gif" /> </a>
			</div>
			<p style="margin-left:70px; margin-top:30px; margin-bottom:20px;">
			</p>
			<ul>
				<li><label>支付密码：</label>
				</li>
				<li><input type="password" name="payPassword"
					id="sellOrderItem_returnPay_payPassword" value="" /> <input
					type="hidden" id="sellOrderItem_returnPay_orderId" name="order.id" />
				</li>
			</ul>
			<div style="width:500px;float:left;">
				<p style="width:320px; padding-left:180px;padding-top:10px;">
					<span style="width:100px;float:left;"><a
						onclick="returnPay('no');" class="tcqrjj"
						style="color: #000;text-decoration: none;">拒绝</a> </span> <span
						style="width:100px;float:left;"><a
						onclick="returnPay('ok');" class="tcqrty"
						style="color: #000;text-decoration: none;">同意</a>
						</button> </span>
				</p>
			</div>
		</form>
	</div>
	<!--待退货弹出框begin-->
	<div id="sellOrderItem_returnShip_alert" class="aqmmtc aqmmjjty"
		style=" visibility:hidden;height:170px;">
		<form action="company/order/rejectReturnShip.html"
			id="sellOrderItemReturnShipFrom" method="post">
			<div class="tcgb">
				<a
					onclick="stopsplbtitle('tanchu', 'sellOrderItem_returnShip_alert');"><img
					src="images/memberimg/gb.gif" /> </a>
			</div>
			<p style="margin-left:70px; margin-top:30px; margin-bottom:20px;">
				<img src="/images/memberimg/tc01.gif" />
			</p>
			<ul>
				<li><label>支付密码：</label>
				</li>
				<li><input type="password" name="payPassword"
					id="sellOrderItem_returnShip_payPassword" value="" /> <input
					type="hidden" name="order.id" id="sellOrderItem_returnShip_orderId"
					value="" />
				</li>
				<li><a class="tcqr" onclick="returnShip();">确认</a>
				</li>
			</ul>
		</form>
	</div>

	<!--退货原因-->
	<div id="sellOrderItem_yuanyin_alert" class="aqmmtc aqmmtc_2"
		style=" visibility:hidden">
		<div class="tcgb" style="top:9px; right:15px;">
			<a onclick="stopsplbtitle('tanchu', 'sellOrderItem_yuanyin_alert');"><img
				src="images/memberimg/gb.gif" /> </a>
		</div>
		<p class="thxqd">退货信息</p>
		<p style="margin-left:50px; margin-top:15px; margin-right:50px;">
			<label class="laleft">退货原因： </label><span style="margin-left:8px;"
				id="tuihuoyuanyin">${orderReturn.cause }</span>
		</p>
	</div>
	<!--发货弹出框begin-->
	<div id="sellOrderItem_deliverShip_alert" class="aqmmtc aqmmtc_2"
		style=" visibility:hidden">
		<form action="company/order/deliverShip.html"
			id="sellOrderItemDeliverShipFrom" method="post">
			<div class="tcgb" style="top:9px; right:15px;">
				<a
					onclick="stopsplbtitle('tanchu', 'sellOrderItem_deliverShip_alert');"><img
					src="images/memberimg/gb.gif" /> </a>
			</div>
			<p class="thxqd">发货详情单</p>
			<p style="margin-left:50px; margin-top:15px; margin-right:50px;">
				<input id="sellOrderItem_deliverShip_orderId" type="hidden"
					name="order.id" /> <input id="sellOrderItem_deliverShip_itemId"
					type="hidden" name="orderItemId" /> <label class="laleft">收货人姓名：
				</label> <span style="margin-left:8px;"
					id="sellOrderItem_deliverShip_shipName"></span>
			</p>
			<p style="margin-left:50px; margin-top:15px; margin-right:50px;">
				<label class="laleft">收货人电话： </label><span style="margin-left:8px;"
					id="sellOrderItem_deliverShip_shipTel"></span>
			</p>
			<p style="margin-left:50px; margin-top:15px; margin-right:50px;">
				<label class="laleft" style="float:left">收货人地址： </label><span
					id="sellOrderItem_deliverShip_shipAddr"
					style="margin-left:8px; float:left; width:250px;"></span>
				<div style="clear: both"></div>
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">发货单号：</label><input type="text"
					id="deliverShip_logisticsNum" name="order.logisticsNum" value=""
					onkeyup="clearNoNum(this)" />
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">物流公司名称：</label><input type="text"
					id="deliverShip_logisticsName" name="order.logisticsName" value="" />
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">物流公司电话：</label><input type="text"
					id="deliverShip_logisticsTel" name="order.logisticsTel" value="" />
			</p>
			<p style="margin-left:200px; margin-top:20px; clear: both">
				<a class="tcqr" id="wuliutijiao" onclick="deliverShipSubmit();">确认提交</a>
			</p>
		</form>
	</div>
	<script type="text/javascript">
		//打开退款窗口
		function OpenReturnPay(orderId) {
			$("#sellOrderItem_returnPay_orderId").val(orderId);
			showsplbtitle('tanchu', 'sellOrderItem_returnPay_alert');
		};
		//打开退货窗口
		function OpenReturnShip(orderId) {
			$("#sellOrderItem_returnShip_orderId").val(orderId);
			showsplbtitle('tanchu', 'sellOrderItem_returnShip_alert');
		};
		//打开发货窗口
		function deliverShip(orderId, shipName, shipTel, shipAddr,itemId,logisticsNum,logisticsName,logisticsTel) {
			$("#sellOrderItem_deliverShip_orderId").val(orderId);
			$("#sellOrderItem_deliverShip_itemId").val(itemId);
			$("#sellOrderItem_deliverShip_shipName").html(shipName);
			$("#sellOrderItem_deliverShip_shipTel").html(shipTel);
			$("#sellOrderItem_deliverShip_shipAddr").html(shipAddr);
			$("#deliverShip_logisticsNum").val(logisticsNum);
			$("#deliverShip_logisticsName").val(logisticsName);
			$("#deliverShip_logisticsTel").val(logisticsTel);
			
			showsplbtitle('tanchu', 'sellOrderItem_deliverShip_alert');
		};
		//打开退货窗口
		function OpenReturnYuanyin(orderId) {
			$("#sellOrderItem_returnShip_orderId").val(orderId);
			showsplbtitle('tanchu', 'sellOrderItem_yuanyin_alert');
		};

		//  拒绝/同意退款
		function returnPay(type) {
			$.ajax({
				type : 'post',
				url : 'company/order/rejectReturnPay.html',
				dataType : 'json',
				data : {
					"type" : type,
					"order.id" : $("#sellOrderItem_returnPay_orderId").val(),
					"password" : $("#sellOrderItem_returnPay_payPassword")
							.val()
				},
				success : function(j) {
					if (j.success) {
						window.location.reload();
					} else {
						alert(j.msg);
					}

				}
			});
		};
		//  确认收到退款
		function returnShip() {
			$.ajax({
				type : 'post',
				url : 'company/order/rejectReturnShip.html',
				dataType : 'json',
				data : {
					"order.id" : $("#sellOrderItem_returnShip_orderId").val(),
					"password" : $("#sellOrderItem_returnShip_payPassword")
							.val()
				},
				success : function(j) {
					if (j.success) {
						window.location.reload();
					} else {
						alert(j.msg);
					}

				}
			});
		};

		//提交发货单
		function deliverShipSubmit() {
			logisticsNum = $("#deliverShip_logisticsNum").val();
			logisticsName = $("#deliverShip_logisticsName").val();
			logisticsTel = $("#deliverShip_logisticsTel").val();
			if (logisticsNum == null || logisticsNum == '') {
				alert("发货单号不能为空！");
			} else if (logisticsName == null || logisticsName == '') {
				alert("物流公司名称不能为空！");
			} else if (logisticsTel == null || logisticsTel == '') {
				alert("物流公司电话不能为空！");
			} else {
				$("#sellOrderItemDeliverShipFrom").submit();
				
			}
		}
		
	</script>
</body>

</html>