<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script  type="text/JavaScript">
</script>
<div class="hyrightr hyflgl">
	<div id="rightjxw" style="margin-left:30px;">
	        <s:action name="statisticsAction!showRightStatistics" namespace="/statisticsManage" executeResult="true"/>
	</div>
</div>