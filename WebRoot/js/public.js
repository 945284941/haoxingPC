/**
 * 公共方法-设置复选框全选/反选 wangmei
 */
function CheckAll_(obj) {
	var checkbox_ = document.getElementsByName('_checkbox');
	if (obj.checked) {
		for ( var i = 0; i < checkbox_.length; i++) {
			if (checkbox_[i].checked == false) {
				checkbox_[i].checked = true;
			}
		}
	} else {
		for ( var i = 0; i < checkbox_.length; i++) {
			if (checkbox_[i].checked == true) {
				checkbox_[i].checked = false;
			}
		}
	}
}

/**
 * 删除(单条或批量)
 */
function delAll(id, delUrl, listUrl) {
	var ids = [];
	if (id != '') {// 单条删除
		ids.push(id);
		if (confirm("您确定删除吗？")) {
			$.ajax({
				url : delUrl,
				data : {
					ids : ids.join()
				},
				dataType : 'json',
				success : function(result) {
					if (result.success) {
						alert(result.msg);
						window.location.href = listUrl;
					} else {
						alert(result.msg);
					}
				}
			});
		}
	} else {// 批量删除
		var checkbox_ = document.getElementsByName('_checkbox');
		var flag = 0;
		for ( var i = 0; i < checkbox_.length; i++) {
			if (checkbox_[i].checked) {
				ids.push(checkbox_[i].value);
				flag++;
			}
		}
		if (flag == 0) {
			alert("您未选择任何项进行批量删除！");
			return false;
		}
		if (confirm("您确定删除这些数据吗？")) {
			$.ajax({
				url : delUrl,
				data : {
					ids : ids.join(',')
				},
				dataType : 'json',
				success : function(result) {
					if (result.success) {
						alert(result.msg);
						window.location.href = listUrl;
					} else {
						alert(result.msg);
					}
				}
			});
		}
		;
	}
}
