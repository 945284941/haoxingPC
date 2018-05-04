<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>

<div class="main">
    <div class="h_seat">
        <a href="/"><s:text name="index_0013"/></a> >
        <a href="">${sessionInfo.curentMenu}</a>
    </div>
    <form id="pagerForm" name="pagerForm" action="${sessionInfo.toUrl}" method="post">
        <input type="hidden" name="wantBuy.buyType" id="buyType" value="${wantBuy.buyType}"/>
        <input type="hidden" name="wantBuy.catId" id="catId" value="${wantBuy.catId}"/>
        <input type="hidden" name="wantBuy.toCountryId" id="toCountryId"  value="${wantBuy.toCountryId}"/>
    </form>
    <div class="bd_cx_nav">
        <div class="cx_nav3_01">
            <div class="cx_nav3">
                <h3>板&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;块：</h3>
                <p>
                    <a class="tab_item on" href="javascript:changeBank(1);">求购</a>
                    <a class="tab_item" href="javascript:changeBank(2);">二手商品</a>
                    <a class="tab_item" href="javascript:changeBank(3);">拼箱</a>
                    <a class="tab_item" href="javascript:changeBank(4);">生活圈</a>
                </p>
            </div>

            <div class="cx_nav3">
                <div class="cx_nav2">
                    <c:if test="${wantBuy.buyType eq '1' or wantBuy.buyType eq '2'}">
                    <h3>分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类：</h3>
                    <p>
                        <c:if test="${empty wantBuy.catId or wantBuy.catId eq '' }">
                            <a class="fenlei_item on" href="javascript:changeFenlei('0','','1');">不限</a>
                        </c:if>
                        <c:if test="${not empty wantBuy.catId and wantBuy.catId ne '' }">
                            <a class="fenlei_item" href="javascript:changeFenlei('0','','1');">不限</a>
                        </c:if>
                        <c:forEach items="${shopOneCatList}" var="shopCat" varStatus="status">
                            <c:if test="${shopCat.id eq  wantBuy.catId}">
                                <a class="fenlei_item on" href="javascript:changeFenlei('${status.index + 1}','${shopCat.id}','1')">
                            </c:if>
                            <c:if test="${shopCat.id ne  wantBuy.catId}">
                                <a class="fenlei_item" href="javascript:changeFenlei('${status.index + 1}','${shopCat.id}','1')">
                            </c:if>
                            <c:if test="${'zh' eq sessionInfo.language}">
                                ${shopCat.name}
                            </c:if>
                            <c:if test="${'zh' ne sessionInfo.language}">
                                ${shopCat.enName}
                            </c:if>
                            </a>
                        </c:forEach>
                    </p>
                    </c:if>
                    <c:if test="${wantBuy.buyType eq '3'}">
                        <h3>国&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家：</h3>
                        <p>
                            <c:if test="${wantBuy.toCountryId eq '' }">
                                <a class="country_item on" href="javascript:changeFenlei('0','','2');">不限</a>
                            </c:if>
                            <c:if test="${wantBuy.toCountryId ne '' }">
                                <a class="country_item" href="javascript:changeFenlei('0','','2');">不限</a>
                            </c:if>

                            <c:forEach items="${countryList}" var="country" varStatus="status">
                            <c:if test="${country.id eq  wantBuy.toCountryId}">
                            <a class="country_item on" href="javascript:changeFenlei('${status.index + 1}','${country.id}','2')">
                                </c:if>
                                <c:if test="${country.id ne  wantBuy.toCountryId}">
                                <a class="country_item" href="javascript:changeFenlei('${status.index + 1}','${country.id}','2')">
                                    </c:if>
                                    <c:if test="${'zh' eq sessionInfo.language}">
                                        ${country.name}
                                    </c:if>
                                    <c:if test="${'zh' ne sessionInfo.language}">
                                        ${country.nameEng}
                                    </c:if>
                                </a>
                                </c:forEach>
                        </p>
                    </c:if>
                </div>

            </div>

        </div>
        <s:if test="#attr.sessionInfo.loginName!=null">
            <a id="bk" href="toAddWantBuy/${wantBuy.buyType}.html" class="cx_nav3_02">
                <c:if test="${empty wantBuy}">
                    发布求购
                </c:if>
                <c:if test="${not empty wantBuy}">
                    <c:if test="${wantBuy.buyType eq '1'}">
                        发布求购
                    </c:if>
                    <c:if test="${wantBuy.buyType eq '2'}">
                        发布二手商品
                    </c:if>
                    <c:if test="${wantBuy.buyType eq '3'}">
                        发布拼箱
                    </c:if>
                    <c:if test="${wantBuy.buyType eq '4'}">
                        发布生活圈
                    </c:if>
                </c:if>
            </a>
        </s:if>
        <s:else>
            <a id="nobk" href="javascript:showLogin('mask', 'pop_500', 'toAddWantBuy/${wantBuy.buyType}.html', '0', '');" class="cx_nav3_02">
                <c:if test="${empty wantBuy}">
                    发布求购
                </c:if>
                <c:if test="${not empty wantBuy}">
                    <c:if test="${wantBuy.buyType eq '1'}">
                        发布求购
                    </c:if>
                    <c:if test="${wantBuy.buyType eq '2'}">
                        发布二手商品
                    </c:if>
                    <c:if test="${wantBuy.buyType eq '3'}">
                        发布拼箱
                    </c:if>
                    <c:if test="${wantBuy.buyType eq '4'}">
                        发布生活圈
                    </c:if>
                </c:if>

            </a>
        </s:else>

    </div>
    <!-- 求购信息 -->
    <div class="lh_xsqg_nr">
        <ul>
            <c:forEach items="${wantBuyList}" var="wantBuy" varStatus="status">
            <li class="fl">
                <div class="tupian"><img src="${wantBuy.picUrl}"/></div>
                <div class="title"><a href="toWantBuyView/${wantBuy.id}/${wantBuy.buyType}.html">${wantBuy.title}</a></div>
                <div class="jg01">
                    <div class="jg_zc01">${wantBuy.mobile}</div>
                    <div class="jg_yj01"><fmt:formatDate value="${wantBuy.sendDate}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
                </div>
            </li>
                </c:forEach>
        </ul>
        <div class="clear"></div>
        <div class="w-page">
            <page:pagination path="toWantBuy.html" formName="pagerForm"/>
        </div>
    </div>

    <!-- 限时抢购结束 -->
</div>
<script type="text/javascript">
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
    function subFo(){
        $("#pagerForm").submit();
    }
</script>