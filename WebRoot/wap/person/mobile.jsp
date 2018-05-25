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
    <h1 class="mui-title">更换手机</h1>
</header>
<div class="mui-content">
    <form id="addForm" class="mui-input-group">
        <input type="hidden" id="id" name="member.id" value="${member.id}">
        <div class="mui-input-row">
            <input type="password" id="password" name="password" class="mui-input-password" placeholder="登录密码">
        </div>
        <div class="mui-input-row">
            <input id="username" name="username" type="text" class="mui-input-clear mui-input" placeholder="新手机号" data-input-clear="3"></span>
        </div>
        <div class="mui-input-row">
            <input id="randNum" type="text" name="randNum" class="mui-input-clear mui-input" placeholder="验证码" data-input-clear="3"></span>
            <a class="hqyzm"  style="width:80px;text-align: center;" onclick="getCode(this)" id="J_getCode">获取验证码</a>
            <a class="hqyzm"  id="J_resetCode" style="display: none;width:80px;text-align: center;">重新发送</a>
            <a class="hqyzm" id="J_second" style="display: none;width:80px;text-align: center;" >60</a>
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

//    mui('body').on('tap','a',function(){
//        window.top.location.href=this.href;
//    });


    /*获取验证码*/
    function getCode(e){
        var isPhone = true;
        var username = $("#username").val();
        if(isPhone) {
            resetCode(); //倒计时
            //发送短信验证码
            $.ajax( {
                url : '/person/personalInfo!sendNewCode.action',
                type : 'POST',
                data : {
                    "username": username,
//                    "codeType":"2"
                },
                success : function(data) {
                    var msg = $.parseJSON(data);
                    if (msg == '001') {
                        $('#username').focus();
                        alert('<s:text name="index_0282"/>！');
                        return false;
                    }
                }
            });

        }
    }

    //    //验证手机号码
    //    function checkPhone(){
    //        var phone = $('#loginName').val();
    //        var pattern = /^1[0-9]{10}$/;
    //        if(phone == '') {
    //            alert('请输入手机号码');
    //            return false;
    //        }else if(!pattern.test(phone)){
    //            alert('请输入正确的手机号码');
    //            return false;
    //        }else{
    //            return true;
    //        }
    //    }
    function subQg(){
        var randNum = $("#randNum").val();
        var password = $("#password").val();
        if(randNum == ''){
            alert("请输入验证码！");
            $("#loginCode").focus();
            return false;
        }else if(password == ''){
            alert("请输入登录密码！");
            $("#password").focus();
            return false;
        }else{
            //修改电话
            $.ajax( {
                url : '/person/personalInfo!updateMobile.action',
                type : 'POST',
                data : $('#addForm').serialize(),
                success : function(data) {
                    var msg = $.parseJSON(data);
                    if (msg == 'success') {
                        alert("<s:text name="index_0315"/>！");
                        window.location.href="/person/toShowBasicInfo.html";
                        return true;
                    }else{
                        alert("<s:text name="index_0316"/>！");
                        return false;
                    }
                }
            });
        }
    }

    //倒计时
    function resetCode() {
        $('#J_getCode').hide();
        $('#J_second').html('60');
        $('#J_second').show();
        var second = 60;
        var timer = null;
        timer = setInterval(function () {
            second -= 1;
            if (second > 0) {
                $('#J_second').html(second);
            } else {
                clearInterval(timer);
                $('#J_getCode').html("重新发送");
                $('#J_getCode').show();
                $('#J_second').hide();
            }
        }, 1000);
    }
</script>
</html>
