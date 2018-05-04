<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<form id="pagerForm" name="pagerForm" action="${sessionInfo.toUrl}" method="post">
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
                                <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">
                                    <img src="${goods.defaultPicSrc}">
                                </a>
                                <%--<div class="index_sptj_nr_qg"><s:text name="index_0269"/></div>--%>
                                <div class="index_sptj_nr_sl"><s:text name="index_0028"/>${goods.store} <s:text name="index_0029"/></div>
                            </div>
                            <div class="goods-info">
                                <div class="goods-name">
                                    <c:if test="${'zh' eq sessionInfo.language}">
                                        <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">${goods.name}</a>
                                    </c:if>
                                    <c:if test="${'zh' ne sessionInfo.language}">
                                        <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">${goods.enName}</a>
                                    </c:if>
                                </div>
                                <div class="goods-price">
                                    <div class="goods-price_div">
                                        <em class="sale-price">￥${goods.price}</em><br>
                                        <span class="yuanjia">￥${goods.yuanjia}</span>
                                    </div>
                                    <div class="goods-price_div01">
                                        <span class="goods_buy">$ ${goods.docPrice} </span><br>
                                        <span class="goods_buy">AED$ ${goods.dlmPrice} </span>
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
            <page:pagination path="toMarket.html" formName="pagerForm"/>
        </div>
    </div>
</div>