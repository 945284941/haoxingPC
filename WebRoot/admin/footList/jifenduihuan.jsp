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
    <title>颐佳官方商城-经验值兑换</title>
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
<div class="breadThumb">当前位置：首页   &gt; 经验值兑换</div>    
<div class="helpCnt">
	<h1 class="text-center">颐佳官方商城<br>经验值兑换</h1>
	<p>1、经验值获取方式</p>
	<p>1、在颐佳官方商城注册、有效购物都将赠送一定数额或一定比例的经验值。 <br>
   注册所送经验值无时间结点，可以在任何活动中凭经验值换购商城内商品。子商户商品需为参与经验值换购活动的商家才可换购，如若不可进行产品的兑换。
</p>
<p>2、经验值奖励规则</p>
<p>2.1消费送经验值规则 <br>
	 （1）在颐佳官方商城购买商品，消费完成且订单状态关闭后，即可获得消费经验值；<br>
（2）购买指定不赠送经验值的商品（如促销商品等），订单关闭之后不赠送消费经验值，但对其发表的评价赠送相应经验值；
</p>
<p>2.2温馨提示：<br>
（1）打折券、促销券、优惠券支付订单金额的部分，将不计入经验值赠送；<br>
（2）不同账户的经验值不能合并；<br>
（3）若订单出现退货，已赠送的消费经验值将从您的账户中扣除；
</p>
<p>3、经验值的使用<br>	
使用经验值可参加颐佳官方商城定期推出的各种活动。</p>
<p>4、经验值有效期<br>
颐佳官方商城经验值永久有效。
</p>
<p>5、经验值查询<br>
您可登录颐佳官方商城“我的账户”，查询经验值累积明细。</p>
<p>6、经验值常见问题<br>
（1）我何时能使用经验值？<br>
消费经验值，待订单关闭后即可使用；评价经验值，经验值获得之后可立即使用。
（2）经验值如何累计？<br>
经验值累计：<br>
注册经验值+消费经验值（消费使用的现金金额）+其它经验值。<br>
经验值只在同一会员账户内累计，不同账户的经验值不能合并。若发生退货，则从您的账户中扣除相应消费经验值。颐佳官方商城保留调整经验值计算比例的权利。<br>
（3）为什么我买了东西却看不到经验值？<br>
如果您成功购买商品，并签收，您实际支付的金额产生的消费经验值将同时计入您的经验值账户（可从我的账户进入查看），此时经验值状态为冻结状态，过了7天的退换货时间，经验值状态则变为解冻状态，您便可以使用；
经验值累积可能因用户机器设备，地域等情况存在延时，请耐心等候。订单完结后7天还没有获得经验值，请及时与客服联系确认。<br>
（4）经验值可以兑换现金或者兑米吗？<br>
颐佳官方商城经验值不能兑换现金、不能兑米。<br>
（5）经验值兑换商品是否能开具发票？<br>
使用经验值兑换的商品，属于颐佳官方商城对您的回馈行为而非交易，不能提供发票。<br>
（6）经验值兑换的商品运费如何支付？<br>
经验值兑换的商品需要买家承担运费。</p>
<p>7、商城内商品采用经验值（粮票）+优惠券+现金的购买方式，如在活动期限内，三古汇会员持有本次活动的优惠券即可在活动期限内进行抵现消费。如若本次活动仅限某些子商户商家参与或者仅限商城自持商品参与（古粮今典系列），则优惠券+经验值仅在上述合作商家中可以进行抵现购买。</p>
	
</div> 
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
