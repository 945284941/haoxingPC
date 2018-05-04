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
<script type=text/javascript src="js/tanchu.js"></script>
<script type=text/javascript src="js/register.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
var aa = '${sessionInfo.userType}';
$(function(){ 
		if(aa=='company'){
			window.location.href='person/order/sellOrders.html';
		}
	});
	
		function chankanwuliu(wuliu){
			$.ajax({
	            url: 'person/order/chakanwuliu.html',
	             type: 'post',
	            data : 'wuliu=' + wuliu,
	            dataType: "json",
	            success: function(messagew){
	            	var message = eval('('+messagew+')');
	            	var msg = '<div style="max-height:400px;overflow:auto;"><ul class="wuliuxinxi" style="max-height:70%;overflow-y:auto">';
	            	if(message.status == 0) {
		            	$.each(message.result.list,function(index,item){
		            		msg += '<li><p>'+item.status+'</p><p>'+item.time+'</p></li>';
		            	});
	            	}else {
	            		msg += '<li><p>'+message.msg+'</p></li>';
	            	}
	            	msg += '</ul></div>';
	            	layer.open({
	            		content:msg
	            	}) 
	            }
	        });
		}
		
	

	function dropOrder(orderId){
	if(confirm("确定要删除?删除后该订单不能恢复!")){
		    	$.ajax( {
						url : 'person/order/DropmyOrders.html',
						type : 'POST',
						data : 'id=' + orderId,
						success : function(data) {
							var r = $.parseJSON(data);
							if (r == 'ok') {
								alert('删除成功！');
								window.location.href = "person/order/myOrders.html";
							} else{
								alert('删除失败！');
								return false;
							}
				
						}
					});
	}
							   
	
	}
