/**
 * 点击"删除"时弹出确认框
 */
(function ($) {
    $.zjjConfirm = function () {
        $.each($("a"), function () {
            //遍历每一个超链接，看是否有删除
            if($(this).text() == '删除') {
                $(this).click(function () {
                    if(window.confirm("您确认要删除吗")) {
                        return true;
                    }else{
                        return false;
                    }
                });
            }
        });
    }
})($);