<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<script type="text/javascript">
    var fenleiArr = document.getElementsByClassName("fenlei_item");
    function changeFenlei(t,f) {
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
    }
    function subFo(){
        $("#pagerForm").submit();
    }
</script>
<div class="main">
    <div class="h_seat">
        <a href="/"><s:text name="index_0013"/></a> >
        <a href="">${sessionInfo.curentMenu}</a>
    </div>
    <form id="pagerForm" name="pagerForm" action="toSecondHand.html" method="post">
        <input type="hidden" name="wantSecondHand.catId" id="catId" value="${wantSecondHand.catId}"/>
    </form>
    <div class="bd_cx_nav">
        <div class="cx_nav3_01">
            <div class="cx_nav3">
                <h3>板&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;块：</h3>
                <p>
                    <a href="toWantBuy.html">求购</a>
                    <a  class="on" href="toSecondHand.html">二手商品</a>
                    <a  href="toWantLcl.html">拼箱</a>
                    <a  href="toWantLife.html">生活圈</a>
                </p>
            </div>

            <div class="cx_nav3">
                <div class="cx_nav2">
                    <h3>分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类：</h3>
                    <p>
                        <c:if test="${empty wantSecondHand.catId or wantSecondHand.catId eq '' }">
                            <a class="fenlei_item on" href="javascript:changeFenlei('0','');">不限</a>
                        </c:if>
                        <c:if test="${not empty wantSecondHand.catId and wantSecondHand.catId ne '' }">
                            <a class="fenlei_item" href="javascript:changeFenlei('0','');">不限</a>
                        </c:if>
                        <c:forEach items="${shopOneCatList}" var="shopCat" varStatus="status">
                            <c:if test="${shopCat.id eq  wantBuy.catId}">
                                <a class="fenlei_item on" href="javascript:changeFenlei('${status.index + 1}','${shopCat.id}')">
                            </c:if>
                            <c:if test="${shopCat.id ne  wantSecondHand.catId}">
                                <a class="fenlei_item" href="javascript:changeFenlei('${status.index + 1}','${shopCat.id}')">
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
                </div>

            </div>

        </div>
            <s:if test="#attr.sessionInfo.loginName!=null">
                <a id="bk" href="toAddHand.html" class="cx_nav3_02">
                    发布二手商品
                </a>
            </s:if>
            <s:else>
                <a id="nobk" href="javascript:showLogin('mask', 'pop_500', 'toAddHand.html', '0', '');" class="cx_nav3_02">
                    发布二手商品
                </a>
            </s:else>

    </div>
    <!-- 求购信息 -->
    <div class="lh_xsqg_nr">
        <ul>
            <c:forEach items="${wantSecondHandList}" var="wantSecondHand" varStatus="status">
            <li class="fl">
                <div class="tupian"><img src="${wantSecondHand.picUrl}"/></div>
                <div class="title"><a href="toHandView/${wantSecondHand.id}.html">${wantSecondHand.title}</a></div>
                <div class="jg01">
                    <div class="jg_zc01">${wantSecondHand.mobile}</div>
                    <div class="jg_yj01"><fmt:formatDate value="${wantSecondHand.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
                </div>
            </li>
                </c:forEach>
        </ul>
        <div class="clear"></div>
        <div class="w-page">
            <page:pagination path="toSecondHand.html" formName="pagerForm"/>
        </div>
    </div>

    <!-- 限时抢购结束 -->
</div>