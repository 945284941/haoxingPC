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
    System.out.println(path+"___________"+basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>" />
    <title>浩星APP</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link type="text/css" href="/wap/css/mui.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/wap/font/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/wap/css/swiper.min.css" />
    <link rel="stylesheet" type="text/css" href="/wap/css/app.css" />
    <style>
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
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <h1 class="mui-title">会员中心</h1>
    <jsp:include page="/wap/index/indexHeader.jsp"></jsp:include>
</header>
<div class="mui-content">
    <div class="vip_box clearfix">
        <div class="mui-table-view-cell">
            <span class="mui-badge bgnone"><a href="/person/toZhanghuguanli.html">账户管理 &gt; </a></span>
            <a href="/person/toShowBasicInfo.html" style="width: 300px">
                <span class="vip_avatar mui-pull-left"><img src="${member.img}"  /></span>
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
            <a href="personalInfo/fenxiaoCenter.html">我是分销商</a>
            <a class="active" href="person/order/huiyuanzhongxin.html">我是买家</a>
        </div>
    </div>
    <div class="vip_mainlist clearfix mt05">
        <h3>我的订单 <a class="mui-pull-right color_999 fn09" href="person/order/myOrders.html">查看更多订单 &gt; </a></h3>
        <ul>
            <!--1、待付款 2、待发货 3、待收货 4、已完成  5.待评价 6.取消订单 7.退款退货中-->
            <li>
                <a href="person/order/myOrders/1.html">
                    <p class="iconfont">&#xe65b;</p>待付款</a>
            </li>
            <li>
                <a href="person/order/myOrders/2.html">
                    <p class="iconfont">&#xe62f;</p>待发货</a>
            </li>
            <li>
                <a href="person/order/myOrders/3.html">
                    <p class="iconfont">&#xe67b;</p>待收货</a>
            </li>
            <li>
                <a href="person/order/myOrders/7.html">
                    <p class="iconfont">&#xe621;</p>退款/退货</a>
            </li>
        </ul>
    </div>
    <div class="vip_data mui-text-center clearfix">
        <div class="mui-pull-left"><fmt:formatNumber type="number" value="${1 * total}" pattern="0.00" maxFractionDigits="2"/>
            <p class="color_666">消费总额</p>
        </div>
        <div class="mui-pull-left"><fmt:formatNumber type="number" value="${1 * member.advance}" pattern="0.00" maxFractionDigits="2"/>
            <p class="color_666">我的心动值</p>
        </div>
    </div>
    <div class="mt05">
        <ul class="mui-table-view">
            <li class="mui-table-view-cell">
                <a href="showMyCollect/1.html" class="mui-navigate-right">
                    <em class="iconfont">&#xe607;</em> 我的收藏
                </a>
            </li>
            <li class="mui-table-view-cell">
                <a href="person/order/pingJiaStatus/1.html" class="mui-navigate-right">
                    <em class="iconfont">&#xe65a;</em> 商品评论
                </a>
            </li>
            <li class="mui-table-view-cell">
                <a href="qiugou/1.html" class="mui-navigate-right">
                    <em class="iconfont">&#xe64d;</em> 我的发布
                </a>
            </li>
            <li class="mui-table-view-cell">
                <a href="yijian.html" class="mui-navigate-right">
                    <em class="iconfont">&#xe63c;</em> 意见反馈
                </a>
            </li>
            <li class="mui-table-view-cell">
                <a class="mui-navigate-right">
                    <em class="iconfont">&#xe673;</em> 在线客服
                </a>
            </li>
        </ul>
    </div>
    <div class="mui-content-padded">
        <button class="vip_but mg0">退出</button>
    </div>
</div>
<div style="padding-bottom: 70px;"></div>
/** 底部导航栏 **/
<jsp:include page="/wap/index/indexFooter.jsp"></jsp:include>

<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">
//    mui('body').on('tap','a',function(){
//        window.top.location.href=this.href;
//    });


    var loginByUrl = '';
    $('#register').on('click',function () {
        window.location.href="login!toRegister.action";
    })
    function loginFromSub() {
        var loginName = $('#loginName').val();
        var loginPwd = $('#loginPwd').val();
        if (loginName == '' || loginName == null) {
            alert('<s:text name="index_0275"/>');
            return false;
        }
        if (loginPwd == '' || loginPwd == null) {
            alert('<s:text name="index_0278"/>');
            return false;
        }
        $.ajax( {
            url : 'login.html',
            type : 'POST',
            data : $('#loginFrom').serialize(),
            success : function(data) {
                var msg = $.parseJSON(data);
                if (msg == 'nameError') {
                    $('#loginName').focus();
                    alert('<s:text name="index_0279"/>');
                    return false;
                }else if (msg == 'pwdError') {
                    $('#loginPwd').focus();
                    alert('<s:text name="index_0280"/>');
                    return false;
                }else if (msg == 'success') {

                  /*  if ($("#remember").attr("checked") == "checked") {*/
                        var userName = $("#loginName").val();
                        var passWord = $("#loginPwd").val();
              /*          $.cookie("remember", "true", { expires: 7 });*/
                        $.cookie("userName", userName, { expires: 7 });
                        $.cookie("passWord", passWord, { expires: 7 });
               /*     } else {
                        $.cookie("remember", "false", { expires: -1 });        // 删除 cookie
                        $.cookie("userName", '', { expires: -1 });
                        $.cookie("passWord", '', { expires: -1 });
                    }*/

                    //登录成功 跳转至 index.jsp
                    if(loginByUrl != null && loginByUrl != ''){
                        window.location.href = loginByUrl;
                    }else{
                        window.location.href = "/";
                    }
                    return true;
                }
            }
        });
    }
</script>
</html>