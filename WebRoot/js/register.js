var reg = /^(?!-)(?!.*?-$)[a-zA-Z0-9-\u4e00-\u9fa5]{2,20}$/;;
var regName = /^[A-Za-z\u4e00-\u9fa5]{2,20}$/;
//var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
var regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
var regAddress = /^(?!-)(?!.*?-$)[a-zA-Z0-9-\u4e00-\u9fa5]{5,100}$/;
var regPwd = /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,10}$/;
var regphone = /^(((13[0-9]{1})|15[0-9]{1}|18[0-9]{1}|17[0-9]{1}|14[0-9]{1}|)+\d{8})$/;
/****
 * 企业注册
 * @return {TypeName} 
 */
$(function(){
	$('#notice .btn').click(function(){
		var me = $(this),meIndex = me.index();
		me.addClass('selected').siblings().removeClass('selected');
		$('.hyzcmain .notice_Content:eq('+meIndex+')').show().siblings().hide();
	})
})
function companyFormsub() {
	//var code = $("#veryCodeC").attr("value");
	var code = $('#veryCode').val();
	var companync = $('#companync').val();
	var companyPwd = $('#companyPwd').val();
	var reCompanyPwd = $('#reCompanyPwd').val();
	
	
	if (companync != '') {
		if (!reg.test(companync) && !regEmail.test(companync)) {
			$('#companync').focus();
			alert("用户名只可输入2-20位英文、汉字、数字！");
			return false;
		}
	} else {
		$('#companync').focus();
		alert("请输入用户名！");
		return false;
	}
	if (companyPwd == '') {
		$('#companyPwd').focus();
		alert('请输入密码！');
		return false;
	} else {
		if (!regPwd.test(companyPwd)) {
			$('#companyPwd').focus();
			alert('密码只可输入6-10位英文、数字及特殊符号！');
			return false;
		}
	}
	
	if (reCompanyPwd == '') {
		$('#reCompanyPwd').focus();
		alert('请输入确认密码！');
		return false;
	}
	if (companyPwd != '' && reCompanyPwd != '') {
		if (companyPwd != reCompanyPwd) {
			$('#companyPwd').focus();
			alert('两次输入的密码不一致，请重新输入！');
			return false;
		}
	}

	
	if (code == '') {
		$('#veryCode').focus();
		alert('请输入验证码！');
		return false;
	}

	$.ajax( {
		url : 'toveryCode.html',
		type : 'POST',
		data : 'veryCode=' + code + '&nickName=' + companync,
		success : function(data) {
			var r = $.parseJSON(data);
			if (r == 'fail') {
				alert('验证码输入不正确！');
				return false;
			} else if (r == 'no') {
				$('#veryCodeC').focus();
				alert('请输入验证码！');
				return false;
			} else if (r == 'exist') {
				alert('用户名已经存在，请重新输入！');
				return false;

			} else if(r == 'oldsession'){
				alert('页面已过期，请重新注册！');
				window.location.href = "/";
			}else {
					document.getElementById("companyFrom").submit();
			}

		}
	});

}


/****
 * 个人注册
 * @return {TypeName} 
 */
function memberFromSub() {
	var memberUsername = $('#memberUsername').val();
	var memberPwd = $('#memberPwd').val();
	var reMemberPwd = $('#reMemberPwd').val();
	var veryCode = $('#veryCode').val();
	var shangjiId = $('#shangjiId').val();
	
	if (shangjiId == '') {
		$('#shangjiId').focus();
		alert('请输入分享号！');
		return false;
	}
	if (memberUsername != '') {
		if (!regphone.test(memberUsername) ) {
			$('#memberUsername').focus();
			alert('用户名只可为手机号！');
			return false;
		}
	} else {
		$('#memberUsername').focus();
		alert("请输入用户名！");
		return false;
	}
	if (memberPwd == '') {
		$('#memberPwd').focus();
		alert('请输入密码！');
		return false;
	} else {
		if (!regPwd.test(memberPwd)) {
			$('#memberPwd').focus();
			alert('密码只可输入6-10位英文、数字及特殊符号！');
			return false;
		}
	}

	if (reMemberPwd == '') {
		$('#reMemberPwd').focus();
		alert('请输入确认密码！');
		return false;
	}
	
	if (memberPwd != '' && reMemberPwd != '') {
		if (memberPwd != reMemberPwd) {
			$('#memberPwd').focus();
			alert('两次输入的密码不一致，请重新输入！');
			return false;
		}
	}
	if (veryCode == '') {
		$('#veryCode').focus();
		alert('请输入验证码！');
		return false;
	}
	$.ajax( {
		url : 'toveryCode.html',
		type : 'POST',
		data : 'veryCode=' + veryCode + '&nickName=' + memberUsername+ '&shangjiId=' + shangjiId,
		success : function(data) {
			var r = $.parseJSON(data);
			if (r == 'fail') {
				$('#veryCode').focus();
				alert('验证码输入不正确！');
				return false;
			} else if (r == 'no') {
				$('#veryCode').focus();
				alert('验证码为空！');
				return false;
			} else if (r == 'exist') {
				$('#memberUsername').focus();
				alert('用户名已经存在，请重新输入！');
				return false;

			} else if (r == 'noShangji') {
				$('#shangjiId').focus();
				alert('不存在该推荐人！');
				return false;

			}else if(r == 'oldsession'){
				alert('页面已过期，请重新注册！');
				window.location.href = "activeIndex.jsp";
				}else {
				document.getElementById("memberFrom").submit();
			}

		}
	});

}
/*  
 *@Description: 弹出层
 *@Author:yhl 
 *@Update:2013-06-8
 */
