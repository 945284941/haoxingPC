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
    <title>三古汇官方商城-经验值政策</title>
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
<div class="breadThumb">当前位置：首页   &gt; 经验值政策</div>    
<div class="helpCnt">
	<h1 class="text-center">三古汇官方商城<br>经验值政策</h1>
	<p>三古汇官方商城采用经验值模式，10经验值=1粮票。商城最终展示以“粮票”形式对外公示。粮票与现金兑换比例“1:1”。可以在三古汇商城中进行商品的购买。（备注：三古汇商城自持产品【古粮今典】系列均可以使用粮票全额支付，商城内其他子商户，仅在开通支持粮票兑换活动的商家中允许使用。</p>
	<p>免费注册【全球家庭健康联盟】会员，每个地区仅限前100名，赠送 【49.9元有机大米】会员享有在平台上购买有机粮食9.5折的优惠。升级vip会员（付费998元）优惠赠送： <br>
1、单人1个月份量（20斤有机米）有机粮食<br>
2、998元古粮券(消费折扣用/有效期6个月)，消费每满99.8元抵用10元古粮券一张。</p>
<p>分享好友成为VIP会员，并帮助所分享的VIP会员，均可获得赠送【免费享用有机粮食】 与奖励的资格。分享越多，帮助越多，所获赠送、奖励越多。超值赠送奖励！</p>
<p>赠送奖励：<br>
   分享好友成为vip会员可以免费享受有机食粮和粮票奖励，分享越多收益越多，更多的分享可以让更多人享受有机食粮。</p>
<p>在免费吃古粮分享的过程中可形成创业模式，从而达到创富的理念。分享他人成为VIP会员，在获得当年内12个月的古粮赠送资格后，后续的VIP会员分享，享有VIP会员分享收益</p>
	
</div> 
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
