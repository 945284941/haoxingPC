<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="gzgz">
<div class="newszong">
   <div class="xwzx">
     <p class="xxzxbt"><a href="qpzx.html" target="_blank"><span class="xwzxz">汽配资讯</span></a><span class="gengd"><a href="qpzx.html" target="_blank">更多&gt;&gt;</a></span></p>
     <ul class="xwzxlist">
     	<s:iterator value="%{map.news_0}" id="n">
     		<li><a href="news/more/<mi:encoder value="${n.newsCatName}" />.html" ><span class="xwzxlifl">[${n.newsCatName}]</span></a><span class="xwzxlinr">
     			<a href="news/detail/${n.id }.html"  title="${n.firstTitle }">
     		<s:if test="%{#n.firstTitle.length()>12}"><s:property value="%{#n.firstTitle.substring(0, 12)}" />...</s:if>
     		<s:else>
     			<s:property value="%{#n.firstTitle}" />
     		</s:else></a>
     		</span><span class="xwzxlidate"><s:date name="#n.createtime"  format="yyyy-MM-dd" /></span></li>
     	</s:iterator>
     </ul>
   </div>
 <div class="schq">
      <p class="schqbt"><a href="schq.html" target="_blank"><span class="xwzxz">市场行情</span></a><span class="schqfl">|<a href="news/more/<mi:encoder value="中国重配" />.html">中国重配</a>-<a href="news/more/<mi:encoder value="国际重配" />.html">国际重配</a>-<a href="news/more/<mi:encoder value="品牌重配" />.html">品牌重配</a></span><span class="gengd"><a href="schq.html" target="_blank">更多&gt;&gt;</a></span></p>
     <ul class="schqlist">
       <s:iterator value="%{map.news_1}" id="n">
     		<li><a href="news/more/<mi:encoder value="${n.newsCatName}" />.html" ><span class="xwzxlifl">[${n.newsCatName}]</span></a><span class="schqlistnr">
     			<a href="news/detail/${n.id }.html"  title="${n.firstTitle }">
     		<s:if test="%{#n.firstTitle.length()>17}"><s:property value="%{#n.firstTitle.substring(0, 17)}" />...</s:if>
     		<s:else>
     			<s:property value="%{#n.firstTitle}" />
     		</s:else></a>
     		</span><span class="xwzxlidate"><s:date name="#n.createtime"  format="yyyy-MM-dd" /></span></li>
     	</s:iterator>
     </ul>
   </div>
	<div class="schq">
      <p class="schqbt"><a href="gqxx.html" target="_blank"><span class="xwzxz">供求信息</span></a><span class="fbxxan"><a onclick="loginOrNot('/s_supplyfb.html')">发布信息</a></span><span class="gengd"><a href="gqxx.html" target="_blank">更多&gt;&gt;</a></span></p>
     <ul class="schqlist">
     	<c:forEach items="${supplys }" var="n">
     		<li><span class="xwzxlifl">
     			<c:choose>
     				<c:when test="${n.status==1 }">
     					[供]
     				</c:when>
     				<c:otherwise>
     					[求]
     				</c:otherwise>
     			</c:choose>
     			</span><span class="schqlistnr3">
     			<a href="/v_supply/${n.id }/${n.typeId}.html"  title="${n.title }">
     				${fn:substring(n.title, 0, 21)}
	     		</a>
     		</span><span class="xwzxlidate"><s:date name="#n.createtime"  format="yyyy-MM-dd" /></span></li>
     	</c:forEach>
     </ul>
   </div>
   <div class="schq">
      <p class="schqbt"><a href="cppc.html" target="_blank"><span class="xwzxz">产品评测</span></a><span class="schqfl">|<a href="news/more/<mi:encoder value="整车评测" />.html">整车评测 </a>-<a href="news/more/<mi:encoder value="配件评测" />.html">配件评测</a></span><span class="gengd"><a href="cppc.html" target="_blank">更多&gt;&gt;</a></span></p>
     <ul class="schqlist">
      	<s:iterator value="%{map.news_2}" id="n">
     		<li><a href="news/more/<mi:encoder value="${n.newsCatName}" />.html" ><span class="xwzxlifl">[${n.newsCatName}]</span></a><span class="schqlistnr">
     			<a href="news/detail/${n.id }.html"  title="${n.firstTitle }">
     		<s:if test="%{#n.firstTitle.length()>17}"><s:property value="%{#n.firstTitle.substring(0, 17)}" />...</s:if>
     		<s:else>
     			<s:property value="%{#n.firstTitle}" />
     		</s:else></a>
     		</span><span class="xwzxlidate"><s:date name="#n.createtime"  format="yyyy-MM-dd" /></span></li>
     	</s:iterator>
     </ul>
   </div>
<div class="schq">
      <p class="schqbt"><a href="zpxy.html" target="_blank"><span class="xwzxz">重配学院</span></a><span class="fbxxan"><a href="/zpxy.html?tg=jsdy" target="_blank">技术答疑</a></span><span class="gengd"><a href="qpzx.html" target="_blank">更多&gt;&gt;</a></span></p>
     <ul class="schqlist">
     	<%-- <c:forEach items="${map.news_3 }" var="v">
	      	<li><span class="xwzxlifl">[${v.newsCatName}]</span>
	     		<span class="schqlistnr"><a href="news/detail/${v.id }.html"  title="${v.firstTitle }">${fn:substring(v.firstTitle,0, 17)}</a></span>
	     		<span class="xwzxlidate"><fmt:formatDate value="${v.createtime}" pattern="yyyy-MM-dd" /></span>
	     	</li> 
     	</c:forEach> --%>
     	
     	<c:forEach items="${zxxt }" var="v">
	      	<li><a href="school/online/<mi:encoder value="${v.newsCatName }" />"><span class="xwzxlifl">[${v.newsCatName}]</span></a>
	     		<span class="schqlistnr"><a href="school/xtview/${v.id }.html"  title="${v.firstTitle }">${fn:substring(v.firstTitle,0, 17)}</a></span>
	     		<span class="xwzxlidate"><fmt:formatDate value="${v.createtime}" pattern="yyyy-MM-dd" /></span>
	     	</li> 
     	</c:forEach>
     	
     </ul>
   </div>
</div>
</div>