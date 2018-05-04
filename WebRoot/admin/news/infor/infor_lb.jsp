<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<meta http-equiv="keywords" content="" />
<meta http-equiv="description" content="" />
<link href="css/master.css" rel="stylesheet" type="text/css"></link>
<link href="css/common.css" rel="stylesheet" type="text/css"></link>
<link href="css/infor.css" rel="stylesheet" type="text/css"></link>
<title>古道金典</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>

<script type="text/javascript">
	$(function() {
		$('#${ti}').addClass('hov');
		if('${asm}'==''){
			$("#hf_status a[asm='-1']").addClass('on');
		}else{
			$("#hf_status a[asm='${asm}']").addClass('on');
		}
		$('#info_list li a').click(function() {
			$('#info_list li a').removeClass('hov');
			$(this).addClass('hov');
			var asm=$('.on').attr('asm');
			var ti=this.id;
			window.location.href="/m_supply/"+ti+"/"+asm+".html";
		});
		
		$('#hf_status a').click(function(){
			$('#hf_status a').removeClass('on');
			$(this).addClass('on');
			var asm=$(this).attr('asm');
			var ti=$('.hov').attr('id');
			window.location.href="/m_supply/"+ti+"/"+asm+".html";
		});
		$('#head_hf_gqxx').addClass('hover');
	});
	function supplyfb(){
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
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
</head>

<body id="mainbody">
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
		<a>首页 > 供求信息 > 更多</a>
	</div>
	<div class="gzgz_new">
		<div class="left">
			<div class="inforb">
				<ul id="info_list">
					<c:forEach items="${st }" var="v">
						<li><a id="${v.id }" style="text-decoration:none">${v.name}</a>
						</li>
					</c:forEach>
				</ul>
				<div class="lb">
					<span>类别：</span> 
					<span id="hf_status"> 
						<a asm="-1">不限</a> 
						<a id="status_1" asm="1" >出售</a> 
						<a id="status_0" asm="0" >求购</a> 
					</span>
				</div>
			</div>
			<div class="content">
				<h2>
					<span>${tn }</span>
				</h2>
				<ul>
					<c:forEach items="${sy }" var="v">
						<li>
							<div class="con-li con-img">
								<a class="conpic" href="/v_supply/${v.id }/${v.typeId}.html">
									<c:choose>
										<c:when test="${fn:length(v.picpath) <=0 }">
											<img alt="公司产品图片" src="/images/360-270zwpic.gif" width="90px" height="90px"/>
											
										</c:when>
										<c:otherwise>
											<img src="${fn:split(v.picpath, ',')[0]}" width="90px" height="90px"/> 
										</c:otherwise>
									</c:choose>	
								</a>
							</div>
							<div class="con-li con-text">
								<p class="con-p1">
									<a href="/v_supply/${v.id }/${v.typeId}.html">${v.title }</a>
								</p>
								<p class="con-p2" title="${v.description }">${fn:substring(v.description, 0, 64)}</p>
								<p class="con-p3">
									<span>发布人：${v.linkman }</span><span class="con-w">有效期至：<fmt:formatDate
											value="${v.effectivetime }" pattern="yyyy-MM-dd" /> </span>
								</p>
							</div>
							<div class="con-li con-phone">
								<span>${v.linkmobile }</span>
							</div>
							<div class="con-li con-time">
								<span><fmt:formatDate value="${v.createtime }"
										pattern="yyyy-MM-dd" /> </span>
							</div></li>
					</c:forEach>

				</ul>
			</div>
			<div id="showpages">
				<page:pagination path="m_supply/${ti}/${asm }.html" />
			</div>
		</div>
		<div class="right">
			<div class="mffb2">
				<a href="javascript:supplyfb();"><img src="/images/mffbxx.gif" alt="免费发布信息" /> </a>
			</div>
			<div class="zdtop">
				<h2>置顶信息</h2>
				<ul>
					<li>
						<div class="top-img">
							<a href="#"><img src="/images/topimg01.gif" /> </a>
						</div>
						<p class="top-p">
							<a href="#">供应奔驰3341自卸车<span>整车</span>出售德国原装奔驰</a>
						</p>
						<p class="top-ph">
							<span>联系电话：18658589898</span>
						</p>
					</li>
					<li>
						<div class="top-img">
							<a href="#"><img src="/images/topimg02.gif" /> </a>
						</div>
						<p class="top-p">
							<a href="#">供应奔驰3341自卸车<span>整车</span>出售德国原装奔驰</a>
						</p>
						<p class="top-ph">
							<span>联系电话：18658589898</span>
						</p>
					</li>
					<li>
						<div class="top-img">
							<a href="#"><img src="/images/topimg01.gif" /> </a>
						</div>
						<p class="top-p">
							<a href="#">供应奔驰3341自卸车<span>整车</span>出售德国原装奔驰</a>
						</p>
						<p class="top-ph">
							<span>联系电话：18658589898</span>
						</p>
					</li>
					<li>
						<div class="top-img">
							<a href="#"><img src="/images/topimg01.gif" /> </a>
						</div>
						<p class="top-p">
							<a href="#">供应奔驰3341自卸车<span>整车</span>出售德国原装奔驰</a>
						</p>
						<p class="top-ph">
							<span>联系电话：18658589898</span>
						</p>
					</li>
					<li>
						<div class="top-img">
							<a href="#"><img src="/images/topimg01.gif" /> </a>
						</div>
						<p class="top-p">
							<a href="#">供应奔驰3341自卸车<span>整车</span>出售德国原装奔驰</a>
						</p>
						<p class="top-ph">
							<span>联系电话：18658589898</span>
						</p>
					</li>
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
