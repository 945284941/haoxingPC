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
    <c:if test="${dengji==1}">
        <h1 class="mui-title order_down_black">一级提成</h1>
    </c:if>
    <c:if test="${dengji==2}">
        <h1 class="mui-title order_down_black">二级提成</h1>
    </c:if>
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="personalInfo/fenxiaoCenter.html"></a>

    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>

</header>
<div class="mui-content">
<c:if test="${empty memberList}">
    <div style="text-align: center;"><img style="margin-top: 40px;" src="images/wujilu.jpg"/></div>
</c:if>
<c:if test="${not empty memberList}">
    <c:forEach items="${memberList}" var="member">
    <div class="mt1p">
        <ul class="mui-table-view">
            <a href="personalInfo/xiaxiantichengTongji/${member.id}/1.html">
                <li class="mui-table-view-cell">

                    下线手机号
                    <span class="mui-pull-right color_999">${member.memberName}</span>

                </li>
                <li class="mui-table-view-cell">

                    联系人
                    <span class="mui-pull-right color_999">${member.truename}</span>

                </li>
                <li class="mui-table-view-cell">

                    订单量
                    <span class="mui-pull-right color_999">${member.count}</span>

                </li>
                <li class="mui-table-view-cell">

                    销售额
                    <span class="mui-pull-right color_999">
                        ￥<fmt:formatNumber type="number" value="${1 * member.total}" pattern="0.00" maxFractionDigits="2"/>
                        $<fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.total}" pattern="0.00" maxFractionDigits="2"/>
                        ADE<fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.total}" pattern="0.00" maxFractionDigits="2"/>
                    </span>

                </li>
                <li class="mui-table-view-cell">

                    提成
                    <span class="mui-pull-right color_999">
                        <fmt:formatNumber type="number" value="${1 * member.ticheng}" pattern="0.00" maxFractionDigits="2"/>
                    </span>
                </li>
            </a>
        </ul>
    </div>
    </c:forEach>
</c:if>
</div>
<div style="padding-bottom: 70px;"></div>
<!--底部导航栏 -->
<jsp:include page="/wap/index/indexFooter.jsp"></jsp:include>

<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">


</script>
</html>

