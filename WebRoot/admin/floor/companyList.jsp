<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<title>颐佳官方商城-商家列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="/admin/common/keyWords.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<link rel="stylesheet" href="css/master.css" type="text/css" />
<link href="css/content.css" rel="stylesheet" type="text/css" />
<link href="css/sjlb.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link rel="stylesheet" href="css/page.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript src="js/catalogue.js"></script>
<script type=text/javascript src="js/regions.js"></script>
<script type="text/javascript" src="js/smap.js"></script>

<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
</head>

<body >
	<!-- header begin -->
	<div class="header">
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	</div>
	<div class="logo">
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	</div>
	<!-- header end -->

	<!-- 代码 开始 -->
	<div id="warp">
		<div class=" bannerzong">
			<ul class="mainnavzong">
				 <li><a class="hover" href="http://www.qlqpw.com" target="_self">商城首页</a></li>
			     <li><a href="qpzx.html">汽配资讯</a></li>
			     <li><a href="zpxy.html">重配学院</a></li>
			     <li><a href="cppc.html">产品评测</a></li>
			     <li><a href="schq.html">市场行情</a></li>
			     <li><a href="gqxx.html">供求信息</a></li>
			     <li><a href="magazine/magazineMain.html">古道杂志</a></li>
			     <li><a href="/admin/foot/contact.jsp">联系我们</a></li>
			</ul>
			<div class="mainqlzpc">
     <a href="news/news!toQlqpc.action"><img src="images/zpc.gif" alt="古道金典" /></a>
   </div>
			<!-- 全部商品分类开始 -->
			<s:action name="searchGoodsAction!gainFirstList" executeResult="true"
				namespace="/"></s:action>
			<!-- 全部商品分类结束 -->
		</div>

		<!-- 滚动图片 -->
		<div class="cplist_main">
			<!-- 相关商家推荐开始 -->
			<div class="sjlbleft"
				style="margin-top:565px; display:inline; position:relative; z-index:0;">
				<div class="right" >
					<s:action name="indexFloorAction!showRegionsComRecommendList"
						executeResult="true" namespace="/indexFloor"></s:action> 				
				</div>
			</div>
			<!-- 相关商家推荐结束 -->
			<div class="sjlbright">
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
					function _orderByUpdatetime(order) {
						if ("asc" == order) {
							$("#orderByUpdatetime").removeClass("gxtime");
							$("#orderByUpdatetime").addClass("gxtime2");
							$("#order").val("desc");
						} else {
							$("#orderByUpdatetime").removeClass("gxtime2");
							$("#orderByUpdatetime").addClass("gxtime");
							$("#order").val("asc");
						}
						$("#sjlbsplistSearchForm").submit();
					}
					function _sjlbsplistSubmitForm() {
						$("#sjlbsplistSearchForm").submit();
					}
				</script>
				<!-- 滚动图片 

				<div id="slides" class="banner">
					<div class="banner_l">
						<a class="prev" href="#"><img alt="上一页"
							src="/images/banner_l.png" width="24" height="43" /> </a>
					</div>
					 
					<div class="bannerImg">
						<div class="slides_container">
							<div id="banner_pic_1">
								<a href="http://zh.qlqpw.com" target="_blank"><img src="/images/sjlbgg.jpg"
									width="970" height="170" /> </a>
							</div>
							<div style="DISPLAY: none" id="banner_pic_2">
								<a href="/magazine/magazineMain.html" target="_blank"><img src="/images/zz2.jpg"
									width="970" height="170" /> </a>
							</div>
							<div style="DISPLAY: none" id="banner_pic_3">
								<a href="/qpzx.html" target="_blank"><img src="/images/dx2.jpg"
									width="970" height="170" /> </a>
							</div>

						</div>
					</div>
					 
					<div class="banner_r">
						<a class="next" href="#"><img alt="下一页"
							src="/images/banner_r.png" width="24" height="43" /> </a>
					</div>
				</div>
				-->
				<div class="cplistrightsjlb">
					<div class="sjlbsplist">
						<form action="/rcomrecommends/more/list.html"
							id="sjlbsplistSearchForm" name="sjlbsplistSearchForm"
							method="post">
							<input type="hidden" id="searchType" name="searchType" value="<s:property value='#request.searchType'/>" />
							<input type="hidden" id="topSearchLike" name="topSearchLike" value="<s:property value='#request.topSearchLike'/>" />
							<input name="rcr.floor" type="hidden" value="${rcr.floor}" /> <input
								id="order" name="order" type="hidden" value="${order}" />
							<div class="sppxbt">
								<span class="sppx">商家排序：</span><span class="mrpx">默认排行</span><span
									class="gxtime" onclick="_orderByUpdatetime('${order}')"
									id="orderByUpdatetime">更新时间</span>
								<p class="jz">
									<span>选择区域</span> <span class="wlsj"> <label
										for="select"></label> <s:select id="comlist_provinceList"
											name="rcr.province" headerKey="0" headerValue="选择省份"
											list="provinceList" listKey="id" listValue="name"
											value="%{rcr.province}" theme="simple"
											onchange="pub_getCitys(this.value,'comlist_cityList')"></s:select>
									</span>
								</p>
								<p class="jz">
									<span class="wlsj"> <label for="select"></label> <s:select
											id="comlist_cityList" name="rcr.city" headerKey="0"
											headerValue="选择市" list="cityList" listKey="id"
											listValue="name" value="%{rcr.city}" theme="simple"></s:select>
									</span>
								</p>
								<p class="qued">
									<a href="javascript:void(0);" onclick="_sjlbsplistSubmitForm()">确定</a>
								</p>
							</div>
						</form>
						<s:if test="%{rcrlist.size()>0}">
							<s:iterator value="rcrlist" var="li" status="st">
								<div class="sjlb_cpcx">
									<div class="sjlb_left">
										<p class="sjlb_cppic">
											<s:if test="null!=#li.comSrc&&''!=#li.comSrc">
												<a href="/Shop/index_${li.companyId}.html" target="_blank"><img src="/images/<s:property value='#li.comSrc'/>" width="147" height="110" /></a>											
											</s:if>
											<s:else>
												<a href="/Shop/index_${li.companyId}.html" target="_blank"><img src="/images/330-206zwpic.gif" width="147" height="110" /></a>
											</s:else>			
										</p>
										<p class="sjlb_leftjxs">
											<span class="jxsmz">经销商名：<a href="/Shop/index_${li.companyId}.html" target="_blank"><s:property
													value='#li.companyName' /> </a></span><span class="ckmap"><a
												href="javascript:void(0)" id="view-map-link" title="点击查看地图"
												onclick="_ShowMapDIV('map-dialogDiv','map-coverDiv','pcaa_<s:property value='#li.id' />','comname_<s:property value='#li.id' />','1','1','1','container')">查看地图</a>
											</span>
										</p>
										<!-- smap begin -->
										<jsp:include page="/admin/floor/map.jsp" />
										<!-- smap end -->
										<p class="szqyyh">
											<span class="szqyyhsycx">所在地区：<s:if
													test="null!=#li.pname&&''!=#li.pname">
													<s:property value='#li.pname' />
													<s:property value='#li.cname' />
													<s:property value='#li.aname' />
												</s:if> <s:else>---</s:else> </span> <span class="szqyyhsydz">街道地址：<s:if
													test="null!=#li.address&&''!=#li.address">
													<s:property value='#li.address' />
												</s:if> <s:else>---</s:else> </span> <span class="zxzxan">
												
												<s:if test="null==#li.qqNumber">
												<a target=blank href=tencent://message/?uin=2221207332&Site=www.ik38.com&Menu=yes>在线咨询</a>
												</s:if>
												<s:else>
													<a target=blank href=tencent://message/?uin=${li.qqNumber}&Site=www.ik38.com&Menu=yes>在线咨询</a>
												</s:else>
												 </span> <input type="hidden"
												id="pcaa_<s:property value='#li.id' />" name="pcaa"
												value="<s:property value='#li.pcaa' />" /> <input
												type="hidden" id="comname_<s:property value='#li.id' />"
												name="comname"
												value="<s:property value='#li.companyName' />" />
										</p>
										<dl>
											<dd class="sjlbhyjb">
												<span class="jz">会员级别：</span><span class="hyjbgood"><img src="/images/levelIcon/${li.vipGradeImgSrc}" title="${li.vipLevelName}"/></span>
											</dd>
											<dd>
												联系电话：
												<s:if test="null!=#li.mobile&&''!=#li.mobile">
													<s:property value='#li.mobile' />
												</s:if>
												<s:else>---</s:else>
											</dd>
											<dd>
												入驻时间：
												<s:if test="null!=#li.regTime">
													<fmt:formatDate value="${li.regTime}" pattern="yyyy.MM.dd"/>
												</s:if>
												<s:else>---</s:else>
											</dd>
										</dl>
										<div class="zfxw">
											<p class="sjlbhyjb">
												<span class="jz">质量等级：</span>
 												<span class="zldjbz">
													<s:if test='null!=#li.qualityImgSrc&&""!=#li.qualityImgSrc'>
														<img src="/images/levelIcon/${li.qualityImgSrc}" />
													</s:if>
													<s:else>0级</s:else> 												
 												</span>												
											</p>
											<p class="sjlbhyjb">
												<span class="jz">服务等级：</span>
 												<span class="zldjbz">
													<s:if test='null!=#li.serveImgSrc&&""!=#li.serveImgSrc'>
														<img src="/images/levelIcon/${li.serveImgSrc}" />
													</s:if>
													<s:else>0级</s:else> 												
 												</span>																				
											</p>
											<p class="sjlbhyjb">
												<span class="jz">信誉等级：</span>
 												<span class="zldjbz">
													<s:if test='null!=#li.creditImgSrc&&""!=#li.creditImgSrc'>
														<img src="/images/levelIcon/${li.creditImgSrc}" />
													</s:if>
													<s:else>0级</s:else> 												
 												</span>												
											</p>
											<p class="sjlbhyjb">
												<span class="jz">物流等级：</span>
 												<span class="zldjbz">
													<s:if test='null!=#li.logisticsImgSrc&&""!=#li.logisticsImgSrc'>
														<img src="/images/levelIcon/${li.logisticsImgSrc}" />
													</s:if>
													<s:else>0级</s:else> 												
 												</span>												
											</p>
										</div>
									</div>
								</div>
							</s:iterator>
						</s:if>
						<s:else>
							<span style="color:red;">暂时没有符合条件的数据！</span>
						</s:else>
						<!-- 分页开始 -->
						<div id="showpages">
							<page:pagination path="rcomrecommends/more/list.html"
								formName="sjlbsplistSearchForm" />
						</div>
						<!-- 分页结束 -->
					</div>
				</div>
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
