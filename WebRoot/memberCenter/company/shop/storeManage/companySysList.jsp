<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<style type="text/css">
.btn{ background-color:#FFF; border:1px solid #CDCDCD;height:24px; width:70px;}
.file{ position:absolute; top:0; right:80px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px }
</style>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>

</head>
<body>
<!-- 头部开始 -->
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
		   <jsp:include page="/admin/common/navigation.jsp" />
	<!-- 头部结束 -->
	<!-- 页脚开始 -->
	<div class="breadThumb">	首页 &gt; 会员中心 &gt; 店铺管理 &gt;首页设置</div>
<div class="gzgz">
     <div class="hyleft">
     	<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
     </div>
     <div class="hyright">
       <p class="hymainbt"><span class="grmenubt">店铺管理</span></p>
       <h2><span>首页设置</span></h2>
       <div class="grjbxx2">
       <s:iterator var="s" value="companySys" status="st">
       	<form action="memberManageAction!uploadCompanySys.action" method="post"   enctype="multipart/form-data" >
	         <div class="fllbgg">
	         <div class="ggxh"><s:property value="#st.index+1"/></div>
	         <div class="ggimg"><img src="${imageUrl}" style="width: 114px;height: 36px;" /></div>
	         <div id="file_wrapper">
		          <div id="file_faker">
		               <div id="file_btn">浏览</div>
		           </div>
		               <input name="companySy.id" value="${id}" type="hidden"/>
		                <input type="file"  id="file_uploader"  name="companySy.myFile" />
		               <span class="lianjiedizhi">链接地址：</span>
		               <input type="text" class="lianjiedizhi-input" name="companySy.href"value="${href}" />
		               <input class="file_sc" type="submit" value="提交" />
		              </div>
	         <span class="sc"><a href="memberManageCompanySysDelete/${id}_${imageUrl}.html">删除</a></span>
	         </div>                       
	        </form>
         </s:iterator>
       </div>
     </div>  
     <div style="clear:both"></div>
</div>
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>
