 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="menu">
    <a href="javascript:void(0)"  class="menubt">所有商品分类</a>
    <ul class="menuzong" id="firstGoodsCats">
      <s:iterator value="firstGoodsCatList" var="goodsCat" status="index">
		<li class="menuzong-li"  data-id="${id}">
			<a class="menuzong-li-a"  href="searchGoodsList/${id}/${name}.html">
				<img src="images/navicon/icon_<s:property value="#index.index+1"/>.png">
				<s:property value="name" />
			</a> 
	    </li>
  	  </s:iterator>
    </ul>
    
</div>
<script type="text/javascript">
$(function(){
    $('.menuzong-li').each(function(){
    });
	if(typeof(navIndex) != undefined && navIndex == 0){
		$('.choujiangRoad').show();
	}else{
		$('#menu').hover(function(){
			$('.menuzong').show();
		},function(){
			$('.menuzong').hide();
		})
	}
	$('.menuzong-li').each(function(){
		var me = $(this),pid = me.attr('data-id');
		$.post('secCatalogue/' + pid + '.html',function(snavs){
			snavs = eval('('+snavs+')');
			if(snavs.length>0){
				var snavStr = '<ul class="menuSec">';
				$.each(snavs,function(index,el){
					snavStr += '<li class="menuSec-li" data-id="'+el.id+'">';
					snavStr += '<a class="menuSec-li-a"  href="searchGoodsList/'+el.id+'/'+el.name+'.html">'+el.name+'</a>'
					snavStr +='</li>';
				})
				me.append(snavStr);
			}
			$('.menuSec-li').each(function(){
				var mm = $(this),sid = mm.attr('data-id');
				$.post('secCatalogue/' + sid + '.html',function(tnavs){
					tnavs =  eval('('+tnavs+')');
					if(snavs.length>0){
						var tnavStr = '<ul class="menuThd">';
						$.each(tnavs,function(iy,item){
							tnavStr += '<li class="menuThd-li" data-id="'+item.id+'">';
							tnavStr += '<a class="menuThd-li-a"  href="searchGoodsList/'+item.id+'/'+item.name+'.html">'+item.name+'</a>'
							tnavStr +='</li>';
						})
						mm.append(tnavStr);
					}
				})
				
				//控制显示隐藏
				$('.menuzong-li').hover(function(e){
					$(this).children('.menuSec').show();
				},function(){
					$(this).children('.menuSec').hide();
				})
				$('.menuSec-li').hover(function(e){
					//if($(this).children('.menuThd').find('li').length>0){
						//$(this).children('.menuThd').show();
					//}
					
				},function(){
					$(this).children('.menuThd').hide();
				})
			})
		})
		
	})
})

function openZhuanpan(){
	$.ajax({
				url : 'memberCenter/goods!checkSession.action',
				type : 'POST',
				dataType : 'JSON',
				success : function(json) {
					if (!json) {
						layer.alert("请先登录");
					} else {
						layer.open({
					    type: 2,
					    title: '',
					    shadeClose: true,
					    shade: 0.8,
					    area: ['650px', '630px'],
					    content: 'zhuanpan/index.jsp' 
					}); 
					}
				}
		});


}
</script>