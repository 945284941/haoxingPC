/**
 * 个人会员(wangmei)
 */

var regPwd = /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,10}$/;
var regf = /^[A-Za-z0-9\u4e00-\u9fa5]{2,20}$/;
var regt = /^[A-Za-z\u4e00-\u9fa5]{2,20}$/;
var regAddress = /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]{5,200}$/;
var regTel = /^\d{3,4}-\d{7,8}$/;
var regphone = /^(((13[0-9]{1})|15[0-9]{1}|18[0-9]{1}|17[0-9]{1}|14[0-9]{1}|)+\d{8})$/;
var regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
var regZip = /^[1-9][0-9]{5}$/;
var rand ="";// 随机数和字母
var m_email;
var m_email_code;
var mobile_ = false;// 手机号
var mobileCode_ = false;// 手机校验码
/*******************************************************************************
 * 个人资料tab选项卡
 * 
 * @param {Object}
 *            thisObj
 * @param {Object}
 *            num
 * @param {Object}
 *            active
 * @param {Object}
 *            normal
 */
function personInfoTabs(thisObj,num,active,normal){
	if(thisObj.className == active)return;
	var tabObj = thisObj.parentNode.id;
	var tabList = document.getElementById(tabObj).getElementsByTagName("span");
	for(var i=0; i <tabList.length; i++){
		if (i == num){
			if(1 == num){
				
			   // 循环遍历学历单选框,判断值是否相等,如相等,将其设置为选中状态
			   $("input[name='member.education']").each(function(){
					if($(this).val() == education){
						$(this).attr("checked",true);
					}   
			   });
			   
			   // 循环遍历所在领域单选框,判断值是否相等,如相等,将其设置为选中状态
			   $("input[name='member.scopes']").each(function(){
					if($(this).val() == scopes){
						$(this).attr("checked",true);
					}   
			   });
			   
			   // 循环遍历岗位单选框,判断值是否相等,如相等,将其设置为选中状态
			   // 当选中为其他时,显示input输入框,并为其赋值
			   $("input[name='member.vocation']").each(function(){
				   if($(this).val() == vocation){
					   $(this).attr("checked",true);
					   $("#m_vocation").hide();
					   return false;
				   }else{
					   if(vocation != ''){
						   $("#m_vocation6").attr("checked",true);
						   if('' != $('input:radio[name="member.vocation"]:checked').val()){
							   $("#m_vocation7").val(vocation);
						   }
						   $("#m_vocation").show();						   
					   }
				   }
			   });
			   
			   // 点击某个岗位时判断是否选中的其他,如其他,则显示其他输入框
			   $("input[name='member.vocation']").click(function(){
				   if($(this).val() == 'other'){
					   if(vocation != ''){
						   if(vocation == $(this).val()){
							   $("#m_vocation7").val(vocation);
						   }
					   }
					   $("#m_vocation").show();
				   }else{
					   $("#m_vocation").hide();
				   }            
				   return true;        
			   });			   
			   
			   // 循环遍历职级单选框,判断值是否相等,如相等,将其设置为选中状态
			   $("input[name='member.jobRole']").each(function(){
					if($(this).val() == jobRole){
						$(this).attr("checked",true);
					}   
			   });			   
			}
		   thisObj.className = active;
		   document.getElementById(tabObj+"_"+i).style.display = "block";
		}else{
		   tabList[i].className = normal;
		   document.getElementById(tabObj+"_"+i).style.display = "none";
		}
	}
}

