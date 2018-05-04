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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link rel="stylesheet" href="web/bootstrap/bootstrap.min.css" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/page.css" type="text/css" />
<title>三古汇官方商城</title>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/layer/layer.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript src="js/register.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="tanchu"></div>
	<!-- 头部开始 -->
<!--======================top开始============================-->
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
 <s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<!--======================导航开始============================-->
  <jsp:include page="/admin/common/navigation.jsp" />
	<!-- 头部结束 -->
	<div class="breadThumb">首页 > 会员中心 > 我的分销 > 分销用户 > 消费记录</div>
	<div class="gzgz">
		<div class="hyleft">
			<c:choose>
				<c:when test="${sessionInfo.userType=='company' }"><jsp:include
						page="/memberCenter/common/leftNavigate.jsp" /></c:when>
				<c:otherwise><jsp:include
						page="/memberCenter/common/leftNavigatePerson.jsp" /></c:otherwise>
			</c:choose>
		</div>
		<div class="hyright">
			<div class="hyrightr">
			</div>
			<p class="hymainbt">
				<span class="grmenubt">消费记录</span>
			</p>
			<div class="aqwt aqwtdd">
				<form action="person/order/myOrders.html"
					id="person_orders_orderForm" name="person_orders_orderForm"
					method="post">
					<ul>
						<li><select id="" name="payStatus" class="textaqsfk">
								<option value="-1">付款状态</option>
								<s:if test="payStatus ==1">
									<option selected="selected" value="1">已付款</option>
								</s:if>
								<s:else>
									<option value="1">已付款</option>
								</s:else>
								<s:if test="payStatus ==0">
									<option selected="selected" value="0">未付款</option>
								</s:if>
								<s:else>
									<option value="0">未付款</option>
								</s:else>
								<s:if test="payStatus ==3">
									<option selected="selected" value="3">已退款</option>
								</s:if>
								<s:else>
									<option value="3">已退款</option>
								</s:else>
								<s:if test="payStatus ==2">
									<option selected="selected" value="2">待退款</option>
								</s:if>
								<s:else>
									<option value="2">待退款</option>
								</s:else>

						</select></li>
						<li><select id="" name="shipStatus" class="textaqsfk">
								<option value="-1">物流状态</option>
								<s:if test="shipStatus ==1">
									<option selected="selected" value="1">已发货</option>
								</s:if>
								<s:else>
									<option value="1">已发货</option>
								</s:else>
								<s:if test="shipStatus ==0">
									<option selected="selected" value="0">未发货</option>
								</s:if>
								<s:else>
									<option value="0">未发货</option>
								</s:else>
								<s:if test="shipStatus ==2">
									<option selected="selected" value="2">已收货</option>
								</s:if>
								<s:else>
									<option value="2">已收货</option>
								</s:else>
								<s:if test="shipStatus ==4">
									<option selected="selected" value="4">已退货</option>
								</s:if>
								<s:else>
									<option value="4">已退货</option>
								</s:else>
								<s:if test="shipStatus ==3">
									<option selected="selected" value="3">待退货</option>
								</s:if>
								<s:else>
									<option value="3">待退货</option>
								</s:else>

						</select></li>
						<li><span style=" float:left">起始时间</span><input class="btime"
							id="orders_startTime" name="startTime" value="${startTimeStr}"
							type="text"
							onClick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,maxDate:'#F{$dp.$D(\'orders_endTime\')}'})" />
						</li>
						<li><span style=" float:left">结束时间</span><input class="btime"
							id="orders_endTime" name="endTime" type="text"
							value="${endTimeStr}"
							onClick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,minDate:'#F{$dp.$D(\'orders_startTime\')}'})" />
						</li>
						<li><button type="submit" class="btn btn-primary btn-xs">确认</button>
						</li>
					</ul>
				</form>
				<div style="clear:both"></div>
			</div>
			<div class="lbcontant2">
				<div class="lbctitle lbctitledd">
					<span style="width:150px;">购买时间</span> 
					<span style="width:373px;">商品名称</span>
					<span style="width:66px;">购买数量</span>
					<span style="width:79px;">单价</span>
					<span style="width:75px;">总价</span>
					<span style="width:88px;">返现</span> 
<!-- 					<span style="width:205px;">操作</span> -->
				</div>
				<s:iterator var="o" value="orderList" status="status">
					<s:iterator var="i" value="#o.items" status="st">
						<div class="zxlb zxlb2 wddd">
							<ul>
								<li style="height:32px;width: 150px;"><span><s:date name="#o.createtime" format="yyyy-MM-dd HH:mm:ss" /></span></li>
								<li class="lbtwo" style="height:32px; line-height:32px;">
									<a target="_Blank" href="goods/${i.goodsId}.html">
										<img src="${i.goodsPic}" />
									</a>
								</li>
								<li class="lbone" style="height:32px;">
									<a target="_Blank" href="goods/${i.goodsId}.html">${i.goodsName}(${i.itemSku })</a>
								</li>
								<li class="ddthree" style="height:32px; line-height:32px;">${i.nums}</li>
								<li class="ddfour" style="height:32px; line-height:32px;">￥${i.dealPrice}</li>
								<li class="ddfive" style="height:32px; line-height:32px;">￥${i.nums*i.dealPrice}</li>
								<li class="ddsix" style="height:32px; line-height:32px;">
									<s:if test="#o.shipStatus ==2">￥${i.goods.fanxian}</s:if>
								</li>
							</ul>
							<div style="clear:both"></div>
						</div>
					</s:iterator>
					</s:iterator>

				<!-- 分页开始 -->
				<div id="showpages">
					<page:pagination path="person/order/myOrders.html"
						formName="person_orders_orderForm" />
				</div>
				<!-- 分页结束 -->
			</div>
		</div>
	</div>
	
	<div id="mjs:tip" class="tip" style="position:absolute;left:0;top:0;display:none;"></div>
	<!-- footer begin -->
	<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
	
</body>
</html>