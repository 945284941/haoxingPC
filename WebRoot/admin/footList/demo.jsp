<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>颐佳官方商城-购物流程</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="web/css/base.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="web/bootstrap/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
  </head>
  <body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="/admin/common/navigation.jsp" />
<div class="breadThumb">当前位置：首页   &gt; 购物流程</div>    
<div class="helpCnt">
	<h1 class="text-center">颐佳官方商城<br>购买流程</h1>
	<h3>一、新用户注册</h3>
	<p>第一步：进入颐佳官方商城网站，点击页面上方的“注册”进入注册页面。也可以用手机号，电子邮箱，支付宝、财付通等第三方账号进行登录。 </p>
	
</div> 
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
