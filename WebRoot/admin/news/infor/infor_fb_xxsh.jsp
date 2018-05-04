<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<link href="css/master.css" rel="stylesheet" type="text/css"></link>
<link href="css/common.css" rel="stylesheet" type="text/css"></link>
<link href="css/infor.css" rel="stylesheet" type="text/css"></link>
<title>供求信息_古道金典</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
<script type="text/javascript">
	$(function(){$('#head_hf_gqxx').addClass('hover');});
</script>
</head>

<body id="mainbody" >
<!-- header begin -->
	<div class="header">
		<jsp:include page="/admin/common/head.jsp"></jsp:include>
	</div>
	<div class="logo">
		<jsp:include page="/admin/common/logo.jsp"></jsp:include>
	</div>

<!-- 代码 开始 -->
<div id="warp">
<div class=" bannerzong">  
   <ul class="mainnavzong">
		<jsp:include page="/admin/common/all_hf_Head.jsp" />
   </ul>
   <div class="mainqlzpc">
     <a href="news/news!toQlqpc.action"><img src="images/zpc.gif" alt="泉利重配城" /></a>
   </div>
<div id="menunew">
    <p class="menubt_new"></p>
    <ul class="menuzong menunew">
    </ul>
   </div>
 </div>
 </div>
<div class="dht"><a>首页 > 供求信息</a></div>
<div class="infor_fb">
  <div class="fbzctitle">
    <ul>
      <li><span>1</span><a href="/s_supplyfb.html">选择信息分类</a></li>
      <li><span>2</span><a href="javascript:void(0)">填写基本信息</a></li>
      <li  class="fxz3"><span>3</span><a href="javascript:void(0)">等待信息审核</a></li>
    </ul>
  </div>
  <div class="fb_content"><div class="fb_1">
    <h2><span>等待信息审核</span></h2>
    <div class="fbxxsh">
      <p class="fbh">尊敬的会员admin，您发布的信息已经提交，
待站方审核通过后，便可被他人浏览，感谢使用。</p>
      <p><a href="/s_supplyfb.html"><img src="/images/fbfh.gif" alt="返回" /></a><a href="/s_supplyfb.html"><img src="/images/fbjx.gif" alt="继续发布信息" /></a></p>
    </div>
    <div class="clr"></div>
    </div>
  </div>
</div>
<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
	<!-- footer end -->
</body>
</html>
