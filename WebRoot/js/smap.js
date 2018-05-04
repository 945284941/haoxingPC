var address;
var cname;
var geocoder, map, marker, navControl, scaleControl, overviewControl, zoomControl, maptypectrl = null;

$.fn.center = function(loaded) {
	var obj = this;
	body_width = parseInt($(window).width());
	body_height = parseInt($(window).height());
	block_width = parseInt(obj.width());
	block_height = parseInt(obj.height());

	left_position = parseInt((body_width / 2) - (block_width / 2)
			+ $(window).scrollLeft());
	if (body_width < block_width) {
		left_position = 0 + $(window).scrollLeft();
	}
	;

	top_position = parseInt((body_height / 2) - (block_height / 2)
			+ $(window).scrollTop());
	if (body_height < block_height) {
		top_position = 0 + $(window).scrollTop();
	}
	;

	if (!loaded) {

		obj.css({
			'position' : 'absolute'
		});
		obj.css({
			'top' : top_position,
			'left' : left_position
		});
		$(window).bind('resize', function() {
			obj.center(!loaded);
		});
		$(window).bind('scroll', function() {
			obj.center(!loaded);
		});

	} else {
		obj.stop();
		obj.css({
			'position' : 'absolute'
		});
		obj.animate({
			'top' : top_position
		}, 200, 'linear');
	}
};

var init = function(address,isOverviewControl,isOperinfoWin,isScaleControl,containerId) {
	$('#'+containerId).empty();

	// 初始化地图
	var myLatLng = new soso.maps.LatLng(36.716928, 116.966149);
	map = new soso.maps.Map(document.getElementById(containerId), {
		center : myLatLng,
		zoomLevel : 13
	});		
	// 显示地图导航平移控件
	navControl = new soso.maps.NavigationControl({
		align : soso.maps.ALIGN.TOP_LEFT,
		margin : new soso.maps.Size(5, 15),
		map : map
	});
	
	// 判断是否显示比例尺控件,1是显示,0是不显示
	if(isScaleControl == '1'){
		// 显示比例尺控件
		scaleControl = new soso.maps.ScaleControl({
			align : soso.maps.ALIGN.BOTTOM_LEFT,
			margin : new soso.maps.Size(30, 15),
			map : map
		});		
	}

	// 判断是否显示鹰眼地图控件,1是显示,0是不显示
	if(isOverviewControl == '1'){
		// 显示鹰眼地图控件
		overviewControl = new soso.maps.OverviewMapControl({
			map : map
		});		
	}

	// 显示缩放指示控件
	zoomControl = new soso.maps.ZoomHintControl({
		map : map
	});

	// 显示地图类型控件
	maptypectrl = new soso.maps.MapTypeControl({
		map : map
	});

	geocoder = new soso.maps.Geocoder();// 声明地址解析类

	// 地址解析
	geocoder
			.geocode(
					{
						'address' : address
					},
					function(results, status) {
						if (status == soso.maps.GeocoderStatus.OK) {
							var position = results.location;
							map.setCenter(position);
							if (marker != null) {
								marker.setMap(null);
							}

							marker = new soso.maps.Marker({
								map : map,
								position : position

							});

							// 判断是否显示信息窗口,1是显示,0是不显示
							if(isOperinfoWin == '1'){
								// 信息窗口
								var infoWin = new soso.maps.InfoWindow({
									map : map
								});
								infoWin.setAnimation(soso.maps.Animation.POP);
								var infoHtml = '<div style="white-space:nowrap; font-size:12px;text-align:left;">公司名称：'
										+ cname + '<br>公司地点：' + address + '</div>';

								infoWin.open(infoHtml, marker);								
							}
							
						} else if (status == soso.maps.GeocoderStatus.NO_RESULTS) {
							alert("没有找到对应地址！");
						} else if (status == soso.maps.GeocoderStatus.ERROR) {
							alert("连接地址解析服务器时出错！");
						} else if (status == soso.maps.GeocoderStatus.INVALID_REUEST) {
							alert("请求无效！");
						} else {
							alert("发生未知错误，响应失败！");
						}
					});
};

/**
 * 遮盖层显示
 * @param ObjID1  遮罩层ID
 * @param ObjID2  弹出层ID
 * @param asId    地址ID
 * @param cid	  公司名称ID
 * @param isOverviewControl 是否显示鹰眼地图控件(0:不显示,1:显示)
 * @param isOperinfoWin 是否显示信息窗口(0:不显示,1:显示)
 */
function _ShowMapDIV(ObjID1, ObjID2, asId,cid,isOverviewControl,isOperinfoWin,isScaleControl,containerId) {
	$('#' + ObjID2).css({
		'height' : $(document).height()
	});
	$('#' + ObjID2).show();
	$('#' + ObjID1).center();
	$('#' + ObjID1).fadeIn();
	address = $("#" + asId).val();
	cname = $("#" + cid).val();
	init(address,isOverviewControl,isOperinfoWin,isScaleControl,containerId);
}
// 关闭遮盖层
function _CloseMapDiv(ObjID1, ObjID2) {
	$('#' + ObjID1).hide();
	$('#' + ObjID2).hide();
}