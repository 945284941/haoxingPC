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
	<base href="<%=basePath%>"/>
	<link href="css/shophy.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="css/sghsc-login.css" type="text/css" >
	<script type="text/javascript" src="js/jquery.form.js"></script>
	<script>var ROOT_PATH = '<c:url value="/" />';var JSESSIONID = "<%=request.getSession().getId()%>";</script>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta content="IE=11.0000" http-equiv="X-UA-Compatible">
	<title>颐佳超市</title>
	<meta name="keywords" content="颐佳超市">
	<meta name="description" content="颐佳超市">
	<meta name="GENERATOR" content="颐佳超市">
	<meta name="author" content="颐佳超市">
	<meta name="copyright" content="颐佳超市">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="3c0d2bedd819ab1c" property="wb:webmaster">
	<link href="css/public.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="js/jquery-1.6.2.js" ></script>

</head>

<body>

<!-- heard -->
<div id="header_form">
	<div class="head_width" id="head_h">
		<div class="head clearfix">
			<div class="logo sline" >
				<a href="#"><img src="images/logo.png" border="0"> </a>
			</div>

			<div class="lh_zcdl">重设密码</div>
			<div class="lh_zcdl_right">感谢注册颐佳商城！</div>

		</div>
	</div>
</div>
<!-- heard结束 -->

<div class="h_enroll">
	<div class="h_enroll_t"><span>重设密码</span></div>
	<div class="login_cont_ny_r1" style="margin: 90px auto; float: none; height: auto;">
		<form id="addForm">
		<div class="login_cont_ny_r_m1">
			<input type="text" placeholder="手机号" class="login_bk1" id="username" name="username"/>
			<input type="password" placeholder="新密码" class="login_bk11" id="newPassword" name="newPassword"/>
			<input type="password" placeholder="确认密码" class="login_bk11"  id="rePassword" name="rePassword"/>
			<input type="text" placeholder="验证码" class="login_yzm" style="height:40px;" id="randNum" name="randNum" style="width: 200px;"/>
			<div class="login_yzm_dx on" id="J_resetCode" style="display: none;"><s:text name="index_0281"/></div>
			<div class="login_yzm_dx on" id="J_second" style="display: none;">60</div>
			<div class="login_yzm_dx" onclick="getCode(this)" id="J_getCode"><s:text name="index_0308"/></div>
		</div>
		<div class="login_cont_ny_r_b1">
			<a href="javascript:void(0);" onclick="subQg()">确定</a>
		</div>
		</form>
		<div class="login_cont_ny_r_wz1">
			<a href="toLogin.html" style="text-align: right; text-decoration: underline;">登录</a>
			<a href="toRegister.html"  style="text-align: left; text-decoration: underline;">注册</a>
			<p style="text-align: center;  display: block;  margin-top:40px;font-size: 14px;">国内电话：${phone}&nbsp;&nbsp;&nbsp;&nbsp;QQ：${qq}   <br/>国外电话：${skype}</p>
		</div>

	</div>
	<div class="clear"></div>
</div>

<!--footer开始-->
<div class="footer">
	<div class="main ">
		<ul>
			<li>
				<div class="footer_img"><img src="images/lh_img_09.png" width="75" height="75" /></div>
				<div class="footer_wz">
					<p>品种齐全 轻松购物</p>
				</div>
			</li>
			<li>
				<div class="footer_img"><img src="images/lh_img_10.png" width="75" height="75" /></div>
				<div class="footer_wz">
					<p>正规渠道 品质保障</p>
				</div>
			</li>
			<li>
				<div class="footer_img"><img src="images/lh_img_11.png" width="75" height="75" /></div>
				<div class="footer_wz">
					<p>天天低价 畅选无忧</p>
				</div>
			</li>
			<li>
				<div class="footer_img"><img src="images/lh_img_12.png" width="75" height="75" /></div>
				<div class="footer_wz">
					<p>限时秒杀 优惠多多</p>
				</div>
			</li>

		</ul>
	</div>
</div>

<div class="foots" style="background: none;">
	<div class="w">
		<p style="color: #666; margin-top: 50px;">Copyright © 2013-2014 htp://www.sss.com 浩星商城版权所有 技术支持：开创集团</p>
		<div class="foots_img">
			<ul>
				<li><img src="images/img_19.png" width="109" height="40" /></li>
				<li><img src="images/img_20.png" width="110" height="40" /></li>
				<li><img src="images/img_21.png" width="109" height="43" /></li>
				<li><img src="images/img_22.png" width="96" height="43" /></li>
			</ul>
		</div>
	</div>
</div>
<!--footer结束-->
<script>
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


    function subQg(){
        var username = $("#username").val();
        var randNum = $("#randNum").val();
        var newPassword = $("#newPassword").val();
        var rePassword = $("#rePassword").val();
        if(username == '') {
            alert("<s:text name="index_0275"/>！");
            $("#username").focus();
            return false;
        }else if(randNum == ''){
            alert("<s:text name="index_0325"/>！");
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
            alert("<s:text name="index_0324"/>！");
            $("#newPassword").focus();
            return false;
        }else{
            //修改电话
            $.ajax( {
                url : 'login!updatePassword.action',
                type : 'POST',
                data : $('#addForm').serialize(),
                success : function(data) {
                    var msg = $.parseJSON(data);
                    if (msg == 'success') {
                        alert("<s:text name="index_0315"/>！");
                        window.location.href="toLogin.html";
                        return true;
                    }else if(msg == 'error'){
                        alert("<s:text name="index_0316"/>！");
                        return false;
                    }
                }
            });
        }
    }

</script>
</body>

</html>