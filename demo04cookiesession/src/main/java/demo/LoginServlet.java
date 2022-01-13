package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/demo/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置request编码
        req.setCharacterEncoding("utf-8");
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        //获取生成的验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //删除session中存储的验证码（验证码只能用一次）
        session.removeAttribute("checkCode_session");
        //判断验证码是否正确
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            if ("root".equals(username) && "123456".equals(password)) {
                //登陆成功
                session.setAttribute("user", username);
                resp.sendRedirect(req.getContextPath() + "/demo/success.jsp");
            } else {
                //登录失败
                req.setAttribute("login_error", "用户名或密码错误");
                req.getRequestDispatcher("/demo/login.jsp").forward(req, resp);
            }
        } else {
            //验证码错误
            req.setAttribute("cc_error", "验证码错误");
            req.getRequestDispatcher("/demo/login.jsp").forward(req, resp);
        }
    }
}