// 个人会员基本信息修改
function _updateBasicInfoForPerson(){
	var m_firstname = $('#m_firstname').val();
	var m_lastname = $('#m_lastname').val();
	var m_truename = $("#m_truename").val();
	var m_gender = $("#m_gender").val();
	var m_card = $("#m_card").val();
	var m_address = $("#m_address").val();
	var m_telphone = $("#m_telphone").val();
	var m_email = $("#m_email").val();
	var path = "";
	var isUndefined = undefined;

	if(isUndefined == m_lastname){
		if (m_firstname != '') {
			if (!regf.test(m_firstname)) {
				$('#m_firstname').focus();
				alert('会员昵称只可输入2-20位英文、汉字、数字！');
				return false;
			}
			path = '&member.firstname='+m_firstname;
		} else {
			$('#m_firstname').focus();
			alert('22请输入会员昵称！');
			return false;
		}		
	}
	if(isUndefined == m_firstname){
		if(m_lastname != ''){
			if (!regf.test(m_lastname)) {
				$('#m_lastname').focus();
				alert('会员昵称只可输入2-20位英文、汉字、数字！');
				return false;
			}
			path = '&member.lastname='+m_lastname;
		}else{
			$('#m_lastname').focus();
			alert('11请输入会员昵称！');
			return false;		
		}		
	}

	if (m_truename != '') {
		if (!regt.test(m_truename)) {
			$('#m_truename').focus();
			alert('真实姓名只可输入2-20位英文、汉字！');
			return false;
		}
	} else {
		$('#m_truename').focus();
		alert('请输入真实姓名！');
		return false;
	}
	if(m_card != ''){
		m_card = m_card.replace(/\s+/g, "");
		var msg = checkIdcard(m_card);
		if (msg != 'true') {
			$('#m_card').focus();
			alert(msg);
			return false;
		}		
	}else{
		$('#m_card').focus();
		alert('请输入身份证号码！');
		return false;		
	}
	if (m_address != '') {
		if (!regAddress.test(m_address)) {
			$('#m_address').focus();
			alert('详细地址中只可输入5-200位英文、汉字、数字及下划线！');
			return false;
		}		
	} else {
		$('#m_address').focus();
		alert('请填写详细地址！');
		return false;
	}
	if (m_email != '') {
		if (!regEmail.test(m_email)) {
			$('#m_email').focus();
			alert('您的邮箱格式不正确！');
			return false;
		} else {
			if (m_email.length > 50) {
				$('#m_email').focus();
				alert('邮箱长度不可超过50位，请重新输入！');
				return false;
			}
		}
	} else {
		$('#m_email').focus();
		alert('请输入您的邮箱地址！');
		return false;
	}
	$.ajax({
		url : "person/updateBasicInfo.html",
		type : "post",
		data : $("#updatePersonBasicInfoForm").serialize(),
		success : function(result){
			var rt = $.parseJSON(result);
			if(rt.res == "expiry"){
				alert(rt.msg);
				return false;					
			}else if(rt.res == "error"){
				alert(rt.msg);
				return false;					
			}else if(rt.res == "fail"){
				alert(rt.msg);
				return false;					
			}else{
				alert(rt.msg);
				window.location.href = "person/showBasicInfo.html";					
			}			
		}
	});
}

// 个人会员详细信息修改
function _updateDetailInfoForPerson(){
	var m_scopes = $('input:radio[name="member.scopes"]:checked').val();
	var m_vocation = $('input:radio[name="member.vocation"]:checked').val();
	var m_jobRole = $('input:radio[name="member.jobRole"]:checked').val();
	var m_vocation7 = $("#m_vocation7").val();
	var flag = true;
	if(null == m_scopes){
		alert('请选择所在领域！');
		return false;		
	}
	if('other' == m_vocation){
		if(m_vocation7 != ''){
			   $("input[name='member.vocation']").each(function(){
				   if($(this).val() == m_vocation7){
						alert('您填写的岗位已存在,请填写其他岗位！');
						flag = false;
						return flag;
				   }
			   });
		}else{
			alert('请填写您的岗位！');
			flag = false;	
		}
	}
	if(null == m_jobRole){
		alert('请选择职级！');
		return false;		
	}
	if(flag){
		$("#m_vocation6").val(m_vocation7);
		$.ajax({
			url : "person/updateDetailInfo.html",
			type : "post", 
			data : $("#updatePersonDetailInfoForm").serialize(),
			success : function(result){
				var res = $.parseJSON(result);
				if(res.success){
					alert(res.msg);
					window.location.href = "person/showBasicInfo.html";
				}else{
					alert(res.msg);
					return false;
				}
			}
		});		
	}
}

// 检验手机号码是否已绑定
function isBindMobile(mobileInpId){
	if(validateMobile(mobileInpId)){
		$.ajax({
			url : "person/isBindMobile.html",
			type : "post",
			data : {
				"mobileNum" : $("#"+mobileInpId).val()
			},
			success : function(map){
				var rt = $.parseJSON(map);
				if(rt.res == 'sessionexpiry'){
					alert(rt.msg);
					window.location.href = "/index.jsp";
				}else if(rt.res == 'isBind'){
					alert(rt.msg);
					return false;
				}else{
					return true;
				}
			}
		});
		return true;
	}else{
		return false;
	}
}
// 手机号码修改
function _updateMobile(tanchu,shxx,type,mobileInpId,mobileCodeId){
	if(validateMobile(mobileInpId)){
		$.ajax({
			url : "person/isBindMobile.html",
			type : "post",
			data : {
				"mobileNum" : $("#"+mobileInpId).val()
			},
			success : function(map){
				var rt = $.parseJSON(map);
				if(rt.res == 'sessionexpiry'){
					alert(rt.msg);
					window.location.href = "/index.jsp";
				}else if(rt.res == 'isBind'){
					alert(rt.msg);
					return false;
				}else{
					if(validateMobileCode(mobileCodeId)){
						$.ajax({
							url : "person/updateMobile.html",
							type : "post",
							data : {
								"mobileNum" : $("#"+mobileInpId).val(),
								"mobileCode" : $("#"+mobileCodeId).val()
							},
							success : function(result){
								var rt = $.parseJSON(result);
								if(rt.res == "expiry"){
									alert(rt.msg);
									return false;					
								}else if(rt.res == "error"){
									alert(rt.msg);
									return false;					
								}else if(rt.res == "fail"){
									alert(rt.msg);
									return false;					
								}else{
									alert(rt.msg);
									_closePubDialog(tanchu, shxx, type);
									if(rt.userType=="company"){
										window.location.href="company/companyMember/gainCompanyMessageById.html";
									}else{
										window.location.href = "person/showBasicInfo.html";
									}
								}
							}
				       });			
					}					
				}
			}
		});
	}
}

