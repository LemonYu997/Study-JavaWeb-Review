<%@ page import="pojo.Person" %>
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
    <%
        Person person = new Person();
        person.setName("张三");
        person.setPhones(new String[]{"13811111111", "13822222222", "13833333333"});

        List<String> cities = new ArrayList<String>();
        cities.add("北京");
        cities.add("上海");
        cities.add("深圳");
        person.setCities(cities);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        person.setMap(map);

        pageContext.setAttribute("p1", person);
    %>

    输出Person对象：${p1} <br>
    输出Person对象的name属性值：${p1.name} <br>
    输出Person对象的phones数组地址：${p1.phones} <br>
    输出Person对象的phones数组属性值：${p1.phones[0]} <br>
    输出Person对象的phones数组属性值：${p1.phones[1]} <br>
    输出Person对象的phones数组属性值：${p1.phones[2]} <br>
    输出Person对象的cities集合中的元素值：${p1.cities} <br>
    输出Person对象的cities集合中的指定元素值：${p1.cities[0]} <br>
    输出Person对现象的map集合：${p1.map} <br>
    输出Person对现象的map集合的key1对应的value：${p1.map.key1} <br>
    输出Person对象中age值（只有一个getAge方法）：${p1.age}
</body>
</html>
