/**
 * 常用JS 周张豹
 */


/**
 * 加入购物车
 */
preAddCart=function(idName,memberId,goodsId){
	var itemId=$('#'+idName).val();
	if(itemId.indexOf(';')>0 || itemId.length<=10){
		alert("规格没有选对,请选择正确在提交");
		return;
	}
	
	var kuCunNum = parseFloat($("#kuCun").val());
	var gouNum = parseFloat($("#admin_goods_goods_byGoodsNum").val());
	
	if(gouNum > kuCunNum){
		alert("加入数大于库存！");
		return;
	}
	qlMemberCart(itemId,gouNum,goodsId);
}

/**
 * 立即购买
 */
preAddCartto=function(idName,memberId,goodsId,isOneBuy){
	var itemId=$('#'+idName).val();
	var gNum = $("#admin_goods_goods_byGoodsNum").val();
	
	var kuCunNum = parseFloat($("#kuCun").val());
	var gouNum = parseFloat($("#admin_goods_goods_byGoodsNum").val());
	
	if(gouNum > kuCunNum){
		alert("所购买数大于库存！");
		return;
	}
	
	if(itemId.indexOf(';')>0 || itemId.length<=10){
		alert("规格没有选对,请选择正确再提交");
		return;
	}
	if (memberId != null && memberId != '' && memberId != 'null') {// 登录状态下立即购买
		$("#goodsItemIds").val(itemId);
		$("#nowBuyNum").val(gNum);
		$("#isNowBuy").val("1");
		$("#isOneBuy").val(isOneBuy);
		$("#goBuy").submit();
	} else {
		showLogin('mask','pop_500', '', '2', '', true);
	}
}



mark = function(id, type, memberId) {
	var gNum = $("#admin_goods_goods_byGoodsNum").val();
	if (type == 1) {// 收藏商品操作
		if (memberId != null && memberId != '') {// 登录状态下收藏
			qlMemberCollect(id, "goods");
		} else {// 未登录下收藏
			var collectUrl = "call/joinCollect/" + id + "/goods.html";
			showLogin('mask', 'pop_500', collectUrl, '2', '收藏成功');

		}

	} else if (type == 2) {// 加入购物车
		qlMemberCart(id,gNum);
	} else if (type == 3) {// 收藏店铺操作
		if (memberId != null && memberId != '') {// 登录状态下收藏
			qlMemberCollect(id, "shop");
		} else {// 未登录下收藏
			var collectUrl = "call/joinCollect/" + id + "/shop.html";
			showLogin('mask', 'pop_500', collectUrl, '2', '收藏成功');

		}
	}
};

// 收藏商品
function qlMemberCollect(id, type) {

	$.ajax({
		url : "call/joinCollect/" + id + "/" + type + ".html",
		success : function() {
			alert('收藏成功！');
		}
	});
};

// 加入购物车
function qlMemberCart(itemId,gNum,goodsId) {
	var url = "call/joinCart/" + itemId + ","+gNum+","+goodsId+".html";
	$.ajax({
		url : url ,
		success : function() {
			selectHeadCartNum();// 执行购物车查询
			alert('加入购物车成功!');
		}
	});
}
/**
 * 立刻购买1
 */
function nowBuy(gid, memberId) {
	var itemId=$('#'+gid).val();
	if(itemId.indexOf(';')>0 || itemId.length<=10){
		alert("规格没有选对,请选择正确在提交");
		return;
	}
	var goodsNum = $("#admin_goods_goods_byGoodsNum").val();
	var buyUrl = "call/nowBuy/" + itemId + "_" + goodsNum + ".html";
	if (memberId != null && memberId != '') {
		// 用户登录状态下
		window.location.href = buyUrl;
	} else {
		// 用户未登录状态下
		showLogin('mask', 'pop_500', buyUrl, '0', '');
	}

}

function nowBuyShCh(gid, memberId) {
	var goodsNum = $("#admin_goods_goods_byGoodsNum").val();
	var buyUrl = "/call/nowBuyShCh/" + gid + "_" + goodsNum + ".html";
	if (memberId != null && memberId != '') {
		// 用户登录状态下
		window.location.href = buyUrl;
	} else {
		// 用户未登录状态下
		showLogin('mask', 'pop_500', buyUrl, '0', '');
	}

}

/**
 * stopId:需要关闭的DIVID;
 * type:1-关闭后刷新当前页面，2-重新加载
 * divId:当type=2时，需要重新加载的DIVId
 */
