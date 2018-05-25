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
						<h3>设置>银行卡</h3>
					</div>
					<div class="w-account">
						<ul>
							<c:forEach items="${bankcardList}" var="bankcard">
								<li class="w-bank">
									<div class="w-bank1">
										<div class="w-bank-tit">
											<p class="w-le"><span>${bankcard.bank}</span></p>
											<p class="w-ri">尾号${bankcard.cardNumber}</p>
										</div>
										<div class="w-bank-cz">
											<p class="w-ri">
												<a href="javascript:void(0)" onclick="delBankcard('${bankcard.id}')">删除</a>|
												<a href="javascript:void(0)" onclick="getBankcard('${bankcard.id}');
														document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">编辑</a>
											</p>
										</div>
									</div>
								</li>
							</c:forEach>
							<li class="w-add">
								<a href="javascript:void(0)" onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">添加银行卡</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--我是买家-->

</div>


<jsp:include page="/admin/common/indexFooter.jsp" />
<!--银行卡-->
<div id="light" class="fn_sign w-box1 w-box2" style="display:none;">

	<div class="w-box-tit">
		<h3><s:text name="index_0303"/>><s:text name="index_0159"/></h3>
		<a href="javascript:void(0)" onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'" class="w-close"></a>
	</div>
	<form action="" id="addForm" enctype="multipart/form-data" method="post">
		<div class="w-set">
			<div class="h_revise1">
				<input type="hidden" class="h_datum_input11" id="id" name="id"/>
				<dl>
					<dt><s:text name="index_0160"/>:</dt>
					<dd><input type="text" class="h_datum_input11" id="name" name="name"/></dd>
				</dl>
				<dl>
					<dt><s:text name="index_0318"/>:</dt>
					<dd>
						<input type="text" class="h_datum_input11" id="bank" name="bank"/>
						<%--<select name="" id="" class="h_revise_select1">
                            <c:forEach items="" var="">
                            <option value="">中国建设银行</option>
                            </c:forEach>
                        </select>--%>
					</dd>
				</dl>
				<dl>
					<dt><s:text name="index_0161"/>:</dt>
					<dd><input type="text" class="h_datum_input11" id="cardNumber" name="cardNumber"/>
						<p>注意：输入卡号与持卡人姓名不匹配的卡，将无法正常收到提现</p>
					</dd>
				</dl>
				<dl>
					<dt><s:text name="index_0163"/>:</dt>
					<dd><input type="text" class="h_datum_input11" id="openBank" name="openBank"/></dd>
				</dl>
			</div>
		</div>
	</form>
	<div class="w-pro-icon">
		<input type="submit" onclick="subQg()" value="<s:text name='index_0309'/>" class="w-cofirm"
			   onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"/>
		<input type="submit" value="<s:text name='index_0319'/>" class="w-cofirm1"
			   onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none';cancel()"/>
	</div>
</div>
<div id="fade" class="black_overlay1"></div>
<!--银行卡-->

<script type="text/javascript">
    //取消
    function cancel(){
        $("#id").val("");
        $("#name").val("");
        $('#bank').val("");
        $('#cardNumber').val("");
        $('#openBank').val("");
    }

    //删除银行卡
    function delBankcard(id){
        if(confirm("<s:text name='index_0326'/>?")){
            $.ajax({
                url : "memberCallAction!delBankcard.action",
                type : "POST",
                data : "id="+id,
                dataType : "JSON",
                success : function(){
                    window.location.href="showBankcard.html";
                }
            });
        }
    }


    //编辑银行卡
    function getBankcard(id){
        $.ajax({
            url : "memberCallAction!getBankcard.action",
            data : "id="+id,
            type : "POST",
            dataType : "JSON",
            success : function(data) {
                $('#id').val(data.id);
                $('#name').val(data.name);
                $('#bank').val(data.bank);
                $('#cardNumber').val(data.cardNumber);
                $('#openBank').val(data.openBank);
            }
        });
    }

	/*//设置默认地址
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
	 }*/

    //添加银行卡
    function subQg() {
        var id = $('#id').val();
        var name = $('#name').val();
        var bank = $('#bank').val();
        var cardNumber = $('#cardNumber').val();
        var openBank = $('#openBank').val();
        if (name == '' || name == null){
            alert('<s:text name="index_0320"/>！');
            return false;
        }
        if (bank == '' || bank == null) {
            alert('<s:text name="index_0322"/>！');
            return false;
        }
        if (cardNumber == '' || cardNumber == null) {
            alert('<s:text name="index_0321"/>！');
            return false;
        }
        if (openBank == '' || openBank == null) {
            alert('<s:text name="index_0323"/>！');
            return false;
        }
        $.ajax({
            url : 'memberCallAction!addBankcard.action',
            type : 'POST',
            data : $('#addForm').serialize(),
            success : function(data) {
                var msg = $.parseJSON(data);
                if (msg == 'success') {
                    alert("<s:text name="index_0315"/>！");
                    window.location.href="showBankcard.html";
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