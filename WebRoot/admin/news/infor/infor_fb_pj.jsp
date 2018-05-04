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
			$("#myform input[name='supply.carbrandName']").val($('#firstBrand').combobox('getText'));
			$("#myform input[name='supply.carseriesName']").val($('#secondBrand').combobox('getText'));
			$("#myform input[name='supply.cartypeName']").val($('#thirdBrand').combobox('getText'));
			if($('#partsProducerId').combobox('getValue')!="") $("#myform input[name='supply.producerName']").val($('#partsProducerId').combobox('getText'));
			
			var cat=document.getElementById('thirdGoodsCat');
			var temp=cat.options[cat.selectedIndex].text;
			$("#myform input[name='supply.carcatName']").val(temp);
			
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
			
			$("#myform input[name='supply.address']").val(temp1+" "+temp2+" "+temp3+" "+$('#address').val());
			
			
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
	function gainNextCarBrand(id,pid){
		$('#'+id).combobox('reload','/news/news!gainNextCarBrand.action?pid='+pid);  
	}
	
	function reduceValidate(){
		$('#myform').form('enableValidation');
	}
	$(function() {
		var temp=undefined;
		var temp2=undefined;
		$('#firstBrand').combobox({
			multiple:true,
			editable:false,
			width:350,
			valueField:'id', 
			textField:'name',
			required:true,
			onChange:function(newValue,oldValue){
				$('#secondBrand').combobox('clear');
				$('#thirdBrand').combobox('clear').combobox('loadData',{});
				gainNextCarBrand('secondBrand',newValue);
			},
			onLoadSuccess:function(){
				temp=$('#firstBrand').combobox('getValues');
			}
		});
	
		$('#secondBrand').combobox({
			url:'/news/news!gainNextCarBrand.action?pid='+temp,
			multiple:true,
			editable:false,
			required:true,
			width:350,
			valueField:'id', 
			textField:'name',
			onChange:function(newValue,oldValue){ 
				$('#thirdBrand').combobox('clear');
				gainNextCarBrand('thirdBrand',newValue);
			},
			onLoadSuccess:function(){
				var target = $(this);
				var data = target.combobox('getData');
				var options = target.combobox('options');
				if(data && data.length>0){
					var fs = data[0];
					target.combobox('setValue',fs[options.valueField]);
				}
			}
		});
		$('#thirdBrand').combobox({
			multiple:true,editable:false,valueField:'id', textField:'name',required:true,width:350,
			onLoadSuccess:function(){
				var target = $(this);
				var data = target.combobox('getData');
				var options = target.combobox('options');
				if(data && data.length>0){
					var fs = data[0];
					target.combobox('setValue',fs[options.valueField]);
				}
			}
		});
		
		$('#province').bind('change',function(){
			if(this.value==''){
				$('#city').hide().empty();
				$('#area').hide().empty();
				return ;
			}
			$.ajax({
				type : "POST",
				url : "/news/news!gainNextCityOrAreaByPid.action",
				data : "pid=" + this.value,
				dataType : "JSON",
				success:function(data){
					$('#city').empty().append("<option value=''>请选择</option>");
					$('#area').empty().append("<option value=''>请选择</option>");
					for ( var i = 0, len = data.length; i < len; i++) {
						$('#city').show().append("<option value='"+data[i].id+"'>" + data[i].name + "</option>");
					}
				}
			});
		});
		$('#city').bind('change',function(){
			if(this.value==''){
				$('#area').hide().empty();
				return ;
			}
			$.ajax({
				type : "POST",
				url : "/news/news!gainNextCityOrAreaByPid.action",
				data : "pid=" + this.value,
				dataType : "JSON",
				success:function(data){
					if(data.length<=0){
						$('#area').hide().empty();
						return ;
					}
					$('#area').empty().append("<option value=''>请选择</option>");
					for ( var i = 0, len = data.length; i < len; i++) {
						$('#area').show().append("<option value='"+data[i].id+"'>" + data[i].name + "</option>");
					}
				}
			});
		});
		
		$('#firstGoodsCat').bind('change',function(){
			if(this.value==''){
				$('#secondGoodsCat').hide().empty().append("<option value=''>请选择</option>");
				$('#thirdGoodsCat').hide().empty().append("<option value=''>请选择</option>");
				return ;
			}
			$.ajax({
				type : "POST",
				url : "/news/news!gainNextGoodsCatByPid.action",
				data : "pid=" + this.value,
				dataType : "JSON",
				success:function(data){
					if(data.length<=0){
						$('#secondGoodsCat').hide().empty().append("<option value=''>请选择</option>");
						$('#thirdGoodsCat').hide().empty().append("<option value=''>请选择</option>");
						return ;
					}
					$('#secondGoodsCat').empty().append("<option value=''>请选择</option>");
					$('#thirdGoodsCat').empty().append("<option value=''>请选择</option>");
					for ( var i = 0, len = data.length; i < len; i++) {
						$('#secondGoodsCat').show().append("<option value='"+data[i].id+"'>" + data[i].name + "</option>");
					}
				}
			});
		});
		$('#secondGoodsCat').bind('change',function(){
			if(this.value==''){
				$('#thirdGoodsCat').hide().empty();
				return ;
			}
			$.ajax({
				type : "POST",
				url : "/news/news!gainNextGoodsCatByPid.action",
				data : "pid=" + this.value,
				dataType : "JSON",
				success:function(data){
					if(data.length<=0){
						$('#thirdGoodsCat').hide().empty();
						return ;
					}
					$('#thirdGoodsCat').empty().append("<option value=''>请选择</option>");
					for ( var i = 0, len = data.length; i < len; i++) {
						$('#thirdGoodsCat').show().append("<option value='"+data[i].id+"'>" + data[i].name + "</option>");
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
		<a>首页 > 供求信息  > ${typeName }</a>
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
										<label><input type="radio"  name="supply.status" class="inRadio_blue" value="1">供应</label> 
									</c:if>
									<label><input
									type="radio" name="supply.status" checked="checked" class="inRadio_blue" value="0">求购</label>
							</div>
							<div class="clr"></div>
						</div>
	
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>配件名称：</span>
							<div class="fb_f2">
								<div>
									<input type="text" class="text easyui-validatebox" name="supply.name" data-options="required:true">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">原厂编号：</span>
							<div class="fb_f2">
								<div>
									<input type="text" class="text" name="supply.carBn">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">生产厂家：</span>
							<div class="fb_f2">
								<div>
									<SELECT class="easyui-combobox" name="supply.producerId" id="partsProducerId" data-options="editable:false" style="height:26px;">
										<OPTION selected value="">请选择</OPTION>
										<c:forEach items="${carPartsProducers}" var="cpp">
											<option value="${cpp.id}">${cpp.name }</option>
										</c:forEach>
									</SELECT>
									<input type="hidden" name="supply.producerName">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="itemh">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>适用品牌：</span>
							<div class="fb_f2">
								<div>
									<SELECT name="supply.carbrandId" id="firstBrand" style="height:26px;">
										<c:forEach items="${firstBrand }" var="fb">
											<option value="${fb.id }">${fb.name }</option>
										</c:forEach>
									</SELECT>
									<input type="hidden" name="supply.carbrandName">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="itemh">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>适用车系：</span>
							<div class="fb_f2">
								<div>
									<SELECT name="supply.carseriesId" id="secondBrand" style="height:26px;">
									</SELECT>
									<input type="hidden" name="supply.carseriesName">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="itemh">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>适用车型：</span>
							<div class="fb_f2">
								<div>
									<SELECT name="supply.cartypeId" id="thirdBrand" style="height:26px;">
									</SELECT>
									<input type="hidden" name="supply.cartypeName">
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label">配件分类：</span>
							<div class="fb_fl fb_f7">
								<div>
									<SELECT class="text" id="firstGoodsCat">
										<OPTION selected value="" >请选择</OPTION>
										<c:forEach items="${goodsCats }" var="gc">
											<option value="${gc.id }">${gc.name }</option>
										</c:forEach>
									</SELECT>
								</div>
							</div>
							<div class="fb_fl fb_f7" style="width:170px;">
								<div>
									<SELECT class="text" id="secondGoodsCat" style="display: none;width:165px;">
										<OPTION selected value="">请选择</OPTION>
									</SELECT>
								</div>
							</div>
							<div class="fb_fl fb_f7" style="width:170px;">
								<div>
									<SELECT class="text"  name="supply.carcatId" id="thirdGoodsCat" style="display: none;width:165px;">
										<OPTION selected value="">请选择</OPTION>
									</SELECT>
									<input type="hidden" name="supply.carcatName">
								</div>
							</div>
							<!-- <div class="fb_fl fb_f7" style="width:170px;">
								<div>
									<select class="text easyui-combotree" id="goodsCat" style="height:25px;" name='goods.carPartsId' data-options="required:true,url:'memberCenter/goods!gainGoodsCatList.action',idFiled:'id',textFiled:'name',parentField:'pid',onBeforeSelect: function(node) {
								            if (!$(this).tree('isLeaf', node.target)) {
								                return false;
								            }
								        },
								        onClick: function(node) {
								            if (!$(this).tree('isLeaf', node.target)) {
								                $('#goodsCat').combotree('showPanel');
								            }
								        },
								        onLoadSuccess:function(){
								        	 $('#goodsCat').combotree('tree').tree('collapseAll');
								        }">
									</select>
								</div>
							</div> -->
							<div class="clr"></div>
						</div>
						<div class="item">
							<span class="label"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>所在地区：</span>
							<div class="fb_fl fb_f7">
								<div>
									<SELECT class="text easyui-validatebox" name="supply.provinceId" id="province" data-options="required:true">
										<OPTION selected value="" >-选择省-</OPTION>
										<c:forEach items="${regions }" var="re">
											<option value="${re.id }">${re.name }</option>
										</c:forEach>
									</SELECT>
									<input type="hidden" name="supply.province" >
								</div>
							</div>
							<div class="fb_fl fb_f7">
								<div>
									<SELECT class="text easyui-validatebox" name="supply.cityId" id="city" style="display: none" data-options="required:true">
										<OPTION selected value="">-选择市-</OPTION>
									</SELECT>
									<input type="hidden" name="supply.city" >
								</div>
							</div>
							<div class="fb_fl fb_f7">
								<div>
									<SELECT class="text easyui-validatebox" name="supply.areaId" id="area" style="display: none">
										<OPTION selected value="">-区或县-</OPTION>
									</SELECT>
									<input type="hidden" name="supply.area" >
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item">
								<span class="label">详细地址:</span>
								<div class="fb_f2">
								<div>
									<input type="text" class="text" id="address" ><input type="hidden" name="supply.address">
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
						<div class="item">
							<span class="label">有效期至：</span>
							<div class="fb_f2 fb_f5">
								<div>
									<input name="supply.effectivetime" type="text" readonly="readonly" style="background:#fff url('/js/My97DatePicker/skin/datePicker.gif') no-repeat right;height:20px;" class="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
								</div>
							</div>
							<div class="clr"></div>
						</div>
						<div class="item" style="padding-top: 10px;">
							<span class="label">价格：</span>
							<div class="fb_fl fb_f4">
								<input type="text" class="text easyui-numberbox" name="supply.price" data-options="min:0,precision:2">
							</div>
							<span class="y">元</span>
							<div class="my">
								<input type="checkbox">
							</div>
							<span class="y">可面议</span>
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
							<span class="label">QQ/Email：</span>
							<div class="fb_fl fb_f5">
								<input type="text" class="text" name="supply.qqEmail">
							</div>
							<div class="clr"></div>
						</div>
						<div class="item2">
							<span class="label">配件说明：</span>
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
