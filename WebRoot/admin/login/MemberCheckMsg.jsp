<%@page import="com.qlzy.common.tools.PwdCrypt"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String login_name="";
	if(request.getParameter("ln")!=null){
		login_name = PwdCrypt.decrypt(request.getParameter("ln"));
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />

<title>颐佳官方商城</title>
<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/master.css" rel="stylesheet" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>

<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript src="js/login.js" ></script>
<div id="maskmember"></div>
</head>

<body id="mainbody">
	<!-- header begin -->
	<div id="tanchu"></div>
	<div class="header">
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	</div>
	<div class="logo">
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	</div>
	<!-- header end -->
	<!-- 导航 -->
	<jsp:include page="../common/navigation.jsp"></jsp:include>
	<!-- 导航结束 -->
<div class="breadThumb">首页 &gt; 忘记密码</div>
	<div class="hdzxtg">
		<div class="hyzcmain" id="notice_0">
			<div class="hydlzcbt">会员信息验证</div>
			<form id="checkPwdFrom" method="post">
				<div class="hyhdxznr">
					<div class="hybd">
						<span class="jz dlnc">用户名：</span>
						<div class="dlwbk">
							<input class="dlwbbk" type="text" name="member.username" id="memberName"/>
						</div>
						<span class="btx">*</span>
					</div>
					<div class="text-left" style="width:300px;margin:20px auto;" class="text-left">
								<a href="javascript:void(0)" id="checkMsgId"  class="btn btn-primary" style="width:80px;margin-left:20px;"
										onclick="checkPwdFromSub('maskmember', 'send_member')">邮箱验证</a>
								<a href="javascript:void(0)" id="checkMsgIdByPhone"  class="btn btn-primary" style="width:94px;margin-left:20px;"
										onclick="checkPwdFromSubByPhone('tanchu', 'mmxg_0',2,'mmxg_mobile');">手机号验证</a>
							</div>
				</div>
			</form>
		</div>
	</div>
	
<div id="mmxg_0" class="aqtc" style=" visibility:hidden">
  <div class="xgmm"><span class="zzjx">1.手机验证</span><span>2.登录密码修改</span></div>
  <p style="margin-left:65px; margin-top:30px;"><label>您当前绑定的手机号是：</label><span id="mmxg_mobile"></span></p>
  <p style="margin-left:65px; margin-top:10px;"><label>校验码：</label><input type="text" style="width:60px;" id="xgmm_mobile_yzm"/>&nbsp;
  <input class="yzm" id="xgmm_mobileCode" type="button" style="width:125px;" value="免费获取校验码" onclick="javascript:sendMobileCodeForBackPwd('xgmm_mobileCode',1,'mobileCheck');"/></p>
  <p style="margin-left:120px; margin-bottom:15px; margin-top:20px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="checkMobileCode('tanchu','mmxg_0','mmxg_1', 2,'xgmm_mobile_yzm')">确认</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="closePubDialog('tanchu', 'mmxg_0', 2);" >关闭</a>
  </p>
</div>
<div id="mmxg_1" class="aqtc" style=" visibility:hidden">
  <div class="xgmm"><span>1.手机验证</span><span class="zzjx">2.登录密码修改</span></div>
  <p style="margin-left:53px; margin-top:10px; margin-bottom:5px;"><label>新密码：</label><input type="password" style="width:200px;" id="m_new_password"/></p>
   <p style="margin-left:100px; margin-bottom:10px;"><span style="margin-left:10px; font-size:12px; color:#999999">密码长度6-10位，字母区分大小写</span></p>
  <p style="margin-left:40px; margin-top:10px; margin-bottom:10px;"><label>确认密码：</label><input type="password" style="width:200px;" id="m_new_pwd"/></p>
  <p style="margin-left:120px; margin-bottom:15px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="updatePassword('tanchu', 'mmxg_1', 2, 'mallLogin.html')">确认提交</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="closePubDialog('tanchu', 'mmxg_1', 2);">关闭</a>
  </p>
</div>
	
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
	<!-- footer end -->
	<div  id="send_member"
		style="display: none;position: absolute; z-index: 100;">
	</div>
</body>
</html>