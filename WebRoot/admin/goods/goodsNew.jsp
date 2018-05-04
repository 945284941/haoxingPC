<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ResourceUtil.getSessionInfoName());
	String memberId = sessionInfo == null ? "" : sessionInfo.getUserId();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
	<title>商品信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta http-equiv="keywords" content="颐佳,商城">
	<meta http-equiv="description" content="颐佳,商城">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="web/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="web/css/sghsc-main.css">
	<link rel="stylesheet" href="web/css/sghsc-deta.css">

	<%-- <script type="text/javascript" src="web/js/jquery-1.2.6.pack.js"></script>
	<script type="text/javascript" src="web/js/base.js"></script> --%>
	
	<jsp:include page="/admin/common/keyWords.jsp" />
	
	<%-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="x-ua-compatible" content="ie=7" />
	<link rel="stylesheet" href="web/bootstrap/bootstrap.min.css" type="text/css"></link>
	<link rel="stylesheet" href="web/css/base.css" type="text/css"></link>
	<link rel="stylesheet" href="web/fonts/iconfont.css" type="text/css"></link>
	<link href="web/css/xiangqing.css" rel="stylesheet" type="text/css" />
	<link href="web/css/liebiaoye.css" rel="stylesheet" type="text/css" />
	<link href="css/goods.css" rel="stylesheet" type="text/css"> --%>
	<SCRIPT src="js/jquery-1.8.0.min.js" type=text/javascript></SCRIPT>
	
	<script type="text/javascript" src="js/qlzy.js"></script>
	<script>
		$(function() {
			var lc = parseInt($('#gd-lastCount').text());
			console.log(lc);
			if (lc == 0) {
				$('#buynowBtn').attr('disabled', 'disabled');
				$('#toGouwucheBtn').attr('disabled', 'disabled');
			}
		});
		var goodsId = "${goods.id}";
		$(function() {
			//成交记录
			$.ajax({
				type : 'post',
				url : 'call/buyRecord.html',
				dataType : 'json',
				data : {
					"goodsId" : goodsId
				},
				success : function(item) {
					var buyRecordTitle = "<ul class=\"sghsc-deta-2-rit-xq-jl\"><li class=\"sghsc-deta-2-rit-xq-jl-li1\">会员账号</li><li class=\"sghsc-deta-2-rit-xq-jl-li1\">购买数量</li><li class=\"sghsc-deta-2-rit-xq-jl-li3\">成交时间</li></ul>";
					for (var i = 0; i < item.length; i++) {
						var name = pwdUserName(item[i].companyName,
								item[i].memberName);
						buyRecordTitle = buyRecordTitle
								+ "<ul class=\"sghsc-deta-2-rit-xq-jl2\"><li class=\"sghsc-deta-2-rit-xq-jl-li1\">" + name
								+ "<li/><li class=\"sghsc-deta-2-rit-xq-jl-li1\">"
								+ item[i].nums
								+ "<li/><li class=\"sghsc-deta-2-rit-xq-jl-li3\">"
								+ item[i].createtime + "</li></ul>";
					}
					$("#SwitchSxBt2_cont_1").append(buyRecordTitle);
				},
				error : function() {
					$("#SwitchSxBt2_cont_1").append(buyRecordTitle);
				}
			});
	
			//商品评论
			$.ajax({
				type : 'post',
				url : 'call/goodsApprakise.html',
				dataType : 'json',
				data : {
					"goodsId" : goodsId
				},
				success : function(apprakise) {
					var apprakiseTitle = "<ul class=\"sghsc-deta-2-rit-xq-jl\"><li class=\"sghsc-deta-2-rit-xq-jl-li1\">会员账号</li><li class=\"sghsc-deta-2-rit-xq-jl-li1\">评论内容</li><li class=\"sghsc-deta-2-rit-xq-jl-li3\">成交时间</li></ul>";
					for (var i = 0; i < apprakise.length; i++) {
						var name = pwdUserName(apprakise[i].companyName,
								apprakise[i].memberName);
						apprakiseTitle = apprakiseTitle
								+ "<ul class=\"sghsc-deta-2-rit-xq-jl2\"><li class=\"sghsc-deta-2-rit-xq-jl-li1\">"
								+ name + "<li/><li class=\"sghsc-deta-2-rit-xq-jl-li1\">"
								+ apprakise[i].content
								+ "<li/><li class=\"sghsc-deta-2-rit-xq-jl-li3\">"
								+ apprakise[i].createtime + "</li></ul>";
					}
					$("#SwitchSxBt2_cont_2").append(apprakiseTitle);
				},
				error : function() {
					$("#SwitchSxBt2_cont_2").append(apprakiseTitle);
				}
			});
		});
		function name() {
			var url = location.href;
			var strs = new Array();
			strs = url.split("#");
			if (strs.length == 2) {
				var divId = strs[1];
				alert(divId);
				var t = $("#" + divId).offset().top;
				$(window).scrollTop(t);
			}
		}
	</script>
