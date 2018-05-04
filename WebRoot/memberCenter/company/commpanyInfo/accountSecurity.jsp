<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/perinfo.js"></script>
<script language="JavaScript" type="text/JavaScript">
function showElement(elementId)
{
  document.getElementById(elementId).style.display="block";
}
function hideElement(elementId)
{
  document.getElementById(elementId).style.display="none";
}
</script>
<div id="tanchu"></div>
</head>
<body>
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
 <s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<!--======================导航开始============================-->
<jsp:include page="/admin/common/navigation.jsp" />
<!--======================top结束============================-->
<div class="breadThumb">当前位置：首页&gt; 企业会员中心 &gt; 企业信息 &gt; 账号安全</div>
<div class="gzgz">
	<div class="hyleft">
		<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
	</div>
     <div class="hyright">
       <p class="hymainbt"><span class="grmenubt">账号安全</span></p>
       <div class="aqjf">
         <p>${company.username}</p>
         <P>您的安全评分为：<b style="color:#cc0000">${company.accountSecurityScore}</b>分</P>
         <P class="cs">建议您启动全部安全设置，以保障账户及资金安全。</P>
       </div>
       <div class="aqjfxq">
         <s:if test="null!=company.questionId&&''!=company.questionId">
			 <div class="aqwt_0 aqwt_1" id="set_aqwt_0">
				 <ul>   
					<li style="color:#333333; font-size:14px; margin-right:13px;"><strong>安全问题</strong></li>
					<li style="width:357px;">您已设置1个安全保护问题</li>
					<li class="qdaq_0"><a href="javascript:void(0);" onclick="_showPubDialog('tanchu', 'aqwtUpdate_0', 1);">修改</a></li>
				 </ul>
			 	 <div style="clear:both"></div>
	 		 </div>         
         </s:if>
         <s:else>
			 <div class="aqwt_0" id="set_aqwt_1">
				<ul>   
			    	<li style="color:#333333; font-size:14px; margin-right:13px;"><strong>安全问题</strong></li>
					<li><s:select list="questions" listKey="id" listValue="question" cssClass="textaqs" headerKey="0" headerValue="请选择安全保护问题" theme="simple" id="m_questionId" name="company.questionId"></s:select>
					</li>
					<li><input type="text" class="textaq" id="m_questionAnswer" name="company.questionAnswer"/></li>
					<li class="qdaq_0"><a href="javascript:void(0);" onclick="_setUpSecurityProtection('/company/accountSecurity.html')">设置</a></li>
				</ul>
		   		<div style="clear:both"></div>
		     </div>         
         </s:else>
         <div class="aq_1"><div class="aqxg"><strong>登录密码</strong>建议您定期更换账号密码，并且不要和其他账号共用同一个密码</div><div class="aqxg2"><a href="javascript:void(0);" onclick="_showUpdatePwDialog('tanchu', 'mmxg_0',2,'mmxg_mobile');">修改密码</a></div></div>
         <s:if test="null!=company.emailStatus&&0!=company.emailStatus">
         	<div class="aq_1"><div class="aqxg"><strong>绑定邮箱</strong>邮箱是您的有效身份证，在保证安全的同时还可以提供订单提醒服务</div><div class="aqxg2"><a href="javascript:void(0);">已绑定</a></div></div>
         </s:if>
         <s:else>
         	<div class="aq_2"><div class="aqxg"><strong>绑定邮箱</strong>邮箱是您的有效身份证，在保证安全的同时还可以提供订单提醒服务</div><div class="aqxg2"><a href="javascript:void(0);" onclick="_showPubDialog('tanchu', 'yxbd', 3);">立即绑定</a></div></div>
         </s:else>
         <s:if test="null!=company.mobileStatus&&0!=company.mobileStatus">
         	<div class="aq_1"><div class="aqxg"><strong>绑定手机</strong>绑定手机后，修改密码将要通过手机验证，避免他人恶意修改您的密码</div><div class="aqxg2"><a href="javascript:void(0);">已绑定</a></div></div>
         </s:if>
         <s:else>
         	<div class="aq_3"><div class="aqxg"><strong>绑定手机</strong>绑定手机后，修改密码将要通过手机验证，避免他人恶意修改您的密码</div><div class="aqxg2"><a href="javascript:void(0);" onclick="_showPubDialog('tanchu', 'sjbd', 4);">立即绑定</a></div></div>
         </s:else>
         <s:if test="null!=company.payPassword&&''!=company.payPassword">
         	<div class="aq_1"><div class="aqxg"><strong>安全密码</strong>安全密码是您在使用预存款交易或兑米时的密码，请务必牢记</div>
         	<div class="aqxg2"><a href="javascript:void(0);" onclick="_showUpdatePwDialog('tanchu', 'zfmmxg_2', 1,'zfmmxg_mobile');">修改</a></div></div>
         </s:if>
         <s:else>
         	<div class="aq_4"><div class="aqxg"><strong>安全密码</strong>安全密码是您在使用预存款交易或兑米时的密码，请务必牢记</div>
         	<div class="aqxg2"><a href="javascript:void(0);" onclick="_showPubDialog('tanchu', 'zfmmxg_0', 5);">设置</a></div>
         	</div>
         </s:else>
       </div>  
   </div>     
