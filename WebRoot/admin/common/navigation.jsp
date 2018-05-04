<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="js/layer/layer.js"></script>

<style>
.redbg a{color:red;}
</style>

<script type="text/javascript">
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
var urlcc = GetQueryString("goodstype");

$(function(){
	var goodstype = $("#goodsType").text();	
	if(goodstype==''){
		$("li.sghsc-goods-nav-li").each(function(){
			if($(this).index()==0 && urlcc == null){
				$(this).addClass("redbg");
			}else if($(this).index()==1 && urlcc == 1){
				$(this).addClass("redbg");
			}else if($(this).index()==2 && urlcc == 3){
				$(this).addClass("redbg");
			}else{
				$(this).removeClass("redbg");
			}
		});
	}else{		
		$("li.sghsc-goods-nav-li").each(function(){
			if($(this).index()==0){
				$(this).removeClass("redbg");
			}else if($(this).index()==1 && goodstype == 1){
				$(this).addClass("redbg");
			}else if($(this).index()==2 && goodstype == 3){
				$(this).addClass("redbg");
			}else{
				$(this).removeClass("redbg");
			}
		});
	
	}

});

// 每日签到
function singIn(){
		$.ajax({
		url : '<%=basePath%>signIn!isLogin.action',
		type : 'POST',
		success : function(msg) {
			var date = $.parseJSON(msg);
			layer.alert(date);
			
			var oDiv = $($("div[id^='layui-layer']")[1]);
			var retop = ((document.body.clientHeight || 943) - oDiv.height())/2;
			if(parseInt(oDiv.css("top")) > retop && retop<800) {
				oDiv.css("top", retop + 'px');
			}
		}
		});
	}

</script>

<div class="sghsc-goods-nav-box">
     <s:action name="catalogueAction!queryFullCategory" executeResult="true" namespace="/" >
		 <s:param name="catType">gwsc</s:param>
	 </s:action>
</div>
