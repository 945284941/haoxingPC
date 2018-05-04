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
	<title>选择支付方式</title> 
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
	<link rel="stylesheet" href="css/xcConfirm.css"/>
	<script type="text/javascript" src="web/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="web/js/jquery-ui-1.10.3.full.min.js"></script>
	<script type="text/javascript" src="js/payment/jquery.hcpay.min.js"></script>
	<script type="text/javascript" src="js/xcConfirm.js"></script>
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
  <div class="sghsc-pay-main" id="box3" >
   <div class="sghsc-pay-odrads"><span>收货地址：${order.pname }${order.cname }${order.aname }${order.address }</span><span>收件人：${order.shipName}</span><span>${order.shipTel}</span></div>
  </div>
  <div class="sghsc-pay-main-2">
   <div class="sghsc-pay-mode-top">支付方式<span class="sghsc-pay-mode-top-1">以下支付方法由颐佳支付提供</span></div>
   <form name="payment" id="payment" action="" method="post" autocomplete="off">
    <div class="sghsc-pay-mode-box">
     <div class="sghsc-pay-mode">
     		<input type="hidden" name="order.id" id="id" value="${order.id }"/>
     	  	<input type="hidden" name="orderId" id="orderId" value="${order.id }"/>
		  	<input type="hidden" name="order.orderNum" id="orderNum" value="${order.orderNum }" />
		  	<input type="hidden" name="order.totalCost" id="totalCost" value="${order.totalCost }"/>
		  	<input type="hidden" name="order.zoneType" id="zoneType" value="${order.zoneType }"/>
		  	<input type="hidden" name="member.xianjinbi" id="xianjinbi" value="${member.xianjinbi }"/>
		  	<input type="hidden" name="member.liucunbi" id="liucunbi" value="${member.liucunbi }"/>
		  	<input type="hidden" name="member.point" id="point" value="${member.point }"/>
		  	<input type="hidden" name="type" id="type" value=""/>
		  	<input type="hidden" name="huichouType" id="huichouType" value=""/>
		  	<input type="hidden" name="payPassword" id="payPassword" value=""/>
		  	<input type="hidden" name="payuser" id="payuser" value=""/>
		  	<input type="hidden" name="hcPaystatus" id="hcPaystatus" value=""/>
		  	<input type="hidden" name="beanAmount" id="beanAmount" value="0"/>
		  	<input type="hidden" name="huibaoAmount" id="huibaoAmount" value="0"/>
		  	<input type="hidden" name="pointAmount" id="pointAmount" value="0"/>
		  	<input type="hidden" name="message" id="message" value=""/>
	
		<c:if test="${order.zoneType == 1 || order.zoneType == 3}">
		   <div id="zhifu1" class="btn btn-default sghsc-pay-mode-fs">
		    <input id="sgh-api-1" name="sgh-apiCode" value="0" type="radio" class="sgh-api-re" <s:if test='order.zoneType != 1 && order.zoneType != 3'>disabled="disabled"</s:if>>
			<span class="sghsc-pay-yue-bt sghsc-pay-icon-1" id="zhifubao">支付宝支付</span>
		   </div>
		</c:if>

     </div>
   </div>
   <div class="sghsc-pay-odrmne sghsc-pay-odrmne-2">支付金额：<span id="rpay"><fmt:formatNumber value="${order.totalCost }" pattern="0.00" /></span>元</div>
   <input type="button" id="mentpay" value="立即支付" class="sghsc-pay-btn" >
   </form>


  
  
  
