$(function() {
	$('.top_mid_slide')
		.slide({
			mainCell: '.top_mid_slider_ul',
			titCell: '.banner_top li',
			titOnClassName: 'this',
			trigger: 'mouseover',
			autoPlay: true
		});
});
$(function() {
	$(".toph_bgsear li").mouseover(function() {
		$(".toph_bgsear>li").show();
	}).mouseleave(function() {
		$(".toph_bgsear>li").last().hide();
	}).click(function() {
		var index = $(this).index();
		if(index == 1) {
			var f_text = $(".toph_bgsear li").find("a").first().text();
			$(".toph_bgsear li").find("a").first().html($(this).find("a").text() + "<s></s>");
			$(".toph_bgsear li").find("a").last().text(f_text);
			$("#type").val($(this).attr("type"));
			$(".toph_bgsear>li").last().hide();
		}
	});

	$(".two_code_a").click(function() {
		$(this).parent().remove();
	});

});
function search_form() {
	alert("aaaaaaa");
	var keyword = arguments[0];
	var type = arguments[1];
	alert(keyword);
	alert(type);
	if(keyword != "" && keyword != undefined) {
		$("#keyword").val(keyword);
	}
	if(type != "" && type != undefined) {
		$("#type").val(type);
	}
	$("#searchForm").submit();
	$("#keyword").val("");
}

$(function() {
	$("#navul li").each(function() {
		var original_url = $(this).attr("original_url");
		if("/index.htm".indexOf(original_url) >= 0) {
			$(this).addClass("this");
		}
	});
	//
	$(".left_menu_dl").live("mouseover", function() {
		var sc_id = $(this).attr("id");
		var sc_color = $(this).attr("sc_color");
		var child_count = $(this).attr("child_count");
		var eq = $(this).index();

		if(child_count > 0) {
			$("#dts_" + sc_id).addClass("left_menu_this").removeClass("left_menu_dt");
			$("#child_" + sc_id).show();
		}
		$("#left_menu_con_" + sc_id).attr("style", "border:1px solid " + sc_color + "; border-left:1px solid " + sc_color + ";").find(".menu_con_right_top").css("background-color", sc_color);
		var z = -35;
		var x = eq * z;
		$("#left_menu_con_" + sc_id).css('margin-top', x + 'px');
		$(".left_menu_dd[id=child_" + sc_id + "]").show();

	}).live("mouseleave", function() {
		$("dt[id^=dts_]").removeAttr("style");
		$("div[id^=left_menu_con_]").removeAttr("style");
		var child_count = $(this).attr("child_count");
		$("dt[id^=dts_]").removeClass("left_menu_this").addClass("left_menu_dt");
		$(".left_menu_dd[id^=child_]").hide();
	});
	$(".nav_left").mouseover(function() {
		$("#other_menu").show();

	});
	$(".nav_left").mouseleave(function() {
		$("#other_menu").hide();
	});
	
	//
});

$(function() {
	$(":radio[id=transport_type]").click(function() {
		var val = $(this).val();
		if(val == 0) {
			$("#transport_template_select").show();
			$("#mail_trans_fee").attr("readonly", "readonly");
			$("#express_trans_fee").attr("readonly", "readonly");
			$("#ems_trans_fee").attr("readonly", "readonly");
		} else {
			$("#transport_template_select").hide();
			$("#mail_trans_fee").removeAttr("readonly");
			$("#express_trans_fee").removeAttr("readonly");
			$("#ems_trans_fee").removeAttr("readonly");
		}
	});
	$(":radio[id=transport_type][value='1']").attr("checked", "checked");
	$("#transport_template_select").hide();;
});;;