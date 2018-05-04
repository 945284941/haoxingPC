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
	      url:'questionAskAction!statisticsQuestionAsk.action',
	      dataType:'json', 
	     success:function(downLoadStatisticsInfo){
	    	 $("#tiwenCount").empty();
	    	 if(downLoadStatisticsInfo.questions==null){
	    		 $("#tiwenCount").append(0);
	    	 }else{
	    		 $("#tiwenCount").append(downLoadStatisticsInfo.questions);
	    	 }
	    	 $("#huidaCount").empty();
	    	 if(downLoadStatisticsInfo.questions==null){
	    		 $("#huidaCount").append(0);
	    	 }else{
	    		 $("#huidaCount").append(downLoadStatisticsInfo.questions);
	    	 }
	    	 
	     }})
	    ;

	
});



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
	
	
	$(function(){  
		var ra = document.getElementById('range').value;
		if(ra!='' ){
			$("#range"+ra).attr("selected","selected");
		}
	});
	var questionAskIds="";
	function checkAll(){
		$("input[name='questionAskId']").attr("checked",true); 
	} 
	function deleteAll(){
		var arrChk=$("input[name='questionAskId']:checked");
	    //遍历得到每个checkbox的value值
	    for (var i=0;i<arrChk.length;i++)
	    {
	    	questionAskIds=arrChk[i].value+','+questionAskIds;
	    }
	    //$('#deleteAllInfo').submit();
	    delAll(questionAskIds,"questionAskAction!deleteQuestionAskByIds.action?questionAskIds="+questionAskIds+"&questionType="+'${questionType}',"person/questionAskAction/toQuestionAskList/${questionType}.html");
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
<div class="dht">首页 &gt; 会员中心  &gt;重配学院  &gt; 技术答疑列表</div>
<div class="gzgz">
    <div class="hyleft">
     	<jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" />
     </div>
     <div class="hyright">
      <div class="hyrightr">
       <div id="rightjxw">
           <p class="hyd0">提问数<span id="tiwenCount"></span></p>
           <p class="hyd0">回答数<span id="huidaCount"></span></p>
       </div>
      </div>
       <p class="hymainbt"><span class="grmenubt">重配学院</span></p>
       <h2><span style="width:90px;">技术答疑列表</span></h2>       
       <div class="grjbxx2" style="padding-bottom:10px;">
         <div class="jsdydy">
         	<span class="jsdyask">
         		<s:if test="questionType==0">
         			<a class="hover" onclick="openOrderPage('/person/questionAskAction/toQuestionAskList/0.html');">提问列表</a>
         		</s:if>
         		<s:else>
         			<a  onclick="openOrderPage('/person/questionAskAction/toQuestionAskList/0.html');">提问列表</a>
         		</s:else>
         		
         	</span>
         	<span class="jsdyask">
         		<s:if test="questionType==1">
         			<a class="hover" onclick="openOrderPage('/person/questionAskAction/toQuestionAskList/1.html');">回答列表</a>
         		</s:if>
         		<s:else>
         			<a onclick="openOrderPage('/person/questionAskAction/toQuestionAskList/1.html');">回答列表</a>
         		</s:else>
         	</span>
         </div>
         <div class="cxzx grcxzx">
         <form action="person/questionAskAction/toQuestionAskList/${questionType}.html" id="pagerForm" name="pagerForm"method="post">
	          <ul> 
	           <li style="_margin-top:5px;"><span><input type="checkbox" value="${id}"   onclick="checkAll()" />全选</span></li>
	           <li><a class="qd"  onclick="deleteAll()">删除</a></li>
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
         <p class="xhbt"><span style="margin-left:80px; width:270px;">问答标题</span><span style="width:78px; margin-left:40px; margin-right:25px;">问答分类</span><span style="width:90px; margin-right:20px;">发布时间</span><span>操作</span></p>
         <s:iterator value="questionOrAskList"status="st">
         <div class="grzxlb">
           <ul>
             <li class="grzxone"><input type="checkbox" value="${id}" name="questionAskId" id="questionAskId"   /></li>
             <li class="grzxtwo">
             	<s:if test="questionType==0">
             		<a href="school/jdview/${id}.html" target="_blank">${titleNews}</a>
             	</s:if>
             	<s:else>
             		<a href="school/jdview/${questionId}.html" target="_blank">${titleNews}</a>
             	</s:else>
             	</li>
             <li class="grzxthree">${catNews }</li>
             <li class="grzxfour">[<s:date format="yyyy-MM-dd" name="%{createTime}"/>]</li>
             <li class="grzxfive">
             	<s:if test="questionType==0">
             		<a href="school/jdview/${id}.html"target="_blank">查看</a><a onclick="delAll('${id}','person/questionAskAction/deleteQuestionAskByIds/${id}/${questionType}.html','person/questionAskAction/toQuestionAskList/${questionType}.html')">移除</a>
             	</s:if>
             	<s:else>
             		<a href="school/jdview/${questionId}.html"target="_blank">查看</a><a onclick="delAll('${id}','person/questionAskAction/deleteQuestionAskByIds/${id}/${questionType}.html','person/questionAskAction/toQuestionAskList/${questionType}.html')">移除</a>
             	</s:else>
             	</li>
           </ul>
           <div style="clear:both"></div>
         </div>
          <s:if test="#st.index==9||#st.index==19">
         	<div class="zpxygg"><a href="#"><img src="/images/memberimg/zpxygg.gif"  /></a></div>
          </s:if>
         </s:iterator>
         <div id="showpages">
			<page:pagination path="person/questionAskAction/toQuestionAskList.html" formName="pagerForm"/>
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