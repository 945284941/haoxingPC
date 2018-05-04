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

    <script type="text/javascript">
        function changetab(appraiseType) {
            $("#appraiseType").val(appraiseType);
            $("#pagerForm").submit();
        }
    </script>
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<s:action name="catalogueAction!queryFullCategory" executeResult="true" namespace="/">
    <s:param name="catType">qg</s:param>
</s:action>

<!-- 导航结束 -->

<div class="main">
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
                    <div id="preview" class="spec-preview"><span class="jqzoom"><img jqimg="${goods.defaultPicSrc}"
                                                                                     src="${goods.defaultPicSrc}"/></span>
                    </div>
                    <!--缩图开始-->
                    <div class="spec-scroll">
                        <a class="prev">&lt;</a>
                        <a class="next">&gt;</a>
                        <div class="items">
                            <ul>
                                <c:forEach items="${goods.goodsPics}" var="goodsPic" varStatus="status">
                                    <li><img  bimg="${goodsPic}" src="${goodsPic}"
                                             onmousemove="preview(this);"></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <!--缩图结束-->
                    <div class="preview-info">
                        <div class="left-btns">
                            <a class="follow J-follow" href="#">
                                <i class="icon iconfont">&#xe739;</i><em>关注</em>
                            </a>
                            <a class="follow J-follow" href="#">
                                <i class="icon iconfont">&#xe61a;</i><em>分享</em>
                            </a>
                            <a class="follow J-follow" href="#">
                                <i class="icon iconfont">&#xe614;</i><em>二维码</em>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="lh_spxq_zj">
                <div class="lh_spxq_zj_title">
                    <i>自营</i>
					<span>
						<c:if test="${'zh' eq sessionInfo.language}">
                            ${goods.name}
                        </c:if>
						<c:if test="${'zh' ne sessionInfo.language}">
                            ${goods.enName}
                        </c:if>
					</span>
                </div>

                <div class="lh_spxq_zj_jg">
                    <ul>
                        <li>
                            <div class="lh_cpxq_jg">
                                <div class="lh_cpxq_jg_left">
                                    <em id="goods_price_new">￥${goods.price}
                                    </em>
                                    <span>￥${goods.yuanjia}</span>
                                </div>
                                <div class="lh_cpxq_jg_right">
                                    <em id="goods_price_new_doc">$ <fmt:formatNumber type="number" value="${goods.docPrice}" pattern="0.00" maxFractionDigits="2"/> </em>
                                    <span id="goods_price_new_aed" >AED <fmt:formatNumber type="number" value="${goods.dlmPrice}" pattern="0.00" maxFractionDigits="2"/></span>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="lh_spxq_zj_jg_zs">
                                <p>购买商品成功后可得100心动值</p>
                            </div>
                        </li>

                    </ul>
                </div>
                <div class="lh_spxq_zj_lb_nr">抢购商品不支持退换货</div>
                <div class="lh_spxq_zj_lb">

                    <ul>
                        <li><span>销量：${goods.queryNum}</span></li>
                        <li><span>收藏数：${goods.clickNumber}</span></li>
                        <li style="border-right: 0px;"><span>山东济南 </span></li>
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
                        <button class="mui-btn mui-btn-numbox-minus" type="button">-</button>
                        <input class="mui-input-numbox" type="number" id="admin_goods_goods_byGoodsNum" value="1"/>
                        <button class="mui-btn mui-btn-numbox-plus" type="button">+</button>
                    </div>
                    <span class="f14 fl">*此商品最多支持1件/单</span>
                </div>
                <div class="lh_spxq_zj_ys">
                    <span>服   务：由**发货，**提供售后服务，预计三天到达</span>
                </div>
                <div class="lh_spxq_zj_button">
                    <input type=hidden  id ="goods_item_id" value=""/>
                    <input type="hidden" id="kuCun"/>
                    <button onclick="preAddCartto('goods_item_id','<%=memberId %>')">立即购买</button>
                    <button class="on" onclick="preAddCart('goods_item_id','<%=memberId %>')"><i class="icon iconfont">&#xe653;</i>加入购物车</button>
                </div>
            </div>
            <div class="lh_spxq_right">
                <div class="lh_spxq_right_logo"><img src="${company.companyLogo}"/></div>
                <div class="lh_spxq_right_title">
                    ${company.shoperName}
                </div>
                <div class="lh_spxq_right_js">${company.shoperContent}<br><span>电话：<a
                        href="">${company.mobile}</a></span><br/><span>电话：<a href="">查看</a></span></div>
                <div class="lh_spxq_right_ksrk">
                    <ul>
                        <li>
                            <a href="#">商家客户</a>
                        </li>
                        <li>
                            <a href="#" class="fr">商家客户</a>
                        </li>
                        <li>
                            <a href="#">商家客户</a>
                        </li>
                        <li>
                            <a href="#" class="fr">商家客户</a>
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
                        <form>
                            <ul>
                                <li class="keyword01">
                                    <label>
                                        <span class="key">关键字</span>
                                        <input type="text" size="18" name="keyword" autocomplete="off" value="">
                                    </label>
                                </li>
                                <li class="price">
                                    <label>
                                        <span class="key">价格</span>
                                        <input type="text" size="18" name="keyword" autocomplete="off" value="￥">-
                                        <input type="text" size="18" name="keyword" autocomplete="off" value="￥">
                                    </label>
                                </li>
                                <li class="submit">
                                    <a href="#"><i class="icon iconfont">&#xe60f;</i></a>
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
                                            <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">
                                                <img src="images/lh_img_01.png">
                                            </a>
                                            <div class="index_sptj_nr_qg">抢购</div>
                                            <div class="index_sptj_nr_sl">仅剩3件</div>
                                        </div>
                                        <div class="goods-info">
                                            <div class="goods-name">
                                                <a isconvert="${status.index + 1}" data-itemid="544015300167" href="#"
                                                   target="_blank">
                                                    <c:if test="${'zh' eq sessionInfo.language}">
                                                        ${hotGoods.name}
                                                    </c:if>
                                                    <c:if test="${'zh' ne sessionInfo.language}">
                                                        ${hotGoods.enName}
                                                    </c:if>
                                                </a>
                                            </div>
                                            <div class="goods-price">
                                                <div class="goods-price_div">
                                                    <em class="sale-price">¥${hotGoods.price}</em><br>
                                                    <span class="yuanjia">￥${hotGoods.yuanjia}</span>
                                                </div>
                                                <div class="goods-price_div01">
                                                    <span class="goods_buy">$<fmt:formatNumber type="number" value="${hotGoods.docPrice}" pattern="0.00" maxFractionDigits="2"/></span><br>
                                                    <span class="goods_buy">AED<fmt:formatNumber type="number" value="${goods.dlmPrice}" pattern="0.00" maxFractionDigits="2"/></span>
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
                                    <a href="javascript:void(0)">商品评价<em>1234</em></a>
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
                            <form id="pagerForm" name="pagerForm" action="goods/${goods.id}.html"
                                  method="post">
                                <input type="hidden" id="appraiseType" name="appraiseType" value="${appraiseType}">
                            </form>
                            <div id="comment01">
                                <div class="lh_spxq_nr_zj_pj">
                                    <ul>
                                        <c:forEach items="${appraiseList}" var="appraise" varStatus="status">
                                            <li>
                                                <div class="top_pj">
            <span>
                <c:if test="${appraise.sincerity == 1 }">
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                </c:if>
               <c:if test="${appraise.sincerity == 2 }">
                   <i class="icon iconfont on" >&#xe668;</i>
                   <i class="icon iconfont on" >&#xe668;</i>
                   <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                   <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                   <i class="icon iconfont" style="color: #999;">&#xe668;</i>
               </c:if>
                <c:if test="${appraise.sincerity == 3 }">
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                </c:if>
                <c:if test="${appraise.sincerity == 4 }">
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont on" >&#xe668;</i>
                    <i class="icon iconfont" style="color: #999;">&#xe668;</i>
                </c:if>
                 <c:if test="${appraise.sincerity == 5 }">
                     <i class="icon iconfont on" >&#xe668;</i>
                     <i class="icon iconfont on" >&#xe668;</i>
                     <i class="icon iconfont on" >&#xe668;</i>
                     <i class="icon iconfont on" >&#xe668;</i>
                     <i class="icon iconfont on" >&#xe668;</i>
                 </c:if>
            </span>
                                                    <div class="top_pj_date">
                                                        <em>${appraise.memberName}</em>
                                                        <b>[<fmt:formatDate value="${appraise.createtime}" pattern="yyyy-MM-dd HH:mm:ss" />]</b>
                                                    </div>
                                                </div>
                                                <p>${appraise.content}</p>
                                                <ul>
                                                    <c:forEach items="${appraise.appraisePics}" var="appraisePic" varStatus="status">
                                                        <li><img src="${appraisePic.picUrl}" /></li>
                                                    </c:forEach>
                                                </ul>
                                                <div style=" float:left;padding: 15px 0; font-size: 12px; color: #af874d;">
                                                    <c:if test="${not empty appraise.replyContent}">
                                                        <span style=" color: #bbbbbb;">[回复]</span>${appraise.replyContent}
                                                    </c:if>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div class="w-page">
                                    <page:pagination path="goods/${goods.id}.html"
                                                     formName="pagerForm"/>
                                </div>

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
    function pinglunPage(){
        alert("ccccc");
    }
    function changeUl(tab, htab) {
        $("#" + tab).show();
        $("#" + htab).hide();

    }
    function goCompanyFenlei() {
        alert("aaaaa");
    }
    $(function () {
        $('.inactive').click(function () {
            if ($(this).siblings('ul').css('display') == 'none') {
                $(this).parent('li').siblings('li').removeClass('inactives');
                $(this).addClass('inactives');
                $(this).siblings('ul').slideDown(100).children('li');
                if ($(this).parents('li').siblings('li').children('ul').css('display') == 'block') {
                    $(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
                    $(this).parents('li').siblings('li').children('ul').slideUp(100);

                }
            } else {
                //控制自身变成+号
                $(this).removeClass('inactives');
                //控制自身菜单下子菜单隐藏
                $(this).siblings('ul').slideUp(100);
                //控制自身子菜单变成+号
                $(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
                //控制自身菜单下子菜单隐藏
                $(this).siblings('ul').children('li').children('ul').slideUp(100);

                //控制同级菜单只保持一个是展开的（-号显示）
                $(this).siblings('ul').children('li').children('a').removeClass('inactives');
            }
        })
    });


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

    // 把组合的key放入结果集SKUResult
    function add2SKUResult(combArrItem, sku) {
        var key = combArrItem.join(";");
        if (SKUResult[key]) {// SKU信息key属性
            var ccc = sku["count"] || sku[" count"];
            SKUResult[key].count += ccc;
            SKUResult[key].prices.push(sku.price);
            // 设置选中规格的单品ID
            SKUResult[key].itemId += ";" + sku.itemId;
        } else {
            var ccc = sku["count"] || sku[" count"];
            SKUResult[key] = {
                count : ccc,
                prices : [sku.price],
                itemId : sku.itemId
            };
            console.info(key);
            console.info(SKUResult[key]);
        }
    }

    // 初始化得到结果集
    function initSKU() {
        var i, j, skuKeys = getObjKeys(data);
        for (i = 0; i < skuKeys.length; i++) {
            var skuKey = skuKeys[i];// 一条SKU信息key
            var sku = data[skuKey]; // 一条SKU信息value
            var ccc = sku["count"] || sku[" count"];
            // 剔除库存为0的单品,使之不可选
            if (ccc == 0) {
                alert(1);
                continue;
            }
            var skuKeyAttrs = skuKey.split(";"); // SKU信息key属性值数组
            skuKeyAttrs.sort(function(value1, value2) {
                return parseInt(value1) - parseInt(value2);
            });

            // 对每个SKU信息key属性值进行拆分组合
            var combArr = combInArray(skuKeyAttrs);
            for (j = 0; j < combArr.length; j++) {
                add2SKUResult(combArr[j], sku);
            }
            // 结果集接放入SKUResult
            SKUResult[skuKeyAttrs.join(";")] = {
                count : ccc,
                prices : [sku.price],
                itemId : sku.itemId
            };
        }
    }

    /**
     * 从数组中生成指定长度的组合 方法: 先生成[0,1...]形式的数组, 然后根据0,1从原数组取元素，得到组合数组
     */
    function combInArray(aData) {
        if (!aData || !aData.length) {
            return [];
        }

        var len = aData.length;
        var aResult = [];

        for (var n = 1; n < len; n++) {
            var aaFlags = getCombFlags(len, n);
            while (aaFlags.length) {
                var aFlag = aaFlags.shift();
                var aComb = [];
                for (var i = 0; i < len; i++) {
                    aFlag[i] && aComb.push(aData[i]);
                }
                aResult.push(aComb);
            }
        }

        return aResult;
    }

    /**
     * 得到从 m 元素中取 n 元素的所有组合 结果为[0,1...]形式的数组, 1表示选中，0表示不选
     */
    function getCombFlags(m, n) {
        if (!n || n < 1) {
            return [];
        }

        var aResult = [];
        var aFlag = [];
        var bNext = true;
        var i, j, iCnt1;

        for (i = 0; i < m; i++) {
            aFlag[i] = i < n ? 1 : 0;
        }

        aResult.push(aFlag.concat());

        while (bNext) {
            iCnt1 = 0;
            for (i = 0; i < m - 1; i++) {
                if (aFlag[i] == 1 && aFlag[i + 1] == 0) {
                    for (j = 0; j < i; j++) {
                        aFlag[j] = j < iCnt1 ? 1 : 0;
                    }
                    aFlag[i] = 0;
                    aFlag[i + 1] = 1;
                    var aTmp = aFlag.concat();
                    aResult.push(aTmp);
                    if (aTmp.slice(-n).join("").indexOf('0') == -1) {
                        bNext = false;
                    }
                    break;
                }
                aFlag[i] == 1 && iCnt1++;
            }
        }
        return aResult;
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
                $('#goods_price_new').text("￥" + pricess);

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
                $('#goods_price_new').text('￥${goods.price}');
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

    var arr = document.getElementsByClassName("radiogrounp");
    var t = $("#appraiseType").val();
    $(function () {
        if (null == t) {
            $("#comtab01").attr("checked", true);
            $("#appraiseType").val("1");
        } else {
            for (var i = 1; i < arr.length + 1; i++) {
                if (i == parseInt(t)) {
                    $("#comtab0" + i).attr("checked", true);
                } else {
                    $("#comtab0" + i).attr("checked", false);
                }
            }
        }
    });
</script>
<script type="text/javascript" src="../../js/qlzy.js"></script>
<script type="text/javascript" src="../../js/login.js"></script>
</body>

</html>