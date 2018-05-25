<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="lh_sjdp_qbsp_right">
    <div class="l_paixun" style="width: 960px;">
        <div class="pl_px">
            <a id="l_pl_h" href="#"></a>
            <a  style="background: none;" id="pOrder" onclick="orderSiv()"><s:text name="index_0089"/>
                <font></font>
            </a>
            <a  id="volume" onclick="volumeSiv()"><s:text name="index_0024"/>
                <font></font>
            </a>
            <a id="createTime" style="background: none;" onclick="createTimeSiv()"><s:text name="index_0090"/>
                <font></font>
            </a>
            <a id="priceRise" onclick="priceRiseSiv()"><s:text name="index_0025"/>
                <font></font>
            </a>
        </div>
    </div>

    <input type="hidden" id="treeId" value="${treeid}">
    <div class="lh_sjdp_qbsp_right_nr">
        <div class="index_sptj_nr index_sptj_nr2">
            <ul id="goodsList">

               <c:forEach items="${goodPageList}" var="goods">
                <li class="item ">
                    <div class="goods-content" >
                        <div class="goods-pic">
                            <a isconvert="1" data-itemid="544015300167" href="goods/${goods.id}.html" target="_blank">
                                <img src="${goods.defaultPicSrc}" style="width:300px;height: 300px;"/>
                            </a>
                            <div class="index_sptj_nr_qg"><s:text name="index_0269" /></div>
                            <div class="index_sptj_nr_sl"><s:text name="index_0028" />${goods.store}<s:text name="index_0029" /></div>
                        </div>
                        <div class="goods-info">
                            <div class="goods-name">
                                <a isconvert="1" data-itemid="544015300167" href="#" target="_blank">${goods.name}</a>
                            </div>
                            <div class="goods-price">
                                <div class="goods-price_div">
                                    <em class="sale-price">¥${goods.price}</em><br>
                                    <span class="yuanjia">¥${goods.yuanjia}</span>
                                </div>
                                <div class="goods-price_div01">
                                    <span class="goods_buy">$${goods.USAMoney}</span><br>
                                    <span class="goods_buy">AED${goods.ADMMoney}</span>
                                </div>
                            </div>
                            <div class="goods-sales">

                                <p class="fl"><s:text name="index_0024"/> ${goods.queryNum}</p>
                                <p class="fr"><s:text name="index_0027"/> ${goods.praiseRate}%</p>
                            </div>
                        </div>
                    </div>
                </li>
                </c:forEach>

            </ul>

        </div>
        <div class="w-page" style="float: left;">
            <page:pagination path="memberCallAction!companyGoodsList.action"
                             formName="pagerForm"/>
        </div>
    </div>


</div>

<script type="text/javascript">


</script>
