
function key() {
	// if(event.shiftKey){
	// window.close();}
	// 禁止shift
	if (event.ctrlKey && window.event.keyCode==67){ 
		alert('禁止CTRL-C复制本贴内容');
		return false; 
	} 
	// 禁止ctrl
	return false;
}
document.onkeydown = key;
if (window.Event)
	document.captureEvents(Event.MOUSEUP);
// swordmaple javascript article.
// from www.jx165.com
// function nocontextmenu(){
// event.cancelBubble = true
// event.returnValue = false;
// return false;}
function norightclick(e) {
	if (window.Event) {
		if (e.which == 2 || e.which == 3)
			return false;
	} else if (event.button == 2 || event.button == 3) {
		event.cancelBubble = true
		event.returnValue = false;
		return false;
	}
}

