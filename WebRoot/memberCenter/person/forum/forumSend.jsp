<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<link href="web/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/page.css" type="text/css" />
<title>三古汇官方商城</title>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<!-- kindEditor -->
<link rel="stylesheet" href="js/kindeditor-4.1.7/themes/default/default.css"/>
<script type="text/javascript" src="js/kindeditor-4.1.7/kindeditor-all-min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/util.js"></script>
<jsp:include page="/js/jquery-easyui-1.3.3/easyuiJs.jsp"></jsp:include>
<style>
texearea {
	resize: none;
}
</style>
</head>
<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="/admin/common/navigation.jsp" />
<div class="breadThumb">首页 > 会员中心 > 电子商城 > 我的参与 > 我要发帖</div>
<div class="gzgz">
	<div class="hyleft">
		<c:choose>
			<c:when test="${sessionInfo.userType=='company' }"><jsp:include page="/memberCenter/common/leftNavigate.jsp" /></c:when>
			<c:otherwise><jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" /></c:otherwise>
		</c:choose>	
	</div>
	<div class="hyright">
		<p class="hymainbt">
			<span class="grmenubt">我要发帖</span>
		</p>
		<div class="container-fluid">
			<form  class="form-horizontal" action="forum/forumAction!MyForumSend.action" method="post" id="myform">
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-40"></div>
			</div>
			<div class="form-group form-group-sm">
			    <label for="title" class="col-sm-4 control-label">标题</label>
			    <div class="col-sm-40">
			      <input type="text" class="form-control easyui-validatebox" name="forum.title" id="title" data-options='required:true' placeholder="标题">
			    </div>
			</div>
			<div class="form-group form-group-sm">
			    <label for="type" class="col-sm-4 control-label">帖子类型</label>
			    <div class="col-sm-40">
								<input name="forum.type"  class="easyui-combobox"
							data-options="panelHeight:90,valueField:'label',textField: 'value',data: [{label:'0',value: '健康养生'},{label:'1',value:'奇闻趣事'},{label:'2',value:'公益杂谈'},{label:'3',value:'情感部落'}],editable:false" />  
			    </div>
			</div>
			<div class="form-group form-group-sm">
			    <label for="type" class="col-sm-4 control-label">帖子内容</label>
			    <div class="col-sm-30">
			      <textarea rows="15" cols="100" name="forum.information" id="information"></textarea>
			    </div>
			</div>
			<div class="form-group form-group-sm">
			    <label for="type" class="col-sm-4 control-label"></label>
			    <div class="col-sm-30">
			    	<button type="button" class="btn btn-primary" onclick="onSub();">发布</button>
			    </div>
			</div>
	      </form>     
		</div>
	</div>
</div>
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
	<!-- footer end -->
	<script type="text/javascript">
$(function(){
		var temp=undefined;
		var is_load_starand=false;
		var is_load_value;
		window.setTimeout(function() {
			editor = KindEditor.create('#information', {
				width : '840px',
				height : '400px',
				resizeType : 0,
				items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
				uploadJson : 'up!upload.action'
			});
		}, 1);
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
			'src' : 'forum/forumAction!toUploadPage.action?chunk=' + chunk,
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

	
	function onSub(){
		var myform=$('#myform').form();
		$('#myform').form('enableValidation');
		if(myform.form('validate')){
			try {
				editor.sync();
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
</body>
</html>