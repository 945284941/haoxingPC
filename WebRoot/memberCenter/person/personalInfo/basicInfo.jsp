<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/page-pagination.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<%--<script language="JavaScript" type="text/JavaScript">
    $(function(){
      var glbCount = parseInt($('#glbCount').text());
      var isVIP = $('#isVip').val();
      if(isVIP==0){
          $('.toVipMsg').show();
      }else{
          $('.toVipMsg').hide();
      }

      $('#dh-edu-count').keyup(function(){
          validDHForm();
      })

      if(isVIP==0){
          $('#memberType').text('普通会员').addClass('text-primary');
      }else if(isVIP == '82ee892375df4c1e98a3d8c9fd6e7612'){
          $('#memberType').text('VIP会员').addClass('text-warning');
      }else if(isVIP == '1b2a989062f24d6faa21db437379139a'){
          $('#memberType').text('县级分销商').addClass('text-info');
      }else if(isVIP == '2237747a89ab45c29a87ea294fce7963'){
          $('#memberType').text('省级分销商').addClass('text-info');
      }else if(isVIP == 'a3f5091e036743f2950c010f1e90a023'){
          $('#memberType').text('市级分销商').addClass('text-info');
      }else if(isVIP == 'ef4bf6acb3404c54b44e4e65e234c20a'){
          $('#memberType').text('社区分销商').addClass('text-info');
      }else{
      $('#memberType').text('未获取到');
      }
      $('#toVipBtn').click(function(){
      if(glbCount>=998){
       layer.confirm('升级VIP将扣除您998的粮票，您确认要继续操作吗？',{icon:0},function(index){
       //ajax处理数据，粮票减少998，增加VIP状态
               var success = true;//接受返回的处理数据
               $.ajax({
                   url : "person/personalInfo!shengjivip.action?member.id=",
                   type : "post",
                   dataType: "json",
                   async: false,
                   success : function(result){
                    if(result.success){
                        layer.alert(result.msg,{icon:1},function(i2){
                                $('#glbCount').text(glbCount-998);
                             layer.close(i2);
                             layer.close(index);
                             window.location.reload();
                        });
                    }else{
                    layer.alert('对不起，升级VIP会员失败！',{icon:2},function(i2){
                             layer.close(i2);
                             layer.close(index);
                        });
                    }
                   }
               });

       });
      }else{
      layer.alert('您的粮票不足998，不能进行升级服务，请及时获取粮票！',{icon:2});
      }

      });
    })
    var txlayer;
    function tixian(){
        var xjcount = parseInt($('#xjCount').text());
        if(xjcount <= 0){
            layer.alert('您当前现金余额为小于0，无法兑米！',{icon:0,closeBtn:2});
        }else{
            var mincount = parseInt($('#xjMinCount').attr('val'))*100;
            var maxcount = parseInt($('#xjMaxCount').attr('val'))*100;
            $('.txmincountText').text(mincount);
            $('.txmaxcountText').text(maxcount);
            txlayer = layer.open({
                type: 1,
                closeBtn :2,
                title:'金米兑米',
                area: ['420px', '280px'],
                content: $('#mc-tixian')
            });
        }

    }
    function validTXForm(){
        var xjcount = parseInt($('#xjCount').text());
        var me = $('#tx-edu-count'),meval = me.val();
          var pattern =/^[1-9][0-9]*$/;
          if(!pattern.test(meval)  || parseInt(meval)==0){
              var formGroup = $('#tixianForm .dhedu-group');
              if(formGroup.hasClass('has-success')) formGroup.removeClass('has-success');
              if(!formGroup.hasClass('has-error')) formGroup.addClass('has-error');
              $('#tixianForm input[name=isValid]').val(0);
              $('#tixianForm .help-block').text('请输入非零的正整数！');
          }else if(parseInt(meval)<parseInt($('#xjMinCount').attr('val'))){
              var formGroup = $('#tixianForm .dhedu-group');
              if(formGroup.hasClass('has-success')) formGroup.removeClass('has-success');
              if(!formGroup.hasClass('has-error')) formGroup.addClass('has-error');
              $('#tixianForm input[name=isValid]').val(0);
              $('#tixianForm .help-block').text('您输入的数值低于交易最小值！');
          }else if(parseInt(meval)*100>xjcount){
              var formGroup = $('#tixianForm .dhedu-group');
              if(formGroup.hasClass('has-success')) formGroup.removeClass('has-success');
              if(!formGroup.hasClass('has-error')) formGroup.addClass('has-error');
              $('#tixianForm input[name=isValid]').val(0);
              $('#tixianForm .help-block').text('您余额不足！');
          }else if(parseInt(meval)>parseInt($('#xjMaxCount').attr('val'))){
              var formGroup = $('#tixianForm .dhedu-group');
              if(formGroup.hasClass('has-success')) formGroup.removeClass('has-success');
              if(!formGroup.hasClass('has-error')) formGroup.addClass('has-error');
              $('#tixianForm input[name=isValid]').val(0);
              $('#tixianForm .help-block').text('您输入的数值超过了交易最大值！');
          }else{
              var formGroup = $('#tixianForm .dhedu-group');
              if(!formGroup.hasClass('has-success')) formGroup.addClass('has-success');
              if(formGroup.hasClass('has-error')) formGroup.removeClass('has-error');
              $('#tixianForm input[name=isValid]').val(1);
              $('#tixianForm .help-block').text('');
          }
    }

    // 兑米提交
    function submitTXFn(){
         validTXForm();
         var isValid = $('#tixianForm input[name=isValid]').val();
         console.log(isValid);
         if(isValid == '1'){
          //校验成功，可直接提交
           dhcount = $('#tx-edu-count').val();
           var url;//后台接口，处理action
           url="person/personalInfo!tixian.action";
           $("#sendsc").replaceWith("<a class='btn btn-primary-2' disabled><span id='sendwaiting2'>请稍后</span></a>");
           $.post(url,{maxPoint:dhcount},function(resp){
               resp = eval('('+resp+')');
                  if(resp.success){
                      if(txlayer) layer.close(txlayer);
                      layer.alert(resp.msg,{icon:1},function(index){
                          layer.close(index);
                          window.location.reload();
                      });
                  }else{
                      if(txlayer) layer.close(txlayer);
                      layer.alert('对不起，操作失败!请刷新重试，如有疑问请联系客服人员！',{icon:2},function(index){
                          layer.close(index);
                          window.location.reload();
                      });
                  }
              });
         }
    }

    function validDHForm(){
        var me = $('#dh-edu-count'),meval = me.val();
          var pattern =/^\d+([.]\d{1})?$/;
          if(!pattern.test(meval)  || parseInt(meval)==0){
              var formGroup = $('#duihuanForm .dhedu-group');
              if(formGroup.hasClass('has-success')) formGroup.removeClass('has-success');
              if(!formGroup.hasClass('has-error')) formGroup.addClass('has-error');
              $('#duihuanForm input[name=isValid]').val(0);
              $('#duihuanForm .help-block').text('请输入非零的合法数值,允许小数点后有一位数字！');
          }else if(parseInt(meval)>parseInt($('#duihuanForm input[name=duihuan-preCount]').val())){
              var formGroup = $('#duihuanForm .dhedu-group');
              if(formGroup.hasClass('has-success')) formGroup.removeClass('has-success');
              if(!formGroup.hasClass('has-error')) formGroup.addClass('has-error');
              $('#duihuanForm input[name=isValid]').val(0);
              $('#duihuanForm .help-block').text('您输入的数值超过了当前拥有的数量！');
          }else{
              var formGroup = $('#duihuanForm .dhedu-group');
              if(!formGroup.hasClass('has-success')) formGroup.addClass('has-success');
              if(formGroup.hasClass('has-error')) formGroup.removeClass('has-error');
              $('#duihuanForm input[name=isValid]').val(1);
              $('#duihuanForm .help-block').text('');
          }
    }

    var duihuanlayer;
    function duihuanFn(type){
        var dhobj = $('#mc-duihuan'),
        glb2jf = $('#mc-duihuan input[name=glb2jf]'),
        jf2glb = $('#mc-duihuan input[name=jf2glb]'),
        dhcount=$('#mc-duihuan input[name=duihuan-preCount]');
        if(type==1){
            glb2jf.val(1);
            jf2glb.val(0);
            dhcount.val($('#glbCount').text());
            $('#mc-duihuan .duihuanTip').text('将金米兑换成经验值');
        }else{
            glb2jf.val(0);
            jf2glb.val(1);
            dhcount.val($('#jfCount').text());
            $('#mc-duihuan .duihuanTip').text('将金米兑换成惠米');
        }
        duihuanlayer = layer.open({
            type: 1,
            closeBtn :2,
            title:'金米兑换',
            area: ['420px', '280px'],
            content: $('#mc-duihuan')
        })
    }
    function submitDHFn(){
     validDHForm();
     var isValid = $('#duihuanForm input[name=isValid]').val();
     if(isValid == '1'){
      //校验成功，可直接提交
       var glb2jf = $('#mc-duihuan input[name=glb2jf]').val(),
       if2glb = $('#mc-duihuan input[name=jf2glb]').val(),
       dhcount = $('#dh-edu-count').val();
       var url;//后台接口，处理action
       var dhtype;
       if(glb2jf=='1'){
          dhtype = 1;
       }
       if(if2glb=='1'){
             dhtype = 2;
       }
       url="person/personalInfo!duihuan.action";
       $.post(url,{dhcount:dhcount,dhtype:dhtype},function(resp){
           resp = eval('('+resp+')');
              if(resp.success){
                  if(duihuanlayer) layer.close(duihuanlayer);
                  layer.alert('您已成功完成兑换！',{icon:1},function(index){
                      layer.close(index);
                      window.location.reload();
                  });
              }else{
                  if(duihuanlayer) layer.close(duihuanlayer);
                  layer.alert('对不起，操作失败!请刷新重试，如有疑问请联系我们客服人员！',{icon:2},function(index){
                      layer.close(index);
                      window.location.reload();
                  });
              }
          });
     }
    }

        function showElement(elementId) {
            document.getElementById(elementId).style.display = "block";
        }
        function hideElement(elementId) {
            document.getElementById(elementId).style.display = "none";
        }
    </script>
    <script type="text/javascript">
        var education = '${member.education}';
        var scopes = '${member.scopes}';
        var vocation = '${member.vocation}';
        var jobRole = '${member.jobRole}';--%>

	<%--
        // 个人会员基本信息修改
    function zhuanzhang(){
        var username = $('#username').val();
        var shefenzheng = $('#shefenzheng').val();
        var guliangbi = $("#guliangbi").val();
        var jifen = $("#jifen").val();
        if(username != ''){
        }else{
            $('#username').focus();
            alert('请输入用户名！');
            return false;
        }
        if(shefenzheng != ''){
        }else{
            $('#shefenzheng').focus();
            alert('请输入身份证号码！');
            return false;
        }
        $.ajax({
            url : "person/personalInfo!zhuanzhang.action",
            type : "post",
            async: false,
            data : $("#zhuangzhangform").serialize(),
            success : function(result){
                var rt = $.parseJSON(result);
                if(rt.res == "expiry"){
                    alert(rt.msg);
                    return false;
                }else if(rt.res == "error"){
                    alert(rt.msg);
                    return false;
                }else if(rt.res == "fail"){
                    alert(rt.msg);
                    return false;
                }else{
                    alert(rt.msg);
                    window.location.href = "person/showBasicInfo.html";
                }
            }
        });
    }
     --%>
	<%--
    //发送手机校验码
    function toSendMobileCode2(objId, type, mobileCheck){
        $.ajax({
            url : "person/personalInfo!sendMobileCode.action",
            type : "post",
            data : {
                "mobileCheck" : mobileCheck
            },
            success : function(map){
                var rt = $.parseJSON(map);
                if(rt.success){
                    //alert("发送成功！");
                    //时间倒计时
                    document.getElementById(objId).disabled = true;
                    for(i=1;i<=(wait/1000);i++) {
                        window.setTimeout("doUpdate2(" + i + ",'"+objId+"')", i * 1000);
                    }
                    window.setTimeout("Timer2('"+objId+"')", wait);
                }else{
                    alert("发送失败！");
                }
            }
        });
    }

    //验证手机校验码
    function validateMobileCode2(mobileCode){
        var m_mobile_yzm = $("#"+mobileCode).val();
        if(m_mobile_yzm == ''){
            $('#'+mobileCode).focus();
            alert('请输入您收到的手机验证码！');
            return false;
        }else{
            return true;
        }
    }

    //时间倒计时
    function doUpdate2(num, objId) {
        secs = 120;
        wait = secs * 1000;

       if(num == (wait/1000)) {
           /* document.getElementById(objId).value = "点击发送验证码"; */
           $("#"+objId).text("发送短信");
       } else {
           wut = (wait/1000)-num;
           /* document.getElementById(objId).value = "(" + wut + "秒后)重发验证码"; */
           $("#"+objId).text(wut+"秒后可重发");
       }
    }

    function Timer2(objId) {
        document.getElementById(objId).disabled = false;
    }

    //判断手机验证是否正确
    function checkMobileCode2(mobileCodeId){
        var flag = validateMobileCode2(mobileCodeId);
        if(flag){
            $.ajax({
                url : "person/checkMobile.html",
                type : "post",
                data : {
                    "mobileCode" : $("#mobileCode2").val(),
                },
                success : function(result){
                    var rt = $.parseJSON(result);
                    if(rt.res == "expiry"){
                        alert(rt.msg);
                        return false;
                    }else if(rt.res == "error"){
                        alert(rt.msg);
                        return false;
                    }else if(rt.res == "fail"){
                        alert(rt.msg);
                        return false;
                    }else if(rt.res == "sessionexpiry"){
                        alert(rt.msg);
                        window.location.href = "/index.jsp";
                    }else{
                        //手机验证码通过
                        submitTXFn();
                    }
                }
            });
        }
    }

    </script>--%>


	<!-- 解决IE6不缓存背景图片的问题-->
	<!--[if IE 6]>
	<script type="text/javascript">
		document.execCommand("BackgroundImageCache", false, true);
	</script>
	<![endif]-->
