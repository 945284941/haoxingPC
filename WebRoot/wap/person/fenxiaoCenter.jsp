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
    <h1 class="mui-title order_down_black">我是分销商</h1>
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="person/order/huiyuanzhongxin.html"></a>

    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>

</header>
<div class="mui-content">
    <div class="vip_box clearfix">
        <div class="mui-table-view-cell">
            <span class="mui-badge bgnone"><a href="/person/toShowBasicInfo.html">账户管理 &gt; </a></span>
            <a href="/person/toShowBasicInfo.html" style="width: 300px">
                <span class="vip_avatar mui-pull-left"><img src="${member.img}" /></span>
                <span class="vip_name mui-pull-left">
							樱桃丸子
							<em class="iconfont">&#xe60b;</em>
							<em class="iconfont">&#xe60b;</em>
							<em class="iconfont">&#xe60b;</em>
							<em class="iconfont">&#xe60b;</em>
							<em class="iconfont">&#xe60b;</em>
						</span>
            </a>
        </div>
        <div class="vip_identity">
            <a class="active" href="personalInfo/fenxiaoCenter.html">我是分销商</a>
            <a href="person/order/huiyuanzhongxin.html">我是买家</a>
        </div>
    </div>
    <div class="vip_mainlist clearfix mt05">
        <h3 class="clearfix">
            <p class="mui-pull-left mg0">我的收益：
                ￥ <fmt:formatNumber type="number" value="${1 * member.shouyi}" pattern="0.00" maxFractionDigits="2"/>&nbsp;&nbsp;
                $ <fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.shouyi}" pattern="0.00" maxFractionDigits="2"/>&nbsp;&nbsp;
                ADE <fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.shouyi}" pattern="0.00" maxFractionDigits="2"/>
            </p>
            <a class="mui-pull-right color_666 fn09" href="javascript:void(0);">分销规则 <img class="fx_ewm mui-pull-right" src="images/2Dbarcode.png"/></a>
        </h3>
        <div  class="mui-row">
            <a class="mui-col-sm-3 mui-col-xs-3 shuju" href="personalInfo/xiaxianticheng/1.html">
                <h2>一级提成</h2>
                <p>￥<fmt:formatNumber type="number" value="${1 * member.yijiticheng}" pattern="0.00" maxFractionDigits="2"/></p>
                <p>$<fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.yijiticheng}" pattern="0.00" maxFractionDigits="2"/></p>
                <p>ADE<fmt:formatNumber type="number" value="${huilv.now_rate_dlm * member.yijiticheng}" pattern="0.00" maxFractionDigits="2"/></p>
            </a>
            <a class="mui-col-sm-3 mui-col-xs-3 shuju" href="personalInfo/xiaxianticheng/2.html">
                <h2>二级提成</h2>
                <p>￥<fmt:formatNumber type="number" value="${1 * member.erjiticheng}" pattern="0.00" maxFractionDigits="2"/></p>
                <p>$<fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.erjiticheng}" pattern="0.00" maxFractionDigits="2"/></p>
                <p>ADE<fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.erjiticheng}" pattern="0.00" maxFractionDigits="2"/></p>
            </a>
            <a class="mui-col-sm-3 mui-col-xs-3 shuju" href="personalInfo/yujiticheng/1.html">
                <h2>预计提成</h2>
                <p>￥<fmt:formatNumber type="number" value="${1 * member.yujiticheng}" pattern="0.00" maxFractionDigits="2"/></p>
                <p>$<fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.yujiticheng}" pattern="0.00" maxFractionDigits="2"/></p>
                <p>ADE<fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.yujiticheng}" pattern="0.00" maxFractionDigits="2"/></p>
            </a>
            <a class="mui-col-sm-3 mui-col-xs-3 shuju" href="javascript:void(0);">
                <h2>已发提成</h2>
                <p>￥<fmt:formatNumber type="number" value="${1 * member.shouyi}" pattern="0.00" maxFractionDigits="2"/></p>
                <p>$<fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.shouyi}" pattern="0.00" maxFractionDigits="2"/></p>
                <p>ADE<fmt:formatNumber type="number" value="${huilv.now_rate_doc * member.shouyi}" pattern="0.00" maxFractionDigits="2"/></p>
            </a>
        </div>
    </div>
    <div class="mui-content-padded">
        <a  href="tixian.html"><button class="vip_but mg0">我要提现</button></a>
    </div>
    <div class="app_box3">
        <div class="mui-row">
            <a class="mui-col-sm-4 mui-col-xs-4 shuju2" href="javascript:void(0);">
                <h2>${member.onlyId}</h2>
                <p>推荐码</p>
            </a>
            <a class="mui-col-sm-4 mui-col-xs-4 shuju2" href="personalInfo/fenxiaoshang/1.html">
                <h2><fmt:formatNumber type="number" value="${1 * member.yijivip}" pattern="0" /></h2>
                <p>分销商</p>
            </a>
            <a class="mui-col-sm-4 mui-col-xs-4 shuju2 bgnone" href="personalInfo/fensituan.html">
                <h2><fmt:formatNumber type="number" value="${1 * member.yijifensi}" pattern="0" /></h2>
                <p>粉丝团</p>
            </a>
        </div>
    </div>
</div>
    <div style="padding-bottom: 70px;"></div>

<!--底部导航栏 -->
<jsp:include page="/wap/index/indexFooter.jsp"></jsp:include>

<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">

    mui('body').on('tap','a',function(){
        window.top.location.href=this.href;
    });

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

