function changeNum(goodsId,itemId, type, idx) {
    var num = $("#" + itemId).val();
    if ($("#check_" + idx).attr("checked") != "checked") {
        $("#check_" + idx).attr("checked", true);
    }
    if (type == 'add') {
        if (num <= 999) {
            updateCarNum(goodsId,itemId, parseInt(num) + 1);
            $("#" + itemId).attr("value", parseInt(num) + 1);
            $("#cartSum_"+idx).text(parseFloat(
                parseFloat($("#cartItemPrice_" + idx).text())
                * parseFloat($("#" + itemId).val())).toFixed(2));
            settotal();
        } else {
            updateCarNum(goodsId,itemId, "1000");
            $("#" + itemId).attr("value", "1000");
            alert('最大数量为1000');
            return;
        }
    } else if (type == 'del') {
        if (num > 1) {
            updateCarNum(goodsId,itemId, parseInt(num) - 1);
            $("#" + itemId).attr("value", num - 1);
            $("#cartSum_" + idx).html(parseFloat(
                parseFloat($("#cartItemPrice_" + idx).text())
                * parseFloat($("#" + itemId).val())).toFixed(2));
            settotal();
        } else {
            /* 	if (confirm("你要删除该商品吗?")) {
             //调用删除的方法
             } */
            alert("购买数量至少为1！");
        }
    } else if (type == 'inputByme') {
        var reg = /^[1-9]\d*$/;
        if (!reg.test(num)) {
            alert("请输入大于0的正整数！");
            updateCarNum(goodsId,itemId, "1");
            $("#" + goodsId).val(1);
        } else {
            if (num >= 1 && num <= 1000) {
                updateCarNum(goodsId,itemId, num);
            } else {
                alert("每件物品购买最大数量为1000！");
                updateCarNum(goodsId,itemId, "1000");
                $("#" + itemId).val(1000);
            }
        }

        $("#cartSum_" + idx).html(parseFloat(
            parseFloat($("#cartItemPrice_" + idx).text())
            * parseFloat($("#" + itemId).val())).toFixed(2));
        settotal();
    }
    var arrayClass = $(".mui-input-numbox");
    var totalNum = 0;
    for(var c=0;c<arrayClass.length;c++){
        totalNum = parseInt(totalNum) + parseInt(arrayClass[c].value);
    }
    $("#admin_common_head_cartTotal").text(totalNum);
}

//改变购物车数量
function updateCarNum(goodsId,itemId, num) {
    $.ajax({
        type : "POST",
        url : "call/updateCartNum.html",
        data : "goodsId=" + goodsId + "&itemId="+itemId+"&num=" + num,
        success : function(d) {
            var json = $.parseJSON(d);
            if (!json.success) {
                alert(json.Msg);
            }
        }
    });
}

// 提交表单
function cartSubmit(memberId) {
    if(memberId != null && memberId != ''){
        var bo = 0;
        var bc;
        var d=[];
        if($('#admin_cart_goodsAll')[0].children.length == 0) {
            return false;
        }
        $("input[name='goodsIds']:checkbox").each(function(i, dom){
            if ("checked" == $(this).attr("checked")) {
                var a = $("input[name='goodstype']:eq("+i+")").val();
                d.push(a);
            }
        });
        if(d!=null&&d!=""){
            if(d.length==1){
                $("#admin_carts_cartFrom").submit();
            }else{
                for(var j=0;j<d.length;j++){
                    var z= j+1;
                    if(d[j]!=d[z]){
                        bo=1;
                        break;
                    }
                    if(j+1+1==d.length){
                        break;
                    }
                }
                if(bo==0){
                    $("#admin_carts_cartFrom").submit();
                }else{
                    alert("商品不属于一个分区，请选择同一分区产品提交订单");
                }
            }
        }else{
            alert("请选择商品!");
        }
    }else {
        showLogin('mask','pop_500',"admin_carts_cartFrom",'1','');
    }

}
//全选
function checkedAll(itemName, checkbox) {
    var checkArray = document.getElementsByName(itemName);
    var flag = checkbox.checked;
    for ( var i = 0; i < checkArray.length; i++) {
        if (checkArray[i].checked != flag) {
            checkArray[i].checked = flag;
        }
    }
    var checkCom = document.getElementsByName("admin_carts_cartCheckbox_com");
    for(var i = 0; i < checkCom.length; i++){
        if (checkCom[i].checked != flag) {
            checkCom[i].checked = flag;
        }
    }
    if ($("#admin_carts_cartCheckbox").attr("checked") != "checked") {
        $("#total").html("0");
        $("#docTotal").html("0");
        $("#dlmTotal").html("0");
    } else {
        settotal();
    }
}
//这个商家下的规格选中或取消
function checkedAllCompany(itemName,itemIndex, checkbox) {
    var checkArray = document.getElementsByName(itemName);
    var flag = checkbox.checked;
    for ( var zc = 0; zc < checkArray.length; zc++) {
        if(flag){
            if($("#"+checkArray[zc].id).attr("cname") == itemIndex){
                $("#"+checkArray[zc].id).attr("checked",true);
            }
        }else{
            if($("#"+checkArray[zc].id).attr("cname") == itemIndex){
                $("#"+checkArray[zc].id).attr("checked",false);
            }
        }
    }
    settotal();
}

