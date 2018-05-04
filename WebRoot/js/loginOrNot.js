	var random4 = function() {
		return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
		};
	var UUID = function() {
			return (random4() + random4() + "-" + random4() + "-" + random4() + "-" + random4() + "-" + random4() + random4() + random4());
		};
	function loginOrNot(url) {
		var form = document.createElement("form");
		form.setAttribute('action', 'mallLogin.html');
		form.setAttribute('method', 'post');
		var formId =UUID();
		form.setAttribute('id', formId);
		form.setAttribute('target', "_self");
		document.body.appendChild(form);
		var hide = document.createElement("input");
		hide.setAttribute('type', 'hidden');
		hide.setAttribute('name', 'vs_url');
		var inputId =UUID();
		hide.setAttribute('id', inputId);
		form.appendChild(hide);
		$.ajax({
			url : 'memberCenter/goods!checkSession.action',
			type : 'POST',
			dataType : 'JSON',
			success : function(json) {
				if (!json) {
					/*$('#' + inputId).val(url);
					$('#' + formId).submit();*/
					
					showLogin('mask','pop_500', '','0','',true);
				} else {
					window.location.href = url;
				}
			}
		});
	}
	
	function AddFavorite() {
		var title='古粮今典-爱多一点';
		url = 'http://www.sanguhuivip.com/';
		  try {
		      window.external.addFavorite(url, title);
		  }
		catch (e) {
	     try {
	       window.sidebar.addPanel(title, url, "");
	    }
	     catch (e) {
	         alert("抱歉，您所使用的浏览器无法完成此操作。将颐佳平台加入收藏失败，请使用Ctrl+D进行添加");
	     }
		}
	}