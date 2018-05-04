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
<link href="css/vipshopsh.css" rel="stylesheet" type="text/css" />
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
	<jsp:include page="/memberCenter/company/shop/front/comLogoSh.jsp" />
	<!-- logo end -->

	<!-- menu start -->
		<jsp:include page="/memberCenter/company/shop/front/comMenuSh.jsp" />
	<!-- menu end -->

	<!-- compurpose start 
	<jsp:include page="/memberCenter/company/shop/front/comPurpose.jsp" />
 compurpose end -->

	<!-- head-img start -->
	<s:action name="companyShopManageAction!gainCompanysHeadImgsSh"
		namespace="/comShopManage" executeResult="true"></s:action>
	<!-- head-img end -->

	<div class="gzgz zsone zsone2">

		<!-- contact start -->
		<jsp:include page="/memberCenter/company/shop/front/commonContactSh.jsp" />
		<!-- contact end -->

		<div class="zscompany2">
			<div class="zst">
				<span>您的位置：</span><a>网站首页 > 企业资讯</a>
			</div>
			<h2>
				<span>企业资讯</span><span style="color:#d81f24; margin-left:10px;">NEWS</span>
			</h2>
			<div class="zszxlb">
				<ul>
					<s:if test="%{companysInfoList.size()>0}">
						<s:iterator value="companysInfoList" var="ci">
							<li><a
								href="/Shop/comInformation/detail/<s:property value="#ci.id" />_${company.id}.html">
									<s:if test="null!=#ci.firstTitle&&#ci.firstTitle.length()>32">
										<s:property value="#ci.firstTitle.substring(0, 32)" />...</s:if> <s:else>
										<s:property value="#ci.firstTitle" />
									</s:else> </a><span><s:date name="#ci.createTime"
										format="yyyy/MM/dd hh:mm" /> </span>
							</li>
						</s:iterator>
					</s:if>
					<s:else>
						<span style="color:red;">暂无资讯!</span>
					</s:else>
				</ul>
			</div>
			<!-- 分页开始 -->
			<div id="showpages">
				<page:pagination
					path="Shop/comInformation/list/${company.id}.html" />
			</div>
			<!-- 分页结束 -->
		</div>
		<div style="clear:both"></div>
	</div>

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