/**
 * Created by Administrator on 2017/8/30.
 */
// 文件上传
$(function() {
        var $list1 = $('#thelist');
        var $btn1 = $('#ctlBtn');
        var $btn = $('#btnSubmit');
        var state1 = 'pending';
        var uploader1 = "";

    uploader1 = WebUploader.create({
        // 不压缩image
        auto: true,
        resize: false,
        // swf文件路径
        swf: swfUrl,
        // 文件接收服务端。
        server: uploadFileUrl,
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker',
        method:'POST'
    });

    // 当有文件添加进来的时候
    uploader1.on( 'fileQueued', function( file ) {
        $("#btnSubmit").attr("disabled",true);
        $list1.append( '<div id="' + file.id + '" class="item">' +
            '<h4 class="info">' + file.name + '</h4>' +
            '<p class="state">等待上传...</p>' +
            '</div>' );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader1.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress .progress-bar');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<div class="progress progress-striped active">' +
                '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                '</div>' +
                '</div>').appendTo( $li ).find('.progress-bar');
        }

        $li.find('p.state').text('上传中');

        $percent.css( 'width', percentage * 100 + '%' );
    });

    uploader1.on( 'uploadSuccess', function( file,response ) {
        $( '#'+file.id ).find('p.state').text('已准备');
        fileNum = fileNum + 1;
        fileIndexNum = fileNum - 1;
        // fileUrls.push(response.src);
        // $("#actFileList").val(fileUrls);
        $("#addFile").append("<input id=actPicObjList["+fileIndexNum+"].imgUrl' name='actPicObjList["+fileIndexNum+"].imgUrl' value='"+response.src+"' />");
        $("#addFile").append("<input id=actPicObjList["+fileIndexNum+"].fileName' name='actPicObjList["+fileIndexNum+"].fileName' value='"+response.fileName+"' />");
        if(fileNum === $(".item").length && num === $(".thumbnail").length){
            $("#btnSubmit").attr("disabled",false);
        }

    });

    uploader1.on( 'uploadError', function( file ) {
        $( '#'+file.id ).find('p.state').text('上传出错');
    });

    uploader1.on( 'uploadComplete', function( file ) {

        $( '#'+file.id ).find('.progress').fadeOut();
    });

    uploader1.on( 'all', function( type ) {
        if ( type === 'startUpload' ) {
            state1 = 'uploading';
        } else if ( type === 'stopUpload' ) {
            state1 = 'paused';
        } else if ( type === 'uploadFinished' ) {
            state1 = 'done';
            $("#btnSubmit").attr("disabled",false);
        }

        if ( state1 === 'uploading' ) {
            $btn1.text('暂停上传');
        } else {
            $btn1.text('开始上传');
        }
    });

    // $btn.on( 'click', function() {
    //     $("#inputForm").attr("action",saveImg);
    //     $("#inputForm").submit();
    //     // if ( state1 === 'uploading' ) {
    //     //     uploader1.stop();
    //     // }else {
    //     //     uploader1.upload();
    //     // }
    // });
});

