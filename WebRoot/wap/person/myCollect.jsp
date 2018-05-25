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
    <base href="<%=basePath%>" />
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
    <h1 class="mui-title">我的收藏</h1>
    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>
</header>

<div class="mui-content">
    <div id="slider" class="mui-slider">
        <div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted my_tab">
           <c:if test="${type=='1'}">
            <a class="mui-control-item mui-active" id="goods" href="showMyCollect/1.html">
                商品收藏
            </a>
            <a class="mui-control-item" id="shop" href="showMyCollect/2.html">
                店铺收藏
            </a>
            </c:if>
            <c:if test="${type=='2'}">
            <a class="mui-control-item" id="goods" href="showMyCollect/1.html">
            商品收藏
            </a>
            <a class="mui-control-item mui-active" id="shop" href="showMyCollect/2.html">
                店铺收藏
            </a>
            </c:if>
        </div>

        <div class="mui-slider-group">
            <c:if test="${empty memberCollectList}">
                <div style="text-align: center;"><img style="margin-top: 80px" src="images/wujilu.jpg"/></div>
            </c:if>
            <c:if test="${not empty memberCollectList}">
                <c:if test="${type == 1}">
                        <div id="item1mobile" class="mui-slider-item mui-control-content mui-active my_tab_con">
                            <ul class="mui-table-view mui-table-view-chevron product">
                            <c:forEach items="${memberCollectList}" var="memberCollect">
                                <li class="mui-table-view-cell">
                                    <a href="">
                                        <div class="product_img">
                                            <img src="${memberCollect.defaultPicSrc}"/>
                                            <p>仅剩${memberCollect.store}件</p>
                                            <span>抢购</span>
                                        </div>
                                        <div class="product_tex">
                                            <p>${memberCollect.name}</p>
                                            <div class="clearfix buying_tex">
                                                <div class="mui-pull-left">
                                                    <p>￥<em>${memberCollect.price}</em></p>
                                                    <s>￥<em>${memberCollect.yuanjia}</em></s>
                                                </div>
                                                <div class="mui-pull-right mui-text-right">
                                                    <p class="fn09">$<em><fmt:formatNumber type="number" value="${huilv.now_rate_doc * memberCollect.price}" pattern="0.00" maxFractionDigits="2"/></em></p>
                                                    <p class="fn09">AED<em><fmt:formatNumber type="number" value="${huilv.now_rate_dlm * memberCollect.price}" pattern="0.00" maxFractionDigits="2"/></em></p>
                                                </div>
                                            </div>
                                            <div class="clearfix mui-text-right"></div>
                                        </div>
                                    </a>
                                    <p class="unfavorite" href=""><a href="javascript:void(0);" onclick="delCollect('${memberCollect.id}','${type}')">取消收藏</a></p>
                                </li>
                            </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                    <c:if test="${type == 2}">
                        <div id="item2mobile" class="mui-slider-item mui-control-content my_tab_con">
                            <ul class="mui-table-view mui-table-view-chevron product">
                                <c:forEach items="${memberCollectList}" var="memberCollect">
                                <li class="mui-table-view-cell">
                                    <a href="">
                                        <div class="product_img">
                                            <img src="${memberCollect.img}" />
                                        </div>
                                        <div class="product_tex">
                                            <p>${memberCollect.shoperName}</p>
                                            <span class="color_666">${memberCollect.shoperContent}</span>
                                        </div>
                                    </a>
                                    <p class="unfavorite" href=""><a href="javascript:void(0);" onclick="delCollect('${memberCollect.id}','${type}')">取消收藏</a></p>
                                </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>
            </c:if>
        </div>
    </div>
</div>
<!--底部导航栏 -->
<jsp:include page="/wap/index/indexFooter.jsp"></jsp:include>
    <script src="/wap/js/mui.min.js"></script>
    <script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">

    mui('body').on('tap','a',function(){
        window.top.location.href=this.href;
    });

    //取消收藏
    function delCollect(id,type){
        if(confirm("确认要删除吗?")){
            $.ajax({
                url : "memberCallAction!delCollect.action",
                type : "POST",
                data : "id="+id,
                dataType : "JSON",
                success : function(){
                    window.location.href="showMyCollect"+type+".html";
                }
            });
        }
    }

</script>
</html>