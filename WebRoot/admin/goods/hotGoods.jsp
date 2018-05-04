<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SessionInfo sessionInfo = (SessionInfo)session.getAttribute(ResourceUtil.getSessionInfoName());
String memberId = sessionInfo==null?"":sessionInfo.getUserId();
%>
<script type="text/javascript" src="js/qlzy.js"></script>
<div class="hotpro">
	<div class="hotprobt">
		<p class="rmbt">热卖</p>
		<ul id="goods_hotGoods_cat" class="rmfl">
			<s:iterator value="%{list}" id="cat" status="st">
				<li><a id= "hot${cat.id}" onmouseover="gethotGoods('${cat.name}','hot${cat.id}');" onclick="gethotGoods('${cat.name}','hot${cat.id}');">${cat.name}</a>|</li>
			</s:iterator>
		</ul>
		<div id="hotGoods" style="clear:both">
			<s:iterator value="%{hotGoods}" id="hot" status="st">
			<s:if test="#st.index==4">
				<div class="gotpiclast">
				<p class="hotcpt"><a href="goods/${hot.id}.html">
					<s:if test="null==defaultPicSrc">
						<img src="/images/170-110zwpic.gif" width="147" height="110" />
			    	</s:if>
			    	<s:else>
			    		<img src="${hot.defaultPicSrc}" width="147" height="110"/>
			    	 </s:else>
					</a></p>
					<p class="hotmc"><a href="goods/${hot.id}.html">${hot.name}</a></p>
					<p class="hotmc red">¥ ${hot.price}</p>
			        <p class="crgwc"><a class="red" href="javascript:void(0);" onclick="mark('${hot.id }','2','<%= memberId%>');" target="_self">放入购物车</a></p>
				</div>
			</s:if>
			<s:else>
				<div class="gotpic">
				<p class="hotcpt"><a href="goods/${hot.id}.html">
					<s:if test="null==defaultPicSrc">
						<img src="/images/170-110zwpic.gif" width="147" height="110" />
			    	</s:if>
			    	<s:else>
			    		<img src="${hot.defaultPicSrc}" width="147" height="110"/>
			    	 </s:else>
					</a></p>
					<p class="hotmc"><a href="goods/${hot.id}.html">${hot.name}</a></p>
					<p class="hotmc red">¥ ${hot.price}</p>
			        <p class="crgwc"><a class="red" href="javascript:void(0);" onclick="mark('${hot.id }','2','<%= memberId%>');" target="_self">放入购物车</a></p>
				</div>
			</s:else>
			</s:iterator>
        </div>
	</div>
  </div>

<div class="hotpro">
   <div class="hotprobt">
      <p class="rmbt">新品</p>
      <ul class="rmfl" id="newGoodsHot">
         <s:iterator value="%{list}" id="cat" status="st">
				<li><a id= "new${cat.id}" onmouseover="getNewGoods('${cat.name}','new${cat.id}');" onclick="getNewGoods('${cat.name}','new${cat.id}');">${cat.name}</a>|</li>
			</s:iterator>
      </ul>
      <div id="newGoods" style="clear:both">
	      <s:iterator value="%{newGoods}" id="n" status="st">
			<s:if test="#st.index==4">
			 <div class="gotpiclast">
				<p class="hotcpt">
					<a href="goods/${n.id}.html">
					<s:if test="null==defaultPicSrc">
						<img src="/images/170-110zwpic.gif" width="147" height="110" />
			    	</s:if>
			    	<s:else>
			    		<img src="${n.defaultPicSrc}" width="147" height="110" />
			    	 </s:else>
					</a>
				</p>
				<p class="hotmc"><a href="goods/${n.id}.html">${n.name}</a></p>
				<p class="hotmc red">¥ ${n.price}</p>
				<p class="crgwc"><a class="red" href="javascript:void(0);" onclick="mark('${n.id}','2','<%=memberId%>');" target="_self">放入购物车</a></p>
			</div>
			</s:if>
			<s:else>
				<div class="gotpic">
				<p class="hotcpt">
					<a href="goods/${n.id}.html">
					<s:if test="null==defaultPicSrc">
						<img src="/images/170-110zwpic.gif" width="147" height="110" />
			    	</s:if>
			    	<s:else>
			    		<img src="${n.defaultPicSrc}" width="147" height="110" />
			    	 </s:else>
					</a>
				</p>
				<p class="hotmc"><a href="goods/${n.id}.html">${n.name}</a></p>
				<p class="hotmc red">¥ ${n.price}</p>
				<p class="crgwc"><a class="red" href="javascript:void(0);" onclick="mark('${n.id}','2','<%=memberId%>');" target="_self">放入购物车</a></p>
			</div>
			</s:else>
	      	
		  </s:iterator>
	  </div>
   </div>
</div>
<script type="text/javascript">
    //鼠标移动热卖商品效果
function gethotGoods(type,id){
	var borderRight;
	 $.ajax({  
	     type:'post',  
	     url:'indexGoodsAction!gainHotGoods.action',  
	     dataType:'json', 
	     data:{"type":type}, 
	     success:function(goods){ 
	     	$("#hotGoods").empty(); 
			for(var i=0; i< goods.length;i++){
		        borderRight = i==5?"gotpiclast":"gotpic";
		        $("#hotGoods").append(
		        	"<div class=\""+borderRight+"\" ><p class=\"hotcpt\"><a href=\"goods/"+goods[i].id+".html\"><img src=\""+goods[i].defaultPicSrc+ 
		        	"\" width=\"147\" height=\"110\"/></a></p><p class=\"hotmc\"><a href=\"goods/"+goods[i].id+".html\">"
		        	+goods[i].name+"</a></p><p class=\"hotmc red\">¥"+goods[i].price+
		        	"</p><p class=\"crgwc\"><a class=\"red\" href=\"javascript:void(0);\" onclick=\"mark('"+goods[i].id+"','2','<%= memberId%>');\" target=\"_self\"> 放入购物车</a></p></div>"
		        );  
		          }
		     $("#goods_hotGoods_cat a").removeClass("hover");
			if(id!=null){
				$("#"+id).addClass("hover");
			}  
		     }  
		    });
		}
		
	
	//鼠标移动新品商品效果
	function getNewGoods(type,id){
		var borderRight_new;
		 $.ajax({  
		     type:'post',  
		     url:'indexGoodsAction!gainNewGoods.action',  
		     dataType:'json', 
		     data:{"type":type}, 
		     success:function(goods){ 
		     	$("#newGoods").empty(); 
				for(var i=0; i< goods.length;i++){
			        borderRight_new = i==5?"gotpiclast":"gotpic";
			        $("#newGoods").append(
			        	"<div class=\""+borderRight_new+"\"><p class=\"hotcpt\"><a href=\"goods/"+goods[i].id+".html\"><img src=\""+goods[i].defaultPicSrc+ 
			        	"\" width=\"147\" height=\"110\"/></a></p><p class=\"hotmc\"><a href=\"goods/"+goods[i].id+".html\">"
			        	+goods[i].name+"</a></p><p class=\"hotmc red\">¥"+goods[i].price+
			        	"</p><p class=\"crgwc\"><a class=\"red\" href=\"javascript:void(0);\" onclick=\"mark('"+goods[i].id+"','2','<%= memberId%>');\" target=\"_self\">放入购物车</a></p></div>"
			        );  
				}
				$("#newGoodsHot a").removeClass("hover");
				if(id!=null){
					$("#"+id).addClass("hover");
				}
			     }  
			    });
			}
    </script>
