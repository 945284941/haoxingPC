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
<div class="breadThumb">当前位置：首页   &gt; 配送须知</div>    
<div class="helpCnt">
	<h1 class="text-center">三古汇官方商城<br>配送须知</h1>
	<p class="text-center">发货时间长短由收货地址附近有无分销商决定</p>
	<div class="text-center"><h3>物流补偿政策</h3></div>
	<table class="table table-bordered footcntlist" align="center">
		<thead>
		<tr>
		<th class="text-center" width="80">单价</th>
		<th class="text-center" width="80">状态</th>
		<th class="text-center" width="80">起包数量</th>
		<th class="text-center" width="80">补贴邮费</th>
		<th class="text-center" width="80">礼品赠送</th>
		<th class="text-center" width="80">备注</th>
		</tr>
		</thead>
		<tbody>
		<tr>
		<td class="text-center">20-39.9元</td>
		<td class="text-center">单件不包邮</td>
		<td class="text-center">24</td>
		<td class="text-center">10元</td>
		<td class="text-center">无</td>
		<td>单次消费满200元，可使用折扣卷抵扣20元</td>
		</tr>
		<tr>
		<td class="text-center">40-79.9元</td>
		<td class="text-center">单件不包邮</td>
		<td class="text-center">12</td>
		<td class="text-center">10元</td>
		<td class="text-center">无</td>
		<td>单次消费满100元，可使用折扣卷抵扣10元</td>
		</tr>
		<tr>
		<td class="text-center">199-299元</td>
		<td class="text-center">单件包邮</td>
		<td class="text-center">5</td>
		<td class="text-center">10元</td>
		<td class="text-center">无</td>
		<td>单次消费满200元，可使用折扣卷抵扣30元。买赠活动内有效</td>
		</tr>
		<tr>
		<td class="text-center">998元以上</td>
		<td class="text-center">包邮</td>
		<td class="text-center">1</td>
		<td class="text-center">全部</td>
		<td class="text-center">无</td>
		<td>消费满998元，自动升级VIP会员。享受返本返惠米。</td>
		</tr>
		</tbody>
		<tr>
		
		</tr>
	</table>
	
</div> 
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
