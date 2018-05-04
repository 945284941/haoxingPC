<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>颐佳官方商城</title>
<script src="js/jquery-1.8.0.min.js"></script>
<style>
.loginBox {
width: 560px; height: auto; background:#fff; margin:150px auto auto auto; box-shadow: 1px 1px 7px #666;border: 1px solid #CDCDCD; position: relative;
}

.close{ top:10px; width:24px; height:24px; right:8px; text-indent:-9999px; display:block; position:  absolute; z-index:1; outline-width:0; outline-style:none; outline-color:invert;background-repeat:no-repeat;background-position-x:50%;background-position-y:7px;background-size:auto;background-origin:padding-box;background-clip:border-box;background-color:transparent;background: url(images/close.png) no-repeat;}
.close a{ top:10px; width:24px; height:24px; right:8px; cursor:pointer;}

</style>
</head>

<body style="width:100%; background: url(images/sy.png) repeat;">
<div class="loginBox">

<p style="padding-left:10px; font-weight:bold;"></p>
<form action="index!toBenison.action" id="benisonForm" method="post">
<div style="margin:0 auto; width:310px; height:180px; background:url(images/benisonjxw.gif) no-repeat 10px 30px; font-weight:bold; padding-left:230px;"><p>祝福内容：</p>
<p>
  <label for="textarea"></label>
  <textarea style="width:295px; height:120px; float:left;" name="benString" id="benString" cols="45" rows="5"></textarea>
</p>
</div>
</form>
<p style="text-align:right; font-size:12px; color:#666; padding-right:25px;"><a onclick="subBenison()"><img src="/images/zfan.gif" border="0"/></a></p>
</div>
	<script>
		function subBenison() {
			var str = $("#benString").val();
			$("#benisonForm").submit();
		}
	</script>
</body>
</html>
