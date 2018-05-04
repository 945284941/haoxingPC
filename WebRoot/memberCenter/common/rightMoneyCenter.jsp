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
	      url:'moneyManage!statisticsMoney.action',
	      dataType:'json', 
	     success:function(fundStatisticsInfo){
	    	 $("#addAll").empty();
	    	 $("#addAll").append(fundStatisticsInfo.depositTotal);
	    	 $("#zhifuAll").empty();
	    	 $("#zhifuAll").append(fundStatisticsInfo.expendTotal);
	    	 $("#tixianAll").empty();
	    	 $("#tixianAll").append(fundStatisticsInfo.withdrawTotal);
	    	 $("#balanceRight").empty();
	    	 $("#balanceRight").append(fundStatisticsInfo.moneyBalance);
	    	 
	     }})
	    ;


});
</script>
<div id="rightjxw">
           <p class="hyd0">预存款充值总额<span id="addAll"></span></p>
           <p class="hyd0">预存款支付总额<span id="zhifuAll"></span></p>
           <p class="hyd0">预存款兑米总额<span id="tixianAll"></span></p>
           <p class="hyd0">预存款金额<span id="balanceRight"></span></p>
 </div>