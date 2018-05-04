<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv=”X-UA-Compatible” content=”IE=edge,chrome=1″ />
		<meta name="description" content="三古汇" />
		<meta name="keywords" content="三古汇" />
		<meta http-equiv="x-ua-compatible" content="ie=7" />
		<title>用户注册—三古汇官方商城</title>
		<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="css/shophy.css" rel="stylesheet" type="text/css">
		<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
		<script src="js/register.js" type="text/javascript"></script>
		<script type="text/javascript">
$(function() {
	checkMemberBoxCheck();
});
function checkMemberBoxCheck() {
	if ($("#memberCheck").attr("checked") == "checked") {
		$("#MemberButtonOk").attr("disabled", false);
	} else {
		$("#MemberButtonOk").attr("disabled", true);

	}
}
function checkCompanyBoxCheck() {
	if ($("#companyCheck").attr("checked") == "checked") {
		$("#CompanyButtonOk").attr("disabled", false);
	} else {
		$("#CompanyButtonOk").attr("disabled", true);

	}
}
// 用户注册操作
function toMemberRegist() {
	location.href = "toMemberRegister.html";
}
function toCompanyRegist(){
	location.href = "toCompanyRegister.html";
}
</script>
	</head>
<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<!-- 导航 -->
<jsp:include page="../common/navigation.jsp"></jsp:include>
  <!-- 导航结束 -->
  <div class="breadThumb">当前位置：首页 &gt; 注册</div>
     <div class="btn-group btn-group-lg register-select"  id="notice">
   	<!--  <button type="button" class="btn btn-default selected"><i class="iconfont">&#xf00ec;</i> 个人会员</button>-->
   	<!--  <button type="button" class="btn btn-default"><i class="iconfont">&#xf00e4;</i> 企业会员</button>  -->
   </div> 
   
<div class="hyzcmain">
	<div class="notice_Content">
		<div class="hyfore1"></div>
		<p class="hyxzbt">三古汇用户服务协议</p>
		<div class="hyhdxznr">
			<div class="xyxznr">
			<p class="MsoNormal" align="center" style="text-align:center;">

<div class=WordSection1 style='layout-grid:15.6pt'>

