/*  
	*@Description: 弹出层
	*@Author:yhl 
	*@Update:2013-06-28
*/
 function showMember(divbg, divId) {
//mask=document.createElement("div");
	yScroll = this.pageYOffset; 
	var mask = document.getElementById(divbg);
	var W = $(document).width();
	var H = $(document).height();	
	//mask.id="mask";
	mask.style.cssText = "position:absolute;z-index:5;width:"
			+ W
			+ "px;height:"
			+ H
			+ "px;background:#000;filter:alpha(opacity=30);opacity:0.3;top:0;left:0;";
	//document.body.appendChild(mask);
	mask.style.display = "block";
	var o = document.getElementById(divId);
	o.style.display = "block";
	//o.style.position = "fixed";
	o.style.top = (H/2  - 100)+"px";
	o.style.left = (W/2 - 200)+"px";
		
}
 function showMemberJsLogin(divbg, divId) {
//mask=document.createElement("div");
	yScroll = this.pageYOffset; 
	var mask = document.getElementById(divbg);
	var W = $(document).width();
	var H = $(document).height();	
	//mask.id="mask";
	mask.style.cssText = "position:absolute;z-index:5;width:"
			+ W
			+ "px;height:"
			+ H
			+ "px;background:#000;filter:alpha(opacity=30);opacity:0.3;top:0;left:0;";
	//document.body.appendChild(mask);
	mask.style.display = "block";
	var o = document.getElementById(divId);
	o.style.display = "block";
	o.style.top = (H/2  - 700)+"px";
	o.style.left = (W/2 - 200)+"px";
	//o.style.position = "fixed";
		
}
function hiddenMember(divbg, divId) {
	var o = document.getElementById(divId);
	o.style.display = "none";
	o.style.top = "253px";
	o.style.left = "400px";
	var maskdiv = document.getElementById(divbg);
	maskdiv.style.display = "none";
}
function jdsjCheckLogin(){
	$.ajax( {
		url : 'jdsjCheckByMemberId.html',
		type : 'POST',
		data : '',
		success : function(data) {
			var msg = $.parseJSON(data);
			if(msg == 'oldsession'){
				alert('很抱歉，您没登录或页面已过期，请重新登录！');
			window.location.href = "/activeIndex.jsp";
			}else{
				if (msg == 'success') {
				
				//跳转到校对页面
			window.location.href = "/collect/checkList/all.html";
			}else{
				$('#memberScSj').text(msg);
				showMemberJsLogin('maskmemberjdsj','pop_memberjdsj');
			}
			}
			

}
	});
}
function jdsjCheck(){
	$.ajax( {
		url : 'jdsjCheckByMemberId.html',
		type : 'POST',
		data : '',
		success : function(data) {
			var msg = $.parseJSON(data);
			
			if(msg == 'oldsession'){
				alert('很抱歉，您没登录或页面已过期，请重新登录！');
			window.location.href = "/activeIndex.jsp";
			}else{
				if (msg == 'success') {
				//跳转到校对页面
					window.location.href = "/collect/checkList/all.html";
				}else{
					$('#memberScSj').text(msg);
					showMember('maskmemberjdsj','pop_memberjdsj');
				}
		}
	}
	});
}