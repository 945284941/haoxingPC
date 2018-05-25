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
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" href="/person/toShowBasicInfo.html"></a>
    <h1 class="mui-title">编辑个人资料</h1>
</header>
<div class="mui-content">
    <ul class="buy_list">
        <li>
            <div class="list_left">姓名</div>
            <div class="list_right color_666">
                <input class="buy_input" type="text" name="" id="" value="" placeholder="张先生" />
            </div>
        </li>
        <li>
            <div class="list_left">证件号</div>
            <div class="list_right color_666 mui-text-right">
                <input class="buy_input" type="text" name="" id="" value="" placeholder="12121212" />
                <div class="idcard_box">
                    <div class="idcard idcard2" id="sss">
                        <img class="acc_imgin" src="images/ID_card_front.png" id="img0">
                        <input type="file" name="file0" id="file0" multiple class="ph08" />
                    </div>
                    <div class="idcard idcard2" id="sss">
                        <img class="acc_imgin" src="images/ID_card_reverse.png" id="img1">
                        <input type="file" name="file0" id="file1" multiple class="ph08" />
                    </div>
                </div>
            </div>
        </li>
        <li>
            <div class="list_left">性别</div>
            <div class="list_right color_666 mui-text-right">
                <input class="buy_input" type="text" name="" id="" value="" placeholder="女" />
            </div>
        </li>
        <li>
            <div class="list_left">年龄</div>
            <div class="list_right color_666 mui-text-right">
                <input class="buy_input" type="text" name="" id="" value="" placeholder="27" />
            </div>
        </li>
        <li>
            <div class="list_left">生日</div>
            <div class="list_right color_666 mui-text-right">
                <input class="buy_input" type="text" name="" id="" value="" placeholder="1990/05/02" />
            </div>
        </li>
        <li>
            <div class="list_left">手机</div>
            <div class="list_right color_666 mui-text-right">
                <input class="buy_input" type="text" name="" id="" value="" placeholder="13812345678" />
            </div>
        </li>
        <li>
            <div class="list_left">邮箱</div>
            <div class="list_right color_666 mui-text-right">
                <input class="buy_input" type="text" name="" id="" value="" placeholder="165165@163.com" />
            </div>
        </li>
        <li>
            <div class="list_left">QQ</div>
            <div class="list_right color_666 mui-text-right">
                <input class="buy_input" type="text" name="" id="" value="" placeholder="46546515" />

            </div>
        </li>
        <li>
            <div class="list_left">微信</div>
            <div class="list_right color_666 mui-text-right">
                <input class="buy_input" type="text" name="" id="" value="" placeholder="13812345678" />

            </div>
        </li>
        <li>
            <div class="list_left">地区</div>
            <div class="list_right color_666 mui-text-right">
                <input class="buy_input" type="text" name="" id="" value="" placeholder="济南" />

            </div>
        </li>
    </ul>
    <div class="mui-content-padded">
        <button class="vip_but mg0">保存</button>
    </div>
</div>
<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
</body>
<script  type="text/javascript">
    mui('body').on('tap','a',function(){
        window.top.location.href=this.href;
    });

    mui.init();
    $(function() {
        $(".acc_sure").on("click", function() {
            alerths("请等待审核！")
            return false;
        })
        $("#file0").change(function() {
            if(this.files && this.files[0]) {
                var objUrl = getObjectURL(this.files[0]);
                console.log("objUrl = " + objUrl);
                if(objUrl) {
                    $("#img0").attr("src", objUrl);
                    $("#file0").click(function(e) {
                        $("#img0").attr("src", objUrl);
                    });
                } else {
                    //IE下，使用滤镜
                    this.select();
                    var imgSrc = document.selection.createRange().text;
                    var localImagId = document.getElementById("sss");
                    //图片异常的捕捉，防止用户修改后缀来伪造图片
                    try {
                        preload.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = data;
                    } catch(e) {
                        this._error("filter error");
                        return;
                    }
                    this.img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src=\"" + data + "\")";
                }
            }
        });
        $("#file1").change(function() {
            if(this.files && this.files[0]) {
                var objUrl = getObjectURL(this.files[0]);
                console.log("objUrl = " + objUrl);
                if(objUrl) {
                    $("#img1").attr("src", objUrl);
                    $("#file1").click(function(e) {
                        $("#img0").attr("src", objUrl);
                    });
                } else {
                    //IE下，使用滤镜
                    this.select();
                    var imgSrc = document.selection.createRange().text;
                    var localImagId = document.getElementById("sss");
                    //图片异常的捕捉，防止用户修改后缀来伪造图片
                    try {
                        preload.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = data;
                    } catch(e) {
                        this._error("filter error");
                        return;
                    }
                    this.img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src=\"" + data + "\")";
                }
            }
        });
        //建立一個可存取到該file的url
        function getObjectURL(file) {
            var url = null;
            if(window.createObjectURL != undefined) { // basic
                url = window.createObjectURL(file);
            } else if(window.URL != undefined) { // mozilla(firefox)
                url = window.URL.createObjectURL(file);
            } else if(window.webkitURL != undefined) { // webkit or chrome
                url = window.webkitURL.createObjectURL(file);
            }
            return url;
        }
    })

</script>
</html>