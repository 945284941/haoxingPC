<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	SessionInfo sessionInfo = (SessionInfo)session.getAttribute(ResourceUtil.getSessionInfoName());
	String memberId = sessionInfo==null?"":sessionInfo.getUserId();
%>
<script type="text/javascript" src="js/qlzy.js"></script>
<script type=text/javascript src="js/memberCenterLogin.js"></script>
<script type=text/javascript src="js/jdsjpop.js"></script>
 <script type="text/javascript">
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

       <dl class="grhymenu">
        <dt style="border-top: 1px solid #D0D0D0;"><span class="ddzxqtb"><i class="iconfont">&#xf012d;</i></span>个人信息</dt>
        <dd class="add"><a class="hover" href="javascript:void(0);" onclick="openOrderPage('person/showBasicInfo.html');">个人账户</a></dd>        
        <dd class="add"><a href="javascript:void(0);" onclick="openOrderPage('person/accountSecurity.html');">账号安全</a></dd>        
       </dl>
       <dl class="grhymenu">
        <dt><span class="ddzxqtb"><i class="iconfont">&#xf0148;</i></span>电子商城</dt>
        <dd class="add">订单管理</dd>
        <dd class=" threecd"><a onclick="openOrderPage('person/order/myOrders.html');" >我的订单</a><a target="_Blank" href="call/goToCart.html">我的购物车</a><a onclick="openOrderPage('person/order/memberCollects.html');">我的收藏</a><a onclick="openOrderPage('person/order/memberViews.html');">我的浏览</a><a onclick="openOrderPage('person/order/shippingAddr.html');">收货地址</a></dd>
        <dd class="add">财富管理</dd>
        <dd class=" threecd"><a onclick="openOrderPage('person/pointDetail/xianjinbi.html');" >我的金米</a></dd>
        <dd class=" threecd"><a onclick="openOrderPage('person/pointDetail/liucunbi.html');" >我的惠米</a></dd>
        <dd class=" threecd"><a onclick="openOrderPage('person/moneyManage/myMoneyList.html');" >我的粮票</a></dd> 
        <dd class=" threecd"><a onclick="openOrderPage('person/pointDetail/myPointList.html');" >我的经验值</a></dd>   
         <dd class="add">兑米记录</dd>
        <dd class=" threecd"><a onclick="openOrderPage('person/pointDetail/xianjinbiCash.html');" >记录列表</a></dd>
       </dl>
    <%--    <dl class="grhymenu">
        <dt><span class="ddzxqtb"><i class="iconfont">&#xf00ca;</i></span>新闻资讯</dt>
        <dd class="add"><a href="javascript:login_or_not('xxzx/toWzsc.html')">文章收藏</a></dd>
        <dd class="add"><a href="javascript:login_or_not('xxzx/toLljl.html')">浏览记录</a></dd>        
       </dl> --%>
       <dl class="grhymenu">
        <dt><span class="ddzxqtb"><i class="iconfont">&#xf00d3;</i></span>我的参与</dt>
       <!--  <dd class="add"><a href="javascript:void(0);" onclick="openOrderPage('forum/MyForum.html');">我的帖子</a></dd>
        <dd class="add"><a href="memberCenter/person/forum/forumSend.jsp" >我要发帖</a></dd>
        <dd class="add"><a href="javascript:void(0);" onclick="openOrderPage('huitie/myHuiTieText.html');">我的回帖</a></dd> 
        -->
        <dd class="add"><a onclick="openOrderPage('person/appraise/toMyAppraiseList.html');">我的评论</a></dd>
       </dl>
       <dl class="grhymenu">
        <dt><span class="ddzxqtb"><i class="iconfont">&#xf00d3;</i></span>我的代言</dt>
        <dd class="add"><a href="javascript:void(0);" onclick="openOrderPage('person/myYiji.html');">一级代言</a></dd>
        <dd class="add"><a href="javascript:void(0);" onclick="openOrderPage('person/myErji.html');">二级代言</a></dd>
        <dd class="add"><a href="javascript:void(0);" onclick="openOrderPage('person/mySanji.html');">三级代言</a></dd>
       </dl>