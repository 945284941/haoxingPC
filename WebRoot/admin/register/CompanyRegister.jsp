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
		<title>三古汇官方商城</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="x-ua-compatible" content="ie=7" />
		<jsp:include page="/admin/common/keyWords.jsp" />
		<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<link href="css/master.css" rel="stylesheet" type="text/css"/>
		<link href="css/news.css" rel="stylesheet" type="text/css"/>
		<link href="css/shophy.css" rel="stylesheet" type="text/css"/>
		<link href="css/common.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="js/register.js"></script>
		<script type="text/javascript">
			function setCompanyStyle(x,y){
				document.getElementById(x).style.display='none';
				document.getElementById(y).focus();
			}
		
		</script>
	</head>

	<body>
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
  <!-- 导航 -->
  <jsp:include page="../common/navigation.jsp"></jsp:include>
  <!-- 导航结束 -->
  <div class="breadThumb" >首页 &gt; 企业注册</div>

  <div class="hdzxtg">
     <div class="huiyuanbt">
     	<p class="huiyuanbtgr">个人会员</p>
       <p class="huiyuanbtqynew">企业会员</p>
       </div>    
     <div class="hyzcmain">
       <div class="hyfore2">
       </div>  
              
           <div class="zchyleft" style="margin-left:105px;">
            <form id="companyFrom" method="post" action="companyRegister.html">
            <input type="hidden" value="${mdid}" id="mdid" name="member.recommendUserId"/>
           <div class="hyzc2">
              <span class="jz dlnc">用&nbsp;&nbsp;户&nbsp;名：</span>
              <div class="dlwbk">
              <label for="textfield"></label>
              <input class="dlwbbk" name="company.username" id="companync" type="text" onfocus="setCompanyStyle('companyz','companync')"/>
              </div>
              <span class="btx">*</span>
              <span class="jz qyjc">(企业简称)</span>
              <div class="zcgzz" id="companyz" onclick="setCompanyStyle(this.id,'companync')">可使用汉字、英文、数字注册</div>
         </div>
         <div class="hyzc2">
              <span class="jz dlnc">登录密码：</span>
              <div class="dlwbk">
              <label for="textfield"></label>
             <input class="dlwbbk" name="company.password" id="companyPwd" type="password" onfocus="setCompanyStyle('companyPwdz','companyPwd')"/>
              </div>
              <span class="btx">*</span>
              <div class="zcgzz" id="companyPwdz" onclick="setCompanyStyle(this.id,'companyPwd')">密码不少于6位，请牢记</div>
         </div>
         <div class="hyzc2">
              <span class="jz dlnc">确认密码：</span>
              <div class="dlwbk">
              <label for="textfield"></label>
             <input class="dlwbbk" type="password" id="reCompanyPwd" onfocus="setCompanyStyle('reCompanyPwdz','reCompanyPwd')"/>
              </div>
              <span class="btx">*</span>
              <div class="zcgzz" id="reCompanyPwdz" onclick="setCompanyStyle(this.id,'reCompanyPwd')">再次输入密码，保持一致</div>
         </div>
        <div class="hyzc2">
              <span class="jz dlnc">验&nbsp;&nbsp;证&nbsp; 码：</span>
           <div class="dlwbk">
              <label for="textfield"></label>
             <input class="yzmbk" type="text" name="veryCode" id="veryCode" maxlength="4" onfocus="setCompanyStyle('yz','veryCode')"/>
              </div>
              <span class="btx"> 
			<img src="validatecode" onclick="javascript:this.src='validatecode?id='+  Math.random();"
				alt="看不清,换一个,请点我"/>
			</span>
              <span class="btx">*</span>
        <div class="zcgzz" id="yz" onclick="setCompanyStyle(this.id,'veryCode')">请准确输入</div>				
         </div>
         <div class="zcxyban"><a href="javascript:void(0)" onclick="companyFormsub();">注册</a></div>
         </form>
         </div>
     <div class="zchyleft">
        <div class="hyzc2wxts">
          <p class="zcwxtsbt">温馨提示：如您只想购物请注册<span class="red">个人会员</span>获得更多专业服务。</p>
        </div>       
     </div>
    </div>  
      
  </div>

	</div>
	<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
  <jsp:include page="/admin/common/indexFooter.jsp" />
<!-- footer end -->
		
		<div  id="pop_member"
		style="display: none;position: absolute; z-index: 100;">
		<jsp:include page="MemberPrompt.jsp" flush="true" />
</body>
</html>
