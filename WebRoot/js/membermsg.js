/*  
 *@Description: 个人会员详细信息注册
 *@Author:yhl 
 *@Update:2013-06-8
 */

/*  
 *@Description: 弹出层
 *@Author:yhl 
 *@Update:2013-06-8
 */
function showMember(divbg, divId) {
//mask=document.createElement("div");
	yScroll = this.pageYOffset; 
	var mask = document.getElementById(divbg);
	var W = $(document).width();
	var H = $(document).height();	
	//mask.id="mask";
	mask.style.cssText = "position:absolute;z-index:5;width:"
			+ W
			+ "px;height:"
			+ H
			+ "px;background:#000;filter:alpha(opacity=30);opacity:0.3;top:0;left:0;";
	//document.body.appendChild(mask);
	mask.style.display = "block";
	var o = document.getElementById(divId);
	o.style.display = "block";
	o.style.top = (H/2  - 100)+"px";
	o.style.left = (W/2 - 200)+"px";
		
}

function hiddenMember(divbg, divId) {
	var o = document.getElementById(divId);
	o.style.display = "none";
	o.style.top = "253px";
	o.style.left = "400px";
	var maskdiv = document.getElementById(divbg);
	maskdiv.style.display = "none";
}

function memberMsgSubForm() {
	var regTel = /^\d{3,4}-\d{7,8}$/;
	var regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	var regphone = /^(((13[0-9]{1})|15[0-9]{1}|18[0-9]{1}|)+\d{8})$/;
	var reg = /^[A-Za-z\u4e00-\u9fa5]{2,20}$/;
	var regf = /^[A-Za-z0-9\u4e00-\u9fa5]{1,20}$/;
	var regAddress = /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]{5,200}$/;
	var regnum = /^(?:[1-9][0-9]?|1[0-4][0-9]|150)$/;
	var firstname = $('#firstname').val();
	var truename = $('#truename').val();
	var mobile = $('#mobile').val();
	//var age = $('#age').val();
	var jobRole = $('#jobRole').val();
	var papersNum = $('#card').val();
	if (firstname != '') {
		if (!regf.test(firstname)) {
			$('#firstname').focus();
			alert('会员昵称只可输入1-20位英文、汉字、数字！');
			return false;
		}
	} else {
		$('#firstname').focus();
		alert('请输入会员昵称！');
		return false;
	}
	if (truename != '') {
		if (!reg.test(truename)) {
			$('#truename').focus();
			alert('真实姓名只可输入2-20位英文、汉字！');
			return false;
		}
	} else {
		$('#truename').focus();
		alert('请输入真实姓名！');
		return false;
	}
	var proId = $('#pro').val();
	if (proId == '0') {
		alert('请选择所在省份！');
		return false;
	}
	var cityId = $('#regionlistOption').val();
	if (document.getElementById('regionlistOption').style.display != "none") {

		if (cityId == '0') {
			alert('请选择所在市！');
			return false;
		}
	}
	var areaId = $('#area').val();
	if (document.getElementById('area').style.display != "none") {

		if (areaId == '0') {
			alert('请选择所在区！');
			return false;
		}
	}
	if (papersNum == '') {
		$('#card').focus();
		alert('请输入身份证号码！');
		return false;
	}
	;
	papersNum = papersNum.replace(/\s+/g, "");
	var msg = checkIdcard(papersNum);
	if (msg != 'true') {
		$('#card').focus();
		alert(msg);
		return false;
	}
	var address = $('#address').val();
	if (address == '') {
		$('#address').focus();
		alert('请填写详细地址！');
		return false;
	} else {
		if (!regAddress.test(address)) {
			$('#address').focus();
			alert('详细地址中只可输入5-200位英文、汉字、数字及下划线！');
			return false;
		}
	}
	if (mobile != '') {
		if (!regphone.test(mobile)) {
			$('#mobile').focus();
			alert('手机格式不正确，请重新输入！');
			return false;
		}
	} else {
		$('#mobile').focus();
		alert('请输入手机号码！');
		return false;
	}
	var engageindustry = $('#engageindustry').val();
	if (engageindustry == '0') {
		alert('请选择从事领域！');
		return false;
	}
	var telphone = $('#telphone').val();
	if (telphone != '') {
		if (!regTel.exec(telphone)) {
			$('#telphone').focus();
			alert('请输入办公电话!例如:0755-83485999');
			return false;
		}
	} 

	//if(age != ''){
	//if(!regnum.test(age)){
	//$('#age').focus();
	//alert('年龄只可输入小于150的正整数！');
	//return false;
	//}
	//}
	if (jobRole == '0') {
		alert('请选择岗位级别！');
		return false;
	}
	if ($('#email').val() != '') {
		if (!regEmail.test($('#email').val())) {
			$('#email').focus();
			alert('您的电子邮箱格式不正确！');
			return false;
		} else {
			if ($('#email').val().length > 50) {
				$('#email').focus();
				alert('电子邮箱长度不可超过50位，请重新输入！');
				return false;
			}
		}
	} else {
		$('#email').focus();
		alert('请输入您的电子邮箱！');
		return false;
	}
