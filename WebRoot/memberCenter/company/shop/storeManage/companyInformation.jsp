<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
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
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>古道金典</title>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="js/kindeditor-4.1.7/themes/default/default.css"/>
<script type="text/javascript" src="js/kindeditor-4.1.7/kindeditor-all-min.js" charset="utf-8"></script>
<script>
$(function() {
       /**
			商品详情的在线编辑
		 */
		window.setTimeout(function() {
			editor = KindEditor.create('#admin_memberCenter_textarea_${company.id }', {
				width : '500px',
				height : '500px',
				items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
				uploadJson : 'up!upload.action'
			});
		}, 1);
		});
var _submit=function(){
	$('#inforForm').submit();
};
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
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
<div class="dht">首页 &gt; 会员中心&gt; 店铺管理 &gt; 企业简介</div>
<div class="gzgz">
     <div class="hyleft">
      <jsp:include page="/memberCenter/common/leftNavigate.jsp" />
     </div>
     <div class="hyright">
      <form id="inforForm" action="memberManageAction!updateMemberInoformation.action" method="post">
        <div class="hyrightr hyflgl">
			<div id="rightjxw" >
			        <s:action name="statisticsAction!showRightStatistics" namespace="/statisticsManage" executeResult="true"/>
			</div>
		</div>
       <p class="hymainbt"><span class="grmenubt">店铺管理</span></p>
       <p style=" margin-top:20px;"><span style="margin-right: 6px; font-weight: bold;">企业宗旨:</span><span>
       	<input style="width:560px; height:25px; border: 1px solid #dedede;" maxlength="45" type="text"name="company.companyPurpose" value="${company.companyPurpose }" /></span>
       </p>
       <p style=" margin-top:10px; margin-left:60px; ">（企业宗旨描述字数少于45）</p>
       <h2><span>企业简介</span></h2>
      
       <div class="grjbxx2 grjbxxwd">
	       <div class="jjcj jjcj2">
				<textarea name='company.combrief'id="admin_memberCenter_textarea_${company.id}" >${company.combrief}</textarea>
				<input type="hidden" name="company.id" value="${company.id}"/>
			</div>
			<input type="submit" value="保存"  class="bc"/>
		</div>
       </form>
     </div>  
     <div style="clear:both"></div>
</div>
<div class="gg"><a href="/"><img src="/images/memberimg/tlgg1.gif"/></a></div>
<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
<!-- footer end -->
</body>
</html>
