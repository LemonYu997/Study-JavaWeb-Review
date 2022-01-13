package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {

    //生命周期
    public HelloServlet() {
        System.out.println("1、执行构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2、初始化");
        //1、可以获取Servlet程序的别名，即servlet.name的值
        System.out.println("HelloServlet程序的别名是：" + servletConfig.getServletName());
        //2、获取初始化参数init.param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));
        //3、获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 用来处理请求和响应
     * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3、执行service方法");
        System.out.println("Hello Servlet");

        //类型转换（因为它有getMethod()方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求的方式   GET/POST...
        String method = httpServletRequest.getMethod();
        System.out.println(method);

        //请求分发
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    public void doGet() {
        System.out.println("执行get请求");
        System.out.println("执行get请求");
        System.out.println("执行get请求");
        System.out.println("执行get请求");
    }

    public void doPost() {
        System.out.println("执行post请求");
        System.out.println("执行post请求");
        System.out.println("执行post请求");
        System.out.println("执行post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4、销毁方法");
    }
}
