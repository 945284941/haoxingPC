<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25 0025
  Time: 上午 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script>

  function  baby(id) {
        var jm=$('#money').val();
        var hl;
        var symbol;
        if(jm<100){
           alert("大于100元才能提现");
           return;
        };
        if(jm>${me.advance}){
            alert("提现金额不足，请重新输入！");
            return;
        };
        $('input[name="marketable"]').each(function () {
            var  moneyType= $(this).attr("id");

            if($(this).is(':checked')) {
                if (moneyType == 'china') {
                    hl = 1;
                    symbol = "元";
                }
                if (moneyType == 'USD') {
                    hl = ${huilv.now_rate_doc};
                    symbol = "美元";
                }
                if (moneyType == 'AED') {
                    hl = ${huilv.now_rate_dlm};
                    symbol = "迪拉姆";
                }
            }
        });
        var barkCard=$('#bankCard').val();
        var tixian=(jm*hl).toFixed(2);
        var handMoney=jm*hl*${fee};
        tixian=tixian-handMoney;

        if(window.confirm('手续费为'+handMoney+symbol+'将要到账金额为'+tixian+symbol+'')){
                $.ajax({
                    url:'shenqing!insertSelective.action',
                    data:{
                        id:id,
                        amount:jm,
                        realAmount:tixian,
                        barndCard:barkCard,
                        liucunAmount:handMoney
                    },
                    method:'post',
                    dataType:'json',
                    success:function (data) {
                        var msg = $.parseJSON(data);
                        if(msg == 'success'){
                            alert("申请成功");
                            window.location.href="tixian.html";
                        }else{
                            alert("申请失败");
                        }
//                        if(_d.success){
//                            $.messager.show({
//                                title : '提示',
//                                msg : "申请成功"
//                            });
//                           /* $('#save_money_add')[0].reset();
//                            start()*/
//                           window.location.href="tixian.html";
//                        }else {
//
//                            $.messager.show({
//                                title : '提示',
//                                msg : "申请失败"
//                            });
//                        }
                    }
                });

        };
  }
</script>
<body>

<!-- 头部开始 -->
<!--======================top开始============================-->
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toPersionLogo" executeResult="true" namespace="/"></s:action>

<!--======================导航开始============================-->
<%--<jsp:include page="/admin/common/navigation.jsp" />--%>
<!-- 头部结束 -->
<%--<div class="breadThumb">首页 > 会员中心 > 电子商城 > 订单管理 > 我的订单</div>--%>

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
                <div class="l-fr" style="min-height: 800px;">
                    <div class="w-title">
                        <h3>申请提现</h3>
                    </div>
                    <div class="bd">
                        <ul>
                            <div class="h_revise h_revise_01" style="float: left;">
                                <dl >
                                    <dt><strong>可提现金额:</strong></dt>
                                    <dd style=" color: #000; font-size: 18px;">

                                        <strong>￥${me.advance}</strong>

                                    <strong>$<fmt:formatNumber type="number" value="${huilv.now_rate_doc * me.advance}" pattern="0.00" maxFractionDigits="2"/></strong>

                                        <strong>AED<fmt:formatNumber type="number" value="${huilv.now_rate_dlm * me.advance}" pattern="0.00" maxFractionDigits="2"/></strong>
                                    </dd>
                                </dl>
                                <dl>

                                    <dt>提现银行:</dt>
                                    <dd>
                                        <select name="ban" id="bankCard"  class="h_revise_select h_revise_select01">
                                            <c:forEach items="${ban}" var="b">
                                            <option value="${b.id}">${b.bank}</option>
                                            </c:forEach>
                                        </select>
                                    <button type="button" class="btn-danger03"><a href="showBankcard.html">添加银行卡</a></button>
                                    </dd>
                                </dl>
                                <dl>
                                    <dt>提现金额:</dt>
                                    <dd><input type="text" name="bn" id="money" class="h_datum_input1 h_datum_input2" /></dd>
                                </dl>
                                <dl>
                                    <dt>选择币总:</dt>
                                    <dd>
									<span>
									   <label><input type="radio" name="marketable" value="true" id="china" checked="checked">人民币（CNY）</label>
									</span>
                                        <span>
									   <label><input type="radio" name="marketable" id="USD">美元（USD）</label>
									</span>
                                        <span>
									   <label><input type="radio" name="marketable"  id="AED">迪拉姆（AED）</label>
									</span>
                                    </dd>
                                </dl>
                                <dl style="margin-bottom: 0;">
                                    <dt></dt>
                                    <dd style="color: #999;">每次提现最低金额￥100.00，每日最高提现金额￥50000.00</dd>
                                </dl>
                                <dl>
                                    <dt></dt>
                                    <dd>
                                        <button   id="submission"  onclick="baby('${me.id}')">提交申请</button>
                                    </dd>
                                </dl>
                            </div>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--我是买家-->


<!-- 页脚结束  -->
<!-- footer begin -->
<jsp:include page="/admin/common/indexFooter.jsp" />
<!-- footer end -->
<script type="text/javascript">
    function selectban(){
        alert(21222)
        $.ajax({
            type:'post',
            url:'shenqing!selectban.action',
            dataType:'json',
            success:function(msg){
                alert(55555)
                for(var i =0;i<msg.length;i++){
                    $opt = $("<option value="+msg[i].id+">"+msg[i].bank+"</option>");
                    $("select[name=ban]").append($opt);
                }
            }


        })
    }






</script>

</body>

</html>