package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import pojo.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

    //JavaBean和Json的转换
    @Test
    public void test1() {
        //创建JavaBean对象
        Person person = new Person(1, "张三");
        //创建gson对象
        Gson gson = new Gson();
        //使用Gson的方法将JavaBean对象转换成Json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);   //{"id":1,"name":"张三"}

        //使用Gson的fromJson()方法将Json字符串转换成JavaBean
        //参数一：Json字符串
        //参数二：转换回去的Java对象类型
        Person person1 = gson.fromJson(personJsonString, person.getClass());
        System.out.println(person1);    //Person{id=1, name='张三'}
    }

    //List集合和Json的转换
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(1, "张三"));
        personList.add(new Person(2, "李四"));

        Gson gson = new Gson();
        //将List集合转为Json字符串
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);
        //[{"id":1,"name":"张三"},{"id":2,"name":"李四"}]

        //将Json字符串转为指定的List集合
//        List<Person> list = gson.fromJson(personListJsonString, new PersonListType().getType());
        List<Person> list = gson.fromJson(personListJsonString, new TypeToken<ArrayList<Person>>(){}.getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);
    }

    //Map集合和Json的转换
    @Test
    public void test3() {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "张三"));
        personMap.put(2, new Person(2, "李四"));

        Gson gson = new Gson();
        //将Map转为Json字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);
        //{"1":{"id":1,"name":"张三"},"2":{"id":2,"name":"李四"}}

        //将Json字符串转回Map集合
//        Map<Integer, Person> map = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        Map<Integer, Person> map = gson.fromJson(personMapJsonString, new TypeToken<Map<Integer, Person>>(){}.getType());
        System.out.println(map);    //{1=Person{id=1, name='张三'}, 2=Person{id=2, name='李四'}}
        Person person = map.get(1);
        System.out.println(person); //Person{id=1, name='张三'}
    }
}
