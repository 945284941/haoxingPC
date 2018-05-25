<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="pagerForm" name="pagerForm"></form>
<ul>
        <c:forEach items="${wantDiscussList}" var="wd">
            <li>
                <a>${wd.content}</a>
                <p>${wd.username} <span class="fr">${wd.createTime}</span></p>
            </li>
        </c:forEach>
    </ul>
    <div class="clear"></div>
    <div class="w-page">
        <page:pagination path="wantDiscussAction!findList.action"
                         formName="pagerForm"/>
    </div>
