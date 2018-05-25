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
</header>
<div class="mui-content">
    <div class="mui-content-padded">
        <form action="questionAskAction!addyi.action"   method="post">
            <textarea class="mg0" name="question" id="question" rows="5" cols="" placeholder="留下您宝贵的意见或建议"></textarea>
        </form>
        <button class="vip_but" onclick="baocun()">保存</button>
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

    function baocun(){
        var question = $("#question").val();
        if(question == null || question == ''){
            alert('内容不能为空');
            return false;
        }
        $.ajax({
            url : 'questionAskAction!addyi.action',
            type : 'POST',
            data : {question:question},
            success : function(data) {
                var r = $.parseJSON(data);
                if (r == 'ok') {
                    alert('保存成功');
                    window.location.href = "person/order/huiyuanzhongxin.html";
                } else {
                    alert('保存失败');
                    return false;
                }
            }
        });
    }

</script>
</html>