// 发送手机验证码(修改手机)
function getMobileCodeForUpdateMobile(objId,mobileInpId,type){
	if(validateMobile(mobileInpId)){
		$.ajax({
			url : "person/isBindMobile.html",
			type : "post",
			data : {
				"mobileNum" : $("#"+mobileInpId).val()
			},
			success : function(map){
				var rt = $.parseJSON(map);
				if(rt.res == 'sessionexpiry'){
					alert(rt.msg);
					window.location.href = "/index.jsp";
				}else if(rt.res == 'isBind'){
					alert(rt.msg);
					return false;
				}else{
					$.ajax({
						url : "person/sendMobileCode.html",
						type : "post",
						data : {
							"mobileNum" : $("#"+mobileInpId).val(),
							"type" : type
						},
						success : function(map){
							var rt = $.parseJSON(map);
							if(rt.success){
								alert("发送成功！");
					            //时间倒计时
								document.getElementById(objId).disabled = true;    
					            for(i=1;i<=(wait/1000);i++) {      
					                window.setTimeout("doUpdate(" + i + ",'"+objId+"')", i * 1000);      
					            }      
					            window.setTimeout("Timer('"+objId+"')", wait);				
							}else{
								alert("发送失败！");
							}
						}
					});					
				}
			}
		});
	}	
}

//show dialog
function _showPubDialog(tanchu,shxx,type) {
	yScroll = this.pageYOffset; 
	var mask = document.getElementById(tanchu);
	var W = $(document).width();
	var H = $(document).height();	
	mask.style.cssText = "position:absolute;z-index:1001;width:"
			+ W
			+ "px;height:"
			+ H
			+ "px;background:#000;_background:#dedede;filter:alpha(opacity=30);opacity:0.3;top:0;left:0; ";
	mask.style.visibility = "visible";
	var o = document.getElementById(shxx);
	o.style.visibility = "visible";	
}
// close dialog
function _closePubDialog(tanchu,shxx,type) {
	var o = document.getElementById(shxx);
	o.style.visibility = "hidden";
	var maskdiv = document.getElementById(tanchu);
	maskdiv.style.visibility = "hidden";
	if(type==1){
		$('#m_check_questionAnswer').val('');
	}else if(type==2){
		$('#xgmm_mobile').val('');
		$('#xgmm_mobile_yzm').val('');
	}else if(type==3){
		$('#m_email').val('');
		$('#m_email_yzm').val('');	
	}else if(type==4){
		$('#m_mobile').val('');
		$('#m_mobile_yzm').val('');
	}else if(type==5){
		$('#m_payPassword').val('');
		$('#m_payPasswordPwd').val('');
		$('#zfmmxg_mobile').val('');
		$('#zfmmxg_mobile_yzm').val('');
	}else{
		$('#updateMobile_yzm').val('');
	}
}

// 设置安全保护问题
function _setUpSecurityProtection(toUrl){
	var m_questionId = $("#m_questionId").val();
	var m_questionAnswer = $("#m_questionAnswer").val();
	if('0' == m_questionId){
		alert("请选择安全保护问题！");
		return false;
	}else{
		if('' == m_questionAnswer){
			alert("请填写安全保护问题答案！");
			return false;
		}
	}
	$.ajax({
		url : "person/setUpSecurityProtection.html",
		type : "post", 
		data : {
				  "questionId" : m_questionId,
				  "questionAnswer" : m_questionAnswer
			   },
		success : function(result){
			var res = $.parseJSON(result);
			if(res.success){
				alert(res.msg);
				window.location.href = toUrl;
			}else{
				alert(res.msg);
				return false;
			}
		}
	});	
};

// 验证安全保护问题
function _isCorrectByCheckQuestion(tanchu,divId1,divId2,type){
	var questionAnswer = $("#m_check_questionAnswer").val();
	if(questionAnswer == ''){
		$('#m_check_questionAnswer').focus();
		alert("请输入您的安全保护问题答案！");
		return false;
	}
	$.ajax({
		url : "person/checkQuestion.html",
		type : "post",
		data : {
			  "questionAnswer" : questionAnswer
		   },
		success : function(result){
			var res = $.parseJSON(result);
			if(res.success){
				_closePubDialog(tanchu, divId1, type);
				_showPubDialog(tanchu, divId2, type);
				$('#m_questionId option:first').attr('selected','selected'); 
			}else{
				alert(res.msg);
				return false;
			}
		}
	});
}