</head>
<body>
 <div id="goodsType" style="display:none;">${goods.goodstype }</div>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<jsp:include page="../common/navigation.jsp"></jsp:include>
<div class="sghsc-deta-box">
<div id=preview>
	<div class=jqzoom id=spec-n1 onClick="">
		<IMG src="${goods.defaultPicSrc }" jqimg="${goods.defaultPicSrc }" width=420 height=420>
	</div>
	<div id=spec-n5>

		<div id=spec-list>
			<ul class=list-h>
				<s:iterator value="goods.img" var="img">
					<li><img src="<s:property value="img"/>"></li>
				</s:iterator>
			</ul>
		</div>

		
    </div>
    <div class="sghsc-deta-1-sc" >
		<a href="javascript:void(0);" onclick="mark('${goods.id }','1','<%= memberId%>');">
			<img src="web/images/sghsc-deta-sc.png" class="sghsc-deta-1-sc-img"/>收藏商品(${goods.collectNum}人)
		</a>
		<!-- <a href="" ><img src="web/images/sghsc-deta-fx.png" class="sghsc-deta-1-sc-img"/>分享</a> -->
		<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
    </div>
    		<div class="bdsharebuttonbox sgh-deta-fx111" >
			<!-- <a href="#" class="bds_more" data-cmd="more"></a> -->
			<a title="分享到QQ空间" href="#" class="bds_qzone" data-cmd="qzone"></a>
			<a title="分享到新浪微博" href="#" class="bds_tsina" data-cmd="tsina"></a>
			<a title="分享到腾讯微博" href="#" class="bds_tqq" data-cmd="tqq"></a>
			<a title="分享到人人网" href="#" class="bds_renren" data-cmd="renren"></a>
			<a title="分享到微信" href="#" class="bds_weixin" data-cmd="weixin"></a>
		</div>
 </div>
 
 <div class="sghsc-deta-1-min">
  <div class="sghsc-deta-1-min-1">${goods.name }</div>
  <div class="sghsc-deta-1-min-2">${goods.lessinformation}</div>
  <div class="sghsc-deta-1-min-3">
   <dl><dt class="sghsc-deta-1-min-3-dt">市场价</dt>
   	<dd><em class="sghsc-deta-1-min-3-dd">¥</em> 
   		<span class="sghsc-deta-1-min-3-dd"><fmt:formatNumber type="number" value="${goods.yuanjia }" pattern="0.00" maxFractionDigits="2"/></span>
   	</dd></dl>
   <dl><dt class="sghsc-deta-1-min-3-dt">商城价</dt>
   	<dd><em class="sghsc-deta-1-min-3-dd2">¥</em>
   		<span id="goods_price_new" class="sghsc-deta-1-min-3-dd2"><fmt:formatNumber type="number" value="${goods.price }" pattern="0.00" maxFractionDigits="2"/></span>  
   	</dd></dl>
   <dl><dt class="sghsc-deta-1-min-3-dt">运费</dt>
   	<dd>
   		<c:choose>
			<c:when test="${goods.isConsultingPostage == 1}">
				<span class="sghsc-deta-1-min-3-dd3">具体邮费请咨询客服</span>
		    </c:when>
		   
		    <c:otherwise>
		    	<c:if test="${goods.wuliu == 0}">
		   			<span class="sghsc-deta-1-min-3-dd3">包邮</span>
		   		</c:if>
		   		<c:if test="${goods.wuliu != 0}">
		   			<em class="sghsc-deta-1-min-3-dd3">¥</em>
		   			<span class="sghsc-deta-1-min-3-dd3">
		   				<fmt:formatNumber type="number" value="${goods.wuliu }" pattern="0.00" maxFractionDigits="2"/>
		   			</span>
		   		</c:if>
		    </c:otherwise>
		</c:choose>
   	</dd></dl>
  </div>
  <c:if test="${goods.goodstype != '3' }">
	<ul class="sghsc-deta-1-min-4">
		<li>返惠米金额：<strong>￥<fmt:formatNumber value="${goods.fanxian}" pattern="##.##" minFractionDigits="2" /></strong></li>
		<li>返惠米期数：<strong>${goods.fanxiannum}</strong></li>
		<li>返惠米比例：<strong><fmt:formatNumber value="${goods.fanxian/goods.price*100/goods.fanxiannum}" pattern="##.##" minFractionDigits="2" />%</strong></li>
	</ul>
  </c:if>
  <div class="sghsc-deta-1-min-4">累计销量：<span>${goods.queryNum}</span></div>
  <div class="sghsc-deta-1-min-41-box">
   <dl>
    <!-- <dt class="sghsc-deta-1-min-41">请选规格：</dt>
	 <dd><ul class="sghsc-deta-1-min-41-list">
	  <li><a class="sghsc-deta-1-min-41-a" role="button" tabindex="0">JBYD 3927(C) C类</a></li>
	  <li><a class="sghsc-deta-1-min-41-a" role="button" tabindex="0">B类 JBYD 3910A(B)</a></li>
	  <li><a class="sghsc-deta-1-min-41-a" role="button" tabindex="0">JBYD 3926(C) C类</a></li>
	  </ul>
	 </dd> -->
	  	<!-- 规格选择 -->
	    <c:if test="${goods.skuCode != null }">
			<c:forEach items="${goods.skuCode }" var="sc">
				<dt class="sghsc-deta-1-min-41">${sc.key }:</dt>
				<dd>
					<ul class="sghsc-deta-1-min-41-list">
						<c:forEach items="${sc.value }" var="v">
							<c:set value="${fn:split(v,'-')}" var="item"></c:set>
							<li class="sku" attr_id="${item[0] }" disabled="disabled">
								<a href="javascript:void(0)">${item[1]}</a>
								<i></i>
							</li>
						</c:forEach>
					</ul>
				</dd>
			</c:forEach>
		</c:if>
		
	</dl>
  </div>
  <div class="sghsc-deta-1-min-5">
   <dl>
	<dt class="sghsc-deta-1-min-5-bt">数量</dt>
	<dd id="sghsc-deta-1-min-5-n">
			<input type="text" class="sghsc-deta-1-min-5-s" value="1" id="admin_goods_goods_byGoodsNum" maxlength="8" title="请输入购买量">
			<span class="sghsc-deta-1-min-5-sn">
                <span class="sghsc-deta-1-min-5-ss"><a id="add" href="javascript:void(0);"><img src="web/images/sghsc-deta-s.png" width="15" height="12" ></a></span>
                <span class="sghsc-deta-1-min-5-ss"><a id="sub" href="javascript:void(0);"><img src="web/images/sghsc-deta-x.png"></a></span>
			</span>
			<span class="sghsc-deta-1-min-5-sj">件</span>
            <em id="J_EmStock" class="sghsc-deta-1-min-5-kc">库存${goods.store}件</em>
            <input type="hidden" id="kuCun" value="${goods.store}" >
	</dd>
   </dl>
   <div class="sghsc-deta-1-min-6">
   <input type="hidden" id="goods_item_id" value="">
   <div class="sghsc-deta-1-min-6-box">
	<a id="J_LinkBuy" href="javascript:void(0);" onclick="preAddCartto('goods_item_id','<%=memberId %>')" 
		class="sghsc-deta-1-min-6-buy" rel="nofollow" data-addfastbuy="true" title="点击此按钮，到下一步确认购买信息。" role="button">
		立即购买
	</a>
   </div>
   <div class="sghsc-deta-1-min-6-go">
	<a href="javascript:void(0);" rel="nofollow" id="toGouwucheBtn" role="button" onclick="preAddCart('goods_item_id','<%=memberId %>')">
		<img src="web/images/sghsc-deta-gwc.png" class="sghsc-deta-1-min-6-gwc" >加入购物车
	</a>
   </div>
   </div>
  </div>
 </div>
  <div class="sghsc-deta-1-rit">
  <div class="sghsc-deta-1-rit-hd">
  <s></s><span>找同类</span></div>
  
	 <div id="SwitchSxBt1_cont_0" >
		 <s:iterator value="catGoodsList" status="st">
		 	<div class="sghsc-deta-1-rit-ald-carousel">
		    	<ul class="sghsc-deta-1-rit-switchable">
				  <li>
				  	<div class="sghsc-deta-1-rit-img">
					  <a class="sghsc-deta-1-rit-a" tabindex="-1" href="goods/${id}.html" target="_blank"> 
					  	<img src="${defaultPicSrc }">
					  	<%-- <s:imgsrc value="${defaultPicSrc }" quantity="s"/> --%>
					  </a>  
					  <p class="sghsc-deta-1-rit-lojg">¥<fmt:formatNumber type="number" value="${price }" pattern="0.00" maxFractionDigits="2"/></p>
					</div>
				  </li>
				</ul>
		    </div>
	     </s:iterator> 
	</div>  
	
	<div id="SwitchSxBt1_cont_1" style="display: none">
		 <s:iterator value="catGoodsList2" status="st">
		 	<div class="sghsc-deta-1-rit-ald-carousel">
		    	<ul class="sghsc-deta-1-rit-switchable">
				  <li>
				  	<div class="sghsc-deta-1-rit-img">
					  <a class="sghsc-deta-1-rit-a" tabindex="-1" href="goods/${id}.html" target="_blank"> 
					  	<img src="${defaultPicSrc }">
					  </a>  
					  <p class="sghsc-deta-1-rit-lojg">¥<fmt:formatNumber type="number" value="${price }" pattern="0.00" maxFractionDigits="2"/></p>
					</div>
				  </li>
				</ul>
		    </div>
	     </s:iterator> 
	</div>  
	
	 <div id="SwitchSxBt1_cont_2" style="display: none">
		<s:iterator value="catGoodsList3" status="st">
		 	<div class="sghsc-deta-1-rit-ald-carousel">
		    	<ul class="sghsc-deta-1-rit-switchable">
				  <li>
				  	<div class="sghsc-deta-1-rit-img">
					  <a class="sghsc-deta-1-rit-a" tabindex="-1" href="goods/${id}.html" target="_blank"> 
					  	<img src="${defaultPicSrc }">
					  </a>  
					  <p class="sghsc-deta-1-rit-lojg">¥<fmt:formatNumber type="number" value="${price }" pattern="0.00" maxFractionDigits="2"/></p>
					</div>
				  </li>
				</ul>
		    </div>
	     </s:iterator> 
	</div>

