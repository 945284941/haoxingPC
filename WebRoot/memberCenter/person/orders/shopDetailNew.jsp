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
    <%--<link rel="stylesheet" href="web/css/style.css" type="text/css">--%>
   <%-- <link rel="stylesheet" href="css/common.css" type="text/css" />--%>
    <link rel="stylesheet" href="css/hyzxgr.css" type="text/css" />
   <%-- <link rel="stylesheet" href="css/page.css" type="text/css" />--%>

<%--
    <script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
    <script type=text/javascript src="js/layer/layer.min.js"></script>
    <script type=text/javascript src="js/slides.jquery.js"></script>
    <script type=text/javascript src="js/tanchu.js"></script>--%>
    <script type=text/javascript src="js/register.js"></script>
    <style type="text/css">

        /*@font-face {
            font-family: 'iconfont';  !* project id 257223 *!
            src: url('font/iconfont.eot');
            src: url('font/iconfont.eot#iefix') format('embedded-opentype'),
            url('font/iconfont.eot.woff') format('woff'),
            url('font/iconfont.eot.ttf') format('truetype'),
            url('font/iconfont.svg#iconfont') format('svg');
        }*/
        @font-face {
            font-family: 'iconfont';  /* project id 257223 */
            src: url('//at.alicdn.com/t/font_257223_t49y1zqpv8e0cnmi.eot');
            src: url('//at.alicdn.com/t/font_257223_t49y1zqpv8e0cnmi.eot?#iefix') format('embedded-opentype'),
            url('//at.alicdn.com/t/font_257223_t49y1zqpv8e0cnmi.woff') format('woff'),
            url('//at.alicdn.com/t/font_257223_t49y1zqpv8e0cnmi.ttf') format('truetype'),
            url('//at.alicdn.com/t/font_257223_t49y1zqpv8e0cnmi.svg#iconfont') format('svg');
        }
        .iconfont {
            font-family: "iconfont" !important;
            font-style: normal;
            -webkit-font-smoothing: antialiased;
            -webkit-text-stroke-width: 0.2px;
            -moz-osx-font-smoothing: grayscale;
        }
        .dislike{
            color:black;
        }
        .like{
            color:red;
        }
        .control{
            display: none;
        }
        .lh_sjdp_top_right ul li {position: relative;}
        .erwema {position: absolute; top: 110px; right:0px; padding: 5px; background: #FFFFFF; border: 1px #DDDDDD solid; display: none;}
        .lh_sjdp_top_right ul li:hover .erwema {display: block;}
    </style>
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>


<!-- 导航结束 -->

<div class="main">
    <!-- 商家店铺 -->
    <div class="lh_sjdp">
        <div class="main">
            <div class="lh_sjdp_top">
                <div class="lh_sjdp_top_left">
                    <img src="${company.companyLogo}" style="height:120px;width:800px;" onclick="shopDetail('${company.id}')">
                </div>
                <div class="lh_sjdp_top_right" style="width:270px;">
                    <ul>
                        <li>
                            <a href="javascript:void(0);" onclick="followShop('${company.id}')">
                                <p><i class="icon iconfont"></i></p>
                                <p><s:text name="index_1004"/></p>
                            </a>
                        </li>
                        <li>
                            <a onclick="updateMemberCollect('${company.id}')">
                                <p><i class="icon iconfont hreat">&#xe60d;</i></p>
                                <p class="Collection">已收藏</p>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <p><i class="icon iconfont"></i></p>
                                <p><s:text name="index_0273"/></p>
                                <div class="erwema"><img src="images/ewm1.jpg"/></div>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 店内分类导航开始 -->
        <div class="lh_sjdp_nav">
            <div class="main">
                <ul>
                    <li class="on"><a href="shopDetail/${company.id}/0.html" ><s:text name="index_0091"/></a></li>
                </ul>

            </div>
        </div>
        <!-- 店内分类导航结束 -->
        <div class="main">
            <div class="lh_spxq_nr_left">
                <!-- 店内搜索开始 -->
                <div class="lh_spxq_nr_left_ss">
                    <div class="skin-box-hd">
                        <h3><span><s:text name="index_1000"/></span></h3>
                    </div>
                    <div class="skin-box-bd">
                        <form name = "pagerForm" id = "pagerForm" action="showGoodsByCompanyId.html">
                            <ul>
                                <li class="keyword01">
                                    <label>
                                        <span class="key"><s:text name="index_1001"/></span>
                                        <input type="text" size="18" name="name" id="name" autocomplete="off" value="">
                                    </label>
                                </li>
                                <input type="hidden" name="carPartsProducerId" id="carPartsProducerId">
                                <input type="hidden" name="siv" id="siv">
                                <li class="price">
                                    <label>
                                        <span class="key"><s:text name="index_0025"/></span>
                                        <input type="text" size="18" id="minMoney" name="minMoney" autocomplete="off" value="">-
                                        <input type="text" size="18" id="maxMoney" name="maxMoney" autocomplete="off" value="">
                                    </label>
                                </li>
                                <li class="submit">
                                    <a onclick="findGoodsByType('','${company.id}','${node}')"><i class="icon iconfont"></i></a>
                                </li>
                            </ul>
                        </form>
                    </div>
                </div>
                <!-- 店内搜索结束 -->
                <!-- 店铺分类开始 -->
                <div class="lh_spxq_nr_left_fl tgar">
                    <div class="skin-box-hd">
                        <h3><span><s:text name="index_1002"/></span></h3>
                    </div>
                    <div class="list">
                        <ul class="yiji">
                            <c:forEach items="${goodsCatList}" var="goods">
                                <li>
                                    <a  onclick="findGoodsByType('${goods.id}','${company.id}','${node}')" class="inactive">${goods.name}</a>
                                    <ul style="display: none">
                                        <c:forEach items="${goods.threeCompanyCatList}" var="treeGoods">
                                            <li class="last">
                                                <a onclick="findGoodsByType('${treeGoods.id}','${company.id}','${node}')">${treeGoods.name}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- 店铺分类结束 -->
                <!-- 推荐分类开始 -->
                <div class="lh_spxq_nr_left_tjcp tgar">
                    <div class="skin-box-hd">
                        <h3><span><s:text name="index_1003"/></span></h3>
                    </div>
                    <div class="index_sptj_nr lb01">
                        <ul>
                            <c:forEach items="${goodsList}" var="good">
                                <li class="item ">

                                    <div class="goods-content" >
                                        <div class="goods-pic">
                                            <a  href="goods/${good.id}.html" target="_blank">

                                                <img src="${good.defaultPicSrc}" style="width:180px;height:180px;">
                                            </a>
                                            <div class="index_sptj_nr_qg"><s:text name="index_0269"/></div>
                                            <div class="index_sptj_nr_sl"><s:text name="index_0028"/>${good.store}<s:text name="index_0029"/></div>
                                        </div>
                                        <div class="goods-info">
                                            <div class="goods-name">
                                                <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">${good.name}</a>
                                            </div>
                                            <div class="goods-price">
                                                <div class="goods-price_div" style="font-size:14px;">
                                                    <em class="sale-price">¥${good.price}</em><br>
                                                    <span class="yuanjia">¥${good.yuanjia}</span>
                                                </div>
                                                <div class="goods-price_div01" style="font-size:14px;">
                                                    <span class="goods_buy">$${good.USAMoney}</span><br>
                                                    <span class="goods_buy">AED${good.ADMMoney}</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- 推荐分类结束 -->
            </div>
            <c:if test="${'0' eq node }">

                <s:action name="memberCallAction!companyTail" executeResult="true" namespace="/"></s:action>

            </c:if>
            <c:if test="${'1' eq node }">
                <!-- 商品列表开始-->
            <div id="pageReload">
                <s:action name="memberCallAction!companyGoodsList" executeResult="true" namespace="/"></s:action>
            </div>
                <!-- 商品列表结束-->
            </c:if>

        </div>
    </div>
    <!-- 商家店铺结束 -->
        <!--footer开始-->
        <s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
        <!--footer结束-->
</div>



<script type="text/javascript">

    //跳转店铺详情
    function shopDetail(id){
        window.location.href="shopDetail/"+id+"/0.html"
    }
    //收藏
    function updateMemberCollect(id){
        var action="";
        if($('.hreat').hasClass('like')){
            action="delete";
        }else{
            action = "add";
        }
        alert(action);
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
                    layer.alert(_data.msg);
                    if(action=='add'){
                        $(".hreat").removeClass('dislike');
                        $(".hreat").addClass("like");
                        $(".Collection").html("<s:text name='index_1006'/>")
                    }else{

                        $(".hreat").removeClass('like');
                        $(".hreat").addClass("dislike");
                        $(".Collection").html("<s:text name='index_1005'/>")
                    }
                }else{
                    if(_data.msg=="noLogin"){
                        layer.alert("登录失效，请先登录。");
                        window.location.href="toLogin.html"
                    }else {
                        alert(_data.msg);
                    }
                }
            }

        })
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

</script>
<script type="text/javascript" src="../../js/qlzy.js"></script>
<script type="text/javascript" src="../../js/login.js"></script>

</body>

</html>