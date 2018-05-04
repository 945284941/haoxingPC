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
    <title>三古汇官方商城-会员中心</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv=”X-UA-Compatible” content=”IE=edge,chrome=1″ />
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
<div class="breadThumb">当前位置：首页   &gt; 会员中心</div>    
<div class="helpCnt">
	<h1 class="text-center">三古汇官方商城<br>会员中心</h1>
	<p>客户可从网站左上角进入会员中心，会员中心为您提供订单中心和账户中心服务。</p>
	<h3>1、订单中心</h3>
	<p>我的订单：显示您的产品订单信息，包括已付款订单信息和未付款订单。 </p>
	<p>我的收藏：收藏您在浏览过程中喜欢的产品，方便您以后的查找。 </p>
	<p>我的评论：对产品的评论。 </p>
	<p>我的咨询：对产品服务等咨询的记录，方便您以后的查找。 </p>
	<p>我的退换货：查看退换货产品的最新进展。  </p>
	<h3>2、账户中心 </h3>
	<p>个人资料：修改完善个人资料。 </p>
	<p>修改头像：用户头像的修改，可自行设置个性化头像。</p>
	<p>修改秘密：定时修改密码，防止账户被盗。</p>
	<p>个人档案：您在网站所做的健康测试的记录。</p>
	<p>我的经验值：购物完善资料等所得到的经验值，可以产品经验值的使用情况。 </p>
	
	
</div> 
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
