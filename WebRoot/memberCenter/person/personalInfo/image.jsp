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
                                <li>
                                    <a href="/person/toShowBasicInfo.html"><s:text name="index_0036"/></a>
                                </li>
                                <li>
                                    <a href="/person/toShowFirstname.html"><s:text name="index_0211"/></a>
                                </li>
                                <li  class="on">
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
                                        <form id="addForm" >
                                        <input type="hidden" value="${member.id}" name="id" id="id"/>
                                        <input type="hidden" name="img" id="img"/>
                                        </form>
                                        <thead>
                                        <tr>
                                            <td class="vip_c12" width="18%"> &nbsp;</td>
                                            <td class="vip_c12" width="6%"></td>
                                            <td width="76%">
                                                <div class="idcard_box">
                                                    <div class="idcard" id="ss0">
                                                        <img class="acc_imgin" src="${member.img}" id="img0" name="img0">
                                                        <div id="filelist" class="uploader-list">
                                                            <div>
                                                                <div id="filePicker" style="margin-top:15px;">选择图片</div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="vip_c12" width="18%"></td>
                                            <td class="vip_c12" width="6%"></td>
                                            <td width="76%">
                                                <a href="javascript:void(0);">
                                                    <div class="btn-danger" onclick="subQg()">确定</div>
                                                </a>
                                            </td>
                                        </tr>
                                        </thead>

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

</div>
</div>

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

        // 文件上传成功，给item添加成功class, 用样式标记上传成功。s
        uploader.on( 'uploadSuccess', function( file,response ) {
            num++;
            indexNum = num - 1;
            $( '#'+file.id ).addClass('upload-state-done');
            //picUrls.push(response.src);
            $("#img0").attr("src",response.src);
            $("#img").val(response.src);
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
        var id = $('#id').val();
        var img = $('#img').val();
        $.ajax( {
            url : '/person/personalInfo!updateImg.action',
            type : 'POST',
            data : $('#addForm').serialize(),
            success : function(data) {
                var msg = $.parseJSON(data);
                if (msg == 'success') {
                    alert("<s:text name="index_0315"/>");
                    window.location.href="/person/toShowImg.html";
                    return true;
                }else{
                    alert("<s:text name="index_0316"/>");
                    return false;
                }
            }
        });
    }
</script>
</body>
</html>
