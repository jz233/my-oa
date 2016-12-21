<%@ taglib prefix="s" uri="/struts-tags" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
<script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery-plugin-confirm.js"></script>
<script type="text/javascript">
    //页面加载完成即调用
    $().ready(function () {
        $.zjjConfirm();
    });
</script>