<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/page.css" type="text/css" />
<link rel="stylesheet" href="web/css/sghsc-order.css" type="text/css" />
<title>三古汇官方商城</title>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
		   <jsp:include page="/admin/common/navigation.jsp" />
	<!-- 头部结束 -->
	<!-- 页脚开始 -->
	<div class="breadThumb">	首页 > 会员中心 > 电子商城 > 订单管理 > 我的浏览</div>
	<div class="gzgz">
		<div class="hyleft">
			<c:choose>
				<c:when test="${sessionInfo.userType=='company' }"><jsp:include page="/memberCenter/common/leftNavigate.jsp" /></c:when>
				<c:otherwise><jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" /></c:otherwise>
			</c:choose>	
		</div>
		<div class="hyright">
			<p class="hymainbt">
				<span class="grmenubt">浏览的商品</span>
			</p>
			
			<div class="lbcontant">
				<div class="zxcz2 sclb1">
				<div class="aqwt aqwtsd">
						<form action="person/order/memberViews.html"
							name="person_goodsViwesFrom" id="person_goodsViewsFrom"
							method="post">
							<ul>
								<li><span style=" float:left">起始时间</span><input class="btime"
									id="goodsViwes_startTime" name="startTime"
									value="${startTimeStr}" type="text"
									onClick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,maxDate:'#F{$dp.$D(\'goodsViwes_endTime\')}'})" />
								</li>
								<li><span style=" float:left">结束时间</span><input class="btime"
									id="goodsViwes_endTime" name="endTime" type="text"
									value="${endTimeStr}"
									onClick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,minDate:'#F{$dp.$D(\'goodsViwes_startTime\')}'})" />
								</li>
								<li><button type="submit" class="btn btn-primary btn-xs">确认</button></li>
							</ul>
						</form>
						<div style="clear:both"></div>
					</div>
				</div>
				<table class="table table-bordered  goodsList">
					<thead>
						<tr>
							<th width="360" class="text-center">商品名称</th>
							<th width="100" class="text-center">浏览时间</th>
							<th width="200" >卖家名称</th>
							<th width="80" class="text-center">单价</th>
							<th  width="80"  class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
					<s:iterator var="view" value="viewsList" status="status">
						<tr>
							<td>
							<a target="_Blank" class="list-wz12" href="goods/${view.viewId}.html">
								<img class="list-goodImg" src="${view.defaultPicSrc }" />${view.goodsName}
							</a>
							</td>
							<td  class="text-center"><s:date name="#view.createtime" format="yyyy-MM-dd HH:mm:ss" /></td>
							<td>
							     <s:if test="#collect.companyName !=null">${view.companyName}</s:if>
								<s:else>——</s:else>
							</td>
							<td class="text-center">￥${view.price }</td>
							<td  class="text-center"><a href= "goods/${view.viewId }.html"  class="btn btn-success btn-xs" target="_blank">购买</a></td>
						</tr>
				     </s:iterator>
					</tbody>
				</table>
				<!-- 分页开始 -->
				<div id="showpages">
							<page:pagination path="person/order/memberViews.html" formName="person_goodsViewsFrom" />
						</div>
				<!-- 分页结束 -->
			</div>
		</div>
	</div>
	<!-- 页脚结束 -->
	<!-- footer begin -->
	<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
	<!-- footer end -->
</body>
</html>