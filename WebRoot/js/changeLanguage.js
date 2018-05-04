/**
 * Created by Administrator on 2018/2/28.
 */
function changeJustLanguage(request_locale){
    $.ajax({
        url: 'login!doNotNeedSession_login.action',
        type: 'POST',
        data:'request_locale='+request_locale,
        success: function (data) {
            window.location.reload();
        }
    });
}