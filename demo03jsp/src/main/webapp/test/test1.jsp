<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 650px;
        }
    </style>
</head>
<body>
    <%--练习1：在jsp页面中输出九九乘法表--%>
    <table align="center">
        <% for (int i = 0; i < 9; i++) { %>
        <tr>
            <%
                for (int j = 0; j <= i; j++) {
            %>
            <td>
                <%=i + "*" + j + "=" + (i * j)%>
            </td>
            <% } %>
        </tr>
        <% } %>
    </table>
</body>
</html>
