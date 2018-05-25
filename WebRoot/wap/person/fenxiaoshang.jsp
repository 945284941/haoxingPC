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
    <h1 class="mui-title order_down_black">分销商</h1>
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="personalInfo/fenxiaoCenter.html"></a>

    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>

</header>
<div class="mui-content">
    <div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted my_tab">
        <c:if test="${dengji eq '1'}">
            <a class="mui-control-item mui-active" href="personalInfo/fenxiaoshang/1.html">
                一级分销商
            </a>
            <a class="mui-control-item" href="personalInfo/fenxiaoshang/2.html">
                二级分销商
            </a>
        </c:if>
        <c:if test="${dengji eq '2'}">
            <a class="mui-control-item" href="personalInfo/fenxiaoshang/1.html">
                一级分销商
            </a>
            <a class="mui-control-item mui-active" href="personalInfo/fenxiaoshang/2.html">
                二级分销商
            </a>
        </c:if>
    </div>
    <div class="mui-slider-group">
        <div id="item1mobile" class="mui-slider-item mui-control-content mui-active my_tab_con">
            <div class="shuju_search">
                <input class="fxs_input" type="text" name="name" id="name" placeholder="手机号/姓名" />
                <button onclick="chaxun();">查询</button>
            </div>
            <div class="vip_mainlist clearfix mt05">
                <h3 class="clearfix">分销商统计 </h3>
                <div class="mui-segmented-control mui-segmented-control-inverted">
                    <div class="mui-control-item shuju" href="">
                        <h2>昨日</h2> <c:if test="${yesToday != null}">${yesToday}</c:if><c:if test="${yesToday == null}">0</c:if>
                    </div>
                    <div class="mui-control-item shuju" href="">
                        <h2>今日</h2> <c:if test="${today != null}">${today}</c:if><c:if test="${today == null}">0</c:if>
                    </div>
                    <div class="mui-control-item shuju" href="">
                        <h2>本周</h2> <c:if test="${week != null}">${week}</c:if><c:if test="${week == null}">0</c:if>
                    </div>
                    <div class="mui-control-item shuju" href="">
                        <h2>本月</h2> <c:if test="${month != null}">${month}</c:if><c:if test="${month == null}">0</c:if>
                    </div>
                    <div class="mui-control-item shuju" href="">
                        <h2>全部</h2> <c:if test="${total != null}">${total}</c:if><c:if test="${total == null}">0</c:if>
                    </div>
                </div>
            </div>
            <c:if test="${empty memberListNew}">
                <div style="text-align: center;"><img style="margin-top: 40px;" src="images/wujilu.jpg"/></div>
            </c:if>
            <c:if test="${not empty memberListNew}">
            <c:forEach items="${memberListNew}" var="member">
                <div class="app_box3 mt05 linheg26">
                    <p>手 机： ${member.mobile}</p>
                    <p>姓 名： ${member.truename}</p>
                    <p>等 级： ${member.memberLvName}</p>
                    <p>注册时间： <fmt:formatDate value="${member.regTime}" pattern="yyyy-MM-dd"/></p>
                </div>
            </c:forEach>
            </c:if>
        </div>


    </div>
</div>
<!--底部导航栏 -->
<%--<jsp:include page="/wap/index/indexFooter.jsp"></jsp:include>--%>

<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">

    mui('body').on('tap','a',function(){
        window.top.location.href=this.href;
    });

    //条件查询
    function chaxun() {
        var value = $("#name").val();
        if(value == null || value == ''){
            alert('查询条件不能为空');
            return false;
        }
        $.ajax({
            url : 'personalInfo/fenxiaoshang/${dengji}.html',
            type : 'POST',
            async : false,
            data : {value:value},
            success : function(data) {

            }
        });
    }

</script>
</html>

