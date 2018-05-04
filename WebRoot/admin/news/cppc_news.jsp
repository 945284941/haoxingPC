<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<meta http-equiv="keywords" content="产品评测，整车评测，配件评测，汽配评测，卡车评测，商用车评测，重汽配件评测" />
<meta http-equiv="description" content="产品评测频道给您提供最新最专业的整车评测、配件评测，为您购买整车、配件提供最有价值参考。对厂家的产品（汽车或配件）从专业角度进行评价测试，从而指导消费者的购买行为也帮助厂家改良自己的产品。" />
<link href="css/master.css" rel="stylesheet" type="text/css"/>
<link href="css/common.css" rel="stylesheet" type="text/css"/>
<link href="css/news.css" rel="stylesheet" type="text/css" />
<link href="css/mark.css" rel="stylesheet" type="text/css"/>
<title>产品评测</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
<script type="text/javascript">
	$(function(){$('#head_hf_cppc').addClass('hover');});
</script>
</head>

<body id="mainbody">
  <!-- header begin -->
  <div class="header">
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
  </div>
  <div class="logo">
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
  </div>  
  <!-- header end -->

<!-- 代码 开始 -->
<div id="warp">
<div class=" bannerzong">  
   <ul class="mainnavzong">
  	 <jsp:include page="/admin/common/all_hf_Head.jsp" />
   </ul>
   <div class="mainqlzpc">
     <a href="news/news!toQlqpc.action"><img src="images/zpc.gif" alt="泉利重配城" /></a>
   </div>
<div id="menunew">
    <p class="menubt_new"></p>
    <ul class="menuzong menunew">
    </ul>
   </div>
 </div>
 </div>
<div class="dht"><a>首页 > 产品评测</a></div>
<div class="gzgz_new">
 <div class="left">
    <div class="shc">
      <div class="jrsc"><a href="/"><img src="/images/sp.gif"/></a></div>


<script>
	//保证导航栏背景与图片轮播背景一起显示
	$("#mainbody").removeClass();
	$("#mainbody").addClass("");
</script>
<script>
	$(function(){
		//滚动Banner图片的显示
		$('#slides').slides({
			preload: false,
			preloadImage: '/images/loading.gif',
			effect: 'fade',
			slideSpeed: 400,
			fadeSpeed: 100,
			play: 3000,
			pause: 100,
			hoverPause: true
		});
    });
	</script>
    <!-- 滚动图片 -->
    
    
    
  
<div id="slides" class="banner banner_new">
  <div class="banner_new_1"><a class="prev" href="javascript:void(0)"><img alt="上一页" src="/images/banner_l.png" width="24" height="43"/></a></div>
  <div class="bannerImg bannernewImg">
	<div class="slides_container">
		<div id="banner_pic_1"><img src="/images/zh.jpg" width="740" height="175"/></div>
		<div style="DISPLAY: none" id="banner_pic_2"><img  src="/images/dx.jpg" width="740" height="175"/></div>
		<div style="DISPLAY: none" id="banner_pic_3"><img  src="/images/zz.jpg" width="740" height="175"/></div>
		
	</div>
</div>
<div class="banner_new_r"><a class="next" href="javascript:void(0)"><img alt="下一页" src="/images/banner_r.png" width="24" height="43"/></a></div>
</div>
<!-- 滚动图片 -->
</div>
    <div class="new">
      <div class="xw3">
      <p class="schqbt2"><span class="xwzxz">整车评测</span><span class="gengd"><a href="news/more/<mi:encoder value="整车评测" />.html" target="_self">更多&gt;&gt;</a></span></p>
      <s:if test="map.top_0.id.length()>0">
	      <div class="txw"><img src="${map.top_0.newsPic }" width="130px" height="72px" /></div>
	      <div class="wz" style="width:760px;"><a href="news/detail/${map.top_0.id }.html">${fn:substring(map.top_0.firstTitle, 0, 19)}</a>
	      <p class="wznr">${fn:substring(map.top_0.secondTitle, 0,58)}...<span class="ck"><a href="news/detail/${map.top_0.id }.html">【查看全文】</a></span></p>
      </div>
      </s:if>
     <ul class="qchq">
     				<s:if test="%{map.news_0.size()>0}">
						<s:iterator value="%{map.news_0}" id="n" >
							<li><span class="schqlistnr2"> 
									<a href="news/detail/${n.id }.html" title="${n.firstTitle }"> 
										<s:if test="%{#n.firstTitle.length()>23}">
											<s:property value="%{#n.firstTitle.substring(0, 23)}" />...
										</s:if> 
										<s:else>
											<s:property value="%{#n.firstTitle}" />
										</s:else>
									</a>
								</span>
								<span class="xwzxlidate"><s:date name="#n.createtime" format="yyyy-MM-dd" /></span>
							</li>
						</s:iterator>
					</s:if>
					<s:else>
						<li>暂无数据!!</li>
					</s:else>
     </ul>
   </div>
  </div>
   <div class="gg"><a href="/"><img src="images/listgg.gif"/></a></div>
   <div class="new">
   <div class="xw3">
      <p class="schqbt2"><span class="xwzxz">配件评测</span><span class="gengd"><a href="news/more/<mi:encoder value="配件评测" />.html">更多&gt;&gt;</a></span></p>
     	 <s:if test="map.top_1.id.length()>0">
     	   <div class="txw"><img src="${map.top_1.newsPic }" width="130px" height="72px"/></div>
	      <div class="wz" style="width:760px;"><a href="news/detail/${map.top_1.id }.html" >${fn:substring(map.top_1.firstTitle, 0, 19)}</a><p class="wznr">
	      ${fn:substring(map.top_1.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_1.id }.html">【查看全文】</a></span></p></div>
     	</s:if>
     <ul class="qchq">
     		<s:if test="%{map.news_1.size()>0}">
						<s:iterator value="%{map.news_1}" id="n" >
							<li><span class="schqlistnr2"> 
									<a href="news/detail/${n.id }.html" title="${n.firstTitle }"> 
										<s:if test="%{#n.firstTitle.length()>23}">
											<s:property value="%{#n.firstTitle.substring(0, 23)}" />...
										</s:if> 
										<s:else>
											<s:property value="%{#n.firstTitle}" />
										</s:else>
									</a>
								</span>
								<span class="xwzxlidate"><s:date name="#n.createtime" format="yyyy-MM-dd" /></span>
							</li>
						</s:iterator>
					</s:if>
					<s:else>
						<li>暂无数据!!</li>
					</s:else>
     </ul>
   </div>
    </div>
    <div class="gg"><a href="javascript:void(0)"><img src="/images/gg1.jpg"/></a></div>
  </div>
  	<div class="right">
	  	<s:action name="indexFloorAction!showRegionsComRecommendList" executeResult="true" namespace="/indexFloor"></s:action>
  	</div>
</div>
 <!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
	<!-- footer end -->
</body>
</html>
