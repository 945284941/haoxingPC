<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
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

</head>
<body>

<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toPersionLogo" executeResult="true" namespace="/"></s:action>

<div style="background: #f6f6f6;">
	<div class="main">
		<!--我是买家-->
		<div class="h_content">
			<!-- 左侧功能菜单开始 -->
			<jsp:include page="/memberCenter/common/leftNavigatePersonNew.jsp" />
			<!-- 左侧功能菜单结束 -->
			<div class="w-buyers">
				<div class="l-fr">
					<div class="w-title">
						<h3><s:text name="index_0303"/>><s:text name="index_0134"/></h3>
					</div>
				</div>
				<div class="w-address">
					<table>
						<tbody>
						<tr class="w-bt">
							<td class="w-shr"><s:text name="index_0151"/></td>
							<td class="w-shdz"><s:text name="index_0134"/></td>
							<td class="w-dh"><s:text name="index_0103"/></td>
							<td class="w-cz"><s:text name="index_0300"/></td>
						</tr>
						<c:forEach items="${addrList}" var="addrList" >
							<c:if test="${addrList.isDefault==true}">
								<tr class="w-nr">
									<td>${addrList.receiveName}</td>
									<td>${addrList.receiveAddress}</td>
									<td>${addrList.mobile}</td>
									<td>
										<a href="javascript:void(0);" class="w-mrdz"><s:text name="index_0148"/></a>
										<a href="javascript:void(0);" class="w-xg" onclick="getAddr('${addrList.id}')"><s:text name="index_0146"/></a>
										<a href="javascript:void(0);" class="w-sc" onclick="delAddr('${addrList.id}')"><s:text name="index_0147"/></a>
									</td>
								</tr>
							</c:if>
							<c:if test="${addrList.isDefault==false}">
								<tr class="w-nr">
									<td>${addrList.receiveName}</td>
									<td>${addrList.receiveAddress}</td>
									<td>${addrList.mobile}</td>
									<td>
										<a  class="w-mrdz" onclick="setDefaultAddr('${addrList.id}')"><s:text name="index_0335"/></a>
										<a  class="w-xg" onclick="getAddr('${addrList.id}')"><s:text name="index_0146"/></a>
										<a  class="w-sc" onclick="delAddr('${addrList.id}')"><s:text name="index_0147"/></a>
									</td>
								</tr>
							</c:if>
						</c:forEach>
						</tbody>
					</table>
					<p class="xz"><s:text name="index_0150"/></p>

						<ul>
							<form action="" id="addForm" enctype="multipart/form-data" method="post">
								<input type="hidden" id="id" name="id"/>
							<li>
								<p class="bxtx"><span ><em>*</em><s:text name="index_0151"/>：</span></p>
								<p><input type="text" class="input" id="receiveName" name="receiveName"/></p>
							</li>
							<li>
								<p class="bxtx"><span ><em>*</em><s:text name="index_0351"/>：</span></p>
								<p>
									<select id="countryId" name="countryId">
										<c:forEach items="${countryList}" var="countryList">
											<option value="${countryList.id}" >${countryList.name}</option>
										</c:forEach>
									</select>
								</p>
							</li>
							<li>
								<p class="bxtx"><span><em>*</em><s:text name="index_0154"/>：</span></p>
								<p><input type="text" class="input" id="receiveAddress" name="receiveAddress"/></p>
							</li>
							<li>
								<p class="bxtx"><span ><em>*</em><s:text name="index_0105"/>：</span></p>
								<p><input type="text" class="input" id="mobile" name="mobile"/></p>
							</li>
							<li>
								<p class="bxtx"><span ><s:text name="index_0152"/>：</span></p>
								<p><input type="text" class="input" id="zip" name="zip"/></p>
							</li>
							</form>
							<li>
								<p class="bxtx">&nbsp;" </p>
								<p><input type="submit" value="<s:text name='index_0309'/>" class="save" onclick="subQg()"></p>
								<p><input type="submit" value="<s:text name='index_0319'/>" class="save1" onclick="cancel()"></p>
							</li>
						</ul>

				</div>
			</div>
		</div>
	</div>
</div>
<!--我是买家-->

</div>
</div>

<jsp:include page="/admin/common/indexFooter.jsp" />
<script type="text/javascript">
    //取消
    function cancel(){
        $("#id").val("");
        $("#receiveName").val("");
        $('#receiveAddress').val("");
        $('#mobile').val("");
        $('#zip').val("");
    }

    //删除收货地址
    function delAddr(id){
        if(confirm("<s:text name='index_0326'/>")){
            $.ajax({
                url : "memberCallAction!delReceiveAddr.action",
                type : "POST",
                data : "id="+id,
                dataType : "JSON",
                success : function(){
                    window.location.href="loadReceiveAddr.html";
                }
            });
        }
    }


    //编辑地址
    function getAddr(id){
        $.ajax({
            url : "memberCallAction!getReceiveAddr.action",
            data : "id="+id,
            type : "POST",
            dataType : "JSON",
            success : function(data) {
                $('#id').val(data.id);
                $('#receiveName').val(data.receiveName);
                $('#receiveAddress').val(data.receiveAddress);
                $('#mobile').val(data.mobile);
                $('#zip').val(data.zip);
                var numbers = $("#countryId").find("option")
                //var options = numbers.find("option");
                //console.log("999"+JSON.stringify(numbers));
                for (var j = 1; j<= numbers.length; j++) {
                    //console.log("111"+$(numbers[j]).val());
                    //console.log("222"+data.countryId);
                    if (data.countryId == $(numbers[j]).val()) {
                        $(numbers[j]).attr("selected", "selected");
                    }
                }

            }
        });
    }

    //设置默认地址
    function setDefaultAddr(id){
        $.ajax({
            url : "memberCallAction!setDefaultAddr.action",
            data : "id="+id,
            type : "POST",
            dataType : "JSON",
            success : function() {
                window.location.href="loadReceiveAddr.html";
            }
        });
    }


    function subQg() {
        var receiveName = $('#receiveName').val();
        var countryId = $('#countryId').val();
        var receiveAddress = $('#receiveAddress').val();
        var mobile = $('#mobile').val();
        var zip = $("#zip").val();
        if (receiveName == '' || receiveName == null){
            alert('<s:text name="index_0352"/>');
            return false;
        }
		if (receiveAddress == '' || receiveAddress == null) {
			alert('<s:text name="index_0354"/>');
			return false;
		}
		if (mobile == '' || mobile == null) {
			alert('<s:text name="index_0355"/>');
			return false;
		}
		$.ajax( {
			url : 'memberCallAction!addReceiveAddr.action',
			type : 'POST',
			data : $('#addForm').serialize(),
			success : function(data) {
				var msg = $.parseJSON(data);
				if (msg == 'success') {
					alert("<s:text name="index_0315"/>！");
					window.location.href="loadReceiveAddr.html";
					return true;
				}else{
					alert("<s:text name="index_0316"/>！");
					return false;
				}
			}
		});


    }
</script>

</body>
</html>