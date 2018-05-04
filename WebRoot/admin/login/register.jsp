<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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

            <div class="lh_zcdl">注册</div>
            <div class="lh_zcdl_right">感谢您对我们的认可！</div>

        </div>
    </div>
</div>
<!-- heard结束 -->

<div class="lh_zcdl_nrbj">
    <div class="main">
        <div class="login_cont_ny_r">
            <div class="login_cont_ny_r_t">
                <div class="login_cont_ny_r_t_l">注册</div>
                <div class="login_cont_ny_r_t_r">已有账号,
                    <a href="toLogin.html"><span style="color:#ff5165;">直接登录</span></a>
                </div>
            </div>
            <form id="registerFrom" action="register.html" method="post">
            <div class="login_cont_ny_r_m">

                <input  type="text" placeholder="手机号" class="login_bk" style="height:40px;" id="loginName" name="loginName"/>
                <input  type="text" placeholder="验证码" class="login_yzm" style="height:40px;" id="loginCode" name="loginCode" style="width: 200px;"/>
                <div class="login_yzm_dx on" id="J_resetCode" style="display: none;">重新发送</div>

                <div class="login_yzm_dx on" id="J_second" style="display: none;">60</div>
                <div class="login_yzm_dx" onclick="getCode(this)" id="J_getCode">获取验证码</div>
                <input name="member.password" id="password" type="password" placeholder="设置密码" class="login_bk2" style="height:40px;" />
                <input id="repassword" type="password" placeholder="确认密码" class="login_bk2" style="height:40px;" />
                <input name="member.shangjiId" id="shangjiId" type="text" placeholder="推荐码（选填）" class="login_bk2" style="height:40px;" />
            </div>
            <div class="login_cont_ny_r_b">
                <a href="javascript:void(0);" onclick="subRegister();">注册</a>
            </div>
            <div class="login_cont_ny_r_xy">注册即表示同意<span style="color:#222;">《商城注册协议》</span></div>
            </form>
        </div>

    </div>
</div>
<!--footer开始-->
<s:action name="indexFloorAction!toSimplifyFoot" namespace="/indexFloor"  executeResult="true"  />
<!--footer结束-->
<script type="text/javascript">
    /*获取验证码*/
    function getCode(e){
       var isPhone = true;
               //checkPhone(); //验证手机号码
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

    //验证手机号码
    function checkPhone(){
        var phone = $('#loginName').val();
        var pattern = /^1[0-9]{10}$/;
        if(phone == '') {
            alert('请输入手机号码');
            return false;
        }else if(!pattern.test(phone)){
            alert('请输入正确的手机号码');
            return false;
        }else{
            return true;
        }
    }
    function subRegister(){
        var loginName = $("#loginName").val();
        var randNum = $("#randNum").val();
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        if(loginName == '') {
            alert("请输入手机号！");
            $("#loginName").focus();
            return false;
        }else if(randNum == ''){
            alert("请输入验证码！");
            $("#randNum").focus();
            return false;
        }else if(password == ''){
            alert("请输入登录密码！");
            $("#password").focus();
            return false;
        }else if(repassword == ''){
            alert("请输入确认密码！");
            $("#repassword").focus();
            return false;
        }else if(password != repassword){
            alert(password);
            alert(repassword);
            alert("登录密码和确认密码输入不一致，请重新输入！");
            $("#password").focus();
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
                        $('#randNum').focus();
                        alert("输入的验证码不正确，请重新输入！");
                        return false;
                    }
                    if (msg == 'pIdisno') {
                        $('#shangjiId').focus();
                        alert("输入的推荐码不存在，请重新输入或者不输入任何字符！");
                        return false;
                    }
                    if (msg == 'sysError') {
                        alert("注册失败，请联系管理员！");
                        return false;
                    }
                    if(msg == 'isexist'){
                        alert("很抱歉，该手机号已经被注册，不能重复注册！");
                        return false;
                    }
                    if(msg == '000'){
                        alert("恭喜您，注册成功！");
                        //window.location.href = "toLogin.html";
                        window.location.href = "/";
                        return true;
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