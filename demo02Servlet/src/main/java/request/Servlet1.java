package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        String username = request.getParameter("username");
        System.out.println("servlet1:" + username);

        //使用域数据传递数据
        //给参数添加一个标识，并传递到servlet2中查看
        request.setAttribute("key", "servlet1的标识");
        //问路（要转发的路径）
        /*
         * 请求转发必须要以 / 打头，斜杠标识地址为：http://ip:port/工程名/，
         * 映射到IDEA代码的web目录
         * */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        //请求转发可以转发到WEB-INF目录下的文件（但是不能直接访问WEB-INF目录下的文件）
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/HelloDemo.html");
        //请求转发不能访问web工程外的资源
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("http://www.baidu.com"); //报错


        //转发到servlet2，将请求和响应一并转发
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止中文乱码
        request.setCharacterEncoding("UTF-8");

        this.doGet(request, response);
    }
}
