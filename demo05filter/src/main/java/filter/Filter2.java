package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/target.jsp")
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2 前置代码");
        System.out.println("Filter2 线程:" + Thread.currentThread().getName());
        System.out.println("Filter2 请求参数：" + servletRequest.getParameter("username"));
        System.out.println(servletRequest.getAttribute("key1"));
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter2 线程:" + Thread.currentThread().getName());
        System.out.println("Filter2 后置代码");
    }

    @Override
    public void destroy() {
    }
}
