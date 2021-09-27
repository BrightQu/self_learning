package cn.self.oop.advanced.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy2 {

    public static <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class<?>[]{clazz}, //如果传入的是user.getClass()，则用clazz.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Before ...");
//                        Object object = method.invoke(obj, args);
                        System.out.println("After ...");
                        return null;
                    }
                });
    }

    public static void main(String[] args) {
        IUser user = new UserImpl(22, "Jasmine");
        IUser userProxy = getProxy(IUser.class);
        String result = userProxy.printUser();
        System.out.println("result: " + result);

        System.out.print("user.getClass().getInterfaces(): ");
        Class<?>[] interfaces = user.getClass().getInterfaces();
        for (Class<?> inter : interfaces) {
            System.out.println(inter);
        }
        System.out.println("IUser.class: "  + IUser.class);
    }
}
