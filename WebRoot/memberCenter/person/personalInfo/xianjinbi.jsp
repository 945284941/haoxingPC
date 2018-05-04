<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	当前位置：首页 &gt; 个人会员中心  &gt; 我的财富  &gt; 金米列表
</div>
<div class="gzgz">
     <div class="hyleft">
     		<jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" />
     </div>
     <div class="hyright">
       	 <table class="table table-bordered myTableList">
       	 	<thead>
       	 		<tr>
       	 			<th width="20px" class="text-center">时间</th>
       	 			<th width="20px" class="text-center">类型</th>
       	 			<th width="20px" class="text-center">数值</th>
       	 			<th width="20px" class="text-center">余额</th>
       	 			<th width="20px" class="text-center">来源</th>
       	 		</tr>
       	 	</thead>
       	 	<tbody>
       	 	<s:iterator value="xianjinbiList" >
       	 		<tr>
       	 			<td class="text-center"><s:date format="yyyy-MM-dd HH:mm:ss"  name="%{createtime}"/></td>
       	 			<td class="text-center">
       	 				<c:choose>
       	 					<c:when test="${type==0}">获取</c:when>
       	 					<c:when test="${type==1}">使用</c:when>
       	 					<c:when test="${type==2}">兑换</c:when>
       	 					<c:when test="${type==10}">消费</c:when>
       	 					<c:when test="${type==11}">兑米</c:when>
       	 				</c:choose>
       	 			</td>
       	 			<td class="text-center">${point}</td>
       	 			<td class="text-center">${balance}</td>
       	 			<td class="text-center">${remark}</td>
       	 		</tr>
       	 	</s:iterator>
       	 	</tbody>
       	 </table>
       	 <!--======================翻页开始============================-->
	     <form id="pagerForm" name="pagerForm" action="person/pointDetail/xianjinbi.html" method="post">
			 <input type="hidden" id="pageNum" name="pageNum" value="1" /> 
			 <input type="hidden" id="sort" name="sort" value="<s:property value='#request.sort'/>" />
			 <input type="hidden" id="order" name="order" value="<s:property value='#request.order'/>" />
		  </form>
		 <div class="fenye"  id="showpages">
		   <page:pagination path="person/pointDetail/xianjinbi.html" formName="pagerForm"/>
		 </div>
   </div>     
</div>
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
 <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>