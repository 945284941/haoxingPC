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
    <h1 class="mui-title">重设密码</h1>
</header>
<div class="mui-content">
    <form id="editFrom" class="mui-input-group">
        <div class="mui-input-row">
            <input id="username" name="loginName" type="text" class="mui-input-clear mui-input" placeholder="手机号" data-input-clear="3"></span>
        </div>
        <div class="mui-input-row">
            <input type="password" name="loginPwd"  id="password" placeholder="密码">
        </div>
        <div class="mui-input-row">
            <input type="password" id="repassword" placeholder="确认密码">
        </div>
        <div class="mui-input-row">
            <input id="loginCode" type="text" name="loginCode" class="mui-input-clear mui-input" placeholder="验证码" data-input-clear="3"></span>
            <a class="hqyzm"  style="width:80px;text-align: center;" onclick="getCode(this)" id="J_getCode">获取验证码</a>
            <a class="hqyzm"  id="J_resetCode" style="display: none;width:80px;text-align: center;">重新发送</a>
            <a class="hqyzm" id="J_second" style="display: none;width:80px;text-align: center;" >60</a>
        </div>
    </form>
    <div class="mui-content-padded">
        <button class="vip_but mg0" onclick="EditPassWord()">确定</button>
        <div class="link-area mt05">
            <a class="mui-pull-left" href="toLogin.html">登录</a>
            <a class="mui-pull-right" href="toRegister.html">注册</a>
        </div>
    </div>
</div>
<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>

<script type="text/javascript">
    function EditPassWord(){

         var username=$('#username').val();
         var password=$('#password').val();
         var repassword=$('#repassword').val();
         var loginCode=$('#loginCode').val();
        if(username == '') {
            mui.alert("请输入手机号","提示","确定",function () {
                $('#username').focus();
            });
            return false;
        }else if(loginCode == ''){
            mui.alert("请输入验证码!","提示","确定",function () {
                $('#loginCode').focus();
            });
            return false;
        }else if(password == ''){
            mui.alert("请输入登录密码","提示","确定",function () {
                $('#password').focus();
            });
            return false;
        }else if(repassword == ''){
            mui.alert("请输入确认密码","提示","确定",function () {
                $('#repassword').focus();
            });
            return false;
        }else if(password != repassword){
            mui.alert("登录密码和确认密码输入不一致，请重新输入！","提示","确定",function () {
                $("#password").focus();
                $('#repassword').focus();
            });
            return false;
        }
        $.ajax({
            url:'toMemberCheckPwdMsgByPhone.html',
            data:$('#editFrom').serialize(),
            dataType:'json',
            success:function (_data) {
               if(_data.msg=='success'){
                   mui.alert("修改成功","提示","确定",function () {
                       $('#editFrom')[0].reset();
                   });

               }
                if(_data.msg=='randNumError'){
                    mui.alert("验证码错误请重新输入","提示","确定",function () {

                    });

                }
            }
        })
    }
    /*获取验证码*/
    function getCode(e){
        var isPhone = true;
        var loginName = $("#username").val();
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
                        $('#username').focus();
                        mui.alert("<s:text name='index_0282'/>","提示","确定",function () {
                            $('#username').focus();
                        });
                        return false;
                    }
                }
            });

        }
    }
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