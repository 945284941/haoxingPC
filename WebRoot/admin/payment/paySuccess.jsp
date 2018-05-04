<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
  <head>
   <base href="<%=basePath%>">
	<title>付款成功</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta http-equiv="keywords" content="颐佳,商城">
	<meta http-equiv="description" content="颐佳,商城">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="web/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="web/css/base.css">
	<link rel="stylesheet" href="web/css/sghsc-order.css">
	<script type="text/javascript" src="web/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="web/js/jquery-ui-1.10.3.full.min.js"></script>
	<script type="text/javascript" src="js/loginOrNot.js"></script>
	
	<style type="text/css">
		.sghsc-pay-odrmne2 {
		    float: right;
		    font-size: 13px;
		    padding-right: 16px;
		    color: #555;
		    height: 40px;
		    line-height: 45px;
		}
	</style>
	</head>
<body>

<div class="sghsc-order-topbox">
  <div class="sghsc-order-top">
    <div class="sghsc-order-rit">
      <div class="sghsc-order-top-let">
	  	 <span><a href="javaScript:void(0);" onclick="loginOrNot('person/order/myOrders.html');" target="_self">${member.mobile }</a></span>
	  	 <a href="v/logout.html" target="_self">退出</a>
	  	 <span>|</span>
	  	 <a href="javaScript:void(0);" onclick="loginOrNot('person/order/myOrders.html');" target="_self">我的订单</a>
	  	 <span>|</span>
	  	 <a href="#" target="_blank">支付帮助</a>
	 	 <span>|</span>
	  	 <a href="#" target="_blank">问题反馈</a>
      </div>
    </div>		
  </div>
</div>

<div class="sghsc-top-banner-box"><a href="<%=basePath%>"><div class="sghsc-top-banner"></div></a></div>

<div class="sghsc-pay-box">
  <div class="sghsc-pay-main">
   <div class="sghsc-pay-odrnm">提交订单成功，请您进行付款！订单号：${order.orderNum }</div>
   <div class="sghsc-pay-odrmne">需支付：<span id="npay"><fmt:formatNumber value="${order.totalCost }" pattern="0.00" /></span>元</div>
   <div class="sghsc-pay-odrmne2" id="ppay">经验值：0.00</div>
   <div class="sghsc-pay-odrmne2">商品总价：<fmt:formatNumber value="${order.totalCost }" pattern="0.00" /></div>
  </div>
  <div class="sghsc-pay-main-1">
   <div class="sghsc-pay-odrmain">请您在提交订单后<span class="sghsc-red">24小时</span>内完成支付，否则订单会自动取消。</div>
   <div class="sghsc-pay-odrxq" id="box4"><span class="sghsc-pay-icon-xq">收起详情</span></div>
  </div>
  <div class="sghsc-pay-main" id="box3">
   <div class="sghsc-pay-odrads"><span>收货地址：${order.pname }${order.cname }${order.aname }${order.address }</span><span>收件人：${order.shipName }</span><span>${order.shipTel }</span></div>
  </div>
  <div class="sghsc-pay-main-2">

  <ol class="sghsc-pay-sus-box" >
    <li class="sghsc-pay-sus-li">
	  <div class="sghsc-pay-sus-li-wz">确认订单信息</div>
	  <div class="sghsc-pay-sus-li-img-1"></div>
	</li>
    <li class="sghsc-pay-sus-li">
	  <div class="sghsc-pay-sus-li-wz">订单支付</div>
	  <div class="sghsc-pay-sus-li-img-2"></div>
	</li>
    <li class="sghsc-pay-sus-li">
	  <div class="sghsc-pay-sus-li-wz">确认收货</div>
	  <div class="sghsc-pay-sus-li-img-3"></div>
	</li>
  </ol>
  <div class="sghsc-pay-sus-r">恭喜您成功付款<span class="sghsc-pay-sus-m" id="rpay">${order.totalCost }</span>元<a href="javaScript:void(0);" onclick="loginOrNot('person/order/myOrders.html');" target="_self">查看订单详情</a></div>
  <div class="sghsc-pay-sus-gb"><s:if test='order.zoneType == 1'><a href="<%=basePath%>searchGoodsListMoreP.html?goodstype=1" target="_self"></s:if>
  								<s:if test='order.zoneType == 3'><a href="<%=basePath%>searchGoodsListMoreP.html?goodstype=3" target="_self"></s:if><input type="submit" value="继续购买" class="sghsc-pay-btn sghsc-pay-btn-2" /></a></div>
 </div>
  
</div>
	<script type="text/javascript">
	var orderAmount = <fmt:formatNumber value="${order.totalCost }" pattern="0.00" />;
	var totalPoint = <fmt:formatNumber value="${member.point}" pattern="0.00" />;
	var topayPoint = 0;
	<c:if test="${pointPayment != null}">
		topayPoint = <fmt:formatNumber value="${pointPayment.amount }" pattern="0.00" />;
	</c:if>
	if("${pointPayment.status}"!="0" || totalPoint>=topayPoint) {
		$("#rpay").text((orderAmount - topayPoint).toFixed(2));
		$("#npay").text((orderAmount - topayPoint).toFixed(2));
		$("#ppay").text("经验值：" + topayPoint.toFixed(2));
	}
	
//展开详情
window.onload=function(){
var box_3 = document.getElementById("box3");
var box_4 = document.getElementById("box4").getElementsByTagName("span")[0];
box_4.onclick=function(){
box_3.className=(box_3.className=="sghsc-pay-main")?"sghsc-pay-main-noe":"sghsc-pay-main";
box_4.className=(box_4.className=="sghsc-pay-icon-xq")?"sghsc-pay-icon-xq-noe":"sghsc-pay-icon-xq";
this.innerHTML=(this.innerHTML=="收起详情")?"展开详情":"收起详情";
}
}
</script>
</body>
</html>
