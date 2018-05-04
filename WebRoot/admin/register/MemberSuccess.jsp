<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="description" content="潜心修炼100天 笑傲江湖100年" />
<meta name="keywords" content="潜心修炼100天 笑傲江湖100年" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>三古汇官方商城</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<link href="css/shophy.css" rel="stylesheet" type="text/css"/>
<%--
<script type="text/javascript">
var times = 6;
$(function() {
	clock();
});

function clock() {
	window.setTimeout('clock()', 1000);
	times = times - 1;
	if (times == -1) {
		window.location.href = "<%=basePath%>";
	} else {
		time.innerHTML = times;
	}
}
</script> 
--%>
  </head>
  
 <body>
 <s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
 <s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
 <jsp:include page="../common/navigation.jsp"></jsp:include>
 <div class="breadThumb">首页 &gt; 个人注册</div>
  <div class="hdzxtg">	
     <h1 class="register-title text-center"><i class="iconfont">&#xf00ec;</i>个人会员</h1>
     <div class="hyzcmain">
       <div class="hyfore4">
       </div>        
     <div class="hyhdxznr">
         <p class="hycgzc">恭喜您：会员
          <s:if test="#attr.sessionInfo.loginNickName!=null">
         	${sessionInfo.loginNickName}
         </s:if>
        <s:else>
       		 ${sessionInfo.loginName}
        </s:else>，<span class="red">注册成功</span>！
</p>
        <p class="zucgtz">
        	请牢记登录密码，如忘记可用安全问题及答案找回，
	        <%-- <span id="time">5</span>秒钟后自动跳转至网站首页……请稍候…… --%>
	       	您可以点击<a href="<%=basePath%>download.jsp">下载APP</a>
       	</p>
     </div>
    </div>     
  </div>
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
<!-- footer end -->
</body>
</html>

