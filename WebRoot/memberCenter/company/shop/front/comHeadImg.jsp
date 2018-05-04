<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type=text/javascript src="js/slides2.jquery.js"></script>
<script>
	$(function() {
		//滚动Banner图片的显示
		$('#slides').slides({
			preload : false,
			preloadImage : '/images/loading.gif',
			effect : 'fade',
			slideSpeed : 400,
			fadeSpeed : 100,
			play : 3000,
			pause : 100,
			hoverPause : true
		});
	});
</script>
<!-- 滚动图片 -->
<div id="slides" class="gzgzvip banner_vip">
	<div class="banner_new_1">
		<a class="prev" href="javascript:void(0)"><img alt="上一页"
			src="/images/banner_l.png" width="24" height="43" /> </a>
	</div>
	<div class="bannerImg">
		<div class="slides_container">
			<s:if test="%{companysHeadImgs.size()>0}">
				<s:iterator value="companysHeadImgs" var="chi" status="st">
					<s:if test="#st.first">
						<div id="banner_pic_<s:property value='#st.index+1'/>">
							<img src="<s:property value='#chi.imgSrc'/>" width="1179"
								height="323" />
						</div>
					</s:if>
					<s:else>
						<div style="DISPLAY: none"
							id="banner_pic_<s:property value='#st.index+1'/>">
							<img src="<s:property value='#chi.imgSrc'/>" width="1179"
								height="323" />
						</div>
					</s:else>
				</s:iterator>
			</s:if>
			<s:else>
				<div id="banner_pic_1">
					<img src="/images/vip/banner01.jpg" width="1179" height="323" />
				</div>
			</s:else>
		</div>
	</div>
	<div class="banner_new_r">
		<a class="next" href="javascript:void(0)"><img alt="下一页"
			src="/images/banner_r.png" width="24" height="43" /> </a>
	</div>
</div>
<!-- 滚动图片 -->