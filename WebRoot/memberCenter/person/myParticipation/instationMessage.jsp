<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
<script type=text/javascript src="js/slides.jquery.js"></script>
<script type=text/javascript src="js/tanchu.js"></script>
<script type=text/javascript src="js/public.js"></script>
<script type=text/javascript src="js/perinfo.js"></script>
<script language="JavaScript" type="text/JavaScript">
	function showElement(elementId) {
		document.getElementById(elementId).style.display = "block";
	}
	function hideElement(elementId) {
		document.getElementById(elementId).style.display = "none";
	}
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
<div id="tanchu"></div>
</head>
<body>
	<!-- head start -->
	<div class="header">
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
	</div>
	<div class="logo">
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
	</div>
	<!-- head end -->

	<!-- 导航 -->
	<jsp:include page="/memberCenter/common/navigation.jsp" />
	<!-- 导航结束 -->
	<c:choose>
		<c:when test="${sessionInfo.userType=='company' }">
		<div class="dht">首页 &gt; 企业会员中心 &gt;我的参与 &gt; 站内短信</div>
		</c:when>
		<c:otherwise><div class="dht">首页 &gt; 个人会员中心 &gt;我的参与 &gt; 站内短信</div></c:otherwise>
	</c:choose>	
	<div class="gzgz">
		<div class="hyleft">
		<c:choose>
			<c:when test="${sessionInfo.userType=='company' }"><jsp:include page="/memberCenter/common/leftNavigate.jsp" /></c:when>
			<c:otherwise><jsp:include page="/memberCenter/common/leftNavigatePerson.jsp" /></c:otherwise>
		</c:choose>			
		</div>
		<div class="hyright">
			<div class="hyrightr">
				<div id="rightjxw">
					<p class="hyd0">
						收到信息总数<span>${mesCount.receiveCount}</span>
					</p>
					<p class="hyd0">
						已读信息总数<span>${mesCount.alreadyReadCount}</span>
					</p>
					<p class="hyd0">
						未读信息总数<span>${mesCount.noReadCount}</span>
					</p>
					<p class="hyd0">
						发送信息总数<span>${mesCount.sendCount}</span>
					</p>
				</div>
			</div>
			<form action="/person/myParticipation/instationMessageList.html" name="instationMessageSearchForm" id="instationMessageSearchForm" method="post">
				<p class="hymainbt">
					<input type="hidden" id="isReceive" name="isReceive" value="${isReceive}" />
					<span class="grmenubt">站内短信</span><span class="zndxss">
					<input type="text" class="srmc" id="m_name" name="m_name" value="${name}"/>
					<input type="submit" class="dxss" value="搜索" /> </span>
					<!--<span style="width:260px; position:relative; font-size:12px; color:#A7A7A7; top:7px; left:30px; z-index:2;" id="mname" onclick="input_clear(this.id,'m_name')">请输入好友用户名</span>-->					
				</p>			
			</form>
			<h2 class="znxxh" id="_zndx">
				<span <s:if test="#request.isReceive == 0 || (#request.isReceive != 1)">class="tabxx"</s:if> onclick="m_getInstationMessageList(0);"><a
					href="javascript:void(0)">收到的信息</a> </span> <span <s:if test="#request.isReceive == 1">class="tabxx"</s:if>
					onclick="m_getInstationMessageList(1);"><a
					href="javascript:void(0)">发送的信息</a> </span>				
				<a class="fxx"
					href="javascript:void(0);"
					onclick="m_toSendInstationMessage('tanchu', 'm_sendMessage', 'm_to2', 6);">发信息</a>
			</h2>
			<div class="grjbxx2" style="padding-bottom:10px;">
				<s:if test="%{instationMessageList.size()>0}">
					<s:iterator value="instationMessageList" var="li">
						<div class="grzxlb" id="m_zndxlist">
							<ul>
								<li class="zndxone"><input type="checkbox" id="_checkbox"
									name="_checkbox" value="<s:property value='#li.id'/>" /></li>
								<li class="zndxthree"><s:if test="#li.status==0">
										<img src="/images/memberimg/sdxx01.gif" />
									</s:if> <s:else>
										<img src="/images/memberimg/sdxx02.gif" />
									</s:else></li>
								<li class="zndxtwo"><span> <s:if test="#li.type==0">【系统消息】</s:if>
										<s:else>【好友消息】</s:else> </span> <s:property value="#li.messageTitle" />
								</li>
								<li class="zndxfive"><a href="javascript:void(0);"
									onclick="m_viewMessage('tanchu', 'm_viewMessage','${li.id}');">【查看】</a>
								</li>
								<li class="zndxfour"><s:date name="#li.createtime"
										format="yyyy-MM-dd hh:mm" />
								</li>
							</ul>
							<div style="clear:both"></div>
						</div>
					</s:iterator>
				</s:if>
				<s:else>
					<div class="grzxlb">
						<ul>
							<li><span style="color:red;text-align: center;">暂时没有符合条件的数据！</span>
							</li>
						</ul>
						<div style="clear:both"></div>
					</div>
				</s:else>

				<div class="dxqx">
					<span><input type="checkbox" name="checkbox_"
						onclick="CheckAll_(this)" />全选</span><a class="qd"
						href="javascript:void(0);"
						onclick="delAll('','/person/myParticipation/deleteInstationMessage.html','/person/myParticipation/instationMessageList.html');">删除</a>
				</div>
				<!-- 分页开始 -->
				<div id="showpages">
					<page:pagination
						path="person/myParticipation/instationMessageList.html" formName="instationMessageSearchForm"/>
				</div>
				<!-- 分页结束 -->
			</div>
		</div>
	</div>
	<!--发信息弹出框开始-->
	<!-- viewMessage start -->
	<div id="m_viewMessage" class="tcpjxx" style="visibility:hidden">
		<h2>
			<span id="m_msg_title" style="width:520px;display:block;float:left;"></span><a style="margin-left:50px;float:left" href="javascript:void(0);"
				onclick="m_closeViewMessage('tanchu', 'm_viewMessage');">【关闭】</a>
		</h2>
		<p class="pjcontent">
			<input id="m_msg_id" name="m_msg_id" type="hidden"/>
			<textarea id="m_msg_content"></textarea>
		</p>
		<div style="margin-left:15px; position:relative">
			<a class="tcqr2" href="javascript:void(0);"
				onclick="m_replyInstationMessage('tanchu', 'm_sendMessage', 2,'m_viewMessage','m_to2');">回复信息</a>
			<div class="tcsc">
				<input type="checkbox" id="delChecked" name="delChecked"/>删除此条信息<a
					href="javascript:void(0);" onclick="m_isCheckedBydelCheckbox('')">[OK]</a>
			</div>
		</div>
	</div>
	<!-- viewMessage end -->

	<div id="m_sendMessage" class="tcpjxx" style="visibility:hidden">
		<form id="m_sendInstationMessageForm"
			name="m_sendInstationMessageForm" method="post"
			action="person/myParticipation/addInstationMessage.html">
			<input type="hidden" id="m_fromId" name="instationMessage.fromId"
				value="${sessionInfo.userId}" /> <input type="hidden" id="m_fromId"
				name="instationMessage.userType" value="${sessionInfo.userType}" />
			<input type="hidden" id="m_to_userType" name="instationMessage.toUserType"/>				
			<div class="fsg">
				<ul>
					<li><strong>发信息给</strong><input type="text" id="m_to1"
						name="instationMessage.toId1" /></li>
					<li><strong>选择好友</strong>
					<select id="m_to2" name="instationMessage.toId2">
						<option value="">请选择好友</option>
					</select>
					</li>
					<li class="fdxgb"><a href="javascript:void(0);"
						onclick="_closePubDialog('tanchu', 'm_sendMessage');">【关闭】</a></li>
				</ul>
			</div>
			<div class="fstitle">
				<span>标题：</span><input type="text" id="m_messageTitle"
					name="instationMessage.messageTitle" /><span class="fsbt">*
					必填</span>
			</div>
			<p class="pjcontent">
				<textarea id="m_content" name="instationMessage.content"></textarea>
			</p>
			<div style="margin-left:500px; position:relative">
				<a href="javascript:void(0);"
					onclick="m_sendInstationMessage('${sessionInfo.userId}')"><img
					src="/images/memberimg/okfs.gif" /> </a>
			</div>
		</form>
	</div>
	<!--发信息弹出框结束-->

	<!-- footer begin -->
	<div class="gzgz">
		<jsp:include page="/admin/common/footer.jsp" />
	</div>
	<!-- footer end -->
</body>
</html>