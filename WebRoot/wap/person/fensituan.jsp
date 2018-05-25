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
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="personalInfo/fenxiaoCenter.html"></a>
    <h1 class="mui-title">粉丝团</h1>
</header>
<div class="mui-content">
    <div class="mt1p">
        <ul class="mui-table-view">
            <c:if test="${empty memberListNew}">
                <div style="text-align: center;"><img style="margin-top: 80px;" src="images/wujilu.jpg"/></div>
            </c:if>
            <c:if test="${not empty memberListNew}">
                <c:forEach items="${memberListNew}" var="member">
                    <li class="mui-table-view-cell">
                        <a >
                                ${member.username}
                            <span class="mui-pull-right color_999"><fmt:formatDate value="${member.regTime}" pattern="yyyy-MM-dd"/></span>
                        </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
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

