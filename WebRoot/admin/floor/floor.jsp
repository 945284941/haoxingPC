<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--footer开始-->
<div class="footer">
	<div class="main">
		<ul>
			<li>
				<div class="footer_img"><img src="images/lh_img_09.png" width="75" height="75" /></div>
				<div class="footer_wz">
					<p><s:text name="index_0254"/></p>
				</div>
			</li>
			<li>
				<div class="footer_img"><img src="images/lh_img_10.png" width="75" height="75" /></div>
				<div class="footer_wz">
					<p><s:text name="index_0255"/></p>
				</div>
			</li>
			<li>
				<div class="footer_img"><img src="images/lh_img_11.png" width="75" height="75" /></div>
				<div class="footer_wz">
					<p><s:text name="index_0256"/></p>
				</div>
			</li>
			<li>
				<div class="footer_img"><img src="images/lh_img_12.png" width="75" height="75" /></div>
				<div class="footer_wz">
					<p><s:text name="index_0257"/></p>
				</div>
			</li>

		</ul>
	</div>
</div>

<div class="foots" style="background: none;">
	<div class="w">
		<p style="color: #666; margin-top: 50px;">Copyright © 2013-2014 htp://www.sss.com <s:text name="index_0265"/> <s:text name="index_0243"/>：<s:text name="index_0266"/></p>
		<div class="foots_img">
			<ul>
				<li><img src="images/img_19.png" width="109" height="40" /></li>
				<li><img src="images/img_20.png" width="110" height="40" /></li>
				<li><img src="images/img_21.png" width="109" height="43" /></li>
				<li><img src="images/img_22.png" width="96" height="43" /></li>
			</ul>
		</div>
	</div>
</div>
<!--footer结束-->