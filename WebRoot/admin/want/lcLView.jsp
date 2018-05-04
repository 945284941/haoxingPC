<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta content="IE=11.0000" http-equiv="X-UA-Compatible">
    <title>颐佳超市</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../../admin/common/keyWords.jsp"></jsp:include>
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<s:action name="catalogueAction!queryFullCategory" executeResult="true" namespace="/" >
    <s:param name="catType">tdd</s:param>
</s:action>

<!-- 导航结束 -->
<div class="main">
    <div class="lh_fbqg"><img src="../../images/lh_fbqg.png"/></div>
    <div class="lh_fbqg_xq">
        <div class="lh_fbqg_xq_left">
            <div class="lh_fbqg_xq_left_bt"><b>${wantBuy.title}</b></div>
            <c:if test="${'zh' eq sessionInfo.language}">
            <p>货物分类：<span>${wantBuy.catName}</span></p>
            <p>发货国家：<span>${wantBuy.countryName}</span></p>
                <p>收货国家：<span>${wantBuy.toCountryName}</span></p>
            </c:if>
            <c:if test="${'zh' ne sessionInfo.language}">
                <p>货物分类：<span>${wantBuy.catEnName}</span></p>
                <p>发货国家：<span>${wantBuy.countryNameEng}</span></p>
                <p>收货国家：<span>${wantBuy.toCountryNameEng}</span></p>
            </c:if>
            <p>发货地址：<span>${wantBuy.fromAddress}</span></p>

            <c:if test="${'zh' eq sessionInfo.language}">
                <p>收货国家：<span>${wantBuy.toCountryName}</span></p>
            </c:if>
            <c:if test="${'zh' ne sessionInfo.language}">
                <p>收货国家：<span>${wantBuy.toCountryNameEng}</span></p>
            </c:if>
            <p>收货地址：<span>${wantBuy.toAddress}</span></p>
            <p>联系电话：<span>${wantBuy.mobile}</span></p>
            <p>联系邮箱：<span>${wantBuy.email}</span></p>
            <p>发货时间：<span><fmt:formatDate value="${wantBuy.sendDate}" pattern="yyyy-MM-dd HH:mm:ss" /></span></p>
            <p>拼箱详情：<span>${wantBuy.content}</span></p>
            <div class="lh_fbqg_xq_left_img">
                <c:forEach items="${wantBuy.picList}"  var="s" varStatus="status">
                <img src="${s}"/>
                </c:forEach>
            </div>
        </div>
        <div class="lh_fbqg_xq_right">
            <ul>
                <c:forEach items="${wantBuyList}"  var="w" varStatus="status">
                <li>
                    <a href="<%=basePath%>toWantBuyView/${w.id}/${w.buyType}.html">${w.title}</a>
                    <p>${w.mobile} <span class="fr"><fmt:formatDate value="${wantBuy.sendDate}" pattern="yyyy-MM-dd HH:mm" /></span></p>
                </li>
                </c:forEach>
            </ul>
        </div>
    </div>

</div>
<!--footer开始-->
<s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
<!--footer结束-->
</body>
</html>