</div>
<!-- securityprotection begin -->
<div id="aqwtUpdate_0" class="aqtc" style=" visibility:hidden">
  <div class="xgmm"><span class="zzjx">1.验证安全保护问题</span><span>2.重设安全保护问题</span></div>
  <p style="margin-left:53px; margin-top:30px;"><label>问题：</label>${company.question}</p>
  <p style="margin-left:53px; margin-top:10px; margin-bottom:5px;"><label>答案：</label><input type="text" style="width:193px;" id="m_check_questionAnswer"/></p>
  <p style="margin-left:110px; margin-bottom:15px; margin-top:20px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_isCorrectByCheckQuestion('tanchu','aqwtUpdate_0','aqwtUpdate_1',1)">确认</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'aqwtUpdate_0',1);">【关闭】</a>
  </p>
</div>
<div id="aqwtUpdate_1" class="aqtc" style=" visibility:hidden">
  <div class="xgmm"><span>1.验证安全保护问题</span><span class="zzjx">2.重设安全保护问题</span></div>
  <p style="margin-left:53px; margin-top:30px;"><label>问题：</label><s:select list="questions" listKey="id" listValue="question" cssClass="textaqs" headerKey="0" headerValue="请选择安全保护问题" theme="simple" id="m_questionId" name="company.questionId"></s:select></p>
  <p style="margin-left:53px; margin-top:10px; margin-bottom:5px;"><label>答案：</label><input class="input" type="text" style="width:200px;" id="m_questionAnswer" name="company.questionAnswer"/></p>
  <p style="margin-left:110px; margin-bottom:15px; margin-top:20px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_setUpSecurityProtection('company/accountSecurity.html')">确认</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'aqwtUpdate_1',1);">【关闭】</a>
  </p>
</div>
<!-- securityprotection end -->
<!-- loginpassword begin -->
<div id="mmxg_0" class="aqtc" style=" visibility:hidden">
  <div class="xgmm"><span class="zzjx">1.手机验证</span><span>2.登录密码修改</span></div>
  <p style="margin-left:65px; margin-top:30px;"><label>您当前绑定的手机号是：</label><span id="mmxg_mobile"></span></p>
  <p style="margin-left:65px; margin-top:10px;"><label>校验码：</label><input type="text" style="width:60px;" id="xgmm_mobile_yzm"/>&nbsp;
  <input class="yzm" id="xgmm_mobileCode" type="button" style="width:125px;" value="免费获取校验码" onclick="javascript:sendMobileCode('xgmm_mobileCode',1,'mobileCheck');"/></p>
  <p style="margin-left:120px; margin-bottom:15px; margin-top:20px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_checkMobile('tanchu', 'mmxg_0','mmxg_1', 2,'xgmm_mobile_yzm')">确认</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'mmxg_0', 2);" >【关闭】</a>
  </p>
</div>
<div id="mmxg_1" class="aqtc" style=" visibility:hidden">
  <div class="xgmm"><span>1.手机验证</span><span class="zzjx">2.登录密码修改</span></div>
  <p style="margin-left:53px; margin-top:30px;"><label>旧密码：</label><input type="password" style="width:200px;" id="m_old_password"/></p>
  <p style="margin-left:53px; margin-top:10px; margin-bottom:5px;"><label>新密码：</label><input type="password" style="width:200px;" id="m_new_password"/></p>
   <p style="margin-left:100px; margin-bottom:10px;"><span style="margin-left:10px; font-size:12px; color:#999999">密码长度6-10位，字母区分大小写</span></p>
  <p style="margin-left:40px; margin-top:10px; margin-bottom:10px;"><label>确认密码：</label><input type="password" style="width:200px;" id="m_new_pwd"/></p>
  <p style="margin-left:120px; margin-bottom:15px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_updatePassword('tanchu', 'mmxg_1', 2, '/company/accountSecurity.html')">确认提交</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'mmxg_1', 2);">【关闭】</a>
  </p>
