maskMember = function(url,memberId) {
			if (memberId != null && memberId != '') {// 登录状态下执行
				 window.location.href = url;
			} else {// 未登录下
				showLogin('mask', 'pop_500', url, '0', '跳转成功');

			}
	};
