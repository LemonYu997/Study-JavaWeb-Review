<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/uploadServlet" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username"> <br>
        头像：<input type="file" name="avatar"> <br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
