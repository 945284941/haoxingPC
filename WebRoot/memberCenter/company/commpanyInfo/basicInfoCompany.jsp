<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css"/>
<link href="css/hyzxdp.css" rel="stylesheet" type="text/css"/>
<script type=text/javascript src="js/regions.js"></script>
<script type=text/javascript src="js/perinfo.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script language="JavaScript" type="text/JavaScript">

function showElement(elementId)
{
  document.getElementById(elementId).style.display="block";
}
function hideElement(elementId)
{
  document.getElementById(elementId).style.display="none";
}

function onchangeMessage(message){
	if(message=='xiangxi'){
		document.getElementById(message).style.display="block";
		document.getElementById('jiben').style.display="none";
	}else{
		document.getElementById(message).style.display="block";
		document.getElementById('xiangxi').style.display="none";
	}
}
	
	function _submit(){
		$('#jibenForm').submit();
	}
	function xiangxi_submit(){
		$('#xiangxiForm').submit();
	}
</script>
</head>
<body>
<div id="tanchu"></div>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
 <s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<!--======================导航开始============================-->
<jsp:include page="/admin/common/navigation.jsp" />
<!--======================top结束============================-->
<div class="breadThumb">当前位置：首页&gt; 会员中心 &gt; 企业信息 &gt; 企业资料</div>
<div class="gzgz">
    <div class="hyleft">
     	<jsp:include page="/memberCenter/common/leftNavigate.jsp" />
     </div>
     <div class="hyright">
       <p class="hymainbt"><span class="grmenubt">企业资料</span></p>
       <div class="myxx">
         <ul>
         <p><span class="hyname">会员${company.username}</span>  欢迎您！</p>
         <p>会员分类：企业</p>
        </ul> 
        <ul>
          <p>注册时间：<s:date format="yyyy-MM-dd" name="%{company.regTime}"/></p><p>注册IP地址：${company.regIp}</p><p>登录时间：<s:date format="yyyy-MM-dd" name="%{company.nowTime}"/></p><p>登录IP地址：${company.nowIp}</p>
        </ul>                      
</div>  
     <div class="grxx" id ="jiben">
     	<form action="company/companyMember/saveCompanyMessage.html" method="post" id="jibenForm" enctype="multipart/form-data">
       	<input name="company.id" value="${company.id }" type="hidden"/>
        <h2><a class="hover" >基本信息</a><a  onclick="onchangeMessage('xiangxi');">详情信息</a></h2>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司名称：</span>
			<input style="vertical-align:middle" type="text" class="textgr" value="${company.companyName}"  name="company.companyName" />
	    </div>
        <div class="item" style="height:43px; line-height:43px;">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司logo：</span>
			
            <div class="zl_pic" style="color: red;">
            	<s:if test="company.companyLogo==null">
            		暂无图片
            	</s:if>
            	<s:else>
            		<img style=" height:41px;" src="${company.companyLogo}" />
            	</s:else>
            	
            </div>
            <div class="fb_f3">
				<div class=btns>
				    	<input class="btn_file_molding" name="logo" size="6" type="file"/><input class="btn_file"  value="上传图片 "type="button"/>
				</div>
			</div>
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>营业执照编号：</span>
			<input type="text" class="textgr"   name="company.licenceNum" value="${company.licenceNum}"/>
	    </div>
        <div class="item" style="height:43px; line-height:43px;">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>营业执照：</span>
	            <div class="zl_pic" style="color:red;">
	            	<s:if test="company.licenceSrc==null">
	            		暂无图片
	            	</s:if>
	            	<s:else>
	            		<img style=" height:41px;" src="${company.licenceSrc}" />
	            	</s:else>
	            </div>
            <div class="fb_f3">
				<div class="btns">
				
				<input class="btn_file_molding" size="6" name="licence" type="file"/><input class="btn_file"  value="上传图片" type="button"/>
				</div>
			</div>
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>营业执照有效期：</span>
			<input type="text" class="textgr" value="${company.licenceEndDate}"  name="company.licenceEndDate"/>
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>营业执照详细地址：</span>
			<input type="text" class="textgr2" value="${company.licenceAddress}"  name="company.licenceAddress"/>
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司地址：</span>
			<s:select id="lvst_companyInfo_proviceList"  class="labelgr"  name="company.province"  headerKey="0"  headerValue="-选择省-" list="provinceList" listKey="id" listValue="name" value="%{company.province}" theme="simple" onchange="_getCitys(this.value,'lvst_companyInfo_citylist','lvst_companyInfo_areaList')"></s:select> 
	        <s:select id="lvst_companyInfo_citylist"   headerKey="0"  name="company.city" headerValue="-选择市-"  list="cityList"  listKey="id"  listValue="name"  value="%{company.city}"  theme="simple"  onchange="_getAreas(this.value,'lvst_companyInfo_areaList')"></s:select>
	        <s:select id= "lvst_companyInfo_areaList"   headerKey="0"  name="company.area" headerValue="-选择区-"  list="areaList"  listKey="id"  listValue="name"  value="%{company.area}"  theme="simple"></s:select>
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>详细地址：</span>
			<input type="text" class="textgr2" value="${company.address }" name="company.address"/>
	    </div>
	     <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司移动电话：</span>
			<input type="text" class="textgr" value="${company.mobile}"  name="company.mobile"/>
            <span><!--  <input type="button" class="button" name="" value="短信验证" />--></span>
	    </div>        
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>验证电话：</span>
			<input type="text" class="textgr" value="${company.linkmanPhone}" disabled="disabled" name="company.linkmanPhone"/>
            <span><!--  <input type="button" class="button" name="" value="短信验证" />-->
            <a href="javascript:void(0);" onclick="_showUpdatePwDialog('tanchu', 'updateMobile_0', 6,'updateMobile_mobile');" style="color:#08c;">更换号码</a></span> 
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司固定电话：</span>
			<input type="text" class="textgr" value="${company.telphone }"  name="company.telphone"/>
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司邮编：</span>
			<input type="text" class="textgr" value="${company.zip }"  name="company.zip"/> 
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司邮箱：</span>
			<input type="text" class="textgr2" value="${company.email }"  name="company.email"/> 
	    </div>
	     <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>店铺客服qq：</span>
			<input type="text" class="textgr2" value="${company.qqNumber }"  name="company.qqNumber"/> 
	    </div>
        <p><a  onclick="_submit()">保存</a></p>     
        </form>       
      </div>
      
      <div class="grxx" id="xiangxi" style="display: none;">
      	<form action="company/companyMember/saveCompanyMessage.html" enctype="multipart/form-data" method="post" id="xiangxiForm">
        <h2><a onclick="onchangeMessage('jiben');">基本信息</a><a class="hover">详情信息</a></h2>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>法人姓名：</span>
			<input style="vertical-align:middle" type="text" class="textgr" value="${company.corporationName}"  name="company.corporationName"/>
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>法人身份证：</span>
			<input type="text" class="textgr" value="${company.card }" name="company.card"/>
	    </div>
        
    <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>开户行名称：</span>
			<input type="text" class="textgr" value="${company.companyBankName }"  name="company.companyBankName"/>
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>银行账号：</span>
			<input type="text" class="textgr2" value="${company.companyBankNum }" name="company.companyBankNum"/>
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>银行开户名：</span>
			<input type="text" class="textgr2" value="${company.accountName }"  name="company.accountName"/>
	    </div>
        <div class="item">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>银行详细地址：</span>
			<input type="text" class="textgr2" value="${company.bankAddress }"  name="company.bankAddress"/>
	    </div>         
        <div class="item" style="height:43px; line-height:43px;">
			<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>供应商家门面图：</span>
          <div class="zl_pic">
          <s:if test="company.storefrontSrc==null">
	            		暂无图片
	            	</s:if>
	            	<s:else>
	            		<img style=" height:41px;" src="${company.storefrontSrc}" />
	            	</s:else>
	        </div>
            <div class="fb_f3">
			<div class="btns">
			<input class="btn_file_molding" size="6" type="file" name="storefrontSrc"/>
			<input class="btn_file"  value="上传图片" type="button"/>
			</div>
			</div>
       
      </div>
    <div class="item" style="height:110px;">
		<span class="labelgr"><strong style="color:#ff0006; ">*&nbsp;&nbsp;</strong>公司经营范围：</span>
		<textarea class="fw" name="company.sellRange" cols="" rows="">${company.sellRange }</textarea>
    </div>
	<input name="company.id" value="${company.id }" type="hidden"/>
	<div class="item">
		<span class="labelgr"></span>
		<a class="gsbc" onclick="xiangxi_submit()">保存</a>
	</div>
       </form>       
      </div>
     </div>  
     <div style="clear:both"></div>
