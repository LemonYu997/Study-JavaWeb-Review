<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    1111 <br>
    <%
        out.write("out输出1 <br/>");

        out.flush();                 //刷新输出，out1放在了前面

        out.write("out输出2 <br/>");  //这行会在末尾执行

        response.getWriter().write("response输出1 <br/>");
        response.getWriter().write("response输出2 <br/>");
    %>
</body>
</html>
