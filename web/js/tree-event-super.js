(function ($) {

    /**
     * 1. 一次性创建树 (allLoad)
     * 2. 点击时创建树 (!allLoad)
     * @param config
     */
    $.fn.dataTree = function (config) {
        var me = this;

        var param = {
            treePlugin: '',
            treeObj: me,
            url: '',
            data: '',
            callback: '',
            setting: {},
            allLoad: false
        };
        //第一个boolean参数 是否深层合并(多层json嵌套时使用)
        $.extend(true,param, $(this).dataTree.defaults, config);

        //缓存param变量(以便后面使用)
        me.data("param", param);

        if (param.allLoad) {  //一次性
            $.fn.dataTree.method.loadAllNodes(param);
        }else{
            $.fn.dataTree.method.loadSubNodes(param);
        }
    }

    $.fn.dataTree.defaults = {
        setting: {
            isSimpleData: true,
            treeNodeKey: "id",
            treeNodeParentKey: "pid",
            showLine: true,
            root: {
                isRoot: true,
                nodes: []
            },
            callback:{
                expand: function (event, treeId, treeNode) {
                    //从缓存中取出变量param的内容
                    var param = $('#' + treeId).data('param');
                    param.data.pid = treeNode.mid;
                    $.fn.dataTree.method.loadSubNodes(param, treeNode);
                }
            }
        },
        allLoad: true   //默认情况一次性全部创建
    }

    $.fn.dataTree.method = {
        loadAllNodes: function (config) {
            config.callback = function (data) {
                $(config.treeObj).zTree(config.setting, data);
            }
            $.fn.dataTree.method.loadData(config);
        },
        loadData: function (config) {
            $.post(config.url, config.data, function (data) {
                config.callback(data);
            });
        },

        loadSubNodes: function (config, treeNode) {
            if(config.data.pid ==0) {   //说明要加载根节点
                config.callback = function (data) {
                    config.treePlugin = $(config.treeObj).zTree(config.setting, data);
                }
                $.fn.dataTree.method.loadData(config);
            }else{  //加载子节点
                config.callback = function (data) {
                    //追加到父节点上
                    if(!config.treePlugin.getNodeByParam("pid", treeNode.mid)) {
                        config.treePlugin.addNodes(treeNode, data, true);
                    }
                }
                $.fn.dataTree.method.loadData(config);
            }
        }

    }

})($);

$().ready(function () {
    // $('#tree').dataTree({
    //     url: 'menuItemAction_showAllMenuItems.action',
    //     data: null,
    //     setting: {
    //         treeNodeKey: 'mid'
    //     },
    //     allLoad: true
    // });
    $('#tree').dataTree({
        url: 'menuItemAction_showMenuItemsByPid.action',
        data: {
            pid: 0
        },
        setting: {
            treeNodeKey: 'mid'
        },
        allLoad: false
    });
});
