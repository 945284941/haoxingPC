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
<meta http-equiv="keywords" content="网站地图" />
<meta http-equiv="description" content="网站地图" />
<title>网站地图</title>
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
		<a href="javascript:void(0)">首页</a> > <a href="javascript:void(0)">售后服务</a>
		> <a href="javascript:void(0)">网站地图</a>
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
					<a class="hover" href="/admin/foot/wzmap.jsp">网站地图</a>
				</dd>
			</dl>
		</div>
		<div class="hyright">
			<p class="hymainbt">
				<span class="grmenubt">网站地图</span>
			</p>
			<div class="wzmap">
				<div class="clearmap">
					<div class="wzmapli">
						<h3>
							<a href="javascript:void(0)"> [泉利商城]</a>
						</h3>
						<div class="wzdt">
							<span><a href="javascript:void(0)">发动机</a> </span> <span><a
								href="javascript:void(0)">变速器</a> </span> <span><a
								href="javascript:void(0)">驾驶室</a> </span> <span><a
								href="javascript:void(0)">离合器</a> </span><span><a
								href="javascript:void(0)">转向系统</a> </span> <span><a
								href="javascript:void(0)">挂车</a> </span> <span><a
								href="javascript:void(0)">电器系统</a> </span> <span><a
								href="javascript:void(0)">传动</a> </span> <span><a
								href="javascript:void(0)">悬挂</a> </span><span><a
								href="javascript:void(0)">车架</a> </span> <span><a
								href="javascript:void(0)">自卸上装</a> </span><span><a
								href="javascript:void(0)">前中后桥</a> </span> <span><a
								href="javascript:void(0)">制动系统</a> </span><span><a
								href="javascript:void(0)">油品</a> </span> <span><a
								href="javascript:void(0)">螺栓及螺母</a> </span><span><a
								href="javascript:void(0)">轴承</a> </span> <span><a
								href="javascript:void(0)">发动机附件</a> </span>
						</div>
					</div>
					<div class="wzmapli wzmapli_2">
						<h3>
							<a href="javascript:void(0)"> [市场行情]</a>
						</h3>
						<div class="wzdt">
							<span><a href="javascript:void(0)">重汽品牌市场行情</a> </span> <span><a
								href="javascript:void(0)">国际整车需求行情</a> </span> <span><a
								href="javascript:void(0)">国际整车市场行情</a> </span> <span><a
								href="javascript:void(0)">国际重配市场行情</a> </span> <span><a
								href="javascript:void(0)">国际汽修厂需求及销售行情</a> </span> <span><a
								href="javascript:void(0)">中国整车需求行情</a> </span> <span><a
								href="javascript:void(0)">中国整车市场行情报告</a> </span> <span><a
								href="javascript:void(0)">中国重配市场行情</a> </span> <span><a
								href="javascript:void(0)">中国维修厂需求及销售行情</a> </span>
						</div>
					</div>
					<div class="wzmapli wzmapli_3">
						<h3>
							<a href="javascript:void(0)"> [汽配资讯]</a>
						</h3>
						<div class="wzdt">
							<span><a href="javascript:void(0)">重配新闻 </a> </span> <span><a
								href="javascript:void(0)">方针政策 </a> </span> <span><a
								href="javascript:void(0)">技术前沿 </a> </span> <span><a
								href="javascript:void(0)">产业资讯 </a> </span> <span><a
								href="javascript:void(0)">展会论坛 </a> </span> <span><a
								href="javascript:void(0)">人物访谈</a> </span>
						</div>
					</div>
					<p style="clear:both"></p>
				</div>
				<div class="clearmap" style="margin-top:20px;">
					<div class="wzmapli">
						<h3>
							<a href="javascript:void(0)"> [供求信息]</a>
						</h3>
						<div class="wzdt">
							<span><a href="javascript:void(0)">整车供求</a> </span> <span><a
								href="javascript:void(0)">配件供求</a> </span> <span><a
								href="javascript:void(0)">设备供求</a> </span> <span><a
								href="javascript:void(0)">汽修厂</a> </span><span><a
								href="javascript:void(0)">物流供求</a> </span> <span><a
								href="javascript:void(0)">租赁供求</a> </span> <span><a
								href="javascript:void(0)">招聘供求</a> </span> <span><a
								href="javascript:void(0)">其他</a> </span>
						</div>
					</div>
					<div class="wzmapli wzmapli_2">
						<h3>
							<a href="javascript:void(0)"> [产品评测]</a>
						</h3>
						<div class="wzdt">
							<span><a href="javascript:void(0)">整车评测</a> </span> <span><a
								href="javascript:void(0)">配件评测 </a> </span>
						</div>
					</div>
					<div class="wzmapli wzmapli_3">
						<h3>
							<a href="javascript:void(0)"> [泉利杂志]</a>
						</h3>
						<div class="wzdt">
							<span><a href="javascript:void(0)">新闻动态 </a> </span> <span><a
								href="javascript:void(0)">策划 </a> </span> <span><a
								href="javascript:void(0)">市场行情 </a> </span> <span><a
								href="javascript:void(0)">人物专访 </a> </span> <span><a
								href="javascript:void(0)">政策解读 </a> </span> <span><a
								href="javascript:void(0)">厂商展台</a> </span> <span><a
								href="javascript:void(0)">供求信息 </a> </span> <span><a
								href="javascript:void(0)">重配学院 </a> </span> <span><a
								href="javascript:void(0)">乐活 </a> </span> <span><a
								href="javascript:void(0)">杂志公告 </a> </span> <span><a
								href="javascript:void(0)">杂志简介</a> </span>
						</div>
					</div>
					<p style="clear:both"></p>
				</div>
				<div class="clearmap" style="margin-top:20px;">
					<div class="wzmapli wzmapli_1">
						<h3>
							<a href="javascript:void(0)"> [重配学院]</a>
						</h3>
						<div class="wzdt">
							<div class="zxxtz">
								<p>
									<a href="javascript:void(0)">在线学堂</a>
								</p>
								<p>
									<a href="javascript:void(0)">行业报告</a>
								</p>
								<p>
									<a href="javascript:void(0)">技术答疑</a>
								</p>
								<p>
									<a href="javascript:void(0)">重配学院新闻</a>
								</p>
								<p>
									<a href="javascript:void(0)">重配学院活动</a>
								</p>
								<p>
									<a href="javascript:void(0)">重配学院简介</a>
								</p>
							</div>
							<div class="zxxt">
								<p>
									<span><a href="javascript:void(0)">品牌知识</a> </span><span><a
										href="javascript:void(0)">整车知识</a> </span><span><a
										href="javascript:void(0)">配件知识</a> </span><span><a
										href="javascript:void(0)">维修知识 </a> </span><span><a
										href="javascript:void(0)">保养知识</a> </span><span><a
										href="javascript:void(0)">其他知识</a> </span>
								</p>
								<p class="bg">
									<span><a href="javascript:void(0)">整车需求行业报告 </a> </span><span><a
										href="javascript:void(0)">整车市场行情报告 </a> </span><span><a
										href="javascript:void(0)">重配市场行情报告 </a> </span><span><a
										href="javascript:void(0)">维修厂需求及销售行情报告 </a> </span><span><a
										href="javascript:void(0)">其他市场行情报告</a> </span>
								</p>
								<p>
									<span><a href="javascript:void(0)">整车选购</a> </span><span><a
										href="javascript:void(0)">配件答疑</a> </span><span><a
										href="javascript:void(0)">维护保养</a> </span><span><a
										href="javascript:void(0)">故障检测</a> </span><span><a
										href="javascript:void(0)">其他答疑</a> </span>
								</p>
							</div>

						</div>
					</div>
					<div class="wzmapli wzmapli_3">
						<h3>
							<a href="javascript:void(0)"> [会员俱乐部]</a>
						</h3>
						<div class="wzdt"></div>
					</div>
					<p style="clear:both"></p>
				</div>
				<div class="clearmap_2">
					<div class="wzmapli">
						<h3>
							<a href="javascript:void(0)"> [关于泉利]</a>
						</h3>
						<div class="wzdt">
							<span><a href="javascript:void(0)">公司简介</a> </span> <span><a
								href="javascript:void(0)">加盟合作</a> </span> <span><a
								href="javascript:void(0)">联系我们</a> </span> <span><a
								href="javascript:void(0)">广告资源</a> </span>
						</div>
					</div>
					<div class="wzmapli">
						<h3>
							<a href="javascript:void(0)"> [新手指南]</a>
						</h3>
						<div class="wzdt">
							<span><a href="javascript:void(0)">用户注册</a> </span> <span><a
								href="javascript:void(0)">购物流程</a> </span> <span><a
								href="javascript:void(0)">密码找回</a> </span> <span><a
								href="javascript:void(0)">免责声明 </a> </span>
						</div>
					</div>
					<div class="wzmapli">
						<h3>
							<a href="javascript:void(0)"> [支付方式]</a>
						</h3>
						<div class="wzdt">
							<span><a href="javascript:void(0)">货到付款</a> </span> <span><a
								href="javascript:void(0)">在线支付</a> </span> <span><a
								href="javascript:void(0)">预存款说明</a> </span> <span><a
								href="javascript:void(0)">体现说明 </a> </span>
						</div>
					</div>
					<div class="wzmapli wzmapli_3">
						<h3>
							<a href="javascript:void(0)"> [售后服务]</a>
						</h3>
						<div class="wzdt">
							<span><a href="javascript:void(0)">退换货流程</a> </span> <span><a
								href="javascript:void(0)">退款说明</a> </span> <span><a
								href="javascript:void(0)">投诉建议</a> </span> <span><a
								href="javascript:void(0)">网站地图 </a> </span>
						</div>
					</div>
					<p style="clear:both"></p>
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