<div class="sghsc-deta-1-rit-qhbtn">
  		<p class="SwitchSxBt1On" id="SwitchSxBt1_tab_0" onmouseover="ShowTag1('SwitchSxBt1','SwitchSxBt1',0,1,0);"></p>
		<p class="SwitchSxBt1" id="SwitchSxBt1_tab_1" onmouseover="ShowTag1('SwitchSxBt1','SwitchSxBt1',1,1,0);"></p>
		<p class="SwitchSxBt1" id="SwitchSxBt1_tab_2" onmouseover="ShowTag1('SwitchSxBt1','SwitchSxBt1',2,1,0);"></p>
</div>
 
 </div>
</div>

<div class="clear"></div>
<div class="sghsc-deta-box2">
<div class="sghsc-deta-2-letbox">
	<div class="sghsc-deta-2-let2">
		<div class="sghsc-deta-2-let-top">商家信息</div>      
		<div class="sghsc-deta-2-let-bot2">商家：<span class="sghsc-deta-2-let-bot-2">${company.companyName }</span></div>
		<div class="sghsc-deta-2-let-bot2">地址：<span class="sghsc-deta-2-let-bot-3">${company.pname}${company.cname}${company.aname}${company.address }</span></div>
		<div class="sghsc-deta-2-let-bot2 sghsc-deta-2-let-bot3">电话：<span class="sghsc-deta-2-let-bot-3">${company.telphone}</span></div>
	</div>
  	<div class="sghsc-deta-2-let">
        <div class="sghsc-deta-2-let-top">宝贝推荐</div>
        <s:iterator value="hotGoodsList" status="st">
	        <div class="sghsc-deta-2-let-bot">
	            <div class="sghsc-deta-2-let-img-box">
	            	<a href="goods/${id}.html" target="_blank">
	            		<img src="${defaultPicSrc }" width="46" height="46" />
	            		<%-- <s:imgsrc value="${defaultPicSrc }" quantity="s"/> --%>
	            	</a>
	            </div>
	            <div class="sghsc-deta-2-let-wz-box">
	            	<ul>
		                <li><div class="sghsc-deta-2-let-bt">${lessinformation}</div></li>
		                <li>￥<span><fmt:formatNumber type="number" value="${price }" pattern="0.00" maxFractionDigits="2"/></span></li>
		                <li class="sghsc-deta-2-let-xl">总销量：${queryNum}</li>
		        	</ul>
	            </div>
	        </div>
        </s:iterator>
	</div>
	</div>
	 
 <div class="sghsc-deta-2-rit">
	<div class="sghsc-deta-2-rit-had">
		<p class="SwitchSxBt2On" id="SwitchSxBt2_tab_0" onclick="ShowTag2('SwitchSxBt2','SwitchSxBt2',0,1,0);">商品详情</p>
		<p class="SwitchSxBt2" id="SwitchSxBt2_tab_1" onclick="ShowTag2('SwitchSxBt2','SwitchSxBt2',1,1,0);">成交记录</p>
		<p class="SwitchSxBt2" id="SwitchSxBt2_tab_2" onclick="ShowTag2('SwitchSxBt2','SwitchSxBt2',2,1,0);">商品评论</p>
	             <p class="sghsc-deta-2-rit-xq2"></p>
	</div>
	<div class="sghsc-deta-2-rit-xq-main" id="SwitchSxBt2_cont_0">
	   	<!-- 商品详情 -->
	   	${goods.infomation}
	</div>
	<div class="sghsc-deta-2-rit-xq-main" id="SwitchSxBt2_cont_1" style="display: none">
		<!-- 成交记录 -->
	</div>
	<div class="sghsc-deta-2-rit-xq-main" id="SwitchSxBt2_cont_2" style="display: none">
	   	<!-- 商品评论 -->
	</div>
 </div>
	