</script>
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
	<div class="breadThumb">首页 > 会员中心 > 电子商城 > 订单管理 > 我的订单</div>
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
				<span class="grmenubt">我的订单</span>
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
					<span style="width:373px; border-left:0">商品名称</span><span
						style="width:66px;">购买数量</span><span style="width:79px;">单价</span><span
						style="width:75px;">总价</span><span style="width:88px;">状态</span> <span
						style="width:75px;">评价</span><span style="width:205px;">操作</span>
				</div>
				<s:iterator var="o" value="orderList" status="status">
				
					<div class="sclb2">

						<span>订单编号：${o.orderNum}</span><span
						>下单时间：<s:date name="#o.createtime"
								format="yyyy-MM-dd HH:mm:ss" />
						</span> 
						<span >商家信息：<a class="dsjxx"
							href="Shop/index_${o.companyId}.html">${o.companyName}</a> </span>
						<span style="width:25px;">
						<s:if test=" #o.payStatus ==1 && #o.shipStatus ==1">
							<a href="javascript:void(0)"
							onclick="memberPayOrder('${o.id}','${o.orderNum }','${o.payMent }')">收货</a> 
						</s:if>
						</span>
					</div>
					<s:iterator var="i" value="#o.items" status="st">
					
						<div class="zxlb zxlb2 wddd sgh-wddd">
							<ul>
								<li class="lbtwo" style="height:32px; line-height:32px;"><a
									target="_Blank" href="goods/${i.goodsId}.html">
									<img
										src="${i.goodsPic}" />
								</a>
								</li>
								<li class="lbone" style="height:32px;"><a target="_Blank"
									href="goods/${i.goodsId}.html">${i.goodsName}(${i.itemSku })</a>
								</li>
								<li class="ddthree" style="height:32px; line-height:32px;">${i.nums
									}</li>
								<li class="ddfour" style="height:32px; line-height:32px;">￥${i.dealPrice}</li>
								<s:if test="#st.index ==0">
									<li class="ddfive" style="height:32px; line-height:32px;">￥${o.totalCost
										}</li>
									<li class="ddsix">
										<span class="s1" style=" display: block;width:90px; height:18px; text-align: center;">
											<s:if test="#o.payStatus ==0">未付款</s:if>
											<s:elseif test="#o.payStatus ==1">已付款</s:elseif>
											<s:elseif test="#o.payStatus ==2">待退款</s:elseif>
											<s:elseif test="#o.payStatus ==3">已退款</s:elseif>
											<s:elseif test="#o.payStatus ==4">已拒绝退款</s:elseif>
										</span>
										<span style=" display: block;width:90px; height:18px; text-align: center;">
											<s:if test="#o.shipStatus ==0">未发货</s:if> <s:elseif
												test="#o.shipStatus ==1">已发货</s:elseif> <s:elseif
												test="#o.shipStatus ==2">已收货</s:elseif> <s:elseif
												test="#o.shipStatus ==3">待退货</s:elseif> <s:elseif
												test="#o.shipStatus ==4">已退货</s:elseif>
										</span>
										<span style=" display: block;width:90px; height:18px; text-align: center;">
											<s:if test="#o.shipStatus ==1">
												<a target="_blank"
													onclick="chankanwuliu(${o.logisticsNum});"
													>查看物流</a>
											</s:if>
										</span>
									</li>
								</s:if>
								<s:else>
									<li class="ddfive" style="height:32px; line-height:32px;">-</li>
									<li class="ddsix" style="height:32px; line-height:32px;">-</li>
								</s:else>
								<s:if test="#st.index ==0">
									<li class="ddseven" style="height:32px; line-height:32px;">
										<!--已付款  --> <s:if test="#o.payStatus ==1">
											<!-- 已收货 -->
											<s:if test="#o.shipStatus ==2">
												<s:if test="#i.appraise ==0">
													<a
														onclick="memberEvaluateOnclick('${i.orderId}','${i.goodsId}','${i.companyId}');">未评价</a>
												</s:if>
												<s:else>
													<span>已评价</span>
												</s:else>
											</s:if>
											<!-- 未收货 -->
											<s:else>
												<s:if test="#i.appraise ==0">
													<span>未评价</span>
												</s:if>
												<s:else>
													<span>已评价</span>
												</s:else>
											</s:else>

										</s:if> <!-- 未付款 --> <s:else>
											<s:if test="#i.appraise ==0">
												<span>未评价</span>
											</s:if>
											<s:else>
												<span>已评价</span>
											</s:else>
										</s:else></li>
								</s:if>
								<s:else>

									<li class="ddseven" style="height:32px; line-height:32px;">
										<!--已付款  --> <s:if test="#o.payStatus ==1">
											<!-- 已收货 -->
											<s:if test="#o.shipStatus ==2">
												<s:if test="#i.appraise ==0">
													<a
														onclick="memberEvaluateOnclick('${i.orderId}','${i.goodsId}','${i.companyId}');">未评价</a>
												</s:if>
												<s:else>
													<span>已评价</span>
												</s:else>
											</s:if>
											<!-- 未收货 -->
											<s:else>
												<s:if test="#i.appraise ==0">
													<span>未评价</span>
												</s:if>
												<s:else>
													<span>已评价</span>
												</s:else>
											</s:else>

										</s:if> <!-- 未付款 --> <s:else>
											<s:if test="#i.appraise ==0">
												<span>未评价</span>
											</s:if>
											<s:else>
												<span>已评价</span>
											</s:else>
										</s:else></li>
								</s:else>
								<s:if test="#st.index ==0">
									<li class="ddeight" style="height:32px; line-height:32px;">
											<span class="wtk ddsh">退货/退款</span>
									</li>
								</s:if>
								<s:if test="#o.payStatus ==0">
									<li class="ddeight" style="height:32px; line-height:32px;">
												<a  onclick="dropOrder('${o.id}')"  href="javascript:void(0)">删除</a>
												<a href="payment!toPaymentType.action?orderId=${o.id}">去支付</a>
									</li>
								</s:if>
							
								<s:else>
									<li class="ddeight" style="height:32px; line-height:32px;">&nbsp;</li>
								</s:else>

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
	<!--签收弹出框begin-->
	<div id="shxx" class="aqmmtc" style=" visibility:hidden">
		<form action="person/order/receiveGoods.html" id="receiveGoodsFrom"
			method="post">
			<div class="tcgb">
				<a onclick="stopsplbtitle('tanchu', 'shxx');"><img
					src="images/memberimg/gb.gif" /> </a>
			</div>
			<p style="margin-left:70px; margin-top:30px; margin-bottom:20px;">
				<img src="images/memberimg/tc01.gif" />
			</p>
			<ul>
				<li><label>安全密码：</label></li>
				<li>
