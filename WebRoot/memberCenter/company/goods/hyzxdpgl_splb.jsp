<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<jsp:include page="/admin/common/keyWords.jsp" />
<title>三古汇官方商城</title>
<link rel="stylesheet" href="css/common.css" type="text/css">
<link href="css/hyzxgr.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<jsp:include page="/js/jquery-easyui-1.3.3/easyuiJs.jsp"></jsp:include>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/JavaScript">
	function marketable(val,id){
		if(id==undefined){
			var s=document.getElementsByName("check");
			var a=0;
			var ids="";
			for( var i=0;i<s.length;i++){
				  if(s[i].checked){
					  ids = ids +","+ s[i].value; 
				  	  a++;
				   }
			}
			if(a<=0){
				alert("请选择需要操作的项目!");
				return ;
			}
			id=ids.substring(1,ids.length);
		}
		$.ajax({
			type:'POST',
	  	  	url:'memberCenter/goods!updateMarketable.action?ids='+id+"&marketable="+val,
	  	  	dataType:'json',
	  	  	success: function(data){
	  	  		var suc="";
	  	  		if(data.ok){
	  	  			var temp=id.split(",");
	  	  			for(i=0;i<temp.length;i++){
	  	  				var mm=temp[i];
		  	  			var html = '';
						if(val=='true'){
							suc="上";
							html = '<a href="javascript:void(0)"  style="color: green;" onclick="marketable(\'false\',\''+mm+'\');">上架</a>';
						}else{
							suc="下";
							html = '<a href="javascript:void(0)"  style="color: red;" onclick="marketable(\'true\',\''+mm+'\');">下架</a>';
						}
						$("#mark_"+mm).html(html);
	  	  			}
					alert('商品修改'+suc+'架成功！');
		  	  	}else{
		  	  		alert("商品修改上下架失败，请稍候再试！");
		  	  	}
			},
			error:function(){
					alert("请求失败!");
			}
		});
	} 
	function submit(){
		$('#searchForm').submit();
	}
	function clear(){
		$('#searchForm input').val('');
		$('#searchForm').submit();
	}
	$(function(){
		
			
	});
		var goodsCatShHasLoad =false;
	function  goodsCatShLoad(){
		goodsCatShHasLoad=true;
		var gcLevel='${goodsCatShTemp.cpLevel}';
		if(gcLevel=='1'){
			$('#shCatId').combotree('setValue','${shCatId}');//配件分类
			var gc=$('#shCatId').combotree('tree').tree('getSelected');//得到改节点
			$('#shCatId').combotree('tree').tree('expandTo',gc.target);//展开该节点
			$('#shCatId').combotree('tree').tree('scrollTo',gc.target);//滚动到该节点
		}else if( gcLevel == '2'){
			var tempfirst='${goodsCatShTemp.cpmap.pid1}';
			var gc=$('#shCatId').combotree('tree').tree('find', tempfirst);
			$('#shCatId').combotree('tree').tree('expand',gc.target);//展开该节点
			$('#shCatId').combotree('setValue','${shCatId}');//配件分类
			var tc=$('#shCatId').combotree('tree').tree('getSelected');
			$('#shCatId').combotree('tree').tree('expandTo',tc.target);
			$('#shCatId').combotree('tree').tree('scrollTo',tc.target);
		}else if(gcLevel =='3'){
			var tempfirst='${goodsCatShTemp.cpmap.pid2}';
			var tempsecond='${goodsCatShTemp.cpmap.pid1}';
			var gc=$('#shCatId').combotree('tree').tree('find', tempfirst);
			$('#shCatId').combotree('tree').tree('expand',gc.target);//展开该节点
			window.setTimeout(function(){
				var sc=$('#shCatId').combotree('tree').tree('find', tempsecond);
				$('#shCatId').combotree('tree').tree('expand',sc.target);
			}, 500);
			window.setTimeout(function(){
				$('#shCatId').combotree('setValue','${shCatId}');//配件分类
				var mc=$('#shCatId').combotree('tree').tree('getSelected');//得到改节点
				$('#shCatId').combotree('tree').tree('expandTo',mc.target);//展开该节点
				$('#shCatId').combotree('tree').tree('scrollTo',mc.target);//滚动到该节点
			}, 500);
		}
	}
	
	
	var goodsCatHasLoad =false;
	function goodsCatLoad(){
		goodsCatHasLoad=true;
		var gcLevel='${goodsCatTemp.cpLevel}';
		if(gcLevel=='1'){
			$('#carPartsId').combotree('setValue','${carPartsId}');//配件分类
			var gc=$('#carPartsId').combotree('tree').tree('getSelected');//得到改节点
			$('#carPartsId').combotree('tree').tree('expandTo',gc.target);//展开该节点
			$('#carPartsId').combotree('tree').tree('scrollTo',gc.target);//滚动到该节点
		}else if( gcLevel == '2'){
			var tempfirst='${goodsCatTemp.cpmap.pid1}';
			var gc=$('#carPartsId').combotree('tree').tree('find', tempfirst);
			$('#carPartsId').combotree('tree').tree('expand',gc.target);//展开该节点
			$('#carPartsId').combotree('setValue','${carPartsId}');//配件分类
			var tc=$('#carPartsId').combotree('tree').tree('getSelected');
			$('#carPartsId').combotree('tree').tree('expandTo',tc.target);
			$('#carPartsId').combotree('tree').tree('scrollTo',tc.target);
		}else if(gcLevel =='3'){
			var tempfirst='${goodsCatTemp.cpmap.pid2}';
			var tempsecond='${goodsCatTemp.cpmap.pid1}';
			var gc=$('#carPartsId').combotree('tree').tree('find', tempfirst);
			$('#carPartsId').combotree('tree').tree('expand',gc.target);//展开该节点
			window.setTimeout(function(){
				var sc=$('#carPartsId').combotree('tree').tree('find', tempsecond);
				$('#carPartsId').combotree('tree').tree('expand',sc.target);
			}, 500);
			window.setTimeout(function(){
				$('#carPartsId').combotree('setValue','${carPartsId}');//配件分类
				var mc=$('#carPartsId').combotree('tree').tree('getSelected');//得到改节点
				$('#carPartsId').combotree('tree').tree('expandTo',mc.target);//展开该节点
				$('#carPartsId').combotree('tree').tree('scrollTo',mc.target);//滚动到该节点
			}, 500);
		}
	}
	
	var carBrandHasLoad =false;
	function carBrandLoad(){
		carBrandHasLoad=true;
		var gcLevel='${carBrandTemp.cpLevel}';
		if(gcLevel=='1'){
			$('#carBrands').combotree('setValue','${carBrand}');//配件分类
			var gc=$('#carBrands').combotree('tree').tree('getSelected');//得到改节点
			$('#carBrands').combotree('tree').tree('expandTo',gc.target);//展开该节点
			$('#carBrands').combotree('tree').tree('scrollTo',gc.target);//滚动到该节点
		}else if( gcLevel == '2'){
			var tempfirst='${carBrandTemp.cpmap.pid1}';
			var gc=$('#carBrands').combotree('tree').tree('find', tempfirst);
			$('#carBrands').combotree('tree').tree('expand',gc.target);//展开该节点
			$('#carBrands').combotree('setValue','${carBrand}');//配件分类
			var tc=$('#carBrands').combotree('tree').tree('getSelected');
			$('#carBrands').combotree('tree').tree('expandTo',tc.target);
			$('#carBrands').combotree('tree').tree('scrollTo',tc.target);
		}else if(gcLevel =='3'){
			var tempfirst='${carBrandTemp.cpmap.pid2}';
			var tempsecond='${carBrandTemp.cpmap.pid1}';
			var gc=$('#carBrands').combotree('tree').tree('find', tempfirst);
			$('#carBrands').combotree('tree').tree('expand',gc.target);//展开该节点
			window.setTimeout(function(){
				var sc=$('#carBrands').combotree('tree').tree('find', tempsecond);
				$('#carBrands').combotree('tree').tree('expand',sc.target);
			}, 500);
			window.setTimeout(function(){
				$('#carBrands').combotree('setValue','${carBrand}');//配件分类
				var mc=$('#carBrands').combotree('tree').tree('getSelected');//得到改节点
				$('#carBrands').combotree('tree').tree('expandTo',mc.target);//展开该节点
				$('#carBrands').combotree('tree').tree('scrollTo',mc.target);//滚动到该节点
			}, 500);
		}
	}
	
	//全选方法，itemName全选的checkbox名称，checkbox为全选的checkbox
	function ff(itemName,checkbox){
	    var checkArray = document.getElementsByName(itemName);
	    var flag = checkbox.checked;
	    for (var i = 0; i < checkArray.length;i++){
	        if (checkArray[i].checked != flag)
	        {
	        	checkArray[i].checked = flag;
	        }
	    }
	}
	function _delete(id){
			if(id==undefined){
				var s=document.getElementsByName("check");
				var a=0;
				var ids="";
				for( var i=0;i<s.length;i++){
					  if(s[i].checked){
						  ids = ids +","+ s[i].value; 
					  	  a++;
					   }
				}
				if(a<=0){
					alert("请选择需要删除的项目!");
					return ;
				}
				ids=ids.substring(1,ids.length);
				if(window.confirm("确定删除?")){
					$.get('memberCenter/goods!delete.action',{"ids":ids},function(data){
						window.location.href="memberCenterGL.html?page="+$('#page').val();
					});
				};
			}else{
				ids=id;
				if(window.confirm("确定删除?")){
					$.get('memberCenter/goods!delete.action',{"ids":ids},function(data){
						if(data){
							window.location.href="memberCenterGL.html?page="+$('#page').val();
						}else{
							alert("删除错误!");
						}
					});
				};
			}
	}
