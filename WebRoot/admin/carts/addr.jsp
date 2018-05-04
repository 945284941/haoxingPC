<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<style>
.list{width:600px;}
.list>span{color:#333;line-height:15px;margin-bottom:12px;font-weight:normal;font-size:13px;}
div.qrshdz{text-align:center;}
</style>

<div style="padding-left: 12px; display: block;" name="consignee-form" id="consignee-form" class="consignee-form">
	
					<div id="name_div" class="list">
						<span class="label"><em>*</em>收货人：</span>
						<div class="field">
							<input type="hidden" id="admin_cart_clearingr_eceiveAddr_id" name="admin_cart_clearingr_eceiveAddr_id" value="${receiveAddr.id}">
							<input type="text" maxlength="20" id="admin_cart_clearingr_eceiveAddr_name" class="textbox" value="${receiveAddr.receiveName}">
						</div>
						<span id="name_div_error" class="status error"></span>
					</div>
					<div class="list select-address">
						<span class="label"><em>*</em>所在地区：</span>
						<div class="field">
							<span id="span_area">
								<span id="span_province">
									<s:select id="admin_cart_clearingProvince" name="" headerKey="0" headerValue="-选择省-" list="provinces" listKey="id" listValue="name" value="%{receiveAddr.province}" theme="simple" onchange="_getCitys(this.value,'admin_cart_clearingCity','admin_cart_clearingArea')"></s:select> 
								</span>
							<span>
								<s:select id="admin_cart_clearingCity" name="" headerKey="0" headerValue="-选择市-" list="cityList" listKey="id" listValue="name" value="%{receiveAddr.city}" theme="simple" onchange="_getAreas(this.value,'admin_cart_clearingArea')"></s:select> 
							</span>
							<span id="span_county">
								<s:select id="admin_cart_clearingArea" name="" headerKey="0" headerValue="-选择区-" list="areaList" listKey="id" listValue="name" value="%{receiveAddr.area}" theme="simple"></s:select>
							</span>
						</span>
					</div>
					<span id="area_div_error" class="status error"></span>
				</div>
				<div class="list full-address">
					<span class="label"><em>*</em>详细地址：</span>
					<div class="field">
						<input type="text" maxlength="50" id="admin_cart_clearingr_receiveAddr_receiveAddress"  class="textbox" value="${receiveAddr.receiveAddress}">
					</div>
					<span class="status error"></span>
				</div>
				<div class="list">
					<span class="label"><em>*</em>手机号码：</span>
					<div class="field">
						<div class="xgphone">
							<input type="text" id="admin_cart_clearingr_receiveAddr_mobile" maxlength="11"  class="textbox" value="${receiveAddr.mobile}">
							<em>或</em>
							<span>固定电话：</span>
							<input type="text" id="admin_cart_clearingr_receiveAddr_telephone" maxlength="20" class="textbox" value="${receiveAddr.telephone}">
						</div>
						<span class="status error"></span>
					</div>
				</div>
				<div class="list">
					<span class="label"><em>*</em>邮箱：</span>
					<div class="field">
						<input type="text" class="textbox" id="admin_cart_clearingr_receiveAddr_email" value="${receiveAddr.email}">
					    <span class="form-tip">用来接收订单提醒邮件，便于您及时了解订单状态</span>
					</div>
				</div>
			</div>
