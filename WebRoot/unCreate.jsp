<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理员</title>
  </head>
  <body  style="background:url('images/bjt.jpg') repeat-x;">
 	 	<img src="/images/wzjs.gif" ></img>
  </body>
</html>
