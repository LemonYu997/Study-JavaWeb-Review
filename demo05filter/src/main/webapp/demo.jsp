<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>测试敏感词替换</h1>
    <form action="/sensitiveServlet" method="get">
        输入一段文字：<input type="text" name="text">
        <input type="submit" value="提交">
    </form>
</body>
</html>
