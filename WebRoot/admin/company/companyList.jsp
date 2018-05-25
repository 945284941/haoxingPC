<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta content="IE=11.0000" http-equiv="X-UA-Compatible">
	<title>颐佳超市</title>
	<meta name="keywords" content="颐佳超市">
	<meta name="description" content="颐佳超市">
	<meta name="GENERATOR" content="颐佳超市">
	<meta name="author" content="颐佳超市">
	<meta name="copyright" content="颐佳超市">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="3c0d2bedd819ab1c" property="wb:webmaster">
	<jsp:include page="../common/keyWords.jsp" flush="true"/>
</head>
<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<s:action name="catalogueAction!queryFullCategory" executeResult="true" namespace="/" >
	<s:param name="catType">cs</s:param>
</s:action>
<div class="main">
	<div class="h_seat">
		<a href="/">首页</a>>
		<a>商家列表</a>
	</div>
	<div class="lh_sssp02">
		<form id="searchCompanyForm" action="searchGoodsAction!searchGoods.action" method="post">
			<input type="hidden" value="2" name="searchType" id="searchType"/>
			<div class="lh_sssp02_dq">地区</div>
			<input id="address" name="address" type="text" placeholder="请输入关键字！" />
		</form>
		<a href="javascript:searchCompany();" class="lh_sssp02_an">确定</a>
	</div>
	<div id="pageReload">

	</div>
</div>
<!--======================bottom开始============================-->
<s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
<script type="text/javascript">
	$(function () {
		searchCompany();
	});
function searchCompany() {
		var url="searchGoodsAction!searchGoods.action";
		$.ajax({
			type:"POST",
			url:url,
			cache:true,
			async:true,
			data : $('#searchCompanyForm').serialize(),
			success:function (html) {
				$("#pageReload").html(html);
			}
		});
}

</script>
</body>
</html>
