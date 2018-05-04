<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>三古汇官方商城-会员等级</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv=”X-UA-Compatible” content=”IE=edge,chrome=1″ />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="web/css/base.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="web/bootstrap/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
  </head>
  <body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="/admin/common/navigation.jsp" />
<div class="breadThumb">当前位置：首页   &gt; 会员等级</div>    
<div class="helpCnt">
	<h1 class="text-center">三古汇官方商城<br>会员等级</h1>
	<p>为了规范【古粮今典】市场秩序，保障各级【古粮今典】会员切身利益，现将各级会员等级识别以及权利和义务公布如下：</p>
	<p>1、【古粮今典】会员等级分为：普通会员、VIP会员、银V会员、金V会员、钻V会员、超V会员，共六级； </p>
	<p>2、普通会员免费注册，注册即送三古汇商城998经验值；享受商城购物9.5折优惠；每日签到，再送经验值；</p>
	<p>3、升级各级VIP开启免费吃有机模式，获得12个月的免费有机粮食后，转换成粮票。同时隔月起享受每月返惠米，40个月返完为止；	</p>
	<p>4、普通会员分享各级VIP均可享受5+5的两级分享佣金；</p>
	<p>5、VIP分享VIP享受10+10的两级分享佣金；</p>
	<p>6、VIP会员分享银V以上级别的VIP可享受5+10两级分享佣金；</p>
	<p>7、银V以上级别会员分享银V以上任意级别VIP均可享受5+5+10三级分享佣金；</p>
	<p>8、金V以上级别会员分享银V以上任意级别VIP均可享受5+10+10三级分享佣金；</p>
	<p>9、任意级别VIP可用十月尚品的经验值在三古汇商城消费（仅限【古粮今典】五谷杂粮礼盒装，消费时须要支付零售价10%的现金，余款以100%的经验值进行冲抵；</p>
	<p>10、十月尚品的经验值不可购买VIP会员资格或家庭装，但可以认购银V以上级别VIP，认购时须支付该级别认购额50%的现金，余款以100%的经验值进行冲抵，经验值部分不享受返惠米。</p>
	<p>以上规则中“以上”含本级；银V会员是指社区代理、金V会员是指县级代理、钻V会员是指市级代理、超V会员是指省级代理；具体分享制度以公司正式行文制度为准。</p>
	<p>本规则不得转发、复制到非VIP群。最终解释权归公司所有！</p>
	
</div> 
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
