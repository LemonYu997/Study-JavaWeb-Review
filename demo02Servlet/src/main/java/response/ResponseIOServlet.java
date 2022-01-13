package response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/io")
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //输出字符集
        System.out.println(response.getCharacterEncoding());    //默认ISO-8859-1
        //方法1：设置字符集，解决中文乱码问题
//        response.setCharacterEncoding("UTF-8");

        //方法1：通过响应头，设置浏览器也使用UTF-8字符集
//        response.setHeader("Content-Type", "text/html;charset=utf-8");
        //方法2：直接调用相关方法设置浏览器字符集
        //此方法一定要在获取流对象前调用才有效
        response.setContentType("text/html;charset=utf-8"); //同时设置服务器和客户端都使用UTF-8

        PrintWriter writer = response.getWriter();
//        writer.write("response's content!");

        //虽然服务器设置成功，但是浏览器没有设置好字符集
        writer.write("中文乱码");   //涓枃涔辩爜
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
