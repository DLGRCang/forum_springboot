/**
 * 
 */

var editorObjectArr = {};

window.wangEditor.fullscreen = {

	// editor create之后调用
	init: function(editorSelector, editorObject){
		editorObject.customConfig.uploadImgHooks = {
			fail: function (xhr, editor, result) {
				top.dialog.msg('系统错误，图片上传失败');
			},
			error: function (xhr, editor) {
				top.dialog.msg('网络异常');
			},
			timeout: function (xhr, editor) {
				top.dialog.msg('网络请求超时');
			},
			customInsert: function (insertImg, result, editor) {
				console.log(result);
				var url = 'http://192.168.0.104:8082/news/' + result.data[0];
				insertImg(url);
			}
		};
		editorObject.create();
		$(editorSelector + " .w-e-toolbar").append('<div class="w-e-menu"><a class="_wangEditor_btn_fullscreen" href="javascript:window.wangEditor.fullscreen.toggleFullscreen(\'' + editorSelector + '\')">全屏</a></div>');
		$(editorSelector + " .w-e-toolbar").append('<div class="w-e-menu"><a class="_wangEditor_btn_preview" href="javascript:window.wangEditor.fullscreen.preview(\'' + editorSelector + '\')">预览</a></div>');
		editorObjectArr[editorSelector] = editorObject;
		},
	toggleFullscreen: function(editorSelector){
		$(editorSelector).toggleClass('fullscreen-editor');
		if($(editorSelector + ' ._wangEditor_btn_fullscreen').text() == '全屏'){
			$(editorSelector + ' ._wangEditor_btn_fullscreen').text('退出全屏');
		}else{
			$(editorSelector + ' ._wangEditor_btn_fullscreen').text('全屏');
		}
	},
	preview: function(editorSelector){
		var html = editorObjectArr[editorSelector].txt.html();
		var layIndex = layer.open({//layui的弹出层直接把获取到的编辑器html内容放到里面就可以显示
			title: '效果预览',
			btn: ['关闭预览'],
			content: html//通过编辑器的监听onchange事件把编辑器内容放到id为bBody的input里
		});
		layer.full(layIndex);
	}
};