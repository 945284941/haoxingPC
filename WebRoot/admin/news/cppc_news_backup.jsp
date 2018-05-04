<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<link href="css/master.css" rel="stylesheet" type="text/css"/>
<link href="css/common.css" rel="stylesheet" type="text/css"/>
<link href="css/news.css" rel="stylesheet" type="text/css" />
<title>产品评测</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
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
  	 <li><a href="http://www.qlqpw.com" target="_self">商城首页</a></li>
     <li><a href="qpzx.html">汽配资讯</a></li>
     <li><a href="activeIndex.jsp">重配学院</a></li>
     <li><a class="hover" href="cppc.html">产品评测</a></li>
     <li><a href="schq.html">市场行情</a></li>
     <li><a href="gqxx.html">供求信息</a></li>
     <li><a href="unCreate.jsp">泉利杂志</a></li>
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
      <div class="jrsc"><a href="/"><img src="images/sp.gif"/></a></div>


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
  <div class="banner_new_1"><a class="prev" href="javascript:void(0)"><img alt="上一页" src="images/banner_l.png" width="24" height="43"/></a></div>
  <div class="bannerImg bannernewImg">
	<div class="slides_container">
		<div id="banner_pic_1"><img src="images/dx.jpg" width="740" height="175"/></div>
		<div style="DISPLAY: none" id="banner_pic_2"><img  src="images/gghd.jpg" width="740" height="175"/></div>
	</div>
