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
<title>三古汇官方商城</title>
<base href="<%=basePath%>"/>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script language="JavaScript" type="text/javascript">
	function showElement(elementId)
		{
		  document.getElementById(elementId).style.display="block";
		}
	function hideElement(elementId)
		{
		  document.getElementById(elementId).style.display="none";
		}
	function addMoney(){
		//验证金额
		var money = $("#doMoney").attr("value");
	    var re = /^\d+(?=\.{0,1}\d+$|$)/;
			    if (money != "") {
			        if (!re.test(money)) {
			            alert("请输入正确的数字");
			            money = "";
			            $("#doMoney").attr("value",money);
			        }
			         money = parseFloat(Math.floor(money * 100) / 100);
			        $("#doMoney").attr("value",money);
			       //是否输入支付方式
			        var doWhat = $("#doWhat").attr("value");
			        if(doWhat==''){
			           alert("请选择支付方式");
			        }else{
			        	 //验证密码
						var payPassword = $("#payPassword").attr("value");
							    $.ajax({
									url : "moneyManage!payIsTrue.action",
									type : "POST",
									dataType : "JSON",
									data : "payPassword="+payPassword,
									success : function(isTrue) {
										if(!isTrue){
											alert("安全密码不对，请从新输入");
										}else{
											if(isTrue){
												document.moneyManageForm.submit(); 
											}
										}
									}
								});				
			        }
			   }
	}

	function changeRange(value){
		document.getElementById('doWhat').value=value;
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
<div class="dht">首页 &gt; 个人会员中心&gt; 电子商城 &gt; 资金管理 &gt; 预付款充值</div>
<div class="gzgz">
     <div class="hyleft">
     		<jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" />
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
         <li class="zjover"><a  href="person/moneyManage/toRechargeMoney.html">预存款充值</a></li> 
         <li><a href="person/moneyManage/toWithdrawMoney.html">预存款兑米</a></li>
         </ul>
         <div style="clear:both"></div>
       </div>
       
       
      <form action="moneyManage!addMoney.action" name="moneyManageForm" id="moneyManageForm" method="post">
       <div class="lbcontant2" style="padding-left:50px; padding-top:30px; width:615px;">
         <div class="hylist" style="background:#f7f7f7">
		   <span class="ddlabel" style="font-weight:bold">充值金额：</span>
		     <div class="fieldcz">
			   <input type="text" maxlength="20" id="doMoney"  name="advanceLogs.doMoney"  class="ddtextbox" />
		     </div>
			 <span class="ddlabel">元</span>
	   </div>
       <div class="hylist">
		   <span class="ddlabel">支付方式：</span>
		     <div class="fieldcz">
		     	<input type="hidden" id="doWhat"name="advanceLogs.doWhat"/>
			   <select   onchange="changeRange(this.value);">
              	<option value="">请选择</option><option value="1">支付宝</option><option value="2">快钱</option></select>
		     </div>
	   </div>
       <div class="hylist">
		   <span class="ddlabel">安全密码：</span>
		     <div class="fieldcz">
			   <input type="password" id="payPassword"  maxlength="20"  class="ddtextbox" />
		     </div>
	   </div>
       <div class="czan"><input type="button" onclick="addMoney()"  value="确认充值" /></div>
       </div> 
       </form>
   </div>     
</div>
<div class="gg"><a href="/"><img src="/images/memberimg/tlgg1.gif"/></a></div>
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
 <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>