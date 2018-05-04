 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="web/css/base.css" type="text/css"/>
<link rel="stylesheet" href="web/bootstrap/bootstrap.min.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<jsp:include page="/js/jquery-easyui-1.3.3/easyuiJs.jsp"></jsp:include>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/JavaScript">
	function submit(){
		$('#searchForm').submit();
	}
	//全选方法，itemName全选的checkbox名称，checkbox为全选的checkbox
	function ff(itemName,checkbox){
	    var checkArray = document.getElementsByName(itemName);
	    var flag = checkbox.checked;
	    for (var i = 0; i < checkArray.length;i++){
	        if (checkArray[i].checked != flag)
	        {
	        	checkArray[i].checked = flag;
	        }
	    }
	}
	function _delete(id){
			if(id==undefined){
				var s=document.getElementsByName("check");
				var a=0;
				var ids="";
				for( var i=0;i<s.length;i++){
					  if(s[i].checked){
						  ids = ids +","+ s[i].value; 
					  	  a++;
					   }
				}
				if(a<=0){
					alert("请选择需要删除的项目!");
					return false;
				}
				ids=ids.substring(1,ids.length);
				if(window.confirm("确定删除?")){
					$.get('newsCenter/news!deleteLljl.action',{"ids":ids},function(data){
						window.location.href="xxzx/toLljl.html?page="+$('#page').val();
					});
				};
			}else{
				ids=id;
				if(window.confirm("确定删除?")){
					$.get('newsCenter/news!deleteLljl.action',{"ids":ids},function(data){
						if(data){
							window.location.href="/xxzx/toLljl.html?page="+$('#page').val();
						}else{
							alert("删除错误!");
						}
					});
				};
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
		   <div class="breadThumb">	首页 &gt; 会员中心&gt; 新闻资讯&gt;浏览记录</div>
	<div class="gzgz">
		<div class="hyleft">
			<c:choose>
				<c:when test="${sessionInfo.userType=='member' }">
						<jsp:include page="/memberCenter/common/leftNavigatePerson.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="/memberCenter/common/leftNavigate.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="hyright">
			<p class="hymainbt">
				<span class="grmenubt">浏览记录</span>
			</p>
		    <div class="myToolbar">
		    	<div class="fn-left">
		    	  <a class="btn btn-primary btn-sm"  href="javascript:_delete()">删除选中</a>
		    	</div>
		    	<div class="fn-right">
		    	<form id="searchForm" name="searchForm" action="xxzx/toLljl.html"  method="post">
		    		始:	<input id="startTime" name="startTime" type="text"
							class="Wdate" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}',dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<s:date name='startTime' format='yyyy-MM-dd HH:mm:ss'/>"  readonly="readonly"/>
					终:<input id="endTime" name="endTime" type="text" readonly="readonly" class="Wdate" onclick="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}',dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<s:date name='endTime' format='yyyy-MM-dd HH:mm:ss'/>" />		
		    	<a class="btn btn-success btn-sm" href="javascript:submit()">确定</a>
		    	</form>
		    	</div>
		    </div>
		    <table class="table table-bordered myTableList">
				<thead>
					<tr>
						<th width="40" style="width:60px;">
						<input type="checkbox" name="checkall" onclick="ff('check',this)" style="vertical-align:sub;"/> 全选
						</th>
						<th width="200">文章标题</th>
						<th class="text-center">文章分类</th>
						<th class="text-center">收藏时间</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${vNews }" var="v">
					<tr>
						<td><input type="checkbox" value="${v.ID }" name="check" /></td>
						<td><a href="news/detail/${v.NEWS_ID }.html" target="_blank" title="${v.FIRST_TITLE }">${fn:substring(v.FIRST_TITLE , 0, 20)}</a></td>
						<td class="text-center">健康资讯</td>
						<td class="text-center"><fmt:formatDate value="${v.CREATETIME }" pattern="yyyy/MM/dd" /></td>
						<td class="text-center opt"><a href="news/detail/${v.NEWS_ID }.html" target="_blank">查看</a><a href="javascript:_delete('${v.ID}')">移除</a></td>
					</tr>
					</c:forEach>
					<tr>
						<td colspan="5">
						<page:pagination path="xxzx/toLljl.html" formName="searchForm" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
		<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>