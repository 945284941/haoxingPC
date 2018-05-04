<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
  <head>
  <base href="<%=basePath%>" />
	<title>三古汇官方商城</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta http-equiv="keywords" content="三古汇,商城">
	<meta http-equiv="description" content="三古汇,商城">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="web/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="web/css/sghsc-main.css">
	<link rel="stylesheet" href="web/css/sghsc-order.css">
	
	<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
	<script type=text/javascript src="js/layer/layer.min.js"></script>
	<script type=text/javascript src="js/slides.jquery.js"></script>
	
	</head>
<body>
<!-- 头部开始 -->
<!--======================top开始============================-->
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<!--======================导航开始============================-->
	<jsp:include page="/admin/common/navigation.jsp" />
<!-- 头部结束 -->

<div class="sghsc-order-main">
<!-- 左侧功能菜单开始 -->
	<c:choose>
		<c:when test="${sessionInfo.userType=='company' }">
			<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
		</c:when>
		<c:otherwise>
			<jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" />
		</c:otherwise>
	</c:choose>
<!-- 左侧功能菜单结束 -->

 <div class="sghsc-order-main-right">
  <div class="sghsc-order-rig-tit">订单详情&nbsp;>&nbsp;物流信息</div>
  <div class="sghsc-orderwl-rig-top">包裹信息</div>
  <div class="sghsc-orderwl-rig-main">

	<div id="resultsDiv" class="sghsc-orderwl-rig-wl2"></div>
	
  <%-- <div class="sghsc-orderwl-rig-xq">
   <div class="sghsc-orderwl-rig-xq0">
	<div class="sghsc-orderwl-rig-xq1">运单号码：</div><div class="sghsc-orderwl-rig-xq2">3318459201430</div>
	<div class="sghsc-orderwl-rig-xq3">物流公司：</div><div class="sghsc-orderwl-rig-xq2">韵达快运</div>
	<div class="sghsc-orderwl-rig-xq3">客服电话：</div><div class="sghsc-orderwl-rig-xq2">95546</div>
   </div>
   <div class="sghsc-orderwl-rig-xq0">
	<div class="sghsc-orderwl-rig-xq1">商家信息：</div><div class="sghsc-orderwl-rig-xq2">广安嘉浩商贸有限公司</div>
   </div>
   <div class="sghsc-orderwl-rig-xq0">
	<div class="sghsc-orderwl-rig-xq1">发货地址：</div><div class="sghsc-orderwl-rig-xq4">从站点发出，本次转运目的地：江苏从站点发出，本次转运目的地：江苏南京栖霞区仙林公司从站点发出，本次转运目的地：江苏南京栖霞区仙林公司从站点发出，本次转运目的地：江苏南京栖霞区仙林公司从站点发出，本次转运目的地：江苏南京栖霞区仙林公司从站点发出，本次转运目的地：江苏南京栖霞区仙林公司从站点发出，本次转运目的地：江苏南京栖霞区仙林公司从站点发出，本次转运目的地：江苏南京栖霞区仙林公司</div>
   </div>	
   <div class="sghsc-orderwl-rig-xq0">
	<div class="sghsc-orderwl-rig-xq1">收货地址：</div><div class="sghsc-orderwl-rig-xq4">王发光，14013191710，山东省济南市历下区解放路街道解放路16号黄金大厦9层山东古道农业科技有限公司</div>
   </div>	
   <div class="sghsc-orderwl-rig-xq5"><a href="" target="_blank"><img src="web/images/img01.jpg" class="sghsc-img-border-1" width="80" height="80"></a><span class="text">476.00 x 1</span></div>
   <div class="sghsc-orderwl-rig-xq5"><a href="" target="_blank"><img src="web/images/img01.jpg" class="sghsc-img-border-1" width="80" height="80"></a><span class="text">476.00 x 1</span></div>
  </div> --%>

  </div>
	  
 </div>

</div>
<div class="clear"></div>
<jsp:include page="/admin/common/indexFooter.jsp" />
<script language="javascript" type="text/javascript">
	window.onload = function(){
		//加载物流信息
		var message = ${messagew};
		
     	var resultHtml = '<xml>';
     	if(message.status == 0) {
	      	$.each(message.result.list,function(index,item){
	      	resultHtml += '<data><time class="sghsc-orderwl-rig-wl3">' +item.time+ '</time><context>' +item.status+ '</context></data><br/>';
      	});
     	}else {
     		resultHtml += '<data><context>' +message.msg+ '</context></data><br/>';
     	}
     	
     	resultHtml += '</xml>';
     	$("#resultsDiv").html(resultHtml);
	}
	
</script> 

</body>
</html>
