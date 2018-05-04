<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
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
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="${news.keywords }" />
<meta http-equiv="description" content="${news.description}" />
<title>${news.firstTitle }</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<link href="css/news.css" rel="stylesheet" type="text/css" />
<link href="web/css/main.css" rel="stylesheet" type="text/css" />

<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
<script type="text/javascript">
	function addfavorite(id) {
		$.ajax({
			url : 'memberCenter/goods!checkSession.action',
			type : 'POST',
			dataType:'JSON',
			success:function(json){
				if(!json){
					var collectUrl = "call/joinCollect/" + id +"/news.html";
					showLogin('mask', 'pop_500', collectUrl, '2', '收藏成功');
				}else{
					$.ajax({
						url : "call/joinCollect/" + id + "/news.html",
						success : function() {
							alert('收藏成功！');
						}
					});
				}
			}
		});
	}
</script>
</head>
<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="/admin/common/navigation.jsp" />	
<div class="breadThumb">
	当前位置： 首页  &gt; 内容详情
</div>
	<div class="ssdp_miad">
		<div class="newszd">
			<h1>${news.firstTitle }</h1>
			<div class="wzly">
				<span>文章来源：${news.resources }</span><span>发布时间：<s:date name="news.createtime" />
				</span><span>发布人：${news.author }</span><span>浏览次数：${news.viewnum }</span>
				<a class="newssc1" onclick="addfavorite('${news.id}')">收藏</a>
			</div>
			<div style="position:relative;">
				    <div class="bdsharebuttonbox" style="top:7px;right:30px;">
					<a href="#" class="bds_more" data-cmd="more"></a>
					<a title="分享到QQ空间" href="#" class="bds_qzone" data-cmd="qzone"></a>
					<a title="分享到新浪微博" href="#" class="bds_tsina" data-cmd="tsina"></a>
					<a title="分享到腾讯微博" href="#" class="bds_tqq" data-cmd="tqq"></a>
					<a title="分享到人人网" href="#" class="bds_renren" data-cmd="renren"></a>
					<a title="分享到微信" href="#" class="bds_weixin" data-cmd="weixin"></a>
					
					</div>
					<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
		
			<div class="wzzy">
				<p class="nrzy">内容摘要</p>
				<h2>${news.secondTitle }</h2>
			</div>
			<div class="newswznr1">${news.content }</div>
		</div>
	<div class="clear"></div>
  </div>
</div>
<div class="clear"></div>
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
 <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>