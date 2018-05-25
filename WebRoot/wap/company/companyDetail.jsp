<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="/wap/css/mui.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/wap/font/iconfont.css" />
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
        .like{
            color:red;
        }
        .dislike{
            color:black;
        }
    </style>
</head>

<body>
<!--头部-->
<header class="mui-bar mui-bar-nav">
    <!-- 搜索框-->
    <div class="search_box">
        <input type="text" name="" id="" value="女装" />
    </div>

    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <div class="addPopover_2" style="position: relative;">
        <a href="#Popover_2" id="meau" class="mui-icon mui-pull-right iconfont">&#xe617;</a>
        <div id="Popover_2" class="mui-popover mui-bar-popover meau_down" style="top: 44px !important;">
            <div class="mui-popover-arrow"></div>
            <ul class="">
                <li class="mui-table-view-cell">
                    <a href="/"><i class="iconfont">&#xe604;</i> 首页</a>
                </li>
                <li class="mui-table-view-cell">
                    <a href=""><i class="iconfont">&#xe600;</i>分类搜索</a>
                </li>
                <li class="mui-table-view-cell">
                    <a href="5.1购物车管理.html"><i class="iconfont">&#xe778;</i>购物车</a>
                </li>
                <li class="mui-table-view-cell">
                    <a href=""><i class="iconfont">&#xe66e;</i>我的</a>
                </li>
            </ul>
        </div>
    </div>
</header>

<div class="mui-content">
    <div class="mui-row app_box3">
        <div class="mui-col-sm-2 mui-col-xs-2 shop_img"><img src="${company.companyLogo}" style="width:58.66px;height:58.66px;" /></div>
        <div class="mui-col-sm-6 mui-col-xs-6 shop_tex">
            <h3>${company.shoperName}</h3>
            <p class="color_666">${company.combrief}</p>
        </div>
        <div class="mui-col-sm-4 mui-col-xs-4 shop_img">
            <div class="procon_tex_tb mui-text-right" style="position: relative;">
                <c:if test="${'like' eq hobby}">
                    <a  onclick="updateMemberCollect('${company.id}')"><span class="iconfont like hreat">&#xe61d;</span></a>
                </c:if>
                <c:if test="${'disLike' eq hobby}">
                    <a onclick="updateMemberCollect('${company.id}')"><span class="iconfont dislike hreat" >&#xe61d;</span></a>
                </c:if>
                <a><span class="iconfont">&#xe62b;</span></a>
            </div>
        </div>
    </div>
    <div class="app_box3 mt05 mui-row mui-text-center linheg26">
        <div class="mui-col-sm-4 mui-col-xs-4">
            <span>${goodsNum}</span><br />
            <span>全部商品</span>
        </div>
        <div class="mui-col-sm-4 mui-col-xs-4">
            <span id="followNum">${followNum}</span><br />
            <span>关注量</span>
        </div>
        <div class="mui-col-sm-4 mui-col-xs-4">
            <span>${praiseRate}</span><br />
            <span>商品评分</span>
        </div>
    </div>
    <div class="app_box2 mt05 linheg26">
        <ul class="mui-table-view">
            <li class="mui-table-view-cell tanchu_but">
                <div class="list_left">商家电话</div>
                <div class="list_right">
                    <span class="mui-pull-right iconfont">&#xe656;</span>
                    <p class="tanchu">${company.telphone}</p>
                </div>

            </li>
            <li class="mui-table-view-cell tanchu_but">
                <div class="list_left">商家邮箱</div>
                <div class="list_right">
                    <span class="mui-pull-right iconfont">&#xe60a;</span>
                    <p class="tanchu">${company.email}</p>
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="list_left">店铺简介</div>
                <div class="list_right">
                    <span class="color_666">${company.shoperContent}</span>
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="list_left">公司名称</div>
                <div class="list_right"><span class="color_666">${company.companyName}</span></div>
            </li>
            <li class="mui-table-view-cell">
                <div class="list_left">所在地址</div>
                <div class="list_right"><span class="color_666">${company.address}</span></div>
            </li>
            <li class="mui-table-view-cell">
                <div class="list_left">开店时间</div>
                <div class="list_right"><span class="color_666 ml1">${company.openTime}</span></div>
            </li>
            <li class="mui-table-view-cell">
                <div class="">授权品牌</div>
                <div>
                    <c:forEach items="${company.imgList}" var="imgs" >
                          <img class="shop_logo2" src="${imgs}" style="width:64px;height: 64px;" />
                    </c:forEach>

                </div>
            </li>
        </ul>
    </div>
</div>

<script src="/wap/js/mui.min.js"></script>
<script src="/wap/js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
    mui.init({
        pullRefresh: {
            container: '#pullrefresh',
            down: {
                callback: pulldownRefresh
            },
            up: {
                contentrefresh: '正在加载...',
                callback: pullupRefresh
            }
        }
    });

    function pulldownRefresh() {
        setTimeout(function() {
            var table = document.body.querySelector('.mui-table-view');
            var cells = document.body.querySelectorAll('.mui-table-view-cell');
            for(var i = cells.length, len = i + 3; i < len; i++) {
                var li = document.createElement('li');
                li.className = 'mui-table-view-cell';
                li.innerHTML = '<li class="mui-table-view-cell">New Slide' + (i + 1) + '</li>';
                //下拉刷新，新纪录插到最前面；
                table.insertBefore(li, table.lastChild);
            }
            mui('#pullrefresh').pullRefresh().endPulldownToRefresh(); //refresh completed
        }, 1500);
    }
    var count = 0;

    function pullupRefresh() {
        setTimeout(function() {
            mui('#pullrefresh').pullRefresh().endPullupToRefresh((++count > 2)); //参数为true代表没有更多数据了。
            var table = document.body.querySelector('.mui-table-view');
            var cells = document.body.querySelectorAll('.mui-table-view-cell');
            for(var i = cells.length, len = i + 5; i < len; i++) {
                var li = document.createElement('li');
                li.className = 'mui-table-view-cell';
                li.innerHTML = '<li class="mui-table-view-cell">New Slide' + (i + 1) + '</li>';

                table.appendChild(li);
            }
        }, 1500);
    }
</script>
<script type="text/javascript" charset="utf-8">
    var active = null,
        lastid, span;
    mui(".mui-content").on("tap", "a", function() {
        var id = this.getAttribute("id");
        if(!active) {
            this.classList.add("active");
            if(id) {
                span = this.querySelector("span");
                span.classList.remove("mui-" + id);
                span.classList.add("mui-" + id + "-filled");
            }
            active = this;
        } else {
            active.classList.remove("active");
            if(lastid) {
                span.classList.remove("mui-" + lastid + "-filled");
                span.classList.add("mui-" + lastid);
            }

            this.classList.add("active");
            if(id) {
                span = this.querySelector("span");
                span.classList.remove("mui-" + id);
                span.classList.add("mui-" + id + "-filled");
            }

            active = this;
        }
        lastid = id;
    });
    function updateMemberCollect(id){

        var action="";
        if($('.hreat').hasClass('like')){
            action="delete";
        }else {
            action = "add";
        }

        $.ajax({
            url:'/follow.html',
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
                    mui.alert(_data.msg,'提示');
                    if(action=='add'){
                        $(".hreat").removeClass('dislike');
                        $(".hreat").addClass("like");
                        $('#followNum').text(_data.obj);
                    }else{
                        $(".hreat").removeClass('like');
                        $(".hreat").addClass("dislike");
                        $('#followNum').text(_data.obj);
                    }
                }else{
                    mui.alert(_data.msg,'提示');
                }
            }
        })
    }
</script>
</body>

</html>