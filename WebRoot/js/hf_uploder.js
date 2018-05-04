/**
 * 创建上传窗口 公共方法
 * @param chunk 是否分割大文件
 * @param callBack 上传成功之后的回调
 */
function Uploader(chunk, callBack) {
	var editWin = $('<div style="overflow: hidden;"/>');
	var upladoer = $('<iframe/>');
	upladoer.attr({
		'src' : '/uploader.jsp?chunk=' + chunk,
		width : '100%',
		height : '100%',
		frameborder : '0',
		scrolling : 'no'
	});
	editWin.window({
		title : "上传文件",
		height : 350,
		width : 550,
		minimizable : false,
		modal : true,
		collapsible : false,
		maximizable : false,
		resizable : false,
		content : upladoer,
		onClose : function() {
			var fw = GetFrameWindow(upladoer[0]);
			var files = fw.files;
			//var paths=fw.paths;
			var thumbPaths = fw.thumbPaths;
			//var standardPaths=fw.standardPaths;
			$(this).window('destroy');
			//callBack.call(this,files,paths,thumbPaths,standardPaths);
			callBack.call(this, files, thumbPaths);
		},
		onOpen : function() {
			var target = $(this);
			setTimeout(function() {
				var fw = GetFrameWindow(upladoer[0]);
				fw.target = target;
			}, 100);
		}
	});
}

/**
 * 根据iframe对象获取iframe的window对象
 * @param frame
 * @returns {Boolean}
 */
function GetFrameWindow(frame) {
	return frame && typeof (frame) == 'object' && frame.tagName == 'IFRAME'
			&& frame.contentWindow;
}

function makerUpload(chunk) {
	//Uploader(chunk,function(files,paths,thumbPaths,standardPaths){
	Uploader(chunk, function(files, thumbPaths) {
		if (files && files.length > 0) {
			var path =document.getElementById('uploader_img');
			var thumb = thumbPaths.join(",").split(",");
			for ( var i = 0; i < thumb.length; i++) {
				var img=document.createElement("img");  
				img.setAttribute("id",ext_UUID());
				img.setAttribute('src',thumb[i]);
				img.style.height='41px';
				img.style.width='55px';
				img.style.marginRight='10px';
				img.style.display="inline";
				img.ondblclick= function(){
					goods_add_dropDom(this);
				};
				path.appendChild(img);
			} ;
		};
	});
}
function goods_add_dropDom(obj){
		if(window.confirm("确定要删除该上传的图片?")){
			$("#"+obj.id).remove();
		}
}