</div>
<div class="banner_new_r"><a class="next" href="javascript:void(0)"><img alt="下一页" src="images/banner_r.png" width="24" height="43"/></a></div>
</div>
<!-- 滚动图片 -->
</div>
    <div class="new">
      <div class="xw">
      <p class="schqbt schqbt_new"><span class="xwzxz">整车评测</span><span class="gengd2">| 牵引车评测 - 自卸车评测 - 载货车评测</span><span class="gengd"><a href="news/more/zcpc.html">更多&gt;&gt;</a></span></p>
      <s:if test="map.top_0.id.length()>0">
	      <div class="txw"><img src="${map.top_0.newsPic }" width="130px" height="72px" /></div>
	      <div class="wz"><a href="news/detail/${map.top_0.id }.html">${fn:substring(map.top_0.firstTitle, 0, 19)}</a>
	      <p class="wznr">${fn:substring(map.top_0.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_0.id }.html">【查看全文】</a></span></p>
      </div>
      </s:if>
     <ul class="schqlist schqlist_new">
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
   <div class="xw2">
      <p class="schqbt schqbt_new"><span class="xwzxz">发动机评测</span><span class="gengd"><a href="news/more/fdjpc.html">更多&gt;&gt;</a></span></p>
     	 <s:if test="map.top_1.id.length()>0">
     	   <div class="txw"><img src="${map.top_1.newsPic }"/></div>
	      <div class="wz"><a href="news/detail/${map.top_0.id }.html" >${fn:substring(map.top_1.firstTitle, 0, 19)}</a><p class="wznr">
	      ${fn:substring(map.top_1.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_1.id }.html">【查看全文】</a></span></p></div>
     	</s:if>
     <ul class="schqlist schqlist_new">
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
    <div class="gg"><a href="javascript:void(0)"><img src="images/gg1.jpg"/></a></div>
    <div class="new">
     <div class="xw">
      <p class="schqbt schqbt_new"><span class="xwzxz">发动机附件评测</span><span class="gengd"><a href="news/more/fdjfjpc.html">更多&gt;&gt;</a></span></p>
      	 <s:if test="map.top_2.id.length()>0">
      <div class="txw"><img src="${map.top_2.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_2.id }.html">${fn:substring(map.top_2.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_2.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_2.id }.html">【查看全文】</a></span></p>
      </div>
      </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_2.size()>0}">
						<s:iterator value="%{map.news_2}" id="n" >
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
   <div class="xw2">
      <p class="schqbt schqbt_new"><span class="xwzxz">驾驶室评测</span><span class="gengd"><a href="news/more/jsspc.html">更多&gt;</a></span></p>
       <s:if test="map.top_3.id.length()>0">
      <div class="txw"><img src="${map.top_3.newsPic }"/></div>
      <div class="wz"><a href="news/detail/${map.top_3.id }.html" >${fn:substring(map.top_3.firstTitle, 0, 19)}</a><p class="wznr">
      ${fn:substring(map.top_3.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_3.id }.html">【查看全文】</a></span></p></div>
      </s:if>
     <ul class="schqlist schqlist_new">
     		<s:if test="%{map.news_3.size()>0}">
						<s:iterator value="%{map.news_3}" id="n" >
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
    <div class="gg"><a href="javascript:void(0)"><img src="images/gg2.jpg"/></a></div>
    <div class="new">
     <div class="xw">
      <p class="schqbt schqbt_new"><span class="xwzxz">变速器总成评测</span><span class="gengd"><a href="news/more/bsqzcpc.html">更多&gt;</a></span></p>
       <s:if test="map.top_4.id.length()>0">
      <div class="txw"><img src="${map.top_4.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_4.id }.html">${fn:substring(map.top_4.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_4.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_4.id }.html">【查看全文】</a></span></p>
      </div>
       </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_4.size()>0}">
						<s:iterator value="%{map.news_4}" id="n" >
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
   <div class="xw2">
      <p class="schqbt schqbt_new"><span class="xwzxz">离合器评测</span><span class="gengd"><a href="news/more/lhqpc.html">更多&gt;&gt;</a></span></p>
       <s:if test="map.top_5.id.length()>0">
      <div class="txw"><img src="${map.top_5.newsPic }"/></div>
      <div class="wz"><a href="news/detail/${map.top_5.id }.html" >${fn:substring(map.top_5.firstTitle, 0, 19)}</a><p class="wznr">
      ${fn:substring(map.top_5.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_5.id }.html">【查看全文】</a></span></p></div>
       </s:if>
     <ul class="schqlist schqlist_new">
     		<s:if test="%{map.news_5.size()>0}">
						<s:iterator value="%{map.news_5}" id="n" >
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
    <!--<div class="gg"><a href="javascript:void(0)"><img src="images/gg3.jpg"/></a></div>-->
    <div class="new">
      <div class="xw">
      <p class="schqbt schqbt_new"><span class="xwzxz">转向系统评测</span><span class="gengd"><a href="news/more/zxxtpc.html">更多&gt;&gt;</a></span></p>
       <s:if test="map.top_6.id.length()>0">
      <div class="txw"><img src="${map.top_6.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_6.id }.html">${fn:substring(map.top_6.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_6.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_6.id }.html">【查看全文】</a></span></p>
      </div>
       </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_6.size()>0}">
						<s:iterator value="%{map.news_6}" id="n" >
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
   <div class="xw2">
     <p class="schqbt schqbt_new"><span class="xwzxz">挂车评测</span><span class="gengd"><a href="news/more/gcpc.html">更多&gt;&gt;</a></span></p>
      <s:if test="map.top_7.id.length()>0">
      <div class="txw"><img src="${map.top_7.newsPic }"/></div>
      <div class="wz"><a href="news/detail/${map.top_7.id }.html" >${fn:substring(map.top_7.firstTitle, 0, 19)}</a><p class="wznr">
      ${fn:substring(map.top_7.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_7.id }.html">【查看全文】</a></span></p></div>
       </s:if>
     <ul class="schqlist schqlist_new">
     		<s:if test="%{map.news_7.size()>0}">
						<s:iterator value="%{map.news_7}" id="n" >
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
    <div class="gg"><a href="javascript:void(0)"><img src="images/gg4.jpg"/></a></div>
    <div class="new">
      <div class="xw">
      <p class="schqbt schqbt_new"><span class="xwzxz">电器系统评测</span><span class="gengd"><a href="news/more/dqxtpc.html">更多&gt;&gt;</a></span></p>
       <s:if test="map.top_8.id.length()>0">
      <div class="txw"><img src="${map.top_8.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_8.id }.html">${fn:substring(map.top_8.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_8.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_8.id }.html">【查看全文】</a></span></p>
      </div> </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_8.size()>0}">
						<s:iterator value="%{map.news_8}" id="n" >
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
   <div class="xw2">
      <p class="schqbt schqbt_new"><span class="xwzxz">传动评测</span><span class="gengd"><a href="news/more/cdpc.html">更多&gt;&gt;</a></span></p>
       <s:if test="map.top_9.id.length()>0">
      <div class="txw"><img src="${map.top_9.newsPic }"/></div>
      <div class="wz"><a href="news/detail/${map.top_9.id }.html" >${fn:substring(map.top_9.firstTitle, 0, 19)}</a><p class="wznr">
      ${fn:substring(map.top_9.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_9.id }.html">【查看全文】</a></span></p></div> </s:if>
     <ul class="schqlist schqlist_new">
     		<s:if test="%{map.news_9.size()>0}">
						<s:iterator value="%{map.news_9}" id="n" >
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
    <div class="gg"><a href="javascript:void(0)"><img src="images/gg1.jpg"/></a></div>
    <div class="new">
      <div class="xw">
      <p class="schqbt schqbt_new"><span class="xwzxz">悬挂评测</span><span class="gengd"><a href="news/more/xgpc.html">更多&gt;&gt;</a></span></p>
       <s:if test="map.top_10.id.length()>0">
      <div class="txw"><img src="${map.top_10.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_10.id }.html">${fn:substring(map.top_10.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_10.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_10.id }.html">【查看全文】</a></span></p>
      </div> </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_10.size()>0}">
						<s:iterator value="%{map.news_10}" id="n" >
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
   <div class="xw2">
     <p class="schqbt schqbt_new"><span class="xwzxz">车架评测</span><span class="gengd"><a href="news/more/cjpc.html">更多>></a></span></p>
      <s:if test="map.top_11.id.length()>0">
      <div class="txw"><img src="${map.top_11.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_11.id }.html">${fn:substring(map.top_11.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_11.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_11.id }.html">【查看全文】</a></span></p>
      </div> </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_11.size()>0}">
						<s:iterator value="%{map.news_11}" id="n" >
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
    <div class="gg"><a href="javascript:void(0)"><img src="images/gg2.jpg"/></a></div>
    <div class="new">
      <div class="xw">
      <p class="schqbt schqbt_new"><span class="xwzxz">自卸上装评测</span><span class="gengd"><a href="news/more/zxszpc.html">更多>></a></span></p>
       <s:if test="map.top_12.id.length()>0">
      <div class="txw"><img src="${map.top_12.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_12.id }.html">${fn:substring(map.top_12.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_12.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_12.id }.html">【查看全文】</a></span></p>
      </div> </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_12.size()>0}">
						<s:iterator value="%{map.news_12}" id="n" >
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
   <div class="xw2">
      <p class="schqbt schqbt_new"><span class="xwzxz">前中后桥评测</span><span class="gengd"><a href="news/more/qzhqpc.html">更多>></a></span></p>
       <s:if test="map.top_13.id.length()>0">
      <div class="txw"><img src="${map.top_13.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_13.id }.html">${fn:substring(map.top_13.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_13.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_13.id }.html">【查看全文】</a></span></p>
      </div> </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_13.size()>0}">
						<s:iterator value="%{map.news_13}" id="n" >
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
    <!--<div class="gg"><a href="javascript:void(0)"><img src="images/gg3.jpg"/></a></div>-->
    <div class="new">
      <div class="xw">
      <p class="schqbt schqbt_new"><span class="xwzxz">制动系统评测</span><span class="gengd"><a href="news/more/zdxtpc.html">更多>></a></span></p>
       <s:if test="map.top_14.id.length()>0">
      <div class="txw"><img src="${map.top_14.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_14.id }.html">${fn:substring(map.top_14.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_14.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_14.id }.html">【查看全文】</a></span></p>
      </div> </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_14.size()>0}">
						<s:iterator value="%{map.news_14}" id="n" >
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
   <div class="xw2">
      <p class="schqbt schqbt_new"><span class="xwzxz">油品评测</span><span class="gengd"><a href="news/more/yppc.html">更多>></a></span></p>
      <s:if test="map.top_15.id.length()>0">
      <div class="txw"><img src="${map.top_15.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_15.id }.html">${fn:substring(map.top_15.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_15.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_15.id }.html">【查看全文】</a></span></p>
      </div> 
      </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_15.size()>0}">
						<s:iterator value="%{map.news_15}" id="n" >
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
    <div class="gg"><a href="javascript:void(0)"><img src="images/gg4.jpg"/></a></div>
    <div class="new">
      <div class="xw">
      <p class="schqbt schqbt_new"><span class="xwzxz">螺栓及螺母</span><span class="gengd"><a href="news/more/lsjlmpc.html">更多>></a></span></p>
       <s:if test="map.top_16.id.length()>0">
      <div class="txw"><img src="${map.top_16.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_16.id }.html">${fn:substring(map.top_16.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_16.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_16.id }.html">【查看全文】</a></span></p>
      </div> </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_16.size()>0}">
						<s:iterator value="%{map.news_16}" id="n" >
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
   <div class="xw2">
      <p class="schqbt schqbt_new"><span class="xwzxz">轴承评测</span><span class="gengd"><a href="news/more/zhouchengpc.html">更多>></a></span></p>
       <s:if test="map.top_17.id.length()>0">
      <div class="txw"><img src="${map.top_17.newsPic }" width="130px" height="72px" /></div>
      <div class="wz"><a href="news/detail/${map.top_17.id }.html">${fn:substring(map.top_17.firstTitle, 0, 19)}</a>
      <p class="wznr">${fn:substring(map.top_17.secondTitle, 0, 40)}...<span class="ck"><a href="news/detail/${map.top_17.id }.html">【查看全文】</a></span></p>
      </div> 
      </s:if>
     <ul class="schqlist schqlist_new">
     				<s:if test="%{map.news_17.size()>0}">
						<s:iterator value="%{map.news_17}" id="n" >
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
