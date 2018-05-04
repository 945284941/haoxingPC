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
    <title>三古汇官方商城-购物流程</title>
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
<div class="breadThumb">当前位置：首页   &gt; 购物流程</div>    
<div class="helpCnt">
	<h1 class="text-center">三古汇官方商城<br>购买流程</h1>
	<h3>一、新用户注册</h3>
	<p>第一步：进入三古汇官方商城网站，点击页面上方的“注册”进入注册页面。也可以用手机号，电子邮箱，支付宝、财付通等第三方账号进行登录。 </p>
	<p>第二步：在相应提示处输入您的用户名、Email（为接收账户信息、订单通知及密码找回等功能）、手机号、密码（密码设置不要过于简单）、确认密码、输入验证码后点击“注册”即可，注册用户名是唯一的。
	</p>
	<p>第三步：完成注册后，系统直接进入会员中心。您可以完善个人资料，或去挑选所需购买的商品。</p>
	<p>现在就去<a href="toMemberNotice.html">注册新用户</a></p>
	<h3>二、挑选商品 </h3>
	<p>三古汇官方商城为您提供了两种方便快捷的商品搜索功能： </p>
	<p>方式一：通过搜索功能查找。在搜索框中输入关键字或商品名称进行搜索。</p>
	<p>方式二：通过分类导航查找。</p>
	<h3>三、确认下单 </h3>
	<p>第一步：挑选到心仪商品后，可将商品放入购物车。点击“加入购物车”进入购物车页面。</p>
	<p>第二步：在购物车中确认商品的数量、金额等信息无误后进行结算。</p>
	<p>第三步：按提示填写详细的收货地址、支付方式。确定购买清单相关信息后，点击去支付，提交订单。
	</p>
	<p>第四步：订单提交后，可在会员中心中查询订单详情及历史订单。 </p>
	<h3>四、等待收货</h3>
</div> 
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
