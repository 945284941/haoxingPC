<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script charset="utf-8" src="http://api.map.soso.com/v1.0/main.js"></script>

<style type="text/css">
#map-coverDiv {
	background-color: #666;
	position: absolute;
	z-index: 1100;
	left: 0;
	top: 0;
	display: none;
	width: 100%;
	opacity: 0.5;
	filter: alpha(opacity =     50);
	-moz-opacity: 0.5;
}

.map-Box {
	width: 750px;
	height: auto;
	/*margin: 300px 0;*/
	left: 450px;
	min-height: 500px;
	box-shadow: 1px 1px 7px #666;
	border: 1px solid #CDCDCD;
	position: absolute;
	background: #FFFFFF;
	z-index: 2000;
	display:none;
}

.showmap {
	margin: 0 auto 10px auto;
	padding-top:30px;
	width: 710px;
	height: 450px;
}

.close {
	top: 10px;
	width: 24px;
	height: 24px;
	right: 8px;
	text-indent: -9999px;
	display: block;
	position: absolute;
	z-index: 1;
	outline-width: 0;
	outline-style: none;
	outline-color: invert;
	background-repeat: no-repeat;
	background-position-x: 50%;
	background-position-y: 7px;
	background-size: auto;
	background-origin: padding-box;
	background-clip: border-box;
	background-color: transparent;
	background: url(images/close.png) no-repeat;
}

.close a {
	top: 10px;
	width: 24px;
	height: 24px;
	right: 8px;
	cursor: pointer;
}
</style>
</head>
<div id="map-coverDiv"></div>
<div class="map-Box" id="map-dialogDiv">
	<a id="companyList-map-close" class="close" href="javascript:void(0)" onclick="_CloseMapDiv('map-dialogDiv','map-coverDiv')"></a>
	<div id="container" class="showmap"></div>
	<p
		style="text-align:right; font-size:12px; color:#666; padding-right:20px;">注：地图位置坐标仅供参考，具体情况以实际道路标识信息为准</p>
</div>
