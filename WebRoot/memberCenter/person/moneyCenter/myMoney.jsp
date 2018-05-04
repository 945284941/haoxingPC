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
<link rel="stylesheet" href="web/css/base.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<link href="css/page.css" rel="stylesheet" type="text/css" />
<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="web/css/sghsc-order.css" type="text/css" />
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
	$(function(){
		$('#tojifen').click(function(){
			alert('对不起，您当前级别不够，无法完成兑换！');
		});
	})
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
</head>
<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="/admin/common/navigation.jsp" />
<div class="breadThumb">
	当前位置：首页 &gt; 个人会员中心  &gt; 电子商城  &gt; 财富管理  &gt; 我的粮票
</div>
<div class="gzgz">
     <div class="hyleft">
     		<jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" />
     </div>
     <div class="hyright">
       <p class="hymainbt"><span class="grmenubt">财富管理</span>
        <s:if test="moneyType==0 && moneyType!=''">
       		<a class="jl zjline" href="person/moneyManage/myMoneyList/0.html">获取记录</a>
        </s:if>
        <s:else>
        	<a class="jl" href="person/moneyManage/myMoneyList/0.html">获取记录</a>
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
        <button id="tojifen" style="float:right;" class="btn btn-primary" href="javascript:void(0)">兑换成经验值</button>
       </p>
       	 <table class="table table-bordered myTableList">
       	 	<thead>
       	 		<tr>
       	 			<th width="" class="text-center">交易时间</th>
       	 			<th class="text-center">交易类型</th>
       	 			<th class="text-center">交易金额</th>
       	 			<th class="text-center">是否完成</th>
       	 			<th width="30%" class="text-center">余额</th>
       	 			<th width="30%" class="text-center">备注</th>
       	 		</tr>
       	 	</thead>
       	 	<tbody>
       	 	<s:iterator value="advanceList" >
       	 		<tr>
       	 			<td class="text-center"><s:date format="yyyy-MM-dd HH:mm:ss" name="%{doTime}"/></td>
       	 			<td class="text-center">
	       	 			<s:if test="doType==0">
							增加
						</s:if>
						<s:else>
							减少
						</s:else>
       	 			</td>
       	 			<td class="text-center">${doMoney}</td>
       	 			<td class="text-center">
		             	<s:if test="trading==0">
		             		未完成
		             	</s:if>
		             	<s:if test="trading==1">
		             		已完成
		             	</s:if>
       	 			</td>
       	 			
       	 			<td class="text-center">${balance}</td>
       	 			<td class="text-center">${message}</td>
       	 		</tr>
       	 	</s:iterator>
       	 	<tr>
       	 		<td colspan="6">
       	 			<page:pagination path="person/moneyManage/myMoneyList.html" formName="pagerForm"/>
       	 			<form id="pagerForm" name="pagerForm"method="post" style="display: none">
					         <input name="moneyType"  type="hidden"  value="<s:property value='#request.moneyType'/>"/>
			          </form>
       	 		</td>
       	 	</tr>
       	 	</tbody>
       	 </table>
   </div>     
</div>
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
 <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>