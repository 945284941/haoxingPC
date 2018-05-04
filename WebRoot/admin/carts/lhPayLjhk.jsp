<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>联行支付页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
  </head>
  <script type="text/javascript">
  $(function() {
		$("#lhpayFormId").submit();
	});
  </script>
  <body>
  	<form action="http://i.chinaecpay.com/gateway.html" id="lhpayFormId" method="post">
    		<input type="hidden" id="merId" name="merId" value="${lhPayPojo.merId}" readonly="readonly" style="border:0px;"/><br/>
    		<input type="hidden" id="dealOrder" name="dealOrder" value="${lhPayPojo.dealOrder}" readonly="readonly" style="border:0px;"><br/>
    		<input type="hidden" id="dealFee" name="dealFee" value="${lhPayPojo.dealFee}" readonly="readonly" style="border:0px;"/><br/>
    		<input type="hidden" id="dealReturn" name="dealReturn" value="${lhPayPojo.dealReturn}" readonly="readonly" style="border:0px;width:500px;"/><br/>
    		<input type="hidden" id="dealNotify" name="dealNotify" value="${lhPayPojo.dealNotify}"  style="border:0px;width:500px;"/><br/>
    		<input type="hidden" id="dealSignure" name="dealSignure" value="${lhPayPojo.dealSignure}"/>
    	</form>
  </body>
</html>
