<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>评论</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<jsp:include page="/admin/common/keyWords.jsp" />
	<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
    <div id="pjnr" class="tcpj" >
		<h2>
			<span>评价内容</span><a href="#"
				onclick="stopsplbtitle('tanchu', 'pjnr');">【关闭】</a>
		</h2>
		<p class="pjcontent">
			<textarea name="" cols="" rows="">尊敬的老板：你的产品</textarea>
		</p>
		<div style="margin-left:15px; position:relative">
			<a class="tcqr">保存评价</a>
			<div class="tcsc">
				<input name="" type="checkbox" value="" />删除此条信息<a href="#">[OK]</a>
			</div>
		</div>
		<div class="tcmjpj">
			<h2>卖家评级</h2>
			<p style="color:#b0080e">
				<span>服务评级</span><span><img src="/images/memberimg/pjdj.gif" />
				</span>
			</p>
			<p style="color:#00589d">
				<span>质量评级</span><span><img src="/images/memberimg/pjdj.gif" />
				</span>
			</p>
			<p style="color:#e45e00">
				<span>信誉评级</span><span><img src="/images/memberimg/pjdj.gif" />
				</span>
			</p>
			<p style="color:#72a023">
				<span>物流评级</span><span><img src="/images/memberimg/pjdj.gif" />
				</span>
			</p>
		</div>
	</div>
  </body>
</html>
