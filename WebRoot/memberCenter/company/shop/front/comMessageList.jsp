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
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/floor.js"></script>
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
				<span>您的位置：</span><a>网站首页 > 客户留言</a>
			</div>
			<h2>
				<span>客户留言</span><span style="color:#d81f24; margin-left:10px;">FEEDBACK</span>
			</h2>
			<div class="hyly">
				<div class="ly">
					<a href="javascript:void(0)"
						onclick="toLeaveMessage('${company.id}','${sessionInfo.userId}')"><img
						src="/images/vip/ly.gif" alt="我要留言" /> </a>
				</div>
				<s:if test="%{companysMessageList.size()>0}">
					<s:iterator value="companysMessageList" var="li">
						<div class="lynr">
							<p class="ly-title">
								<span class="ly-tit"><s:property value="#li.memberName" />
								</span><span>发布时间：<s:date name="#li.createTime"
										format="yyyy/MM/dd" /> </span>
							</p>
							<p class="hylynr">
								<s:property value="#li.message" />
							</p>
						</div>
					</s:iterator>
				</s:if>
				<s:else>
					<div class="lynr">
						<span style="color:red;">暂时没有符合条件的数据！</span>
					</div>
				</s:else>
			</div>
			<!-- 分页开始 -->
			<div id="showpages">
				<page:pagination path="Shop/comMessage/list/${company.id}.html" />
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