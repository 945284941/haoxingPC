<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付宝支付页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="支付">
	<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
  </head>
  <script type="text/javascript">
 $(function() {
		$("#payment").submit();
	});

  </script>
  <body>
  <form name="payment" id= "payment"  action="aliPayAction!goAlipayapi.action"  method="post">
  <input type="hidden" name="tradePayDeail.id" id="id" value="${tradePayDeail.id }"/>
  <input type="hidden" name="tradePayDeail.orderId" id="orderId" value="${tradePayDeail.orderId }"/>
  <input type="hidden" name="tradePayDeail.orderNum" id="orderNum" value="${tradePayDeail.orderNum }" />
  <input type="hidden" name="tradePayDeail.orderName" id="orderName" value="${tradePayDeail.orderName }"/>
  <input type="hidden" name="tradePayDeail.totalPrice" id="totalPrice" value="${tradePayDeail.totalPrice }"/>
  <input type="hidden" name="tradePayDeail.orderMsg" id="orderMsg" value="${tradePayDeail.orderMsg }"/>
  <input type="hidden" name="tradePayDeail.productUrl" id="productUrl" value="${tradePayDeail.productUrl }"/>
  <input type="hidden" name="frpId"  id="pay_frpId" />
  </form>
  </body>
</html>
