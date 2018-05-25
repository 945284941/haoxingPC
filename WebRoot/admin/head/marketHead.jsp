<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="/WEB-INF/jsp-taglib.tld" prefix="mi" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<!-- 导航 -->
<div class="nav">
    <div class="nav_center">
        <div id="leftCat" class="nav_left">
            <h2><a href="/"><em><i class="icon iconfont">&#xe6b8;</i></em><span><s:text name="index_0268"/></span></a></h2>
            <div id="other_menu" class="other_menu" style="display: none;">
                <div class="left_menu" id="left_menu">
					<c:forEach items="${fullCategoryList}" var="cat" varStatus="status">
                    <dl class="left_menu_dl" id="${status.index + 1}" style="position: relative;" child_count="3" sc_color="#e60012">
                        <dt class="left_menu_dt" id="dts_15">
                            <i class="left_menu_i"><i class="icon iconfont">&#xe610;</i></i>
							<c:if test="${'zh' eq sessionInfo.language}">
								<strong class="left_menu_str"><a href="searchGoodsListCat/${bankuaiType}/${cat.id}.html">${cat.name}</a></strong>
							</c:if>
							<c:if test="${'zh' ne sessionInfo.language}">
								<strong class="left_menu_str"><a href="searchGoodsListCat/${bankuaiType}/${cat.id}.html">${cat.enName}</a></strong>
							</c:if>
                        </dt>
                        <dd class="left_menu_dd" id="child_${status.index + 1}" style="display: none;">
                            <div class="left_menu_con this " id="left_menu_con_15">
								<span class="left_menu_sp">
                                      <div class="left_menu_con_center">
                                            <div class="menu_con_right_top" style="background-color: #000;">
                                             	<dl>
													<dt>
														<c:if test="${'zh' eq sessionInfo.language}">
															<c:forEach items="${cat.subCatList}" var="subCat" varStatus="status">
																<span><a href="searchGoodsListCat/${bankuaiType}/${subCat.id}.html" target="_blank">${subCat.name}</a></span>
															</c:forEach>
														</c:if>
														<c:if test="${'zh' ne sessionInfo.language}">
															 <c:forEach items="${cat.subCatList}" var="subCat" varStatus="status">
																<span><a href="searchGoodsListCat/${bankuaiType}/${subCat.id}.html" target="_blank">${subCat.enName}</a></span>
															 </c:forEach>
														</c:if>
													</dt>
												</dl>
											</div>
										 <div class="left_menu_con_center_left">
										 <c:if test="${'zh' eq sessionInfo.language}">
										 <c:forEach items="${cat.subCatList}" var="subCat" varStatus="status">
										 <dl>
											<dt><b>&gt; </b><a href="searchGoodsListCat/${bankuaiType}/${subCat.id}.html" target="_blank">${subCat.name}</a></dt>
											<dd>
												<c:forEach items="${subCat.threeCatList}" var="threeCat" varStatus="status">
													<a href="searchGoodsListCat/${bankuaiType}/${threeCat.id}.html" target="_blank">${threeCat.name}</a>
												</c:forEach>
											</dd>

										 </dl>
										 </c:forEach>
										 </c:if>

										 <c:if test="${'zh' ne sessionInfo.language}">
											 <c:forEach items="${cat.subCatList}" var="subCat" varStatus="status">
											<dl>
												<dt><b>&gt; </b><a href="searchGoodsListCat/${bankuaiType}/${subCat.id}.html" target="_blank">${subCat.enName}</a></dt>
												<dd>
													<c:forEach items="${subCat.threeCatList}" var="threeCat" varStatus="status">
														<a href="searchGoodsListCat/${bankuaiType}/${threeCat.id}.html" target="_blank">${threeCat.enName}</a>
													</c:forEach>
												</dd>
											</dl>
											 </c:forEach>
										 </c:if>
										 </div>
									</div>
								</span>
                            </div>
                        </dd>
                    </dl>
					</c:forEach>
                </div>
            </div>
        </div>
        <s:action name="catalogueAction!queryFullMenu" executeResult="true" namespace="/"/>
    </div>
</div>