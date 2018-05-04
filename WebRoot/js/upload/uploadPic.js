/**
 * Created by Administrator on 2017/8/31.
 */
jQuery(function () {
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