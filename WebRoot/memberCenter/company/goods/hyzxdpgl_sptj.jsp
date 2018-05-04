<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<jsp:include page="/js/jquery-easyui-1.3.3/easyuiJs.jsp"></jsp:include>
<!-- kindEditor -->
<link rel="stylesheet" href="js/kindeditor-4.1.7/themes/default/default.css"/>
<script type="text/javascript" src="js/kindeditor-4.1.7/kindeditor-all-min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/util.js"></script>
<style>
texearea {
	resize: none;
}

</style>
<script type="text/javascript">
	$(function(){
		var temp=undefined;
		var is_load_starand=false;
		var is_load_value;
		window.setTimeout(function() {
			editor = KindEditor.create('#information', {
				width : '650px',
				height : '400px',
				resizeType : 0,
				items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
				uploadJson : 'up!upload.action'
			});
		}, 1);
		
		$('#type').combobox({
			multiple:true,editable:false,valueField:'id', textField:'name',required:true
		});
		$('#myform').form('disableValidation');
	});

	/**
	 * 创建上传窗口 公共方法
	 * @param chunk 是否分割大文件
	 * @param callBack 上传成功之后的回调
	 */
	function Uploader(chunk, callBack) {
		var editWin = $('<div style="overflow: hidden;"/>');
		var upladoer = $('<iframe/>');
		upladoer.attr({
			'src' : 'news/news!toUploadPage.action?chunk=' + chunk,
			width : '100%',
			height : '100%',
			frameborder : '0',
			scrolling : 'no'
		});
		editWin.dialog({
			title : "上传文件",
			height : 350,
			width : 550,
			minimizable : false,
			modal : true,
			collapsible : false,
			maximizable : false,
			resizable : false,
			content : upladoer,
			onClose : function() {
				var fw = GetFrameWindow(upladoer[0]);
				var files = fw.files;
				//var paths=fw.paths;
				var thumbPaths = fw.thumbPaths;
				//var standardPaths=fw.standardPaths;
				$(this).window('destroy');
				//callBack.call(this,files,paths,thumbPaths,standardPaths);
				callBack.call(this, files, thumbPaths);
			},
			onOpen : function() {
				var target = $(this);
				setTimeout(function() {
					var fw = GetFrameWindow(upladoer[0]);
					fw.target = target;
				}, 100);
			}
		});
	}

	/**
	 * 根据iframe对象获取iframe的window对象
	 * @param frame
	 * @returns {Boolean}
	 */
	function GetFrameWindow(frame) {
		return frame && typeof (frame) == 'object' && frame.tagName == 'IFRAME'
				&& frame.contentWindow;
	}

	function makerUpload(chunk) {
		//Uploader(chunk,function(files,paths,thumbPaths,standardPaths){
		Uploader(chunk, function(files, thumbPaths) {
			if (files && files.length > 0) {
				var path =document.getElementById('picPath');
				var thumb = thumbPaths.join(",").split(",");
				for ( var i = 0; i < thumb.length; i++) {
					var img=document.createElement("img");  
					img.setAttribute("id",ext_UUID());
					img.setAttribute('src',thumb[i]);
					img.style.height='41px';
					img.style.width='55px';
					img.style.marginRight='10px';
					img.style.display="inline";
					img.ondblclick= function(){
						goods_add_dropDom(this);
					};
					path.appendChild(img);
				} ;
			};
		});
	}
	function goods_add_dropDom(obj){
		if(window.confirm("确定要删除该上传的图片?")){
			$("#"+obj.id).remove();
			/*$.ajax({
				url : "goods!dropImg.action",
				type : "POST",
				dataType : "JSON",
				data : "src="+obj.src+"&goodsId=add",
				success : function(j) {
					if(j){
						alert("删除成功");
						
						
					}else{
						alert("删除失败");
						return ;
					}
				}
			});				
			*/
		}
	}