function showMember(divbg, divId) {
//mask=document.createElement("div");
	var yScroll = this.pageYOffset; 
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

/**
 * 个人注册完善信息
 * @returns {Boolean}
 */
function memberMsgSubForm() {
	var regTel = /^\d{3,4}-\d{7,8}$/;
	var regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	var regphone = /^(((13[0-9]{1})|15[0-9]{1}|18[0-9]{1}|17[0-9]{1}|14[0-9]{1}|)+\d{8})$/;
	var reg = /^[A-Za-z\u4e00-\u9fa5]{2,20}$/;
	var regf = /^[A-Za-z0-9\u4e00-\u9fa5]{1,20}$/;
	var regAddress = /^(?!-)(?!.*?-$)[a-zA-Z0-9-\u4e00-\u9fa5]{5,200}$/;
	var regnum = /^(?:[1-9][0-9]?|1[0-4][0-9]|150)$/;
	var firstname = $('#firstname').val();
	var truename = $('#truename').val();
	var mobile = $('#mobile').val();
	var age = $('#age').val();
	var jobRole = $('#jobRole').val();
	var papersNum = $('#card').val();
	var gender = $('#gender').val();
	var mobileCode = $("#member_mobileCode").val();
	

$.ajax({
	url : 'person/ajaxMobileCodeBoolean',
	type : 'POST',
	dataType:'JSON',
	data : 'telNum=' + mobile + '&telCode=' + mobileCode,
	success : function(m) {
		if(m.success){
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
						window.location.href = "/";
						}else {
					
								$.ajax( {
									type : 'POST',
									url : 'memberMsgRegister.html',
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
							
										window.location.href = "admin/register/MemberSuccess.jsp";
									}
									if (msg == 'oldsession') {
										alert('页面已过期，请重新修改信息！');
										window.location.href = "/";
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
				
		}else {
			 alert(m.msg);
		}
	}
});
	
	

}


/***
 * 企业详细信息注册
 * @return {TypeName} 
 */
function companyMsgFromSub() {
	//var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var regTel = /^\d{3,4}-\d{7,8}$/;
	var regphone = /^(((13[0-9]{1})|15[0-9]{1}|18[0-9]{1}|17[0-9]{1}|14[0-9]{1}|)+\d{8})$/;
	var regLinkName = /^[A-Za-z\u4e00-\u9fa5]{2,20}$/;
	var regnum2 = /^\d+$/ ;
	var regnum = /^(?:[1-9][0-9]?|1[0-4][0-9]|150)$/;	
	var companyname = $('#companyname').val();
	var linkmanName = $('#linkmanName').val();
	var scopes = $('#scopes').val();
	var linkmanPhone = $('#linkmanPhone').val();
	//var linkmanAge = $('#linkmanAge').val();
	var jobRole = $('#jobRole').val();
	var companyLicense= $('#companyLicense').val();
	var linkmanPhoneCode = $("#linkmanPhoneCode").val();
	var mobileBoolea = "";
	var mobileMsg='';
	var qqNumber = $('#qqNumber').val();
	var regqqNumber=/^\d{5,10}$/;
	
	
	if (companyname != '') {
		if (!reg.test(companyname)) {
			$('#companyname').focus();
			alert('企业名称只可输入3-20位英文和汉字！');
			return false;
		}
	} else {
		$('#companyname').focus();
		alert('请输入企业名称！');
		return false;
	}
	
	if(linkmanName != ''){
		if(!regLinkName.test(linkmanName)){
			$('#linkmanName').focus();
				alert('联系人只可输入2-20位英文、汉字！');
				return false;
		}
	}else{
	$('#linkmanName').focus();
		alert('请输入联系人姓名！');
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
			alert('请选择所在地区！');
			return false;
		}
	}
	
	if(linkmanPhone != ''){
		if(!regphone.test(linkmanPhone)){
			$('#linkmanPhone').focus();
				alert('联系人手机格式不正确，请重新输入！');
				return false;
		}
	}else{
	$('#linkmanPhone').focus();
		alert('请输入联系人手机！');
		return false;
	}
//	if(linkmanAge != ''){
//		if(!regnum.test(linkmanAge)){
//		$('#linkmanAge').focus();
//			alert('联系人年龄只可输入小于150的正整数！');
//			return false;
//		}
//	}
	if(qqNumber != ''){
		if(!regqqNumber.test(qqNumber)){
			$('#qqNumber').focus();
				alert('请输入正确的qq号码！');
				return false;
		}
	}else{
	$('#qqNumber').focus();
		alert('请输入店铺qq客服！');
		return false;
	}
	var address = $('#address').val();
	if (address == '') {
		$('#address').focus();
		alert('请填写详细地址！');
		return false;
	} else {
		/*if (!regAddress.test(address)) {
			$('#address').focus();
			alert('详细地址中只可输入5-100位英文、汉字、数字！');
			return false;
		}*/
	}
	var mobile = $('#telphone').val();
	if (mobile != '') {
		if (!regTel.exec(mobile)) {
			$('#telphone').focus();
			alert('请输入办公电话!例如:0755-83485999');
			return false;
		}
	} 
	
	if ($('#email').val() != '') {
		if (!regEmail.test($('#email').val())) {
			$('#email').focus();
			alert('您的电子邮箱格式不正确！');
			return false;
		}else{
			if($('#email').val().length > 50){
				$('#email').focus();
				alert('电子邮箱长度不可超过50位，请重新输入！');
				return false;
			}
		}
	}else{
	$('#email').focus();
		alert('请输入您的电子邮箱！');
		return false;
	}
	
	if(companyLicense == ''){
	 alert('请上传公司营业执照！');
	 return false;
	}
	
	if(linkmanPhoneCode == ''){
		 alert('请输入手机验证码！');
		 return false;
		}
	
	
	$.ajax({
		url : 'person/ajaxMobileCodeBoolean',
		type : 'POST',
		dataType:'JSON',
		data : 'telNum=' + linkmanPhone + '&telCode=' + linkmanPhoneCode,
		success : function(m) {
			if(m.success){
				$('#companyMsgFrom').ajaxSubmit({
					type : 'POST',
							url : 'uploadFile.html',
							data : $('#companyMsgFrom').serialize(),
							//data:list,	
							dataType : 'json',
							error : function() {
								//alert("JQuery AJAX Error!");
								alert('请求超时请重试！');
								return false;
							},
							success : function(data) {
								if(data == 'fail'){
									alert('上传文件失败！');
									return false;
								}
								if(data == 'typeerror'){
									alert('上传文件格式不正确！');
									return false;
								}
								//window.location.href = "${pageContext.request.contextPath}/order/orderCheck.do?productId=" + productId;
								if(data == 'success'){
									alert('完善信息成功！');
									window.location.href = "admin/register/CompanyVerify.jsp";
								}
								if(data == 'oldsession'){
									alert('界面过期，请重新修改信息！');
									window.location.href = "/";
								}
								if(data == 'failcompany'){
									alert('完善信息失败！');
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

function IsURL(str_url){
        var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
        + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
        + "|" // 允许IP和DOMAIN（域名）
        + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
        + "[a-z]{2,6})" // first level domain- .com or .museum
        + "(:[0-9]{1,4})?" // 端口- :80
        + "((/?)|" // a slash isn't required if there is no file name
        + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
        var re=new RegExp(strRegex);
        //re.test()
        if (re.test(str_url)){
            return true;
        }else{
            return false;
        }
}
/***
 * 主销车型一级下属目录
 * @return {TypeName} 
 */
function displayCarBrandPid() {
	var carBrandPid = $("#carBrandPid").val();
	if (carBrandPid != '0') {
		$.ajax( {
			url : 'toCarBrandByPid.html',
			type : 'POST',
			data : 'pid=' + carBrandPid,
			dataType : 'json',
			error : function() {
				alert('请求失败');
				return false;
			},
			success : function(carBrandByPidList) {
				document.getElementById("carBrandListOption").innerHTML = "";
				var menuname = new Array();
				var menuvalue = new Array();
				if (carBrandByPidList.length > 0) {
					for ( var i = 0; i < carBrandByPidList.length; i++) {
						menuname.push(carBrandByPidList[i].name);
						menuvalue.push(carBrandByPidList[i].id);

					}
					sbox = new SelectBox("carBrandListOption", 200, menuname,
							menuvalue);
					sbox._changeSelectBox(menuname, menuvalue);
				}

			}
		});
	}
}

/***
 * 切换省时对应的城市
 * @return {TypeName} 
 */
function displayQY() {
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
/***
 * 切换城市时对应的地区
 * @return {TypeName} 
 */
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
				$("#area").append("<option value='0'>-选择地区-</option>");
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
/***
 * tab选项卡
 * @param {Object} thisObj
 * @param {Object} Num
 * @param {Object} active
 * @param {Object} normal
 * @return {TypeName} 
 */
function nTabs(thisObj,Num,active,normal){
	if(thisObj.className == active){
		return false;
		}
	var tabObj = thisObj.parentNode.id;
	var tabList = document.getElementById(tabObj).getElementsByTagName("li");
	for(i=0; i <tabList.length; i++)
	{
		if (i == Num)
		{
		   thisObj.className = active;
		   document.getElementById(tabObj+"_Content"+i).style.display = "block";
		}else{
		   tabList[i].className = normal;
		   document.getElementById(tabObj+"_Content"+i).style.display = "none";
		}
	}
}
function membernTabs(thisObj,Num,active,normal){
	var tabObj = thisObj.parentNode.id;
	var tabList = document.getElementById(tabObj).getElementsByTagName("li");
	for(i=0; i <tabList.length; i++)
	{
		if (i == Num)
		{	
			thisObj.className = active+"new";
		
		   document.getElementById(tabObj+"_Content"+i).style.display = "block";
		}else{		
			tabList[i].className = normal;
		   document.getElementById(tabObj+"_Content"+i).style.display = "none";
		}
	}
}
/*  
	*@Description: 多选下拉菜单
	*@Author:yhl 
	*@Update:2013-06-8
*/
//事件绑定
Function.prototype.bindEvent = function(object, newPara) {
	var __method = this;
	return function(event) {
		__method.call(null, event || window.event, object, newPara);//null直接调用方法，event||window.event,object,newPara为参数
		return null;
	}
};
/*
 * 取值，使用document.getElementById('SelectHideValueText')取得多选框列表选中的值
 * 构造函数
 *	@param elem				Div对象。
 *	@param width			下拉多选列表框宽度。
 *	@param menuName			显示内容数组（与数据值数组一一对应）。
 *	@param menuValue		数据值数组。
 *	@param splitSign		列表框值之间的分隔符（默认为0x11）。
 * by lwyx2000	
 */
SelectBox = function(elem, width, menuName, menuValue, splitSign) {
	if (!elem) {
		alert("请输入第一个参数：Div对象！");
		return false;
	}
	this._elem = elem;
	if (!width) {
		alert("请输入第二个参数：宽度属性！");
		return false;
	}
	this._width = width;
	if (!menuName) {
		alert("请输入第三个参数：多选框名称列表！");
		return false;
	}
	this._menuName = menuName;
	if (!menuValue) {
		alert("请输入第四个参数：多选框值列表！");
		return false;
	}
	this._menuValue = menuValue;
	if (menuName.length != menuValue.length) {
		alert("多选框值列表内容与值没有完全对应（个数不同）！");
		return false;
	}
	//属性
	this._splitSign = ",";
	this._clickNum = 0;
	this._selectArray = new Array();//存放选中的下拉列表内容
	this._selectValueArray = new Array();//存放选中的下拉列表值
	this._hideTextType = "hidden";//隐藏文本框的类型可为text，默认为隐藏(hidden)测试使用 id:SelectHideValueText
	if (splitSign != null) {
		this._splitSign = splitSign;
	}
	this._getClickNum = function() {
		return this._clickNum;
	}
	this._setClickNum = function(num) {
		this._clickNum = num;
	}

	this._getSelectArray = function() {
		return this._selectArray;
	}
	this._setSelectArray = function(array) {
		this._selectArray = array;
	}

	this._getSelectValueArray = function() {
		return this._selectValueArray;
	};
	this._setSelectValueArray = function(array) {
		this._selectValueArray = array;
	};

	//getClickNum : function(){} 与以前定义有什么不同

	this._buildSelectBox();
}
//判断是否选中，将选中的值存入数组
//e:触发的事件，obj selectBox对象，para 触发事件的对象
//使用call方法时改变了this的指向
SelectBox.prototype._selectBoxCheck = function(e, obj, para) {
	//得到存放文本框显示内容的数组
	var selectArray = obj._getSelectArray();
	var selectValueArray = obj._getSelectValueArray();
	//得到选中值对应的内容名
	var name = obj._getNameUseValue(para.value);
	if (para.checked == true) {
		selectArray.push(name);
		selectValueArray.push(para.value);
		obj._showSelectArray();
	} else if (para.checked == false) {//将取消选择的值从数组中删除
		obj._deleteFromSelectArray(name, para.value);
		obj._showSelectArray();
	}
	obj._setSelectArray(selectArray);
	obj._setSelectValueArray(selectValueArray);
}
//用指定的值从内容数组中得到对应的内容
SelectBox.prototype._getNameUseValue = function(value) {
	var menuValue = this._menuValue;
	var menuName = this._menuName;
	for ( var i = 0; i < menuValue.length; i++) {
		if (menuValue[i] == value) {
			return menuName[i];
		}
	}
}
//从数组中删除指定元素
SelectBox.prototype._deleteFromSelectArray = function(name,value){
	var selectArray = this._getSelectArray();
	var selectValueArray = this._getSelectValueArray();
	for(var i=0;i<selectArray.length;i++){
		if(selectArray[i] == name){
			//删除指定元素，将后面元素向前移动1位
			for(var j=i;j+1<selectArray.length;j++){
				selectArray[j] = selectArray[j+1];
				selectValueArray[j] = selectValueArray[j+1]
			}
			selectArray.pop();
			selectValueArray.pop();
			return;
		}
	}
	this._setSelectArray(selectArray);
	this._setSelectValueArray(selectValueArray);
}
//得到数组中所有的值（选中的值），显示在文本框上
SelectBox.prototype._showSelectArray = function(){
	//临时变量，存放要显示在文本框上的内容
	var finalTxt = '';
	var finalValue = '';
	var selectArray = this._selectArray;
	var selectValueArray = this._selectValueArray;
	var splitSign = this._splitSign;
	if(selectArray.length == 0){
		finalTxt = '请选择';				
		document.getElementById("selectText").value = finalTxt;
		document.getElementById("SelectHideValueText").value = finalValue;
		return;
	}
	for(var i=0;i<selectArray.length;i++){
		if(i != 0){
			finalTxt += ",";
			finalValue += splitSign;
		}
		finalTxt += selectArray[i]
		finalValue += selectValueArray[i];
	}
	document.getElementById("selectText").value = finalTxt;
	document.getElementById("SelectHideValueText").value = finalValue;
}
//e调用方法时传来的事件，obj调用方法时传来的SelectBox对象
SelectBox.prototype._selectOnClick = function(e,obj){
	var menu = document.getElementById("selectMenu");
	var img = document.getElementById("selectImg");
	var clickNum = obj._getClickNum();
	//clickNum为偶数显示下拉框
	if(clickNum%2 == 0){
		img.style.backgroundImage = "url(images/dropDown2.jpg)";		
		menu.style.display = "block";
		obj._changImg('url(images/dropDown1.jpg)');
	}else{
		img.style.backgroundImage = "url(images/dropDown2.jpg)";	
		menu.style.display = "none";
		obj._changImg('url(images/dropDown1.jpg)');
	}	
	//clickNum到达10000就置0
	if(clickNum == 10000){
		clickNum = 0;
	}
	clickNum++;
	obj._setClickNum(clickNum);
}
//下拉按钮改变背景
SelectBox.prototype._changImg = function(imgurl){
	//延迟0.1秒显示背景
	
	setTimeout(function(){
						var img = document.getElementById("selectImg");
						img.style.backgroundImage = imgurl;
						
				},10);
}
//当鼠标移出下拉多选框时触发
SelectBox.prototype._selectBoxMouseOut = function(even,obj){
	var selectBox = document.getElementById("selectBox");
	var menu = document.getElementById("selectMenu");
	var selectImg = document.getElementById("selectImg");
	var e = even || window.event;
	var targetDom = e.toElement || e.relatedTarget;	
	var clickNum = obj._getClickNum();
	//当鼠标点击到子元素中时，targetDom = 此子元素的父元素，直到找到需要定义方法的父元素
	while(targetDom && targetDom != selectBox){
		targetDom = targetDom.parentNode;
	}
	if(!targetDom){
		if(clickNum%2 == 1 || clickNum%2 == 0){
			menu.style.display = "none";
			obj._changImg('url(images/dropDown1.jpg)');
			clickNum++;
		}
	}
	obj._setClickNum(clickNum);
}
//建立多选下拉框列表
SelectBox.prototype._buildSelectBox = function(){
	var elem = document.getElementById(this._elem);
	var width = this._width;
	var menuName = this._menuName;
	var menuValue = this._menuValue;
	//建立头div
	
	var selectBox_div = document.createElement("div");
	elem.insertBefore(selectBox_div,null);	
	selectBox_div.id = "selectBox";
	selectBox_div.onmouseout = this._selectBoxMouseOut.bindEvent(this);
	//建立模拟下拉框div
	var selectImg_div = document.createElement("div");
	selectBox_div.insertBefore(selectImg_div,null);
	selectImg_div.id = "selectImg";
	selectImg_div.style.backgroundImage = "url(images/dropDown2.jpg)";
	if(!+[1,]){
		selectImg_div.style.cssText="width:173px;height:18px"
	}else {

	 selectImg_div.style.cssText="width:173px;height:30px";
	 }
	selectImg_div.onclick  = this._selectOnClick.bindEvent(this);
	//--建立文本框
	var selectTxt_input = document.createElement("input");
	selectTxt_input.type = "text";
	selectImg_div.insertBefore(selectTxt_input,null);
	selectTxt_input.value = "请选择"
	selectTxt_input.id = "selectText";
	if(!+[1,]){
		selectTxt_input.style.cssText="width:173px;height:18px"
	}else {

	 selectTxt_input.style.cssText="width:173px;height:30px";
	 }
	//建立多选框内容列表ul
	var selectMenu_ul = document.createElement("ul");
	selectBox_div.insertBefore(selectMenu_ul,null);
	selectMenu_ul.id = "selectMenu";
	//var menu = document.getElementById("selectMenu");
	//selectMenu_ul.onmouseout = function(){
	//	menu.style.display = "none";
	//}	
	
	//--创建li
	for(var i=0;i<menuName.length;i++){
		var selectMenu_li = document.createElement("li");
		selectMenu_ul.insertBefore(selectMenu_li,null);
		//----创建checkbox
		var selectMenu_checkbox = document.createElement("input");
		selectMenu_checkbox.type = "checkbox";
		selectMenu_checkbox.value = menuValue[i]; 
		//前一个this为selectBox对象，后一个selectMenu_checkbox为方法的参数
		selectMenu_checkbox.onclick = this._selectBoxCheck.bindEvent(this,selectMenu_checkbox);
		selectMenu_li.insertBefore(selectMenu_checkbox,null);
		//----创建span内含文字
		var selectMenu_span = document.createElement("span");
		selectMenu_li.insertBefore(selectMenu_span,null);
		selectMenu_span.innerHTML = menuName[i];
	}
	//--建立隐藏文本框，用于存放选择的值
	var selectTxt_hideinput = document.createElement("input");
	selectTxt_hideinput.type = this._hideTextType;
	selectBox_div.insertBefore(selectTxt_hideinput,null);
	selectTxt_hideinput.id = "SelectHideValueText"
}
//重置多选下拉框列表中的选项
SelectBox.prototype._changeSelectBox = function(menuName,menuValue){
	this._menuName = menuName;
	this._menuValue = menuValue;
	var elem = document.getElementById(this._elem);
	elem.innerHTML = "";
	this._buildSelectBox();
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

/**
 * 浮点数字验证
 * 使用方法只能输入数字和小数点的文本框：<input id="input1" onkeyup="clearNoNum(this)">
 * @param obj
 */
function clearNoNum(obj)
{
    //先把非数字的都替换掉，除了数字和.
    obj.value = obj.value.replace(/[^\d.]/g,"");
    //必须保证第一个为数字而不是.
    obj.value = obj.value.replace(/^\./g,"");
    //保证只有出现一个.而没有多个.
    obj.value = obj.value.replace(/\.{2,}/g,".");
    //保证.只出现一次，而不能出现两次以上
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
}
