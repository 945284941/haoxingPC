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
<!--头部-->
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title">提现申请</h1>
    <a id='confirmBtn' class="mui-icon mui-icon-left-nav mui-pull-left" href="personalInfo/fenxiaoCenter.html"></a>
    <a class="mui-btn mui-btn-link mui-pull-right" href="personalInfo/tixianjilu.html"><span class="color_999">提现记录</span></a>
</header>
<div class="mui-content">
    <div class="app_box3">可提现金额：
        ￥<fmt:formatNumber type="number" value="${1 * me.advance}" pattern="0.00" maxFractionDigits="2"/>
        ($<fmt:formatNumber type="number" value="${huilv.now_rate_doc * me.advance}" pattern="0.00" maxFractionDigits="2"/>
        AED<fmt:formatNumber type="number" value="${huilv.now_rate_dlm * me.advance}" pattern="0.00" maxFractionDigits="2"/>)
    </div>
    <p class="title">选择支付币种</p>
    <form class="mui-input-group">
        <div class="mui-input-row mui-radio">
            <label class="color_666">人民币（CNY）</label>
            <input name="marketable" type="radio" id="china" checked="checked">
        </div>
        <div class="mui-input-row mui-radio">
            <label class="color_666">美元（USD）</label>
            <input name="marketable" type="radio" id="USD">
        </div>
        <div class="mui-input-row mui-radio">
            <label class="color_666">迪拉姆（AED）</label>
            <input name="marketable" type="radio" id="AED" >
        </div>
    </form>
    <p class="title">
        <span class="color_666">到账银行卡</span>
        <span class="mui-pull-right">
            <select class="yinhk" name="">>
                <c:forEach items="${ban}" var="b">
                <option value="">招商银行(8040)</option>
                </c:forEach>
            </select>
        </span>
    </p>
    <div class="app_box3">
        <div>提现金额</div>
        <div class="mt05">￥ <input class="tixian" type="text" name="bn" id="money"/> </div>
        <div class="zhushi">手续费（个人所得税及管理费）：2.00元<br /> 每次提现最低金额￥100.00<br />每日最高提现金额￥50000.00
            <br /> 实际收款金额：￥98.00
        </div>
    </div>
    <div class="mui-content-padded">
        <button class="vip_but" onclick="baby('${me.id}')">提交申请</button>
    </div>
</div>
<!--底部导航栏 -->
<%--<jsp:include page="/wap/index/indexFooter.jsp"></jsp:include>--%>

<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">

    mui('body').on('tap','a',function(){
        window.top.location.href=this.href;
    });
    function  baby(id) {
        var jm=$('#money').val();
        var hl;
        var symbol;
        if(jm<100){
            alert("大于100元才能提现");
            return;
        };
        if(jm>${me.advance}){
            alert("提现金额不足，请重新输入！");
            return;
        };
        $('input[name="marketable"]').each(function () {
            var  moneyType= $(this).attr("id");

            if($(this).is(':checked')) {
                if (moneyType == 'china') {
                    hl = 1;
                    symbol = "元";
                }
                if (moneyType == 'USD') {
                    hl = ${huilv.now_rate_doc};
                    symbol = "美元";
                }
                if (moneyType == 'AED') {
                    hl = ${huilv.now_rate_dlm};
                    symbol = "迪拉姆";
                }
            }
        });
        var barkCard=$('#bankCard').val();
        var tixian=jm*hl;
        var handMoney=jm*hl*${fee};
        tixian=tixian-handMoney;

        if(window.confirm('手续费为'+handMoney+symbol+'将要到账金额为'+tixian+symbol+'')){
            $.ajax({
                url:'shenqing!insertSelective.action',
                type:'POST',
                data:{
                    id:id,
                    amount:jm,
                    realAmount:tixian,
                    barndCard:barkCard,
                    liucunAmount:handMoney
                },
//                method:'post',
                dataType:'json',
                success : function (data) {
                    var msg = $.parseJSON(data);
                    if(msg == 'success'){
                        alert("申请成功");
                        document.location.reload();
                    }else{
                        alert("申请失败");
                    }
                }
            });
        };
    }

</script>
</html>

