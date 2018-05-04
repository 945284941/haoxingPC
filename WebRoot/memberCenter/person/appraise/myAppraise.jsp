<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" href="web/css/base.css" type="text/css"/>
<link rel="stylesheet" href="web/bootstrap/bootstrap.min.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<link href="css/page.css" rel="stylesheet" type="text/css" />
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
		   <div class="breadThumb">	首页 &gt; 会员中心&gt; 新闻资讯&gt;品评价列表</div>
<div class="gzgz">
     <div class="hyleft">
     	<jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" />
     </div>
     <div class="hyright">
       <p class="hymainbt"><span class="grmenubt">评论列表</span></p>
       <table class="table table-bordered myTableList">
       	  <thead>
       	  	<tr>
       	  		<th>商品名称</th>
       	  		<th class="text-center">评价内容</th>
       	  		<th class="text-center">商品评价</th>
       	  		<th class="text-center">评论时间</th>
       	  	</tr>
       	  </thead>
       	  <tbody>
       	    <s:iterator value="appraiseList" >
       	  	<tr>
       	  		<td><a href="goods/${goodsId}.html#${id}"  target="_blank">${fn:substring(goodsName,0, 10)}</a></td>
       	  		<td class="text-center">${content}</td>
       	  		<td class="text-center">
      	  			<s:if test="quality==0">
						中评
					</s:if>
					<s:elseif test="quality==-1">
						差评
					</s:elseif>
					<s:else>
						好评
					</s:else>
       	  		</td>
       	  		<td class="text-center"><s:date format="yyyy-MM-dd" name="%{createtime}"/></td>
       	  	</tr>
       	  	</s:iterator>
       	  	<tr>
       	  		<td colspan="4">
       	  		<page:pagination path="person/appraise/toMyAppraiseList.html" formName="pagerForm"/>
       	  		<form id="pagerForm" name="pagerForm"method="post" style="display: none">
                </form>
       	  		</td>
       	  	</tr>
       	  </tbody>
       </table>
     </div>     
</div>
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>