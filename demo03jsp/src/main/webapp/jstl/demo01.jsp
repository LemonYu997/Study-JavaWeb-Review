<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    保存之前：${requestScope.name} <br>

    <%--
        之前的保存方式：域对象.setAttribute(key, value)
        scope：设置保存到哪个域 page,request,session,application
        var：设置key
        value：设置value
    --%>
    <c:set scope="request" var="name" value="Tom" />

    保存之后：${requestScope.name} <br>

    <c:if test="${12 != 12}">
        <h1>12等于12</h1>
    </c:if>

    <c:set scope="request" var="height" value="178" />
    <c:choose>
        <c:when test="${requestScope.height > 190}">小巨人</c:when>
        <c:when test="${requestScope.height > 180}">很高</c:when>
        <c:when test="${requestScope.height > 170}">还可以</c:when>
        <c:otherwise>170</c:otherwise>
    </c:choose>
</body>
</html>
