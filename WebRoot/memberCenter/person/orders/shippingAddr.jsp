<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link rel="stylesheet" href="css/tanchu.css" type="text/css" />
<link rel="stylesheet" href="web/css/sghsc-order.css" type="text/css" />
<title>三古汇官方商城</title>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript src="js/regions.js"></script>
<script type=text/javascript src="js/register.js"></script>
<script type=text/javascript src="js/tanchu.js"></script>
<script type=text/javascript src="js/qlzy.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<div id="tanchu"></div>
</head>
<style>
.ddlabel{width:90px;}

</style>

<body>
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
		   <jsp:include page="/admin/common/navigation.jsp" />
		   <div class="breadThumb">	首页 > 会员中心 > 电子商城 > 订单管理 > 收货地址</div>
	<div class="gzgz">
		<div class="hyleft">
			<c:choose>
				<c:when test="${sessionInfo.userType=='company' }"><jsp:include page="/memberCenter/common/leftNavigate.jsp" /></c:when>
				<c:otherwise><jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" /></c:otherwise>
			</c:choose>
		</div>
		<div class="hyright">
			<p class="hymainbt">
				<span class="grmenubt">订单管理</span>
			</p>
			<div class="shdz">
				<div class="sh_title">
					<ul>
						<li style="width:100px;">收货人</li>
						<li style="width:120px;">手机</li>
						<li style="width:300px; text-align:left;">收货地址</li>
						<li style="width:120px;">操作</li>
						<li style="width:300px;">默认地址</li>
					</ul>
				</div>
				<div class="dznr">
					<jsp:include page="memberShippingAddr.jsp" />
				</div>
				<form>
					<div style="padding-left: 70px; display: block;"
						class="consignee-form">
						<div class="hylist">
							<span class="ddlabel"><em>*</em>收货人：</span>
							<div class="field">
								<input type="text" style="width:200px;" maxlength="20" id="person_orders_shippingAddr_clearingName" class="ddtextbox" />
							</div>
							<span class="status error"></span>
						</div>
						<div class="hylist">
							<span class="ddlabel"><em>*</em>所在地区：</span>
							<div class="field">
								<span> 
									<s:select id="person_orders_shippingAddr_clearingProvince" name="" headerKey="0" headerValue="-选择省-" list="provinces" listKey="id" listValue="name" value="%{receiveAddr.province}" theme="simple" onchange="_getCitys(this.value,'person_orders_shippingAddr_clearingCity','person_orders_shippingAddr_clearingArea')"></s:select> 
								</span> 
								<span> 
									<s:select id="person_orders_shippingAddr_clearingCity" name="" headerKey="0" headerValue="-选择市-" list="cityList" listKey="id" listValue="name" value="%{receiveAddr.city}" theme="simple" onchange="_getAreas(this.value,'person_orders_shippingAddr_clearingArea')"></s:select> 
								</span>
								<span id="span_county">
									<s:select id="person_orders_shippingAddr_clearingArea" name="" headerKey="0" headerValue="-选择区-" list="areaList" listKey="id" listValue="name" value="%{receiveAddr.area}" theme="simple"></s:select>
								</span>
								
							</div>
						</div>
						<div class="hylist">
							<span class="ddlabel"><em>*</em>详细地址：</span>
							<div class="field">
								<input id="person_orders_shippingAddr_clearingAddress" type="text" style="width:250px;" class="ddtextbox" />
							</div>
						</div>
						<div class="hylist">
							<span class="ddlabel"><em>*</em>手机号码：</span>
							<div class="field">
								<div class="xgphone">
									<input type="text" maxlength="11" class="ddtextbox" id="person_orders_shippingAddr_clearingMobile"/> 
									<em style="color:#666666; margin-right:5px;">或</em> 
									<span>固定电话：</span>
									<input type="text" maxlength="20" class="ddtextbox" id="person_orders_shippingAddr_clearingTelephone"/>
								</div>
							</div>
						</div>
						<div class="hylist">
							<span class="ddlabel"><em>*</em>邮箱：</span>
							<div class="field">
								<input type="text" style="width:150px;" class="ddtextbox" id="person_orders_shippingAddr_clearingEmail"/>
							</div>
						</div>
						<div class="hylist2">
							<input type="checkbox" class="input-jz" id="person_orders_shippingAddr_clearingIsDefault"/>设为默认地址
						</div>
						<div class="group">
							<a class="btn-qd" href="javascript:addPesionNewAddr();">新增</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 页脚结束 -->
	<!-- footer begin -->
	<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
	<!-- footer end -->
	
	<!--买方信息修改-->
        <div id="shipingAddr_addr" class="splb splbxg" style=" visibility:hidden;z-index: 9999; top:30%; left:50%; margin-left:-400px; width:800px;">
			<div class="splb-title"><strong>收货人信息</strong><a href="javascript:stopsplbtitle('tanchu', 'shipingAddr_addr');" style="margin-left:10px; font-size:12px; color:#fff2b3">【关闭】</a></div>
				<div class="splb-content">
					<div class="sbox-wrap">
			  			<div class="form">
							<jsp:include page="/admin/carts/addr.jsp"></jsp:include>
							<div class="qrshdz">
								<a class="btn-submit" href="javascript:addNewAddr('shipingAddr_addr','1','');"><span>确认收货地址</span></a>
								<div style="display:none">正在提交信息，请等待！</div>
							</div>
						</div>
					</div>
				</div>
		</div>
  <!--买方信息修改结束-->
  <script type="text/javascript">
  
	function openMemberAddr(id){
		showsplbtitle('tanchu', 'shipingAddr_addr');
		$("#consignee-form").load("memberCallAction!loadReceiveAddr.action",{"receiveAddr.id":id});
	}
	
	function setDefaultAddr(id){
		$.ajax({
		type : "POST",
		url : "call/setDefaultAddr.html",
		data : "receiveAddr.id="+id,
		dataType : "JSON",
		success : function() {
			$("#memberCenter_person_orders_memberShippingAddr").load("memberCallAction!loadMemberShippingAddr.action",{"receiveAddr.id":id});
			
		}
	});
	}
	//删除收货地址
	function delAddr(id){
		$.ajax({
		type : "POST",
		url : "call/delAddr.html",
		data : "receiveAddr.id="+id,
		dataType : "JSON",
		success : function() {
			$("#memberCenter_person_orders_memberShippingAddr").load("memberCallAction!loadMemberShippingAddr.action",{"receiveAddr.id":id});
			
		}
	});
	}
  </script>
</body>
</html>