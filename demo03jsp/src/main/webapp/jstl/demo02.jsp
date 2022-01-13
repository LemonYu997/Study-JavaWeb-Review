<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        遍历1到10，输出
        begin：开始的索引
        end：结束的索引
        var：循环的变量（当前正在遍历的数据）
    --%>
    1、遍历1到10 <br>
    <c:forEach begin="1" end="10" var="i">
        ${i}
    </c:forEach> <br>
    2、遍历Object数组 <br>
    <%
        request.setAttribute("arr", new String[]{"tom", "john"});
    %>
    <%-- for (Object item: arr)
        items:遍历的数据源（集合）
        var：当前遍历的数据
    --%>
    <c:forEach items="${requestScope.arr}" var="item">
        ${item} <br>
    </c:forEach>
    3、遍历Map <br>
    <%
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        request.setAttribute("map", map);
    %>
    <c:forEach items="${requestScope.map}" var="entry">
        ${entry} <br>
        key = ${entry.key} <br>
        value = ${entry.value} <br>
    </c:forEach>
    4、遍历List
    <%
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(1, "tom1", 15));
        list.add(new Student(2, "tom2", 16));
        list.add(new Student(3, "tom3", 17));
        request.setAttribute("list", list);
    %>
    <c:forEach items="${requestScope.list}" var="student">
        ${student} <br>
        ${student.id}+${student.name}+${student.age} <br>
    </c:forEach>

</body>
</html>
