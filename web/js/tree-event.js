var tree = {
    zTreePlugin: '', //运行zTree()后的返回值(zTree引用)
    setting: {
        isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        },

        //加载子树的callback对象
        callback:{
            expand: function (event, treeId, treeNode) {
                tree.loadSubNodes(event, treeId, treeNode);
            }
        }
    },
    createTree: function () {
        $.post("menuItemAction_showMenuItemsByPid.action", {
            pid: 0
        },function (data) {
            tree.zTreePlugin = $('#tree').zTree(tree.setting, data);
        });
    },

    loadSubNodes: function (event, treeId, treeNode) {
        //判断点击的节点下有没有子节点, 有则请求并显示
        if(!tree.zTreePlugin.getNodeByParam("pid", treeNode.mid)) {
            $.post("menuItemAction_showMenuItemsByPid.action", {
                pid: treeNode.mid
            }, function (data) {
                //子树追加到父节点上
                tree.zTreePlugin.addNodes(treeNode, data, true);
            });
        }
    }
};

$().ready(function () {
    tree.createTree();
});