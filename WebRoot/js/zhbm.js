/**
 * 展会>>我要报名
 */
function onlineApplyFormSubmit(){
	var regTel = /^\d{3,4}-\d{7,8}$/;
	var regphone = /^(((13[0-9]{1})|15[0-9]{1}|18[0-9]{1}|)+\d{8})$/;
	var regInteger = /^-?[1-9]\d*$/;
	var regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	var _applyType = $("#wybm_applyType").val();
	var _name = $("#wybm_name").val();
	var _province = $("#wybm_province").val();
	var _city = $("#wybm_city").val();
	var _area = $("#wybm_area").val();
	var _address = $("#wybm_address").val();
	var _enrollment = $("#wybm_enrollment").val();
	var _contact = $("#wybm_contact").val();
	var _email = $("#wybm_email").val();
	if(_applyType == '0'){
		alert("请选择报名类型！");
		return false;
	}
	if($.trim(_name) == ''){
		$('#wybm_name').focus();
		alert("请填写姓名！");
		return false;		
	}
	if(_province == '0'){
		alert("请选择省！");
		return false;		
	}
	if(_city == '0'){
		alert("请选择市！");
		return false;		
	}
	if(_area == '0'){
		alert("请选择区！");
		return false;		
	}
	if($.trim(_address) == ''){
		$('#wybm_address').focus();
		alert("请填写街道地址！");
		return false;		
	}
	if(_enrollment != ''){
		if(!regInteger.test(_enrollment)){
			$('#wybm_enrollment').focus();
			alert("报名人数只能填写整数！");
			return false;
		}
	}
	if(_contact != ''){
		if (!regTel.exec(_contact) && !regphone.test(_contact)) {
			$('#wybm_contact').focus();
			alert("请正确输入联系方式！例如:15000000000/0755-83485999");
			return false;
		}
	}
	if(_email != ''){
		if (!regEmail.test(_email)) {
			$("#wybm_email").focus();
			alert("电子邮箱格式不正确！");
			return false;
		}		
	}
	$.ajax({
		type:'POST',
		url:'zhbmAdd.html',
		data : $("#onlineApplyForm").serialize(),
		dataType:'json',
		success:function(result){
			if(result.success){
				alert("提交信息成功！");
				window.location.href = "http://zh.qlqpw.com";
			}else{
				alert("提交信息失败！");
				return false;
			}
		},
		error : function() {
			alert('请求失败!');
			return false;
		}
	});	
}
