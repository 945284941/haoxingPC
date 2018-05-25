var arr = document.getElementsByClassName("tab_item");
var countryArr = document.getElementsByClassName("country_item");
var fenleiArr = document.getElementsByClassName("fenlei_item");
var t = $("#buyType").val();
$(function () {
    for(var i = 0; i < arr.length; i++) {
        if(i == parseInt(t)-1){
            arr[i].classList.add("on");
        }else{
            arr[i].classList.remove("on");
        }
    }
});
function changeFenlei(t,f,v) {
    if(v == '1'){
        for(var i = 0; i < fenleiArr.length; i++) {
            if(i == t){
                fenleiArr[i].classList.add("on");
                if(t != 0){
                    $("#catId").val(f);
                    subFo();
                }else{
                    $("#catId").val('');
                    subFo();
                }
            }else{
                fenleiArr[i].classList.remove("on");
            }
        }
    }else{
        for(var i = 0; i < countryArr.length; i++) {
            if(i == t){
                countryArr[i].classList.add("on");
                if(t != 0){
                    $("#toCountryId").val(f);
                    subFo();
                }else{
                    $("#toCountryId").val('');
                    subFo();
                }
            }else{
                countryArr[i].classList.remove("on");
            }
        }
    }

}
function changeBank(t) {
    for(var i = 0; i < arr.length; i++) {
        if(i == parseInt(t)-1){
            arr[i].classList.add("on");
            $("#buyType").val((i+1).toString());
            subFo();
        }else{
            arr[i].classList.remove("on");
        }
    }
}