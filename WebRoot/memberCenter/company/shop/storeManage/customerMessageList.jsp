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
<jsp:include page="/admin/common/keyWords.jsp" />
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/page.css" rel="stylesheet" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script language="JavaScript" type="text/JavaScript">
$(function(){  
	var ra = document.getElementById('range').value;
	if(ra!='' ){
		$("#range"+ra).attr("selected","selected");
	}
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

//弹出层
function cusMess(message){
	 _ShowcusDIV('cus-dialogDiv','cus-coverDiv');
	 $("#content").empty();
	 $("#content").append(message);
}

$.fn.center = function(loaded) {
	var obj = this;
	body_width = parseInt($(window).width());
	body_height = parseInt($(window).height());
	block_width = parseInt(obj.width());
	block_height = parseInt(obj.height());

	left_position = parseInt((body_width / 2) - (block_width / 2)
			+ $(window).scrollLeft());
	if (body_width < block_width) {
		left_position = 0 + $(window).scrollLeft();
	}
	;

	top_position = parseInt((body_height / 2) - (block_height / 2)
			+ $(window).scrollTop());
	if (body_height < block_height) {
		top_position = 0 + $(window).scrollTop();
	}
	;

	if (!loaded) {

		obj.css({
			'position' : 'absolute'
		});
		obj.css({
			'top' : top_position,
			'left' : left_position
		});
		$(window).bind('resize', function() {
			obj.center(!loaded);
		});
		$(window).bind('scroll', function() {
			obj.center(!loaded);
		});

	} else {
		obj.stop();
		obj.css({
			'position' : 'absolute'
		});
		obj.animate({
			'top' : top_position
		}, 200, 'linear');
	}
};
//遮盖层显示
function _ShowcusDIV(ObjID1, ObjID2) {
	$('#' + ObjID2).css({
		'height' : $(document).height()
	});
	$('#' + ObjID2).show();
	$('#' + ObjID1).center();
	$('#' + ObjID1).fadeIn();
}
function _ClosecusDiv(ObjID1, ObjID2) {
	$('#' + ObjID1).hide();
	$('#' + ObjID2).hide();
}
</script>
<style type="text/css">
#cus-coverDiv {
	background-color: #666;
	position: absolute;
	z-index: 1100;
	left: 0;
	top: 0;
	display: none;
	width: 100%;
	opacity: 0.5;
	filter: alpha(opacity =     50);
	-moz-opacity: 0.5;
}

.cus-Box {
	width: 500px;
	/*margin: 300px 0;*/
	left: 450px;
	min-height: 150px;
	_height: 150px;
	box-shadow: 1px 1px 7px #666;
	border: 1px solid #CDCDCD;
	position: absolute;
	background: #FFFFFF;
	z-index: 2000;
	display:none;
	padding:5px 20px;
	text-indent: 2em;	
}
#content{ background:url(images/tcly.gif) no-repeat center top; padding-top:15px;}
.showcus {
	margin: 0 auto 10px auto;
	padding-top:30px;
	width: 710px;
	height: 450px;
}

.close {
	top: 10px;
	width: 24px;
	height: 24px;
	right: 8px;
	text-indent: -9999px;
	display: block;
	position: absolute;
	z-index: 1;
	outline-width: 0;
	outline-style: none;
	outline-color: invert;
	background-repeat: no-repeat;
	background-position-x: 50%;
	background-position-y: 7px;
	background-size: auto;
	background-origin: padding-box;
	background-clip: border-box;
	background-color: transparent;
	background: url(images/close.png) no-repeat;
}

.close a {
	top: 10px;
	width: 24px;
	height: 24px;
	right: 8px;
	cursor: pointer;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>古道金典</title>
</head>
<body id="mainbody" >
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
<div class="dht">首页 &gt; 会员中心 &gt;店铺管理 &gt; 客户留言</div>
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
        <h2><span>客户留言</span></h2>
       <div class="grjbxx2">
         <div class="cxzx">
         <form action="memberManageCustomerMessage.html"id="pagerForm" name="pagerForm"method="post">
         <ul>
		   <li><input name="companyMessage.baseKey"  type="text" class="text"  value="<s:property value='#request.companyMessage.baseKey'/>"/></li>
		   <li><input id="range" name="companyMessage.timeRange"  type="hidden"  value="<s:property value='#request.companyMessage.timeRange'/>"/></li>
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
         <p class="xhbt ly_bt"><span style="width:115px; margin-right:25px;">留言人</span><span style="margin-right:25px; width:310px;">留言内容</span><span style="width:83px; margin-right:25px;">留言时间</span><span>操作</span></p>
         <s:iterator var="s" value="companysMessages">
         <div class="zxlb ly_lb">
           <ul>
             <li class="onely"><span>${memberName }</span></li>
             <li class="twoly">${message}</li>
             <li class="threely">[<s:date format="yyyy-MM-dd" name="%{createTime}"/>]</li>
             <li class="fourly"><a href="javascript:void(0)" id="view-cus-link" title="点击查看信息"
												onclick="cusMess('${message}')">查看</a></li>
           </ul>
           <div style="clear:both"></div>
         </div>
         </s:iterator>
          <div id="showpages">
			<page:pagination path="memberManageCustomerMessage.html" formName="pagerForm"/>
		 </div>
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
<div id="cus-coverDiv"></div>
<div class="cus-Box" id="cus-dialogDiv">
	<a id="companyList-cus-close" class="close" href="javascript:void(0)" onclick="_ClosecusDiv('cus-dialogDiv','cus-coverDiv')"></a><br/>
	<div id="content">
		
	</div>
</div>       	
</body>
</html>
