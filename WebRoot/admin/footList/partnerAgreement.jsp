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
    <title>三古汇官方商城-商家入驻</title>
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
<div class="breadThumb">当前位置：首页   &gt; 商家入驻</div>    
<div class="helpCnt">
	<h1 class="text-center">三古汇官方商城<br>商家入驻协议</h1>
	<p>为了更好地开拓市场，更好地为本地客户服务，甲乙双方本着互惠互利的双赢策略，根据乙方三古汇商城入驻条件，甲方申请入驻乙方商城，并完全接受乙方的规范，经友好协商，甲乙双方签署以下入驻协议。</p>
	<h3>一、 入驻商家基本条件</h3>
	<p>1、 有良好的合作意愿，能提供优质的商品，保证合作的顺利进行，并保证提供良好的售后服务；</p>
	<p>2、 甲方必须满足以下条件之一（符合其中一项即可）：</p>
	<p>⑴授权商，获得国际或者国内知名品牌厂商的授权；</p>
	<p>⑵拥有自己注册商标的生产型厂商；</p>
	<p>⑶专业品牌经销商，代理商，B2C网站；</p>
	<p>⑷专业品牌专卖店。</p>
	<p>3、 甲方应在签订本协议时向乙方提供（经乙方认可的）包括但不限于以下证明材料复印件：</p>
	<p>⑴营业执照 (包括个体户营业执照)、税务登记证；</p>
	<p>⑵拥有注册商标或者品牌，或者拥有正规的品牌授权书。</p>
	<p>4、 甲方承诺：</p>
	<p>⑴所有商品一口价销售（参与打折、促销、秒杀活动除外）；</p>
	<p>⑵七天无损坏不影响二次销售情况下换货(如商品无质量问题，且包装未破坏不影响二次销售，换货费用由买家承担，每张订单只提供一次换货服务；如属商品质量问题，换货费用由商家承担)；</p>
	<p>⑶实体店地址变更应及时告知乙方；</p>
	<p>⑷参加乙方全网经验值购物活动；</p>
	<p>⑸所有商品保证原厂正品，保障商品质量、承诺售后服务，必要时能提供销售发票。</p>
	<h3>二、 入驻商铺类型</h3>
	<p>1、 展示型商铺；</p>
	<p>2、 销售型商铺。</p>
	<h3>三、入驻商铺等级</h3>
	<p>1、普通商铺；</p>
	<p>2、扶持商铺；</p>
	<p>3、拓展商铺；</p>
	<p>4、旗舰商铺。</p>
	<h3>三、 商铺入驻开通流程</h3>
	<p>1、 甲乙双方签署本协议；</p>
	<p>2、 甲方根据所选择商铺类型，提交相应的证明材料复印件；</p>
	<p>3、 在乙方商城注册，获取管理员账号；</p>
	<p>4、 乙方审核通过后，甲方即可发布商品并展示经营活动。</p>
	<h3>四、 双方权利义务</h3>
	<p>甲方权利义务：</p>
	<p>1、 在本协议第一条规定范围内，甲方自行开拓市场与发展业务，不得以欺诈、胁迫等不正当手段损害客户或甲方的利益与声誉；</p>
	<p>2、 甲方妥善保管商铺管理员账号，如因甲方保管、设置或使用不当造成的经济损失，由甲方自行承担责任；</p>
	<p>3、 甲方在使用过程中如发现任何非法盗用乙方账号出现安全漏洞等情况，应立即通知乙方；</p>
	<p>4、 甲方保证其所有经营活动完全符合中国有关法律、法规、行政规章等的规定。如因甲方违反上述规定给乙方带来任何损害，甲方应承担所有法律责任并赔偿由此给甲方造成的损失；</p>
	<p>5、 在协议有效期内，甲方不得向与乙方构成商业竞争关系的企业、商业机构或者组织提供有关乙方相关信息或者资料，否则对乙方造成损失的，由甲方负责赔偿。</p>
	<p>乙方权利义务：</p>
	<p>1、 乙方对甲方提供必要的开店技术咨询，并保证商城系统平台能正常稳定运行；</p>
	<p>2、 如甲方是托管商铺，乙方应及时为甲方进行店铺更新并实时进行日常管理；</p>
	<p>3、 在本协议有效期限内，乙方有权根据市场情况对各种商铺入驻条件进行调整。</p>
	<h3>五、 协议期限</h3>
	<p>本协议有效期为一年，自签订之日起生效。有效期满后，双方可视合作情况续约。</p>
	<h3>六、 协议变更、终止及违约责任</h3>
	<p>1、 甲乙双方应本着诚实信用的原则履行本协议。任何一方在履约过程中采用欺诈、胁迫或者暴力的手段，另一方均可以解除本协议并要求对方赔偿由此造成的损失；</p>
	<p>2、 在协议执行期间，如果双方或一方认为需要终止，应提前一个月通知对方，双方在财务结算完毕、各自责任明确履行之后，方可终止协议。某方擅自终止本协议，给对方造成损失的，应赔偿对方损失；</p>
	<p>3、 经双方协商达成一致，可以对本协议有关条款进行变更，但应当以书面形式确认；</p>
	<p>4、 一方变更通讯地址或其它联系方式，应自变更之日起十日内，将变更后的地址、联系方式通知另一方，否则变更方应对此造成的一切后果承担责任；</p>
	<p>5、 如因客观情况发生重大变化，致使本协议无继续法履行的，经甲乙双方协商同意，可以变更或者终止协议的履行。</p>
	<h3>七、 保密条款</h3>
	<p>1、甲、乙双方所提供给对方的一切资料、技术和对项目的策划设计要严格保密，并只能在合作双方公司的业务范围内使用；</p>
	<p>2、甲、乙双方均应对在合作过程中所知悉的对方的商业和技术秘密承担保密义务。保密条款不受本协议期限的限制。</p>
	<h3>八、 争议解决</h3>
	<p>在本协议执行期间如果双方发生争议，双方应友好协商解决。如果协商不成，双方同意提交给崇左市仲裁委员会进行仲裁，接受其仲裁规则，并服从该仲裁裁决，仲裁费由败诉方承担。争议的解决适用中华人民共和国法律、法规、条例和计算机行业惯例。</p>
	
</div> 
<!-- <div class="bottom_box_06"> <div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<jsp:include page="/admin/common/indexFooter.jsp" />
  </body>
</html>