function addNewAddr(stopId,type,divId) {

	var name = $("#admin_cart_clearingr_eceiveAddr_name").val();
	var province = $("#admin_cart_clearingProvince").val();
	var city = $("#admin_cart_clearingCity").val();
	var area = $("#admin_cart_clearingArea").val();
	var receiveAddress = $("#admin_cart_clearingr_receiveAddr_receiveAddress")
			.val();
	var mobile = $("#admin_cart_clearingr_receiveAddr_mobile").val();
	var telephone = $("#admin_cart_clearingr_receiveAddr_telephone").val();
	var email = $("#admin_cart_clearingr_receiveAddr_email").val();
	if (!regName.test(name)) {
		$('#admin_cart_clearingr_eceiveAddr_name').focus();
		alert('收货人只可输入2-20位英文和汉字！');
		return;
	}
	if (province == null || province == '0' || city == null || city == '0'
			|| area == null || area == '0') {
		$('#admin_cart_clearingProvince').focus();
		alert('请选择所在地区！');
		return;
	}
	if (!regAddress.test(receiveAddress)) {
		$('#admin_cart_clearingr_eceiveAddr_name').focus();
		alert('详细地址中只可输入5-100位英文、汉字、数字及下划线！');
		return;
	}
	if (!regphone.test(mobile)) {
		$('#admin_cart_clearingr_receiveAddr_mobile').focus();
		alert('请正确填写手机号码！');
		return;
	}
	if (!regEmail.test(email)) {
		$('#admin_cart_clearingr_receiveAddr_email').focus();
		alert('请正确填写电子邮箱地址');
		return;
	}
	var formValue = "receiveAddr.receiveName=" + name + "&"
			+ "receiveAddr.province=" + province + "&" + "receiveAddr.city="
			+ city + "&" + "receiveAddr.area=" + area + "&"
			+ "receiveAddr.receiveAddress=" + receiveAddress + "&"
			+ "receiveAddr.mobile=" + mobile + "&" + "receiveAddr.telephone="
			+ telephone + "&" + "receiveAddr.email=" + email + "&"
			+ "receiveAddr.id="
			+ $("#admin_cart_clearingr_eceiveAddr_id").val() + "&";
	$.ajax({
		type : "POST",
		url : "call/updateMemberAddr.html",
		data : formValue,
		dataType : "JSON",
		success : function(id) {
			stopsplbtitle('tanchu', stopId);
			if(type == 1){
				location.reload();
			}else if (type==2) {
				$("#"+divId).load("memberCallAction!loadReceiveClearingAddr.action",{"receiveAddr.id":id});
			}
			
		}
	});
}


function addPesionNewAddr() {
	
	var name = $("#person_orders_shippingAddr_clearingName").val();
	var province = $("#person_orders_shippingAddr_clearingProvince").val();
	var city = $("#person_orders_shippingAddr_clearingCity").val();
	var area = $("#person_orders_shippingAddr_clearingArea").val();
	var receiveAddress = $("#person_orders_shippingAddr_clearingAddress")
	.val();
	var mobile = $("#person_orders_shippingAddr_clearingMobile").val();
	var telephone = $("#person_orders_shippingAddr_clearingTelephone").val();
	var email = $("#person_orders_shippingAddr_clearingEmail").val();
	var isDefault = 'false';
	if(document.getElementById('person_orders_shippingAddr_clearingIsDefault').checked){
		isDefault= 'true';
	}
	
		 
	
	if (!regName.test(name)) {
		$('#person_orders_shippingAddr_clearingName').focus();
		alert('收货人只可输入2-20位英文和汉字！');
		return;
	}
	if (province == null || province == '0' || city == null || city == '0'
		|| area == null || area == '0') {
		$('#person_orders_shippingAddr_clearingProvince').focus();
		alert('请选择所在地区！');
		return;
	}
	if (!regAddress.test(receiveAddress)) {
		$('#person_orders_shippingAddr_clearingAddress').focus();
		alert('详细地址中只可输入5-100位英文、汉字、数字及下划线！');
		return;
	}
	if (!regphone.test(mobile)) {
		$('#person_orders_shippingAddr_clearingMobile').focus();
		alert('请正确填写手机号码！');
		return;
	}
	if (!regEmail.test(email)) {
		$('#person_orders_shippingAddr_clearingEmail').focus();
		alert('请正确填写电子邮箱地址');
		return;
	}
	var formValue = "receiveAddr.receiveName=" + name + "&"
	+ "receiveAddr.province=" + province + "&" + "receiveAddr.city="
	+ city + "&" + "receiveAddr.area=" + area + "&"
	+ "receiveAddr.receiveAddress=" + receiveAddress + "&"
	+ "receiveAddr.mobile=" + mobile + "&" + "receiveAddr.telephone="
	+ telephone + "&" + "receiveAddr.email=" + email + "&"
	+ "receiveAddr.id="
	+ $("#admin_cart_clearingr_eceiveAddr_id").val() + "&"
	+ "receiveAddr.isDefault="
	+ isDefault+ "&";
	$.ajax({
		type : "POST",
		url : "call/addMemberAddr.html",
		data : formValue,
		dataType : "JSON",
		success : function(id) {
			$("#person_orders_shippingAddr_clearingName").attr("value","");
			$("#person_orders_shippingAddr_clearingProvince").attr("value","0");
			$("#person_orders_shippingAddr_clearingCity").attr("value","0");
			$("#person_orders_shippingAddr_clearingArea").attr("value","0");
			$("#person_orders_shippingAddr_clearingAddress").attr("value","");
			$("#person_orders_shippingAddr_clearingMobile").attr("value","");
			$("#person_orders_shippingAddr_clearingTelephone").attr("value","");
			$("#person_orders_shippingAddr_clearingEmail").attr("value","");
			$("#memberCenter_person_orders_memberShippingAddr").load("memberCallAction!loadMemberShippingAddr.action",{"receiveAddr.id":id});
			
		}
	});
}

