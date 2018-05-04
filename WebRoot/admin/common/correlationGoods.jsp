<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="zysp_r">
	<h2>相关热门商品<input id="admin_common_correlationInput" type="hidden" value="${goods.carPartsId }"  /></h2>
	<ul>
		<div id="admin_common_correlationGoods" ></div>
	</ul>
</div>

<SCRIPT type=text/javascript>
	$(function(){			
	   	var goodsCatID = $("#admin_common_correlationInput").val();
	   	$.ajax({
				type : "POST",
				url : "indexGoodsAction!gainHotGoodsByGoodCatId.action",
				dataType:'json',
				data : "goodsCatId=" + goodsCatID ,
				success : function(goods) {
					$("#admin_common_correlationGoods").empty();
					var g = "";
					for(var i=0; i< goods.length;i++){
						var image="";
						if(goods[i].defaultPicSrc==null || ''==goods[i].defaultPicSrc==null){
							image = "images/70-54zwpic.gif";
						}else{
							image = goods[i].defaultPicSrc;
						}
		       			g  = g+
			        		"<li><p class=\"p-img\"><a href=\"/goods/"+goods[i].id+".html\" target=\"_blank\"><img src=\""+image+"\" width=\"70px\" height=\"54px\" class=\"err-product\" /> </a></p>"+
							"<div class=\"zysp_r_r\"><p class=\"p-name\"><a href=\"/goods/"+goods[i].id+".html\" target=\"_blank\">"+goods[i].name+"</a></p>"+
							"<p>"+goods[i].bn+"</p><p class=\"p-price\"><strong class=\"J_570310\">￥"+goods[i].price+"</strong></p></div></li>"
		        		 
		          	}
		          
		          	$("#admin_common_correlationGoods").append(g);
				}
			});	
	});
	</SCRIPT>
