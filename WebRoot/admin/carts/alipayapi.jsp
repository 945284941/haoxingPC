<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>" />
		<title>支付宝即时到账交易</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type=text/javascript src="<%=path%>/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript">
		 $(function() {
				$("#alipaysubmit").submit();
			});
  </script>
	</head>
	<body>
	<form id="alipaysubmit" name="alipaysubmit"
		action="https://mapi.alipay.com/gateway.do?_input_charset=utf-8"
		method="POST">
			<input type="hidden" name="sign" value="${sPara.sign }" />
			<input type="hidden" name="body" value="${sPara.body }" />
			<input type="hidden" name="_input_charset" value="${sPara._input_charset }" />
			<input type="hidden" name="total_fee" value="${sPara.total_fee }" />
			<input type="hidden" name="subject" value="${sPara.subject }" />
			<input type="hidden" name="sign_type" value="${sPara.sign_type }" />
			<input type="hidden" name="service" value="${sPara.service }" />
			<input type="hidden" name="notify_url" value="${sPara.notify_url }" />
			<input type="hidden" name="partner" value="${sPara.partner }" />
			<input type="hidden" name="seller_email" value="${sPara.seller_email }" />
			<input type="hidden" name="out_trade_no" value="${sPara.out_trade_no }" />
			<input type="hidden" name="payment_type" value="${sPara.payment_type }" />
			<input type="hidden" name="return_url" value="${sPara.return_url }" />
	</form>
	</body>
</html>
