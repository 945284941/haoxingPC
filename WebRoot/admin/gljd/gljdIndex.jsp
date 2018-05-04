<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>颐佳官方商城</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	<meta http-equiv=”X-UA-Compatible” content=”IE=edge,chrome=1″ />
   <link rel="stylesheet" href="web/css/base.css" type="text/css"></link>
   <link rel="stylesheet" href="web/css/main.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
  </head>
  
  <body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="/admin/common/navigation.jsp" />
<div class="breadThumb">当前位置：首页   &gt; 颐佳</div>
<div class="gljd-index">
  <img class="gljd-index-pic" src="web/images/gljd/gljd-1.png">
  <img class="gljd-index-pic" src="web/images/gljd/gljd-2.png">
  <img class="gljd-index-pic" src="web/images/gljd/gljd-3.png">
</div>
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
  
  </body>
</html>
