<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>古道金典</title>
<style>
.loginBox {
	width: 70%;
	background: #FFF;
	margin: 20% auto auto auto;
	box-shadow: 1px 1px 7px #666;
	border: 1px solid #CDCDCD;
	position: relative;
}


</style>
</head>

<body>
	<div class="loginBox">
	
		<p style="width:100%; text-align:center; color:#AE0B15; font-weight:bold; font-size:24px; line-height:30px;">热烈祝贺古道金典资讯频道上线！</p>
		<div style="width:38%; float:left;">
			<img src="/images/benisonjxw.gif" />
		</div>
		<form action="index!toBenison.action" id="benisonForm" method="post">
		<div style="width:55%; float:left;font-weight:bold;">
			<p style="width:100%; font-size:12px;">打开手机祝福我吧，给我好评哦：</p>
			<p>
				<label for="textarea"></label>
				<textarea style="width:100%;" name="benString" id="benString"
					cols="45" rows="5"></textarea>
			</p>
		</div>
		</form>
		<p style="text-align:right; width:90%; padding-right:25px;">
			<a onclick="subBenison();"><img src="/images/zfan.gif" border="0" />
			</a>
		</p>
	</div>
	<script src="js/jquery-1.8.0.min.js"></script>
	<script src="js/jquery-pin.js"></script>
	<script>
		$('.loginBox').pin({
			containerSelector : ".active_body"
		});

		function subBenison() {
			var str = $("#benString").val();
			$("#benisonForm").submit();
		}
	</script>
</body>
</html>