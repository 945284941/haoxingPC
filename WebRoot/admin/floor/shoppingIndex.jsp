<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--超市首页信息-->
<div class="main">
    <div class="index">
        <!-- top_index -->
        <div class="top_index">
            <div class="top_mid_right">
                <!-- 右上角公告 -->
                <div class="top_mid_phone">
                    <div class="top_mid_nav">
                        <div class="top_mid_nav_phone this"><s:text name="index_0007"/></div>
                        <div class="top_mid_nav_phone" style="float: right;">
                            <a href="#"><s:text name="index_0010"/></a>
                        </div>
                    </div>
                    <div class="top_mr_news">
                        <ul class="top_mr_box" style="display: block;" u_id="1">

                            <c:forEach items="${gonggaoList}" var="gongao" varStatus="status">
                                <li><b><a href="#" target="_blank"><fmt:formatDate value="${gongao.createtime}" pattern="yyyy-MM-dd" /></a></b>
                                    <c:if test="${'zh' eq sessionInfo.language}">
                                        <a href="#" target="_blank" title="${gongao.firstTitle}">${fn:substring(gongao.firstTitle,0, 11)}</a>
                                    </c:if>
                                    <c:if test="${'zh' ne sessionInfo.language}">
                                        <a href="#" target="_blank" title="${gongao.secondTitle}">${fn:substring(gongao.secondTitle,0, 11)}</a>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- 右上角公告结束 -->

                <!-- 右上角会员天地 -->
                <div class="top_mid_hytd">
                    <div class="top_mid_nav">
                        <div class="top_mid_nav_phone this"><s:text name="index_0008"/></div>
                    </div>
                    <div class="top_mr_hytd">
                        <p>￥1=$${huilv.now_rate_doc}</p>
                        <p>￥1=AED${huilv.now_rate_aed}</p>
                    </div>
                </div>
                <!-- 右上角会员天地结束 -->

            </div>
        </div>
        <!-- top_index结束 -->

        <!-- 限时抢购 -->
        <div class="index_sptj">
            <div class="index_sptj_tab">
                <ul>
                    <li class="this" goods_random="1"><s:text name="index_0009"/></li>
                    <li class="fr">
                        <a href="#" class="index_sptj_hyp"><s:text name="index_0010"/></a>
                    </li>
                </ul>
            </div>


            <div class="index_sptj_nr">
                <ul>
                        <c:forEach items="${flashSaleGoodsList}" var="goods" varStatus="status">
                            <li class="item ">
                                <div class="goods-content">
                                    <div class="goods-pic">
                                        <a isconvert="1" data-itemid="544015300167" href="goods/${goods.id}.html" target="_blank">
                                            <img src="${goods.defaultPicSrc}">
                                        </a>
                                        <!--<div class="index_sptj_nr_zk">9.8折</div>-->
                                    </div>
                                    <div class="goods-info">
                                        <div class="goods-name">
                                            <c:if test="${'zh' eq sessionInfo.language}">
                                                <a isconvert="1" data-itemid="544015300167" href="goods/${goods.id}.html" target="_blank">${goods.name}</a>
                                            </c:if>
                                            <c:if test="${'zh' ne sessionInfo.language}">
                                                <a isconvert="1" data-itemid="544015300167" href="goods/${goods.id}.html" target="_blank">${goods.enName}</a>
                                            </c:if>
                                        </div>
                                        <div class="goods-price">
                                            <div class="goods-price_div">
                                                <em class="sale-price">￥${goods.activityPrice}</em><br>
                                                <span class="yuanjia">￥${goods.yuanjia}</span>
                                            </div>
                                            <div class="goods-price_div01">
                                                <span class="goods_buy">$ <fmt:formatNumber type="number" value="${goods.docPrice}" pattern="0.00" maxFractionDigits="2"/></span><br>
                                                <span class="goods_buy">AED$ <fmt:formatNumber type="number" value="${goods.dlmPrice}" pattern="0.00" maxFractionDigits="2"/></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                </ul>

            </div>

        </div>
        <!-- 限时抢购结束 -->

        <!-- 首页中间内容 -->
        <div class="index_tj">
            <div class="index_tj_01">
                <a class="index_tj_01_top"><img src="${adMap["商城首页广告位1(PC)"].imageUrl}" /></a>
                <div class="index_tj_01_bottom">
                    <a class="index_tj_01_bottom_left"><img src="${adMap["商城首页广告位2(PC)"].imageUrl}" alt="" /></a>
                    <a class="index_tj_01_bottom_right"><img src="${adMap["商城首页广告位3(PC)"].imageUrl}" /></a>
                </div>
            </div>
            <a class="index_tj_02"><img src="${adMap["商城首页广告位4(PC)"].imageUrl}" /></a>
            <div class="index_tj_03">
                <a class="index_tj_03_left"><img src="${adMap["商城首页广告位5(PC)"].imageUrl}" alt="" /></a>
                <a class="index_tj_03_right"><img src="${adMap["商城首页广告位6(PC)"].imageUrl}" alt="" /></a>
            </div>
        </div>
        <!-- 首页中间内容结束 -->

        <!-- 商品推荐 -->
        <div class="index_sptj">
            <div class="index_sptj_tab" id="index_sale_tab">
                <ul>
                    <li class="this" id="goodscase2" goods_random="1"><s:text name="index_0011"/></li>
                    <li class="fr">
                        <a href="#" class="index_sptj_hyp"><s:text name="index_0010"/></a>
                    </li>
                </ul>
            </div>
            <div class="index_sptj_nr">
                <ul>

                    <c:forEach items="${shoppingGoodsList}" var="goods" varStatus="status">
                        <li class="item ">
                            <div class="goods-content" >
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
                                            <a isconvert="1" data-itemid="544015300167" href="goods/${goods.id}.html" target="_blank">${goods.name}</a>
                                        </c:if>
                                        <c:if test="${'zh' ne sessionInfo.language}">
                                            <a isconvert="1" data-itemid="544015300167" href="goods/${goods.id}.html" target="_blank">${goods.enName}</a>
                                        </c:if>
                                    </div>
                                    <div class="goods-price">
                                        <div class="goods-price_div">
                                            <em class="sale-price">￥${goods.price}</em><br>
                                            <span class="yuanjia">￥${goods.yuanjia}</span>
                                        </div>
                                        <div class="goods-price_div01">
                                            <span class="goods_buy">$ ${goods.docPrice}</span><br>
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
    </div>
</div>