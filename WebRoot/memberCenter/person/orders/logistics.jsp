<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/page.css" type="text/css" />
<link rel="stylesheet" href="web/css/sghsc-order.css"/>
<title>三古汇官方商城</title>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript src="js/tanchu.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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
</head>
<body>
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
		   <jsp:include page="/admin/common/navigation.jsp" />
	<!-- 头部结束 -->
	<!-- 页脚开始 -->
		<div class="breadThumb">首页 > 企业会员中心 > 电子商城 > 订单管理 > 查看物流</div>
	<div class="gzgz">
		<div class="hyleft">
     		<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
     	</div>
		<div class="hyright">
			<div class="hyrightr">
			</div>
			<p class="hymainbt">
				<span class="grmenubt">物流</span>
			</p>
			
			<div class="sghsc-orderwl-rig-wl2" id="resultsDiv">
					 <%--<div class="sghsc-orderwl-rig-xq">
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
				  </div>--%>
			</div>
		</div>

	</div>


	
	<!-- footer begin -->
<!--======================bottom开始============================-->
  <div class="clear"></div>
<jsp:include page="/admin/common/indexFooter.jsp" />
	<!-- footer end -->
	<!-- 页脚结束 -->

</body>
</html>