</div>
<div class="sghsc-deta-geduan"></div>

	
<script type=text/javascript>
	$(function() {
		$("#goods_item_id").val("");
	});
	
	/*  右侧切换  */
	function ShowTag1(TagName,TagClass,num,count,more) {
    for(var i=0;i<3;i++) {
       var tag = document.getElementById(TagName+"_tab_"+i);
        var cont = document.getElementById(TagName+"_cont_"+i);
        var mores;
        if(more) {
            mores = document.getElementById(TagName+"_more_"+i);
            }
        if(i==num) {
            tag.className = TagClass+"On";
            cont.style.display = "block";
            if(more) {
            	mores.style.display = "block";
            }
            } else {
                tag.className = TagClass;
                cont.style.display = "none";
                if(more) {
            		mores.style.display = "none";
            	}
			}  
		}
	}	
	/* 详情页切换 */
	function ShowTag2(TagName,TagClass,num,count,more) {
	    for(var i=0;i<3;i++) {
	       var tag = document.getElementById(TagName+"_tab_"+i);
	        var cont = document.getElementById(TagName+"_cont_"+i);
	        var mores;
	        if(more) {
	            mores = document.getElementById(TagName+"_more_"+i);
	            }
	        if(i==num) {
	            tag.className = TagClass+"On";
	            cont.style.display = "block";
	            if(more) {
	            mores.style.display = "block";
	            }
	            } else {
	                tag.className = TagClass;
	                cont.style.display = "none";
	                if(more) {
	            mores.style.display = "none";
	          }
	            }  }}
	</script>
	<!-- 图片放大 -->
	<script type=text/javascript>
		$(function(){			
		   $(".jqzoom").jqueryzoom({
				xzoom:400,
				yzoom:400,
				offset:10,
				position:"right",
				preload:1,
				lens:1
			});
			$("#spec-list").jdMarquee({
				deriction:"left",
				width:422,
				height:56,
				step:2,
				speed:4,
				delay:10,
				control:true,
				_front:"#spec-right",
				_back:"#spec-left"
			});
			$("#spec-list img").bind("mouseover",function(){
				var src=$(this).attr("src");
				$("#spec-n1 img").eq(0).attr({
					src:src.replace("\/n5\/","\/n1\/"),
					jqimg:src.replace("\/n5\/","\/n0\/")
				});
				$(this).css({
					"padding":"1px",
					"border":"1px solid #ccc",
					"cursor":"pointer"
				});
			}).bind("mouseout",function(){
				$(this).css({
					"padding":"2px",
					"border":"none"
				});
			});				
		})
