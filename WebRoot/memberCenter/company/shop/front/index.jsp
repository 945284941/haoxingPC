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
<title>古粮今典在线商城</title>
<link rel="stylesheet" href="web/slideBox/css/jquery.slideBox.css"  type="text/css"></link>
<link rel="stylesheet" href="web/css/main.css"  type="text/css"></link>
<link href="web/css/zishangpu.css" rel="stylesheet"  type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="web/slideBox/js/jquery.slideBox.js"></script>
</head>

<body>
<!--======================top开始============================-->
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
 <s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<!--======================导航开始============================-->
<jsp:include page="/admin/common/navigation.jsp" />
<!--======================top结束============================-->
<div class="zsp_mian">
    <div id="slideBar" class="zsp_top slideBox">
    	<ul class="items">
    			<s:if test="%{companysHeadImgs.size()>0}">
				<s:iterator value="companysHeadImgs" var="chi" status="st">
					<s:if test="#st.first">
						  <li><a href="/shop" title=""><img src="<s:property value='#chi.imgSrc'/>"></a></li>
					</s:if>
					<s:else>
						  <li><a href="/shop" title=""><img src="web/images/zishangpu/zsp_banner.png"></a></li>
					</s:else>
				</s:iterator>
			</s:if>
		</ul>
    </div>
    <div class="zsp_cx">
        <div class="zsp_cx_let"><a href="${cmp.cmp_0.href }"><img class="imgArray" data-id="0" src="${cmp.cmp_0.imageUrl }" width="415" height="422" /></a></div>
        <div class="zsp_cx_rit">
            <div style="width:460; height:208; border:#CCCCCC solid 1px;"><a href="${cmp.cmp_1.href }"><img  class="imgArray" data-id="1" src="${cmp.cmp_1.imageUrl }" width="458" height="208" /></a></div>
            <div style="width:460; height:208;margin-top:5px; border:#CCCCCC solid 1px;"><a href="${cmp.cmp_2.href }"><img  class="imgArray" data-id="2"  src="${cmp.cmp_2.imageUrl }" width="458" height="208" /></a></div>
        </div>
    </div>
    <div class="clear"></div>
    <div class="zsp_man_03">
        <div class="zsp_main_05top"><img src="${cmp.cmp_3.imageUrl }" width="888" height="145" /></div>
        <div style="width:888; height:316;margin-top:5px; border:#CCCCCC solid 1px;"><a href="${cmp.cmp_4.href }"><img src="${cmp.cmp_4.imageUrl }" width="888" height="316" /></a></div>
        <div class="zsp_man_03_tu" >
                <div class="zsp_man_03_tu1"><a href="${cmp.cmp_5.href }"><img src="${cmp.cmp_5.imageUrl }" width="439" height="223" /></a></div>
                <div class="zsp_man_03_tu2"><a href="${cmp.cmp_6.href }"><img src="${cmp.cmp_6.imageUrl }" width="439" height="223" /></a></div>
        </div>
        <div class="clear"></div>
             <div class="zsp_man_03_tu" >
                <div class="zsp_man_03_tu1"><a href="${cmp.cmp_7.href }"><img src="${cmp.cmp_7.imageUrl }" width="439" height="223" /></a></div>
                <div class="zsp_man_03_tu2"><a href="${cmp.cmp_8.href }"><img src="${cmp.cmp_8.imageUrl }" width="439" height="223" /></a></div>
             </div>
             <div class="clear"></div>
        <div class="zsp_man_03_bot"><a href="${cmp.cmp_10.href }"><img src="${cmp.cmp_10.imageUrl }" width="888" height="318" /></a></div>
    </div>
    <div class="zsp_man_03">
        <div  class="zsp_main_04top"><img src="${cmp.cmp_11.imageUrl }" width="888" height="100" /></div>
        <div class="zsp_main_04bot">
            <div class="zsp_main_04bot_one"><a href="${cmp.cmp_12.href }"><img src="${cmp.cmp_12.imageUrl }" width="221" height="321" /></a></div>
            <div class="zsp_main_04bot_one"><a href="${cmp.cmp_13.href }"><img src="${cmp.cmp_13.imageUrl }" width="221" height="321" /></a></div>
            <div class="zsp_main_04bot_one"><a href="${cmp.cmp_14.href }"><img src="${cmp.cmp_14.imageUrl }" width="221" height="321" /></a></div>
            <div class="zsp_main_04bot_one"><a href="${cmp.cmp_15.href }"><img src="${cmp.cmp_15.imageUrl }" width="221" height="321" /></a></div>
            <div class="zsp_main_04bot_one"><a href="${cmp.cmp_16.href }"><img src="${cmp.cmp_16.imageUrl }" width="221" height="321" /></a></div>
            <div class="zsp_main_04bot_one"><a href="${cmp.cmp_17.href }"><img src="${cmp.cmp_17.imageUrl }" width="221" height="321" /></a></div>
            <div class="zsp_main_04bot_one"><a href="${cmp.cmp_18.href }"><img src="${cmp.cmp_18.imageUrl }" width="221" height="321" /></a></div>
            <div class="zsp_main_04bot_one"><a href="${cmp.cmp_19.href }"><img src="${cmp.cmp_19.imageUrl }" width="221" height="321" /></a></div>
        </div>
        <div class="clear"></div>
    </div> 
    <div class="zsp_man_03">
         <div class="zsp_main_05top"><img src="${cmp.cmp_20.imageUrl }" width="888" height="145" /></div>
         <div style="width:888; height:312;margin-top:5px; border:#CCCCCC solid 1px;"><a href="${cmp.cmp_21.href }"><img src="${cmp.cmp_21.imageUrl }" width="888" height="312" /></a></div>
         <div>
         <div class="zsp_main_05bot1"><a href="${cmp.cmp_22.href }"><img src="${cmp.cmp_22.imageUrl }" width="439" height="370" /></a></div>
         <div class="zsp_main_05bot2"><a href="${cmp.cmp_23.href }"><img src="${cmp.cmp_23.imageUrl }" width="439" height="370" /></a></div>
         </div>
         <div class="clear"></div>
         <div>
         <div class="zsp_main_05bot1"><a href="${cmp.cmp_24.href }"><img src="${cmp.cmp_24.imageUrl }" width="439" height="370" /></a></div>
         <div class="zsp_main_05bot2"><a href="${cmp.cmp_25.href }"><img src="${cmp.cmp_25.imageUrl }" width="439" height="370" /></a></div>
         </div>
         <div class="clear"></div>
    </div>
    <div class="zsp_mian_bot" ><a href="${cmp.cmp_26.href }"><img src ="${cmp.cmp_26.imageUrl }"  /></a></div>
</div>
<div class="clear"></div>

<!--======================bottom开始============================-->
<jsp:include page="/admin/common/indexFooter.jsp" />
</form>
<script type="text/javascript">
$(function(){
	$('#slideBar').slideBox({
		width:'100%',
		height:357,
		direction : 'top',
		duration : 0.3,//滚动持续时间，单位：秒
		easing : 'linear',//swing,linear//滚动特效
		delay : 5,//滚动延迟时间，单位：秒
		hideClickBar : false,//不自动隐藏点选按键
		startIndex : 1,//初始焦点顺序
		clickBarRadius : 2
	});
})
</script>
</body>
</html>
