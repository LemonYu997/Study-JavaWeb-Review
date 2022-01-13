package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //写死
        if ("root".equals(username) && "123456".equals(password)) {
            //登录成功
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("登录成功");
        } else {
            //登陆失败，重新登录
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
