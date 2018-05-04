<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(function() {
		selectHeadCartNum();// 执行购物车查询
	});
	function selectHeadCartNum() {
		$.ajax({
			url : "call/checkCartNum.html",
			type: "post",
			dataType : "JSON",
			success : function(num) {
				$("#admin_common_head_cartTotal").empty();
				$("#admin_common_head_cartTotal").append(num);//更新购物车的商品总数量
			}
		});
	}
	var top_search_submit = function() {
		$('#top_search_submit').submit();
	};
</script>
<!-- heard -->
<div id="header_form">
	<div class="head_width" id="head_h">
		<div class="head clearfix">
			<div class="logo">
				<a href="#"><img src="images/logo.png" border="0"> </a>
			</div>
			<div class="searchform">
				<form id="searchform" action="searchGoodsListMoreP.html" method="post" target="_blank"><input name="type" id="type" type="hidden" value="goods">
					<div class="toph_bigsearch">
						<div class="toph_sear">
							<ul class="toph_bgsear">
								<li class="this" type="goods">
									<a href="javascript:void(0);"><s:text name="index_0017"/><s></s></a>
								</li>
								<li type="store" style="display: none;">
									<a href="javascript:void(0);"><s:text name="index_0242"/></a>
								</li>
							</ul>
								<input name="keyword" class="toph_sear_txt" id="keyword" lang="zh-cn" type="text" placeholder=<s:text name="index_0253"/> value="" onwebkitspeechchange="jquery('#searchform').submit()" x-webkit-speech="">
								<input name="input" class="toph_sear_btn" style="cursor: pointer;" href="javascript:void(0)" onclick="search_form()" type="button" value=<s:text name="index_0001"/>>

						</div>
						<div class="keyword">
							<c:forEach items="${indexKeywordsList}" var="dict" varStatus="status">
							<a onclick="search_form('${dict.label}','goods');" href="javascript:void(0);">${dict.label}</a>
							</c:forEach>
						</div>
					</div>
				</form>
			</div>
			<div class="lh_gwc"><span><a href="call/goToCart.html"><i class="icon iconfont">&#xe653;</i><s:text name="index_0015"/> <strong style="color:#FBC91D;" class="sghsc-banner-shop-mnr" id="admin_common_head_cartTotal">0</strong> <s:text name="index_0029"/></a></span></div>
		</div>
	</div>
</div>
<!-- heard结束 -->



