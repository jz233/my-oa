<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Department</title>
</head>
<body>
    <s:iterator value="departments">
        <s:property value="name"></s:property>
    </s:iterator>

    <s:debug></s:debug>
</body>
</html>
