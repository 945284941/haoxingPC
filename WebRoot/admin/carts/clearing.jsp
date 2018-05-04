<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>订单结算页面</title>

<link href="css/master.css" rel="stylesheet" type="text/css">
<link href="css/news.css" rel="stylesheet" type="text/css">
<link href="css/shop.css" rel="stylesheet" type="text/css">
<link href="css/shop_two.css" rel="stylesheet" type="text/css">
<link href="css/common.css" rel="stylesheet" type="text/css" />

<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/regions.js"></script>
<script type=text/javascript src="js/tanchu.js"></script>
<script type=text/javascript src="js/register.js"></script>
<script type=text/javascript src="js/qlzy.js"></script>

</head>
<body>
	<div id="tanchu"></div>
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	<jsp:include page="../common/navigation.jsp"></jsp:include>
	
	<form action="call/submitOrder.html" id="admin_carts_clearingFrom"
		name="admin_carts_clearingFrom" method="post"
		enctype="multipart/form-data">
		<div class="shop shop1013">
			<div class="shopgw">

				<ul>
					<li class="first"><span>1. 我的购物车</span></li>
					<li class="two"><span>2.核对并提交订单</span></li>
					<li class="thr"><span>3.货款支付</span></li>
				</ul>
				<div style="clear: both; height: 10px;"></div>
			</div>
			
			
			

			
			
			
			
			<!--买方信息开始-->
			<div class="splb splbtwo">
				<h2>
					买方信息<a href="javascript:showsplbtitle('tanchu', 'shxx');"
						class="bjxg">【编辑修改】</a>
				</h2>
				<jsp:include page="clearingAddr.jsp"></jsp:include>
			</div>

			<div class="splb">
				<h2>物流配送</h2>
				<ul>
					<li class="kg sgh-splb-bk-3"></li>
					<li class="ps sgh-splb-bk-4">配送方式</li>
					<li class="msh sgh-splb-bk-4">配送描述</li>
				</ul>
				<div style="clear: both"></div>
				<div class="cplb msh">
					<div class="cc xzput sgh-splb-bk-5">
						<div class="p-img">
							<input type="radio" value="N" class="hookbox" checked="checked"
								name="logistics" onclick="goodsMail('N')">
						</div>
					</div>
					<div class="cc psfs">
						<span class="price">物流发送</span>
					</div>
					<div class="cc psmsh">
						<span class="price">由卖家负责联系物流公司配送 ,费用为：
							<span id="span_mailing">${mailing}元</span>
							<input type="hidden" name="mailing" id="hidden_mailing" value="${mailing}" />
						</span>
					</div>
				</div>
			</div>
			<%-- <div class="splb">
				<h2>支付方式</h2>
				<ul>
					<li class="kg"></li>
					<li class="ps">名称</li>
					<li class="ms">订购描述</li>
				</ul>
				<div style="clear: both"></div>
				<div class="cplb">
					<div class="cc xzput">
						<div class="p-img">
							<input type="radio" value="0" class="hookbox" checked="checked"
								name="payment">
						</div>
					</div>
					<div class="cc psfs">
						<span class="price">在线支付</span>
					</div>
					<div class="cc psms">
						<span class="price">支持支付宝支付</span>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="cplb">
		            <div class="cc xzput">
		                <div class="p-img"><input type="radio" value="1" class="hookbox" onclick="" name="payment"></div>      
		            </div>
		            <div class="cc psfs"><span class="price">金米</span></div>
		            <div class="cc psms"><span class="price">使用金米支付，请确保余额足以支付,您现在持有金米（<i id="glbCount">${member.xianjinbi}</i>）。</span><i class="noglbMsg" style="display:none;font-size:14px;font-weight:bold;color:red;">您的金米余额不足以支付此订单,按钮将不能操作！</i></div>
		            <div style="clear:both"></div>
		        </div>
		        <div class="cplb">
		            <div class="cc xzput">
		                <div class="p-img"><input type="radio" value="3" class="hookbox" onclick="" name="payment"></div>      
		            </div>
		            <div class="cc psfs"><span class="price">惠米</span></div>
		            <div class="cc psms"><span class="price">使用金米支付，请确保余额足以支付,您现在持有金米（<i id="lcbCount">${member.liucunbi}</i>）。</span><i class="nolcbMsg" style="display:none;font-size:14px;font-weight:bold;color:red;">您的惠米余额不足以支付此订单,按钮将不能操作！</i></div>
		            <div style="clear:both"></div>
		        </div>
		        <div class="cplb">
		            <div class="cc xzput">
		                <div class="p-img"><input type="radio" value="2" class="hookbox" onclick="" name="payment"></div>      
		            </div>
		            <div class="cc psfs"><span class="price">经验值</span></div>
		            <div class="cc psms"><span class="price">使用经验值支付，请确保余额足以支付,您现在持有经验值（<i id="jfbCount">${member.point}</i>）。</span><i class="nojfbMsg" style="display:none;font-size:14px;font-weight:bold;color:red;">您的经验值余额不足以支付此订单,按钮将不能操作！</i></div>
		            <div style="clear:both"></div>
		        </div>            
		        
			</div> --%>
			<div class="splb splbtwo">
				<h2>
					发票信息<a href="javascript:showsplbtitleBill('tanchu', 'fpxx');"
						class="bjxg">【编辑修改】</a>
				</h2>
				<div class="cplb sgh-splb-bk-1">
					<div class="cc name">
						<span class="price">发票类型<input type="hidden" id="billType"
							name="billType" value="普通发票" /></span>
					</div>
					<div class="cc lb">
						<span class="price" id="bill_type">普通发票</span>
					</div>
					<div style="clear: both"></div>
				</div>
				<div class="cplb sgh-splb-bk-2">
					<div class="cc name">
						<span class="price">发票抬头<input type="hidden" id="billHead"
							name="billHead" value="个人" /></span>
					</div>
					<div class="cc lb">
						<span class="price" id="bill_head">个人</span>
					</div>
					<div style="clear: both"></div>
				</div>
				<div class="cplb sgh-splb-bk-2">
					<div class="cc name">
						<span class="price">发票内容 <input type="hidden"
							id="billContent" name="billContent" value="有机粮食" /></span>
					</div>
					<div class="cc lb">
						<span id="bill_content">有机粮食</span>
					</div>
					<div style="clear: both"></div>
				</div>
			</div>

			<!--div class="splb splbtwo">
				<h2>
					买家留言<a class="bjxg"></a>
				</h2>
				<div class="cplb">
					<textarea style="margin-left: 10px;" rows="4" cols="134" name="remark" id="remark"></textarea>
				</div>
			</div-->

