<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="../../js/changeLanguage.js"></script>
<script type="text/javascript" charset="utf-8">
    mui('body').on('tap','a',function(){
        window.top.location.href=this.href;
    });
</script>
<nav class="mui-bar mui-bar-tab my_foot">
	<a class="mui-tab-item mui-active" href="#" >
		<span class="mui-icon iconfont">&#xe604;</span>
		<span class="mui-tab-label">首页</span>
	</a>
	<a class="mui-tab-item" href="#">
		<span class="mui-icon iconfont">&#xe6fa;</span>
		<span class="mui-tab-label">分类</span>
	</a>
	<a class="mui-tab-item" target="_blank" href="person/order/huiyuanzhongxin.html">
		<img class="foot_avatar" src="/wap/images/avatar.jpg" />
	</a>
	<a class="mui-tab-item" href="http://www.baidu.com">
		<span class="mui-icon iconfont">&#xe778;</span>
		<span class="mui-tab-label">购物车</span>
	</a>
	<a class="mui-tab-item" href="#">
		<span class="mui-icon iconfont">&#xe6be;</span>
		<span class="mui-tab-label">中文</span>
	</a>
</nav>