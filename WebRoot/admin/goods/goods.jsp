<%@page import="com.qlzy.common.tools.ResourceUtil" %>
<%@page import="com.qlzy.pojo.SessionInfo" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

    SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ResourceUtil.getSessionInfoName());
    String memberId = sessionInfo == null ? "" : sessionInfo.getUserId();
    System.out.println(sessionInfo.getHuilvMap());
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta content="IE=11.0000" http-equiv="X-UA-Compatible">
    <title>颐佳超市</title>
    <meta name="keywords" content="颐佳超市">
    <meta name="description" content="颐佳超市">
    <meta name="GENERATOR" content="颐佳超市">
    <meta name="author" content="颐佳超市">
    <meta name="copyright" content="颐佳超市">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="/admin/common/keyWords.jsp" />
    <script type="text/javascript" src="../../js/haoxing.js"></script>
    <script type="text/javascript" src="../../js/top.js"></script>
    <script type="text/javascript" src="../../js/jquery.jqzoom.js"></script>
    <script type="text/javascript" src="../../js/base.js"></script>
<%--    <script type="text/javascript" src="js/layer/layui.all.js"></script>--%>
    <script type="text/javascript" src="js/layer/layer.js"></script>
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<s:action name="catalogueAction!queryFullCategory" executeResult="true" namespace="/">
    <s:param name="catType">qg</s:param>
</s:action>

<!-- 导航结束 -->

