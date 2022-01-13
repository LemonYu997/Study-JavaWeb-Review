package response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/response1")
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过response1");
        //设置响应状态码302，表示重定向（已搬迁）
//        response.setStatus(302);
//        //设置响应头，说明新的地址在哪里
//        response.setHeader("Location", "http://localhost:8080/response2");

        //一次搞定
        response.sendRedirect("http://localhost:8080/response2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
