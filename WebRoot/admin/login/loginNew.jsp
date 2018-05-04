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

<script type="text/javascript">
			function setMemberStyle(x,y){
				document.getElementById(x).style.display='none';
				document.getElementById(y).focus();
			}
			
			$(function(){
				$('#loginFrom input').keydown(function(event){
					if(event.keyCode==13){
						$("#dialog_loginid").click(); 
					}
				});
			});
			
            // 登录时记住用户名称和密码
            $(function() {
			    var loginNameStr = "loginName";
			    var loginPwdStr = "loginPwd";
			    $("#remember").click(function(){
			        var ischeck=$(this).is(":checked"); 
			        var loginNameVal = "";
			        var loginPwdVal = "";
			        if(ischeck){
			            loginNameVal = $("#loginName").val();
			            loginPwdVal = $("#loginPwd").val();
			            $("#remember").attr("checked","checked");
			        }
			        setCookie(loginNameStr, loginNameVal, 5);
			        setCookie(loginPwdStr, loginPwdVal, 5);
			    });
			});
			
			function setCookie(name,value,expiresHours) {
			    var cookieString=name+"="+encodeURI(value)+";path=" + ROOT_PATH;
			    if(expiresHours>0) {
			        var date=new Date();
			        date.setTime(date.getTime()+7*24*60*60*1000);
			        
			        cookieString=cookieString+"; expires="+date.toGMTString();
			    }
			    document.cookie=cookieString;
			}
			
			function showmenuobj(divbg, divId){
				document.all("login2div").style.display="none";
				
		   		var o = document.getElementById(divId);
		        o.style.display="none";
		        o.style.top="253px";
		        o.style.left="400px"; 
		  	 	var maskdiv = document.getElementById(divbg);
		   		maskdiv.style.display="none";
			}
</script>

	</head>
	<body>
  <div class="sghsc-login2-form" id="login2div">
   <div class="sghsc-login2-form-top"><span>您尚未登录</span></div>
  
   <div class="form_1">
    <span class="sghscleft s1-left2">商城会员登录</span>
	<span class="sghscright s1-right2"><a href="toMemberNotice.html"><b></b>立即注册</a></span>
   </div>

   <form id="loginFrom" action="tologin.html" method="post" >
    <div class="ermsg ermsg2" ></div>
    <div class="ermsg0 ermsg3" ></div>
	
	<div class="sghsc-login-username">
	 <div class="sghsc-login-username-icon" style="background:url(images/sghsc-login-username.png) no-repeat"></div>
	 <input onkeydown="if(event.keyCode==13){$('#userName').focus();};" type="text" id="loginName" name="loginName" placeholder="请输入用户名"/>
	</div>
	<div class="sghsc-login-username sghsc-login-userpwd">
	 <div class="sghsc-login-username-icon sghsc-login-userpwd-icon" style="background:url(images/sghsc-login-userpwd.png) no-repeat"></div>
	 <input onkeydown="if(event.keyCode==13){$('#userpwd').focus();};" type="password" id="loginPwd" name="loginPwd" placeholder="请输入登录密码"/>
	</div>	
	
	<div class="sghsc-login2-username" id="sghsjyz" style="display:none;">
	 <div class="sghsc-login2-sjyz">手机验证码：</div>
	 <input type="text" id="mobileStatus" name="mobileStatus" />
	 <span class="sghsc-login2-fsdx" id="box1">
		<a id="mobileButt" onclick="toSendMobileCode('mobileButt', '1', 'mobileCheck')" title="发送短信到您的手机">发送短信</a>
	 </span>
	 <div class="sghsc-login2-fscg-no" id="box2">验证码已发送到您的手机，请注意查收</div>
	</div>
	
	<div class="sghsc-login-rem"><span><input id="remember" type="checkbox" />记住密码</span><span class="s1-right1 sghscright"><a href="toMemberCheckMsg.html" >忘记密码？</a></span></div>
	<!-- <input type="submit" value="登录" onclick="loginFromSub();" class="sghsc-login2-btn" /> -->
	<a class="sghsc-login2-btn" href="javascript:void(0);" onclick="loginFromSub();">登录</a>	
   </form>
  <a class="sghsc-login2-form-top-x" onclick="hiddenLogin('mask','pop_500');" title="关闭"></a>
  </div>
	</body>
</html>
