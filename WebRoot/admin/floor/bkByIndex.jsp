<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<script type="text/javascript">
    var arr = document.getElementsByClassName("tab_item");
    function changeBank(t) {
        for(var i = 0; i < arr.length; i++) {
            if(i == t){
                arr[i].classList.add("on");
                if(i == 0 || i == 1){
                    changeBk("发布求购","toAddWantBuy.html","wantBuy");
                    $("#fenlei").hide();
                }
                if(i == 2){
                    changeBk("发布二手商品","toAddSecondHand.html","wantSecond");
                }
                if(i == 3){
                    changeBk("发布拼箱","toAddLcl.html","wantLcl");
                }
                if(i == 4){
                    changeBk("发布生活圈","toLife.html","wantLife");
                }
            }else{
                arr[i].classList.remove("on");
            }
        }
    }

    function changeBk(t,url,bg){
        var old = $("#checkLable").val();
        $("#checkLable").val(bg)
        $("#bk").text(t);
        $("#bk").attr("href",url);
        $("#nobk").text(t);
        $("#nobk").attr("href","javascript:showLogin('mask', 'pop_500', '"+url+"', '0', '');");
        alert(old);
        $("#"+old).hide();
        $("#"+bg).show();
    }
</script>
<div class="main">
    <input type="hidden" id="checkLable" value="wantBuy"/>
    <div class="h_seat">
        <a href="/"><s:text name="index_0013"/></a> >
        <a href="">${sessionInfo.curentMenu}</a>
    </div>
    <form id="pagerForm" name="pagerForm" action="${sessionInfo.toUrl}" method="post">
    </form>
    <div class="bd_cx_nav">
        <div class="cx_nav3_01">
            <div class="cx_nav3">
                <h3>板&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;块：</h3>
                <p>
                    <a class="tab_item on" href="javascript:changeBank(0);">不限</a>
                    <a class="tab_item" href="javascript:changeBank(1);">求购</a>
                    <a class="tab_item" href="javascript:changeBank(2);">二手商品</a>
                    <a class="tab_item" href="javascript:changeBank(3);">拼箱</a>
                    <a class="tab_item" href="javascript:changeBank(4);">生活圈</a>
                </p>
            </div>

            <div class="cx_nav3">
                <div class="cx_nav2" id="fenlei">
                    <h3>分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类：</h3>
                    <p>
                        <a href="" class="on">不限</a>
                        <c:forEach items="${shopOneCatList}" var="shopCat" varStatus="status">
                            <c:if test="${'zh' eq sessionInfo.language}">
                                <a href="">${shopCat.name}</a>
                            </c:if>
                            <c:if test="${'zh' ne sessionInfo.language}">
                                <a href="">${shopCat.enName}</a>
                            </c:if>
                        </c:forEach>
                    </p>
                </div>
                <div class="cx_nav2" id="guojia">
                    <h3>国&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家：</h3>
                    <p>
                        <a href="" class="on">不限</a>
                        <c:forEach items="${countryList}" var="co" varStatus="status">
                            <c:if test="${'zh' eq sessionInfo.language}">
                                <a href="">${co.name}</a>
                            </c:if>
                            <c:if test="${'zh' ne sessionInfo.language}">
                                <a href="">${co.nameEng}</a>
                            </c:if>
                        </c:forEach>
                    </p>
                </div>
            </div>

        </div>
        <s:if test="#attr.sessionInfo.loginName!=null">
            <a id="bk" href="toAddWantBuy.html" class="cx_nav3_02">发布求购</a>
        </s:if>
        <s:else>
            <a id="nobk" href="javascript:showLogin('mask', 'pop_500', 'toAddWantBuy.html', '0', '');" class="cx_nav3_02">发布求购</a>
        </s:else>
    </div>
    <div id="wantBuy" style="display: block">
        <s:action name="indexFloorAction!showIndexWantBuyFloor" namespace="/indexFloor" executeResult="true"></s:action>
    </div>
    <div id="wantLcl" style="display: none">
        <s:action name="indexFloorAction!showIndexFlashSaleFloor" namespace="/indexFloor" executeResult="true"></s:action>
    </div>

</div>