<%@page import="com.qlzy.common.tools.PwdCrypt"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String login_name="";
	if(request.getParameter("ln")!=null){
		login_name = PwdCrypt.decrypt(request.getParameter("ln"));
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />

<title>颐佳官方商城</title>
<link href="css/shophy.css" rel="stylesheet" type="text/css" />

<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type="text/javascript">
	/***
	 * tab选项卡
	 * @param {Object} thisObj
	 * @param {Object} Num
	 * @param {Object} active
	 * @param {Object} normal
	 * @return {TypeName} 
	 */
	function nTabs(thisObj, Num, active, normal) {
		if (thisObj.className == active)
			return;
		var tabObj = thisObj.parentNode.id;
		var tabList = document.getElementById(tabObj)
				.getElementsByTagName("li");
		for ( var i = 0; i < tabList.length; i++) {
			if (i == Num) {
				thisObj.className = active;
				document.getElementById(tabObj + "_" + i).style.display = "block";
			} else {
				tabList[i].className = normal;
				document.getElementById(tabObj + "_" + i).style.display = "none";
			}
		}
	}

	function sub(id) {
		$.ajax({
			url : 'login!checkCode.action',
			type : 'POST',
			data : 'code=' + $('#' + id + ' input[name=loginCode]').val(),
			dataType : 'JSON',
			success : function(j) {
				if (!j) {
					alert('验证码错误,请重新输入!');
					return false;
				} else {
					document.getElementById(id).submit();
				}
			}
		});
	}
	
	$(function(){
		$('#hf_gerenForm input').keydown(function(event){
			if(event.keyCode==13){
				$("#hf_loginid").click(); 
			}
		});
	});
	
	var msg='${errmsg }';
	if(msg == 'notStartCheck'){
		alert('您的申请已收到，正在审核，大约需要48小时，请耐心等待！');
	}else if(msg == 'isCheckFail'){
		alert('很抱歉，您的信息审核未通过，请联系客服 0531-55702537！');
	}else{
	if(!msg.length<=0){
		alert('用户名或密码错误!');
	}
	}
	
</script>
</head>

<body >
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="../common/navigation.jsp"></jsp:include>
<div class="index">
	<div class="breadThumb">首页 &gt; 个人登录</div>
	<div class="hdzxtg">
		<div class="hyzcmain" id="notice_0">
			<div class="hydlzcbt">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</div>
			<form action="login!loginSuccess.action" method="post" id="hf_gerenForm">
				<input type="hidden" name="vs_url" value="${vs_url }" />
				<div class="hyhdxznr">
					<div class="hybd">
						<span class="jz dlnc">会员账号：</span>
						<div class="dlwbk">
							<label for="textfield"></label> <input class="dlwbbk" type="text"
								name="loginName" value="<%=login_name %>" />
						</div>
						<span class="btx">*</span>
					</div>

					<div class="hybd">
						<span class="jz dlnc">登录密码：</span>
						<div class="dlwbk">
							<label for="textfield"></label> <input class="dlwbbk" type="password"
								name="loginPwd" />
						</div>
						<span class="btx">*</span>
					</div>

					<div class="hybd">
						<span class="jz dlnc">验&nbsp;&nbsp;证&nbsp; 码：</span>
						<div class="dlwbk">
							<label for="textfield"></label> <input class="yzmbk" type="text"
								name="loginCode" />
						</div>
						<span class="btx"><img src="validatecode"
							onclick="javascript:this.src='validatecode?id='+  Math.random();"
							alt="看不清,换一个,请点我" /> </span><span class="btx">*</span>
					</div>

					<div class="hybd" style="text-align:center">
						<p class="dlan">
							<a onclick="sub('hf_gerenForm');" id="hf_loginid">登录</a>
						</p>
						<p class="dlan">
							<a href="toMemberNotice.html">注册</a>
						</p>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>