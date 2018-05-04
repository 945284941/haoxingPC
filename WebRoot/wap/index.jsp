<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
		<base href="<%=basePath%>" />
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<link href="/wap/css/mui.min.css" rel="stylesheet" />
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
			<div class="search_box">
				<input type="text" name="" id="" value="" placeholder="搜索" />
				<span class="RichScan iconfont">&#xe605;</span>
			</div>
			<a class=" mui-icon mui-pull-right iconfont">&#xe67a;</a>
			<a class=" mui-icon mui-pull-left iconfont">&#xe613;</a>
		</header>
		<div id="pullrefresh" class="mui-content mui-scroll-wrapper pad0">
			<div class="mui-scroll">
				<!--图片轮播-->
				<div id="slider" class="mui-slider">
					<div class="mui-slider-group mui-slider-loop">
						<div class="mui-slider-item mui-slider-item-duplicate">
							<a href="#">
								<img src="/wap/images/banner.png">
							</a>
						</div>
						<div class="mui-slider-item">
							<a href="#">
								<img src="/wap/images/banner.png">
							</a>
						</div>
						<div class="mui-slider-item">
							<a href="#">
								<img src="/wap/images/banner.png">
							</a>
						</div>
						<div class="mui-slider-item">
							<a href="#">
								<img src="/wap/images/banner.png">
							</a>
						</div>
						<div class="mui-slider-item">
							<a href="#">
								<img src="/wap/images/banner.png">
							</a>
						</div>
						<div class="mui-slider-item mui-slider-item-duplicate">
							<a href="#">
								<img src="/wap/images/banner.png">
							</a>
						</div>
					</div>
					<div class="mui-slider-indicator banner_point">
						<div class="mui-indicator mui-active"></div>
						<div class="mui-indicator"></div>
						<div class="mui-indicator"></div>
						<div class="mui-indicator"></div>
					</div>
				</div>
				<!--分类导航-->

				<s:action name="catalogueAction!queryFullMenu" executeResult="true" namespace="/" />


				<!--公告-->
				<div class="news_box mui-row">
					<div class="mui-col-sm-9 mui-col-xs-8 index_notice_box">
						<h3>今日公告</h3>

						<s:action name="indexFloorAction!showIndexShoppingFloor" namespace="/indexFloor" executeResult="true"/>

					</div>
					<div class="mui-col-sm-3 mui-col-xs-4 parities">
						<p>汇率</p>
						<p>￥1=$0.1516</p>
						<p>￥1=AED1111</p>
					</div>
				</div>
				<!--限时抢购-->
				<div class="buying">
					<h3>限时抢购  <a href="" class="mui-pull-right">更多&gt;&gt;</a></h3>
					<div class="swiper-container swiper-container-horizontal swiper-container-free-mode buying_slider">
						<div class="swiper-wrapper">
							<div class="swiper-slide">
								<a href="#"><img class="mui-media-object" src="/wap/images/buying.png">
									<div class="clearfix buying_tex">
										<div class="mui-pull-left">
											<p>￥29.9</p>
											<s>￥36.9</s>
										</div>
										<div class="mui-pull-right mui-text-right">
											<p class="fn09">$30.00</p>
											<p class="fn09">AED3000.00</p>
										</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a href="#"><img class="mui-media-object" src="/wap/images/buying.png">
									<div class="clearfix buying_tex">
										<div class="mui-pull-left">
											<p>￥29.9</p>
											<s>￥36.9</s>
										</div>
										<div class="mui-pull-right mui-text-right">
											<p class="fn09">$30.00</p>
											<p class="fn09">AED3000.00</p>
										</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a href="#"><img class="mui-media-object" src="/wap/images/buying.png">
									<div class="clearfix buying_tex">
										<div class="mui-pull-left">
											<p>￥29.9</p>
											<s>￥36.9</s>
										</div>
										<div class="mui-pull-right mui-text-right">
											<p class="fn09">$30.00</p>
											<p class="fn09">AED3000.00</p>
										</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a href="#"><img class="mui-media-object" src="/wap/images/buying.png">
									<div class="clearfix buying_tex">
										<div class="mui-pull-left">
											<p>￥29.9</p>
											<s>￥36.9</s>
										</div>
										<div class="mui-pull-right mui-text-right">
											<p class="fn09">$30.00</p>
											<p class="fn09">AED3000.00</p>
										</div>
									</div>
								</a>
							</div>
						</div>
					</div>
				</div>
				<!--广告位-->
				<div class="ad_box">
					<div class=" mui-row">
						<div class="mui-col-sm-6 mui-col-xs-6 index_ad"><img src="/wap/images/ad1.png" /></div>
						<div class="mui-col-sm-6 mui-col-xs-6 index_ad"><img src="/wap/images/ad1.png" /></div>
						<div class="mui-col-sm-6 mui-col-xs-6 index_ad"><img src="/wap/images/ad3.png" /></div>
						<div class="mui-col-sm-6 mui-col-xs-6 index_ad"><img src="/wap/images/ad4.png" /></div>
						<div class="index_ad"><img src="images/ad5.png" /></div>
					</div>
					<div class="mui-row">
						<div class="mui-col-sm-5 mui-col-xs-5 index_ad"><img src="/wap/images/ad6.png" /></div>
						<div class="mui-col-sm-7 mui-col-xs-7 mui-row index_ad">
							<div class="mui-col-sm-12 mui-col-xs-12"><img src="/wap/images/ad7.png" /></div>
							<div style="padding-right: 0.25rem;" class="mui-col-sm-6 mui-col-xs-6"><img src="/wap/images/ad8.png" /></div>
							<div style="padding-left: 0.25rem;" class="mui-col-sm-6 mui-col-xs-6"><img src="/wap/images/ad9.png" /></div>
						</div>
					</div>
				</div>

				<!--商品推荐-->
				<div class="product_box">
					<h3>商品推荐</h3>
					<!--数据列表-->
					<ul class="mui-table-view mui-table-view-chevron product product2 o_hidden">
						<li class="mui-table-view-cell">
							<a href="">
								<div class="product_img">
									<img src="/wap/images/product.png" />
									<p>仅剩3件</p>
									<span>抢购</span>
								</div>
								<div class="product_tex">
									<p>加厚法莱绒床笠</p>
									<div class="clearfix buying_tex">
										<div class="mui-pull-left">
											<p>￥<em>29.9</em></p>
											<s>￥<em>36.9</em></s>
										</div>
										<div class="mui-pull-right mui-text-right">
											<p class="fn09">$<em>30.00</em></p>
											<p class="fn09">AED<em>3000.00</em></p>
										</div>
									</div>
									<div class="clearfix color_999">
										<p class="mui-pull-left">销量<em>1212</em></p>
										<p class="mui-pull-right">好评<em>98%</em></p>
									</div>
								</div>
							</a>
						</li>
						<li class="mui-table-view-cell">
							<a href="">
								<div class="product_img">
									<img src="/wap/images/product.png" />
									<p>仅剩3件</p>
									<span>抢购</span>
								</div>
								<div class="product_tex">
									<p>加厚法莱绒床笠</p>
									<div class="clearfix buying_tex">
										<div class="mui-pull-left">
											<p>￥<em>29.9</em></p>
											<s>￥<em>36.9</em></s>
										</div>
										<div class="mui-pull-right mui-text-right">
											<p class="fn09">$<em>30.00</em></p>
											<p class="fn09">AED<em>3000.00</em></p>
										</div>
									</div>
									<div class="clearfix color_999">
										<p class="mui-pull-left">销量<em>1212</em></p>
										<p class="mui-pull-right">好评<em>98%</em></p>
									</div>
								</div>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<nav class="mui-bar mui-bar-tab my_foot">
			<a class="mui-tab-item mui-active" href="#">
				<span class="mui-icon iconfont">&#xe604;</span>
				<span class="mui-tab-label">首页</span>
			</a>
			<a class="mui-tab-item" href="#">
				<span class="mui-icon iconfont">&#xe6fa;</span>
				<span class="mui-tab-label">分类</span>
			</a>
			<a class="mui-tab-item" href="#">
				<img class="foot_avatar" src="/wap/images/avatar.jpg" />
			</a>
			<a class="mui-tab-item" href="#">
				<span class="mui-icon iconfont">&#xe778;</span>
				<span class="mui-tab-label">购物车</span>
			</a>
			<a class="mui-tab-item" href="#">
				<span class="mui-icon iconfont">&#xe6be;</span>
				<span class="mui-tab-label">中文</span>
			</a>
		</nav>
		<script src="/wap/js/mui.min.js"></script>
		<script src="/wap/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
		<script>
			//			限时抢购
			var buying_slider = new Swiper('.buying_slider', {
				slidesPerView: 2.2,
				spaceBetween: 10,
				freeMode: true,
				pagination: {
					clickable: true,
				},
			}); //			今日公告
			var index_notice = new Swiper('.index_notice', {
				spaceBetween: 30,
				centeredSlides: true,
				autoplay: {
					delay: 2500,
					disableOnInteraction: false,
				},
				navigation: {
					nextEl: '.swiper-button-next',
					prevEl: '.swiper-button-prev',
				},
			});
		</script>
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
	</body>

</html>