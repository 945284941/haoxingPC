<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<link href="css/master.css" rel="stylesheet" type="text/css"></link>
<link href="css/common.css" rel="stylesheet" type="text/css"></link>
<link href="css/infor.css" rel="stylesheet" type="text/css"></link>
<title>供求信息_古道金典，提供最全面的汽车及配件供应、求购商机</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<jsp:include page="/js/jquery-easyui-1.3.3/easyuiJs.jsp"></jsp:include>
<script type="text/javascript" src="js/hf_uploder.js"></script>
<script type="text/javascript">
	function sub() {
		var myform = $('#myform').form();
		reduceValidate();
		if (myform.form('validate')) {
			var temp = $('#uploader_img img');
			var picSrc = [];
			for ( var i = 0; i < temp.length; i++) {
				var e = temp[i];
				var s = e.src;
				picSrc.push(s);
			}
			$("#myform input[name='supply.picpath']").val(picSrc.toString());
			$.ajax({
				url : 'memberCenter/goods!checkSession.action',
				type : 'POST',
				dataType : 'JSON',
				success : function(json) {
					if (!json) {
						showLogin('mask', 'pop_500', 'myform', '1', '');
					} else {
						document.getElementById('myform').submit();
					}
				}
			});
		} else {
			return;
		}
	}
	function reduceValidate(){
		$('#myform').form('enableValidation');
	}
	$(function() {
		$('#myform').form('disableValidation');
		$('#head_hf_gqxx').addClass('hover');
	});
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
</head>

<body id="mainbody">
	<!-- header begin -->
	<div class="header">
		<jsp:include page="/admin/common/head.jsp"></jsp:include>
	</div>
	<div class="logo">
		<jsp:include page="/admin/common/logo.jsp"></jsp:include>
	</div>

	<!-- 代码 开始 -->
	<div id="warp">
		<div class=" bannerzong">
			<ul class="mainnavzong">
				<jsp:include page="/admin/common/all_hf_Head.jsp" />
			</ul>
			<div class="mainqlzpc">
     <a href="news/news!toQlqpc.action"><img src="images/zpc.gif" alt="泉利重配城" /></a>
   </div>
			<div id="menunew">
				<p class="menubt_new"></p>
				<ul class="menuzong menunew">
				</ul>
			</div>
		</div>
	</div>
	<div class="dht">
		<a>首页 > 供求信息 > ${typeName }</a>
	</div>
	<div class="infor_fb">
		<div class="fbzctitle">
			<ul>
				<li><span>1</span><a href="/s_supplyfb.html">选择信息分类</a>
				</li>
				<li class="fxz"><span>2</span><a href="javascript:void(0)">填写基本信息</a>
				</li>
				<li class="fxz2"><span>3</span><a href="javascript:void(0)">等待信息审核</a>
				</li>
			</ul>
		</div>
		<form method="post" id="myform" action="/news/news!add.action"
			enctype="multipart/form-data">
			<div class="fb_content">
				<div class="fb_1">
					<h2>
						<span>${typeName }</span> <input type="hidden"
							name="supply.typeId" value="${typeId }"> <input
							type="hidden" name="supply.typeName" value="${typeName }">
					</h2>
					<div class="fb_con2">
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>供求：</span>
							<div class="fb_gqfl">
								<c:if test="${sessionInfo.userType=='company'}">
									<label><input type="radio" name="supply.status"
										class="inRadio_blue" value="1">转让</label>
								</c:if>
								<label><input type="radio" checked="checked"
									name="supply.status" class="inRadio_blue" value="0">求购</label>
							</div>
							<div class="clr"></div>
						</div>

						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>信息标题：</span>
							<div class="fb_fl">
								<div>
									<input type="text" class="text easyui-validatebox"
										data-options="required:true" name="supply.title">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">上传图片：</span>
							<div class="fb_f3">
								<DIV class=btns>
									<INPUT class=btn_file value=上传图片 type=button
										onclick="makerUpload(false);">双击图片删除! <input
										type="hidden" name="supply.picpath" />
								</DIV>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">&nbsp;</span>
							<div class="fb_gqfl" id="uploader_img"></div>
						</div>
						<div class="item" style="padding-top: 10px;">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>联系人：</span>
							<div class="fb_fl fb_f5">
								<input type="text" class="text easyui-validatebox"
									data-options="required:true" name="supply.linkman">
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>联系电话：</span>
							<div class="fb_fl fb_f5">
								<input type="text" class="text"
									data-options="required:true" name="supply.linkmobile">
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">QQ/Email：</span>
							<div class="fb_fl fb_f5">
								<input type="text" class="text" name="supply.qqEmail">
							</div>
							<div class="clr"></div>
						</div>
						<div class="item2">
							<span class="label">详情说明：</span>
							<div class="fb_fl fb_f6">
								<textarea name="supply.description"
										style="width: 350px;height: 90px;resize: none;"></textarea>
							</div>
							<div class="clr"></div>
						</div>
					</div>
					<div class="wcmenu">
						<a href="javascript:sub()"><img src="/images/wcmenu.gif" />
						</a>
					</div>
					<div class="clr"></div>
				</div>
			</div>
		</form>
	</div>
	<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
	<!-- footer end -->
</body>
</html>
