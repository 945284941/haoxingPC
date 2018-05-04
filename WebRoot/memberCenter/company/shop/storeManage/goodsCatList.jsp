<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<jsp:include page="/admin/common/keyWords.jsp" />
		<title>古道金典</title>
		<link rel="stylesheet" href="css/common.css" type="text/css" />
		<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.8.0.min.js">
</script>
		<script type="text/JavaScript">
function removeCat(id, goodsCatId) {
	$.ajax( {
		type : 'post',
		url : 'memberManageAction!dropById.action',
		data : "id=" + id + "&goodsCatId=" + goodsCatId,
		dataType : 'json',
		success : function(goodsNum) {
			if (goodsNum == 0) {
				location.href = "memberManageGoodsCat.html";
			} else {
				alert("删除失败，该目录下存在" + goodsNum + "件商品");
			}
		}
	});
}
function editP(id) {
	var porderNum = $("#p" + id).val();
	$.ajax( {
		type : 'post',
		url : 'memberManageAction!updatePorderById.action',
		data : "porderNum=" + porderNum + "&id=" + id,
		dataType : 'json',
		success : function() {
			location.href = "memberManageGoodsCat.html";
		}
	});
}
//添加商品分类
function addCompanyCat() {
	var s = $("#tjflbg").is(":hidden");
	var s2 = $("#tjflbg").is(":visible");
	if (s) {
		$('#tjflbg').show();
		$
				.ajax( {
					type : 'post',
					url : 'memberManageAction!gainGoodsCatListShop.action',
					dataType : 'json',
					success : function(companysGoodsCats) {
						document.getElementById('tjflbg').style.display = "inline";
						$("#goodsCatShop").empty();
						for ( var i = 0; i < companysGoodsCats.length; i++) {
							$("#goodsCatShop").append(
									" <label><input type='checkbox' class='chk' name='goodsCatId' value='"
											+ companysGoodsCats[i].goodsCatId
											+ "'>" + companysGoodsCats[i].name
											+ "</input></label>");
						}
						$("#goodsCatShop")
								.append(
										"<label><input onclick='check()' class='bu' value='保存'/></label>");
					}
				});
	}
	if (s2) {
		$('#tjflbg').hide();
	}
}
function check() {
	var x = $('input[name="goodsCatId"]:checked');
	if (x.length > 0) {
		document.getElementById("goodsCatShop").submit();
	} else {
		alert("请选择分类名称！");
		return false;
	}

}
function hideCompanyCat() {
	$('#tjflbg').hide();
}
function showElement(elementId) {
	document.getElementById(elementId).style.display = "block";
}
function hideElement(elementId) {
	document.getElementById(elementId).style.display = "none";
}
</script>
	</head>
	<body>
		<!-- 头部开始 -->
		<div class="header">
			<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
		</div>
		<div class="logo">
			<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
		</div>

		<div id="warp">
			<jsp:include page="/memberCenter/common/navigation.jsp" />
		</div>
		<!-- 头部结束 -->
		<!-- 页脚开始 -->
		<div class="dht">
			<a href="#">首页</a> &gt;
			<a href="#">企业会员中心</a> &gt;
			<a href="#">店铺管理</a> &gt;
			<a href="#">分类管理</a>
		</div>
		<div class="gzgz">
			<div class="hyleft">
				<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
			</div>
			<div class="hyright">
				<div class="hyrightr hyflgl">
					<div id="rightjxw">
						<s:action name="statisticsAction!showRightStatistics"
							namespace="/statisticsManage" executeResult="true" />
					</div>
				</div>
				<p class="hymainbt">
					<span class="grmenubt">店铺管理</span>
				</p>
				<h2>
					<span>分类管理</span>
				</h2>
				<div class="tjflyc">
					<p>
						<a onclick="addCompanyCat()">添加分类</a>
					</p>
					<div id="tjflbg" style="display: none">
						<div class="tjfl">
							<form id="goodsCatShop" method="post"
								action="memberManageAddGoodsCat.html">
								<label>
									[请点击添加分类]
								</label>
							</form>
						</div>
						<div class="yd">
							<img width="15" height="21" src="/images/memberimg/flbg.gif" />
						</div>
					</div>
				</div>
				<div class="grjbxx">
					<s:iterator var="s" value="companysGoodsCats" status="st">
						<div id="${id}" class="fllb pic<s:property value="#st.index"/>">
							<span>${name}</span><span class="sc"><a
								onclick="removeCat('${id}','${goodsCatId}')">删除</a>
							</span><span class="sc"><input id="p${id}" value="${porder }"
									type="text" name="xh" />
							</span><span class="sc"><a onclick="editP('${id}')">确定</a>
							</span>
						</div>
					</s:iterator>
				</div>
			</div>
			<div style="clear: both"></div>
		</div>
		<div class="gg">
			<a href="/"><img src="/images/memberimg/tlgg1.gif" />
			</a>
		</div>
		<!-- footer begin -->
		<div class="gzgz">
			<jsp:include page="/admin/common/footer.jsp" />
		</div>
		<!-- footer end -->
	</body>
</html>