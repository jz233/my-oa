var tree = {
    setting: {
        isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        }
    },
    createTree: function () {
        $.post("menuItemAction_showAllMenuItems.action", null, function (data) {
            $('#tree').zTree(tree.setting, data);
        });
    }
};

// $().ready(function () {
//     tree.createTree();
// });

$().ready(function () {
    $('#tree').dataTree({
        ajax:{
            url: "menuItemAction_showAllMenuItems.action",
            data: null
        },
        setting:{
            treeNodeKey: "mid"
        }

    });
});