<div class="main">
    <input type="hidden" name="saleRate" id="saleRate" value="${goods.saleRate}"/>
    <input type="hidden" name="docRate" id="docRate" value="${goods.docRate}"/>
    <input type="hidden" name="dlmRate" id="dlmRate" value="${goods.dlmRate}"/>
    <input type="hidden" name="fanxian" id="fanxian" value="${goods.fanxian}"/>
    <input type="hidden" name="isGroup" id="isGroup" value="${goods.isGroup}"/>
    <input type="hidden" name="isFlashSale" id="isFlashSale" value="${goods.isFlashSale}"/>
    <input type="hidden" name="activityPrice" id="activityPrice" value="${goods.activityPrice}"/>
    <div class="h_seat">
        <a href="">首页</a>>
        <a href="">商品详情</a>
    </div>
    <!-- 商品详情 -->
    <div class="lh_spxq">
        <!-- 商品详情 top-->
        <div class="lh_spxq_top">
            <div class="lh_spxq_left">
                <div class="product01">
                    <div id="preview" class="spec-preview">
                        <span class="jqzoom">
                        <img jqimg="${goods.defaultPicSrc}" src="${goods.defaultPicSrc}"/>
                        </span>
                    </div>
                    <!--缩图开始-->
                    <div class="spec-scroll">
                        <a class="prev">&lt;</a>
                        <a class="next">&gt;</a>
                        <div class="items">
                            <ul>
                                <c:forEach items="${goods.goodsPics}" var="goodsPic" varStatus="status">
                                    <li>
                                        <img  bimg="${goodsPic}" src="${goodsPic}"
                                             onmousemove="preview(this);">
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <!--缩图结束-->
                    <div class="preview-info">
                        <div class="left-btns">
                            <a class="follow J-follow hreat " onclick="follow('${company.id}')">
                                <i class="icon iconfont">&#xe739;</i><em>关注</em>
                            </a>
                            <a class="follow J-follow" href="#">
                                <i class="icon iconfont">&#xe61a;</i><em>分享</em>
                            </a>
                          <%--  <a class="follow J-follow" href="#">
                                <i class="icon iconfont">&#xe614;</i><em>二维码</em>
                            </a>--%>
                        </div>
                    </div>
                </div>
            </div>
            <div class="lh_spxq_zj">
                <div class="lh_spxq_zj_title">
                    <s:if test="goods.isSysSelf == '1'">
                        <i>自营</i>
                    </s:if>
					<span>
                            ${goods.name}
					</span>
                </div>

                <div class="lh_spxq_zj_jg">
                    <ul>
                        <li>
                            <div class="lh_cpxq_jg">
                                <div class="lh_cpxq_jg_left">
                                    <em id="goods_price_new">￥
                                         <c:if test="${goods.isFlashSale eq '1' or goods.isGroup eq '1'}" >
                                             <fmt:formatNumber type="number" value="${goods.price * goods.activityPrice * goods.saleRate}" pattern="0.00" maxFractionDigits="2"/>
                                         </c:if>
                                        <c:if test="${goods.isFlashSale eq '0' and goods.isGroup eq '0'}" >
                                            <fmt:formatNumber type="number" value="${goods.price * goods.saleRate}" pattern="0.00" maxFractionDigits="2"/>
                                        </c:if>

                                    </em>
                                    <span>￥<fmt:formatNumber type="number" value="${goods.yuanjia}" pattern="0.00" maxFractionDigits="2"/></span>
                                </div>
                                <div class="lh_cpxq_jg_right">
                                    <em id="goods_price_new_doc">$ <fmt:formatNumber type="number" value="${goods.docPrice}" pattern="0.00" maxFractionDigits="2"/> </em>
                                    <span id="goods_price_new_dlm" >AED <fmt:formatNumber type="number" value="${goods.dlmPrice}" pattern="0.00" maxFractionDigits="2"/></span>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="lh_spxq_zj_jg_zs">
                                <p>购买商品成功后可得
                                    <span id="xindongzhi">
                                        <c:if test="${goods.isFlashSale eq '1' or goods.isGroup eq '1'}" >
                                            <fmt:formatNumber type="number" value="${goods.price * goods.activityPrice * goods.saleRate * goods.fanxian}" pattern="0.00" maxFractionDigits="2"/>
                                        </c:if>
                                        <c:if test="${goods.isFlashSale eq '0' and goods.isGroup eq '0'}" >
                                            <fmt:formatNumber type="number" value="${goods.price * goods.saleRate * goods.fanxian}" pattern="0.00" maxFractionDigits="2"/>
                                        </c:if>
                                    </span>
                                    心动值</p>
                            </div>
                        </li>

                    </ul>
                </div>
                <div class="lh_spxq_zj_lb_nr">抢购商品不支持退换货</div>
                <div class="lh_spxq_zj_lb">

                    <ul>
                        <li><span>销量：${goods.queryNum}</span></li>
                        <li><span>收藏数：${goods.clickNumber}</span></li>
                        <li style="border-right: 0px;"><span>${fn:substring(goods.comAddress,0, 4)}</span></li>
                    </ul>
                </div>
                <c:if test="${goods.skuCode != null }">
                    <c:forEach items="${goods.skuCode }" var="sc">
                        <div class="lh_spxq_zj_cc">
                            <span>${sc.key }</span>
                            <ul class="goodsGG_list">
                                <c:forEach items="${sc.value }" var="v">
                                <c:set value="${fn:split(v,'-')}" var="item"></c:set>
                                <li class="sku" attr_id="${item[0]}" disabled="disabled">
                                        ${item[1]}
                                </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:forEach>
                </c:if>
                <div class="lh_spxq_zj_sl">
                    <span>数量</span>
                    <div class="mui-numbox">
                        <button class="mui-btn mui-btn-numbox-minus" type="button" onclick="clickNum('del')">-</button>
                        <input class="mui-input-numbox" type="number" id="admin_goods_goods_byGoodsNum" value="1"/>
                        <button class="mui-btn mui-btn-numbox-plus" type="button" onclick="clickNum('add')">+</button>
                    </div>
                    <%--<span class="f14 fl">*此商品最多支持1件/单</span>--%>
                </div>
                <div class="lh_spxq_zj_ys">
                    <span>服   务：${goods.companyPurpose}</span>
                </div>
                <div class="lh_spxq_zj_button">
                    <form id="goBuy" action="memberCallAction!goClearing.action" method="post">
                        <input type=hidden  id ="goods_item_id" value=""/>
                        <input type="hidden" id="kuCun"/>
                        <input type="hidden" id="isOneBuy" name="isOneBuy"/>
                        <input type="hidden" id="goodsItemIds" name="goodsItemIds"/>
                        <input type="hidden" id="nowBuyNum" name="nowBuyNum"/>
                        <input type="hidden" id="isNowBuy" name="isNowBuy" value="0"/>
                    </form>

                    <c:if test="${goods.isGroup eq '1'}">
                        <button class="on" onclick="preAddCartto('goods_item_id','<%=memberId %>','${goods.id}','0')">参团</button>
                        <button  onclick="preAddCartto('goods_item_id','<%=memberId %>','${goods.id}','1')">单独购买</button>

                    </c:if>
                    <c:if test="${goods.isFlashSale eq '1'}">
                        <button class="on"  onclick="preAddCartto('goods_item_id','<%=memberId %>','${goods.id}','0')">立即抢购</button>


                    </c:if>
                    <c:if test="${goods.isFlashSale eq '0' and  goods.isGroup eq '0'}">
                        <button onclick="preAddCartto('goods_item_id','<%=memberId %>','${goods.id}','1')">立即购买</button>
                        <button class="on" onclick="preAddCart('goods_item_id','<%=memberId %>','${goods.id}')"><i class="icon iconfont">&#xe653;</i>加入购物车</button>
                    </c:if>
                </div>
            </div>
            <div class="lh_spxq_right">
                <div class="lh_spxq_right_logo"><img src="${company.companyLogo}"/></div>
                <div class="lh_spxq_right_title">
                    ${company.shoperName}
                </div>
                <div class="lh_spxq_right_js">${company.shoperContent}<br>
                    <span>电话：<a onclick="companyMobile('${company.id}')">查看</a></span><br/>
                    <input type="hidden" value="${company.mobile}" id="companyMobile">
                    <span>邮箱：<a onclick="companyEmail('${company.id}')">查看</a></span>
                    <input type="hidden" value="${company.email}" id="companyEmail">
                </div>
                <div class="lh_spxq_right_ksrk">
                    <ul>
                        <li>
                            <a>商家客服</a>
                        </li>
                        <li>
                            <a class="fr">平台客服</a>
                        </li>
                        <li>
                            <a href="shopDetail/${company.id}/1.html">进入店铺</a>
                        </li>
                        <li onclick="followShop('${company.id}')">
                            <a class="fr like followShop">关注店铺</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 商品详情top结束 -->

        <!-- 商品详情内容-->
        <div class="lh_spxq_nr">
            <div class="lh_spxq_nr_left">
                <div class="lh_spxq_nr_left_ss">
                    <div class="skin-box-hd">
                        <h3><span>店内搜素</span></h3>
                    </div>
                    <div class="skin-box-bd">
                        <form id="comForm" action="memberCallAction!shopDetail.action" method="post">
                            <input type="hidden" id="id" name="id" value="${company.id}"/>
                            <input type="hidden" id="node" name="node" value="1"/>
                            <input type="hidden" id="carPartsProducerId" name="carPartsProducerId" value=""/>
                            <ul>
                                <li class="keyword01">
                                    <label>
                                        <span class="key">关键字</span>
                                        <input type="text" size="18" id="name" name="name" avalue="">
                                    </label>
                                </li>
                                <li class="price">
                                    <label>
                                        <span class="key">价格</span>
                                        <input type="text" size="18" id="minMoney" name="minMoney"  value="">-
                                        <input type="text" size="18" id="maxMoney" name="maxMoney"  value="">
                                    </label>
                                </li>
                                <li class="submit">
                                    <a href="javascript:subCom();"><i class="icon iconfont">&#xe60f;</i></a>
                                </li>
                            </ul>
                        </form>
                    </div>
                </div>
                <div class="lh_spxq_nr_left_fl tgar">
                    <div class="skin-box-hd">
                        <h3><span>店内分类</span></h3>
                    </div>
                    <div class="list">
                        <ul class="yiji">
                            <c:forEach items="${companyGoodsCatList}" var="companyCat" varStatus="status">
                                <li>
                                    <a class="inactive">
										<span onclick="goCompanyFenlei('${companyCat.id}');">
										<c:if test="${'zh' eq sessionInfo.language}">
                                            ${companyCat.name}
                                        </c:if>
										<c:if test="${'zh' ne sessionInfo.language}">
                                            ${companyCat.enName}
                                        </c:if>
										</span>
                                    </a>
                                    <ul style="display: none">
                                        <c:forEach items="${companyCat.subCompanyCatList}" var="companySubCat"
                                                   varStatus="status">
                                            <li class="last">
                                                <a onclick="goCompanyFenlei('${companySubCat.id}');">
                                                    <c:if test="${'zh' eq sessionInfo.language}">
                                                        ${companySubCat.name}
                                                    </c:if>
                                                    <c:if test="${'zh' ne sessionInfo.language}">
                                                        ${companySubCat.enName}
                                                    </c:if>
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="lh_spxq_nr_left_tjcp tgar">
                    <div class="skin-box-hd">
                        <h3><span>推荐商品</span></h3>
                    </div>
                    <div class="index_sptj_nr lb01">
                        <ul>
                            <c:forEach items="${hotGoodsList}" var="hotGoods" varStatus="status">
                                <li class="item ">
                                    <div class="goods-content" id="taotian">
                                        <div class="goods-pic">
                                            <a isconvert="1" data-itemid="544015300167" href="goods/${hotGoods.id}.html" target="_blank">
                                                <img src="${hotGoods.defaultPicSrc}">
                                            </a>
                                            <div class="index_sptj_nr_qg">
                                                <c:choose>
                                                    <c:when test="${hotGoods.cornerMark eq '1'}">
                                                        <s:text name="index_0413"/>
                                                    </c:when>
                                                    <c:when test="${hotGoods.cornerMark eq '2'}">
                                                        <s:text name="index_0412"/>
                                                    </c:when>
                                                    <c:when test="${hotGoods.cornerMark eq '3'}">
                                                        <s:text name="index_0411"/>
                                                    </c:when>
                                                    <c:when test="${hotGoods.cornerMark eq '4'}">
                                                        <s:text name="index_0005"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <s:text name="index_0414"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="index_sptj_nr_sl"><s:text name="index_0028"/>${hotGoods.store} <s:text name="index_0029"/></div>
                                        </div>
                                        <div class="goods-info">
                                            <div class="goods-name">
                                                <a isconvert="${status.index + 1}" data-itemid="544015300167" href="goods/${hotGoods.id}.html"
                                                   target="_blank">
                                                        ${hotGoods.name}
                                                </a>
                                            </div>
                                            <div class="goods-price">
                                                <div class="goods-price_div">
                                                    <em class="sale-price">¥
                                                        <c:if test="${hotGoods.isFlashSale eq '1' or hotGoods.isGroup eq '1'}" >
                                                            <fmt:formatNumber type="number" value="${hotGoods.price * hotGoods.activityPrice * hotGoods.saleRate}" pattern="0.00" maxFractionDigits="2"/>
                                                        </c:if>
                                                        <c:if test="${hotGoods.isFlashSale eq '0' and hotGoods.isGroup eq '0'}" >
                                                            <fmt:formatNumber type="number" value="${hotGoods.price * hotGoods.saleRate}" pattern="0.00" maxFractionDigits="2"/>
                                                        </c:if>
                                                    </em><br>
                                                    <em class="sale-price">$
                                                        <fmt:formatNumber type="number" value="${hotGoods.docPrice}" pattern="0.00" maxFractionDigits="2"/>
                                                    </em><br>
                                                    <em class="sale-price">
                                                        AED<fmt:formatNumber type="number" value="${goods.dlmPrice}" pattern="0.00" maxFractionDigits="2"/>
                                                    </em><br>
                                                    <%--<span class="yuanjia">￥<fmt:formatNumber type="number" value="${hotGoods.yuanjia}" pattern="0.00" maxFractionDigits="2"/></span>--%>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="slideTxtBox">
                <div class="lh_spxq_nr_zj">
                    <div class="lh_spxq_nr_zj_top">
                        <div class="hd">
                            <ul>
                                <li onmouseover="changeUl('xiangqing','pinglun')">
                                    <a href="javascript:void(0)">商品详情</a>
                                </li>
                                <li class="tm-selected" onmouseover="changeUl('pinglun','xiangqing')">
                                    <a href="javascript:void(0)">商品评价<em>${goods.allCount}</em></a>
                                </li>
                            </ul>
                        </div>
                        <div class="pageright lh_spxq_nr_zj_top_ewm" id="site-nav">
                            <div class="menu">
                                <a class="menu-hd01" href="" rel="nofollow">手机购买<i class="icon iconfont">
                                    &#xe614;</i><b></b></a>
                                <div class="menu-bd" style="top: 46px;">
                                    <div class="menu-bd-panel">
                                        <div>

                                            <a href="#" rel="nofollow"><img src="images/ewm1.jpg"/></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="bd">
                        <ul class="lh_spxq_2018" id="xiangqing">
                            ${goods.infomation}
                        </ul>
                        <ul id="pinglun" style="display:none;">
                            <div class="rate-toolbar">
                                <span class="rate-filter">
                                    <input class="radiogrounp" name="radiogrounp" checked="" type="radio" id="comtab01"
                                           onclick="changetab('1');">
                                    <label>全部</label>
                                    <input class="radiogrounp" name="radiogrounp" type="radio" id="comtab02" onclick="changetab('2');">
                                    <label>好评 (${goods.haopingCount})</label>
                                    <input class="radiogrounp" name="radiogrounp" type="radio" id="comtab03" onclick="changetab('3');">
                                    <label>中评 (${goods.zhongpingCount})</label>
                                    <input class="radiogrounp" name="radiogrounp" type="radio" id="comtab04" onclick="changetab('4');">
                                    <label>差评 (${goods.chapingCount})</label>
                                    <input class="radiogrounp" name="radiogrounp" type="radio" id="comtab05" onclick="changetab('5');">
                                    <label>有图 (${goods.tupianCount})</label>
					    	</span>
                            </div>
                            <form id="pagerForm" name="pagerForm" action="indexGoodsAction!gainGoodsAppraise.action"
                                  method="post">
                                <input type="hidden" id="appraiseType" name="appraiseType" value="${appraiseType}"/>
                                <input type="hidden" id="goodsId" name="goodsId" value="${goodsId}"/>
                            </form>
                            <div id="pageReload">
                                <s:action name="indexGoodsAction!gainGoodsAppraise" executeResult="true" namespace="/" />
                            </div>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(".slideTxtBox").slide();
        </script>
        <!-- 商品详情内容结束 -->
    </div>
    <!-- 商品详情结束 -->