</div>
<!-- loginpassword end -->
<!-- bindMobile begin -->
<div id="sjbd" class="aqtc" style=" visibility:hidden">
  <p class="xgmmbd">手机绑定</p>
  <p style="margin-left:40px; margin-top:30px;"><label>手机号码：</label><input type="text" style="width:200px;" id="m_mobile"/></p>
  <p style="margin-left:28px; margin-top:10px;"><label>输入校验码：</label><input type="text" style="width:60px;" id="m_mobile_yzm"/>&nbsp;<input class="yzm" id="mobileCode" type="button" style="width:125px;" value="免费获取校验码" onclick="javascript:getMobileCode('mobileCode','m_mobile',0);"/></p>
  <p style="margin-left:120px; margin-bottom:15px; margin-top:20px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_bindMobile('tanchu', 'sjbd', 4,'m_mobile','m_mobile_yzm','/company/accountSecurity.html')">确认</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'sjbd', 4);" >【关闭】</a>
  </p>
</div>
<!-- bindMobile end -->
<!-- bindEmail begin -->
<div id="yxbd" class="aqtc" style=" visibility:hidden">
  <p class="xgmmbd">邮箱绑定</p>
  <p style="margin-left:40px; margin-top:30px;"><label>邮箱地址：</label><input type="text" style="width:200px;" id="m_email"/></p>
  <p style="margin-left:28px; margin-top:10px;"><label>输入校验码：</label><input type="text" style="width:60px;" id="m_email_yzm"/>&nbsp;<input type="button" class="yzm" style="width:125px;" id="emailCode" value="点此发送校验码" onclick="javascript:_sendEmailVerificateCode('emailCode');"/></p>
  <p style="margin-left:111px; color:#FF8D00">请登录您的邮箱获取校验码进行邮箱确认！</p>
  <p style="margin-left:120px; margin-bottom:15px; margin-top:20px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_bindEmail('tanchu', 'yxbd', 3,'company/accountSecurity.html')">确认</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'yxbd', 3);" >【关闭】</a>
  </p>
</div>
<!-- bindEmail end -->
<!-- paypassword begin -->
<div id="zfmmxg_0" class="aqtc" style=" visibility:hidden">
  <p class="xgmmbd">设置安全密码</p>
  <p style="margin-left:40px; margin-top:30px;"><label>安全密码：</label><input type="password" style="width:200px;" id="m_payPassword"/></p>
   <p style="margin-left:100px; margin-bottom:10px;"><span style="margin-left:10px; font-size:12px; color:#999999">密码长度6-10位，字母区分大小写</span></p>
  <p style="margin-left:40px; margin-top:10px; margin-bottom:10px;"><label>确认密码：</label><input type="password" style="width:200px;" id="m_payPasswordPwd"/></p>
  <p style="margin-left:124px; margin-bottom:15px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_setUpPayPassword('tanchu', 'zfmmxg_0', 5,'company/accountSecurity.html')">确认提交</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'zfmmxg_0', 5);" >【关闭】</a>
  </p>
</div>
<div id="zfmmxg_1" class="aqtc" style=" visibility:hidden">
  <div class="xgmm"><span>1.手机验证</span><span class="zzjx">2.安全密码修改</span></div>
  <p style="margin-left:25px; margin-top:30px;"><label>旧安全密码：</label><input type="password" style="width:200px;" id="up_m_old_payPassword"/></p>
  <p style="margin-left:53px; margin-top:10px; margin-bottom:5px;"><label>新密码：</label><input type="password" style="width:200px;" id="up_m_new_payPassword"/></p>
   <p style="margin-left:100px; margin-bottom:10px;"><span style="margin-left:10px; font-size:12px; color:#999999">密码长度6-10位，字母区分大小写</span></p>
  <p style="margin-left:40px; margin-top:10px; margin-bottom:10px;"><label>确认密码：</label><input type="password" style="width:200px;" id="up_m_new_payPasswordPwd"/></p>
  <p style="margin-left:124px; margin-bottom:15px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_updatePayPassword('tanchu', 'zfmmxg_1', 5,'/company/accountSecurity.html')">确认提交</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'zfmmxg_1', 5);" >【关闭】</a>
  </p>
</div>
<div id="zfmmxg_2" class="aqtc" style=" visibility:hidden">
  <div class="xgmm"><span class="zzjx">1.手机验证</span><span>2.安全密码修改</span></div>
  <p style="margin-left:40px; margin-top:30px;"><label>您当前绑定的手机号是：</label><span id="zfmmxg_mobile"></span></p>
  <p style="margin-left:28px; margin-top:10px;"><label>校验码：</label><input type="text" style="width:60px;" id="zfmmxg_mobile_yzm"/>&nbsp;
  <input class="yzm" id="zfmmxg_mobileCode" type="button" style="width:125px;" value="免费获取校验码" onclick="javascript:sendMobileCode('zfmmxg_mobileCode',1,'mobileCheck');"/></p>
  <p style="margin-left:120px; margin-bottom:15px; margin-top:20px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_checkMobile('tanchu', 'zfmmxg_2','zfmmxg_1', 5,'zfmmxg_mobile_yzm')">确认</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'zfmmxg_2', 5);" >【关闭】</a>
  </p>
</div>
<!-- paypassword end -->
	<!-- footer begin -->
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>