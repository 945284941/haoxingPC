<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=7" />
    <jsp:include page="/admin/common/keyWords.jsp" />
    <title>颐佳商城</title>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta http-equiv="keywords" content="颐佳,商城" />
    <meta http-equiv="description" content="颐佳,商城" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- <link rel="stylesheet" href="web/bootstrap/bootstrap.min.css" type="text/css" /> -->
    <link rel="stylesheet" href="web/css/sghsc-main.css" type="text/css" />
    <link rel="stylesheet" href="web/css/sghsc-order.css" type="text/css" />
    <link rel="stylesheet" href="web/css/datePicker.css" />
    <link rel="stylesheet" href="web/css/style.css" type="text/css">
 <%--   <link rel="stylesheet" href="web/css/pagination.css" type="text/css">--%>
    <link rel="stylesheet" href="css/common.css" type="text/css" />
    <link rel="stylesheet" href="css/hyzxgr.css" type="text/css" />
    <link rel="stylesheet" href="css/page.css" type="text/css" />


    <script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
    <script type=text/javascript src="js/layer/layer.min.js"></script>
    <script type=text/javascript src="js/slides.jquery.js"></script>
    <script type=text/javascript src="js/tanchu.js"></script>
    <script type=text/javascript src="js/register.js"></script>
    <script type="text/javascript" src="js/layer/layer.js"></script>

    <!-- 日历控件 -->
    <script type="text/javascript" src="web/js/jquery.date_input.pack.js"></script>
    <script type="text/javascript">
        function changetab(pid){
            if(pid=="comtab01"){
                $("#comment02,#comment03,#comment04,#comment05").hide();
                $("#comment01").show();
            }
            if(pid=="comtab02"){
                $("#comment01,#comment03,#comment04,#comment05").hide();
                $("#comment02").show();
            }
            if(pid=="comtab03"){
                $("#comment01,#comment02,#comment04,#comment05").hide();
                $("#comment03").show();
            }
            if(pid=="comtab04"){
                $("#comment01,#comment02,#comment03,#comment05").hide();
                $("#comment04").show();
            }
            if(pid=="comtab05"){
                $("#comment01,#comment02,#comment03,#comment04").hide();
                $("#comment05").show();
            }
        }
        function updateMemberCollect(id){

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
    </script>
    <style type="text/css">
        @font-face {
            font-family: "iconfont";
            src: url('font/iconfont.eot');
            /* IE9*/
            src: url('font/iconfont.eot#iefix') format('embedded-opentype'), /* IE6-IE8 */
            url('font/iconfont.woff') format('woff'), /* chrome, firefox */
            url('font/iconfont.ttf') format('truetype'), /* chrome, firefox, opera, Safari, Android, iOS 4.2+*/
            url('font/iconfont.svg#iconfont') format('svg');
            /* iOS 4.1- */
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
    </style>
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>


<!-- 导航结束 -->

<div class="main">
    <%--<input type="hidden" name="saleRate" id="saleRate" value="${goods.saleRate}"/>
    <input type="hidden" name="docRate" id="docRate" value="${goods.docRate}"/>
    <input type="hidden" name="dlmRate" id="dlmRate" value="${goods.dlmRate}"/>
    <input type="hidden" name="fanxian" id="fanxian" value="${goods.fanxian}"/>
    <input type="hidden" name="isGroup" id="isGroup" value="${goods.isGroup}"/>
    <input type="hidden" name="isFlashSale" id="isFlashSale" value="${goods.isFlashSale}"/>
    <input type="hidden" name="activityPrice" id="activityPrice" value="${goods.activityPrice}"/>--%>

    <!-- 商家店铺 -->
    <div class="lh_sjdp">
        <div class="main">
            <div class="lh_sjdp_top">
                <div class="lh_sjdp_top_left">
                    <img src="${company.companyLogo}" style="height:120px;width:600px;" onclick="shopDetail('${company.id}')">
                </div>
                <div class="lh_sjdp_top_right" style="width:270px;">
                    <ul>
                        <li>
                            <a href="">
                                <p><i class="icon iconfont"></i></p>
                                <p><s:text name="index_1004"/></p>
                            </a>
                        </li>
                        <li>
                            <a onclick="updateMemberCollect('${company.id}')">
                                <c:if test="${'like' eq hobby }">
                                    <p><i class="icon iconfont hreat like" ></i></p>
                                    <p class="Collection">已收藏</p>
                                </c:if>
                                <c:if test="${'disLike' eq hobby}">
                                    <p><i class="icon iconfont hreat dislike" ></i></p>
                                    <p class="Collection">收藏</p>
                                </c:if>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <p><i class="icon iconfont"></i></p>
                                <p><s:text name="index_0273"/></p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="lh_sjdp_nav">
            <div class="main">
                <ul>
                    <li class="on"><a onclick="shopDetail('${company.id}')"><s:text name="index_0091"/></a></li>
                </ul>

            </div>
        </div>
        <div class="main">
            <div class="lh_spxq_nr_left">
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
                                            <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">

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
</div>

<!--footer开始-->
<s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
<!--footer结束-->



<script src="js/mui.js"></script>
<script>
    mui.init();
    document.getElementById("btn").addEventListener('tap', function(event) {
        mui.alert('当前值: ' + document.getElementById("box").value, null, "提示");
    });
    var testBox = document.getElementById("test");
    testBox.addEventListener('change', function() {
        console.log(testBox.value);
    });
</script>
<script>
    $(function(){
        $("#address_1 div.list div").click(function(){
            $(this).addClass("addr-cur").siblings("div").removeClass("addr-cur");
            $(this).addClass("addr-def").siblings("div").removeClass("addr-def");
        })
    })
</script>
<script type="text/javascript">
    $(document).ready(function() {
        $('.inactive').click(function() {
            if($(this).siblings('ul').css('display') == 'none') {
                $(this).parent('li').siblings('li').removeClass('inactives');
                $(this).addClass('inactives');
                $(this).siblings('ul').slideDown(100).children('li');
                if($(this).parents('li').siblings('li').children('ul').css('display') == 'block') {
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
    function shopDetail(id){
        window.location.href="shopDetail/"+id+"/0.html"
    }
/*    function findGoodsByPrice(){
        var minMoney=$('#minMoney').val();
        var name=$('#name').val();
        var maxMoney=$('#maxMoney').val();
    }*/
    function findGoodsByType(treeId,companyId,node){

        var minMoney=$('#minMoney').val();
        var name=$('#name').val();
        var maxMoney=$('#maxMoney').val();
        if(treeId==null||treeId==""){
            treeId= $('#treeId').val();
        }else{
            $('#carPartsProducerId').val(treeId)
        }
          $.ajax({
              url:'memberCallAction!companyGoodsList.action',
              data:{
                  carPartsProducerId:treeId,
                  id:companyId,
                  minMoney:minMoney,
                  maxMoney:maxMoney,
                  name:name
              },
           /*   dataType:'json',*/

              success:function (_data) {
                  $('#detail').html(_data)
                  $('.lh_sjdp_qbsp_right01').css("display","none");


              }
          })
    }
    function orderSiv(){

        var minMoney=$('#minMoney').val();
        var name=$('#name').val();
        var maxMoney=$('#maxMoney').val();
        var companyId=$('#companyId').val();
        var treeId=$('#treeId').val();
        $('#siv').val("orderSive");
        $.ajax({
            url:'memberCallAction!companyGoodsListByCompanyIdAndTreeId.action',
            data:{
                carPartsProducerId:treeId,
                id:companyId,
                minMoney:minMoney,
                maxMoney:maxMoney,
                name:name,
                orderSiv:1
            },
            dataType:'json',
            success:function (_data) {
                $('#goodsList').html("");
                var goods=_data.goodPageListNew;
                console.log(_data)
                for (var i=0;i < goods.length;i++){

                    $('#goodsList').append('                <li class="item ">\n' +
                        '                    <div class="goods-content" >\n' +
                        '                        <div class="goods-pic">\n' +
                        '                            <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">\n' +
                        '                                <img src="'+goods[i].defaultPicSrc+'" style="width:300px;height:300px;"/>\n' +
                        '                            </a>\n' +
                        '                            <div class="index_sptj_nr_qg">抢购</div>\n' +
                        '                            <div class="index_sptj_nr_sl">仅剩'+goods[i].store+'件</div>\n' +
                        '                        </div>\n' +
                        '                        <div class="goods-info">\n' +
                        '                            <div class="goods-name">\n' +
                        '                                <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">'+goods[i].name+'</a>\n' +
                        '                            </div>\n' +
                        '                            <div class="goods-price">\n' +
                        '                                <div class="goods-price_div">\n' +
                        '                                    <em class="sale-price">¥'+goods[i].price+'</em><br>\n' +
                        '                                    <span class="yuanjia">¥'+goods[i].yuanjia+'</span>\n' +
                        '                                </div>\n' +
                        '                                <div class="goods-price_div01">\n' +
                        '                                    <span class="goods_buy">$'+goods[i].uSAMoney+'</span><br>\n' +
                        '                                    <span class="goods_buy">AED'+goods[i].aDMMoney+'</span>\n' +
                        '                                </div>\n' +
                        '                            </div>\n' +
                        '                            <div class="goods-sales">\n' +
                        '\n' +
                        '                                <p class="fl">销量 '+goods[i].queryNum+'</p>\n' +
                        '                                <p class="fr">好评 '+goods[i].praiseRate+'</p>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                    </div>\n' +
                        '                </li>')
                }
            }
        })
    }
    function volumeSiv(){
        var minMoney=$('#minMoney').val();
        var name=$('#name').val();
        var maxMoney=$('#maxMoney').val();
        var companyId=$('#companyId').val();
        var treeId=$('#treeId').val();
        $('#siv').val("volumeSiv");
        $.ajax({
            url:'memberCallAction!companyGoodsListByCompanyIdAndTreeId.action',
            data:{
                carPartsProducerId:treeId,
                id:companyId,
                minMoney:minMoney,
                maxMoney:maxMoney,
                name:name,
                volumeSiv:1
            },
            dataType:'json',
            success:function (_data) {
                $('#goodsList').html("");
                var goods=_data.goodPageListNew;
                console.log(_data)
                for (var i=0;i < goods.length;i++){

                    $('#goodsList').append('                <li class="item ">\n' +
                        '                    <div class="goods-content" >\n' +
                        '                        <div class="goods-pic">\n' +
                        '                            <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">\n' +
                        '                                <img src="'+goods[i].defaultPicSrc+'" style="width:300px;height:300px;"/>\n' +
                        '                            </a>\n' +
                        '                            <div class="index_sptj_nr_qg">抢购</div>\n' +
                        '                            <div class="index_sptj_nr_sl">仅剩'+goods[i].store+'件</div>\n' +
                        '                        </div>\n' +
                        '                        <div class="goods-info">\n' +
                        '                            <div class="goods-name">\n' +
                        '                                <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">'+goods[i].name+'</a>\n' +
                        '                            </div>\n' +
                        '                            <div class="goods-price">\n' +
                        '                                <div class="goods-price_div">\n' +
                        '                                    <em class="sale-price">¥'+goods[i].price+'</em><br>\n' +
                        '                                    <span class="yuanjia">¥'+goods[i].yuanjia+'</span>\n' +
                        '                                </div>\n' +
                        '                                <div class="goods-price_div01">\n' +
                        '                                    <span class="goods_buy">$'+goods[i].uSAMoney+'</span><br>\n' +
                        '                                    <span class="goods_buy">AED'+goods[i].aDMMoney+'</span>\n' +
                        '                                </div>\n' +
                        '                            </div>\n' +
                        '                            <div class="goods-sales">\n' +
                        '\n' +
                        '                                <p class="fl">销量 '+goods[i].queryNum+'</p>\n' +
                        '                                <p class="fr">好评 '+goods[i].praiseRate+'</p>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                    </div>\n' +
                        '                </li>')
                }
            }
        })
    }
    function createTimeSiv(){
        var minMoney=$('#minMoney').val();
        var name=$('#name').val();
        var maxMoney=$('#maxMoney').val();
        var companyId=$('#companyId').val();
        var treeId=$('#treeId').val();
        $('#siv').val("createTimeSiv");
        $.ajax({
            url:'memberCallAction!companyGoodsListByCompanyIdAndTreeId.action',
            data:{
                carPartsProducerId:treeId,
                id:companyId,
                minMoney:minMoney,
                maxMoney:maxMoney,
                name:name,

            },
            dataType:'json',
            success:function (_data) {
                $('#goodsList').html("");
                var goods=_data.goodPageListNew;
                console.log(_data)
                for (var i=0;i < goods.length;i++){

                    $('#goodsList').append('                <li class="item ">\n' +
                        '                    <div class="goods-content" >\n' +
                        '                        <div class="goods-pic">\n' +
                        '                            <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">\n' +
                        '                                <img src="'+goods[i].defaultPicSrc+'" style="width:300px;height:300px;"/>\n' +
                        '                            </a>\n' +
                        '                            <div class="index_sptj_nr_qg">抢购</div>\n' +
                        '                            <div class="index_sptj_nr_sl">仅剩'+goods[i].store+'件</div>\n' +
                        '                        </div>\n' +
                        '                        <div class="goods-info">\n' +
                        '                            <div class="goods-name">\n' +
                        '                                <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">'+goods[i].name+'</a>\n' +
                        '                            </div>\n' +
                        '                            <div class="goods-price">\n' +
                        '                                <div class="goods-price_div">\n' +
                        '                                    <em class="sale-price">¥'+goods[i].price+'</em><br>\n' +
                        '                                    <span class="yuanjia">¥'+goods[i].yuanjia+'</span>\n' +
                        '                                </div>\n' +
                        '                                <div class="goods-price_div01">\n' +
                        '                                    <span class="goods_buy">$'+goods[i].uSAMoney+'</span><br>\n' +
                        '                                    <span class="goods_buy">AED'+goods[i].aDMMoney+'</span>\n' +
                        '                                </div>\n' +
                        '                            </div>\n' +
                        '                            <div class="goods-sales">\n' +
                        '\n' +
                        '                                <p class="fl">销量 '+goods[i].queryNum+'</p>\n' +
                        '                                <p class="fr">好评 '+goods[i].praiseRate+'</p>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                    </div>\n' +
                        '                </li>')
                }
            }
        })
    }

    function priceRiseSiv(){
        var minMoney=$('#minMoney').val();
        var name=$('#name').val();
        var maxMoney=$('#maxMoney').val();
        var companyId=$('#companyId').val();
        var treeId=$('#treeId').val();
        $('#siv').val("priceRiseSiv");
        $.ajax({
            url:'memberCallAction!companyGoodsListByCompanyIdAndTreeId.action',
            data:{
                carPartsProducerId:treeId,
                id:companyId,
                minMoney:minMoney,
                maxMoney:maxMoney,
                name:name,
                priceRiseSiv:1

            },
            dataType:'json',
            success:function (_data) {
                $('#goodsList').html("");
                var goods=_data.goodPageListNew;
                console.log(_data)
                for (var i=0;i < goods.length;i++){

                    $('#goodsList').append('                <li class="item ">\n' +
                        '                    <div class="goods-content" >\n' +
                        '                        <div class="goods-pic">\n' +
                        '                            <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">\n' +
                        '                                <img src="'+goods[i].defaultPicSrc+'" style="width:300px;height:300px;"/>\n' +
                        '                            </a>\n' +
                        '                            <div class="index_sptj_nr_qg">抢购</div>\n' +
                        '                            <div class="index_sptj_nr_sl">仅剩'+goods[i].store+'件</div>\n' +
                        '                        </div>\n' +
                        '                        <div class="goods-info">\n' +
                        '                            <div class="goods-name">\n' +
                        '                                <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">'+goods[i].name+'</a>\n' +
                        '                            </div>\n' +
                        '                            <div class="goods-price">\n' +
                        '                                <div class="goods-price_div">\n' +
                        '                                    <em class="sale-price">¥'+goods[i].price+'</em><br>\n' +
                        '                                    <span class="yuanjia">¥'+goods[i].yuanjia+'</span>\n' +
                        '                                </div>\n' +
                        '                                <div class="goods-price_div01">\n' +
                        '                                    <span class="goods_buy">$'+goods[i].uSAMoney+'</span><br>\n' +
                        '                                    <span class="goods_buy">AED'+goods[i].aDMMoney+'</span>\n' +
                        '                                </div>\n' +
                        '                            </div>\n' +
                        '                            <div class="goods-sales">\n' +
                        '\n' +
                        '                                <p class="fl">销量 '+goods[i].queryNum+'</p>\n' +
                        '                                <p class="fr">好评 '+goods[i].praiseRate+'</p>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                    </div>\n' +
                        '                </li>')
                }

            }
        })
    }


</script>


</body>
<script type="text/javascript">


</script>
</html>
