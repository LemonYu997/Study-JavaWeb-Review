<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    1、请求参数：
    ${param} <br>
    输出请求参数username的值：
    ${param.username} <br>
    2、请求参数username数组中的值
    ${paramValues.hobby[0]} <br>
    3、请求头信息：
    ${header} <br>
    指定请求头【User-Agent】：
    ${header['User-Agent']} <br>
    4、请求头数组：
    ${headerValues['User-Agent'][0]} <br>
    5、cookie信息：<br>
    cookie名称：${cookie.JSESSIONID.name} <br>
    cookie值：${cookie.JSESSIONID.value} <br>
    6、WEB-INF中的context-param值：<br>
    ${initParam} <br>
    ${initParam.username} <br>
    ${initParam.url}
</body>
</html>