<script type="text/javascript">
	var orderAmount = <fmt:formatNumber value="${order.totalCost }" pattern="0.00" />;
	var totalPoint = <fmt:formatNumber value="${member.point}" pattern="0.00" />;
	var topayPoint = 0;
	<c:if test="${pointPayment != null}">
		topayPoint = <fmt:formatNumber value="${pointPayment.amount }" pattern="0.00" />;
	</c:if>
	var topayAmount = orderAmount;
		//选择支付样式	
		$(function(){
			if("${pointPayment.status}"!="0" || totalPoint>=topayPoint) {
				$("#rpay").text((orderAmount - topayPoint).toFixed(2));
				$("#npay").text((orderAmount - topayPoint).toFixed(2));
				$("#ppay").text("经验值：" + topayPoint.toFixed(2));
				topayAmount = orderAmount - topayPoint;
			}
		
		    $(".sghsc-pay-mode-fs input").change(function(){
		    	$("#type").val($(":checked").val());
		        $(":checked").parent().addClass("sgh-api-focus").siblings().removeClass("sgh-api-focus");
		    });
		});
		
		$("#mentpay").click(function(){
		 $("div.sgh-api-focus").find("span#xinjinbi");
		 	var paymentType=$("#type").val();
		 	if(null!=paymentType&&""!=paymentType&&typeof(paymentType) != "undefined"){
		 		gopay();
		 	} else {
		 		var txt=  "支付类型不能为空!";
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
				return;
		 	}
		});
		
		//支付
		function gopay() {
			var paymentType=$("#type").val();
			var zoneType=$("#zoneType").val();
			var id=$("#orderId").val();
			var orderId=$("#orderNum").val();
			var totalCost=$("#totalCost").val();
			var xianjinbi=$("#xianjinbi").val();
			var liucunbi=$("#liucunbi").val();
			var point=$("#point").val();
			var from = document.getElementById("payment");
			if(paymentType=="0"){
				from.action = "memberCallAction!toZfbPay.action";
				$("#payment").submit();
			}else if(paymentType=="1"){
				if(topayAmount>Number(xianjinbi)){
					var txt=  "金米余额不足!";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
					return;
				}else{
					var dialog = $("#QuidpaySelector").dialog({
						resizable: false,
						modal: true,
						title: "金米支付",
						title_html: true,
						width:546,
						height:320,
						buttons: [
							{
								html: "确认",
								"class" : "sghsc-pay-hbpay-btn","id" : "send",
								click: function() {
									$("#send").replaceWith("<button class='sghsc-pay-hbpay-btn'><span id='sendwaiting2'>请稍后...</span></button>");
										var quidpaypassword=$("#quidpaypassword").val();
										var payPassword=$.md5($("#quidpaypassword").val());
										$("#payPassword").val(payPassword);
										from.action = "payment!dealOwnResult.action";
										$("#payment").submit();
									}
							},
						]
					});
				}
			}else if(paymentType=="2"){
				if(topayAmount>Number(point)){
					var txt=  "经验值余额不足!";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
					return;
				}else{
					var dialog = $("#QuidpaySelector").dialog({
						resizable: false,
						modal: true,
						title: "经验值支付",
						title_html: true,
						width:546,
						height:320,
						buttons: [
							{
								html: "确认",
								"class" : "sghsc-pay-hbpay-btn",
								"id" : "send",
								click: function() {
									$("#send").replaceWith("<button class='sghsc-pay-hbpay-btn'><span id='sendwaiting2'>请稍后...</span></button>");
										var quidpaypassword=$("#quidpaypassword").val();
										var payPassword=$.md5($("#quidpaypassword").val());
										$("#payPassword").val(payPassword);
										from.action = "payment!dealOwnResult.action";
										$("#payment").submit();
									}
							},
						]
					});
				}
			}else if(paymentType=="3"){
				if(topayAmount>Number(liucunbi)){
					var txt=  "惠米余额不足!";
					window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
					return;
				}else{
					var dialog = $("#QuidpaySelector").dialog({
						resizable: false,
						modal: true,
						title: "惠米支付",
						title_html: true,
						width:546,
						height:320,
						buttons: [
							{
								html: "确认",
								"class" : "sghsc-pay-hbpay-btn","id" : "send",
								click: function() {
									$("#send").replaceWith("<button class='sghsc-pay-hbpay-btn'><span id='sendwaiting2'>请稍后...</span></button>");
										var quidpaypassword=$("#quidpaypassword").val();
										var payPassword=$.md5($("#quidpaypassword").val());
										$("#payPassword").val(payPassword);
										from.action = "payment!dealOwnResult.action";
										$("#payment").submit();
									}
							},
						]
					});
				}
			}else if(paymentType=="4"||paymentType=="5"||paymentType=="6"||paymentType=="7"){
				if(paymentType=="4"){
					$("#huichouType").val("1");
					$("#beanAmount").val(topayAmount);
					$("#huibaoAmount").val("0");
					$("#pointAmount").val("0");
				}else if(paymentType=="5"){
					$("#huichouType").val("2");
					$("#huibaoAmount").val(topayAmount);
					$("#pointAmount").val("0");
					$("#beanAmount").val("0");
				}else if(paymentType=="6"){
					$("#huichouType").val("3");
					$("#pointAmount").val(topayAmount);
					$("#beanAmount").val("0");
					$("#huibaoAmount").val("0");
				}else if(paymentType=="7"){
					$("#huichouType").val("4");
					$("#pointAmount").val("0");
					var huibao=$("#huibao1").val();
					var huidou=$("#huidou1").val();
					if(Number(huibao)+Number(huidou)==topayAmount){
						$("#huibaoAmount").val(huibao.toString());
						$("#beanAmount").val(huidou.toString());
					}else{
						var txt=  "汇豆和汇宝数量输入有误!";
						window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
						return;
					}
				}
				var dialog = $("#HuibaopaySelector").dialog({
					resizable: false,
					modal: true,
					title: "汇筹支付",
					title_html: true,
					width:546,
					height:320,
					buttons: [
						{
							html: "确认",
							"class" : "sghsc-pay-hbpay-btn","id" : "send",
							click: function() {
								$("#send").replaceWith("<button class='sghsc-pay-hbpay-btn'><span id='sendwaiting2'>请稍后...</span></button>");
									var quidpaypassword=$("#hbpaypassword").val();
									var payPassword=$.md5(quidpaypassword);
									$("#payPassword").val(payPassword);
									var hbpayname = $("#hbpayname").val();
									$("#payuser").val(hbpayname);
									from.action = "payment!dealHcResult.action";
									$("#payment").submit();
								}
						},
					]
				});
			}
		}
