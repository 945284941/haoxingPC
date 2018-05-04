var firstId;
var secondId;
var thirdId;
function getFirstDateByGrade(id, firstGoodsCatId, secondGoodsCatId) {
	$.ajax({
		type : 'post',
		url : 'catalogueAction!gainFirstCatalogue.action',
		data : "pid=" + id,
		dataType : 'json',
		success : function(fistGoodsCatList) {
			$("#firstGoodsCatList").append(
					"<option value='' class='xzk'>请选择(可不选)</option>");
			for ( var i = 0; i < fistGoodsCatList.length; i++) {
				if (firstGoodsCatId == fistGoodsCatList[i].id) {
					$("#firstGoodsCatList").append(
							"<option selected=" + "selected" + " value='"
									+ fistGoodsCatList[i].id + "'>"
									+ fistGoodsCatList[i].name + "</option>");
					getSecondDateByPid(firstGoodsCatId, secondGoodsCatId);
				} else {
					$("#firstGoodsCatList").append(
							"<option value='" + fistGoodsCatList[i].id + "'>"
									+ fistGoodsCatList[i].name + "</option>");
				}
			}
		}
	});
}

function getSecond() {
	$("#secondGoodsCatList").empty();// 清空二级菜单下拉框
	firstId = $("#firstGoodsCatList").val();// 获得一级菜单的id的值
	if (firstId != '') {
		if (firstId.length == 1) {
			$("#secondGoodsCatList").append(
					"<option value='' class='xzk'>请选择(可不选)</option>");
		} else {
			getSecondDateByPid(firstId, '1');
		}
	}
}

function getSecondDateByPid(id, secondGoodsCatId) {
	$.ajax({
				type : "post",
				dataType : 'json',
				url : 'secCatalogue/' + id + '.html',
				cache : false,
				success : function(secondGoodsCatList) {
					$("#secondGoodsCatList").append(
							"<option value='' class='xzk'>请选择(可不选)</option>");
					for ( var i = 0; i < secondGoodsCatList.length; i++) {
						if (secondGoodsCatId == secondGoodsCatList[i].id) {
							$("#secondGoodsCatList").append(
									"<option selected=" + "selected"
											+ " value='"
											+ secondGoodsCatList[i].id + "'>"
											+ secondGoodsCatList[i].name
											+ "</option>");
						} else {
							$("#secondGoodsCatList").append(
									"<option value='"
											+ secondGoodsCatList[i].id + "'>"
											+ secondGoodsCatList[i].name
											+ "</option>");
						}
					}
				}
			});
}

// 该品牌下的车系 主页
function getCarLine(id) {
	$("#carBrand a").removeClass("hover");
	if (id != null) {
		$("#" + id).addClass("hover");
		document.getElementById("carBrandId").value = id;
		document.getElementById("carBrandIdS").value = id;
	}
	$.ajax({
				type : "post",
				dataType : 'json',
				url : "catalogueAction!gainCarLineListaction.action",
				data : "pid=" + id,
				cache : false,
				success : function(map) {
					$("#carLineUL").empty();
					$("#carVersionList").empty();
					for ( var i = 0; i < map.carLineList.length; i++) {

						if (i == 0) {
							$("#carLineUL")
									.append(
											" <li class='cxfl'><a id='"
													+ map.carLineList[i].id
													+ "' class='hover' onclick=\"getCarVersion('"
													+ map.carLineList[i].id
													+ "')\">" + "["
													+ map.carLineList[i].name
													+ "]" + "</a></li>");
							for ( var j = 0; j < map.carVersionList.length; j++) {
								$("#carVersionList").append(
										"<option value='"
												+ map.carVersionList[j].id
												+ "'>"
												+ map.carVersionList[j].name
												+ "</option>");
							}
						} else {
							$("#carLineUL").append(
									" <li class='cxfl'><a id='"
											+ map.carLineList[i].id
											+ "' onclick=\"getCarVersion('"
											+ map.carLineList[i].id + "')\">"
											+ "[" + map.carLineList[i].name
											+ "]" + "</a></li>");
						}
					}
				}
			});
}
// 该品牌下的车型
function getCarVersion(id) {
	$("#carLineList a").removeClass("hover");
	if (id != null) {
		$("#" + id).addClass("hover");
		document.getElementById("carLineIdS").value = id;
		document.getElementById("carLineId").value = id;
	}

	$.ajax({
		type : "post",
		dataType : 'json',
		url : "catalogueAction!gainCarVersionList.action",
		data : "pid=" + id,
		cache : false,
		success : function(carVersionList) {
			$("#carVersionList").empty();
			for ( var i = 0; i < carVersionList.length; i++) {
				$("#carVersionList").append(
						"<option value='" + carVersionList[i].id + "'>"
								+ carVersionList[i].name + "</option>");
			}

		}
	});
}

// 左边目录导航
function getSecondCatalogue(id, name, index) {
	document.getElementById('secondtc').style.display = "inline";
	document.getElementById('secondtc').className = "fy" + index;
	$.ajax({
		type : 'post',
		url : 'secCatalogue/' + id + '.html',
		dataType : 'json',
		success : function(secondGoodsCatList) {
			$("#secondCatalogueList").empty();
			$("#secondCatalogueList").attr("name", id);
			for ( var i = 0; i < secondGoodsCatList.length; i++) {
				$("#secondCatalogueList").append(
						"<li><a title=" + secondGoodsCatList[i].name
								+ " href='searchGoodsListS/"
								+ secondGoodsCatList[i].id + "/" + name + "/"
								+ id + ".html' >" + secondGoodsCatList[i].name
								+ " </a></li>");
			}
			//onmouseover=getThirdCatalogue('"+secondGoodsCatList[i].id+"','"+secondGoodsCatList[i].name+"','"+i+"')
		}
	});

}

function getThirdCatalogue(id, name, index) {
	document.getElementById('secondtc').style.display = "inline";
	document.getElementById('secondtc1').style.display = "inline";
	document.getElementById('secondtc1').className = "ft" + index;
	$.ajax({
		type : 'post',
		url : 'secCatalogue/' + id + '.html',
		dataType : 'json',
		success : function(ThirdGoodsCatList) {
			$("#ThirdCatalogueList").empty();
			$("#ThirdCatalogueList").attr("name", id);
			for ( var i = 0; i < ThirdGoodsCatList.length; i++) {
				$("#ThirdCatalogueList").append(
						"<li><a title=" + ThirdGoodsCatList[i].name
								+ " href='searchGoodsListS/"
								+ ThirdGoodsCatList[i].id + "/" + name + "/"
								+ id + ".html'  >" + ThirdGoodsCatList[i].name
								+ " </a></li>");
			}
		}
	});
}
// 设置显示
function setDisplayT() {
	document.getElementById('secondtc').style.display = "inline";
	var id = $("#secondCatalogueList").attr("name");
	if (id != null) {
		$("#" + id).addClass("hover");
	}
}
// 设置隐藏
function setDisplayF() {
	$("#firstGoodsCats a").removeClass("hover");
}

//设置显示
function setDisplayT1() {
	document.getElementById('secondtc').style.display = "inline";
	document.getElementById('secondtc1').style.display = "inline";
	var id = $("#ThirdCatalogueList").attr("name");
	var pid = $("#secondCatalogueList").attr("name");
	if (id != null) {
		$("#" + id).addClass("hover");
	}
	if(pid != null){
		$("#" + id).addClass("hover");
	}
}
//设置隐藏
function setDisplayF1() {
	document.getElementById('secondtc').style.display = "none";
	document.getElementById('secondtc1').style.display = "none";
	$("#firstGoodsCats a").removeClass("hover");
}