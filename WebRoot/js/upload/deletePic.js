/**
 * Created by Administrator on 2017/8/23.
 */


function showDeleteDiv(resourceCode){
    $("#"+resourceCode).show();
}

function hideDeleteDiv(resourceCode){
        $("#"+resourceCode).hide();
}
function deleteImg(id,codeId) {
    var r=window.confirm("确定删除图片");
    console.log(codeId);
    // var imgStatus = $("#imgStatus").val();
    if (r) {
        $("#"+codeId).remove();
        //直接删除ajax
        $.ajax({
            type: 'POST',
            url: deleteImgForm,
            data: {
                "id" : id
            },
            dataType: 'json',
            error: function() {
                alert("操作失败");
            },
            success: function(data) {
                if("1" == data){
                    alertx("删除成功");
                }else{
                    alertx("删除失败");
                }
            }

        });
    }
}

function removeFromCommaJoinedText(value, container) {
    if (value.length == 0)
        return '';
    value = value.replace(/^,/, '').replace(/,$/, '');
    container = container.replace(/^,/, '').replace(/,$/, '');
    if (container == value) {
        return '';
    }
    var sArray = container.split('!!');
    var sArrayNew = [];
    for (var i = sArray.length - 1; i >= 0; --i) {
        if (sArray[i] != value){
            sArrayNew.push(sArray[i]);
        }
    }
    var result = sArrayNew.join('!!');
    result = result.replace(/,,/,',');
    result = result.replace(/^,/, '').replace(/,$/, '');
    return result;
}
