package servlet;

import pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        //发sql语句查询学生的信息
        //使用for循环生成查询到的数据做模拟
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            students.add(new Student(i, "name" + i, 18 + i));
        }
        //保存查询到的结果（学生信息）到request中
        req.setAttribute("stuList", students);
        //请求转发到showStudent.jsp页面
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
