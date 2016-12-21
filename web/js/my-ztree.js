var tree = {
    setting: {
        isSimpleData: true,
        treeNodeKey: "id",
        treeNodeParentKey: "pId",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        }
    },
    zNodes: [
        {id: '1', pid: '0', name: 'elder', icon: 'user.gif', isParent: true},
        {id: '2', pid: '1', name: 'clam'},
        {id: '3', pid: '2', name: 'professor'},
        {id: '4', pid: '1', name: 'spice girl'},
        {id: '5', pid: '4', name: 'mr tung'}
    ],

    createTree: function () {
        $('#tree').zTree(tree.setting, tree.zNodes);
    }
};

$().ready(function () {
    // tree.createTree();
    /**
     *  使用封装好的方法创建zTree
     *  dataTree是一个扩展jQuery的插件$.fn.dataTree
     */
    $('#tree').dataTree();
});