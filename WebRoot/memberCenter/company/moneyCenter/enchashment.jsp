<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>古道金典</title>
<base href="<%=basePath%>"/>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script language="JavaScript" type="text/JavaScript">
function showElement(elementId)
{
  document.getElementById(elementId).style.display="block";
}
function hideElement(elementId)
{
  document.getElementById(elementId).style.display="none";
}
var mobileNum;
function enchashment(){
	//验证金额
	var money = $("#doMoney").attr("value");
    var re = /^\d+(?=\.{0,1}\d+$|$)/;
    if(money==''){
    	alert("金额不能为空");
    }else{
		    if (money != "") {
		        if (!re.test(money)) {
		            alert("请输入正确的数字");
		            money = "";
		            $("#doMoney").attr("value",money);
		        }
		         money = parseFloat(Math.floor(money * 100) / 100);
		        $("#doMoney").attr("value",money);
		       //是否输入银行及银行账号
		        var bank = $("#bank").attr("value");
		        var bankAccount = $("#bankAccount").attr("value");
		        if(bank==''){
		           alert("请选择到账银行");
		        }else{
		        	
		        	if(bankAccount==''){
		        		alert("请输入到账银行卡号");
		        	}else{
		        		 //验证密码
						var payPassword = $("#payPassword").attr("value");
						var yanzheng = $("#duanxinNum").attr("value");
							    $.ajax({
									url : "moneyManage!payIsTrue.action",
									type : "POST",
									dataType : "JSON",
									data : "payPassword="+payPassword,
									success : function(isTrue) {
										if(!isTrue){
											alert("安全密码不对，请从新输入");
										}else{
											 $.ajax({
													url : "moneyManage!moneyEnchs.action",
													type : "POST",
													dataType : "JSON",
													data : {"money":money,"yanzhengMobile":yanzheng,"mobileNum":mobileNum},
													success : function(map) {
														if(!map.moneyEn){
															alert("取现金额大于余额");
														}else{
															if(!map.yanzheng){
																alert("获取验证码错误，请从新输入");
															}else{
																if(!map.guoqi){
																		alert("验证码已经过期");
																}else{
																	document.enchashmentForm.submit(); 
																}
															}
														}
													}
												});				
										}
									}
								});				
		        	}
		        }
		        
		   }
    }
}

function changeBank(value){
	document.getElementById('bank').value=value;
}
//得到验证码