<p class=MsoNormal align=center style='text-align:center;line-height:150%'><b><span
style='font-size:14px;line-height:150%;font-family:宋体;mso-bidi-font-family:
宋体'>【三古汇<span lang=EN-US>.</span>云生活】服务协议<span lang=EN-US></span></span></b></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>当您加入和使用【三古汇<span
lang=EN-US>.</span>云生活】表明您已经阅读并同意本使用条款，您的会员活动会遵从本使用条款。鉴于【三古汇<span lang=EN-US>.</span>云生活】并非是关乎国计民生或者垄断的行业及企业，因此您对本使用协议不认同的，完全可以选择不加入和使用【三古汇<span
lang=EN-US>.</span>云生活】。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>本协议由您与山东三古汇网络科技有限公司共同缔结，具有合同效力。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>本协议中协议双方合称协议方，山东三古汇网络科技有限公司在协议中亦称为“【三古汇<span
lang=EN-US>.</span>云生活】”，是一家在山东济南市历下区解放路<span lang=EN-US>16</span>号黄金大厦九层办公的提供购物返米<a
name="_GoBack"></a>、促销信息、活动导购、广告等服务的公司，域名为<span lang=EN-US>www.sanguhuivip.com</span>。<span
lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><b><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>一、协议内容及签署</span></b><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>1</span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>、本协议内容包括协议正文及所有【三古汇<span
lang=EN-US>.</span>云生活】已经发布的或将来可能发布的各类规则。所有规则为本协议不可分割的组成部分，与协议正文具有同等法律效力。除另行明确声明外，任何【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司提供的服务均受本协议约束。但法律法规另有强制性规定的，依其规定。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>2</span>、您在注册【三古汇<span
lang=EN-US>.</span>云生活】账户时点击提交“我已阅读并且同意【三古汇<span lang=EN-US>.</span>云生活】的使用协议”即视为您接受本协议及各类规则，并同意受其约束。您应当在使用【三古汇<span
lang=EN-US>.</span>云生活】服务之前认真阅读全部协议内容并确保完全理解协议内容，如您对协议有任何疑问的，应向【三古汇<span
lang=EN-US>.</span>云生活】咨询。但无论您事实上是否在使用【三古汇<span lang=EN-US>.</span>云生活】服务之前认真阅读了本协议内容，只要您注册、<a
name=或者正在使用>正在或者继续使用</a>【三古汇<span lang=EN-US>.</span>云生活】服务，则视为接受本协议。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>3</span>、您承诺接受并遵守本协议的约定。如果您不同意本协议的约定，您应立即停止注册程序或停止使用【三古汇<span
lang=EN-US>.</span>云生活】服务。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>4</span>、【三古汇<span
lang=EN-US>.</span>云生活】有权根据需要不时地制订、修改本协议或各类规则，并以网站公示的方式进行公告。变更后的协议和规则一经在网站公布后，立即自动生效。【三古汇<span
lang=EN-US>.</span>云生活】的最新的协议和规则以及网站公告可供您随时登陆查阅，您也应当经常性的登陆查阅最新的协议和规则以及网站公告以了解【三古汇<span
lang=EN-US>.</span>云生活】最新动态。如您不同意相关变更，应当立即停止使用【三古汇<span lang=EN-US>.</span>云生活】服务。您继续使用服务的，即表示您接受经修订的协议和规则。本协议和规则（及其各自的不时修订）条款具有可分割性，任一条款被视为违法、无效、被撤销、变更或因任何理由不可执行，并不影响其他条款的合法性、有效性和可执行性。<span
lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><b><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>二、会员及账户管理</span></b><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>1</span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>、申请资格<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>您应当是具备完全民事权利能力和完全民事行为能力的自然人、法人或其他组织。若您不具备前述主体资格，则您及您的监护人应承担因此而导致的一切后果，且【三古汇<span
lang=EN-US>.</span>云生活】有权注销（永久冻结）您的【三古汇<span lang=EN-US>.</span>云生活】账户，并向您及您的监护人索偿或者追偿。若您不具备前述主体资格，则需要监护人同意您，方可注册成为【三古汇<span
lang=EN-US>.</span>云生活】会员，否则您和您的监护人应承担因此而导致的一切后果，且【三古汇<span lang=EN-US>.</span>云生活】有权注销（永久冻结）您的【三古汇<span
lang=EN-US>.</span>云生活】账户，并向您及您的监护人索偿或者追偿。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>【三古汇<span
lang=EN-US>.</span>云生活】并无能力对您的民事权利能力和民事行为能力进行实质性审查，因此一旦您进行了注册，【三古汇<span
lang=EN-US>.</span>云生活】可以视为您具备完全民事权利能力和完全民事行为能力。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>2</span>、账户<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>在您签署本协议，完成会员注册程序或以其他【三古汇<span
lang=EN-US>.</span>云生活】允许的方式实际使用【三古汇<span lang=EN-US>.</span>云生活】服务时，【三古汇<span
lang=EN-US>.</span>云生活】会向您提供唯一编号的【三古汇<span lang=EN-US>.</span>云生活】账户（以下亦称账户）。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>您可以对账户设置会员名和密码，通过该会员名密码或与该会员名密码关联的其它用户名密码登陆【三古汇<span
lang=EN-US>.</span>云生活】平台。您设置的会员名不得侵犯或涉嫌侵犯他人合法权益。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>您应对您的账户（会员名）和密码的安全，以及对通过您的账户（会员名）和密码实施的行为负责。除非经过正当法律程序，且征得【三古汇<span
lang=EN-US>.</span>云生活】的同意，否则，账户（会员名）和密码不得以任何方式转让、赠与或继承。如果发现任何人不当使用您的账户或有任何其他可能危及您的账户安全的情形时，您应当立即以有效方式通知【三古汇<span
lang=EN-US>.</span>云生活】，要求【三古汇<span lang=EN-US>.</span>云生活】暂停相关服务。您理解【三古汇<span
lang=EN-US>.</span>云生活】对您的请求采取行动需要合理时间，【三古汇<span lang=EN-US>.</span>云生活】对在采取行动前已经产生的后果（包括但不限于您的任何损失）不承担任何责任，但【三古汇<span
lang=EN-US>.</span>云生活】未能在合理时间内采取行动的情况除外。您认可您在注册、使用【三古汇<span lang=EN-US>.</span>云生活】服务过程中提供、形成的数据等相关信息的所有权及其他相关权利属于【三古汇<span
lang=EN-US>.</span>云生活】，【三古汇<span lang=EN-US>.</span>云生活】有权使用上述信息。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span><b><span
style='mso-spacerun:yes'>&nbsp;</span>3</b></span><b>、会员</b><span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>在您按照注册页面提示填写信息、阅读并同意本协议并完成全部注册程序后或以其他【三古汇<span lang=EN-US>.</span>云生活】允许的方式实际使用【三古汇<span
lang=EN-US>.</span>云生活】服务时，您即成为【三古汇<span lang=EN-US>.</span>云生活】会员。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>在注册时，您应当按照法律法规要求，或注册页面的提示准确提供，并及时更新您的资料，以使之真实、及时，完整和准确。如有合理理由怀疑您提供的资料错误、不实、过时或不完整的，【三古汇<span
lang=EN-US>.</span>云生活】有权向您发出询问或要求改正的通知，若您未能在【三古汇<span lang=EN-US>.</span>云生活】要求的合理期限内回复【三古汇<span
lang=EN-US>.</span>云生活】的询问及或完成改正，【三古汇<span lang=EN-US>.</span>云生活】有权做出删除相应资料并暂时停止账户的处理，直至终止对您提供部分或全部【三古汇<span
lang=EN-US>.</span>云生活】服务，【三古汇<span lang=EN-US>.</span>云生活】对此不承担任何责任，您将承担因此产生的任何成本或支出。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>您应当准确填写并及时更新您提供的电子邮件地址、联系电话、联系地址、邮政编码等联系方式，以便【三古汇<span
lang=EN-US>.</span>云生活】或其他会员与您进行有效联系，因通过这些联系方式无法与您取得联系，导致您在使用【三古汇<span
lang=EN-US>.</span>云生活】服务过程中产生任何损失或增加费用的，应由您完全独自承担，【三古汇<span lang=EN-US>.</span>云生活】对此不予承担。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>您在使用【三古汇<span lang=EN-US>.</span>云生活】服务过程中，所产生的应纳税费，以及一切硬件、软件、服务、账户维持及其它方面的费用，均由您独自承担。您同意【三古汇<span
lang=EN-US>.</span>云生活】有权从您相关账户中优先扣除上述费用。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>对于被【三古汇<span
lang=EN-US>.</span>云生活】账户冻结或者暂时停止帐户的会员，【三古汇<span lang=EN-US>.</span>云生活】将不再提供会员连锁项目下的服务。<span
lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><b><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>三、【三古汇<span
lang=EN-US>.</span>云生活】服务（详情见《三古汇商城会员代言制度》）：</span></b><span lang=EN-US
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>&nbsp;</span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp; </span>1</span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>、普通会员<span
lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp; </span></span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>通过各个渠道（如：他人分享、网络检索、推送消息、地面活动等）了解到【三古汇<span
lang=EN-US>.</span>云生活】，进入注册页面免费注册，注册信息需认真填写，姓名、联系方式、支付宝帐号确保真实有效。注册成功即送<span
lang=EN-US>2000</span>经验值，消费即可享受消费返米。<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp; </span></span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>【三古汇<span
lang=EN-US>.</span>云生活】会员（以下简称会员）可以通过注册、邀请、参加【三古汇<span lang=EN-US>.</span>云生活】及其合作组织所举行的各种活动获得经验值。<span
lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>普通会员任何情况下在【三古汇<span
lang=EN-US>.</span>云生活】消费均可享受消费返米，返米时间起止以商品信息为准。<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp; </span>2</span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>、<span
lang=EN-US> VIP</span>会员<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp; </span></span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>普通会员一次性在【三古汇<span
lang=EN-US>.</span>云生活】消费满<span lang=EN-US>998</span>元，自动升级为<span lang=EN-US>VIP</span>会员。<span
lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp; </span></span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>直接购买【三古汇<span
lang=EN-US>.</span>云生活】自营产品【古粮今典】<span lang=EN-US>998</span>元的家庭装或礼盒装一次性累计达到<span
lang=EN-US>998</span>元，自动升级<span lang=EN-US>VIP</span>会员。<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp;&nbsp;</span>3</span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>、商城会员代言制度<span
lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>【三古汇<span
lang=EN-US>.</span>云生】会员（<span lang=EN-US>VIP</span>），都可以相应获得三级代言津贴（邀请免费会员注册即可获得三级经验值奖励，引导会员消费即可获得商品价值<span
lang=EN-US>10%</span>的代言津贴）；<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>代言津贴比例为<span
lang=EN-US>10%+10%+10%</span>，即：每邀请一个免费会员即可获得<span lang=EN-US>200</span>经验值，每邀请一个<span
lang=EN-US>VIP</span>会员或引导普通会员在“特惠专区”（其他专区不予返米和代言津贴）消费即可获得商品价值<span lang=EN-US>10%</span>的代言津贴“金米”，下级再邀请也可以等额获得商品价值<span
lang=EN-US>10%</span>的代言津贴“金米”，可以享受三级；<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-spacerun:yes'>&nbsp; </span><span
style='color:red'><span style='mso-spacerun:yes'>&nbsp;</span></span></span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体;color:#0D0D0D;
mso-themecolor:text1;mso-themetint:242'>电子货币（经验值、惠米、金米）消费的不计入消费奖励，特卖品和汇筹专区不计入消费奖励。<span
lang=EN-US><br>
</span></span><span lang=EN-US style='font-size:12px;font-family:宋体;
mso-bidi-font-family:宋体'><span style='mso-spacerun:yes'>&nbsp; </span><span
style='mso-spacerun:yes'>&nbsp;&nbsp;</span>4</span><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>、电子虚拟货币是会员通过注册、邀请、消费、参与、点击【三古汇<span
lang=EN-US>.</span>云生活】及其合作组织举办的各种活动及其设置的相应链接、页面获得的一种权利，可以用来折抵、消费、兑现。【三古汇<span
lang=EN-US>.</span>云生活】的电子虚拟货币仅适用于【三古汇<span lang=EN-US>.</span>云生活】及其合作组织举办的各种活动，并不构成会员任何形式的资产。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>5</span>、会员应当获得的电子虚拟货币由【三古汇<span
lang=EN-US>.</span>云生活】根据相应活动规则计入会员在【三古汇<span lang=EN-US>.</span>云生活】之账户中。电子虚拟货币获得的规则由各项具体活动详细规定，请您密切注意网站各具体活动的页面。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>6</span>、会员除在【三古汇<span
lang=EN-US>.</span>云生活】指定的专区或者平台上进行相关奖励的交易涉及到电子虚拟货币的流转外，电子虚拟货币不能以买卖、赠与等其他任何形式转让予他人（代理商的古粮劵除外）。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>7</span>、会员电子虚拟货币中的金米部分在符合【三古汇<span
lang=EN-US>.</span>云生活】及其合作组织举办的具体活动之规则的情况下可以申请【三古汇<span lang=EN-US>.</span>云生活】进行兑现，正常情况下，【三古汇<span
lang=EN-US>.</span>云生活】收到申请后<span lang=EN-US>5</span>个工作日内完成汇款工作（遇到节假日情况顺延）。【三古汇<span
lang=EN-US>.</span>云生活】提供银联或支付宝转账等方式进行兑现。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>8</span>、【三古汇<span
lang=EN-US>.</span>云生活】经验值可以参与抽奖，还可以在特惠专区购买商品时折抵现金使用。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>正常情况下，【三古汇<span
lang=EN-US>.</span>云生活】将在<span lang=EN-US>3</span>个工作日内发货。（遇到节假日情况顺延）<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>9</span>、通过【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司或合作组织提供的【三古汇<span lang=EN-US>.</span>云生活】服务和其它服务，会员可在业务规则允许范围内在【三古汇<span
lang=EN-US>.</span>云生活】上发布交易信息、查询商品和服务信息、达成交易意向并进行网站内部交易、对其他会员进行评价、参加【三古汇<span
lang=EN-US>.</span>云生活】组织的活动以及使用其它信息服务及技术服务。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>8</span>、您在【三古汇<span
lang=EN-US>.</span>云生活】的交易过程中与其他会员发生交易纠纷时，一旦您或其它会员任一方或双方共同提交【三古汇<span
lang=EN-US>.</span>云生活】要求协调处理，则【三古汇<span lang=EN-US>.</span>云生活】有权根据单方判断做出协调处理决定，您了解并同意接受返利网的判断和调处决定。该决定将对您的纠纷具有约束力。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>9</span>、您了解并同意，【三古汇<span
lang=EN-US>.</span>云生活】有权应政府部门（包括司法及行政部门）的正当合法的要求，向其提供您在【三古汇<span lang=EN-US>.</span>云生活】填写的注册信息和交易纪录等必要信息。如您涉嫌侵犯他人知识产权或者其他合法权益，则【三古汇<span
lang=EN-US>.</span>云生活】亦有权在初步判断涉嫌侵权等违法行为存在的情况下，向权利人提供您必要的身份信息。除非法律法规或相关政府部门另有要求，【三古汇<span
lang=EN-US>.</span>云生活】将在前述信息披露情况发生后及时向您发出书面通知。<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='margin-left:0cm;text-indent:0cm;line-height:20.0pt;
mso-line-height-rule:exactly;mso-list:l0 level1 lfo1'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><span
style='mso-list:Ignore'>四、</span></span><b><span style='font-size:
12px;font-family:宋体;mso-bidi-font-family:宋体'>【三古汇<span lang=EN-US>.</span>云生活】服务使用规范及处理规定</span></b><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span><span style='font-size:12px;font-family:宋体;mso-bidi-font-family:
宋体'>在使用【三古汇<span lang=EN-US>.</span>云生活】服务过程中，您承诺遵守下列使用规范：<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>1</span>、会员承诺其注册信息的正确性。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>2</span>、如果会员提供给【三古汇<span lang=EN-US>.</span>云生活】的资料有变更，请及时通知【三古汇<span
lang=EN-US>.</span>云生活】做出相应的修改。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>3</span>、会员不得出现恶意注册恶意点击等行为。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>4</span>、会员应及时使用自己的【三古汇<span lang=EN-US>.</span>云生活】账户中的经验值和惠米。经验值和惠米有效期为<span
lang=EN-US>25</span>个月，从会员获得的经验值和惠米进入会员的【三古汇<span lang=EN-US>.</span>云生活】帐户开始起算。超过有效期仍未及时使用的，则此部分过期经验值和惠米将逾期失效并作归零处理。经验值和惠米有效期到期之日一个月前，【三古汇<span
lang=EN-US>.</span>云生活】将会通过会员登记注册的联系方式提前一个月通知会员尽快使用即将到期的经验值和惠米。经验值和惠米有效期到期后，【三古汇<span
lang=EN-US>.</span>云生活】仍然给予会员<span lang=EN-US>1</span>个月的宽限期，在此宽限期内会员可申请使用已经到期之经验值和惠米。宽限期届满仍未使用的，此部分过期经验值和惠米将正式逾期失效并作归零处理。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;</span><span
style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;</span>5</span>、【三古汇<span
lang=EN-US>.</span>云生活】会员帐户如果一年内无登陆记录，将被视为休眠账户作冻结处理。会员账户自冻结第二个月开始，【三古汇<span
lang=EN-US>.</span>云生活】保留在每月<span lang=EN-US>1</span>日自动扣除已经超出有效期的经验值和惠米部分的权利。会员可向【三古汇<span
lang=EN-US>.</span>云生活】申请账号解冻，收到解冻申请后【三古汇<span lang=EN-US>.</span>云生活】可以为用户解冻账号，但是已经扣除的经验值和惠米不能恢复。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>6</span>、超过两年无登陆记录，【三古汇<span
lang=EN-US>.</span>云生活】保留注销该帐户的权利。注销后该账户内所有经验值和惠米自动清零且不予恢复。此时【三古汇<span
lang=EN-US>.</span>云生活】不接受会员申请解冻或找回账户，相应的会员名将开放给任意用户注册登记使用。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>7</span>、在使用【三古汇<span
lang=EN-US>.</span>云生活】服务过程中实施的所有行为均遵守国家法律、法规等规范性文件及【三古汇<span lang=EN-US>.</span>云生活】各项规则的规定和要求，不违背社会公共利益或公共道德，不损害他人的合法权益，不违反本协议及相关规则。您如果违反前述承诺，产生任何法律后果的，您应自己独自承担所有的法律责任，并确保【三古汇<span
lang=EN-US>.</span>云生活】免于因此产生任何损失。如【三古汇<span lang=EN-US>.</span>云生活】因此承担相应责任或者赔偿相关损失，则您承诺【三古汇<span
lang=EN-US>.</span>云生活】可以向您追偿，相关责任或损失由您最终承担。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>8</span>、在与其他会员分享、交易过程中，遵守诚实信用原则，不采取不正当竞争行为，不扰乱网上交易的正常秩序，不从事与网上交易无关的行为。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>9</span>、不以虚构或歪曲事实的方式不当评价其他会员，不采取不正当方式制造或提高自身的信用度，不采取不正当方式制造或提高（降低）其他会员的信用度。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>10</span>、不对【三古汇<span
lang=EN-US>.</span>云生活】平台上的任何数据作商业性利用，包括但不限于在未经【三古汇<span lang=EN-US>.</span>云生活】事先书面同意的情况下，以复制、传播等任何方式使用【三古汇<span
lang=EN-US>.</span>云生活】网站上展示的资料。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>11</span>、【三古汇<span
lang=EN-US>.</span>云生活】严禁会员通过以下行为获得利益，一经发现，【三古汇<span lang=EN-US>.</span>云生活】有权追回已经给予的相关电子虚拟货币和已经兑换的商品，并视情节严重可中止会员账号直至注销会员账号，同时该会员必须承担由此给【三古汇<span
lang=EN-US>.</span>云生活】带来的所有损失：<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>a)</span>购买产品后恶意取消订单；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>b)</span>劫持流量；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>c)</span>自买自卖；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>d)</span>劫持其他用户的正常访问链接使其变成推广链接；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>e)</span>骗取其他用户点击其设置的非【三古汇<span
lang=EN-US>.</span>云生活】设置的链接；<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>f)</span>违反购物所在网站用户协议及其规则；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>g)</span>其他违反法律法规或者违反诚实信用、公平原则的行为。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>12</span>、【三古汇<span
lang=EN-US>.</span>云生活】严禁各种针对【三古汇<span lang=EN-US>.</span>云生活】活<span
lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>动的作弊行为。对于查实的作弊行为，我们将收回该账号全部的代言津贴、取消代言资格，扣除一定的电子虚拟货币，并列入【三古汇<span
lang=EN-US>.</span>云生活】黑名单账户。作弊行为包括但不限于：使用相同的电脑、相同的<span lang=EN-US>IP</span>地址在同一天内注册多个账号，以骗取代言津贴的行为；以注册送钱或注册送经验值等利益诱导用户来注册【三古汇<span
lang=EN-US>.</span>云生活】获取奖励的行为等。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>13</span>、【三古汇<span
lang=EN-US>.</span>云生活】禁止会员在【三古汇<span lang=EN-US>.</span>云生活】的合作商城内进行任何形式的推广。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>14</span>、您不得使用任何装置、软件或例行程序干预或试图干预【三古汇<span
lang=EN-US>.</span>云生活】平台的正常运作或正在【三古汇<span lang=EN-US>.</span>云生活】上进行的任何交易、活动。您不得采取任何将导致不合理的庞大数据负载加诸【三古汇<span
lang=EN-US>.</span>云生活】网络设备的行动，否则【三古汇<span lang=EN-US>.</span>云生活】将追究您的相关责任，包括但不限于取消相关积分、收回相关分享奖励、取消分享资格、列入【三古汇<span
lang=EN-US>.</span>云生活】黑名单账户、冻结账户或者注销账户等。如造成【三古汇<span lang=EN-US>.</span>云生活】损失或者承担相应法律责任的，【三古汇<span
lang=EN-US>.</span>云生活】有权要求您赔偿并最终承担相应的责任。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>您了解并同意【三古汇<span
lang=EN-US>.</span>云生活】有权作如下处理：<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>1</span>、【三古汇<span
lang=EN-US>.</span>云生活】有权对您是否违反上述承诺做出单方认定，并根据单方认定结果适用规则予以处理，这无须征得您的同意。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>2</span>、经国家行政或司法机关的生效法律文书确认您存在违法或侵权行为，或者【三古汇<span
lang=EN-US>.</span>云生活】根据自身的判断，认为您的行为涉嫌违反本协议和<span lang=EN-US>/</span>或规则的条款或涉嫌违反法律法规规定的，则【三古汇<span
lang=EN-US>.</span>云生活】有权在【三古汇<span lang=EN-US>.</span>云生活】上公示您的该等涉嫌违法或违约行为及【三古汇<span
lang=EN-US>.</span>云生活】已对您采取的措施。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>3</span>、对于您在【三古汇<span
lang=EN-US>.</span>云生活】上发布的涉嫌违法或涉嫌侵犯他人合法权利或违反本协议或规则的信息，【三古汇<span lang=EN-US>.</span>云生活】有权予以删除，且按照规则的规定进行处罚。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>4</span>、对于您在【三古汇<span
lang=EN-US>.</span>云生活】上实施的行为，包括您未在【三古汇<span lang=EN-US>.</span>云生活】上实施但已经对【三古汇<span
lang=EN-US>.</span>云生活】及其用户产生影响的行为，【三古汇<span lang=EN-US>.</span>云生活】有权单方认定您行为的性质及是否构成对本协议或规则的违反，并据此作出相应处罚。您应自行保存与您行为有关的全部证据，并应对无法提供充要证据而承担的不利后果。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>5</span>、对于您涉嫌违反承诺的行为对任意第三方造成损害的，您均应当以自己的名义独立承担所有的法律责任，并应确保【三古汇<span
lang=EN-US>.</span>云生活】免于因此产生损失或增加费用。如【三古汇<span lang=EN-US>.</span>云生活】因此承担相应责任或者赔偿相关损失，则您承诺【三古汇<span
lang=EN-US>.</span>云生活】可以向您追偿，相关责任或损失由您最终承担，相关损失包括合理的律师费用、相关机构的调查费用等。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>6</span>、如您涉嫌违反有关法律或者本协议之规定，使【三古汇<span
lang=EN-US>.</span>云生活】遭受任何损失，或受到任何第三方的索赔，或受到任何行政管理部门的处罚，您应当赔偿【三古汇<span
lang=EN-US>.</span>云生活】因此造成的损失及（或）发生的费用，包括合理的律师费用、相关机构的调查费用等。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>7</span>、【三古汇<span
lang=EN-US>.</span>云生活】上展示的资料（包括但不限于文字、图表、标识、图像、数字下载和数据编辑）均为【三古汇<span
lang=EN-US>.</span>云生活】或其内容提供者的财产或者权利；【三古汇<span lang=EN-US>.</span>云生活】上所有内容的汇编是属于【三古汇<span
lang=EN-US>.</span>云生活】的著作权；【三古汇<span lang=EN-US>.</span>云生活】上所有软件都是【三古汇<span
lang=EN-US>.</span>云生活】或其关联公司或其软件供应商的财产或者权利，上述知识产权均受法律保护。如您侵犯上述权利，【三古汇<span
lang=EN-US>.</span>云生活】有权根据规则对您进行处理并追究您的法律责任。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>8</span>、【三古汇<span
lang=EN-US>.</span>云生活】并无能力对您的相关注册、登记资料进行实质性审查，因此一旦因您的的注册、登记资料的问题导致的相关后果应全部由您自己承担，【三古汇<span
lang=EN-US>.</span>云生活】对此不承担责任。如果根据法律法规要求【三古汇<span lang=EN-US>.</span>云生活】先行承担了相关责任，那么您承诺【三古汇<span
lang=EN-US>.</span>云生活】有权向您追偿，由您最终承担上述责任。<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>五、特别授权<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span>您完全理解并不可撤销地授予【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司下列权利：<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>1</span>、一旦您向【三古汇<span
lang=EN-US>.</span>云生活】或其关联公司或其合作组织作出任何形式的承诺，且相关公司或组织已确认您违反了该承诺，则【三古汇<span
lang=EN-US>.</span>云生活】有权立即按您的承诺或协议约定的方式对您的账户采取限制措施，包括中止或终止向您提供服务，并公示相关公司确认您的违约情况。您了解并同意，除非法律法规另有明确要求，【三古汇<span
lang=EN-US>.</span>云生活】无须就相关确认与您核对事实，或另行征得您的同意，且【三古汇<span lang=EN-US>.</span>云生活】无须就此限制措施或公示行为向您承担任何的责任。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>2</span>、一旦您违反本协议，或与【三古汇<span
lang=EN-US>.</span>云生活】签订的其他协议的约定，【三古汇<span lang=EN-US>.</span>云生活】有权以任何方式通知【三古汇<span
lang=EN-US>.</span>云生活】关联公司或其合作组织，要求其对您的权益采取限制措施，包括但不限于要求【三古汇<span lang=EN-US>.</span>云生活】将您账户内的电子虚拟货币支付给【三古汇<span
lang=EN-US>.</span>云生活】指定的对象，要求关联公司中止、终止对您提供部分或全部服务，且在其经营或实际控制的任何网站公示您的违约情况。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>3</span>、对于您在注册、登记或者交易中记录的资料及数据信息，您授予【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司或其合作组织独家的、永久的、免费的全球范围内使用并许可他人使用的权利。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>4</span>、【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司有权受理您与其他会员因交易产生的争议，并有权单方判断与该争议相关的事实及应适用的规则，进而作出处理决定。该处理决定对您有约束力。如您未在限期内执行处理决定的，则【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司有权利（但无义务）直接处分您【三古汇<span lang=EN-US>.</span>云生活】账户内的电子虚拟货币。如该争议造成【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司损失的，您应及时弥补【三古汇<span lang=EN-US>.</span>云生活】及其关联公司的损失，否则【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司有权直接抵减您在合同项下和账户中的权益，并有权继续追偿。<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>六、责任范围和责任限制<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>1</span>、【三古汇<span
lang=EN-US>.</span>云生活】负责按<span lang=EN-US>&quot;</span>现状<span lang=EN-US>&quot;</span>和<span
lang=EN-US>&quot;</span>可得到<span lang=EN-US>&quot;</span>的状态向您提供服务，且【三古汇<span
lang=EN-US>.</span>云生活】仅对自身提供的服务承担责任。【三古汇<span lang=EN-US>.</span>云生活】对于第三方向会员提供的服务和产品不提供保证也不承担任何责任，但应当协助会员和第三方进行交涉谈判以维护会员合法权益。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>2</span>、您了解【三古汇<span
lang=EN-US>.</span>云生活】上的信息系第三方或者其他会员自行发布，且可能存在风险和瑕疵。【三古汇<span lang=EN-US>.</span>云生活】仅作为交易地点。【三古汇<span
lang=EN-US>.</span>云生活】仅作为您获取物品或服务信息、物色交易对象、就物品或服务的交易进行协商及开展交易的场所，但【三古汇<span
lang=EN-US>.</span>云生活】无法控制交易所涉及的物品质量、安全或合法性，商贸信息的真实性或准确性，以及交易各方履行其在贸易协议中各项义务的能力。您应自行谨慎判断确定相关物品或信息的真实性、合法性和有效性，并自行承担相关风险。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>3</span>、【三古汇<span
lang=EN-US>.</span>云生活】上的商品价格、数量、是否有货等商品信息随时有可能发生变动，【三古汇<span lang=EN-US>.</span>云生活】不就此作出特别通知。您知悉并理解由于网站上商品信息数量极其庞大，虽然【三古汇<span
lang=EN-US>.</span>云生活】会尽合理的最大努力保证您所浏览的商品信息的准确性、迅捷性，但由于众所周知的互联网技术因素等客观原因，【三古汇<span
lang=EN-US>.</span>云生活】显示的信息可能存在一定的滞后性和差错，由此给您带来的不便或产生相应问题，【三古汇<span
lang=EN-US>.</span>云生活】不承担责任。<span lang=EN-US>&nbsp;<br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>4</span>、除非法律法规明确要求，或出现以下情况，否则，【三古汇<span
lang=EN-US>.</span>云生活】没有义务对所有用户的注册数据、商品（服务）信息、交易行为以及与交易有关的其它事项进行事先审查：<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>a)</span>【三古汇<span
lang=EN-US>.</span>云生活】有合理的理由认为特定会员及具体交易事项可能存在重大违法或违约情形。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>b)</span>【三古汇<span
lang=EN-US>.</span>云生活】有合理的理由认为用户在【三古汇<span lang=EN-US>.</span>云生活】的行为涉嫌违法或不当。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>5</span>、您理解并同意，【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司并非司法机构，仅能以普通人的身份对证据进行鉴别，【三古汇<span lang=EN-US>.</span>云生活】及其关联公司对争议的调处完全是基于您的委托，【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司无法保证争议处理结果符合您的期望，也不对争议调处结论承担任何责任。如您因此遭受损失，您同意自行通过法律途径向受益人或者其他相关人员索偿。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>6</span>、您了解并同意，【三古汇<span
lang=EN-US>.</span>云生活】不对因下述任一情况而导致您的任何损害赔偿承担责任，包括但不限于利润、商誉、使用、数据等方面的损失或其它无形损失的损害赔偿<span
lang=EN-US> (</span>无论【三古汇<span lang=EN-US>.</span>云生活】是否已被告知该等损害赔偿的可能性<span
lang=EN-US>)</span>：<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>a)</span>第三方未经批准的使用您的账户或更改您的数据。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>b)</span>通过【三古汇<span
lang=EN-US>.</span>云生活】服务购买或获取任何商品、样品、数据、信息或进行交易等行为或替代行为产生的费用及损失，但因【三古汇<span
lang=EN-US>.</span>云生活】提供的服务信息错误所导致的除外。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>c)</span>您对【三古汇<span
lang=EN-US>.</span>云生活】服务的误解。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>d)</span>任何非因【三古汇<span
lang=EN-US>.</span>云生活】的原因而引起的与【三古汇<span lang=EN-US>.</span>云生活】服务有关的其它损失。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>7</span>、因使用【三古汇<span
lang=EN-US>.</span>云生活】服务而引起的任何损害或经济损失，【三古汇<span lang=EN-US>.</span>云生活】承担的全部责任均不超过您通过【三古汇<span
lang=EN-US>.</span>云生活】所购买的或与该索赔有关的服务或商品的价格。本责任限制条款在会员资格被冻结、暂停或注销后仍继续有效。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>8</span>、不论在何种情况下，【三古汇<span
lang=EN-US>.</span>云生活】均不对由于罢工、暴乱、起义、骚乱、火灾、洪水、风暴、爆炸、战争、政府行为、司法行政机关的命令，以及其它非因返利网的原因而造成的不能服务或延迟服务承担责任。【三古汇<span
lang=EN-US>.</span>云生活】会尽合理努力处理善后事宜。<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>七、协议终止<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>1</span>、您同意，【三古汇<span
lang=EN-US>.</span>云生活】有权依据本协议决定中止、终止向您提供部分或全部【三古汇<span lang=EN-US>.</span>云生活】平台服务，暂时冻结或永久冻结（注销）您的账户，且无须为此向您或任何第三方承担任何责任，但本协议或法律法规另有明确要求的除外。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>2</span>、出现以下情况时，返利网有权直接以注销账户的方式终止本协议：<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>a)</span>会员超过两年无登陆记录；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>b)</span>【三古汇<span
lang=EN-US>.</span>云生活】终止向您提供服务后，您涉嫌再一次直接或间接或以他人名义注册为【三古汇<span lang=EN-US>.</span>云生活】用户的；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>c)</span>您提供的电子邮箱不存在或无法接收电子邮件，且没有其他方式可以与您进行联系，或【三古汇<span
lang=EN-US>.</span>云生活】以其它联系方式通知您更改电子邮件信息，而您在【三古汇<span lang=EN-US>.</span>云生活】通知后七个工作日内仍未更改为有效的电子邮箱的；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>d)</span>您注册信息中的主要内容不真实或不准确或不及时或不完整；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>e)</span>本协议（含规则）变更时，您明示并通知【三古汇<span
lang=EN-US>.</span>云生活】不愿接受新的服务协议的；<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>f)</span>其它【三古汇<span
lang=EN-US>.</span>云生活】认为应当终止服务的情况。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>3</span>、您有权向【三古汇<span
lang=EN-US>.</span>云生活】要求注销您的账户，经【三古汇<span lang=EN-US>.</span>云生活】审核同意的，【三古汇<span
lang=EN-US>.</span>云生活】注销（永久冻结）您的账户，届时，您与【三古汇<span lang=EN-US>.</span>云生活】基于本协议的合同关系即终止。您的账户被注销（永久冻结）后，【三古汇<span
lang=EN-US>.</span>云生活】没有义务为您保留或向您披露您账户中的任何信息，也没有义务向您或第三方转发任何您未曾阅读或发送过的信息。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>4</span>、您同意，您与【三古汇<span
lang=EN-US>.</span>云生活】的合同关系终止后，【三古汇<span lang=EN-US>.</span>云生活】及其关联公司或者其合作组织仍享有下列权利<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>a)</span>继续保存并使用您的注册、登记信息、数据及您使用【三古汇<span
lang=EN-US>.</span>云生活】服务期间的所有交易数据。<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>b)</span>您在使用【三古汇<span
lang=EN-US>.</span>云生活】服务期间存在违法行为或违反本协议或规则的行为的，【三古汇<span lang=EN-US>.</span>云生活】仍可依据本协议向您主张权利。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>5</span>、【三古汇<span
lang=EN-US>.</span>云生活】中止或终止向您提供服务后，对于您在服务中止或终止之前的交易行为依下列原则处理，您应独立处理并完全承担进行以下处理所产生的任何争议、损失或增加的任何费用，并应确保【三古汇<span
lang=EN-US>.</span>云生活】免于因此产生任何损失或承担任何费用：<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>a)</span>您在服务中止或终止之前已经上传至【三古汇<span
lang=EN-US>.</span>云生活】的物品尚未交易的，【三古汇<span lang=EN-US>.</span>云生活】有权在中止或终止服务的同时删除此项物品的相关信息；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>b)</span>您在服务中止或终止之前已经与其他会员达成买卖合同，但合同尚未实际履行的，【三古汇<span
lang=EN-US>.</span>云生活】有权删除该买卖合同及其交易物品的相关信息；<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>c)</span>您在服务中止或终止之前已经与其他会员达成买卖合同且已部分履行的，【三古汇<span
lang=EN-US>.</span>云生活】可以不删除该项交易，但【三古汇<span lang=EN-US>.</span>云生活】有权在中止或终止服务的同时将相关情形通知您的交易对方。<span
lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>八、隐私权政策<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>1</span>、【三古汇<span
lang=EN-US>.</span>云生活】对希望成为会员的用户没有任何限制，但<span lang=EN-US>18</span>岁以下的用户使用【三古汇<span
lang=EN-US>.</span>云生活】服务必须取得监护人的同意；<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>2</span>、一个帐号仅限一个会员使用，会员必须向【三古汇<span
lang=EN-US>.</span>云生活】提供真实确实的信息，由于资料提供不正确导致汇款无法收到等后果，【三古汇<span lang=EN-US>.</span>云生活】不承担责任；<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>3</span>、会员资料修改后必须及时通知【三古汇<span
lang=EN-US>.</span>云生活】做出相应变更；<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>4</span>、【三古汇<span
lang=EN-US>.</span>云生活】及其关联公司承诺不向其它第三方机构透露会员涉及隐私的信息；<span lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>5</span>、会员必须遵守【三古汇<span
lang=EN-US>.</span>云生活】（及合作组织）的使用条款及隐私政策。<span lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>九、法律适用、管辖与其他<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;&nbsp;</span>1</span>、本协议之效力、解释、变更、执行与争议解决均适用中华人民共和国法律，如无相关法律规定的，则应参照通用国际商业惯例和（或）行业惯例。<span
lang=EN-US><br>
<span style='mso-spacerun:yes'>&nbsp;</span><span
style='mso-spacerun:yes'>&nbsp; </span>2</span>、因本协议产生之争议，应依照中华人民共和国法律予以处理。双方对于争议协商不成的，应当提交山东三古汇网络科技有限公司企业所在地人民法院诉讼解决。<span
lang=EN-US>&nbsp;</span></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><span
lang=EN-US style='font-size:12px;font-family:宋体;mso-bidi-font-family:宋体'>&nbsp;</span></p>

		</div>
	</div>
</div>
		<div class="hyhdxznr">
				<input type="checkbox" name="memberCheck" id="memberCheck" onclick="checkMemberBoxCheck()" checked="checked"/>
				<label for="memberCheck">阅读并同意遵守</label><br>
				<input type="button" class="btn btn-default" id="MemberButtonOk" name="MemberButtonOk" value="下一步" onclick="toMemberRegist();">
		</div>
	</div>
</div>
<!--======================bottom开始============================-->
   <div class="clear"></div>
   <jsp:include page="/admin/common/indexFooter.jsp" />
<!-- footer end -->
	</body>
</html>
