package utils;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CookieUtils {
    /**
     * 查找指定名称的cookies
     * */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if(name == null || cookies == null || cookies.length == 0 ) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }

    //更新lastTime的cookie方法
    public static void updateCookie(Cookie cookie) throws UnsupportedEncodingException {
        //只更新lastTime的cookie，所以先判断
        if ("lastTime".equals(cookie.getName())) {
            //得到当前时间
            Date date = new Date();
            //设置格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String format = sdf.format(date);

            //字符串中的特殊字符需要使用URL编码
            System.out.println("编码前：" + format);
            format = URLEncoder.encode(format, "utf-8");
            System.out.println("编码后：" + format);

            //更新cookie
            cookie.setValue(format);
        } else {
            System.out.println("无法更新名字不是lastTime的cookie");
            System.out.println("请重新检查代码");
        }
    }
}
