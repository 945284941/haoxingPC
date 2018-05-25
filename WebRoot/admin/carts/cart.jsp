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
			<span class="fl">我的购物车</span>
			<ul class="lh_wdgwc_top_right fr">
				<li class="cartcur">1.我的购物车</li>
				<li>2.确认订单</li>
				<li>3.支付订单</li>
			</ul>
		</div>
		<c:if test="${not empty companyCarts}">
		<div class="lh_wdgwc_cszdsp">
			<input type="hidden" id="dlmHv" value="${huilv.now_rate_dlm}"/>
			<input type="hidden" id="docHv" value="${huilv.now_rate_doc}"/>
			<input type="hidden" id="delGoodsIds"/>

			<ul>
				<div class="lh_wdgwc_w-bond">
					<div class="lh_wdgwc_w-bond-title">
						<p class="lh_wdgwc_w-title-qx">
							<label><input type="checkbox" id="admin_carts_cartCheckbox" onclick="checkedAll('goodsIds',this);"/>全选</label>
						</p>
						<p class="lh_wdgwc_w-title-name3" style="text-align: center;">商品</p>
						<p class="w-title-time3">单价</p>
						<p class="lh_wdgwc_w-title-time3">数量</p>
						<p class="lh_wdgwc_w-title-time3">小计</p>
						<p class="lh_wdgwc_w-title-mony3">操作</p>
					</div>
				</div>
				<c:forEach items="${companyCarts}" var="coms" varStatus="status">
				<div class="lh_wdgwc_w-bond-jd">
					<div class="lh_wdgwc_w-bond-155" style=" width:35px;margin-top: 0px; margin-left: 10px;">
						<label><input name="admin_carts_cartCheckbox_com" type="checkbox" onclick="checkedAllCompany('goodsIds','${status.index}',this);"></label>
					</div>
					<div class="lh_wdgwc_w-bond-jd_bt">
						<span>商家名称：${coms.companyName}</span>
					</div>
					<div class="lh_wdgwc_w-bond-jd_jrdp">
						<a href="shopDetail/${coms.id}/1.html">进入店铺></a>
					</div>
				</div>
					<c:forEach items="${coms.cartList}" var="cart" varStatus="status1">
				<div class="lh_wdgwc_w-bond-list1 fl" style=" border-top:2px solid #d6cfcf" id="cart_${cart.itemId}">
					<div class="lh_wdgwc_w-bond-info1">
						<div class="lh_wdgwc_w-bond-155">
							<label><input type="checkbox"
										  id="check_${status.index}_${status1.index}" checksumid="cartSum_${status.index}_${status1.index}"
										  name="goodsIds" cname="${status.index}" value="${cart.itemId}"
										  onclick="checkBoxUpPr('${status.index}_${status1.index}')" />
							</label>
						</div>
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
							<span id="cartItemPrice_${status.index}_${status1.index}"><fmt:formatNumber type="number" value="${cart.goodsItem.price * cart.goods.saleRate}" pattern="0.00" maxFractionDigits="2"/></span>
						</div>
						<div class="lh_wdgwc_w-bond-18">
							<div class="mui-numbox" style="width: 50px; padding: 0 20px;">
								<button class="mui-btn mui-btn-numbox-minus" type="button" style="width: 24px;" onclick="changeNum('${cart.goodsId}','${cart.itemId}','del','${status.index}_${status1.index}')">-</button>
								<input class="mui-input-numbox" type="number" id="${cart.itemId}" value="${cart.goodsNum}"
									   onkeyup="changeNum('${cart.goodsId}','${cart.itemId}','inputByme','${status.index}_${status1.index}')" />
								<button class="mui-btn mui-btn-numbox-plus" type="button" style="width: 24px;" onclick="changeNum('${cart.goodsId}','${cart.itemId}','add','${status.index}_${status1.index}')">+</button>
							</div>
						</div>
						<div id="cartSum_${status.index}_${status1.index}" class="lh_wdgwc_w-bond-19"><fmt:formatNumber type="number" value="${cart.goodsItem.price * cart.goods.saleRate * cart.goodsNum}" pattern="0.00" maxFractionDigits="2"/></div>
						<div class="lh_wdgwc_w-bond-20">
							<a href="javascript:void(0);" onclick="delCartGoods('${cart.itemId}');">删除</a>
						</div>
						<div class="w-clear"></div>
					</div>
				</div>
					</c:forEach>

				</c:forEach>

				<div class="lh_wdgwc_js fl">
					<%--<p class="lh_wdgwc_w-title-qx fl">--%>
						<%--<label style="color: #5c5c5c;"><input type="checkbox" id="cookie" name="data[cookie]" value="1" style="margin-top: 22px;">全选</label>--%>
					<%--</p>--%>
						<form id="clearForm" action="memberCallAction!goClearing.action" method="post">
							<input type="hidden" id="goodsItemIds" name="goodsItemIds" />
							<input type="hidden" id="isOneyBuy" name="isOneBuy" value="1"/>
							<input type="hidden" id="isNowBuy" name="isNowBuy" value="0"/>
						</form>
					<p class="lh_wdgwc_js_sc">
						<a href="javascript:void(0);" onclick="delCheckGoods();">删除选择商品</a>
					</p>
					<p class="lh_wdgwc_js_ze">
						<span>总额：<i>￥</i><i id="total">0.00</i> <i>$</i><i id="docTotal">0.00</i> <i>AED</i><i id="dlmTotal">0.00</i> (含税）</span>
					</p>
					<p class="lh_wdgwc_js_an">
						<a href="javascript:goClearing('<%=memberId%>');">去结算</a>
					</p>
				</div>
			</ul>
	</div>
		</c:if>
			<c:if test="${empty companyCarts}">
				<div class="lh_wdgwc_wu">
					<div class="lh_gwczt">
						<span><i class="icon iconfont">&#xe616;</i></span>
						<p>您的购物车还没任何商品</p>
						<button>去购物</button>
					</div>
				</div>
			</c:if>
		<s:if test="#attr.sessionInfo.loginName == null">
		<div class="lh_wdgwc_wu">
			<div class="lh_gwczt">
				<span><i class="icon iconfont">&#xe619;</i></span>
				<p>您还没有登录</p>
				<a href="javascript:showLogin('mask', 'pop_500', 'call/goToCart.html', '0', '');"><button>去登陆</button></a>
			</div>
		</div>
		</s:if>
	</div>
</div>
<jsp:include page="../../admin/common/indexFooter.jsp" />
	<!-- footer end -->
<script type="text/javascript" src="../../js/cart.js"></script>
<script type="text/javascript">
	// 提交表单
	function goClearing(memberId) {
		if(memberId != null && memberId != 'null' && memberId != ''){
			var goodsItems = $("#delGoodsIds").val();
			if(null != goodsItems && goodsItems != ''){
				if(checkOneCompany()){
					$("#goodsItemIds").val(goodsItems);
					$("#clearForm").submit();
				}else{
					alert("很抱歉，商品不属于同一商家，请选择同一商家的商品！");
					return false;
				}
			}else{
				alert("请选择商品!");
				return false;
			}
		}else {
			showLogin('mask', 'pop_500', 'call/goToCart.html', '0', '');
		}

	}

	//检查是否是同一个商家
	function checkOneCompany() {
		var oneFlag = 0;
		var checkOneCom = true;
		var checkArray = document.getElementsByName("goodsIds");
		for ( var zc = 0; zc < checkArray.length; zc++) {
			if($("#"+checkArray[zc].id).attr("checked") == "checked"){
				var checkId = checkArray[zc].id;
				var checkComs = checkId.split("_");
				var checkCom = checkComs[1];
				if(zc == 0){
					oneFlag = checkCom;
				}else{
					if(checkCom == oneFlag){
						checkOneCom = true;
					}else{
						checkOneCom = false;
					}
				}

			}
		}
		return checkOneCom;
	}
</script>
</body>
</html>
