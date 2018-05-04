<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div id="warp">
<div class=" bannerzong">  
   <ul class="mainnavzong">
     <li><a  href="http://www.qlqpw.com">商城首页</a></li>
     <li><a href="qpzx.html">资讯首页</a></li>     
     <li><a href="zpxy.html">重配学院</a></li>
     <li><a class="hover" onclick="loginOrNot('/memberCenter/statistics.html');">我的泉利</a></li>
     <li><a href="/admin/foot/contact.jsp">联系我们</a></li>     
   </ul>
<div id="menunew">
    <p class="menubt_new"></p>
    <ul class="menuzong menunew">
       <li><a href="/">发动机</a></li>
       <li><a href="/">发动机附件</a></li>
       <li><a href="/">驾驶室</a></li>
       <li><a href="/">变速器总成</a></li>
       <li><a href="/">离合器</a></li>
       <li><a href="/">转向系统</a></li>
       <li><a href="/">挂车</a></li>
       <li><a href="/">电器系统</a></li>
       <li><a href="/">传动</a></li>
       <li><a href="/">悬挂</a></li>
       <li><a href="/">车架</a></li>
       <li><a href="/">自卸上装</a></li>
       <li><a href="/">前中后桥</a></li>
       <li><a href="/">制动系统</a></li>
       <li><a href="/">油品</a></li>
       <li><a href="/">螺栓及螺母</a></li>
       <li><a href="/">轴承</a></li>
    </ul>
   </div>
 </div>
</div>