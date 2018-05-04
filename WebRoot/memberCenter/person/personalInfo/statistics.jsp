<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/perinfo.js"></script>
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
	<!-- head start -->
	<div class="header">
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	</div>
	<div class="logo">
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	</div>
	<!-- head end -->

	<!-- 导航 -->
	<jsp:include page="/memberCenter/common/navigation.jsp"/>
	<!-- 导航结束 -->
<div class="dht">首页 &gt; 个人会员中心 &gt; 个人信息 &gt; 统计信息</div>
<div class="gzgz">
	 <div class="hyleft">
	 	<jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" />
	 </div>
     <div class="hyright">
      <div class="hyrightr">
       <div id="rightjxw">
           <p class="hyd0">预存款充值总额<span>${fundStatisticsInfo.depositTotal}</span></p>
           <p class="hyd0">预存款支付总额<span>${fundStatisticsInfo.expendTotal}</span></p>
           <p class="hyd0">预存款兑米总额<span>${fundStatisticsInfo.withdrawTotal}</span></p>
           <p class="hyd0">预存款金额<span>${fundStatisticsInfo.moneyBalance}</span></p>
       </div>
       <div class="hygg"><a><img style="width:300px;" src="/images/memberimg/gg04.gif" /></a></div>
       <div class="hygg"><a><img style="width:300px;" src="/images/memberimg/gg05.gif" /></a></div>
      </div>
       <p class="hymainbt"><span class="grmenubt">统计信息</span></p>
      <div class="tjxxz">
       <div class="tjxx">
          <h2>订单统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'ddtj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">未付款未发货订单数</span><span class="pstjsz" id="per_ddtj_0">${orderStatisticsInfo.noPayAndShipOrderCount}</span></li>
            <li><span class="pstj">已付款未发货订单数</span><span class="pstjsz" id="per_ddtj_1">${orderStatisticsInfo.alreadyPayAndNoShipOrderCount}</span></li>
            <li><span class="pstj">已付款已发货订单数</span><span class="pstjsz" id="per_ddtj_2">${orderStatisticsInfo.alreadyPayAndShipOrderCount}</span></li>
            <li><span class="pstj">历史交易完成订单数</span><span class="pstjsz" id="per_ddtj_3">${orderStatisticsInfo.completeOfTheTransactionHistoryOrderCount}</span></li>
            <li><span class="pstj">历史交易关闭订单数</span><span class="pstjsz" id="per_ddtj_4">${orderStatisticsInfo.closeOfTheTransactionHistoryOrderCount}</span></li>
            <li><span class="pstj">已退货待退款订单数</span><span class="pstjsz" id="per_ddtj_5">${orderStatisticsInfo.alreadyReturnAndNoFullrefundOrderCount}</span></li>
            <li><span class="pstj">已退货已退款订单数</span><span class="pstjsz" id="per_ddtj_6">${orderStatisticsInfo.alreadyReturnAndFullrefundOrderCount}</span></li>
          </ul>
       </div>
      </div>
      <div class="tjxxz">
       <div class="tjxxgw">
          <h2>购物车统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'gwctj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">购物车商品数量</span><span class="pstjsz" id="per_gwctj_0">${shoppingCartStatisticsInfo.shoppingCartQuantity}</span></li>
            <li><span class="pstj">购物车商品总价</span><span class="pstjsz" id="per_gwctj_1">${shoppingCartStatisticsInfo.shoppingCartTotal}</span></li>
          </ul>
       </div>
       <div class="tjxxzj">
          <h2>资金统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'zjtj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">存入总额</span><span class="pstjsz" id="per_zjtj_0">${fundStatisticsInfo.depositTotal}</span></li>
            <li><span class="pstj">支出总额</span><span class="pstjsz" id="per_zjtj_1">${fundStatisticsInfo.expendTotal}</span></li>
            <li><span class="pstj">兑米总额</span><span class="pstjsz" id="per_zjtj_2">${fundStatisticsInfo.withdrawTotal}</span></li>
            <li><span class="pstj">预存款余额</span><span class="pstjsz" id="per_zjtj_3">${fundStatisticsInfo.moneyBalance}</span></li>
          </ul>
       </div>
      </div>
      <div class="tjgg"><img src="/images/memberimg/xxtjgg.gif" /></div>
      
      <div class="tjxxz">
       <div class="tjxxgw jflj">
          <h2>经验值统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'jftj');"></s:select>
          </div>
          <ul>
			<li><span class="pstj">经验值累计</span><span class="pstjsz" id="per_jftj_0">${pointStatisticsInfo.pointAddUp}</span></li>
            <li><span class="pstj">经验值消费</span><span class="pstjsz" id="per_jftj_1">${pointStatisticsInfo.pointExpend}</span></li>
            <li><span class="pstj">经验值余额</span><span class="pstjsz" id="per_jftj_2">${pointStatisticsInfo.pointBalance}</span></li>
          </ul>
       </div>
       <div class="tjxxzj sctjxx">
          <h2>收藏统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'sctj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">收藏商品总数</span><span class="pstjsz" id="per_sctj_0">${collectStatisticsInfo.collectGoodsCount}</span></li>
            <li><span class="pstj">收藏商铺总数</span><span class="pstjsz" id="per_sctj_1">${collectStatisticsInfo.collectShopCount}</span></li>
            <li><span class="pstj">收藏资讯总数</span><span class="pstjsz" id="per_sctj_2">${collectStatisticsInfo.collectNewsCount}</span></li>
          </ul>
       </div>
       <div class="tjxxzj lltj">
          <h2>浏览统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'lltj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">浏览商品总数</span><span class="pstjsz" id="per_lltj_0">${browseStatisticsInfo.browseGoodsCount}</span></li>
            <li><span class="pstj">浏览商铺总数</span><span class="pstjsz" id="per_lltj_1">${browseStatisticsInfo.browseShopCount}</span></li>
            <li><span class="pstj">浏览资讯总数</span><span class="pstjsz" id="per_lltj_2">${browseStatisticsInfo.browseNewsCount}</span></li>
          </ul>
       </div>
      </div>
      <div class="tjxxz">
       <div class="tjxx tjhdxx">
          <h2>活动统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'hdtj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">我参与的活动</span><span class="pstjsz" id="per_hdtj_0">0</span></li>
            <li><span class="pstj">下载资料</span><span class="pstjsz" id="per_hdtj_1">${activeStatisticsInfo.downloadData}</span></li>
            <li><span class="pstj">提问/回答</span><span class="pstjsz" id="per_hdtj_2">${activeStatisticsInfo.askQuestions}/${activeStatisticsInfo.replyQuestions}</span></li>
            <li><span class="pstj">上传数据</span><span class="pstjsz" id="per_hdtj_3">${activeStatisticsInfo.uploadCount}</span></li>
            <li><span class="pstj">上传采用</span><span class="pstjsz" id="per_hdtj_4">${activeStatisticsInfo.uploadPassCount}</span></li>
            <li><span class="pstj">校对数据</span><span class="pstjsz" id="per_hdtj_5">${activeStatisticsInfo.checkCount}</span></li>
            <li><span class="pstj">校对采用</span><span class="pstjsz" id="per_hdtj_6">${activeStatisticsInfo.checkPassCount}</span></li>
            <li><span class="pstj">累计奖金</span><span class="pstjsz" id="per_hdtj_7">${activeStatisticsInfo.addUpReward}</span></li>
          </ul>
       </div>
       <div class="tjxxzj lltj">
          <h2>信息统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'xxtj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">我的评论总数</span><span class="pstjsz" id="per_xxtj_0">${msgStatisticsInfo.commentCount}</span></li>
            <li><span class="pstj">参与活动总数</span><span class="pstjsz" id="per_xxtj_1">0</span></li>
          </ul>
       </div>
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