<!-- 					<input type="password" name="payPassword" id="payPassword" value="" />  -->
					<input type="hidden" name="order.id" id="payOrderId" value="" />
					<input type="hidden" name="order.orderNum" id="payOrderOrderNum" value="" />
					<input type="hidden" name="order.payMent" id="payMent" value="" />
				</li>
				<li><button type="button" class="tcqr" style="border: none;" id="receiptGoods">收货</button></li>
			</ul>
		</form>
	</div>
	<!--签收弹出框END-->
	<!--退货/退款弹出框begin-->
	<div id="thtk" class="aqmmtc aqmmtc_2" style=" visibility:hidden">
		<form action="person/order/returnOrder.html"
			id="memberReturnGoodsForm" method="post">
			<div class="tcgb" style="top:9px; right:15px;">
				<a onclick="stopsplbtitle('tanchu', 'thtk');"><img
					src="images/memberimg/gb.gif" /> </a>
			</div>
			<p class="thxqd">退货详情单</p>
			<p
				style="margin-left:50px; margin-top:15px; margin-right:50px;  background:#FFFFdd">
				<label class="laleft">单号： <input type="hidden"
					name="orderReturn.isdelivery" id="returnGoods_isdelivery" /> <input
					type="hidden" name="orderReturn.orderId" id="returnGoods_orderId" />
					<input type="hidden" id="returnGoods_orderTotal" /> </label><span
					id="returnGoods_orderIdSpan"></span>
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">退款金额：</label><input type="text"
					id="orderReturn_returnMoney" name="orderReturn.returnMoney"
					value="" onkeyup="clearNoNum(this)" />
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">物流单号：</label><input type="text"
					id="orderReturn_logisticsNum" name="orderReturn.logisticsNum"
					value="" />
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">物流公司：</label><input type="text"
					id="orderReturn_logisticsName" name="orderReturn.logisticsName"
					value="" />
			</p>
			<p style="margin-left:50px; margin-top:10px; margin-bottom:15px;">
				<label class="laleft">物流电话：</label><input type="text"
					id="orderReturn_logisticsTel" name="orderReturn.logisticsTel"
					value="" />
			</p>
			<p style="margin-left:50px; height:100px; margin-bottom:20px;">
				<label class="laleft" style=" float:left;">退货/退款原因：</label>
				<textarea id="orderReturn_cause" name="orderReturn.cause"
					class="textyy"></textarea>
			</p>
			<p style="margin-left:200px; margin-top:20px; clear: both">
				<a class="tcqr" onclick="returnGoodsSubmit();">确认提交</a>
			</p>
		</form>
	</div>
	<!--退货/退款弹出框end-->
	<div id="tctk" class="aqmmtc" style=" visibility:hidden">
		<div class="tcgb">
			<a onclick="stopsplbtitle('tanchu', 'tctk');"><img
				src="images/memberimg/gb.gif" /> </a>
		</div>
		<p
			style="margin-left:40px; padding-left:40px; line-height:30px; font-size:20px;color:#666666; font-weight:bold; width:470px; margin-top:30px; margin-bottom:10px; background:url(images/memberimg/aqxq02.gif) no-repeat left top;">
			您的退货/退款申请已提交至商家，待商家收到要退的货物后，您的货款预计在<span style="color:#f77e00">三个工作日内</span>返还！
		</p>
		<p style="margin-left:230px">
			<a class="tcqr">已阅关闭</a>
		</p>
	</div>
	<!--评价弹出框begin-->
	<div id="pjnr" class="tcpj" style="visibility: hidden;">
		<form action="person/order/evaluateGoods.html" id="memberEvaluateFrom"
			method="post">
			<h2>
				<span>评价内容</span><a onclick="stopsplbtitle('tanchu', 'pjnr');">【关闭】</a>
			</h2>
			<p class="pjcontent">
				<input type="hidden" name="appraise.orderId"
					id="member_evaluate_orderId" /> <input type="hidden"
					name="appraise.goodsId" id="member_evaluate_goodsId" /> <input
					type="hidden" name="appraise.companyId"
					id="member_evaluate_companyId" />
				<textarea id="member_evaluate_appraise" name="appraise.content"
					cols="" rows=""
					onBlur="if(this.innerHTML==''){this.innerHTML='请在此处填写你对商品的评价……';this.style.color='#D1D1D1'}"
					style="COLOR: #d1d1d1"
					onFocus="if(this.innerHTML=='请在此处填写你对商品的评价……'){this.innerHTML='';this.style.color='#000'}">请在此处填写你对商品的评价……</textarea>
			</p>
			<div class="tcmjpj">
				<h2>卖家评级</h2>
				<p style="color:#b0080e">
					<span>服务评级<input type="hidden" id="member_evaluate_serve"
						name="appraise.serve" />
					</span> <span><a onclick="memberEvaluate('serve','-1');"><img
							id="serve1" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span><a onclick="memberEvaluate('serve','0');"><img
							id="serve2" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span><a onclick="memberEvaluate('serve','1');"><img
							id="serve3" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span id="serveType"></span>
				</p>
				<p style="color:#00589d">
					<span>质量评级<input type="hidden" id="member_evaluate_quality"
						name="appraise.quality" />
					</span> <span><a onclick="memberEvaluate('quality','-1');"><img
							id="quality1" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span><a onclick="memberEvaluate('quality','0');"><img
							id="quality2" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span><a onclick="memberEvaluate('quality','1');"><img
							id="quality3" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span id="qualityType"></span>
				</p>
				<p style="color:#e45e00">
					<span>信誉评级<input type="hidden" id="member_evaluate_credit"
						name="appraise.credit" />
					</span> <span><a onclick="memberEvaluate('credit','-1');"><img
							id="credit1" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span><a onclick="memberEvaluate('credit','0');"><img
							id="credit2" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span><a onclick="memberEvaluate('credit','1');"><img
							id="credit3" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span id="creditType"></span>

				</p>
				<p style="color:#72a023">
					<span>物流评级<input type="hidden"
						id="member_evaluate_logistics" name="appraise.logistics" />
					</span> <span><a onclick="memberEvaluate('logistics','-1');"><img
							id="logistics1" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span><a onclick="memberEvaluate('logistics','0');"><img
							id="logistics2" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span><a onclick="memberEvaluate('logistics','1');"><img
							id="logistics3" src="images/memberimg/pjdj2.gif" />
					</a>
					</span> <span id="logisticsType"></span>
				</p>
			</div>
			<div
				style="margin-left:15px; margin-bottom:20px; margin-top:10px; position:relative">
				<a onclick="memberEvaluateSubmit();" class="tcqr"
					style="color: #333333">保存评价</a>
			</div>
		</form>
	</div>
	<!--评价弹出框结束-->
	<div id="mjs:tip" class="tip" style="position:absolute;left:0;top:0;display:none;"></div>
	<!-- footer begin -->

