package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionServlet")
public class SessionServlet extends BaseServlet {
    //创建和获取Session，使用同一个API
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //创建和获取session会话对象
        HttpSession session = req.getSession();
        //判断当前session对象是否是新创建的
        boolean isNew = session.isNew();
        //获取session会话的id
        String id = session.getId();

        resp.getWriter().write("得到的session的id是：" + id + "<br>");
        resp.getWriter().write("得到的session是否为新创建的" + isNew + "<br>");
    }

    //存储数据
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("已经向session中保存了数据");
    }

    //获取数据
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从session中获取key1的数据是" + attribute);
    }

    //默认超时时长
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取Session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认超时时长为" + maxInactiveInterval + "秒");
    }

    //自定义超时时长为3秒
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取session对象
        HttpSession session = req.getSession();
        //设置当前session在3秒后超时
        session.setMaxInactiveInterval(3);

        //获取Session的当前超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("当前Session将在" + maxInactiveInterval + "秒后超时");
    }

    //Session立即超时（销毁）
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取Session对象
        HttpSession session = req.getSession();
        //立即超时
        session.invalidate();
        resp.getWriter().write("Session已经设置为超时（无效）");
    }
}
