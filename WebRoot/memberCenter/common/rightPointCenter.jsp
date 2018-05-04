<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script  type="text/JavaScript">
$(function(){  
	 $.ajax({  
	     type:'post',  
	      url:'pointDetail!statisticsPoint.action',
	      dataType:'json', 
	     success:function(pointStatisticsInfo){
	    	 $("#jifen").empty();
	    	 $("#jifen").append(pointStatisticsInfo.pointAddUp);
	    	 $("#xiaofei").empty();
	    	 $("#xiaofei").append(pointStatisticsInfo.pointExpend);
	    	 $("#balance").empty();
	    	 $("#balance").append(pointStatisticsInfo.pointBalance);
	    	 
	     }})
	    ;


});
</script>
   <div id="rightjxw">
           <p class="hyd0">经验值累计<span id="jifen"></span></p>
         <p class="hyd0">经验值消费<span id="xiaofei"></span></p>
           <p class="hyd0">经验值余额<span id="balance"></span></p>
       </div>