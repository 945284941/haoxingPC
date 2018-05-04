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
    <title>三古汇官方商城-验货说明</title>
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
<div class="breadThumb">当前位置：首页   &gt; 验货说明</div>    
<div class="helpCnt">
	<h1 class="text-center">三古汇官方商城<br>验货说明</h1>
	<p>为保障您的权益，请您在收到商品时与配送员当面核对，核对范围包括但不限于：商品种类、规格、数量（包括商品最小包装单位）、金额、赠品、外包装、票据等是否与订单一致，准确无误再进行签收。签收后，“三古汇官方商城”不再为以上问题负责。
 </p>
<p>根据不同食品的不同属性，在验货时您可能需要一并检查以下所列举情况中的一个或多个方面，包括但不限于：商品的保质期、商品的性状是否变化、商品本身标识是否可辨、商品的防伪标签是否已被完全刮开等。
</p>
<p>如果您的订单交由他人代收，代收人享有与您等同的权利，我们将视为您本人签收。如果您在验货时发现商品存在上述问题，经配送员或配送员在场时与客服联络确认，可以选择拒收整个订单。但如果订单商品含有密封包装，且拆封后无质量问题时，不可拒收。
</p>
<p>拒收业务完成后，已支付的款项将按原支付方式和原路径安排退款。在15个工作日内到账。对于“三古汇官方商城”原因造成的订单拒收，客户无需支付配送费；客户原因造成的订单拒收（包装自行拆开等），“三古汇官方商城”将收取您的单程配送费（商家自付）。</p>
	
</div> 
<div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div>
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