<!-- 购物车 -->
			<div class="splb shopcart">	
				<h2>商品列表</h2>
				<ul>
					<li class="mc">商品名称</li>
					<li style="width:125px;" >单价</li>
					<li style="width:125px;" >规格</li>
					<li style="width:125px;" >物流费用</li>
					<li style="width:125px;" >购买数量</li>
					<li style="width:125px;" >经验值</li>
					<li class="cz" style="width:125px;" >金额小计</li>
				</ul>	
				<div style="clear: both"></div>	
				<s:iterator value="carts" var="cart" status="gd">
					<div class="cplb"><ul class="shop1013cart">
						<li class="cc cplbname mc">
							<div class="p-img">
								<a target="_blank" href="goods/${cart.goods.id}.html">
									<img alt="${cart.goods.name}" src="${cart.goods.defaultPicSrc}" width="45px" height="35px" />
									<%-- <img alt="${cart.goods.name}" src='<s:imgsrc value="${cart.goods.defaultPicSrc}" quantity="s"/>' width="45px" height="35px" /> --%>
								</a>
								
								<a target="_blank" href="goods/${cart.goods.id}.html"><img
									alt="${cart.goods.name}" src="${cart.goods.defaultPicSrc}" width="45px"
									height="35px" /></a>
							</div>
							 <input class="fenqu" value="${cart.goods.goodstype }" type="hidden"/>
							<div class="p-name">
								<input type="hidden" name="goodsIds" value="${cart.id}"><a
									target="_blank" href="goods/${cart.goods.id}.html"> <s:if
										test="%{#cart.goods.name.length()>50}">
										<s:property value="%{#cart.goods.name.substring(0, 50)}" />...</s:if> <s:else>
					     		${cart.goods.name}
					     		</s:else>
								</a>
							</div>
						</li>						
						<li class="cc cplbname" style="width:125px;" >
							<span class="price">￥${cart.goodsItem.price}</span>
						</li>
						<li class="cc cplbprice" style="width:125px;" >
							<span class="price">${cart.goodsItem.skuJsonHz}</span>
						</li>
						<li class="cc cplbprice" style="width:125px;" >
							<span class="price">${cart.goods.postage}</span>
						</li>
						<li class="cc cplbprice" style="width:125px;" >
							<span class="price">${cart.goodsNum}</span>
						</li>
						<li class="cc cplbprice" style="width:125px;" >
							<c:if test="${cart.goods.isPoint == 1 && cart.goods.goodstype == 1}">
								<input type="checkbox" name="payCartsIds" value="${cart.id }" onchange="getPercentage();" />
								<span class="price">￥<fmt:formatNumber value="${cart.goodsItem.price * cart.goodsNum * (cart.goods.pointPercentage/100) }" pattern="0.00" maxFractionDigits="2"/>
								</span>
							</c:if>
						</li>
						<li class="cz" style="width:125px;" >
							<span class="price" style="color: #c00f17">￥</span><span
								style="color: #c00f17"
								id="goods_price_<s:property value="#gd.getIndex()"/>">${cart.goodsItem.price*10000*cart.goodsNum/10000}</span>
						</li>
						<!--  div style="clear: both"></div>-->
					</ul></div>
				</s:iterator>				
				<!--div class="zj">
					<span class="zjje">总计金额（不含运费）：<strong style="color: #c00f17">￥</strong><strong
						style="color: #c00f17" id="goods_total"></strong></span>
				</div-->
			</div>

