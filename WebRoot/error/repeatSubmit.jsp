<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<link href="/css/hyzxgr.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" type="text/JavaScript">
	function showElement(elementId) {
		document.getElementById(elementId).style.display = "block";
	}
	function hideElement(elementId) {
		document.getElementById(elementId).style.display = "none";
	}
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
<style>
.hyhdxznr {
	width: 815px;
	margin: 0 auto;
}

.xyxznr {
	width: 755px;
	padding-left: 30px;
	padding-right: 30px;
	line-height: 24px;
	padding-top: 20px;
	color: #333333;
	float: left;
	height: 500px;
	border-left: 1px solid #E2E3EA;
	border-top: 1px solid #ABADB3;
	border-bottom: 1px solid #E2E3EA;
	overflow: auto;
}

.xydxk {
	width: 24px;
	float: left;
	padding-left: 570px;
	padding-top: 25px;
}

.xywz {
	width: 120px;
	float: left;
	padding-top: 25px;
}

.xyban {
	width: 82px;
	float: right;
	line-height: 30px;
	text-align: center;
	font-size: 14px;
	padding-top: 25px;
}

.xyban a {
	background: url(images/xyban.gif) no-repeat;
	display: block
}

.xyban a:hover {
	background: url(images/xyban2.gif) no-repeat;
	text-decoration: none;
}

.xyqtb {
	height: 24px;
	float: left;
	width: 20px;
}
</style>
</head>
<body>
	<!-- 页脚开始 -->
	<div class="gzgz">
		<div
			style="background:url(/images/404bz.gif) no-repeat 100px 55px; width:100%; padding-top:30px; float:left; min-height:300px;">
			<p
				style=" padding-left:370px; padding-top:25px; width:350px; float:left;">
				<img src="/images/bdts.gif" />
			</p>
			<dl
				style="padding-left:370px; padding-top:25px; width:750px; float:left; font-size:14px;">
				<dt style="float:left; line-height:40px; width:100%;">你可以逛逛：</dt>
				<dd style="width:80px;float:left; ">
					<a style="padding-right:10px;" href="http://www.qlqpw.com">商城首页</a>|
				</dd>
				<dd style="width:80px;float:left; ">
					<a style="padding-right:10px;" href="/schq.html">市场行情</a>|
				</dd>
				<dd style="width:80px;float:left; ">
					<a style="padding-right:10px;" href="/cppc.html">产品评测</a>|
				</dd>
				<dd style="width:80px;float:left; ">
					<a style="padding-right:10px;" href="/gqxx.html">供求信息</a>|
				</dd>
				<dd style="width:80px;float:left; ">
					<a style="padding-right:10px;" href="javascript:void(0)">重配学院</a>|
				</dd>
				<dd style="width:80px;float:left; ">
					<a style="padding-right:10px;" href="/qpzx.html">汽配资讯</a>|
				</dd>
				<dd style="width:80px;float:left; ">
					<a style="padding-right:10px;" href="javascript:void(0)">泉利杂志</a>|
				</dd>
				<dd style="width:80px;float:left; ">
					<a style="padding-right:10px;" href="/admin/foot/contact.jsp">联系我们</a>
				</dd>
			</dl>
		</div>
	</div>
</body>
</html>