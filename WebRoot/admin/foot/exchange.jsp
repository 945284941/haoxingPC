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
<meta http-equiv="keywords" content="退换货流程" />
<meta http-equiv="description" content="退换货流程" />
<title>退换货流程</title>
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
		<a href="javascript:void(0)">首页</a> > <a href="javascript:void(0)">售后服务</a> > <a href="javascript:void(0)">退换货流程</a>
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
			<a href="/admin/foot/membePoint.jsp">会员经验值</a>
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
			<a class="hover" href="/admin/foot/exchange.jsp">退换货流程</a>
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
				<span class="grmenubt">退换货流程</span>
			</p>

			<div class="grjbxx">
				<p>
					为规范古道金典电子商务买卖双方的交易后退换货以及退款的行为，促进开放、透明、责任的商业文明，维护古道金典正常运营秩序。 <br />
					<strong style="color:#F60;">商品退换货政策</strong> <br /> <strong>1</strong><strong>、换货规则</strong>（满足如下条件时，买方可以申请换货）
					<br /> 1-1 买方收到货物时，商品出现质量问题的影响买方正常使用的； <br /> 1-2
					买方收到货物时，发现实际商品与订单所购商品不符的； <br /> 1-3 买方收到货物时，发现商品与网站描述严重不符的； <br />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出现以上情况，卖方承担买方因换货产生的物流运费；
					<br /> <strong>2</strong><strong>、换货流程</strong>（分为联系卖方换货与联系站方换货） <br />
					1-1 联系卖方换货（通过古道金典站与卖方线下直接交易的）
				</p>
				<ol>
					<ol>
						<ol>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;买方收到商品后，如果满足换货规则可以直接联系卖方换货；
							</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卖方收到买方换货申请后，应及时处理买方诉求对买方进行及时换货处理；
							</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;因卖方原因造成换货的，应补偿本次换货的物流运费；
							</li>
						</ol>
					</ol>
				</ol>
				<p>1-2 联系站方换货（通过古道金典与卖方线上直接交易的）</p>
				<ol>
					<ol>
						<ol>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;买方收到商品后，如果满足换货规则可以联系站方客服申请换货；
							</li>
						</ol>
					</ol>
				</ol>
				<p>
					1-1-2 站方客服收到买方申请后，需要获知买方换货原因，如买方有条件可以提供该商品的照片为换货依据； <br /> 1-1-3
					站方客服经确认属于可换货范围的商品，联系卖方沟通换货事宜，并将具体结果反馈买方；
				</p>
				<ol>
					<ol>
						<ol>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;买方根据客服的指引，将商品发回卖方等待卖方重新发货。
							</li>
						</ol>
					</ol>
				</ol>
				<p>
					<strong>3</strong><strong>、退货规则</strong>（满足如下条件时，买方可以申请换货） <br />
					1-1 买方收到货物时，发现货物存在明显质量问题的； <br /> 1-2 买方经过一次换货后仍然存在换货规则存在的问题的； <br />
					1-3 买方收到货物时商品与卖方描述出入较大的； <br /> 1-4 卖方描述中明确承诺的退货说明的； <br /> <strong>4</strong><strong>、退货流程</strong>（分为联系卖方退货与联系站方退货）
					<br /> 1-1 联系卖方退货（通过古道金典站与卖方线下直接交易的） <br />
					1-1-1买方收到商品后，如果满足退货规则可以直接联系卖方退货； <br />
					1-1-2卖方收到买方退货申请后，应及时处理买方诉求对买方进行及时退货处理； <br />
					1-1-3因卖方原因造成退货的，应补偿本次换货的物流运费； <br /> 1-1-4
					卖方收到退货商品后，将本次交易的产生的金额返还给买方完成退货流程；
				</p>
				<ol>
					<ol>
						<li>联系站方退货（通过古道金典与卖方线上直接交易的）</li>
					</ol>
				</ol>
				<p>
					1-1-1 买方收到商品后，如果满足退货规则可以联系站方客服申请退货； <br /> 1-1-2
					站方客服收到买方申请后，需要获知买方退货原因，如买方有条件可以提供该商品的照片为退货依据； <br /> 1-1-3
					站方客服经确认属于可退货范围的商品，联系卖方沟通退货事宜，并将具体结果反馈买方； <br />
					1-1-4买方根据客服的指引，将商品发回卖方等待卖方确认货物到达； <br /> 1-1-5
					卖方收到退货商品后，将本次交易产生的金额返还给买方完成退货流程。 <br /> <strong>5</strong><strong>、以下情况不予以办理退换货
					</strong><br /> 1-1 任何非古道金典出售或展示的商品，即古道金典不存在的商品； <br /> 1-2
					任何因买方保管导致出现质量问题的商品； <br /> 1-3 任何影响卖方第二次销售的商品，确实产品自身的问题除外； <br />
					1-4 任何卖方明确在商品描述中提及注明的不退换货的商品； <br /> 1-5
					货物出现破损，但没有在收货时当场要求物流人员退换货的； <br /> 1-6 超过明确注明退换货期限的商品； <br /> 1-7
					如有赠品的商品，赠品不能随商品一并退回的； <br /> 1-8 赠品不享受任何退换货及质保服务； <br /> 1-9
					买方发货单据或发票丢失或信息不全者； <br /> 1-10 商品本人不存在质量问题的； <br /> 1-11
					特别活动注明不退换货的商品不在退换货服务内。 <br /> <strong>6</strong><strong>、其他相关说明
					</strong><br /> 1-1 申请退换货的买方，请于签收商品之日起7日内向古道金典或买方申请，逾期不予以受理； <br /> 1-2
					使用优惠券、经验值或参加特殊活动等优惠购买的商品发生退换货，按买方所支付的实际金额进行比例换算，再进行退换货结算，如原订购的商品缺<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;货，经与买家沟通后按同等价值商品进行调换；
					<br /> 1-3 如果是由于商品质量问题或商品种类与订单不符造成的退换货，物流费用应有卖方承担； <br />
					1-4其他问题可以联系网站客服（电话，QQ，Email）；
				</p>
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