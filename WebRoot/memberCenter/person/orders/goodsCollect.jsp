<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="x-ua-compatible" content="ie=7" />
	<jsp:include page="/admin/common/keyWords.jsp" />
	<title>颐佳商城</title>
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<meta http-equiv="keywords" content="颐佳,商城" />
	<meta http-equiv="description" content="颐佳,商城" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<!-- <link rel="stylesheet" href="web/bootstrap/bootstrap.min.css" type="text/css" /> -->
	<link rel="stylesheet" href="web/css/sghsc-main.css" type="text/css" />
	<link rel="stylesheet" href="web/css/sghsc-order.css" type="text/css" />
	<link rel="stylesheet" href="web/css/datePicker.css" />

	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<link rel="stylesheet" href="css/hyzxgr.css" type="text/css" />
	<link rel="stylesheet" href="css/page.css" type="text/css" />

	<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
	<script type=text/javascript src="js/layer/layer.min.js"></script>
	<script type=text/javascript src="js/slides.jquery.js"></script>
	<script type=text/javascript src="js/tanchu.js"></script>
	<script type=text/javascript src="js/register.js"></script>
	<script type="text/javascript" src="js/layer/layer.js"></script>

	<!-- 日历控件 -->
	<script type="text/javascript" src="web/js/jquery.date_input.pack.js"></script>
	<style type="text/css">
		.lh_dpsc ul li{
			float: left;
			margin-left:55px;
			margin-top: 0px;
			width: 290px;
			height:35px;
			border: 0px solid;
		}
	</style>
</head>
<body>

<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toPersionLogo" executeResult="true" namespace="/"></s:action>

<div style="background: #f6f6f6;">
	<div class="main">
		<!--我是买家-->
		<div class="h_content">
			<!-- 左侧功能菜单开始 -->
			<jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" />
			<!-- 左侧功能菜单结束 -->
			<div class="w-buyers">
				<div class="l-fr ">
					<div class="w-title">
						<h3>我的收藏>商品收藏</h3>
					</div>
					<div class="index_sptj_nr index_sptj_nr3">
						<c:if test="${empty memberCollectList}">
							<div style="text-align: center;"><img src="images/wujilu.jpg"/></div>
						</c:if>
						<ul>
							<c:if test="${not empty memberCollectList}">
							<c:forEach items="${memberCollectList}" var="memberCollect">
								<li class="item ">
									<div class="goods-content" id="taotian">
										<div class="goods-pic">
											<a isconvert="1" data-itemid="544015300167" href="goods/${memberCollect.goodsId}.html" target="_blank">
												<img src="${memberCollect.defaultPicSrc}" />
											</a>
											<div class="index_sptj_nr_qg">抢购</div>
											<div class="index_sptj_nr_sl">仅剩${memberCollect.store}件</div>
										</div>
										<div class="goods-info">
											<div class="goods-name">
												<%--<c:choose>
													<c:when test=""	>
														<a isconvert="1" data-itemid="544015300167" href="goods/${memberCollect.goodsId}.html" target="_blank">${memberCollect.name}</a>
													</c:when>
													<c:otherwise>
														<a isconvert="1" data-itemid="544015300167" href="goods/${memberCollect.goodsId}.html" target="_blank">${memberCollect.enName}</a>
													</c:otherwise>
												</c:choose>--%>
												<c:if test="${'zh' eq sessionInfo.language}">
													<a isconvert="1" data-itemid="544015300167" href="goods/${memberCollect.goodsId}.html" target="_blank">${memberCollect.name}</a>
												</c:if>
												<c:if test="${'zh' ne sessionInfo.language}">
													<a isconvert="1" data-itemid="544015300167" href="goods/${memberCollect.goodsId}.html" target="_blank">${memberCollect.enName}</a>
												</c:if>
											</div>
											<div class="goods-price">
												<div class="goods-price_div">
													<em class="sale-price">¥${memberCollect.price}</em><br>
													<span class="yuanjia">￥${memberCollect.yuanjia}</span>
												</div>
												<div class="goods-price_div01">
													<span class="goods_buy">$<fmt:formatNumber type="number" value="${huilv.now_rate_doc * memberCollect.price}" pattern="0.00" maxFractionDigits="2"/></span><br>
													<span class="goods_buy">AED<fmt:formatNumber type="number" value="${huilv.now_rate_dlm * memberCollect.price}" pattern="0.00" maxFractionDigits="2"/></span>
												</div>
											</div>
											<div class="goods-sales">
												<p class="fl">销量 ${memberCollect.queryNum}</p>
												<p class="fr">好评 ${memberCollect.praiseRate}%</p>
											</div>
											<div class="lh_dpsc">
												<ul>
													<li>
													<a class="qxsc" onclick="delCollect('${memberCollect.id}')">取消收藏</a>
													</li>
												</ul>
											</div>
										</div>
									</div>
								</li>
							</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--我是买家-->

</div>


<jsp:include page="/admin/common/indexFooter.jsp" />


<script type="text/javascript">
    //取消收藏
    function delCollect(id){
        if(confirm("确认要删除吗?")){
            $.ajax({
                url : "memberCallAction!delCollect.action",
                type : "POST",
                data : "id="+id,
                dataType : "JSON",
                success : function(){
                    window.location.href="showGoodsCollect.html";
                }
            });
        }
    }
</script>

</body>
</html>