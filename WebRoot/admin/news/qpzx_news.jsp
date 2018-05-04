<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<base target="_blank" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<meta http-equiv="keywords" content="" />
<meta http-equiv="description" content="" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/slides.jquery.js"></script>
<link href="css/master.css" rel="stylesheet" type="text/css" />
<link href="css/news.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/common.css" type="text/css"></link>
<title>颐佳官方商城</title>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
<script type="text/javascript">
	$(function(){$('#head_hf_qpzx').addClass('hover');});
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
	<div class="gzgz">
		<div class="rlqz">
		 <!--   <p class="rlqztb">热烈祝贺：泉利汽配网成功上线！！</p>-->

		
		</div>
		<%--<div class="gzgz">
			<marquee width="100%" height="50px" behavior="scroll" direction="left" scrollamount="20" scrolldelay="300" >
				<span id="benison" style="color:#FF0000;font-size:24px;line-height:50px; font-weight:bold;"></span>
			</marquee>
		</div>
	--%></div>
	<div class="dht">
		<a>首页 > 汽配资讯</a>
	</div>
	<div class="gzgz_new">
		<div class="left">
			<div class="shc">
				<div class="jrsc">
					<a href="/"><img src="/images/sp.gif" />
					</a>
				</div>


				<script>
					//保证导航栏背景与图片轮播背景一起显示
					$("#mainbody").removeClass();
					$("#mainbody").addClass("");
				</script>
				<script>
					$(function() {
						//滚动Banner图片的显示
						$('#slides').slides({
							preload : false,
							preloadImage : '/images/loading.gif',
							effect : 'fade',
							slideSpeed : 400,
							fadeSpeed : 100,
							play : 3000,
							pause : 100,
							hoverPause : true
						});
						/**window.setInterval(function(){
							$.ajax( {
								url : 'call/selectBenison.html',
								type : 'POST',
								data : '',
								dataType:'JSON',
								success : function(data) {
									$('#benison').html("");
									var str = '祝福语：';
									for(var i = 0,len = data.length; i<len; i++){
										if(i==0){
											str = str +data[i].name;
										}else {
											str = str + "," +data[i].name;
										}
										
									}
									$('#benison').html(str);
								}
							});
						}, 6000);
						*/
					});
				</script>
				<div id="slides" class="banner banner_new">
				  	<div class="banner_new_1"><a class="prev" ><img alt="上一页" src="/images/banner_l.png" width="24" height="43"/></a></div>
				  	<div class="bannerImg bannernewImg">
					<div class="slides_container">
						<div id="banner_pic_1"><img src="/images/zh.jpg" width="740" height="175"/></div>
						<!--  <div style="DISPLAY: none" id="banner_pic_2"><a href="http://www.qlqpw.com/news/detailZpc/%25E6%25B3%2589%25E5%2588%25A9%25E7%2583%25AD%25E7%2582%25B9/62f49f2b66b446a7b64581e9c63900e4.html" target="_blank"><img  src="/images/dx.jpg" width="740" height="175"/></a></div>-->
						<div style="DISPLAY: none" id="banner_pic_3"><img  src="/images/zz.jpg" width="740" height="175"/></div>
		
					</div>
					</div>
					<div class="banner_new_r"><a class="next" ><img alt="下一页" src="/images/banner_r.png" width="24" height="43"/></a></div>
				</div>

				<!-- 滚动图片 -->

				<!-- zanshi 
				<div class="banner banner_new">
					<img src="/images/banner06.jpg"></img>
				</div>
				-->

			</div>
			<div class="new">
				<div class="xw">
					<p class="schqbt schqbt_new">
						<span class="xwzxz">重配新闻</span><span class="gengd"><a
							href="news/more/<mi:encoder value="重配新闻" />.html">更多>></a>
						</span>
					</p>
					<s:if test="map.top_0.id.length()>0">
						<div class="txw">
							<img src="${map.top_0.newsPic }" width="130px" height="72px" />
						</div>
						<div class="wz">
							<a href="news/detail/${map.top_0.id }.html">${fn:substring(map.top_0.firstTitle,
								0, 19)}</a>
							<p class="wznr">
								${fn:substring(map.top_0.secondTitle, 0, 38)}...<span class="ck"><a
									href="news/detail/${map.top_0.id }.html">【查看全文】</a>
								</span>
							</p>
						</div>
					</s:if>
					<ul class="schqlist schqlist_new">
						<s:if test="%{map.news_0.size()>0}">
							<s:iterator value="%{map.news_0}" id="n">
								<li><span class="schqlistnr2"><a href="news/detail/${n.id }.html" title="${n.firstTitle }">
											<s:if test="%{#n.firstTitle.length()>23}">
												<s:property value="%{#n.firstTitle.substring(0, 23)}" />...</s:if>
											<s:else>
												<s:property value="%{#n.firstTitle}" />
											</s:else> </a>
								</span> <span class="xwzxlidate">[<s:date name="#n.createtime"
											format="yyyy-MM-dd" />] </span></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li>暂无数据!!</li>
						</s:else>
					</ul>
				</div>
				<div class="xw2">
					<p class="schqbt schqbt_new">
						<span class="xwzxz">方针政策</span><span class="gengd"><a
							href="news/more/<mi:encoder value="方针政策" />.html">更多>></a>
						</span>
					</p>
					<s:if test="map.top_1.id.length()>0">
						<div class="txw">
							<img src="${map.top_1.newsPic }" width="130px" height="72px" />
						</div>
						<div class="wz">
							<a href="news/detail/${map.top_1.id }.html">${fn:substring(map.top_1.firstTitle,
								0, 19)}</a>
							<p class="wznr">
								${fn:substring(map.top_1.secondTitle, 0, 38)}...<span class="ck"><a
									href="news/detail/${map.top_1.id }.html">【查看全文】</a>
								</span>
							</p>
						</div>
					</s:if>
					<ul class="schqlist schqlist_new">
						<s:if test="%{map.news_1.size()>0}">
							<s:iterator value="%{map.news_1}" id="n">
								<li><span class="schqlistnr2"><a
										href="news/detail/${n.id }.html" title="${n.firstTitle }">
											<s:if test="%{#n.firstTitle.length()>23}">
												<s:property value="%{#n.firstTitle.substring(0, 23)}" />...</s:if>
											<s:else>
												<s:property value="%{#n.firstTitle}" />
											</s:else> </a>
								</span> <span class="xwzxlidate">[<s:date name="#n.createtime"
											format="yyyy-MM-dd" />] </span></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li>暂无数据!!</li>
						</s:else>
					</ul>
				</div>
			</div>
			<!--  
			<div class="gg">
				<a href="http://www.qlqpw.com/firstExhibition/index.html" target="_blank"><img src="/images/gg33.jpg" />
				</a>
			</div>
			-->
			<div class="new">
				<div class="xw">
					<p class="schqbt schqbt_new">
						<span class="xwzxz">技术前沿</span><span class="gengd"><a
							href="news/more/<mi:encoder value="技术前沿" />.html">更多>></a>
						</span>
					</p>
					<s:if test="map.top_2.id.length()>0">
						<div class="txw">
							<img src="${map.top_2.newsPic }" width="130px" height="72px" />
						</div>
						<div class="wz">
							<a href="news/detail/${map.top_2.id }.html">${fn:substring(map.top_2.firstTitle,
								0, 19)}</a>
							<p class="wznr">
								${fn:substring(map.top_2.secondTitle, 0, 38)}...<span class="ck"><a
									href="news/detail/${map.top_2.id }.html">【查看全文】</a>
								</span>
							</p>
						</div>
					</s:if>
					<ul class="schqlist schqlist_new">
						<s:if test="%{map.news_2.size()>0}">
							<s:iterator value="%{map.news_2}" id="n">
								<li><span class="schqlistnr2"><a
										href="news/detail/${n.id }.html" title="${n.firstTitle }">
											<s:if test="%{#n.firstTitle.length()>23}">
												<s:property value="%{#n.firstTitle.substring(0, 23)}" />...</s:if>
											<s:else>
												<s:property value="%{#n.firstTitle}" />
											</s:else> </a>
								</span> <span class="xwzxlidate">[<s:date name="#n.createtime"
											format="yyyy-MM-dd" />] </span></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li>暂无数据!!</li>
						</s:else>
					</ul>
				</div>
				<div class="xw2">
					<p class="schqbt schqbt_new">
						<span class="xwzxz">产业资讯</span><span class="gengd"><a
							href="news/more/<mi:encoder value="产业资讯" />.html">更多>></a>
						</span>
					</p>
					<s:if test="map.top_3.id.length()>0">
						<div class="txw">
							<img src="${map.top_3.newsPic }" width="130px" height="72px" />
						</div>
						<div class="wz">
							<a href="news/detail/${map.top_3.id }.html">${fn:substring(map.top_3.firstTitle,
								0, 19)}</a>
							<p class="wznr">
								${fn:substring(map.top_3.secondTitle, 0, 38)}...<span class="ck"><a
									href="news/detail/${map.top_3.id }.html">【查看全文】</a>
								</span>
							</p>
						</div>
					</s:if>
					<ul class="schqlist schqlist_new">
						<s:if test="%{map.news_3.size()>0}">
							<s:iterator value="%{map.news_3}" id="n">
								<li><span class="schqlistnr2"><a
										href="news/detail/${n.id }.html" title="${n.firstTitle }">
											<s:if test="%{#n.firstTitle.length()>23}">
												<s:property value="%{#n.firstTitle.substring(0, 23)}" />...</s:if>
											<s:else>
												<s:property value="%{#n.firstTitle}" />
											</s:else> </a>
								</span> <span class="xwzxlidate">[<s:date name="#n.createtime"
											format="yyyy-MM-dd" />] </span></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li>暂无数据!!</li>
						</s:else>
					</ul>
				</div>

			</div>
			<!--  
			<div class="gg">
				<a href="http://qpzx.qlqpw.com" target="_blank"><img src="/images/gg1.jpg" />
				</a>
			</div>
			-->
			<div class="new">
				<div class="xw">
					<p class="schqbt schqbt_new">
						<span class="xwzxz">展会论坛</span><span class="gengd"><a
							href="news/more/<mi:encoder value="展会论坛" />.html">更多>></a>
						</span>
					</p>
					<s:if test="map.top_4.id.length()>0">
						<div class="txw">
							<img src="${map.top_4.newsPic }" width="130px" height="72px" />
						</div>
						<div class="wz">
							<a href="news/detail/${map.top_4.id }.html">${fn:substring(map.top_4.firstTitle,
								0, 19)}</a>
							<p class="wznr">
								${fn:substring(map.top_4.secondTitle, 0, 38)}...<span class="ck"><a
									href="news/detail/${map.top_4.id }.html">【查看全文】</a>
								</span>
							</p>
						</div>
					</s:if>
					<ul class="schqlist schqlist_new">
						<s:if test="%{map.news_4.size()>0}">
							<s:iterator value="%{map.news_4}" id="n">
								<li><span class="schqlistnr2"><a
										href="news/detail/${n.id }.html" title="${n.firstTitle }">
											<s:if test="%{#n.firstTitle.length()>23}">
												<s:property value="%{#n.firstTitle.substring(0, 23)}" />...</s:if>
											<s:else>
												<s:property value="%{#n.firstTitle}" />
											</s:else> </a>
								</span> <span class="xwzxlidate">[<s:date name="#n.createtime"
											format="yyyy-MM-dd" />] </span></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li>暂无数据!!</li>
						</s:else>
					</ul>
				</div>
				<div class="xw2">
					<p class="schqbt schqbt_new">
						<span class="xwzxz">人物访谈</span><span class="gengd"><a
							href="news/more/<mi:encoder value="人物访谈" />.html">更多>></a>
						</span>
					</p>
					<s:if test="map.top_5.id.length()>0">
						<div class="txw">
							<img src="${map.top_5.newsPic }" width="130px" height="72px" />
						</div>
						<div class="wz">
							<a href="news/detail/${map.top_5.id }.html">${fn:substring(map.top_5.firstTitle,
								0, 19)}</a>
							<p class="wznr">
								${fn:substring(map.top_5.secondTitle, 0, 38)}...<span
									class="ck"><a href="news/detail/${map.top_5.id }.html">【查看全文】</a>
								</span>
							</p>
						</div>
					</s:if>
					<ul class="schqlist schqlist_new">
						<s:if test="%{map.news_5.size()>0}">
							<s:iterator value="%{map.news_5}" id="n">
								<li><span class="schqlistnr2"><a
										href="news/detail/${n.id }.html" title="${n.firstTitle }">
											<s:if test="%{#n.firstTitle.length()>23}">
												<s:property value="%{#n.firstTitle.substring(0, 23)}" />...</s:if>
											<s:else>
												<s:property value="%{#n.firstTitle}" />
											</s:else> </a>
								</span> <span class="xwzxlidate">[<s:date name="#n.createtime"
											format="yyyy-MM-dd" />] </span></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li>暂无数据!!</li>
						</s:else>
					</ul>
				</div>

			</div>
			<div class="gg">
				<a href="javascript:void(0)"><img src="/images/gg2.jpg" />
				</a>
			</div>
		</div>
		<div class="right">
			<s:action name="indexFloorAction!showRegionsComRecommendList"
			executeResult="true" namespace="/indexFloor"></s:action>
		</div>
	</div>
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
</body>
</html>
