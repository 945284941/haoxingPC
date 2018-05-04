<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

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
	<script type=text/javascript src="js/slides.jquery.js"></script>
	<script type=text/javascript src="js/tanchu.js"></script>
	<script type=text/javascript src="js/regions.js"></script>
	<script type=text/javascript src="js/register.js"></script>
	<script type=text/javascript src="js/qlzy.js"></script>


  </head>
  <div id="tanchu"></div>
  <body>
	  <!-- header begin -->
	  <div class="header">
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	  </div>
	  <div class="logo">
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	  </div>  
	  <!-- header end -->
	  <!-- 导航 -->
	  <jsp:include page="../common/navigation.jsp"></jsp:include>
	  <!-- 导航结束 -->
  	<form action="call/submitOrderCh.html" id="admin_carts_clearingFrom" name="admin_carts_clearingFrom" method="post" enctype="multipart/form-data">
  		<div class="shop">
		  <div class="shopgw">
		    <h2><span>（选购清单）</span></h2>
		    <ul>
		      <li class="first"><span>1. 我的购物车</span></li>
		      <li class="two"><span>2.核对并提交订单</span></li>
		      <li class="thr"><span>3.货款支付</span></li>
		    </ul><div style="clear:both; height:10px;"></div>
		  </div>
		  <div class="splb">
		    <h2>商品列表</h2>
		    <ul>
		      <li class="mc">商品名称</li><li class="mc">商品卖家</li><li>单价</li><li>物流费用</li><li>购买数量</li><li class="cz">金额小计</li>
		    </ul><div style="clear:both"></div>
		    <s:iterator value="goodsList" var="goods" status="gd">
		    	 <div class="cplb">
		            <div class="cc cplbname">
		                <div class="p-img"><a target="_blank" href="#"><img alt="${goods.name}" src="${goods.defaultPicSrc}" width="45px" height="35px"/>
		                
		                </a></div>    
		                <div class="p-name"><input type="hidden" name="goodsIds" value="${goods.id}" ><a target="_blank" href="#">${goods.name}</a></div>    
		            </div>
		            <div class="cc cplbname"><a target="_blank" href="/Shop/index_${goods.companyId}.html"><span class="price">${goods.companyName}</span></a></div>
		            <div class="cc cplbprice"><span class="price">￥${goods.price}</span></div>
		            <div class="cc cplbprice"><span class="price">
		             <c:if test="${fn:contains(goods.isMail, 'false')}"> 不包邮</c:if>
		             <c:if test="${fn:contains(goods.isMail, 'true')}"> 包邮</c:if>
		           	 </span></div>
		           
		            
		            <div class="cc cplbprice"><span class="price">${goods.cartNum}</span></div>
		            <div class="cc xj"><span class="price" style="color:#c00f17" >￥</span><span style="color:#c00f17"  id="goods_price_<s:property value="#gd.getIndex()"/>">${goods.price*10000*goods.cartNum/10000}</span></div>
		            <div style="clear:both"></div>
		        </div>
	    	</s:iterator>	   	       
		    <div class="zj">
		      <span class="zjje">总计金额（不含运费）：<strong style="color:#c00f17">￥</strong><strong style="color:#c00f17" id="goods_total"></strong></span>
		    </div>
		  </div>
		  <!--买方信息开始-->
		  <div class="splb splbtwo">
		    <h2>买方信息<a href="javascript:showsplbtitle('tanchu', 'shxx');" class="bjxg">【编辑修改】</a></h2>
		    <jsp:include page="clearingAddr.jsp"></jsp:include>      
		  </div>

		  <div class="splb">
		    <h2>物流配送</h2>
		    <ul>
		      <li class="kg"></li><li class="ps">配送方式</li><li class="msh">配送描述</li>
		    </ul><div style="clear:both"></div>
		    <div class="cplb">
		            <div class="cc xzput">
		                <div class="p-img"><input type="radio" value="Y" class="hookbox" name="logistics"></div>      
		            </div>
		            <div class="cc psfs"><span class="price">自提</span></div>
		            <div class="cc psmsh"><span class="price">提货地点：山东省济南市天桥区重汽配件城</span></div>
		        </div>
		        <div class="cplb">
		            <div class="cc xzput">
		                <div class="p-img"><input type="radio" value="N" class="hookbox" checked="checked" name="logistics"></div>      
		            </div>
		            <div class="cc psfs"><span class="price">物流发送</span></div>
		            <div class="cc psmsh"><span class="price">由卖家负责联系物流公司配送，具体物流费用可在线咨询卖家</span></div>
		        </div>        
		  </div>
		  <div class="splb">
		    <h2>支付方式</h2>
		    <ul>
		      <li class="kg"></li><li class="ps">名称</li><li class="ms">订购描述</li><li class="fy">手续费</li>
		    </ul><div style="clear:both"></div>
		    <div class="cplb">
		            <div class="cc xzput">
		                <div class="p-img"><input type="radio" value="2" class="hookbox" checked="checked" name="payment"></div>      
		            </div>
		            <div class="cc psfs"><span class="price">担保支付</span></div>
		            <div class="cc psms"><span class="price">使用账户余额支付，请确保余额大于或等于支付金额。</span></div>
		            <div class="cc wlf"><span class="price" style="color:#c00f17">￥0.00</span></div>
		        </div>
		       <!--   <div class="cplb">
		            <div class="cc xzput">
		                <div class="p-img"><input type="radio" value="1" class="hookbox" onclick="" name="payment"></div>      
		            </div>
		            <div class="cc psfs"><span class="price">预存款</span></div>
		            <div class="cc psms"><span class="price">使用账户余额支付，请确保余额大于或等于支付金额。</span></div>
		            <div class="cc wlf"><span class="price" style="color:#c00f17">￥0.00</span></div><div style="clear:both"></div>
		        </div>   -->     
		  </div>
		  <div class="splb splbtwo">
		    <h2>发票信息<a href="javascript:showsplbtitleBill('tanchu', 'fpxx');" class="bjxg" >【编辑修改】</a></h2>
		        <div class="cplb">
		            <div class="cc name"><span class="price">发票类型<input type="hidden" id="billType" name="billType" value="普通发票" /></span></div>
		            <div class="cc lb"><span class="price" id="bill_type">普通发票</span></div><div style="clear:both"></div>
		        </div> 
		        <div class="cplb">
		            <div class="cc name"><span class="price">发票抬头<input type="hidden" id="billHead" name="billHead" value="个人" /></span></div>
		            <div class="cc lb"><span class="price" id="bill_head">个人</span></div><div style="clear:both"></div>
		        </div>
		        <div class="cplb">
		            <div class="cc name"><span class="price">发票内容 <input type="hidden" id="billContent" name="billContent" value="重汽配件" /></span></div>
		            <div class="cc lb"><span id="bill_content">重汽配件</span></div><div style="clear:both"></div>
		        </div>       
		  </div>
		
		 <div class="splb splbtwo">
		    <h2>买家留言<a  class="bjxg" ></a></h2>
		        <div class="cplb">
		         <textarea style="margin-left:10px;" rows="4" cols="116" name="remark" id="remark"></textarea>
		        </div> 
		             
		  </div>
		  
		  
		  <div class="splb">
		    <h2>总计金额</h2>
		    <div class="zj">
		      <span class="zjje">总计金额（不含运费）：<strong style="color:#c00f17">￥</strong><strong style="color:#c00f17" id="goods_total2">500.00</strong></span>
		      <span class="scjf">获得商城经验值为：<strong id="goods_total3"></strong>分</span>
		      <span class="scjf">您当前的信用额度为：<strong style="color:#c00f17">￥</strong><strong style="color:#c00f17" id="guaranteePrice">${guaranteePrice}</strong></span>
		      <span class="tjd"><a href="javascript:submitForm();">提交订单</a></span>
		    </div>
		  </div>
		  <div class="tlggp"><a href="/"><img src="/images/tlgg7.gif"/></a></div>
		    <!--发票信息修改开始-->
		  <div id="fpxx" class="splb splbxg" style=" visibility:hidden;top:50%;left:auto; z-index: 9999;">
			<div class="splb-title"><strong>发票信息</strong><a href="javascript:stopsplbtitle('tanchu', 'fpxx');" style="margin-left:10px; font-size:12px; color:#fff2b3">【关闭】</a></div>
		    <div class="splb-content">
			  <div class="form">
				 <div class="item">
			            <div class="splb-xj">
			               <label for=""><strong>发票类型：</strong></label>
						     <input type="radio"id="ptfp" value="普通发票"  name="bill_type_radio"  class="bill">
						     <label for="" class="fp">普通发票</label>
			                 <input type="radio" id="ptzfp" value="普通增值税发票"  name="bill_type_radio" class="bill">
						     <label for="" class="fp">普通增值税发票</label>
			                 <input type="radio" id="zyfp" value="专用增值税发票" name="bill_type_radio" class="bill">
						     <label for="" class="fp">专用增值税发票</label>
					 </div>
			         <div class="splb-xj">
			                 <label for=""><strong>发票抬头：</strong></label>
						     <input type="radio" value="个人" id="gerenBill" name="bill_head_radio" onclick="closeBillHeadInput();" checked="checked" class="bill">
						     <label for="" class="fp">个人</label>
			                 <input type="radio" value="单位" id="danweiBill" name="bill_head_radio" onclick="showBillHeadInput();" class="bill">
						     <label for="">单位</label>
			                 <input type=text id="bill_head_input" name="billHead" class="dwtx" style="display:none;">
					 </div>
			         <div class="splb-xj">
			         <label for=""><strong>发票内容：</strong></label>
			     <input type="text" value="" id="bill_content_input" name="bill_content_input" class="hookboxnr" >
			     </div>
				</div>
			  </div>
			</div>
			<div class="splb-content">
			      <div class="group">
					<a class="btn-submit" href="javascript:updateBill();"><span>确认发票信息</span></a>
					<div style="display:none" class="loading loading-1"><b></b>正在提交信息，请等待！</div>
				</div>
			</div>
		
		</div>
      <!--发票信息修改结束-->
      
        <!--买方信息修改-->
        <div id="shxx" class="splb splbxg" style=" visibility:hidden;z-index: 9999; top:26%; left:auto;">
			<div class="splb-title"><strong>收货人信息</strong><a href="javascript:stopsplbtitle('tanchu', 'shxx');" style="margin-left:10px; font-size:12px; color:#fff2b3">【关闭】</a></div>
			<div class="splb-content">
				<div class="sbox-wrap">
	  			<div class="form">
				<!--更多常用收货人--->
				<!---详细收货人信息表单--->
				<s:iterator value="raList" var="ra">
				 	<div class="item_dz">
				 		<s:if test="#ra.id==receiveAddr.id">
				 			<input type="radio" id="admin_cart_clearing_radioAddr" onclick="changeAddr('${ra.id}');" name="addr" checked="checked" class="hookboxra"  value="${ra.id}">
				 		</s:if><s:else>
				 			<input type="radio" id="admin_cart_clearing_radioAddr" onclick="changeAddr('${ra.id}');" name="addr" class="hookboxra"  value="${ra.id}">
				 		</s:else>
				 		
						<label for="consignee_radio_new">${ra.receiveName} ${ra.telephone} ${ra.mobile}   ${ra.pname}${ra.cname}${ra.aname}${ra.receiveAddress} </label>
				 	</div>
				 </s:iterator>
						
				
				<div class="item">
						<input type="radio" id="admin_cart_clearing_radioAddr" onclick="newAddr();" name="addr" class="hookboxra">
						<label for="consignee_radio_new">使用新地址 </label>
				</div>
			    <jsp:include page="addr.jsp"></jsp:include>
			<div class="group">
				<a class="btn-submit" href="javascript:addNewAddr('shxx','2','admin_cart_clearingAddr_div');"><span>确认收货地址</span></a>
				<div style="display:none">正在提交信息，请等待！</div>
			</div>
		</div>
	</div>
