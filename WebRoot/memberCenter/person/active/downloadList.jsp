<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<link href="css/page.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/public.js"></script>
<script language="JavaScript" type="text/JavaScript">
$(function(){  
	var ra = document.getElementById('range').value;
	if(ra!='' ){
		$("#range"+ra).attr("selected","selected");
	}
	//右边赋值
	 $.ajax({  
	     type:'post',  
	      url:'dataDownload!statisticsDownLoad.action',
	      dataType:'json', 
	     success:function(downLoadStatisticsInfo){
	    	 $("#shouchangCount").empty();
	    	 if(downLoadStatisticsInfo.collectNewsCount==null){
	    		 $("#shouchangCount").append(0);
	    	 }else{
	    		 $("#shouchangCount").append(downLoadStatisticsInfo.collectNewsCount);
	    	 }
	    	 $("#liulanCount").empty();
	    	 if(downLoadStatisticsInfo.browseNewsCount==null){
	    		 $("#liulanCount").append(0);
	    	 }else{
	    		 $("#liulanCount").append(downLoadStatisticsInfo.browseNewsCount);
	    	 }
	    	 $("#xiazaiCount").empty();
	    	 if(downLoadStatisticsInfo.downloadData==null){
	    		 $("#xiazaiCount").append(0);
	    	 }else{
	    		 $("#xiazaiCount").append(downLoadStatisticsInfo.downloadData);
	    	 }
	    	 
	     }})
	    ;

	
});
var dataDownloadIds="";
function showElement(elementId)
{
  document.getElementById(elementId).style.display="block";
}
function hideElement(elementId)
{
  document.getElementById(elementId).style.display="none";
}
function changeRange(value){
	document.getElementById('range').value=value;
}
var _submit=function(){
$('#pagerForm').submit();
};
function checkAll(){
	$("input[name='dataDownloadId']").attr("checked",true); 
} 
function deleteAll(){
	var arrChk=$("input[name='dataDownloadId']:checked");
    //遍历得到每个checkbox的value值
    for (var i=0;i<arrChk.length;i++)
    {
    	dataDownloadIds=arrChk[i].value+','+dataDownloadIds;
    }
    delAll(dataDownloadIds,"person/dataDownload/deleteDataDownloadByIdsPerson/"+dataDownloadIds+".html","person/dataDownload/toDataloadPointList.html");
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
<div class="dht">首页 &gt; 个人会员中心 &gt;重配学院 &gt; 资料下载列表</div>
<div class="gzgz">
     <div class="hyleft">
      <jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" />
     </div>
     <div class="hyright">
      <div class="hyrightr">
       <div id="rightjxw">
           <p class="hyd0">文章收藏数<span id="shouchangCount"></span></p>
           <p class="hyd0">文章浏览数<span id="liulanCount"></span></p>
           <p class="hyd0">资料下载数<span id="xiazaiCount"></span></p>
       </div>
      </div>
       <p class="hymainbt"><span class="grmenubt">重配学院</span></p>
       <h2><span style="width:90px;">资料下载列表</span></h2>
       <div class="grjbxx2" style="padding-bottom:10px;">
         <div class="cxzx grcxzx">
         <form action="person/dataDownload/toDataloadPointList.html" id="pagerForm" name="pagerForm"method="post">
        	<ul>
           		  <li style="_margin-top:5px;"><span><input type="checkbox" name="checkbox" onclick="checkAll()" />全选</span></li>
		           <li><a class="qd" onclick="deleteAll()">删除</a></li>
		           <li style="margin-right:15px;">
		           		<input id="range" name="timeRange"  type="hidden"  value="<s:property value='#request.timeRange'/>"/>
		           		<select id="timeRange"  class="text" onchange="changeRange(this.value);">
						 	<option value="">请选择时段</option>
						 	<option id="range1"  value="1">昨日</option>
							<option id="range3" value="3">近三天</option>
							<option id="range7" value="7">近一周</option>
							<option id="range30" value="30">本月</option>
							<option id="range365" value="365">一年</option>
						</select>
				    </li>
		            <li><a class="qd" onclick="_submit()">确定</a></li>
         </ul>
         <div style="clear:both"></div>
        </form>
         </div>
         <p class="xhbt"><span style="margin-left:80px; width:270px;">文章标题</span><span style="width:78px; margin-left:40px; margin-right:25px;">文章分类</span><span style="width:90px; margin-right:20px;">下载时间</span><span>操作</span></p>
        <s:iterator value="dataDownloadList" status="st">
         <div class="grzxlb">
           <ul>
             <li class="grzxone"><input type="checkbox" value="${id}" name="dataDownloadId" id="dataDownloadId" /></li>
             <li class="grzxtwo"><a href="news/detail/${newId}.html" target="_blank">${firstTitle}</a></li>
             <li class="grzxthree">${nameCat}</li>
             <li class="grzxfour">[<s:date format="yyyy-MM-dd" name="%{createdate}"/>]</li>
             <li class="grzxfive"><a href="news/detail/${newId}.html" target="_blank">查看</a><a onclick="delAll('${id}','person/dataDownload/deleteDataDownloadByIdsPerson/${id}.html','person/dataDownload/toDataloadPointList.html')">移除</a></li>
           </ul>
           <div style="clear:both"></div>
         </div>
         <s:if test="#st.index==9||#st.index==19">
         		<div class="zpxygg"><a href="#"><img src="/images/memberimg/zpxygg.gif"  /></a></div>
         </s:if> 
         </s:iterator>
         
		<div id="showpages">
			<page:pagination path="person/dataDownload/toDataloadPointList.html" formName="pagerForm"/>
		 </div>
       </div>
     </div>     
</div>
<div class="gg"><a href="/"><img src="/images/memberimg/tlgg1.gif"/></a></div>
<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
<!-- footer end -->
</body>
</html>