<!-- 发票   -->
<div class="splb shopfapiao">	
	<%-- <div class="shopfapiaol">
		<div class="shopfpl">发票抬头：<span>个人</span><a href="javascript:showsplbtitleBill('tanchu', 'fpxx');" class="bjxg">修改</a></div>
		<div class="shopfpr">运送方式：<span>普通配送</span><span>快递</span></div>
	</div> --%>
	<div class="shopfapiaol">
		<div class="shopfpl">给卖家留言：<input name="remark" id="remark" placeholder="选填：对本次交易的说明(建议填写和卖家协商一致的内容)"/></div>
		<div class="shopfpr"><!--运费险：<i>运费险</i>卖家赠送，若卖家收货前退货，可获保险<strong>${mailing}</strong--></div>
	</div>
<%-- 	<div class="shopfapiaol">
		<em>店铺合计(含运费)：<b>￥${mailing}</b></em>
	</div> --%>
</div>


















<div class="splb shoptjdd">
	<!--h2>总计金额</h2-->
	<div class="zj">	
		<span class="zjje">	
		<p>商品总额：
			<strong>￥</strong><strong id="goods_total2"></strong>
		</p>
		<p>物流费用：
			<strong>+￥</strong><strong id="goods_mailing">${mailing}</strong>
		</p>
		<p>经验值：
			<strong>-￥</strong><strong id="pointVal">0</strong>
		</p>
		<p class="shopsfze">实付总额：		
			<b>￥</b><b id="goods_total"></b>
		</p>
		</span>
	    <!--<span class="scjf">获得经验值为：<strong id="goods_total3"></strong></span>-->
	<span class="tjd"><a href="javascript:submitForm();">提交订单</a></span>
	</div>
