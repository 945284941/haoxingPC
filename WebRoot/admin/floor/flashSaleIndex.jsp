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
    <form id="pagerForm" name="pagerForm" action="indexFloor/indexFloorAction!showIndexFlashSaleFloor.action" method="post">
        </form>
    <!-- 限时抢购 -->
    <div class="lh_xsqg_nr">
        <ul>
            <c:forEach items="${marketGoodsList}" var="goods" varStatus="status">
            <li class="fl">
                <div class="tupian">
                    <a href="goods/${goods.id}.html"><img src="${goods.defaultPicSrc}"/></a></div>
                <div class="title">
                        <a isconvert="1" data-itemid="544015300167" href="goods/${goods.id}.html" target="_blank">${goods.name}</a>
                </div>
                <div class="jg">
                    <div class="jg_zc">
                        <em>￥<fmt:formatNumber type="number" value="${goods.price * goods.activityPrice * goods.saleRate}" pattern="0.00" maxFractionDigits="2"/></em>
                        <span>￥<fmt:formatNumber type="number" value="${goods.yuanjia}" pattern="0.00" maxFractionDigits="2"/></span>
                    </div>
                    <div class="jg_yj">
                        <span class="goods_buy">$ <fmt:formatNumber type="number" value="${goods.docPrice}" pattern="0.00" maxFractionDigits="2"/></span><br>
                        <span class="goods_buy">AED$ <fmt:formatNumber type="number" value="${goods.dlmPrice}" pattern="0.00" maxFractionDigits="2"/></span>
                    </div>
                </div>
                <div class="bottom"><a href="goods/${goods.id}.html">立即抢购</a></div>
            </li>
                </c:forEach>
        </ul>
        <div class="clear"></div>
        <div class="w-page">
            <page:pagination path="indexFloor/indexFloorAction!showIndexFlashSaleFloor.action" formName="pagerForm"/>
        </div>
    </div>

    <!-- 限时抢购结束 -->
</div>