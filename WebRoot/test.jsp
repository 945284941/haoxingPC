<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
  </head>
  
  <body>
      <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cn">
<head>
<title>正计时</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<style type="text/css">
#thenceThen{font-size:2em;}
</style>
<script type="text/javascript" language="javascript">
function thenceThen(){
var date1 = new Date(1381741113671);
var totalSecs=(new Date()-date1)/1000;
var days=Math.floor(totalSecs/3600/24);
var hours=Math.floor((totalSecs-days*24*3600)/3600);
var mins=Math.floor((totalSecs-days*24*3600-hours*3600)/60);
var secs=Math.floor((totalSecs-days*24*3600-hours*3600-mins*60));
if (days != 0 ) {
document.getElementById("thenceThen").innerText="　答题时间："+days+"天"+hours+"小时"+mins+"分钟"+secs+"秒";
}else if (hours == 0 && mins == 0) {
document.getElementById("thenceThen").innerText="　答题时间："+secs+"秒";
}else if (hours == 0 && mins != 0) {
document.getElementById("thenceThen").innerText="　答题时间："+mins+"分钟"+secs+"秒";
}else if (hours != 0) {
document.getElementById("thenceThen").innerText="　答题时间："+hours+"小时"+mins+"分钟"+secs+"秒";
}
}
var clock;
window.onload=function(){
clock=self.setInterval("thenceThen()", 500);
}
</script>
</head>
<body>
<div id="thenceThen"></div>
</body>

</html> 
  </body>
</html>
