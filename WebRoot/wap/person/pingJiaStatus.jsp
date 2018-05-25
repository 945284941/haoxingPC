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
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="person/order/huiyuanzhongxin.html"></a>
    <h1 class="mui-title">商品评价</h1>
    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>
</header>
<div class="mui-content">
    <div id="slider" class="mui-slider">
        <div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted my_tab">
            <c:if test="${appraise=='1'}">
            <a class="mui-control-item mui-active" href="person/order/pingJiaStatus/1.html">
                已评价
            </a>
            <a class="mui-control-item" href="person/order/pingJiaStatus/0.html">
                未评价
            </a>
            </c:if>
            <c:if test="${appraise=='0'}">
            <a class="mui-control-item" href="person/order/pingJiaStatus/1.html">
                已评价
            </a>
            <a class="mui-control-item mui-active" href="person/order/pingJiaStatus/0.html">
                未评价
            </a>
            </c:if>
        </div>

        <div class="mui-slider-group">
            <c:if test="${empty orderItems}">
                <div style="text-align: center;"><img style="margin-top: 80px" src="images/wujilu.jpg"/></div>
            </c:if>
            <c:if test="${not empty orderItems}">
            <div id="item1mobile" class="mui-slider-item mui-control-content mui-active my_tab_con">
                <ul class="mui-table-view mui-table-view-chevron product clearfix">

                    <c:forEach items="${orderItems}" var="item">
                        <li class="mui-table-view-cell bg_gray">
                            <a href="">
                                <div class="product_img">
                                    <img src="${item.defaultPicSrc}" />
                                    <%--<p>仅剩3件</p>
                                    <span>抢购</span>--%>
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
                            <p class="mui-text-right">
                                <c:if test="${appraise=='1'}">
                                    <a class="order_but order_but2" >已评价</a>
                                </c:if>
                                <c:if test="${appraise=='0'}">
                                    <a class="order_but order_but2" href="person/order/toComment/${item.id}.html">去评价</a>
                                </c:if>
                            </p>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            </c:if>
        </div>
    </div>
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

    mui('body').on('tap','a',function(){
        window.top.location.href=this.href;
    });

    //设置默认
    function setDefault(id){
        $(this).attr("checked","checked");
        $.ajax({
            url : "memberCallAction!setDefaultBankcard.action",
            type : "POST",
            data : "id="+id,
            dataType : "JSON",
            success : function(){
                window.location.href="showBankcard.html";
            }
        });
    }

    //删除银行卡
    function delBankcard(id){
        if(confirm("<s:text name='index_0326'/>?")){
            $.ajax({
                url : "memberCallAction!delBankcard.action",
                type : "POST",
                data : "id="+id,
                dataType : "JSON",
                success : function(){
                    window.location.href="showBankcard.html";
                }
            });
        }
    }

</script>
</html>