function gainMobile(){
	 $("#mobileSpan").html("");
		document.getElementById('yanzheng').disabled="disabled";
		window.setTimeout(show,301000);
		shijianjishi();
		document.getElementById('duanxinNum').disabled = false; 
		mobileNum = $("#mobileNum").attr("value");
		$.ajax({
			url : "moneyManage!mobileMessage.action",
			type : "POST",
			dataType : "JSON",
			data : {"mobileNum":mobileNum },
			success : function(isTrue) {
				if(!isTrue){
					alert("短信发送失败");
				}else{
					$("#mobileSpan").html("<font color='red'>短信发送成功</font>");
				}
			}
		});	
}
function clearValue(id){
	document.getElementById(id).value="";
}
var time = 299, t;
 function shijianjishi(){
	 $("#yanzheng").val("("+time+"秒)后重新点击");
	 time--;
	 t = setTimeout(shijianjishi, 1000);
	 if ( time < 0 ){
		 time= 60;
		  clearTimeout(t);
		 }
 }
 function show()
	{
		document.getElementById('yanzheng').disabled = false; 
		 $("#yanzheng").val("短信验证");
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
<!-- 头部开始 -->
<div class="header">
  <s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
</div>
<div class="logo">
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
</div>
<div id="warp">
<jsp:include page="/memberCenter/common/navigation.jsp" />
</div>
<!-- 头部结束 -->
<!-- 页脚开始 -->
<div class="dht">首页 &gt; 会员中心  &gt; 电子商城 &gt; 资金管理 &gt; 预付款兑米</div>
<div class="gzgz">
     <div class="hyleft">
     		<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
     </div>
     <div class="hyright">
      <div class="hyrightr">
       	<jsp:include page="/memberCenter/common/rightMoneyCenter.jsp" />
      </div>
        <p class="hymainbt"><span class="grmenubt">资金管理</span>
        <s:if test="moneyType==0 && moneyType!=''">
       		<a class="jl zjline" href="moneyManage!gainMoneyList.action?moneyType=0">充值记录</a>
        </s:if>
        <s:else>
        	<a class="jl" href="moneyManage!gainMoneyList.action?moneyType=0">充值记录</a>
        </s:else>
        <s:if test="moneyType==2">
       		<a class="jl zjline" href="moneyManage!gainMoneyList.action?moneyType=2" >支付记录</a>
        </s:if>
         <s:else>
        	<a class="jl" href="moneyManage!gainMoneyList.action?moneyType=2" >支付记录</a>
        </s:else>
       	<s:if test="moneyType==1">
       		<a class="jl zjline" href="moneyManage!gainMoneyList.action?moneyType=1">兑现记录</a>
        </s:if>
         <s:else>
        	<a class="jl" href="moneyManage!gainMoneyList.action?moneyType=1">兑现记录</a>
        </s:else>
        	<a class="jl" href="person/moneyManage/myMoneyList/10.html" >金额记录</a>
       </p>
       <div class="zjaj"><ul>  
         <li><a href="person/moneyManage/toRechargeMoney.html">预存款充值</a></li> 
         <li class="zjover"><a  href="person/moneyManage/toWithdrawMoney.html">预存款兑米</a></li>
         </ul>
         <div style="clear:both"></div>
       </div>
       
       <form  action="moneyManage!enchashment.action"  id="enchashmentForm" name="enchashmentForm" method="post">
       <div class="lbcontant2" style="padding-left:50px; padding-top:30px; width:615px;">
         <div class="hylist" style="background:#f7f7f7">
		   <span class="ddlabel" style="font-weight:bold">兑米金额：</span>
		     <div class="fieldcz">
			   <input type="text" maxlength="20" id="doMoney"  name="advanceLogs.doMoney"  class="ddtextbox" />
		     </div>
			 <span class="ddlabel">元</span>
	   </div>
       <div class="hylist" style="height:60px;">
		   <span class="ddlabel">会员备注：</span>
		     <div class="fieldcz" style="width:250px;">
			   <textarea name="advanceLogs.message" style="height:60px; resize:none; width:250px; border:1px solid #dedede"></textarea>
		     </div>
	   </div>
       <div class="hylist">
		   <span class="ddlabel">到账银行：</span>
		     <div class="fieldcz">
		     <input type="hidden" id="bank"name="advanceLogs.bank"/>
			   <select  onchange="changeBank(this.value);">
             	 <option value="">请选择：</option>
              	</select>
		     </div>
	   </div>
       <div class="hylist">
		   <span class="ddlabel">银行账号：</span>
		     <div class="fieldcz">
			   <input type="text" maxlength="20"  name="advanceLogs.bankAccount" id="bankAccount" class="ddtextbox" />
		     </div>
	   </div>
       <div class="hylist">
		   <span class="ddlabel">安全密码：</span>
		   <s:if test="payPassword!=null && payPassword!=''">
			   <div class="fieldcz">
				   <input type="password" maxlength="20" id="payPassword"   class="ddtextbox" />
			     </div>
		   </s:if>
		   <s:else>
		   			<a style="margin-left:10px; text-decoration:underline" onclick="openOrderPage('/company/accountSecurity.html');">没有密码？<b style="color:red">设置</b></a>
		   </s:else>
	   </div>
       <div class="hylist">
		   <span class="ddlabel">手机号码：</span>
		   <s:if test="statusMobile==1">
		     <div class="fieldcz">
		     	<input type="text" maxlength="20" id="mobileNum"  class="ddtextbox" name="mobileNum" value="${mobileNum }" disabled="disabled"/>
		     	</div>
           <span  class="sjdx"><em>*</em><input id="yanzheng" class="dxyz" type="button" onclick="gainMobile();" value="短信验证" /><input name="advanceLogs.yanzhengMobile"  disabled="disabled" id="duanxinNum" class="ddtextdxyzm" onfocus="clearValue(this.id);" value="验证码"/></span><span id="mobileSpan"></span>
		     </s:if>
		     <s:else>
		     	<a onclick="openOrderPage('/company/accountSecurity.html');" style="color: red;">手机未绑定，点击绑定手机</a>
		     </s:else>
	   </div>
	   <s:if test="statusMobile==1">
       		<div class="czan"><input type="button" onclick="enchashment()" value="确认兑米" /></div>
		</s:if>
       </div>  
       </form>
   </div>     
</div>
<div class="gg"><a href="/"><img src="/images/memberimg/tlgg1.gif"/></a></div>
<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
<!-- footer end -->
</body>
</html>