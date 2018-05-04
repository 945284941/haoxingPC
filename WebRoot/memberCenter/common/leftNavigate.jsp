<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	SessionInfo sessionInfo = (SessionInfo)session.getAttribute(ResourceUtil.getSessionInfoName());
	String memberId = sessionInfo==null?"":sessionInfo.getUserId();
%>
<script type=text/javascript src="js/qlzy.js"></script>
<script type=text/javascript src="js/memberCenterLogin.js"></script>
<script>
	function login_or_not(url){
		$.ajax({
				url : 'memberCenter/goods!checkSession.action',
				type : 'POST',
				dataType : 'JSON',
				success : function(json) {
					if (!json) {
						showLogin('mask', 'pop_500', url, '0', '');
					} else {
						window.location.href=url;
					}
				}
		});
	}
</script>
      <p class="grhybt">企业会员中心</p>
       <dl class="grhymenu">
        <dt><span class="ddzxqtb"><i class="iconfont">&#xf00d5;</i></span>企业信息</dt>
        <dd class="add"><a onclick="maskMember('company/companyMember/gainCompanyMessageById.html','<%= memberId%>')">企业资料</a></dd>        
        <dd class="add"><a href="javascript:void(0);" onclick="openOrderPage('company/accountSecurity.html');">账号安全</a></dd>        
       </dl>
       <dl class="grhymenu">
        <dt><span class="ddzxqtb"><i class="iconfont">&#xf0148;</i></span>电子商城</dt>
        <dd class="sub">订单管理</dd>
        <dd class=" threecd"><a onclick="openOrderPage('person/order/sellOrders.html');">出售订单</a></dd>
        <dd class="sub">商品管理</dd> 
        <dd class=" threecd"><a href="javascript:login_or_not('memberCenterGL.html')">商品列表</a><a href="javascript:login_or_not('memberCenterGA.html')">添加商品</a><!-- <a onclick="login_or_not('/memberCenter/company/goods/hyzxdpgl_scfk.jsp')" href="javascript:void(0)">市场反馈</a> --><a href="javascript:login_or_not('memberCenterGRE.html')">回收站</a></dd>
        <dd class="sub">店铺管理</dd> 
        <dd class=" threecd"><a onclick="openOrderPage('memberManageHeadImg.html')" >轮播图设置</a><a onclick="openOrderPage('toCompanySys.html')" >首页设置</a></dd>  
       </dl>
