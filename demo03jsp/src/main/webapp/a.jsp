<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--1、声明类属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;
%>

<%--2、声明static静态代码块--%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
    }
%>

<%--3、声明类方法--%>
<%!
    public int add() {
       return 1+2;
    }
%>

<%--4、声明内部类--%>
<%!
    public static class A {
        private Integer id;
        private String name;
    }
%>

<%--1、输出整型--%>
<%=12%>
<%--2、输出浮点型--%>
<%=12.12%>
<%--3、输出字符串--%>
<%="输出字符串"%>
<%--4、输出对象--%>
<%=map%>
<%--5、直接使用_jspService()中的方法--%>
<%=request.getParameter("username")%>

<%--1、if语句--%>
<%
    int i = 12;
    if (i == 12) {
        System.out.println("you are right");
    } else {
        System.out.println("you error");
    }
%>
<%--2、for语句--%>
<%
    for (int j = 0; j < 10; j++) {
        System.out.println(j);
    }
%>
<%--3、翻译后的java文件中_jspService()方法内的代码--%>
<%
    String username = request.getParameter("username");
    System.out.println("username:" + username);
%>
<%--4、可以由多个代码脚本块完成一个脚本语句--%>
<%
    for (int j = 0; j < 10; j++) {
%>
<%
        System.out.println(j);
    }
%>
<%--5、代码脚本和表达式脚本一起组合使用，在jsp页面上输出数据--%>
<table border="1" cellspacing="0">
<%
    for (int j = 0; j < 10; j++) {
%>
<tr>
    <td>第<%=j%>行</td>
</tr>
<%
    }
%>
</table>
</body>
</html>
