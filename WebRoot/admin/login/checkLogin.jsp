<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<script type="text/javascript" src="../../js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="../../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../../js/login.js"></script>
<script type="text/javascript">
    $(function() {
        if ($.cookie("remember") == "true") {
            $("#remember").attr("checked", true);
            $("#loginName").val($.cookie("userName"));
            $("#loginPwd").val($.cookie("passWord"));
        }
    });
</script>
<div class="xfdl">
    <div class="login_cont_ny_r">
        <div class="login_cont_ny_r_t">
            <div class="login_cont_ny_r_t_l">登录</div>
            <div class="login_cont_ny_r_t_r"><s:text name="index_0112"/>,
                <a href="toRegister.html"><span style="color:#ff5165;"><s:text name="index_0276"/></span></a>
            </div>
        </div>
        <form id="loginFrom" action="login.html" method="post">
        <div class="login_cont_ny_r_m">
            <input name="loginName" type="text" placeholder="<s:text name="index_0113"/>"  class="login_bk" id="loginName" />
            <input name="loginPwd" type="text" placeholder="<s:text name="index_0107"/>" class="login_bk2" id="loginPwd"/>
            <div class="login_cont_ny_r_wz">
                <div class="login_cont_ny_r_wz_input"><input name="remember" id="remember" type="checkbox"/>记住密码</div>
                <a href="toMemberCheckMsg.html" style="text-decoration: underline;">忘记密码？</a>
            </div>
        </div>
        <div class="login_cont_ny_r_b">
            <a href="javascript:void(0);" onclick="loginFromSub1();"><s:text name="index_0112"/></a>
        </div>
        </form>
    </div>
</div>