</head>
<body>
<div id="tanchu"></div>
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
						<h3><s:text name="index_0303"/>><s:text name="index_0304"/></h3>
					</div>
				</div>
				<div class="l-fr1 tgar">
					<div class="slideTxtBox">
						<div class="hd">
							<ul>
								<li class="on">
									<a href="/person/toShowBasicInfo.html"><s:text name="index_0036"/></a>
								</li>
								<li>
									<a href="/person/toShowFirstname.html"><s:text name="index_0211"/></a>
								</li>
								<li>
									<a href="/person/toShowImg.html"><s:text name="index_0305"/></a>
								</li>
								<li>
									<a href="/person/toShowMobile.html"><s:text name="index_0306"/></a>
								</li>
								<li>
									<a href="/person/toShowPassword.html"><s:text name="index_0166"/></a>
								</li>
							</ul>
						</div>
						<div class="bd">
							<ul>
								<div class="vip_c1">
									<table width="65%" border="0" cellspacing="0" cellpadding="0">
										<form id="addForm" action="toUpdateBasicInfo.html" enctype="multipart/form-data" method="post">
											<input type="hidden" value="${member.id}" name="member.id" />
											<thead>
											<tr>
												<td class="vip_c12" width="18%"><s:text name="index_0138"/>:</td>
												<td class="vip_c12" width="6%"></td>
												<td width="76%">
													<div class="vip_a13"><input type="text" class="q2" value="${member.truename}" name="member.truename" id="truename"></div>
												</td>
											</tr>

											<tr>
												<td class="vip_c12" width="18%"><s:text name="index_0310"/>:</td>
												<td class="vip_c12" width="6%"></td>
												<td width="76%">
													<div class="vip_a13"><input type="text" class="q2" value="${member.card}" name="member.card" id="card"></div>
												</td>
											</tr>
											<tr>
                                                <td class="vip_c12" width="18%"><s:text name="index_0311"/>：</td>
                                                <td class="vip_c12" width="6%"></td>
                                                <td width="76%">
                                                    <div class="idcard_box">
                                                        <div class="idcard" id="ss0">
															<input type="hidden" id="cardFront" name="member.cardFront">
															<c:if test="${member.cardFront!=null}">
																<img class="acc_imgin" src="${member.cardFront}" id="img0">
															</c:if>
															<c:if test="${member.cardFront==null}">
                                                            <img class="acc_imgin" src="images/ID_card_front.png" id="img0">
															</c:if>
															<div id="filelist" class="uploader-list">
																<div>
																	<div id="filePicker" style="margin-top:15px;">选择图片</div>
																</div>
															</div>
                                                           <%-- <input type="file" name="file0" id="file0" multiple class="ph08" />--%>
                                                        </div>
                                                        <div class="idcard" id="ss1">
															<input type="hidden" id="cardReverse" name="member.cardReverse">
															<c:if test="${member.cardReverse!=null}">
																<img class="acc_imgin" src="${member.cardReverse}" id="img1">
															</c:if>
															<c:if test="${member.cardReverse==null}">
                                                            <img class="acc_imgin" src="images/ID_card_reverse.png" id="img1">
															</c:if>
															<div id="filelist1" class="uploader-list">
																<div>
																	<div id="filePicker1" style="margin-top:15px;">选择图片</div>
																</div>
															</div>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>

											<tr>
												<td class="vip_c12" width="18%"><s:text name="index_0140"/>:</td>
												<td class="vip_c12" width="6%"></td>
												<td width="76%">
													<div class="vip_a13">
														<s:if test="null!=member.gender">
															<s:if test="0==member.gender">
																<input type="radio" id="m_gender" name="member.gender"
																	   class="q3" value="1" /><s:text name="index_0312"/>
																<input type="radio" id="m_gender" name="member.gender"
																	   class="q3" value="0" checked="checked" /><s:text name="index_0313"/>
															</s:if>
															<s:else>
																<input type="radio" id="gender" name="member.gender"
																	   class="q3" value="1" checked="checked" /><s:text name="index_0312"/>
																<input type="radio" id="gender" name="member.gender"
																	   class="q3" value="0" /><s:text name="index_0313"/>
															</s:else>
														</s:if>
														<s:else>
															<input type="radio" id="m_gender" name="member.gender"
																   class="inRadio_blue" value="1" /><s:text name="index_0312"/>
															<input type="radio" id="m_gender" name="member.gender"
																   class="inRadio_blue" value="0" /><s:text name="index_0313"/>
														</s:else>
													</div>
												</td>
											</tr>

											<tr>
												<td class="vip_c12" width="18%"><s:text name="index_0141"/>:</td>
												<td class="vip_c12" width="6%"></td>
												<td width="76%">
													<div class="vip_a13"><input type="text" class="q2" value="${member.age}" name="member.age" id="age"></div>
												</td>
											</tr>

											<tr>
												<td class="vip_c12" width="18%"><s:text name="index_0142"/>:</td>
												<td class="vip_c12" width="6%"></td>
												<td width="76%">
													<div class="vip_a13"><input type="text" class="q2" value="${member.birthday}"  name="member.birthday" id="birthday"></div>
												</td>
											</tr>

											<tr>
												<td class="vip_c12" width="18%">QQ:</td>
												<td class="vip_c12" width="6%"></td>
												<td width="76%">
													<div class="vip_a13"><input type="text" class="q2" value="${member.qq}"  name="member.qq" id="qq"></div>
												</td>
											</tr>

											<tr>
												<td class="vip_c12" width="18%"><s:text name="index_0104"/>:</td>
												<td class="vip_c12" width="6%"></td>
												<td width="76%">
													<div class="vip_a13"><input type="text" class="q2" value="${member.email}"  name="member.email" id="email"></div>
												</td>
											</tr>

											<tr>
												<td class="vip_c12" width="18%"><s:text name="index_0143"/>:</td>
												<td class="vip_c12" width="6%"></td>
												<td width="76%">
													<div class="vip_a13"><input type="text" class="q2" value="${member.weiXin}"  name="member.weiXin" id="weiXin"></div>
												</td>
											</tr>

											<tr>
												<td class="vip_c12" width="18%"><s:text name="index_0144"/>:</td>
												<td class="vip_c12" width="6%"></td>
												<td width="76%">
													<div class="vip_a13"><input type="text" class="q2" value="${member.area}"  name="member.area" id="area"></div>
												</td>
											</tr>

											<tr>
												<td class="vip_c12" width="18%"></td>
												<td class="vip_c12" width="6%"></td>
												<td width="76%">
													<div>
														<input class="btn-danger" onclick="subQg()" type="button" value="<s:text name='index_0309'/>"/>
													</div>
												</td>
											</tr>

											</thead>
										</form>
									</table>

								</div>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--我是买家-->
