<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    关系运算： <br>
    ${12 == 12} 或 ${12 eq 12} <br>
    ${12 != 12} 或 ${12 ne 12} <br>
    ${12 < 12} 或 ${12 lt 12} <br>
    ${12 > 12} 或 ${12 gt 12} <br>
    ${12 <= 12} 或 ${12 le 12} <br>
    ${12 >= 12} 或 ${12 ge 12} <br>
    逻辑运算： <br>
    ${12 == 12 && 12 > 11} 或 ${12 == 12 and 12 > 11} <br>
    ${12 == 12 || 12 > 11} 或 ${12 == 12 or 12 > 11} <br>
    ${!(12 == 12)} 或 ${not(12 == 12)} <br>
    算术运算： <br>
    ${12 + 12} <br>
    ${12 - 12} <br>
    ${12 * 12} <br>
    ${18 / 12} 或 ${18 div 12} <br>
    ${18 % 12} 或 ${18 mod 12} <br>
    empty运算：判断数据是否为空，空输出true，不为空输出false <br>
    <%
        //1、值为null时
        request.setAttribute("emptyNull", null);
        //2、值为空字符串的时候，为空
        request.setAttribute("emptyStr", "");
        //3、值为Object类型数组，长度为0时，为空
        request.setAttribute("emptyArr", new Object[]{});
        //4、List集合，元素个数为0，为空
        List<String> list = new ArrayList<String>();
        request.setAttribute("emptyList", list);
        //5、Map集合，元素个数为0，为空
        Map<String, Object> map = new HashMap<String, Object>();
        request.setAttribute("emptyMap", map);
    %>
    ${empty emptyNull} <br>
    ${empty emptyStr} <br>
    ${empty emptyArr} <br>
    ${empty emptyList} <br>
    ${empty emptyMap} <br>
    三元运算： <br>
    ${12 == 12 ? "真的" : "假的"} <br>
    .点运算和[]中括号运算： <br>
    <%
        map.put("aaa", "aaaValue");
        map.put("b+b+b", "bbbValue");
        map.put("c.c.c", "cccValue");
        request.setAttribute("map", map);
    %>
    ${map.aaa} <br>
    ${map["b+b+b"]} <br>
    ${map['c.c.c']} <br>
</body>
</html>
