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

	<div class="gzgzvip zsone zsone2">
	
		<!-- contact start -->
		<jsp:include page="/memberCenter/company/shop/front/commonContact.jsp" />
		<!-- contact end -->
		
		<div class="zscompany2">
			<div class="zst">
				<span>您的位置：</span><a>网站首页 > 企业资讯</a>
			</div>
			<h2>
				<span>企业资讯</span><span style="color:#d81f24; margin-left:10px;">NEWS</span>
			</h2>
			<div class="zscom-content">
				<p class="title">${companysInfo.firstTitle}</p>
				<p class="title2">
					<span class="tit-time">发布日期：<s:date
							name="%{companysInfo.createTime}" format="yyyy/MM/dd" /> </span><span>浏览次数：【${companysInfo.views}】次</span>
				</p>
				<p class="zscontent">${companysInfo.content}</p>
				<p class="title2">
					<a href="/Shop/comInformation/detail/${c1.id}_${company.id}.html" class="tit-time" title="${c1.firstTitle}">上一篇： 
					<s:if test="null!=#request.c1.firstTitle&&#request.c1.firstTitle.length()>18">
						<s:property value="#request.c1.firstTitle.substring(0, 18)" />
		            </s:if> 
		            <s:else>
						${c1.firstTitle}
				    </s:else>					
					</a>
					<a href="/Shop/comInformation/detail/${c2.id}_${company.id}.html" title="${c2.firstTitle}">下一篇：
					<s:if test="null!=#request.c2.firstTitle&&#request.c2.firstTitle.length()>18">
						<s:property value="#request.c2.firstTitle.substring(0, 18)" />
		            </s:if> 
		            <s:else>
						${c2.firstTitle}
				    </s:else>					
					</a>
				</p>
			</div>
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
