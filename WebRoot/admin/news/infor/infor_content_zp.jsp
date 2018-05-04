<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<jsp:include page="/admin/common/keyWords.jsp" />
<link href="css/master.css" rel="stylesheet" type="text/css"></link>
<link href="css/common.css" rel="stylesheet" type="text/css"></link>
<link href="css/infor.css" rel="stylesheet" type="text/css"></link>
<title>供求信息_古道金典，提供最全面的汽车及配件供应、求购商机</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type="text/javascript">
	function fb() {
		$.ajax({
			url : 'memberCenter/goods!checkSession.action',
			type : 'POST',
			dataType : 'JSON',
			success : function(json) {
				if (!json) {
					showLogin('mask', 'pop_500', '/s_supplyfb.html', '0', '');
				} else {
					window.location.href = "/s_supplyfb.html";
				}
			}
		});
	}
	$(function(){
		$('#head_hf_gqxx').addClass('hover');
	});
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
</head>

<body id="mainbody" onload="slideShow()">
	<!-- header begin -->
	<div class="header">
		<jsp:include page="/admin/common/head.jsp"></jsp:include>
	</div>
	<div class="logo">
		<jsp:include page="/admin/common/logo.jsp"></jsp:include>
	</div>

	<!-- 代码 开始 -->
	<div id="warp">
		<div class=" bannerzong">
			<ul class="mainnavzong">
				<jsp:include page="/admin/common/all_hf_Head.jsp" />
			</ul>
			<div class="mainqlzpc">
     <a href="news/news!toQlqpc.action"><img src="images/zpc.gif" alt="泉利重配城" /></a>
   </div>
			<div id="menunew">
				<p class="menubt_new"></p>
				<ul class="menuzong menunew">
				</ul>
			</div>
		</div>
	</div>
	<div class="dht">
		<a>首页 > 供求信息  > </a>
	</div>
	<div class="gzgz_content">
		<div class="subcontent subcontent2 sub3">
			<h2>
				<span class="gybt">${obj.title }</span><span class="gytime">发布时间：<fmt:formatDate
						value="${obj.createtime }" pattern="yyyy-MM-dd" />
				</span>
				<div style=" clear:both"></div>
			</h2>
			<p class="gd-p">
				<span>公司名称：${obj.companyName }</span><span>联系电话：${obj.linkmobile
					}</span><span class="yxtime">有效期至：<fmt:formatDate
						value="${obj.effectivetime }" pattern="yyyy/MM/dd" />
				</span>
			</p>
			<p class="zpxx">
				<span>岗位名称：${obj.jobName }</span><span>月薪：${obj.price }元</span><span>公司地址：${obj.companyAddress
					}</span><span class="zpxx4">QQ/Email：${obj.qqEmail }</span>
			</p>
		</div>
		<div class="subfb">
			<a onclick="fb();"><img src="/images/fbbutton.gif" /> </a>
		</div>
		<div style="clear:both;"></div>
	</div>
	<div class="gzgz_content">
		<div class="gzgz_coleft">
			<h2>
				<span>综合描述</span>
			</h2>
			<div class="grxx">
				<h3>公司信息：</h3>
				<p>
					<span>公司名称：${obj.companyName }</span><span>性质：${obj.jobNature
						}</span><span>所属行业：${obj.calling }</span><span>公司规模：${obj.companyScale
						}人</span><span>公司性质：${obj.companyNature }</span><span>工作经验：${obj.workExperience
						}年</span><span>最高学历：${obj.education }</span><span>公司地址：${obj.companyAddress
						}</span><span>招聘职位：${obj.jobName}</span><span>月薪：${obj.monthlypay
						}元</span><span>所在职级：<c:if test="${fn:length(obj.jobRank)==0}">--</c:if>${obj.jobRank}</span><span>联系电话：${obj.linkmobile
						}</span><span class="zpxx4">QQ/Email：${obj.qqEmail}</span>
				</p>
			</div>
			<div class="grxx">
				<h3>岗位职责和要求：</h3>
				<p class="smtext">${obj.jobRequest }</p>
				<p>联系我时，请注明在古道金典看到的，谢谢。</p>
			</div>
			<div class="grxx">
				<h3>公司简介：</h3>
				<p class="smtext">${obj.description}</p>
				<p>联系我时，请注明在古道金典看到的，谢谢。</p>
			</div>

		</div>
		<div class="gzgz_coright">
			<p class="hzsjz">
				<span class="xwzxz">合作商家</span>
			</p>
			<div class="hzsj">
				<ul>
					<li><div class="hzsj-img">
							<a href="#"><img src="/images/hzsj.gif" /> </a>
						</div>
						<div class="hzsj-p">
							<p>
								<a href="#">济南蓝天重卡重配有限公司</a>
							</p>
							<p>电话：0531-86495423</p>
							<p>联系人：王经理</p>
						</div>
						<div class="hzsj-jj">简介：济南蓝海汽车配件有限公司成立于2004年，注册资金200万……</div></li>
					<li><div class="hzsj-img">
							<a href="#"><img src="/images/hzsj.gif" /> </a>
						</div>
						<div class="hzsj-p">
							<p>济南蓝天重卡重配有限公司</p>
							<p>电话：0531-86495423</p>
							<p>联系人：王经理</p>
						</div>
						<div class="hzsj-jj">简介：济南蓝海汽车配件有限公司成立于2004年，注册资金200万……</div></li>
					<li><div class="hzsj-img">
							<a href="#"><img src="/images/hzsj.gif" /> </a>
						</div>
						<div class="hzsj-p">
							<p>济南蓝天重卡重配有限公司</p>
							<p>电话：0531-86495423</p>
							<p>联系人：王经理</p>
						</div>
						<div class="hzsj-jj">简介：济南蓝海汽车配件有限公司成立于2004年，注册资金200万……</div></li>
				</ul>
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
