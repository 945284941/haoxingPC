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
	function fb(){
		$.ajax({
			url : 'memberCenter/goods!checkSession.action',
			type : 'POST',
			dataType:'JSON',
			success:function(json){
				if(!json){
					showLogin('mask','pop_500','/s_supplyfb.html','0','');
				}else{
					window.location.href="/s_supplyfb.html";
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
		<a>首页 > 供求信息</a>
	</div>
	<div class="gzgz_content">
		<div class="subimg">
			<a>
			<c:choose>
				<c:when test="${fn:length(obj.picpath) <=0 }">
					<img alt="公司产品图片" src="/images/360-270zwpic.gif" width="197px" height="197px"/>
					
				</c:when>
				<c:otherwise>
					<img alt="公司产品图片" src="${fn:split(obj.picpath, ',')[0]}" width="197px" height="197px"/> 
				</c:otherwise>
			</c:choose>
			</a>
		</div>
		<div class="subcontent">
			<h2>
				<span class="gybt">${obj.title }</span><span class="gytime">发布时间：<fmt:formatDate
						value="${obj.createtime }" pattern="yyyy-MM-dd" />
				</span>
				<div style="clear:both"></div>
			</h2>
			<p class="gd-p">
				<span>联系人：${obj.linkman }</span><span>联系电话：<strong
					style="color:#d90000">${obj.linkmobile }</strong>
				</span><span class="yxtime">有效期至：<fmt:formatDate
						value="${obj.effectivetime }" pattern="yyyy/MM/dd" /></span>
			</p>
			<p>
				<span>汽车品牌：${obj.carbrandName }</span><span>汽车车系：${obj.carseriesName }</span><span>汽车车型：${obj.cartypeName }</span><span>汽车类型：${obj.carcatName }</span>
			</p>
			<p>
				<span>汽车颜色：${obj.color }</span><span>首次上牌时间：<fmt:formatDate
						value="${obj.carFirstcardtime }" pattern="yyyy/MM/dd" /></span><span>有无重大事故：${obj.hasAccident }</span><span>证件是否齐全：${obj.hasCertificate }</span>
			</p>
			<p>
				<span>外观成色：${obj.quality }</span><span>内饰状况：${obj.interiorCondition }</span><span>行驶里程：${obj.mileage }公里内</span><span>价格：${obj.price }元</span>
			</p>
			<p>
				<span>QQ/Email：${obj.qqEmail }</span>
			</p>
		</div>
		<div class="subfb">
			<a onclick="fb();"><img src="/images/fbbutton.gif" />
			</a>
		</div>
		<div style="clear:both;"></div>
	</div>
	<div class="gzgz_content">
		<div class="gzgz_coleft">
			<h2>
				<span>综合描述</span>
			</h2>
			<div class="sm">
				<h3>补充说明：</h3>
				<p class="smtext">${obj.description }</p>
				<p>联系我时，请注明在古道金典看到的，谢谢。</p>
			</div>
			<c:if test="${fn:length(obj.picpath) >0}">
			<div class="sm">
				<h3>配件图片：</h3>
				<div id="gallery">
					<div id="imagearea">
						<div id="image">
							<a href="javascript:imgNav(-1)" class="imgnav " id="previmg"></a>
							<a href="javascript:imgNav(1)" class="imgnav " id="nextimg"></a>
						</div>
					</div>
					<div id="thumbwrapper">
						<div id="thumbarea">
							<ul id="thumbs">
								<c:forEach items="${fn:split(obj.picpath, ',')}" var="img"
									varStatus="v">
									<li value="${img}"><img src="${img }" width="114"
										height="114" alt="" /></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<script type="text/javascript">
					var imgid = 'image';
					var imgdir = 'images/fullsize';
					var imgext = '.jpg';
					var thumbid = 'thumbs';
					var auto = true;
					var autodelay = 5;
				</script>
				<script type="text/javascript" src="js/slide.js"></script>
			</div>
			</c:if>
		</div>
		<div class="gzgz_coright">
			<p class="hzsjz">
				<span class="xwzxz">合作商家</span>
			</p>
			<div class="hzsj">
				<ul>
					<li><div class="hzsj-img">
							<a href="#"><img src="/images/hzsj.gif" />
							</a>
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
							<a href="#"><img src="/images/hzsj.gif" />
							</a>
						</div>
						<div class="hzsj-p">
							<p>济南蓝天重卡重配有限公司</p>
							<p>电话：0531-86495423</p>
							<p>联系人：王经理</p>
						</div>
						<div class="hzsj-jj">简介：济南蓝海汽车配件有限公司成立于2004年，注册资金200万……</div></li>
					<li><div class="hzsj-img">
							<a href="#"><img src="/images/hzsj.gif" />
							</a>
						</div>
						<div class="hzsj-p">
							<p>济南蓝天重卡重配有限公司</p>
							<p>电话：0531-86495423</p>
							<p>联系人：王经理</p>
						</div>
						<div class="hzsj-jj">简介：济南蓝海汽车配件有限公司成立于2004年，注册资金200万……</div></li>
					<li><div class="hzsj-img">
							<a href="#"><img src="/images/hzsj.gif" />
							</a>
						</div>
						<div class="hzsj-p">
							<p>济南蓝天重卡重配有限公司</p>
							<p>电话：0531-86495423</p>
							<p>联系人：王经理</p>
						</div>
						<div class="hzsj-jj">简介：济南蓝海汽车配件有限公司成立于2004年，注册资金200万……</div></li>
					<li><div class="hzsj-img">
							<a href="#"><img src="/images/hzsj.gif" />
							</a>
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
