<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<link href="css/hyzxdp.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/tanchu.js"></script>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript>
function bjPrice(bjvalue,itemid,orderid){
		$("#"+bjvalue).attr("disabled",false);
		var html = '';
		html = '<a href="javascript:void(0)"  style="color:#c00f17;" onclick="bcPrice(\''+bjvalue+'\',\''+itemid+'\',\''+orderid+'\');">确认</a>';
		$("#bjbc"+bjvalue).html(html);
}
function bcPrice(bjvalue,itemid,orderid){
		var bcvalue = $("#"+bjvalue).val();
		var reg = /^-?\d+\.?\d{0,2}$/;
		if(!reg.test(bcvalue)){
			$("#"+bjvalue).focus();
			alert("修改的单价只可输入两位小数的数字！");
			return false;
		}else{
			$("#"+bjvalue).attr("disabled",true);
			$.ajax( {
						url : 'person/order/sellOrderChItemModifyPrice.html',
						type : 'POST',
						data : 'bcvalue='+bcvalue+'&orderItemId='+itemid,
						success : function(data) {
							var r = $.parseJSON(data);
							if (r == 'no') {
								alert('修改失败！');
							} else if(r == 'ok'){
								alert('修改成功！');
							} else if(r == 'error'){
								alert('折扣金额不能大于交易总金额！');
							}
							window.location.href = "person/order/sellChOrderItem/"+orderid+".html";
						
						}
					});
		}					

}
</script>
<div id="tanchu"></div>
</head>
<body>
	<!-- 头部开始 -->
	<div class="header">
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	</div>
	<div class="logo">
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	</div>
	<div id="warp">
		<jsp:include page="/memberCenter/common/navigation.jsp" />
	</div>
	<!-- 头部结束 -->
	<!-- 页脚开始 -->
	<div class="dht">
		<a href="#">首页</a> > <a href="#">企业会员中心</a> > <a href="#">商品列表</a>
	</div>
	<div class="gzgz">
		<div class="hyleft">
			<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
		</div>
		<div class="shop" >
			<div class="splb"  >
				<h2>商品列表</h2>
				<ul>
					<li class="mc">商品名称</li>
					<li class="mc">商品货号</li>
					<li class="mc">市场价</li>
					<li >成交单价</li>
					<li >购买数量</li>
					<li style="width:152px;">金额小计</li>
					<!--  <li class="cz">操作</li>-->
				</ul>
				<div style="clear:both"></div>
				<s:iterator var="item" value="orderItems" status="status">
					<div class="cplb">
						<div class="cc cplbname">
							<div class="p-img">
								<a target="_blank" href="goods/${item.goodsId}.html"><img alt="${item.goodsName}" src="${item.goodsPic}" width="40" height="40" /></a>
							</div>
							<div class="p-name">
								<a target="_blank" href="goods/${item.goodsId}.html">${item.goodsName}</a>
							</div>
						</div>
						<div class="cc cplbname">
							<span class="price">${item.bn}</span>
						</div>
						<div class="cc cplbprice" style="width:195px;">
							<span class="price">￥${item.marketbalePrice}</span>
						</div>
						<div class="cc cplbprice">
							<span class="price">￥${item.dealPrice}
							<!--  <input id='${status.index+1}' style='text-align:center; width:60px;margin-top: 5px;' disabled='disabled' value='${item.dealPrice}'></input>-->
							
							</span>
						</div>

						<div class="cc cplbprice">
							<span class="price" id='itemNums${status.index+1}'>${item.nums}</span>
						</div>
						
						<div class="cc cplbprice" style="width:152px;">
							<span class="price" style="color:#c00f17" id='itemAcount${status.index+1}'>￥${item.amount}</span>
						</div>
						<!--  
						<div class="cc xj">
							<span class="price" id="bjbc${status.index+1}">
								<a id="bj"  style="color:#c00f17" onclick="bjPrice('${status.index+1}','${item.id}','${item.orderId}');">修改价格</a>
							</span>
						</div>
						-->
						<div style="clear:both"></div>
					</div>
				</s:iterator>


				<div class="zj">
					<span class="zjje">订单总金额：<strong style="color:#c00f17" id="orderTotal">￥${order.totalCost}</strong>
					</span>
				</div>
			</div>
			<div class="splb splbtwo">
				<h2>买方留言</h2>
				${order.remark}
				
				
				
			</div>
			<div class="splb splbtwo">
				<h2>基本信息</h2>
				<div class="cplb">
					<div class="cc name">
						<span class="price">订单号</span>
					</div>
					<div class="cc lb">
						<span class="price">${order.orderNum}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name">
						<span class="price">订单状态</span>
					</div>
					<div class="cc lb">
						<span class="price">
							<s:if test="order.payStatus ==0">未付款</s:if>
							<s:elseif test="order.payStatus ==1">已付款</s:elseif>
							<s:elseif test="order.payStatus ==2">
								<s:if test="order.shipStatus==0 || order.shipStatus ==4"><a onclick="OpenReturnPay('${order.id}');" style="color: red;">待退款</a></s:if>
								<s:else>待退款</s:else>
							</s:elseif>
							<s:elseif test="order.payStatus ==3">已退款</s:elseif>
							<s:elseif test="order.payStatus ==4">已拒绝退款</s:elseif>
						
						</span>
						<span class="price">
							<s:if test="order.shipStatus ==0">
								<s:if test="order.payStatus ==3">未发货</s:if>
								<s:else><a style="color: red;" onclick="deliverShip('${order.id}','${order.shipName}','${order.shipTel}','${order.pname}${order.cname}${order.aname}${order.address}');">未发货</a></s:else>
							</s:if>
							<s:elseif test="order.shipStatus ==1">已发货</s:elseif>
							<s:elseif test="order.shipStatus ==2">已收货</s:elseif>
							<s:elseif test="order.shipStatus ==3"><a onclick="OpenReturnShip('${order.id}');" style="color: red;">待退货</a></s:elseif>
							<s:elseif test="order.shipStatus ==4">已退货</s:elseif>
						</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb" style="display: none;">
					<div class="cc name">
						<span class="price">买方账号</span>
					</div>
					<div class="cc lb">
						<span>0531-86541222</span><span>15865418888</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name">
						<span class="price">下单时间</span>
					</div>
					<div class="cc lb">
						<span class="price"><s:date name="order.createtime" format="yyyy-MM-dd HH:mm:ss"/></span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name">
						<span class="price">支付方式</span>
					</div>
					<div class="cc lb">
						<span class="price"><s:if test="order.payMent == 0">网上支付</s:if><s:elseif test="order.payMent == 1">现金代收</s:elseif> </span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name">
						<span class="price">付款时间</span>
					</div>
					<div class="cc lb">
						<span class="price"><s:if test="order.payTime != null"><s:date name="order.payTime" format="yyyy-MM-dd HH:mm:ss"/></s:if><s:else>未付款</s:else></span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name">
						<span class="price">配送方式${order.isDelivery}</span>
					</div>
					<div class="cc lb">
						<span class="price">
						<c:choose>
							<c:when test="${order.isDelivery=='N' }">物流</c:when>
							<c:when test="${order.isDelivery=='Y' }">上门自提</c:when>
							<c:otherwise>
								--
							</c:otherwise>
						</c:choose>
						</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name">
						<span class="price">发货时间</span>
					</div>
					<div class="cc lb">
						<span class="price"><s:if test="order.shipTime != null"><s:date name="order.shipTime" format="yyyy-MM-dd HH:mm:ss"/></s:if><s:else>未发货</s:else></span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc larst name">
						<span class="price">发货单号</span>
					</div>
					<div class="cc larst lb">
						<span class="price">${order.logisticsNum }</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc larst name">
						<span class="price">物流公司名称</span>
					</div>
					<div class="cc larst lb">
						<span class="price">${order.logisticsName }</span>
					</div>
					<div style="clear:both"></div>
				</div>
			</div>
			<!--买方信息开始-->
			<div class="splb splbtwo">
				<h2>买方信息</h2>
				<div class="cplb">
					<div class="cc name">
						<span class="price">收货人姓名</span>
					</div>
					<div class="cc lb">
						<span class="price">${order.shipName}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name">
						<span class="price">详细地址</span>
					</div>
					<div class="cc lb">
						<span class="price">${order.pname}${order.cname}${order.aname}${order.address}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name">
						<span class="price">联系电话</span>
					</div>
					<div class="cc lb">
					<s:if test="order.order.shipTel != null"></s:if>
						<span>${order.shipTel}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc larst name">
						<span class="price">邮政编码</span>
					</div>
					<div class="cc larst lb">
						<span class="price">${order.shipZip}</span>
					</div>
					<div style="clear:both"></div>
				</div>
			</div>
			<div class="splb splbtwo">
				<h2>其他信息</h2>
				<div class="cplb">
					<div class="cc name">
						<span class="price">发票类型</span>
					</div>
					<div class="cc lb">
						<span class="price">${order.billType}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name">
						<span class="price">发票抬头</span>
					</div>
					<div class="cc lb">
						<span class="price">${order.billHead}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
					<div class="cc name">
						<span class="price">发票内容</span>
					</div>
					<div class="cc lb">
						<span>${order.billContent}</span>
					</div>
					<div style="clear:both"></div>
				</div>
				
			</div>
		</div>
		<div style="clear:both"></div>
	</div>
	<div class="gg">
		<a href="/"><img src="/images/memberimg/tlgg1.gif" /> </a>
	</div>
	<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
	<!-- footer end -->
	<!-- 页脚结束 -->
	<!--待退款弹出框begin-->
	<div id="sellOrderItem_returnPay_alert" class="aqmmtc aqmmjjty" style=" visibility:hidden;height:170px;">
		<form action="company/order/rejectReturnPay.html" id="sellOrderItemReturnPayFrom" method="post">
			<div class="tcgb">
				<a onclick="stopsplbtitle('tanchu', 'sellOrderItem_returnPay_alert');"><img src="/images/memberimg/gb.gif" /> </a>
			</div>
			<p style="margin-left:70px; margin-top:30px; margin-bottom:20px;">
				<img src="/images/memberimg/tc01js.gif" />
			</p>
			<ul>
				<li><label>支付密码：</label>
				</li>
				<li><input type="password" name="payPassword" id="sellOrderItem_returnPay_payPassword" value="" />
					<input type="hidden" id="sellOrderItem_returnPay_orderId" name="order.id" />
				</li>				
			</ul>
			<div style="width:500px;float:left;">
			<p style="width:320px; padding-left:180px;padding-top:10px;">
				<span style="width:100px;float:left;"><a onclick="returnPay('no');" class="tcqrjj" style="color: #000;text-decoration: none;">拒绝</a></span>
				<span style="width:100px;float:left;"><a onclick="returnPay('ok');" class="tcqrty" style="color: #000;text-decoration: none;">同意</a></button>
				</span></p>			
			</div>
		</form>
	</div>
	<!--待退货弹出框begin-->
	<div id="sellOrderItem_returnShip_alert" class="aqmmtc aqmmjjty" style=" visibility:hidden;height:170px;">
		<form action="company/order/rejectReturnShip.html" id="sellOrderItemReturnShipFrom" method="post">
			<div class="tcgb">
				<a onclick="stopsplbtitle('tanchu', 'sellOrderItem_returnShip_alert');"><img src="/images/memberimg/gb.gif" /> </a>
			</div>
			<p style="margin-left:70px; margin-top:30px; margin-bottom:20px;">
				<img src="/images/memberimg/tc01.gif" />
			</p>
			<ul>
				<li><label>支付密码：</label>
				</li>
				<li><input type="password" name="payPassword" id="sellOrderItem_returnShip_payPassword" value="" />
					<input type="hidden" name="order.id" id="sellOrderItem_returnShip_orderId" value="" />
				</li>
				<li><a class="tcqr" onclick="returnShip();">确认</a>
				</li>
			</ul>
		</form>
	</div>
	<!--发货弹出框begin-->
	<div id="sellOrderItem_deliverShip_alert" class="aqmmtc aqmmtc_2" style=" visibility:hidden">
		<form action="company/order/deliverShip.html" id="sellOrderItemDeliverShipFrom" method="post">
			<div class="tcgb" style="top:9px; right:15px;">
				<a onclick="stopsplbtitle('tanchu', 'sellOrderItem_deliverShip_alert');"><img src="/images/memberimg/gb.gif" /> </a>
			</div>
			<p class="thxqd">发货详情单</p>
			<p style="margin-left:50px; margin-top:15px; margin-right:50px;">
				<input id="sellOrderItem_deliverShip_orderId" type="hidden" name="order.id"/>
				<label class="laleft">收货人姓名： </label><span style="margin-left:8px;" id="sellOrderItem_deliverShip_shipName"></span>
			</p>
			<p style="margin-left:50px; margin-top:15px; margin-right:50px;">
				<label class="laleft">收货人电话： </label><span style="margin-left:8px;" id="sellOrderItem_deliverShip_shipTel"></span>
			</p>
			<p style="margin-left:50px; margin-top:15px; margin-right:50px;">
				<label class="laleft" style="float:left">收货人地址： </label><span id="sellOrderItem_deliverShip_shipAddr" style="margin-left:8px; float:left; width:250px;"></span>
				<div style="clear: both"></div>
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">发货单号：</label><input type="text" id="deliverShip_logisticsNum" name="order.logisticsNum" value="" onkeyup="clearNoNum(this)"/>
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">物流公司名称：</label><input type="text" id="deliverShip_logisticsName" name="order.logisticsName" value="" />
			</p>
			<p style="margin-left:50px; margin-top:15px;">
				<label class="laleft">物流公司电话：</label><input type="text" id="deliverShip_logisticsTel" name="order.logisticsTel" value="" />
			</p>
			<p style="margin-left:200px; margin-top:20px; clear: both">
				<a class="tcqr" onclick="deliverShipSubmit();">确认提交</a>
			</p>
		</form>
	</div>
	<script type="text/javascript">
		//打开退款窗口
		function OpenReturnPay(orderId){
			$("#sellOrderItem_returnPay_orderId").val(orderId);
			showsplbtitle('tanchu', 'sellOrderItem_returnPay_alert');
		};
		//打开退货窗口
		function OpenReturnShip(orderId){
			$("#sellOrderItem_returnShip_orderId").val(orderId);
			showsplbtitle('tanchu', 'sellOrderItem_returnShip_alert');
		};
		//打开发货窗口
		function deliverShip(orderId,shipName,shipTel,shipAddr){
			$("#sellOrderItem_deliverShip_orderId").val(orderId);
			$("#sellOrderItem_deliverShip_shipName").html(shipName);
			$("#sellOrderItem_deliverShip_shipTel").html(shipTel);
			$("#sellOrderItem_deliverShip_shipAddr").html(shipAddr);
			showsplbtitle('tanchu', 'sellOrderItem_deliverShip_alert');
		};
		//  拒绝/同意退款
		function returnPay(type){
			$.ajax({  
			     type:'post',  
			     url:'company/order/rejectReturnPay.html',  
			     dataType:'json', 
			     data:{"type":type,
			     		"order.id":$("#sellOrderItem_returnPay_orderId").val(),
			     		"password":$("#sellOrderItem_returnPay_payPassword").val()
			     }, 
			     success:function(j){ 
			     	if(j.success){
			     		window.location.reload();
			     	}else{
			     		alert(j.msg);
			     	}
			     	
				 }
		    });
		};
		//  确认收到退款
		function returnShip(){
			$.ajax({  
			     type:'post',  
			     url:'company/order/rejectReturnShip.html',  
			     dataType:'json', 
			     data:{	"order.id":$("#sellOrderItem_returnShip_orderId").val(),
			     		"password":$("#sellOrderItem_returnShip_payPassword").val()
			     }, 
			     success:function(j){ 
			     	if(j.success){
			     		window.location.reload();
			     	}else{
			     		alert(j.msg);
			     	}
			     	
				 }
		    });
		};
		
		//提交发货单
		function deliverShipSubmit(){
			logisticsNum = $("#deliverShip_logisticsNum").val();
			logisticsName = $("#deliverShip_logisticsName").val();
			logisticsTel = $("#deliverShip_logisticsTel").val();
			if(logisticsNum == null || logisticsNum == ''){
				alert("发货单号不能为空！");
			}else if(logisticsName == null || logisticsName == ''){
				alert("物流公司名称不能为空！");
			}else if(logisticsTel == null || logisticsTel == ''){
				alert("物流公司电话不能为空！");
			}else {
				if (confirm("是否确认发货?确认发货后不能修改发货信息！")){
					$("#sellOrderItemDeliverShipFrom").submit();
				};
			}
		}
	</script>
</body>

</html>