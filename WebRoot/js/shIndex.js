

	function ff(f) {
		var pid = "#" + f;
		yScroll = this.pageYOffset;
		var mask = document.getElementById("tanchu");
		var W = $(document).width();
		var H = $(document).height();
		mask.style.cssText = "position:absolute;z-index:1001;width:"
				+ W
				+ "px;height:"
				+ H
				+ "px;background:#000;_background:#dedede;filter:alpha(opacity=30);opacity:0.3;top:0;left:0; ";
		mask.style.visibility = "visible";
		document.getElementById("test").innerHTML = "";
		//alert($(f).html());
		var imgs = document.getElementById(f).getElementsByTagName("img");
		var d = pid + " img";
		var w = $(d).attr("width");
		if (w > 0) {
			$("#test").width(w);
		} else {
			$("#test").width(1000);
		}
		if (!$(pid).has("img").length) {
			document.getElementById("test").innerHTML = " <a class='modalCloseImg simplemodal-close' title='Close' alt='关闭'></a>暂无图片";
		} else {
			document.getElementById("test").innerHTML = $(pid).html();
		}
		$("#test").show();
		$(".modalCloseImg").click(function() {
			$("#test").hide();
			$("#tanchu").hide();
		});
	}