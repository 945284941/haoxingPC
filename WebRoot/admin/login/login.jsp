<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="IE=11.0000" http-equiv="X-UA-Compatible">
        <jsp:include page="../common/keyWords.jsp" />
        <title>颐佳超市</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="3c0d2bedd819ab1c" property="wb:webmaster">
    </head>

<body>
<!-- heard -->
<div id="header_form">
    <div class="head_width" id="head_h">
        <div class="head clearfix">
            <div class="logo sline" >
                <a href="#"><img src="images/logo.png" border="0"> </a>
            </div>

            <div class="lh_zcdl"><s:text name="index_0112"/></div>
            <div class="lh_zcdl_right"><s:text name="index_0274"/></div>

        </div>
    </div>
</div>
<!-- heard结束 -->

<div class="lh_zcdl_nrbj">
    <div class="main">
        <div class="login_cont_ny_r" style="margin-top:110px;">
            <form id="loginFrom" action="login.html" method="post">
                <div class="login_cont_ny_r_t">
                    <div class="login_cont_ny_r_t_l"><s:text name="index_0112"/></div>
                    <div class="login_cont_ny_r_t_r"><s:text name="index_0276"/>,
                        <a href="toRegister.html"><span style="color:#ff5165;"><s:text name="index_0114"/></span></a>
                    </div>
                </div>
                <div class="login_cont_ny_r_m">
                    <input name="loginName" type="text" placeholder="<s:text name="index_0113"/>"  class="login_bk"  style="height:40px;" id="loginName" />
                    <input name="loginPwd" type="password" placeholder="<s:text name="index_0107"/>" class="login_bk2" style="height:40px;" id="loginPwd"/>
                    <div class="login_cont_ny_r_wz">
                        <div class="login_cont_ny_r_wz_input"><input name="remember" type="checkbox" id="remember"/><s:text name="index_0277"/></div>
                        <a href="toMemberCheckMsg.html" style="text-decoration: underline;"><s:text name="index_0115"/></a>
                    </div>
                </div>
                <div class="login_cont_ny_r_b" >
                    <a href="javascript:void(0);" onclick="loginFromSub();"><s:text name="index_0112"/></a>
                </div>
            </form>
        </div>

    </div>
</div>

<!--footer开始-->
<s:action name="indexFloorAction!toSimplifyFoot" namespace="/indexFloor"  executeResult="true"  />
<!--footer结束-->
<script>
    var loginByUrl = '';
    /**
     * 登录验证
     * @returns {Boolean}
     */
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
                    if ($("#remember").attr("checked") == "checked") {
                        var userName = $("#loginName").val();
                        var passWord = $("#loginPwd").val();
                        $.cookie("remember", "true", { expires: 7 });
                        $.cookie("userName", userName, { expires: 7 });
                        $.cookie("passWord", passWord, { expires: 7 });

                    }
                    else {
                        $.cookie("remember", "false", { expires: -1 });        // 删除 cookie
                        $.cookie("userName", '', { expires: -1 });
                        $.cookie("passWord", '', { expires: -1 });

                    }
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
    $(function() {
        if ($.cookie("remember") == "true") {
            $("#remember").attr("checked", true);
            $("#loginName").val($.cookie("userName"));
            $("#loginPwd").val($.cookie("passWord"));
        }
    });

//    /*获取验证码*/
//    var isPhone = 1;
//    function getCode(e){
//        checkPhone(); //验证手机号码
//        if(isPhone){
//            resetCode(); //倒计时
//        }else{
//            $('#phone').focus();
//        }
//
//    }
//    //验证手机号码
//    function checkPhone(){
//        var phone = $('#phone').val();
//        var pattern = /^1[0-9]{10}$/;
//        isPhone = 1;
//        if(phone == '') {
//            alert('请输入手机号码');
//            isPhone = 0;
//            return;
//        }
//        if(!pattern.test(phone)){
//            alert('请输入正确的手机号码');
//            isPhone = 0;
//            return;
//        }
//    }
//    //倒计时
//    function resetCode(){
//        $('#J_getCode').hide();
//        $('#J_second').html('60');
//        $('#J_second').show();
//        var second = 60;
//        var timer = null;
//        timer = setInterval(function(){
//            second -= 1;
//            if(second >0 ){
//                $('#J_second').html(second);
//            }else{
//                clearInterval(timer);
//                $('#J_getCode').html("重新发送");
//                $('#J_getCode').show();
//                $('#J_second').hide();
//            }
//        },1000);
//    }
</script>
</body>
</html>