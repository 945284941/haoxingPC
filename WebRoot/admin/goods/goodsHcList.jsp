<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
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
<title>汇筹商品区—颐佳官方商城</title>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/regions.js"></script>
<script type=text/javascript src="js/smap.js"></script>
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

<style type="text/css">
.img-typeIcon{
position: relative;
}
.img-typeIcon-img{
position: absolute;
top:0;
left:0;
}
</style>
		
<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="web/css/sghsc-main.css" rel="stylesheet" type="text/css" />
<link href="web/css/sghsc-goods.css" rel="stylesheet" type="text/css" />	
<link href="css/page.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="web/js/searchGoods.js" ></script>
 
<script language="JavaScript" type="text/JavaScript">
 $(function(){
	$("#fullCategoryone span").each(function(){
		$(this).css("color","rgb(102, 102, 102)");
		$(this).click(function(){
			$("#fullCategoryone span").each(function(){
				$(this).css("color","rgb(102, 102, 102)");
			});
		  $(this).css("color","red");
		});
	});
}); 
</script>

</head>
<body>

<div id="goodsType" style="display:none;">${goodstype}</div>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<!--======================logo开始============================-->
 <s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<!--======================导航开始============================-->
 <jsp:include page="/admin/common/navigation.jsp" />
<!--======================middle部分开始============================-->

<div class="sghsc-goods-select">
	<div class="sghsc-goods-sxuan"><span class="sghsc-goods-sxuanbt">商品筛选</span>
  		<span class="sghsc-goods-sxuanlb">(共<span>${pagination. totalCount}</span>个商品)</span>
    </div>
    <div class="sghsc-goods-sxuan" id="search-selected">
       <b class="left">已选条件</b>
    </div>
    <div class="clear"></div>
    
<%-- 	<div class="sghsc-goods-sxuan"><b>所有分类</b>
		<img src="web/images/sghsc-goods-sy.png"></img>
	    <span id="toggle" class="sghsc-goods-sxuan-fl">收起分类</span>
	</div>

<div id="fullCategory">
	<!-- 一级分类 -->
	<div class="sghsc-goods-sxuan" id="fullCategoryone" style="overflow:hidden;">	
	<c:forEach items="${fullCategoryList}" var="cat" varStatus="status">
	  	<span id="firstCategory" class="sghsc-goods-sxuan-flbt1" >${cat.name}</span>
	</c:forEach>	
	</div>
	
	<!--  二级分类 -->
	<div class="sghsc-goods-sxuan" id="fullCategorysub" style="height:100%;">	
	<c:forEach items="${fullCategoryList}" var="cat" varStatus="status"> 
		<div class="subcat2" style="display:none;">			 	
		 <c:forEach items="${cat.subCatList}" var="subCat" >		
		   <a href="javascript:void(0)" class="sghsc-goods-sxuan-fllist-x" data-module="goodsCatName" data-item="${subCat.name }" onclick="chaxun('goodsCatName','${subCat.name }');">${subCat.name }</a>
		 </c:forEach>
		</div>
	</c:forEach>	
	</div>
</div> --%>

   <div class="sghsc-goods-sxuan" id="fullCategoryone"><b>所有分类</b>
	 <!-- 一级分类 -->
	<c:forEach items="${fullCategoryList}" var="cat" varStatus="status">
		<a href="javascript:void(0)" class="sghsc-goods-sxuan-fllist-x" data-module="firstGoodsCatName" data-item="${cat.name }" onclick="chaxun('firstGoodsCatName','${cat.name }');">${cat.name }</a>
	</c:forEach>	
   </div>

	<div class="sghsc-goods-sxuan" id="lb_sx_lx"><b>包装方式</b>
     <s:iterator value="baozhuangList" var="n">
        <a href="javascript:void(0)" data-module="baozhuang" data-item="${n.name }"  class="sghsc-goods-sxuan-fs" onclick="chaxun('baozhuang','${n.name }');">${n.name }</a>
     </s:iterator>
	</div>

	<div class="sghsc-goods-sxuan" id="lb_sx_lx"><b>重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量</b>
     <s:iterator value="zhongliangList" var="n">
		<a href="javascript:void(0)" data-module="zhongliang" data-item="${n.name }" class="sghsc-goods-sxuan-fs" onclick="chaxun('zhongliang','${n.name }');">${n.name }</a>
     </s:iterator>
	</div>

	<div class="sghsc-goods-sxuan sghsc-goods-noborder" id="lb_sx_lx"><b>省&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份</b>
	<s:iterator value="shengfenList" var="n">
		<a href="javascript:void(0)" data-module="shengfen" data-item="${n.name }" class="sghsc-goods-sxuan-fs" onclick="chaxun('shengfen','${n.name }');">${n.name }</a>
    </s:iterator>
	</div>
	
	<div class="sghsc-goods-select sghsc-goods-noborder">
         <a class="sghsc-goods-select2-fl" href="javascript:void(0)" onclick="sortOrder('(CLICK_NUMBER*0.3+query_num*0.7)','desc');">综合排序</a>
         <a class="sghsc-goods-select2-fl" onclick="sortOrder('query_num','desc');">销量</a>
         <a class="sghsc-goods-select2-fl" id="searchByPrice">价格</a>
         <a class="sghsc-goods-select2-fl" onclick="sortOrder('createtime','desc');">上架时间</a>
         <a class="sghsc-goods-select2-fl" onclick="sortOrder('click_number','desc');">收藏</a>
        <!--  <div class="sghsc-goods-select2-rit"><a href="#"><img src="web/images/sghsc-goods-r.png" width="21" height="20"></img></a></div>
         <div class="sghsc-goods-select2-rit"><a href="#"><img src="web/images/sghsc-goods-l.png" width="21" height="20"></img></a></div> -->
	</div>
