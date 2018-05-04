<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute(ResourceUtil.getSessionInfoName());
	String memberId = sessionInfo == null ? "" : sessionInfo
			.getUserId();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>三古汇官方商城</title>
		<link href="/css/cxcss.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
</head>

		<div class="top01">
		</div>
		<div class="top02">
		</div>
		<div class="top03">
		</div>
		<div class="top04">
		</div>
		<div class="top05">
		</div>
		<div class="top06">
		</div>
		<div class="activity">
			<c:forEach items="${goodsHotList1}" var="v" varStatus="vs">
				<div class="sale">
					<h2>
						<span>${v.companyName }</span>
					</h2>
					
					<p>
					<a href="${v.activeGoodsAddr}" target="_blank" style="color:#b20d00;text-decoration:underline;LINE-HEIGHT:24px;">
						<c:choose>
							<c:when test="${fn:length(v.activeContent) > 70 }">
									${fn:substring(v.activeContent, 0, 70)}...
								</c:when>
							<c:otherwise>
									${v.activeContent}
								</c:otherwise>
						</c:choose>
					</a>
					</p>
					
					<div class="pro">
						<div class="pro_pic">
							<img src="${v.defaultPicSrc}" style="width: 103px; height: 78px;" />
						</div>
						<div class="pro_con">
							<p>
								原厂编号：${v.bn}
							</p>
							<p>
								适用车系：
								<c:choose>
									<c:when test="${fn:length(v.optimalCar) > 10 }">
									${fn:substring(v.optimalCar, 0, 10)}...
								</c:when>
									<c:otherwise>
									${v.optimalCar}
								</c:otherwise>
								</c:choose>
							</p>
							<p class="ckxq">
								<a href="${v.activeGoodsAddr}" target="_blank"><img
										src="/images/cx/link.gif" /> </a>
							</p>
						</div>
					</div>
					<p>
						活动期限：
						<fmt:formatDate value="${v.activeStartTime}" pattern="yyyy.MM.dd" />
						——
						<fmt:formatDate value="${v.activeEndTime}" pattern="yyyy.MM.dd" />
					</p>
				</div>
			</c:forEach>
			<div style="clear: both"></div>
		</div>
		<div class="activity activity2">
			<c:forEach items="${goodsHotList2}" var="v2" varStatus="vs2">
				<div class="sale_2">
					<h2>
						<span>${v2.companyName }</span>
					</h2>
					<div class="pro_2">
						<div class="pro_pic">
							<img src="${v2.defaultPicSrc}" />
						</div>
						<div class="pro_con_2">
							<p class="pro_contitle">
							<a href="${v2.activeGoodsAddr}" target="_blank" style="color:#b20d00;text-decoration:underline;LINE-HEIGHT:24px;">
								<c:choose>
									<c:when test="${fn:length(v2.activeContent) > 70 }">
									${fn:substring(v2.activeContent, 0, 70)}...
								</c:when>
									<c:otherwise>
									${v2.activeContent}
								</c:otherwise>
								</c:choose>
								</a>
							</p>
							<p>
								原厂编号：${v2.bn}
							</p>
							<p>
								适用车系：
								<c:choose>
									<c:when test="${fn:length(v2.optimalCar) > 25 }">
									${fn:substring(v2.optimalCar, 0, 25)}...
								</c:when>
									<c:otherwise>
									${v2.optimalCar}
								</c:otherwise>
								</c:choose>
							</p>
						</div>
					</div>
					<p class="hdtime">
						活动期限：
						<fmt:formatDate value="${v2.activeStartTime}" pattern="yyyy.MM.dd" />
						——
						<fmt:formatDate value="${v2.activeEndTime}" pattern="yyyy.MM.dd" />
					</p>
					<a class="ckxq" href="${v2.activeGoodsAddr}" target="_blank"><img
							src="/images/cx/link.gif" /> </a>
				</div>
			</c:forEach>
			<div style="clear: both"></div>
		</div>
		<div class="activity_3">
			<div class="activity_3_1">
			<c:if test="${(goodsHotList3)!= null && fn:length(goodsHotList3) > 7}">
				<c:forEach items="${goodsHotList3}" var="v3" varStatus="vs3">
					<div class="sale_3">
						<h2>
							<span>${v3.companyName }</span>
						</h2>
						<p>
						<a href="${v3.activeGoodsAddr}" target="_blank" style="text-decoration:underline;color:#4d2d00;LINE-HEIGHT:24px;">
							<c:choose>
								<c:when test="${fn:length(v3.activeContent) > 60 }">
									${fn:substring(v3.activeContent, 0, 60)}...
								</c:when>
								<c:otherwise>
									${v3.activeContent}
								</c:otherwise>
							</c:choose>
							</a>
						</p>
						<div class="pro">
							<div class="pro_pic">
								<img src="${v3.defaultPicSrc}" />
							</div>
							<div class="pro_con">
								<p>
									原厂编号：${v3.bn}
								</p>
								<p class="cxlbcx">
									适用车系：
									<c:choose>
										<c:when test="${fn:length(v3.optimalCar) > 18 }">
									${fn:substring(v3.optimalCar, 0, 18)}...
								</c:when>
										<c:otherwise>
									${v3.optimalCar}
								</c:otherwise>
									</c:choose>
								</p>
							</div>
						</div>
						<p class="hdtime">
							活动期限：
							<fmt:formatDate value="${v3.activeStartTime}" pattern="MM.dd" />
							-
							<fmt:formatDate value="${v3.activeEndTime}" pattern="MM.dd" />
						</p>
						<p class="ckxq_3">
							<a href="${v3.activeGoodsAddr}" target="_blank"><img
									src="/images/cx/salf_9.jpg" /> </a>
						</p>
					</div>
				</c:forEach>
				</c:if>
				<c:if test="${(goodsHotList3)!= null && fn:length(goodsHotList3) <= 7}">
				<c:forEach items="${goodsHotList3}" var="v3" varStatus="vs3">
					<div class="sale_3">
						<h2>
							<span>${v3.companyName }</span>
						</h2>
						<p>
						<a href="${v3.activeGoodsAddr}" target="_blank" style="text-decoration:underline;color:#4d2d00;LINE-HEIGHT:24px;">
							<c:choose>
								<c:when test="${fn:length(v3.activeContent) > 60 }">
									${fn:substring(v3.activeContent, 0, 60)}...
								</c:when>
								<c:otherwise>
									${v3.activeContent}
								</c:otherwise>
							</c:choose>
						</a>
						</p>
						<div class="pro">
							<div class="pro_pic">
								<img src="${v3.defaultPicSrc}" />
							</div>
							<div class="pro_con">
								<p>
									原厂编号：${v3.bn}
								</p>
								<p class="cxlbcx">
									适用车系：
									<c:choose>
										<c:when test="${fn:length(v3.optimalCar) > 18 }">
									${fn:substring(v3.optimalCar, 0, 18)}...
								</c:when>
										<c:otherwise>
									${v3.optimalCar}
								</c:otherwise>
									</c:choose>
								</p>
							</div>
						</div>
						<p class="hdtime">
							活动期限：
							<fmt:formatDate value="${v3.activeStartTime}" pattern="MM.dd" />
							-
							<fmt:formatDate value="${v3.activeEndTime}" pattern="MM.dd" />
						</p>
						<p class="ckxq_3">
							<a href="${v3.activeGoodsAddr}" target="_blank"><img
									src="/images/cx/salf_9.jpg" /> </a>
						</p>
					</div>
				</c:forEach>
				<div class="sale_3 sxgg">
					<p class="ggjr">
						<img src="/images/cx/sxgg02.jpg" />
					</p>
					<p class="ckxq_3">
						<a href="/admin/foot/contact.jsp" target="_blank"><img src="/images/cx/sxgg.jpg" />
						</a>
					</p>
				</div>
				</c:if>
				<div style="clear: both"></div>
			</div>
		</div>
		<c:if test="${(goodsHotList4)!= null && fn:length(goodsHotList4) > 0}">
		<div class="gqcxhd">
			<div class="gqcxhd02">
				<h2>
					<img src="/images/cx/gqtitle.png" />
				</h2>
				<c:forEach items="${goodsHotList4}" var="v4" varStatus="vs4">
					<div class="sale_3">
						<h2>
							<span>${v4.companyName }</span>
						</h2>
						<p>
						
							<c:choose>
								<c:when test="${fn:length(v4.activeContent) > 60 }">
									${fn:substring(v4.activeContent, 0, 60)}...
								</c:when>
								<c:otherwise>
									${v4.activeContent}
								</c:otherwise>
							</c:choose>
						
						</p>
						<div class="pro">
							<div class="pro_pic"  style="position: relative; display: block;">
								<img src="${v4.defaultPicSrc}"/>
							</div>
							<div class="pro_con">
								<p>
									原厂编号：${v4.bn}
								</p>
								<p class="cxlbcx">
									适用车系：
									<c:choose>
										<c:when test="${fn:length(v4.optimalCar) > 15 }">
									${fn:substring(v4.optimalCar, 0, 15)}...
								</c:when>
										<c:otherwise>
									${v4.optimalCar}
								</c:otherwise>
									</c:choose>
								</p>
							</div>
						</div>
						<p class="hdtime">
							活动期限：
							<fmt:formatDate value="${v4.activeStartTime}" pattern="MM.dd" />
							-
							<fmt:formatDate value="${v4.activeEndTime}" pattern="MM.dd" />
						</p>
						<p class="ckxq_3">
							<img src="/images/cx/salf_9.gif" /> 
						</p>
					</div>
				</c:forEach>
			</div>
			<div style="clear: both"></div>
		</div>
		</c:if>
		<div class="foot">
			<p>
				版权所有： 济南德睿东方商业管理有限公司 鲁ICP备13009108
			</p>
			<p>
				技术支持：济南德睿东方商业管理有限公司
			</p>
			<p>
				公司地址：山东省济南市天桥区二环北路8号
			</p>
		</div>
</html>
