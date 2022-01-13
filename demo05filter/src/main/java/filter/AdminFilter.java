package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("构造方法");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("初始化方法");

        //1、获取Filter的名称filter-name的内容
        System.out.println("filter-name的值是：" + filterConfig.getFilterName());
        //2、获取在web.xml中配置的init-param初始化参数
        System.out.println("username是：" + filterConfig.getInitParameter("username"));
        //3、获取ServletContent对象
        ServletContext servletContext = filterConfig.getServletContext();
        System.out.println(servletContext);
    }

    /**
     * doFilter用于拦截请求，可以做权限检查
     * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截方法");

        //将servletRequest强转为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取session
        HttpSession session = request.getSession();
        //获取登录用户
        Object user = session.getAttribute("user");
        //如果等于null，说明还没有登录，进行请求转发
        if (user == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        } else {
            //已经登录，请求放行
            //让程序继续往下访问用户的目标资源
            //【很重要】不能忘记！！
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
