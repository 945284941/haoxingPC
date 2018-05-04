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
    <title>三古汇官方商城-退换货说明</title>
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
<div class="breadThumb">当前位置：首页   &gt; 退换货说明</div>    
<div class="helpCnt">
	<h1 class="text-center">三古汇官方商城<br>退换货说明</h1>
	<p>依据《中华人民共和国产品质量法》、《中华人民共和国消费者权益保护法》等法律法规，“三古汇”承诺对已销售的存在质量问题的商品办理售后服务。客户签收商品时请按照 《验货与拒收政策》之要求进行验货，检查无误后再行签收。签收后，“三古汇官方商城”不再为验货时即可发现的问题承担售后责任。为保障您的权益，请您在收到 商品时与配送员当面核对商品的名称、数量、价格等信息无误，确保商品包装完好、商品没有破损等表面质量问题。
 </p>
<p> 1、水果、蔬菜、水产、肉类等生鲜易腐食品，请您在签收前检查商品的品质，此类商品一经签收将不予以办理退换货；
</p>
<p> 2、除生鲜易腐食品外，其他食品仅支持质量问题退换货，不支持无理由退换货，一经签收非质量问题不予以办理；若签收后24小时内您发现验货时无法发现的质量问题，请与客服中心联系，并提交相关食品检验部门的质检证明，客服将及时为您处理；
</p>
<p><strong>特别说明，以下情况不予办理退换货 ：</strong> </p>
<P>1、任何非购自“三古汇”的商品；<br>
2、任何因客户使用或保管不当导致出现质量问题的商品；<br>
3、任何因您个人原因导致超过保质期的商品；<br>
4、商品图片仅供参照，一切以实物为准。因拍摄灯光及不同显示器等问题造成的色差不属于质量问题。
</P>
<p><strong>退换货运费说明：</strong> </p>
<P>发生退换货时，退、换货运费由责任方承担。<br>
因商品质量问题（非人为损坏）产生的退、换货由“三古汇”承担运费；<br>
由于顾客自身原因导致退、换货的由顾客承担运费。</P>
<P>符合退货条件的，客服中心予以确认，并按原支付方式和原路径安排退款。在线支付的订单，我们会在7个工作日内将退款注入至原支付账户。汇款支付的订单，将退款汇至原汇款银行的原汇款人处。</P>
<P>符合退货条件的，客服中心予以确认，并按原支付方式和原路径安排退款。在线支付的订单，我们会在7个工作日内将退款注入至原支付账户。汇款支付的订单，将退款汇至原汇款银行的原汇款人处。</P>
<P>寄回商品务必用纸盒包或者包装包装好，有商城统一包装的商品，需将包装一并寄回。有赠品的订单商品，需将赠品一并寄回。随意寄回的商品，一律拒绝签收！
退换货前，请您通过微信、QQ、电话跟我们客服联系，告知您的订单号及退换货原因、联系方式、并提供有质量问题的商品图片等，我们视具体情况妥善为您解决。
</P>
<P>本网站承诺7天无理由退换货，规则如下：</P>
<P>一．非质量问题: 可退货，退货邮费买家承担；<br>
二．质量问题：可退换货，邮费本网站承担
</P>
	
</div> 
<div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div>
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
