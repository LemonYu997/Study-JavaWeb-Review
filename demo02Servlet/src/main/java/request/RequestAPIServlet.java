package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/request1")
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------doGet----------");
        //getRequestURI()：获取请求的资源路径
        System.out.println("URI:" + req.getRequestURI());   ///request1
        //getRequestURL()：获取请求的统一资源定位符（绝对路径）
        System.out.println("url:" + req.getRequestURL());   //http://localhost:8080/request1
        //getRemoteHost()：获取客户端的IP地址
        /*
         * 本机访问的话，localhost = 127.0.0.1
         * 使用本机真实IP(192.168.64.1)访问，那就得到真实IP
         * */
        System.out.println("客户端IP地址:" + req.getRemoteHost());   //0:0:0:0:0:0:0:1
        //getHeader()：获取请求头
        System.out.println("请求头User-Agent:" + req.getHeader("User-Agent"));
        //getMethod：获取请求的方式（GET/POST）
        System.out.println("请求的方式:" + req.getMethod());

        System.out.println("---------------------------");
        //getParameter()：获取请求的参数
        //括号内的参数为前端页面<input name="XXX" value="YYY">中的 XXX
        //获得的值为YYY或输入的内容
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hobby = req.getParameter("hobby");
        //getParameterValues：获取请求的参数（多个值的时候）
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("username:" + username); //12314
        System.out.println("password:" + password); //ffvgbsgs
        //如果是复选框（多个值），这种方式只能输出一个
        System.out.println("hobby:" + hobby);   //cpp 选了两个，只输出了一个
        System.out.println(Arrays.asList(hobbies)); //[cpp, Java]

        //setAttribute(key, value)：设置域数据
        //getAttribute(key)：获取域数据
        //getRequestDispatcher()：获取请求转发对象
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体字符集，解决POST中文乱码问题
        //要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");

        System.out.println("-----------doPost----------");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("username:" + username); //12314
        System.out.println("password:" + password); //ffvgbsgs
        System.out.println(Arrays.asList(hobbies)); //[cpp, Java]
    }
}
