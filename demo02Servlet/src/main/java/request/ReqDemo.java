package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/reqdemo")
public class ReqDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求行方法
        //获取请求方法 GET/POST
        System.out.println(req.getMethod());        //GET
        //获取工程目录 这里是空的
        System.out.println(req.getContextPath());   //空的
        //获取servlet的路径，这里是/reqdemo
        System.out.println(req.getServletPath());   // /reqdemo
        //获取get参数
        System.out.println(req.getQueryString());   // username=111&password=111&hobby=cpp
        //获取URI
        System.out.println(req.getRequestURI());    // /reqdemo
        //获取协议版本
        System.out.println(req.getProtocol());      // HTTP/1.1
        //获取客户机地址
        System.out.println(req.getRemoteAddr());    // 0:0:0:0:0:0:0:1

        //2、获取请求头数据
        //获取所有请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + ":" + value);
        }

        //3、获取请求体
        BufferedReader reader = req.getReader();
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
