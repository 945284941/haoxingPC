/*
Copyright 2013, KISSY UI Library v1.31
MIT Licensed
build time: Aug 15 16:16
*/
/**
 * backColor button.
 * @author yiminghe@gmail.com
 */
KISSY.add("editor/plugin/back-color/index", function (S, Editor, Button, cmd) {

    function backColor(config) {
        this.config = config || {};
    }

    S.augment(backColor, {
        pluginRenderUI: function (editor) {
            cmd.init(editor);
            Button.init(editor, {
                defaultColor: 'rgb(255, 217, 102)',
                cmdType: "backColor",
                tooltip: "背景颜色"
            });
        }
    });

    return backColor;

}, {
    requires: ['editor', '../color/btn', './cmd']
});