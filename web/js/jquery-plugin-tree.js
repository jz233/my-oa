(function ($) {
    $.fn.dataTree = function (config) {
        var me = this;

        var param = {
            setting:{}
        };
        /*
            先config.setting覆盖defaults, 然后再将覆盖过后的defaults复制给param
            (config.setting中有treeNodeKey)
         */
        $.extend(param.setting, $(this).dataTree.defaults.setting, config.setting);

        $.post(config.ajax.url, config.ajax.data, function (data) {
            me.zTree(param.setting, data);
        });
    };
    $.fn.dataTree.defaults = {
        setting: {
            isSimpleData: true,
            treeNodeKey: "id",
            treeNodeParentKey: "pid",
            showLine: true,
            root: {
                isRoot: true,
                nodes: []
            }
        }
    }

})($);

