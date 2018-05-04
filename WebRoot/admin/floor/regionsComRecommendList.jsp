<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
 <p class="schqbt shj"><span class="xwzxz">相关商家推荐</span></p>
 <div class="sjtj">
   <ul>
     <s:if test="%{rcrlist.size()>0}">
	     <s:iterator value="rcrlist" var="li" status="st">
	     	<s:if test="#st.index<5">
		         <li>
		           <p><a href="/Shop/index_<s:property value='#li.companyId'/>.html" target="_blank"><img src="/images/vip/jnbeiben.jpg" width="192" height="120"/></a></p>
		           <p class="tjsjmc"><a class="red" href="/Shop/index_<s:property value='#li.companyId'/>.html" title="<s:property value='#li.cname'/>"  target="_blank">
		           <s:if test="null!=#li.cname&&#li.cname.length()>16">
		                <s:property value="#li.cname.substring(0, 16)" />......
		           </s:if>
		           <s:else>
		           		<s:property value="#li.cname" />
		           </s:else>		           
		           </a></p>
		           <p title="<s:property value='#li.carBrandStr' />">
		           <s:if test="null!=#li.carBrandStr&&#li.carBrandStr.length()>16">
		                <s:property value="#li.carBrandStr.substring(0, 16)" />
		           </s:if>
		           <s:else>
		           		<s:property value="#li.carBrandStr" />
		           </s:else>		           
		           </p>
		         </li>     	
	     	</s:if>
	     </s:iterator>     
     </s:if>
     <s:else>
     	<span style="color:red;">暂时没有符合条件的数据！</span>
     </s:else>
   </ul>
 </div>
