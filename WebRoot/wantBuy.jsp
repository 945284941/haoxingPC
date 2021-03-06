<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta content="IE=11.0000" http-equiv="X-UA-Compatible">
    <title>颐佳超市</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="admin/common/keyWords.jsp" />
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<s:action name="catalogueAction!queryFullCategory" executeResult="true" namespace="/" >
    <s:param name="catType">qg</s:param>
</s:action>
<div id="pageReload">
</div>
<s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript">
    $(function () {
        subFo();
    });
    function subFo() {
        var url="indexFloor/indexFloorAction!showIndexWantBuyFloor.action";
        $.ajax({
            type:"POST",
            url:url,
            cache:true,
            async:true,
            data : $('#pagerForm').serialize(),
            success:function (html) {
                $("#pageReload").html(html);
            }
        });
    }
</script>
</body>
</html>