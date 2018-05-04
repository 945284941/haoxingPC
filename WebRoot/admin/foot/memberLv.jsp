<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<meta http-equiv="keywords" content="会员等级" />
<meta http-equiv="description" content="会员等级" />
<title>会员等级</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<link rel="stylesheet" href="/css/newbanner.css" type="text/css" />
<link href="/css/foot_hyzxgr.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/css/staticlxwm.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/JavaScript">
	function showElement(elementId) {
		document.getElementById(elementId).style.display = "block";
	}
	function hideElement(elementId) {
		document.getElementById(elementId).style.display = "none";
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
	<!-- header begin -->
	<div class="header">
		<jsp:include page="/admin/common/head.jsp"></jsp:include>
	</div>
	<div class="logo">
		<jsp:include page="/admin/common/logo.jsp"></jsp:include>
	</div>
	<!-- 头部开始 -->
	<jsp:include page="/admin/foot/head.jsp" />
	<!-- 页脚开始 -->
	<div class="dht">
		<a href="javascript:void(0)">首页</a> > <a href="javascript:void(0)">会员相关</a> > <a href="javascript:void(0)">会员等级</a>
	</div>
	<div class="gzgz">
		<div class="hyleft">
	<dl class="grhymenu">
		<dt>
			<span class="ddzxqtb"><img src="/images/footerImg/ddzxq.gif" /> </span>关于泉利
		</dt>
		<dd class="add">
			<a href="/admin/foot/company.jsp">公司简介</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/cooperation.jsp">加盟合作</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/contact.jsp">联系我们</a>
		</dd>
		<dd class="add">
					<a href="zp.html">诚聘英才</a>
				</dd>
		<dd class="add">
			<a href="/admin/foot/advertising.jsp">广告资源</a>
		</dd>
	</dl>
	<dl class="grhymenu">
		<dt>
			<span class="ddzxqtb"><img src="/images/footerImg/ddzxq.gif" /> </span>新手指南
		</dt>
		<dd class="add">
			<a href="/admin/foot/login.jsp">用户注册</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/process.jsp">购物流程</a>
		</dd>
		<dd class="add">
			<a href="javascript:void(0)">密码找回</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/disclaimer.jsp">免责声明</a>
		</dd>
	</dl>
	<dl class="grhymenu">
		<dt>
			<span class="ddzxqtb"><img src="/images/footerImg/ddzxq.gif" /> </span>会员相关
		</dt>
		<dd class="add">
			<a class="hover" href="/admin/foot/memberLv.jsp">会员等级</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/memberPoint.jsp">会员经验值</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/dispute.jsp">争议处理</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/deposit.jsp">预存款说明</a>
		</dd>
	</dl>
	<dl class="grhymenu">
		<dt>
			<span class="ddzxqtb"><img src="/images/footerImg/ddzxq.gif" /> </span>售后服务
		</dt>
		<dd class="add">
			<a href="/admin/foot/exchange.jsp">退换货流程</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/retreat.jsp">退款说明</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/complain.jsp">投诉建议</a>
		</dd>
		<dd class="add">
			<a href="/admin/foot/wzmap.jsp">网站地图</a>
		</dd>
	</dl>
</div>
		   <div class="hyright">       
       <p class="hymainbt"><span class="grmenubt">会员等级</span></p>
       
     <div class="grjbxx">
       <p><strong>1</strong><strong>、企业会员级别 </strong><br />
普通会员（终身免费）  等级图标<img width="35" height="35" src="/images/footerImg/pt01.gif" /><img width="35" height="35" src="/images/footerImg/pt02.gif" /> <img width="35" height="35" src="/images/footerImg/pt03.gif" /><img width="35" height="35" src="/images/footerImg/pt04.gif" /><img width="35" height="35" src="/images/footerImg/pt05.gif" /><img width="35" height="35" src="/images/footerImg/pt06.gif" /><img width="35" height="35" src="/images/footerImg/pt07.gif" /><img width="35" height="35" src="/images/footerImg/pt08.gif" /><img width="35" height="35" src="/images/footerImg/pt09.gif" /><br /><br />
VIP会员（1年/收费） 等级图标 <img width="35" height="35" src="/images/footerImg/VIP01.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/VIP02.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/VIP03.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/VIP04.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/VIP05.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/VIP06.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/VIP07.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/VIP08.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/VIP09.gif" /> <br /><br />
黄金会员（1年/收费） 等级图标 <img width="35" height="35" src="/images/footerImg/hj01.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hj02.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hj03.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hj04.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hj05.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hj06.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hj07.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hj08.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hj09.gif" /><br /><br />
白金会员（1年/收费） 等级图标 <img width="35" height="35" src="/images/footerImg/bj01.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/bj02.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/bj03.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/bj04.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/bj05.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/bj06.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/bj07.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/bj08.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/bj09.gif" /> <br /><br />
钻石会员（1年/收费） 等级图标 <img width="35" height="35" src="/images/footerImg/z01.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/z02.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/z03.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/z04.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/z05.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/z06.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/z07.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/z08.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/z09.gif" /> <br /><br />
       </p>
       <p><strong>2</strong><strong>、商家诚信体系 </strong><br />
         质量等级  图标<img width="35" height="35" src="/images/footerImg/hartz01.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartz02.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartz03.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartz04.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartz05.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartz06.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartz07.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartz08.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartz09.gif" /><br /><br />
         信誉等级  图标<img width="35" height="35" src="/images/footerImg/hartc01.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartc02.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartc03.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartc04.gif" /><img width="35" height="35" src="/images/footerImg/hartc05.gif" />&nbsp;&nbsp;<img width="35" height="35" src="/images/footerImg/hartc06.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartc07.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartc08.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartc09.gif" /><br /><br />
         服务等级  图标<img width="35" height="35" src="/images/footerImg/hartf01.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartf02.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartf03.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartf04.gif" /><img width="35" height="35" src="/images/footerImg/hartf05.gif" />&nbsp;&nbsp;<img width="35" height="35" src="/images/footerImg/hartf06.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartf07.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartf08.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartf09.gif" /><br /><br />
         物流等级  图标<img width="35" height="35" src="/images/footerImg/hartw01.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartw02.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartw03.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartw04.gif" /><img width="35" height="35" src="/images/footerImg/hartw05.gif" />&nbsp;&nbsp;<img width="35" height="35" src="/images/footerImg/hartw06.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartw07.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartw08.gif" />&nbsp;<img width="35" height="35" src="/images/footerImg/hartw09.gif" /><br /><br />
       </p>
       <p><strong>3</strong><strong>、评价体系 </strong><br />
         买方交易完成后，对卖方进行的诚信体系进行评价， <br />
         优良  点亮<img width="17" height="17" src="/images/footerImg/pjjxw.gif" />&nbsp;<img width="17" height="17" src="/images/footerImg/pjjxw.gif" />&nbsp;<img width="17" height="17" src="/images/footerImg/pjjxw.gif" />3个吉祥物图标  获得优良 +1分 <br />
         一般  点亮<img width="17" height="17" src="/images/footerImg/pjjxw.gif" />&nbsp;<img width="17" height="17" src="/images/footerImg/pjjxw.gif" />2个吉祥物图标    获得一般 0分 <br />
         较差  点亮<img width="17" height="17" src="/images/footerImg/pjjxw.gif" />1个吉祥物图标      获得较差 -1分 </p>
       <p><strong>4</strong><strong>、诚信体系升级 </strong></p>
       <table border="1" cellspacing="0" cellpadding="0" style="text-align:center;">
         <tr>
           <td width="284" valign="top">
             0级 </td>
           <td width="284" valign="top"><p>小于0</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>1级 </p></td>
           <td width="284" valign="top"><p>0~50</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>2级 </p></td>
           <td width="284" valign="top"><p>51~150</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>3级 </p></td>
           <td width="284" valign="top"><p>151~300</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>4级 </p></td>
           <td width="284" valign="top"><p>301~600</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>5级 </p></td>
           <td width="284" valign="top"><p>601~1200</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>6级 </p></td>
           <td width="284" valign="top"><p>1201~2400</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>7级 </p></td>
           <td width="284" valign="top"><p>2401~4800</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>8级 </p></td>
           <td width="284" valign="top"><p>4801~9600</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>9级 </p></td>
           <td width="284" valign="top"><p>大于9601</p></td>
         </tr>
       </table>
       <p><strong>5</strong><strong>、会员级别升级 </strong></p>
       <table border="1" cellspacing="0" cellpadding="0" style="text-align:center;">
         <tr>
           <td width="284" valign="top">
             1级 </td>
           <td width="284" valign="top"><p>0~400</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>2级 </p></td>
           <td width="284" valign="top"><p>401~800</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>3级 </p></td>
           <td width="284" valign="top"><p>801~1600</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>4级 </p></td>
           <td width="284" valign="top"><p>1601~3200</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>5级 </p></td>
           <td width="284" valign="top"><p>3201~6400</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>6级 </p></td>
           <td width="284" valign="top"><p>6401~12800</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>7级 </p></td>
           <td width="284" valign="top"><p>12801~25600</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>8级 </p></td>
           <td width="284" valign="top"><p>25601~51200</p></td>
         </tr>
         <tr>
           <td width="284" valign="top"><p>9级 </p></td>
           <td width="284" valign="top"><p>大于51200</p></td>
         </tr>
       </table>
       <p><strong>6</strong><strong>、升级规则 </strong><br />
         6.1  企业会员等级、诚信体系（含4类）等级共分9级；其中0级为该项对应的负分等级只出现在诚信体系中； <br />
         6.2  企业会员等级的计算公式 <br />
         等级=（Z+F+W+X）+C+1000xN <br />
         其中当Z、F、W、Z任意得分为负分时企业会员横向等级为1级直至负分为正； <br />
         质量分：Z<br />
         服务分：F<br />
         物流分：W<br />
         信誉分：X<br />
         成交量：C<br />
         企业会员与站方的合作期满的年限：N<br />
         6.3  会员等级分为横向等级与纵向等级，纵向等级不可通过经验值积累获得，而是在有效期内与站方达成协议付费获得；横向等级则可以按照经验值积累来升<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级；<br />  6.4  诚信体系含四个要素，每个要素均为横向升级有0~9级； <br />
         6.5  诚信体系无论何种要素成为0级，其会员等级的横向等级回到初始化1级； </p>
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

