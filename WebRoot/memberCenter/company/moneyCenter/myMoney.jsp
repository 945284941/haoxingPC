<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
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
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<link href="css/page.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script  type="text/javascript">
	function showElement(elementId)
	{
	  document.getElementById(elementId).style.display="block";
	}
	function hideElement(elementId)
	{
	  document.getElementById(elementId).style.display="none";
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
<div class="dht">会展中心  &gt; 电子商城 &gt; 资金管理 &gt; 我的资金</div>
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
       		<a class="jl zjline" href="person/moneyManage/myMoneyList/0.html">充值记录</a>
        </s:if>
        <s:else>
        	<a class="jl" href="person/moneyManage/myMoneyList/0.html">充值记录</a>
        </s:else>
        <s:if test="moneyType==2">
       		<a class="jl zjline" href="person/moneyManage/myMoneyList/2.html" >支付记录</a>
        </s:if>
         <s:else>
        	<a class="jl" href="person/moneyManage/myMoneyList/2.html" >支付记录</a>
        </s:else>
       	<s:if test="moneyType==1">
       		<a class="jl zjline" href="person/moneyManage/myMoneyList/1.html">兑现记录</a>
        </s:if>
         <s:else>
        	<a class="jl" href="person/moneyManage/myMoneyList/1.html">兑现记录</a>
        </s:else>
       	 	<a class="jl " href="person/moneyManage/myMoneyList/10.html">金额记录</a>
       	
       </p>
       <div class="zjaj"><ul>  
          <li><a href="person/moneyManage/toRechargeMoney.html">预存款充值</a></li> 
         <li><a href="person/moneyManage/toWithdrawMoney.html">预存款兑米</a></li>
         </ul>
         <div style="clear:both"></div>
       </div>
       <div class="lbcontant2">
         <div class="zjtitle">
         <span style="width:120px;">交易时间</span><span style="width:87px;">交易类型</span><span style="width:80px;">交易金额</span><span style="width:76px;">交易状态</span><span style="width:79px;">是否完成</span>
			<span style="width:195px;">备注</span></div>
         <s:iterator value="advanceList" >
         <div class="zjcon">
           <ul>
             <li class="zjtwo"><s:date format="yyyy-MM-dd" name="%{doTime}"/></li>
             <li class="zjthree">
				<s:if test="doType==0">
					增加
				</s:if>
				<s:else>
					减少
				</s:else>
			 </li>
             <li class="zjfour">${doMoney}</li>
             <li class="zjfive">
             	<s:if test="doType==0">
             		充值
             	</s:if>
             	<s:elseif test="doType==1">
             		取现
             	</s:elseif>
             	<s:elseif test="doType==2">
             		消费
             	</s:elseif>
             </li>
             <li class="zjsix">
             	<s:if test="trading==0">
             		未完成
             	</s:if>
             	<s:if test="trading==1">
             		已完成
             	</s:if>
             </li>
             <li class="zjseven">&nbsp;${message}</li>
           </ul>
           <div style="clear:both"></div>
         </div>
         </s:iterator>
         
         <div id="showpages">
			<page:pagination path="person/moneyManage/myMoneyList.html" formName="pagerForm"/>
		 </div>
		</div> 
		  <form id="pagerForm" name="pagerForm"method="post" style="display: none">
		         <input name="moneyType"  type="hidden"  value="<s:property value='#request.moneyType'/>"/>
          </form>
   </div>     
</div>
<div class="gg"><a href="/"><img src="/images/memberimg/tlgg1.gif"/></a></div>
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
 <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>