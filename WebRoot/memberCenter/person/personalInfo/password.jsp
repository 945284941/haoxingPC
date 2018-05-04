<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=7" />
    <jsp:include page="/admin/common/keyWords.jsp" />
    <title>颐佳商城</title>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta http-equiv="keywords" content="颐佳,商城" />
    <meta http-equiv="description" content="颐佳,商城" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- <link rel="stylesheet" href="web/bootstrap/bootstrap.min.css" type="text/css" /> -->
    <link rel="stylesheet" href="web/css/sghsc-main.css" type="text/css" />
    <link rel="stylesheet" href="web/css/sghsc-order.css" type="text/css" />
    <link rel="stylesheet" href="web/css/datePicker.css" />

    <link rel="stylesheet" href="css/common.css" type="text/css" />
    <link rel="stylesheet" href="css/hyzxgr.css" type="text/css" />
    <link rel="stylesheet" href="css/page.css" type="text/css" />

    <script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
    <script type=text/javascript src="js/layer/layer.min.js"></script>
    <script type=text/javascript src="js/slides.jquery.js"></script>
    <script type=text/javascript src="js/tanchu.js"></script>
    <script type=text/javascript src="js/register.js"></script>
    <script type="text/javascript" src="js/layer/layer.js"></script>

    <!-- 日历控件 -->
    <script type="text/javascript" src="web/js/jquery.date_input.pack.js"></script>
    <!-- 解决IE6不缓存背景图片的问题-->
    <!--[if IE 6]>
    <script type="text/javascript">
        document.execCommand("BackgroundImageCache", false, true);
    </script>
    <![endif]-->
</head>
<body>
<div id="tanchu"></div>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toPersionLogo" executeResult="true" namespace="/"></s:action>

<div style="background: #f6f6f6;">
    <div class="main">
        <!--我是买家-->
        <div class="h_content">
            <!-- 左侧功能菜单开始 -->
            <jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" />
            <!-- 左侧功能菜单结束 -->
            <div class="w-buyers">
                <div class="l-fr">
                    <div class="w-title">
                        <h3>设置>个人信息</h3>
                    </div>
                </div>
                <div class="l-fr1 tgar">
                    <div class="slideTxtBox">
                        <div class="hd">
                            <ul>
                                <li>
                                    <a href="/person/toShowBasicInfo.html">基本信息</a>
                                </li>
                                <li>
                                    <a href="/person/toShowUsername.html">用户名</a>
                                </li>
                                <li>
                                    <a href="/person/toShowImg.html">更换头像</a>
                                </li>
                                <li>
                                    <a href="/person/toShowMobile.html">登录手机号</a>
                                </li>
                                <li class="on">
                                    <a href="/person/toShowPassword.html">登录密码</a>
                                </li>
                            </ul>
                        </div>
                        <div class="bd">
                            <ul>
                                <div class="h_revise">
                                    <form id="addForm" action="" enctype="multipart/form-data" method="post">
                                        <input type="hidden" value="${member.id}" name="member.id" />
                                        <dl>
                                            <dt>手机号：</dt>
                                            <dd><input type="text" size="40" class="login_bk" id="username" name="username" value="${member.username}"/></dd>
                                        </dl>
                                        <dl>
                                            <dt>验证码：</dt>
                                            <dd>
                                                <input  type="text" placeholder="验证码" class="login_yzm" style="height:40px;" id="randNum" name="randNum" style="width: 200px;"/>
                                                <div class="login_yzm_dx on" id="J_resetCode" style="display: none;">重新发送</div>
                                                <div class="login_yzm_dx on" id="J_second" style="display: none;">60</div>
                                                <div class="login_yzm_dx" onclick="getCode(this)" id="J_getCode">获取验证码</div>
                                            </dd>
                                        </dl>
                                        <dl>
                                            <dt>新密码：</dt>
                                            <dd><input class="login_bk" type="password" size="40" id="newPassword" name="newPassword"/></dd>
                                        </dl>
                                        <dl>
                                            <dt>确认密码：</dt>
                                            <dd><input class="login_bk" type="password" size="40" id="rePassword" name="rePassword"/></dd>
                                        </dl>

                                        <dl>
                                            <dt></dt>
                                            <dd><button type="button" onclick="subQg()" class="btn btn-danger">　　确认　　</button></dd>
                                        </dl>

                                    </form>
                                </div>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--我是买家-->

</div>
</div>

<jsp:include page="/admin/common/indexFooter.jsp" />
<script type="text/javascript">
    /*获取验证码*/
    function getCode(e){
        var isPhone = true;
        //checkPhone(); //验证手机号码
        var username = $("#username").val();
        if(isPhone) {
            resetCode(); //倒计时
            //发送短信验证码
            $.ajax( {
                url : '/person/personalInfo!sendNewCode.action',
                type : 'POST',
                data : {
                    "username": username,
                    "codeType":"2"
                },
                success : function(data) {
                    var msg = $.parseJSON(data);
                    if (msg == '001') {
                        $('#username').focus();
                        alert('<s:text name="index_0282"/>');
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
        var username = $("#username").val();
        var randNum = $("#randNum").val();
        var newPassword = $("#newPassword").val();
        var rePassword = $("#rePassword").val();
        if(username == '') {
            alert("请输入登录手机号！");
            $("#username").focus();
            return false;
        }else if(randNum == ''){
            alert("请输入验证码！");
            $("#randNum").focus();
            return false;
        }else if(newPassword == ''){
            alert("请输入登录密码！");
            $("#newPassword").focus();
            return false;
        }else if(rePassword == ''){
            alert("请输入确认密码！");
            $("#rePassword").focus();
            return false;
        }else if(newPassword != rePassword){
            alert(newPassword);
            alert(rePassword);
            alert("登录密码和确认密码输入不一致，请重新输入！");
            $("#newPassword").focus();
            return false;
        }else{
            //修改电话
            $.ajax( {
                url : '/person/personalInfo!updatePassword.action',
                type : 'POST',
                data : $('#addForm').serialize(),
                success : function(data) {
                    var msg = $.parseJSON(data);
                    if (msg == 'success') {
                        alert("修改成功！");
                        window.location.href="/person/toShowPassword.html";
                        return true;
                    }else if(msg == 'error'){
                        alert("修改失败！");
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

</body>
</html>