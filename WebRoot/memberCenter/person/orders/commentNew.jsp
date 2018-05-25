<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%--<html lang="en">--%>
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=7" />
    <jsp:include page="/admin/common/keyWords.jsp" />
    <title>颐佳商城</title>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta http-equiv="keywords" content="颐佳,商城" />
    <meta http-equiv="description" content="颐佳,商城" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- <link rel="stylesheet" href="web/bootstrap/bootstrap.min.css" type="text/css" /> -->
    <link rel="stylesheet" href="web/css/sghsc-main.css" type="text/css" />
    <link rel="stylesheet" href="web/css/sghsc-order.css" type="text/css" />
    <link rel="stylesheet" href="web/css/datePicker.css" />

    <link rel="stylesheet" href="css/common.css" type="text/css" />
    <link rel="stylesheet" href="css/hyzxgr.css" type="text/css" />
    <link rel="stylesheet" href="css/page.css" type="text/css" />

    <script type=text/javascript src="js/jquery-1.8.0.min.js"></script>
    <script type=text/javascript src="js/layer/layer.min.js"></script>
    <script type=text/javascript src="js/slides.jquery.js"></script>
    <script type=text/javascript src="js/tanchu.js"></script>
    <script type=text/javascript src="js/register.js"></script>
    <script type="text/javascript" src="js/layer/layer.js"></script>

    <!-- 日历控件 -->
    <script type="text/javascript" src="web/js/jquery.date_input.pack.js"></script>

    <script type="text/javascript">

//        $(function(){
//            var num = $("#sincerity").val();
//            var count = $("#id").val();
//            if(num==1){
//                $("#"+count+"1").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"2").attr("src","images/memberimg/star_no.png");
//                $("#"+count+"3").attr("src","images/memberimg/star_no.png");
//                $("#"+count+"4").attr("src","images/memberimg/star_no.png");
//                $("#"+count+"5").attr("src","images/memberimg/star_no.png");
//            }
//            if(num==2){
//                $("#"+count+"1").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"2").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"3").attr("src","images/memberimg/star_no.png");
//                $("#"+count+"4").attr("src","images/memberimg/star_no.png");
//                $("#"+count+"5").attr("src","images/memberimg/star_no.png");
//            }
//            if(num==3){
//                $("#"+count+"1").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"2").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"3").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"4").attr("src","images/memberimg/star_no.png");
//                $("#"+count+"5").attr("src","images/memberimg/star_no.png");
//            }
//            if(num==4){
//                $("#"+count+"1").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"2").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"3").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"4").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"5").attr("src","images/memberimg/star_no.png");
//            }
//            if(num==5){
//                $("#"+count+"1").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"2").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"3").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"4").attr("src","images/memberimg/star_yes.png");
//                $("#"+count+"5").attr("src","images/memberimg/star_yes.png");
//            }
//        });

        function memberEvaluate(count,num){
            $("#input").val(num);
            if(num==1){
                $("#"+count+"1").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"2").attr("src","images/memberimg/star_no.png");
                $("#"+count+"3").attr("src","images/memberimg/star_no.png");
                $("#"+count+"4").attr("src","images/memberimg/star_no.png");
                $("#"+count+"5").attr("src","images/memberimg/star_no.png");
            }
            if(num==2){
                $("#"+count+"1").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"2").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"3").attr("src","images/memberimg/star_no.png");
                $("#"+count+"4").attr("src","images/memberimg/star_no.png");
                $("#"+count+"5").attr("src","images/memberimg/star_no.png");
            }
            if(num==3){
                $("#"+count+"1").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"2").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"3").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"4").attr("src","images/memberimg/star_no.png");
                $("#"+count+"5").attr("src","images/memberimg/star_no.png");
            }
            if(num==4){
                $("#"+count+"1").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"2").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"3").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"4").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"5").attr("src","images/memberimg/star_no.png");
            }
            if(num==5){
                $("#"+count+"1").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"2").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"3").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"4").attr("src","images/memberimg/star_yes.png");
                $("#"+count+"5").attr("src","images/memberimg/star_yes.png");
            }
        }

        //提交评论
        function tijiao(id) {
            var num = $("#input").val();
            var content = $("#content").val();
            if(num == null || num == ''){
                alert('<s:text name="index_0330"/>！');
                return false;
            }
            if(content == null || content == ''){
                alert('<s:text name="index_0331"/>！');
                return false;
            }
            $.ajax({
                url : 'orderAction!changeAppraise.action',
                type : 'POST',
                data : {id:id,content:content,num:num},
                success : function(data) {
                    var r = $.parseJSON(data);
                    if (r == 'ok') {
                        window.location.href = "person/order/toComment/${order.id}.html";
                    } else {
                        alert('<s:text name="index_0316"/>！');
                        return false;
                    }
                }
            });
        }


    </script>
</head>
<body>
<div id="tanchu"></div>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toPersionLogo" executeResult="true" namespace="/"></s:action>

