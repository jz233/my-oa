<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/common/common.jsp" %>
<html>
<head>
    <title>岗位列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/>
            岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">

        <!-- 表头-->
        <thead>
        <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            <td width="200px">岗位名称</td>
            <td width="300px">岗位说明</td>
            <td>相关操作</td>
        </tr>
        </thead>

        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">
        <s:iterator value="#roles">
            <tr class="TableDetail1 template">
                <td><s:property value="name"/></td>
                <td><s:property value="description"/></td>
                <td>
                    <%--<a onClick="return delConfirm()" href="list.html">删除</a>--%>
                    <%--<a href="saveUI.html">修改</a>--%>
                    <s:a action="roleAction_updateUI?rid=%{rid}">修改</s:a>
                    <s:a action="roleAction_delete?rid=%{rid}">删除</s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="roleAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png"/></a>
        </div>
    </div>
</div>
</body>
</html>

