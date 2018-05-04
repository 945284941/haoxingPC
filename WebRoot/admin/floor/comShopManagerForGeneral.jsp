<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>颐佳官方商城</title>
<link href="css/master.css" rel="stylesheet" type="text/css" />
<link href="css/news.css" rel="stylesheet" type="text/css" />
<link href="css/retail.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript src="js/floor.js"></script>
<script type="text/javascript" src="js/qlzy.js"></script>
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
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	</div>
	<div class="logo">
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	</div>
	<!-- header end -->

	<!-- 导航 -->
	<jsp:include page="/admin/common/navigation.jsp" />
	<!-- 导航结束 -->

	<div class="dht">首页 &gt; 商家列表 &gt; 商家展示</div>
	<div class="zs">
		<div>
			
	    </div>
		<div class="zsleft">
			<s:if test='company.shCheck eq "1" '>
		    	<p style="margin-bottom:10px"><a href="http://www.sdqpsh.com/" target="_blank"><img src="/images/sh/shbs.jpg" width='330px;' height="200px;"/></a></p>
		    </s:if>
			<p class="pic">
				<s:if test="null!=company.storefrontSrc&&''!=company.storefrontSrc">
					<img src="/images/${company.storefrontSrc}" width="330"
						height="206" />
				</s:if>
				<s:else>
					<img src="/images/330-206zwpic.gif" width="240" height="150" />
				</s:else>
			</p>
			<p>
				<span>所在地区：<s:if
						test="%{company.province!=null && company.province!=''}">${company.pname}${company.cname}${company.aname}</s:if>
					<s:else>---</s:else> </span>
			</p>
			<p>
				<span>街道地址：<s:if
						test="%{company.address!=null && company.address!=''}">${company.address}</s:if>
					<s:else>---</s:else> </span>
			</p>
			<p class="dj_hy">
				<span>会员级别<img src="/images/levelIcon/${company.vipGradeImgSrc}" title="${company.vipLevelName}"/> </span>
			</p>
			<p class="dj_hy">
				<span style="margin-right:30px;">质量等级
					<s:if test='null!=company.qualityImgSrc&&""!=company.qualityImgSrc'>
						<img src="/images/levelIcon/${company.qualityImgSrc}" />
					</s:if>
					<s:else>0级</s:else>			
				</span> 
				<span>信誉级别
					<s:if test='null!=company.creditImgSrc&&""!=company.creditImgSrc'>
						<img src="/images/levelIcon/${company.creditImgSrc}" />
					</s:if>
					<s:else>0级</s:else>				
				</span>
			</p>
			<p class="dj_hy">
				<span style="margin-right:30px;">服务等级
					<s:if test='null!=company.serveImgSrc&&""!=company.serveImgSrc'>
						<img src="/images/levelIcon/${company.serveImgSrc}" />
					</s:if>
					<s:else>0级</s:else>				
				</span> 
				<span>物流等级
					<s:if test='null!=company.logisticsImgSrc&&""!=company.logisticsImgSrc'>
						<img src="/images/levelIcon/${company.logisticsImgSrc}" />
					</s:if>
					<s:else>0级</s:else>				
				</span>
			</p>
			<p>
				<span>更新时间：<s:date name="%{company.regTime}"
						format="yyyy.MM.dd" /> </span>
			</p>
			<p class="zxz">
					<a class="zxzv" target=blank href=tencent://message/?uin=${company.qqNumber}&Site=www.ik38.com&Menu=yes>
					在线咨询</a>
				<a class="zxzv"
					onclick="mark('${company.id }','3','<%= memberId%>');">收藏店铺</a>
			</p>
		</div>
		<div class="zsright">
			<p class="h2">${company.companyName}</p>
			<p class="gsjj">${company.combrief}</p>
		</div>
	</div>
	<!--商品展示开始-->
	<div class="zysp">
		<div class="zysp_l">
			<div class="cpsp">
				<h2>主营产品展示</h2>
				<ul class="rmfl" id="comGoods_zy_goodsCat">
					<s:iterator value="goodsCatList" var="li" status="st">
						<s:if test="#st.last">
							<li><a id="comGoods<s:property value="#li.id"/>"
								onclick="comShop_getComGoods('comGoods<s:property value="#li.id"/>','${company.id}','<s:property value="#li.id"/>')"
								href="javascript:void(0)"
								onmouseover="comShop_getComGoods('comGoods<s:property value="#li.id"/>','${company.id}','<s:property value="#li.id"/>')"><s:property
										value="#li.name" /> </a>
							</li>
						</s:if>
						<s:else>
							<li><a id="comGoods<s:property value="#li.id"/>"
								onclick="comShop_getComGoods('comGoods<s:property value="#li.id"/>','${company.id}','<s:property value="#li.id"/>')"
								href="javascript:void(0)"
								onmouseover="comShop_getComGoods('comGoods<s:property value="#li.id"/>','${company.id}','<s:property value="#li.id"/>')"><s:property
										value="#li.name" /> </a>|</li>
						</s:else>
					</s:iterator>
				</ul>
				<div class="both"></div>
			</div>
			<div class="zsp" id="com_goods">
				<s:if test="%{goodsListByCom.size()>0}">
					<s:iterator value="goodsListByCom" var="li" status="st">
						<s:if test="#st.index<16">
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
									<span class="dlf">¥</span><s:property value="#li.price" />
								</p>
							</div>
						</s:if>
					</s:iterator>
				</s:if>
				<s:else>
					<span style="color:red;">暂时没有符合条件的数据！</span>
				</s:else>
			</div>
		</div>
		<div class="zysp_r">
			<h2>热门商品</h2>
			<ul>
				<s:if test="%{hotGoodsList.size()>0}">
					<s:iterator value="hotGoodsList" var="hotGoodsList">
						<li>
							<p class="p-img">
								<a href="goods/<s:property value='#hotGoodsList.id'/>.html"
									target="_blank"> <img
									src="<s:property value='#hotGoodsList.defaultPicSrc'/>"
									class="err-product" width="74" height="58" /> </a>
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
									<span class="dlf">¥</span><s:property value="#hotGoodsList.price" />
								</p>
							</div></li>
					</s:iterator>
				</s:if>
				<s:else>
					<li><span style="color:red;">暂时没有符合条件的数据！</span>
					</li>
				</s:else>
			</ul>
		</div>
		<div class="both"></div>
	</div>
	<!--商品展示结束-->

	<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
	<!-- footer end -->
</body>
</html>
