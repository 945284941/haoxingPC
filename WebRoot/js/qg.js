/***
 * 发布求购
 * @returns {boolean}
 */
function subQg() {
    var title = $('#title').val();
    var mobile = $('#mobile').val();
    if (title == '' || title == null) {
        alert('请输入求购标题！');
        return false;
    }
    if (mobile == '' || mobile == null) {
        alert('请输入联系电话！');
        return false;
    }
    $.ajax( {
        url : 'addWantBuy.html',
        type : 'POST',
        data : $('#addForm').serialize(),
        success : function(data) {
            var msg = $.parseJSON(data);
            if (msg == 'success') {
                window.location.href="toWantBuy.html";
                return true;
            }else{
                alert("添加失败");
                return false;
            }
        }
    });
}