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
    </style>
</head>

<body>
<!-- top -->
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toPersionLogo" executeResult="true" namespace="/"></s:action>
<!-- heard结束 -->

<div style="background: #f6f6f6;">
    <div class="main">
        <div class="h_seat">
            <a href="">首页</a>&gt;
            <a href="">买家中心</a>
        </div>
        <!--我是买家-->
        <div class="h_content">
            <div class="l-fl">
                <h3><s:text name="index_0258"/></h3>
                <dl>
                    <dt><s:text name="index_0259"/></dt>
                </dl>
                <dl>
                    <dt><s:text name="index_0267"/></dt>
                </dl>
                <dl>
                    <dt><s:text name="index_0260"/></dt>
                </dl>
                <dl onclick="noticelist()">
                    <dt><s:text name="index_0007"/></dt>
                </dl>
            </div>
            <div class="w-buyers">
                <div class="l-fr">
                    <div class="w-title">
                        <h3>
                            ${news.firstTitle}
                        </h3>
                    </div>
                    <div class="xiangqing" style="overflow: hidden;">
                        ${news.content}
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--我是买家-->


<!--footer开始-->
<s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
<!--footer结束-->
<script type="text/javascript">
    function noticelist(){
        window.location.href="news/news!noticeList.action";
    }
</script>
</body>

</html>