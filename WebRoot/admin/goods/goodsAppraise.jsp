<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<div class="lh_spxq_nr_zj_pj">
    <ul>
        <c:forEach items="${appraiseList}" var="appraise" varStatus="status">
            <li>
        <div class="top_pj">
            <span>
                <c:if test="${appraise.sincerity == 1 }">
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                </c:if>
               <c:if test="${appraise.sincerity == 2 }">
                   <i class="icon iconfont on" >&#xe668;</i>
                   <i class="icon iconfont on" >&#xe668;</i>
                   <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                   <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                   <i class="icon iconfont" style="color: #999;">&#xe668;</i>
               </c:if>
                <c:if test="${appraise.sincerity == 3 }">
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                </c:if>
                <c:if test="${appraise.sincerity == 4 }">
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                </c:if>
                 <c:if test="${appraise.sincerity == 5 }">
                     <i class="icon iconfont on" >&#xe668;</i>
                     <i class="icon iconfont on" >&#xe668;</i>
                     <i class="icon iconfont on" >&#xe668;</i>
                     <i class="icon iconfont on" >&#xe668;</i>
                     <i class="icon iconfont on" >&#xe668;</i>
                 </c:if>
            </span>
            <div class="top_pj_date">
                <em>${appraise.memberName}</em>
                <b>[<fmt:formatDate value="${appraise.createtime}" pattern="yyyy-MM-dd HH:mm:ss" />]</b>
            </div>
        </div>
            <p>${appraise.content}</p>
        <ul>
                <c:forEach items="${appraise.appraisePics}" var="appraisePic" varStatus="status">
                    <li><img src="${appraisePic.picUrl}" /></li>
                </c:forEach>
        </ul>
        <div style=" float:left;padding: 15px 0; font-size: 12px; color: #af874d;">
            <c:if test="${not empty appraise.replyContent}">
            <span style=" color: #bbbbbb;">[回复]</span>${appraise.replyContent}
            </c:if>
        </div>
    </li>
        </c:forEach>
    </ul>
</div>
<div class="w-page">
    <page:pagination path="gainGoodsAppraiseList/${goods.id}.html"
                     formName="pagerForm"/>
</div>
