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
<script charset="utf-8" src="http://api.map.soso.com/v1.0/main.js"></script>
<script type="text/javascript" src="js/smap.js"></script>
<script language="JavaScript" type="text/JavaScript">
	function showElement(elementId) {
		document.getElementById(elementId).style.display = "block";
	}
	function hideElement(elementId) {
		document.getElementById(elementId).style.display = "none";
	}
	$(function() {
		address = '${company.pname}${company.cname}${company.aname}${company.address}';
		cname = '${company.companyName}';
		init(address,"1","0","1","container");
	});
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
<!-- 		<jsp:include page="/admin/common/vipShopHead.jsp" /> -->
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
				<span>您的位置：</span><a>网站首页 > 联系我们</a>
			</div>
			<h2>
				<span>联系我们</span><span style="color:#d81f24; margin-left:10px;">CONTACT
					US</span>
			</h2>
			<div class="cont">
				<div class="con-dz">
					<p>地址：${company.pname}${company.cname}${company.aname}${company.address}</p>
				</div>
				<div class="con-lx">
					<p>
						联系人：
						<s:if
							test="null!=company.linkmanName && ''!=company.linkmanName">${company.linkmanName}</s:if>
						<s:else>---</s:else>
					</p>
					<p>
						电话：
						<s:if
							test="null!=company.linkmanMobile && ''!=company.linkmanMobile">${company.linkmanMobile}</s:if>
						<s:else>---</s:else>
					</p>
					<p>
						手机：
						<s:if
							test="null!=company.linkmanPhone && ''!=company.linkmanPhone">${company.linkmanPhone}</s:if>
						<s:else>---</s:else>						
					</p>
				</div>
				<div class="con-yx">
					<p>
						企业网址：
						<s:if test="null!=company.domain && ''!=company.domain"><a href="http://${company.domain}.qlqpw.com">http://${company.domain}.qlqpw.com</a></s:if>
						<s:else>---</s:else>
					</p>
					<p>
						邮箱：
						<s:if test="null!=company.email && ''!=company.email">${company.email}</s:if>
						<s:else>---</s:else>
					</p>
				</div>
				
				<div class="ppt">
				
				<s:if test="null!=company.qqNumber">
				<a target=blank
					href=tencent://message/?uin=${company.qqNumber}&Site=www.ik38.com&Menu=yes>
					<img src="/images/vip/ppt.gif" alt="配配通" />
				</a>
			</s:if>
			<s:else>
				<a target=blank
					href=tencent://message/?uin=2221207332&Site=www.ik38.com&Menu=yes>
					<img src="/images/vip/ppt.gif" alt="配配通" />
				</a>
			</s:else>
			<span>点击配配通<br />
						进入商家即时聊天界面</span>
				</div>
				<div class="map">
					<div id="container" style="width:360px; height:350px;"></div>
				</div>
			</div>
		</div>
		<div style="clear:both"></div>
	</div>

	<!-- foot start -->
	<div class="gzgzvip footer">
<!-- 		<jsp:include page="/admin/common/vipShopFoot.jsp" /> -->
	</div>
	<!-- foot end -->

	<!-- 热销品类 start -->
	<s:action name="companyShopManageAction!gainCompanyGoodsCats"
		namespace="/comShopManage" executeResult="true"></s:action>
	<!-- 热销品类 end -->
</body>
</html>