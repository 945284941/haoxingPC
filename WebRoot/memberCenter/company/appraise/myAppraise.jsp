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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<base href="<%=basePath%>"/>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<link href="css/hyzxdp.css" rel="stylesheet" type="text/css"/>
<link href="css/page.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
$(function(){  
	//右边赋值
	 $.ajax({  
	     type:'post',  
	      url:'appraise!statisticsAppraiseByCompany.action',
	      dataType:'json', 
	     success:function(appraiseStatisticsInfo){
	    	 $("#allCount").empty();
	    	 $("#allCount").append(appraiseStatisticsInfo.sumAllCount);
	    	 $("#bellCount").empty();
	    	 $("#bellCount").append(appraiseStatisticsInfo.bellCount);
	    	 $("#middleCount").empty();
	    	 $("#middleCount").append(appraiseStatisticsInfo.middleCount);
	    	 $("#badCount").empty();
	    	 $("#badCount").append(appraiseStatisticsInfo.badCount);
	     }});
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
<div class="dht">首页 &gt; 会员中心  &gt;我的参与 &gt;我的评论</div>
<div class="gzgz">
     <div class="hyleft">
    	 <jsp:include page="/memberCenter/common/leftNavigate.jsp" />
     </div>
     <div class="hycy">
      <div class="hyrightr">
       <div id="rightjxw">
           <p class="hyd0">评价总数<span id="allCount"></span></p>
           <p class="hyd0">好评总数<span id="bellCount"></span></p>
           <p class="hyd0">中评总数<span id="middleCount"></span></p>
           <p class="hyd0">差评总数<span id="badCount"></span></p>
       </div>
      </div>
       <p class="hymainbt"><span class="grmenubt">我的参与</span></p>
       	<h2 id="grxx">
       		<s:if test="appraiseType=='sell'">
       			<span ><a href="person/appraise/toMyAppraiseList.html">商品评价</a></span>
	       		<span class="tab_pj" ><a href="person/appraise/toMyAppraiseList/sell.html">买家评价</a></span>
       		</s:if>
       		<s:else>
	       		<span class="tab_pj" ><a href="person/appraise/toMyAppraiseList.html">商品评价</a></span>
	       		<span><a href="person/appraise/toMyAppraiseList/sell.html">买家评价</a></span>
       		</s:else>
       		</h2>
       <div id="grxx_1" >
       <div class="grjbxx2" style="padding-top:0;">
         <p class="hysppj"><span style="margin-left:10px; width:130px; text-align:center">商品名称</span><span style="width:280px; margin-right:30px;text-align:center">评价内容</span><span style="width:60px;text-align:center">商品评价</span><span style="width:135px;text-align:center">评论时间</span></p>
          <s:iterator value="appraiseList" status="st">
	           <div class="wdpl">
	           <ul>
	             <li class="grplone"><a href="#">${goodsName }</a></li>
	             <li class="grpltwo">${content} </li>
	             <li class="grplthree">
						<s:if test="quality==0">
							中评
						</s:if>
						<s:elseif test="quality==-1">
							差评
						</s:elseif>
						<s:else>
							好评
						</s:else>
				 </li>
	             <li class="grplfour"><s:date format="yyyy-MM-dd" name="%{createtime}"/></li>
	           </ul>
	           <div style="clear:both"></div>
	           </div>
	           <s:if test="#st.index==9||#st.index==19">
         	<div class="zpxygg"><a href="#"><img src="/images/memberimg/zpxygg.gif"  /></a></div>
          </s:if>
           </s:iterator>
        <div id="showpages">
			<page:pagination path="person/appraise/toMyAppraiseList.html" formName="pagerForm"/>
		 </div>
		 <form id="pagerForm" name="pagerForm"method="post" style="display: none">
			 <input name="appraiseType"  type="hidden"  value="<s:property value='#request.appraiseType'/>"/>
          </form>
       </div>
     </div>  
     <div style="clear:both"></div>
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