<jsp:include page="/admin/common/indexFooter.jsp" />
<script type="text/javascript">
    var swfUrl = '../../js/webuploader-0.1.5/Uploader.swf';
    var uploadUrl = 'up!uploadImg.action';
    var num = 0;
    var fileNum = 0;
    var picUrls = [];
    $(function () {
        var uploader="";
        var $list=$("#filelist");
        var $list1=$("#filelist1");
        var thumbnailWidth = 100;
        var thumbnailHeight = 100;
        uploader = WebUploader.create({
            auto: true,
            swf: swfUrl,
            server: uploadUrl,
            pick: {
                id:'#filePicker',
                multiple:false
            },
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            },
            method:'POST'
        });
        // 当有文件添加进来的时候
        uploader.on( 'fileQueued', function( file ) {
            uploader.makeThumb( file, function( error, src ) {
                if ( error ) {
                    return;
                }
                $("#img0").attr("src",src);
            }, thumbnailWidth, thumbnailHeight );
        });

        // 文件上传过程中创建进度条实时显示。
        uploader.on( 'uploadProgress', function( file, percentage ) {
            var $li = $( '#'+file.id ),
                $percent = $li.find('.progress span');
            if ( !$percent.length ) {
                $percent = $('<p class="progress"><span></span></p>')
                    .appendTo( $li )
                    .find('span');
            }
            $percent.css( 'width', percentage * 100 + '%' );
        });

        // 文件上传成功，给item添加成功class, 用样式标记上传成功。
        uploader.on( 'uploadSuccess', function( file,response ) {
            num++;
            indexNum = num - 1;
            $( '#'+file.id ).addClass('upload-state-done');
            //picUrls.push(response.src);
            $("#cardFront").val(response.src);
//            $("#img0").attr("src",response.src);
            // $("#addPic").append("<input id=actpicArry["+indexNum+"]' name='actpicArry["+indexNum+"]' value='"+response.src+"' />");
            //图片已经上传完毕
            if(num === $(".thumbnail").length && fileNum === $(".item").length ){
                $("#btnSubmit").attr("disabled",false);
            }
        });

        // 文件上传失败，现实上传出错。
        uploader.on( 'uploadError', function( file ,response) {

            var $li = $( '#'+file.id ),
                $error = $li.find('div.error');
            if ( !$error.length ) {
                $error = $('<div class="error"></div>').appendTo( $li );
            }
            $error.text('上传失败');
        });

        // 完成上传完了，成功或者失败，先删除进度条。
        uploader.on( 'uploadComplete', function( file ) {
            $( '#'+file.id ).find('.progress').remove()
        });
    });




    $(function () {
        var uploader="";
        var $list=$("#filelist");
        var $list1=$("#filelist1");
        var thumbnailWidth = 100;
        var thumbnailHeight = 100;
        uploader = WebUploader.create({
            auto: true,
            swf: swfUrl,
            server: uploadUrl,
            pick: {
                id:'#filePicker1',
                multiple:false
            },
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            },
            method:'POST'
        });
        // 当有文件添加进来的时候
        uploader.on( 'fileQueued', function( file ) {
            uploader.makeThumb( file, function( error, src ) {
                if ( error ) {
                    return;
                }
                $("#img1").attr("src",src);
            }, thumbnailWidth, thumbnailHeight );
        });

        // 文件上传过程中创建进度条实时显示。
        uploader.on( 'uploadProgress', function( file, percentage ) {
            var $li = $( '#'+file.id ),
                $percent = $li.find('.progress span');
            if ( !$percent.length ) {
                $percent = $('<p class="progress"><span></span></p>')
                    .appendTo( $li )
                    .find('span');
            }
            $percent.css( 'width', percentage * 100 + '%' );
        });

        // 文件上传成功，给item添加成功class, 用样式标记上传成功。
        uploader.on( 'uploadSuccess', function( file,response ) {
            num++;
            indexNum = num - 1;
            $( '#'+file.id ).addClass('upload-state-done');
            $("#cardReverse").val(response.src);
//            $("#img1").attr("src",response.src);
            // $("#addPic").append("<input id=actpicArry["+indexNum+"]' name='actpicArry["+indexNum+"]' value='"+response.src+"' />");
            //图片已经上传完毕
            if(num === $(".thumbnail").length && fileNum === $(".item").length ){
                $("#btnSubmit").attr("disabled",false);
            }
        });

        // 文件上传失败，现实上传出错。
        uploader.on( 'uploadError', function( file ,response) {

            var $li = $( '#'+file.id ),
                $error = $li.find('div.error');
            if ( !$error.length ) {
                $error = $('<div class="error"></div>').appendTo( $li );
            }
            $error.text('上传失败');
        });

        // 完成上传完了，成功或者失败，先删除进度条。
        uploader.on( 'uploadComplete', function( file ) {
            $( '#'+file.id ).find('.progress').remove()
        });
    });



</script>
<script type="text/javascript">
    function subQg() {
        var truename = $('#truename').val();
        var card = $('#card').val();
        var cardFront = $('#cardFront').val();
        var cardReverse = $('#cardReverse').val();
        var gender = $('#gender').val();
        var age = $('#age').val();
        var birthday = $('#birthday').val();
        var mobile = $('#mobile').val();
        var qq = $('#qq').val();
        var email = $('#email').val();
        var area = $('#area').val();
        var weiXin = $('#weiXin').val();

        if (truename == '' || truename == null) {
            alert('<s:text name="index_0327"/>！');
            return false;
        }
        if (card == '' || card == null) {
            alert('<s:text name="index_0328"/>！');
            return false;
        }
		if (age == '' || age == null) {
			 alert('<s:text name="index_03129"/>！');
			 return false;
		 }
        $.ajax( {
            url : '/person/personalInfo!updateBasicInfo.action',
            type : 'POST',
            data : $('#addForm').serialize(),
            success : function(data) {
                var msg = $.parseJSON(data);
                if (msg == 'success') {
                    alert("<s:text name="index_0315"/>！");
                    window.location.href="/person/toShowBasicInfo.html";
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