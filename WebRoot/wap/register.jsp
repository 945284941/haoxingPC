<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="/wap/css/mui.min.css" rel="stylesheet" />
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
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <h1 class="mui-title">注册</h1>
</header>
<div class="mui-content">
    <form id="registerFrom" class="mui-input-group">
        <div class="mui-input-row">
            <input id="loginName" type="text" name="loginName"
                   class="mui-input-clear mui-input" placeholder="手机号" data-input-clear="3"></span>
        </div>
        <div class="mui-input-row">
            <input id="randNum" type="password" name="loginCode" class="mui-input-clear mui-input" placeholder="验证码" data-input-clear="3"></span>
            <a class="hqyzm"  style="width:80px;text-align: center;" onclick="getCode(this)" id="J_getCode">获取验证码</a>
            <a class="hqyzm"  id="J_resetCode" style="display: none;width:80px;text-align: center;">重新发送</a>
            <a class="hqyzm" id="J_second" style="display: none;width:80px;text-align: center;" >60</a>
        </div>
        <div class="mui-input-row">
            <input type="password" id="password" name="member.password" placeholder="密码">
        </div>
        <div class="mui-input-row">
            <input type="password" id="repassword" placeholder="确认密码">
        </div>
        <div class="mui-input-row">
            <input type="password" name="member.shangjiId" id="shangjiId" placeholder="推荐码（选填）">
        </div>
    </form>
    <div class="mui-content-padded">
        <button class="vip_but mg0" onclick="subRegister()">注册</button>
        <div class="link-area mt05">
            <a class="mui-pull-left" id='reg'><input type="checkbox" name="" id="Agreement" value="" /> <span class="color_666">同意</span>《商城注册协议》</a>
        </div>
    </div>
</div>
<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script type="text/javascript">

    function subRegister(){
        var loginName = $("#loginName").val();
        var randNum = $("#randNum").val();
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        if(loginName == '') {
            mui.alert("请输入手机号","提示","确定",function () {
                $("#loginName").focus();
            });
            return false;
        }else if(randNum == ''){
            mui.alert("请输入验证码","提示","确定",function () {
                $("#randNum").focus();
            });
            return false;
        }else if(password == ''){
            mui.alert("请输入登录密码","提示","确定",function () {
                $("#password").focus();
            });
            return false;
        }else if(repassword == ''){
            mui.alert("请输入确认密码","提示","确定",function () {
                $("#repassword").focus();
            });
            return false;
        }else if(password != repassword){
            mui.alert("登录密码和确认密码输入不一致","提示","确定",function () {
                $("#password").focus();
            });
            return false;
        }if(!$('#Agreement').is(':checked')){
            mui.alert("请同意商城注册协议","提示","确定",function () {
                $("#loginName").focus();
            });
           return false;
        }else{
            //注册信息
            $.ajax( {
                url : 'register.html',
                type : 'POST',
                data : $('#registerFrom').serialize(),
                success : function(data) {
                    var msg = $.parseJSON(data);
                    if (msg == 'randNumError') {
                        mui.alert("输入的验证码不正确，请重新输入！","提示","确定",function () {
                            $("#randNum").focus();
                        });
                        return false;
                    }
                    if (msg == 'pIdisno') {
                        mui.alert("输入的推荐码不存在，请重新输入或者不输入任何字符！","提示","确定",function () {
                            $("#shangjiId").focus();
                        });
                        return false;
                    }
                    if (msg == 'sysError') {
                        mui.alert("注册失败，请联系管理员！","提示","确定",function () {

                        });

                        return false;
                    }
                    if(msg == 'isexist'){
                        mui.alert("很抱歉，该手机号已经被注册，不能重复注册！","提示","确定",function () {
                        });
                        return false;
                    }
                    if(msg == '000'){
                        mui.alert("恭喜您，注册成功！","提示","确定",function () {
                            window.location.href = "login!toLogin.action";

                        });
                        //window.location.href = "toLogin.html";

                    }
                }
            });
        }
    }
    /*获取验证码*/
    function getCode(e){
        var isPhone = true;
        var loginName = $("#loginName").val();
        if(isPhone) {
            resetCode(); //倒计时
            //发送短信验证码
            $.ajax( {
                url : 'sendCode.html',
                type : 'POST',
                data : {
                    "loginName": loginName
                },
                success : function(data) {
                    var msg = $.parseJSON(data);
                    if (msg == '001') {
                        $('#loginName').focus();
                        alert('<s:text name="index_0282"/>');
                        return false;
                    }
                }
            });

        }
    }

    //倒计时
    function resetCode(){
        $('#J_getCode').hide();
        $('#J_second').html('60');
        $('#J_second').show();
        var second = 60;
        var timer = null;
        timer = setInterval(function(){
            second -= 1;
            if(second >0 ){
                $('#J_second').html(second);
            }else{
                clearInterval(timer);
                $('#J_getCode').html("重新发送");
                $('#J_getCode').show();
                $('#J_second').hide();
            }
        },1000);
    }
</script>
</html>