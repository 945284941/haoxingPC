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
	<div class="lh_sssp_left">
		<ul>
<c:forEach items="${searchCompanyList}" var="company" varStatus="status">
			<li>
				<div class="lh_sssp_left_top">
					<div class="lh_sssp_left_top_left">
						<div class="lh_sssp_left_top_left_logo"><img src="images/zishu_03.png" /></div>
						<div class="lh_sssp_left_top_left_title">
							<p>${company.companyName}</p>
							<p><span>${company.combrief}</span></p>
							<p><span>${company.address}</span></p>
							<p><span>好评率: 99.02%</span><span style="float: right;">共300件宝贝</span></p>
						</div>
					</div>

				</div>
				<div class="index_sptj_nr searchi_cplist">
					<ul>
					<c:forEach items="${company.goodsList}" var="goods" varStatus="gStatus">
						<li class="item ">
							<div class="goods-content" id="taotian">
								<div class="goods-pic">
									<a isconvert="1" data-itemid="544015300167" href="#" target="_blank">
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
											<em class="sale-price">¥${goods.price}</em><br>
											<span class="yuanjia">￥${goods.yuanjia}</span>
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
			</li>
	</c:forEach>
					</ul>
	</div>
<div class="clear"></div>
<div class="w-page">
	<page:pagination path="searchGoodsAction!searchGoods.action" formName="searchCompanyForm"/>
</div>
