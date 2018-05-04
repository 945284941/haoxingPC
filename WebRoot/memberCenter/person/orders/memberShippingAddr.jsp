<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div id="memberCenter_person_orders_memberShippingAddr">
	<ul>
		<s:iterator var="ra" value="raList" status="status">
			<li>
			<span class="shname">${ra.receiveName}</span> 
			<span class="shphone">${ra.mobile}</span> 
			<span class="shxxdz">${ra.pname}${ra.cname}${ra.aname}${ra.receiveAddress}</span>
			<span class="shOpt">
				<a class="shbj" href="javascript:openMemberAddr('${ra.id}');">编辑</a>
				<a class="shbj" href="javascript:delAddr('${ra.id}');">删除</a>
			</span>
				
				<s:if test="#ra.isDefault == 'true'">
					<span class="shmr" style="color:#D01528;text-align:center;">默认地址</span>
				</s:if> <s:else>
					<a class="shmr" href="javascript:setDefaultAddr('${ra.id}');">设为默认地址</a>
				</s:else></li>
		</s:iterator>


	</ul>
</div>