<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="css/shophy.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/register.js"></script>
<script type="text/javascript">
	function setMemberStyle(x,y){
		document.getElementById(x).style.display='none';
		document.getElementById(y).focus();
	}
	function getQueryString(name) { 
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r != null) return unescape(r[2]); return null; 
	} 
	var s =getQueryString("shangjiId");
	window.onload = function(){
   		 $("#shangjiId").val(s);
	}; 
	
</script>
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="../common/navigation.jsp"></jsp:include>
<div class="breadThumb">首页 &gt; 个人注册</div>
<div class="hdzxtg">
    <!--  <h1 class="register-title text-center"><i class="iconfont">&#xf00ec;</i>个人会员</h1> -->
     <div class="hyzcmain">
       <div class="hyfore2">
       </div>  
              
         <div class="zchyleft" style="margin-left:105px;">
         <form id="memberFrom" method="post" action="memberRegister.html"> 
     		<input type="hidden" value="${mdid}" id="mdid" name="member.recommendUserId"/>  
     		 <div class="hyzc2">
               <span class="jz dlnc">分&nbsp;&nbsp;享&nbsp;号：</span>
              <div class="dlwbk">
              <label for="textfield"></label>
               <input class="dlwbbk" name="member.shangjiId" id="shangjiId" type="text" placeholder="分享号不能为空" />
              </div>  <span class="btx">*</span>
         </div>
            <div class="hyzc2">
              <span class="jz dlnc">手&nbsp;&nbsp;机&nbsp;号：</span>
              <div class="dlwbk">
              <label for="textfield"></label>
               <input class="dlwbbk" name="member.username" id="memberUsername" type="text" placeholder="请使用电话号码进行注册" />
              </div>
              <span class="btx">*</span>
         </div>
         
         <div class="hyzc2">
              <span class="jz dlnc">登录密码：</span>
              <div class="dlwbk">
              <label for="textfield"></label>
              <input class="dlwbbk" name="member.password" id="memberPwd" type="password" placeholder="密码不少于6位，请牢记"/>
              </div>
              <span class="btx">*</span>
         </div>
         <div class="hyzc2">
              <span class="jz dlnc">确认密码：</span>
              <div class="dlwbk">
              <label for="textfield"></label>
             <input class="dlwbbk" name="passwordCheck" id="reMemberPwd" type="password" placeholder="再次输入密码，保持一致"/>
              </div>
              <span class="btx">*</span>
         </div>
         <div class="hyzc2">
              <span class="jz dlnc">验&nbsp;&nbsp;证&nbsp; 码：</span>
           <div class="dlwbk">
              <label for="textfield"></label>
             <input class="yzmbk" type="text" name="veryCode" id="veryCode" maxlength="4"/>
             <span class="btx"> 
			<img src="validatecode" onclick="javascript:this.src='validatecode?id='+  Math.random();"
				alt="看不清,换一个,请点我"/>
			</span>
              <span class="btx">*</span>
           </div>
              			
         </div>
         <div class="hyzc2"  style="padding-left:80px">
         	<a href="javascript:void(0)" class="btn btn-primary" onclick="memberFromSub();">注 册</a>
         </div>
         </form>
         </div>
   
     <div class="zchyleft">
        <a href="http://www.sanguhuivip.com/download.jsp">  <img src="images/zcwxts.png" alt="" style="margin-top: 30px;" /></a>
     </div>
    </div>     
  </div>
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
<!-- footer end -->
</body>
</html>
