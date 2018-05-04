<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%@ taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<ul id="navul">
    <c:forEach items="${dictList}" var="dict" varStatus="status">
    <li>
        <c:if test="${'zh' eq sessionInfo.language}">
        <a id="65537" href="${dict.value}" target="_blank" original_url=""><span>${dict.label}</span></a>
        </c:if>
        <c:if test="${'zh' ne sessionInfo.language}">
            <a id="65537" href="${dict.value}" target="_blank" original_url=""><span>${dict.labelEng}</span></a>
        </c:if>
    </li>
    </c:forEach>
    <li style="float: right;">
        <a id="229380" href="#" target="_blank" original_url=""><span><img src="images/lh_01.png"/></span></a>
    </li>
</ul>