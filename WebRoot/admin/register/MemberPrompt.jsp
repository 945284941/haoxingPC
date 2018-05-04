<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
        <style>
         .wxts{ width:390px; float:left;  background:#FFF5F5;  font-size:14px; padding:30px; line-height:24px;color:#000; font-weight:bold; border:5px solid #DD373B; height:30px;}
         .red{ color:#ED1B23;}
        </style>
	</head>
	<body>
		<div id="divMemberPrompt" style="overflow:hidden;position:relative" >
			  <div class="wxts">
                 请填写真实有效的个人信息，用于兑奖；否则视为无效！
              </div>
              <span style="position:absolute;right:10px;top:-5px; margin-top: 5px;"> <a
				onClick="hiddenMember('maskmember','pop_member');" style="cursor: pointer; width:70px; height:60px; float: right; background: url(images/close.gif) no-repeat 72px 10px; color:#B91A1E; padding-left:20px; padding-top:5px; font-size:12px;">已阅关闭</a>
			</span>          
		</div>

	</body>
</html>