</script>
<script type="text/JavaScript">
	function showElement(elementId) {
		document.getElementById(elementId).style.display = "block";
	}
	function hideElement(elementId) {
		document.getElementById(elementId).style.display = "none";
	}
	function gainNextCarBrand(id,pid){
		$('#'+id).combobox('reload','memberCenter/goods!gainCarBrandNext.action?pid='+pid);  
	}
	function onSub(){
		$.messager.progress({
			title : '提示',
			text : '数据处理中，请稍后....'
		});
		var myform=$('#myform').form();
		$('#myform').form('enableValidation');
		if(myform.form('validate')){
			try {
				editor.sync();
				var specValues = [];
				var inputs = $("#myform input[name='specValue']");
				var goodsLabel = $('#goodsLabel').combobox('getValues');
				$("#myform input[name='goodsLabel']").val(goodsLabel);
				for ( var i = 0; i < inputs.length; i++) {
					var e = inputs[i];
					var spec = $('#' + e.id);
					var specValue = spec.val();
					if (!specValue.trim() == "") {
						specValues.push(e.id + "~" + specValue);
					}
				}
				$("#myform input[name='specValues']").val(specValues.toString());
				
				var temp = $('#picPath img');
				var pic = [];
				for ( var i = 0; i < temp.length; i++) {
					var e = temp[i];
					var s = e.src;
					pic.push(s);
				}
				$("#myform input[name='picSrc']").val(pic.toString());
			} catch (e) {
				$.messager.progress('close');
				$.messager.alert('Warning','脚本错误,请重试!');
			}
			$.ajax({
				url : 'memberCenter/goods!checkSession.action',
				type : 'POST',
				dataType:'JSON',
				success:function(json){
					if(!json){
						$.messager.progress('close');
						showLogin('mask','pop_500','myform','1','');
					}else{
						document.getElementById('myform').submit();
					}
				}
			});
			return true;
		}else{
			$.messager.progress('close');
			return false;
		}
	}
	
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
</head>
<body>
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
		   <jsp:include page="/admin/common/navigation.jsp" />
	<!-- 头部结束 -->
	<!-- 页脚开始 -->
		<div class="breadThumb">首页 > 企业会员中心 > 电子商城 > 商品管理 > 商品添加</div>
	<div class="gzgz">
		<div class="hyleft">
			<jsp:include page="/memberCenter/common/leftNavigate.jsp"></jsp:include>
		</div>
		<div class="hyright">
			<p class="hymainbt">
				<span class="grmenubt">店铺管理</span><a onclick="loginOrNot('memberCenterGL.html');">发布列表</a><a
					onclick="loginOrNot('memberCenterGRE.html');">回收站</a><a class="lb"  >添加商品</a><span class="tjsp">商品添加</span>
			</p>
			<form action="memberCenter/goods!add.action" method="post" id="myform">
			<input type="hidden" name="specValues" >
			<input type="hidden" name="goodsLabel">
			<div class="grjbxx2">
				<div class="spitem">
					<span class="label">商品编号</span>
					<div class="fb_fl">
						<div>
							<input type="text" class="text easyui-validatebox" id="goods_bn" name="goods.bn" data-options="required:true">
						</div>
					</div>
					<span class="label">商品名称</span>
					<div class="fb_fl">
						<div>
							<input type="text" class="text easyui-validatebox" id="goods_name" name="goods.name" data-options="required:true">
						</div>
					</div>
					<span class="label">商品分类</span>
					<div class="fb_fl">
						<select class="text easyui-combotree" id="goodsCat" style="height:26px;" name='goods.carPartsId' data-options="panelWidth:500,required:true,url:'memberCenter/goods!gainGoodsCatListByPid.action',onBeforeSelect: function(node) {
				            if (!$(this).tree('isLeaf', node.target)) {
				                return false;
				            }
				        },
				        onClick: function(node) {
				            if (!$(this).tree('isLeaf', node.target)) {
				                $('#goodsCat').combotree('showPanel');
				                if(node.state=='open'){
									$('#goodsCat').combotree('tree').tree('collapse',node.target);
								}else{
									$('#goodsCat').combotree('tree').tree('expand',node.target);
								}
				            }
				        },
				        onLoadSuccess:function(){
				        }">
						</select>
						
						
					</div>
					
					<div style="clear:both"></div>
				</div>
				
				
				<div class="spitem">
					<span class="label">商品原价</span>
					<div class="fb_fl">
						<div>
							<input type="text" class="text easyui-numberbox"  name="goods.yuanjia" data-options="required:true,min:0.01,precision:2">
						</div>
					</div>

						<span class="label">商品现价</span>
					<div class="fb_fl">
						<div>
							<input type="text" class="text easyui-numberbox"  name="goods.price" data-options="required:true,min:0.01,precision:2">
						</div>
					</div>
					<span class="label">商品产地</span>
					<div class="fb_fl">
						<div>
							<input type="text" class="text easyui-validatebox"  id="goods_productArea" name="goods.productArea" data-options="required:true">
						</div>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="spitem">
					<span class="label">单位包装</span>
					<div class="fb_fl">
						<div>
							<input type="text" class="text" id='goods_unit' name="goods.unit">
						</div>
					</div>
					<span class="label">库存数量</span>
					<div class="fb_fl">
						<div>
							<input type="text" class="text easyui-numberbox" name="goods.store" data-options="required:true">
						</div>
					</div>
					<span class="label">商品标签</span>
					<div class="fb_fl">
						<SELECT class="text easyui-combobox" style="height:26px;" data-options="multiple:true,editable:false" id="goodsLabel">
							<c:forEach var="gl" items="${goodsLabels}">     
								<option value="${gl.id }">${gl.name }</option>
							</c:forEach>
						</SELECT>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="spitem">
					<span class="label">是否上架</span>
					<div class="fb_fl">
						<SELECT class="text easyui-combobox" style="height:26px;" id="goods_marketable" data-options="editable:false" name="goods.marketable">							
							<OPTION value="true">是</OPTION>
							<OPTION value="false">否</OPTION>
						</SELECT>
					</div>
						<span class="label">商品简介</span>
					<div class="fb_fl">
						<div>
							<input type="text" class="text easyui-validatebox" style="width:360px;" name="goods.lessinformation" data-options="required:true">
						</div>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="spitem">
					<span class="label">图片上传</span>
					<div class="fb_f1">
						<INPUT class=btn_file value=上传图片 type=button onclick="makerUpload(false);">
						<input type="hidden" name="picSrc">
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="spitem">
					<div id="picPath"></div>
				</div>
				<div class="spitem">
					<p style="font-weight:bold">商品规格：</p>
					<c:forEach var="gs" items="${goodsSpecifications}">     
						<span class="label2">${gs.name}</span>
						<div class="fb_f2">
							<div>
								<input type="text" class="text" id="${gs.id}" name="specValue">
							</div>
						</div>
					</c:forEach>
					
					<div style="clear:both"></div>
				</div>
				<div class="glsp">
					<textarea name='goods.infomation' id="information" style="height: 400px;width: 650px;"></textarea>
				</div>
				<p class="spyl">
					<button type="button" onclick="onSub();">发布</button>
				</p>

			</div>
			</form>
		</div>
		<div style="clear:both"></div>
	</div>
	<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
	<!-- footer end -->
</body>
</html>