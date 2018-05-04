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
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>
	<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
	<meta http-equiv="keywords" content="三古汇,商城"/>
	<meta http-equiv="description" content="三古汇,商城"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="web/bootstrap/bootstrap.min.css"/>
	<link rel="stylesheet" href="web/css/sghsc-main.css"/>
	<link rel="stylesheet" href="web/css/sghsc-order.css"/>
	
	<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
	<script type=text/javascript src="js/layer/layer.min.js"></script>
	<script type=text/javascript src="js/slides.jquery.js"></script>
	<style>
	.middle-demo-2 
	{ 
	padding-top: 24px; 
	padding-bottom: 24px; 
	} 
	</style>
	</head>
<body>

<!-- 头部开始 -->
<!--======================top开始============================-->
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<!--======================导航开始============================-->
  	<jsp:include page="/admin/common/navigation.jsp" />
<!-- 头部结束 -->
<div class="breadThumb">首页 > 会员中心 > 电子商城 > 订单管理 > 我的订单> 订单详情</div>

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
  <div class="sghsc-order-rig-tit">订单详情</div>
  <div class="sghsc-order2-rig-lc">
   <!-- <div id="status1" class="sghsc-order2-rig-lc-tit1">拍下商品</div> -->
   <div id="status1" class="sghsc-order2-rig-lc-tit">拍下商品</div>
   <div id="status2" class="sghsc-order2-rig-lc-tit">付款到商城</div>
   <div id="status3" class="sghsc-order2-rig-lc-tit">卖家发货</div>
   <div id="status4" class="sghsc-order2-rig-lc-tit">确认收货</div>
   <div id="status5" class="sghsc-order2-rig-lc-tit">评价</div>

   <div id="staLogo1" class="sghsc-order2-rig-lc-bg1"></div>
   <div id="staLogo2" class="sghsc-order2-rig-lc-bg2"></div>
   <div id="staLogo3" class="sghsc-order2-rig-lc-bg3"></div>
   <div id="staLogo4" class="sghsc-order2-rig-lc-bg4"></div>
   <div id="staLogo5" class="sghsc-order2-rig-lc-bg5"></div>

   <!-- <div class="sghsc-order2-rig-lc-time">2016-10-12&nbsp;14:12:10</div>   
   <div class="sghsc-order2-rig-lc-time">2016-10-12&nbsp;14:12:10</div> 
   <div class="sghsc-order2-rig-lc-time">2016-10-12&nbsp;14:12:10</div> 
   <div class="sghsc-order2-rig-lc-time">2016-10-12&nbsp;14:12:10</div>  -->
  </div>

  <div class="sghsc-order2-rig-xq">
   <div class="sghsc-order2-rig-xq-let">
    <div class="sghsc-order2-rig-xq-let-s">订单信息</div>
	<div class="sghsc-order2-rig-xq-let-x1">收货信息：</div><div class="sghsc-order2-rig-xq-let-x12">${order.shipName }&nbsp;&nbsp;${order.shipTel }&nbsp;&nbsp;${order.pname }${order.cname }${order.aname }${order.address }</div>
	<div class="sghsc-order2-rig-xq-let-x2">订单编号：</div><div class="sghsc-order2-rig-xq-let-x22">${order.orderNum }</div>
	<div class="sghsc-order2-rig-xq-let-x2">下单时间：</div><div class="sghsc-order2-rig-xq-let-x22"><s:date name="order.createtime" format="yyyy-MM-dd HH:mm:ss" /></div>
	<div class="sghsc-order2-rig-xq-let-x2">商家信息：</div><div class="sghsc-order2-rig-xq-let-x22">${order.companyName }</div>
   </div>
   <div class="sghsc-order2-rig-xq-rit">
    <div class="sghsc-order2-rig-xq-rit1">
    订单状态：<s:if test="order.payStatus == 0">
			未付款
		</s:if>
		<s:if test="order.payStatus == 1">
			已付款
		</s:if>
		<s:if test="order.payStatus == 2">
			待退款
		</s:if>
		<s:if test="order.payStatus == 3">
			已退款
		</s:if>
		<s:if test="order.payStatus == 4">
			卖家拒绝退款
		</s:if>
		<s:if test="order.payStatus == 5">
			退款中
		</s:if>
        <s:if test="order.shipStatus == 0">
			，卖家未发货
		</s:if>
		<s:if test="order.shipStatus == 1">
			，卖家已发货
		</s:if>
		<s:if test="order.shipStatus == 2">
			，您已收货
		</s:if>
		<s:if test="order.shipStatus == 3">
			待退货
		</s:if>
		<s:if test="order.shipStatus == 4">
			拒绝退货
		</s:if>
		<s:if test="order.shipStatus == 5">
			退款中
		</s:if>
    </div>
	<%-- <div class="sghsc-order2-rig-xq-rit2">您还有<span id="divdown1"></span>来付款，超时订单自动关闭</div> --%>
	<div class="sghsc-order2-rig-xq-rit2">
	<!-- <a class="sghsc-order2-rig-xq-rit4" href="">取消订单</a> -->
		<s:if test="order.payStatus == 0">
			您可以<a class="sghsc-order2-rig-xq-rit4" href="payment!toPaymentType.action?orderId=${order.id}">去付款</a>
			<!-- <a class="sghsc-order2-rig-xq-rit3" href="">付款</a> -->
		</s:if>
		<s:if test="order.shipStatus == 1">
			您可以点击列表中的物流单号，查看物流详情
			<!--  
			<a target="_blank" href="logisticsDetail/${order.logisticsNum}.html">查看物流</a>-->
		</s:if>
	</div>
   </div>
  </div> 

  <div class="sghsc-order-rig-dd">
   <table class="sghsc-order-rig-dd-tit"><tbody><tr>
   <td width="448px;" align="center">商品</td>
   <td width="96px;" align="center">单价</td>
   <td width="60px;" align="center">数量</td>
   <td width="96px;" align="center">状态</td>
   <td width="96px;" align="center">物流单号</td>
   <td width="96px;" align="center">物流名称</td>
   <td width="96px;" align="center">物流电话</td>
   </tr></tbody></table>
   
   <s:iterator var="item" value="orderItems" status="status">
   	 <table><tbody>
	   <tr>
	   	<td class="sghsc-order-rig-dd-1-td" ><div class="sghsc-order-rig-dd-1-div" >
		   <div class="sghsc-order-rig-dd-1-img">
		   	<a href="" target="_blank" >
		   		<img src="${item.defaultPicSrc }" border="0" width="80px;" height="80px;"/>
		   	</a>
		   </div>
		   <div class="sghsc-order-rig-dd-1-bt" style="width:338px;">
		   <p><a href="" target="_blank" ><span style="line-height:16px;">${item.goodsName}</span></a></p>
		   <p><span title="七天退换" ><img src="web/images/sghscorder/sghsc-order-zheng.png" /></span>
		   <span title="如实描述" ><img src="web/images/sghscorder/sghsc-order-7.png" /></span>
		   <span title="正品保证" ><img src="web/images/sghscorder/sghsc-order-bao.png" /></span></p>
		   </div></div>
		</td>
		<td class="sghsc-order-rig-dd-1-td"><div style="width:96px;">￥${item.dealPrice}</div></td>
		<td class="sghsc-order-rig-dd-1-td"><div style="width:60px;">X${item.nums}</div></td>
		<td class="sghsc-order-rig-dd-1-td">
			<div style="width:96px;">
				<s:if test="order.payStatus == 0">
					未付款
				</s:if>
				<s:if test="order.payStatus == 1">
					已付款
				</s:if>
				<s:if test="order.payStatus == 2">
					待退款
				</s:if>
				<s:if test="order.payStatus == 3">
					已退款
				</s:if>
				<s:if test="order.payStatus == 4">
					卖家拒绝退款
				</s:if>
				<s:if test="order.payStatus == 5">
					退款中
				</s:if>
			</div>
		</td>
		<td class="sghsc-order-rig-dd-1-td">
		<div style="width:96px;">
			<div>${item.logisticsNum}</div>
			<c:if test="${null != item.logisticsNum && item.logisticsNum != ''}">
				<div>
					<a target="_blank" href="logisticsDetail/${item.logisticsNum}.html">查看物流</a>
				</div>
			</c:if>
		</div>
		</td>
		<td class="sghsc-order-rig-dd-1-td"><div style="width:96px;">${item.logisticsName}</div></td>
		<td class="sghsc-order-rig-dd-1-td"><div style="width:96px;">${item.logisticsTel}</div></td>
	   </tr>
	 </tbody></table>
   </s:iterator>
   
  </div>  

  <div class="sghsc-order2-bom-box">
   <div class="sghsc-order2-bom-box-let">商品总价：</div>
   <div class="sghsc-order2-bom-box-rit">￥${order.costProtect }</div>
   <div class="sghsc-order2-bom-box-let">运费：</div>
   <div class="sghsc-order2-bom-box-rit">￥${order.carriage }</div>
   <div class="sghsc-order2-bom-box-let2">订单总价：</div>
   <div class="sghsc-order2-bom-box-rit2">￥${order.totalCost }</div>
  </div>
  
  <input type="hidden" id="payStatus" name="payStatus" value="${order.payStatus }" />
  <input type="hidden" id="shipStatus" name="payStatus" value="${order.shipStatus }" />
  
 </div>
 <jsp:include page="/admin/common/indexFooter.jsp" />
