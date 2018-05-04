<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="rxpl">
	<div class="rxgd">
		<div class="rxsp">
			<h2>
				<span>热销品类</span>
			</h2>
			<ul>
				<s:if test="%{companysGoodsCats.size()>0}">
					<s:iterator value="companysGoodsCats" var="li">
						<li><a
							href="/Shop/moreComgoods/<s:property value='#li.goodsCatId'/>_${company.id}.html" target="_blank"><s:property value="#li.name" />
						</a>
						</li>
					</s:iterator>
				</s:if>
				<s:else>
					<span style="color:red;">暂无热销品类！</span>
				</s:else>
			</ul>
			<div style="clear:both"></div>
		</div>
	</div>
</div>