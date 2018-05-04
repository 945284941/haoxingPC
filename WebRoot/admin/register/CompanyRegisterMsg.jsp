<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>三古汇官方商城欢迎你</title>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="x-ua-compatible" content="ie=7" />
		<jsp:include page="/admin/common/keyWords.jsp" />
		<script src="js/jquery-1.8.0.min.js" type="text/javascript">
</script>
		<script type="text/javascript" src="js/jquery.form.js">
</script>
		<link href="css/master.css" rel="stylesheet" type="text/css" />
		<link href="css/news.css" rel="stylesheet" type="text/css" />
		<link href="css/shophy.css" rel="stylesheet" type="text/css" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/register.js"></script>
		<script type="text/javascript" src="js/perinfo.js"></script>
		<script type="text/javascript">
$(function() {
	var newUsername = '${company.username}';
	if ('' == newUsername) {
		alert("信息丢失，请重新填写！");
		location.href = "toCompanyRegister.html";
	} 
});
function setStyle(x, y) {
	document.getElementById(x).style.display = 'none';
	document.getElementById(y).focus();
}
</script>
	</head>
	<div id="maskmember"></div>
	<body>
	<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	<jsp:include page="../common/navigation.jsp"></jsp:include>
	<div class="breadThumb">首页 > 企业注册</div>

		<div class="hdzxtg">
			<div class="huiyuanbt">
				<p class="huiyuanbtgr">
					个人会员
				</p>
				<p class="huiyuanbtqynew">
					企业会员
				</p>
			</div>
			<div class="hyzcmain">
				<div class="hyfore3">
				</div>

				<div class="hyhdxznr3">
					<form id="companyMsgFrom" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="carBrandId" id="carBrandId" value="" />
						<input type="hidden" name="company.password"
							value="${company.password}" />
						<input type="hidden" name="company.username"
							value="${company.username}" />
						<div class="hybdaa">
							<span class="jz dlnc">企业名称：</span>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbk" name="company.companyName"
									id="companyname" type="text"
									onfocus="setStyle('companynamez','companyname')" />
							</div>
							<span class="btx">*</span>
							<div class="zcgzz" id="companynamez"
								onclick="setStyle(this.id,'companyname')">
								请输入营业执照公司注册名称
							</div>
						</div>
						<div class="hybdaa">
							<span class="jz dlnc">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</span>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbk" type="text" name="company.linkmanName"
									id="linkmanName"
									onfocus="setStyle('linkmanNamez','linkmanName')" />
							</div>
							<span class="btx">*</span>
							<div class="zcgzz" id="linkmanNamez"
								onclick="setStyle(this.id,'linkmanName')">
								请输入联系人姓名
							</div>
						</div>
						<div class="hybdaa">
							<span class="jz dlnc">办公地址：</span>
							<div class="dlwbk">
								<select class="wzqyk" onchange="displayPro();"
									name="company.province" id="pro">
									<option class="xzscs" value="0">
										-选择省-
									</option>
									<s:iterator value="citylist" var="Regions">
										<option value="<s:property value="id" />"
											id="<s:property value="id" />">
											<s:property value="name" />
										</option>
									</s:iterator>
								</select>

							</div>
							<div class="dlwbk xzs">
								<select class="wzqyk" id="regionlistOption" name="company.city"
									onchange="displayCS();">
									<option value='0'>
										-选择市-
									</option>
								</select>
							</div>
							<div class="dlwbk xzs">
								<select class="wzqyk" id="area" name="company.area">
									<option value='0'>
										-选择区-
									</option>
								</select>
							</div>
							<span class="btx">*</span>
						</div>
						<div class="hybdaa">
							<span class="jz lxr">联系人手机：</span>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbk" type="text" name="company.linkmanPhone"
									id="linkmanPhone"
									onfocus="setStyle('linkmanPhonez','linkmanPhone')" />
							</div>
							<span class="btx">*</span>
							<div class="zcgzz" id="linkmanPhonez"
								onclick="setStyle(this.id,'linkmanPhone')">
								请输入联系人手机号
							</div>
						</div>
						
						<div class="hybdaa">
							<span class="jz lxr">联系人性别：</span>
							<div class="dlwbk">
								<select class="csly" id="linkmanSex" name="company.linkmanSex">
									<option class="xzscs" value="">
										请选择
									</option>
									<option value="0">
										女
									</option>
									<option value="1">
										男
									</option>
								</select>
							</div>


						</div>
						<div class="hybdaa">
							<span class="jz lxr">店铺qq客服：</span>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbk" type="text" id="qqNumber"
									name="company.qqNumber" />
							</div>
							<span class="btx">*</span>
						</div>
						<div class="hybdaa">
							<span class="jz dlnc">固定电话：</span>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbk" type="text" id="telphone"
									name="company.telphone" />
							</div>

						</div>
						<div class="hybdaaqy">
							<span class="jz dlnc">详细地址：</span>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbk" type="text" name="company.address"
									id="address" onfocus="setStyle('addressz','address')" />
							</div>
							<span class="btx">*</span>
							<div class="zcgzz" id="addressz"
								onclick="setStyle(this.id,'address')">
								请输入详细地址
							</div>
						</div>
						<div class="hybdaayyzz">
							<span class="jz yyzzsc">营业执照/组织机构代码证扫描件</span>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbk" name="fileupload" type="file"
									id="companyLicense" />
							</div>
							<span class="btx">*</span>

						</div>

						<div class="hybdaaqy">
							<span class="jz dlnc">电子邮箱：</span>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbk" type="text" id="email"
									name="company.email" onfocus="setStyle('emailz','email')" />
							</div>
							<span class="btx">*</span>
							<div class="zcgzz" id="emailz"
								onclick="setStyle(this.id,'email')">
								请输入邮箱地址
							</div>
						</div>
						<div class="hybdaalogo">
							<span class="jz dlnc">企业logo：</span>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbk" name="fileupload" type="file"
									id="companyLogo" />
							</div>
							<span class="btx"></span>

						</div>
						<div class="hybdaaqy">
							<span class="jz dlnc">激&nbsp;&nbsp;活&nbsp;&nbsp;码：</span>
							<input class="mfhqjhm1"  id="admin_companyRegisterMsg_toESM" type="button" value="免费获取短信激活码" onclick="getMobileCode('admin_companyRegisterMsg_toESM','linkmanPhone',1);"/>
							<div class="dlwbk">
								<label for="textfield"></label>
								<input class="dlwbbkyzm" type="text"  id="linkmanPhoneCode"  />
							</div>
							<span class="btx">*</span>							
						</div>
						<div class="hybdaa">

							<p class="wcxyban2">
								<a href="javascript:void(0)" onclick="companyMsgFromSub();">完成，下一步</a>
							</p>
						</div>

					</form>

				</div>
			</div>

		</div>
	<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
		<!-- footer end -->
<jsp:include page="/admin/common/indexFooter.jsp" />
		<div id="pop_member"
			style="display: none; position: absolute; z-index: 100;">
		</div>
	</body>
</html>