</div>
<!-- updateMobile begin -->
<div id="updateMobile_0" class="aqtc" style=" visibility:hidden">
  <div class="xgmm"><span class="zzjx">1.验证身份</span><span>2.修改手机号码</span></div>
  <p style="margin-left:70px; margin-top:30px;"><label>已绑定手机号码：</label><span id="updateMobile_mobile"></span></p>
  <p style="margin-left:175px; margin-top:10px;">
	<input class="yzm" id="updateMobile_mobileCode" type="button" style="width:125px;" value="免费获取校验码" onclick="javascript:sendMobileCode('updateMobile_mobileCode',2,'mobileCheck');"/></p>
  <p style="margin-left:128px; margin-top:10px;"><label>校验码：</label><input type="text" style="width:60px;" id="updateMobile_yzm"/>
  </p>
  <p style="margin-left:110px; margin-bottom:15px; margin-top:20px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_checkMobile('tanchu', 'updateMobile_0','updateMobile_1', 6,'updateMobile_yzm')">确认</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'updateMobile_0', 6);" >【关闭】</a>
  </p>
</div>
<div id="updateMobile_1" class="aqtc" style=" visibility:hidden">
  <div class="xgmm"><span>1.验证身份</span><span class="zzjx">2.修改手机号码</span></div>
  <p style="margin-left:40px; margin-top:30px;"><label>新手机号码：</label><input type="text" style="width:200px;" id="updateMobile_new_mobile"/></p>
  <p style="margin-left:68px; margin-top:10px;"><label>校验码：</label><input type="text" style="width:60px;" id="updateMobile_new_yzm"/>&nbsp;
  <input class="yzm" id="updateMobile_new_mobileCode" type="button" style="width:125px;" value="免费获取校验码" onclick="javascript:getMobileCodeForUpdateMobile('updateMobile_new_mobileCode','updateMobile_new_mobile',2);"/></p>
  <p style="margin-left:120px; margin-bottom:15px; margin-top:20px;"><a class="tcqr_aq" href="javascript:void(0);" onclick="_updateMobile('tanchu', 'updateMobile_1', 6,'updateMobile_new_mobile','updateMobile_new_yzm')">确认</a>
  <a class="tcgb2" href="javascript:void(0);" onclick="_closePubDialog('tanchu', 'updateMobile_1', 6);" >【关闭】</a>
  </p>  
</div>
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
	<!-- footer end -->
</body>
</html>