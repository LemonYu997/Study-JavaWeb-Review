package demo2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();

        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sale")) {
                    //1、增强参数
                    double money = (double) args[0];
                    money = money * 0.85;
                    System.out.println("专车接送");
                    Object obj = method.invoke(lenovo, money);
                    System.out.println("免费送货");
                    return obj + " + 鼠标垫";
                } else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });

        String computer1 = lenovo.sale(8000);
        System.out.println(computer1);
        lenovo.show();

        String computer2 = proxy_lenovo.sale(8000);
        System.out.println(computer2);
        proxy_lenovo.show();
    }
}
