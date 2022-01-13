<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        request.getScheme()     获取请求协议
        request.getServerName() 获取服务器IP
        request.getServerPort() 获取服务器端口号
        request.getContextPath()获取工程路径
        request.getMethod()     获取请求方法
        request.getRemoteHost() 获取请求方法
        request.getSession().getId() 获取会话id
    --%>
    1、协议         <br>
    ${pageContext.request.scheme}   <br>
    2、服务器IP     <br>
    ${pageContext.request.serverName} <br>
    3、服务器端口    <br>
    ${pageContext.request.serverPort} <br>
    4、工程路径      <br>
    ${pageContext.request.contextPath} <br>
    5、请求方法      <br>
    ${pageContext.request.method} <br>
    6、客户端IP地址  <br>
    ${pageContext.request.remoteHost} <br>
    7、会话的ID编号  <br>
    ${pageContext.request.session.id} <br>
</body>
</html>
