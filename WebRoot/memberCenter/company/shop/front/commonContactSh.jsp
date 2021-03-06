<%@page import="com.qlzy.common.tools.ResourceUtil"%>
<%@page import="com.qlzy.pojo.SessionInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SessionInfo sessionInfo = (SessionInfo) session
			.getAttribute(ResourceUtil.getSessionInfoName());
	String memberId = sessionInfo == null ? "" : sessionInfo
			.getUserId();
%>
<script type="text/javascript" src="js/qlzy.js"></script>
<div class="zs">
			<h2>
				<span>联系方式</span>
			</h2>
			<div class="zsleft">
				<p>
					<span>所在区域： <s:if
							test="null!=company.province && ''!=company.province">${company.pname}${company.cname}${company.aname}</s:if>
						<s:else>---</s:else> </span>
				</p>
				<p style="height:40px; line-height:20px;">
					<span
						style=" line-height:20px; height:40px; margin-right:0; overflow:hidden">商家地址：<s:if
							test="null!=company.address && ''!=company.address">${company.address}</s:if>
						<s:else>---</s:else>
					</span>
				</p>
				<p>
					<span>会员级别<img src="/images/levelIcon/${company.vipGradeImgSrc}" title="${company.vipLevelName}"/>
					</span>
				</p>
				<p>
					<span>质量等级
					<s:if test='null!=company.qualityImgSrc&&""!=company.qualityImgSrc'>
							<img src="/images/levelIcon/${company.qualityImgSrc}" />
						</s:if>
					<s:else>0级</s:else>
					</span>
					<span>信誉级别
					<s:if test='null!=company.creditImgSrc&&""!=company.creditImgSrc'>
							<img src="/images/levelIcon/${company.creditImgSrc}" />
						</s:if>
						<s:else>0级</s:else>
					</span>
				</p>
				<p>
					<span>服务等级
					<s:if test='null!=company.serveImgSrc&&""!=company.serveImgSrc'>
							<img src="/images/levelIcon/${company.serveImgSrc}" />
						</s:if>
						<s:else>0级</s:else>	
					</span>
					<span>物流等级
						<s:if test='null!=company.logisticsImgSrc&&""!=company.logisticsImgSrc'>
							<img src="/images/levelIcon/${company.logisticsImgSrc}" />
						</s:if>
						<s:else>0级</s:else>	
					</span>
				</p>
				<p>
					<span>入驻时间：<s:date name="%{company.regTime}"
							format="yyyy.MM.dd" /></span>
				</p>
				<p>
					<span>固定电话：<s:if
							test="null!=company.telphone && ''!=company.telphone">${company.telphone}</s:if>
						<s:else>---</s:else></span>
				</p>
				<p>
					<span>移动电话：<s:if
							test="null!=company.mobile && ''!=company.mobile">${company.mobile}</s:if>
						<s:else>---</s:else></span>
				</p>
				<p class="zxz">
					<!--  a href="#"><img src="images/vip/zxzx.gif" width="133"
						height="34" />
					</a>-->
					<a target=blank href=tencent://message/?uin=${company.qqNumber}&Site=www.ik38.com&Menu=yes>
					<img src="/images/vip/zxzx.gif" width="133"
						height="34"/>
						</a>
				</p>
			</div>
		</div>