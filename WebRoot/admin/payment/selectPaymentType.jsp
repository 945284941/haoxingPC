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
			<span class="fl">订单支付</span>
			<ul class="lh_wdgwc_top_right fr">
				<li>1.我的购物车</li>
				<li>2.确认订单</li>
				<li class="cartcur">3.支付订单</li>
			</ul>
		</div>
		<div class="lh_wdgwc_zfdd">
			<div class="cacart1 fl">
				<div class="order_cg">订单提交成功，请您尽快付款！ 订单号：9574991670</div>
				<div class="order_cg_nr">
					<p>
						<span>交易金额：￥500.00（$50.00  AED20.00）</span>
						<span></span>
						<span> </span>
					</p>
					<p><span>颐佳币：-100（￥500.00   $50.00  AED20.00）</span></p>
					<p><span>还需支付：￥500.00（$50.00  AED20.00）</span></p>
					<p><span>温馨提示： 请您在24小时内完成支付，否则订单会被自动取消（以订单详情页为准）。</span></p>
				</div>
			</div>

			<div class="lh_zf_2018_dz">
				<p>收货地址：山东济南市历下区中润世纪广场18栋402</p>
				<p>收货人：小A 139****6893</p>
				<p>商品名称：商品A，商品B，商品C</p>
			</div>

			<div class="lh_zf_2018_dz">
				<div class="lh_zf_2018_zf">选择支付币种：</div>
				<div class="lh_zf_2018_bz">
					<ul>
						<li>
							<label>
								<input type="radio" name="pid" value="39">
								<span>人名币（CNY）</span>
							</label>
						</li>
						<li>
							<label>
								<input type="radio" name="pid" value="39">
								<span>美元（USD）</span>
							</label>
						</li>
						<li>
							<label>
								<input type="radio" name="pid" value="39">
								<span>迪拉姆（AED）</span>
							</label>
						</li>
					</ul>
				</div>
			</div>

			<div class="lh_zf_2018_dz">
				<div class="lh_zf_2018_zf">选择支付方式：</div>
				<div class="lh_zf_2018_bz">
					<ul>
						<li>
							<label>
								<input type="radio" name="pid" value="39">
								<span>支付宝</span>
							</label>
						</li>
						<li>
							<label>
								<input type="radio" name="pid" value="39">
								<span>paypal</span>
							</label>
						</li>
						<li>
							<label>
								<input type="radio" name="pid" value="39">
								<span>线下支付</span>
							</label>
						</li>
					</ul>
				</div>
			</div>

			<div class="zffs_zfan"><a href="#" class="te_m">确认支付</a></div>
		</div>
	</div>
</div>
<jsp:include page="../../admin/common/indexFooter.jsp" />
</body>
</html>

  
  
  
