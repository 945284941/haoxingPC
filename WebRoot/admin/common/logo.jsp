<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(function() {
		selectHeadCartNum();// 执行购物车查询
		$("#searchType").val("1");
		$("#topSearchLike").val();
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
	function search_form(goodsKeyWord,k) {
		var url = "searchGoodsAction!toGoodsList.action";
		$("#topSearchLike").val(goodsKeyWord);
		$("#searchType").val(k);
		if("1" == k){
		}else{
			url = "searchGoodsAction!toCompanyList.action";
		}
		$("#top_search_submit").attr("action",url);
		$("#top_search_submit").submit();
	}
	var top_search_submit = function() {
		var url = "searchGoodsAction!toGoodsList.action";
		var searchType = $("#searchType").val();
		if("1" == searchType){
		}else{
			url = "searchGoodsAction!toCompanyList.action";
		}
		$("#top_search_submit").attr("action",url);
		$("#top_search_submit").submit();
	};
	var changeSearchType = function (e,s,h) {
		$("#searchType").val(e);
		$("#"+s).show();
		$("#"+h).hide();
	}
</script>
<!-- heard -->
<div id="header_form">
	<div class="head_width" id="head_h">
		<div class="head clearfix">
			<div class="logo">
				<a href="#"><img src="images/logo.png" border="0"> </a>
			</div>
			<div class="searchform">
				<form id="top_search_submit" action="searchGoodsListMoreP.html" method="post"><input name="type" id="type" type="hidden" value="goods">
					<div class="toph_bigsearch">
						<div class="toph_sear">
							<ul class="toph_bgsear">
								<li class="this" type="goods">
									<a href="javascript:void(0);" onclick="changeSearchType('1','goodsKeyWords','shopKeyWords');"><s:text name="index_0017"/></a>
								</li>
								<li type="store" style="display: none;">
									<a href="javascript:void(0);" onclick="changeSearchType('2','shopKeyWords','goodsKeyWords');"><s:text name="index_0242"/></a>
								</li>
							</ul>
								<input type="hidden" name="searchType" id="searchType" value="1"/>
								<input name="topSearchLike" class="toph_sear_txt" id="topSearchLike" lang="zh-cn" type="text" placeholder=<s:text name="index_0253"/>  x-webkit-speech="">
								<input name="input" class="toph_sear_btn" style="cursor: pointer;" href="javascript:void(0)" onclick="top_search_submit()" type="button" value=<s:text name="index_0001"/>>

						</div>
						<div class="keyword" id="goodsKeyWords">
							<c:forEach items="${indexKeywordsList}" var="dict" varStatus="status">
							<a onclick="search_form('${dict.label}','1');" href="javascript:void(0);">${dict.label}</a>
							</c:forEach>
						</div>
						<div class="keyword" id="shopKeyWords" style="display: none;">
							<c:forEach items="${indexCompanyKeywordsList}" var="dict" varStatus="status">
								<a onclick="search_form('${dict.label}','2');" href="javascript:void(0);">${dict.label}</a>
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



