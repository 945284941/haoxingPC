<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" language="javascript">
function hide(div){
	 document.getElementById(div).style.display = "none";
	}
</script>
<!--<div id="sjcxhd">
	<div class="sjcx">


		<div id="slides1" class="bannerzongcx">
			<div class="banner_new_1">
				<a class="prev" href="#"><img alt="上一页" src="images/cxpre.gif"
						width="20" height="20" /> </a>
			</div>
			<div class="banner_cx">
				<div class="slides_container">
					<c:forEach items="${goodsHotList }" var="v" varStatus="vs">
					<c:if test="${vs.index==0 }">
						<div id="banner_pic_${vs.index}" class="f_out">
						<a class="sjtitlebg" href="call/goodsHot.html" target="_blank">
								${v.companyName}</a>
							<div class="picintro">
								<p>
									促销活动：
									<c:choose>
										<c:when test="${fn:length(v.activeContent) > 20 }">
										${fn:substring(v.activeContent, 0, 20)}...
									</c:when>
										<c:otherwise>
										${v.activeContent}
									</c:otherwise>
									</c:choose>
								</p>
								<p>
									联系方式：${v.companyLinkPhone}
								</p>
							</div>
						</div>
					</c:if>
						<div style="DISPLAY: none" id="banner_pic_${vs.index}" class="f_out">
					<a class="sjtitlebg" href="call/goodsHot.html" target="_blank">
							${v.companyName}</a>
						<div class="picintro">
							<p>
								促销活动：
								<c:choose>
									<c:when test="${fn:length(v.activeContent) > 20 }">
									${fn:substring(v.activeContent, 0, 20)}...
								</c:when>
									<c:otherwise>
									${v.activeContent}
								</c:otherwise>
								</c:choose>
							</p>
							<p>
								联系方式：${v.companyLinkPhone}
							</p>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
			<div class="banner_new_r">
				<a class="next" href="#"><img alt="下一页" src="images/cxnext.gif"
						width="20" height="20" /> </a>
			</div>
		</div>
		<div class="clickcxzt">
			<a href="call/goodsHot.html"><img src="images/cxztbg2.gif" /> </a>
		</div>
	</div>
	
</div>
<!--<div class="gbcx"><img src="images/cxgb.gif" onclick="divA.animate({width:'0px'})"/></div>
<div class="gbcx"><img src="images/cxgb.gif" onclick="divA.animate({width:'1280px'})"/></div>  -->
<!--商家促销活动begin-->
<div class="gzgz"  >
      <div class="gzgzhd f_list">         
         <div id="slides" class="bannerzongcx ">
  <!--<div class="banner_new_1"><a class="prev" href="#"><img alt="上一页" src="images/cxpre.gif" width="20" height="20"/></a></div>-->
  <div class="banner_cx " >
		<c:forEach items="${goodsHotList }" var="v" varStatus="vs">
					<div class="f_out" id="banner_pic_1">
						<a class="sjtitlebg" href="call/goodsHot.html" target="_blank">
							${v.companyName} </a>
						<div class="picintro">
							<p>
								促销活动：
								<c:choose>
									<c:when test="${fn:length(v.activeContent) > 25 }">
									${fn:substring(v.activeContent, 0, 25)}......
								</c:when>
									<c:otherwise>
									${v.activeContent}
								</c:otherwise>
								</c:choose>
							</p>
							<p>
								联系方式：${v.companyLinkPhone}
							</p>
						</div>
						<div class="flash_tab">
			</div>
					</div>
				</c:forEach>
				<div class="tabs f_tabs" style="width: 330px;">
					<ul id="xhul" >
					<c:forEach items="${goodsHotList }" var="v" varStatus="vs">
						<li class="f_tab opdiv">
							<a href="javascript:void(0);" title="${vs.index}"> </a>
						</li>
					</c:forEach>
					</ul>
				</div>
	</div>

</div>
      <div class="clickcxzt">
        <a href="call/goodsHot.html"><img src="images/cxztbg03.gif" /></a>
      </div> 
     </div>
      <div class="gbcx"></div>
    </div>
    </div>
<script type="text/javascript">
FeatureList(".f_list", {
	"onclass" : "noopdiv",
	"offclass" : "opdiv",
	"pause_on_act" : "mouseover",
	"interval" : 5000,
	"speed" : 1
});
</script>
		
