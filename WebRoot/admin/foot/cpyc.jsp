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
<meta http-equiv="keywords" content="招聘" />
<meta http-equiv="description" content="古道金典" />
<title>诚聘英才</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<link rel="stylesheet" href="/css/newbanner.css" type="text/css" />
<link href="/css/foot_hyzxgr.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/css/staticlxwm.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<style>
html #hm_t_undefined .hm-t-go-top {position:fixed;right:2px;bottom:2px;z-index:99998;cursor:pointer;width:40px;height:37px!important;text-align:center;white-space:normal;font-size:14px;line-height:17px;padding-top:3px;color:#fff;background:#404040;background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEkAAAAXCAYAAABH92JbAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDowMjgwMTE3NDA3MjA2ODExODA4M0UyNDA4ODdDRTZBQiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpBQjc5RkRFNkI5ODMxMUUzQkZGNDhENEJFQjM2OTcyRiIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpBQjc5RkRFNUI5ODMxMUUzQkZGNDhENEJFQjM2OTcyRiIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRvc2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MDI4MDExNzQwNzIwNjgxMTgwODNFMjQwODg3Q0U2QUIiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6MDI4MDExNzQwNzIwNjgxMTgwODNFMjQwODg3Q0U2QUIiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5HPYM5AAACC0lEQVR42uyZTSgEYRjH90NoqaVcpDblvKW2XOSkNh8H5Yac9sBBDqQokiJKSMpNTi5OPo6Ktsgu67JcUHIXWfK1u3b8Xx6Zxuzu+64dM83uv34zNfu8b8/8Z+d5P8YqSZLFJNLsRmyWvIRMKgVD4AhEwA3YAV0pzGwEqyAEwmAddIICHe7FqhnsdQM14FxKLj+ooFiGE2ykiD8GVbJ4I1ELAnTmasMODnAhpVcIFIMicMgRH6Z4IxnUAh4pP3Zu5TVpUOLXDJgWiB8wkEF9IK7IL07X05oUFLjpZ4JXQQOYYwfzafJcoDjVPqw43KE4lWtUTF+AQ8eBqQSsgTaO2E0apJ7URrdCDZOM62hQJfBzGmShOD+1+2XSiYaJ7utkkBsEgEewnYfauZUmzWmU6DuY0sEgLzgArgzbu6i992cu/1WclqXsa1iHIt0DYlnKP0b9fRZu5pWdZs7dWXqa7B80+s//oF5aMSjflGqBPq5BQnFtVv4UmGHjIPEH96PAZ6C5kVMwf6daPzbFKnqCqvx9Bk/yFjSBFTMvcL+1DerAmUA/p9Rm1+y7AHJdgnqwx9EHm1s0gKtc2CpR6gE00/ZHMm3RKxbJlf0kNb2BDrCk8hsbDdvBay5tuiUTGxL7waTs2iLw0YTR9BLZQRwDUVqwjuTS9q3VRB8C1OQUnM6UqdXX/IcADn0IMADs2AqDOPSutQAAAABJRU5ErkJggg==) no-repeat -42px center #666;*background-image:url(http://ecma.bdimg.com/holmes/t-popup-icons-png8.png);_position:absolute;_top:expression(eval(document.documentElement.scrollTop+(document.documentElement.clientHeight||document.body.clientHeight)-this.offsetHeight-2));}
.STYLE3 {
	font-size: 18px;
	font-weight: bold;
	color: #000000;
	line-height: 15px;
}
.STYLE5 {color: #333333; font-weight: bold; }
.STYLE9 {font-size: 5px; color: #666666; }
.STYLE12 {font-family: "微软雅黑"; font-size: 20px;}
</style>
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
		<a href="javascript:void(0)">首页</a> > <a href="javascript:void(0)">关于泉利</a> > <a href="javascript:void(0)">招聘列表</a>
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
					<a href="/admin/foot/cooperation.jsp">加盟合作</a>
				</dd>
				<dd class="add">
					<a href="/admin/foot/contact.jsp">联系我们</a>
				</dd>
				<dd class="add">
					<a class="hover" href="zp.html">诚聘英才</a>
				</dd>
				<dd class="add">
					<a  href="/admin/foot/advertising.jsp">广告资源</a>
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
					<a href="toMemberCheckMsg.html">密码找回</a>
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
				<span class="grmenubt">招聘信息</span>
			</p>
			<div class="grjbxx">
				<div style="padding-left:17px;">
						<s:action name="zpmessage!toComeZpjj" executeResult="true" namespace="/"></s:action>
		<p style="font-size:12px;line-height:19px;">  <br>
		</p>
		
		<p style="font-size:12px;">
			<br/>
		</p></div>
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