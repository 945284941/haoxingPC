<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<link href="css/hyzxdp.css" rel="stylesheet" type="text/css" />
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
	<!-- 导航 -->
	<jsp:include page="/memberCenter/common/navigation.jsp"/>
	<!-- 导航结束 -->
	<!-- 页脚开始 -->
	<div class="dht">
		<a >首页</a> > <a >会员中心</a> > <a >电子商城</a> > <a>商品管理</a> > <a >市场反馈</a>
	</div>
	<div class="gzgz">
		<div class="hyleft">
			<jsp:include page="/memberCenter/common/leftNavigate.jsp"></jsp:include>
		</div>
		<div class="hyright">
			<div class="hyrightr">
				<div id="rightjxw">
					<p class="hyd0">
						拥有商品品牌数<span>213</span>
					</p>
					<p class="hyd0">
						拥有商品分类数<span>230</span>
					</p>
					<p class="hyd0">
						拥有商品总数<span>230</span>
					</p>
					<p class="hyd0">
						商品上架总数<span>230</span>
					</p>
					<p class="hyd0">
						商品下架总数<span>230</span>
					</p>
				</div>
			</div>
			<p class="hymainbt">
				<span class="grmenubt">商品管理</span>
			</p>
			<div class="grscfk">
				<div class="fksearch">
					<ul>
						<li>商品名称:<input placeholder="请输入商品名称" />
						</li>
						<li><a class="fkss" href="#">搜索</a>
						</li>
					</ul>
					<div style="clear:both"></div>
				</div>
				<div class="spfk">
					<div class="fkxhbt">
						<span style="width:80px; margin-left:25px;">商品类别</span><span
							style="margin-left:50px; width:105px;">商品名称</span><span
							style="width:70px; margin-left:30px;">好评总计</span><span
							style="width:70px; margin-left:30px;">中评总计</span><span
							style="width:70px; margin-left:30px;">差评总计</span><span
							style="width:70px; margin-left:30px;">综合评价</span>
					</div>
					<div class="fklb">
						<ul>
							<li class="one">发动机发动机</li>
							<li class="two"><a href="#">斯太尔王整斯太尔王整车斯太尔王整车斯太尔王整车车</a>
							</li>
							<li class="three">1311</li>
							<li class="three">2100</li>
							<li class="three">50</li>
							<li class="three">中评</li>
						</ul>
						<div style="clear:both"></div>
					</div>
					<div class="fklb">
						<ul>
							<li class="one">发动机发动机</li>
							<li class="two"><a href="#">斯太尔王整车</a>
							</li>
							<li class="three">1311</li>
							<li class="three">2100</li>
							<li class="three">50</li>
							<li class="three">中评</li>
						</ul>
						<div style="clear:both"></div>
					</div>
					<div class="fklb">
						<ul>
							<li class="one">发动机发动机</li>
							<li class="two"><a href="#">斯太尔王整车</a>
							</li>
							<li class="three">1311</li>
							<li class="three">2100</li>
							<li class="three">50</li>
							<li class="three">中评</li>
						</ul>
						<div style="clear:both"></div>
					</div>
					<div class="fklb">
						<ul>
							<li class="one">发动机发动机</li>
							<li class="two"><a href="#">斯太尔王整车</a>
							</li>
							<li class="three">1311</li>
							<li class="three">2100</li>
							<li class="three">50</li>
							<li class="three">中评</li>
						</ul>
						<div style="clear:both"></div>
					</div>
					<div class="fklb">
						<ul>
							<li class="one">发动机发动机</li>
							<li class="two"><a href="#">斯太尔王整车</a>
							</li>
							<li class="three">1311</li>
							<li class="three">2100</li>
							<li class="three">50</li>
							<li class="three">中评</li>
						</ul>
						<div style="clear:both"></div>
					</div>
					<div class="fklb">
						<ul>
							<li class="one">发动机发动机</li>
							<li class="two"><a href="#">斯太尔王整车</a>
							</li>
							<li class="three">1311</li>
							<li class="three">2100</li>
							<li class="three">50</li>
							<li class="three">中评</li>
						</ul>
						<div style="clear:both"></div>
					</div>
					<div id="showpages">
						<p id="wzpage">
							<strong><span class="n2">首页</span>
							</strong> <strong><span class="n">上一页</span>
							</strong> <strong><span class="pc">1</span>
							</strong> <a href="#"><span class="pc">2</span>
							</a> <a href="#"><span class="pc">3</span>
							</a> <a href="#"><span class="pc">4</span>
							</a> <a href="#"><span class="pc">5</span>
							</a> <a href="#"><span class="n">下一页></span>
							</a> <a href="#"><span class="n2">尾页</span>
							</a> <a><span class="page-skip"><em>&nbsp;&nbsp;&nbsp;&nbsp;第1页&nbsp;&nbsp;共100页&nbsp;&nbsp;&nbsp;&nbsp;到第</em><input
									type="text" onkeydown="" value="1" class="jumpto">页
							</span>
							</a> <a href="" onclick="" value="转到"><span
								class="btn-skipsearch">转到</span>
							</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div style="clear:both"></div>
	</div>
	<div class="gg">
		<a href="/"><img src="/images/memberimg/tlgg1.gif" />
		</a>
	</div>
	<div class="gzgz">
		<div class="rlqz">
			<!--  <p class="rlqztb">热烈祝贺：古道金典成功上线！！</p>-->
		</div>
		<div class="gzgzbk">
			<dl>
				<dt>关于泉利</dt>
				<dd>
					<a href="/">公司简介</a>
				</dd>
				<dd>
					<a href="/">加盟合作</a>
				</dd>
				<dd>
					<a href="/">联系我们</a>
				</dd>
				<dd>
					<a href="/">广告资源</a>
				</dd>
			</dl>
			<dl>
				<dt>新手指南</dt>
				<dd>
					<a href="/">用户注册 </a>
				</dd>
				<dd>
					<a href="/">购物流程</a>
				</dd>
				<dd>
					<a href="/">密码找回</a>
				</dd>
				<dd>
					<a href="/">免责声明</a>
				</dd>
			</dl>
			<dl>
				<dt>支付方式</dt>
				<dd>
					<a href="/">货到付款</a>
				</dd>
				<dd>
					<a href="/">在线支付</a>
				</dd>
				<dd>
					<a href="/">预存款说明</a>
				</dd>
				<dd>
					<a href="/">兑米说明</a>
				</dd>
			</dl>
			<dl style="border-right:none;">
				<dt>售后服务</dt>
				<dd>
					<a href="/">退换货流程</a>
				</dd>
				<dd>
					<a href="/">退款说明</a>
				</dd>
				<dd>
					<a href="/">投诉建议</a>
				</dd>
				<dd>
					<a href="/">网站地图</a>
				</dd>
			</dl>
		</div>
		<div class="foot">
			<p>版权所有： 山东泉利置业有限公司</p>
			<p>济南德睿东方商业管理有限公司 鲁ICP备13009108</p>
			<p>技术支持：济南德睿东方商业管理有限公司</p>
			<p>公司地址：山东省济南市天桥区二环北路8号</p>
		</div>
	</div>
	<!-- 页脚结束 -->
</body>
</html>