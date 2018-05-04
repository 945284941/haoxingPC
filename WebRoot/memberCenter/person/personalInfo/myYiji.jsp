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
	
	function seePurchaseHistory(id) {
		window.location.href='person/purchaseHistory/'+id+'/1.html';
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
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="/admin/common/navigation.jsp" />
<div class="breadThumb">
	当前位置：首页 &gt; 个人会员中心  &gt; 我的分销  &gt; 一级分销
</div>
<div class="gzgz">
     <div class="hyleft">
     		<jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" />
     </div>
     <div class="hyright">
       	 <table class="table table-bordered myTableList">
       	 	<thead>
       	 		<tr>
       	 			<th width="20px" class="text-center">用户名</th>
       	 			<th width="20px" class="text-center">姓名</th>
       	 			<th width="20px" class="text-center">注册时间</th>
       	 			<th width="20px" class="text-center">会员号</th>
       	 			<th width="20px" class="text-center">会员等级</th>
       	 		</tr>
       	 	</thead>
       	 	<tbody>
       	 	<s:iterator value="memberList" >
       	 		<tr>
       	 			<td class="text-center"><a onclick="seePurchaseHistory('${id}')" title="查看消费记录" target="_barnk">${username}</a></td>
       	 			<td class="text-center">${truename}</td>
       	 			<td class="text-center"><s:date format="yyyy-MM-dd HH:mm:ss"  name="%{regTime}"/></td>
       	 			<td class="text-center">${onlyId}</td>
       	 			<td class="text-center">
       	 			<s:if test="type==0">
							普通会员
						</s:if>
						<s:if test="type=='82ee892375df4c1e98a3d8c9fd6e7612'">
							vip会员
						</s:if>
						<s:if test="type=='ef4bf6acb3404c54b44e4e65e234c20a'">
						  社区分销商
						</s:if>
						<s:if test="type=='1b2a989062f24d6faa21db437379139a'">
						 县级分销商
						</s:if>
						<s:if test="type=='a3f5091e036743f2950c010f1e90a023'">
							市级分销商
						</s:if>
						<s:if test="type=='2237747a89ab45c29a87ea294fce7963'">
							省级分销商
						</s:if>
						</td>
       	 		</tr>
       	 	</s:iterator>
       	 	</tbody>
       	 </table>
       	 <!--======================翻页开始============================-->
	     <form id="pagerForm" name="pagerForm" action="person/myYiji.html" method="post">
			 <input type="hidden" id="pageNum" name="pageNum" value="1" /> 
			 <input type="hidden" id="sort" name="sort" value="<s:property value='#request.sort'/>" />
			 <input type="hidden" id="order" name="order" value="<s:property value='#request.order'/>" />
		  </form>
		 <div class="fenye"  id="showpages">
		   <page:pagination path="person/myYiji.html" formName="pagerForm"/>
		 </div>
   </div>     
</div>
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
 <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>