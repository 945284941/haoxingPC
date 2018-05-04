<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/JavaScript">
	var menuId = '${menuId}';
	$(function() {
		$("#menu_" + menuId).addClass("hover");
	});
</script>
<div class="gzgz banner">
		<ul class="main">
			<li><a id="menu_0" href="/Shop/index_${company.id}.html">网站首页</a>
			</li>
			<li><a id="menu_1" href="/Shop/comProfile/${company.id}.html">企业简介</a>
			</li>
			<li><a id="menu_2" href="/Shop/comInformation/list/${company.id}.html">企业资讯</a>
			</li>
			<li><a id="menu_3" href="/Shop/comGoods/list/${company.id}.html">主营产品</a>
			</li>
			<li><a id="menu_4" href="/Shop/contact/${company.id}.html">联系我们</a>
			</li>
			<li><a id="menu_5" href="/Shop/comMessage/list/${company.id}.html">客户留言</a>
			</li>
		</ul>
		<p>
			咨询电话：
			<s:if test="null!=company.telphone && ''!=company.telphone">${company.telphone}</s:if>
			<s:else>---</s:else>
		</p>
	</div>