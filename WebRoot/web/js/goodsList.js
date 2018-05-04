var catalogue = [];
var firstGoodsCatId;
var secondGoodsCatId;
$(function(){
	firstGoodsCatId = $('#firstGoodsCatId').val();
	secondGoodsCatId = $('#secondGoodsCatId').val();
	getFirstCatalogue();
	var leixing= $('#leixing').val();
	if(leixing != ''){
		setChaxunTip('类型',leixing,'leixing');
	}
	var baozhuang = $('#baozhuang').val();
	if(baozhuang != ''){
		setChaxunTip('包装',baozhuang,'baozhuang');
	}
	var zhongliang = $('#zhongliang').val();
	if(zhongliang != ''){
		setChaxunTip('重量',zhongliang,'zhongliang');
	}
	var shengfen = $('#shengfen').val();
	if(shengfen != ''){
		setChaxunTip('省份',shengfen,'shengfen');
	}
	
	var sort = $('#sort').val();
	if(sort == '(CLICK_NUMBER*0.3+query_num*0.7)'){
		$('.lb_zhpx .lb_zhpx_tow:first').addClass('active');
	}
	if(sort == 'query_num'){
		$('.lb_zhpx .lb_zhpx_tow:eq(1)').addClass('active');
	}
	//PRICE
	if(sort == 'PRICE'){
		$('.lb_zhpx .lb_zhpx_tow:eq(2)').addClass('active');
		var order = $('#order').val();
		console.log(order);
		if(order == 'desc'){
			$('.lb_zhpx .lb_zhpx_tow:eq(2)').addClass('search-up2low');
		}else if(order == 'asc'){
			$('.lb_zhpx .lb_zhpx_tow:eq(2)').addClass('search-low2up');
		}
	}
	if(sort == 'createtime'){
		$('.lb_zhpx .lb_zhpx_tow:eq(3)').addClass('active');
	}
	if(sort == 'click_number'){
		$('.lb_zhpx .lb_zhpx_tow:eq(4)').addClass('active');
	}
	
	
	$('#searchByPrice').click(function(){
		if($(this).hasClass('search-up2low')){
			sortOrder('PRICE','asc');
		}else if($(this).hasClass('search-low2up')){
			sortOrder('PRICE','desc');
		}else{
			$(this).addClass('search-low2up');
			sortOrder('PRICE','asc');
		}
	})
})

function getFirstCatalogue(){
	//获取一级菜单
	$.post('catalogueAction!gainFirstCatalogue.action',{pid:'1'},function(resp){
		resp = eval('('+resp+')');
		$.each(resp,function(i,ctg){
			var c = ctg;
			var ctgStr = '<li data-id="'+ctg.id+'" class="search-type-item"><div class="search-type-title"><a class="search-type-link">'+ctg.name+'</a></div></li>';
			$('.search-type').append(ctgStr);
			
			//根据一级菜单id获取二级菜单
			$.post('secCatalogue/'+ctg.id+'.html',function(subResp){
				subResp = eval('('+subResp+')');
				c.children = subResp;
				if(subResp.length != 0){
					var pitem = $('.search-type .search-type-item[data-id='+ctg.id+']');
					pitem.find('.search-type-title').prepend('<div class="search-type-icon"></div>');
					pitem.find('.search-type-title').append('<span class="search-look-more">＞</span>');
					var subCtgStr ='<ul  class="search-subtype">';
					$.each(subResp,function(j,subCtg){
						subCtgStr += '<li  class="search-subtype-item" data-id="'+subCtg.id+'"><a class="search-subtype-link"  href="javascript:;">'+subCtg.name+'</a></li>';
					})
					subCtgStr += '</ul>';
					pitem.append(subCtgStr);
					
					//绑定展开与折叠状态
					$('.search-type-item[data-id='+ctg.id+'] .search-type-icon').click(function(){
						var me = $(this),pItem = me.parents('.search-type-item'),subType = pItem.find('.search-subtype');
						if(pItem.hasClass('expend')){
							pItem.removeClass('expend');
							subType.hide('slow');
						}else{
							pItem.addClass('expend');
							subType.show('slow');
						}
					});
					$('.search-type-item[data-id='+ctg.id+'] .search-subtype-item a').click(function(){
						var me = $(this),
						      sItem = me.parent('.search-subtype-item'),
							  id = sItem.attr('data-id'),
							  pitem = sItem.parents('.search-type-item'),
							  pid = pitem.attr('data-id');
						$('#firstGoodsCatId').val(pid);
						$('#secondGoodsCatId').val(id);
						$("#thirdGoodsCatId").val('');
						$("#leixing").val('');
						$("#pagerForm").submit();
					})
				}
				
				if(firstGoodsCatId != '' && firstGoodsCatId == ctg.id){
					$('.search-type-item[data-id='+firstGoodsCatId+']').addClass('expend').find('.search-subtype').show();
					if(secondGoodsCatId!='' ) $('.search-subtype-item[data-id='+secondGoodsCatId+']').addClass('active');
				}
				
			})
			catalogue.push(c);
		})
		
		$('.search-type-item .search-type-link').click(function(){
			var me = $(this),pItem = me.parents('.search-type-item');
			$('#firstGoodsCatId').val(pItem.attr('data-id'));
			$('#secondGoodsCatId').val(pItem.attr(''));
			$("#pagerForm").submit();
		})
	})
}

//类别查询该市下的商家及商品
function getCityData(id){
	$("#cityId").val(id);
	var cityName=$("#lvst_goodsList2_cityList").find("option:selected").text(); 
	$("#cityName").val(cityName);
	$("#pagerForm").submit();
}
//根据库存查询列表
function getStoreData(){
var $storeCheckBox = $("#storeCheckBox");
	if($storeCheckBox.is(":checked")){
		$("#store").val('1');
	}else{
		$("#store").val('');
	}
	$("#pagerForm").submit();
}
function reset(){
	$("#zhankai").val('zhankai');
	$("#reset").submit();
}
function showMessage(value){
	alert(value);
}
//收藏商品
function addfavorite(id) {
	$.ajax({
		url : 'memberCenter/goods!checkSession.action',
		type : 'POST',
		dataType:'JSON',
		success:function(json){
			if(!json){
				var collectUrl = "call/joinCollect/" + id+"/goods.html";
				showLogin('mask', 'pop_500', collectUrl, '2', '收藏成功');
				//openLoginLayer();
			}else{
				$.ajax({
					url : "call/joinCollect/" + id + "/goods.html",
					success : function() {
						alert('收藏成功！');
					}
				});
			}
		}
	});
}
 //根据所选条件排序
function sortOrder(data1,data2){
	$("#sort").val(data1);
	$("#order").val(data2);
	$("#pagerForm").submit();
	
}

function chaxun(data1,data2){
	 $("#"+data1).val(data2);
	$("#pagerForm").submit();
}

function setChaxunTip(type,value,tip){
	var tips = '<div class="lb_sx_xk">'+type+'：<span>'+value+'</span><i class="search-close-btn" data-type="'+tip+'" ></i></div>';
	$('.search-selected').append(tips);
	$('.search-selected .search-close-btn').unbind('click').click(function(){
		$('#'+$(this).attr('data-type')).val('');
		$("#pagerForm").submit();
	});
}
function setLeixing(id,name){
	$("#thirdGoodsCatId").val(id);
	$("#leixing").val(name);
	$("#pagerForm").submit();
}
