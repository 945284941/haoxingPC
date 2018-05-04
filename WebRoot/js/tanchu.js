/*  
	*@Description: ������
	*@Author:yhl 
	*@Update:2013-06-28
*/
 function showsplbtitle(tanchu,shxx) {
	yScroll = this.pageYOffset; 
	var mask = document.getElementById(tanchu);
	var W = $(document).width();
	var H = $(document).height();	
	mask.style.cssText = "position:absolute;z-index:1001;width:"
			+ W
			+ "px;height:"
			+ H
			+ "px;background:#000;_background:#dedede;filter:alpha(opacity=30);opacity:0.3;top:0;left:0; ";
	mask.style.visibility = "visible";
	var o = document.getElementById(shxx);
	o.style.visibility = "visible";
}
 function showsplbtitleBill(tanchu,shxx) {
	 	var billType = $("#bill_type").text();
		var billHead = $("#bill_head").text();
		var billContent = $("#bill_content").text(); 
		if(billType == "普通发票"){
			$("#ptfp").attr("checked","checked");
		}else if(billType == "普通增值税发票"){
			$("#ptzfp").attr("checked","checked");
		}else{
			$("#zyfp").attr("checked","checked");
		}
		if(billHead == "个人"){
			$("#gerenBill").attr("checked","checked");
			document.getElementById("bill_head_input").style.display="none";
		}else{
			$("#danweiBill").attr("checked","checked");
			document.getElementById("bill_head_input").style.display="inline-block";
			
		}
		$("#bill_head_input").attr("value",billHead);
		$("#bill_content_input").attr("value",billContent);
	 yScroll = this.pageYOffset; 
	 var mask = document.getElementById(tanchu);
	 var W = $(document).width();
	 var H = $(document).height();	
	 mask.style.cssText = "position:absolute;z-index:1001;width:"
		 + W
		 + "px;height:"
		 + H
		 + "px;background:#000;_background:#dedede;filter:alpha(opacity=30);opacity:0.3;top:0;left:0; ";
	 mask.style.visibility = "visible";
	 var o = document.getElementById(shxx);
	 o.style.visibility = "visible";
	 
 }
function stopsplbtitle(tanchu,shxx) {
	var o = document.getElementById(shxx);
	o.style.visibility = "hidden";
	var maskdiv = document.getElementById(tanchu);
	maskdiv.style.visibility = "hidden";
}