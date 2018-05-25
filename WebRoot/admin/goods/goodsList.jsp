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
		<a>商品列表</a>
	</div>
	<div class="bd_cx_nav">
		<div class="cx_nav">
			<dl>
				<dt>板&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;块：</dt>
				<dd>
					<p>
						<a href="javascript:changeBanku(0);" class="bankuai">不限</a>
						<a href="javascript:changeBanku(1);" class="bankuai">平台</a>
						<a href="javascript:changeBanku(2);" class="bankuai">超市</a>
						<a href="javascript:changeBanku(3);" class="bankuai">建材设备</a>
					</p>
				</dd>
			</dl>

				<dl id="first_1" style="display: none">
				<dt>分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类：</dt>
				<dd>
					<div id="fenlei_1">
						<a  id="first_1_1" class="on">不限</a>
					</div>
					<div id="fenlei_2" style="display: none">

					</div>
					<div id="fenlei_3" style="display: none">

					</div>
				</dd>
			</dl>
			<form id="searchGoodsForm" action="searchGoodsAction!searchGoods.action" method="post">
				<input type="hidden" name="catId" id="catId" value="${catId}">
				<input type="hidden" name="bankuaiType" id="bankuaiType" value="${bankuaiType}"/>
				<input type="hidden" name="isZiying" id="isZiying" value="${isZiying}">
				<input type="hidden" name="priceType" id="priceType" value="${priceType}"/>
				<input type="hidden" name="searchType" id="searchType" value="1"/>
				<input type="hidden" name="orderBySort" id="orderBySort" value="0"/>
				<input type="hidden" name="isIndexShop" id="isIndexShop" value="${isIndexShop}"/>
				<input type="hidden" name="isIndexMarket" id="isIndexMarket" value="${isIndexMarket}"/>
				<input type="hidden" name="isIndexBuild" id="isIndexBuild" value="${isIndexBuild}"/>
			<dl>
				<dt>所在区域</dt>
				<dd>
					<div class="query">
							<div class="query_date">
								<input id="address" name="address" type="text" placeholder="请输入地址">
							</div>
					</div>
				</dd>
			</dl>
			<dl>
				<dt>价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</dt>
				<dd>
					<div class="query">
						<form>
							<div class="query_date">
								<input id="minPrice" name="minPrice" type="text" placeholder="最低价格">
							</div>
							<div class="query_date_zj bort"></div>
							<div class="query_date">
								<input id="maxPrice" name="maxPrice" type="text" placeholder="最高价格">
							</div>
							<div class="query_date_bom">
								<a href="javascript:searchGoods();">查询</a>
							</div>
						</form>
					</div>
					<div class="clear"></div>
					<div class="bizhong_xz">
						<div onclick="changePrice(0,'1');" class="jiage on">￥</div><div class="jiage" onclick="changePrice(1,'3');">$</div><div class="jiage" onclick="changePrice(2,'2');">AED</div>
					</div>
				</dd>
			</dl>
			</form>
		</div>
	</div>

	<div class="l_paixun">
		<div class="pl_px">
			<a id="l_pl_h" class="active" >排序</a>
			<a class="paixu active" href="javascript:checkSort(0);">默认排序
				<font></font>
			</a>
			<a class="paixu" href="javascript:checkSort(1);">销量
				<font></font>
			</a>
			<a class="paixu" href="javascript:checkSort(2);">价格
				<font></font>
			</a>
			<div class="pl_px_zkjd">
				<input id="ziying" name="ziying" type="checkbox"  onclick="checkZiying();" />仅看自营</div>
		</div>
	</div>
	<div id="pageReload">

	</div>
