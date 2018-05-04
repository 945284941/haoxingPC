<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/page.css" type="text/css" />
<title>三古汇官方商城</title>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript src="js/tanchu.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<div id="tanchu"></div>
</head>
<body>
	<!-- 头部开始 -->
	<div class="header">
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	</div>
	<div class="logo">
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	</div>
	<div id="warp">
		<jsp:include page="/memberCenter/common/navigation.jsp" />
	</div>
	<!-- 头部结束 -->
	<!-- 页脚开始 -->
	<!-- 页脚开始 -->
	<div class="dht">
		首页 > 会员中心 > 电子商城 > 订单管理 > 我的浏览
	</div>
	<div class="gzgz">
		<div class="hyleft">
			<c:choose>
				<c:when test="${sessionInfo.userType=='company' }"><jsp:include page="/memberCenter/common/leftNavigate.jsp" /></c:when>
				<c:otherwise><jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" /></c:otherwise>
			</c:choose>
		</div>
		<div class="hyright">
			<div class="hyrightr">
				<div id="rightjxw">
					<p class="hyd0">
						浏览商品总数<span>${browseStatisticsInfo.browseGoodsCount}</span>
					</p>
					<p class="hyd0">
						浏览店铺总数<span>${browseStatisticsInfo.browseShopCount}</span>
					</p>
				</div>

			</div>
			<p class="hymainbt">
				<span class="grmenubt">订单管理</span>
			</p>
			<div class="scsp">
				<h2>
					<a href="person/order/memberViews.html">浏览的商品</a><span>浏览的商铺</span>
				</h2>
			</div>
			<div class="hysclb">
				<div class="zxcz2 sclbksc1">
					<span><input type="checkbox" value="" name="" />全选</span><a
						class="sc" href="#">删除</a>
				</div>
				<div class="hysclb1">

					<s:iterator var="company" value="companies" status="status">
						<!-- 第一个广告 -->
						<s:if test="#status.index==3">
							<div style="clear:both"></div>
							<div class="scgg">
								<img src="/images/memberimg/gg03.gif" />
							</div>
						</s:if>
						<!-- 第二个广告 -->
						<s:if test="#status.index==6">
							<div style="clear:both"></div>
							<div class="scgg">
								<img src="/images/memberimg/gg03.gif" />
							</div>
						</s:if>
						<div class="sjsc">
							<div class="sjsc2">
								<p>
									<span class="name">商品名称：</span><span class="nr">${company.companyName}</span>
								</p>
								<p>
									<span class="name">所在区域：</span><span class="nr2">${company.pname}${company.cname}${company.aname}</span>
								</p>
								<p>
									<span>会员级别</span><span><img src="/images/levelIcon/${company.vipGradeImgSrc}" title="${company.vipLevelName}"/></span>
								</p>
								<p>
									浏览时间：
									<s:date name="#company.regTime"
										format="yyyy-MM-dd HH:mm:ss" />
								</p>
							</div>
							<div class="sjsc3">
								<span><input type="checkbox" value="${company.username}"
									name="" />删除</span> <a class="sc"
									href="Shop/index_${company.id }.html">进入店铺</a>
							</div>
						</div>
					</s:iterator>


					<div style="clear:both"></div>
				</div>
				<!-- 分页开始 -->
				<div id="showpages">
					<page:pagination path="rcomrecommends/more/list.html"
						formName="sjlbsplistSearchForm" />
				</div>
				<!-- 分页结束 -->
			</div>
		</div>
	</div>


	<!-- 页脚结束 -->
	<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
	<!-- footer end -->
</body>
</html>