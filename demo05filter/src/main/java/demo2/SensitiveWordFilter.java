package demo2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordFilter implements Filter {
    private List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
        try {
            ServletContext servletContext = filterConfig.getServletContext();
            //这个路径表示放在工程目录下（webapp下）
            String realPath = servletContext.getRealPath("/敏感词汇.txt");
            System.out.println(realPath);

            //读取文件，解决中文乱码
            InputStreamReader isr = new InputStreamReader(new FileInputStream(realPath), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            //将文件中的每一行数据添加到list中
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            isr.close();

            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行");
        //创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    //增强返回值 获取返回值
                    String value = (String) method.invoke(servletRequest, args);
                    if (value != null) {
                        for (String s : list) {
                            if (value.contains(s)) {
                                value = value.replaceAll(s, "***");
                            }
                        }
                    }
                    return value;
                }
                //如果不是getParameter方法，不变
                return method.invoke(servletRequest, args);
            }
        });

        //放行
        filterChain.doFilter(proxy_req, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
