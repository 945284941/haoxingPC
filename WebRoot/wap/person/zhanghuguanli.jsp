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
    <h1 class="mui-title">账户管理</h1>
    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>
</header>
<div class="mui-content">
    <div class="vip_box clearfix">
        <div class="mui-table-view-cell">
            <a href="/person/toShowBasicInfo.html" class="mui-navigate-right">
                <span class="vip_avatar mui-pull-left"><img src="${member.img}" /></span>
            </a>
        </div>
    </div>
    <div class="mt05">
        <ul class="mui-table-view">
            <li class="mui-table-view-cell">
                <a href="/person/toShowFirstname.html" class="mui-navigate-right">
                    昵称
                    <span class="mui-pull-right mr20 color_999">${member.firstname}</span>
                </a>
            </li>
            <li class="mui-table-view-cell">
                <a href="loadReceiveAddr.html" class="mui-navigate-right">
                    收货地址
                </a>
            </li>
            <li class="mui-table-view-cell">
                <a href="showBankcard.html" class="mui-navigate-right">
                    银行卡
                </a>
            </li>
            <li class="mui-table-view-cell">
                <a href="/person/toShowMobile.html" class="mui-navigate-right">
                    手机号
                    <span class="mui-pull-right mr20 color_999">${member.username}</span>
                </a>
            </li>
            <li class="mui-table-view-cell">
                <a href="/person/toShowPassword.html" class="mui-navigate-right">
                    修改密码
                </a>
            </li>
        </ul>
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