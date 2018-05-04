<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta name="description" content="潜心修炼100天 笑傲江湖100年" />
		<meta name="keywords" content="潜心修炼100天 笑傲江湖100年" />
		<meta http-equiv="x-ua-compatible" content="ie=7" />
		<title>三古汇官方商城</title>
		<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
		<link href="css/master.css" rel="stylesheet" type="text/css"/>
		<link href="css/news.css" rel="stylesheet" type="text/css"/>
		<link href="css/shophy.css" rel="stylesheet" type="text/css"/>
		<link href="css/common.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript">
var times = 6;
$(function() {
	clock();
});

function clock() {
	window.setTimeout('clock()', 100000000000000000000);
	times = times - 1;
	if (times == -1) {
		window.location.href = "/";
	} else {
		time.innerHTML = times;
	}
}
</script>
	</head>

	<body>
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	<jsp:include page="../common/navigation.jsp"></jsp:include>
	<div class="breadThumb">首页 > 企业注册</div>

		<div class="hdzxtg">
			<div class="huiyuanbt">
				<p class="huiyuanbtgr">
					个人会员
				</p>
				<p class="huiyuanbtqynew">
					企业会员
				</p>
			</div>
			<div class="hyzcmain">
				<div class="hyfore4">
					
				</div>
				<div class="hyhdxznr">
					<p class="hycgzc">
						恭喜您：会员
						<s:if test="#attr.sessionInfo.loginNickName!=null">
         	${sessionInfo.loginNickName}
         </s:if>
						<s:else>
       		 ${sessionInfo.loginName}
        </s:else>
						，
						<span class="red">已经完成信息提交</span>！
					</p>
					<p class="zucgtz">
						站方客服会在1个工作日进行信息审核，并发至您填写的电子邮箱地址，请注意查收，谢谢合作，祝您愉快！
						<span id="time">5</span>秒钟后自动跳转至网站首页……请稍候……
					</p>

				</div>
				<div class="onean">
					<a href="index.jsp"><img src="images/fhsyan.gif" />
					</a>
				</div>
			</div>
		</div>
	<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
		<!-- footer end -->
<jsp:include page="/admin/common/indexFooter.jsp" />
	</body>
</html>

