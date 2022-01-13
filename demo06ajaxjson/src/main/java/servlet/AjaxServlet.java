package servlet;

import com.google.gson.Gson;
import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajaxServlet")
public class AjaxServlet extends BaseServlet {
    protected void jsAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("发送ajax请求");

        Person person = new Person(1, "张三");
        //转换成Json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jqueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryAjax 方法调用");

        Person person = new Person(1, "张三");
        //转换成Json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jqueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryGet 方法调用");

        Person person = new Person(1, "张三");
        //转换成Json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jqueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryPost 方法调用");

        Person person = new Person(1, "张三");
        //转换成Json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jqueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryGetJson 方法调用");

        Person person = new Person(1, "张三");
        //转换成Json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jquerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jquerySerialize 方法调用");

        //前端发送ajax请求时，将表单序列化添加到参数里
        //这里直接获取即可
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));

        Person person = new Person(1, "张三");
        //转换成Json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }
}
