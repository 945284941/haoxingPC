<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<script type="text/javascript">
	function changeAddress(t) {
		$.ajax( {
			url : 'changeAddress.html',
			type : 'POST',
			data : {"addressId":t},
			success : function(data) {
				var msg = $.parseJSON(data);
				if (msg == '001') {
					alert('很抱歉，切换失败！');
					return false;
				}else{
					location.reload();
					return true;
				}
			}
		});
	}
</script>
<div id="mask"></div>
<!-- top -->
<div class="top">
	<div class="top_page">
		<div class="pageright" id="site-nav">
			<ul class="quick-menu">
				<li class="mytaobao menu-item menupx">
					<div class="menu">
						<span><s:text name="index_0272"/></span>
					</div>
				</li>
				<s:if test="#attr.sessionInfo.loginName!=null">
					<li class="mytaobao menu-item menupx">
						<div class="menu">
							<a class="menu-hd" rel="nofollow" style="padding-left: 8px; padding-right: 8px;">欢迎 ${fn:substring(sessionInfo.loginName, 0, 8)}</a>
						</div>
					</li>
					<li class="mytaobao menu-item menupx">
						<div class="menu">
							<a class="menu-hd" href="#" rel="nofollow" style="width: 100px;padding-left: 0;padding-right: 0;text-align: center;"><s:text name="index_0088"/></a>
							<div class="menu-bd">
								<div class="menu-bd-panel">
									<div>
										<a href="#" rel="nofollow"><s:text name="index_0170"/></a>
										<a href="#" rel="nofollow"><s:text name="index_0124"/></a>
										<a href="#" rel="nofollow"><s:text name="index_0123"/></a>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li class="mytaobao menu-item menupx">
						<div class="menu">
							<a class="menu-hd"  onclick="loginOrNot('person/order/huiyuanzhongxin.html');" rel="nofollow" style="width: 100px;padding-left: 0;padding-right: 0;text-align: center;"><s:text name="index_0118"/></a>
							<div class="menu-bd">
								<div class="menu-bd-panel">
									<div>
										<a href="#" rel="nofollow"><s:text name="index_0249"/></a>
										<a href="#" rel="nofollow"><s:text name="index_0250"/></a>
										<a href="#" rel="nofollow"><s:text name="index_0251"/></a>
									</div>
								</div>
							</div>
						</div>
					</li>
				</s:if>
				<s:else>
				<li class="mytaobao menu-item menupx">
					<div class="menu">
						<a class="menu-hd" href="toLogin.html" rel="nofollow" style="padding-left: 8px; padding-right: 8px;"><s:text name="index_0112"/></a>
					</div>
				</li>
				<li class="mytaobao menu-item menupx">
					<div class="menu">
						<span><a class="menu-hd" href="toRegister.html" rel="nofollow" style="text-decoration: underline;padding-left: 8px; padding-right: 8px;"><s:text name="index_0109"/></a></span>
					</div>
				</li>
				</s:else>

				<li class="mytaobao menu-item menupx">
					<div class="menu">
						<span><a class="menu-hd" href="toBrands.html" rel="nofollow" style="text-decoration: underline;padding-left: 8px; padding-right: 8px;"><s:text name="index_0283"/></a></span>
					</div>
				</li>

				<li class="mytaobao menu-item menupx">
					<div class="menu">
						<a class="menu-hd" href="" rel="nofollow" style="width: 100px;padding-left: 0;padding-right: 0;text-align: center;"><s:text name="index_0252"/></a>
						<div class="menu-bd">
							<div class="menu-bd-panel">
								<div>
									<a href="#" rel="nofollow"><img src="images/ewm1.jpg" /></a>
									<span style="color: #666;">android <s:text name="index_0273"/></span>
									<a href="#" rel="nofollow"><img src="images/ewm1.jpg" /></a>
									<span style="color: #666;">IOS <s:text name="index_0273"/></span>
									<a href="#" rel="nofollow"><img src="images/ewm1.jpg" /></a>
									<span style="color: #666;">WAP <s:text name="index_0273"/></span>
								</div>
							</div>
						</div>
					</div>
				</li>
				<li class="mytaobao menu-item menupx">
					<div class="menu">
						<a class="menu-hd" href="javascript:changeJustLanguage('zh_CN')" rel="nofollow" style="padding-left: 8px; padding-right: 8px;"><s:text name="index_0270"></s:text></a>
					</div>
				</li>

				<span class="pageleft">|</span>
				<li class="mytaobao menu-item menupx">
					<div class="menu">
						<span><a class="menu-hd" href="javascript:changeJustLanguage('en_US')" rel="nofollow" style="padding-left: 8px; padding-right: 8px;">EN</a></span>

					</div>
				</li>
				<s:if test="#attr.sessionInfo.loginName!=null">
					<li class="mytaobao menu-item menupx">
						<div class="menu">
							<span><a class="menu-hd" href="logout.html" rel="nofollow" style="text-decoration: underline;padding-left: 8px; padding-right: 8px;"><s:text name="index_0241"/></a></span>

						</div>
					</li>
				</s:if>
			</ul>
		</div>
		<div class="pageleft">
			<span><i class="icon iconfont">&#xe611;</i><s:text name="index_0271"/></span>
		</div>
		<div class="pageleft"  style="margin-left: 15px;">
			<ul class="quick-menu">
				<li class="mytaobao menu-item menupx">
					<div class="menu">
						<a class="menu-hd" href="#" rel="nofollow" style="padding-top: 0px;"><i class="icon iconfont">&#xe650;</i>
							<c:if test="${'zh' eq sessionInfo.language}">
								${sessionInfo.addressMap["addressName"]}
							</c:if>
							<c:if test="${'zh' ne sessionInfo.language}">
								${sessionInfo.addressMap["addressEnName"]}
							</c:if>

						</a>
						<div class="menu-bd" style="width: 100px; float: left; right: initial;">
							<div class="menu-bd-panel">
								<div>
									<c:forEach items="${changeCountryList}" var="country" varStatus="status">
										<c:if test="${country.id ne sessionInfo.addressMap['addressId']}">
											<a href="javascript:void(0)" onclick="changeAddress('${country.id}');" rel="nofollow">
													<c:if test="${'zh' eq sessionInfo.language}">
														${country.name}
													</c:if>
													<c:if test="${'zh' ne sessionInfo.language}">
														${country.nameEng}
													</c:if>
											</a>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- top结束 -->
<div  id="pop_500" style="display:none;">
	<jsp:include page="../login/checkLogin.jsp" flush="true" />
</div>
<script type="text/javascript" src="js/loginOrNot.js"></script>