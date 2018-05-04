<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>泉利重配城口号征集系统</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<link rel="stylesheet" href="/css/bmxt.css" type="text/css" />
<script type=text/javascript src="/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/js/khzj.js"></script>
<script type="text/javascript" src="/js/perinfo.js"></script>
</head>
<body style="height: 100%;background-color: #002a4e;">

	<div class="bmxt">
		<div class="bmxt02"></div>
		<form name="khzjMsgForm" method="post">
		<input type="hidden" value="" name="khContentid" id="khContentid"/>
		<div class="bmxtbd">
			<div class="titleD"></div>
			<div class="hdlb">
			
			

			</div>
			<div class="bmbd">
				<div class="bmleft">
						<ul class="listkou">
								<li class="listnrkou">
									<span> 
										<input name="hd" type="radio" value="${id}" checked/> 
									</span> 
									<span> 
										${content}
									</span>
									 <span class="listnum">${point}</span>
								</li>
						</ul>
				</div>
				
			</div>
			<div class="bmright" style="float:left;margin-top:20px;">

				<p class="bmtext">
					<span class="label">您的手机号：</span> <span class="bx">
					<input
						type="text" name="khzj.tpTelphone" id="tpTelphone" />
					</span> <span class="label">激 活 码：</span> <span class="bx">
					<input
						type="text" name="tpTelphoneCode" id="tpTelphoneCode"/>
					</span> <span class="buttonla"><input
						id="admin_khzjMsg_toESM" width="50px;" type="button"
						value="免费获取短信激活码"
						onclick="getMobileCode('admin_khzjMsg_toESM','tpTelphone',0);" />
					</span><span class="bx"></span>
				</p>
			</div>
			<div style="clear:both"></div>
		</div>
		<div class="button">
			<input type="button" onclick="khzjMsgFormSub();" />

		</div>
		</form>
	</div>
	
</body>
</html>