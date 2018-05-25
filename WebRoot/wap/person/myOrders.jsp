<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>浩星APP</title>
    <base href="<%=basePath%>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link type="text/css" href="/wap/css/mui.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/wap/font/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/wap/css/swiper.min.css" />
    <link rel="stylesheet" type="text/css" href="/wap/css/app.css" />
    <style>
        @font-face {
            font-family: 'iconfont';
            src: url('iconfont.eot');
            src: url('iconfont.eot?#iefix') format('embedded-opentype'), url('iconfont.woff') format('woff'), url('iconfont.ttf') format('truetype'), url('iconfont.svg#iconfont') format('svg');
        }

        .iconfont {
            font-family: "iconfont" !important;
            font-size: 16px;
            font-style: normal;
            -webkit-font-smoothing: antialiased;
            -webkit-text-stroke-width: 0.2px;
            -moz-osx-font-smoothing: grayscale;
        }
    </style>
</head>
<body>
<!--头部-->
<header class="mui-bar mui-bar-nav">
    <div class="middlePopover" style="position: relative;">
        <h1 class="mui-title order_down_black"><a href="#middlePopover" class="mui-btn-outlined">我的订单<em class="iconfont">&#xe618;</em> </a></h1>
        <div id="middlePopover" class="mui-popover mui-bar-popover order_down">
            <div class="mui-popover-arrow"></div>
            <ul>
                <!--1、待付款 2、待发货 3、待收货 4、已完成  5.待评价 6.取消订单 7.退款退货中-->
                <li><a href="person/order/myOrders/1.html">待付款</a></li>
                <li><a href="person/order/myOrders/2.html">待发货</a></li>
                <li><a href="person/order/myOrders/3.html">待收货</a></li>
                <li><a href="person/order/myOrders/5.html">待评价</a></li>
                <li><a href="person/order/myOrders/4.html">已完成</a></li>
                <li><a href="person/order/myOrders/7.html">退货</a></li>
                <li><a href="person/order/myOrders/6.html">已取消</a></li>
            </ul>
        </div>
    </div>
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="person/order/huiyuanzhongxin.html"></a>
    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>
</header>
<div class="mui-content">
    <c:if test="${empty orderList}">
        <div style="text-align: center;"><img style="margin-top: 80px;" src="images/wujilu.jpg"/></div>
    </c:if>
    <c:if test="${not empty orderList}">
        <c:forEach items="${orderList}" var="order">
        <div class="app_box2 clearfix">
            <div class="mui-content-padded">${order.shopName}
                <span class="mui-pull-right fn09 color_999">
                    <c:if test="${order.status eq '1'}">待付款</c:if>
                    <c:if test="${order.status eq '2'}">待发货</c:if>
                    <c:if test="${order.status eq '3'}">待收货</c:if>
                    <c:if test="${order.status eq '4'}">已完成</c:if>
                    <c:if test="${order.status eq '5'}">待评价</c:if>
                    <c:if test="${order.status eq '6'}">已取消</c:if>
                    <c:if test="${order.status eq '7'}">退款退货中</c:if>
                </span>
            </div>
            <ul class="mui-table-view mui-table-view-chevron product clearfix">
            <a href="person/order/toOrderDetail/${order.id}.html">
            <c:forEach items="${order.items}" var="item">
                <li class="mui-table-view-cell bg_gray">
                    <a href="">
                        <div class="product_img">
                            <img src="${item.defaultPicSrc}" />
                            <%--<p>仅剩3件</p>--%>
                            <%--<span>抢购</span>--%>
                        </div>
                        <div class="product_tex">
                            <p>${item.goodsName}</p>
                            <div class="clearfix buying_tex">
                                <div class="mui-pull-left">
                                    <p>￥<em>${item.dealPrice}</em></p>
                                    <s>￥<em>${item.marketbalePrice}</em></s>
                                </div>
                                <div class="mui-pull-right mui-text-right">
                                    <p class="fn09">$<em><fmt:formatNumber type="number" value="${huilv.now_rate_doc * item.dealPrice}" pattern="0.00" maxFractionDigits="2"/></em></p>
                                    <p class="fn09">AED<em><fmt:formatNumber type="number" value="${huilv.now_rate_dlm * item.dealPrice}" pattern="0.00" maxFractionDigits="2"/></em></p>
                                </div>
                            </div>
                            <p class="mui-text-right">x${item.nums}</p>
                        </div>
                    </a>
                </li>
            </c:forEach>
            </a>
            </ul>
            <p class="mui-content-padded mui-text-right">
                共<span>${order.count}</span>件商品
                实付款
                ￥<span><fmt:formatNumber type="number" value="${1 * order.totalCost}" pattern="0.00" maxFractionDigits="2"/></span>
                $<span><fmt:formatNumber type="number" value="${huilv.now_rate_doc * order.totalCost}" pattern="0.00" maxFractionDigits="2"/></span>
                AED<span><fmt:formatNumber type="number" value="${huilv.now_rate_dlm * order.totalCost}" pattern="0.00" maxFractionDigits="2"/></span>
            </p>
            <p class="shopcar_subtotal">
                <!--1、待付款 2、待发货 3、待收货 4、已完成  5.待评价 6.取消订单 7.退款退货中-->
                <c:if test="${order.status=='1'}"><button class="mui-btn order_but" href="">去支付</button></c:if>
                <c:if test="${order.status=='2'}"><button class="mui-btn order_but" href="">取消订单</button></c:if>
                <c:if test="${order.status=='3'}"><button class="mui-btn order_but" href="">确认收货</button></c:if>
                <c:if test="${order.status=='4'}"><button class="mui-btn order_but" href="">查看订单</button></c:if>
                <c:if test="${order.status=='5'}"><button class="mui-btn order_but" href="">查看订单</button></c:if>
                <c:if test="${order.status=='6'}"><button class="mui-btn order_but" href="">删除订单</button></c:if>
                <c:if test="${order.status=='7'}"><button class="mui-btn order_but" href="">查看订单</button></c:if>
            </p>
        </div>
        </c:forEach>
    </c:if>
</div>
<%--
<!--底部导航栏 -->
<jsp:include page="/wap/index/indexFooter.jsp"></jsp:include>
--%>
<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">

   mui('#middlePopover').on('tap','a',function(){
       window.top.location.href=this.href;
   });
   mui('.mui-content').on('tap','a',function(){
       window.top.location.href=this.href;
   });


</script>
</html>