<div class="sghsc-order-main">
    <!-- 左侧功能菜单开始 -->
    <div class="main">
        <div class="h_content">
            <c:choose>
                <c:when test="${sessionInfo.userType=='company' }">
                    <jsp:include page="/memberCenter/common/leftNavigate.jsp" />
                </c:when>
                <c:otherwise>
                    <jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" />
                </c:otherwise>
            </c:choose>
            <!-- 左侧功能菜单结束 -->
            <!-- 右侧功能开始 -->
            <div class="w-buyers">
                <div class="l-fr">
                    <div class="w-title">
                        <h3><s:text name="index_0088"/></h3>
                    </div>
                    <div class="mt5">
                        <table class="table0902" width="100%" border="0" cellspacing="0" cellpadding="0">
                            <thead>
                            <tr>
                                <td><s:text name="index_0332"/></td>
                                <td><s:text name="index_0333"/></td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orderItems}" var="item" varStatus="s">
                            <c:if test="${item.appraise=='0'}">
                            <tr>
                                <td>
                                    <img class="fl" src="${item.defaultPicSrc}" width="135" height="83">
                                    <p class="fl ml10">
                                        <a class="color_blue" href="#">${item.goodsName}</a>
                                    </p>
                                </td>
                                <td width="230">
                                    <p class="t_l">
                                        <span><input type="hidden" id="input" name="appraise.serve"/></span>
                                        <span><a onclick="memberEvaluate('${s.count}','1');"><img id="${s.count}1" src="/images/memberimg/star_no.png" /></a></span>
                                        <span><a onclick="memberEvaluate('${s.count}','2');"><img id="${s.count}2" src="/images/memberimg/star_no.png" /></a></span>
                                        <span><a onclick="memberEvaluate('${s.count}','3');"><img id="${s.count}3" src="/images/memberimg/star_no.png" /></a></span>
                                        <span><a onclick="memberEvaluate('${s.count}','4');"><img id="${s.count}4" src="/images/memberimg/star_no.png" /></a></span>
                                        <span><a onclick="memberEvaluate('${s.count}','5');"><img id="${s.count}5" src="/images/memberimg/star_no.png" /></a></span>
                                    </p>
                                    <p class="t_l mt5"><textarea class="bd0902" name="content" id="content" cols="20" rows="2"></textarea></p>
                                    <p class="t_l"><button type="button" class="btn-tijiao" onclick="tijiao('${item.id}')"><s:text name="index_0334"/></button></p>
                                </td>
                            </tr>
                            </c:if>
                            <c:if test="${item.appraise=='1'}">
                            <tr>
                                <td>
                                    <img class="fl" src="${item.defaultPicSrc}" width="135" height="83">
                                    <p class="fl ml10">
                                        <a class="color_blue" href="#">${item.goodsName}</a>
                                    </p>
                                </td>
                                <td width="230">
                                    <c:if test="${item.appraiseSincerity==1}">
                                    <p class="t_l">
                                       <span>
                                           <!--<input type="hidden" id="sincerity" name="sincerity" value="${item.appraiseSincerity}"/>-->
                                           <!--<input type="hidden" id="id" name="id" value="${s.count}"/>-->
                                       </span>
                                        <span><a><img id="${s.count}1" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}2" src="/images/memberimg/star_no.png" /></a></span>
                                        <span><a><img id="${s.count}3" src="/images/memberimg/star_no.png" /></a></span>
                                        <span><a><img id="${s.count}4" src="/images/memberimg/star_no.png" /></a></span>
                                        <span><a><img id="${s.count}5" src="/images/memberimg/star_no.png" /></a></span>
                                    </p>
                                    </c:if>
                                    <c:if test="${item.appraiseSincerity==2}">
                                    <p class="t_l">
                                       <span>
                                           <!--<input type="hidden" id="sincerity" name="sincerity" value="${item.appraiseSincerity}"/>-->
                                           <!--<input type="hidden" id="id" name="id" value="${s.count}"/>-->
                                       </span>
                                        <span><a><img id="${s.count}1" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}2" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}3" src="/images/memberimg/star_no.png" /></a></span>
                                        <span><a><img id="${s.count}4" src="/images/memberimg/star_no.png" /></a></span>
                                        <span><a><img id="${s.count}5" src="/images/memberimg/star_no.png" /></a></span>
                                    </p>
                                    </c:if>
                                    <c:if test="${item.appraiseSincerity==3}">
                                    <p class="t_l">
                                       <span>
                                           <!--<input type="hidden" id="sincerity" name="sincerity" value="${item.appraiseSincerity}"/>-->
                                           <!--<input type="hidden" id="id" name="id" value="${s.count}"/>-->
                                       </span>
                                        <span><a><img id="${s.count}1" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}2" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}3" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}4" src="/images/memberimg/star_no.png" /></a></span>
                                        <span><a><img id="${s.count}5" src="/images/memberimg/star_no.png" /></a></span>
                                    </p>
                                    </c:if>
                                    <c:if test="${item.appraiseSincerity==4}">
                                    <p class="t_l">
                                       <span>
                                           <!--<input type="hidden" id="sincerity" name="sincerity" value="${item.appraiseSincerity}"/>-->
                                           <!--<input type="hidden" id="id" name="id" value="${s.count}"/>-->
                                       </span>
                                        <span><a><img id="${s.count}1" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}2" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}3" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}4" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}5" src="/images/memberimg/star_no.png" /></a></span>
                                    </p>
                                    </c:if>
                                    <c:if test="${item.appraiseSincerity==5}">
                                    <p class="t_l">
                                       <span>
                                           <!--<input type="hidden" id="sincerity" name="sincerity" value="${item.appraiseSincerity}"/>-->
                                           <!--<input type="hidden" id="id" name="id" value="${s.count}"/>-->
                                       </span>
                                        <span><a><img id="${s.count}1" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}2" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}3" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}4" src="/images/memberimg/star_yes.png" /></a></span>
                                        <span><a><img id="${s.count}5" src="/images/memberimg/star_yes.png" /></a></span>
                                    </p>
                                    </c:if>
                                    <p class="t_l mt5">${item.appraiseContent}</p>
                                </td>
                            </tr>
                            </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>