<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
	<!-- footer end -->
	<!-- 页脚结束 -->
	<script type="text/javascript">
		//会员点击收货操作
		 function memberPayOrder(orderId,orderNum,payMent){
		 
// 			$("#payPassword").val("");
			$("#payOrderId").val(orderId);
			$("#payOrderOrderNum").val(orderNum);
			$("#payMent").val(payMent);
			confirm("确认收货") ? $("#receiveGoodsFrom").submit() : "" ;
// 			showsplbtitle('tanchu', 'shxx');
		} 

		//会员点击评价操作
		function memberEvaluateOnclick(orderId, goodsId, companyId) {
			$("#member_evaluate_orderId").val(orderId);
			$("#member_evaluate_goodsId").val(goodsId);
			$("#member_evaluate_companyId").val(companyId);
			showsplbtitle('tanchu', 'pjnr');
		}

		//会员进行等级平均
		function memberEvaluate(type, evaluate) {
			if (evaluate == 1) {//好评
				$("#" + type + "1").attr("src", "images/memberimg/pjdj.gif");
				$("#" + type + "2").attr("src", "images/memberimg/pjdj.gif");
				$("#" + type + "3").attr("src", "images/memberimg/pjdj.gif");
				$("#" + type + "Type").html("好评");
			} else if (evaluate == 0) {//中评
				$("#" + type + "1").attr("src", "images/memberimg/pjdj.gif");
				$("#" + type + "2").attr("src", "images/memberimg/pjdj.gif");
				$("#" + type + "3").attr("src", "images/memberimg/pjdj2.gif");
				$("#" + type + "Type").html("中评");
			} else {//差评
				$("#" + type + "1").attr("src", "images/memberimg/pjdj.gif");
				$("#" + type + "2").attr("src", "images/memberimg/pjdj2.gif");
				$("#" + type + "3").attr("src", "images/memberimg/pjdj2.gif");
				$("#" + type + "Type").html("差评");
			}
			$("#member_evaluate_" + type).val(evaluate);
		}

		function memberEvaluateSubmit() {
			var evaluate = $("#member_evaluate_appraise").val();
			var serve = $("#member_evaluate_serve").val();
			var quality = $("#member_evaluate_quality").val();
			var credit = $("#member_evaluate_credit").val();
			var logistics = $("#member_evaluate_logistics").val();
			if (evaluate == null || evaluate == ''
					|| evaluate == '请在此处填写你对商品的评价……') {
				alert('请对商品填写评价内容！');
			} else if (serve == null || serve == '') {
				alert('请对服务评级进行评价！');
			} else if (quality == null || quality == '') {
				alert('请对质量评级进行评价！');
			} else if (credit == null || credit == '') {
				alert('请对信誉评级进行评价！');
			} else if (logistics == null || logistics == '') {
				alert('请对物流评级进行评价！');
			} else {
				$("#memberEvaluateFrom").submit();
			}
		}

		//点击申请退货
		function returnGoodsOnclick(orderId,orderNum, shipStatus, orderTotal) {
			$("#returnGoods_orderId").val(orderId);
			$("#returnGoods_isdelivery").val(shipStatus);
			$("#returnGoods_orderTotal").val(orderTotal);
			$("#returnGoods_orderIdSpan").html(orderNum);
			showsplbtitle('tanchu', 'thtk');
		}

		// 提交退款退货
		function returnGoodsSubmit() {
			var returnMoney = $("#orderReturn_returnMoney").val();
			var logisticsNum = $("#orderReturn_logisticsNum").val();
			var logisticsName = $("#orderReturn_logisticsName").val();
			var logisticsTel = $("#orderReturn_logisticsTel").val();
			var cause = $("#orderReturn_cause").val();
			var orderTotal = $("#returnGoods_orderTotal").val();
			var shipType = $("#returnGoods_isdelivery").val();
			if (returnMoney == null || returnMoney == '') {
				alert("请填写需要退款金额！");
			} else if (returnMoney > orderTotal) {
				alert("退款金额不得超过订单总金额");
			} else if (shipType == "1"
					&& (logisticsNum == null || logisticsNum == '')) {
				alert("退回货物的物流单号不能为空！");
			} else if (shipType == "1" && (logisticsName == null || logisticsName == '')) {
				alert("退回货物的物流公司不能为空！");
			} else if (shipType == "1" && (logisticsTel == null || logisticsTel == '')) {
				alert("退回货物的物流公司电话不能为空！");
			} else if (cause == null || cause == '') {
				alert("请填写退款、退货的原因！");
			} else {
				$("#memberReturnGoodsForm").submit();
			}

		}
	</script>
</body>
</html>