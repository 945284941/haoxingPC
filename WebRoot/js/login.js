var LoginBuyUrl = '';
var subType = '0';
var LoginMsg='登录成功';
var load=false;

/**
 * 登录弹出窗口<br>
 * type表示登录成功跳转的方式<br>方式为：0-重定向URL，1-提交表单，2-ajax提交,3-刷新页面表头,局部刷新<br>
 * url表示登录成功后需要跳转的路径
 * successMsg 表示ajax提交成功后提示信息
 * Load 是否刷新本页面 true：刷新，默认false
 * @param divbg
 * @param divId
 * @param url
 * @param type
 */
function showLogin(divbg,divId,url,type,successMsg,Load){
    LoginBuyUrl =url;
    subType = type;
    LoginMsg = successMsg;
    load = Load;
    //mask=document.createElement("div");
    var mask = document.getElementById(divbg);
    var W=$(document).width();
    var H=$(document).height();
    var screenH = window.screen.height;
    //mask.id="mask";
    // mask.style.cssText="position:absolute;z-index:2000;width:"+W+"px;height:"+H+"px;background:#000;filter:alpha(opacity=30);opacity:0.3;top:0;left:0;";
    // //document.body.appendChild(mask);
    // mask.style.display="block";
    var o = $('#loginBox'),
        leftLength = (W-400)/2,
        topLength = (screenH-350)/2;
        o.css({'top':topLength+'px','left':leftLength+'px'});
        $('#'+divId).show();
}

/**
 * 登录验证
 * @returns {Boolean}
 */
function loginFromSub1() {
    var loginName = $('#loginName').val();
    var loginPwd = $('#loginPwd').val();
    if (loginName == '' || loginName == null) {
        alert('请输入登录名！');
        return false;
    }
    if (loginPwd == '' || loginPwd == null) {
        alert('请输入密码！');
        return false;
    }
    $.ajax( {
        url : 'login.html',
        type : 'POST',
        data : $('#loginFrom').serialize(),
        success : function(data) {
            var msg = $.parseJSON(data);
            if (msg == 'nameError') {
                $('#loginName').focus();
                alert('该用户名不存在,请重新输入！');
                return false;
            }else if (msg == 'pwdError') {
                $('#loginPwd').focus();
                alert('密码不正确，请重新输入！');
                return false;
            }else if (msg == 'success') {
                if ($("#remember").attr("checked") == "checked") {
                    var userName = $("#loginName").val();
                    var passWord = $("#loginPwd").val();
                    $.cookie("remember", "true", { expires: 7 });
                    $.cookie("userName", userName, { expires: 7 });
                    $.cookie("passWord", passWord, { expires: 7 });
                }else{
                    $.cookie("remember", "false", { expires: -1 });        // 删除 cookie
                    $.cookie("userName", '', { expires: -1 });
                    $.cookie("passWord", '', { expires: -1 });
                }
                if(subType == '0'){
                    window.location.href = LoginBuyUrl;
                }else if (subType == '1') {
                    document.getElementById(LoginBuyUrl).submit();
                    //$("#"+LoginBuyUrl).submit();
                }else if (subType == '2'){
                    $.ajax({ url: LoginBuyUrl, success: function(){
                        location.reload();
                    }});
                }else if (subType == '3'){
                    $("#admin_common_head_welcome").load("admin/common/headWelcome.jsp");
                }
                return true;
            }
        }
    });
}