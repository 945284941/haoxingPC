<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta content="IE=11.0000" http-equiv="X-UA-Compatible">
    <title>颐佳超市</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../../admin/common/keyWords.jsp"></jsp:include>
    <script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../../js/webuploader-0.1.5/webuploader.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../js/webuploader-0.1.5/webuploader.css">
    <link rel="stylesheet" type="text/css" href="../../js/webuploader-0.1.5/style.css">
</head>

<body>
<s:action name="common!toHead" executeResult="true" namespace="/"></s:action>
<s:action name="common!toLogo" executeResult="true" namespace="/"></s:action>
<s:action name="catalogueAction!queryFullCategory" executeResult="true" namespace="/" >
    <s:param name="catType">tdd</s:param>
</s:action>

<!-- 导航结束 -->

<div class="main">
    <div class="lh_fbqg"><img src="images/lh_fbqg.png"/></div>
    <div class="lh_fbqg_wbk">
        <form id="addForm" action="addWantBuy.html" enctype="multipart/form-data" method="post">
            <input type="hidden" id="picArry" name="wantBuy.picArry"/>
            <input type="hidden" id="buyType" name="wantBuy.buyType" value="4">
            <ul>
                <li>
                    <span>娱乐标题</span>
                    <input type="text" name="wantBuy.title" id="title"  />
                </li>
                <li>
                    <span>发布国家</span>
                    <select id="fromCountryId" name="wantBuy.fromCountryId">
                        <c:forEach items="${fromCountryList}" var="country" varStatus="status">
                            <option  value="${country.id}">
                                <c:if test="${'zh' eq sessionInfo.language}">
                                    ${country.name}
                                </c:if>
                                <c:if test="${'zh' ne sessionInfo.language}">
                                    ${country.nameEng}
                                </c:if>
                            </option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <span>娱乐内容</span>
                    <textarea name="wantBuy.content" cols="50" rows="4" id="content"></textarea>
                </li>
                <li>
                    <span>相关图片</span>
                    <div class="lh_fbqg_wbk_sc">
                        <div id="filelist" class="uploader-list">
                            <div>
                                <div id="filePicker" style="margin-top:15px;">选择图片</div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
            <button id="btnSubmit" type="button" onclick="subQg();" class="lx_btn02">发布</button>
        </form>
    </div>
</div>
<!--footer开始-->
<s:action name="indexFloorAction!showFoot" namespace="/indexFloor" executeResult="true"></s:action>
<!--footer结束-->
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
                multiple:true
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
            var $li = $(
                            '<div id="' + file.id + '" class="file-item thumbnail">' +
                            '<img name="file" >' +
                            '<div class="info">' + file.name + '</div>' +
                            '</div>'
                    ),
                    $img = $li.find('img');
            $list.append( $li );
            uploader.makeThumb( file, function( error, src ) {
                if ( error ) {
                    $img.replaceWith('<span>不能预览</span>');
                    return;
                }
                $img.attr( 'src', src );
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
            picUrls.push(response.src);
            $("#picArry").val(picUrls);
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


    function subQg() {
        var title = $('#title').val();
        if (title == '' || title == null) {
            alert('请输入求购标题！');
            return false;
        }
        $.ajax( {
            url : 'addWantBuy.html',
            type : 'POST',
            data : $('#addForm').serialize(),
            success : function(data) {
                var msg = $.parseJSON(data);
                if (msg == 'success') {
                    window.location.href="toWantBuy.html?wantBuy.buyType=4";
                    return true;
                }else{
                    alert("添加失败");
                    return false;
                }
            }
        });
    }
</script>
</body>
</html>