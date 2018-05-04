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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>古道金典</title>
<link href="css/page.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script language="JavaScript" type="text/JavaScript">
$(function(){  
	var ra = document.getElementById('range').value;
	if(ra!='' ){
		$("#range"+ra).attr("selected","selected");
	}
});
  var companyInfoIds="";
	function changeRange(value){
			document.getElementById('range').value=value;
	}
	var _submit=function(){
		$('#pagerForm').submit();
	};
	function checkAll(){
		$("input[name='companyInfoId']").attr("checked",true); 
	} 
	function deleteAll(){
		var arrChk=$("input[name='companyInfoId']:checked");
	    //遍历得到每个checkbox的value值
	    for (var i=0;i<arrChk.length;i++)
	    {
	    	companyInfoIds=arrChk[i].value+','+companyInfoIds;
	    }
	    //$('#deleteAllInfo').submit();
	    window.location.href = 'memberManageAction!deleteCompanyInfoList.action?companyInfoIds='+companyInfoIds;
	}
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
<!-- 页脚开始 -->
<div class="dht">首页 &gt; 会员中心 &gt; 店铺管理 &gt;咨询列表</div>
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
       <h2><span>资讯列表</span><a href="memberManageAddCompanyInfo.html">发布资讯</a></h2>
       <div class="grjbxx2">
         <div class="cxzx">
          <form action="memberManageAddCompanyInfoForm.html" id="pagerForm" name="pagerForm"method="post">
         <ul>
		   <li><input name="companysInfo.baseKey"  type="text" class="text"  value="<s:property value='#request.companysInfo.baseKey'/>"/></li>
		   <li><input id="range" name="companysInfo.timeRange"  type="hidden"  value="<s:property value='#request.companysInfo.timeRange'/>"/></li>
            <li><select id="timeRange" class="text" onchange="changeRange(this.value);">
						<option value="">请选择时段</option>
						<option id="range1"  value="1">昨日</option>
							<option id="range3" value="3">近三天</option>
							<option id="range7" value="7">近一周</option>
							<option id="range30" value="30">本月</option>
							<option id="range365" value="365">一年</option>
				</select>
			</li>
         <li> <a class="cx" onclick="_submit()">查询</a></li>
         </ul>
         	</form>
            <div style="clear:both"></div>
         </div>
         <p class="xhbt"><span style="width:78px; margin-left:40px;">序号</span><span style="margin-left:80px; width:270px;">文章标题</span><span style="width:90px; margin-right:30px;">发布时间</span><span>操作</span></p>
        <form action="memberManageAction!deleteCompanyInfoList.action" id="deleteAllInfo" name="deleteAllInfo"method="post">
        
        	<input id="ids" name="companyInfoIds" type="hidden"/>
        
        </form> 
         <s:iterator var="s" value="companysInfos" status="st">
	         <div class="zxlb">
	           <ul>
	             <li><input type="checkbox" value="${id}" name="companyInfoId" id="companyInfoId" /></li>
	             <li class="one"><s:property value="#st.index+1"/></li>
	             <li class="two"><a href="#">${firstTitle }</a></li>
	             <li class="three">[<s:date format="yyyy-MM-dd" name="%{createTime}"/>]</li>
	             <li class="four"><a  target="_blank" href="/Shop/comInformation/detail/${id}_${company.id}.html">预览</a><a href="memberManageUpdateCompanyInfo/${id}.html">修改</a><a href="memberManageAction!deleteCompanyInfoList.action?companyInfoIds=${id}">删除</a></li>
	           </ul>
	           <div style="clear:both"></div>
	         </div>
 			</s:iterator>
         <div class="zxcz"><span><input type="checkbox"  name="checkbox" onclick="checkAll()"/>全选</span><a class="sc" onclick="deleteAll()">删除</a></div>
       </div>
       <div id="showpages" style="width:665px;">
			<page:pagination path="memberManageAddCompanyInfoForm.html" formName="pagerForm"/>
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