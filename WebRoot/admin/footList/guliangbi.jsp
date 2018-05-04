<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>颐佳官方商城-粮票使用说明</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv=”X-UA-Compatible” content=”IE=edge,chrome=1″ />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="web/css/base.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="web/bootstrap/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
  </head>
  <body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="/admin/common/navigation.jsp" />
<div class="breadThumb">当前位置：首页   &gt; 粮票使用说明</div>    
<div class="helpCnt">
	<h1 class="text-center">颐佳官方商城<br>粮票使用说明</h1>
	<h3>一、相关定义</h3>
	<p><strong>1、粮票：</strong>粮票是颐佳官方商城推出的一项预备金交易业务项目，如果用户在会员中心资金管理中拥有一定的粮票金额，在购买商品或做支付兑米交易时可以直接使用，可以增加业务的处理速度并会有相应的奖励。是用户向站方充值粮票，专项用于在颐佳官方商城的经营活动。，冲入颐佳官方商城的粮票将以“粮票”的形式展示在用户中心的粮票栏目中,
</p>
<p><strong>2、粮票充值：</strong>粮票充值是指，用户通过颐佳官方商城签约的第三方支付平台的网上银行，将自身账户中的资金预存在颐佳官方商城的账户中，此资金的所有权依然为用户。
</p>
<p><strong>3、粮票兑米：</strong>粮票兑米是指，用户通过颐佳官方商城的会员中心资金管理的兑米功能，将用户在网站合法的粮票通过第三方支付平台转入用户自身银行账户。（颐佳官方商城暂不支持此项业务，开通时间另行通知） </p>
<p><strong>4、粮票余额：</strong>粮票余额指，以当前时间为节点来统计用户在颐佳官方商城粮票的剩余可支配的资金额度。</p>
<p><strong>5、可支配粮票：</strong>可支配粮票是指，用户在颐佳官方商城中的粮票资金可以根据用户本意自由的用于支付、兑米、充值、转账等的资金款项。
</p>
<p><strong>6、冻结粮票：</strong>冻结粮票是指，因用户自身原因导致用户涉 嫌违法，站方配合公检法机构采取的使用户粮票余额为不可支配的粮票的强制行为；或用户恶意蓄意破坏站方正常运营，破坏正常的市场秩序等违反了相关规定 及合同的违法或违规行为，站方采取的某一时间段内冻结粮票的强制措施。冻结后的粮票不得兑米，支付，转账。 </p>
<h3>二、粮票操作流程 </h3>
<p><strong>1、粮票充值流程 </strong></p>
<p>1-1 会员在颐佳官方商城中找到粮票充值的按钮点击进入充值页面； </p>
<p>1-2 会员在充值页面中输入本次将要充值的金额并点击确认后进入支付方式选择页面；</p>
<p>1-3 会员在支付方式选择页面中可以选择第三方支付平台支付与银联支付；</p>
<ol>
	<li>1.如会员选择第三方支付平台支付，会进入选择网银界面，选择会员拥有的开通网银的银行即可；</li>
	<li>2.然后进入该银行的支付页面继续完成操作流程直至交易成功。</li>
</ol>
<p><strong>2、粮票兑米流程</strong><small>（暂不开放）</small></p>
<ol>
	<li>1.会员在网站中点击兑米按钮，进入兑米提示页面，仔细阅读提示信息后，再按照提示要求进行相关操作；</li>
	<li>2.会员输入兑米的具体金额后，提交兑米申请；</li>
	<li>3.通过兑米审核后，会员选择网站系统中的任意一方支持兑米的银行，输入相关的银行账户信息并确定；</li>
</ol>
<p>1-4 会员核对上几步的操作无误后，输入相关兑米密码或验证码，等待系统确认；</p>
<p>1-4 会员核对上几步的操作无误后，输入相关兑米密码或验证码，等待系统确认；</p>
<h3>三、粮票规则 </h3>
<p>1、使用网银或第三方支付平台进行线上充值时，须遵守相关的银行或第三方支付平台的使用规定； 
</p><p>2、使用线下银行柜台或ATM设备充值时保留好转账或汇款原始凭证，并拍照或扫描原始凭证，将图片上传至网站。 
</p><p>3、由站方客服人员核对转账或汇款的原始凭证图片，并核实相关款项已到账，系统通知会员粮票充值成功； 
</p><p>4、关于粮票充值及兑米的转账、支付、汇款等手续费以第三方支付平台或站方相关规定计算，相关费用由会员承担；</p>
<h3>四、其他  </h3>
<p>1、本规则自发布之日起生效。</p>
<p>2、本规则的最终解释权归山东颐佳网络科技有限公司享有。</p>
</div> 
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
