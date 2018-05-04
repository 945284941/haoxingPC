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
<script language="JavaScript" type="text/JavaScript">

$(function(){  
	//右边赋值
	 $.ajax({  
	     type:'post',  
	      url:'supplyMessage!statisticsSupply.action',
	      dataType:'json', 
	     success:function(supplyStatisticsInfo){
	    	 $("#zhengche").empty();
	         $("#zhengche").append(supplyStatisticsInfo.zhengcheCount);
	         $("#peijian").empty();
	         $("#peijian").append(supplyStatisticsInfo.peijianCount);
	         $("#shebei").empty();
	         $("#shebei").append(supplyStatisticsInfo.shebeiCount);
	         $("#qixiu").empty();
	         $("#qixiu").append(supplyStatisticsInfo.qixiuCount);
	         $("#wuliu").empty();
	         $("#wuliu").append(supplyStatisticsInfo.wuliuCount);
	         $("#zulin").empty();
	         $("#zulin").append(supplyStatisticsInfo.zulinCount);
	         $("#qiuzhi").empty();
	         $("#qiuzhi").append(supplyStatisticsInfo.qiuzhiCount);
	         $("#qita").empty();
	         $("#qita").append(supplyStatisticsInfo.qitaCount);
	         
	    	 
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
function supplyfb(){
	$.ajax({
		url : 'memberCenter/goods!checkSession.action',
		type : 'POST',
		dataType:'JSON',
		success:function(json){
			if(!json){
				showLogin('mask','pop_500','/s_supplyfb.html','0','');
			}else{
				window.location.href="/s_supplyfb.html";
			}
		}
	});
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
<div class="dht">首页  &gt; 个人会员中心 &gt;我的参与  &gt; 供求信息</div>
<div class="gzgz">
      <div class="hyleft">
     	<jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" />
     </div>
     <div class="hyright gqxxzx">
      <div class="hyrightr">
       <div id="rightjxw">
           <p class="hyd0" >整车求购总数<span id="zhengche"></span></p>
           <p class="hyd0">配件求购总数<span id="peijian"></span></p>
           <p class="hyd0">设备求购总数<span id="shebei"></span></p>
           <p class="hyd0">汽修厂信息总数<span id="qixiu"></span></p>
           <p class="hyd0">物流信息总数<span id="wuliu"></span></p>
           <p class="hyd0">租赁信息总数<span id="zulin"></span></p>
           <p class="hyd0">求职招聘总数<span id="qiuzhi"></span></p>
           <p class="hyd0">其他供求数<span id="qita"></span></p>
       </div>
      </div>
       <p class="hymainbt"><span class="grmenubt">供求信息</span></p>
       <h2>
       		<s:if test="supplyType=='zhengche'">
       			<a href="person/appraise/mySupplyList/zhengche.html" class="gyover" >整车供求</a>
       		</s:if>
       		<s:else>
       			<a href="person/appraise/mySupplyList/zhengche.html"  >整车供求</a>
       		</s:else>
       		<s:if test="supplyType=='peijian'">
       			<a href="person/appraise/mySupplyList/peijian.html" class="gyover">配件供求</a>
       		</s:if>
       		<s:else>
       			<a href="person/appraise/mySupplyList/peijian.html">配件供求</a>
       		</s:else>
       		<s:if test="supplyType=='shebei'">
       			<a href="person/appraise/mySupplyList/shebei.html" class="gyover">设备供求</a>
       		</s:if>
       		<s:else>
       			<a href="person/appraise/mySupplyList/shebei.html">设备供求</a>
       		</s:else>
       		<s:if test="supplyType=='qixiu'">
       			<a href="person/appraise/mySupplyList/qixiu.html" class="gyover">汽修厂信息</a>
       		</s:if>
       		<s:else>
       			<a href="person/appraise/mySupplyList/qixiu.html">汽修厂信息</a>
       		</s:else>
       		<s:if test="supplyType=='wuliu'">
       			<a href="person/appraise/mySupplyList/wuliu.html" class="gyover">物流信息</a>
       		</s:if>
       		<s:else>
       			<a href="person/appraise/mySupplyList/wuliu.html">物流信息</a>
       		</s:else>
       		<s:if test="supplyType=='zulin'">
       			<a href="person/appraise/mySupplyList/zulin.html" class="gyover">租赁</a>
       		</s:if>
       		<s:else>
       			<a href="person/appraise/mySupplyList/zulin.html">租赁</a>
       		</s:else>
       		<s:if test="supplyType=='qiuzhi'">
       			<a href="person/appraise/mySupplyList/qiuzhi.html"  class="gyover">招聘求职</a>
       		</s:if>
       		<s:else>
       			<a href="person/appraise/mySupplyList/qiuzhi.html">招聘求职</a>
       		</s:else>
       		<s:if test="supplyType=='qita'">
       			 <a href="person/appraise/mySupplyList/qita.html"  class="gyover">其他供求</a>
       		</s:if>
       		<s:else>
       			 <a href="person/appraise/mySupplyList/qita.html">其他供求</a>
       		</s:else>
       </h2>
       <div class="grjbxx2" style="padding-bottom:10px; clear:both">
         <div class="gqan"><a class="gqan3" onclick="supplyfb();" target="_blank">发布信息</a></div>
         <s:iterator value="supplyList">
         <div class="grgqlb">
           <ul>
             <li class="grgqtwo"><a href="v_supply/${id}/${typeId}.html"  target="_blank">${title}</a></li>
             <li class="grgqfour">[<s:date format="yyyy-MM-dd" name="%{createtime}"/>]</li>
             <li class="grgqthree">查看${viewnum }</li>
           </ul>
           <div style="clear:both"></div>
         </div>
        </s:iterator>
         <div id="showpages">
			<page:pagination path="person/appraise/mySupplyList.html" formName="pagerForm"/>
		 </div>
		  <form id="pagerForm" name="pagerForm"method="post" style="display: none">
		         <input name="supplyType"  type="hidden"  value="<s:property value='#request.supplyType'/>"/>
          </form>
       </div>
     </div>   
</div>
<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
<!-- footer end -->
</body>
</html>