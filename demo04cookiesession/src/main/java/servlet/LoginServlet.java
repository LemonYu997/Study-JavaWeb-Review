package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //判断用户名密码是否正确，这里定死
        if ("root".equals(username) && "123456".equals(password)) {
            //登录成功
            Cookie cookie = new Cookie("username", username);
            //cookie的保存时间为一周
            cookie.setMaxAge(60 * 60 * 24 * 7);
            resp.addCookie(cookie);
            System.out.println("登录成功");
        } else {
            //登陆失败
            System.out.println("登录失败");
        }
    }
}
