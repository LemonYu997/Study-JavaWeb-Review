<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080">
    <script>
        //点击验证码图片刷新验证码
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src="/demo/checkCodeServlet?time=" + new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <form action="/demo/loginServlet" method="post">
        用户名：<input type="text" name="username"> <br>
        密码：<input type="password" name="password"> <br>
        验证码：<input type="text" name="checkCode">
        <img id="img" src="/demo/checkCodeServlet"> <br>
        <input type="submit" value="登录">
    </form>

    <%--错误提示信息--%>
    <div>
        <%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%>
    </div>
    <div>
        <%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%>
    </div>
</body>
</html>
