<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />

<link href="css/common.css" rel="stylesheet" type="text/css"/>
<link href="css/page.css" rel="stylesheet" type="text/css"/>
<link href="css/qxcx.css" rel="stylesheet" type="text/css"/>
<title>新闻查询结果</title>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<link href="css/page.css" rel="stylesheet" type="text/css"/>
<style>
.listbk{ margin:30px; margin-right:0}
.listbk ul li{ font-size:14px; width:420px; float:left; display:inline; margin-right:55px;}
.listbk ul li span{ display:block; margin-top:15px; float:right}
.listbk ul li span.listnr{ width:300px; overflow:hidden;  white-space:nowrap; float:left}
.listbk ul li span.listnr a{ color:#333333; }
</style>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
<script type="text/javascript">
	$(function(){$('#head_hf_qpzx').addClass('hover');});
</script>
</head>

<body id="mainbody">
<!-- header begin -->
	<div class="header">
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	</div>
	<div class="logo">
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	</div>
	<!-- header end -->
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
<div class="qxcx">
  <div class="qxcx_2">
  <p class="cx">新闻查询结果</p>
  <div class="listbk">
    <ul class="listnew">
						<s:iterator value="list">
							<li><span class="listnr"><a title="${firstTitle }" href="news/detail/${id}.html">
									${firstTitle }
							</a>
							</span><span class="listdate">[<s:date name="createtime"
											format="yyyy-MM-dd" />] </span>
							</li>
						</s:iterator>
					</ul>
  </div>
   <div id="showpages">
			<page:pagination path="news/searchAllNews.html" formName="pagerForm"/>
	 </div>
	 <form id="pagerForm" name="pagerForm" action="/news/searchAllNews.html" method="post">
			<input type="hidden" id="searchType" name="searchType" value="<s:property value='#request.searchType'/>" />
			<input type="hidden" id="topSearchLike" name="topSearchLike" value="<s:property value='#request.topSearchLike'/>" />
	</form>
  </div>
</div>
<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
</body>
</html>
