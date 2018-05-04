<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<meta http-equiv="keywords" content="加盟合作，经营管理支持，市场拓展支持，行业分析支持，培训支持，开发客户" />
<meta http-equiv="description" content="公司将在市场上进行大力度的品牌建设投入，提升品牌形象；我们有完善的支持体系对加盟商进行经营管理支持、市场拓展支持、行业分析支持以及培训支持，欢迎大家来加盟。" />
<title>加盟合作，提供经营管理、市场拓展、行业分析、培训等支持</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<link rel="stylesheet" href="/css/newbanner.css" type="text/css" />
<link href="/css/foot_hyzxgr.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/css/staticlxwm.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>

<script type="text/JavaScript">
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
<body>
	<!-- header begin -->
	<div class="header">
		<jsp:include page="/admin/common/head.jsp"></jsp:include>
	</div>
	<div class="logo">
		<jsp:include page="/admin/common/logo.jsp"></jsp:include>
	</div>
	<!-- 头部开始 -->
	<jsp:include page="/admin/foot/head.jsp" />
	<!-- 页脚开始 -->
	<div class="dht">
		<a href="javascript:void(0)">首页</a> > <a href="javascript:void(0)">关于泉利</a> > <a href="javascript:void(0)">加盟合作</a>
	</div>
	<div class="gzgz">
		<div class="hyleft">
	<dl class="grhymenu">
		<dt>
			<span class="ddzxqtb"><img src="/images/footerImg/ddzxq.gif" /> </span>关于泉利
		</dt>
		<dd class="add">
			<a href="/admin/foot/company.jsp">公司简介</a>
		</dd>
		<dd class="add">
			<a class="hover"  href="/admin/foot/cooperation.jsp">加盟合作</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/contact.jsp">联系我们</a>
			
		</dd>
		<dd class="add">
					<a href="zp.html">诚聘英才</a>
				</dd>
		<dd class="add">
			<a href="/admin/foot/advertising.jsp">广告资源</a>
		</dd>
	</dl>
	<dl class="grhymenu">
		<dt>
			<span class="ddzxqtb"><img src="/images/footerImg/ddzxq.gif" /> </span>新手指南
		</dt>
		<dd class="add">
			<a href="/admin/foot/login.jsp">用户注册</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/process.jsp">购物流程</a>
		</dd>
		<dd class="add">
			<a href="javascript:void(0)">密码找回</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/disclaimer.jsp">免责声明</a>
		</dd>
	</dl>
	<dl class="grhymenu">
		<dt>
			<span class="ddzxqtb"><img src="/images/footerImg/ddzxq.gif" /> </span>会员相关
		</dt>
		<dd class="add">
			<a href="/admin/foot/memberLv.jsp">会员等级</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/memberPoint.jsp">会员经验值</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/dispute.jsp">争议处理</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/deposit.jsp">预存款说明</a>
		</dd>
	</dl>
	<dl class="grhymenu">
		<dt>
			<span class="ddzxqtb"><img src="/images/footerImg/ddzxq.gif" /> </span>售后服务
		</dt>
		<dd class="add">
			<a href="/admin/foot/exchange.jsp">退换货流程</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/retreat.jsp">退款说明</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/complain.jsp">投诉建议</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/wzmap.jsp">网站地图</a>
		</dd>
	</dl>
</div>
		<div class="hyright">
			<p class="hymainbt">
				<span class="grmenubt">加盟合作</span>
			</p>

			<div class="grjbxx">
			</div>
		</div>


	</div>
	<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
	<!-- footer end -->
</body>
</html>

