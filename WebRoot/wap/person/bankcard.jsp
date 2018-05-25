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
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="/person/toZhanghuguanli.html"></a>
    <h1 class="mui-title">银行卡管理</h1>
</header>
<div id="OA_task_1" class="mui-content">
    <c:if test="${empty bankcardList}">
        <div style="text-align: center;"><img style="margin-top: 80px" src="images/wujilu.jpg"/></div>
    </c:if>
    <c:if test="${not empty bankcardList}">
        <c:forEach items="${bankcardList}" var="bankcard">
            <div class="vip_box">
                <div class="mui-content-padded">
                    <div>${bankcard.name}   **** **** **** ${bankcard.cardNumber}</div>
                    <div class="mt05">${bankcard.openBank}</div>
                </div>
                <div class="mui-table-view-cell mui-radio address">
                    <c:if test="${bankcard.isDefault==true}">
                        <td><input name="radio" type="radio" checked="checked" onclick="setDefault('${bankcard.id}')" /> 设为默认</td>
                    </c:if>
                    <c:if test="${bankcard.isDefault==false}">
                        <td><input name="radio" type="radio" onclick="setDefault('${bankcard.id}')"/> 设为默认</td>
                    </c:if>
                </div>
                <div class="address_but color_666">
                    <a href="showEditBankcard/${bankcard.id}.html"><em class="iconfont">&#xe609;</em> 编辑</a>
                    <span class="mui-btn" onclick="delBankcard('${bankcard.id}')"><em class="iconfont">&#xe624;</em> 删除</span>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
<div class="mui-content-padded">
    <a href="showAddBankcard.html" class="vip_but mg0">+ 新增银行卡</a>
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

    //设置默认
    function setDefault(id){
        $(this).attr("checked","checked");
        $.ajax({
            url : "memberCallAction!setDefaultBankcard.action",
            type : "POST",
            data : "id="+id,
            dataType : "JSON",
            success : function(){
                window.location.href="showBankcard.html";
            }
        });
    }

    //删除银行卡
    function delBankcard(id){
        if(confirm("<s:text name='index_0326'/>?")){
            $.ajax({
                url : "memberCallAction!delBankcard.action",
                type : "POST",
                data : "id="+id,
                dataType : "JSON",
                success : function(){
                    window.location.href="showBankcard.html";
                }
            });
        }
    }

</script>
</html>

