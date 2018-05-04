<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="lh_sjdp_qbsp_right01">
    <ul>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span>商家名称
                <span>${company.shoperName}</span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span>商家QQ
                <span><a href="">${company.qqNumber}</a></span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span>商家电话
                <span><a href="">${company.linkmanMobile}</a></span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span>店铺介绍
            </p>
            <p style="margin-left: 40px;">${company.combrief}</p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span>公司名称
                <span>${company.companyName}</span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span>所在地区
                <span>${company.area}</span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span>开店时间
                <span>${company.openTime}</span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span>授权品牌
                <span>${company.openTime}</span>
            </p>
            <div class="lh_sjdp_qbsp_right01_pp">
                <c:forEach items="${company.imgList}" var="imgs" >
                    <div class="lh_sjdp_qbsp_right01_pp_img">
                            ${imgs}
                    </div>
                </c:forEach>
            </div>
        </li>
    </ul>
</div>
