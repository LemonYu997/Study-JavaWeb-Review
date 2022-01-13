package servlet;

import utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

//案例：提醒上次访问时间
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应体数据格式和编码
        resp.setContentType("text/html; charset=utf-8");

        //获取所有Cookie
        Cookie[] cookies = req.getCookies();
        //查找有没有指定的cookie（lastTime）
        Cookie cookie = CookieUtils.findCookie("lastTime", cookies);
        if (cookie != null) {
            //有则输出上次访问时间
            //该cookie的value即上次访问的时间
            String value = cookie.getValue();
            System.out.println("解码前：" + value);
            //使用URL解码
            value = URLDecoder.decode(value, "utf-8");
            System.out.println("解码后：" + value);
            //前端页面输出提示信息
            resp.getWriter().write("<h1>您上次访问的时间为：" + value + "</h1>");
            //更新cookie
            CookieUtils.updateCookie(cookie);
            //设置存活时间1个月
            cookie.setMaxAge(60 * 60 * 24 * 30);

            resp.addCookie(cookie);
        } else {
            //不存在该cookie，新建一个cookie
            Cookie lastTime = new Cookie("lastTime", "wait");
            //更新cookie
            CookieUtils.updateCookie(lastTime);
            //设置存活时间1个月
            lastTime.setMaxAge(60 * 60 * 24 * 30);

            resp.addCookie(lastTime);
            resp.getWriter().write("<h1>欢迎您首次访问</h1>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
