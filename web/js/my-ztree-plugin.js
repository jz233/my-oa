(function ($) {
    //dataTree是个对象
    $.fn.dataTree = function () {
        var param = {};
        //后者内容复制到param变量中
        $.extend(param, $(this).dataTree.defaultTree || {});

        //this代表调用dataTree方法的对象自身
        $(this).zTree(param.setting, param.zNodes);
    }
    //defaultTree看作是dataTree的一个属性
    $.fn.dataTree.defaultTree = {
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
        ]
    }
})($);

