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
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="/person/toZhanghuguanli.html"></a>
    <h1 class="mui-title">昵称</h1>
</header>
<div class="mui-content">
    <form id="addForm" class="mui-input-group">
        <div class="mui-input-row">
            <input type="hidden" id="id" name="member.id" value="${member.id}"/>
            <input type="text" type="password" class="mui-input-clear mui-input"
                   placeholder="昵称" data-input-clear="3" value="${member.firstname}" id="firstname" name="member.firstname"></span>
        </div>
    </form>
    <div class="mui-content-padded">
        <button class="vip_but mg0" onclick="subQg()">确定</button>
    </div>
</div>
<%--<!--底部导航栏 -->
<jsp:include page="/wap/index/indexFooter.jsp"></jsp:include>--%>
<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">

    mui('body').on('tap','a',function(){
        window.top.location.href=this.href;
    });


    function subQg() {
        var firstname = $('#firstname').val();
        if (firstname == '' || firstname == null) {
            alert('<s:text name="index_0314"/>！');
            return false;
        }
        $.ajax( {
            url : '/person/personalInfo!updateBasicInfo.action',
            type : 'POST',
            data : $('#addForm').serialize(),
            success : function(data) {
                var msg = $.parseJSON(data);
                if (msg == 'success') {
                    alert('<s:text name="index_0315"/>！');
                    window.location.href="/person/toShowBasicInfo.html";
                    return true;
                }else{
                    alert('<s:text name="index_0316"/>！');
                    return false;
                }
            }
        });
    }
</script>
</html>