</div>
</div>
  <!--买方信息修改结束-->
</div>
<!-- footer begin -->
<div class="gzgz">
	<jsp:include page="/admin/common/footer.jsp" />
</div>
<!-- footer end -->
	
	</form>
	<script type="text/javascript">
	var totalPrice = 0;
	var goodsListLength = "<s:property value="goodsList.size" />";
	$(function() {
		var total = 0;
		for ( var zc = 0; zc < goodsListLength; zc++) {
			var tzc = parseFloat($("#goods_price_" + zc).text());
			total = total + tzc;
		}
		$("#goods_total").html(total);
		$("#goods_total2").html(total);
		$("#goods_total3").html(total);
		totalPrice = total;
	});
	
	function changeAddr(id){
		$("#consignee-form").load("memberCallAction!loadReceiveAddr.action",{"receiveAddr.id":id});
	
	}
	//使用新地址
	function newAddr(){
		$("#admin_cart_clearingr_eceiveAddr_id").attr("value","");
		$("#admin_cart_clearingr_eceiveAddr_name").attr("value","");
		$("#admin_cart_clearingProvince").attr("value","0");
		$("#admin_cart_clearingCity").attr("value","0");
		$("#admin_cart_clearingArea").attr("value","0");
		$("#admin_cart_clearingr_receiveAddr_receiveAddress").attr("value","");
		$("#admin_cart_clearingr_receiveAddr_mobile").attr("value","");
		$("#admin_cart_clearingr_receiveAddr_telephone").attr("value","");
		$("#admin_cart_clearingr_receiveAddr_email").attr("value","");
	}
	
	
	//修改发票信息
	function updateBill(){
		var billType=$("input[name='bill_type_radio']:checked").val();
		var billHead=$("input[name='bill_head_radio']:checked").val();
		var billContent = $("#bill_content_input").val();
		$("#bill_type").html(billType);
		if(billHead == "个人"){
			$("#bill_head").html("个人");
		}else{
			var billHeadinput = $("#bill_head_input").val();
			$("#bill_head").html(billHeadinput);
		}
		$("#bill_content").html(billContent);
		//一下三个设置隐藏域的值
		$("#billType").attr("value",billType);
		$("#billHead").attr("value",billHead);
		$("#billContent").attr("value",billContent);
		stopsplbtitle('tanchu', 'fpxx');
	}
	function updateNewBill(){
		var billType = $("#bill_type").text();
		var billHead = $("#bill_head").text();
		var billContent = $("#bill_content").text(); 
		$("input[name='bill_type_radio']").attr("value",billType);
		
		if(billHead == "个人"){
			$("input[name='bill_head_radio']").attr("value",billHead);
		}else{
			$("input[name='bill_head_radio']").attr("value","单位");
			$("#bill_head_input").attr("value",billHead);
		}
		$("#bill_content_input").attr("value",billContent);
		
	}
	//隐藏发票抬头信息
	function closeBillHeadInput(){
		document.getElementById("bill_head_input").style.display="none";
	}
	//显示发票抬头信息
	function showBillHeadInput(){
		document.getElementById("bill_head_input").style.display="inline-block";
	}
	//提交表单
	function submitForm(){
	var remark= $("#remark").val();
	if(null != remark && remark != ''){
		if(remark.length > 200){
			alert("留言数字不能超过200个！");
		}
	}
	var guaranteePrice = "${guaranteePrice}";
	if(totalPrice > guaranteePrice){
		alert("很抱歉，您当前的余额不足，请联系客服！");
		
	}else{
		var addrId=$("#admin_carts_clearingAddr_receiveAddrId").val();
		if(addrId != null && addrId != ''){
			
			$("#admin_carts_clearingFrom").submit();
		}else {
			showsplbtitle('tanchu', 'shxx');
		}
	}
		
	//	$("#admin_carts_clearingFrom").submit();
	}
	</script>
</body>
</html>
