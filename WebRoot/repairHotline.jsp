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
<title>古道金典-抢修热线</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link rel="stylesheet" href="css/page.css" type="text/css" />
<link rel="stylesheet" href="css/qxcx.css" type="text/css" />
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type=text/javascript src="js/regions.js"></script>
<script type="text/javascript" src="js/smap.js"></script>
<script>

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
	<!-- 头部结束 -->
	<!-- 导航 -->
	<jsp:include page="/admin/common/navigation.jsp"/>
	<!-- 导航结束 -->
<div class="qxcx">
  <div class="qxcx_2">
  <p class="cx">抢修查询</p>
  <div class="qxsearch">
    <span class="label">地区搜索：</span>
    <form id="qxrxSearchForm" name="qxrxSearchForm" action="repairHotline.html" method="post">
    <div class="fb_f2">
    <div>
		<s:select cssClass="text" id="qxrx_province"
			name="qixiuchang.proId" headerKey="0" headerValue="-选择省-"
			list="provinceList" listKey="id" listValue="name"
			value="%{qixiuchang.proId}" theme="simple"
			onchange="_getCitys(this.value,'qxrx_city','qxrx_area')"></s:select>
    </div> 
    </div>
    <div class="fb_f2">
    <div>
		<s:select cssClass="text" id="qxrx_city"
			name="qixiuchang.cityId" headerKey="0" headerValue="-选择市-"
			list="cityList" listKey="id" listValue="name"
			value="%{qixiuchang.cityId}" theme="simple"
			onchange="_getAreas(this.value,'qxrx_area')"></s:select>
    </div> 
    </div>
    <div class="fb_f2">
    <div>
		<s:select cssClass="text" id="qxrx_area"
			name="qixiuchang.areaId" headerKey="0" headerValue="-选择区-"
			list="areaList" listKey="id" listValue="name"
			value="%{qixiuchang.areaId}" theme="simple"></s:select>    
    </div> 
    </div>
    <div class="fb_f1"><div>
      <input type="text" class="text2" id="qxrx_address" name="qixiuchang.address" value="${qixiuchang.address}"/>
        </div> 
    </div>
    <div class="fb_f3"><div>
      <input type="submit" class="butt" value="搜索"/>
     </div> 
    </div>
    </form>
  <div class="clr"></div>
  </div>
  <s:if test="%{qixiuchangList.size()>0}">
	  <s:iterator value="qixiuchangList" var="li" status="st">
		  <div class="qxnr">
		    <div class="qxnr_left">
		      <p style=" font-weight:bold; color:#333333; font-size:14px;">
		      <s:if test='null!=#li.name&&""!=#li.name'><s:property value="#li.name"/></s:if><s:else>---</s:else>
		      </p>
		      <p style=" color:#333333;"><span style="margin-right:30px;">联系人：
		      <s:if test='null!=#li.linkman&&""!=#li.linkman'><s:property value="#li.linkman"/></s:if><s:else>---</s:else>
		      </span>
		      <span>联系电话：
		      <s:if test='(null!=#li.telephone&&""!=#li.telephone)&&(null!=#li.mobilephone&&""!=#li.mobilephone)'>
		      	<s:property value="#li.telephone"/>/<s:property value="#li.mobilephone"/>
		      </s:if>
		      <s:elseif test='(null!=#li.telephone&&""!=#li.telephone)&&(null==#li.mobilephone||""==#li.mobilephone)'>
		      	<s:property value="#li.telephone"/>
		      </s:elseif>
		      <s:elseif test='(null==#li.telephone||""==#li.telephone)&&(null!=#li.mobilephone&&""!=#li.mobilephone)'>
		      	<s:property value="#li.mobilephone"/>
		      </s:elseif>
			  <s:else>---</s:else>	      	      	      
		      </span></p>
		      <p style=" color:#333333;">地址：
		      	<s:property value="#li.province"/><s:property value="#li.city"/><s:property value="#li.area"/><s:property value="#li.address"/>
		      </p>
		    <input type="hidden" id="pcaa_<s:property value='#li.id' />" value="${li.province}${li.city}${area}${address}"/>
		    <input type="hidden" id="comname_<s:property value='#li.id' />" value="${li.name}"/>
		    </div>
		    <div class="qxnr_right">
		      <div><a href="javascript:void(0);" onclick="_ShowMapDIV('map-dialogDiv','map-coverDiv','pcaa_<s:property value='#li.id' />','comname_<s:property value='#li.id' />','1','1','1','container')">查看地图</a></div>
		    </div>
		    <div class="clr"></div>
		  </div>  
	  </s:iterator>
			<!-- smap begin -->
			<jsp:include page="/admin/floor/map.jsp" />
			<!-- smap end -->	   
  </s:if>
  <s:else>
  	<span style="color:red;">暂时没有符合条件的数据！</span>
  </s:else>
	<!-- 分页开始 -->
	<div id="showpages">
		<page:pagination path="repairHotline.html"/>
	</div>
	<!-- 分页结束 -->
  </div>
</div>
<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
<!-- footer end -->
</body>
</html>