</script>
<!-- 增加商品数量 -->
<script type=text/javascript>
	$("#admin_goods_goods_byGoodsNum").keypress(function(b) {
	        var keyCode = b.keyCode ? b.keyCode : b.charCode;
	        if (keyCode != 0 && (keyCode < 48 || keyCode > 57) && keyCode != 8 && keyCode != 37 && keyCode != 39) {
	            return false;
	        } else {
	            return true;
	        }
	    }).keyup(function(e) {
	        var keyCode = e.keyCode ? e.keyCode : e.charCode;
	        console.log(keyCode);
	        if (keyCode != 8) {
	            var numVal = parseInt($("#admin_goods_goods_byGoodsNum").val()) || 0;
	            numVal = numVal < 1 ? 1 : numVal;
	            $("#admin_goods_goods_byGoodsNum").val(numVal);
	        }
	    }).blur(function() {
	        var numVal = parseInt($("#admin_goods_goods_byGoodsNum").val()) || 0;
	        numVal = numVal < 1 ? 1 : numVal;
	        $("#admin_goods_goods_byGoodsNum").val(numVal);
	    });
		
	//增加
	$("#add").click(function() {
	    var num = parseInt($("#admin_goods_goods_byGoodsNum").val()) || 0;
	    $("#admin_goods_goods_byGoodsNum").val(num + 1);
	});
	
	//减去
	$("#sub").click(function() {
	    var num = parseInt($("#admin_goods_goods_byGoodsNum").val()) || 0;
	    num = num - 1;
	    num = num < 1 ? 1 : num;
	    $("#admin_goods_goods_byGoodsNum").val(num);
	});	


		var keys = "${goods.skuKeys}";
		keys = eval(keys);
		var data = ${goods.data};
		// 保存最后的组合结果信息
		var SKUResult = {};
		// 获得对象的key
		function getObjKeys(obj) {
			if (obj !== Object(obj))
				throw new TypeError('Invalid object');
			var keys = [];
			for ( var key in obj)
				if (Object.prototype.hasOwnProperty.call(obj, key))
					keys[keys.length] = key;
			return keys;
		}

		// 把组合的key放入结果集SKUResult
		function add2SKUResult(combArrItem, sku) {
			var key = combArrItem.join(";");
			if (SKUResult[key]) {// SKU信息key属性
				var ccc = sku["count"] || sku[" count"];
				SKUResult[key].count += ccc;
				SKUResult[key].prices.push(sku.price);
				// 设置选中规格的单品ID
				SKUResult[key].itemId += ";" + sku.itemId;
			} else {
				var ccc = sku["count"] || sku[" count"];
				SKUResult[key] = {
					count : ccc,
					prices : [ sku.price ],
					itemId : sku.itemId
				};
				console.info(SKUResult[key]+"00000000000");
			}
		}

		// 初始化得到结果集
		function initSKU() {
			var i, j, skuKeys = getObjKeys(data);
			for (i = 0; i < skuKeys.length; i++) {
				var skuKey = skuKeys[i];// 一条SKU信息key
				var sku = data[skuKey]; // 一条SKU信息value
				console.info(sku);
				var ccc = sku["count"] || sku[" count"];
				// 剔除库存为0的单品,使之不可选
				if (ccc == 0) {
					continue;
				}
				var skuKeyAttrs = skuKey.split(";"); // SKU信息key属性值数组
				skuKeyAttrs.sort(function(value1, value2) {
					return parseInt(value1) - parseInt(value2);
				});

				// 对每个SKU信息key属性值进行拆分组合
				var combArr = combInArray(skuKeyAttrs);
				for (j = 0; j < combArr.length; j++) {
					add2SKUResult(combArr[j], sku);
				}
				// 结果集接放入SKUResult
				SKUResult[skuKeyAttrs.join(";")] = {
					count : ccc,
					prices : [ sku.price ],
					itemId : sku.itemId
				};
			}
		}

		/**
		 * 从数组中生成指定长度的组合 方法: 先生成[0,1...]形式的数组, 然后根据0,1从原数组取元素，得到组合数组
		 */
		function combInArray(aData) {
			if (!aData || !aData.length) {
				return [];
			}

			var len = aData.length;
			var aResult = [];

			for (var n = 1; n < len; n++) {
				var aaFlags = getCombFlags(len, n);
				while (aaFlags.length) {
					var aFlag = aaFlags.shift();
					var aComb = [];
					for (var i = 0; i < len; i++) {
						aFlag[i] && aComb.push(aData[i]);
					}
					aResult.push(aComb);
				}
			}

			return aResult;
		}

		/**
		 * 得到从 m 元素中取 n 元素的所有组合 结果为[0,1...]形式的数组, 1表示选中，0表示不选
		 */
		function getCombFlags(m, n) {
			if (!n || n < 1) {
				return [];
			}

			var aResult = [];
			var aFlag = [];
			var bNext = true;
			var i, j, iCnt1;

			for (i = 0; i < m; i++) {
				aFlag[i] = i < n ? 1 : 0;
			}

			aResult.push(aFlag.concat());

			while (bNext) {
				iCnt1 = 0;
				for (i = 0; i < m - 1; i++) {
					if (aFlag[i] == 1 && aFlag[i + 1] == 0) {
						for (j = 0; j < i; j++) {
							aFlag[j] = j < iCnt1 ? 1 : 0;
						}
						aFlag[i] = 0;
						aFlag[i + 1] = 1;
						var aTmp = aFlag.concat();
						aResult.push(aTmp);
						if (aTmp.slice(-n).join("").indexOf('0') == -1) {
							bNext = false;
						}
						break;
					}
					aFlag[i] == 1 && iCnt1++;
				}
			}
			return aResult;
		}

		// 初始化用户选择事件
		$(function() {
			initSKU();
			$('.sku').each(function() {
				var self = $(this);
				var attr_id = self.attr('attr_id');
				if (!SKUResult[attr_id]) {
					self.css("display", "none");
					//self.attr('disabled', 'disabled');
				}
			}).click(function() {
				var self = $(this);
				// 选中自己，兄弟节点取消选中
				self.addClass('product_sku_act').siblings().removeClass('product_sku_act');
				self.find("a").addClass('selected');
				self.siblings().find("a").removeClass('selected');
				// 已经选择的节点
				var selectedObjs = $('.product_sku_act');
				if (selectedObjs.length) {
					// 获得组合key价格
					var selectedIds = [];
					selectedObjs.each(function() {
						selectedIds.push($(this).attr('attr_id'));
					});
					selectedIds.sort(function(value1, value2) {
						return parseInt(value1)
								- parseInt(value2);
					});
					var len = selectedIds.length;
					var prices = SKUResult[selectedIds
							.join(';')].prices;
					var counts = SKUResult[selectedIds
							.join(';')].count;
					var itemId = SKUResult[selectedIds
							.join(';')].itemId;
					
					var maxPrice = Math.max.apply(Math, prices);
					var minPrice = Math.min.apply(Math, prices);
					var pricess = maxPrice > minPrice ? minPrice
							+ "-" + maxPrice
							: maxPrice;
					$('#goods_price_new').text(pricess.toFixed(2));
					if (counts == 0) {
						alert('没库存');
					}
					$('#goods_item_id').val(itemId);
					// 用已选中的节点验证待测试节点 underTestObjs
					$(".sku").not(selectedObjs).not(self).each(function() {
					 	var siblingsSelectedObj = $(this).siblings('.product_sku_act');
						var testAttrIds = [];// 从选中节点中去掉选中的兄弟节点
						if (siblingsSelectedObj.length) {
							var siblingsSelectedObjId = siblingsSelectedObj.attr('attr_id');
							for (var i = 0; i < len; i++) {
								(selectedIds[i] != siblingsSelectedObjId)&& testAttrIds.push(selectedIds[i]);
							}
						} else {
							testAttrIds = selectedIds.concat();
						}
						testAttrIds = testAttrIds.concat($(this).attr('attr_id'));
						testAttrIds.sort(function(value1,value2) {
							return parseInt(value1) - parseInt(value2);
						});
						if (!SKUResult[testAttrIds.join(';')]) {
							$(this).css("display","none").removeClass('product_sku_act');
						} else {
							$(this).css("display",null);
							$(this).removeAttr('disabled');
						}
					});
				} else {
					// 设置默认价格
					var pri = ${goods.price};
					$('#goods_price_new').val(pri.toFixed(2));
					// 设置属性状态
					$('.sku').each(function() {
						//SKUResult[$(this).attr('attr_id')] ? $(this).removeAttr('disabled'): $(this).attr('disabled','disabled').removeClass('product_sku_act');
						 SKUResult[$(this).attr('attr_id')] ? $(this).css("display",null) : $(this).css("display","none").removeClass('product_sku_act');
					})
				}
			});
			
			//只有一种规格的处理，将唯一的规格id添加到规格的隐藏域中。减少用户不必要的选择
			if($('.sku').length == 1){
				var itemId = SKUResult[$($('.sku')[0]).attr('attr_id')].itemId;
				if (itemId) {
					$('#goods_item_id').val(itemId);
				}
				
				//添加选中样式
				$('.sku').addClass('product_sku_act');
				$('.sku > a').addClass('selected');
			}
			
			
			/**
			    判断多个规格下，各个规格有几个规格值，若某规格下仅有一个规格值，默认选中 
			*/
			var flagNum = 0;
			//遍历所有的规格ul标签
			$('ul.sghsc-deta-1-min-41-list').each(function() {
				var num = $(this).find("li").length;
				//判断各个规格下是否只有一个规格值
				if(num == 1){
					//单一规格值设置选中样式,标志为偶数
					$(this).find("li").addClass('product_sku_act');
					$(this).find("li > a").addClass('selected');
					
					flagNum = flagNum + 2;
				}else{
					//多规格值，标志为奇数
					flagNum = flagNum + 1.5;
				}
			})
			//所有规格均为单一规格值，将唯一的规格id添加到规格的隐藏域中
			if(0 == (flagNum % 2) && flagNum != 0) {
	            var itemId = SKUResult[$($('.sku')[0]).attr('attr_id')].itemId;
				if (itemId) {
					$('#goods_item_id').val(itemId);
				}
	        }
			
		});

</script>

<SCRIPT src="web/js/lib.js" type=text/javascript></SCRIPT>
<SCRIPT src="web/js/97zzw.js" type=text/javascript></SCRIPT>

<SCRIPT src="js/goods/magnifier.js" type=text/javascript></SCRIPT>
	<!-- footer begin -->
	<div class="clear"></div>
	<!-- <div class="bottom_box_06">
		<div class="bottom_box_06img">
			<img src="web/images/zixun/tonglan.png" width="1190" height="118" />
		</div>
	</div> -->
	<jsp:include page="/admin/common/indexFooter.jsp" />

	<!-- footer end -->

</body>
</html>
