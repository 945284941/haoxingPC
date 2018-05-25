<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	SessionInfo sessionInfo = (SessionInfo)session.getAttribute(ResourceUtil.getSessionInfoName());
	String memberId = sessionInfo==null?"":sessionInfo.getUserId();
%>
<script type="text/javascript" src="js/qlzy.js"></script>
<script type=text/javascript src="js/memberCenterLogin.js"></script>
<script type=text/javascript src="js/jdsjpop.js"></script>
 <script type="text/javascript">
	function login_or_not(url){
		$.ajax({
				url : 'memberCenter/goods!checkSession.action',
				type : 'POST',
				dataType : 'JSON',
				success : function(json) {
					if (!json) {
						showLogin('mask', 'pop_500', url, '0', '');
					} else {
						window.location.href=url;
					}
				}
		});
	}
</script>


<div style="background: #f6f6f6;">
	<%--<div class="main">--%>
		<div class="h_seat">
			<a href=""><s:text name="index_0013"/></a>>
			<a href="person/order/huiyuanzhongxin.html"><s:text name="index_0387"/></a>
		</div>
		<!--我是买家-->
		<%--<div class="h_content">--%>
			<div class="l-fl">
				<h3><s:text name="index_0121"/></h3>
				<dl>
					<dt><s:text name="index_0388"/></dt>
					<dd>
						<a href="person/order/myOrders.html"><s:text name="index_0088"/></a>
					</dd>
				</dl>
				<dl>
					<dt><s:text name="index_0128"/></dt>
					<dd>
						<a href="showShopCollect.html"><s:text name="index_0195"/></a>
					</dd>
					<dd>
						<a href="showGoodsCollect.html"><s:text name="index_0194"/></a>
					</dd>
				</dl>
				<dl>
					<dt><s:text name="index_0130"/></dt>
					<dd>
						<a href="qiugou/1.html"><s:text name="index_0389"/></a>
					</dd>
					<dd>
						<a href="qiugou/2.html"><s:text name="index_0101"/></a>
					</dd>
					<dd>
						<a href="qiugou/3.html"><s:text name="index_0390"/></a>
					</dd>
					<dd>
						<a href="qiugou/4.html"><s:text name="index_0102"/></a>
					</dd>
				</dl>
				<dl>
					<dt>设置</dt>
					<dd>
						<a href="/person/toShowBasicInfo.html"><s:text name="index_0304"/></a>
					</dd>
					<dd>
						<a href="loadReceiveAddr.html"><s:text name="index_0134"/></a>
					</dd>
					<dd>
						<a href="showBankcard.html"><s:text name="index_0135"/></a>
					</dd>
					<dd>
						<a href=""><s:text name="index_0133"/></a>
					</dd>
					<dd>
						<a href=""><s:text name="index_0391"/></a>
					</dd>
					<dd>
						<a href="/person/toShowPassword.html"><s:text name="index_0136"/></a>
					</dd>
				</dl>
				<dl>
					<dt><s:text name="index_0030"/></dt>
					<dd>
						<a href="yijian.html"><s:text name="index_0131"/></a>
					</dd>
				</dl>
			</div>

		<%--</div>--%>
	<%--</div>--%>
</div>

	<%--<div class="sghsc-order-main-left">
	  <div class="sghsc-order-le-tit-box">
 		<div class="sghsc-order-le-tit">个人信息</div>
		<div class="sghsc-order-le-wz">
			<a href="javascript:void(0);" onclick="openOrderPage('person/showBasicInfo.html');" target="_self">个人账户</a>
		</div>
		<div class="sghsc-order-le-wz">
			<a href="javascript:void(0);" onclick="openOrderPage('person/accountSecurity.html');" target="_self">账号安全</a>
		</div>
	  </div>
	  <div class="sghsc-order-le-tit-box">
 		<div class="sghsc-order-le-tit">订单管理</div>
		<div class="sghsc-order-le-wz"><a onclick="openOrderPage('person/order/myOrders.html');" target="_self">我的订单</a></div>
		<div class="sghsc-order-le-wz"><a onclick="openOrderPage('person/order/memberCollects.html');" target="_self">我的收藏</a></div>
		<div class="sghsc-order-le-wz"><a onclick="openOrderPage('person/order/memberViews.html');" target="_self">我的浏览</a></div>
		<div class="sghsc-order-le-wz"><a onclick="openOrderPage('person/order/shippingAddr.html');" target="_self">收货地址</a></div>
	  </div>
	  <div class="sghsc-order-le-tit-box">
		  <div class="sghsc-order-le-tit">财富管理</div>
		  <div class="sghsc-order-le-wz">
		 	<a onclick="openOrderPage('person/pointDetail/xianjinbi.html');" target="_self">我的金米</a></div>
		  <div class="sghsc-order-le-wz">
			<a target="_self" onclick="openOrderPage('person/pointDetail/liucunbi.html');" >我的惠米</a>
		  </div>
		  <div class="sghsc-order-le-wz">
			<a target="_self" onclick="openOrderPage('person/pointDetail/myPointList.html');" >我的经验值</a>
			<!-- <img class="sghsc-order-le-wz-new" src="web/images/sghscorder/sghsc-order-new.png"> -->
		  </div>
		  <div class="sghsc-order-le-wz">
			<a target="_self" onclick="openOrderPage('person/moneyManage/myMoneyList.html');" >我的粮票</a>
		  </div>
	 </div>
	 <div class="sghsc-order-le-tit-box">
		 <div class="sghsc-order-le-tit">我的代言</div>
		 <div class="sghsc-order-le-wz"><a href="javascript:void(0);" onclick="openOrderPage('person/myYiji.html');" target="_self">一级代言</a></div>
		 <div class="sghsc-order-le-wz"><a href="javascript:void(0);" onclick="openOrderPage('person/myErji.html');" target="_self">二级代言</a></div>
		 <div class="sghsc-order-le-wz"><a href="javascript:void(0);" onclick="openOrderPage('person/mySanji.html');" target="_self">三级代言</a></div>
	 </div>
	</div>--%>
	
	
	