</div>
<!--======================bottom开始============================-->
<s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
<script type="text/javascript">
	var yuyan = '${sessionInfo.language}';
	var cat1Arr = [];
	var cat2Arr = [];
	var cat3Arr = [];
	var catSecond = {};
	var catThree = {};
	var bankuaiArr = document.getElementsByClassName("bankuai");
	var t = $("#bankuaiType").val();
	var ziying = $("#isZiying").val();
	if("" == t){
		t = "0";
		$("#bankuaiType").val(t);
	}
	$(function () {
		for(var i = 0; i < bankuaiArr.length; i++) {
			if(i == parseInt(t)){
				bankuaiArr[i].classList.add("on");
			}else{
				bankuaiArr[i].classList.remove("on");
			}
		}
		if(ziying == "0"){
			$("#ziying").attr("checked", true);
		}
		$.ajax({
			type:'POST',
			url:'catalogueAction!gailAllGoodsCat.action',
			data :{"pid":'0'},
			dataType:'json',
			success:function(obj){
				cat1Arr = obj[1];
				cat2Arr = obj[2];
				cat3Arr = obj[3];
			},
			error : function() {
				alert('请求失败!');
				return false;
			}
		});
		searchGoods();
	});
	function checkOn(e){
		var cArr = document.getElementsByClassName(e);
		for(var i = 0; i < cArr.length; i++) {
			cArr[i].classList.remove("on");
		}
	}

	function changeBanku(a) {
		$("#bankuaiType").val(a);
		$("#catId").val("");
		var fcatArray = [];
		for(var i = 0; i < bankuaiArr.length; i++) {
			if(i == parseInt(a)){
				//重新装载
				$("#fenlei_1").empty();
				$("#fenlei_1").append("<a id= 'first_1_1' href=\"javascript:checkFenlei('');\" class='first_1_1 on'>不限</a>");
				if(i == 1){
					fcatArray = cat1Arr;
				}
				if(i == 2){
					fcatArray = cat2Arr;
				}
				if(i == 3){
					fcatArray = cat3Arr;
				}
				if(yuyan == 'zh'){
					$.each(fcatArray, function(i, item) {
						$("#fenlei_1").append("<a class='first_1_1' href=\"javascript:checkFenlei('"+item.id+"');\" id=\""+item.id+"\">"+item.name+"</a>");
						console.log(item.subCatList);
						catSecond[item.id]=item.subCatList;
					});
				}else{
					$.each(fcatArray, function(i, item) {
						$("#fenlei_1").append("<a class='first_1_1' href=\"javascript:checkFenlei('"+item.id+"');\" id=\""+item.id+"\">"+item.enName+"</a>");
						catSecond[item.id]=item.subCatList;
					});
				}

				bankuaiArr[i].classList.add("on");
			}else{
				bankuaiArr[i].classList.remove("on");
			}
		}
		$("#fenlei_3").empty();
		$("#fenlei_2").empty();
		$("#fenlei_3").hide();
		$("#fenlei_2").hide();
		$("#first_1").show();

	}

	function checkFenlei(e) {
		$("#catId").val(e);
		$("#fenlei_2").empty();
		if(e != ''){
			$("#fenlei_2").append("<a id= 'first_2_1' href=\"javascript:checkFenlei2('');\" class='first_2_1 on'>不限</a>");
			if(yuyan == 'zh'){
				$.each(catSecond[e], function(i, item) {
					$("#fenlei_2").append("<a class='first_2_1' href=\"javascript:checkFenlei2('"+item.id+"');\" id=\""+item.id+"\">"+item.name+"</a>");
					console.log(item.subCatList);
					catThree[item.id]=item.threeCatList;
				});
			}else{
				$.each(catSecond[e], function(i, item) {
					$("#fenlei_2").append("<a class='first_2_1' href=\"javascript:checkFenlei2('"+item.id+"');\" id=\""+item.id+"\">"+item.enName+"</a>");
					catThree[item.id]=item.threeCatList;
				});
			}
			checkOn("first_1_1");
			$("#"+e).addClass("on");
			$("#fenlei_2").show();
			$("#fenlei_3").hide();
		}else{
			checkOn("first_1_1");
			$("#first_1_1").addClass("on");
			$("#fenlei_2").hide();
			$("#fenlei_3").hide();
		}


	}
	function checkFenlei2(e) {
		$("#catId").val(e);
		$("#fenlei_3").empty();
		if(e != '') {
			$("#fenlei_3").append("<a id= 'first_3_1' href=\"javascript:checkFenlei3('');\" class='first_3_1 on'>不限</a>");
			if (yuyan == 'zh') {
				$.each(catThree[e], function (i, item) {
					$("#fenlei_3").append("<a class='first_3_1' href=\"javascript:checkFenlei3('" + item.id + "');\" id=\"" + item.id + "\">" + item.name + "</a>");
					console.log(item.subCatList);
				});
			} else {
				$.each(catThree[e], function (i, item) {
					$("#fenlei_3").append("<a class='first_3_1' href=\"javascript:checkFenlei3('" + item.id + "');\" id=\"" + item.id + "\">" + item.enName + "</a>");
				});
			}
			checkOn("first_2_1");
			$("#" + e).addClass("on");
			$("#fenlei_3").show();
		}else{
			checkOn("first_2_1");
			$("#first_2_1").addClass("on");
			$("#fenlei_3").hide();
		}
	}
	function checkFenlei3(e) {
		$("#catId").val(e);
		if(e != '') {
			checkOn("first_3_1");
			$("#"+e).addClass("on");
		}else{
			checkOn("first_3_1");
			$("#first_3_1").addClass("on");
		}

	}
	function checkSort(e) {
		changeClass(e,'paixu','active');
		$("#orderBySort").val(e);
		searchGoods();
	}
	function changeClass(e,type,classType) {
		var cArr = document.getElementsByClassName(type);
		for(var i = 0; i < cArr.length; i++) {
			if(i == parseInt(e)){
				cArr[i].classList.add(classType);
			}else{
				cArr[i].classList.remove(classType);
			}
		}
	}
	function changePrice(e,type) {
		changeClass(e,'jiage','on');
		$("#priceType").val(type);
	}
	function checkZiying() {
		if ($("#ziying").attr("checked") == "checked") {
			$("#isZiying").val("1");
		}else{
			$("#isZiying").val("0");
		}
	}
	function searchGoods() {
		var url="searchGoodsAction!searchGoods.action";
		$.ajax({
			type:"POST",
			url:url,
			cache:true,
			async:true,
			data : $('#searchGoodsForm').serialize(),
			success:function (html) {
				$("#pageReload").html(html);
			}
		});
	}

	function toCatId(e) {
		$("#catId").val(e);
	}

</script>
</body>
</html>
