<%@page import="com.qlzy.common.tools.PwdCrypt"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<link href="web/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/shophy.css" rel="stylesheet" type="text/css" />

<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script src="js/login.js" type="text/javascript"></script>
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="../common/navigation.jsp"></jsp:include>
<div class="breadThumb">	首页 &gt; 修改密码</div>
<div class="hdzxtg">
	<div class="hyzcmain" id="notice_0">
		<div class="hydlzcbt">会员密码修改</div>
		<form id="modifyPwdFrom" method="post">
			<input type="hidden" value="${userId}" name="member.id" />
			<input type="hidden" value="${userName}" name="member.username" />
			<input type="hidden" value="${userType}" name="userType" />
			<div class="hyhdxznr">
				<div class="hybd">
					<span class="jz dlnc">用  户  名：</span>
					<div class="dlwbk">
						<input class="dlwbbk" type="text" readonly="true" value="${userName}" 
								id="memberUsername"/>
					</div>
					<span class="btx">*</span>
				</div>
				<div class="hybd">
					<span class="jz dlnc">新  密  码：</span>
					<div class="dlwbk">
						<input class="dlwbbk"  name="member.password" id="memberPwd"
								type="password"/>
					</div>
					<span class="btx">*</span>
				</div>
				<div class="hybd">
					<span class="jz dlnc">确认密码：</span>
					<div class="dlwbk">
						<input class="dlwbbk" name="passwordCheck" id="reMemberPwd"
								type="password"/>
					</div>
					<span class="btx">*</span>
				</div>
				<p class="text-center"><a href="javascript:void(0)" class="btn btn-success" id="checkMsgId" style="width:160px;margin-left:-50px;" onclick="modifyPwdFromSub()">提交</a></p>
			</div>
		</form>
	</div>
</div>
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>