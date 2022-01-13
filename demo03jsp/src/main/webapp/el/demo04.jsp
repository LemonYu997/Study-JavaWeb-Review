<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1", "pageContext1");
        pageContext.setAttribute("key2", "pageContext2");
        request.setAttribute("key2", "request");
        session.setAttribute("key2", "session");
        application.setAttribute("key2", "application");
    %>
    EL获取四个域中的值： <br>
    ${pageScope.key1} <br>
    ${pageScope.key2} <br>
    ${requestScope.key2} <br>
    ${sessionScope.key2} <br>
    ${applicationScope.key2} <br>
</body>
</html>
