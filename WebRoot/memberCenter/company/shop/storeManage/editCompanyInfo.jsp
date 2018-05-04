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
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>古道金典</title>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="js/kindeditor-4.1.7/themes/default/default.css"/>
<script type="text/javascript" src="js/kindeditor-4.1.7/kindeditor-all-min.js" charset="utf-8"></script>

<script language="JavaScript" type="text/JavaScript">
function showElement(elementId)
{
  document.getElementById(elementId).style.display="block";
}
function hideElement(elementId)
{
  document.getElementById(elementId).style.display="none";
}
$(function() {
    /**
			商品详情的在线编辑
		 */
		window.setTimeout(function() {
			editor = KindEditor.create('#admin_add_companyInfo_textarea_${company.id }', {
				width : '500px',
				height : '500px',
				items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
				uploadJson : 'up!upload.action'
			});
		}, 1);
		});
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
<div class="dht"><a href="#">首页</a> &gt; <a href="#">企业会员中心</a> &gt; <a href="#">店铺管理</a> &gt;<a href="#">咨询修改</a></div>
<div class="gzgz">
     <div class="hyleft">
      <jsp:include page="/memberCenter/common/leftNavigate.jsp" />
     </div>
     <div class="hyright">
        <div class="hyrightr hyflgl">
			<div id="rightjxw" >
			        <s:action name="statisticsAction!showRightStatistics" namespace="/statisticsManage" executeResult="true"/>
			</div>
		</div>
       <p class="hymainbt"><span class="grmenubt">店铺管理</span></p>
       <h2><a href="memberManageCompanyInfo.html">资讯列表</a><span>修改保存</span></h2>
       <div class="grjbxx3 grjby">
       <form action="memberManageAction!updateCompanyInfo.action" method="post">
         <p><em>资讯标题：</em>
         <input name="companysInfo.id" type="hidden" value="${companysInfo.id}"/>
      		<input name="companysInfo.firstTitle" class="zxtitle" value="${companysInfo.firstTitle}"/></p>
         <div class="zx2"><em>资讯内容：</em><br/>
         <div class="zxnr">
         	<textarea name='companysInfo.content' 
						id="admin_add_companyInfo_textarea_${company.id}" >${companysInfo.content }</textarea>
				
         
         </div>
         <div style="clear:both"></div>
        </div>
         <div class="wcfb"><input  class="fb" value="完成发布" type="submit"/></div>
        </form>
       </div>
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