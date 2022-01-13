<%@ page import="pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px red solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px red solid;
        }
    </style>
</head>
<body>
    <%
        List<Student> students = (List<Student>) request.getAttribute("stuList");
    %>
    <table align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>操作</th>
        </tr>
        <% for (Student student : students) { %>
            <tr>
                <td><%=student.getId()%></td>
                <td><%=student.getName()%></td>
                <td><%=student.getAge()%></td>
                <td>删除 修改</td>
            </tr>
        <% } %>
    </table>
</body>
</html>
