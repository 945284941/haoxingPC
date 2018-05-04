/*******************************************************************************
 * 登录
 * 
 * @return {TypeName}
 */
function loginFromSub() {
	var loginName = $('#loginName').val();
	var loginPwd = $('#loginPwd').val();
	var loginCode = $('#loginCode').val();
	if (loginName == '' || loginName == null) {
		$('#loginName').focus();
		alert('请输入用户名！');
		return false;
	}
	if (loginPwd == '' || loginPwd == null) {
		$('#loginPwd').focus();
		alert('请输入密码！');
		return false;
	}
	if (loginCode == '' || loginCode == null) {
		$('#loginCode').focus();
		alert('请输入验证码！');
		return false;
	}
	$
			.ajax({
				url : 'toActivelogin.html',
				type : 'POST',
				data : $('#loginFrom').serialize(),
				success : function(data) {
					var msg = $.parseJSON(data);
					if (msg == 'fail') {
						$('#loginCode').focus();
						alert('验证码输入不正确！');
						return false;
					}
					if (msg == 'no') {
						$('#loginCode').focus();
						alert('验证码为空！');
						return false;
					}
					if (msg == 'nameError') {
						$('#loginName').focus();
						alert('该用户名不存在！');
						return false;

					}
					if (msg == 'pwdError') {
						$('#loginPwd').focus();
						alert('密码不正确，请重新输入！');
						return false;
					}
					if (msg == 'sessionold') {
						alert('页面已过期，请重新登录！');
						window.location.href = "/activeIndex.jsp";
					}
					if (msg == 'success') {
						// alert('登录成功！');
						// 跳转到登录成功页面
						window.location.href = "/active/loginRegister/ActiveMemberLoginSuccess.jsp";
					}

				}
			});
}
function showMember(divbg, divId) {
	// mask=document.createElement("div");
	yScroll = this.pageYOffset;
	var mask = document.getElementById(divbg);
	var W = $(document).width();
	var H = $(document).height();
	// mask.id="mask";
	mask.style.cssText = "position:absolute;z-index:5;width:"
			+ W
			+ "px;height:"
			+ H
			+ "px;background:#000;filter:alpha(opacity=30);opacity:0.3;top:0;left:0;";
	// document.body.appendChild(mask);
	mask.style.display = "block";
	var o = document.getElementById(divId);
	o.style.display = "block";
	// o.style.position = "fixed";
	o.style.top = (H / 2 - 100) + "px";
	o.style.left = (W / 2 - 200) + "px";

}
function hiddenMember(divbg, divId) {
	var o = document.getElementById(divId);
	o.style.display = "none";
	o.style.top = "253px";
	o.style.left = "400px";
	var maskdiv = document.getElementById(divbg);
	maskdiv.style.display = "none";
}
function checkPwdFromSub(divbg, divId) {
	var memberName = $("#memberName").val();
	if (memberName == "" || null == memberName) {
		alert("请填写用户名！");
		return false;
	}
	showMember(divbg, divId);
	$.ajax({
		url : 'toActiveMemberCheckPwdMsg.html',
		type : 'POST',
		data : $('#checkPwdFrom').serialize(),
		success : function(data) {
			hiddenMember(divbg, divId);
			var msg = $.parseJSON(data);
			if (msg == 'error') {
				alert("信息有误或该用户不存在，请重新填写！");
				return false;
			} else {
				alert("您的申请已提交成功，请查看您的" + msg + "邮箱。");
				window.location.href = "/activeIndex.jsp";
			}

		}
	});

}
function modifyPwdFromSub() {
	var memberUsername = $('#memberUsername').val();
	var memberPwd = $('#memberPwd').val();
	var reMemberPwd = $('#reMemberPwd').val();
	if (memberPwd == '') {
		$('#memberPwd').focus();
		alert('请输入密码！');
		return false;
	} else {
		if (!regPwd.test(memberPwd)) {
			$('#memberPwd').focus();
			alert('密码只可输入6-10位英文、数字及特殊符号！');
			return false;
		}
	}

	if (reMemberPwd == '') {
		$('#reMemberPwd').focus();
		alert('请输入确认密码！');
		return false;
	}
	if (memberPwd != '' && reMemberPwd != '') {
		if (memberPwd != reMemberPwd) {
			$('#memberPwd').focus();
			alert('两次输入的密码不一致，请重新输入！');
			return false;
		}
	}
	$.ajax({
		url : 'toActiveModifyPwd.html',
		type : 'POST',
		data : $('#modifyPwdFrom').serialize(),
		success : function(data) {
			var msg = $.parseJSON(data);
			if (msg == 'su') {
				alert('修改密码成功！');
				window.location.href = "toActiveMemberLogin.html";
			} else {
				alert('很抱歉，修改失败！');
				return false;
			}

		}
	});
}