// 查询已绑定的手机号
function _showUpdatePwDialog(tanchu,divId,type,mobileId){
	$.ajax({
		url : "person/gainMobile.html",
		type : "post",
		success : function(result){
			var rt = $.parseJSON(result);
			if(rt.res == "sessionexpiry"){
				alert(rt.msg);
				window.location.href = "/index.jsp";
			}else{
				$('#'+mobileId).html(rt.mobile);
				_showPubDialog(tanchu, divId,type);
			}
		}
	});	
}

// 登录密码修改前需进行手机验证
function _checkMobile(tanchu,divId1,divId2,type,mobileCodeId){
	var flag = validateMobileCode(mobileCodeId);
	if(flag){
		$.ajax({
			url : "person/checkMobile.html",
			type : "post",
			data : {
				"mobileCode" : $("#"+mobileCodeId).val()
			},
			success : function(result){
				var rt = $.parseJSON(result);
				if(rt.res == "expiry"){
					alert(rt.msg);
					return false;					
				}else if(rt.res == "error"){
					alert(rt.msg);
					return false;					
				}else if(rt.res == "fail"){
					alert(rt.msg);
					return false;					
				}else if(rt.res == "sessionexpiry"){
					alert(rt.msg);
					window.location.href = "/index.jsp";
				}else{
					_closePubDialog(tanchu, divId1, type);
					_showPubDialog(tanchu, divId2, type);
				}
			}
		});		
	}	
}
// 登录密码修改
function _updatePassword(tanchu,divId,type,toUrl){
	//var m_old_password = $("#m_old_password").val();
	var m_new_password = $("#m_new_password").val();
	var m_new_pwd = $("#m_new_pwd").val();
	/*if(m_old_password == ''){
		$('#m_old_password').focus();
		alert("请输入旧密码！");
		return false;
	}else{
		if (!regPwd.test(m_old_password)) {
			$('#m_old_password').focus();
			alert('旧密码只可输入6-10位英文、数字及特殊符号！');
			return false;
		}
	}*/
	if(m_new_password == ''){
		$('#m_new_password').focus();
		alert("请输入新密码！");
		return false;
	}else{
		if (!regPwd.test(m_new_password)) {
			$('#m_new_password').focus();
			alert('新密码只可输入6-10位英文、数字及特殊符号！');
			return false;
		}
	}
	if(m_new_pwd == ''){
		$('#m_new_pwd').focus();
		alert("请输入确认密码！");
		return false;
	}
	if (m_new_password != '' && m_new_pwd != '') {
		if (m_new_password != m_new_pwd) {
			$('#m_new_pwd').focus();
			alert('两次输入的密码不一致，请重新输入！');
			return false;
		}
	}	
	$.ajax({
		url : "person/passwordUpdate.html",
		type : "post", 
		data : {
				 // "oldPassword" : m_old_password,
				  "newPassword" : m_new_password
			   },
		success : function(result){
			var rt = $.parseJSON(result);
			if(rt.res == 'succ'){
				alert(rt.msg);
				_closePubDialog(tanchu, divId, type);
				window.location.href = toUrl;
			}else{
				alert(rt.msg);
			}
		}
	});	
}
// 设置安全密码
function _setUpPayPassword(tanchu,divId,type,toUrl){
	var m_payPassword = $("#m_payPassword").val();
	var m_payPasswordPwd = $("#m_payPasswordPwd").val();
	if(m_payPassword == ''){
		$('#m_payPassword').focus();
		alert("请输入安全密码！");
		return false;
	}else{
		if (!regPwd.test(m_payPassword)) {
			$('#m_payPassword').focus();
			alert('安全密码只可输入6-10位英文、数字及特殊符号！');
			return false;
		}
	}
	if(m_payPasswordPwd == ''){
		$('#m_payPasswordPwd').focus();
		alert("请输入确认密码！");
		return false;
	}
	if (m_payPassword != '' && m_payPasswordPwd != '') {
		if (m_payPassword != m_payPasswordPwd) {
			$('#m_payPasswordPwd').focus();
			alert('两次输入的密码不一致，请重新输入！');
			return false;
		}
	}	
	$.ajax({
		url : "person/payPasswordUpdate.html",
		type : "post", 
		data : {
				  "payPassword" : m_payPassword,
				  "type" : "setUp"
			   },
		success : function(result){
			var rt = $.parseJSON(result);
			if(rt.res == 'succ'){
				alert(rt.msg);
				_closePubDialog(tanchu, divId, type);
				window.location.href = toUrl;
			}else{
				alert(rt.msg);
			}
		}
	});	
}
// 修改支付密码
function _updatePayPassword(tanchu,divId,type,toUrl){
	//var up_m_old_payPassword = $("#up_m_old_payPassword").val();
	var up_m_new_payPassword = $("#up_m_new_payPassword").val();
	var up_m_new_payPasswordPwd = $("#up_m_new_payPasswordPwd").val();
	/*if(up_m_old_payPassword == ''){
		$('#up_m_old_payPassword').focus();
		alert("请输入旧安全密码！");
		return false;
	}else{
		if (!regPwd.test(up_m_old_payPassword)) {
			$('#up_m_old_payPassword').focus();
			alert('旧安全密码只可输入6-10位英文、数字及特殊符号！');
			return false;
		}
	}*/
	if(up_m_new_payPassword == ''){
		$('#up_m_new_payPassword').focus();
		alert("请输入新密码！");
		return false;
	}else{
		if (!regPwd.test(up_m_new_payPassword)) {
			$('#up_m_new_payPassword').focus();
			alert('新密码只可输入6-10位英文、数字及特殊符号！');
			return false;
		}
	}	
	if(up_m_new_payPasswordPwd == ''){
		$('#up_m_new_payPasswordPwd').focus();
		alert("请输入确认密码！");
		return false;
	}
	if (up_m_new_payPassword != '' && up_m_new_payPasswordPwd != '') {
		if (up_m_new_payPassword != up_m_new_payPasswordPwd) {
			$('#up_m_new_payPasswordPwd').focus();
			alert('两次输入的密码不一致，请重新输入！');
			return false;
		}
	}	
	$.ajax({
		url : "person/payPasswordUpdate.html",
		type : "post", 
		data : {
				  /*"oldPayPassword" : up_m_old_payPassword,*/
				  "newPayPassword" : up_m_new_payPassword,
				  "type" : "update"
			   },
		success : function(result){
			var rt = $.parseJSON(result);
			if(rt.res == 'succ'){
				alert(rt.msg);
				_closePubDialog(tanchu, divId, type);
				window.location.href = toUrl;
			}else{
				alert(rt.msg);
			}
		}
	});	
}
// 个人统计信息
function per_statisticsInfo(obj,type){
	$.ajax({
		url : "memberCenter/gainStatisticsByTime.html",
		type : "post", 
		data : {
			 	  "time" : obj,
				  "type" : type
			   },
		success : function(result){
			var rt = $.parseJSON(result);
			var statisticsType = rt.perStatisticsInfo.statisticsType;
			var statisticsInfo = rt.perStatisticsInfo;
			if(statisticsType == 'ddtj'){// 订单统计
				$("#per_ddtj_0").html(statisticsInfo.noPayAndShipOrderCount);
				$("#per_ddtj_1").html(statisticsInfo.alreadyPayAndNoShipOrderCount);
				$("#per_ddtj_2").html(statisticsInfo.alreadyPayAndShipOrderCount);
				$("#per_ddtj_3").html(statisticsInfo.completeOfTheTransactionHistoryOrderCount);
				$("#per_ddtj_4").html(statisticsInfo.closeOfTheTransactionHistoryOrderCount);
				$("#per_ddtj_5").html(statisticsInfo.alreadyReturnAndNoFullrefundOrderCount);
				$("#per_ddtj_6").html(statisticsInfo.alreadyReturnAndFullrefundOrderCount);				
			}else if(statisticsType == 'gwctj'){// 购物车统计
				$("#per_gwctj_0").html(statisticsInfo.shoppingCartQuantity);
				$("#per_gwctj_1").html(statisticsInfo.shoppingCartTotal);				
			}else if(statisticsType == 'zjtj'){// 资金统计
				$("#per_zjtj_0").html(statisticsInfo.depositTotal);
				$("#per_zjtj_1").html(statisticsInfo.expendTotal);
				$("#per_zjtj_2").html(statisticsInfo.withdrawTotal);
				$("#per_zjtj_3").html(statisticsInfo.moneyBalance);
			}else if(statisticsType == 'jftj'){// 经验值统计
				$("#per_jftj_"+0).html(statisticsInfo.pointAddUp);
				$("#per_jftj_"+1).html(statisticsInfo.pointExpend);
				$("#per_jftj_"+2).html(statisticsInfo.pointBalance);
			}else if(statisticsType == 'sctj'){// 收藏统计
				$("#per_sctj_"+0).html(statisticsInfo.collectGoodsCount);
				$("#per_sctj_"+1).html(statisticsInfo.collectShopCount);
				$("#per_sctj_"+2).html(statisticsInfo.collectNewsCount);
			}else if(statisticsType == 'lltj'){// 浏览统计
				$("#per_lltj_"+0).html(statisticsInfo.browseGoodsCount);
				$("#per_lltj_"+1).html(statisticsInfo.browseShopCount);
				$("#per_lltj_"+2).html(statisticsInfo.browseNewsCount);
			}else if(statisticsType == 'hdtj'){// 活动统计
				//$("#per_hdtj_"+0).html(statisticsInfo.partakeActives);
				$("#per_hdtj_"+1).html(statisticsInfo.downloadData);
				$("#per_hdtj_"+2).html(statisticsInfo.askQuestions+"/"+statisticsInfo.replyQuestions);
				$("#per_hdtj_"+3).html(statisticsInfo.uploadCount);
				$("#per_hdtj_"+4).html(statisticsInfo.uploadPassCount);
				$("#per_hdtj_"+5).html(statisticsInfo.checkCount);
				$("#per_hdtj_"+6).html(statisticsInfo.checkPassCount);
				$("#per_hdtj_"+7).html(statisticsInfo.addUpReward);
			}else if(statisticsType == 'xxtj'){// 信息统计
				$("#per_xxtj_"+0).html(statisticsInfo.commentCount);
				//$("#per_xxtj_"+1).html(statisticsInfo.commentCount);
				//$("#per_xxtj_"+2).html(statisticsInfo.partakeActives);
			}else if(statisticsType == 'jstj'){// 结算统计
				$("#com_jstj_"+0).html(statisticsInfo.totalTradeAmount);
			}else if(statisticsType == 'fbtj'){// 发布统计
				$("#com_fbtj_"+0).html(statisticsInfo.totalSupplyInfo);
				//$("#com_fbtj_"+1).html(statisticsInfo.totalAdver);
				$("#com_fbtj_"+2).html(statisticsInfo.totalNews);
			}else if(statisticsType == 'wltj'){// 物流统计
				$("#com_wltj_"+0).html(statisticsInfo.totalSinceTheMention);
				$("#com_wltj_"+1).html(statisticsInfo.totalDelivery);
				$("#com_wltj_"+2).html(statisticsInfo.totalReturns);
			}else if(statisticsType == 'xydjtj'){// 信誉等级统计
				$("#com_xydjtj_"+0).html(statisticsInfo.credit_greatReviews);
				$("#com_xydjtj_"+1).html(statisticsInfo.credit_inReviews);
				$("#com_xydjtj_"+2).html(statisticsInfo.credit_badReviews);
				$("#com_xydjtj_"+3).html(statisticsInfo.credit_totalPoint);
			}else if(statisticsType == 'fwdjtj'){// 服务等级统计
				$("#com_fwdjtj_"+0).html(statisticsInfo.serve_greatReviews);
				$("#com_fwdjtj_"+1).html(statisticsInfo.serve_inReviews);
				$("#com_fwdjtj_"+2).html(statisticsInfo.serve_badReviews);
				$("#com_fwdjtj_"+3).html(statisticsInfo.serve_totalPoint);
			}else if(statisticsType == 'zldjtj'){// 质量等级统计
				$("#com_zldjtj_"+0).html(statisticsInfo.quality_greatReviews);
				$("#com_zldjtj_"+1).html(statisticsInfo.quality_inReviews);
				$("#com_zldjtj_"+2).html(statisticsInfo.quality_badReviews);
				$("#com_zldjtj_"+3).html(statisticsInfo.quality_totalPoint);
			}else if(statisticsType == 'wldjtj'){// 物流等级统计
				$("#com_wldjtj_"+0).html(statisticsInfo.logistics_greatReviews);
				$("#com_wldjtj_"+1).html(statisticsInfo.logistics_inReviews);
				$("#com_wldjtj_"+2).html(statisticsInfo.logistics_badReviews);
				$("#com_wldjtj_"+3).html(statisticsInfo.logistics_totalPoint);
			}else if(statisticsType == 'sptj'){// 商品统计
				//$("#com_sptj_"+0).html(statisticsInfo.logistics_greatReviews);
				$("#com_sptj_"+1).html(statisticsInfo.goodsCats);
				$("#com_sptj_"+2).html(statisticsInfo.goodsCount);
				$("#com_sptj_"+3).html(statisticsInfo.goodsAddedCount);
				$("#com_sptj_"+4).html(statisticsInfo.goodsOffTheShelfCount);
			}else if(statisticsType == 'fwtj'){// 访问统计
				$("#com_fwtj_"+0).html(statisticsInfo.customerViews);
				$("#com_fwtj_"+1).html(statisticsInfo.customerCollects);
				$("#com_fwtj_"+2).html(statisticsInfo.customerComments);
			}else{
				alert("没有查询到此类统计信息！");
				return false;
			}
		}
	});	
}
//时间倒计时
secs = 120;    
wait = secs * 1000; 
function doUpdate(num,objId) {
   if(num == (wait/1000)) {      
	   document.getElementById(objId).value = "点此发送校验码";      
   } else {      
       wut = (wait/1000)-num;      
       document.getElementById(objId).value = "(" + wut + "秒后)重发校验码";      
   }      
}
function Timer(objId) {
	document.getElementById(objId).disabled = false; 
}
// 验证手机号
function validateMobile(mobileInpId){
	var m_mobile = $("#"+mobileInpId).val();
	if (m_mobile != '') {
		if (!regphone.test(m_mobile)) {
			$("#"+mobileInpId).focus();
			alert('手机格式不正确，请重新输入！');
			return false;
		}else{
			return true;
		}
	} else {
		$("#"+mobileInpId).focus();
		alert('请输入手机号码！');
		return false;
	}
}
// 验证手机校验码
function validateMobileCode(mobileCode){
	var m_mobile_yzm = $("#"+mobileCode).val();
	if(m_mobile_yzm == ''){
		$('#'+mobileCode).focus();
		alert('请输入您收到的手机校验码！');
		return false;
	}else{
		return true;
	}
}
// 验证邮箱
function validateEmail(){
	var m_email = $("#m_email").val();
	if (m_email != '') {
		if (!regEmail.test(m_email)) {
			$('#m_email').focus();
			alert('您的邮箱格式不正确！');
			return false;
		} else {
			if (m_email.length > 50) {
				$('#m_email').focus();
				alert('邮箱长度不可超过50位，请重新输入！');
				return false;
			}else{
				return true;
			}
		}
	} else {
		$('#m_email').focus();
		alert('请输入您的邮箱地址！');
		return false;
	}
}
// 验证邮箱校验码
function validateEmailCode(){
	var m_email_yzm = $("#m_email_yzm").val();
	if(m_email_yzm == ''){
		$('#m_email_yzm').focus();
		alert('请输入您收到的邮箱校验码！');
		return false;		
	}else{
		return true;
	}
}
// 发送手机校验码
function sendMobileCode(objId,type,mobileCheck){
	$.ajax({
		url : "person/sendMobileCode.html",
		type : "post",
		data : {
			"type" : type,
			"mobileCheck" : mobileCheck
		},
		success : function(map){
			var rt = $.parseJSON(map);
			if(rt.success){
				alert("发送成功！");
	            //时间倒计时
				document.getElementById(objId).disabled = true;    
	            for(i=1;i<=(wait/1000);i++) {      
	                window.setTimeout("doUpdate(" + i + ",'"+objId+"')", i * 1000);      
	            }      
	            window.setTimeout("Timer('"+objId+"')", wait);				
			}else{
				alert("发送失败！");
			}
		}
	});		
}
function getMobileCode(objId,mobileInpId,type){
	if(validateMobile(mobileInpId)){
		$.ajax({
			url : "person/sendMobileCode.html",
			type : "post",
			data : {
				"mobileNum" : $("#"+mobileInpId).val(),
				"type" : type
			},
			success : function(map){
				var rt = $.parseJSON(map);
				if(rt.success){
					alert("发送成功！");
		            //时间倒计时
					document.getElementById(objId).disabled = true;    
		            for(i=1;i<=(wait/1000);i++) {      
		                window.setTimeout("doUpdate(" + i + ",'"+objId+"')", i * 1000);      
		            }      
		            window.setTimeout("Timer('"+objId+"')", wait);				
				}else{
					alert("发送失败！");
				}
			}
		});		
	}
}
//手机绑定
function _bindMobile(tanchu,shxx,type,mobileInpId,mobileCodeId,toUrl){
	var flag = validateMobile(mobileInpId)&&validateMobileCode(mobileCodeId);
	if(flag){
		$.ajax({
			url : "person/bindMoble.html",
			type : "post",
			data : {
				"mobileNum" : $("#"+mobileInpId).val(),
				"mobileCode" : $("#"+mobileCodeId).val()
			},
			success : function(result){
				var rt = $.parseJSON(result);
				if(rt.res == "expiry"){
					alert(rt.msg);
					return false;					
				}else if(rt.res == "error"){
					alert(rt.msg);
					return false;					
				}else if(rt.res == "fail"){
					alert(rt.msg);
					return false;					
				}else{
					alert(rt.msg);
					_closePubDialog(tanchu, shxx, type);
					window.location.href = toUrl;					
				}
			}
		});		
	}
}
//发送邮箱校验码
function _sendEmailVerificateCode(objId){
	if(validateEmail()){
		$.ajax({
			url : "person/sendEmailCode.html",
			type : "post",
			data : {
				"email" : $("#m_email").val()
			},
			success : function(result){
				var rt = $.parseJSON(result);
				if(rt.success){
					alert(rt.msg);
		            //时间倒计时
		            document.getElementById(objId).disabled = true;     
		            for(i=1;i<=(wait/1000);i++) {      
		                window.setTimeout("doUpdate(" + i + ",'"+objId+"')", i * 1000);      
		            }      
		            window.setTimeout("Timer('"+objId+"')", wait);				
				}
			}
		});		
	}
}
// 邮箱绑定
function _bindEmail(tanchu,shxx,type,toUrl){
	var flag = validateEmail()&&validateEmailCode();
	if(flag){
		$.ajax({
			url : "person/bindEmail.html",
			type : "post",
			data : {
				"email" : $("#m_email").val(),
				"emailCode" : $("#m_email_yzm").val()
			},
			success : function(result){
				var rt = $.parseJSON(result);
				if(rt.res == "expiry"){
					alert(rt.msg);
					return false;					
				}else if(rt.res == "error"){
					alert(rt.msg);
					return false;					
				}else if(rt.res == "fail"){
					alert(rt.msg);
					return false;					
				}else{
					alert(rt.msg);
					_closePubDialog(tanchu, shxx, type);
					window.location.href = toUrl;					
				}				
			}
		});		
	}
}
// 站内短信列表
function m_getInstationMessageList(num){
	$("#isReceive").attr("value",num);
	$('#instationMessageSearchForm').submit();
}

