<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
</head>
<body>
	<form>
		用户名<input /><br>
		登录密码<input /><br>
		确认密码<input /><br>
		验证码<input /><br>
		真实姓名<input /><br>
		所在地区（省 市）<input /><br>
		从事领域（+车队）<input /><br>
		岗位职能<input /><br>
		办公电话（#）<input /><br>
		性别（#）<input /><br>
		手机<input /><br>
		Email<input /><br>
		身份证号<input /><br>
	</form>
</body>
</html>