<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<jsp:include page="/js/jquery-easyui-1.3.3/easyuiJs.jsp"></jsp:include>
<script type="text/javascript" src="js/hf_uploder.js"></script>
<script type="text/javascript">
	function sub(){
		var myform=$('#myform').form();
		reduceValidate();
		if(myform.form('validate')){
			var temp = $('#uploader_img img');
			var picSrc=[];
			for ( var i = 0; i < temp.length; i++) {
				var e = temp[i];
				var s = e.src;
				picSrc.push(s);
			}
			$("#myform input[name='supply.picpath']").val(picSrc.toString());
			var tr=false;
		var s1=$("#myform input[name='supply.transportMode']");
		for(var i=0;i<s1.length;i++){
			var e=s1[i];
			if(e.checked){
				tr=true;
			}
		}
		if(!tr){
			alert("请选择货运方式");
			return;
		}
		var or=false;
		var s2=$("#myform input[name='supply.organizegoodsMode']");
		for(var i=0;i<s2.length;i++){
			var e=s2[i];
			if(e.checked){
				or=true;
			}
		}
		if(!or){
			alert("请选择组货方式");
			return;
		}
		var goodstype=false;
		var s3=$("#myform input[name='supply.goodsType']");
		for(var i=0;i<s3.length;i++){
			var e=s3[i];
			if(e.checked){
				goodstype=true;
			}
		}
		if(!goodstype){
			alert("请选择货物种类");
			return;
		}
		var ser=false;
		var s4=$("#myform input[name='supply.serviceMode']");
		for(var i=0;i<s4.length;i++){
			var e=s4[i];
			if(e.checked){
				ser=true;
			}
		}
		if(!ser){
			alert("请选择服务延伸");
			return;
		}
			$.ajax({
				url : 'memberCenter/goods!checkSession.action',
				type : 'POST',
				dataType:'JSON',
				success:function(json){
					if(!json){
						showLogin('mask','pop_500','myform','1','');
					}else{
						document.getElementById('myform').submit();
					}
				}
			});
		}else{
			return ;
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
		<form method="post" id="myform" action="/news/news!add.action" enctype="multipart/form-data">
			<div class="fb_content">
				<div class="fb_1">
					<h2>
						<span>${typeName }</span>
						<input type="hidden" name="supply.typeId" value="${typeId }">
						<input type="hidden" name="supply.typeName" value="${typeName }">
					</h2>
					
					<div class="fb_con2">
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>租赁：</span>
							<div class="fb_gqfl">
								<c:if test="${sessionInfo.userType=='company'}">
									<label><input type="radio"  name="supply.status"
										class="inRadio_blue" value="1">出租</label>
								</c:if>
									 <label><input
									type="radio" checked="checked" name="supply.status" class="inRadio_blue" value="0">求租</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>信息标题：</span>
							<div class="fb_fl">
								<div>
									<input type="text" class="text  easyui-validatebox" name="supply.title" data-options="required:true">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>运送范围：</span>
							<div class="fb_fl">
								<div>
									<input type="text" class="text easyui-validatebox" name="supply.deliveryScope" data-options="required:true">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>货运方式：</span>
							<div class="my2">
								<label><input type="checkbox" class="chk" value="公路" name="supply.transportMode">公路</label> <label><input
									type="checkbox" class="chk" value="铁路"
									name="supply.transportMode">铁路</label> <label><input
									type="checkbox" class="chk" value="航空"
									name="supply.transportMode">航空</label> <label><input
									type="checkbox" class="chk" value="河运"
									name="supply.transportMode">河运</label> <label><input
									type="checkbox" class="chk" value="海运"
									name="supply.transportMode">海运</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>是否往返：</span>
							<div class="fb_gqfl">
								<label><input type="radio" checked="checked" name="supply.isRound"
									class="inRadio_blue" value="是">是</label> <label><input
									type="radio" name="supply.isRound" class="inRadio_blue" value="否">否</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>有无中转：</span>
							<div class="fb_gqfl">
								<label><input type="radio" checked="checked" name="supply.isTransit"
									class="inRadio_blue" value="直达">直达</label> <label><input
									type="radio" name="supply.isTransit" class="inRadio_blue" value="有中转">有中转</label>
								<label><input type="radio" name="supply.isTransit"
									class="inRadio_blue" value="联运">联运</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>班次：</span>
							<div class="fb_gqfl">
								<label><input type="radio" checked="checked" name="supply.isFixedshift"
									class="inRadio_blue" value="固定班次">固定班次</label> <label><input
									type="radio" name="supply.isFixedshift" class="inRadio_blue" value="不固定班次">不固定班次</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>组货方式：</span>
							<div class="my2">
								<label><input type="checkbox" class="chk" value="零整不限" name="supply.organizegoodsMode">零整不限</label> <label><input
									type="checkbox" class="chk" value="整车"
									name="supply.organizegoodsMode">整车</label> <label><input
									type="checkbox" class="chk" value="整仓"
									name="supply.organizegoodsMode">整仓</label> <label><input
									type="checkbox" class="chk" value="集装箱"
									name="supply.organizegoodsMode">集装箱</label> <label><input
									type="checkbox" class="chk" value="拼货"
									name="supply.organizegoodsMode">拼货</label> <label><input
									type="checkbox" class="chk" value="零担"
									name="supply.organizegoodsMode">零担</label> <label><input
									type="checkbox" class="chk" value="包裹"
									name="supply.organizegoodsMode">包裹</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>货物种类：</span>
							<div class="my2">
								<label><input type="checkbox" class="chk" value="普通货物" name="supply.goodsType">普通货物</label> <label><input
									type="checkbox" class="chk" value="大件货物" 
									name="supply.goodsType">大件货物</label> <label><input
									type="checkbox" class="chk" value="危险货物"
									name="supply.goodsType">危险货物</label> <label><input
									type="checkbox" class="chk" value="贵重货物" 
									name="supply.goodsType">贵重货物</label> <label><input
									type="checkbox" class="chk" value="其他货物"
									name="supply.goodsType">其他货物</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>服务延伸：</span>
							<div class="my2">
								<label><input type="checkbox" class="chk" value="上门提货" name="supply.serviceMode">上门提货</label> <label><input
									type="checkbox" class="chk" value="送货上门"
									name="supply.serviceMode">送货上门</label> <label><input
									type="checkbox" class="chk" value="代收货款"
									name="supply.serviceMode">代收货款</label> <label><input
									type="checkbox" class="chk" value="河运"
									name="supply.serviceMode">河运</label> <label><input
									type="checkbox" class="chk" value="海运"
									name="supply.serviceMode">海运</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">上传图片：</span>
							<div class="fb_f3">
								<DIV class=btns>
									<INPUT class=btn_file value=上传图片 type=button onclick="makerUpload(false);">双击图片删除!
									<input type="hidden" name="supply.picpath" />
								</DIV>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item" >
								<span class="label">&nbsp;</span>
								<div class="fb_gqfl" id="uploader_img">
								
								</div>
						</div>
						<div class="item">
							<span class="label">有效期至：</span>
							<div class="fb_f2 fb_f5">
								<div>
									<input name="supply.effectivetime" type="text" readonly="readonly" style="background:#fff url('/js/My97DatePicker/skin/datePicker.gif') no-repeat right;height:20px;" class="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item" style="padding-top:10px;">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>联系人：</span>
							<div class="fb_fl fb_f5">
								<input type="text" class="text easyui-validatebox" data-options="required:true" name="supply.linkman" >
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>联系电话：</span>
							<div class="fb_fl fb_f5">
								<input type="text" class="text easyui-validatebox" data-options="required:true" name="supply.linkmobile">
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
