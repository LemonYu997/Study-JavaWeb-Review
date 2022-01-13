package i18n;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {

    @Test
    public void testLocale() {
        //获取系统默认地区、语言、国家
        Locale locale = Locale.getDefault();
        System.out.println(locale); //zh_CN

        //查看所有可用地区
//        Locale[] availableLocales = Locale.getAvailableLocales();
//        for (Locale availableLocale : availableLocales) {
//            System.out.println(availableLocale);
//        }

        //获取中国，中文的常量Local对象
        System.out.println(Locale.CHINA);   //zh_CN
        //获取英文，美国的
        System.out.println(Locale.US);      //en_US
    }

    @Test
    public void testI18n() throws Exception {
        //得到需要的Locale对象
        Locale locale = Locale.CHINA;

        //通过指定的baseName和Locale对象读取相应的配置文件
        //配置文件要放在maven项目的resources目录下
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);

        //解决中文乱码问题
        String username = new String(bundle.getString("username").getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(bundle.getString("password").getBytes("ISO-8859-1"), "UTF-8");
        String sex = new String(bundle.getString("sex").getBytes("ISO-8859-1"), "UTF-8");
        String age = new String(bundle.getString("age").getBytes("ISO-8859-1"), "UTF-8");

        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("sex:" + sex);
        System.out.println("age:" + age);
    }
}
