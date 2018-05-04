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
<title>供求信息_古道金典，提供最全面的汽车及配件供应、求购商机</title>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<jsp:include page="/js/jquery-easyui-1.3.3/easyuiJs.jsp"></jsp:include>
<script type="text/javascript" src="js/hf_uploder.js"></script>
<script>

	function sub(){
		var myform=$('#myform').form();
		reduceValidate();
		var or=false;
		var s2=$("#myform input[name='supply.operateSort']");
		for(var i=0;i<s2.length;i++){
			var e=s2[i];
			if(e.checked){
				or=true;
			}
		}
		if(!or){
			alert("经营类别");
			return;
		}
		if(myform.form('validate')){
			var temp = $('#uploader_img img');
			var picSrc=[];
			for ( var i = 0; i < temp.length; i++) {
				var e = temp[i];
				var s = e.src;
				picSrc.push(s);
			}
			$("#myform input[name='supply.picpath']").val(picSrc.toString());
			
			var province = document.getElementById('province');
			var temp1 = province.options[province.selectedIndex].text;
			$("#myform input[name='supply.province']").val(temp1);
			
			var city = document.getElementById('city');
			var temp2 = city.options[city.selectedIndex].text;
			$("#myform input[name='supply.city']").val(temp2);
			
			var area = document.getElementById('area');
			var temp3 = "";
			if (area.value != undefined && area.value != '') {
				temp3 = area.options[area.selectedIndex].text;
				$("#myform input[name='supply.area']").val(temp3);
			}
			$("#myform input[name='supply.address']").val(
					temp1 + " " + temp2 + " " + temp3 + " "
							+ $('#address').val());
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
		$('#province')
				.bind(
						'change',
						function() {
							if (this.value == '') {
								$('#city').hide().empty().append(
										"<option value=''>请选择</option>");
								$('#area').hide().empty().append(
										"<option value=''>请选择</option>");
								return;
							}
							$
									.ajax({
										type : "POST",
										url : "/news/news!gainNextCityOrAreaByPid.action",
										data : "pid=" + this.value,
										dataType : "JSON",
										success : function(data) {
											$('#city')
													.empty()
													.append(
															"<option value=''>请选择</option>");
											$('#area')
													.empty()
													.append(
															"<option value=''>请选择</option>");
											for ( var i = 0, len = data.length; i < len; i++) {
												$('#city').show().append(
														"<option value='"+data[i].id+"'>"
																+ data[i].name
																+ "</option>");
											}
										}
									});
						});
		$('#city')
				.bind(
						'change',
						function() {
							if (this.value == '') {
								$('#area').hide().empty();
								return;
							}
							$
									.ajax({
										type : "POST",
										url : "/news/news!gainNextCityOrAreaByPid.action",
										data : "pid=" + this.value,
										dataType : "JSON",
										success : function(data) {
											if (data.length <= 0) {
												$('#area').hide().empty();
												return;
											}
											$('#area')
													.empty()
													.append(
															"<option value=''>请选择</option>");
											for ( var i = 0, len = data.length; i < len; i++) {
												$('#area').show().append(
														"<option value='"+data[i].id+"'>"
																+ data[i].name
																+ "</option>");
											}
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
									<label><input type="radio" 
										name="supply.status" class="inRadio_blue" value="1">供应</label> 
								</c:if>
										<label><input
									type="radio" checked="checked" name="supply.status" class="inRadio_blue" value="0">求购</label>
							</div>
							<div class="clr"></div>
						</div>
	
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>经营类别：</span>
							<div class="my2">
								<label><input type="checkbox" class="chk" value="乘用车维修" name="supply.operateSort">乘用车维修</label> <label><input
									type="checkbox" class="chk" value="商用车维修" name="supply.operateSort">商用车维修</label>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>经营区域：</span>
							<div class="fb_fl fb_f7" style="width: auto;">
									<div>
										<SELECT id="province" name="supply.provinceId" class="easyui-validatebox" data-options="required:true" id="province" style="height:26px;">
											<OPTION selected value="">-选择省-</OPTION>
											<c:forEach items="${regions }" var="re">
												<option value="${re.id }">${re.name }</option>
											</c:forEach>
										</SELECT>
										<input name="supply.province" type="hidden">
									</div>
								</div>
								<div class="fb_fl fb_f7" style="width: auto;">
									<div>
										<SELECT class="text easyui-validatebox" name="supply.cityId" id="city" data-options="required:true" style="display: none;height:26px;" >
										</SELECT>
										<input name="supply.city" type="hidden">
									</div>
								</div>
								<div class="fb_fl fb_f7" style="width: auto;">
									<div>
										<SELECT class="text" id="area" name="supply.areaId" style="display: none;height:26px;" name="supply.area">
										</SELECT>
										<input name="supply.area" type="hidden">
									</div>
								</div>
							<div class="clr"></div>
						</div>
						<div class="item">
								<span class="label">详细地址：</span>
								<div class="fb_f2">
								<div>
									<input type="text" class="text" id="address"> <input
									type="hidden" name="supply.address">
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
						<div class="item" style="padding-top:10px;">
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
</body>
</html>