</div>

<!--倒计时-->
<script language="javascript" type="text/javascript">
/* var interval = 1000; 
function ShowCountDown(year,month,day,divname) 
{ 
var now = new Date(); 
var endDate = new Date(year, month-1, day); 
var leftTime=endDate.getTime()-now.getTime(); 
var leftsecond = parseInt(leftTime/1000); 
var day1=Math.floor(leftsecond/(60*60*24)); 
var hour=Math.floor((leftsecond-day1*24*60*60)/3600); 
var minute=Math.floor((leftsecond-day1*24*60*60-hour*3600)/60); 
var second=Math.floor(leftsecond-day1*24*60*60-hour*3600-minute*60); 
var cc = document.getElementById(divname); 
cc.innerHTML = hour+"小时"+minute+"分"+second+"秒"; 
} 
window.setInterval(function(){ShowCountDown(2010,4,20,'divdown1');}, interval);  */

	$(function(){
		//alert($("#payStatus").val());
		var payStatus = $("#payStatus").val();
		var shipStatus = $("#shipStatus").val();
		
		if(0 == payStatus){
			$("#status1").removeClass().addClass("sghsc-order2-rig-lc-tit1");
			$("#status2").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status3").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status4").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status5").removeClass().addClass("sghsc-order2-rig-lc-tit");
			
			$("#staLogo1").removeClass().addClass("sghsc-order2-rig-lc-bg12");
			$("#staLogo2").removeClass().addClass("sghsc-order2-rig-lc-bg2");
			$("#staLogo3").removeClass().addClass("sghsc-order2-rig-lc-bg3");
			$("#staLogo4").removeClass().addClass("sghsc-order2-rig-lc-bg4");
		}
		if(1 == payStatus){
			$("#status2").removeClass().addClass("sghsc-order2-rig-lc-tit1");
			$("#status1").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status3").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status4").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status5").removeClass().addClass("sghsc-order2-rig-lc-tit");
			
			$("#staLogo2").removeClass().addClass("sghsc-order2-rig-lc-bg22");
			$("#staLogo1").removeClass().addClass("sghsc-order2-rig-lc-bg12");
			$("#staLogo3").removeClass().addClass("sghsc-order2-rig-lc-bg3");
			$("#staLogo4").removeClass().addClass("sghsc-order2-rig-lc-bg4");
		}
		if(1 == shipStatus){
			$("#status3").removeClass().addClass("sghsc-order2-rig-lc-tit1");
			$("#status1").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status2").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status4").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status5").removeClass().addClass("sghsc-order2-rig-lc-tit");
			
			$("#staLogo3").removeClass().addClass("sghsc-order2-rig-lc-bg32");
			$("#staLogo1").removeClass().addClass("sghsc-order2-rig-lc-bg12");
			$("#staLogo2").removeClass().addClass("sghsc-order2-rig-lc-bg22");
			$("#staLogo4").removeClass().addClass("sghsc-order2-rig-lc-bg4");
		}
		if(2 == shipStatus){
			$("#status4").removeClass().addClass("sghsc-order2-rig-lc-tit1");
			$("#status1").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status2").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status3").removeClass().addClass("sghsc-order2-rig-lc-tit");
			$("#status5").removeClass().addClass("sghsc-order2-rig-lc-tit");
			
			$("#staLogo4").removeClass().addClass("sghsc-order2-rig-lc-bg42");
			$("#staLogo3").removeClass().addClass("sghsc-order2-rig-lc-bg32");
			$("#staLogo1").removeClass().addClass("sghsc-order2-rig-lc-bg12");
			$("#staLogo2").removeClass().addClass("sghsc-order2-rig-lc-bg22");
		}
		
	});
	
</script> 

</body>
</html>
