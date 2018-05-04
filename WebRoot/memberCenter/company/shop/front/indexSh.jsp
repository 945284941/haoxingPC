<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute(ResourceUtil.getSessionInfoName());
	String memberId = sessionInfo == null ? "" : sessionInfo
			.getUserId();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<link href="/css/vipshopsh.css" rel="stylesheet" type="text/css" />
<link href="/css/page.css" rel="stylesheet" type="text/css" />
<title>古道金典</title>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/goods/magnifier.js"></script>
<script type=text/javascript src="js/floor.js"></script>
<script type=text/javascript src="js/qlzy.js"></script>
<script language="JavaScript" type="text/JavaScript">
	function showElement(elementId) {
		document.getElementById(elementId).style.display = "block";
	}
	function hideElement(elementId) {
		document.getElementById(elementId).style.display = "none";
	}

	$(function() {
		$(".strip_of_thumbnails img").bind("mouseover", function() {
			var src = $(this).attr("src");
			$("#DHTMLgoodies_largeImage img").eq(0).attr({
				src : src.replace("\/n5\/", "\/n1\/"),
				jqimg : src.replace("\/n5\/", "\/n0\/")
			});

		});
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
	<div class="header">
		<jsp:include page="/admin/common/vipShopHead.jsp" />
	</div>

	<!-- 代码 开始 -->
	<!-- logo start -->
	<jsp:include page="/memberCenter/company/shop/front/comLogoSh.jsp" />
	<!-- logo end -->
	<!-- menu start -->
	<jsp:include page="/memberCenter/company/shop/front/comMenuSh.jsp" />
	<!-- menu end -->

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
			$('#js-news').ticker();
		});
	</script>

	<!-- head-img start -->
	<s:action name="companyShopManageAction!gainCompanysHeadImgsSh"
		namespace="/comShopManage" executeResult="true"></s:action>
	<!-- head-img end -->


	<div class="gzgz zsone">
		<!-- contact start -->
		<jsp:include
			page="/memberCenter/company/shop/front/commonContactSh.jsp" />
		<!-- contact end -->
		<div class="zscompany">
			<h2>
				<span>企业简介</span><a href="/Shop/comProfile/${company.id}.html">更多>></a>
			</h2>
			<div class="com-nr">
				<p class="com-img">
					<img src="images/vip/jj-img.gif" />
				</p>
				<p class="gsjj">
					<s:if test="null!=company.combrief && ''!=company.combrief">
						${fn:substring(company.combrief, 0, 215)}...<span class="ck"><a
							href="/Shop/comProfile/${company.id}.html">【查看详细】</a>
						</span>
					</s:if>
					<s:else>暂无企业简介!</s:else>
				</p>
			</div>
		</div>
		<div class="zszx">
			<h2>
				<span>企业资讯</span><a
					href="/Shop/comInformation/list/${company.id}.html">更多>></a>
			</h2>
			<div class="zxt">
				<div class="qyzx">
					<div class="zx-img">
						<span><img src="images/vip/zx-img.gif" /> </span>
					</div>
					<div class="zxgsjj">
						<h3>
							<span>${company.companyName}企业理念和宗旨</span>
						</h3>
						<s:if
							test="null!=company.companyPurpose&&''!=company.companyPurpose">${company.companyPurpose}</s:if>
						<s:else>---</s:else>

					</div>
				</div>
				<div style="clear:both;"></div>
				<ul>
					<s:if test="%{companysInfoList.size()>0}">
						<s:iterator value="companysInfoList" var="companysInfo">
							<li><a
								href="/Shop/comInformation/detail/<s:property value="#companysInfo.id" />_${company.id}.html"
								title="<s:property value='#companysInfo.firstTitle' />"> <s:if
										test="null!=#companysInfo.firstTitle&&#companysInfo.firstTitle.length()>25">
										<s:property value="#companysInfo.firstTitle.substring(0, 25)" />......
		           				</s:if> <s:else>
										<s:property value="#companysInfo.firstTitle" />
									</s:else> </a><span class="time"><s:date
										name="#companysInfo.createTime" format="yyyy-MM-dd" /> </span></li>
						</s:iterator>
					</s:if>
					<s:else>
						<span style="color:red;">暂无资讯!</span>
					</s:else>

				</ul>

			</div>
		</div>
		<div style="clear:both"></div>
	</div>
	<!--商品展示开始-->

	<div id="mainContainer" class="gzgz zysprm">
		<h2>相关热门商品</h2>
		<div id="DHTMLgoodies_largeImage">
			<s:iterator value="hotGoodsList" var="hotGoodsList" status="st">
				<s:if test="#st.first">
					<img src="<s:property value='#hotGoodsList.defaultPicSrc' />"
						jqimg="<s:property value='#hotGoodsList.defaultPicSrc' />"
						width="350" height="263" />
				</s:if>
			</s:iterator>
		</div>
		<div id="DHTMLgoodies_panel_one">
			<div id="DHTMLgoodies_thumbs">
				<div id="DHTMLgoodies_thumbs_inner">

					<div class="strip_of_thumbnails">
						<div>
							<ul>
								<s:if test="%{hotGoodsList.size()>0}">

									<s:iterator value="hotGoodsList" var="hotGoodsList" status="st">
										<li><p class="p-img">
												<a href="goods/<s:property value='#hotGoodsList.id'/>.html"
													target="_blank"><img
													src="<s:property value='#hotGoodsList.defaultPicSrc' />"
													width=70 height=54 /> </a>
											</p>
											<div class="zysp_r_r">
												<p class="p-name">
													<a href="goods/<s:property value='#hotGoodsList.id'/>.html"
														target="_blank"
														title="<s:property value='#hotGoodsList.name' />"> <s:if
															test="null!=#hotGoodsList.name&&#hotGoodsList.name.length()>5">
															<s:property value="#hotGoodsList.name.substring(0, 5)" />......
								           </s:if> <s:else>
															<s:property value="#hotGoodsList.name" />
														</s:else> </a>
												</p>
												<p>
													<s:property value="#hotGoodsList.bn" />
												</p>
												<p class="p-price">
													<span class="dlf">¥</span>
													<s:property value="#hotGoodsList.price" />
												</p>
											</div>
										</li>
									</s:iterator>
								</s:if>
								<s:else>
									<span style="color:red;">暂无热门商品!</span>
								</s:else>


							</ul>
						</div>
					</div>
				</div>
			</div>
			<div id="DHTMLgoodies_arrows">
				<p id="DHTMLgoodies_leftArrow" class="leftArrow"></p>
				<p id="DHTMLgoodies_rightArrow" class="rightArrow"></p>
			</div>

			<div style="clear:both"></div>
		</div>
		<div style="clear:both"></div>
		<p>
			<script type="text/javascript">
				initGalleryScript(); // Initialize script
			</script>
		</p>
	</div>
	<div class="gzgz zysp">
		<div class="cpsp">
			<h2>
				<a href="/Shop/comGoods/list/${company.id}.html" target="_blank">主营产品展示</a>
			</h2>
			<ul class="rmfl" id="comGoods_zy_goodsCat">
				<s:if test="%{companysGoodsCats.size()>0}">
					<s:iterator value="companysGoodsCats" var="companysGoodsCat"
						status="st">
						<s:if test="(#st.last&&#st.first)||(#st.last&&!#st.first)">
							<s:if test="#companysGoodsCat.goodsCatId==#request.selGoodsCatId">
								<li><a
									id="comGoods<s:property value="#companysGoodsCat.id"/>"
									onclick="comShop_getComGoods('comGoods<s:property value="#companysGoodsCat.id"/>','${company.id}','<s:property value="#companysGoodsCat.goodsCatId"/>','${vipGrade}','${menuId}')"
									href="javascript:void(0)" class="hover"><s:property
											value="#companysGoodsCat.name" /> </a>
								</li>
							</s:if>
							<s:else>
								<li><a
									id="comGoods<s:property value="#companysGoodsCat.id"/>"
									onclick="comShop_getComGoods('comGoods<s:property value="#companysGoodsCat.id"/>','${company.id}','<s:property value="#companysGoodsCat.goodsCatId"/>','${vipGrade}','${menuId}')"
									href="javascript:void(0)"><s:property
											value="#companysGoodsCat.name" /> </a>
								</li>
							</s:else>
						</s:if>
						<s:else>
							<s:if test="#companysGoodsCat.goodsCatId==#request.selGoodsCatId">
								<li><a
									id="comGoods<s:property value="#companysGoodsCat.id"/>"
									onclick="comShop_getComGoods('comGoods<s:property value="#companysGoodsCat.id"/>','${company.id}','<s:property value="#companysGoodsCat.goodsCatId"/>','${vipGrade}','${menuId}')"
									href="javascript:void(0)" class="hover"><s:property
											value="#companysGoodsCat.name" /> </a>|</li>
							</s:if>
							<s:else>
								<li><a
									id="comGoods<s:property value="#companysGoodsCat.id"/>"
									onclick="comShop_getComGoods('comGoods<s:property value="#companysGoodsCat.id"/>','${company.id}','<s:property value="#companysGoodsCat.goodsCatId"/>','${vipGrade}','${menuId}')"
									href="javascript:void(0)"><s:property
											value="#companysGoodsCat.name" /> </a>|</li>
							</s:else>
						</s:else>
					</s:iterator>
				</s:if>
				<s:else>
					<li><span style="color:red;">暂无热销品类!</span></li>
				</s:else>
			</ul>
			<div class="both"></div>
		</div>
		<div class="zsp" id="com_goods">
			<s:if test="%{goodsListByCom.size()>0}">
				<s:iterator value="goodsListByCom" var="li" status="st">
					<s:if test="#st.index<20">
						<div class="gotpicz">
							<p class="eproduct">
								<a href="goods/<s:property value='#li.id'/>.html"
									target="_blank"><img
									src="<s:property value='#li.defaultPicSrc'/>" width="200"
									height="150" /> </a>
							</p>
							<p class="p-name">
								<a href="goods/<s:property value='#li.id'/>.html"
									target="_blank" title="<s:property value='#li.name' />"> <s:if
										test="null!=#li.name&&#li.name.length()>15">
										<s:property value="#li.name.substring(0, 15)" />......
		           </s:if> <s:else>
										<s:property value="#li.name" />
									</s:else> </a>
							</p>
							<p class="p-name">
								<s:property value="#li.bn" />
							</p>
							<p class="p-price">
								<span class="dlf">¥</span>
								<s:property value="#li.price" />
							</p>
						</div>
					</s:if>
				</s:iterator>
			</s:if>
			<s:else>
				<span style="color:red;">暂时没有符合条件的数据！</span>
			</s:else>

		</div>
		<div class="zymore">
			<a
				href="/Shop/moreComgoods/<s:property value='#request.selGoodsCatId'/>_${company.id}.html"
				id="shopIndex_more" target="_blank">查看更多>></a>
		</div>
		<form id="shopIndexForm" name="shopIndexForm"
			action="searchGoodsListMoreP.html" method="post">
			<input id="selGoodsCatId" name="selGoodsCatId" type="hidden"
				value="<s:property value='selGoodsCatId'/>" />
		</form>
		<div style="clear:both"></div>

	</div>
	<!--商品展示结束-->
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
