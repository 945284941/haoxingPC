<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/27 0027
  Time: 上午 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>

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

    </script>
</head>

<body>
<!-- top -->
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toPersionLogo" executeResult="true" namespace="/"></s:action>
<!-- top结束 -->

<!-- heard -->

<!-- heard结束 -->

<div style="background: #f6f6f6;">
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
            <div class="w-buyers">
                <div class="l-fr">
                    <div class="w-title">
                        <h3>我的发布</h3>
                    </div>
                </div>
                <div class="l-fr1 tgar">
                    <div class="slideTxtBox">
                        <div class="hd">
                            <ul>
                                <li class="on">
                                    <a href="">求购</a>
                                </li>
                                <li>
                                    <a href="">二手商品</a>
                                </li>
                                <li>
                                    <a href="">拼箱</a>
                                </li>
                                <li>
                                    <a href="">生活圈</a>
                                </li>
                            </ul>
                        </div>
                        <div class="fabu">
                            <dl>
                                <c:forEach items="${wan}" var="wan">
                                    <dt><img src="${wan.picUrl}" width="115"></dt>
                                    <dd>
                                        <h3>${wan.title}</h3>
                                        <p>
                                            <span class="fl">${wan.mobile}</span>
                                            <span class="fr"> <fmt:formatDate value="${wan.createDate}" pattern="yyyy-MM-dd HH:mm" /></span>
                                        </p>
                                        <a class="r120" onclick="delAddr('${wan.id}')">删除</a>
                                        <a  href="<%=basePath%>toWantBuyView/${wan.id}/${wan.buyType}.html">查看</a>

                                    </dd>
                                </c:forEach>
                            </dl>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--我是买家-->

</div>
</div>
<!--footer开始-->
<div class="gzgz">
    <jsp:include page="/admin/common/footer.jsp" />
</div>
<!--footer结束-->
<script src="js/jquery1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
    $(function() {
        $(".acc_sure").on("click", function() {
            alerths("请等待审核！")
            return false;
        })
        $("#file0").change(function() {
            if(this.files && this.files[0]) {
                var objUrl = getObjectURL(this.files[0]);
                console.log("objUrl = " + objUrl);
                if(objUrl) {
                    $("#img0").attr("src", objUrl);
                    $("#file0").click(function(e) {
                        $("#img0").attr("src", objUrl);
                    });
                } else {
                    //IE下，使用滤镜
                    this.select();
                    var imgSrc = document.selection.createRange().text;
                    var localImagId = document.getElementById("sss");
                    //图片异常的捕捉，防止用户修改后缀来伪造图片
                    try {
                        preload.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = data;
                    } catch(e) {
                        this._error("filter error");
                        return;
                    }
                    this.img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src=\"" + data + "\")";
                }
            }
        });
        $("#file1").change(function() {
            if(this.files && this.files[0]) {
                var objUrl = getObjectURL(this.files[0]);
                console.log("objUrl = " + objUrl);
                if(objUrl) {
                    $("#img1").attr("src", objUrl);
                    $("#file1").click(function(e) {
                        $("#img0").attr("src", objUrl);
                    });
                } else {
                    //IE下，使用滤镜
                    this.select();
                    var imgSrc = document.selection.createRange().text;
                    var localImagId = document.getElementById("sss");
                    //图片异常的捕捉，防止用户修改后缀来伪造图片
                    try {
                        preload.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = data;
                    } catch(e) {
                        this._error("filter error");
                        return;
                    }
                    this.img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src=\"" + data + "\")";
                }
            }
        });
        //建立一個可存取到該file的url
        function getObjectURL(file) {
            var url = null;
            if(window.createObjectURL != undefined) { // basic
                url = window.createObjectURL(file);
            } else if(window.URL != undefined) { // mozilla(firefox)
                url = window.URL.createObjectURL(file);
            } else if(window.webkitURL != undefined) { // webkit or chrome
                url = window.webkitURL.createObjectURL(file);
            }
            return url;
        }
    })

    function chakan(){
        //      alert(1111111);
//        window.location.href="<%=basePath%>toWantBuyView/${w.id}/${w.buyType}.html";
//        $.ajax({id,buyType
//            url:'wantBuy!toWantBuyView.action',
//            type:'POST',
//            data:{
//                "wantBuy.id":id,
//                "wantBuy.buyType":buyType
//            },
//            dataType:'JSON',
//            success:function(){
//                //window.location.href="querywan.html";
//            }
//        })


    }

    function delAddr(id){

        if(confirm("确认要删除吗?")){
            $.ajax({
                url : "Release!DelectWant.action",
                type : "POST",
                data : "id="+id,
                dataType : "JSON",
                success : function(){
                    window.location.href="delectwan.html";
                }
            });
        }
    }

</script>
</body>

</html>