</script>
<!-- 解决IE6不缓存背景图片的问题-->
<!--[if IE 6]>
<script type="text/javascript">
document.execCommand("BackgroundImageCache", false, true);
</script>
<![endif]-->
</head>	
<body>
		<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
		<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
		   <jsp:include page="/admin/common/navigation.jsp" />
	<!-- 头部结束 -->
	<!-- 页脚开始 -->
		<div class="breadThumb">首页 > 企业会员中心 > 电子商城 > 商品管理 > 商品列表</div>
	<div class="gzgz">
		<div class="hyleft">
				<jsp:include page="/memberCenter/common/leftNavigate.jsp"></jsp:include>
		</div>
		<div class="hyright">
			<%-- <div class="righttj">
				<h2>商品统计</h2>
				<div class="xzsd">
					<select id="u42" class="text2">
						<option selected value="请选择时段">请选择时段</option>
						<option value="2010-10">2010-2011</option>
						<option value="2011-2012">2011-2012</option>
						<option value="2010-10">2010-2011</option>
						<option value="2011-2012">2011-2012</option>
						<option value="2010-10">2010-2011</option>
						<option value="2011-2012">2011-2012</option>
					</select> <a class="spck" href="javascript:void(0)">查看</a>
				</div>
				<ul>
					<li><span class="ps">拥有商品品牌数</span><span>120</span>
					</li>
					<li><span class="ps">拥有商品分类数</span><span>11</span>
					</li>
					<li><span class="ps">拥有商品总数</span><span>105</span>
					</li>
					<li><span class="ps">商品上架总数</span><span>100</span>
					</li>
					<li><span class="ps">商品下架总数</span><span>12</span>
					</li>
				</ul>
			</div> --%>

			<p class="hymainbt">
				<span class="grmenubt">商品管理</span><a class="lb" href="javascript:void(0)">发布列表</a><a onclick="loginOrNot('memberCenterGRE.html'); ">回收站</a><a onclick="loginOrNot('memberCenterGA.html'); ">添加商品</a><span class="tjsp">商品列表</span>
			</p>
			<h2 class="cxtj">
				<span>查询条件</span>
			</h2>
			<form id="searchForm" name="searchForm" action="memberCenterGL.html"  method="post">
				<div class="grjbxxt">
					<div class="spitem">
						<span class="labelt">开始时间</span>
						<div class="fb_ftit">
							<div>
							<input id="startTime" name="startTime" type="text"
							class="Wdate" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}',dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<s:date name='startTime' format='yyyy-MM-dd HH:mm:ss'/>"  readonly="readonly"/>
							</div>
						</div>
						<span class="labelt">结束时间</span>
						<div class="fb_ftit">
							<input id="endTime" name="endTime" type="text" readonly="readonly" class="Wdate" onclick="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}',dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<s:date name='endTime' format='yyyy-MM-dd HH:mm:ss'/>" />
						</div>
						<div style="clear:both"></div>
					</div>
					<div class="spitem">
						<span class="labelt">商品编号</span>
						<div class="fb_ft2">
							<div>
								<input type="text" class="text" value="${bn }" name="bn">
							</div>
						</div>
						<span class="labelt">商品分类</span>
						<div class="fb_ft2">
							<select class="text easyui-combotree" name='carPartsId' style="height:26px;" id="carPartsId"  data-options="panelWidth:500,width:150,url:'memberCenter/goods!gainGoodsCatListByPid.action',onBeforeSelect: function(node) {
					            if (!$(this).tree('isLeaf', node.target)) {
					                return false;
					            }
					        },
					        onClick: function(node) {
					            if (!$(this).tree('isLeaf', node.target)) {
					                $('#carPartsId').combotree('showPanel');
					                if(node.state=='open'){
										$('#carPartsId').combotree('tree').tree('collapse',node.target);
									}else{
										$('#carPartsId').combotree('tree').tree('expand',node.target);
									}
					            }
					        },
					        onLoadSuccess:function(){
					        	if(!goodsCatHasLoad){
						        	goodsCatLoad();
					        	}
					        }">
							</select>
						</div>
						<div style="clear:both"></div>
					</div>
					<div class="spitem">
						<span class="labelt">商品名称</span>
						<div class="fb_ft2">
							<div>
								<input type="text" class="text" value="${name }" name="name">
							</div>
						</div>
						<div style="clear:both"></div>
					</div>
					<div class="spitem">
						<span class="labelt">是否上架</span>
						<div class="fb_ft2">
							<select class="text easyui-combobox" style="height:26px;" name="marketable" id="_marketable" data-options="width:70,editable:false,panelHeight:95">
								<option value="">请选择</option>
								<option value="true" <c:if test="${marketable=='true'}">selected="selected"</c:if> >是</option>
								<option value="false"  <c:if test="${marketable=='false'}">selected="selected"</c:if> >否</option>
							</select>
						</div>
					</div>
					<p class="cx">
						<a class="cx2" href="javascript:submit()">查询</a><a class="qk" href="javascript:clear()">清空</a>
					</p>
				</div>
			</form>
			<div class="lbcontant">
				<div class="lbctitle">
					<span>商品编号</span><span>商品名称</span><span style="width:66px;">单价</span><span
						style="width:61px;">商品状态</span><span style="width:51px;">库存</span><span
						style="width:83px;">操作</span>
				</div>

				<c:forEach var="g" items="${goodsList}">
					<div class="zxlb zxlb2">
						<ul>
							<li style="width:15px; height:15px;"><input type="checkbox"
								value="${g.id }" name="check" />
							</li>
							<li class="lbtwo" title="${g.bn }">
							<c:choose>
								<c:when test="${fn:length(g.bn) > 10 }">
									${fn:substring(g.bn, 0, 10)}..
								</c:when>
								<c:otherwise >
									${g.bn}
								</c:otherwise>
							</c:choose></li>
							<li class="lbthree">
							<c:choose>
								<c:when test="${fn:length(g.name) > 10 }">
									${fn:substring(g.name, 0, 10)}..
								</c:when>
								<c:otherwise >
									${g.name}
								</c:otherwise>
							</c:choose></li>
							
							<li class="lbfive">￥${g.price }</li>
							<li class="lbsix" id="mark_${g.id }">
							<c:choose>
								<c:when test="${g.marketable=='true' }"><a onclick="marketable('false','${g.id}');" style="color: green;"
											href="javascript:void(0)">上架</a></c:when>
								<c:otherwise><a onclick="marketable('true','${g.id}');" style="color: red;"
											href="javascript:void(0)">下架</a></c:otherwise>
							</c:choose></li>
							<li class="lbse">
							<c:choose>
								<c:when test="${g.store <=100 }"><span style="color: red;">${g.store }</span></c:when>
								<c:otherwise><span style="color: green;">${g.store }</span></c:otherwise>
							</c:choose></li>
							<li class="lbeight"><a href="javascript:loginOrNot('memberCenterEdit/${g.id }.html')">编辑</a>/<a href="javascript:_delete('${g.id}')">删除</a>
							</li>
						</ul>
						<div style="clear:both"></div>
					</div>
				</c:forEach>
				<div id="showpages">
					<page:pagination path="memberCenterGL.html" formName="searchForm" />
				</div>
			</div>

		</div>
		<div style="clear:both"></div>
	</div>
<!-- <div class="bottom_box_06"><div class="bottom_box_06img"><img src="web/images/zixun/tonglan.png" width="1190" height="118" /></div></div> -->
<!--======================bottom开始============================-->
   <jsp:include page="/admin/common/indexFooter.jsp" />
</body>
</html>