$(function(){
	// 一级分类名称
	var firstGoodsCatName = $('#firstGoodsCatName').val();
	if(firstGoodsCatName != ''){
		setChaxunTip('分类',firstGoodsCatName,'firstGoodsCatName');
	}
	// 二级分类名称
	var goodsCatName = $('#goodsCatName').val();
	if(goodsCatName != ''){
		setChaxunTip('二级分类',goodsCatName,'goodsCatName');
	}
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
		$('.sghsc-goods-select .sghsc-goods-select2-fl:first').addClass('active');
	}
	if(sort == 'query_num'){
		$('.sghsc-goods-select .sghsc-goods-select2-fl:eq(1)').addClass('active');
	}
	//PRICE
	if(sort == 'PRICE'){
		$('.sghsc-goods-select .sghsc-goods-select2-fl:eq(2)').addClass('active');
		var order = $('#order').val();
		console.log(order);
		if(order == 'desc'){
			$('.sghsc-goods-select .sghsc-goods-select2-fl:eq(2)').addClass('search-up2low');
		}else if(order == 'asc'){
			$('.sghsc-goods-select .sghsc-goods-select2-fl:eq(2)').addClass('search-low2up');
		}
	}
	if(sort == 'createtime'){
		$('.sghsc-goods-select .sghsc-goods-select2-fl:eq(3)').addClass('active');
	}
	if(sort == 'click_number'){
		$('.sghsc-goods-select .sghsc-goods-select2-fl:eq(4)').addClass('active');
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
	});
	
	
	 // 收起分类与展开分类
    $("#toggle").click(function() {
        $(this).text($("#fullCategory").is(":hidden") ? "收起分类" : "展开分类");
        $("#fullCategory").slideToggle();       
    });
    
    //$("#fullCategorysub .subcat2").css("display","none"); 
    
    // 根据一级分类显示二级分类
    $("#fullCategoryone span").each(function(){
    	$(this).click(function(){
    		var oneindex = $(this).index();
    		$("#fullCategorysub .subcat2").each(function(){
    			$(this).css("display","none");  		
    			if($(this).index() == oneindex){
    				$(this).css("display","inline");
    			}
    		});
    	});    	
    });
    
});


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

 //根据所选条件排序
function sortOrder(data1,data2){
	$("#sort").val(data1);
	$("#order").val(data2);
	$("#pagerForm").submit();
	
}

function reset(){
	$("#zhankai").val('zhankai');
	$("#reset").submit();
}

// 查询
function chaxun(data1,data2){
	 $("#"+data1).val(data2);
	$("#pagerForm").submit();
}

// 展示已选择的查询条件
function setChaxunTip(type,value,tip){
	var tips = '<div class="sghsc-goods-sxuan-tj">'+type+'：<span>'+value+'</span><i class="sghsc-goods-close-btn" data-type="'+tip+'" ></i></div>';
	$('#search-selected').append(tips);
	$('#search-selected .sghsc-goods-close-btn').unbind('click').click(function(){
		$('#'+$(this).attr('data-type')).val('');
		$("#pagerForm").submit();
	});
}
