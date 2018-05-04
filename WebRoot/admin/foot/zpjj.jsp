<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<style>
html #hm_t_undefined .hm-t-go-top {position:fixed;right:2px;bottom:2px;z-index:99998;cursor:pointer;width:40px;height:37px!important;text-align:center;white-space:normal;font-size:14px;line-height:17px;padding-top:3px;color:#fff;background:#404040;background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEkAAAAXCAYAAABH92JbAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDowMjgwMTE3NDA3MjA2ODExODA4M0UyNDA4ODdDRTZBQiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpBQjc5RkRFNkI5ODMxMUUzQkZGNDhENEJFQjM2OTcyRiIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpBQjc5RkRFNUI5ODMxMUUzQkZGNDhENEJFQjM2OTcyRiIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRvc2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MDI4MDExNzQwNzIwNjgxMTgwODNFMjQwODg3Q0U2QUIiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6MDI4MDExNzQwNzIwNjgxMTgwODNFMjQwODg3Q0U2QUIiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5HPYM5AAACC0lEQVR42uyZTSgEYRjH90NoqaVcpDblvKW2XOSkNh8H5Yac9sBBDqQokiJKSMpNTi5OPo6Ktsgu67JcUHIXWfK1u3b8Xx6Zxuzu+64dM83uv34zNfu8b8/8Z+d5P8YqSZLFJNLsRmyWvIRMKgVD4AhEwA3YAV0pzGwEqyAEwmAddIICHe7FqhnsdQM14FxKLj+ooFiGE2ykiD8GVbJ4I1ELAnTmasMODnAhpVcIFIMicMgRH6Z4IxnUAh4pP3Zu5TVpUOLXDJgWiB8wkEF9IK7IL07X05oUFLjpZ4JXQQOYYwfzafJcoDjVPqw43KE4lWtUTF+AQ8eBqQSsgTaO2E0apJ7URrdCDZOM62hQJfBzGmShOD+1+2XSiYaJ7utkkBsEgEewnYfauZUmzWmU6DuY0sEgLzgArgzbu6i992cu/1WclqXsa1iHIt0DYlnKP0b9fRZu5pWdZs7dWXqa7B80+s//oF5aMSjflGqBPq5BQnFtVv4UmGHjIPEH96PAZ6C5kVMwf6daPzbFKnqCqvx9Bk/yFjSBFTMvcL+1DerAmUA/p9Rm1+y7AHJdgnqwx9EHm1s0gKtc2CpR6gE00/ZHMm3RKxbJlf0kNb2BDrCk8hsbDdvBay5tuiUTGxL7waTs2iLw0YTR9BLZQRwDUVqwjuTS9q3VRB8C1OQUnM6UqdXX/IcADn0IMADs2AqDOPSutQAAAABJRU5ErkJggg==) no-repeat -42px center #666;*background-image:url(http://ecma.bdimg.com/holmes/t-popup-icons-png8.png);_position:absolute;_top:expression(eval(document.documentElement.scrollTop+(document.documentElement.clientHeight||document.body.clientHeight)-this.offsetHeight-2));}
.STYLE3 {
	font-size: 18px;
	font-weight: bold;
	color: #000000;
	line-height: 15px;
}
.STYLE5 {color: #333333; font-weight: bold; }
.STYLE9 {font-size: 5px; color: #666666; }
.STYLE12 {font-family: "微软雅黑"; font-size: 20px;}
</style>
<table border="0">
  <tr>
    <td>
    <div><img src="http://www.qlqpw.net/${zpCompany.imageSrc}" align="left" width="287" height="218" style="margin-right:10px;"/><h3 align="center" style="size: 290px;">泉利置业有限公司简介</h3>
    		  <p>
    		  	${zpCompany.companyMessage}
			  </p>
    </div>
   </td>
    </tr>
</table>
<p class="STYLE3">&nbsp;</p>
<p class="STYLE3">&nbsp;</p>
<table width="900" border="0" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC" bgcolor="#FFFFFF" >
  <tr>
    <td width="15%" height="40" align="center" valign="middle" bordercolor="#666666" bgcolor="#F5F5F5"><span class="STYLE5">最新职位</span></td>
    <td width="20%" height="40" align="center" valign="middle" bordercolor="#666666" bgcolor="#F5F5F5"><span class="STYLE5">工作地点</span></td>
    <td width="5%" height="40" align="center" valign="middle" bordercolor="#666666" bgcolor="#F5F5F5"><span class="STYLE5">人数</span></td>
    <td width="5%" height="40" align="center" valign="middle" bordercolor="#666666" bgcolor="#F5F5F5"><span class="STYLE5">发布日期</span></td>
    <td width="5%" height="40" align="center" valign="middle" bordercolor="#666666" bgcolor="#F5F5F5"><span class="STYLE5">详情</span></td>
  </tr>
  <s:iterator value="zpList" var="zpMessage">
  	<tr>
    <td width="10%" height="30" align="center" valign="middle" bordercolor="#666666" bgcolor="#FFFFFF">${zpPosition}</td>
    <td width="10%" height="30" align="center" valign="middle" bordercolor="#666666" bgcolor="#FFFFFF">${workPlace}</td>
    <td width="10%" height="30" align="center" valign="middle" bordercolor="#666666" bgcolor="#FFFFFF">${peopleNum}</td>
    <td width="10%" height="30" align="center" valign="middle" bordercolor="#666666" bgcolor="#FFFFFF"><s:date name="deliverTime" format="yyyy-MM-dd" /></td>
    <td width="10%" height="40" align="center" valign="middle" bordercolor="#666666" bgcolor="#FFFFFF"><a target="_blank"  href="zpmessage!gainZpMessage.action?zpId=${id}">详情</a></td>
  </tr>
  </s:iterator>
  
 
</table>