</div>
			
			
			
			<!--发票信息修改开始-->
			<div id="fpxx" class="splb splbxg"
				style="visibility: hidden; top: 30%; left:30%; z-index: 9999;width: 590px;margin: 0 auto;">
				<div class="splb-title">
					<strong>发票信息</strong><a
						href="javascript:stopsplbtitle('tanchu', 'fpxx');"
						class="sgh-splb-gb">【关闭】</a>
				</div>
				<div class="splb-content">
					<div class="form">
						<div class="item">
							<div class="splb-xj">
								<label for=""><strong>发票类型：</strong></label> <input type="radio"
									id="ptfp" value="普通发票" name="bill_type_radio" class="bill">
								<label for="" class="fp">普通发票</label> <input type="radio"
									id="ptzfp" value="普通增值税发票" name="bill_type_radio" class="bill">
								<label for="" class="fp" style="width: 116px;">普通增值税发票</label> <input type="radio"
									id="zyfp" value="专用增值税发票" name="bill_type_radio" class="bill">
								<label for="" class="fp">专用增值税发票</label>
							</div>
							<div class="splb-xj">
								<label for=""><strong>发票抬头：</strong></label> <input type="radio"
									value="个人" id="gerenBill" name="bill_head_radio"
									onclick="closeBillHeadInput();" checked="checked" class="bill">
								<label for="" class="fp">个人</label> <input type="radio"
									value="单位" id="danweiBill" name="bill_head_radio"
									onclick="showBillHeadInput();" class="bill"> <label
									for="">单位</label> <input type=text id="bill_head_input"
									name="billHead" class="dwtx" style="display: none;">
							</div>
							<div class="splb-xj">
								<label for=""><strong>发票内容：</strong></label> <input type="text"
									value="" id="bill_content_input" name="bill_content_input"
									class="hookboxnr">
							</div>
						</div>
					</div>
				</div>
				<div class="splb-content">
					<div class="group">
						<a class="btn-submit" href="javascript:updateBill();"><span>确认发票信息</span></a>
						<div style="display: none" class="loading loading-1">
							<b></b>正在提交信息，请等待！
						</div>
					</div>
				</div>

			</div>
			<!--发票信息修改结束-->

				<!--买方信息修改-->
			<div id="shxx" class="splb splbxg"
				style="visibility: hidden; z-index: 99999; top: 16%; left: 26%;width:710px;">
				<div class="splb-title">
					<strong>收货人信息</strong><a
						href="javascript:stopsplbtitle('tanchu', 'shxx');"
						style="margin-left: 555px; font-size: 12px; color: #666">【关闭】</a>
				</div>
				<div class="splb-content">
					<div class="sbox-wrap">
						<div class="form">
							<!--更多常用收货人--->
							<!---详细收货人信息表单--->
							<s:iterator value="raList" var="ra">
								<div class="item_dz">
									<s:if test="#ra.id==receiveAddr.id">
										<input type="radio" id="admin_cart_clearing_radioAddr" 
											onclick="changeAddr('${ra.id}');" name="addr"
											checked="checked" class="hookboxra" value="${ra.id}">
									</s:if>
									<s:else>
										<input type="radio" id="admin_cart_clearing_radioAddr"
											onclick="changeAddr('${ra.id}');" name="addr"
											class="hookboxra" value="${ra.id}">
									</s:else>

									<label for="consignee_radio_new">${ra.receiveName}
										${ra.telephone} ${ra.mobile}
										${ra.pname}${ra.cname}${ra.aname}${ra.receiveAddress} </label>
								</div>
							</s:iterator>


							<div class="item">
								<input type="radio" id="admin_cart_clearing_radioAddr"
									onclick="newAddr();" name="addr" class="hookboxra"> <label
									for="consignee_radio_new">使用新地址 </label>
							</div>
							<jsp:include page="addr.jsp"></jsp:include>
							<div class="group">
								<a class="btn-submit"
									href="javascript:addNewAddr('shxx','2','admin_cart_clearingAddr_div');"><span>确认收货地址</span></a>
								<div style="display: none">正在提交信息，请等待！</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--买方信息修改结束-->
		</div>
		<!--div class="bottom_box_06">
			<div class="bottom_box_06img">
				<img src="web/images/zixun/tonglan.png" width="1190" height="118" />
			</div>
		</div-->
		<jsp:include page="/admin/common/indexFooter.jsp" />
		<!-- footer end -->

	</form>
	<script type="text/javascript">
		var goodsListLength = "<s:property value="carts.size" />";
		var mailing = ${mailing};
		$(function() {
			var total = 0;
			for (var zc = 0; zc < goodsListLength; zc++) {
				var tzc = parseFloat($("#goods_price_" + zc).text());
				total = total + tzc;
			}
			var payTotal = total;
			var logistics = $('input:radio[name="logistics"]:checked').val();
			if (logistics == 'N') {
				payTotal += mailing;
				$("#goods_mailing").html(mailing);
			} else {
				$("#goods_mailing").html("0");
			}
			/* var m = ${isMail};
			var mail = ${mailing};
			console.info(m + ">>>"+mail);
			
			if(!m){
				total = total + mail;
			} 

			console.info(mailMax);
			if (total >= mailMax) {

				$("#span_mailing").html("免运费");
				$("#hidden_mailing").val(0);
				$("#goods_mailing").html(0);
			}*/
			$("#goods_total").html(parseFloat(payTotal).toFixed(2));
			$("#goods_total2").html(parseFloat(total).toFixed(2));
			$("#goods_total3").html(parseFloat(total).toFixed(2));
			var goods_total = parseInt($('#goods_total').text());
			var glbCount = parseInt($('#glbCount').text());
			if (goods_total > glbCount) {
				$('input[type=radio][name=payment][value=1]').attr('disabled',
						'disabled');
				$('.noglbMsg').show();
			}
			var jfbCount = $('#jfbCount').text();
			if(goods_total > jfbCount){
				$('input[type=radio][name=payment][value=2]').attr('disabled',
						'disabled');
				$('.nojfbMsg').show();
			}
			var lcbCount = $('#lcbCount').text();
			if(goods_total > lcbCount){
				$('input[type=radio][name=payment][value=3]').attr('disabled',
						'disabled');
				$('.nolcbMsg').show();
			}
		});

		function changeAddr(id) {
			$("#consignee-form").load(
					"memberCallAction!loadReceiveAddr.action", {
						"receiveAddr.id" : id
					});

		}
		//使用新地址
		function newAddr() {
			$("#admin_cart_clearingr_eceiveAddr_id").attr("value", "");
			$("#admin_cart_clearingr_eceiveAddr_name").attr("value", "");
			$("#admin_cart_clearingProvince").attr("value", "0");
			$("#admin_cart_clearingCity").attr("value", "0");
			$("#admin_cart_clearingArea").attr("value", "0");
			$("#admin_cart_clearingr_receiveAddr_receiveAddress").attr("value",
					"");
			$("#admin_cart_clearingr_receiveAddr_mobile").attr("value", "");
			$("#admin_cart_clearingr_receiveAddr_telephone").attr("value", "");
			$("#admin_cart_clearingr_receiveAddr_email").attr("value", "");
		}

		//修改发票信息
		function updateBill() {
			var billType = $("input[name='bill_type_radio']:checked").val();
			var billHead = $("input[name='bill_head_radio']:checked").val();
			var billContent = $("#bill_content_input").val();
			$("#bill_type").html(billType);
			if (billHead == "个人") {
				$("#bill_head").html("个人");
			} else {
				var billHeadinput = $("#bill_head_input").val();
				$("#bill_head").html(billHeadinput);
			}
			$("#bill_content").html(billContent);
			//一下三个设置隐藏域的值
			$("#billType").attr("value", billType);
			$("#billHead").attr("value", billHead);
			$("#billContent").attr("value", billContent);
			stopsplbtitle('tanchu', 'fpxx');
		}
		function updateNewBill() {
			var billType = $("#bill_type").text();
			var billHead = $("#bill_head").text();
			var billContent = $("#bill_content").text();
			$("input[name='bill_type_radio']").attr("value", billType);

			if (billHead == "个人") {
				$("input[name='bill_head_radio']").attr("value", billHead);
			} else {
				$("input[name='bill_head_radio']").attr("value", "单位");
				$("#bill_head_input").attr("value", billHead);
			}
			$("#bill_content_input").attr("value", billContent);

		}
		//隐藏发票抬头信息
		function closeBillHeadInput() {
			document.getElementById("bill_head_input").style.display = "none";
		}
		//显示发票抬头信息
		function showBillHeadInput() {
			document.getElementById("bill_head_input").style.display = "inline-block";
		}

		function goodsMail(m) {
			if (m == 'Y') {
				$("#goods_mailing").html("0");
			} else {
				$("#goods_mailing").html(mailing);
			}
		}

		//提交表单
		function submitForm() {
			var remark = $("#remark").val();
			if (null != remark && remark != '') {
				if (remark.length > 200) {
					alert("留言数字不能超过200个！");
				}
			}
			var payment= $('input[name="payment"]:checked').attr('value');
		
			var addrId = $("#admin_carts_clearingAddr_receiveAddrId").val();
			if (addrId != null && addrId != '') {
			var a;
			var b;
				/* if(payment==2){
					$.each($(".fenqu"),function(i,o){
						  a = $(this).val(); 
						  
						    if(a!=2){
						  	alert("经验值仅支持经验值专区商品使用");
						  }else{
						  	$("#admin_carts_clearingFrom").submit();
						  }
						});
				}else{
					$.each($(".fenqu"),function(i,o){
						  b = $(this).val(); 
						    if(b==2){
						  	alert("该支付方式不能为经验值商品支付");
						  }else{
						  	$("#admin_carts_clearingFrom").submit();
						  }
						});
				} */
				$("#admin_carts_clearingFrom").submit();
			} else {
				showsplbtitle('tanchu', 'shxx');
			}
			//	$("#admin_carts_clearingFrom").submit();
		}
		
		//根据用户所选商品计算经验值及实付总额
		function getPercentage(){
			var payCartsIds = "";
			var cartsIds = document.getElementsByName("payCartsIds");
            for (var i = 0; i < cartsIds.length; i++) {
                if (cartsIds[i].checked) {
                    payCartsIds += cartsIds[i].value + ',';
                }
            }
            
            if("" == payCartsIds){
            	$("#pointVal").html("0");
            	
            	var total = 0;
				for (var zc = 0; zc < goodsListLength; zc++) {
					var tzc = parseFloat($("#goods_price_" + zc).text());
					total = total + tzc;
				}
				var payTotal = total;
				var logistics = $('input:radio[name="logistics"]:checked').val();
				if (logistics == 'N') {
					payTotal += mailing;
					$("#goods_total").html(parseFloat(payTotal).toFixed(2));
				} else {
					$("#goods_mailing").html("0");
				}
            }else{
            	$.ajax({
					type:'post',
					url:"<%=basePath %>getPercentage/" +payCartsIds+ ".html",
					dataType:'json',
					success:function(data){
						var results = eval("(" +data +")");
						$("#pointVal").html(parseFloat(results).toFixed(2));
						
						
						var total = 0;
						for (var zc = 0; zc < goodsListLength; zc++) {
							var tzc = parseFloat($("#goods_price_" + zc).text());
							total = total + tzc;
						}
						var payTotal = total;
						var logistics = $('input:radio[name="logistics"]:checked').val();
						if (logistics == 'N') {
							payTotal += mailing;
							
							payTotal = payTotal - results;
							$("#goods_total").html(parseFloat(payTotal).toFixed(2));
						} else {
							$("#goods_mailing").html("0");
						}
					}
				});
            }
			
		}
		
	</script>
</body>
</html>