// 查看站内短信
function m_viewMessage(tanchu,shxx,id) {
	$.ajax({
		url : "person/myParticipation/showDetailInstationMessage.html",
		type : "post",
		data : {"id" : id},
		success : function(data){
			var rt = $.parseJSON(data);
			var type = "";
			if(rt.type == 0){
				type = "系统消息";
			}else{
				type = "好友消息";
			}
			$("#m_msg_title").html("标题：【"+type+"】"+rt.messageTitle);
			$("#m_msg_content").val(rt.content);
			$("#m_msg_id").val(rt.id);
			showsplbtitle(tanchu, shxx);
		}
	});
}

// 关闭站内短信弹出框
function m_closeViewMessage(tanchu,shxx){
	_closePubDialog(tanchu, shxx);
	window.location.href = "person/myParticipation/instationMessageList.html";
}

// 发送站内短信
function m_toSendInstationMessage(tanchu,shxx,selId,type){
	$('#'+selId).html("");
	$.ajax({
		url : "person/myParticipation/gainPptUsers.html",
		type : "post",
		success : function(result){
		   var pptUsers = $.parseJSON(result);
		   $('#'+selId).append("<option value=''>请选择好友</option>");
		   for(var i=0; i< pptUsers.length;i++){
			   $('#'+selId).append("<option value='"+pptUsers[i].userId+"'>"+pptUsers[i].userName+"</option>");
		   }
		   _showPubDialog(tanchu, shxx, type);
		},
		error : function() {
			alert('请求失败!');
			return false;
		}
	});
}

