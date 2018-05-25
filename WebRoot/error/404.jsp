<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>颐佳商城</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<link rel="stylesheet" href="/css/newbanner.css" type="text/css" />
<link href="/css/hyzxgr.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/css/staticlxwm.css" type="text/css" />
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
		<div>
			<dl style="padding-left:370px; padding-top:25px; width:750px; float:left; font-size:14px;">
				<div>
					<span>请联系管理员！</span>
				</div>
			</dl>
		</div>
	</div>
</body>
</html>