</div>

<!--footer开始-->
<s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
<!--footer结束-->

<script type="text/javascript">

    var keys = "${goods.skuKeys}";
    keys = eval(keys);
    var data = ${goods.data};
    // 保存最后的组合结果信息
    var SKUResult = {};
    // 获得对象的key
    function getObjKeys(obj) {
        if (obj !== Object(obj))
            throw new TypeError('Invalid object');
        var keys = [];
        for ( var key in obj)
            if (Object.prototype.hasOwnProperty.call(obj, key))
                keys[keys.length] = key;
        return keys;
    }




    // 初始化用户选择事件
    $(function() {
        initSKU();
        $('.sku').each(function() {
            var self = $(this);
            var attr_id = self.attr('attr_id');
            if (!SKUResult[attr_id]) {
                self.css("display", "none");
                //self.attr('disabled', 'disabled');
            }
        }).click(function() {
            var self = $(this);
            // 选中自己，兄弟节点取消选中
            self.toggleClass('on').siblings().removeClass('on');
            // 已经选择的节点
            var selectedObjs = $('.on');
            if (selectedObjs.length) {
                // 获得组合key价格
                var selectedIds = [];
                selectedObjs.each(function() {
                    if(undefined != $(this).attr('attr_id') && "" != $(this).attr('attr_id')){
                        selectedIds.push($(this).attr('attr_id'));
                    }

                });
                selectedIds.sort(function(value1, value2) {
                    return parseInt(value1)
                            - parseInt(value2);
                });
                var len = selectedIds.length;
                var prices = SKUResult[selectedIds
                        .join(';')].prices;
                var counts = SKUResult[selectedIds
                        .join(';')].count;
                var itemId = SKUResult[selectedIds
                        .join(';')].itemId;

                var maxPrice = Math.max.apply(Math, prices);
                var minPrice = Math.min.apply(Math, prices);
                var pricess = maxPrice > minPrice ? minPrice
                + "-" + maxPrice
                        : maxPrice;
                var activityPrice = $("#activityPrice").val();
                var saleRate = $("#saleRate").val();
                var docRate = $("#docRate").val();
                var dlmRate = $("#dlmRate").val();
                var fanxian = $("#fanxian").val()
                if("1" == $("#isGroup").val() || "1" == $("#isFlashSale").val()){
                    var newprice = (pricess * saleRate * activityPrice).toFixed(2);
                    $('#goods_price_new').text("￥" + newprice);
                    var docPricess = (pricess * saleRate * docRate * activityPrice).toFixed(2);
                    $('#goods_price_new_doc').text("$" + docPricess);
                    var dlmPricess = (pricess * saleRate * dlmRate * activityPrice).toFixed(2);
                    $('#goods_price_new_dlm').text("AED" + dlmPricess);
                    var newXindongzhi = (pricess * saleRate * fanxian * activityPrice).toFixed(2);
                    $('#xindongzhi').text(newXindongzhi);
                }else{
                    var newprice = (pricess * saleRate).toFixed(2);
                    $('#goods_price_new').text("￥" + newprice);
                    var docPricess = (pricess * saleRate * docRate).toFixed(2);
                    $('#goods_price_new_doc').text("$" + docPricess);
                    var dlmPricess = (pricess * saleRate * dlmRate).toFixed(2);
                    $('#goods_price_new_dlm').text("AED" + dlmPricess);
                    var newXindongzhi = (pricess * saleRate * fanxian).toFixed(2);
                    $('#xindongzhi').text(newXindongzhi);
                }

                if (counts == 0) {
                    alert('没库存');
                }
                $("#kuCun").val(counts);
                $('#goods_item_id').val(itemId);
                // 用已选中的节点验证待测试节点 underTestObjs
                $(".sku").not(selectedObjs).not(self).each(function() {
                    var siblingsSelectedObj = $(this).siblings('.on');
                    var testAttrIds = [];// 从选中节点中去掉选中的兄弟节点
                    if (siblingsSelectedObj.length) {
                        var siblingsSelectedObjId = siblingsSelectedObj.attr('attr_id');
                        for (var i = 0; i < len; i++) {
                            (selectedIds[i] != siblingsSelectedObjId)&& testAttrIds.push(selectedIds[i]);
                        }
                    } else {
                        testAttrIds = selectedIds.concat();
                    }
                    testAttrIds = testAttrIds.concat($(this).attr('attr_id'));
                    testAttrIds.sort(function(value1,value2) {
                        return parseInt(value1) - parseInt(value2);
                    });
                    if (!SKUResult[testAttrIds.join(';')]) {
                        $(this).css("display","none").removeClass('on');
                    } else {
                        $(this).css("display",null);
                        $(this).removeAttr('disabled');
                    }
                });
            } else {
                // 设置默认价格
                if("1" == $("#isGroup").val() || "1" == $("#isFlashSale").val()){
                    $('#goods_price_new').text('￥<fmt:formatNumber type="number" value="${goods.price * goods.activityPrice}" pattern="0.00" maxFractionDigits="2"/>');
                }else{
                    $('#goods_price_new').text('￥${goods.price}');
                }

                // 设置属性状态
                $('.sku').each(function() {
                    //SKUResult[$(this).attr('attr_id')] ? $(this).removeAttr('disabled'): $(this).attr('disabled','disabled').removeClass('on');
                    SKUResult[$(this).attr('attr_id')] ? $(this).css("display",null) : $(this).css("display","none").removeClass('on');
                })
            }
        });

        //只有一种规格的处理，将唯一的规格id添加到规格的隐藏域中。减少用户不必要的选择
        if($('.sku').length == 1){
            var itemId = SKUResult[$($('.sku')[0]).attr('attr_id')].itemId;
            if (itemId) {
                $('#goods_item_id').val(itemId);
            }

        }
    });


    function clickNum(type) {
        var num = $("#admin_goods_goods_byGoodsNum").val();
        if (type == 'add') {
            if (num <= 999) {
                $("#admin_goods_goods_byGoodsNum").attr("value", parseInt(num) + 1);
            } else {
                $("#admin_goods_goods_byGoodsNum").attr("value", "1000");
                alert('最大数量为1000');
                return;
            }
        } else if (type == 'del') {
            if (num > 1) {
                $("#admin_goods_goods_byGoodsNum").attr("value", num - 1);
            } else {
                alert("购买数量至少为1！");
            }
        } else if (type == 'inputByme') {
            var reg = /^[1-9]\d*$/;
            if (!reg.test(num)) {
                alert("请输入大于0的正整数！");
                $("#admin_goods_goods_byGoodsNum").val(1);
            } else {
                if (num >= 1 && num <= 1000) {
                    $("#admin_goods_goods_byGoodsNum").val(num);
                } else {
                    alert("每件物品购买最大数量为1000！");
                    $("#admin_goods_goods_byGoodsNum").val(1000);
                }
            }

        }
    }
    function followShop(id){
        var action="";
        if($('.followShop').hasClass('like')){
            action="delete";
        }else{
            action = "add";
        }
        $.ajax({
            url:'memberCollectAction!updateMemberCollect.action',
            data:{
                collectId:id,
                userType:'member',
                type:'shop',
                action:action
            },
            dataType:'json',
            method:'post',
            success:function (_data) {
                if(_data.success){
                    alert(_data.msg);
                    if(action=='add'){
                        $(".hreat").removeClass('dislike');
                        $(".hreat").addClass("like");
                        $(".hreat i").css("color","red");
                        $(".followShop").removeClass('dislike');
                        $(".followShop").addClass("like");
                        $('.followShop').html("取消关注")
                    }else{
                        $(".followShop").removeClass('like');
                        $(".followShop").addClass("dislike");
                        $(".hreat").removeClass('like');
                        $(".hreat").addClass("dislike");
                        $(".hreat i").css("color","black");
                        $('.followShop').html("关注店铺")
                    }
                }else{
                    if(_data.msg=="noLogin"){
                        alert("登录失效，请先登录。");
                        window.location.href="toLogin.html"
                    }else {
                        alert(_data.msg);
                    }
                }
            }

        })
    }
    function companyMobile(id){
        var content=$('#companyMobile').val();
        $.ajax({
            url:'companyMemberAction!companyClickNum.action',
            data:{
                id:id
            },
            success:function () {
            }
        })
        layer.open({
            title: '查看邮箱',
            content: content,
        });

    }
    function companyEmail(id){
        var content=$('#companyEmail').val();
        $.ajax({
            url:'companyMemberAction!companyClickNum.action',
            data:{
                id:id
            },
            success:function () {
            }
        })
        layer.open({
            title: '查看邮箱',
            content: content
        });

    }
    function follow(id){
        var action="";
        if($('.hreat').hasClass('like')){
            action="delete";
        }else{
            action = "add";
        }
        $.ajax({
            url:'memberCollectAction!updateMemberCollect.action',
            data:{
                collectId:id,
                userType:'member',
                type:'shop',
                action:action
            },
            dataType:'json',
            method:'post',
            success:function (_data) {
                if(_data.success){
                    alert(_data.msg);
                    if(action=='add'){
                        $(".hreat").removeClass('dislike');
                        $(".hreat").addClass("like");
                        $(".hreat i").css("color","red");
                        $(".followShop").removeClass('dislike');
                        $(".followShop").addClass("like");
                        $('.followShop').html("取消关注")

                    }else{

                        $(".followShop").removeClass('like');
                        $(".followShop").addClass("dislike");
                        $(".hreat").removeClass('like');
                        $(".hreat").addClass("dislike");
                        $(".hreat i").css("color","black");
                        $('.followShop').html("关注店铺")
                    }
                }else{
                    alert(_data.msg);
                }
            }

        })
    }
</script>
<script type="text/javascript" src="../../js/qlzy.js"></script>
<script type="text/javascript" src="../../js/login.js"></script>
<script type="text/javascript" src="../../js/goods.js"></script>
</body>

</html>