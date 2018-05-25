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
        #pingStar li{
            float: left;
            padding-right: 8px;
        }
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
        <h1 class="mui-title order_down_black">预计提成</h1>
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="personalInfo/fenxiaoCenter.html"></a>

    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>

</header>
<div class="mui-content">

    <div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted my_tab">
        <c:if test="${dengji eq '1'}">
            <a class="mui-control-item mui-active" href="personalInfo/yujiticheng/1.html">
                一级分销商
            </a>
            <a class="mui-control-item" href="personalInfo/yujiticheng/2.html">
                二级分销商
            </a>
        </c:if>
        <c:if test="${dengji eq '2'}">
            <a class="mui-control-item" href="personalInfo/yujiticheng/1.html">
                一级分销商
            </a>
            <a class="mui-control-item mui-active" href="personalInfo/yujiticheng/2.html">
                二级分销商
            </a>
        </c:if>
    </div>

    <div class="mui-slider-group">
        <div id="item1mobile" class="mui-slider-item mui-control-content mui-active my_tab_con">
            <c:if test="${empty orderList}">
                <div style="text-align: center;"><img style="margin-top: 40px;" src="images/wujilu.jpg"/></div>
            </c:if>
            <c:if test="${not empty orderList}">
                <c:forEach items="${orderList}" var="order">
                <div class="vip_mainlist clearfix mt05">
                    <h3 class="clearfix">订单编号：1654654 <span class="color_999 mui-pull-right">2015-10-15 10:00</span> </h3>
                    <div class="mui-row">
                        <div class="mui-col-sm-6 mui-col-xs-6 shuju" href="">
                            <h2>总价</h2>
                            <p>￥<fmt:formatNumber type="number" value="${1 * order.totalCost}" pattern="0.00" maxFractionDigits="2"/></p>
                            <p>$<fmt:formatNumber type="number" value="${huilv.now_rate_doc * order.totalCost}" pattern="0.00" maxFractionDigits="2"/></p>
                            <p>ADE<fmt:formatNumber type="number" value="${huilv.now_rate_dlm * order.totalCost}" pattern="0.00" maxFractionDigits="2"/></p>
                        </div>
                        <div class="mui-col-sm-6 mui-col-xs-6  shuju" href="">
                            <h2>提成</h2>
                            <p>
                                <c:if test="${dengji eq '1'}">
                                    ￥<fmt:formatNumber type="number" value="${yijibili * order.orderPoints}" pattern="0.00" maxFractionDigits="2"/>
                                </c:if>
                                <c:if test="${dengji eq '2'}">
                                    ￥<fmt:formatNumber type="number" value="${erjibili * order.orderPoints}" pattern="0.00" maxFractionDigits="2"/>
                                </c:if>
                            </p>
                            <%--<p>$80</p>
                            <p>ADE8</p>--%>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
<!--底部导航栏 -->
<jsp:include page="/wap/index/indexFooter.jsp"></jsp:include>

<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">
    mui('body').on('tap','a',function(){
        window.top.location.href=this.href;
    });

</script>
</html>

