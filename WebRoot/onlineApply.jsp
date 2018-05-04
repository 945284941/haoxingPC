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
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>中国重配第一展-我要报名</title>
<link href="css/exhibition.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="js/regions.js" type="text/javascript"></script>
<script src="js/zhbm.js" type="text/javascript"></script>
<script type="text/javascript">
</script>
</head>

<body>
<!-- 代码 开始 -->
<div class="Statictop" id="hotpic">
    <div id="NewsPic">
        <img width="1000px" height="400px" src="images/exhibition/bannerny.jpg" class="Picture" alt="中国重配第一展"  />
    </div>
</div>
    <!-- 代码 结束 -->
<div class="Staticzong">
<div class="Staticmain">
   
   <div class="registration">
   <form id="onlineApplyForm" name="onlineApplyForm">
      <div class="wybmregistration"><img src="images/exhibition/wybm.gif"/></div>
<div class="hybdaa">
              <span class="jz dlnc">报名类型：</span>
              <div class="dlwbk">                
                <s:select cssClass="wzqyklx" list="#{1:'我要参展',2:'我要观展',3:'2014中国重配行业国际贸易峰会'}" headerKey="0" headerValue="选择报名类型" theme="simple" id="wybm_applyType" name="exhibitionApply.applyType"></s:select>
           </div>
              <span class="btx">*</span>
         </div>
<div class="hybdaa">
              <span class="jz dlnc">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
              <div class="dlwbk">
              <input class="dlwbbk" type="text" name="exhibitionApply.name" id="wybm_name" maxlength="25"/>
              </div>
              <span class="btx">*</span>              
      </div>
         <div class="hybdaaqy">
              <span class="jz dlnc">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区：</span>
              <div class="dlwbk">                
				<s:select cssClass="wzqyk" id="wybm_province"
					name="exhibitionApply.province" headerKey="0" headerValue="-选择省-"
					list="provinceList" listKey="id" listValue="name" theme="simple"
					onchange="_getCitys(this.value,'wybm_city','wybm_area')"></s:select>                
             </div>
           <div class="dlwbk xzs">                
                <select class="wzqyk" id="wybm_city" name="exhibitionApply.city" onchange="_getAreas(this.value,'wybm_area')">
                  <option value="0">-选择市-</option>
                </select>
           </div>
        <div class="dlwbk xzs">                
                <select class="wzqyk" id="wybm_area" name="exhibitionApply.area">
                  <option value="0">-选择区-</option>
                </select>
           </div>
              <span class="btx">*</span>             
         </div>
         <div class="hybdaa">
           <span class="jz dlnc">街道地址：</span>
              <div class="dlwbk">
              <input class="dlwbbk" type="text" name="exhibitionApply.address" id="wybm_address" maxlength="100"/>
              </div>
              <span class="btx">*</span>              
         </div>
         <div class="hybdaa">
              <span class="jz dlnc">公司名称：</span>
              <div class="dlwbk">
              <input class="dlwbbk" type="text" name="exhibitionApply.companyName" id="companyName" maxlength="25"/>
              </div>             
         </div> 
         <div class="hybdaa">
              <span class="jz dlnc">报名人数：</span>
              <div class="dlwbk">
              <input class="dlwbbk" type="text" name="exhibitionApply.enrollment" id="wybm_enrollment" maxlength="10"/>
              </div>             
         </div>
         <div class="hybdaa">
              <span class="jz dlnc">联系方式：</span>
              <div class="dlwbk">
              <input class="dlwbbk" type="text" name="exhibitionApply.contact" id="wybm_contact" maxlength="50"/>
              </div>             
         </div>
         <div class="hybdaa">
              <span class="jz dlnc">经营范围：</span>
              <div class="dlwbk">
              <input class="dlwbbk" type="text" name="exhibitionApply.businessScope" id="businessScope" maxlength="250"/>
              </div>             
         </div>
         <div class="hybdaa">
           <span class="jz dlnc">电子邮箱：</span>
              <div class="dlwbk">
              <input class="dlwbbk" type="text" name="exhibitionApply.email" id="wybm_email" maxlength="50"/>
              </div>             
         </div>
         <div class="tjan"><a href="javascript:void(0);" onclick="onlineApplyFormSubmit()"><img src="images/exhibition/tjan.gif"/></a></div>  
    </form>
    </div>
   <div class="footer">版权所有： 山东泉利置业有限公司<br /> 
济南德睿东方商业管理有限公司 鲁ICP备13009108<br />
技术支持：济南德睿东方商业管理有限公司<br />
公司地址：山东省济南市天桥区二环北路8号</div>
</div>
   
</div>

</body>
</html>
