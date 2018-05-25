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
    System.out.println(path+"___________"+basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>" />
    <title>浩星APP</title>
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
    <h1 class="mui-title">个人资料</h1>
    <a href="/person/toBianji.html" class="mui-btn mui-btn-link mui-pull-right"><span class="color_999">编辑</span></a>
</header>
<div class="mui-content">
    <ul class="buy_list">
        <li>
            <a href="/person/toShowImg.html">
                <div class="list_left">头像</div>
                <div class="list_right color_666 mui-text-right">
                    <img class="vip_avatar2" src="${member.img}" />
                </div>
            </a>
        </li>
        <li>
            <div class="list_left">姓名</div>
            <div class="list_right color_666 mui-text-right">
                ${member.truename}
            </div>
        </li>
        <li>
            <div class="list_left">证件号</div>
            <div class="list_right color_666 mui-text-right">
                ${member.card}
            </div>
        </li>
        <li>
            <div class="list_left">性别</div>
            <div class="list_right color_666 mui-text-right">
                <c:if test="${member.gender eq '1'}">男</c:if>
                <c:if test="${member.gender eq '0'}">女</c:if>
            </div>
        </li>
        <li>
            <div class="list_left">年龄</div>
            <div class="list_right color_666 mui-text-right">
                ${member.age}
            </div>
        </li>
        <li>
            <div class="list_left">生日</div>
            <div class="list_right color_666 mui-text-right">
                ${member.birthday}
            </div>
        </li>
        <li>
            <div class="list_left">手机</div>
            <div class="list_right color_666 mui-text-right">
                ${member.mobile}
            </div>
        </li>
        <li>
            <div class="list_left">邮箱</div>
            <div class="list_right color_666 mui-text-right">
                ${member.email}
            </div>
        </li>
        <li>
            <div class="list_left">QQ</div>
            <div class="list_right color_666 mui-text-right">
                ${member.qq}
            </div>
        </li>
        <li>
            <div class="list_left">微信</div>
            <div class="list_right color_666 mui-text-right">
                ${member.weiXin}
            </div>
        </li>
        <li>
            <div class="list_left">地区</div>
            <div class="list_right color_666 mui-text-right">
                ${member.area}
            </div>
        </li>
    </ul>
</div>
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