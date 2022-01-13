<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key", "value");
    %>
    表达式脚本输出：<%=request.getAttribute("key")%> <br>
    EL表达式输出：${key} <br>
    表达式脚本输出（不存在时）：
    <%=request.getAttribute("key1") == null ? "" : request.getAttribute("key1") %>
    <br>
    EL表达式输出：${key1} <br> <br> <br>

    输出顺序: <br>
    <%
        //往四个域中都分别保存了数据
        pageContext.setAttribute("keya", "pageContext");
        request.setAttribute("keya", "request");
        session.setAttribute("keya", "session");
        application.setAttribute("keya", "application/servletContext");
    %>
    ${keya}

</body>
</html>
