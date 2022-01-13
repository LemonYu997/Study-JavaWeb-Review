package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        String username = request.getParameter("username");
        System.out.println("servlet2:" + username);

        //使用域数据获取数据
        //查看参数是否有servlet1的标识
        Object value = request.getAttribute("key");
        System.out.println("是否有servlet1的标识：" + value);

        //处理自己的业务
        System.out.println("servlet2的业务");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
