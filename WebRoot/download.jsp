<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
<meta http-equiv="content-tysectione" content="text/html; charset=UTF-8"/>
<meta name="viewsectionort" id="viewsectionort" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<style>

body{background:url(app/wxphone.png) 0px 10px no-repeat #fff;background-size:100%;font-size:15px;color:#fff;}

.down-content{margin-left:50%;margin-top:70%;}
a{display:block;width:80%;margin-right:10px;float:right;height:40px;line-height:40px;border:1px solid #0099CD;margin:0px auto;border-radius:8px;text-decoration:none;font-weight:bold;}
a.iPhone{background:;color:#0099CD;width:53%;margin-top:30px;background:url(app/down-apple.png) no-repeat 30px #fff;background-size:15%;padding-left:32%;}
a.Android{color:#fff;margin-top:30px;background:url(app/down-andriod.png) no-repeat 15px #0099CD;background-size:15%;width:62%;padding-left:23%;}
</style>
</head>
<body>
<div class="down-content">
<a href="https://itunes.apple.com/cn/app/san-gu-hui/id1110302794?mt=8" class="iPhone">iOS下载</a>
<a href="http://www.sanguhuivip.com/app/sanguhui.apk" class="Android">Android下载</a> 
</div>
</body>
</html>