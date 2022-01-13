<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主题内容<br>
    <%--
        <%@ include file=""%> 就是静态包含
        file属性指定包含的jsp页面的路径
        地址中第一个斜杠表示 http://ip.port/工程路径/，映射代码的web目录
    --%>
<%--    <%@ include file="/include/footer.jsp" %>--%>

    <%--
        <jsp:include page=""></jsp:include> 这是动态包含
        page属性是指定要包含的jsp页面的路径
        动态包含也可以像静态包含一样，把被包含的内容执行输出到包含位置
    --%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="aaa"></jsp:param>
        <jsp:param name="password" value="bbb"></jsp:param>
    </jsp:include>

    <%--
        <jsp:forward page=""></jsp:forward> 请求转发
        page：设置请求转发的路径
    --%>
        <jsp:forward page="../scope2.jsp"></jsp:forward>
    </body>
</html>
