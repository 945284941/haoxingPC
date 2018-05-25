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
    <h1 class="mui-title order_down_black">我的发布</h1>
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="person/order/huiyuanzhongxin.html"></a>
    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>
    </div>
</header>
<div class="mui-content">
    <div id="slider" class="mui-slider">
        <div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted my_tab">
            <c:if test="${wantBuyType eq '1'}">
            <a class="mui-control-item mui-active" href="qiugou/1.html">
                求购
            </a>
            <a class="mui-control-item" href="qiugou/2.html">
                二手商品
            </a>
            <a class="mui-control-item" href="qiugou/3.html">
                拼箱
            </a>
            <a class="mui-control-item" href="qiugou/4.html">
                生活圈
            </a>
            </c:if>
            <c:if test="${wantBuyType eq '2'}">
            <a class="mui-control-item" href="qiugou/1.html">
                求购
            </a>
            <a class="mui-control-item mui-active" href="qiugou/2.html">
                二手商品
            </a>
            <a class="mui-control-item" href="qiugou/3.html">
                拼箱
            </a>
            <a class="mui-control-item" href="qiugou/4.html">
                生活圈
            </a>
            </c:if>
            <c:if test="${wantBuyType eq '3'}">
            <a class="mui-control-item" href="qiugou/1.html">
                求购
            </a>
            <a class="mui-control-item" href="qiugou/2.html">
                二手商品
            </a>
            <a class="mui-control-item mui-active" href="qiugou/3.html">
                拼箱
            </a>
            <a class="mui-control-item" href="qiugou/4.html">
                生活圈
            </a>
            </c:if>
            <c:if test="${wantBuyType eq '4'}">
            <a class="mui-control-item" href="qiugou/1.html">
                求购
            </a>
            <a class="mui-control-item" href="qiugou/2.html">
                二手商品
            </a>
            <a class="mui-control-item" href="qiugou/3.html">
                拼箱
            </a>
            <a class="mui-control-item mui-active" href="qiugou/4.html">
                生活圈
            </a>
            </c:if>
        </div>

        <div class="mui-slider-group">
            <div id="item1mobile" class="mui-slider-item mui-control-content mui-active my_tab_con">
                <ul class="mui-table-view mui-table-view-chevron product">
                    <c:forEach items="${wan}" var="wan">
                    <li class="mui-table-view-cell">
                        <a href="">
                            <div class="product_img">
                                <img src="${wan.picUrl}" style="width: 136px;height: 136px"/>
                            </div>
                            <div class="product_tex">
                                <p>${wan.title}</p>
                                <div class="clearfix color_666">
                                    <p class="mui-pull-left buy_dh">
                                        <c:if test="${wantBuyType eq '1'}">求购</c:if>
                                        <c:if test="${wantBuyType eq '2'}">二手商品</c:if>
                                        <c:if test="${wantBuyType eq '3'}">拼箱</c:if>
                                        <c:if test="${wantBuyType eq '4'}">生活圈</c:if>
                                    </p>
                                    <p class="mui-pull-right buy_dh right0"><fmt:formatDate value="${wan.createDate}" pattern="yyyy-MM-dd HH:mm" /></p>
                                </div>
                            </div>
                        </a>
                        <p class="mui-btn shopcar_del" onclick="delAddr('${wan.id}','${wantBuyType}')"><em class="iconfont">&#xe624;</em></p>
                    </li>
                    </c:forEach>
                </ul>
            </div>
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

    function delAddr(id,buyType){

        if(confirm("确认要删除吗?")){
            $.ajax({
                url : "Release!DelectWant.action",
                type : "POST",
                data : {id:id,buyType:buyType},
                dataType : "JSON",
                success : function(){
                    window.location.href="qiugou/"+buyType+".html";

                }
            });
        }
    }

</script>
</html>

