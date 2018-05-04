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
<base href="<%=basePath%>" target="_blank" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<meta http-equiv="keywords"
	content="" />
<meta http-equiv="description"
	content="" />
<link href="css/master.css" rel="stylesheet" type="text/css"></link>
<link href="css/common.css" rel="stylesheet" type="text/css"></link>
<link href="css/infor.css" rel="stylesheet" type="text/css"></link>
<title>古道金典</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
<script type="text/javascript">
	/***
	 * tab选项卡
	 * @param {Object} thisObj
	 * @param {Object} Num
	 * @param {Object} active
	 * @param {Object} normal
	 * @return {TypeName} 
	 */
	function nTabs(thisObj, Num, active, normal) {
		if (thisObj.className == active)
			return;
		var tabObj = thisObj.parentNode.id;
		var tabList = document.getElementById(tabObj)
				.getElementsByTagName("li");
		for ( var i = 0; i < tabList.length; i++) {
			if (i == Num) {
				thisObj.className = active;
				document.getElementById(tabObj + "_" + i).style.display = "block";
			} else {
				tabList[i].className = normal;
				document.getElementById(tabObj + "_" + i).style.display = "none";
			}
		}
	}

	function supplyfb() {
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
	$(function() {
		$('#head_hf_gqxx').addClass('hover');
	});
</script>
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
				<a href="news/news!toQlqpc.action"><img src="images/zpc.gif"
					alt="泉利重配城" />
				</a>
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
	<div class="gzgz_new">
		<div class="left">
			<div class="shc">
				<div class="jrsc">
					<a href="/"><img src="/images/sp.gif" /> </a>
				</div>


				<script>
					//保证导航栏背景与图片轮播背景一起显示
					$("#mainbody").removeClass();
					$("#mainbody").addClass("");
				</script>
				<script>
					$(function() {
						//滚动Banner图片的显示
						$('#slides').slides({
							preload : false,
							preloadImage : '/images/loading.gif',
							effect : 'fade',
							slideSpeed : 400,
							fadeSpeed : 100,
							play : 3000,
							pause : 100,
							hoverPause : true
						});
					});
				</script>
				<!-- 滚动图片 -->




				<div id="slides" class="banner banner_new">
					<div class="banner_new_1">
						<a class="prev"><img alt="上一页" src="/images/banner_l.png"
							width="24" height="43" /> </a>
					</div>
					<div class="bannerImg bannernewImg">
						<div class="slides_container">
							<div id="banner_pic_1">
								<img src="/images/zh.jpg" width="740"
									height="175" />
								
							</div>
							<!--  
		<div style="DISPLAY: none" id="banner_pic_2"><a href="http://www.qlqpw.com/news/detailZpc/%25E6%25B3%2589%25E5%2588%25A9%25E7%2583%25AD%25E7%2582%25B9/62f49f2b66b446a7b64581e9c63900e4.html" target="_blank"><img  src="/images/dx.jpg" width="740" height="175"/></a></div>
							-->
							<div style="DISPLAY: none" id="banner_pic_3">
								<img src="/images/zz.jpg" width="740" height="175" />
							</div>

						</div>
					</div>
					<div class="banner_new_r">
						<a class="next"><img alt="下一页" src="/images/banner_r.png"
							width="24" height="43" /> </a>
					</div>
				</div>
				<!-- 滚动图片 -->
			</div>
			<div class="new">
				<div class="xw">
					<p class="schqbt_in">
						<span class="xwzxz">${map['1'].name }</span><span class="gengd"><a
							href="/m_supply/${map['1'].id}/-1.html" target="_blank">更多>></a>
						</span>
					</p>
					<div class="xwfl">
						<ul class="xxfl" id="zcgq">
							<li class="on" onclick="nTabs(this,0,'on','')"><a>供应信息</a>|</li>
							<li onclick="nTabs(this,1,'on','')"><a>求购信息</a>
							</li>
						</ul>
						<div class="lfl" id="zcgq_0">
							<ul class="schqlist_new">
								<c:forEach items="${map['1_list']['g']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div class="rfl" id="zcgq_1" style="display: none">
							<ul class="schqlist_new2">
								<c:forEach items="${map['1_list']['q']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div style="clear:both"></div>
					</div>

				</div>
				<div class="xw2">
					<p class="schqbt_in">
						<span class="xwzxz">${map['2'].name }</span><span class="gengd"><a
							href="/m_supply/${map['2'].id}/-1.html">更多>></a> </span>
					</p>
					<div class="xwfl">
						<ul class="xxfl" id="pjgq">
							<li class="on" onclick="nTabs(this,0,'on','')"><a>供应信息</a>|</li>
							<li onclick="nTabs(this,1,'on','')"><a>求购信息</a>
							</li>
						</ul>
						<div class="lfl" id="pjgq_0">
							<ul class="schqlist_new">
								<c:forEach items="${map['2_list']['g']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div class="rfl" id="pjgq_1" style="display: none">
							<ul class="schqlist_new2">
								<c:forEach items="${map['2_list']['q']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div style="clear:both;"></div>
					</div>

				</div>
				<div style="clear:both; height:0"></div>
			</div>
			<!--  
			<div class="gg">
				<a href="/"><img src="/images/gg1.jpg" /> </a>
			</div>
			-->
			<div class="new">
				<div class="xw3">
					<p class="schqbt_in">
						<span class="xwzxz">${map['3'].name }</span><span class="gengd"><a
							href="/m_supply/${map['3'].id}/-1.html">更多>></a> </span>
					</p>
					<div class="xwfl">
						<ul class="xxfl" id="sbgq">
							<li class="on" onclick="nTabs(this,0,'on','')"><a>供应信息</a>|</li>
							<li onclick="nTabs(this,1,'on','')"><a>求购信息</a>
							</li>
						</ul>
						<div class="lfl" id="sbgq_0">
							<ul class="schqlist_new">
								<c:forEach items="${map['3_list']['g']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div class="rfl" id="sbgq_1" style="display: none">
							<ul class="schqlist_new2">
								<c:forEach items="${map['3_list']['q']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div style="clear:both"></div>
					</div>

				</div>
				<div class="xw4">
					<p class="schqbt_in">
						<span class="xwzxz">${map['4'].name }</span><span class="gengd"><a
							href="/m_supply/${map['4'].id}/-1.html">更多>></a> </span>
					</p>
					<div class="xwfl">
						<ul class="xxfl" id="qxc">
							<li class="on" onclick="nTabs(this,0,'on','')"><a>供应信息</a>|</li>
							<li onclick="nTabs(this,1,'on','')"><a>求购信息</a>
							</li>
						</ul>
						<div class="lfl" id="qxc_0">
							<ul class="schqlist_new">
								<c:forEach items="${map['4_list']['g']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div class="rfl" style="display:none" id="qxc_1">
							<ul class="schqlist_new2">
								<c:forEach items="${map['4_list']['q']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div style="clear:both"></div>
					</div>

				</div>
				<div style="clear:both; height:0"></div>
			</div>
			<!-- 
			<div class="gg">
				<a href="/"><img src="/images/gg2.jpg" /> </a>
			</div>
			-->
			<div class="new">
				<div class="xw5">
					<p class="schqbt_in">
						<span class="xwzxz">${map['5'].name }</span><span class="gengd"><a
							href="/m_supply/${map['5'].id}/-1.html">更多>></a> </span>
					</p>
					<div class="xwfl">
						<ul class="xxfl" id="wlxx">
							<li class="on" onclick="nTabs(this,0,'on','')"><a>供应信息</a>|</li>
							<li onclick="nTabs(this,1,'on','')"><a>求购信息</a>
							</li>
						</ul>
						<div class="lfl" id="wlxx_0">
							<ul class="schqlist_new">
								<c:forEach items="${map['5_list']['g']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div class="rfl" style="display:none" id="wlxx_1">
							<ul class="schqlist_new2">
								<c:forEach items="${map['5_list']['q']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div style="clear:both"></div>
					</div>

				</div>
				<div class="xw6">
					<p class="schqbt_in">
						<span class="xwzxz">${map['6'].name }</span><span class="gengd"><a
							href="/m_supply/${map['6'].id}/-1.html">更多>></a> </span>
					</p>
					<div class="xwfl">
						<ul class="xxfl" id="zl">
							<li class="on" onclick="nTabs(this,0,'on','')"><a>招聘信息</a>|</li>
							<li onclick="nTabs(this,1,'on','')"><a>求职信息</a>
							</li>
						</ul>
						<div class="lfl" id="zl_0">
							<ul class="schqlist_new">
								<c:forEach items="${map['6_list']['q']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div class="rfl" style="display:none" id="zl_1">
							<ul class="schqlist_new2">
								<c:forEach items="${map['6_list']['g']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div style="clear:both"></div>
					</div>

				</div>
				<div style="clear:both; height:0"></div>
			</div>
			<!--
			<div class="gg">
				<a href="/"><img src="/images/gg3.jpg" />
				</a>
			</div>
			-->
			<div class="new">
				<div class="xw7">
					<p class="schqbt_in">
						<span class="xwzxz">${map['7'].name }</span><span class="gengd"><a
							href="/m_supply/${map['7'].id}/-1.html">更多>></a> </span>
					</p>
					<div class="xwfl">
						<ul class="xxfl" id="qzzp">
							<li class="on" onclick="nTabs(this,0,'on','')"><a>供应信息</a>|</li>
							<li onclick="nTabs(this,1,'on','')"><a>求购信息</a>
							</li>
						</ul>
						<div class="lfl" id="qzzp_0">
							<ul class="schqlist_new">
								<c:forEach items="${map['7_list']['g']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div class="rfl" style="display:none" id="qzzp_1">
							<ul class="schqlist_new2">
								<c:forEach items="${map['7_list']['q']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div style="clear:both"></div>
					</div>

				</div>
				<div class="xw8">
					<p class="schqbt_in">
						<span class="xwzxz">${map['8'].name }</span><span class="gengd"><a
							href="/m_supply/${map['8'].id}/-1.html">更多>></a> </span>
					</p>
					<div class="xwfl">
						<ul class="xxfl" id="qtxx">
							<li class="on" onclick="nTabs(this,0,'on','')"><a>供应信息</a>|</li>
							<li onclick="nTabs(this,1,'on','')"><a>求购信息</a>
							</li>
						</ul>
						<div class="lfl" id="qtxx_0">
							<ul class="schqlist_new">
								<c:forEach items="${map['8_list']['g']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div class="rfl" style="display:none" id="qtxx_1">
							<ul class="schqlist_new2">
								<c:forEach items="${map['8_list']['q']}" var="v">
									<li><span class="schqlistnr"><a
											href="/v_supply/${v.id }/${v.typeId}.html" title="${v.title}">${v.title
												}</a> </span><span class="xwzxlidate"><fmt:formatDate
												value="${v.createtime }" pattern="yyyy-MM-dd" />
									</span></li>
								</c:forEach>
							</ul>
						</div>
						<div style="clear:both"></div>
					</div>
				</div>
			</div>
			<div style="clear:both"></div>
		</div>
		<div class="right">
			<div class="mffb">
				<a onclick="supplyfb();" target="_blank"><img
					src="/images/mffbxx.gif" alt="免费发布信息" /> </a>
				<!-- <a class="scxx" >删除/修改信息</a> -->
			</div>
			<div class="zxinfor">
				<h2>最新供应信息</h2>
				<ul>
					<c:forEach items="${newgy }" var="v">
						<li><a href="/v_supply/${v.id }/${v.typeId}.html"
							title="${v.title}">${fn:substring(v.title, 0, 14)}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="gg2">
				<a><img src="/images/xxgg03.gif" /> </a>
			</div>
			<div class="zxinfor">
				<h2>最新求购信息</h2>
				<ul>
					<c:forEach items="${newqg }" var="v">
						<li><a href="/v_supply/${v.id }/${v.typeId}.html"
							title="${v.title}">${fn:substring(v.title, 0, 14)}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="gg2">
				<a><img src="/images/xxgg04.gif" /> </a>
			</div>
			<div class="gg3">
				<a><img src="/images/xxgg05.gif" /> </a>
			</div>
			<div class="gg2">
				<a><img src="/images/xxgg06.gif" /> </a>
			</div>
			<div class="gg3">
				<a><img src="/images/xxgg07.gif" /> </a>
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
