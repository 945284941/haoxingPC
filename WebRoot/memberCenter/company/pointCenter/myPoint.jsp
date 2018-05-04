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
<link rel="stylesheet" href="css/newbanner.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<link href="css/page.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script language="JavaScript" type="text/JavaScript">
function showElement(elementId)
{
  document.getElementById(elementId).style.display="block";
}
function hideElement(elementId)
{
  document.getElementById(elementId).style.display="none";
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
<div class="dht">首页&gt; 会员中心 &gt; 电子商城 &gt; 经验值管理 &gt; 我的经验值 &gt; 获取记录</div>
<div class="gzgz">
      <div class="hyleft">
     	<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
     </div>
     <div class="hyright">
      <div class="hyrightr">
      	<jsp:include page="/memberCenter/common/rightPointCenter.jsp" />
      </div>
       <p class="integralbt_hymainbt"><span class="grmenubt">经验值管理</span>
       <span class="integralbt">
       		<s:if test="pointType==0">
				<a class="hover" href="person/pointDetail/myPointList/0.html">获取记录</a>
		    </s:if>
		    <s:else>
		    	<a  href="person/pointDetail/myPointList/0.html">获取记录</a>
		    </s:else>
       	</span>
       <span class="integralbt">
	      	 	<s:if test="pointType==1">
	       			<a class="hover" href="person/pointDetail/myPointList/1.html">兑换记录</a>
			    </s:if>
			    <s:else>
			    	<a href="person/pointDetail/myPointList/1.html">兑换记录</a>
			    </s:else>
	       	
       	</span>
       <span class="integralbt"><a href="person/pointDetail/myPointList/10.html">余额记录</a></span>
       <span class="integralbt_jfsc"><a href="#">经验值商城</a></span>
       </p>
       <div class="integralbt_listbt">
          <dl>
            <dt>
            <span class="integralbt_time">时间</span><span class="integralbt_jflx">经验值类型</span><span class="integralbt_jfsz">经验值数值</span><span class="integralbt_bz">获取来源</span></dt>
             <s:iterator value="pointDetailList" >
            		<dd>
	            		<span class="integralbt_time"><s:date format="yyyy-MM-dd" name="%{createtime}"/></span>
	            		<span class="integralbt_jflx">
							<s:if test="type==1">
								兑换
							</s:if>
							<s:else>
								获取
							</s:else>
						</span>
	            		<span class="integralbt_jfsz">${point}</span>
	            		<span class="integralbt_bz">${remark}</span>
            		</dd>
           	</s:iterator>
          </dl>
           <div id="showpages">
			<page:pagination path="person/pointDetail/myPointList.html" formName="pagerForm"/>
		 </div>
		 <form id="pagerForm" name="pagerForm"method="post" style="display: none">
		         <input name="pointType"  type="hidden"  value="<s:property value='#request.pointType'/>"/>
         </form>
       </div> 
     </div>  
    
</div>
<div class="gzgz">
  <p class="foottopgg"><img src="/images/memberimg/tlgg1.gif"/></p>
</div>
<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
<!-- footer end -->
</body>
</html>