<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>古道金典</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<link href="css/vipshop.css" rel="stylesheet" type="text/css" />
<link href="css/page.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides2.jquery.js"></script>
<script type="text/javascript" src="js/images-slide.js"></script>
<script language="JavaScript" type="text/JavaScript">
	function showElement(elementId) {
		document.getElementById(elementId).style.display = "block";
	}
	function hideElement(elementId) {
		document.getElementById(elementId).style.display = "none";
	}
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
</head>

<body id="mainbody">
	<!-- head start -->
	<div class="header">
		<jsp:include page="/admin/common/vipShopHead.jsp" />
	</div>
	<!-- head end -->

	<!-- 代码 开始 -->

	<!-- logo start -->
	<jsp:include page="/memberCenter/company/shop/front/comLogo.jsp" />
	<!-- logo end -->
	
	<!-- menu start -->
		<jsp:include page="/memberCenter/company/shop/front/comMenu.jsp" />
	<!-- menu end -->

	<!-- compurpose start -->
	<jsp:include page="/memberCenter/company/shop/front/comPurpose.jsp" />
	<!-- compurpose end -->

	<!-- head-img start -->
	<s:action name="companyShopManageAction!gainCompanysHeadImgs"
		namespace="/comShopManage" executeResult="true"></s:action>
	<!-- head-img end -->
	
	<div class="gzgzvip cpwz">
		<span>您的位置：</span><a>网站首页 > 主营产品</a>
	</div>
	<!--商品展示开始-->
	<div class="gzgzvip">
		<div class="vipcplb">
			<h2>
				<span>${goodsCatName}</span>
			</h2>
			<div class="vipxhxq">
				<s:if test="%{goodsListByCom.size()>0}">
					<s:iterator value="goodsListByCom" var="li">
						<div class="gotpicz cpgot cpgotxq">
							<p class="eproduct">
								<a href="/goods/<s:property value='#li.id'/>.html"
									target="_blank"><img
									src="<s:property value='#li.defaultPicSrc'/>" /> </a>
							</p>
							<p class="p-name">
								<a href="goods/<s:property value='#li.id'/>.html"
									target="_blank" title="<s:property value='#li.name' />"> <s:if
										test="null!=#li.name&&#li.name.length()>15">
										<s:property value="#li.name.substring(0, 15)" />......
	           </s:if> <s:else>
										<s:property value="#li.name" />
									</s:else> </a>
							</p>
							<p class="p-name">
								<s:property value="#li.bn" />
							</p>
							<p class="p-price">
								<span class="dlf">¥</span><s:property value="#li.price" />
							</p>
						</div>
					</s:iterator>
				</s:if>
				<s:else>
					<span style="color:red;">暂时没有符合条件的数据！</span>
				</s:else>
				<div style="clear:both"></div>
			</div>
			<!-- 分页开始 -->
			<div id="showpages">
				<page:pagination
					path="Shop/moreComgoods/${goodsCatId}_${company.id}.html" />
			</div>
			<!-- 分页结束 -->
		</div>
	</div>
	<!--商品展示结束-->

	<!-- foot start -->
	<div class="gzgzvip footer">
		<jsp:include page="/admin/common/vipShopFoot.jsp" />
	</div>
	<!-- foot end -->
	
	<!-- 热销品类 start -->
	<s:action name="companyShopManageAction!gainCompanyGoodsCats"
		namespace="/comShopManage" executeResult="true"></s:action>
	<!-- 热销品类 end -->
</body>
</html>