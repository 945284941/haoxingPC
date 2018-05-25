<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<form id="pagerForm" name="pagerForm" action="toMarketPage/isIndexMarket.html" method="post">
</form>
<!--超市首页的商品-->
<div class="clear"></div>
<div class="main">
    <div class="index">
        <!-- 商品推荐 -->
        <div class="index_sptj" style="margin-top: 375px;">
            <div class="index_sptj_nr">
                <ul>
                    <c:forEach items="${marketGoodsList}" var="goods" varStatus="status">
                    <li class="item ">
                        <div class="goods-content" id="taotian">
                            <div class="goods-pic">
                                <a isconvert="1" data-itemid="544015300167" href="goods/${goods.id}.html" target="_blank">
                                    <img src="${goods.defaultPicSrc}">
                                </a>
                                <div class="index_sptj_nr_qg">
                                    <c:choose>
                                        <c:when test="${goods.cornerMark eq '1'}">
                                            <s:text name="index_0413"/>
                                        </c:when>
                                        <c:when test="${goods.cornerMark eq '2'}">
                                            <s:text name="index_0412"/>
                                        </c:when>
                                        <c:when test="${goods.cornerMark eq '3'}">
                                            <s:text name="index_0411"/>
                                        </c:when>
                                        <c:when test="${goods.cornerMark eq '4'}">
                                            <s:text name="index_0005"/>
                                        </c:when>
                                        <c:otherwise>
                                            <s:text name="index_0414"/>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="index_sptj_nr_sl"><s:text name="index_0028"/>${goods.store} <s:text name="index_0029"/></div>
                            </div>
                            <div class="goods-info">
                                <div class="goods-name">
                                        <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">${goods.name}</a>
                                </div>
                                <div class="goods-price">
                                    <div class="goods-price_div">
                                        <em class="sale-price">￥<fmt:formatNumber type="number" value="${goods.price * goods.saleRate}" pattern="0.00" maxFractionDigits="2"/></em><br>
                                        <span class="yuanjia">￥<fmt:formatNumber type="number" value="${goods.yuanjia}" pattern="0.00" maxFractionDigits="2"/> </span>
                                    </div>
                                    <div class="goods-price_div01">
                                        <span class="goods_buy">$ <fmt:formatNumber type="number" value="${goods.docPrice}" pattern="0.00" maxFractionDigits="2"/> </span><br>
                                        <span class="goods_buy">AED$ <fmt:formatNumber type="number" value="${goods.dlmPrice}" pattern="0.00" maxFractionDigits="2"/> </span>
                                    </div>
                                </div>
                                <div class="goods-sales">
                                    <p class="fl"><s:text name="index_0024"/> ${goods.queryNum} </p>
                                    <p class="fr"><s:text name="index_0027"/> ${goods.praiseRate * 100}% </p>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>
                </ul>
            </div>

        </div>
        <!-- 商品推荐结束 -->
        <div class="clear"></div>
        <div class="w-page">
            <page:pagination path="toMarketPage/${showType}.html" formName="pagerForm"/>
        </div>
    </div>
</div>