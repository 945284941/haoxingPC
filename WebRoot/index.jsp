<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	String curDomain = request.getServerName();
	
	if(curDomain.equals("sanguhuivip.com")){
		System.out.println(curDomain);
		response.sendRedirect("http://www.sanguhuivip.com");
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta content="IE=11.0000" http-equiv="X-UA-Compatible">
	<title>颐佳超市</title>
	<jsp:include page="admin/common/keyWords.jsp" flush="true"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="3c0d2bedd819ab1c" property="wb:webmaster">
</head>
<body id="indexPage">
   <s:action name="common!toHead" executeResult="true" namespace="/"/>
   <s:action name="common!toLogo" executeResult="true" namespace="/"/>
   <s:action name="catalogueAction!queryFullCategory" executeResult="true" namespace="/" >
	   <s:param name="catType">gwsc</s:param>
   </s:action>
   <s:action name="catalogueAction!toCome" executeResult="true" namespace="/"/>
   <s:action name="indexFloorAction!showIndexShoppingFloor" namespace="/indexFloor" executeResult="true">
	   <s:param name="showType">index_ad_pc</s:param>
   </s:action>
   <s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
   <%--<jsp:include page="/admin/common/indexFooter.jsp" />--%>
</body>
</html>
