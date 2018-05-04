<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
		<s:if test="%{comGoodsList.size()>0}">
			<s:iterator value="comGoodsList" var="comGoodsList">
				<div class="vipcplb">
					<h2>
						<span> <s:property value="#comGoodsList.gname" /> </span><a
							href="/Shop/moreComgoods/<s:property value='#comGoodsList.gid'/>_${company.id}.html"
							target="_blank">更多>></a>
					</h2>
					<s:if test="#comGoodsList.glist.size()>0">
						<div class="vipxh">
							<s:iterator value="#comGoodsList.glist" var="li">
								<div class="gotpicz cpgot">
									<p class="eproduct">
										<a href="/goods/<s:property value='#li.id'/>.html"
											target="_blank"><img
											src="<s:property value='#li.defaultPicSrc'/>" /> </a>
									</p>
									<p class="p-name">
										<a href="goods/<s:property value='#li.id'/>.html"
											target="_blank" title="<s:property value='#li.name' />">
											<s:if test="null!=#li.name&&#li.name.length()>17">
												<s:property value="#li.name.substring(0, 17)" />......
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
							<div style="clear:both"></div>
						</div>
					</s:if>
					<s:else>
						<span style="color:red;">暂时没有符合条件的数据！</span>
					</s:else>
				</div>
			</s:iterator>
		</s:if>
		<s:else>
			<span style="color:red;">暂时没有符合条件的数据！</span>
		</s:else>
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