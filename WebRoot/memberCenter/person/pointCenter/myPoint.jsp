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
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<link href="css/page.css" rel="stylesheet" type="text/css" />
<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="web/css/sghsc-order.css" type="text/css" />
<link href="js/layer/skin/layer.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/layer/layer.min.js"></script>
<script language="JavaScript" type="text/JavaScript">
function showElement(elementId)
{
  document.getElementById(elementId).style.display="block";
}
function hideElement(elementId)
{
  document.getElementById(elementId).style.display="none";
}
$(function(){
	$('#toGuliangbi').click(function(){
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
		   <div class="breadThumb">	首页 &gt; 会员中心&gt; 财富管理 &gt; 我的经验值</div>
<div class="gzgz">
      <div class="hyleft">
     	<jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" />
     </div>
     <div class="hyright">
       <p class="integralbt_hymainbt"><span class="grmenubt">经验值管理</span>
       <span class="integralbt">
       		<s:if test="pointType==0">
				<a class="hover" href="person/pointDetail/myPointList/0.html">获取记录</a>
		    </s:if>
		    <s:else>
		    	<a  href="person/pointDetail/myPointList/0.html">获取记录</a>
		    </s:else>
       	</span>
       	<a id="toGuliangbi" href="javascript:void(0)" class="btn btn-primary" style="float:right;">兑换成粮票</a>
       <span class="integralbt">
	      	 	<s:if test="pointType==1">
	       			<a class="hover" href="person/pointDetail/myPointList/1.html">兑换记录</a>
			    </s:if>
			    <s:else>
			    	<a href="person/pointDetail/myPointList/1.html">兑换记录</a>
			    </s:else>
       	</span>
       </p>
       <div>
       	<table class="table table-bordered myTableList">
       		<thead>
       			<tr>
       				<th class="text-center">时间</th>
       				<th class="text-center">经验值类型</th>
       				<th class="text-center">经验值数值</th>
       				<th>余额</th>
       				<th>获取来源</th>
       			</tr>
       		</thead>
       		<tbody>
       		    <s:iterator value="pointDetailList" >
       			<tr>
       				<td class="text-center"><s:date format="yyyy-MM-dd HH:mm:ss" name="%{createtime}"/></td>
       				<td class="text-center"><s:if test="type==1">使用</s:if><s:else>获取</s:else></td>
       				<td class="text-center">${point}</td>
       				<td>${balance}</td>
       				<td>${remark}</td>
       			</tr>
       			</s:iterator>
       			<tr>
       				<td colspan="4">
       				<page:pagination path="person/pointDetail/myPointList.html" formName="pagerForm"/>
       				<form id="pagerForm" name="pagerForm"method="post" style="display: none">
					         <input name="pointType"  type="hidden"  value="<s:property value='#request.pointType'/>"/>
			        </form>
       				
       				</td>
       			</tr>
       		</tbody>
       	</table>
       </div>
     </div>  
    
</div>
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
<jsp:include page="/admin/common/indexFooter.jsp" />
<!-- footer end -->
</body>
</html>