</script>


<div style="display:none;">
	<div id="HuibaopaySelector">
		<div class="sghsc-pay-hbpay-main">

				<form class="form-horizontal" role="form" id="forHuibaopay">
					<div class="sghsc-pay-hbpay-main-1">
					  <div class="sghsc-pay-hbpay-main-bt">汇筹账号：</div>
                      <input type="text" name="hbpayname" id="hbpayname" class="sghsc-pay-hbpay-main-input" required placeholder="请输入您的帐号"  />
					</div>

					<div class="sghsc-pay-hbpay-main-1">
					  <div class="sghsc-pay-hbpay-main-bt">支付密码：</div>
                      <input type="password" name="hbpaypassword" id="hbpaypassword" class="sghsc-pay-hbpay-main-input" required placeholder="请输入6位数字支付密码" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" />
					</div>			
				</form>	

		</div>	
	</div>	
</div>


<div style="display:none;">
	<div id="QuidpaySelector">
		<div class="sghsc-pay-hbpay-main">

				<form class="form-horizontal" role="form" id="forQuidpay">
					<div class="sghsc-pay-hbpay-main-1"  style="display: none;">
					  <div class="sghsc-pay-hbpay-main-bt"></div>
                      <input type="text" name="" id="" class="sghsc-pay-hbpay-main-input"  />
					</div>
					<div class="sghsc-pay-hbpay-main-1">
					  <div class="sghsc-pay-hbpay-main-bt">支付密码：</div>
                      <input type="password" name="quidpaypassword" id="quidpaypassword" class="sghsc-pay-hbpay-main-input" required placeholder="请输入您的支付密码" />
					</div>			
				</form>	

		</div>	
	</div>	
</div>				

		

<script type="text/javascript">
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


		
 </div>  
</div>
	
</body>
</html>
