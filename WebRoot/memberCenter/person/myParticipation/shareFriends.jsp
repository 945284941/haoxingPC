<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript src="js/tanchu.js"></script>
<script type=text/javascript src="js/perinfo.js"></script>
<script language="JavaScript" type="text/JavaScript">
function showElement(elementId)
{
  document.getElementById(elementId).style.display="block";
}
function hideElement(elementId)
{
  document.getElementById(elementId).style.display="none";
}
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
<div id="tanchu"></div>
</head>
<body>
	<!-- head start -->
	<div class="header">
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	</div>
	<div class="logo">
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	</div>
	<!-- head end -->
	
	<!-- 导航 -->
	<jsp:include page="/memberCenter/common/navigation.jsp"/>
	<!-- 导航结束 -->
	<c:choose>
		<c:when test="${sessionInfo.userType=='company' }">
		<div class="dht">首页 &gt; 企业会员中心 &gt;我的参与 &gt; 分享好友</div>
		</c:when>
		<c:otherwise><div class="dht">首页 &gt; 个人会员中心 &gt;我的参与 &gt; 分享好友</div></c:otherwise>
	</c:choose>	
<div class="gzgz">
	<div class="hyleft">
		<c:choose>
			<c:when test="${sessionInfo.userType=='company' }"><jsp:include page="/memberCenter/common/leftNavigate.jsp" /></c:when>
			<c:otherwise><jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" /></c:otherwise>
		</c:choose>		
	</div>
     <div class="hyright">
      <div class="hyrightr">
       <div id="rightjxw">
           <p class="hyd0">邀请好友数<span>${inviteCount}</span></p>
       </div>
      </div>
       <p class="hymainbt"><span class="grmenubt">分享好友</span></p>
       <div class="grjbxx_fx" style=" margin-top:10px;">  
           <p style="color:#333333">你可以通过QQ、MSN或者发送邮件，把下面链接发送给你的好友</p>
           <p style="color:#f26521">${friendUrl}</p>

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