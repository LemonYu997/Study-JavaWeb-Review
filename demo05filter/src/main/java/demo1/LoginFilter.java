package demo1;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/demo/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取请求路径
        //这里是 uri 要的是资源路径
        String uri = request.getRequestURI();
        System.out.println(uri);

        //除了用户登录相关资源路径，其他全部拦截
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")
                || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/")
                || uri.contains("checkCodeServlet")) {
            filterChain.doFilter(request, response);
        } else {
            //验证用户是否登录
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //登录过，放行
                filterChain.doFilter(request, response);
            } else {
                //没有登录，跳转登录页面
                request.setAttribute("login_msg", "请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
