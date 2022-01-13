package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取web.xml中配置的上下文参数context-param
//        ServletContext context = getServletConfig().getServletContext();
        ServletContext context = getServletContext();   //可以直接调用
        String username = context.getInitParameter("username");
        System.out.println(username);       //root
        System.out.println("context-param的password值是：" + context.getInitParameter("password"));

        //2、获取当前的工程路径，格式：/工程路径
        System.out.println("当前工程路径：" + context.getContextPath());   //没设置，所以为空

        //3、获取工程部署后在服务器硬盘上的绝对路径
        //斜杠/被服务器解析地址为: http://host:port/工程名/ 映射到IDEA代码的webapp目录
        System.out.println("获取的实际工程路径是：" + context.getRealPath("/"));
        //D:\Java\Projects\JavaWebRe\demo02Servlet\src\main\webapp\
        System.out.println("工程下css目录的绝对路径是：" + context.getRealPath("/css"));
        //D:\Java\Projects\JavaWebRe\demo02Servlet\src\main\webapp\css

        //4、像Map一样存取数据
        //在web工程部署启动的时候创建，在web工程停止的时候销毁，所以中间再次访问就有值了
        System.out.println("key1对应的值:" + context.getAttribute("key1")); //第一次访问为null，第二次为value1
        context.setAttribute("key1", "value1");
        System.out.println("key1对应的值:" + context.getAttribute("key1")); //value1

        //一个web工程，只有一个ServletContext对象实例
        //在本工程其他Servlet中输出的地址是一样的
        System.out.println(context);    //org.apache.catalina.core.ApplicationContextFacade@3a2927d2

        String filename = "a.jpg";
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
