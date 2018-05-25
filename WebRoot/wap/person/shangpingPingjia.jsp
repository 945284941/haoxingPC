<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>浩星APP</title>
    <base href="<%=basePath%>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link type="text/css" href="/wap/css/mui.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/wap/font/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/wap/css/swiper.min.css" />
    <link rel="stylesheet" type="text/css" href="/wap/css/app.css" />
    <style>
        #pingStar li{
            float: left;
            padding-right: 8px;
        }
        @font-face {
            font-family: 'iconfont';
            src: url('iconfont.eot');
            src: url('iconfont.eot?#iefix') format('embedded-opentype'), url('iconfont.woff') format('woff'), url('iconfont.ttf') format('truetype'), url('iconfont.svg#iconfont') format('svg');
        }

        .iconfont {
            font-family: "iconfont" !important;
            font-size: 16px;
            font-style: normal;
            -webkit-font-smoothing: antialiased;
            -webkit-text-stroke-width: 0.2px;
            -moz-osx-font-smoothing: grayscale;
        }
    </style>
</head>
<body>
<!--头部-->
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title order_down_black">商品评价</h1>
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="person/order/huiyuanzhongxin.html"></a>
    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>
</header>
<div class="mui-content">
    <div class="app_box2 mt05 clearfix">
        <ul class="mui-table-view mui-table-view-chevron product clearfix">
            <li class="mui-table-view-cell">
                <a href="">
                    <div class="product_img">
                        <img src="${orItem.defaultPicSrc}" />
                        <%--<p>仅剩3件</p>
                        <span>抢购</span>--%>
                    </div>
                    <div class="product_tex">
                        <p>${orItem.goodsName}</p>
                        <div class="clearfix buying_tex">
                            <div class="mui-pull-left">
                                <p>￥<em>${orItem.dealPrice}</em></p>
                                <s>￥<em>${orItem.marketbalePrice}</em></s>
                            </div>
                            <div class="mui-pull-right mui-text-right">
                                <p class="fn09">$<em><fmt:formatNumber type="number" value="${huilv.now_rate_doc * orItem.dealPrice}" pattern="0.00" maxFractionDigits="2"/></em></p>
                                <p class="fn09">AED<em><fmt:formatNumber type="number" value="${huilv.now_rate_dlm * orItem.dealPrice}" pattern="0.00" maxFractionDigits="2"/></em></p>
                            </div>
                        </div>
                        <p class="mui-text-right">x${orItem.nums}</p>
                    </div>
                </a>
            </li>
        </ul>
    </div>
    <div class="mui-content-padded clearfix">
        <div class="mui-pull-left">满意度：</div>
        <div class="">
            <input type="hidden" id="input" name="appraise.serve"/>
            <ul id="pingStar">
                <li rel="1" title="特别差"><span onclick="memberEvaluate('1')"><img id="1" src="/images/memberimg/star_no.png" /></span></li>
                <li rel="2" title="很差"><span onclick="memberEvaluate('2')"><img id="2" src="/images/memberimg/star_no.png" /></span></li>
                <li rel="3" title="一般"><span onclick="memberEvaluate('3')"><img id="3" src="/images/memberimg/star_no.png" /></span></li>
                <li rel="4" title="很好"><span onclick="memberEvaluate('4')"><img id="4" src="/images/memberimg/star_no.png" /></span></li>
                <li rel="5" title="非常好"><span onclick="memberEvaluate('5')"><img id="5" src="/images/memberimg/star_no.png" /></span></li>
            </ul>
            <span id="dir"></span>
            <input type="hidden" value="" id="startP" />
        </div>
    </div>
    <div class="mui-content-padded">
        <form>
            <textarea class="mg0" name="content" id="content" rows="5" cols=""></textarea>
            <div class="idcard_box mt0">
                <div class="idcard idcard4" id="sss">
                    <img class="acc_imgin" src="images/add_img.png" id="img1">
                    <input type="file" name="file0" id="file1" multiple class="ph08" />
                </div>
            </div>
            <button class="vip_but" onclick="tijiao('${orItem.id}')">确定</button>
        </form>
    </div>
</div>
<%--
<!--底部导航栏 -->
<jsp:include page="/wap/index/indexFooter.jsp"></jsp:include>
--%>
<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">

    mui('body').on('tap','a',function(){
        window.top.location.href=this.href;
    });

    function memberEvaluate(num) {
        $("#input").val(num);
        if(num==1){
            $("#1").attr("src","images/memberimg/star_yes.png");
            $("#2").attr("src","images/memberimg/star_no.png");
            $("#3").attr("src","images/memberimg/star_no.png");
            $("#4").attr("src","images/memberimg/star_no.png");
            $("#5").attr("src","images/memberimg/star_no.png");
        }
        if(num==2){
            $("#1").attr("src","images/memberimg/star_yes.png");
            $("#2").attr("src","images/memberimg/star_yes.png");
            $("#3").attr("src","images/memberimg/star_no.png");
            $("#4").attr("src","images/memberimg/star_no.png");
            $("#5").attr("src","images/memberimg/star_no.png");
        }
        if(num==3){
            $("#1").attr("src","images/memberimg/star_yes.png");
            $("#2").attr("src","images/memberimg/star_yes.png");
            $("#3").attr("src","images/memberimg/star_yes.png");
            $("#4").attr("src","images/memberimg/star_no.png");
            $("#5").attr("src","images/memberimg/star_no.png");
        }
        if(num==4){
            $("#1").attr("src","images/memberimg/star_yes.png");
            $("#2").attr("src","images/memberimg/star_yes.png");
            $("#3").attr("src","images/memberimg/star_yes.png");
            $("#4").attr("src","images/memberimg/star_yes.png");
            $("#5").attr("src","images/memberimg/star_no.png");
        }
        if(num==5){
            $("#1").attr("src","images/memberimg/star_yes.png");
            $("#2").attr("src","images/memberimg/star_yes.png");
            $("#3").attr("src","images/memberimg/star_yes.png");
            $("#4").attr("src","images/memberimg/star_yes.png");
            $("#5").attr("src","images/memberimg/star_yes.png");
        }
    }
    //提交评论
    function tijiao(id) {
        var num = $("#input").val();
        var content = $("#content").val();
        if(num == null || num == ''){
            alert('<s:text name="index_0330"/>！');
            return false;
        }
        if(content == null || content == ''){
            alert('<s:text name="index_0331"/>！');
            return false;
        }
        $.ajax({
            url : 'orderAction!changeAppraise.action',
            type : 'POST',
            data : {id:id,content:content,num:num},
            success : function(data) {
                var r = $.parseJSON(data);
                if (r == 'ok') {
                    window.location.href = "person/order/pingJiaStatus/1.html";
                } else {
                    alert('<s:text name="index_0316"/>！');
                    return false;
                }
            }
        });
    }

</script>
</html>

