<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>颐佳官方商城</title>
<link rel="stylesheet" href="web/css/main.css" type="text/css"></link>
<link href="web/css/cuxiao.css"rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
$(function(){
	
})
</script>
</head>

<body>
<form>
<!--======================top开始============================-->
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
 <s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<!--======================导航开始============================-->
<jsp:include page="/admin/common/navigation.jsp" />
<!--======================middle部分开始============================-->
<div class="breadThumb">当前位置：全部结果>特卖</div>
<div class="lb_mid cuxiao">
  <div class="lb_mid_rit">
      <div>
          <div class="tm_rit_01 imgItem">
          <a href="${mapList.temai_0.href}">
          <img src="${mapList.temai_0.imageUrl}" width="282" height="393" />
          <div class="imgMsg">
          	<span>${mapList.temai_0.goodName }</span><br/>
          	<span class="imgMsg-price">￥${mapList.temai_0.price }</span>
          </div>
          </a>
          </div>
          <div class="tm_rit_01 imgItem">
          <a href="${mapList.temai_1.href}">
          <img src="${mapList.temai_1.imageUrl}" width="282" height="393" />
          <div class="imgMsg">
          	<span>${mapList.temai_1.goodName }</span><br/>
          	<span class="imgMsg-price">￥${mapList.temai_1.price }</span>
          </div>
          </a>
          </div>
          <div class="tm_rit_02 imgItem"><a href="${mapList.temai_2.href}">
          <img src="${mapList.temai_2.imageUrl}" width="375" height="393" />
          <div class="imgMsg">
          	<span>${mapList.temai_2.goodName }</span><br/>
          	<span class="imgMsg-price">￥${mapList.temai_2.price }</span>
          </div>
          </a></div>
      </div>
      <div class="clear"></div>
      <div class="lb_mid_rit1">
           <div class="tm_rit_03 imgItem"><a href="${mapList.temai_3.href}">
           <img src="${mapList.temai_3.imageUrl}" width="566" height="286" />
           <div class="imgMsg">
          	<span>${mapList.temai_3.goodName }</span><br/>
          	<span class="imgMsg-price">￥${mapList.temai_3.price }</span>
          </div>
           </a></div>
           <div class="tm_rit_04 imgItem"><a href="${mapList.temai_4.href}">
           <img src="${mapList.temai_4.imageUrl}" width="375" height="286" />
           <div class="imgMsg">
          	<span>${mapList.temai_4.goodName }</span><br/>
          	<span class="imgMsg-price">￥${mapList.temai_4.price }</span>
          </div>
           </a></div>
      </div>
      <div class="clear"></div>
      <div class="lb_mid_rit1">
           <div class="tm_rit_07 imgItem"><a href="${mapList.temai_5.href}">
           <img src="${mapList.temai_5.imageUrl}" width="375" height="286" />
           <div class="imgMsg">
          	<span>${mapList.temai_5.goodName }</span><br/>
          	<span class="imgMsg-price">￥${mapList.temai_5.price }</span>
          </div>
           </a></div>
           <div class="tm_rit_08 imgItem"><a href="${mapList.temai_6.href}">
           <img src="${mapList.temai_6.imageUrl}" width="565" height="286" />
           <div class="imgMsg">
          	<span>${mapList.temai_6.goodName }</span><br/>
          	<span class="imgMsg-price">￥${mapList.temai_6.price }</span>
          </div>
           </a></div>
      </div>
      <div class="clear"></div>
      <div class="lb_mid_rit1">
          <div class="lb_mid_rit2">
              <div class="tm_rit_06 imgItem" style="float:none;"><a href="${mapList.temai_7.href}">
              <img src="${mapList.temai_7.imageUrl}" width="567" height="195" />
              <div class="imgMsg">
	          	<span>${mapList.temai_7.goodName }</span><br/>
	          	<span class="imgMsg-price">￥${mapList.temai_7.price }</span>
	          </div>
              </a></div>
              <div class="imgItem"  style="margin-top:3px; height:195; width:567; ">
              <a href="${mapList.temai_8.href}">
              <img src="${mapList.temai_8.imageUrl}" width="567" height="195" />
              <div class="imgMsg">
	          	<span>${mapList.temai_8.goodName }</span><br/>
	          	<span class="imgMsg-price">￥${mapList.temai_8.price }</span>
	          </div>
              </a></div>
          </div>
          <div class="tm_rit_05 imgItem"><a href="${mapList.temai_9.href}">
          <img src="${mapList.temai_9.imageUrl}" width="377" height="395" />
          <div class="imgMsg">
          	<span>${mapList.temai_9.goodName }</span><br/>
          	<span class="imgMsg-price">￥${mapList.temai_9.price }</span>
          </div>
          </a></div>
          <div class="clear"></div>
      </div>
      <div class="clear"></div>
      <div class="lb_mid_rit1">
           <div class="tm_rit_09 imgItem"><a href="${mapList.temai_10.href}">
           <img src="${mapList.temai_10.imageUrl}" width="375" height="265" />
           <div class="imgMsg">
          	<span>${mapList.temai_10.goodName }</span><br/>
          	<span class="imgMsg-price">￥${mapList.temai_10.price }</span>
          </div>
           </a></div>
           <div class="tm_rit_10 imgItem"><a href="${mapList.temai_11.href}">
           <img src="${mapList.temai_11.imageUrl}" width="565" height="265" />
           <div class="imgMsg">
          	<span>${mapList.temai_11.goodName }</span><br/>
          	<span class="imgMsg-price">￥${mapList.temai_11.price }</span>
          </div>
           </a></div>
      </div>
      <div class="clear"></div>
  </div>
  <jsp:include page="/admin/goods/searchHotGoodsList.jsp" />
<div class="clear"></div>
</div>

<!--======================bottom开始============================-->
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
</form>
</body>
</html>
