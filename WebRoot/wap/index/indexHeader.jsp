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

</script>
	<div class="addPopover_2" style="position: relative;">
		<a href="#Popover_2" id="meau" class="mui-icon mui-pull-right iconfont">&#xe617;</a>
		<div id="Popover_2" class="mui-popover mui-bar-popover meau_down">
			<div class="mui-popover-arrow"></div>
			<ul class="">
				<li class="mui-table-view-cell">
					<a href="1.0index.html"><i class="iconfont">&#xe604;</i> 首页</a>
				</li>
				<li class="mui-table-view-cell">
					<a href=""><i class="iconfont">&#xe600;</i>分类搜索</a>
				</li>
				<li class="mui-table-view-cell">
					<a href="5.1购物车管理.html"><i class="iconfont">&#xe778;</i>购物车</a>
				</li>
				<li class="mui-table-view-cell">
					<a href=""><i class="iconfont">&#xe66e;</i>我的</a>
				</li>
			</ul>
		</div>
	</div>