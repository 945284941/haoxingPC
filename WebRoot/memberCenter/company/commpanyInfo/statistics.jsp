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
<link href="css/hyzxdp.css" rel="stylesheet" type="text/css"/>
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/perinfo.js"></script>
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
<div class="dht">首页 &gt; 企业会员中心 &gt; 企业信息 &gt; 统计信息</div>
<div class="gzgz">
	 <div class="hyleft">
	 	<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
	 </div>
     <div class="hyright">
      <div class="hyrightr hyflgl">
         <div id="rightjxw" style="margin-left:30px;">
		 	<s:action name="statisticsAction!showRightStatistics" namespace="/statisticsManage" executeResult="true"/>
		 </div>
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
       <div class="tjxxgw jflj">
          <h2>结算统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'jstj');"></s:select>
          </div>          
          <ul>
            <li><span class="pstj">总交易额</span><span class="pstjsz" id="com_jstj_0">${settleStatisticsInfo.totalTradeAmount}</span></li>
            <li><span class="pstj">退款额</span><span class="pstjsz" id="com_jstj_1">0</span></li>
            <li><span class="pstj">保证金金额</span><span class="pstjsz" id="com_jstj_2">0</span></li>
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
       <div class="tjxxgw jflj">
          <h2>发布统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'fbtj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">发布供求信息</span><span class="pstjsz" id="com_fbtj_0">${publishStatisticsInfo.totalSupplyInfo}</span></li>
            <li><span class="pstj">发布广告总数</span><span class="pstjsz" id="com_fbtj_1">0</span></li>
            <li><span class="pstj">发布新闻资讯</span><span class="pstjsz" id="com_fbtj_2">${publishStatisticsInfo.totalNews}</span></li>
          </ul>
       </div>
       <div class="tjxxzj wltj">
          <h2>物流统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'wltj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">客户自提数</span><span class="pstjsz" id="com_wltj_0">${logisticsStatisticsInfo.totalSinceTheMention}</span></li>
            <li><span class="pstj">物流配送数</span><span class="pstjsz" id="com_wltj_1">${logisticsStatisticsInfo.totalDelivery}</span></li>
            <li><span class="pstj">退货数</span><span class="pstjsz" id="com_wltj_2">${logisticsStatisticsInfo.totalReturns}</span></li>
          </ul>
       </div>
       <div class="tjxxzj xydj">
          <h2>信誉等级统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'xydjtj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">信誉好评数</span><span class="pstjsz" id="com_xydjtj_0">${creditLevelStatisticsInfo.credit_greatReviews}</span></li>
            <li><span class="pstj">信誉中评数</span><span class="pstjsz" id="com_xydjtj_1">${creditLevelStatisticsInfo.credit_greatReviews}</span></li>
            <li><span class="pstj">信誉差评数</span><span class="pstjsz" id="com_xydjtj_2">${creditLevelStatisticsInfo.credit_greatReviews}</span></li>
            <li><span class="pstj">信誉经验值</span><span class="pstjsz" id="com_xydjtj_3">${creditLevelStatisticsInfo.credit_greatReviews}</span></li>
          </ul>
       </div>
       <div class="tjxxgw fwdj">
         <h2>服务等级统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'fwdjtj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">服务好评数</span><span class="pstjsz" id="com_fwdjtj_0">${serveLevelStatisticsInfo.serve_greatReviews}</span></li>
            <li><span class="pstj">服务中评数</span><span class="pstjsz" id="com_fwdjtj_1">${serveLevelStatisticsInfo.serve_inReviews}</span></li>
            <li><span class="pstj">服务差评数</span><span class="pstjsz" id="com_fwdjtj_2">${serveLevelStatisticsInfo.serve_badReviews}</span></li>
            <li><span class="pstj">服务经验值</span><span class="pstjsz" id="com_fwdjtj_3">${serveLevelStatisticsInfo.serve_totalPoint}</span></li>
          </ul>
       </div>
      </div>
      <div class="tjxxz">
        <div class="tjxx sptj">
          <h2>商品统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'sptj');"></s:select>
          </div>
          <ul>
            <%-- <li><span class="pstj">拥有商品品牌数</span><span class="pstjsz" id="com_sptj_0">0</span></li> --%>
            <li><span class="pstj">拥有商品分类数</span><span class="pstjsz" id="com_sptj_1">${goodsStatisticsInfo.goodsCats}</span></li>
            <li><span class="pstj">拥有商品总数</span><span class="pstjsz" id="com_sptj_2">${goodsStatisticsInfo.goodsCount}</span></li>
            <li><span class="pstj">商品上架总数</span><span class="pstjsz" id="com_sptj_3">${goodsStatisticsInfo.goodsAddedCount}</span></li>
            <li><span class="pstj">商品下架总数</span><span class="pstjsz" id="com_sptj_4">${goodsStatisticsInfo.goodsOffTheShelfCount}</span></li>
          </ul>
       </div>
       <div class="tjxxgw gwtj">
          <h2>经验值统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'jftj');"></s:select>
          </div>
          <ul>
			<li><span class="pstj">经验值累计</span><span class="pstjsz" id="per_jftj_0">${pointStatisticsInfo.pointAddUp}</span></li>
            <li><span class="pstj">经验值消费</span><span class="pstjsz" id="per_jftj_1">${pointStatisticsInfo.pointExpend}</span></li>
          </ul>
       </div>
       <div class="tjxxgw gwtj">
          <h2>购物车统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'gwctj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">购物车商品数量</span><span class="pstjsz" id="per_gwctj_0">${shoppingCartStatisticsInfo.shoppingCartQuantity}</span></li>
            <li><span class="pstj">购物车商品总价</span><span class="pstjsz" id="per_gwctj_1">${shoppingCartStatisticsInfo.shoppingCartTotal}</span></li>
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
       <div class="tjxxgw jflj">
          <h2>活动统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'hdtj');"></s:select>
          </div>
          <ul>
            <%-- <li><span class="pstj">我参与的活动</span><span class="pstjsz" id="per_hdtj_0">0</span></li> --%>
            <li><span class="pstj">下载资料</span><span class="pstjsz" id="per_hdtj_1">${activeStatisticsInfo.downloadData}</span></li>
            <li><span class="pstj">提问/回答</span><span class="pstjsz" id="per_hdtj_2">${activeStatisticsInfo.askQuestions}/${activeStatisticsInfo.replyQuestions}</span></li>
          </ul>
       </div>
       <div class="tjxxzj wltj">
          <h2>访问统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'fwtj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">客户浏览商品数</span><span class="pstjsz" id="com_fwtj_0">${visitStatisticsInfo.customerViews}</span></li>
            <li><span class="pstj">客户收藏商品数</span><span class="pstjsz" id="com_fwtj_1">${visitStatisticsInfo.customerCollects}</span></li>
            <li><span class="pstj">客户评论商品数</span><span class="pstjsz" id="com_fwtj_2">${visitStatisticsInfo.customerComments}</span></li>
          </ul>
       </div>
       <div class="tjxxzj xydj">
          <h2>质量等级统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'zldjtj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">质量好评数</span><span class="pstjsz" id="com_zldjtj_0">${qualityLevelStatisticsInfo.quality_greatReviews}</span></li>
            <li><span class="pstj">质量中评数</span><span class="pstjsz" id="com_zldjtj_1">${qualityLevelStatisticsInfo.quality_inReviews}</span></li>
            <li><span class="pstj">质量差评数</span><span class="pstjsz" id="com_zldjtj_2">${qualityLevelStatisticsInfo.quality_badReviews}</span></li>
            <li><span class="pstj">质量经验值</span><span class="pstjsz" id="com_zldjtj_3">${qualityLevelStatisticsInfo.quality_totalPoint}</span></li>
          </ul>
       </div>
       <div class="tjxxgw fwdj">
         <h2>物流等级统计</h2>
          <div class="xzsdtj">
          	<s:select cssClass="text2" list="#{1:'今日',2:'昨日',3:'近三天',4:'近一周',5:'本月',6:'本年 '}" headerKey="0" headerValue="请选择时段" theme="simple" id="u42" onchange="per_statisticsInfo(this.value,'wldjtj');"></s:select>
          </div>
          <ul>
            <li><span class="pstj">物流好评数</span><span class="pstjsz" id="com_wldjtj_0">${logisticsLevelStatisticsInfo.logistics_greatReviews}</span></li>
            <li><span class="pstj">物流中评数</span><span class="pstjsz" id="com_wldjtj_1">${logisticsLevelStatisticsInfo.logistics_inReviews}</span></li>
            <li><span class="pstj">物流差评数</span><span class="pstjsz" id="com_wldjtj_2">${logisticsLevelStatisticsInfo.logistics_badReviews}</span></li>
            <li><span class="pstj">物流经验值</span><span class="pstjsz" id="com_wldjtj_3">${logisticsLevelStatisticsInfo.logistics_totalPoint}</span></li>
          </ul>
       </div>
      </div>
   </div>
 </div>
<div class="gg"><img src="/images/memberimg/tlgg1.gif"/></div>
	<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
	<!-- footer end -->
</body>
</html>