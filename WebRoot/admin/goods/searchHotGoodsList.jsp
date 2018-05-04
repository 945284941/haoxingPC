<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
</script>
 <div class="lb_mid_let_bot">
        <div class="lb_mid_let_bot_top">宝贝推荐</div>
        
        <s:iterator value="hotGoodsList" status="st">
		        <div class="lb_mid_let_bot_tj">
		            <div><a  href="goods/${id}.html" target="_blank"><img src="${defaultPicSrc }" width="180" height="180" /></a></div>
		            <ul>
		                <li>￥<span>${price }</span></li>
		                <li><div class="lb_mid_let_bot_wz">${lessinformation}</div> </li>
		                <li>总销量：${queryNum}</li>
		            </ul>
		        </div>
        </s:iterator>
     </div>
