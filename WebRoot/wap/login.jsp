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
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <h1 class="mui-title">登录</h1>
</header>
<div class="mui-content">
    <div><img src="/wap/images/vip_banenr.jpg" /></div>
    <form id="loginFrom" class="mui-input-group">
        <div class="mui-input-row">
            <input id="loginName" name="loginName" type="text" class="mui-input-clear mui-input" placeholder="已验证手机号" data-input-clear="2"><span class="mui-icon mui-icon-clear mui-hidden"></span>
        </div>
        <div class="mui-input-row">
            <input id="loginPwd" name="loginPwd" type="password" class="mui-input-clear mui-input" placeholder="密码" data-input-clear="3"><span class="mui-icon mui-icon-clear mui-hidden"></span>
        </div>
    </form>
    <div class="mui-content-padded">
        <button class="vip_but mg0" onclick="loginFromSub()">登录</button>
        <div class="link-area mt05">
            <a class="mui-pull-left" id='register'>注册</a>
            <a class="mui-pull-right" href="toMemberCheckMsg.html">忘记密码？</a>
        </div>
    </div>
</div>

<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/jquery.cookie.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">
    var loginByUrl = '';
    $('#register').on('click',function () {
        window.location.href="login!toRegister.action";
    })
    function loginFromSub() {
        var loginName = $('#loginName').val();
        var loginPwd = $('#loginPwd').val();
        if (loginName == '' || loginName == null) {
            alert('<s:text name="index_0275"/>');
            return false;
        }
        if (loginPwd == '' || loginPwd == null) {
            alert('<s:text name="index_0278"/>');
            return false;
        }
        $.ajax( {
            url : 'login.html',
            type : 'POST',
            data : $('#loginFrom').serialize(),
            success : function(data) {
                var msg = $.parseJSON(data);
                if (msg == 'nameError') {
                    $('#loginName').focus();
                    alert('<s:text name="index_0279"/>');
                    return false;
                }else if (msg == 'pwdError') {
                    $('#loginPwd').focus();
                    alert('<s:text name="index_0280"/>');
                    return false;
                }else if (msg == 'success') {

                  /*  if ($("#remember").attr("checked") == "checked") {*/
                        var userName = $("#loginName").val();
                        var passWord = $("#loginPwd").val();
              /*          $.cookie("remember", "true", { expires: 7 });*/
                        $.cookie("userName", userName, { expires: 7 });
                        $.cookie("passWord", passWord, { expires: 7 });
               /*     } else {
                        $.cookie("remember", "false", { expires: -1 });        // 删除 cookie
                        $.cookie("userName", '', { expires: -1 });
                        $.cookie("passWord", '', { expires: -1 });
                    }*/

                    //登录成功 跳转至 index.jsp
                    if(loginByUrl != null && loginByUrl != ''){
                        window.location.href = loginByUrl;
                    }else{
                        window.location.href = "/";
                    }
                    return true;
                }
            }
        });
    }
</script>
</html>