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


        function changeStatus(orderId,status,disabled) {
            $.ajax({
                url : 'orderAction!changeOrderStatus.action',
                type : 'POST',
                data : {orderId:orderId,status:status,disabled:disabled},
                success : function(data) {
                    var r = $.parseJSON(data);
                    if (r == 'ok') {
                        window.location.href = "person/order/myOrders.html";
                    } else {
                        alert('操作失败！');
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
                    <div class="kuang0902">
                        <div class="title0902">
                            <span>订单号：${order.orderNum}</span>
                            <span class="ml16">状态：<font class="color_green">
                                <!--支付状态：0 未付款，1 已付款， 2待退款， 3 已退款,4 卖家拒绝退款 5退款中
                                    发货状态：0 未发货，1 已发货， 2 已收货，3 待退货，4 已退货, 5 卖家拒绝退货 -->
                            <c:if test="${order.payStatus=='0'}"><s:text name="index_0357"/></c:if>
                            <c:if test="${order.payStatus=='1'}"><s:text name="index_0358"/></c:if>
                            <c:if test="${order.payStatus=='2'}"><s:text name="index_0359"/></c:if>
                            <c:if test="${order.payStatus=='3'}"><s:text name="index_0360"/></c:if>
                            <c:if test="${order.payStatus=='4'}"><s:text name="index_0361"/></c:if>
                            <c:if test="${order.payStatus=='5'}"><s:text name="index_0362"/></c:if>
                            ，
                            <c:if test="${order.shipStatus=='0'}"><s:text name="index_0363"/></c:if>
                            <c:if test="${order.shipStatus=='1'}"><s:text name="index_0364"/></c:if>
                            <c:if test="${order.shipStatus=='2'}"><s:text name="index_0365"/></c:if>
                            <c:if test="${order.shipStatus=='3'}"><s:text name="index_0366"/></c:if>
                            <c:if test="${order.shipStatus=='4'}"><s:text name="index_0367"/></c:if>
                            <c:if test="${order.shipStatus=='5'}"><s:text name="index_0368"/></c:if>
                            </font></span>
                            <span class="ml16 fw100 color_gray2">
                                <s:text name="index_0337"/>：<fmt:formatDate value="${order.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            <span class="ml16">
                            <c:if test="${order.status!='7'}">
                            <a style="" class="color_blue fw100" href="#"><s:text name="index_0187"/></a>
                            </c:if>
                            </span>
                        </div>
                        <div class="title0902"><s:text name="index_0338"/>：<span class="fw100">${order.orderMsg}</span></div>
                        <div class="ml40">
                            <c:if test="${order.status==1}">
                                <img src="images/status-1.jpg" width="512" height="72">
                            </c:if>
                            <c:if test="${order.status==2}">
                                <img src="images/status-2.jpg" width="512" height="72">
                            </c:if>
                            <c:if test="${order.status==3}">
                                <img src="images/status-3.jpg" width="512" height="72">
                            </c:if>
                            <c:if test="${order.status==5}">
                                <img src="images/status-4.jpg" width="512" height="72">
                            </c:if>
                            <c:if test="${order.status==4}">
                                <img src="images/status-5.jpg" width="512" height="72">
                            </c:if>
                        </div>
                    </div>
                        <div class="title0902"><s:text name="index_0369"/></div>
                        <div>
                            <table class="table0902" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <thead>
                                <tr>
                                    <td><s:text name="index_0393"/></td>
                                    <td><s:text name="index_0394"/></td>
                                    <td><s:text name="index_0395"/></td>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>2015-05-02 12:00:00</td>
                                    <td>您的订单已经拣货完毕，待出库交付圆通快递，运单号为82565236523</td>
                                    <td>颐佳超市</td>
                                </tr>
                                <tr>
                                    <td>2015-05-02 12:00:00</td>
                                    <td>您的订单已经拣货完毕，待出库交付圆通快递，运单号为82565236523</td>
                                    <td>颐佳超市</td>
                                </tr>
                                <tr>
                                    <td>2015-05-02 12:00:00</td>
                                    <td>您的订单已经拣货完毕，待出库交付圆通快递，运单号为82565236523</td>
                                    <td>颐佳超市</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="kuang0902">
                        <div class="title0902"><s:text name="index_0370"/></div>
                        <div>
                            <table class="table0902" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody>
                                <tr>
                                    <td width="150"><s:text name="index_0371"/></td>
                                    <td>
                                        <p class="fl">${order.shipName}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="150"><s:text name="index_0134"/></td>
                                    <td>
                                        <p class="fl">${order.address}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="150"><s:text name="index_0103"/></td>
                                    <td>
                                        <p class="fl">${order.shipTel}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="150"><s:text name="index_0105"/></td>
                                    <td>
                                        <p class="fl"></p>
                                    </td>
                                </tr>
                                <%--<tr>
                                    <td width="150">送货时间</td>
                                    <td>
                                        <p class="fl"></p>
                                    </td>
                                </tr>--%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="kuang0902">
                        <div class="title0902"><s:text name="index_0372"/></div>
                        <div>
                            <table class="table0902" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody>
                                <tr>
                                    <td width="150"><s:text name="index_0373"/></td>
                                    <td>
                                        <p class="fl">${order.billType}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="150"><s:text name="index_0374"/></td>
                                    <td>
                                        <p class="fl">${order.billHead}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="150"><s:text name="index_0375"/></td>
                                    <td>
                                        <p class="fl">${order.billContent}</p>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="kuang0902">
                        <div class="title0902"><s:text name="index_0396"/></div>
                        <div>
                            <table class="table0902" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody>
                                <tr>
                                    <td width="150"><s:text name="index_0177"/></td>
                                    <td>
                                        <p class="fl">在线支付</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="150"><s:text name="index_0397"/></td>
                                    <td>
                                        <p class="fl">￥5.00</p>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="kuang0902">
                        <div class="title0902"><s:text name="index_0376"/></div>
                        <div>
                            <table class="table0902" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <thead>
                                <tr>
                                    <td><s:text name="index_0378"/></td>
                                    <td><s:text name="index_0332"/></td>
                                    <td><s:text name="index_0379"/></td>
                                    <td><s:text name="index_0380"/></td>
                                    <td><s:text name="index_0038"/></td>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${orderItems}" var="item">
                                <c:if test="${item.appraise=='0'}">
                                <tr>
                                    <td>$${item.goods.bn}</td>
                                    <td>
                                        <img class="fl" src="${item.defaultPicSrc}" width="135" height="83">
                                        <p class="fl ml10">
                                            <a class="color_blue" href="#">${item.goodsName}</a>
                                        </p>
                                    </td>
                                    <td>${item.nums}</td>
                                    <td>
                                        <br class="color_red1">
                                        <span>￥<fmt:formatNumber type="number" value="${1 * item.dealPrice}" pattern="0.00" maxFractionDigits="2"/></span></br>
                                        <span>$<fmt:formatNumber type="number" value="${huilv.now_rate_doc * item.dealPrice}" pattern="0.00" maxFractionDigits="2"/></span></br>
                                        <span>AED<fmt:formatNumber type="number" value="${huilv.now_rate_dlm * item.dealPrice}" pattern="0.00" maxFractionDigits="2"/></span>
                                        </p>
                                    </td>
                                    <td>
                                        <button type="button" class="btn-danger03"><a href="person/order/toComment/${item.id}.html">评价</a></button>
                                    </td>
                                </tr>
                                </c:if>
                                <c:if test="${item.appraise=='1'}">
                                <tr>
                                    <td>${item.goods.bn}</td>
                                    <td>
                                        <img class="fl" src="${item.defaultPicSrc}" width="135" height="83">
                                        <p class="fl ml10">
                                            <a class="color_blue" href="#">${item.goodsName}</a>
                                        </p>
                                    </td>
                                    <td>${item.nums}</td>
                                    <td>
                                        <p class="color_red1">
                                            <span>￥${item.dealPrice}</span></br>
                                            <span>$<fmt:formatNumber type="number" value="${huilv.now_rate_doc * item.dealPrice}" pattern="0.00" maxFractionDigits="2"/></span></br>
                                            <span>AED<fmt:formatNumber type="number" value="${huilv.now_rate_dlm * item.dealPrice}" pattern="0.00" maxFractionDigits="2"/></span>
                                        </p>
                                    </td>
                                    <td>
                                        <p><s:text name="index_0198"/></p>
                                    </td>
                                </tr>
                                </c:if>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="5" style="line-height:35px;">
                                        <p class="t_r f14"><s:text name="index_0025"/>：￥${order.totalCost}
                                            $<fmt:formatNumber type="number" value="${huilv.now_rate_doc * order.totalCost}" pattern="0.00" maxFractionDigits="2"/>
                                            AED<fmt:formatNumber type="number" value="${huilv.now_rate_dlm * order.totalCost}" pattern="0.00" maxFractionDigits="2"/>(<s:text name="index_0382"/>)</p>
                                        <p class="t_r f14"><s:text name="index_0381"/>：-100（￥500.00   $50.00  AED20.00）</p>
                                        <h2 class="t_r" style="font-size: 20px;"><s:text name="index_0383"/>：<span class="color_black">￥1020.00</span></h2>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>