</div>
<div class=" clear"></div>

<div class="sghsc-goods-select3">
     
      <s:iterator value="goodsDetailList" var="goodsDetail" >
        <div class="sghsc-goods-list-box">
            <img class="img-typeIcon-img" src="images/huichou.png"/>
        	<a href="goods/${id}.html" target="_blank" class="img-typeIcon">
            <img class="lazy" data-original='${defaultPicSrc}' src="images/picbg.png" width="218" height="182" /></a>
			<div class="sghsc-goods-list-y">
                              ￥<fmt:formatNumber type="number" value="${price }" pattern="0.00" maxFractionDigits="2"/>
            </div>
           	<div class="sghsc-goods-list-tittle">
           		<s:if test="name.length()>32">
					<s:property value="name.substring(0, 32)" />...</s:if>
				<s:else>
					<s:property value="name" />
				</s:else>             
           	</div>
            <div class="sghsc-goods-list-xl">总销量：<span>${queryNum}</span></div>
        </div>
    </s:iterator>
</div>        
<div class=" clear"></div>

      <form id="pagerForm" name="pagerForm" action="searchGoodsListMoreP.html" method="post">
			<input type="hidden" id="pageNum" name="pageNum" value="1" /> 
			<input type="hidden" id="firstGoodsCatId" name="firstGoodsCatId"  value="<s:property value='#request.firstGoodsCatId'/>" />
			<input type="hidden" id="secondGoodsCatId" name="secondGoodsCatId" value="<s:property value='#request.secondGoodsCatId'/>" />
			<input type="hidden" id="thirdGoodsCatId" name="thirdGoodsCatId"  value="<s:property value='#request.thirdGoodsCatId'/>" />
			<input type="hidden" id="firstGoodsCatName" name="firstGoodsCatName" value="<s:property value='#request.firstGoodsCatName'/>" />
			<input type="hidden" id="goodsCatName" name="goodsCatName" value="<s:property value='#request.goodsCatName'/>" />
			<input type="hidden" id="bn"name="bn"  value="<s:property value='#request.bn'/>" />
			<input type="hidden" id="cityId" name="cityId"  value="<s:property value='#request.cityId'/>" />
			<input type="hidden" id="cityName" name="cityName"  value="<s:property value='#request.cityName'/>" />
			<input type="hidden" id="provinceId" name="provinceId"  value="<s:property value='#request.provinceId'/>" />
			<input type="hidden" id="sort" name="sort"  value="<s:property value='#request.sort'/>" />
			<input type="hidden" id="order" name="order"  value="<s:property value='#request.order'/>" />
			<input type="hidden" id="topName" name="topName"  value="<s:property value='#request.topName'/>" />
			<input type="hidden" id="weight"  name="weight"  value="<s:property value='#request.weight'/>" />
			<input type="hidden" id="length"  name="length"  value="<s:property value='#request.length'/>" />
			<input type="hidden" id="width"  name="width"  value="<s:property value='#request.width'/>" />
			<input type="hidden" id="height"  name="height"  value="<s:property value='#request.height'/>" />
			<input type="hidden" id="color"  name="color" value="<s:property value='#request.color'/>" />
			
			<input type="hidden" id="leixing" name="leixing" value="<s:property value='#request.leixing'/>" />
			<input type="hidden" id="baozhuang" name="baozhuang" value="<s:property value='#request.baozhuang'/>" />
			<input type="hidden" id="zhongliang" name="zhongliang" value="<s:property value='#request.zhongliang'/>" />
			<input type="hidden" id="shengfen" name="shengfen" value="<s:property value='#request.shengfen'/>" />
			<input type="hidden" id="goodstype" name="goodstype" value="<s:property value='#request.goodstype'/>" />
			
			<input type="hidden" id="createtime" name="color" value="<s:property value='#request.createtime'/>" />
			<input type="hidden" id="topSearchLike" name="topSearchLike" value="<s:property value='#request.topSearchLike'/>" />
	</form>
	<form id="reset" action="searchGoodsListMoreP.html" method="post">
	<input id="zhankai" name="zhankai"  type="hidden"/></form>
    <div id="showpages">
    	<page:pagination path="searchGoodsListMoreP.html" formName="pagerForm"/>
	</div>
     <div class=" clear"></div>
  
<!--======================bottom开始============================-->
<jsp:include page="/admin/common/indexFooter.jsp" />

</body>
</html>
