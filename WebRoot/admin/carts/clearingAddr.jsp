<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="admin_cart_clearingAddr_div" class="sgh-splb-bk">
		        <div class="cplb">
		            <div class="cc name"><span class="price">收货人姓名</span></div>
		            <div class="cc lb">
		            	<span class="price">
		            		<input type="hidden" id="admin_carts_clearingAddr_receiveAddrId" name="receiveAddr.id" value="${receiveAddr.id}">${receiveAddr.receiveName}
		            	</span></div><div style="clear:both"></div>
		        </div> 
		        <div class="cplb">
		            <div class="cc name"><span class="price">详细地址</span></div>
		            <div class="cc lb">
		            	<span class="price">${receiveAddr.pname}${receiveAddr.cname}${receiveAddr.aname}${receiveAddr.receiveAddress}
		            	</span>
		            </div>
		            <div style="clear:both"></div>
		        </div>
		        <div class="cplb">
		            <div class="cc name"><span class="price">联系电话</span></div>
		            <div class="cc lb"><span>${receiveAddr.telephone}</span><span>${receiveAddr.mobile}</span></div><div style="clear:both"></div>
		        </div>
		        <div class="cplb">
		            <div class="cc name"><span class="price">邮政编码</span></div>
		            <div class="cc lb"><span class="price">${receiveAddr.zip}</span></div><div style="clear:both"></div>
		        </div>
		  	</div> 