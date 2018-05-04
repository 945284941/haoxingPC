<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="/admin/common/keyWords.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>颐佳官方商城</title>
<link rel="stylesheet" href="css/staticlxwm.css" type="text/css">
<link href="css/master.css" rel="stylesheet" type="text/css">


<link href="css/common.css" rel="stylesheet" type="text/css" />
<SCRIPT src="js/jquery-1.8.0.min.js" type=text/javascript></SCRIPT>
<script type="text/javascript" src="js/qlzy.js"></script>
</head>
<body>
<!-- header begin -->
  <div class="header">
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
  </div>
  <div class="logo">
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
  </div>  
  <!-- header end -->
  <!-- 导航 -->
  <jsp:include page="../../common/navigation.jsp"></jsp:include>
  <!-- 导航结束 -->


 

<!-- 页脚开始 -->
<div class="dht"><a href="#">首页</a> > <a href="#">关于古道金典</a> > <a href="#">公司简介</a></div>
<div class="gzgz">
     <div class="hyleft">      
       <dl class="grhymenu">
        <dt><span class="ddzxqtb"><img src="/images/ddzxq.gif"/></span>关于古道金典</dt>
        <dd class="add"><a href="#">公司简介</a></dd>
        <dd class="add"><a href="#">加盟合作</a></dd>        
        <dd class="add"><a class="hover" href="admin/floor/guide/contact.jsp">联系我们</a></dd>
        <dd class="add"><a href="zp.html">诚聘英才</a></dd>
        <dd class="add"><a href="#">广告资源</a></dd>               
       </dl>
       <dl class="grhymenu">
        <dt><span class="ddzxqtb"><img src="/images/ddzxq.gif"/></span>新手指南</dt>
        <dd class="add"><a href="#">用户注册</a></dd>        
        <dd class="add"><a href="#">购物流程</a></dd>        
        <dd class="add"><a href="#">密码找回</a></dd>
        <dd class="add"><a href="#">免责声明</a></dd>
       </dl>
       <dl class="grhymenu">
        <dt><span class="ddzxqtb"><img src="/images/ddzxq.gif"/></span>会员相关</dt>
        <dd class="add"><a href="#">会员等级</a></dd>
        <dd class="add"><a href="#">会员经验值</a></dd>
        <dd class="add"><a href="#">争议处理</a></dd>
        <dd class="add"><a href="#">预存款说明</a></dd>        
       </dl>
       <dl class="grhymenu">
        <dt><span class="ddzxqtb"><img src="/images/ddzxq.gif"/></span>售后服务</dt>
        <dd class="add"><a href="#">退换货流程</a></dd>
        <dd class="add"><a href="#">退款说明</a></dd>   
        <dd class="add"><a href="#">投诉建议</a></dd>
       <dd class="add"><a href="#">网站地图</a></dd>            
       </dl>
       
  </div>
     <div class="hyright">       
       <p class="hymainbt"><span class="grmenubt">联系我们</span></p>
       
     <div class="grjbxx">
       <div style=" width:300px; float:left; padding-left:600px; padding-top:100px; height:446px;font-size:16px; background:url(images/lxwmbj.gif) no-repeat;">
       <p style="padding-bottom:15px; "><strong>网站运营部</strong><br />
         加盟电话：0531-66670628<br />
     <!--   传真：0531-55702586--></p> 
       <p style="padding-bottom:15px;"><strong>杂志编辑部</strong><br />
         加盟电话：0531-66670629<br />
       <!-- 传真：0531-55702586--></p>
       <p><strong>会展招商部</strong><br />
         加盟电话：0531-55702555<br />
       <!-- 传真：0531-55702586--></p>
       <p>Email：server@qlqpw.com<br />
         地址：济南市天桥区二环北路8号<br />
         邮编：250032</p>
       </div>
       
     </div>
     </div>  
    
</div>
<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
<!-- footer end -->
<!-- 页脚结束 -->
</body>
</html>