function settotal() {
    var checkGoodsIds = [];
    var total = 0;
    var checkArray = document.getElementsByName("goodsIds");
    for ( var zc = 0; zc < checkArray.length; zc++) {
        if($("#"+checkArray[zc].id).attr("checked") == "checked"){
            checkGoodsIds.push($("#"+checkArray[zc].id).val());
            var tzc = parseFloat($("#"+($("#"+checkArray[zc].id).attr("checksumid"))).text());
            total = accAdd(total, tzc);
        }
    }
    $("#total").html(parseFloat(total).toFixed(2));
    $("#dlmTotal").html(parseFloat(parseFloat(total).toFixed(2)* $("#dlmHv").val()).toFixed(2));
    $("#docTotal").html(parseFloat(parseFloat(total).toFixed(2)* $("#docHv").val()).toFixed(2));
    $("#delGoodsIds").val(checkGoodsIds);
}

function accAdd(arg1,arg2){
    var r1,r2,m;
    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
    m=Math.pow(10,Math.max(r1,r2))
    return (arg1*m+arg2*m)/m;
}

function checkBoxUpPr(numId) {
    if ($("#check_" + numId).attr("checked") != "checked") {
        $("#admin_carts_cartCheckbox").attr("checked",false);
    } else {
        $("#check_" + numId).attr("checked",true);
    }
    settotal();
}

/**
 *删除购物车商品
 */
function delCartGoods(itemId){
    $.ajax({
        url : "call/delCartGoods.html",
        data:{itemId:itemId},
        success : function() {
            $('#cart_'+itemId).remove();
            selectHeadCartNum();// 执行购物车查询
            settotal();
        }
    });
}
function delCheckGoods() {
    var itemId = $("#delGoodsIds").val();
    $.ajax({
        url : "call/delCartGoods.html",
        data:{itemId:itemId},
        success : function() {
            var goodsCartIds = itemId.split(",");
            for(var i=0;i<goodsCartIds.length;i++){
                $('#cart_'+goodsCartIds[i]).remove();
            }
            settotal();
        }
    });
}
/**
 *清空购物车
 */
function delCartGoodsAll(){
    $.ajax({
        url : "call/clearCartGoods.html",
        data:'',
        success : function() {
            $('#admin_cart_goodsAll').empty();
        }
    });
    $('#total').text('0');
}
function delCartGoodsAll1(){
    var temp=document.getElementsByName('goodsIds');
    var goodsIds="";
    for(var i=0;i<temp.length;i++){
        var e=temp[i];
        if(i==0){
            goodsIds=e.value;
        }else{
            goodsIds = goodsIds+","+e.value;
        }
    }
    $.ajax({
        url : "call/delCartGoods.html",
        data:{goodsId:goodsIds},
        success : function() {
            $('#admin_cart_goodsAll').empty();
        }
    });
    $('#total').text('0');
}
//收藏本站
function AddFavorite(url,title) {
    try {
        window.external.addFavorite(url,title);
    }
    catch (e) {
        try {
            window.sidebar.addPanel(title, url,"");
        }
        catch (e) {
            alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请进入新网站后使用Ctrl+D进行添加");
        }
    }
}
Array.prototype.indexOf = function(val) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == val) return i;
    }
    return -1;
};
Array.prototype.removeArray = function(val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};
