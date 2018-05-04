var reg = /^[A-Za-z\u4e00-\u9fa5]{2,20}$/;
var regphone = /^(((13[0-9]{1})|15[0-9]{1}|18[0-9]{1}|)+\d{8})$/;
function khzjMsgFormSub(){
	
	var	kouhao = '';
	var che = $("input[name='hd']:checked").size();
	if(che == '0' || che == 0){
		alert('请选择您中意的口号！');	
		return false;
	}else{
		kouhao = $("input[name='hd']:checked").val(); 
		$('#khContentid').val(kouhao);
	}
	var khContentid = $('#khContentid').val();
	var tpUsername = $('#tpUsername').val();
	var tpTelphone = $('#tpTelphone').val();
	
	if (tpTelphone != '') {
		if (!regphone.test(tpTelphone)) {
			$('#tpTelphone').focus();
			alert('手机格式不正确，请重新输入！');
			return false;
		}
	} else {
		$('#tpTelphone').focus();
		alert('请输入手机号码！');
		return false;
	}
	var tpTelphoneCode = $("#tpTelphoneCode").val();
	if (tpTelphoneCode == '') {
		alert('请输入手机验证码！');
		 return false;
	}
	$.ajax({
		url:'checkPhone.html',
		type:'POST',
		dataType:'JSON',
		data:'tpTelphone='+tpTelphone,
		error : function() {
			//alert("JQuery AJAX Error!");
			alert('请求超时请重试！');
			return false;
		},
			success : function(msg) {
				if(msg == 'no'){
					alert('感谢您的支持与厚爱，您已投票过了，不能再投票！');
					return false;
				}else{
					$.ajax({
						url : 'person/ajaxMobileCodeBoolean',
						type : 'POST',
						dataType:'JSON',
						data : 'telNum=' + tpTelphone + '&telCode=' + tpTelphoneCode,
						success : function(m) {
							if(m.success){
								
								$.ajax({
									url:'upkhzj.html',
									type:'POST',
									dataType:'JSON',
									data:'tpTelphone=' +tpTelphone +'&tpUsername='+tpUsername+'&khContentid='+khContentid,
									error:function(){
										alert('请求超时请重试！');
										return false;
									},
									success : function(data) {
										if(data == 'success'){
											alert('您已成功投票，感谢您的支持！');
											//showsplbtitle('tanchu', 'tctkbm');
											window.location.href = "tokhzj.html";
										}else{
											alert('投票失败，请重新投票！');
											return false;
										}
									}
								});
									
							}else {
								 alert(m.msg);
							}
						}
					});
				}
				
			}
	});
	
}
