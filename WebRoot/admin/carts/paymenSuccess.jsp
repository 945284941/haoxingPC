<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付成功</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="x-ua-compatible" content="ie=7" />
	<jsp:include page="/admin/common/keyWords.jsp" />
    <link href="css/master.css" rel="stylesheet" type="text/css">
	<link href="css/news.css" rel="stylesheet" type="text/css">
	<link href="css/shop.css" rel="stylesheet" type="text/css">
	<link href="css/shop_two.css" rel="stylesheet" type="text/css">
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
	<script type=text/javascript src="js/slides.jquery.js"></script>
    

  </head>
  
  <body>
    <div class="header">
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
  </div>
  <div class="logo">
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
  </div>  
  <!-- header end -->
  <!-- 导航 -->
  <jsp:include page="../common/navigation.jsp"></jsp:include>
  <!-- header end -->
	<div class="shop">
		<div style=" width:293px; margin:20px auto 0">
			<img src="/images/shop/zfcg.gif" alt="支付成功" />
		</div>
		<div class="splb splbtwo">
			<h2>订单状态</h2>
			<div class="cplb">
				<div class="cc name"><span class="price">订单编号</span></div>
				<div class="cc lb"><span class="price">${orderNum }</span></div>
				<div style="clear:both"></div>
			</div> 
	        <div class="cplb">
	            <div class="cc name"><span class="price">支付状态</span></div>
	            <div class="cc lb"><span class="price">买家已支付货款</span></div><div style="clear:both"></div>
	        </div>
	        <div class="cplb">
	            <div class="cc name"><span class="price">订单来源</span></div>
	            <div class="cc lb"><span class="price">网站（手机、客服热线）</span></div><div style="clear:both"></div>
	        </div>       
		</div>
		<!--  
		<div class="tlggp"><a href="/"><img src="/images/tlgg7.gif"/></a></div>-->
	</div>
	
	<!-- footer begin -->
	<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
 <jsp:include page="/admin/common/indexFooter.jsp" />
<!-- footer end -->
  </body>
</html>