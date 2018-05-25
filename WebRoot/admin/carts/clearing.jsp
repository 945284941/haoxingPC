<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SessionInfo sessionInfo = (SessionInfo)session.getAttribute(ResourceUtil.getSessionInfoName());
	String memberId = sessionInfo==null?"":sessionInfo.getUserId();
	String addressId = sessionInfo.getAddressMap().get("addressId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<jsp:include page="/admin/common/keyWords.jsp" />
	<meta http-equiv="x-ua-compatible" content="ie=7" />
	<link href="css/master.css" rel="stylesheet" type="text/css" />
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/news.css" rel="stylesheet" type="text/css" />
	<link href="css/shop.css" rel="stylesheet" type="text/css" />

	<title>颐佳官方商城</title>
	<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="js/slides.jquery.js"></script>
	<script type="text/javascript">


	</script>
	<!-- 解决IE6不缓存背景图片的问题-->
	<!--[if IE 6]>
	<script type="text/javascript">
		document.execCommand("BackgroundImageCache", false, true);
	</script>
	<![endif]-->
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<s:action name="catalogueAction!queryFullCategory" executeResult="true" namespace="/" >
	<s:param name="catType">cs</s:param>
</s:action>



<div class="main">
	<div class="lh_wdgwc">
		<div class="lh_wdgwc_top fl">
			<span class="fl">填写并核对订单信息</span>
			<ul class="lh_wdgwc_top_right fr">
				<li>1.我的购物车</li>
				<li class="cartcur">2.确认订单</li>
				<li>3.支付订单</li>
			</ul>
		</div>
		<div class="order-address addr-much" id="address_1">

			<input type="hidden" id="oldCountryId" name="oldCountryId" value="<%=addressId%>"/>

			<div class="list">

				<c:if test="${not empty receiveAddr and not empty receiveAddr.id}">
				<div id="${receiveAddr.id}" nowCountryId="${receiveAddr.countryId}" class="addr suggest-address addr-cur addr-def">
					<div class="inner">
						<div class="addr-hd" title="">
							<span class="prov">
								<c:if test="${'zh' eq sessionInfo.language}">
									${receiveAddr.countryName}
								</c:if>
								<c:if test="${'zh' ne sessionInfo.language}">
									${receiveAddr.countryEnName}
								</c:if>
							</span>
							<span>（</span>
							<span class="name">${receiveAddr.receiveName}</span>
							<span> 收）</span>
						</div>

						<div class="addr-bd">
							<span class="addr4tip">${receiveAddr.receiveAddress}</span>
							<span class="street">${receiveAddr.mobile}</span>
							<span class="last">&nbsp;</span>
						</div>

					</div>
					<div class="curMarker"></div>
				</div>
				</c:if>
				<c:forEach items="${raList}" varStatus="status" var="ad">
				<div id="${ad.id}" nowCountryId="${ad.countryId}" class="addr suggest-address">
					<div class="inner">
						<div class="addr-hd" title="">
							<span class="prov">
								<c:if test="${'zh' eq sessionInfo.language}">
									${ad.countryName}
								</c:if>
								<c:if test="${'zh' ne sessionInfo.language}">
									${ad.countryEnName}
								</c:if>
							</span>
							<span>（</span>
							<span class="name">${ad.receiveName}</span>
							<span> 收）</span>
						</div>

						<div class="addr-bd">
							<span class="addr4tip">${ad.receiveAddress}</span>
							<span class="street">${ad.mobile}</span>
							<span class="last">&nbsp;</span>
						</div>

					</div>
					<div class="curMarker"></div>
				</div>
				</c:forEach>
			</div>
		</div>
		<div class="control" >
			<a class="manageAddr" href="loadReceiveAddr.html" >管理收货地址</a>
		</div>

		<div class="lh_wdgwc_cszdsp">
			<ul>
				<div class="lh_wdgwc_w-bond">
					<div class="lh_wdgwc_w-bond-title">
						<p class="lh_wdgwc_w-title-name3 fl">商品清单</p>
						<p class="lh_wdgwc_w-title-mony3 fr" style="text-align: right;margin-right: 10px;"><a href="call/goToCart.html">返回购物车></a></p>
					</div>
				</div>
				<div class="lh_wdgwc_w-bond" style="padding: 0px;">
					<div class="lh_wdgwc_w-bond-title">
						<p class="lh_wdgwc_w-title-name3" style="text-align: center;">商品</p>
						<p class="w-title-time3" style="margin-left: 80px;">单价</p>
						<p class="lh_wdgwc_w-title-time3">数量</p>
						<p class="lh_wdgwc_w-title-time3">小计</p>
					</div>
				</div>
				<div class="lh_wdgwc_w-bond-jd">
					<div class="lh_wdgwc_w-bond-jd_bt">
						<span>商家名称：${companyName} </span>
					</div>
					<div class="lh_wdgwc_w-bond-jd_jrdp">
						<a href="shopDetail/${companyId}/1.html">进入店铺></a>
					</div>
				</div>
				<c:forEach items="${carts}" var="cart" varStatus="status1">
					<div class="lh_wdgwc_w-bond-list1 fl" style=" border-top:2px solid #d6cfcf">
						<div class="lh_wdgwc_w-bond-info1">
							<div class="lh_wdgwc_w-bond-16">
								<div class="lh_wdgwc_w-bond-img1 fl">
									<a href="goods/${cart.goods.id}.html"><img src="${cart.goods.defaultPicSrc}" /></a>
								</div>
								<div class="lh_wdgwc_w-bond-name1 fl">
									<a href="goods/${cart.goods.id}.html">${cart.goods.name}</a>
									<span><i>${cart.goodsItem.skuJsonHz}</i></span>
								</div>
								<div class="w-clear"></div>
							</div>
							<div class="lh_wdgwc_w-bond-17">
								<span>
									<c:if test="${isOneBuy eq '0'and (cart.goods.isGroup eq '1' or cart.goods.isFlashSale eq '1') }">
										<fmt:formatNumber type="number" value="${cart.goodsItem.price * cart.goods.saleRate * cart.goods.activityPrice}" pattern="0.00" maxFractionDigits="2"/>
									</c:if>
									<c:if test="${empty isOneBuy or isOneBuy eq '1'}">
										<fmt:formatNumber type="number" value="${cart.goodsItem.price * cart.goods.saleRate}" pattern="0.00" maxFractionDigits="2"/>
									</c:if>

								</span>
							</div>
							<div class="lh_wdgwc_w-bond-18">
								${cart.goodsNum}
							</div>
							<div class="lh_wdgwc_w-bond-19">${payPrice}</div>
							<div class="w-clear"></div>
						</div>
					</div>
				</c:forEach>
				<div class="lh_wdgwc_w-bond" style=" padding: 0px;">
					<div class="lh_wdgwc_w-bond-title01">
						<p class="lh_wdgwc_w-title-name33 fl">给卖家留言
							<input  class="q1" name="memberLeaveMsg" id="memberLeaveMsg" type="text" value="对本次交易的说明" style="border: 0px; background: none;">
						</p>
					</div>
				</div>
				<div class="lh_wdgwc_tjdd_zong">
					<div class="lh_wdgwc_tjdd">
						<p>
							<span>共<i>${carts.size()}</i>件商品</span>
						</p>
						<p>
							<span>应付金额：(含税)</br>
								<i style="font-size: 24px;">￥${payPrice}</i></br>
							<i style="font-size: 24px;">$${payDocPrice}</i></br>
							<i style="font-size: 24px;">AED ${payDlmPrice}</i></br>
							</span>
						</p>
					</div>
					<div class="lh_wdgwc_tjdd_tjan">
						<a href="javascript:subOrder();">提交订单</a>
					</div>
				</div>

			</ul>
		</div>

	</div>
</div>
<form id="toPay" action="payment/toPayment.html" method="post">
	<input type="hidden" id="orderId" name="orderId"/>
</form>
<form id="subForm" action="" method="post">
	<input type="hidden" name="orderMsg" id="orderMsg" />
	<input type="hidden" id="receiveAddrId" name="receiveAddrId" value=""/>
	<input type="hidden" id="goodsItemIds" name="goodsItemIds" value="${goodsItemIds}"/>
	<input type="hidden" id="countryId" name="countryId" value=""/>
	<input type="hidden" id="nowBuyNum" name="nowBuyNum" value="${nowBuyNum}"/>
	<input type="hidden" id="isOneBuy" name="isOneBuy" value="${isOneBuy}"/>
	<input type="hidden" id="isNowBuy" name="isNowBuy" value="${isNowBuy}"/>
</form>
<jsp:include page="../../admin/common/indexFooter.jsp" />
<script type="text/javascript">
	$(function(){
		$("#address_1 div.list div").click(function(){
			$(this).addClass("addr-cur").siblings("div").removeClass("addr-cur");
			$(this).addClass("addr-def").siblings("div").removeClass("addr-def");
			$("#receiveAddrId").val(this.id);
			var cId = $(this).attr("nowCountryId");
			$("#countryId").val(cId);

		})
	})
	//是否选中了地址
	function checkClickAddress() {
		var flag = false;
		if('' != $("#receiveAddrId").val()){
			flag = true;
		}
		return flag;
	}
	//是否更改了国家
	function changeAddress(){
		var nowCountryId = $("#countryId").val();
		var oldCountryId = $("#oldCountryId").val();
		if(nowCountryId != oldCountryId){
			return false;
		}else{
			return true;
		}
	}
	function subOrder(){

		//是否选中了地址
		if(checkClickAddress()){
			if(changeAddress()){
				var memberLeaveMsg = $("#memberLeaveMsg").val();
				$("#orderMsg").val(memberLeaveMsg);
				$.ajax({
					url:"call/submitOrder.html",
					data:$("#subForm").serialize(),
					type:"POST",
					success:function(_data){
						console.log(_data);
						var obj = JSON.parse(_data);
						if(obj.msg == "000"){
							alert("提交订单成功，去支付吧！");
							$("#orderId").val(obj.orderId);
							$("#toPay").submit();
						}else{
							alert("提交订单失败，请联系系统管理员！");
							return false;
						}
					}
				});
//				$.post("call/submitOrder.html",$("#subForm").serialize(),function (_data) {
//
//				})

			}else{
				alert("您目前的地址与确认订单中商品所属国家不一致，请重新选择地址！");
				return false;
			}
		}else{
			alert("请选择收货地址！");
			return false;
		}

	}
</script>
</body>
</html>
