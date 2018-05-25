<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
	<div class="index_sptj_nr">
		<ul>
			<c:forEach items="${searchGoodsList}" var="goods" varStatus="status">
			<li class="item ">
				<div class="goods-content" id="taotian">
					<div class="goods-pic">
						<a isconvert="1" data-itemid="544015300167" href="goods/${goods.id}.html" target="_blank">
							<img src="${goods.defaultPicSrc}" style="height: 231px;">
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
								<a isconvert="1" data-itemid="544015300167" href="goods/${goods.id}.html" target="_blank">${goods.name}</a>
						</div>
						<div class="goods-price">
							<div class="goods-price_div">
								<em class="sale-price">¥$<fmt:formatNumber type="number" value="${goods.price}" pattern="0.00" maxFractionDigits="2"/></em><br>
								<span class="yuanjia">￥$<fmt:formatNumber type="number" value="${goods.yuanjia}" pattern="0.00" maxFractionDigits="2"/></span>
							</div>
							<div class="goods-price_div01">
								<span class="goods_buy">$<fmt:formatNumber type="number" value="${goods.docPrice}" pattern="0.00" maxFractionDigits="2"/></span><br>
								<span class="goods_buy">AED<fmt:formatNumber type="number" value="${goods.dlmPrice}" pattern="0.00" maxFractionDigits="2"/></span>
							</div>
						</div>
						<div class="goods-sales">
							<p class="fl">销量 ${goods.queryNum}</p>
							<p class="fr">好评 ${goods.praiseRate * 100}%</p>
						</div>
					</div>
				</div>
			</li>
			</c:forEach>
		</ul>

	</div>

	<div class="clear"></div>
	<div class="w-page">
		<page:pagination path="searchGoodsAction!searchGoods.action" formName="searchGoodsForm"/>
	</div>

