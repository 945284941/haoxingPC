<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="detail">
</div>
<div class="lh_sjdp_qbsp_right01">
    <ul>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span><s:text name="index_1007"/>
                <span>${company.shoperName}</span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span><s:text name="index_1008"/>
                <span><a href="">${company.qqNumber}</a></span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span><s:text name="index_0094" />
                <span><a href="">${company.telphone}</a></span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span><s:text name="index_0096"/>
            </p>
            <p style="margin-left: 40px;">${company.combrief}</p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span><s:text name="index_0097" />
                <span>${company.companyName}</span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span><s:text name="index_0098" />
                <span>${company.area}</span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span><s:text name="index_0099" />
                <span>${company.openTime}</span>
            </p>
        </li>
        <li>
            <p>
                <span><i class="icon iconfont"></i></span><s:text name="index_0100" />
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



</div>
