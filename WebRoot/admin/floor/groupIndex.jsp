<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<div class="main">
    <div class="h_seat">
        <a href="/"><s:text name="index_0013"/></a> >
        <a href="">${sessionInfo.curentMenu}</a>
    </div>
    <form id="pagerForm" name="pagerForm" action="${sessionInfo.toUrl}" method="post">
        </form>
    <!-- 团多多 -->
    <div class="lh_xsqg_nr">
        <ul>
            <c:forEach items="${marketGoodsList}" var="goods" varStatus="status">
            <li class="fl">
                <div class="tupian"><img src="${goods.defaultPicSrc}"/></div>
                <div class="title">
                    <c:if test="${'zh' eq sessionInfo.language}">
                        <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">${goods.name}</a>
                    </c:if>
                    <c:if test="${'zh' ne sessionInfo.language}">
                        <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">${goods.enName}</a>
                    </c:if>
                </div>
                <div class="jg">
                    <div class="jg_zc">
                        <em>￥${goods.activityPrice}</em>
                        <span>￥${goods.yuanjia}</span>
                    </div>
                    <div class="jg_yj">
                        <span class="goods_buy">$ ${goods.docPrice}</span><br>
                        <span class="goods_buy">AED$ ${goods.dlmPrice}</span>
                    </div>
                </div>
                <div class="bottom"><a href="#">立即抢购</a></div>
                <div class="tuan">2人团</div>
            </li>
                </c:forEach>
        </ul>
        <div class="clear"></div>
        <div class="w-page">
            <page:pagination path="toFlashSale.html" formName="pagerForm"/>
        </div>
    </div>

    <!-- 限时抢购结束 -->
</div>