/**
 * 关于打开相关页面 周张豹
 */
function openOrderPage(url){
	$.ajax({
		url : 'memberCenter/goods!checkSession.action',
		type : 'POST',
		dataType : 'JSON',
		success : function(json) {
			if (!json) {
				showLogin('mask', 'pop_500', url, '0', '');
			} else {
				window.location.href=url;
			}
		}
});
}

/**
 *  根据商品的ID获取商品的收藏数量，主要用于商品展示页面,查询后需要展示的位置ID
 * @param goodsId
 * @author 周张豹
 */
function selectMemberCollect(goodsId,showId){
	$.ajax({
		url : '/call/selectCollect.html',
		type : 'POST',
		dataType : 'JSON',
		data:{"id":goodsId},
		success : function(json) {
			$("#"+showId).html("已有"+json+"人收藏");
		}
});
}

function pwdUserName(fistName,secondName){
	var returnName = "";
	if(fistName != null && fistName != '' && fistName != undefined){
		returnName = fistName.charAt(0)+"***"+fistName.charAt(fistName.length-1);		
	}else {
		returnName = secondName.charAt(0)+"***"+secondName.charAt(secondName.length-1);
	}
	return returnName;
};

/**
 * ppt开始交流
 * tuid,对方ID
 * fuid，自己ID
 */
function readRegedit(tuid,fuid){
	 var Browser = {
			   'isIE' : (navigator.userAgent.indexOf('MSIE') >= 0) && (navigator.userAgent.indexOf('Opera') < 0),

			   'isFirefox' : navigator.userAgent.indexOf('Firefox') >= 0,

			   'isOpera' : navigator.userAgent.indexOf('Opera') >= 0

			 };
	 if('' == fuid || fuid == null){
		 alert('很抱歉,您需要在网页上登录后才可使用!');
		 return false;
	 }else{
		 if(Browser["isIE"]){
			 var obj = new ActiveXObject("WScript.Shell"); 
			var s="HKEY_CURRENT_USER\\SOFTWARE\\Classes\\myClient\\URL Protocol"; 
				try{
					var sNic = obj.RegRead(s); 
				if (sNic!=null) {
					window.open("myclient://"+tuid+","+fuid,"_blank");
				}else{
					if(window.confirm('很抱歉，您未安装配配通或安装的不完全，请到官方网站下载最新版本进行安装。')){
						ajaxDownLoad('配配通');
					}
				}	
				}catch(e){
					if(window.confirm('很抱歉，您未安装配配通或安装的不完全，请到官方网站下载最新版本进行安装。')){
						ajaxDownLoad('配配通');
					}
				} 
			 }else{
			 	alert("很抱歉,目前配配通在线打开方式仅支持IE");
			 	return false;
			 }
	 }
	 
}

/**
 * 下载文件
 * @param downName
 */
function ajaxDownLoad(downName) {  
	window.location.href="/memberCallAction!downloadFile.action?path="+downName;
};
