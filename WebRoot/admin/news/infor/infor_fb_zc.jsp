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
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<link href="css/master.css" rel="stylesheet" type="text/css"></link>
<link href="css/common.css" rel="stylesheet" type="text/css"></link>
<link href="css/infor.css" rel="stylesheet" type="text/css"></link>
<title>供求信息_古道金典</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<jsp:include page="/js/jquery-easyui-1.3.3/easyuiJs.jsp"></jsp:include>
<script type="text/javascript" src="js/hf_uploder.js"></script>
<script>
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
		var brand=document.getElementById('firstBrand');
		var temp=brand.options[brand.selectedIndex].text;
		$("#myform input[name='supply.carbrandName']").val(temp);
		
		var series=document.getElementById('secondBrand');
		 temp=series.options[series.selectedIndex].text;
		$("#myform input[name='supply.carseriesName']").val(temp);
		
		var type=document.getElementById('thirdBrand');
		 temp=type.options[type.selectedIndex].text;
		$("#myform input[name='supply.cartypeName']").val(temp);
		
		var cat=document.getElementById('carCatId');
		temp=cat.options[cat.selectedIndex].text;
		$("#myform input[name='supply.carcatName']").val(temp);
		
		$("#myform input[name='supply.picpath']").val(picSrc.toString());
		
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
	$('#firstBrand').bind('change',function(){
		$.ajax({
			type : "POST",
			url : "/news/news!gainNextCarBrand.action",
			data : "pid=" + this.value,
			dataType : "JSON",
			success : function(data) {
				var list=data;
				if (list.length <= 0) {
					$('#secondBrand').empty();
					$('#thirdBrand').empty().append("<option value=''>请选择</option>");
					$('#secondBrand').append("<option value=''>请选择</option>");
				}else {
					$('#secondBrand').empty();
					$('#thirdBrand').empty().append("<option value=''>请选择</option>");
					$('#secondBrand').append("<option value=''>请选择</option>");
					for ( var i = 0, len = list.length; i < len; i++) {
						$('#secondBrand').append("<option value='"+list[i].id+"'>" + list[i].name + "</option>");
					}
				}
			},error:function(data){
				alert("系统错误,请联系管理员!");
			}
		}); 
	});
	$('#secondBrand').bind('change',function(){
		$.ajax({
			type : "POST",
			url : "/news/news!gainNextCarBrand.action",
			data : "pid=" + this.value,
			dataType : "JSON",
			success : function(data) {
				var list=data;
				if (list.length <= 0) {
					$('#thirdBrand').empty();
					$('#thirdBrand').append("<option value=\"\">暂无数据</option>");
				}else {
					$('#thirdBrand').empty();
					$('#thirdBrand').append("<option value=''>请选择</option>");
					for ( var i = 0, len = list.length; i < len; i++) {
						$('#thirdBrand').append("<option value='"+list[i].id+"'>" + list[i].name + "</option>");
					}
				}
			},error:function(data){
				alert("系统错误,请联系管理员!");
			}
		}); 
	});
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
	<div id="test1"></div>
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
		<a>首页 > 供求信息 >${typeName }</a>
	</div>
	<div class="infor_fb">
		<div class="fbzctitle">
			<ul>
				<li><span>1</span><a href="/s_supplyfb.html">选择信息分类</a></li>
				<li class="fxz"><span>2</span><a href="javascript:void(0)">填写基本信息</a>
				</li>
				<li class="fxz2"><span>3</span><a href="javascript:void(0)">等待信息审核</a>
				</li>
			</ul>
		</div>
		<form action="/news/news!add.action" id="myform" method="post" enctype="multipart/form-data">
			<div class="fb_content">
				<div class="fb_1">
					<h2>
						<span>${typeName }</span>
						<input type="hidden" name="supply.typeId" value="${typeId }">
						<input type="hidden" name="supply.typeName" value="${typeName }">
					</h2>
					<div class="fb_con2">
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>信息标题：</span>
							<div class="fb_fl">
								<div>
									<input type="text" class="text easyui-validatebox" name="supply.title" data-options="required:true">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>供求：</span>
							<div class="fb_gqfl">
							<c:if test="${sessionInfo.userType=='company'}">
								<label><input type="radio" name="supply.status" class="inRadio_blue" value="1">供应</label>
							</c:if>	
							 <label><input
									type="radio"  checked="checked"  name="supply.status" class="inRadio_blue" value="0">求购</label>
							</div>
							<div class="clr"></div>
						</div>

						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>汽车品牌：</span>
							<div class="fb_f2">
								<div>
									<SELECT class="text easyui-validatebox" name='supply.carbrandId' id="firstBrand" data-options="required:true">
										<OPTION selected value="">请选择</OPTION>
										<c:forEach items="${firstBrand }" var="fb">
											<option value="${fb.id }">${fb.name }</option>
										</c:forEach>
									</SELECT>
									<input type="hidden" name="supply.carbrandName">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>汽车车系：</span>
							<div class="fb_f2">
								<div>
									<SELECT class="text easyui-validatebox" id="secondBrand" name="supply.carseriesId" data-options="required:true">
										<OPTION selected value="">请选择</OPTION>
									</SELECT>
									<input type="hidden" name="supply.carseriesName">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>汽车车型：</span>
							<div class="fb_f2">
								<div>
									<SELECT class="text easyui-validatebox" id="thirdBrand" name="supply.cartypeId" data-options="required:true">
										<OPTION selected value="">请选择</OPTION>
									</SELECT>
									<input type="hidden" name="supply.cartypeName">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>汽车类型：</span>
							<div class="fb_f2">
								<div>
									<SELECT class="text easyui-validatebox" id='carCatId' name="supply.carcatId" data-options="required:true">
										<OPTION selected value="">请选择</OPTION>
										<c:forEach items="${carBrandTypeList }" var="cbt">
											<option value="${cbt.id }">${cbt.name }</option>
										</c:forEach>
									</SELECT>
									<input type="hidden" name="supply.carcatName">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">汽车颜色：</span>
							<div class="fb_f2">
								<div>
									<input type="text" class="text" name="supply.color">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">首次上牌时间：</span>
							<div class="fb_f2">
								<div>
									<input name="supply.carFirstcardtime" type="text" readonly="readonly" style="background:#fff url('/js/My97DatePicker/skin/datePicker.gif') no-repeat right;height:20px;" class="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
								</div>
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
						<div class="item" style="padding-top: 10px;">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>有无重大事故：</span>
							<div class="fb_gqfl">
								<label><input type="radio" checked="checked"
									name="supply.hasAccident" class="inRadio_blue" value="有">有</label> <label><input
									type="radio" name="supply.hasAccident" class="inRadio_blue" value="无">无</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>证件是否齐全：</span>
							<div class="fb_gqfl">
								<label><input type="radio" checked="checked"
									name="supply.hasCertificate" class="inRadio_blue" value="是">是</label> <label><input
									type="radio" name="supply.hasCertificate" class="inRadio_blue" value="否">否</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>外观成色：</span>
							<div class="fb_gqfl">
								<label><input type="radio" checked="checked"
									name="supply.quality" class="inRadio_blue" value="全新">全新</label> <label><input
									type="radio" name="supply.quality" class="inRadio_blue" value="较新">较新</label>
								<label><input type="radio" name="supply.quality"
									class="inRadio_blue" value="一般">一般</label> <label><input
									type="radio" name="supply.quality" class="inRadio_blue" value="较差">较差</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>内饰状况：</span>
							<div class="fb_gqfl">
								<label><input type="radio" checked="checked"
									name="supply.interiorCondition" class="inRadio_blue" value="完好">完好</label> <label><input
									type="radio" name="supply.interiorCondition" class="inRadio_blue" value="有缺陷">有缺陷</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">行驶里程：</span>
							<div class="fb_fl fb_f4">
								<input type="text" class="text easyui-numberbox" name="supply.mileage" data-options="min:0,precision:2">
							</div>
							<span>公里内</span>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">价格：</span>
							<div class="fb_fl fb_f4">
								<input type="text" class="text easyui-numberbox" name="supply.price" data-options="min:0,precision:2">
							</div>
							<span>元</span>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>联系人：</span>
							<div class="fb_fl fb_f5">
								<input type="text" class="text easyui-validatebox" name="supply.linkman" data-options="required:true">
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>联系电话：</span>
							<div class="fb_fl fb_f5">
								<input type="text" class="text easyui-validatebox" name="supply.linkmobile" data-options="required:true">
							</div>
							<div class="clr"></div>
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
						<div class="item">
							<span class="label">QQ/Email：</span>
							<div class="fb_fl fb_f5">
								<input type="text" class="text" name="supply.qqEmail">
							</div>
							<div class="clr"></div>
						</div>
						<div class="item2">
							<span class="label">补充说明：</span>
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
	<!-- upload -->
	<div id="uploadPic">
		 
	</div>
	<!-- upload end -->
</body>
</html>
