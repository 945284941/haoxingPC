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
<meta http-equiv="keywords" content="预存款说明" />
<meta http-equiv="description" content="预存款说明" />
<title>预存款说明</title>
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
		<a href="javascript:void(0)">首页</a> > <a href="javascript:void(0)">会员相关</a> > <a href="javascript:void(0)">预存款说明</a>
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
			<a class="hover" href="/admin/foot/deposit.jsp">预存款说明</a>
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
				<span class="grmenubt">预存款说明</span>
			</p>

			<div class="grjbxx">
				<p>
					<strong style="color:#F60;">一、相关定义 </strong><br /> <strong>1</strong><strong>、预存款：</strong>预存款是古道金典推出的一项预备金交易业务项目，如果用户在会员中心资金管理中拥有一定的预存款金额，在购买商品或做支付兑米交易时可以直接使用，可以增加业务的处理速度并会有相应的奖励。是用户向站方充值预存款，专项用于在古道金典的经营活动。
					<br /> <strong>2</strong><strong>、预存款充值：</strong>预存款充值是指，用户通过古道金典签约的第三方支付平台的网上银行，将自身账户中的资金预存在古道金典的账户中，此资金的所有权依然为用户。
					<br /> <strong>3</strong><strong>、预存款兑米：</strong>预存款兑米是指，用户通过古道金典的会员中心资金管理的兑米功能，将用户在网站合法的预存款通过第三方支付平台转入用户自身银行账户。
					<br /> <strong>4</strong><strong>、预存款余额：</strong>预存款余额指，以当前时间为节点来统计用户在古道金典预存款的剩余可支配的资金额度。
					<br /> <strong>5</strong><strong>、可支配预存款：</strong>可支配预存款是指，用户在古道金典中的预存款资金可以根据用户本意自由的用于支付、兑米、充值、转账等的资金款项。
					<br /> <strong>6</strong><strong>、冻结预存款：</strong>冻结预存款是指，因用户自身原因导致用户涉嫌违法，站方配合公检法机构采取的使用户预存款余额为不可支配的预存款的强制行为；或用户恶意蓄意破坏站方正常运营，破坏正常的市场秩序等违反了相关规定及合同的违法或违规行为，站方采取的某一时间段内冻结预存款的强制措施。冻结后的预存款不得兑米，支付，转账。
				</p>
				<p>
					<strong style="color:#F60;">二、预存款操作流程 </strong><br /> <strong>1</strong><strong>、预存款充值流程
					</strong><br /> <strong>1-1</strong> 会员在古道金典中找到预存款充值的按钮点击进入充值页面； <br /> <strong>1-2
					</strong>会员在充值页面中输入本次将要充值的金额并点击确认后进入支付方式选择页面； <br /> <strong>1-3</strong>
					会员在支付方式选择页面中可以选择第三方支付平台支付与银行柜台支付；
				</p>
				<ol>
					<ol>
						<ol>
							<li>如会员选择第三方支付平台支付，会进入选择网银界面，选择会员拥有的开通网银的银行即可；</li>
							<li>然后进入该银行的支付页面继续完成操作流程直至交易成功。</li>
						</ol>
					</ol>
				</ol>
				<p>
					<strong>1-2-1</strong>
					如会员选择银行柜台支付方式，需要会员记录站方展示的开户银行，银行账户，及收款人等信息，并将自身的相关信息填写在此页面； <br />
					<strong>1-2-2</strong> 会员提交信息后，便可以通过去银行柜台进行向站方指定的银行账户进行转账或汇款操作； <br />
					<strong>1-2-3</strong>
					会员转账或汇款完成后可以回到网站后台资金管理页面中上传转账或汇款凭证（可扫描或拍照）图片，点击完成。 <br /> <strong>1-2-4</strong>
					站方客服人员确认后，会员获得预存款相应金额完成流程。
				</p>
				<ol>
					<li>预存款兑米流程</li>
					<ol>
						<li>会员在网站中点击兑米按钮，进入兑米提示页面，仔细阅读提示信息后，再按照提示要求进行相关操作；</li>
						<li>会员输入兑米的具体金额后，提交兑米申请；</li>
						<li>通过兑米审核后，会员选择网站系统中的任意一方支持兑米的银行，输入相关的银行账户信息并确定；</li>
					</ol>
				</ol>
				<p>
					<strong>1-4</strong> 会员核对上几步的操作无误后，输入相关兑米密码或验证码，等待系统确认； <br /> <strong>1-5</strong>
					站方在第三方支付平台或相关银行规定的账期内，将款项支付到会员输入的银行账户中，至此全部兑米流程完成。
				</p>
				<p>
					<strong style="color:#F60;">三、预存款规则 </strong><br /> <strong>1、</strong>使用网银或第三方支付平台进行线上充值时，须遵守相关的银行或第三方支付平台的使用规定；
					<br /> <strong>2、</strong>使用线下银行柜台或ATM设备充值时保留好转账或汇款原始凭证，并拍照或扫描原始凭证，将图片上传至网站。
					<br /> <strong>3、</strong>由站方客服人员核对转账或汇款的原始凭证图片，并核实相关款项已到账，系统通知会员预存款充值成功；
					<br /> <strong>4、</strong>关于预存款充值及兑米的转账、支付、汇款等手续费以第三方支付平台或站方相关规定计算，相关费用由会员承担；
				</p>
				<p>
					<strong style="color:#F60;">四、其他 </strong><br /> <strong>1、</strong>本规则自发布之日起生效<br />
					<strong>2、</strong>本规则的最终解释权归济南德睿东方商业管理有限公司享有。
				</p>
				<p style="text-align:right;">济南德睿东方商业管理有限公司</p>
				<p style="text-align:right;">2013/6/26</p>
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

