<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
		<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="css/shophy.css" rel="stylesheet" type="text/css"/>
		<link href="css/common.css" rel="stylesheet" type="text/css"/>
		<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<script src="js/cardcode.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/register.js"></script>
		<script type="text/javascript" src="js/perinfo.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
		<script type="text/javascript">


$.validator.addMethod("isMobile", function (value, element) {
    var length = value.length;
    //var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|147|(18[0-9]{1}))+\d{8})$/;
    var mobile = /^(1\d{10})$/;
    return this.optional(element) || (length === 11 && mobile.test(value));
}, "请正确填写手机号码");

$.validator.addMethod("isVerifyCode", function (value, element) {
    var length = value.length;
    var code = /^(\d{6})$/;
    return this.optional(element) || (length === 6 && code.test(value));
}, "请输入正确的手机验证码");

$(function() {
	var newUsername = '${member.username}';
	if('' == newUsername){
		alert("信息丢失，请重新填写！");
		location.href = "toMemberRegister.html";
	}	
	$('#memberMsgForm').validate({
		rules:{
			'member.firstname':'required',
			'member.truename':'required',
			'member.address':'required',
			'member.card':{
				required:true,
				isCard:true
			},
			'member.email':{
				required:true,
				email:true
			},
			'member.mobile':{
				required:true,
				isMobile:true
			},
			'member_mobileCode':{
				required:true,
				isVerifyCode:true
			}
			
		},
		messages:{
			'member.firstname':'会员昵称不能为空哦！',
			'member.truename':'真实姓名不能为空哦！',
			'member.address':'地址不能为空哦！',
			'member.card':{
				required:'身份证号不能为空哦！'
			},
			'member.email':{
				required:'邮箱地址不能为空哦！',
				email:'请输入合法的邮箱地址！'
			},
			'member.mobile':{
				required:'手机号码不能为空哦！'
			},
			'member_mobileCode':{
				required:'请获取并输入手机验证码！'
			}
		},
		errorElement:'div',
		errorClass:'validText',
		submitHandler:function(form){
			memberMsgSubForm();	
		}
	});
});
function setStyle(x, y) {
	document.getElementById(x).style.display = 'none';
	document.getElementById(y).focus();
}
</script>
	</head>
	<div id="maskmember"></div>
	<body id="mainbody">
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
		<jsp:include page="../common/navigation.jsp"></jsp:include>
		<div class="breadThumb">首页 &gt; 个人注册</div>
		<div class="hdzxtg">
			<h1 class="register-title text-center"><i class="iconfont">&#xf00ec;</i>个人会员</h1>
			<div class="hyzcmain">
				<div class="hyfore3"></div>
				<div class="hyhdxznr3">
					<form  method="post" enctype="multipart/form-data"  id="memberMsgForm">
						<input type="hidden" name="member.password" value="${member.password }" />
						<input type="hidden" name="member.username"  value="${member.username }" />
						<input type="hidden" name="member.recommendUserId" value="${member.recommendUserId}" />
						<input type="hidden" name="member.shangjiId" value="${member.shangjiId }" />

						<div class="hybdaa">
							<span class="jz dlnc">手机号码：</span>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbk" type="text" id="mobile" 
										name="member.mobile"  value="${member.username }" readonly="readonly"/>
							</div>
							<span class="btx">*</span>
						</div>
						
						<div class="hybdaa">
							<span class="jz dlnc">&nbsp;&nbsp;&nbsp;验&nbsp;&nbsp;证&nbsp;&nbsp;码：</span>
							
							<div class="dlwbk">
							    <input class="mfhqjhm1"  id="admin_memberRegisterMsg_toESM" type="button" value="免费获取短信激活码" onclick="getMobileCode('admin_memberRegisterMsg_toESM','mobile','1');"/>
								<input class="dlwbbkyzm" name="member_mobileCode" type="text"  id="member_mobileCode"  />
								
							</div>
							<span class="btx">*</span>	
												
						</div>
						<div class="clearfix"></div>
						<div style="padding-left:340px;">
							<button type="submit"  class="btn btn-primary">完成，下一步</button>
							
						</div>
					</form>
				</div>
				
				<div class="qlqpwwxts">
					<p class="red">
						三古汇·云生活（www.sanguhuivip.com）温馨提示：
					</p>
					<p>
						请您务必填写真实有效的信息，方便参加网站官方有奖活动，进行网上交易，资金流转及获得其他增值服务等。
					</p>
				</div>
			</div>
		</div>
	<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
<!-- footer end -->
	</body>
</html>

