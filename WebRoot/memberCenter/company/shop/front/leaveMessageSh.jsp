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
<link href="css/vipshopsh.css" rel="stylesheet" type="text/css" />
<link href="css/page.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides2.jquery.js"></script>
<script type="text/javascript" src="js/images-slide.js"></script>
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

		<form id="addMessageForm" name="addMessageForm" action="Shop/addMessage.html" method="post">
			<div class="zscompany2">
				<div class="zst">
					<span>您的位置：</span><a>网站首页 > 客户留言</a>
				</div>
				<h2>
					<span>客户留言</span><span style="color:#d81f24; margin-left:10px;">FEEDBACK</span>
				</h2>
				<div class="wyly">
					<s:if test="'member'==userType">
						<p>
							<span class="label">用户名：</span>${member.username} <input
								type="hidden" id="memberName" name="companysMessage.memberName"
								value="${member.username}" />
						</p>
						<p>
							<span class="label">电话： </span>
							<s:if
								test="(null!=member.mobile&&''!=member.mobile)&&(null!=member.telphone&&''!=member.telphone)">${member.mobile}/
	      											${member.telphone}</s:if>
							<s:elseif
								test="(null!=member.mobile&&''!=member.mobile)&&(null==member.telphone&&''==member.telphone)">${member.mobile}</s:elseif>
							<s:elseif
								test="(null==member.mobile&&''==member.mobile)&&(null==member.telphone&&''==member.telphone)">${member.telphone}</s:elseif>
							<s:else>---</s:else>
						</p>
						<p>
							<span class="label">邮箱：</span>
							<s:if test="null!=member.email&&''!=member.email">
								${member.email}
							</s:if>
							<s:else>---</s:else>
						</p>
					</s:if>
					<s:else>
						<p>
							<span class="label">用户名：</span>${company.username} <input
								type="hidden" id="memberName" name="companysMessage.memberName"
								value="${company.username}" />
						</p>
						<p>
							<span class="label">电话： </span>
							<s:if
								test="(null!=company.linkmanMobile&&''!=company.linkmanMobile)&&(null!=company.linkmanPhone&&''!=company.linkmanPhone)">${company.linkmanMobile}/
	      											${company.linkmanPhone}</s:if>
							<s:elseif
								test="(null!=company.linkmanMobile&&''!=company.linkmanMobile)&&(null==company.linkmanPhone&&''==company.linkmanPhone)">${company.linkmanMobile}</s:elseif>
							<s:elseif
								test="(null==company.linkmanMobile&&''==company.linkmanMobile)&&(null==company.linkmanPhone&&''==company.linkmanPhone)">${company.linkmanPhone}</s:elseif>
							<s:else>---</s:else>
						</p>
						<p>
							<span class="label">邮箱：</span>
							<s:if test="null!=company.email&&''!=company.email">
								${company.email}
							</s:if>
							<s:else>---</s:else>							
						</p>
					</s:else>
					<p style="margin-bottom:10px;">
						<span class="label">您的留言：</span>
						<textarea class="yzm" id="message" name="companysMessage.message"></textarea>
					</p>
					<p>
						<span class="label">验证码：</span> <input type="text" class="yzmtex"
							id="verifyCode" name="verifyCode" maxlength="4" /> <span
							class="yzmimg"><img src="validatecode"
							onclick="javascript:this.src='validatecode?id='+  Math.random();"
							alt="看不清,换一个,请点我" /> </span>
					</p>
				</div>
				<input type="hidden" name="companysMessage.companyId"
					value="${companyId}" /> <input type="hidden"
					name="companysMessage.memberId" value="${sessionInfo.userId}" /> <input
					type="hidden" name="companysMessage.memberType"
					value="${sessionInfo.userType}" />
				<s:token></s:token>
				<div class="wy-ly">
					<a href="javascript:void(0);"
						onclick="_addCompanysMessageFromSub();" target="_self"><img
						src="/images/vip/ly.gif" alt="我要留言" /> </a> <a
						href="javascript:void(0);" onclick="companysMessageFrom_clean();"><img
						src="/images/vip/cx.gif" alt="重写" /> </a> <input id="res" name="res"
						type="reset" style="display:none;" />
				</div>
			</div>
			
		</form>
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