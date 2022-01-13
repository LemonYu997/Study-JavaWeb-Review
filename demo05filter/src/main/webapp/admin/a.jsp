<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("a.jsp页面执行了");
        Object user = session.getAttribute("user");
        //如果等于null，说明还没有登录
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    %>
    <h1>这是一个jsp文件</h1>
</body>
</html>
