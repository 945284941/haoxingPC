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
<div id="pullrefresh" class="mui-content mui-scroll-wrapper pt45">
    <div class="mui-scroll">
        <div class="mui-row shop_box">
            <div class="mui-col-sm-2 mui-col-xs-2 shop_img"><img src="${company.companyLogo}" style="width:58.66px;height:58.66px;" /></div>
            <div class="mui-col-sm-6 mui-col-xs-6 shop_tex">
                <h3>${company.shoperName}</h3>
                <div class="procon_tex_tb" style="position: relative;">
                    <c:if test="${'like' eq hobby}">
                    <a class="mui-text-center" ><span class="iconfont like hreat">&#xe61d;</span></a>
                    </c:if>
                    <c:if test="${'disLike' eq hobby}">
                        <a class="mui-text-center" onclick="updateMemberCollect('${company.id}')"><span class="iconfont dislike hreat">&#xe61d;</span></a>
                    </c:if>
                    <a class="mui-text-center"><span class="iconfont">&#xe62b;</span></a>
                </div>
            </div>
            <div class="mui-col-sm-4 mui-col-xs-4 mui-text-right shop_ewm"><img src="/wap/images/2Dbarcode.png" /></div>
        </div>
        <div class="shop_list">
            <ul>
                <li>
                    <a  id="Recommend" onclick="goodsOrdering()">推荐</a>
                </li>
                <li>
                    <a  id="salesVolume" onclick="goodsOrdering()">销量 <i class="iconfont">&#xe618;</i></a>
                </li>
                <li>
                    <a  id="newProduct" onclick="goodsOrdering()">新品</a>
                </li>
                <li>
                    <a  id="price" onclick="goodsOrdering()">价格 <i class="iconfont">&#xe81b;</i></a>
                </li>
            </ul>
        </div>
        <ul class="mui-table-view mui-table-view-chevron product product2">
           <c:forEach items="${goods}" var="good">
            <li class="mui-table-view-cell">
                <a href="">
                    <div class="product_img">
                        <img src="${good.defaultPicSrc}"  style="width:161px;height:161px;"/>
                        <p>仅剩${good.store}件</p>
                        <span>抢购</span>
                    </div>
                    <div class="product_tex">
                        <p>${good.name}</p>
                        <div class="clearfix buying_tex">
                            <div class="mui-pull-left">
                                <p>￥<em>¥${good.price}</em></p>
                                <s>￥<em>${good.yuanjia}</em></s>
                            </div>
                            <div class="mui-pull-right mui-text-right">
                                <p class="fn09">$<em>${good.USAMoney}</em></p>
                                <p class="fn09">AED<em>${good.ADMMoney}</em></p>
                            </div>
                        </div>
                        <div class="clearfix color_999">
                            <p class="mui-pull-left">${good.queryNum}<em>1212</em></p>
                            <p class="mui-pull-right">好评<em>${good.praiseRate}%</em></p>
                        </div>
                    </div>
                </a>
            </li>
           </c:forEach>
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
   mui('.hreat').on('tap',function () {
       alert(1)
   })


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
      /*      for(var i = cells.length, len = i + 5; i < len; i++) {
                var li = document.createElement('li');
                li.className = 'mui-table-view-cell';
                li.innerHTML = '<li class="mui-table-view-cell">New Slide' + (i + 1) + '</li>';

                table.appendChild(li);
            }*/
            $.ajax({
                url:'',
                data:{

                },
                dataType:'json',
                success:function (_data) {

                }

            })
        }, 1500);
    }
</script>
<script type="text/javascript" charset="utf-8">
    var active = null,
        lastid, span;
/*    mui(".mui-content").on("tap", "a", function() {
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
    });*/

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
