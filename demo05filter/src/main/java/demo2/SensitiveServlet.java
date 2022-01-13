package demo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sensitiveServlet")
public class SensitiveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        //获取用户输入内容
        String text = req.getParameter("text");
        //将用户输入内容返回到页面上
        //此时经过了过滤器，替换敏感词
        resp.getWriter().write("<h1>" + text + "</h1>");
    }
}
