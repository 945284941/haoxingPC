<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" href="css/shophy.css" type="text/css"></link>
<div id="mask"></div>
<div class="index_top_ret">
   <div class="index_top_ret_let">
		<s:if test="#attr.sessionInfo.loginName!=null">
		     <span title="${sessionInfo.loginName }">${fn:substring(sessionInfo.loginName, 0, 8)}&nbsp;</span>
		     <span>您好，欢迎访问颐佳 云生活！</span>
		  	 <a href="v/logout.html" target="_self">退出</a>
		  	 <input type="hidden" id="_sessionUserId" value="${sessionInfo.userId }">
		</s:if>
		<s:else>
	     <span>欢迎访问颐佳 云生活！</span>
	  	 <a href="javascript:showLogin('mask','pop_500', '','0','',true)"  target="_self">登录</a>
	  	 <span>|</span>
	 	 <a href="toMemberNotice.html" target="_self">注册</a>
	 	 <span>|</span>
	   </s:else>
	  <a href="javaScript:void(0);" onclick="loginOrNot('person/order/myOrders.html');" target="_self">个人中心</a> 
	  <span>|</span>
	  <!-- <a href="http://www.guliangjindian.com/qlzy">后台管理</a> -->
  </div> 
  <div class="index_top_ret_ret"><img src="web/images/zixun/dianhua.jpg" width="18" height="18" align="top" />客服热线:<span><b>400-665-2578</b></span></div>
  <div class="clear"></div>
</div>

<div  id="pop_500" style="display:none;">
	<jsp:include page="/admin/login/login.jsp" flush="true" />
</div>
<script type="text/javascript">
$(function(){
	$('#loginFrom input').keydown(function(event){
		if(event.keyCode==13){
			$("#dialog_loginid").click(); 
		}
	});
	
});

</script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?4c6d10e6396028311a9e1aaf37d98f88";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
