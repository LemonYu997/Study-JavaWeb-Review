package servlet;

import utils.CookieUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@WebServlet("/cookieServlet")
public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、创建cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2、通知客户端保存cookie
        resp.addCookie(cookie);
        //创建多个cookie
        Cookie cookie2 = new Cookie("key2", "value2");
        resp.addCookie(cookie2);

        resp.getWriter().write("cookie创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cookie[] cookies = req.getCookies();

        //遍历cookie
        for (Cookie cookie : cookies) {
            //getName返回cookie的key
            //getValue返回cookie的value
            resp.getWriter().write("cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br>");
        }

        //查找指定Cookie
        Cookie iwantCookie = CookieUtils.findCookie("key1", cookies);
    }

    //修改Cookie的值
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //方案一：
        //1. 先创建一个要修改的同名的Cookie对象
        //2. 在构造器中赋予新的Cookie值
        Cookie cookie = new Cookie("key1", "newValue1");
        //3. 调用response.addCookie()，通知客户端保存修改
        resp.addCookie(cookie);
        resp.getWriter().write("key1的cookie已经修改好  <br>");

        //方案二：
        //1. 先查找要修改的Cookie对象
        Cookie cookie2 = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie2 != null) {
            //2. 调用setValue()方法赋予新的Cookie值
            cookie2.setValue("newValue2");
            //3. 调用response.addCookie()通知客户端保存修改
            resp.addCookie(cookie2);
            resp.getWriter().write("key2的cookie已经修改好 <br>");
        }
    }

    //cookie生命控制
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);   //设置存活时间
        resp.addCookie(cookie);
    }

    //立即删除
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //先找到要删除的cookie对象
        Cookie cookie = CookieUtils.findCookie("defaultLife", req.getCookies());
        if (cookie != null) {
            //调用setMaxAge方法赋值为0
            cookie.setMaxAge(0);
            //resp.addCookie
            resp.addCookie(cookie);

            resp.getWriter().write("defaultLife的Cookie已经被删除");
        }
    }

    //设置cookie存活时间
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cookie cookie = new Cookie("life3600", "life3600");
        //一小时后被删除
        cookie.setMaxAge(3600);   //设置存活时间
        resp.addCookie(cookie);
        resp.getWriter().write("已创建存活时间为一小时的cookie");
    }

    //解决中文乱码问题
    protected void chineseCookie(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cookie cookie = new Cookie(URLEncoder.encode("chinese中文", "utf-8"), URLEncoder.encode("中文", "utf-8"));
        resp.addCookie(cookie);

        resp.getWriter().write("设置中文cookie");
    }

    //路径问题
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cookie cookie = new Cookie("path1", "path1");
        //req.getContextPath()得到工程路径
        cookie.setPath(req.getContextPath() + "/abc"); //   /工程路径/abc
        resp.getWriter().write("创建了一个带有path路径的Cookie");
    }
}