$.ajax( {
		url : 'toActiveCheckMemberName.html',
		type : 'POST',
		data : 'firstName=' + firstname,
		success : function(data) {
			var r = $.parseJSON(data);
			if (r == 'exist') {
				$('#firstname').focus();
				alert('会员昵称已经存在，请重新输入！');
				return false;

			}else if(r == 'oldsession'){
				alert('页面已过期，请重新注册！');
				window.location.href = "index.jsp";
				}else {
			
						$.ajax( {
							type : 'POST',
							url : 'ActivememberMsgRegister.html',
							data : $('#memberMsgForm').serialize(),
							//data:list,	
							dataType : 'text',
							error : function() {
								//alert("JQuery AJAX Error!");
							alert('请求超时请重试！');
							return false;
						},
						success : function(data) {
							var msg = $.parseJSON(data);
							if (msg == 'success') {
								alert('完善信息成功！');
					
								window.location.href = "/active/loginRegister/ActiveMemberSuccess.jsp";
							}
							if (msg == 'oldsession') {
								alert('页面已过期，请重新修改信息！');
								window.location.href = "activeIndex.jsp";
							}
							if (msg == 'fail') {
								alert('完善信息失败！');
								return false;
							}
					
						}
						});
			
			}

		}
	});
	
	
	
	
	

}

function displayPro() {
	var proId = document.getElementById("pro").value;
	$.ajax( {
		url : 'toRegions.html',
		type : 'POST',
		data : 'proId=' + proId,
		dataType : 'json',
		error : function() {
			alert('请求失败');
			return false;
		},
		success : function(regionlist) {
			document.getElementById("regionlistOption").innerHTML = "";
			if (regionlist.length > 0) {
				$("#regionlistOption").append(
						"<option value='0'>-选择市-</option>");
				for ( var i = 0; i < regionlist.length; i++) {
					$("#regionlistOption").append(
							"<option value='" + regionlist[i].id + "'>"
									+ regionlist[i].name + "</option>");
				}
				$("#regionlistOption").show();
			} else {
				$("#regionlistOption").hide();
			}
		}
	});

}

function displayCS() {
	var cityId = $('#regionlistOption').val();
	$.ajax( {
		url : 'toArea.html',
		type : 'POST',
		data : 'cityId=' + cityId,
		dataType : 'json',
		error : function() {
			alert('请求失败');
			return false;
		},
		success : function(arealist) {
			document.getElementById("area").innerHTML = "";
			if (arealist.length > 0) {
				$("#area").append("<option value='0'>-选择区-</option>");
				for ( var i = 0; i < arealist.length; i++) {
					$("#area").append(
							"<option value='" + arealist[i].id + "'>"
									+ arealist[i].name + "</option>");
				}
				$("#area").show();
			} else {
				$("#area").hide();
			}
		}
	});

}