function m_sendInstationMessage(memberId){
	if(memberId != null && memberId != ''){
		// 用户登录状态下
		var m_to1 = $("#m_to1").val();
		var m_to2 = $("#m_to2").val();
		var m_messageTitle = $("#m_messageTitle").val();
		var m_content = $("#m_content").val();
		if(m_to1 == '' && m_to2 == ''){
			alert("请填写或选择一个好友！");
			return false;
		}
		if(m_to1 != '' && m_to2 != ''){
			alert("只能填写或选择一个好友！");
			return false;			
		}
		if(m_messageTitle == ''){
			alert("请填写标题！");
			return false;
		}
		if(m_content == ''){
			alert("请填写内容！");
			return false;
		}
		if(m_to1 != ''){
			$.ajax({
				url : "person/myParticipation/gainIsExistMember.html",
				type : "post",
				data : {
						"username" : m_to1,
					    "userId" : memberId
					   },
				success : function (result){
					var rt = $.parseJSON(result);
					if(!rt.success){
						alert(rt.msg);
						return false;
					}else{
						$("#m_to1").val(rt.users.id);
						$("#m_to_userType").val(rt.userType);
						document.m_sendInstationMessageForm.submit();
					}
				}
			});			
		}else{
			document.m_sendInstationMessageForm.submit();
		}
	}else {
		// 用户未登录状态下
		showLogin('mask','pop_500',url,'0','');
	}	
}

// 回复信息
function m_replyInstationMessage(tanchu,shxx,type,divId,selId){
	_closePubDialog(tanchu, divId);
	m_toSendInstationMessage(tanchu, shxx, selId, type);
} 

// 查看站内短信页面-删除
function m_isCheckedBydelCheckbox() {
	var id = $("#m_msg_id").val();
	if ($("#delChecked").attr("checked") != "checked") {
		alert("请勾选删除复选框");
		return false;
	}else{
		
		delAll(id,'/person/myParticipation/deleteInstationMessage.html','/person/myParticipation/instationMessageList.html');
	}
}

// 文本框默认文字点击消失
function input_clear(x,y){
	document.getElementById(x).style.display='none';
	document.getElementById(y).focus();
}
