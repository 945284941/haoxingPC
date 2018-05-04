//区域商家推荐
var province;// 省份
var city;// 城市
var f;// 1F-7F
var rcr_str;

// 根据省份获取市列表
function floor_getCitys(id, citySelId, num) {
	// 切换选择其他省份时将下拉框标签内容清空
	$('#' + citySelId).html("");
	$.ajax({
		type : 'POST',
		url : 'pubGetCitys.html',
		data : 'rcr.province=' + id,
		dataType : 'json',
		success : function(cityList) {
			$('#' + citySelId).append("<option value='0'>选择市</option>");
			for ( var i = 0; i < cityList.length; i++) {
				$('#' + citySelId).append(
						"<option value='" + cityList[i].id + "'>"
								+ cityList[i].name + "</option>");
			}
			if (id == '0') {
				city = $("#floor" + num + "_qysjtj_cityList").val();// 获取城市
				f = $("#f" + num).val();// 获取楼层位置
				getRComRecommends(city, num);
			}
		},
		error : function() {
			alert('请求失败!');
			return false;
		}
	});
}
// 根据地区获取其对应的商家推荐
function getRComRecommends(id, num) {
	province = $("#floor"+num+"_qysjtj_provinceList").val();// 获取省份
	f = $("#f" + num).val();// 获取楼层位置
	// 切换区域时将div内容清空
	$("#rcr_" + num).html("");
	$
			.ajax({
				type : 'POST',
				url : 'indexFloor/getRComRecommends.html',
				data : {
					"rcr.city" : id,
					"rcr.province" : province,
					"rcr.floor" : f
				},
				dataType : 'json',
				success : function(data) {
					if (data.length == 0) {
						rcr_str = "<span style=\"color:red;\">暂时没有符合条件的数据！</span>";
					} else {
						rcr_str = "";
						var comSrc = "";
						for ( var i = 0; i < data.length; i++) {
							if(null != data[i].comSrc && '' != data[i].comSrc){
								comSrc = data[i].comSrc;
							}else{
								comSrc = "330-206zwpic.gif";
							}
							rcr_str += "<li>"
									+ "<p><a href=\"/Shop/index_"+data[i].companyId+".html\"><img src=\"images/"
									+ comSrc
									+ "\" width=\"240\" height=\"150\"/></a></p>"
									+ "<p class=\"tjsjmc\"><a class=\"red\" href=\"/Shop/index_"+data[i].companyId+".html\">"
									+ data[i].cname + "</a></p>"
									+ "<p>" + data[i].carBrandStr
									+ "</p>" + "</li>";
						}
						;
					}
					$("#rcr_" + num).append(rcr_str);
				},
				error : function() {
					alertMsg.warn("请求失败!");
				}
			});
};

// 访问更多区域商家推荐
function rComRecommends_toMore(num) {
	//var p = $("#floor" + num + "_qysjtj_provinceList").val();
	//var c = $("#floor" + num + "_qysjtj_cityList").val();
	//var f = $("#f" + num).val();
	//openNewDialog("/rcomrecommends/toMore/"+p+"/"+c+"/"+f+".html");
	openNewDialog("/rcomrecommends/toMore/"+0+"/"+0+"/"+num+".html");
};

// 普通会员-某分类下的主营产品
function comShop_getComGoods(id, companyId, carPartsId) {
	$
			.ajax({
				type : 'post',
				url : 'Shop/getComGoodsListByCat.html',
				dataType : 'json',
				data : {
					"goods.carPartsId" : carPartsId,
					"goods.companyId" : companyId
				},
				success : function(comGoodsListByCat) {
					$("#com_goods").empty();
					if (id != null) {
						$("#comGoods_zy_goodsCat li a").removeClass("hover");
						$("#" + id).addClass("hover");
						$('#shopIndex_more').attr('href',"/Shop/moreComgoods/"+carPartsId+"_"+companyId+".html");
					}
					if (comGoodsListByCat.length > 0) {
						for ( var i = 0; i < comGoodsListByCat.length; i++) {
							if (i < 15) {
								var name = "";
								if(null!=comGoodsListByCat[i].name&&comGoodsListByCat[i].name.length>18){
									name = comGoodsListByCat[i].name.substring(0,18);
								}else{
									name = comGoodsListByCat[i].name;
								}
								$("#com_goods")
										.append(
												"<div class=\"gotpicz\">"
														+ "<p class=\"eproduct\"><a href=\"goods/"+comGoodsListByCat[i].id+".html\" target=\"_blank\"><img src=\""
														+ comGoodsListByCat[i].defaultPicSrc
														+ "\" width=\"200\" height=\"150\"/></a></p>"
														+ "<p class=\"p-name\"><a href=\"goods/"+comGoodsListByCat[i].id+".html\" target=\"_blank\" title=\""+comGoodsListByCat[i].name+"\">"
														+ name
														+ "</a></p>"
														+ "<p class=\"p-name\">"
														+ comGoodsListByCat[i].bn
														+ "</p>"
														+ "<p class=\"p-price\"><span class=\"dlf\">¥</span>"
														+ comGoodsListByCat[i].price
														+ "</p>" + "</div>");
							};
						};
					} else {
						$("#com_goods")
								.append(
										"<span style=\"color:red;\">暂时没有符合条件的数据！</span>");
					};
				},
				error : function() {
					alert('请求失败,请稍后再试!');
				}
			});
}

// 留言
function toLeaveMessage(cid,memberId){
	var url = "/Shop/leaveMessage/"+cid+".html";
	if(memberId != null && memberId != ''){
		//用户登录状态下
		window.location.href = url;
	}else {
		//用户未登录状态下
		showLogin('mask','pop_500',url,'0','','');
	}
}

// 添加留言信息
function _addCompanysMessageFromSub() {
	var messageContent = $('#message').val();
	var verifyCode = $('#verifyCode').val();
	if (messageContent == '' || messageContent == null) {
		alert('请输入您的留言！');
		return false;
	}
	if (verifyCode == '' || verifyCode == null) {
		alert('请输入验证码！');
		return false;
	}
	$.ajax({
		url : 'common!checkValidateCode.action',
		type : 'POST',
		data : {"verifyCode" : verifyCode},
		dataType : 'JSON',
		success : function(data) {
			if (data.msg == 'isNull') {
				alert('验证码不能为空！');
				return false;
			} else if (data.msg == 'fail'){
				alert("验证码不正确！");
				return false;
			}else{
				$.ajax({
					url : 'common!checkSession.action',
					type : 'POST',
					dataType : 'JSON',
					success : function(json) {
						if (json) {
							document.getElementById("addMessageForm").submit();
						} else {
							showLogin('mask', 'pop_500', 'addMessageForm', '1', '','');
						}
					}
				});				
			}
		}
	});	
}

//重置
function companysMessageFrom_clean(){
	$("input[name='res']").click(); 
}

// 打开新窗口页面
function openNewDialog(url){
	window.open(url, "_blank");
}