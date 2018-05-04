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

<script type="text/javascript">
	function sub() {
		var myform = $('#myform').form();
		reduceValidate();
		if (document.getElementById('zp').checked) {
			var province = document.getElementById('c_province');
			var temp1 = province.options[province.selectedIndex].text;

			var city = document.getElementById('c_city');
			var temp2 = city.options[city.selectedIndex].text;

			var area = document.getElementById('c_area');
			var temp3 = "";
			if (area.value != undefined && area.value != '') {
				temp3 = area.options[area.selectedIndex].text;
			}

			var address = document.getElementById('companyAddress').value;
			$("#myform input[name='supply.companyAddress']").val(
					temp1 + " " + temp2 + " " + temp3 + " " + address);
		} else {
			var province = document.getElementById('h_province');
			var temp1 = province.options[province.selectedIndex].text;

			var city = document.getElementById('h_city');
			var temp2 = city.options[city.selectedIndex].text;

			var area = document.getElementById('h_area');
			var temp3 = "";
			if (area.value != undefined && area.value != '') {
				temp3 = area.options[area.selectedIndex].text;
			}
			var address = document.getElementById('homeAddress').value;
			$("#myform input[name='supply.homeAddress']").val(
					temp1 + " " + temp2 + " " + temp3 + " " + address);
			province = document.getElementById('j_province');
			temp1 = province.options[province.selectedIndex].text;

			city = document.getElementById('j_city');
			temp2 = city.options[city.selectedIndex].text;

			area = document.getElementById('j_area');
			temp3 = "";
			if (area.value != undefined && area.value != '') {
				temp3 = area.options[area.selectedIndex].text;
			}
			$("#myform input[name='supply.jobPlace']").val(
					temp1 + " " + temp2 + " " + temp3);
		}
		if (myform.form('validate')) {
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
		$('#head_hf_gqxx').addClass('hover');
		$('#myform').form('disableValidation');
		$('#zhaopin').hide();
		$('#zhaopin input').attr('disabled', true);
		$('#zhaopin select').attr('disabled', true);
		$('#zhaopin textarea').attr('disabled', true);
		$('#qiuzhi').show();
		$('#qiuzhi input').attr('disabled', false);
		$('#qiuzhi select').attr('disabled', false);

		$('#zp').bind('click', function() {
			if (this.checked) {
				$('#zhaopin').show();
				$('#qiuzhi').hide();
				$('#zhaopin input').attr('disabled', false);
				$('#zhaopin select').attr('disabled', false);
				$('#zhaopin textarea').attr('disabled', false);
				$('#qiuzhi input').attr('disabled', true);
				$('#qiuzhi select').attr('disabled', true);
				$('#qiuzhi textarea').attr('disabled', true);
			}
		});
		$('#qz').bind('click', function() {
			if (this.checked) {
				$('#zhaopin').hide();
				$('#zhaopin input').attr('disabled', true);
				$('#zhaopin select').attr('disabled', true);
				$('#zhaopin textarea').attr('disabled', true);
				$('#qiuzhi').show();
				$('#qiuzhi input').attr('disabled', false);
				$('#qiuzhi select').attr('disabled', false);
				$('#qiuzhi textarea').attr('disabled', false);
			}
		});

		$('#j_province')
				.bind(
						'change',
						function() {
							if (this.value == '') {
								$('#j_city').hide().empty().append(
										"<option value=''>-选择市-</option>");
								$('#j_area').hide().empty().append(
										"<option value=''>-区或县-</option>");
								return;
							}
							$.ajax({
								type : "POST",
								url : "/news/news!gainNextCityOrAreaByPid.action",
								data : "pid=" + this.value,
								dataType : "JSON",
								success : function(data) {
									$('#j_city')
											.empty()
											.append(
													"<option value=''>-选择市-</option>");
									$('#j_area')
											.empty()
											.append(
													"<option value=''>-区或县-</option>");
									for ( var i = 0, len = data.length; i < len; i++) {
										$('#j_city').show().append(
												"<option value='"+data[i].id+"'>"
														+ data[i].name
														+ "</option>");
									}
								}
							});
						});
		$('#j_city')
				.bind(
						'change',
						function() {
							if (this.value == '') {
								$('#j_area').hide().empty();
								return;
							}
							$.ajax({
										type : "POST",
										url : "/news/news!gainNextCityOrAreaByPid.action",
										data : "pid=" + this.value,
										dataType : "JSON",
										success : function(data) {
											if (data.length <= 0) {
												$('#j_area').hide().empty();
												return;
											}
											$('#j_area')
													.empty()
													.append(
															"<option value=''>-区或县-</option>");
											for ( var i = 0, len = data.length; i < len; i++) {
												$('#j_area').show().append(
														"<option value='"+data[i].id+"'>"
																+ data[i].name
																+ "</option>");
											}
										}
									});
						});
		$('#c_province')
				.bind(
						'change',
						function() {
							if (this.value == '') {
								$('#c_city').hide().empty().append(
										"<option value=''>-选择市-</option>");
								$('#c_area').hide().empty().append(
										"<option value=''>-区或县-</option>");
								return;
							}
							$
									.ajax({
										type : "POST",
										url : "/news/news!gainNextCityOrAreaByPid.action",
										data : "pid=" + this.value,
										dataType : "JSON",
										success : function(data) {
											$('#c_city')
													.empty()
													.append(
															"<option value=''>-选择市-</option>");
											$('#c_area')
													.empty()
													.append(
															"<option value=''>-区或县-</option>");
											for ( var i = 0, len = data.length; i < len; i++) {
												$('#c_city').show().append(
														"<option value='"+data[i].id+"'>"
																+ data[i].name
																+ "</option>");
											}
										}
									});
						});
		$('#c_city')
				.bind(
						'change',
						function() {
							if (this.value == '') {
								$('#c_area').hide().empty();
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
												$('#c_area').hide().empty();
												return;
											}
											$('#c_area')
													.empty()
													.append(
															"<option value=''>-区或县-</option>");
											for ( var i = 0, len = data.length; i < len; i++) {
												$('#c_area').show().append(
														"<option value='"+data[i].id+"'>"
																+ data[i].name
																+ "</option>");
											}
										}
									});
						});
		$('#h_province')
				.bind(
						'change',
						function() {
							if (this.value == '') {
								$('#h_city').hide().empty().append(
										"<option value=''>-选择市-</option>");
								$('#h_area').hide().empty().append(
										"<option value=''>-区或县-</option>");
								return;
							}
							$
									.ajax({
										type : "POST",
										url : "/news/news!gainNextCityOrAreaByPid.action",
										data : "pid=" + this.value,
										dataType : "JSON",
										success : function(data) {
											$('#h_city')
													.empty()
													.append(
															"<option value=''>-选择市-</option>");
											$('#h_area')
													.empty()
													.append(
															"<option value=''>-区或县-</option>");
											for ( var i = 0, len = data.length; i < len; i++) {
												$('#h_city').show().append(
														"<option value='"+data[i].id+"'>"
																+ data[i].name
																+ "</option>");
											}
										}
									});
						});
		$('#h_city')
				.bind(
						'change',
						function() {
							if (this.value == '') {
								$('#h_area').hide().empty();
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
												$('#h_area').hide().empty();
												return;
											}
											$('#h_area')
													.empty()
													.append(
															"<option value=''>-区或县-</option>");
											for ( var i = 0, len = data.length; i < len; i++) {
												$('#h_area').show().append(
														"<option value='"+data[i].id+"'>"
																+ data[i].name
																+ "</option>");
											}
										}
									});
						});
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
		<a>首页 > 供求信息 >${typeName}</a>
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
		<form action="/news/news!add.action" id="myform" method="post"
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
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>类别：</span>
							<div class="fb_gqfl">
								<c:if test="${sessionInfo.userType=='company'}">
									<label><input type="radio" id="zp" name="supply.status"
										class="inRadio_blue" value="0">招聘</label>
								</c:if>
								<label><input type="radio" id="qz" name="supply.status"
									class="inRadio_blue" checked="checked" value="1">求职</label>
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
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>性质：</span>
							<div class="fb_gqfl">
								<label><input type="radio" checked="checked"
									name="supply.jobNature" class="inRadio_blue" value="全职">全职</label>
								<label><input type="radio" name="supply.jobNature"
									class="inRadio_blue" value="兼职">兼职</label>
							</div>
							<div class="clr"></div>
						</div>

						<!--招聘信息begin-->
						<div id="zhaopin">
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>岗位名称：</span>
								<div class="fb_f2">
									<div>
										<input type="text" class="text easyui-validatebox"
											data-options="required:true" name="supply.jobName">
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item2">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>岗位职责和要求：</span>
								<div class="fb_fl fb_f6">
									<textarea name="supply.jobRequest" class="easyui-validatebox" data-options="required:true"
										style="width: 350px;height: 90px;resize: none;"></textarea>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>月薪：</span>
								<div class="fb_f2">
									<div>
										<input type="text" class="text easyui-numberbox"
											data-options="required:true,min:0,precision:2" name="supply.monthlypay">
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司名称：</span>
								<div class="fb_f2">
									<div>
										<input type="text" class="text easyui-validatebox"
											data-options="required:true" name="supply.companyName">
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>所属行业：</span>
								<div class="fb_f2">
									<div>
										<SELECT class="text easyui-validatebox"
											data-options="required:true" name="supply.calling" id="zhaopin_calling">
											<OPTION selected value="">请选择</OPTION>
											<OPTION selected value="整车制造商">整车制造商</OPTION>
											<OPTION selected value="整车经销商">整车经销商</OPTION>
											<OPTION selected value="配件制造商">配件制造商</OPTION>
											<OPTION selected value="配件经销商">配件经销商</OPTION>
											<OPTION selected value="车队">车队</OPTION>
											<OPTION selected value=" 物流商">物流商</OPTION>
											<OPTION selected value="汽修厂">汽修厂</OPTION>
											<OPTION selected value="行业协会">行业协会</OPTION>
											<OPTION selected value="专业市场">专业市场</OPTION>
											<OPTION selected value="其他">其他</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label">所在职级：</span>
								<div class="fb_f2">
									<div>
										<input type="text" class="text" name="supply.jobRank">
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>学历要求：</span>
								<div class="fb_f2">
									<div>
										<SELECT class="text easyui-validatebox"
											data-options="required:true" name="supply.education" id="zhaopin_education">
											<OPTION selected value="">请选择</OPTION>
											<OPTION value="本科及本科以上">本科及本科以上</OPTION>
											<OPTION value="大专/技校">大专/技校</OPTION>
											<OPTION value="高中/中专职高">高中/中专职高</OPTION>
											<OPTION value="初中及初中以下">初中及初中以下</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>工作经验：</span>
								<div class="fb_f2">
									<div>
										<SELECT class="text easyui-validatebox"
											data-options="required:true" name="supply.workExperience" id="zhaopin_workExperience">
											<OPTION selected value="">请选择</OPTION>
											<OPTION value="八年以上">八年以上</OPTION>
											<OPTION value="五至八年">五至八年</OPTION>
											<OPTION value="三至五年">三至五年</OPTION>
											<OPTION value="三年以下">三年以下</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司规模：</span>
								<div class="fb_f2">
									<div>
										<SELECT class="text easyui-validatebox"
											data-options="required:true" name="supply.companyScale" id="zhaopin_companyScale">
											<OPTION selected value="">请选择</OPTION>
											<OPTION value="50及以上">50及以上</OPTION>
											<OPTION value="10-50">10-50</OPTION>
											<OPTION value="10人以下">10人以下</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司性质：</span>
								<div class="fb_f2">
									<div>
										<SELECT class="text easyui-validatebox"
											data-options="required:true" name="supply.companyNature" id="zhaopin_companyNature">
											<OPTION selected value="">请选择</OPTION>
											<OPTION value="国有企业">国有企业</OPTION>
											<OPTION value="集体企业">集体企业</OPTION>
											<OPTION value="联营企业">联营企业</OPTION>
											<OPTION value="三资企业">三资企业</OPTION>
											<OPTION value="私营企业">私营企业</OPTION>
											<OPTION value="其他企业">其他企业</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司地址：</span>
								<div class="fb_fl fb_f7">
									<div>
										<SELECT class="text easyui-validatebox" data-options="required:true" id="c_province">
											<OPTION selected value="">-选择省-</OPTION>
											<c:forEach items="${regions }" var="re">
												<option value="${re.id }">${re.name }</option>
											</c:forEach>
										</SELECT>
									</div>
								</div>
								<div class="fb_fl fb_f7">
									<div>
										<SELECT class="text easyui-validatebox" data-options="required:true" id="c_city">
											<OPTION selected value="请选择">请选择</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="fb_fl fb_f7">
									<div>
										<SELECT class="text" id="c_area">
											<OPTION selected value="请选择">请选择</OPTION>
										</SELECT>
									</div>
								</div>
								<input type="hidden" name="supply.companyAddress">
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>详细地址：</span>
								<div class="fb_f2">
									<div>
										<input type="text" class="text easyui-validatebox"
										data-options="required:true" id="companyAddress">
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item2">
								<span class="label">公司简介：</span>
								<div class="fb_fl fb_f6">
									<textarea name="supply.description"
										style="width: 350px;height: 90px;resize: none;"></textarea>
								</div>
								<div class="clr"></div>
							</div>
						</div>
						<!--招聘信息end-->
						<!--求职信息begin-->
						<div id="qiuzhi">
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>性别：</span>
								<div class="fb_gqfl">
									<label><input type="radio" checked="checked"
										name="supply.gender" class="inRadio_blue" value="1">男</label>
									<label><input type="radio" name="supply.gender"
										class="inRadio_blue" value="0">女</label>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>出生日期：</span>
								<div class="fb_f2">
									<div>
										<input name="supply.birthday" type="text" readonly="readonly"
											style="background:#fff url('/js/My97DatePicker/skin/datePicker.gif') no-repeat right;height:20px;"
											class="text easyui-validatebox" data-options="required:true"
											onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>现居住地：</span>
								<div class="fb_fl fb_f7">
									<div>
										<SELECT class="text easyui-validatebox" data-options="required:true"  id="h_province">
											<OPTION selected value="">-选择省-</OPTION>
											<c:forEach items="${regions }" var="re">
												<option value="${re.id }">${re.name }</option>
											</c:forEach>
										</SELECT>
									</div>
								</div>
								<div class="fb_fl fb_f7">
									<div>
										<SELECT class="text easyui-validatebox" data-options="required:true"  id="h_city">
											<OPTION selected value="请选择">请选择</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="fb_fl fb_f7">
									<div>
										<SELECT class="text" id="h_area">
											<OPTION selected value="请选择">请选择</OPTION>
										</SELECT>
									</div>
								</div>
								<input type="hidden" name="supply.homeAddress">
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>详细地址：</span>
								<div class="fb_f2">
									<div>
										<input type="text" class="text easyui-validatebox"
										data-options="required:true" id="homeAddress">
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>籍贯：</span>
								<div class="fb_fl">
									<div>
										<input type="text" class="text easyui-validatebox"
											data-options="required:true" name="supply.originPlace">
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>最高学历：</span>
								<div class="fb_f2">
									<div>
										<SELECT class="text easyui-validatebox"
											data-options="required:true" name="supply.education" id="qiuzhi_education">
											<OPTION selected value="">请选择</OPTION>
											<OPTION value="本科及本科以上">本科及本科以上</OPTION>
											<OPTION value="大专/技校">大专/技校</OPTION>
											<OPTION value="高中/中专职高">高中/中专职高</OPTION>
											<OPTION value="初中及初中以下">初中及初中以下</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label">证书：</span>
								<div class="fb_f2">
									<div>
										<input type="text" class="text" name="supply.certificate">
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>工作经验：</span>
								<div class="fb_f2">
									<div>
										<SELECT class="text easyui-validatebox"
											data-options="required:true" name="supply.workExperience" id="qiuzhi_workExperience">
											<OPTION selected value="">请选择</OPTION>
											<OPTION value="八年以上">八年以上</OPTION>
											<OPTION value="五至八年">五至八年</OPTION>
											<OPTION value="三至五年">三至五年</OPTION>
											<OPTION value="三年以下">三年以下</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>期望职位类别：</span>
								<div class="fb_f2">
									<div>
										<SELECT class="text easyui-validatebox"
											data-options="required:true" name="supply.jobCat" id="qiuzhi_jobCat">
											<OPTION selected value="">请选择</OPTION>
											<OPTION value="销售">销售</OPTION>
											<OPTION value="采购">采购</OPTION>
											<OPTION value="行政">行政</OPTION>
											<OPTION value="财务">财务</OPTION>
											<OPTION value="技术">技术</OPTION>
											<OPTION value="其他">其他</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>期望职位：</span>
								<div class="fb_f2">
									<div>
										<SELECT class="text easyui-validatebox"
											data-options="required:true" name="supply.job" id="qiuzhi_job">
											<OPTION selected value="">请选择</OPTION>
											<OPTION value="工人/职员">工人/职员</OPTION>
											<OPTION value="基层管理">基层管理</OPTION>
											<OPTION value="中层管理">中层管理</OPTION>
											<OPTION value="高层管理">高层管理</OPTION>
											<OPTION value="其他">其他</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>期望月薪：</span>
								<div class="fb_f2">
									<div>
										<input type="text" class="text"
											data-options="required:true" name="supply.monthlypay">
									</div>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item2">
								<span class="label">个人简介：</span>
								<div class="fb_fl fb_f6">
									<textarea name="supply.description"
										style="width: 350px;height: 90px;resize: none;"></textarea>
								</div>
								<div class="clr"></div>
							</div>
							<div class="item">
								<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>求职地区：</span>
								<div class="fb_fl fb_f7">
									<div>
										<SELECT class="text easyui-validatebox" data-options="required:true"  id="j_province">
											<OPTION selected value="">-选择省-</OPTION>
											<c:forEach items="${regions }" var="re">
												<option value="${re.id }">${re.name }</option>
											</c:forEach>
										</SELECT>
									</div>
								</div>
								<div class="fb_fl fb_f7">
									<div>
										<SELECT class="text easyui-validatebox" data-options="required:true"  id="j_city">
											<OPTION selected value="请选择">请选择</OPTION>
										</SELECT>
									</div>
								</div>
								<div class="fb_fl fb_f7">
									<div>
										<SELECT class="text" id="j_area">
											<OPTION selected value="请选择">请选择</OPTION>
										</SELECT>
									</div>
								</div>
								<input type="hidden" name="supply.jobPlace">
								<div class="clr"></div>
							</div>
						</div>
						<!--求职信息end-->
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>有效期：</span>
							<div class="fb_fl fb_f5">
								<input type="text" class="text easyui-validatebox"
									data-options="required:true" name="supply.effectivetime"
									readonly="readonly"
									style="background:#fff url('/js/My97DatePicker/skin/datePicker.gif') no-repeat right;height:20px;"
									class="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
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
								<input type="text" class="text easyui-validatebox"
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
					</div>
					<div class="wcmenu">
						<a href="javascript:sub();"><img src="/images/wcmenu.gif" /> </a>
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
