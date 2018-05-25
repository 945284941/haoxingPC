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
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta content="IE=11.0000" http-equiv="X-UA-Compatible">
    <title>颐佳超市</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="/admin/common/keyWords.jsp" />
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<s:action name="catalogueAction!queryFullCategory" executeResult="true" namespace="/" >
    <s:param name="catType">cs</s:param>
</s:action>
<s:action name="catalogueAction!toLunbo" executeResult="true" namespace="/">
    <s:param name="lunboType">market_lunbo_pc</s:param>
</s:action>
<div id="pageReload">
    <s:action name="indexFloorAction!showIndexMarketOrBuildFloor" namespace="/indexFloor" executeResult="true">
        <s:param name="showType">isIndexMarket</s:param>
    </s:action>
</div>

<%--<jsp:include page="/admin/common/indexFooter.jsp" />--%>
<s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
</body>

</html>