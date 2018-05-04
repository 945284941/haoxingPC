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
<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
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
<div class="breadThumb">首页 &gt; 会员中心&gt; 财富管理 &gt; 我的优惠券</div>
<div class="gzgz">
      <div class="hyleft">
     	<jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" />
     </div>
     <div class="hyright">
        <p class="hymainbt">
	    	<span class="grmenubt">我的优惠券</span>
	    </p>
     	<table class="table table-bordered"  style="margin-top:10px;">
     		<thead>
     			<tr>
     				<th>优惠券名称</th>
     				<th width="480" class="text-center">优惠券信息</th>
     				<th width="120">优惠券数量</th>
     				<th width="120" class="text-center">是否已使用</th>
     			</tr>
     		</thead>
     		<tbody>
     			<s:iterator value="courtesyMemberList" >
     			<tr>
     				<td>${name}</td>
     				<td  class="text-center">${remark}</td>
     				<td  class="text-center">${num}</td>
     				<td class="text-center"><s:if test="disabled =='false'">未使用</s:if><s:else>已经使用</s:else></td>
     			</tr>
     			</s:iterator>
     		</tbody>
     	</table>
     </div>  
    
</div>
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
<jsp:include page="/admin/common/indexFooter.jsp" />
<!-- footer end -->
</body>
</html>