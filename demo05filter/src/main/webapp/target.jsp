<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("target.jsp页面执行了");
        System.out.println("target.jsp线程：" + Thread.currentThread().getName());
        System.out.println("target.jsp请求参数：" + request.getParameter("username"));
    %>
    <h1>这是目标资源</h1>
</body>
</html>
